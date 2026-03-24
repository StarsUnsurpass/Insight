package com.example.insight.data.model

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.textbooks.*

data class Textbook(
    val id: String,
    val grade: String,
    val term: String, 
    val coverColor: Color,
    val units: List<TextbookUnit>
)

data class TextbookUnit(
    val id: String,
    val title: String,
    val topic: String,
    val details: List<UnitDetailSection> = emptyList()
)

data class UnitDetailSection(
    val category: String,
    val content: String 
)

object TextbookProvider {
    val textbooks = listOf(
        Grade7Up.data,
        Grade7Down.data,
        Grade8Up.data,
        Grade8Down.data,
        Grade9Full.data
    )
}
