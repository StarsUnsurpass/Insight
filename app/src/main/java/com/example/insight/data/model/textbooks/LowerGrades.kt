package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade7Down {
    val data = Textbook(
        id = "g7_down",
        grade = "七年级",
        term = "下册",
        coverColor = Color(0xFFF1F8E9),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc7x_2025/coverbig.jpg",
        units = listOf(
            TextbookUnit("g7d_u1", "Unit 1", "Can you play the guitar?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 2025新课标主题透视
                    *   **主题范畴**：个人特长与意愿。
                    *   **核心内容**：谈论能力 (Abilities) 与加入社团。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇金牌解析", """
                    #### ① **play the guitar / chess**
                    - **乐器类**：加 **the**。
                    - **球类/棋类**：**不加** the。
                    
                    #### ② **speak / tell / say / talk**
                    - **speak**: 语言。 **tell**: 故事。 **say**: 内容。 **talk**: 交谈。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 情态动词 "can" (能力场)
                    - 无谓数人称变化，后接动词原形。
                """.trimIndent())
            )),
            TextbookUnit("g7d_u2", "Unit 2", "What time do you go to school?", listOf(
                UnitDetailSection("📖 单元导读", "日常作息规律与时间物理对标。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 频率副词 (Frequency Adverbs)
                    - **always > usually > often > sometimes > never**.
                    - **物理位置**：行前 be 后。
                """.trimIndent())
            )),
            TextbookUnit("g7d_u3", "Unit 3", "How do you get to school?", listOf(
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **by train / take the bus**
                    - **by + 交通工具** (无冠词)；**take the + 交通工具** (有冠词)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### It takes sb. some time to do sth.
                    - 花费某人多少时间做某事（固定公式）。
                """.trimIndent())
            )),
            TextbookUnit("g7d_u4", "Unit 4", "Don't eat in class.", listOf(
                UnitDetailSection("📖 单元导读", "校园及家庭规则 (Rules)。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 祈使句 (Imperatives)
                    - 肯定常用动词原形，否定开头用 **Don't**。
                """.trimIndent())
            )),
            TextbookUnit("g7d_u5", "Unit 5", "Why do you like pandas?", listOf(
                UnitDetailSection("📖 单元导读", "动物偏好与因果逻辑。"),
                UnitDetailSection("⚙️ 核心语法精析", """
                    #### Why 与 Because 的逻辑闭环
                """.trimIndent())
            )),
            TextbookUnit("g7d_u6", "Unit 6", "I'm watching TV.", listOf(
                UnitDetailSection("📖 单元导读", "现在进行时 (Present Continuous)。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    #### am/is/are + v-ing
                """.trimIndent())
            )),
            TextbookUnit("g7d_u7", "Unit 7", "It's raining!", listOf(
                UnitDetailSection("📖 单元导读", "描述天气与大众活动。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    #### How is the weather? = What's the weather like?
                """.trimIndent())
            )),
            TextbookUnit("g7d_u8", "Unit 8", "Is there a post office near here?", listOf(
                UnitDetailSection("📖 单元导读", "街道物理空间位置。"),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    #### There be 句型 (就近原则)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u9", "Unit 9", "What does he look like?", listOf(
                UnitDetailSection("📖 单元导读", "人物外貌描述模型。"),
                UnitDetailSection("⚙️ 核心语法精析", """
                    #### is (体型/身高) vs has (特征/头发)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u10", "Unit 10", "I'd like some noodles.", listOf(
                UnitDetailSection("📖 单元导读", "餐厅订餐、点菜。"),
                UnitDetailSection("⚙️ 核心语法精析", """
                    #### would like to do / would like sth.
                """.trimIndent())
            )),
            TextbookUnit("g7d_u11", "Unit 11", "How was your school trip?", listOf(
                UnitDetailSection("📖 单元导读", "一般过去时 (Simple Past) - be动词场。")
            )),
            TextbookUnit("g7d_u12", "Unit 12", "What did you do last weekend?", listOf(
                UnitDetailSection("📖 单元导读", "一般过去时 (Simple Past) - 实义动词场。")
            ))
        )
    )
}

object Grade8Down {
    val data = Textbook(
        id = "g8_down",
        grade = "八年级",
        term = "下册",
        coverColor = Color(0xFFFFF3E0),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc8x_2026/coverbig.jpg",
        units = listOf(
            TextbookUnit("g8d_u1", "Unit 1", "What's the matter?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 2025新课标主题透视
                    *   **主题范畴**：人与自我 —— 健康管理与安全救援。
                    *   **核心内容**：表述身体不适，给出急救建议。
                    *   **考点分布**：have a + 疾病名称；情态动词 should；反身代词的使用。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇金牌解析", """
                    #### ① **stomachache / headache / toothache**
                    - **【规律】**：部位 + **-ache** (疼痛)。
                    
                    #### ② **reflexive pronouns** (反身代词)
                    - *himself, herself, yourself, themselves...*
                    - **物理逻辑**：主语和宾语指代同一人。
                    
                    #### ③ **take one's temperature** (量体温)
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 1. should / shouldn't 给出建议
                    - *You should lie down and rest.*
                    
                    ### 2. enough (足够的)
                    - **物理位置**：修饰形容词后置 (*good enough*)；修饰名词前置 (*enough water*)。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u2", "Unit 2", "I'll help to clean up the city parks.", listOf(
                UnitDetailSection("📖 单元导读", """
                    *   **内容**：志愿服务 (Volunteering) 与社区贡献。
                    *   **核心**：动词短语的拆分法则；used to 表达过去。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### Phrasal Verbs (动词+副词)
                    - **【磁场效应】**：*cheer up, give away, pick up*.
                    - **特殊点**：当宾语是代词 (*it, them*) 时，必须放在两者**中间**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 1. used to do sth. (过去常常)
                    - 表示过去存在的状态。
                    
                    ### 2. 动词不定式做目的状语
                    - *I want to help poor students to get an education.*
                """.trimIndent())
            )),
            TextbookUnit("g8d_u3", "Unit 3", "Could you please clean your room?", listOf(
                UnitDetailSection("📖 单元导读", "家务协作与委婉请求。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### borrow vs lend vs keep
                    - **borrow**: 借入 (非延续)。
                    - **lend**: 借出 (非延续)。
                    - **keep**: 保存 (可延续，常与 since/for 连用)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 委婉请求的礼貌层级
                    - **Could you please...?** (表示礼貌，非过去时)。
                    - 肯定回答：*Yes, sure. / No problem.*
                    - 否定回答：*I'm sorry, I can't. I have to...*
                """.trimIndent())
            )),
            TextbookUnit("g8d_u4", "Unit 4", "Why don't you talk to your parents?", listOf(
                UnitDetailSection("📖 单元导读", "生活压力、矛盾纠纷与心理疏导。"),
                UnitDetailSection("⚙️ 语法精析", """
                    ### 提建议的多种物理路径
                    1. *Why don't you do...?*
                    2. *Why not do...?*
                    3. *How about doing...?*
                    4. *You should...*
                """.trimIndent()),
                UnitDetailSection("📚 核心句式", """
                    - **You should talk to them.**
                    - **What's the matter?**
                    - **Don't compete with others too much.**
                """.trimIndent())
            )),
            TextbookUnit("g8d_u5", "Unit 5", "What were you doing when the rainstorm came?", listOf(
                UnitDetailSection("📖 单元导读", "重大瞬间的叙事背景（过去进行时）。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### when vs while
                    - **when**: 后跟瞬间动作或时间点。
                    - **while**: 后跟延续动作或时间轴。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 过去进行时 (Past Continuous)
                    - **结构**：**was/were + v-ing**。
                    - **物理场**：强调过去某一特定时刻或时间段正在发生的动作。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u6", "Unit 6", "An old man tried to move the mountains.", listOf(
                UnitDetailSection("📖 单元导读", "寓言故事、神话传说与哲学启迪。"),
                UnitDetailSection("⚙️ 语法精析", """
                    ### 1. unless (除非)
                    - 引导条件状语，相当于 *if ... not*。
                    
                    ### 2. as soon as (一……就)
                    - **主将从现 (I)**：从句用一般现在时态表达将来意图。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u7", "Unit 7", "What's the highest mountain in the world?", listOf(
                UnitDetailSection("📖 单元导读", "世界地理之最与环境保护。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **the size of** (……的大小)
                    #### ② **as far as I know** (据我所知)
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    ### 比较级与最高级的进阶应用
                    - **最高级**：*the + ...est / most ...*。
                    - **比较级表达最高级**：*higher than any other mountain*.
                """.trimIndent())
            )),
            TextbookUnit("g8d_u8", "Unit 8", "Have you read Treasure Island yet?", listOf(
                UnitDetailSection("📖 单元导读", "阅读习惯、艺术偏好与体验沉淀（现在完成时）。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### already vs yet
                    - **already**: 用于肯定陈述。
                    - **yet**: 用于疑问/否定，由于期待动作发生而处于观测态。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 现在完成时 (Present Perfect) I
                    - **结构**：**have/has + 过去分词 (done)**。
                    - **物理意义**：过去发生的动作对现在产生的影响或后果。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u9", "Unit 9", "Have you ever been to a museum?", listOf(
                UnitDetailSection("📖 单元导读", "旅行地点打卡与经历分享。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### been to vs gone to
                    - **have been to**: 去过某地（现在已不在此处）。
                    - **have gone to**: 去了某地（现在可能在途中或目的地）。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u10", "Unit 10", "I've had this bike for three years.", listOf(
                UnitDetailSection("📖 单元导读", "家乡记忆、旧物断舍离与延续感。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### since vs for (时间段法则)
                    - **for + 时间长度**。
                    - **since + 动作起始点/从句**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 瞬间动词的延续性映射
                    - *buy* -> **have had**; *borrow* -> **have kept**.
                    - 在包含 *since/for* 的现在完成时中，动词必须是延续性的。
                """.trimIndent())
            ))
        )
    )
}
