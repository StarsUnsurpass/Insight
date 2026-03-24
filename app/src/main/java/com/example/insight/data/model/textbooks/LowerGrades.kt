package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade7Down {
    val data = Textbook(
        id = "g7_down",
        grade = "七年级",
        term = "下册",
        coverColor = Color(0xFFE8F5E9),
        units = listOf(
            TextbookUnit(
                "g7down_u1", "Unit 1", "Can you play the guitar?",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我 (Man and Self)
                        *   **子主题**：个人特长与爱好；多元文化中的艺术兴趣。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **guitar** (n.) 吉他
                        *   **搭配**：**play the guitar** (弹吉他)。乐器前必须加 **the**。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 情态动词 can 的全维度运用
                        1.  **物理含义**：表示能力“能、会”。
                        2.  **三大特征**：不变性、连接性、独立性。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u2", "Unit 2", "What time do you go to school?",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我
                        *   **子主题**：日常生活作息；时间管理。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **time** 的表达法
                        *   *6:10* -> *six ten* 或 *ten past six*。
                        *   *6:50* -> *ten to seven*。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 1. What time vs. When
                        *   **What time**：具体的时间点。
                        *   **When**：较宽泛的时间段。
                    """.trimIndent())
                )
            )
        ) + (3..12).map { i ->
            TextbookUnit("g7d_u$i", "Unit $i", "全维度同步解析 (同步更新中)", listOf(
                UnitDetailSection("📖 单元导读", "本单元内容核心话题预览...")
            ))
        }
    )
}

object Grade8Down {
    val data = Textbook(
        id = "g8_down",
        grade = "八年级",
        term = "下册",
        coverColor = Color(0xFFFFE0B2),
        units = listOf(
            TextbookUnit(
                "g8down_u1", "Unit 1", "What's the matter?",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我
                        *   **子主题**：身体健康；疾病与家庭急救。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇基础", """
                        #### ① **stomachache** (n.) 胃痛
                        *   **ache系列**：headache, toothache, backache.
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 1. 情态动词 should 表示建议
                        *   *You should see a doctor.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u2", "Unit 2", "I'll help to clean up the city parks.",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与社会
                        *   **子主题**：志愿服务 (Volunteering)。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **Phrasal Verbs (短语动词)**
                        *   *clean it up* (代词居中), *give out* (分发), *put off* (推迟)。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 动词不定式 (To do)
                        1.  **作宾语**：*decide to do*。
                        2.  **作宾补**：*ask sb. to do*。
                    """.trimIndent())
                )
            )
        ) + (3..10).map { i ->
            TextbookUnit("g8d_u$i", "Unit $i", "全维度同步解析 (同步更新中)", listOf(
                UnitDetailSection("📖 单元导读", "本单元内容内容核心话题预览...")
            ))
        }
    )
}
