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
                        ### 1. 2025新课标主题透视
                        *   **主题范畴**：人与自我 (Man and Self) —— 假期生活与旅行体验。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解 (Vocabulary Focus)", """
                        #### ① **ancient** [ˈeɪnʃənt] (adj. 古代的; 古老的)
                        - **[物理搭配]**：*ancient buildings* (古建筑)。
                        
                        #### ② **indefinite pronouns** 复合不定代词
                        - **物理规则**：形容词必须后置。 *something special* (√)。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析 (Grammar)", """
                        #### 1. 一般过去时 (Simple Past)
                        - 助动词 **did** 常驻场位。
                        
                        #### 2. 不定代词 (Indefinite Pronouns)
                        - *something / someone* (肯定句)；*anything / anyone* (疑问/否定句)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "Home Sweet Home",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **核心内容**：家务活动与日常请求。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析 (Grammar)", """
                        #### 请求礼貌度场 (Politeness)
                        - **Can you...?** vs **Could you please...?** (更委婉)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "In the Kitchen",
                listOf(
                    UnitDetailSection("📖 单元导读", "烹饪食谱与制作流程。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. 祈使句 (Imperatives)
                        - *First, cut up the vegetables.*
                        
                        #### 2. 可数名词 vs 不可数名词
                        - *How much milk do we need?*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "We Can Live Without Bees...",
                listOf(
                    UnitDetailSection("📖 单元导读", "自然保护与环境因果。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. might (可能性)
                        - *What might happen if bees disappear?*
                        
                        #### 2. 零类条件句 (Zero Conditional)
                        - 表达自然定律。 *If bees disappear, plants will die.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "A Beautiful Blue Planet",
                listOf(
                    UnitDetailSection("📖 单元导读", "地球资源与回收保护。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 形容词/副词 比较级与最高级
                        - *The Earth is the only planet with life.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "I'm going to study computer science.",
                listOf(
                    UnitDetailSection("📖 单元导读", "职业理想与新年愿望。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. "be going to" (计划场)
                        - 用于表示已有的计划、安排或必然的倾向。
                        
                        #### 2. Career & Resolutions
                        - *How/Where/When* 提问具体计划步骤。
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *What are you going to be when you grow up?*
                        - *I am going to take up a hobby.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "Will people have robots?",
                listOf(
                    UnitDetailSection("📖 单元导读", "科技预测与未来生活描绘。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 一般将来时 (will) —— 预测场
                        - 表示对未来的猜测、承诺或预测。
                        
                        #### fewer vs less
                        - **fewer** 修饰可数名词；**less** 修饰不可数名词。
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *There will be more pollution.*
                        - *People will live to be 200 years old.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "How do you make a banana milk shake?",
                listOf(
                    UnitDetailSection("📖 单元导读", "制作流程与顺序词。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. 顺序词 (Sequence Words)
                        - *First, Next, Then, Finally.*
                        
                        #### 2. Imperatives (祈使句)
                        - *Peel the bananas and cut them up.*
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *How many bananas do we need?*
                        - *First, pour the milk into the blender.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u9", "Unit 9", "Can you come to my party?",
                listOf(
                    UnitDetailSection("📖 单元导读", "社交邀请与忙碌拒绝。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 1. 情态动词 (Modal Verbs) Invitations
                        - *Can you come...?* — *I'd love to.*
                        
                        #### 2. have to (客观义务)
                        - *I'd love to, but I have to prepare for an exam.*
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *Thanks for asking.* (谢谢邀请)。
                        - *I am not available.* (我没空)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u10", "Unit 10", "If you go to the party, you'll have a great time!",
                listOf(
                    UnitDetailSection("📖 单元导读", "决策链条与因果建议。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### If 引导的条件状语从句 (I)
                        - **主将从现 (Primary Rule)**：主句用将来时，If 从句用一般现在时。
                        
                        #### advice vs advise
                        - **advice** (n. 不可数)；**advise** (v. 建议某人做某事)。
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *If you work hard, you will succeed.*
                        - *Let's give him some advice.*
                    """.trimIndent())
                )
            )
        )
    )
}
