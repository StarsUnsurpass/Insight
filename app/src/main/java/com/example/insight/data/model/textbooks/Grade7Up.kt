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
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：自我认识，结交新朋友，初次见面的社交礼仪与沟通策略 (Self-introduction & Making friends)。

                        ### 2. 单元主题内容
                        本单元作为七年级正式学习的起点，以“You and Me (你和我)”为核心，围绕“结交新朋友”这一真实社交情境展开。通过介绍自己的基本信息（如姓名、年龄、国籍、班级、外貌特征及兴趣爱好等），学习如何与他人进行破冰交流。同时，引导学生了解中外姓名文化的差异，培养跨文化交际意识，学会在新环境中尊重他人、建立和谐积极的人际关系，顺利完成从小学生到初中生的心理与社交过渡。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **核心名词**：name (名字), grade (年级), class (班级), country (国家), friend (朋友), mistake (错误), hobby (爱好), guitar (吉他), tennis (网球).
                        - **核心动词**：am/is/are (是), make (制作; 使), play (玩; 弹奏), get (得到), know (知道; 认识).
                        - **核心形/副**：full (完整的), same (相同的), different (不同的), English (英国的; 英语), new (新的).
                        - **高频短语**：full name (全名), make friends (交朋友), each other (互相), the same as (和...一样), play the guitar (弹吉他), be good at (擅长).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **介绍自己**：My name is... / I'm... I am 12 years old. I'm from China.
                        2.  **询问他人**：What's your name? / Where are you from? / How old are you?
                        3.  **表达爱好**：I like playing tennis. / My favourite sport is...
                        4.  **社交礼貌**：Nice to meet you. / Nice to meet you, too.

                        ### 3. 重点语法 (Key Grammar)
                        - **系动词 be (am, is, are)** 的一般现在时用法（肯定句、否定句、疑问句及简略回答）。
                        - **人称代词（主格）**（I, you, he, she, it, we, they）与 **形容词性物主代词**（my, your, his, her, its, our, their）的对应与用法。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        **Teng Fei**: Hello! I'm Teng Fei. What's your name?
                        **Peter**: Hi, Teng Fei. My name is Peter Brown.
                        **Teng Fei**: Nice to meet you, Peter.
                        **Peter**: Nice to meet you too. Where are you from?
                        **Teng Fei**: I'm from Beijing, China. And you?
                        **Peter**: I'm from London, the UK.
                        **Teng Fei**: Oh, we are in the same class! We are in Class 1, Grade 7.
                        **Peter**: Yes! Let's be friends.

                        **【译文】**
                        **腾飞**：你好！我是腾飞。你叫什么名字？
                        **彼得**：嗨，腾飞。我的名字是彼得·布朗。
                        **腾飞**：很高兴认识你，彼得。
                        **彼得**：我也很高兴认识你。你来自哪里？
                        **腾飞**：我来自中国北京。你呢？
                        **彼得**：我来自英国伦敦。
                        **腾飞**：哦，我们在同一个班！我们在七年级一班。
                        **彼得**：是的！让我们做朋友吧。

                        ### Section B (Reading) 阅读文段
                        **【原文】**
                        Hi, everyone! I am a new student here. My full name is Chen Jiaqi. You can call me Jiaqi. I am 13 years old. I am from Chengdu. I like music and I can play the guitar well. I also like sports. My favourite sport is tennis. I usually play tennis with my friends on weekends. I want to make friends with all of you. We can help each other and learn together.

                        **【译文】**
                        大家好！我是这里的一名新生。我的全名是陈家琪。你们可以叫我家琪。我13岁了。我来自成都。我喜欢音乐并且我吉他弹得很好。我也喜欢运动。我最喜欢的运动是网球。我通常在周末和朋友们打网球。我想和你们所有人都交朋友。我们可以互相帮助，共同学习。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译 (Key Sentences Deep Dive)", """
                        #### 1. What's your name? (你叫什么名字？)
                        - **【句式剖析】**：What's 是 What is 的缩写。用来询问对方的姓名。
                        - **【用法拓展】**：
                            *   回答时可用：`My name is...` 或 `I am / I'm...` 或直接说出名字。
                            *   如果询问第三人称的名字：`What's his/her name?` (他/她叫什么名字？)
                        
                        #### 2. Nice to meet you. (很高兴认识你。)
                        - **【句式剖析】**：初次见面时的标准问候语。meet 意为“遇见；相识”。
                        - **【用法拓展】**：回答时通常在句末加 too（也），即 `Nice to meet you, too.`（认识你我也很高兴）。注意 too 前面一般有逗号。如果在非初次见面时打招呼，常用 `Nice to see you.`

                        #### 3. Where are you from? (你来自哪里？)
                        - **【句式剖析】**：询问某人的国籍或籍贯。from 是介词，意为“来自...”。
                        - **【同义转换】**：`Where do you come from?` (此处 come 是实义动词，所以借用助动词 do)。
                        - **【答语】**：`I am from...` 或 `I come from...` (不能说 I am come from...)。
                        
                        #### 4. We are in the same class. (我们在同一个班。)
                        - **【句式剖析】**：in the same class 在同一个班。
                        - **【要点精讲】**：`same` (相同的) 前面必须加定冠词 `the`。其反义词是 `different` (不同的)，常用于 `be different from...` (与...不同)。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题 (Vocabulary Deep Dive)", """
                        #### ① full (adj. 完整的；满的)
                        - **【词汇梳理】**：读音 /fʊl/。反义词为 empty (空的)。
                        - **【词块归纳】**：
                            *   **full name** 全名 (由 First name 名 + Last/Family name 姓 组成)。
                            *   **be full of** 充满... (相当于 be filled with)。
                        - **【用法总结】**：作定语时修饰名词，如 a full box；作表语时接 of，如 The room is full of students.
                        - **【中考真题/例题】**：
                            *The glass is ________ water. You can drink it.*
                            A. fill with   B. full of   C. full with   D. fill of
                            **[解析]**：be full of = be filled with，意为“充满”，选 **B**。

                        #### ② grade (n. 年级；成绩)
                        - **【词汇梳理】**：读音 /ɡreɪd/。名词。
                        - **【词块归纳】**：
                            *   **in Grade 7** 在七年级。
                            *   **get good grades** 取得好成绩。
                        - **【用法总结】**：表示“在几年级几班”时，先说班级，后说年级，且首字母必须大写。如：in Class 1, Grade 7 (在七年级一班)。
                        - **【中考真题/例题】**：
                            *Tom is a new student. He is in ________.*
                            A. class 1, grade 7   B. Grade 7, Class 1   C. Class 1, Grade 7   D. grade 7, class 1
                            **[解析]**：英语中单位从小到大排列，且首字母需大写，选 **C**。

                        #### ③ make friends (交朋友)
                        - **【词汇梳理】**：friend 朋友 -> friendly (adj. 友好的) -> friendship (n. 友谊)。
                        - **【词块归纳】**：
                            *   **make friends with sb.** 和某人交朋友。
                            *   **be friendly to sb.** 对某人友好。
                        - **【用法总结】**：由于“交朋友”至少是两个人之间的事，所以 friend 必须用复数形式 friends。
                        - **【中考真题/例题】**：
                            *I want to make ________ with you. Are you willing?*
                            A. a friend   B. friend   C. friends   D. friendly
                            **[解析]**：固定搭配 make friends with，选 **C**。

                        #### ④ each other (互相；彼此)
                        - **【词汇梳理】**：代词短语，通常在句中作动词或介词的宾语。
                        - **【用法总结】**：
                            *   `help each other` 互相帮助
                            *   `learn from each other` 互相学习
                        - **【辨析】**：each other 通常指两者之间的互相；one another 通常指三者或三者以上的互相（但在现代英语中两者常可互换）。

                        #### ⑤ country (n. 国家)
                        - **【词汇梳理】**：读音 /ˈkʌntri/。复数形式为 **countries**。
                        - **【词块归纳】**：
                            *   **in the country** 在乡下 / 在国内。
                        - **【相关词汇】**：China, the UK, the US, Canada, Australia (国家名称首字母需大写)。

                        #### ⑥ classmate (n. 同班同学)
                        - **【词块归纳】**：class (班级) + mate (伙伴; 伴侣) = classmate。
                        - **【拓展】**：roommate (室友), schoolmate (校友), teammate (队友)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心一：系动词 be (am, is, are) 的全能用法
                        **1. 基本用法总结与口诀**
                        be 动词意为“是”，在一般现在时中有三种形式：am, is, are。其使用取决于句子的主语。
                        *   **【必背口诀】**：我 (I) 用 am，你 (you) 用 are，is 连着他 (he)、她 (she)、它 (it)。单数名词用 is，复数名词全用 are。

                        **2. 句型结构大盘点**
                        *   **【肯定句】**：主语 + be + 表语 (名词/形容词等).
                            *   *I am a student.* (我是一个学生。)
                            *   *He is tall.* (他很高。)
                        *   **【否定句】**：主语 + be + not + 表语.
                            *   *I am not (I'm not) a teacher.*
                            *   *She is not (isn't) from the UK.*
                        *   **【一般疑问句及简略回答】**：Be + 主语 + 表语?
                            *   *— Are you English?* (你是英国人吗？)
                            *   *— Yes, I am. / No, I'm not.* (注意：Yes 回答时，I am 不能缩写)
                            *   *— Is he your brother?*
                            *   *— Yes, he is. / No, he isn't.*

                        **3. 缩写形式 (Contractions)**
                        *   I am = I'm
                        *   You are = You're
                        *   He is = He's / She is = She's / It is = It's
                        *   is not = isn't / are not = aren't (注意：am not 没有连写的缩写形式，只能是 I'm not)

                        **4. 中考真题特训**
                        *   *(2023·北京中考)* *— Where ________ your pen pal from? — He ________ from Australia.*
                            A. is; is   B. are; is   C. is; are   D. are; are
                            **[解析]**：第一空主语 your pen pal (你的笔友) 是第三人称单数，用 is；第二空主语 He 也是单数，用 is。选 **A**。

                        ---

                        ### 语法核心二：人称代词与物主代词的归宿
                        **1. 人称代词（主格）**
                        *   用于在句子中作主语，通常放在句首或动词前。
                        *   单数：I (我), You (你), He (他), She (她), It (它)
                        *   复数：We (我们), You (你们), They (他/她/它们)

                        **2. 形容词性物主代词**
                        *   表示“某人的”，**相当于一个形容词，后面必须紧跟名词**，绝对不能单独使用！
                        *   单数：my (我的), your (你的), his (他的), her (她的), its (它的)
                        *   复数：our (我们的), your (你们的), their (他/她/它们的)
                        
                        **【黄金易错法则】**：
                        看见名词在后头，前面必选物主代词（my/your/his...）；若在句首做主语，果断选主格（I/you/he...）。

                        **3. 中考真题特训**
                        *   *(2024·山东中考)* *This is my new friend. ________ name is Tom and ________ is a nice boy.*
                            A. His; his   B. His; he   C. He; his   D. He; he
                            **[解析]**：第一空修饰名词 name，需用形容词性物主代词 His (他的)；第二空在句子中作主语，需用人称代词主格 he (他)。选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：Introducing yourself (自我介绍)
                        本单元的写作核心是能够在新学期向同学或朋友书面介绍自己的基本信息（姓名、年龄、国籍、班级、喜好等），并表达结交朋友的愿望。

                        #### 1. 写作思路导图 (Mind Map)
                        *   **Opening (开篇问候)**：Hello / Hi everyone!
                        *   **Basic Info (基本信息)**：Name, Age, Country/City, Grade/Class.
                        *   **Hobbies (兴趣爱好)**：I like... / My favourite... is... / I am good at...
                        *   **Closing (结尾期望)**：I want to make friends with you. / Nice to meet you.

                        #### 2. 必备高级词汇与佳句 (Golden Sentences)
                        *   *Let me introduce myself to you.* (让我向你们介绍一下我自己。)
                        *   *I am an outgoing and friendly boy/girl.* (我是一个外向且友好的男孩/女孩。)
                        *   *In my free time, I usually...* (在我的空闲时间，我通常...)
                        *   *I hope we can be good friends and help each other.* (我希望我们能成为好朋友并互相帮助。)

                        #### 3. 满分范文赏析 (High-Score Model Essay)
                        **Hello, everyone!**
                        Let me introduce myself. **My full name is** Zhang Yuhang, and you can call me Yuhang. **I am 13 years old.** **I am from** Shanghai, China. Now, **I am a middle school student in Class 3, Grade 7.** 
                        I am an active boy. **I like** sports very much, and **my favourite sport is** basketball. I often play it with my classmates after school. I am also **good at** English. 
                        I am very happy to be here. **I hope I can make friends with all of you.** We can learn and play together. **Thank you!**

                        **【名师点评】**：
                        这篇自我介绍逻辑清晰，分段合理。第一段交代了姓名、年龄、籍贯和班级等硬指标；第二段补充了性格、爱好和特长，使人物形象立体丰满；第三段表达了交友的良好意愿。运用了 "be good at", "make friends with" 等核心短语，完全符合七年级上册 Unit 1 的大纲要求！
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
