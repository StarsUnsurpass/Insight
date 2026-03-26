package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade7Up {
    val data = Textbook(
        id = "g7_up",
        grade = "七年级",
        term = "上册",
        coverColor = Color(0xFFE3F2FD),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc7s_2024/coverbig.jpg",
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
                        ### 1. 主题情境透义
                        *   **核心内容**：介绍家庭成员关系，描述家庭合影。
                        *   **主题范畴**：人与自我 —— 家庭生活与和谐氛围。
                        *   **考点分布**：名词所有格；物主代词的进阶应用；have/has 的拥有逻辑。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇知识详解 (Vocabulary)", """
                        #### ① **spend time** (花时间; 度过时光)
                        - **【结构锚定】**：**spend time (in) doing sth.** (花时间做某事) / **spend time with sb.** (和某人共度时光)。
                        - **【对比】**：*It takes sb. some time to do sth.* (固定搭配对比)。
                        
                        #### ② **photo** /ˈfəʊtəʊ/ (n. 照片)
                        - **【复数】**：**photos** (直接加s)。
                        - **【词组】**：*a photo of my family* (一张我的全家福)。
                        
                        #### ③ **play chess** (下国际象棋)
                        - **【语法点】**：棋类、球类运动名词前**不加**冠词 *the*。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法精讲 (Grammar Master)", """
                        ### 1. 名词所有格 (Possessive Nouns)
                        表示“……的”物理所属关系。
                        - **【单数形式】**：名词 + **'s**。 *Tom's pen*.
                        - **【复数形式】**：
                          - 以s结尾的复数名词只加 **'**。 *students' books*.
                          - 不以s结尾的复数名词加 **'s**。 *women's day*.
                        
                        ### 2. have/has 的“磁力场”用法
                        表达物理拥有或关系归属。
                        - **have**：用于第一、二人称及复数。 *I have a sister.*
                        - **has**：用于第三人称单数。 *She has a big dog.*
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式深度解析", """
                        - **Who is she?** (询问身份) -> *She is my aunt.*
                        - **This is a photo of my family.** (介绍照片内容)
                        - **What is your father's job?** (询问职业的另一种表达)
                    """.trimIndent()),
                    UnitDetailSection("📝 写作专项：My Family (家庭介绍)", """
                        - **【必背句型】**：
                          - *There are ... people in my family.*
                          - *My father is a/an ...*
                          - *I love my family.*
                        - **【范文片段】**：*I have a big family. My parents are both teachers. I often spend time playing games with my brother...*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u3", "Unit 3", "My School",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 核心主题
                        *   **内容**：描述校园建筑设施及其方位。
                        *   **重点**：*There be* 句型；方位介词；祈使句引导路径。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇金牌解析", """
                        #### ① **across from** (在……对面)
                        - **【物理方位】**：指在街道、走廊等空间的另一侧。
                        - **【例句】**：*The library is across from the teachers' office.*
                        
                        #### ② **between... and...** (在两者之间)
                        - **【逻辑点】**：必须连接的是两个具体的物理坐标点。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法精析", """
                        ### 1. There be 句型的“就近原则”
                        表示“在某处存在某物”。
                        - **结构**：*There is (单数/不可数) / There are (复数) ...*
                        - **核心点**：当并列多个主语时，be 动词形式由离它**最近**的那个名词决定。
                          - *There **is** a desk and two chairs.*
                          - *There **are** two chairs and a desk.*
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句式详解", """
                        - **Where is the sports field?** (询问具体地点)
                        - **How many classrooms are there in your school?** (询问数量)
                        - **Go down the hallway and turn left.** (路径指引)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u4", "Unit 4", "My Favourite Subject",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 核心话题
                        *   **领域**：学科选择与个人理由。
                        *   **考点**：Why 疑问句及其逻辑答语；表心理感受的形容词辨析。
                    """.trimIndent()),
                    UnitDetailSection("🔤 词汇深度剖析", """
                        #### ① **favourite** (adj. 最喜爱的)
                        - **【用法】**：通常放在名词前。 *favourite subject*.
                        - **【等价转换】**：*like ... best*.
                        
                        #### ② **interesting vs boring** (有趣 vs 乏味)
                        - **【物理控制】**：描述客观事物的性质，赋予事物“吸引力”或“枯燥性”。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法精讲", """
                        ### Why 与 Because 的逻辑因果锚定
                        - **Why** 引导特殊疑问句，探究原因。
                        - **Because** 引导陈述句，给出理由。
                        - **【考场禁忌】**：在同一个句子中，**Because** 和 **So** 绝对不能同时出现（逻辑重叠）。
                    """.trimIndent()),
                    UnitDetailSection("📚 核心句式解析", """
                        - **What's your favourite subject?** (询问最喜欢的学科)
                        - **Why do you like geography? — Because it's useful.** (因果连横)
                        - **When is your maths lesson?** (询问课程时间)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u5", "Unit 5", "Fun Clubs",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 主题情境
                        *   **内容**：各色社团招新，个人才艺展示。
                        *   **重点**：情态动词 can 表达能力；want to 句型表达意愿。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇详析", """
                        #### ① **join** (参加; 加入)
                        - **【用法】**：指加入某个社团或组织。 *join the art club*.
                        
                        #### ② **be good at** (擅长)
                        - **【固定搭配】**：后接动词需用 **-ing** 形式。 *be good at drawing*.
                        - **【同义转换】**：*do well in*.
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法精讲", """
                        ### 情态动词 "can" 的能力立场
                        - **【物理属性】**：
                          1. 无人称和数的变化 (He can, I can, They can)。
                          2. 后面必须接**动词原形**。
                        - **【否定形式】**：*cannot / can't*.
                        - **【疑问形式】**：*Can you ...?*
                    """.trimIndent()),
                    UnitDetailSection("📚 高频句式解析", """
                        - **What club do you want to join?** (询问加入意图)
                        - **I can sing and dance.** (个人能力陈述)
                        - **Please help us with the music festival!** (请求协助)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u6", "Unit 6", "A Day in the Life",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        *   **核心内容**：时间表达法（精准制导）与作息规律描述。
                        *   **语法重点**：频率副词的物理分布；时间介词 (at, on, in)。
                    """.trimIndent()),
                    UnitDetailSection("🔤 词汇金牌解析", """
                        #### ① **usually / often / sometimes** (频率副词)
                        - **【频率梯度】**：*always (100%) > usually (80%) > often (60%) > sometimes (30%) > never (0%)*。
                        
                        #### ② **time expressions** (时间表达)
                        - **quarter** (刻钟; 15分钟)；**half** (一半; 30分钟)。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法精析", """
                        ### 1. 时间表达法的双重逻辑
                        1. **顺读法**：先小时后分钟。 *8:15 -> eight fifteen*.
                        2. **逆读法**：
                           - 分钟 ≤ 30，用 **past** (过)。 *8:20 -> twenty past eight*.
                           - 分钟 > 30，用 **to** (差)。 *8:50 -> ten to nine*.
                        
                        ### 2. 频率副词的“行前 be 后”位置
                        - *I **usually** get up at 6:30.* (动词前)
                        - *He **is** always happy.* (be动词后)
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句式详解", """
                        - **What time do you usually go to bed?** (询问具体作息)
                        - **It's time for breakfast.** (该做某事的时间了)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u7", "Unit 7", "Happy Birthday!",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 主题情境
                        *   **内容**：月份、日期、生日派对及价格询问。
                        *   **重点**：序数词的构建与缩写；介词在日期中的精准应用。
                    """.trimIndent()),
                    UnitDetailSection("🔤 核心词汇详析", """
                        #### ① **months** (十二个月份)
                        - **【注意】**：月份单词的首字母**必须大写**。
                        
                        #### ② **price / how much**
                        - **【金牌词句】**：*What is the price of this pen?* = *How much is this pen?*
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 单元语法点精析", """
                        ### 1. 序数词 (Ordinal Numbers) 的构建逻辑
                        用于表示物理顺序或日期。
                        - **【必背口诀】**：一二三，特殊记 (first, second, third)；八去 t，九去 e (eighth, ninth)；ve 要用 f 替 (fifth, twelfth)；ty 变成 tie (twenty -> twentieth)；以上若遇几十几，只变个位就可以。
                        
                        ### 2. 日期表达中的“介词守则”
                        - **at**：用于具体的时间时刻。 *at 7 o'clock*.
                        - **on**：用于具体的一天或日期。 *on May 1st*.
                        - **in**：用于月份、季节、年份等大时间段。 *in June*.
                    """.trimIndent()),
                    UnitDetailSection("📚 高频句式解析", """
                        - **When is your birthday?** (询问生日)
                        - **My birthday is on October 10th.** (回答具体日期)
                        - **How old are you?** (询问年龄)
                    """.trimIndent())
                )
            )
        )
    )
}
