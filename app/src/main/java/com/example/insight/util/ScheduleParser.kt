package com.example.insight.util

import android.graphics.Rect
import com.example.insight.data.local.dao.CourseWithTimeSlot
import com.example.insight.data.local.entities.CourseEntity
import com.example.insight.data.local.entities.TimeSlotEntity
import com.google.mlkit.vision.text.Text
import kotlin.math.abs

data class RecognizedCourse(
    val name: String,
    val dayOfWeek: Int,
    val startPeriod: Int,
    val endPeriod: Int
)

class ScheduleParser {

    /**
     * 将 ML Kit 识别出的文本块聚类成课表网格
     */
    fun parse(text: Text, imageWidth: Int, imageHeight: Int): List<RecognizedCourse> {
        val blocks = text.textBlocks.filter { it.text.length > 1 }
        if (blocks.isEmpty()) return emptyList()

        // 1. 估算行和列的边界
        // 课表通常是 7列 (周一-周日) 或 5列，以及 10-12行
        val columnWidth = imageWidth / 7f
        val rowHeight = imageHeight / 12f

        val result = mutableListOf<RecognizedCourse>()

        blocks.forEach { block ->
            val rect = block.boundingBox ?: return@forEach
            val centerX = rect.centerX()
            val centerY = rect.centerY()

            // 计算该文本块属于第几天 (1-7)
            val day = (centerX / columnWidth).toInt() + 1
            
            // 计算该文本块属于第几节课 (1-12)
            val period = (centerY / rowHeight).toInt() + 1

            if (day in 1..7 && period in 1..12) {
                // 简单的聚类逻辑：如果该格子已经有课，尝试追加名称或处理跨行
                val existing = result.find { it.dayOfWeek == day && abs(it.startPeriod - period) <= 1 }
                if (existing != null) {
                    // 可能是同一门课的地点或教师信息，这里暂且合并名称
                    // 在实际应用中，可以通过正则判断是否是地点
                } else {
                    result.add(RecognizedCourse(
                        name = block.text,
                        dayOfWeek = day,
                        startPeriod = period,
                        endPeriod = period
                    ))
                }
            }
        }

        return result
    }

    /**
     * 更高级的网格聚类算法 (Grid Clustering)
     * 利用 DBSCAN 或简单的均值漂移思路，找到 X 和 Y 的对齐线
     */
    fun advancedParse(text: Text): List<RecognizedCourse> {
        val blocks = text.textBlocks.map { 
            it.boundingBox!! to it.text 
        }.sortedBy { it.first.top }

        if (blocks.isEmpty()) return emptyList()

        // 聚类 Y 坐标 (行)
        val rowThreshold = 20 // 像素容差
        val rows = mutableListOf<MutableList<Pair<Rect, String>>>()
        blocks.forEach { block ->
            val targetRow = rows.find { abs(it.first().first.centerY() - block.first.centerY()) < rowThreshold }
            if (targetRow != null) {
                targetRow.add(block)
            } else {
                rows.add(mutableListOf(block))
            }
        }

        // 聚类 X 坐标 (列)
        // 假设课表是有规律的，我们可以通过统计直方图找到 7 个高峰
        // 这里简化处理，直接根据屏幕比例映射
        
        // 返回识别出的课程
        return rows.flatMapIndexed { rowIndex, row ->
            row.map { (rect, text) ->
                RecognizedCourse(
                    name = text,
                    dayOfWeek = estimateDay(rect.centerX()), 
                    startPeriod = rowIndex + 1,
                    endPeriod = rowIndex + 1
                )
            }
        }
    }

    private fun estimateDay(centerX: Int): Int {
        // 实际上需要根据整体布局的 minX 和 maxX 来动态计算
        return (centerX / 150) + 1 // 占位逻辑
    }
}
