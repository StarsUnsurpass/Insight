package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade7Up {
    val data = Textbook(
        id = "g7_up",
        grade = "七年级",
        term = "上册",
        coverColor = Color(0xFFE3F2FD),
        units = listOf(
            TextbookUnit(
                "g7up_u1", "Unit 1", "You and Me",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 2025新课标主题透视
                        *   **主题范畴**：人与自我 (Man and Self) —— 初次见面与自我介绍。
                        *   **核心逻辑**：构建社交信任的物理场，涵盖身份确认、国籍归属与兴趣同频。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解 (Vocabulary Focus)", """
                        #### ① **full** [fʊl] (adj. 完整的; 满的)
                        - **[教材详解]**：在介绍姓名时，*full name* 指“全名”。
                        - **[物理搭配]**：*be full of...* (满是……)。 
                        - **[例句]**：*Please tell me your full name, Alan Walker.*
                        
                        #### ② **make friends** (交朋友)
                        - **[物理核心]**：*friend* 必须用复数，表示社交的双向性。
                        - **[搭配]**：*make friends with sb.* (和某人交朋友)。
                        
                        #### ③ **get to know** (认识; 了解)
                        - **[逻辑过程]**：强调从陌生到熟悉的变化过程。
                        - **[例句]**：*Let's get to know each other better.*
                        
                        #### ④ **each other** (互相; 彼此)
                        - **[用法]**：通常作宾语。 *We help each other.*
                        
                        #### ⑤ **same** [seɪm] (adj. 相同的)
                        - **[物理标识]**：前面通常必须加定冠词 **the**。
                        - **[反义词]**：**different** (不同的)。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析 (Grammar Deep Dive)", """
                        #### 1. 系动词 be (am, is, are) 的物理场用法
                        初一英语的基石，必须掌握其在不同人称下的“磁通控制”：
                        - **口诀记忆**：我(I)用 **am**，你(you)用 **are**，**is** 跟着他(he)、她(she)、它(it)；单数用 **is**，复数全用 **are**。
                        - **句式变换逻辑**：
                          - 肯定句：主语 + be + 其他.
                          - 否定句：be 动词后加 **not**. 
                          - 疑问句：be 动词前置句首。
                    """.trimIndent()),
                    UnitDetailSection("🎯 2025年中考同步演练 (Exam Drill)", """
                        - *(2025 深圳模拟)*：My brother and I are in ________ school, but in different classes.
                          A. a same / B. same / C. the same / D. an same
                          **[解析]**：*same* 前必加 *the*，选 **C**。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u2", "Unit 2", "We're Family!",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **核心内容**：家庭成员关系、所属物品与日常互动。
                        *   **关键词**：`ping-pong bat`, `fishing rod`, `chess set`, `cousin`.
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇详析 (Vocabulary)", """
                        #### ① **spend time doing sth.** (花时间做某事)
                        - *I spend time playing chess with my uncle.*
                        
                        #### ② **a lot of / lots of** (许多)
                        - 后面可接可数名词复数或不可数名词。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法精析 (Grammar)", """
                        #### 1. 一般现在时 (to be, have/has)
                        - **have/has** 表示“拥有”。 *He has a football.*
                        
                        #### 2. 物主代词 (Possessive Adjectives)
                        - *my, your, his, her, its, our, their*。
                        - **物理位置**：必须放在名词之前。 *my father*.
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *What does family mean to you?*
                        - *Here's a photo of my family.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u3", "Unit 3", "My School",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **核心内容**：描述校园设施及其物理方位。
                        *   **关键词**：`dining hall`, `gym`, `whiteboard`, `across from`.
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法精析 (Grammar)", """
                        #### 1. "There be" 句型 (存留物理场)
                        - 表达“某处有某物”。
                        - **就近原则**：*There is a whiteboard and two desks.*
                        
                        #### 2. 方位介词 (Prepositions of Place)
                        - *in front of, behind, across from, near*.
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *The library is across from the classroom.*
                        - *There is a sports field behind the building.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u4", "Unit 4", "My Favourite Subject",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **核心内容**：学科偏好、理由表达及逻辑因果。
                        *   **关键词**：`subject`, `geography`, `biology`, `P.E.`, `reason`.
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析 (Grammar)", """
                        #### "Why" 与 "Because" 的逻辑锚定
                        - *Why* 提问，*Because* 回答。
                        - *Why do you like maths? — Because it's useful.*
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *What's your favourite subject?*
                        - *Biology is my favourite because it's interesting.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u5", "Unit 5", "Fun Clubs",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **核心内容**：社团活动、才艺展示与能力评估。
                        *   **关键词**：`chess club`, `act`, `paint`, `guitar`, `stories`.
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析 (Grammar)", """
                        #### 情态动词 "can" (物理常力场)
                        - 表示能力 (Ability)。
                        - **物性特征**：无谓数/人称变化，后接动词原形。
                        - *I can play chess.* / *Can you join us?*
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式", """
                        - *I am good at drawing.* (我擅长画画)。
                        - *Welcome to the music club!*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u6", "Unit 6", "A Day in the Life",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 主题情境透视
                        *   **核心内容**：描述作息规律 (Routine) 与精准时间表达。
                        *   **考察点**：时间表达法逻辑转换；频率副词。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解 (Vocabulary Focus)", """
                        #### ① **get up / go to school / go to bed**
                        *   **[固定搭配]**：日常动作短语，注意 **go to bed** 中不加 *the* (指睡觉这种物理状态)。
                        
                        #### ② **past / to** (时间物理路径)
                        *   **past**：表示“过”。 *8:10 -> ten past eight*。
                        *   **to**：表示“差”。 *9:50 -> ten to ten*。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析 (Grammar)", """
                        #### 1. 时间表达法的双重逻辑
                        1. **直接读法**：*7:05 (seven five)*。
                        2. **逆向读法**：
                          - 分钟 ≤ 30，用 **past**。
                          - 分钟 > 30，用 **to** (差……分钟到……点)。
                        
                        #### 2. 频率副词 (Frequency Adverbs)
                        - **always > usually > often > sometimes > never**.
                        - **物理位置**：行前 be 后。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u7", "Unit 7", "Happy Birthday!",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 核心话题
                        *   **主题语境**：月份、日期与生日活动。
                        *   **重点语法**：序数词 (Ordinal Numbers)；日期表达法。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解 (Vocabulary Focus)", """
                        #### ① **months** (12个月份全掌握)
                        *   **[背诵技巧]**：January, February 特殊记；September, October, November, December 规律性后缀。
                        
                        #### ② **date** (n. 日期)
                        - *What is the date today?* (今天是几号？)。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析 (Grammar)", """
                        #### 1. 序数词 (Ordinal Numbers) 物理缩写守则
                        *   **1st (first), 2nd (second), 3rd (third)**。
                        *   **[口诀]**：八去 t，九去 e (eighth, ninth)；ve 要用 f 替 (fifth, twelfth)；ty 变成 tie (twenty -> twentieth)。
                        
                        #### 2. 日期表达法 (Date format)
                        *   **[结构]**：Month + Day (序数词)。 *October 1st* (10月1日)。
                    """.trimIndent())
                )
            )
        )
    )
}
