package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade9Full {
    val data = Textbook(
        id = "g9_full",
        grade = "九年级",
        term = "全一册",
        coverColor = Color(0xFFE3F2FD),
        units = listOf(
            TextbookUnit(
                "g9_u1", "Unit 1", "Good Learners",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我
                        *   **子主题**：学习方法与策略；终身学习。
                        
                        ### 2. 单元核心新知
                        *   **核心语法**：介词 **by** 表示手段或方式的用法；**how** 引导的特殊疑问句。
                        *   **话题句式**：How do you study for a test? / I study by working with a group.
                    """.trimIndent()),
                    UnitDetailSection("🔤 词汇详解", """
                        #### ① **textbook** (n.) 教科书；课本
                        *   **记忆**：text (正文) + book (书)。
                        
                        #### ② **conversation** (n.) 交谈；谈话
                        *   **词块**：*have a conversation with sb.* 与某人交谈。
                        
                        #### ③ **pronunciation** (n.) 发音；读音
                        *   **动词形式**：**pronounce** (v.)。注意拼写变化：动词里有 'o'，名词里 'o' 消失了。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲", """
                        #### 介词 by 的中考全能解析
                        
                        1.  **表示“通过……方式/手段” (核心考点)**
                            *   结构：**by + doing sth.**
                            *   e.g. *I learn English by listening to tapes.*
                        2.  **表示方位**：在……旁边 (e.g., *by the window*)。
                        3.  **表示时间**：到……为止；不迟于 (e.g., *by the end of this month*)。
                        4.  **表示被动**：被，由 (e.g., *written by Lu Xun*)。
                        
                        #### 【提问方式】
                        对 *by + doing* 结构提问时，疑问词统一用 **How**。
                    """.trimIndent()),
                    UnitDetailSection("🔍 长难句分析", """
                        > *Original:* "The secret to language learning is listening to something you are interested in every day."
                        
                        *   **解析**：
                            *   `The secret to language learning` (主语)
                            *   `is` (系动词)
                            *   `listening to something` (表语，动名词短语)
                            *   `you are interested in` (定语从句，修饰 something)
                    """.trimIndent()),
                    UnitDetailSection("✍️ 词句积累", """
                        *   **It's a piece of cake.** (小菜一碟)
                        *   **Practice makes perfect.** (熟能生巧)
                        *   **Knowledge is power.** (知识就是力量)
                    """.trimIndent())
                )
            )
        ) + (2..14).map { i ->
            TextbookUnit("g9f_u$i", "Unit $i", "中考总复习全维度解析", listOf(
                UnitDetailSection("📖 单元导读", "本单元包含中考高频词汇 20+，核心语法 1 项..."),
                UnitDetailSection("⚙️ 语法精讲", "针对中考真题趋势进行深度考点剖析..."),
                UnitDetailSection("📌 核心速记", "同步《教材帮》最新中考教研成果...")
            ))
        }
    )
}
