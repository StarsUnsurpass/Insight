package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade9Full {
    val data = Textbook(
        id = "g9_full",
        grade = "九年级",
        term = "全一册",
        coverColor = Color(0xFFFFB74D),
        units = listOf(
            TextbookUnit("g9_u1", "Unit 1", "How can we become good learners?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 2025新课标主题透视
                    *   **主题范畴**：人与自我 —— 学习策略与终身学习。
                    *   **核心内容**：探讨学习英语及其他学科的高效方法。
                    *   **考点分布**：by + v-ing 表达手段；重点词组 depend on, connect ... with.
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇金牌解析", """
                    #### ① **by + doing** (通过……方式)
                    - **【物理属性】**：表示手段、动作的方式。提问用 **How**。
                    - *How do you study for a test? — By working with friends.*
                    
                    #### ② **patient [ˈpeɪʃnt]**
                    - **(adj.)** 有耐心的。 *be patient with sb.*
                    - **(n.)** 病人。
                    
                    #### ③ **active [ˈæktɪv]**
                    - **(adj.)** 活跃的；积极的。 *take an active part in...* (积极参加)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 1. by 引导的方式状语
                    - 常用搭配：*by reading, by listening, by asking*.
                    
                    ### 2. 情态动词 (Modal Verbs) 的回顾
                    - *can/could, may/might, must* 在建议和能力表达中的应用。
                """.trimIndent()),
                    UnitDetailSection("📚 重点句式深度解析", """
                        - **The more you read, the faster you'll be.** (The more... the more... 比较级结构)
                        - **It's not easy to master a foreign language.**
                        - **Learning is a lifelong journey.**
                    """.trimIndent())
            )),
            TextbookUnit("g9_u2", "Unit 2", "I think that mooncakes are delicious!", listOf(
                UnitDetailSection("📖 单元导读", """
                    *   **内容**：描述节日 (Festivals) 与传统。
                    *   **语法**：宾语从句 (Object Clauses)；感叹句的物理构建。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **lay vs lie** (时空错位辨析)
                    - **lay**: [leɪ] (放; 产卵)。 **laid, laid, laying**。
                    - **lie**: [laɪ] (躺; 位于)。 **lay, lain, lying**。
                    
                    #### ② **admire [ədˈmaɪə(r)]** (钦佩; 欣赏)
                    - *admire sb. for sth.* (因某事而钦佩某人)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 1. 宾语从句 (Object Clauses)
                    - **引导词**：*that* (引导陈述句，口语中常省略)；*if/whether* (引导一般疑问句)。
                    - **时态法则**：主过从必过（主句是过去时，从句需用对应的过去时态）。
                    
                    ### 2. 感叹句 (Exclamatory Sentences)
                    - **What型**：*What (a/an) + adj. + n. (+ 主语 + 谓语)!*
                    - **How型**：*How + adj./adv. (+ 主语 + 谓语)!*
                """.trimIndent())
            )),
            TextbookUnit("g9_u3", "Unit 3", "Could you please tell me where the restrooms are?", listOf(
                UnitDetailSection("📖 单元导读", "礼貌询问与城市导航（间接引语应用场）。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 间接引语 (Indirect Questions)
                    - **【物理转换准则】**：疑问语序 -> **陈述语序**。
                    - *Where is the bank?* -> *I wonder **where the bank is**.*
                    - **语气控制**：使用 *Could you please...?* 或 *I wonder if...* 显得更委婉。
                """.trimIndent()),
                UnitDetailSection("📚 核心句式", """
                    - **Excuse me, do you know where I can buy some medicine?**
                    - **Can you tell me how to get to the post office?**
                """.trimIndent())
            )),
            TextbookUnit("g9_u4", "Unit 4", "I used to be afraid of the dark.", listOf(
                UnitDetailSection("📖 单元导读", "个人变化与成长足迹。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### take pride in vs be proud of
                    - 两者都表示“以……为荣”。 *take pride in* 接名词。
                    
                    #### look for vs find
                    - **look for**: 强调“找”的过程。
                    - **find**: 强调“找到”的结果。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### used to do (过去常常)
                    - 表示过去的行为或状态，**现在已不再发生**。
                    - **否定式**：*didn't use to*。 **疑问式**：*Did you use to ...?*
                    - **混淆项**：*be used to doing* (习惯于做某事)。
                """.trimIndent())
            )),
            TextbookUnit("g9_u5", "Unit 5", "What are the shirts made of?", listOf(
                UnitDetailSection("📖 单元导读", "产品制造、原材料与非遗文化（一般现在时被动语态）。"),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### be made of vs be made from (物理vs化学)
                    - **of**: 物理变化，能看出原材料。 *The desk is made of wood.*
                    - **from**: 化学变化，看不出原材料。 *Bread is made from flour.*
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 被动语态 (Passive Voice) I
                    - **结构**：**am/is/are + 过去分词 (v-ed)**。
                    - **场景**：强调动作承受者，或不知道动作发出者。
                """.trimIndent())
            )),
            TextbookUnit("g9_u6", "Unit 6", "When was it invented?", listOf(
                UnitDetailSection("📖 单元导读", "发明史与科技演进（一般过去时被动语态）。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **by accident** (偶然地)
                    - *It happened by accident.*
                    
                    #### ② **take place** (发生)
                    - 侧重于有计划的发生，**无被动语态**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 被动语态 (Passive Voice) II
                    - **结构**：**was/were + 过去分词**。
                    - *The zipper was invented in 1893.*
                """.trimIndent())
            )),
            TextbookUnit("g9_u7", "Unit 7", "Teenagers should be allowed to choose their own clothes.", listOf(
                UnitDetailSection("📖 单元导读", "校园规章与责任界定（含情态动词的被动语态）。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 情态动词的被动语态
                    - **结构**：**情态动词 + be + 过去分词**。
                    - *Teenagers should be allowed to...* (青少年应该被允许……)
                """.trimIndent()),
                UnitDetailSection("📚 核心句式", """
                    - **Parents shouldn't be too strict with their children.**
                    - **I think I should be allowed to stay up until 11:00.**
                """.trimIndent())
            )),
            TextbookUnit("g9_u8", "Unit 8", "It must belong to Carla.", listOf(
                UnitDetailSection("📖 单元导读", "逻辑推理与归属判定。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **belong to** (属于)
                    - **【语法点】**：不接人称代词宾格。 *It belongs to me.* (√)
                    - **【必背】**：**无被动语态**，**无进行时态**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 语气推测 (Modals of Deduction)
                    - **must** (一定): 肯定推测。 100%
                    - **could / might** (可能): 不确定。 50%
                    - **can't** (不可能): 否定推测。 0%
                """.trimIndent())
            )),
            TextbookUnit("g9_u9", "Unit 9", "I like music that I can dance to.", listOf(
                UnitDetailSection("📖 单元导读", "个人品味、电影与音乐（定语从句初探）。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 定语从句 (Attributive Clauses)
                    - **关系代词**：
                      - 指人：*who / that*.
                      - 指物：*which / that*.
                    - **从句位置**：紧跟在先行词后面。
                    - *I like movies **that are interesting**.*
                """.trimIndent())
            )),
            TextbookUnit("g9_u10", "Unit 10", "You're supposed to shake hands.", listOf(
                UnitDetailSection("📖 单元导读", "礼仪、习俗与社交期待。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **be supposed to do** (应该做……)
                    - 相当于 *should*，但语气更偏向于社会规则或期待。
                    
                    #### ② **shake hands** (握手)
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 习俗与规则的表达
                    - *In China, we are supposed to...*
                    - *It's polite to...* (做某事是礼貌的)。
                """.trimIndent())
            )),
            TextbookUnit("g9_u11", "Unit 11", "Sad movies make me cry.", listOf(
                UnitDetailSection("📖 单元导读", "情绪诱发与外界影响。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### make 的复合宾语结构
                    1. **make sb. do sth.** (让某人做某事)。 
                       - **注**：被动语态中 **to** 需还原。 *He was made **to** work.*
                    2. **make sb. + adj.** (使某人……)。 *Music makes me happy.*
                """.trimIndent())
            )),
            TextbookUnit("g9_u12", "Unit 12", "Life is full of the unexpected.", listOf(
                UnitDetailSection("📖 单元导读", "生活中的意外与过去完成时（时空折叠）。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 过去完成时 (Past Perfect)
                    - **物理意义**：动作发生在“过去的过去”。
                    - **结构**：**had + 过去分词**。
                    - **标志词**：*by the time, already, before + 过去时间点*.
                """.trimIndent())
            )),
            TextbookUnit("g9_u13", "Unit 13", "We're trying to save the earth!", listOf(
                UnitDetailSection("📖 单元导读", "环境保护与可持续行动。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **recycle / reuse / reduce** (3R)
                    #### ② **take action** (采取行动)
                    #### ③ **make a difference** (产生影响)
                """.trimIndent())
            )),
            TextbookUnit("g9_u14", "Unit 14", "I remember meeting all of you in Grade 7.", listOf(
                UnitDetailSection("📖 单元导读", "毕业总结、成就回顾与未来愿景。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### remember doing vs remember to do
                    - **doing**: 记得*已做过*的事。
                    - **to do**: 记得*去做*某事。
                """.trimIndent()),
                UnitDetailSection("📚 典句必背", """
                    - **Looking back at these past three years...**
                    - **It's time to set out on our new journey.**
                    - **Knowledge can change your life.**
                """.trimIndent())
            ))
        )
    )
}
