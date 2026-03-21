import os

# Using direct string concatenation and escaping to avoid any issues with triple quotes or special characters
kotlin_content = r"""package com.example.insight.data.model

data class ExampleProblem(
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String
)

data class PastExamQuestion(
    val year: String,
    val location: String,
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String,
    val errorProne: String? = null,
    val translation: String? = null
)

data class HighlightedSentence(
    val text: String,
    val analysis: String
)

data class TextbookParagraph(
    val content: String,
    val highlightedSentences: List<HighlightedSentence>,
    val source: String
)

data class ExampleSentence(
    val english: String,
    val chinese: String,
    val analysis: String? = null,
    val difficulty: String = "中考难度"
)

data class RelatedPoint(
    val title: String,
    val description: String,
    val connectionReason: String
)

data class TeachingNote(
    val title: String,
    val content: String
)

data class KnowledgePoint(
    val id: String,
    val section: String,
    val title: String,
    val description: String,
    val syllabusDetails: List<String>,
    val relatedPoints: List<RelatedPoint>,
    val exampleProblems: List<ExampleProblem>,
    val pastExamQuestions: List<PastExamQuestion>,
    val textbookParagraphs: List<TextbookParagraph>,
    val exampleSentences: List<ExampleSentence>,
    val teachingNotes: List<TeachingNote> = emptyList(),
    val famousQuote: String,
    val quoteAuthor: String
)

object KnowledgeProvider {
    val allPoints = listOf(
        KnowledgePoint(
            id = "nouns",
            section = "板块一：词法体系 (Morphology)",
            title = "名词 (Nouns)",
            description = "【核心概念】\n名词 (Nouns) 是初中英语语法体系的核心枢纽。掌握名词，即掌握了英语句子结构的一半。\n\n【考纲要求】\n1. 名词的分类与判定：准确区分可数与不可数名词。\n2. 名词的数：规则与不规则复数变化。\n3. 名词所有格：'s 与 of 结构。\n\n【重难点剖析】\n主谓一致与集体名词的判定是常见考点。",
            syllabusDetails = listOf("可数/不可数区分", "复数变化规则", "所有格用法"),
            relatedPoints = listOf(RelatedPoint("冠词", "名词前的限定词。", "数决定了 a/an 的使用。")),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "北京", "There is some information on the board.", listOf("A. message", "B. information"), "B", "information不可数。", translation = "布告栏上有些信息。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("In our school, there are many different clubs.", listOf(HighlightedSentence("clubs", "可数名词复数。")), "人教版八上 Unit 2")
            ),
            exampleSentences = listOf(ExampleSentence("Could you give me some advice?", "能给我建议吗？", analysis = "advice不可数。")),
            teachingNotes = listOf(TeachingNote("易错点", "把 advice 当可数。")),
            famousQuote = "A good name is better than riches.",
            quoteAuthor = "Cervantes"
        ),
        KnowledgePoint(
            id = "present_perfect",
            section = "板块二：时态语态 (Tenses & Voices)",
            title = "现在完成时 (Present Perfect)",
            description = "【核心概念】\n现在完成时连接过去与现在，强调过去动作对现在的影响或持续。\n\n【考纲要求】\n1. 结构：have/has + done。\n2. 用法：已经完成（影响）或持续到现在。\n3. 延续性动词转换：for/since 搭配必考。",
            syllabusDetails = listOf("基本结构构成", "already/yet 用法", "for/since 搭配"),
            relatedPoints = listOf(RelatedPoint("一般过去时", "时态辨析。", "一个强调点，一个强调影响。")),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "苏州", "Someone has cleaned the room.", listOf("A. cleans", "B. has cleaned"), "B", "强调影响结果。", translation = "有人打扫过房间了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Have you read Treasure Island yet?", listOf(HighlightedSentence("yet", "用于疑问句。")), "人教版八下 Unit 8")
            ),
            exampleSentences = listOf(ExampleSentence("We have lived here since 2010.", "我们住这十年了。", analysis = "延续性用法。")),
            teachingNotes = listOf(TeachingNote("易错点", "瞬间动词不能接 for/since。")),
            famousQuote = "What is past is prologue.",
            quoteAuthor = "Shakespeare"
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints.find { it.id == "nouns" }
    }
}
"""

with open("app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt", "w", encoding="utf-8") as f:
    f.write(kotlin_content)
