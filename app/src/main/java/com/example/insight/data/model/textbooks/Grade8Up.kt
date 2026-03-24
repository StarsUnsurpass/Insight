package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade8Up {
    val data = Textbook(
        id = "g8_up",
        grade = "八年级",
        term = "上册",
        coverColor = Color(0xFFFFF9C4),
        units = listOf(
            TextbookUnit(
                "g8up_u1", "Unit 1", "Where did you go on vacation?",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **主题范畴**：人与自我
                        *   **子主题**：假期活动；旅游经历。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 1. 一般过去时 (Simple Past Tense)
                        *   **核心关键词**：*yesterday*, *last week*, *ago*...
                        
                        #### 2. 复合不定代词 (Compound Indefinite Pronouns)
                        *   *someone*, *anything*, *everything*, *nothing*...
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "How often do you exercise?",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **子主题**：健康习惯；频率询问。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **hardly** (adv.) 几乎不 (具有否定意义)。
                        #### ② **once / twice** (adv.) 一次 / 两次。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 1. "How often" 引导的特殊疑问句
                        *   用于提问频率：*twice a week*.
                        
                        #### 2. 频度副词位置
                        *   **口诀**：“行前系助后”。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "I'm more outgoing than my sister.",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        *   **子主题**：朋友间的对比；真正的友谊。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 形容词与副词的比较级
                        *   **程度修饰**：可用 *much*, *even*, *a bit* 修饰（不可用 very）。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "What's the best movie theater?",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        *   **子主题**：客观评价生活设施。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 形容词与副词的最高级
                        *   **结构**：**the + 最高级 + in/of ...**
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "Do you want to watch a game show?",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        *   **子主题**：节目偏好；个人态度表达。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 动词不定式 (to do) 作宾语
                        *   **口诀**：期望计划想，希望答应忙...
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "I'm going to study computer science.",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我 —— 职业规划与未来理想。
                        *   **子主题**：职业理想；实现目标的计划；新年决心。
                        
                        ### 2. 单元主题内容
                        探讨“长大后想做什么”以及“如何实现”。学习表示计划与意图的 **be going to** 结构。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **Jobs** 职业
                        *   **computer programmer** (程序员)；**engineer** (工程师)。
                        
                        #### ② **grow up** (长大)
                        *   **be sure about** (对...有把握)。
                        
                        #### ③ **make a resolution** (下定决心)
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### be going to 结构 (一般将来时)
                        1.  **含义**：表示计划、打算做某事，或根据迹象推测。
                        2.  **结构**：**am/is/are + going to + 动词原形**。
                        3.  **注意**：与 **will** 相比，更强调“已经计划好”的意图。
                    """.trimIndent()),
                    UnitDetailSection("🔍 长难句剖析", """
                        > *Original:* "I'm going to practice harder to become a good violinist."
                        *   **解析**：*to become...* 是不定式作目的状语。
                    """.trimIndent()),
                    UnitDetailSection("📌 重点速记手册", """
                        *   **口诀**：be going to 打算做，计划安排已确定；be 的形式依主语，后面跟动词原形。
                    """.trimIndent())
                )
            )
        ) + (7..10).map { i ->
            TextbookUnit("g8up_u$i", "Unit $i", "全维度同步解析 (同步更新中)", listOf(
                UnitDetailSection("📖 单元导读", "本单元内容核心话题和词汇分析预览...")
            ))
        }
    )
}




