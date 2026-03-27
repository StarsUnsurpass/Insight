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

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What's your name? (你叫什么名字？)
                        - **【句式剖析】**：What's 是 What is 的缩写。用来询问对方的姓名。
                        - **【用法拓展】**：回答时可用：`My name is...` 或 `I am / I'm...` 或直接说出名字。
                        
                        #### 2. Nice to meet you. (很高兴认识你。)
                        - **【句式剖析】**：初次见面时的标准问候语。meet 意为“遇见；相识”。
                        - **【用法拓展】**：回答时通常在句末加 too（也），即 `Nice to meet you, too.`
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① full (adj. 完整的；满的)
                        - **【词块归纳】**：**full name** 全名；**be full of** 充满...。
                        - **【中考真题/例题】**：
                        
                        *The glass is ________ water. You can drink it.*
                        A. fill with   B. full of   C. full with   D. fill of
                        
                        **[解析]**：be full of = be filled with，意为“充满”，选 **B**。

                        #### ② grade (n. 年级；成绩)
                        - **【词块归纳】**：**in Grade 7** 在七年级；**get good grades** 取得好成绩。
                        - **【中考真题/例题】**：
                        
                        *Tom is a new student. He is in ________.*
                        A. class 1, grade 7   B. Grade 7, Class 1   C. Class 1, Grade 7   D. grade 7, class 1
                        
                        **[解析]**：英语中单位从小到大排列，且首字母需大写，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心一：系动词 be (am, is, are) 的全能用法
                        **1. 基本用法总结与口诀**
                        *   **【必背口诀】**：我 (I) 用 am，你 (you) 用 are，is 连着他 (he)、她 (she)、它 (it)。单数名词用 is，复数名词全用 are。

                        **2. 中考真题特训**
                        
                        *(2023·北京中考)* *— Where ________ your pen pal from? — He ________ from Australia.*
                        A. is; is   B. are; is   C. is; are   D. are; are
                        
                        **[解析]**：第一空主语 your pen pal 是第三人称单数，用 is；第二空主语 He 也是单数，用 is。选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：Introducing yourself (自我介绍)
                        **Hello, everyone!**
                        
                        Let me introduce myself. **My full name is** Zhang Yuhang, and you can call me Yuhang. **I am 13 years old.** **I am from** Shanghai, China. Now, **I am a middle school student in Class 3, Grade 7.** 
                        
                        I am an active boy. **I like** sports very much, and **my favourite sport is** basketball. I often play it with my classmates after school. I am also **good at** English. 
                        
                        I am very happy to be here. **I hope I can make friends with all of you.** We can learn and play together. **Thank you!**
                    """.trimIndent())
                )
            ),


            TextbookUnit(
                "g7up_u2", "Unit 2", "We're Family!",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：家庭与家庭生活 (Family life)
                        *   **子主题**：向他人介绍家庭成员，描述家庭照片，体会家庭温暖 (Introducing family members)。

                        ### 2. 单元主题内容
                        本单元以“We're Family! (我们是一家人！)”为主题，旨在引导学生学习如何介绍家庭成员及描述人际关系。通过辨认照片中的人物、讨论家庭成员的职业和爱好，学生不仅能掌握亲属称谓（如 grandfather, aunt, cousin 等），还能学会使用名词所有格和 have/has 来表达所属关系。本单元强调家庭在个人成长中的重要性，鼓励学生关爱家人，构建和谐的家庭氛围。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **亲属称谓**：grandfather (祖父), grandmother (祖母), parents (父母), uncle (伯/叔/舅), aunt (伯母/婶母/姨母), cousin (堂/表兄弟姊妹), son (儿子), daughter (女儿).
                        - **核心动词**：have/has (有), spend (花时间), cook (烹饪), go (去), watch (看).
                        - **核心名词/形容词**：photo (照片), job (工作), heart (心), beautiful (美丽的), pink (粉红色的).
                        - **高频短语**：a photo of... (一张...的照片), spend time with... (和...度过时光), play chess (下棋), in the middle (在中间), family tree (家谱).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问身份**：Who's he/she? / Who are they?
                        2.  **介绍成员**：This is my father. / These are my grandparents.
                        3.  **描述所属**：I have a big family. / She has a sister. / This is my father's bike.
                        4.  **表达感受**：I love my family. / They are very kind.

                        ### 3. 重点语法 (Key Grammar)
                        - **名词所有格**（'s 所有格）的构成与用法。
                        - **动词 have/has** 的一般现在时用法及其在人称变化下的切换。
                        - **复数名词**的规则与不规则变化（如 photo -> photos, man -> men）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teng Fei**: Who's the boy in the photo?
                        
                        **Fu Xing**: He's my cousin. His name is Li Ming.
                        
                        **Teng Fei**: Is this your aunt?
                        
                        **Fu Xing**: Yes, it is. Her name is Li Hua. She is a teacher.
                        
                        **Teng Fei**: What's your father's job?
                        
                        **Fu Xing**: He is a doctor. He is very busy but he often spends time with us.

                        **【译文】**
                        
                        **腾飞**：照片里的那个男孩是谁？
                        
                        **复兴**：他是我表弟。他的名字叫李明。
                        
                        **腾飞**：这是你姨妈吗？
                        
                        **复兴**：是的。她的名字叫李华。她是一名老师。
                        
                        **腾飞**：你爸爸的工作是什么？
                        
                        **复兴**：他是一名医生。他很忙，但他经常和我们在一起。

                        ### Section B (Reading) 阅读文段：My Family
                        **【原文】**
                        
                        Look at this photo. This is my family. My grandparents are in the middle. They are very old but very healthy. My father is standing on the left. He is tall. He likes playing football. My mother is next to him. She is beautiful and she cooks very well. I have a little brother. He is only 5 years old. We love each other. I am very happy in my family.

                        **【译文】**
                        
                        看这张照片。这是我的家人。我的爷爷奶奶在中间。他们虽然年纪大了，但非常健康。我爸爸站在左边。他很高。他喜欢踢足球。我妈妈在他旁边。她很漂亮，而且做饭非常好吃。我有一个小弟弟。他才5岁。我们彼此相爱。我在我的家庭里非常幸福。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Who's the boy in the photo? (照片里的男孩是谁？)
                        - **【句式剖析】**：`Who's` 是 `Who is` 的缩写。`in the photo` 是介词短语作定语，修饰 `the boy`。
                        - **【用法拓展】**：询问人的身份时用 `Who`。回答通常用 `He/She is...` 或 `They are...`
                        
                        #### 2. He often spends time with us. (他经常花时间和我们在一起。)
                        - **【句式剖析】**：`spend time with sb.` 意为“和某人度过时光”。
                        - **【用法拓展】**：`spend` 的主语必须是人。
                            *   `spend ... on sth.` (在某事上花时间/钱)
                            *   `spend ... (in) doing sth.` (花时间/钱做某事)
                        
                        #### 3. My mother is next to him. (我妈妈在他旁边。)
                        - **【句式剖析】**：`next to` 意为“紧邻；在...旁边”，相当于 `beside`。
                        
                        #### 4. This is a photo of my family. (这是一张我的全家福。)
                        - **【要点精讲】**：`a photo of...` 意为“一张...的照片”。注意区分 `my family photo` (我的家庭照片) 和 `a photo of my family`。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① photo (n. 照片)
                        - **【词汇梳理】**：复数形式为 **photos** (直接加s)。
                        - **【例题】**：
                        
                        *I have two ________ of my sisters.*
                        A. photoes   B. photo   C. photos   D. a photo
                        
                        **[解析]**：two 后面接名词复数，photo 的复数是 photos，选 **C**。

                        #### ② parents (n. 父母)
                        - **【用法总结】**：
                            *   `parent` 指父亲或母亲其中一人。
                            *   `parents` 指父亲和母亲两人。
                        - **【中考真题/例题】**：
                        
                        *Both of my ________ are doctors.*
                        A. parent   B. parents   C. father   D. mother
                        
                        **[解析]**：both (两者都) 提示需用复数，选 **B**。

                        #### ③ job (n. 工作) vs work (v./n. 工作)
                        - **【辨析】**：`job` 是可数名词，指具体职业；`work` 常用作不可数名词，指抽象的劳动。
                        - **【中考真题/例题】**：
                        
                        *My father has a good ________ in a big bank.*
                        A. work   B. jobs   C. job   D. worker
                        
                        **[解析]**：a 提示用单数可数名词，选 **C**。

                        #### ④ look at (看...)
                        - **【用法总结】**：`look` 是不及物动词，接宾语必须加 `at`。
                        - **【辨析】**：`look` (看过程/动作)；`see` (看结果/看见)；`watch` (注视/观看动态事物，如电视)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心一：名词所有格 ('s)
                        表示人或物的所有关系（“...的”）。
                        **1. 构成规则**
                        *   **【单数名词】**：直接加 `'s`。如：*Tom's book*。
                        *   **【以s结尾的复数名词】**：只加 `'`。如：*the teachers' office*。
                        *   **【不以s结尾的复数名词】**：加 `'s`。如：*Children's Day*。
                        *   **【共同所有与分别所有】**：
                            - *A and B's...* (两人共有)
                            - *A's and B's...* (两人各自所有)

                        **2. 中考真题特训**
                        
                        *(2024·江苏中考)* *This is ________ room. It is very big and clean.*
                        A. Lily and Lucy's   B. Lily's and Lucy's   C. Lily's and Lucy   D. Lily and Lucy
                        
                        **[解析]**：由 room 为单数可知是两人共有，选 **A**。

                        ---

                        ### 语法核心二：have 与 has 的用法
                        **1. 基本用法**
                        表示“有；拥有”。
                        *   **have**：用于第一、二人称 (I, you) 及复数主语 (we, they, the boys)。
                        *   **has**：用于第三人称单数 (he, she, it, Tom, my sister)。

                        **2. 句式变换**
                        *   **否定句**：主语 + `don't / doesn't` + `have`... (注意：doesn't 后用 have 原形)。
                        *   **疑问句**：`Do / Does` + 主语 + `have`...?

                        **3. 中考真题特训**
                        
                        *(2023·广东中考)* *— ________ your sister ________ an English dictionary? — Yes, she ________.*
                        A. Does; has; does   B. Does; have; does   C. Do; have; do   D. Do; have; does
                        
                        **[解析]**：主语 your sister 是单数，助动词用 Does，后面动词恢复原形 have；肯定回答用 Yes, she does。选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：My Family (介绍我的家庭)
                        #### 1. 写作模板 (Template)
                        *   **第一步：总体介绍**。`I have a ... family. There are ... people in my family.`
                        *   **第二步：逐一介绍成员**。介绍职业 (`My father is a...`)、爱好 (`He likes...`)、性格或外貌。
                        *   **第三步：总结情感**。`I love my family / my parents very much.`

                        #### 2. 满分范文赏析 (Model Essay)
                        **My Big and Happy Family**
                        
                        I have a big and happy family. There are five people in my family: my grandparents, my parents and me.
                        
                        My grandfather is 65 years old. He likes **playing chess**. My grandmother **is good at cooking**. She often cooks delicious food for us. 
                        
                        My father is a doctor. He is very tall. In his free time, he likes **spending time with** me. My mother is a teacher. She is very kind. 
                        
                        I love my family very much. We always help each other.
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
