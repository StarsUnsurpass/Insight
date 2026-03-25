package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

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
                        *   **主题范畴**：人与自我 —— 假期生活与旅行体验。
                        *   **核心内容**：谈论过去的假期经历，评价旅行感受。
                        *   **考点分布**：一般过去时的熟练应用；复合不定代词的物理法则。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇金牌解析", """
                        #### ① **ancient** /ˈeɪnʃənt/ (adj. 古代的)
                        - **【用法视角】**：描述具有历史厚重感的建筑或文化。 *ancient buildings*.
                        - **【近义辨析】**：*old* (一般的旧) vs *ancient* (上古/古代的)。
                        
                        #### ② **indefinite pronouns** (复合不定代词)
                        - **【物理规则】**：
                          1. **修饰成分后置**：形容词必须放在不定代词之后。 *something special* (√)。
                          2. **三位一体**：*some-* 用于肯定句；*any-* 用于疑问/否定句。
                        
                        #### ③ **decide (v.)**
                        - **【固定搭配】**：**decide to do sth.** (决定做某事)。
                        - **【名词形式】**：**decision**。 *make a decision*.
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 核心语法精讲", """
                        ### 1. 一般过去时 (Simple Past)
                        - **【时间锚点】**：*last month, yesterday, in 2020*.
                        - **【助动词】**：疑问/否定必须请出 **did**。
                        
                        ### 2. 复合不定代词全解
                        - *someone, anyone, no one, everyone...*
                        - **【语法点拨】**：不定代词作主语时，谓语动词用**单数**。
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句式深度解析", """
                        - **Where did you go on vacation? — I went to...**
                        - **Did you do anything special? — Not really.**
                        - **How was the weather? — It was sunny.**
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "How often do you exercise?",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        *   **内容**：谈论生活习惯与频率。
                        *   **核心**：频率副词的精准量化；How often 引导的疑问句。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇详析", """
                        #### ① **how often** (多久一次)
                        - **【逻辑对标】**：用于询问动作发生的频率。
                        - **【同类家族】**：*How long* (多久), *How soon* (多久以后)。
                        
                        #### ② **hardly ever** (几乎不)
                        - **【属性】**：程度极低，通常等同于否定表达。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 核心语法精讲", """
                        ### 频率副词的“量化分布”
                        - 100% (**always**) -> 80% (**usually**) -> 60% (**often**) -> 30% (**sometimes**) -> 5% (**hardly ever**) -> 0% (**never**)。
                        - **【位置】**：实前 be 后。
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句式深度解析", """
                        - **How often do you go to the movies? — Once a week.**
                        - **What's your favourite program? — Animal World.**
                        - **Good health habits help you get better grades.**
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "I'm more outgoing than my sister.",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        *   **核心主题**：人物对比与特征衡量。
                        *   **考点**：形容词/副词比较级的物理构建模型。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇详析", """
                        #### ① **outgoing** (外向的)
                        - **【反义词】**：**quiet** (文静的) / **shy** (害羞的)。
                        
                        #### ② **both ... and ...** (两者都)
                        - **【重要规则】**：作主语时，谓语动词始终用**复数**。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 核心语法精析", """
                        ### 比较级 (Comparatives) 的构建逻辑
                        1. **单音节/双音节**：末尾加 **-er** (*taller, funnier*)。
                        2. **多音节**：前面加 **more** (*more athletic*)。
                        - **【修饰语】**：可以用 **much, a little, even** 来修饰比较级表示程度。
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句式深度解析", """
                        - **I'm taller than my sister.**
                        - **She's more outgoing than me.**
                        - **Is Sam as funny as Tom?** (as...as 同级比较)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "What's the best movie theater?",
                listOf(
                    UnitDetailSection("📖 单元导读", "最高级应用下的场所评价。"),
                    UnitDetailSection("⚙️ 核心语法精讲", """
                        ### 最高级 (Superlatives) 物理法则
                        - 表示三者及以上中的“最……”。
                        - **【定冠词】**：形容词最高级前必须加 **the**。
                        - **【结构】**：**the + adj.-est / the most + adj.**
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - **It has the most comfortable seats.**
                        - **Which is the best movie theater in town?**
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "Do you want to watch a game show?",
                listOf(
                    UnitDetailSection("📖 单元导读", "电视节目偏好与意见表达。"),
                    UnitDetailSection("🔤 核心词汇", """
                        #### ① **hope to do sth.** (希望做某事)
                        #### ② **plan to do sth.** (计划做某事)
                        - 后接动词不定式做宾语。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 核心语法精讲", """
                        ### 动词不定式做宾语 (I)
                        - 某些动词必须后接 **to do**。 *want, hope, plan, expect, learn*.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "I'm going to study computer science.",
                listOf(
                    UnitDetailSection("📖 单元导读", "理想抱负与未来规划。"),
                    UnitDetailSection("⚙️ 核心语法精析", """
                        #### be going to (计划场)
                        - 表示主观打算或客观必然倾向。
                        - **结构**：*am/is/are + going to + 动词原形*.
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - **What are you going to be when you grow up?**
                        - **I'm going to grow vegetables in the future.**
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "Will people have robots?",
                listOf(
                    UnitDetailSection("📖 单元导读", "未来预测与环境展望。"),
                    UnitDetailSection("⚙️ 核心语法精析", """
                        #### 一般将来时 (will) —— 预测场
                        - 表达对未来的推测（常伴随 I think...）。
                        
                        #### less vs fewer
                        - **less**: 修饰不可数。 *less water*.
                        - **fewer**: 修饰可数。 *fewer trees*.
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - **There will be more pollution.**
                        - **Will people live to be 200 years old?**
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "How do you make a banana milk shake?",
                listOf(
                    UnitDetailSection("📖 单元导读", "制作指南与流程控制。"),
                    UnitDetailSection("🔤 核心词汇详析", """
                        #### ① **First, Next, Then, Finally** (顺序词)
                        - 用于逻辑指引。
                        
                        #### ② **peel / cut up / pour / turn on**
                        - 烹饪/电器相关的物理动词短语。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 核心语法点精析", """
                        ### 祈使句 (续) 与 计数法
                        - *How many bananas do we need?* (可数询问)
                        - *How much milk do we need?* (不可数询问)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u9", "Unit 9", "Can you come to my party?",
                listOf(
                    UnitDetailSection("📖 单元导读", "社交邀请与忙碌拒绝的礼貌策略。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### 情态动词 (Modal Verbs) for Invitations
                        - **Asking**: *Can you come...?*
                        - **Accepting**: *Sure, I'd love to.*
                        - **Refusing**: *I'm sorry, I'm not available. I have to...*
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - **I'm afraid I can't.** (委婉表达)。
                        - **Thanks for asking.** (出于礼貌的感谢)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u10", "Unit 10", "If you go to the party, you'll have a great time!",
                listOf(
                    UnitDetailSection("📖 单元导读", "因果决策链与逻辑建议。"),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        #### If 引导的条件状语从句
                        - **【核心法则】**：**主将从现**。
                        - 如果主语是将来动作，if 引导的从句通常必须用一般现在时。
                        - *If it rains tomorrow, we will stay at home.*
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - **If you work hard, you will succeed.**
                        - **I will bring some snacks if I go to the party.**
                    """.trimIndent())
                )
            )
        )
    )
}
