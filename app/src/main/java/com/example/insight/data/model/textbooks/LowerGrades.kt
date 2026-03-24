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
                    UnitDetailSection("📖 单元导读", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我
                        *   **子主题**：个人特长与爱好；社团活动。
                        
                        ### 2. 单元核心新知
                        *   **核心语法**：情态动词 **can** 的用法。
                        *   **功能句式**：Can you swim? / Yes, I can. / No, I can't.
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲", """
                        #### 情态动词 can 的精密体系
                        
                        1.  **含义**：表示“能”、“会”、“可以”。
                        2.  **句式特征**：
                            *   **无人称变化**：不管是 I, you 还是 he, she, it，一律用 can。
                            *   **后接原形**：can + 动词原形。
                        3.  **句型转换**：
                            *   否定句：直接在 can 后加 not -> **can't**。
                            *   疑问句：直接将 can 提到主语前。
                    """.trimIndent())
                )
            )
        ) + (2..12).map { i ->
            TextbookUnit("g7d_u$i", "Unit $i", "全维度同步解析", listOf(
                UnitDetailSection("📖 单元导读", "本单元包含核心词汇及关键语法项..."),
                UnitDetailSection("⚙️ 语法精讲", "同步教学大纲，提供详尽的语法解析...")
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
                    UnitDetailSection("📖 单元导读", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我
                        *   **子主题**：健康与急救；疾病描述。
                    """.trimIndent()),
                    UnitDetailSection("🔤 词汇详解", """
                        #### ① **stomachache** (n.) 胃痛
                        *   **词源**：stomach (胃) + ache (痛)。类似词：toothache, headache.
                        
                        #### ② **matter** (n.) 问题；事情
                        *   **句型**：*What's the matter with you?* (你怎么了？)
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲", """
                        #### 1. 情态动词 should (表示建议)
                        *   肯定：should + 动词原形。
                        *   否定：shouldn't + 动词原形。
                        
                        #### 2. 反身代词
                        *   myself, yourself, himself, herself, itself, ourselves, yourselves, themselves.
                    """.trimIndent())
                )
            )
        ) + (2..10).map { i ->
            TextbookUnit("g8d_u$i", "Unit $i", "全维度同步解析", listOf(
                UnitDetailSection("📖 单元导读", "本单元包含健康、环保、志愿者等核心话题..."),
                UnitDetailSection("⚙️ 语法精讲", "包含宾语从句、现在完成时等中考重难点...")
            ))
        }
    )
}
