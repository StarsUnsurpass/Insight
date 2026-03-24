package com.example.insight.data.model

import androidx.compose.ui.graphics.Color

data class Textbook(
    val id: String,
    val grade: String,
    val term: String, // "上册", "下册", "全一册"
    val coverColor: Color,
    val units: List<TextbookUnit>
)

data class TextbookUnit(
    val id: String,
    val title: String,
    val topic: String,
    val isFilled: Boolean = false, // Marker to indicate if this unit has real content yet
    val coreGrammar: String = "核心内容尚未收录",
    val sections: List<UnitSection> = emptyList()
)

sealed class UnitSection {
    data class SectionA(
        val title: String = "Section A (基础输入)",
        val vocabulary: List<String>,
        val sentencePatterns: List<String>
    ) : UnitSection()
    
    data class GrammarFocus(
        val title: String = "Grammar Focus (语法聚焦)",
        val grammarNodeIds: List<String> // Maps to KnowledgePoint IDs
    ) : UnitSection()
    
    data class SectionB(
        val title: String = "Section B (能力输出)",
        val readingSkills: List<String>,
        val writingSkills: List<String>
    ) : UnitSection()
}

object TextbookProvider {
    val textbooks = listOf(
        Textbook(
            id = "g7_up",
            grade = "七年级",
            term = "上册",
            coverColor = Color(0xFFFCE4EC), // Light Pink
            units = generatePlaceholderUnits("g7u", 9)
        ),
        Textbook(
            id = "g7_down",
            grade = "七年级",
            term = "下册",
            coverColor = Color(0xFFE8F5E9), // Light Green
            units = generatePlaceholderUnits("g7d", 12)
        ),
        Textbook(
            id = "g8_up",
            grade = "八年级",
            term = "上册",
            coverColor = Color(0xFFFFF3E0), // Light Orange
            units = generatePlaceholderUnits("g8u", 10)
        ),
        Textbook(
            id = "g8_down",
            grade = "八年级",
            term = "下册",
            coverColor = Color(0xFFFFE0B2), // Orange
            units = listOf(
                TextbookUnit(
                    id = "g8d_u8",
                    title = "Unit 8",
                    topic = "Have you read Treasure Island yet? (文学与音乐)",
                    isFilled = true,
                    coreGrammar = "现在完成时 (Present Perfect Tense)",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("already vs yet", "treasure", "island", "classic"),
                            sentencePatterns = listOf("Have you read...?", "Yes, I have already read it.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("grammar_present_perfect") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("长难句拆解：定语从句在阅读中的应用"),
                            writingSkills = listOf("写读后感：现在完成时与一般过去时的连用")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g8d_u9",
                    title = "Unit 9",
                    topic = "Have you ever been to a museum? (经历与地点)",
                    isFilled = true,
                    coreGrammar = "现在完成时 (been to vs gone to)",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("amusement", "somewhere", "camera", "invention"),
                            sentencePatterns = listOf("Have you ever been to...?", "No, I've never been there.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("grammar_present_perfect") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("事实与观点的区分"),
                            writingSkills = listOf("介绍一个你去过的地方")
                        )
                    )
                )
            ) + generatePlaceholderUnits("g8d", 8, startIndex = 10) // 补齐剩余的8个单元
        ),
        Textbook(
            id = "g9_full",
            grade = "九年级",
            term = "全一册",
            coverColor = Color(0xFFE3F2FD), // Light Blue
            units = listOf(
                TextbookUnit(
                    id = "g9_u1",
                    title = "Unit 1",
                    topic = "How can we become good learners? (学习方法)",
                    isFilled = true,
                    coreGrammar = "by + doing (方式状语)",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("textbook", "conversation", "aloud", "pronunciation"),
                            sentencePatterns = listOf("How do you learn...?", "I learn by working with a group.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("prep_by") // Mapped to preposition 'by'
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("寻找段落主题句 (Topic Sentences)"),
                            writingSkills = listOf("给朋友写一封关于学习建议的信")
                        )
                    )
                )
            ) + generatePlaceholderUnits("g9f", 13, startIndex = 2) // 补齐剩余单元
        )
    )

    private fun generatePlaceholderUnits(prefix: String, count: Int, startIndex: Int = 1): List<TextbookUnit> {
        return (startIndex until startIndex + count).map {
            TextbookUnit(
                id = "${prefix}_u$it",
                title = "Unit $it",
                topic = "教学大纲内容准备中...",
                isFilled = false
            )
        }
    }
}