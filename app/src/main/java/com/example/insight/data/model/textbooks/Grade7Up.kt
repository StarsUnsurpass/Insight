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
                        *   **主题范畴**：人与自我 (Man and Self) —— 生活与学习。
                        *   **核心内容**：初次见面时的社交策略（Self-introduction & Making friends）。
                        *   **核心素养发展**：
                            - **语言能力**：掌握介绍及询问个人信息（姓名、年龄、籍贯、班级、爱好）的句式。
                            - **文化意识**：了解中西方姓名表达差异（Family name vs First name）及初次见面的礼仪技巧。
                            - **思维品质**：学会通过提问（Where, How old, What）快速建立社交联系并发现共同点。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇金牌解析 (Vocabulary Deep Dive)", """
                        #### ① **full** /fʊl/ (adj. 完整的; 满的)
                        - **【教材详解】**：在介绍姓名时，*full name* 指包含姓和名的“全名”。
                        - **【用法视角】**：
                          1. **full name** 全名。西方人：*First Name* (名) + *Last Name* (姓)。
                          2. **be full of...** 充满…… (= *be filled with*)。
                        - **【考点提醒】**：在填表或正式场合，*full name* 需准确写出。
                        - **【例句】**：*Please write down your full name on the paper.*
                        
                        #### ② **grade** /ɡreɪd/ (n. 年级; 成绩)
                        - **【金牌语法】**：
                          1. **in Grade 7** 在七年级。注意：表示“在...年级”用介词 **in**，Grade 首字母大写，后面接基数词。
                          2. **get good grades** 取得好成绩。
                        - **【关联记忆】**：*classmate* (同班同学) = *class* + *mate* (伙伴)。
                        
                        #### ③ **make friends** (交朋友)
                        - **【核心逻辑】**：*friend* 必须用复数，因为“交朋友”是双向的行为。
                        - **【必背短语】**：**make friends with sb.** 与某人交朋友。
                        - **【例句】**：*I want to make friends with students from all over the world.*
                        
                        #### ④ **each other** (互相; 彼此)
                        - **【句法用法】**：通常在句中作宾语。
                        - **【精微辨析】**：*each other* 多用于两者之间，*one another* 用于三者及以上。
                        
                        #### ⑤ **same** /seɪm/ (adj. 相同的)
                        - **【黄金法则】**：前面必须加定冠词 **the**。
                        - **【反义词】**：**different** (不同的)。固定搭配：*be different from* (与……不同)。
                        - **【例句】**：*They are in the same class, but they like different colors.*
                        
                        #### ⑥ **country** /ˈkʌntri/ (n. 国家)
                        - **【词形变化】**：复数形式为 **countries** (变y为i加es)。
                        - **【相关词汇】**：*population* (人口), *flag* (国旗)。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 核心语法·三维精讲 (Grammar Master)", """
                        ### 1. be 动词 (am, is, are) 的全能用法
                        be 动词是初一英语最重要的基石，形式随主语变化：
                        - **【助记口诀】**：
                          - 我(I)用 **am**，你(you)用 **are**，**is** 跟着他(he)、她(she)、它(it)；
                          - 单数主语用 **is**，复数主语全用 **are**。
                        - **【句式变换逻辑】**：
                          - **肯定句**：*He is from the UK.*
                          - **否定句**：*He is not from the UK.* (be后加not)
                          - **疑问句**：*Is he from the UK?* (be前移) -> *Yes, he is. / No, he isn't.*
                        
                        ### 2. 人称代词与物主代词的归宿
                        - **主格 (Subject Pronouns)**：I, You, He, She, It, We, They (作主语，通常放在句首)。
                        - **形容词性物主代词 (Possessive Adjectives)**：My, Your, His, Her, Its, Our, Their。
                          - **用法关键**：后面必须跟名词！*My name*, *Your class*.
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句式深度解析 (Key Sentences)", """
                        #### 1. 自我介绍及其逻辑
                        - **My name is... / I'm...** (我是...)
                        - **I'm 13 years old.** (我13岁了)
                        - **I'm in Class 1, Grade 7.** (我在七年级一班)
                        - **【解惑】**：英语地址由小到大：Class -> Grade -> School -> City -> Country。
                        
                        #### 2. 询问来源的两种路径
                        - **Where are you from?** (are是系动词)
                        - **Where do you come from?** (come是实义动词)
                        - **【错题预警】**：千万不能混搭成 *Where are you come from?* (×)
                        
                        #### 3. 表示兴趣爱好
                        - **I like football.** (我喜欢足球)
                        - **My favourite subject is maths.** (数学是我最喜欢的科目)
                    """.trimIndent()),
                    UnitDetailSection("📝 写作专题：Introducing Yourself (写作导航)", """
                        - **【写作要求】**：开学初次见面，通过介绍自己结交新朋友。
                        - **【精选素材】**：
                          - *get to know each other* 互相了解
                          - *Nice to meet you.* 见到你很高兴
                          - *look forward to...* 期待……
                        - **【高分范文】**：
                          *Hello everyone! My name is Li Hua. I'm thirteen years old. I'm from Beijing, China. I'm in Class 2, Grade 7. I am good at English and music. My favourite sport is ping-pong. I'm very happy to meet you all and I hope we can be good friends. Thank you!*
                    """.trimIndent()),
                    UnitDetailSection("🎯 2024-2025 中考考点模拟 (Exam Drill)", """
                        - **【考点1：代词辨析】**
                          *   *Look at that girl. ________ name is Lucy.*
                              A. She  B. Her  C. He  D. His
                              **[解析]**：修饰名词 *name*，用形容词性物主代词，指代女孩，选 **B**。
                        
                        - **【考点2：be动词用法】**
                          *   *My parents ________ teachers in this school.*
                              A. am  B. is  C. are  D. be
                              **[解析]**：主语 *My parents* 是复数，选 **C**。
                        
                        - **【考点3：same及其冠词】**
                          *   *We are in ________ same school.*
                              A. a  B. an  C. the  D. /
                              **[解析]**：*same* 词前常有 *the* 守护，选 **C**。
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
