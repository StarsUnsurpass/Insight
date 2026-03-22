package com.example.insight.ui.schedule

import android.graphics.Rect
import com.google.mlkit.vision.text.Text
import kotlin.math.abs

data class ParsedGridItem(
    val text: String,
    val dayOfWeek: Int, // 1-7
    val startPeriod: Int,
    val endPeriod: Int,
    val bounds: Rect
)

object ScheduleImportEngine {

    fun parseGrid(blocks: List<Text.TextBlock>, imageWidth: Int, imageHeight: Int): List<ParsedGridItem> {
        if (blocks.isEmpty()) return emptyList()

        // 1. Differentiate "Labels" vs "Content"
        // Usually, days are at the top (lowest Y), and periods are at the left (lowest X).
        
        // Let's find 7 logical columns for days by clustering block.boundingBox.centerX
        val columns = find1DClusters(blocks.map { it.boundingBox?.centerX() ?: 0 }.filter { it > 0 }, imageWidth / 14)
        
        // Sometimes the leftmost column is the "Period" or "Time" column. We need exactly 7 columns for days.
        // If there are 8 columns, the 1st is probably the time labels.
        val dayColumns = if (columns.size >= 8) columns.takeLast(7) else columns.takeLast(7)
        if (dayColumns.isEmpty()) return emptyList()

        // 2. Find rows by clustering centerY. We skip the top row (headers).
        val rows = find1DClusters(blocks.map { it.boundingBox?.centerY() ?: 0 }.filter { it > 0 }, imageHeight / 25)
        
        // Find the "header" row (Y is minimum)
        val headerRowY = rows.minOrNull() ?: 0
        val contentRows = rows.filter { it > headerRowY + (imageHeight / 30) }.sorted()
        
        val parsedItems = mutableListOf<ParsedGridItem>()

        // 3. Map each text block to (Column, Row Span)
        for (block in blocks) {
            val bounds = block.boundingBox ?: continue
            val text = block.text.replace("\n", "").trim()
            
            // Ignore headers like "星期一", "周一"
            if (isHeaderOrNoise(text)) continue

            val centerX = bounds.centerX()
            val top = bounds.top
            val bottom = bounds.bottom

            // Find closest day column by X
            val dayIndex = dayColumns.indexOfMinBy { abs(it - centerX) }
            val dayOfWeek = dayIndex + 1

            // Find start period and end period by Y
            // A course card spanning multiple periods will cover multiple row centers
            val coveredRows = contentRows.mapIndexedNotNull { index, rowY -> 
                if (rowY >= top && rowY <= bottom) index + 1 else null
            }
            
            val startPeriod = coveredRows.minOrNull() ?: mapToClosestPeriod(top, contentRows)
            val endPeriod = coveredRows.maxOrNull() ?: mapToClosestPeriod(bottom, contentRows)

            if (startPeriod in 1..20 && endPeriod in 1..20) {
                // Ignore pure numbers in the first column which are likely period indices
                if (text.toIntOrNull() != null && bounds.left < dayColumns.first() - (imageWidth/10)) {
                    continue
                }
                
                parsedItems.add(
                    ParsedGridItem(
                        text = text,
                        dayOfWeek = dayOfWeek.coerceIn(1, 7),
                        startPeriod = startPeriod,
                        endPeriod = maxOf(startPeriod, endPeriod),
                        bounds = bounds
                    )
                )
            }
        }
        
        return parsedItems
    }

    private fun find1DClusters(values: List<Int>, threshold: Int): List<Int> {
        if (values.isEmpty()) return emptyList()
        val sorted = values.sorted()
        val clusters = mutableListOf<List<Int>>()
        var current = mutableListOf(sorted[0])
        
        for (i in 1 until sorted.size) {
            if (sorted[i] - current.last() < threshold) {
                current.add(sorted[i])
            } else {
                clusters.add(current)
                current = mutableListOf(sorted[i])
            }
        }
        clusters.add(current)
        
        return clusters.map { it.average().toInt() }
    }

    private fun isHeaderOrNoise(text: String): Boolean {
        val lower = text.lowercase()
        return lower.contains("星期") || lower.contains("周一") || lower.contains("周二") ||
               lower.contains("周三") || lower.contains("周四") || lower.contains("周五") ||
               lower.contains("周六") || lower.contains("周日") || lower.contains("节次") || 
               text.length < 2 && text.toIntOrNull() == null
    }

    private fun mapToClosestPeriod(y: Int, rowCenters: List<Int>): Int {
        if (rowCenters.isEmpty()) return 1
        val closestIndex = rowCenters.indexOfMinBy { abs(it - y) }
        return closestIndex + 1
    }

    private fun <T> List<T>.indexOfMinBy(selector: (T) -> Int): Int {
        var minIndex = -1
        var minValue = Int.MAX_VALUE
        for (i in indices) {
            val value = selector(this[i])
            if (value < minValue) {
                minValue = value
                minIndex = i
            }
        }
        return minIndex
    }
}
