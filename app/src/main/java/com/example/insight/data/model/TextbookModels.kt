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
    val category: String, // e.g., "词汇辨析", "核心语法", "常用句型", "写作要点"
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
                    id = "g7up_s1",
                    title = "Starter Unit 1",
                    topic = "Hello!",
                    details = listOf(
                        UnitDetailSection("词汇速记", """
                            1. **Hello / Hi**：最基础的问候语。Hi 较 Hello 更为随意。
                            2. **Good morning / afternoon / evening**：不同时段的问候。注意 morning 是从凌晨到中午12点前。
                            3. **I'm = I am**：自我介绍的缩写形式。
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            *   **字母 A-H**：掌握 8 个字母的大小写书写及其在单词中的发音。
                            *   **be动词基础**：初识 `am` 的用法（配合 I 使用）。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_s2",
                    title = "Starter Unit 2",
                    topic = "Keep Tidy!",
                    details = listOf(
                        UnitDetailSection("重点词汇", """
                            1. **Keep tidy**：保持整洁。
                            2. **What's this?**：这是什么？用于询问近处的物体。
                            3. **Colors**：red, blue, yellow, green, orange, purple, white, black, brown.
                        """.trimIndent()),
                        UnitDetailSection("语法帮", """
                            *   **字母 I-R**：掌握其读音与书写。
                            *   **不定冠词 a / an**：
                                *   a 用于辅音音素开头的单词前（如 *a pen*）。
                                *   an 用于元音音素开头的单词前（如 *an orange*）。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_s3",
                    title = "Starter Unit 3",
                    topic = "Welcome!",
                    details = listOf(
                        UnitDetailSection("核心词汇", """
                            1. **Numbers 1-10**：one, two, three, four, five, six, seven, eight, nine, ten.
                            2. **Classroom items**：ruler, pencil, eraser, pencil box, schoolbag, dictionary.
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            *   **字母 S-Z**：掌握其读音与书写。
                            *   **指示代词 this & that**：
                                *   this 指近处。
                                *   that 指远处。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_u1",
                    title = "Unit 1",
                    topic = "You and Me",
                    details = listOf(
                        UnitDetailSection("核心词汇帮", """
                            *   **friend** (n.) 朋友 -> **friendly** (adj.) 友好的。
                            *   **nice** (adj.) 令人愉快的；宜人的。常用于 *Nice to meet you!*
                            *   **meet** (v.) 遇见；相逢。其过去式为 *met*。
                            *   **each other**：互相；彼此。用于两者之间。
                        """.trimIndent()),
                        UnitDetailSection("语法帮 (核心)", """
                            #### be动词的一般现在时 (am, is, are)
                            
                            1. **用法口诀**：我(I)用am，你(you)用are，is连着他(he)、她(she)、它(it)；单数名词用is，复数名词全用are。
                            2. **句式结构**：
                               *   肯定句：主语 + be + 其他. (e.g. *I am a student.*)
                               *   否定句：主语 + be + not + 其他. (e.g. *She is not my teacher.*)
                               *   疑问句：Be + 主语 + 其他? (e.g. *Are you from China?*)
                        """.trimIndent()),
                        UnitDetailSection("句型帮", """
                            1. **What's your name?** ——询问姓名。回答：*My name is...* 或 *I'm...*
                            2. **Where are you from?** ——询问籍贯/国籍。回答：*I'm from...* 或 *I come from...*
                            3. **How old are you?** ——询问年龄。回答：*I'm... (years old).*
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_u2",
                    title = "Unit 2",
                    topic = "We're Family",
                    details = listOf(
                        UnitDetailSection("词汇速查", """
                            *   **Family members**：grandfather, grandmother, father, mother, uncle, aunt, brother, sister, cousin.
                            *   **photo** (n.) 照片 -> 复数为 **photos** (直接加s)。
                            *   **son** (儿子) vs **sun** (太阳) —— 同音词。
                        """.trimIndent()),
                        UnitDetailSection("语法重点", """
                            #### 1. 指示代词 this, that, these, those
                            *   **this / these**：指代近处的人或物。
                            *   **that / those**：指代远处的人或物。
                            
                            #### 2. 名词所有格 ('s)
                            *   表示“某人的”。
                            *   单数名词后加 **'s** (e.g. *Tom's book*)。
                            *   以s结尾的复数名词只加 **'** (e.g. *the teachers' office*)。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_u3",
                    title = "Unit 3",
                    topic = "My School",
                    details = listOf(
                        UnitDetailSection("场所词汇", """
                            *   **classroom** 教室
                            *   **library** 图书馆 (注意拼写)
                            *   **playground** 操场
                            *   **lab** 实验室 (laboratory的缩写)
                        """.trimIndent()),
                        UnitDetailSection("语法大招", """
                            #### There be 句型 (表示“某地有某物”)
                            
                            1. **结构**：There is/are + 名词 + 地点状语.
                            2. **主谓一致 (就近原则)**：
                               *   *There is a desk and two chairs.*
                               *   *There are two chairs and a desk.*
                            3. **与have的区别**：
                               *   There be 指“客观存在”。
                               *   Have/Has 指“主观拥有”。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_u4",
                    title = "Unit 4",
                    topic = "My Favourite Food",
                    details = listOf(
                        UnitDetailSection("词汇速记", """
                            *   **Food**：apple, banana, bread, milk, chicken, vegetable, healthy, breakfast, lunch, dinner.
                            *   **like** (v.) 喜欢 -> **dislike** (v.) 不喜欢。
                        """.trimIndent()),
                        UnitDetailSection("语法精讲", """
                            #### 1. 可数名词与不可数名词
                            *   **可数名词**：有复数形式（如 *apples*）。
                            *   **不可数名词**：没有复数形式（如 *milk, bread, water*）。
                            
                            #### 2. some 与 any 的用法
                            *   **some** 用于肯定句。
                            *   **any** 用于否定句和疑问句。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_u5",
                    title = "Unit 5",
                    topic = "Fun Times",
                    details = listOf(
                        UnitDetailSection("能力词汇", """
                            *   **play**：演奏、踢（球）。
                            *   **Instruments**：piano, guitar, drums (注意：play the piano)。
                            *   **Sports**：tennis, soccer, basketball (注意：play soccer)。
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            #### 情态动词 can 的用法
                            
                            1. **表示“能力”**：I can sing.
                            2. **句式变化**：
                               *   否定：can't (cannot)。
                               *   疑问：Can you...? 回答：Yes, I can. / No, I can't.
                            3. **连词 but**：表示转折（e.g. *I can dance but I can't sing.*）。
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_u6",
                    title = "Unit 6",
                    topic = "A Day in the Life",
                    details = listOf(
                        UnitDetailSection("日常词汇", """
                            *   **get up** 起床
                            *   **eat breakfast** 吃早餐
                            *   **go to school** 上学
                            *   **do homework** 做作业
                            *   **go to bed** 睡觉
                        """.trimIndent()),
                        UnitDetailSection("语法重点", """
                            #### 1. 一般现在时 (The Simple Present Tense)
                            *   表示经常性、习惯性的动作。
                            *   **时间表达法**：
                                *   整点：... o'clock.
                                *   逆读法：past (过), to (差)。
                            
                            #### 2. 频度副词
                            *   always, usually, often, sometimes, never.
                        """.trimIndent())
                    )
                ),
                TextbookUnit(
                    id = "g7up_u7",
                    title = "Unit 7",
                    topic = "Happy Birthday",
                    details = listOf(
                        UnitDetailSection("日期词汇", """
                            *   **Months**：January, February, March, April, May, June, July, August, September, October, November, December.
                            *   **date** 日期；**birthday** 生日；**party** 派对；**gift** 礼物。
                        """.trimIndent()),
                        UnitDetailSection("语法聚焦", """
                            #### 1. 序数词 (Ordinal Numbers)
                            *   表示顺序：first, second, third, fourth...
                            *   **口诀**：一二三，特殊记；八去t，九去e；f代ve；ty变tie。
                            
                            #### 2. 时间介词 in, on, at
                            *   **at**：用于具体时刻（at 7:00）。
                            *   **on**：用于具体某一天、星期或日期（on Monday, on May 1st）。
                            *   **in**：用于月份、季节、年份或泛指上下午（in May, in 2024）。
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
