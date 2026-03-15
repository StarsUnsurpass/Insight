package com.example.insight.util

import android.content.Context
import android.net.Uri
import com.example.insight.data.local.entities.StudentEntity
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.InputStream

object ExcelImporter {

    fun importStudentsFromExcel(context: Context, uri: Uri): List<StudentEntity> {
        val students = mutableListOf<StudentEntity>()
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        
        inputStream?.use { stream ->
            val workbook = WorkbookFactory.create(stream)
            val sheet = workbook.getSheetAt(0)
            
            // Skip header row
            for (i in 1..sheet.lastRowNum) {
                val row = sheet.getRow(i) ?: continue
                
                try {
                    val name = row.getCell(0)?.stringCellValue ?: continue
                    val genderStr = row.getCell(1)?.stringCellValue ?: ""
                    val gender = when (genderStr) {
                        "男" -> 1
                        "女" -> 2
                        else -> 0
                    }
                    val age = row.getCell(2)?.numericCellValue?.toInt() ?: 0
                    val className = row.getCell(3)?.stringCellValue ?: ""
                    val score = row.getCell(4)?.numericCellValue?.toFloat() ?: 0f
                    
                    students.add(
                        StudentEntity(
                            name = name,
                            gender = gender,
                            age = age,
                            className = className,
                            latestScore = score
                        )
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                    // Skip invalid rows
                }
            }
        }
        
        return students
    }
}
