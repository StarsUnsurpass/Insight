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
        coverColor = Color(0xFFFFB74D),
        units = listOf(
            TextbookUnit(
                "g9_u1", "Unit 1", "How can we become good learners?",
                listOf(
                    UnitDetailSection("📖 单元导读", "学习方法与策略。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### by + doing (通过……方式)
                        - 表示通过某种手段或方法。
                        - *I learn English by listening to tapes.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u2", "Unit 2", "I think that mooncakes are delicious!",
                listOf(
                    UnitDetailSection("📖 单元导读", "传统节日与文化庆典。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. 宾语从句 (Object Clause)
                        - 引导词: **that, if/whether**.
                        - **时态一致性逻辑**：主句过，从句过。
                        
                        #### 2. 感叹句 (Exclamatory)
                        - *What* +(a/an) + adj. + n. !
                        - *How* + adj./adv. !
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u3", "Unit 3", "Could you please tell me where the restrooms are?",
                listOf(
                    UnitDetailSection("📖 单元导读", "礼貌问路与生活请求。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. 间接引语 (Indirect Questions)
                        - 语序变为 **陈述句语序** (主语在前，谓语在后)。
                        - *Could you tell me where he lives?* (√) (不是 *where does he live*)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u4", "Unit 4", "I used to be afraid of the dark.",
                listOf(
                    UnitDetailSection("📖 单元导读", "过去与现在的鲜明对比。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### used to + do (过去常常)
                        - 表示过去存在的状态或习惯，而现在不再如此。
                        - **否定式**：*didn't use to* 或 *usedn't to*。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u5", "Unit 5", "What are the shirts made of?",
                listOf(
                    UnitDetailSection("📖 单元导读", "产品原产地与材质。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 一般现在时 被动语态 (Passives)
                        - **结构**：**am/is/are + v-ed (过去分词)**。
                        - *The shirts are made of cotton.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u6", "Unit 6", "When was it invented?",
                listOf(
                    UnitDetailSection("📖 单元导读", "发明创造的历史轨迹。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 一般过去时 被动语态 (Past Passives)
                        - **结构**：**was/were + v-ed**。
                        - *When was the telephone invented?*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u7", "Unit 7", "Teenagers should be allowed to choose their own clothes.",
                listOf(
                    UnitDetailSection("📖 单元导读", "家规校纪与个人选择。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 情态动词 被动语态 (Modal Passives)
                        - **结构**：**情态动词 (can/should/must) + be + v-ed**。
                        - *Cell phones must be turned off during lessons.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u8", "Unit 8", "It must belong to Carla.",
                listOf(
                    UnitDetailSection("📖 单元导读", "推断、猜测与物主确认为话题。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 表示推测的情态动词 (Physics Logic)
                        - **must** (100% 肯定); **could/might** (20%-50% 可能); **can't** (0% 绝不)。
                        - **belong to** (属于……)，无被动语态。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u9", "Unit 9", "I like music that I can dance to.",
                listOf(
                    UnitDetailSection("📖 单元导读", "音乐爱好与事物描述（定语从句）。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 定语从句 (Relative Clauses)
                        - **先行词**：指人 (*who/that*)；指物 (*which/that*)。
                        - **which vs that**：*that* 更万能，但先行词前有 *all, any, first* 等词只用 *that*。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u10", "Unit 10", "You're supposed to shake hands.",
                listOf(
                    UnitDetailSection("📖 单元导读", "各国礼仪与跨文化交际。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. be supposed to + do (应该做某事)
                        - 表示期望、职责或约定。
                        - *What are you supposed to do at a party?*
                        
                        #### 2. It is + adj. + for sb. + to do sth.
                        - 描述做某事的物理特征。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u11", "Unit 11", "Sad movies make me cry.",
                listOf(
                    UnitDetailSection("📖 单元导读", "事物对情感的影响逻辑（使役动词）。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 使役动词 "make" 的双重场
                        - **make + sb. + do** (动词原形)：*Money makes people change.*
                        - **make + sb. + adj.** (形容词)：*The news made him happy.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u12", "Unit 12", "Life is full of the unexpected.",
                listOf(
                    UnitDetailSection("📖 单元导读", "突发状况与过去完成时话题。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 过去完成时 (Past Perfect)
                        - **核心逻辑**：**过去的过去**。
                        - **结构**：**had + v-ed**。
                        - *By the time he arrived, the train had left.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u13", "Unit 13", "We're trying to save the earth!",
                listOf(
                    UnitDetailSection("📖 单元导读", "环境保护与生态可持续。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 全时态 被动语态 整合
                        - 考察对不同时态下被动形式的精准掌握 (am/is/are being done, have been done 等)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u14", "Unit 14", "I remember meeting all of you in Grade 7.",
                listOf(
                    UnitDetailSection("📖 单元导读", "毕业季回忆、感谢与展望蓝图。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 动词搭配总结 (Memories)
                        - *remember doing* (记得做过)；*remember to do* (记得去做)。
                        - *look forward to + doing* (期望做某事)。
                    """.trimIndent())
                )
            )
        )
    )
}
