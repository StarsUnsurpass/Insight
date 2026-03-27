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
                        
                        **[解析]**：two 后面接名词复数， photo 的复数是 photos，选 **C**。

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
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self) / 人与社会 (Man and Society)
                        *   **主题群**：学校、人际关系与校园生活 (School life)
                        *   **子主题**：描述校园建筑设施，辨识方位，介绍学校环境，培养爱校意识 (Describing school layout)。

                        ### 2. 单元主题内容
                        本单元以“My School (我的学校)”为主题，重点学习如何描述校园内的建筑设施（如 classroom building, library, sports field 等）及其空间方位。通过学习 `There be` 句型和方位介词（如 across from, between...and... 等），学生能够清晰、准确地向他人介绍自己的学习环境。本单元不仅锻炼学生的空间逻辑表达能力，还引导学生发现校园之美，增强对学校的归属感和自豪感。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **校园设施**：building (建筑物), classroom (教室), library (图书馆), office (办公室), hall (礼堂), playground/sports field (操场), dining hall (食堂), gym (体育馆).
                        - **方位介词/短语**：behind (在...后面), in front of (在...前面), across from (在...对面), between...and... (在...之间), next to (在...旁边), on the left/right (在左/右边).
                        - **核心动词**：show (出示; 给...看), spend (花时间), raise (举起; 筹集).
                        - **高频短语**：show sb. around (带某人参观), classroom building (教学楼), computer room (电脑室), teachers' office (老师办公室).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问地点**：Where is the library? / Is there a gym in your school?
                        2.  **描述存在**：There is a big library. / There are many classrooms.
                        3.  **描述方位**：The gym is behind the classroom building. / It's across from the sports field.
                        4.  **感叹赞美**：How beautiful our school is!

                        ### 3. 重点语法 (Key Grammar)
                        - **There be 句型**（一般现在时）的肯定、否定、疑问形式及其“就近原则”。
                        - **方位介词**的精准应用与区分。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Fu Xing**: Welcome to our school, Peter!
                        
                        **Peter**: Thanks, Fu Xing. Your school is very big. Where is your classroom?
                        
                        **Fu Xing**: It's in that building. It's on the second floor.
                        
                        **Peter**: Is there a library here?
                        
                        **Fu Xing**: Yes, there is. It's behind the office building.
                        
                        **Peter**: And what's that building across from the library?
                        
                        **Fu Xing**: That's the dining hall. Let's go and have a look.

                        **【译文】**
                        
                        **复兴**：欢迎来到我们的学校，彼得！
                        
                        **彼得**：谢谢，复兴。你们学校很大。你的教室在哪里？
                        
                        **复兴**：就在那栋楼里。它在二楼。
                        
                        **彼得**：这儿有图书馆吗？
                        
                        **复兴**：是的，有。它在办公楼后面。
                        
                        **彼得**：图书馆对面的那栋建筑是什么？
                        
                        **复兴**：那是食堂。让我们去看看吧。

                        ### Section B (Reading) 阅读文段：Our Beautiful School
                        **【原文】**
                        
                        Hi, I am Li Hua. I want to show you around my school. My school is not very big but it is very beautiful. In the middle of the school, there is a large sports field. We often play football there. Behind the sports field, there are two classroom buildings. My classroom is in Building A. There is also a small garden next to the library. We like reading books there. I love my school very much.

                        **【译文】**
                        
                        嗨，我是李华。我想带你参观我的学校。我的学校不是很大，但是它很漂亮。在学校中间，有一个大型操场。我们经常在那里踢足球。在操场后面，有两栋教学楼。我的教室在A号楼。图书馆旁边还有一个小花园。我们喜欢在那里读书。我非常热爱我的学校。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Where is your classroom? (你的教室在哪里？)
                        - **【句式剖析】**：`Where` 引导的特殊疑问句，用来询问地点。
                        - **【用法拓展】**：回答方位时，常配合 `It's in/on/behind...` 等介词短语。
                        
                        #### 2. Is there a library here? (这儿有图书馆吗？)
                        - **【句式剖析】**：`There be` 句型的一般疑问句形式。
                        - **【答语】**：肯定回答：`Yes, there is.`；否定回答：`No, there isn't.`
                        
                        #### 3. It's across from the office building. (它在办公楼对面。)
                        - **【要点精讲】**：`across from` 意为“在...对面”，强调两者之间隔着街道、走廊或空地。
                        
                        #### 4. I want to show you around my school. (我想带你参观我的学校。)
                        - **【词块归纳】**：`show sb. around...` 意为“带某人参观...”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① building (n. 建筑物；楼房)
                        - **【词汇梳理】**：来自动词 `build` (建设)。复数形式为 `buildings`。
                        - **【例题】**：
                        
                        *There are many tall ________ in the city.*
                        A. build   B. building   C. buildings   D. builds
                        
                        **[解析]**：many 后面接名词复数，选 **C**。

                        #### ② in front of (在...前面) vs in the front of (在...前部)
                        - **【辨析】**：
                            *   `in front of` 指在某个物体外部的前面。
                            *   `in the front of` 指在某个物体内部的前部。
                        - **【中考真题/例题】**：
                        
                        *The driver sits ________ the bus.*
                        A. in front of   B. in the front of   C. behind   D. next to
                        
                        **[解析]**：司机坐在公交车“内部”的前头，选 **B**。

                        #### ③ between...and... (在...和...之间)
                        - **【用法总结】**：连接两个并列的成分。
                        - **【例题】**：
                        
                        *The library is ________ the gym ________ the dining hall.*
                        A. among; and   B. between; and   C. from; to   D. next; to
                        
                        **[解析]**：两者之间用 between...and...，选 **B**。

                        #### ④ show (v. 出示; 给...看)
                        - **【常用短语】**：
                            *   `show sth. to sb.` = `show sb. sth.` (给某人看某物)
                            *   `on show` (在展览中)
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心一：There be 句型 (The "There be" Structure)
                        表示“某处存在某人/某物”。
                        **1. 基本结构**
                        *   **There is + 单数可数名词/不可数名词 + 地点状语.**
                        *   **There are + 复数名词 + 地点状语.**

                        **2. 就近原则 (The Principle of Proximity)**
                        当 be 动词后接两个或多个并列主语时，be 的形式由**离它最近**的那个主语决定。
                        - *There **is** a pen and two books on the desk.* (pen 是单数)
                        - *There **are** two books and a pen on the desk.* (books 是复数)

                        **3. 中考真题特训**
                        
                        *(2024·安徽中考)* *There ________ some water and two apples on the table.*
                        A. am   B. is   C. are   D. be
                        
                        **[解析]**：离 be 动词最近的主语是 some water (不可数名词)，用 is，选 **B**。

                        ---

                        ### 语法核心二：常用方位介词 (Prepositions of Place)
                        **1. 常见介词一览**
                        *   `on` (在...上面 - 接触)
                        *   `in` (在...里面)
                        *   `behind` (在...后面)
                        *   `under` (在...正下方)
                        *   `next to` (在...旁边)
                        *   `across from` (在...对面)

                        **2. 中考真题特训**
                        
                        *(2023·湖北中考)* *The cinema is ________ the supermarket and the library.*
                        A. in   B. behind   C. between   D. among
                        
                        **[解析]**：提示词 and 连接了两个地点，表示“在两者之间”，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：My School (我的学校)
                        #### 1. 写作要点 (Key Points)
                        *   **总述**：评价学校（大小、美丑）。
                        *   **分述**：介绍主要建筑及其位置。
                        *   **活动**：在这些场所进行的活动（如在操场踢球）。
                        *   **总结**：表达对学校的喜爱之情。

                        #### 2. 满分范文赏析 (Model Essay)
                        **Welcome to My School**
                        
                        My school is a beautiful place. Let me tell you something about it.
                        
                        In our school, **there is** a modern library. It is **next to** the classroom building. We like reading books there. In the middle of the school, **there is** a big playground. Many students play sports there after school. **Across from** the playground is our dining hall. The food there is very delicious.
                        
                        I like my school very much. Welcome to visit my school!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u4", "Unit 4", "My Favourite Subject",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：学校、人际关系与校园生活 (School life)
                        *   **子主题**：学科选择与个人喜好，学习计划与理由陈述 (Subject preferences and reasons)。

                        ### 2. 单元主题内容
                        本单元以“My Favourite Subject (我最喜欢的学科)”为主题，引导学生讨论各门学科及其魅力。通过学习 Why 引导的特殊疑问句和 because 引导的理由陈述，学生能够清晰地表达自己对不同学科的情感态度（如 interesting, useful, difficult 等）。本单元旨在帮助学生审视自己的学习生活，发现不同学科的价值，培养均衡发展的学习意识。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **学科名词**：maths (数学), English (英语), Chinese (语文), history (历史), geography (地理), science (科学), IT (信息技术), PE (体育), art (艺术), music (音乐).
                        - **描述性形容词**：interesting (有趣的), useful (有用的), important (重要的), difficult (困难的), easy (容易的), exciting (令人兴奋的).
                        - **高频短语**：favourite subject (最喜欢的学科), next week (下周), from... to... (从...到...), have lessons (上课).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问喜好**：What's your favourite subject?
                        2.  **陈述理由**：Why do you like geography? — Because it's useful.
                        3.  **询问课程时间**：When is your maths lesson? — It's at 9:00 on Monday.
                        4.  **评价学科**：I think history is very interesting.

                        ### 3. 重点语法 (Key Grammar)
                        - **Why 引导的特殊疑问句**及其回答（Because 句型）。
                        - **时间介词 at, on, in** 在课程表述中的精准应用。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Han Mei**: What's your favourite subject, Tom?
                        
                        **Tom**: My favourite subject is science.
                        
                        **Han Mei**: Why do you like science?
                        
                        **Tom**: Because it's very interesting. I like doing experiments.
                        
                        **Han Mei**: When do you have science?
                        
                        **Tom**: We have science on Wednesday and Friday.

                        **【译文】**
                        
                        **韩梅**：你最喜欢的学科是什么，汤姆？
                        
                        **汤姆**：我最喜欢的学科是科学。
                        
                        **韩梅**：你为什么喜欢科学？
                        
                        **汤姆**：因为它很有趣。我喜欢做实验。
                        
                        **韩梅**：你什么时候上科学课？
                        
                        **汤姆**：我们在周三和周五上科学课。

                        ### Section B (Reading) 阅读文段：My School Day
                        **【原文】**
                        
                        I'm very busy but happy today. At 8:00, I have Chinese. It's my favourite subject because I love Chinese stories. Then at 9:00, I have maths. It's difficult but useful. At 11:00, I have PE. I like PE because it's exciting. In the afternoon, I have an art lesson. I think art is easy. I have a great time at school.

                        **【译文】**
                        
                        今天我很忙但也很快乐。在8点钟，我上语文课。它是我最喜欢的学科，因为我热爱中国故事。然后在9点钟，我上数学课。它很难但是很有用。在11点钟，我上体育课。我喜欢体育，因为它令人兴奋。在下午，我有一节艺术课。我认为艺术很轻松。我在学校过得很愉快。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What's your favourite subject? (你最喜欢的学科是什么？)
                        - **【句式剖析】**：`favourite` 作形容词修饰 `subject`。
                        - **【同义转换】**：`What subject do you like best?`
                        
                        #### 2. Why do you like science? (你为什么喜欢科学？)
                        - **【句式剖析】**：`Why` 引导特殊疑问句询问原因，助动词 `do` 随人称变化。
                        
                        #### 3. Because it's very interesting. (因为它非常有意思。)
                        - **【要点精讲】**：在英语中，`Because` (因为) 和 `So` (所以) 不能在同一个句子中同时出现。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① favourite (adj. 最喜爱的)
                        - **【用法总结】**：前面常接物主代词。*my favourite book*。
                        - **【例题】**：
                        
                        *Which subject do you like ________?*
                        A. good   B. better   C. best   D. well
                        
                        **[解析]**：like ... best 相当于 favourite，选 **C**。

                        #### ② interesting (有趣的) vs interested (感兴趣的)
                        - **【辨析】**：
                            *   `interesting` 修饰“物”，表示事物本身的性质。
                            *   `interested` 修饰“人”，表示人的主观感受。*be interested in sth.*
                        - **【中考真题/例题】**：
                        
                        *I think the movie is very ________. I am ________ in it.*
                        A. interesting; interesting   B. interested; interested   C. interesting; interested   D. interested; interesting
                        
                        **[解析]**：第一空修饰 movie (物)，第二空修饰 I (人)，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：Why 疑问句与 Because 因果连横
                        **1. 结构分析**
                        - 问句：Why + 助动词 (do/does) + 主语 + 动词原形 + 其他?
                        - 答句：Because + 主语 + 谓语 + 其他.

                        **2. 时间介词 at, on, in 的区分**
                        - **at**：用于具体的时间点 (at 8:00)。
                        - **on**：用于具体的某一天或星期 (on Monday, on May 1st)。
                        - **in**：用于大的时间段，如上午/下午、月份、年份 (in the morning, in June)。

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *— ________ don't you go to the party? — ________ I have too much homework to do.*
                        A. Why; Because   B. Why; So   C. How; Because   D. How; So
                        
                        **[解析]**：问句询问原因，答句给出理由，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：My School Day (我的学校生活)
                        #### 1. 必备句式
                        *   *My favourite subject is... because it's...*
                        *   *We have ... on ...*
                        *   *I think ... is useful/easy.*
                        *   *I have a busy and happy day.*

                        #### 2. 满分范文赏析
                        **My School Day**
                        
                        I have a busy but interesting school day on Monday.
                        
                        At 8:30, I have my first lesson, Chinese. It is **favourite subject** because I like the teacher. At 10:00, I have maths. It's a bit **difficult** for me, but it is **useful**. In the afternoon, we have music and PE. Music is very **relaxing**. 
                        
                        I like my school day very much.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u5", "Unit 5", "Fun Clubs",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：个人兴趣爱好，社团活动，特长展示 (Hobbies and clubs)。

                        ### 2. 单元主题内容
                        本单元以“Fun Clubs (趣味社团)”为核心，引导学生探索并介绍自己的兴趣特长。通过学习情态动词 `can` 的用法，学生能够表达自己“能做什么”和“擅长做什么”。本单元模拟了校园社团招新的真实情境，旨在鼓励学生积极参与课外活动，在交流与合作中发展特长，建立自信并结识志趣相投的朋友。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **社团名称**：music club, art club, English club, chess club, swimming club, sports club.
                        - **特长动词**：sing (唱), dance (跳舞), swim (游泳), draw (画画), speak (说), play (弹奏; 玩).
                        - **核心名词**：ability (能力), member (成员), student (学生).
                        - **高频短语**：be good at (擅长), help sb. with sth. (在某方面帮助某人), want to join (想加入).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问能力**：Can you sing? / What can you do?
                        2.  **表达能力**：I can dance. / He can't speak English.
                        3.  **询问意愿**：What club do you want to join? — I want to join the art club.
                        4.  **展示特长**：I'm good at playing the guitar.

                        ### 3. 重点语法 (Key Grammar)
                        - **情态动词 can** 的肯定句、否定句、一般疑问句及其回答。
                        - **want to do sth.** 表达意愿的用法。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teacher**: What club do you want to join, Li Hua?
                        
                        **Li Hua**: I want to join the music club.
                        
                        **Teacher**: Can you sing or dance?
                        
                        **Li Hua**: I can sing well, but I can't dance.
                        
                        **Teacher**: That's great! We need help for the music festival.
                        
                        **Li Hua**: I'd love to help!

                        **【译文】**
                        
                        **老师**：李华，你想加入什么社团？
                        
                        **李华**：我想加入音乐社团。
                        
                        **老师**：你会唱歌还是跳舞？
                        
                        **李华**：我唱歌很好，但我不会跳舞。
                        
                        **老师**：那太棒了！我们的音乐节需要人帮忙。
                        
                        **李华**：我很乐意帮忙！

                        ### Section B (Reading) 阅读文段：Clubs Recruitment
                        **【原文】**
                        
                        Welcome to our school clubs! Can you speak English? Join the English club. Are you good at sports? Come to the basketball club. We also have a chess club. It is very fun. If you like music, you can join the music club. We need members for the school band. Come and show us what you can do!

                        **【译文】**
                        
                        欢迎来到我们的学校社团！你会说英语吗？加入英语社团吧。你擅长体育吗？来篮球社团吧。我们还有一个象棋社团。它非常有趣。如果你喜欢音乐，你可以加入音乐社团。我们的校乐队需要成员。快来展示你的才艺吧！
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What club do you want to join? (你想加入什么社团？)
                        - **【句式剖析】**：`want to join` 意为“想要加入”。`join` 指加入某个组织或群体。
                        
                        #### 2. I'm good at playing the guitar. (我擅长弹吉他。)
                        - **【要点精讲】**：`be good at` 后面接动词时，必须用 **-ing** 形式。
                        - **【词块归纳】**：`play the guitar` (弹吉他)。注意：西洋乐器前必须加定冠词 **the**。
                        
                        #### 3. Help us with the music festival! (帮我们举办音乐节吧！)
                        - **【词块归纳】**：`help sb. with sth.` 在某事上帮助某人。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① can (modal v. 能; 会)
                        - **【用法总结】**：
                            *   后接动词原形。
                            *   否定形式为 `cannot` 或 `can't`。
                        - **【例题】**：
                        
                        *He can ________ the violin very well.*
                        A. playing   B. plays   C. play   D. to play
                        
                        **[解析]**：can 后面接动词原形，选 **C**。

                        #### ② join (加入) vs take part in (参加)
                        - **【辨析】**：
                            *   `join` 指加入组织、团体，并成为其中一员。
                            *   `take part in` 指参加某项活动或比赛。
                        - **【中考真题/例题】**：
                        
                        *My brother wants to ________ the army.*
                        A. join   B. join in   C. take part in   D. join to
                        
                        **[解析]**：army (参军) 是加入组织，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：情态动词 can 的“能力”立场
                        **1. 句型构成**
                        - 肯定句：主语 + can + 动词原形.
                        - 否定句：主语 + can't + 动词原形.
                        - 疑问句：Can + 主语 + 动词原形?
                        - 简略回答：Yes, 主语 + can. / No, 主语 + can't.

                        **2. 核心短语 -ing 形式变换**
                        - be good at **drawing** (擅长画画)
                        - be good at **swimming** (注意双写m)

                        **3. 中考真题特训**
                        
                        *(2023·北京中考)* *— ________ you play the piano? — Yes, but I ________ play it very well.*
                        A. Can; can't   B. Can; can   C. Do; don't   D. Do; can't
                        
                        **[解析]**：第一空询问能力，第二空根据 but 引导的转折关系可知是“不能/不太好”，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：Club Application (社团申请/自荐信)
                        #### 1. 写作要点
                        *   **目的**：我想加入XX社团。
                        *   **特长**：我会做... 我擅长...
                        *   **联系方式**：请拨打电话... 找我。

                        #### 2. 满分范文赏析
                        **Join the Music Club**
                        
                        My name is Li Hua and I want to **join the music club**. 
                        
                        I love music very much. **I can** sing many English songs and **I am good at** playing the piano. I can also help my classmates with their music lessons. I think I can be a good member of the club. 
                        
                        Please call me at 668-9988. Thank you!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u6", "Unit 6", "A Day in the Life",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：个人作息，时间管理，日常生活规律 (Daily routines)。

                        ### 2. 单元主题内容
                        本单元以“A Day in the Life (生活中的一天)”为主题，重点学习时间的表达及日常活动的描述。通过学习 get up, have breakfast, go to school 等动作短语，以及 always, usually, often 等频率副词，学生能够有条理地介绍自己或他人的作息时间表。本单元旨在培养学生良好的生活习惯，学会科学合理地规划时间。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **日常动作**：get up (起床), brush teeth (刷牙), eat breakfast (吃早餐), go to school (上学), do homework (做作业), go to bed (睡觉).
                        - **时间副词**：always (总是), usually (通常), often (经常), sometimes (有时), never (从不).
                        - **核心名词**：time (时间), shower (淋浴), station (站; 所).
                        - **高频短语**：take a shower (洗澡), brush my teeth (刷我的牙), go home (回家), on weekends (在周末).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问时间**：What time is it? / What's the time?
                        2.  **询问作息**：What time do you usually get up?
                        3.  **描述规律**：I usually get up at 6:30. / He never goes to school late.
                        4.  **固定句型**：It's time for breakfast. (该吃早餐了。)

                        ### 3. 重点语法 (Key Grammar)
                        - **时间表达法**（顺读法与逆读法）。
                        - **频率副词**在句子中的位置（行前 be 后）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Rick**: Hi, Scott. What time do you usually get up on school days?
                        
                        **Scott**: I usually get up at six o'clock.
                        
                        **Rick**: That's early! And what time do you go to school?
                        
                        **Scott**: I go to school at seven thirty. I'm never late for school.
                        
                        **Rick**: Do you have a shower in the morning?
                        
                        **Scott**: No, I always have a shower in the evening before bed.

                        **【译文】**
                        
                        **里克**：嗨，斯科特。在上学日你通常几点起床？
                        
                        **斯科特**：我通常六点钟起床。
                        
                        **里克**：那真早！那你几点去上学？
                        
                        **斯科特**：我七点半去上学。我上学从不迟到。
                        
                        **里克**：你早晨洗澡吗？
                        
                        **斯科特**：不，我总是在晚上睡觉前洗澡。

                        ### Section B (Reading) 阅读文段：My Daily Routine
                        **【原文】**
                        
                        My name is Li Hua. I have a healthy life. I always get up at 6:15. I brush my teeth and then have a good breakfast. I go to school at 7:10. Lessons start at 8:00. After school, I play basketball with my friends. I do my homework at 7:00 in the evening. At 9:30, I go to bed. I feel very good every day.

                        **【译文】**
                        
                        我的名字是李华。我有着健康的生活。我总是6:15起床。我刷牙，然后吃一顿丰盛的早餐。我7:10去上学。课程8:00开始。放学后，我和朋友们打篮球。我晚上7:00做作业。9:30的时候，我上床睡觉。我每天都感觉很好。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What time is it? (几点了？)
                        - **【用法拓展】**：同义句为 `What's the time?` 常用 `It's...` 回答。
                        
                        #### 2. I'm never late for school. (我上学从不迟到。)
                        - **【词块归纳】**：`be late for...` 意为“做...迟到”。
                        - **【语法点】**：频率副词 `never` 放在 be 动词 `am` 之后。
                        
                        #### 3. It's time for breakfast. (该吃早餐了。)
                        - **【用法拓展】**：`It's time for + 名词` = `It's time to do + 动词原形`。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① time (n. 时间)
                        - **【常见搭配】**：`on time` (准时)；`in time` (及时)。
                        - **【例题】**：
                        
                        *We should go to school ________.*
                        A. in time   B. at time   C. on time   D. for time
                        
                        **[解析]**：上学应该准时，选 **C**。

                        #### ② eat / have (吃)
                        - **【用法总结】**：表示“吃三餐”时，餐名前**不加**冠词。*have breakfast* (吃早餐)。
                        - **【例题】**：
                        
                        *It's eight o'clock. Let's have ________ breakfast.*
                        A. a   B. an   C. the   D. /
                        
                        **[解析]**：have breakfast 固定短语，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心一：时间表达法的“双轨制”
                        **1. 顺读法 (小时 + 分钟)**
                        - 6:10 -> six ten
                        - 7:30 -> seven thirty

                        **2. 逆读法 (分钟 + past/to + 小时)**
                        - **past (过)**：分钟 ≤ 30。 8:20 -> twenty past eight.
                        - **to (差)**：分钟 > 30。 9:50 -> ten to ten (十点差十分).
                        - **特殊词**：quarter (15分钟), half (30分钟)。

                        ### 语法核心二：频率副词的“排位赛”
                        - **位置**：行为动词前，be 动词后。
                        - **频度排序**：always (100%) > usually (80%) > often (60%) > sometimes (30%) > never (0%).

                        **3. 中考真题特训**
                        
                        *(2024·江苏中考)* *I ________ play football after school, but today I have to go home early.*
                        A. always   B. never   C. usually   D. sometimes
                        
                        **[解析]**：根据 but 后的转折可知，平时“通常”踢球，但今天例外，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：My Daily Routine (我的作息时间)
                        #### 1. 写作逻辑 (Logic)
                        - **Morning**：get up, have breakfast, go to school.
                        - **Afternoon**：have lessons, play sports.
                        - **Evening**：do homework, go to bed.

                        #### 2. 满分范文赏析
                        **My Busy Day**
                        
                        I have a busy day from Monday to Friday. 
                        
                        **I usually get up at** 6:30. Then I brush my teeth and have a quick breakfast. At 7:15, I **go to school** by bus. Lessons begin at 8:00. In the afternoon, I **often play** ping-pong with my classmates. It's very fun. In the evening, I **always do my homework** first. I go to bed at 9:45. 
                        
                        This is my day. It's busy but I am happy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u7", "Unit 7", "Happy Birthday!",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：生日庆祝，日期表达，购物体验 (Birthday celebrations)。

                        ### 2. 单元主题内容
                        本单元围绕“Happy Birthday (生日快乐)”这一温馨话题，学习月份、日期的表达以及如何谈论价格。学生将掌握序数词的构建规则，并学会询问他人的生日（When is your birthday?）和年龄（How old are you?）。此外，单元还涉及了简单的购物情境（How much is it?）。本单元旨在培养学生关爱他人、分享快乐的社交习惯，并初步具备在生活中进行简单交易的能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **十二个月份**：January, February, March, April, May, June, July, August, September, October, November, December. (注意：首字母必须大写)。
                        - **序数词**：first, second, third, fourth, fifth... twentieth...
                        - **核心名词**：birthday (生日), date (日期), party (派对), price (价格), dollar (美元).
                        - **高频短语**：birthday party (生日派对), have a party (举办派对), how old (多大岁数), how much (多少钱).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问日期**：When is your birthday? — My birthday is on October 10th.
                        2.  **询问年龄**：How old are you? — I am 13.
                        3.  **询问价格**：How much is this sweater? — It's nine dollars.
                        4.  **祝福用语**：Happy birthday to you!

                        ### 3. 重点语法 (Key Grammar)
                        - **序数词**的变换规则及其在日期中的应用。
                        - **How much** 引导的价格疑问句。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Alice**: When is your birthday, Jack?
                        
                        **Jack**: My birthday is on August 2nd. When is yours?
                        
                        **Alice**: It's on January 5th. 
                        
                        **Jack**: Are you having a party this year?
                        
                        **Alice**: Yes, I am. Can you come to my party?
                        
                        **Jack**: I'd love to! How old will you be?
                        
                        **Alice**: I will be thirteen.

                        **【译文】**
                        
                        **艾丽丝**：杰克，你的生日是什么时候？
                        
                        **杰克**：我的生日是在8月2日。你的呢？
                        
                        **艾丽丝**：在1月5日。
                        
                        **杰克**：你今年要举办派对吗？
                        
                        **艾丽丝**：是的。你能来参加我的派对吗？
                        
                        **杰克**：我很乐意！你到时多大了？
                        
                        **艾丽丝**：我就十三岁了。

                        ### Section B (Reading) 阅读文段：Birthday Sale
                        **【原文】**
                        
                        Welcome to Mr. Cool's Clothes Store! We have a great sale for your birthday. How much is the red sweater? It's only 15 dollars. The black trousers are 20 dollars. For girls, we have beautiful skirts for 12 dollars. Come to our store and buy clothes for your party!

                        **【译文】**
                        
                        欢迎来到库尔先生的服装店！我们为你的生日准备了大促销。这件红毛衣多少钱？只要15美元。这条黑裤子20美元。对于女孩们，我们有12美元的漂亮裙子。快来我们的商店为你的派对买衣服吧！
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. When is your birthday? (你的生日是什么时候？)
                        - **【用法拓展】**：回答日期时，介词必须用 `on`。
                        
                        #### 2. How much is this sweater? (这件毛衣多少钱？)
                        - **【要点精讲】**：询问单数物品价格用 `is`，复数物品用 `are`。
                        
                        #### 3. Happy birthday to you! (祝你生日快乐！)
                        - **【常识】**：接受祝福后要礼貌地说 `Thank you!`
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① Months (月份)
                        - **【记忆口诀】**：一月二月衔接难，Jan. Feb. 记心间；三月四月桃花开，Mar. Apr. 春天来；五月六月过初夏，May Jun. 最繁华；七月八月放暑假，Jul. Aug. 乐开花；九十十一十二月，Sep. Oct. Nov. Dec.。
                        
                        #### ② How old (多大) vs How much (多少)
                        - **【辨析】**：`How old` 问年龄；`How much` 问价格（或不可数名词数量）。
                        - **【中考真题/例题】**：
                        
                        *— ________ is the blue hat? — It's five dollars.*
                        A. How old   B. How much   C. How many   D. How long
                        
                        **[解析]**：回答是价格，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心一：序数词 (Ordinal Numbers) 的“变身术”
                        **1. 变化口诀**
                        一二三，特殊记 (first, second, third)；八去 t，九去 e (eighth, ninth)；ve 要用 f 替 (fifth, twelfth)；ty 变成 tie (twenty -> twentieth)；以上若遇几十几，只变个位就可以。

                        **2. 句式变换**
                        - 询问价格：How much + be + 物品?
                        - 询问日期：When is the + 活动?

                        **3. 中考真题特训**
                        
                        *(2023·广东中考)* *My daughter's ________ birthday is coming. I will buy a gift for her.*
                        A. nine   B. ninth   C. the nine   D. the ninth
                        
                        **[解析]**：表示“第九个生日”，序数词前有形容词性物主代词时不再加 the，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：A Birthday Party Invitation (生日派对邀请函)
                        #### 1. 写作要素
                        - **Who** (谁的生日)
                        - **When** (什么日期和时间)
                        - **Where** (在什么地点)
                        - **What** (活动内容)

                        #### 2. 满分范文赏析
                        **An Invitation**
                        
                        Hi, my friends!
                        
                        Next Friday, **January 15th**, is my 13th birthday. I am going to **have a party** at my home. The party starts at 6:00 p.m. We will eat birthday cake and play games. I will be very happy if you can come!
                        
                        See you then!
                    """.trimIndent())
                )
            )

        )
    )
}
