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
                "g9_u1", "Unit 1", "How can we become good learners?",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与自我 (Man and Self)
                        *   **子主题**：学习方法与策略；终身学习；如何学好英语。
                        
                        ### 2. 单元主题内容
                        探讨听、说、读、写各维度的英语学习技巧。重点掌握介词 **by** 引导方式状语的用法，并学会通过分享成功经验来优化个人学习路径。
                        
                        ### 3. 单元新知预览
                        *   **核心语法**：by + doing 结构；how 引导的特殊疑问句。
                        *   **重点词汇**：textbook, conversation, aloud, pronunciation, patience...
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **aloud** (adv.) 大声地
                        *   *read aloud* 朗读 (使人听见)
                        *   *speak loudly* 大声说话 (增加音量)
                        
                        #### ② **pronunciation** (n.) 发音
                        *   动词：**pronounce**。记得名词中 'o' 会消失。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 介词 by 的万能指南
                        1.  **by + doing**：通过……方式 (How do you study? — By listening...)。
                        2.  **by + 时间/地点**：在……旁；到……为止。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u2", "Unit 2", "I think that mooncakes are delicious!",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与社会
                        *   **子主题**：传统节日文化；文化习俗。
                        
                        ### 2. 单元主题内容
                        学习如何描述中外节日，重点掌握宾语从句和感叹句，能够地道地表达个人情感与评价。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解", """
                        #### ① **admire** (v.) 欣赏；钦佩
                        *   *admire sb. for sth.* 因某事而钦佩某人。
                        
                        #### ② **remind** (v.) 提醒
                        *   *remind sb. of sth.* 使某人想起……
                        *   *remind sb. to do sth.* 提醒某人做某事。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法深度精讲", """
                        #### 1. 宾语从句 (Objective Clauses)
                        *   **引导词**：that (陈述), if/whether (疑问)。
                        *   **语序**：必须用陈述句语序。
                        *   **时态**：主过从必过。
                        
                        #### 2. 感叹句 (Exclamatory Sentences)
                        *   **What + 名词** (What a lovely day!)
                        *   **How + 形容词/副词** (How beautiful the moon is!)
                    """.trimIndent())
                )
            )
        ) + (3..14).map { i ->
            TextbookUnit("g9f_u$i", "Unit $i", "中考总复习全维度解析 (同步更新中)", listOf(
                UnitDetailSection("📖 单元导读", "本单元包含中考高频词汇及核心语法拆解..."),
                UnitDetailSection("⚙️ 语法精讲", "针对中考真题趋势进行深度考点剖析..."),
                UnitDetailSection("📌 核心速记", "同步《教材帮》最新中考教研成果...")
            ))
        }
    )
}
