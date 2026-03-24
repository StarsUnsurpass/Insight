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
    val details: List<UnitDetailSection> = emptyList()
)

data class UnitDetailSection(
    val category: String, // 分类名称
    val content: String // Markdown 详尽内容
)

object TextbookProvider {
    val textbooks = listOf(
        Textbook(
            id = "g7_up",
            grade = "七年级",
            term = "上册",
            coverColor = Color(0xFFFCE4EC),
            units = listOf(
                TextbookUnit(
                    "g7up_u1", "Unit 1", "You and Me",
                    listOf(
                        UnitDetailSection("单元导读", """
                            ### 1. 单元主题层级
                            *   **主题范畴**：人与自我
                            *   **子主题**：个人情况；人际交往
                            
                            ### 2. 单元主题内容
                            本单元通过询问姓名、年龄、籍贯等基本信息，引导学生学会在新环境下结识新朋友，建立和谐的同学关系。
                            
                            ### 3. 单元新知预览
                            *   **单词短语**：friend, each other, be from, full name...
                            *   **核心句式**：What's your name? / Where are you from?
                            *   **重点语法**：be动词(am, is, are)的一般现在时用法。
                            *   **主题写作**：Introduce yourself and your new friends.
                        """.trimIndent()),
                        UnitDetailSection("知识详解", """
                            #### 重点词汇精讲
                            1.  **friend** (n.) 朋友
                                *   **派生词**：friendly (adj.) 友好的；friendship (n.) 友谊。
                                *   **固定搭配**：make friends with sb. 与某人交朋友。
                            2.  **nice** (adj.) 令人愉快的
                                *   **近义词**：pleasant, glad.
                                *   **用法**：It's nice to do sth. 做某事很愉快。
                        """.trimIndent()),
                        UnitDetailSection("翻译与语篇分析", """
                            #### Section A 2a 译文
                            ——你叫什么名字？
                            ——我的名字叫艾伦。很高兴见到你！
                            
                            #### 语篇逻辑拆解
                            本文是一篇典型的自我介绍。第一部分介绍基本姓名；第二部分介绍兴趣爱好；第三部分表达交友意愿。
                        """.trimIndent()),
                        UnitDetailSection("长难句分析", """
                            > *Original:* "I have a new friend from the US and her name is Sally."
                            
                            *   **成分拆解**：
                                *   `I` (主语) + `have` (谓语) + `a new friend` (宾语)
                                *   `from the US` (介词短语作定语，修饰friend)
                                *   `and` (并列连词)
                                *   `her name` (从句主语) + `is` (系动词) + `Sally` (表语)
                            *   **解析**：这是一个由 and 连接的并列句，描述了朋友的国籍和姓名。
                        """.trimIndent()),
                        UnitDetailSection("语法精讲", """
                            #### be 动词 (am, is, are) 的精密用法
                            | 语法项 | 用法说明 | 例句 |
                            | :--- | :--- | :--- |
                            | **am** | 仅用于第一人称 I | I am a teacher. |
                            | **is** | 用于第三人称单数 (he, she, it, Tom) | He is my friend. |
                            | **are** | 用于复数及第二人称 (we, you, they) | They are students. |
                            
                            > **注意**：在否定句中，not 紧跟在 be 动词之后。
                        """.trimIndent()),
                        UnitDetailSection("词句积累", """
                            *   Nice to meet you. (很高兴见到你)
                            *   Where are you from? (你来自哪里？)
                            *   Welcome to our school! (欢迎来到我们学校！)
                        """.trimIndent())
                    )
                )
            ) + (2..7).map { TextbookUnit("g7up_u$it", "Unit $it", "话题建设中...") }
        ),
        Textbook(
            id = "g8_up",
            grade = "八年级",
            term = "上册",
            coverColor = Color(0xFFFFF3E0),
            units = listOf(
                TextbookUnit(
                    "g8up_u1", "Unit 1", "Happy Holiday",
                    listOf(
                        UnitDetailSection("单元导读", """
                            ### 1. 单元主题层级
                            *   **主题范畴**：人与社会
                            *   **子主题**：旅游经历；节假日活动
                            
                            ### 2. 单元主题内容
                            探讨假期活动，通过询问“去了哪里”、“和谁一起”以及“感受如何”，练习一般过去时的实际应用。
                            
                            ### 3. 单元新知预览
                            *   **单词短语**：ancient, stay at home, wonderful, go on vacation...
                            *   **核心句式**：Where did you go? / How was the trip?
                            *   **重点语法**：一般过去时的特殊疑问句与复合不定代词。
                        """.trimIndent()),
                        UnitDetailSection("知识详解", """
                            #### 复合不定代词全解析 (Starter)
                            *   **指人**：someone, anyone, no one, everyone.
                            *   **指物**：something, anything, nothing, everything.
                            
                            > 💡 **核心考点**：
                            > 1. 形容词修饰它们时必须**后置**。 (e.g. *something interesting*)
                            > 2. 它们作主语时，谓语动词一律用**单数**。
                        """.trimIndent()),
                        UnitDetailSection("长难句分析", """
                            > *Original:* "Did you do anything special on your vacation in the mountains?"
                            
                            *   **解析**：
                                *   `Did` (助动词开头，一般过去时疑问句)
                                *   `anything special` (不定代词+形容词后置定语)
                                *   `in the mountains` (地点状语)
                        """.trimIndent()),
                        UnitDetailSection("语法精讲", """
                            #### 一般过去时 (Simple Past Tense)
                            *   **动词变化**：
                                *   规则：+ed (worked), 重读闭音节双写 (stopped)。
                                *   不规则：go -> went, take -> took, buy -> bought。
                            *   **时间标志**：yesterday, last week, two days ago...
                        """.trimIndent())
                    )
                )
            ) + (2..10).map { TextbookUnit("g8up_u$it", "Unit $it", "话题建设中...") }
        ),
        Textbook("g7_down", "七年级", "下册", Color(0xFFE8F5E9), (1..12).map { TextbookUnit("g7d_u$it", "Unit $it", "建设中") }),
        Textbook("g8_down", "八年级", "下册", Color(0xFFFFE0B2), (1..10).map { TextbookUnit("g8d_u$it", "Unit $it", "建设中") }),
        Textbook("g9_full", "九年级", "全一册", Color(0xFFE3F2FD), (1..14).map { TextbookUnit("g9f_u$it", "Unit $it", "建设中") })
    )
}
