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
    val category: String, // e.g., "核心词汇帮", "语法帮", "方法帮", "真题解析"
    val content: String // Markdown format
)

object TextbookProvider {
    val textbooks = listOf(
        Textbook(
            id = "g7_up",
            grade = "七年级",
            term = "上册",
            coverColor = Color(0xFFFCE4EC), // Light Pink
            units = listOf(
                TextbookUnit(
                    "g7up_s1", "Starter Unit 1", "Hello!",
                    listOf(
                        UnitDetailSection("词汇速记", """
                            *   **问候语**：Hello (你好), Hi (喂；你好), Good morning (早上好), Good afternoon (下午好), Good evening (晚上好)。
                            *   **缩写形式**：I'm = I am (我是), what's = what is (是什么)。
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            #### 1. 26个字母 (A-H)
                            *   掌握 A-H 8个字母的大小写、顺序及基本发音。
                            #### 2. be动词 (am)
                            *   I am... 用于自我介绍。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_s2", "Starter Unit 2", "Keep Tidy!",
                    listOf(
                        UnitDetailSection("核心词汇", """
                            *   **物品**：pencil (铅笔), book (书), eraser (橡皮), ruler (尺子)。
                            *   **颜色**：red (红), blue (蓝), yellow (黄), green (绿), black (黑), white (白)。
                        """.trimIndent()),
                        UnitDetailSection("语法帮", """
                            #### 不定冠词 a/an
                            *   **a**：用于辅音音素开头的单词前 (e.g., *a ruler*)。
                            *   **an**：用于元音音素开头的单词前 (e.g., *an eraser*)。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_s3", "Starter Unit 3", "Welcome!",
                    listOf(
                        UnitDetailSection("词汇天地", """
                            *   **数字 1-10**：one, two, three, four, five, six, seven, eight, nine, ten。
                            *   **课堂指令**：Stand up (起立), Sit down (坐下), Listen (听), Read (读)。
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            #### 指示代词 this / that
                            *   **this** 指代近处的人或物。
                            *   **that** 指代远处的人或物。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_u1", "Unit 1", "You and Me",
                    listOf(
                        UnitDetailSection("核心词汇帮", """
                            *   **friend** (n.) 朋友 -> **friendly** (adj.) 友好的。
                            *   **meet** (v.) 遇见 -> **Nice to meet you!** (很高兴见到你！)
                            *   **each other**：互相；彼此（两者之间）。
                        """.trimIndent()),
                        UnitDetailSection("语法帮 (核心)", """
                            #### be动词的一般现在时 (am, is, are)
                            1. **用法口诀**：我(I)用am，你(you)用are，is连着他(he)、她(she)、它(it)；单数名词用is，复数名词全用are。
                            2. **肯定句**：I am a student. / They are friends.
                            3. **否定句**：be动词后加not (e.g., *He is not...*)。
                            4. **疑问句**：be动词提前 (e.g., *Are you...?*)。
                        """.trimIndent()),
                        UnitDetailSection("考点精析", """
                            *   **first name** (名) 与 **last name / family name** (姓) 的区别。在英语中名在前，姓在后。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_u2", "Unit 2", "We're Family",
                    listOf(
                        UnitDetailSection("词汇速记", """
                            *   **家庭成员**：grandfather, grandmother, father, mother, uncle, aunt, brother, sister, cousin.
                            *   **photo** (照片) -> 复数 **photos**。
                        """.trimIndent()),
                        UnitDetailSection("语法帮", """
                            #### 1. 指示代词 these & those
                            *   **these** (这些)：this 的复数。
                            *   **those** (那些)：that 的复数。
                            #### 2. 名词所有格 ('s)
                            *   表示“某人的”。单数名词后加 's (e.g., *Tom's photo*)；以s结尾的复数名词只加 ' (e.g., *my parents' room*)。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_u3", "Unit 3", "My School",
                    listOf(
                        UnitDetailSection("场所词汇", """
                            *   classroom (教室), library (图书馆), playground (操场), dining hall (食堂)。
                            *   **between... and...**：在……和……之间。
                        """.trimIndent()),
                        UnitDetailSection("语法大招", """
                            #### There be 句型 (表示“某地有某物”)
                            1. **结构**：There is/are + 某物 + 某地.
                            2. **就近原则**：be动词的形式由离它最近的名词决定 (e.g., *There is a desk and two chairs.*)。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_u4", "Unit 4", "My Favourite Food",
                    listOf(
                        UnitDetailSection("饮食词汇", """
                            *   apple, banana, milk, bread, chicken, vegetable, salad, healthy (健康的)。
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            #### 1. 可数名词与不可数名词
                            *   **可数**：有单复数之分 (apples, books)。
                            *   **不可数**：没有复数形式 (water, bread)。
                            #### 2. some 与 any
                            *   **some**：常用于肯定句。
                            *   **any**：常用于否定句和疑问句。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_u5", "Unit 5", "Fun Times",
                    listOf(
                        UnitDetailSection("能力词汇", """
                            *   play tennis, play the piano, play chess, sing, dance, swim.
                            *   **club** (社团) -> join a club (加入社团)。
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            #### 情态动词 can
                            1. **表示能力**：I can speak English.
                            2. **无人称变化**：He can dance. (不用 can's)。
                            3. **句式**：Can you...? Yes, I can. / No, I can't.
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_u6", "Unit 6", "A Day in the Life",
                    listOf(
                        UnitDetailSection("作息词汇", """
                            *   get up (起床), eat breakfast (吃早餐), go to school (去上学), do homework (做作业), go to bed (睡觉)。
                        """.trimIndent()),
                        UnitDetailSection("语法重点", """
                            #### 一般现在时 (习惯与经常)
                            1. **肯定句**：I usually go to bed at 9:00.
                            2. **时间表达法**：
                               *   顺读法：seven twenty (7:20)。
                               *   逆读法：half past seven (7:30)。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    "g7up_u7", "Unit 7", "Happy Birthday",
                    listOf(
                        UnitDetailSection("日期词汇", """
                            *   **月份**：January, February, March, April, May, June, July, August, September, October, November, December.
                            *   **first** (1st), **second** (2nd), **third** (3rd)。
                        """.trimIndent()),
                        UnitDetailSection("语法帮", """
                            #### 1. 序数词
                            *   用于表示日期或顺序。
                            #### 2. 时间介词 in, on, at
                            *   **at**：具体时刻 (at 8:00)。
                            *   **on**：具体某一天 (on Monday, on May 1st)。
                            *   **in**：年、月、季节 (in May, in 2024)。
                        """.trimIndent())
                    )
                )
            )
        ),
        Textbook("g7_down", "七年级", "下册", Color(0xFFE8F5E9), emptyList()),
        Textbook("g8_up", "八年级", "上册", Color(0xFFFFF3E0), emptyList()),
        Textbook("g8_down", "八年级", "下册", Color(0xFFFFE0B2), emptyList()),
        Textbook("g9_full", "九年级", "全一册", Color(0xFFE3F2FD), emptyList())
    )
}
