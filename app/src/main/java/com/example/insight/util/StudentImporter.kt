package com.example.insight.util

import android.content.Context
import android.net.Uri
import com.example.insight.data.local.entities.StudentEntity
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipInputStream

object StudentImporter {

    fun importStudents(context: Context, uri: Uri): List<StudentEntity> {
        val contentResolver = context.contentResolver
        val mimeType = contentResolver.getType(uri) ?: ""
        
        return try {
            when {
                mimeType.contains("spreadsheet") || mimeType.contains("excel") -> importFromExcel(context, uri)
                mimeType.contains("wordprocessingml") || mimeType.contains("msword") -> importFromWord(context, uri)
                mimeType.contains("zip") -> importFromZip(context, uri)
                else -> importFromExcel(context, uri) // Fallback
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    private fun importFromExcel(context: Context, uri: Uri): List<StudentEntity> {
        val students = mutableListOf<StudentEntity>()
        context.contentResolver.openInputStream(uri)?.use { stream ->
            val workbook = WorkbookFactory.create(stream)
            val sheet = workbook.getSheetAt(0)
            for (i in 1..sheet.lastRowNum) {
                val row = sheet.getRow(i) ?: continue
                try {
                    val name = row.getCell(0)?.stringCellValue ?: continue
                    val gender = when (row.getCell(1)?.stringCellValue) { "男" -> 1; "女" -> 2; else -> 0 }
                    val age = row.getCell(2)?.numericCellValue?.toInt() ?: 0
                    val className = row.getCell(3)?.stringCellValue ?: ""
                    val score = row.getCell(4)?.numericCellValue?.toFloat() ?: 0f
                    students.add(StudentEntity(name = name, gender = gender, age = age, className = className, latestScore = score))
                } catch (e: Exception) { }
            }
        }
        return students
    }

    private fun importFromWord(context: Context, uri: Uri): List<StudentEntity> {
        val students = mutableListOf<StudentEntity>()
        context.contentResolver.openInputStream(uri)?.use { stream ->
            val doc = XWPFDocument(stream)
            for (table in doc.tables) {
                for (i in 1 until table.rows.size) {
                    val row = table.rows[i]
                    try {
                        val name = row.getCell(0).text.trim()
                        if (name.isEmpty()) continue
                        val gender = when (row.getCell(1).text.trim()) { "男" -> 1; "女" -> 2; else -> 0 }
                        val age = row.getCell(2).text.trim().toIntOrNull() ?: 0
                        val className = row.getCell(3).text.trim()
                        val score = row.getCell(4).text.trim().toFloatOrNull() ?: 0f
                        students.add(StudentEntity(name = name, gender = gender, age = age, className = className, latestScore = score))
                    } catch (e: Exception) { }
                }
            }
        }
        return students
    }

    private fun importFromZip(context: Context, uri: Uri): List<StudentEntity> {
        val allStudents = mutableListOf<StudentEntity>()
        context.contentResolver.openInputStream(uri)?.use { stream ->
            val zipStream = ZipInputStream(stream)
            var entry = zipStream.nextEntry
            while (entry != null) {
                if (!entry.isDirectory) {
                    val fileName = entry.name.lowercase()
                    if (fileName.endsWith(".xlsx") || fileName.endsWith(".docx")) {
                        // Create temp file because POI needs seekable/re-readable stream sometimes
                        val tempFile = File.createTempFile("import_", "_" + entry.name, context.cacheDir)
                        FileOutputStream(tempFile).use { fos ->
                            zipStream.copyTo(fos)
                        }
                        val tempUri = Uri.fromFile(tempFile)
                        val imported = if (fileName.endsWith(".xlsx")) {
                            importFromExcel(context, tempUri)
                        } else {
                            importFromWord(context, tempUri)
                        }
                        allStudents.addAll(imported)
                        tempFile.delete()
                    }
                }
                zipStream.closeEntry()
                entry = zipStream.nextEntry
            }
        }
        return allStudents
    }
}
