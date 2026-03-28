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
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/sc7x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g7up_u1", "Unit 1", "Making New Friends",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境与价值导向
                        *   **主题语境**：人与自我 —— 结交新朋友。
                        *   **深层意义**：作为初中英语的第一课，本单元不仅是语言的起点，更是社交礼仪的启蒙。通过学习问候语、自我介绍和询问姓名，引导学生建立积极的人际关系，培养自信、礼貌的沟通品格。
                        
                        ### 2. 知识能力目标
                        - **语言能力**：掌握 26 个字母的正确读音与书写；掌握 be 动词的一般现在时陈述与疑问用法；熟练运用问候及自我介绍句型。
                        - **思维品质**：理解中西方姓名文化差异（姓在前与姓在后）。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **问候/介绍**：hello (你好), hi (你好), good (好的), morning (早晨), afternoon (下午), evening (晚上), name (名字), nice (令人愉快的), meet (遇见)。
                        - **代词核心**：I (我), my (我的), you (你), your (你的), he (他), his (他的), she (她), her (她的)。
                        - **数字 0-9**：zero, one, two, three, four, five, six, seven, eight, nine.
                        - **姓名构成**：first name (名字), last name (姓), family name (姓)。

                        ### 2. 核心短语金牌储备
                        - `good morning/afternoon/evening` 早上/下午/晚上好
                        - `nice to meet you` 见到你很高兴
                        - `my/his/her name` 我的/他的/她的名字
                        - `telephone number` 电话号码
                        - `ID card` 身份证
                        - `first name` 名字 (Givien name)
                        - `last name / family name` 姓氏 (Surname)
                        - `in English` 用英语
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What's your name? (你叫什么名字？)
                        - **【考点详解】**：`What's` 是 `What is` 的缩写。`your` 是形容词性物主代词，后接名词。
                        - **【回答方式】**：`My name is...` 或 `I am...`。
                        
                        #### 2. Nice to meet you! (见到你很高兴！)
                        - **【社交礼仪】**：初次见面时的正式问候语。对方通常回答：`Nice to meet you, too!`。
                        
                        #### 3. What's his/her telephone number? (他的/她的电话号码是多少？)
                        - **【结构剖析】**：`What's` 引导询问信息的特殊疑问句。注意 `his` (男) 与 `her` (女) 的区分。
                        
                        #### 4. Gina is her first name. (吉娜是她的名字。)
                        - **【文化避坑】**：英语国家人名通常是“名在前，姓在后”。例如：*Jim Green* 中，*Jim* 是 first name，*Green* 是 last name。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：be 动词的一般现在时 (I)
                        **1. 对应关系**：
                        - I + **am**
                        - You / We / They + **are**
                        - He / She / It / 单数名词 + **is**
                        
                        **2. 缩写形式**：
                        - I'm, You're, He's, She's, It's, What's, Name's.
                        - **注意**：this is 不能缩写。

                        ### 核心语法二：形容词性物主代词
                        **规律**：必须放在名词前，表示“...的”。
                        - *my book* (我的书)
                        - *your friend* (你的朋友)
                        - *his name* (他的名字)
                        - *her ID card* (她的身份证)

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *— What's ________ telephone number? — ________ telephone number is 123-456.*
                        A. he; He   B. his; His   C. him; His   D. his; He
                        
                        **[解析]**：询问“他的”号码，修饰名词用形容词性物主代词 his，选 **B**。

                        *(2023·北京中考)* *Nice ________ you. My name ________ Mike.*
                        A. meet; is   B. to meet; is   C. meeting; is   D. to meet; am
                        
                        **[解析]**：固定搭配 Nice to meet you；My name 是第三人称单数，用 is，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：自我介绍 (Self-introduction)
                        #### 1. 写作要素
                        - **问候语**：Hello! / Good morning!
                        - **姓名**：My name is... / I am...
                        - **联系方式**：My phone number is...
                        - **结语**：Nice to meet you!

                        #### 2. 高分句式
                        - *I am a student in Middle School.* (我是一中学生。)
                        - *My first name is Jim and my last name is Brown.* (我名叫吉姆，姓布朗。)
                        - *You can call me at 123456.* (你可以拨打123456联系我。)

                        #### 3. 满分范文
                        **Hello, Everyone!**
                        
                        Good morning! My name is Li Hua. My first name is Hua and my last name is Li. I am 13 years old. My telephone number is 138-0000. Nice to meet you all! I hope we can be good friends.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u2", "Unit 2", "This is my sister.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 家庭成员。
                        *   **深层意义**：本单元围绕“介绍家人及指认人物”展开。旨在引导学生感受家庭温暖，增进对家庭成员的了解。通过绘制家庭树（Family Tree），培养学生的逻辑归类能力和对家庭责任的认同感。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握指示代词 `this, that, these, those` 的空间距离感；熟练运用名词复数形式；掌握询问身份的句型。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **家庭成员**：father (父亲), mother (母亲), parents (父母), brother (兄弟), sister (姐/妹), grandfather (祖父), grandmother (祖母), grandparents (祖父母), cousin (堂/表兄弟姐妹), uncle (舅/叔/伯), aunt (姨/婶/姑), son (儿子), daughter (女儿)。
                        - **指示代词**：this (这), that (那), these (这些), those (那些)。
                        - **其他**：friend (朋友), picture (照片), photo (照片), girl (女孩), boy (男孩)。

                        ### 2. 核心短语金牌储备
                        - `my family` 我的家庭
                        - `family tree` 家谱/家庭树
                        - `a photo of my family` 一张全家福
                        - `in the first photo` 在第一张照片里
                        - `have a good day` 过得愉快
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. This is my sister. (这是我的妹妹。)
                        - **【考点详解】**：`This is...` 用于介绍近处或单数的人物。
                        
                        #### 2. These are my parents. (这些是我的父母。)
                        - **【结构剖析】**：`These are...` 后接名词复数。注意 `parents` 指双亲（父和母）。
                        
                        #### 3. Who's he? (他是谁？)
                        - **【语法核心】**：`Who's` 是 `Who is` 的缩写。用于询问身份。
                        
                        #### 4. Are those your grandparents? (那些是你的祖父母吗？)
                        - **【回答方式】**：`Yes, they are.` / `No, they aren't.`。 (**注意：回答指示代词引导的疑问句，主语统一用 they**)
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：指示代词 (this, that, these, those)
                        - **单数**：`this` (近), `that` (远)。
                        - **复数**：`these` (近), `those` (远)。
                        - **口诀**：单变复，is 变 are，this 变 these，that 变 those。

                        ### 核心语法二：名词变复数的规则
                        1.  直接加 s：*brother -> brothers*。
                        2.  以 s, x, ch, sh 结尾加 es：*bus -> buses, watch -> watches*。
                        3.  以“辅音+y”结尾，变 y 为 i 加 es：*family -> families*。
                        4.  不规则变化：*child -> children*。

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— Who are ________ boys over there? — They are my classmates.*
                        A. this   B. that   C. these   D. those
                        
                        **[解析]**：over there 提示距离远，且 boys 为复数，选 **D**。

                        *(2023·上海中考)* *— Is this your photo? — Yes, ________ is. And ________ are my sisters.*
                        A. it; these   B. this; those   C. it; those   D. this; these
                        
                        **[解析]**：回答 this 引导的问句用 it 代替；后句介绍近处人物复数用 these，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍我的家人 (Introduce My Family)
                        #### 1. 写作思路
                        - **总述**：Here is a photo of my family. / I have a happy family.
                        - **具体介绍**：依次介绍祖父母、父母和兄弟姐妹。
                        - **情感评价**：I love my family.

                        #### 2. 高分句式
                        - *These are my grandparents.*
                        - *The man in the photo is my father.*
                        - *My sister is a student. She is 10 years old.*

                        #### 3. 满分范文
                        **My Family**
                        
                        Hi! I am Li Hua. Here is a photo of my family. These are my grandparents. They are very kind. This is my father. He is a teacher. This is my mother. She is a doctor. Who is the little girl? She is my sister, Li Mei. I love my family very much!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u3", "Unit 3", "Where is my schoolbag?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活习惯（物品陈列）。
                        *   **深层意义**：本单元聚焦“物品的位置与归纳”。旨在引导学生学会整理自己的生活用品（如书包、钥匙、课本），培养良好的生活习惯和自理能力。通过描述凌乱与整洁房间的对比，理解有序生活的重要性。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **学习用品**：schoolbag (书包), pencil (铅笔), pen (钢笔), book (书), notebook (笔记本), dictionary (词典), map (地图)。
                        - **家居用品**：bed (床), table (桌子), chair (椅子), desk (书桌), sofa (沙发), keys (钥匙)。
                        - **方位介词**：in (在...里), on (在...上), under (在...下)。
                        - **其他词汇**：where (在哪里), everywhere (到处), tidy (整洁的), messy (乱的)。

                        ### 2. 核心短语金牌储备
                        - `in the schoolbag` 在书包里
                        - `on the desk` 在桌子上
                        - `under the bed` 在床底下
                        - `in the room` 在房间里
                        - `come on` 快点；加油
                        - `a set of keys` 一串钥匙 (**必考：谓语用单数**)
                        - `be tidy` 保持整洁
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Where's my schoolbag? (我的书包在哪？)
                        - **【考点详解】**：`Where` 询问地点。回答用 `It's on/in/under...`。
                        
                        #### 2. It's under the table. (它在桌子底下。)
                        - **【结构剖析】**：`It` 指代前面的单数名词 `schoolbag`。
                        
                        #### 3. Where are my keys? (我的钥匙在哪？)
                        - **【语法核心】**：复数名词提问，助动词用 `are`。回答用 `They're...`。
                        
                        #### 4. The keys are on the sofa. (钥匙在沙发上。)
                        - **【避坑指南】**：注意 `keys` 是复数，谓语动词用 `are`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：Where 引导的特殊疑问句
                        - **单数提问**：`Where is + 名词单数?` -> 回答：`It is + 介词短语.`
                        - **复数提问**：`Where are + 名词复数?` -> 回答：`They are + 介词短语.`

                        ### 核心语法二：方位介词 (in, on, under)
                        - **in**：表示在内部。
                        - **on**：表示在物体表面，且有接触。
                        - **under**：表示在正下方。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *— Where ________ my glasses? — ________ on the sofa.*
                        A. is; It's   B. are; They're   C. is; They're   D. are; It's
                        
                        **[解析]**：glasses (眼镜) 永远是复数形式，选 **B**。

                        *(2023·河北中考)* *I can't find my dictionary. It isn't ________ my schoolbag.*
                        A. on   B. under   C. in   D. to
                        
                        **[解析]**：在书包“里面”，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍我的房间 (My Room)
                        #### 1. 写作要点
                        - **方位描写**：由远及近，或从左到右。
                        - **物品分布**：使用 There be 结构或 `A is on/in B`。
                        - **评价总结**：I think my room is very tidy.

                        #### 2. 高分句式
                        - *This is my room. It is not big but tidy.*
                        - *My bed is in the room. My quilt is on the bed.*
                        - *Where is my desk? It's near the window.*

                        #### 3. 满分范文
                        **My Tidy Room**
                        
                        Hello! Welcome to my room. It is small but very tidy. My bed is in the middle of the room. My blue quilt is on it. Under the bed is my schoolbag. I have a big desk. My books and notebooks are in the desk. My computer is on the desk. I love my room very much!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u4", "Unit 4", "Do you have a soccer ball?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 兴趣与运动。
                        *   **深层意义**：本单元围绕“运动器材的所有权及运动喜好”展开。旨在引导学生热爱体育运动，培养健康的生活方式和团队合作意识。通过对比不同运动的评价（interesting, boring, difficult），学会表达主观感受并尊重他人的选择。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **运动器材**：soccer ball (足球), basketball (篮球), volleyball (排球), tennis (网球), ping-pong (乒乓球), bat (球棒)。
                        - **评价形容词**：interesting (有趣的), boring (无聊的), difficult (困难的), easy (容易的), relaxing (放松的)。
                        - **核心动词**：have (有), play (玩/打), watch (看), let (让)。
                        - **其他**：us (我们), them (他们), class (班级), same (相同的)。

                        ### 2. 核心短语金牌储备
                        - `play basketball/soccer/tennis` 打篮球/足球/网球 (**必考：球类运动前不加冠词**)
                        - `watch TV` 看电视
                        - `watch sports on TV` 在电视上看体育比赛
                        - `on TV` 在电视上
                        - `at school` 在学校
                        - `be late` 迟到
                        - `play sports` 做运动
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Do you have a soccer ball? (你有足球吗？)
                        - **【考点详解】**：一般现在时含有实义动词 `have` 的疑问句。需借用助动词 `do`。
                        
                        #### 2. Does he have a tennis bat? (他有网球拍吗？)
                        - **【结构剖析】**：第三人称单数提问，助动词用 `does`。注意：`does` 后面动词还原为 `have`。
                        
                        #### 3. Let's play basketball. (让我们打篮球吧。)
                        - **【语法核心】**：`Let's` 引导的祈使句表示建议。后接动词原形。
                        
                        #### 4. I don't have a volleyball, but my brother has one. (我没有排球，但我哥哥有一个。)
                        - **【避坑指南】**：`one` 用来替代前面提到的同类不特定事物。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：have / has 的用法
                        - **肯定句**：I/You/We/They **have**...; He/She/It **has**...
                        - **否定句**：`don't have` / `doesn't have`。
                        - **疑问句**：`Do you have...?` / `Does he have...?`

                        ### 核心语法二：祈使句建议 (Let's)
                        - **结构**：`Let's + 动词原形.`
                        - **回答**：Yes, let's. / That sounds good.

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— ________ your sister ________ a computer? — No, she ________.*
                        A. Do; have; don't   B. Does; has; doesn't   C. Does; have; doesn't   D. Do; has; don't
                        
                        **[解析]**：主语 sister 是三单，疑问句借 does 动词还原 have，选 **C**。

                        *(2023·北京中考)* *— Let's play soccer after school. — That ________ like a good idea.*
                        A. sound   B. sounds   C. sounding   D. to sound
                        
                        **[解析]**：That 指代前面这件事，是单数，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的运动习惯 (My Sports)
                        #### 1. 写作要点
                        - **器材拥有情况**：I have a... / I don't have a...
                        - **喜欢的运动**：I like... because...
                        - **运动频率**：I play sports every day.

                        #### 2. 高分句式
                        - *I like sports very much.*
                        - *I have a collection of soccer balls.*
                        - *Playing basketball is very interesting for me.*
                        - *Let's go and play sports together!*

                        #### 3. 满分范文
                        **My Favorite Sport**
                        
                        I love sports. I have a basketball and two soccer balls. My favorite sport is basketball because it's very interesting and relaxing. I often play basketball with my classmates after school. I don't like volleyball because I think it's difficult. Sports are good for our health. Let's play together!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u5", "Unit 5", "Do you have a soccer ball?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 兴趣与运动。
                        *   **深层意义**：本单元围绕“运动器材的所有权及运动喜好”展开。旨在引导学生热爱体育运动，培养健康的生活方式和团队合作意识。通过对比不同运动的评价（interesting, boring, difficult），学会表达主观感受并尊重他人的选择。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **运动器材**：soccer ball (足球), basketball (篮球), volleyball (排球), tennis (网球), ping-pong (乒乓球), bat (球棒)。
                        - **评价形容词**：interesting (有趣的), boring (无聊的), difficult (困难的), easy (容易的), relaxing (放松的)。
                        - **核心动词**：have (有), play (玩/打), watch (看), let (让)。
                        - **其他**：us (我们), them (他们), class (班级), same (相同的)。

                        ### 2. 核心短语金牌储备
                        - `play basketball/soccer/tennis` 打篮球/足球/网球 (**必考：球类运动前不加冠词**)
                        - `watch TV` 看电视
                        - `watch sports on TV` 在电视上看体育比赛
                        - `on TV` 在电视上
                        - `at school` 在学校
                        - `be late` 迟到
                        - `play sports` 做运动
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Do you have a soccer ball? (你有足球吗？)
                        - **【考点详解】**：一般现在时含有实义动词 `have` 的疑问句。需借用助动词 `do`。
                        
                        #### 2. Does he have a tennis bat? (他有网球拍吗？)
                        - **【结构剖析】**：第三人称单数提问，助动词用 `does`。注意：`does` 后面动词还原为 `have`。
                        
                        #### 3. Let's play basketball. (让我们打篮球吧。)
                        - **【语法核心】**：`Let's` 引导的祈使句表示建议。后接动词原形。
                        
                        #### 4. I don't have a volleyball, but my brother has one. (我没有排球，但我哥哥有一个。)
                        - **【避坑指南】**：`one` 用来替代前面提到的同类不特定事物。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：have / has 的用法
                        - **肯定句**：I/You/We/They **have**...; He/She/It **has**...
                        - **否定句**：`don't have` / `doesn't have`。
                        - **疑问句**：`Do you have...?` / `Does he have...?`

                        ### 核心语法二：祈使句建议 (Let's)
                        - **结构**：`Let's + 动词原形.`
                        - **回答**：Yes, let's. / That sounds good.

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— ________ your sister ________ a computer? — No, she ________.*
                        A. Do; have; don't   B. Does; has; doesn't   C. Does; have; doesn't   D. Do; has; don't
                        
                        **[解析]**：主语 sister 是三单，疑问句借 does 动词还原 have，选 **C**。

                        *(2023·北京中考)* *— Let's play soccer after school. — That ________ like a good idea.*
                        A. sound   B. sounds   C. sounding   D. to sound
                        
                        **[解析]**：That 指代前面这件事，是单数，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的运动习惯 (My Sports)
                        #### 1. 写作要点
                        - **器材拥有情况**：I have a... / I don't have a...
                        - **喜欢的运动**：I like... because...
                        - **运动频率**：I play sports every day.

                        #### 2. 高分句式
                        - *I like sports very much.*
                        - *I have a collection of soccer balls.*
                        - *Playing basketball is very interesting for me.*
                        - *Let's go and play sports together!*

                        #### 3. 满分范文
                        **My Favorite Sport**
                        
                        I love sports. I have a basketball and two soccer balls. My favorite sport is basketball because it's very interesting and relaxing. I often play basketball with my classmates after school. I don't like volleyball because I think it's difficult. Sports are good for our health. Let's play together!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u6", "Unit 6", "Do you like bananas?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 饮食与健康。
                        *   **深层意义**：本单元围绕“饮食喜好与健康饮食”展开。旨在引导学生认识各种食物的名称，学会表达自己和他人的饮食偏好。更重要的是，通过区分健康食品与垃圾食品，培养学生养成均衡饮食的良好习惯，树立健康第一的生活理念。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **水果类**：banana (香蕉), apple (苹果), orange (橘子), strawberry (草莓), pear (梨)。
                        - **蔬菜类**：tomato (西红柿), potato (土豆), carrot (胡萝卜), vegetable (蔬菜)。
                        - **主食/肉类**：hamburger (汉堡包), bread (面包), rice (米饭), chicken (鸡肉)。
                        - **饮品/零食**：milk (牛奶), salad (沙拉), ice-cream (冰淇淋)。
                        - **形容词**：healthy (健康的), right (正确的), fat (胖的)。

                        ### 2. 核心短语金牌储备
                        - `think about` 思考；考虑
                        - `eating habits` 饮食习惯
                        - `ask sb. about sth.` 询问某人关于某事
                        - `healthy food` 健康食品
                        - `one last question` 最后一个问题
                        - `after dinner` 晚饭后
                        - `want to be fat` 想变胖
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Do you like bananas? (你喜欢香蕉吗？)
                        - **【考点详解】**：`like` 作实义动词，表示“喜欢”。询问喜好用一般疑问句 `Do/Does + 主语 + like...?`。
                        - **【用法拓展】**：表示一类事物时，可数名词要用复数（如 bananas），不可数名词用原形（如 milk）。
                        
                        #### 2. He doesn't like salad. (他不喜欢沙拉。)
                        - **【结构剖析】**：第三人称单数否定句。`doesn't` 后面接动词原形 `like`。
                        
                        #### 3. Let's have strawberries and apples. (让我们吃草莓和苹果吧。)
                        - **【避坑指南】**：`have` 在这里意为“吃/喝”，等同于 eat 或 drink。
                        
                        #### 4. I don't want to be fat. (我不想变胖。)
                        - **【语法延伸】**：`want to be + 形容词/名词` 表示“想成为/想变得...”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：可数名词与不可数名词 (入门)
                        - **可数名词**：可以论个算。有复数形式（加 -s/-es）。如：*apples, tomatoes*。
                        - **不可数名词**：不能论个算。没有复数形式。如：*milk, rice, bread*。
                        - **既可数又不可数**：*chicken* (作小鸡可数，作鸡肉不可数)；*salad* (作沙拉酱不可数，作一盘沙拉可数)；*ice-cream*。

                        ### 核心语法二：一般现在时的肯定、否定与疑问
                        - I like apples. -> I **don't** like apples. -> **Do** you like apples?
                        - He likes apples. -> He **doesn't** like apples. -> **Does** he like apples?

                        ### 中考真题特训
                        
                        *(2024·广东中考)* *I like eating ________ and ________.*
                        A. potato; chicken   B. potatoes; chicken   C. potatoes; chickens   D. potato; chickens
                        
                        **[解析]**：土豆是可数名词，表示一类用复数 potatoes；鸡肉是不可数名词，用原形，选 **B**。

                        *(2023·上海中考)* *My sister usually ________ an egg and some milk for breakfast.*
                        A. have   B. has   C. having   D. to have
                        
                        **[解析]**：主语 sister 是三单，谓语动词用 has，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的饮食习惯 (My Eating Habits)
                        #### 1. 写作逻辑
                        - **总述**：I have a healthy eating habit.
                        - **三餐描写**：分别描述早、中、晚三餐吃什么（For breakfast/lunch/dinner, I have...）。
                        - **喜好与原因**：I like... because... / I don't like...
                        - **总结**：Healthy food makes me strong.

                        #### 2. 高分句式
                        - *For breakfast, I always have some bread and a glass of milk.*
                        - *I like vegetables because they are good for my health.*
                        - *I don't eat ice-cream because I don't want to be fat.*

                        #### 3. 满分范文
                        **My Healthy Diet**
                        
                        Hello, I am Li Ming. I have good eating habits. For breakfast, I usually eat an egg and drink some milk. For lunch, I like rice, chicken and tomatoes. I think chicken is very delicious. For dinner, I eat vegetables and fruit. I like strawberries and apples very much. I don't eat hamburgers or ice-cream because they are not healthy and I don't want to be fat. Healthy food makes me strong and happy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u7", "Unit 7", "How much are these socks?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 购物与消费。
                        *   **深层意义**：本单元围绕“服装与购物”展开。旨在引导学生掌握购物时的交际用语，包括询问价格、颜色、尺码以及表达购买意愿。通过认识货币单位和商品价格，培养学生的理财意识和理性消费观念。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **服装鞋帽**：T-shirt (T恤衫), sweater (毛衣), skirt (裙子), socks (短袜), shoes (鞋), shorts (短裤), trousers (长裤)。
                        - **颜色形容词**：black (黑), white (白), red (红), green (绿), blue (蓝), yellow (黄)。
                        - **购物相关**：price (价格), dollar (美元), Yuan (元), sale (特卖), store (商店)。
                        - **形容词**：big (大), small (小), short (短), long (长)。

                        ### 2. 核心短语金牌储备
                        - `how much` 多少钱
                        - `Can I help you?` 我能帮您吗？
                        - `I'll take it.` 我买了。
                        - `Here you are.` 给你。
                        - `have a look at...` 看一看...
                        - `at a very good price` 以非常好的价格
                        - `on sale` 特价销售
                        - `for boys/girls` 给男孩/女孩们的
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. How much is this T-shirt? (这件T恤衫多少钱？)
                        - **【考点详解】**：`How much + be + 主语?` 用于询问价格。回答用 `It is / They are + 价格.`。
                        - **【语法延伸】**：`how much` 还可以修饰不可数名词，询问数量。*How much water do you need?*
                        
                        #### 2. What color do you want? (你想要什么颜色的？)
                        - **【结构剖析】**：`What color` 引导特殊疑问句询问颜色。
                        
                        #### 3. We have sweaters at a very good price. (我们的毛衣价格很实惠。)
                        - **【避坑指南】**：表示“以...的价格”，介词必须用 `at`。
                        
                        #### 4. I'll take it. (我买了。)
                        - **【社交礼仪】**：购物时决定购买某物的地道表达。`take` 这里意为“买下”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：How much 问价格
                        - 单数：`How much is the hat?` -> `It's five dollars.`
                        - 复数：`How much are the shoes?` -> `They're ten dollars.` (注意：成双成对的衣物如 shoes, socks, trousers 都是复数)。

                        ### 核心语法二：基数词 (10-30)
                        - 11-19：eleven, twelve, thirteen, fourteen, fifteen... (注意 13, 15, 18 的拼写)。
                        - 整十：twenty, thirty.

                        ### 中考真题特训
                        
                        *(2024·四川中考)* *— ________ are these red socks? — They are 10 yuan.*
                        A. How much   B. How many   C. How long   D. How often
                        
                        **[解析]**：根据答语 10 yuan 可知是问价格，选 **A**。

                        *(2023·江苏中考)* *This pair of shoes ________ very nice. I'll ________ them.*
                        A. look; buy   B. looks; take   C. look; take   D. looks; have
                        
                        **[解析]**：This pair of 作主语，谓语动词用单数 looks；决定买下用 take，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：商店促销海报 (A Sale Poster)
                        #### 1. 写作要素
                        - **吸引顾客**：Come and buy your clothes at...
                        - **商品与价格**：We have... for only...
                        - **颜色与人群**：... in red, green and white for girls/boys.
                        - **联系方式/地址**：Come to our store now!

                        #### 2. 高分句式
                        - *Welcome to Mr. Cool's Clothes Store!*
                        - *We sell all our clothes at very good prices.*
                        - *Do you need sweaters for school?*
                        - *Anybody can afford our prices!*

                        #### 3. 满分范文
                        **Huaxing Clothes Store Sale!**
                        
                        Come and buy your clothes at Huaxing's great sale! We sell all our clothes at very good prices. Do you need sweaters for the winter? We have warm sweaters for only $15. Do you like sports? We have great sports shoes for only $20. For girls, we have beautiful skirts in red, green and white for only $12. And socks are only $2 for three pairs! Come to Huaxing Clothes Store now!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u8", "Unit 8", "When is your birthday?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 时间与节日。
                        *   **深层意义**：本单元围绕“日期、月份与生日”展开。旨在引导学生学会用英语表达具体日期，关注自己和他人的生日及重要节日。通过举办生日派对等活动，增进同学间的友谊，培养感恩之心和时间规划能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **十二个月份**：January, February, March, April, May, June, July, August, September, October, November, December。
                        - **序数词**：first (第一), second (第二), third (第三), fifth (第五), eighth (第八), ninth (第九), twelfth (第十二), twentieth (第二十)。
                        - **节日/活动**：birthday (生日), party (派对), festival (节日), test (测试), trip (旅行), art (艺术)。
                        - **其他**：month (月), old (老的), term (学期), time (时间), busy (忙碌的)。

                        ### 2. 核心短语金牌储备
                        - `Happy birthday!` 生日快乐！
                        - `how old` 多大年纪
                        - `School Day` 学校开放日
                        - `sports meet` 运动会
                        - `art festival` 艺术节
                        - `English test` 英语测试
                        - `have a good time` 玩得开心
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. When is your birthday? (你的生日是什么时候？)
                        - **【考点详解】**：`When` 引导特殊疑问句询问日期或时间。
                        
                        #### 2. My birthday is on May 2nd. (我的生日在五月二日。)
                        - **【介词用法】**：在具体的某一天（如某月某日），介词用 `on`。如果只有月份，介词用 `in`（如 *in May*）。
                        
                        #### 3. How old are you? (你多大了？)
                        - **【结构剖析】**：询问年龄的固定句型。回答用 `I'm + 数字 (+ years old).`
                        
                        #### 4. We have an English test on November 15th. (我们在11月15日有一次英语测验。)
                        - **【避坑指南】**：`have a test` 意为“举行测验/参加测验”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：序数词的构成规律
                        **口诀**：
                        一二三，特殊记 (first, second, third)；
                        从四开始加 -th (fourth)；
                        八去 t，九去 e (eighth, ninth)；
                        ve 要用 f 替 (fifth, twelfth)；
                        整十把 y 变 ie，再加 -th (twentieth)；
                        几十几，只变个位就可以 (twenty-first)。

                        ### 核心语法二：日期的表达
                        - **写法**：Month + Date, Year. (May 2nd, 2024)
                        - **读法**：May the second, two thousand and twenty-four.

                        ### 中考真题特训
                        
                        *(2024·安徽中考)* *— When is Teachers' Day in China? — It's on ________.*
                        A. September 10th   B. October 1st   C. March 8th   D. June 1st
                        
                        **[解析]**：常识题，教师节在9月10日，选 **A**。

                        *(2023·广东中考)* *Today is my sister's ________ birthday. I will buy her a gift.*
                        A. twelve   B. twelfth   C. the twelfth   D. twelveth
                        
                        **[解析]**：表示“第十二个”生日，用序数词 twelfth，且前面已有形容词性物主代词 sister's，不能再加 the，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：学校活动日程安排 (School Activities)
                        #### 1. 写作思路
                        - **总述**：We have some interesting and fun things for you this term.
                        - **分述**：按时间顺序列出各项活动（On + 日期, we have...）。
                        - **结语**：This is a really busy term!

                        #### 2. 高分句式
                        - *On September 21st, we have a school trip in the afternoon.*
                        - *October is a great month.*
                        - *We have an art festival on November 3rd.*
                        - *Your parents can come to our school.*

                        #### 3. 满分范文
                        **Our School Calendar**
                        
                        Dear students, we have some interesting and fun things for you this term. On September 21st, we have a school trip. In October, we have a great festival. It's the sports meet on October 12th. Next, we have an art festival. It is on November 3rd. We have an English test on November 30th. On December 15th, we have a book sale in the school library. This is a really busy but happy term!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u9", "Unit 9", "My favorite subject is science.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 学习科目与时间表。
                        *   **深层意义**：本单元围绕“学校科目及喜好原因”展开。旨在引导学生全面了解各学科的特点，发现自己的兴趣所在。通过讨论科目和安排时间表，培养学生的学习规划能力和对不同知识领域的探索精神。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **学科名称**：subject (学科), science (科学), P.E. (体育), music (音乐), math (数学), Chinese (语文), geography (地理), history (历史)。
                        - **星期名词**：Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday。
                        - **形容词**：favorite (最喜爱的), free (空闲的), cool (酷的), useful (有用的), strict (严格的)。
                        - **其他**：why (为什么), because (因为), finish (完成), lesson (课)。

                        ### 2. 核心短语金牌储备
                        - `favorite subject` 最喜欢的科目
                        - `play games with sb.` 和某人玩游戏
                        - `the next day` 第二天
                        - `for sure` 肯定地；确切地
                        - `from ... to ...` 从...到...
                        - `after that` 在那之后
                        - `be strict with sb.` 对某人要求严格
                        - `have P.E.` 上体育课
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What's your favorite subject? (你最喜欢的科目是什么？)
                        - **【考点详解】**：`favorite` 意为“最喜爱的”，可作形容词或名词。相当于 `What subject do you like best?`。
                        
                        #### 2. Why do you like P.E.? (你为什么喜欢体育？)
                        - **【结构剖析】**：`Why` 引导特殊疑问句询问原因。
                        
                        #### 3. Because it's fun. (因为它很有趣。)
                        - **【考点详解】**：回答 `Why` 提问，必须用 `Because` 引导原因状语从句。
                        
                        #### 4. I am very busy from Monday to Friday. (我从周一到周五都很忙。)
                        - **【语法延伸】**：`from ... to ...` 表示时间或空间的起点和终点。星期前面不用加冠词。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：特殊疑问词的综合运用
                        - **What** 问内容 (What's your favorite...?)
                        - **Why** 问原因 (Why do you like...?)
                        - **Who** 问人物 (Who is your science teacher?)
                        - **When** 问时间 (When is your math class?)

                        ### 核心语法二：表时间的介词 (in, on, at)
                        - **in**：加年、月、季节、泛指的上下午晚上。 (*in 2024, in May, in the morning*)
                        - **on**：加具体的某一天、星期几、或特定的一天的上下午。 (*on Monday, on May 1st, on Sunday morning*)
                        - **at**：加具体的时间点。 (*at 8:00*)

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *— ________ is your English teacher? — Ms. Clark. She is very kind.*
                        A. What   B. Who   C. Where   D. How
                        
                        **[解析]**：根据回答是人名，可知问的是“谁”，选 **B**。

                        *(2023·广东中考)* *My favorite subject is history ________ it's very interesting.*
                        A. so   B. but   C. because   D. or
                        
                        **[解析]**：前后是因果关系，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我最喜欢的一天/科目 (My Favorite Day/Subject)
                        #### 1. 写作要点
                        - **点题**：点出最喜欢哪一天或哪个科目。
                        - **原因**：为什么喜欢？（有趣、老师好、有自己喜欢的课）。
                        - **日程安排**：列举这一天的具体课程或活动。
                        - **感受评价**：This day is busy but happy.

                        #### 2. 高分句式
                        - *My favorite day of the week is Friday.*
                        - *I like science because it is difficult but interesting.*
                        - *Mr. Wang is my math teacher and his classes are great.*
                        - *After school, I play sports with my friends.*

                        #### 3. 满分范文
                        **My Favorite Day**
                        
                        My favorite day is Friday because I have my favorite subjects. In the morning, I have Chinese and math. Math is difficult but I think it's useful. Then at 10:00, I have history. Mr. Smith is our history teacher. He is very funny and his classes are interesting. In the afternoon, I have P.E. from 2:00 to 3:00. I love P.E. because I can play soccer with my friends. After that, school finishes. I am always very happy on Friday.
                    """.trimIndent())
                )
            )
        )
    )
}
