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
            TextbookUnit("g9_u1", "Unit 1", "How can we become good learners?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    *   **主题范畴**：人与自我 —— 学习高效化与学习策略。
                    *   **核心内容**：讨论如何通过不同方式学好英语及其他学科。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **by + doing** (通过……方式)
                    - **物理属性**：表示手段/方法。
                    - *by listening to tapes* (听磁带); *by asking the teacher for help*.
                    
                    #### ② **patient [ˈpeɪʃnt]**
                    - **(adj.)** 有耐心的；**(n.)** 病人。
                    - *be patient with sb.* (对某人有耐心)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### How 引导的特殊疑问句
                    - 用于提问“如何做”。
                    - *How do you study for a test? — By working with friends.*
                    
                    #### depend on / connect with
                    - **depend on**: 取决于；依赖。
                    - **connect with**: 把……与……结合。
                """.trimIndent())
            )),
            TextbookUnit("g9_u2", "Unit 2", "I think that mooncakes are delicious!", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    *   **主题范畴**：文化习俗 —— 节日传统与故事传说。
                    *   **核心内容**：描述节日食物、习俗及背后的神话故事（嫦娥奔月、圣诞颂歌）。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **lay vs lie** (辨析磁场)
                    - **lay**: [leɪ] (放; 产卵)。 过去式 **laid**, 现分 **laying**。
                    - **lie**: [laɪ] (躺; 位于)。 过去式 **lay**, 现分 **lying**。
                    
                    #### ② **steal [stiːl]** (偷)
                    - *steal sth. from sb.* (从某人处偷某物)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 1. 宾语从句 (Object Clauses)
                    - **引导词**：*that* (陈述句), *if/whether* (一般疑问句)。
                    - **时态逻辑**：主句是一般过去时，从句通常用过去某种时态。
                    
                    #### 2. 感叹句 (Exclamatory)
                    - **What型**：*What + a/an + adj + n (可数单数)!*
                    - **How型**：*How + adj/adv (+ 主语 + 谓语)!*
                """.trimIndent())
            )),
            TextbookUnit("g9_u3", "Unit 3", "Could you please tell me where the restrooms are?", listOf(
                UnitDetailSection("📖 单元导读", "礼貌请求与城市设施定位。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **restroom vs bathroom**
                    - **restroom**: 公共厕所。
                    - **bathroom**: 浴室/家里的厕所。
                    
                    #### ② **suggest [səˈdʒest]** (建议)
                    - *suggest doing sth.* (√)
                    - *suggest that sb. (should) do sth.* (√)
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 间接引语 (Indirect Questions) —— 礼貌逻辑
                    - **物理语序转换**：疑问句语序 -> **陈述句语序** (主语在前)。
                    - *Where is the bank?* -> *Could you tell me **where the bank is**?*
                """.trimIndent())
            )),
            TextbookUnit("g9_u4", "Unit 4", "I used to be afraid of the dark.", listOf(
                UnitDetailSection("📖 单元导读", "成长阶段对比与外貌性格蝶变。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **be afraid of** (害怕)
                    - *be afraid of doing* / *be afraid to do*.
                    
                    #### ② **humorous [ˈhjuːmərəs]** (幽默的)
                    - 其名词为 **humor**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### used to do (过去常常) —— 习惯对冲
                    - 表示过去的行为或状态，而现在不再发生了。
                    - **否定式**：*didn't use to* / *usedn't to*.
                    - **辨析**：*be used to doing* (习惯于做某事)。
                """.trimIndent())
            )),
            TextbookUnit("g9_u5", "Unit 5", "What are the shirts made of?", listOf(
                UnitDetailSection("📖 单元导读", "物质组成、原产地与非遗文化。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### be made of vs be made from
                    - **be made of**: 物理变化 (能看原材质)。 *The desk is made of wood.*
                    - **be made from**: 化学变化 (看不出原材)。 *Paper is made from wood.*
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 一般现在时 被动语态 (Passives I)
                    - **结构**：**am/is/are + v-ed (过去分词)**。
                    - **物理意义**：动作的承受者放在主语位置。
                """.trimIndent())
            )),
            TextbookUnit("g9_u6", "Unit 6", "When was it invented?", listOf(
                UnitDetailSection("📖 单元导读", "发明史、科技成就与历史物理场。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **by accident** (偶然地)
                    - 意为 *by mistake*.
                    
                    #### ② **take place** (发生)
                    - 无被动语态。常指有计划的发生。 *Happen* 指偶然发生。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 一般过去时 被动语态 (Passives II)
                    - **结构**：**was/were + v-ed**。
                    - *When was the zipper invented? — It was invented in 1893.*
                """.trimIndent())
            )),
            TextbookUnit("g9_u7", "Unit 7", "Teenagers should be allowed to choose their own clothes.", listOf(
                UnitDetailSection("📖 单元导读", "探讨规章制度与青少年权利（情态动词被动语态应用场）。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 情态动词的被动语态
                    - **结构**：**情态动词 + be + done (过去分词)**。
                    - *Teenagers should be allowed to...*
                    
                    #### stay up (熬夜) / clean up (打扫干净)
                    - 常用短语集锦。
                """.trimIndent())
            )),
            TextbookUnit("g9_u8", "Unit 8", "It must belong to Carla.", listOf(
                UnitDetailSection("📖 单元导读", "逻辑推理、物主归属与证据分析。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **belong to** (属于)
                    - 无被动语态，无进行时。 *The book belongs to me.*
                    
                    #### ② **anybody / somebody / nobody**
                    - 不定代词磁场。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 语气强弱推测 (Modals of Deduction)
                    - **must** (一定): 100% 肯定。
                    - **could / might** (可能): 50% 可能性。
                    - **can't** (不可能): 0% 可能性。
                """.trimIndent())
            )),
            TextbookUnit("g9_u9", "Unit 9", "I like music that I can dance to.", listOf(
                UnitDetailSection("📖 单元导读", "个人品味描述（定语从句应用场）。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 定语从句 (Attributive Clauses) —— 磁铁句
                    - **关系词选择**：
                      - 指人：*who / that*.
                      - 指物：*which / that*.
                    - **物理位置**：紧跟在被修饰的名词（先行词）之后。
                """.trimIndent())
            )),
            TextbookUnit("g9_u10", "Unit 10", "You're supposed to shake hands.", listOf(
                UnitDetailSection("📖 单元导读", "全球社交礼仪与文化习俗。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **be supposed to do** (应该做)
                    - 相当于 *should*。
                    
                    #### ② **relax / relaxed / relaxing**
                    - 形容词词法辨析 (-ed 修饰人, -ing 修饰物)。
                """.trimIndent())
            )),
            TextbookUnit("g9_u11", "Unit 11", "Sad movies make me cry.", listOf(
                UnitDetailSection("📖 单元导读", "情绪感知与事物对心理的影响。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### make 的使役用法
                    - **结构1**：*make sb. adj.* (使某人变得……)。
                    - **结构2**：*make sb. do sth.* (使某人做某事)。
                    - **陷阱**：在被动语态中，要还原 **to**。 *He was made to cry.*
                """.trimIndent())
            )),
            TextbookUnit("g9_u12", "Unit 12", "Life is full of the unexpected.", listOf(
                UnitDetailSection("📖 单元导读", "突发事件与生活反思。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 过去完成时 (Past Perfect) —— 过去的过去
                    - **结构**：**had + done**。
                    - **物理参照点**：在过去某动作之前已经完成。
                    - **标志词**：*by the time, before*.
                """.trimIndent())
            )),
            TextbookUnit("g9_u13", "Unit 13", "We're trying to save the earth!", listOf(
                UnitDetailSection("📖 单元导读", "环保责任与可持续发展（动名词用法）。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **recycle / reuse / reduce** (3R守则)
                    #### ② **be harmful to** (对……有害)
                """.trimIndent())
            )),
            TextbookUnit("g9_u14", "Unit 14", "I remember meeting all of you in Grade 7.", listOf(
                UnitDetailSection("📖 单元导读", "毕业季：成长回忆与未来愿景。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### remember doing vs remember to do
                    - **doing**: 记得做过某事 (已发生)。
                    - **to do**: 记得去做某事 (未发生)。
                """.trimIndent()),
                UnitDetailSection("📚 典句必背", """
                    - *It's time to say goodbye.*
                    - *Believe in yourself and never give up.*
                """.trimIndent())
            )
        )
    )
)
}
