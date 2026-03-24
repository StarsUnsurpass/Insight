package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade7Up {
    val data = Textbook(
        id = "g7_up",
        grade = "七年级",
        term = "上册",
        coverColor = Color(0xFFFCE4EC),
        units = listOf(
            TextbookUnit(
                "g7up_u1", "Unit 1", "You and Me",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我
                        *   **子主题**：个人信息 (Personal information)；人际交往。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **friend** (n.) 朋友
                        *   **friendly** (adj.) 友好的。
                        *   **make friends (with sb.)** 与某人交朋友。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### be 动词 (am, is, are) 的基本用法
                        *   *I am...* / *He is...* / *They are...*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u2", "Unit 2", "We're Family",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **子主题**：家庭成员；指示代词的运用。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **family**
                        *   指“家”看作单数；指“家人”看作复数。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 指示代词 (this, that, these, those)
                        *   **单数**：this, that；**复数**：these, those。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u3", "Unit 3", "My School",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **子主题**：校园场所；方位描述。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇详解", """
                        *   **library**, **playground**, **classroom**...
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### There be 句型
                        *   **就近原则**：*There is a book and two pens.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u4", "Unit 4", "My Favorite Food",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        *   **子主题**：饮食与健康；喜好表达。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 可数名词与不可数名词
                        *   **Countable**: *apples*, *tomatoes*.
                        *   **Uncountable**: *bread*, *rice*, *meat*.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u5", "Unit 5", "Fun Clubs",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **子主题**：选择社团；才艺展示。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 情态动词 can
                        *   **be good at** (擅长)；**can + 动词原形**。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u6", "Unit 6", "A day in the life",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **子主题**：校园生活作息；自律意识培养。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 现在进行时 (be + doing)
                        *   **逆读法时间表达法**：*half past*, *a quarter to*。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u7", "Unit 7", "Happy Birthday!",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **子主题**：日期表达；派对筹备。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 时间介词 (in/on/at)
                        *   **序数词口诀**：一二三特殊记，八去 t 九去 e...
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u8", "Unit 8", "Spending time with family",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我 —— 家庭生活与劳动教育。
                        *   **子主题**：家庭活动；家务劳动；传统习俗与亲情。
                        
                        ### 2. 单元主题内容
                        描述与家人共度的时光。学习如何表达正在发生的家庭场景，理解并表达家务劳动在家庭关系中的情感价值。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **holiday/festival** (n.) 节日/假期
                        *   **traditional customs** (传统习俗)。
                        
                        #### ② **spend** (v.) 花费 (时间/金钱)
                        *   *spend time with sb.* (与某人共度时光)。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 1. 现在进行时 (续)
                        *   **结构**：**be + v-ing**。
                        *   *What is your father doing? He is washing the car.*
                        
                        #### 2. 动名词作主语
                        *   *Spending time with family is important.* (谓语动词用单数)。
                    """.trimIndent()),
                    UnitDetailSection("🔍 长难句剖析", """
                        > *Original:* "Doing housework is also a way to show our love for our family."
                        *   **解析**：*to show...* 是不定式作定语，修饰 *way*。
                        *   **写作点拨**：这是论述家庭责任感的满分句型。
                    """.trimIndent()),
                    UnitDetailSection("📌 重点速记手册", """
                        *   **口诀**：现在进行时好记，be + doing 莫忘记；am/is/are 依主语，v-ing 紧跟在其后。
                    """.trimIndent())
                )
            )
        ) + (9..10).map { i ->
            TextbookUnit("g7up_u$i", "Unit $i", "全维度同步解析 (同步更新中)", listOf(
                UnitDetailSection("📖 单元导读", "本单元内容核心话题和词汇分析预览...")
            ))
        }
    )
}




