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
        coverColor = Color(0xFFFFCCBC),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/qc9x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g9_u1", "Unit 1", "How can we become good learners?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 学习策略与方法。
                        *   **深层意义**：作为九年级的开篇，本单元聚焦于“如何学习”。旨在通过探讨各种高效的学习技巧（如看英语电影、查字典、小组合作），引导学生反思自己的学习习惯。强调终身学习的理念和面对困难时的毅力（patience），为冲刺中考打下心理和方法论基础。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **学习动作**：repeat (重复), note (笔记), pronounce (发音), memorize (记忆), review (复习), discover (发现)。
                        - **核心名词**：expression (表达), textbook (教科书), conversation (交际), grammar (语法), brain (大脑), knowledge (知识)。
                        - **抽象词汇**：patience (耐心), ability (能力), secret (秘密), chemistry (化学), physics (物理)。
                        - **形容词/副词**：wise (明智的), active (积极的), secret (秘密的), overnight (一夜之间)。

                        ### 2. 核心短语金牌储备
                        - `by doing sth.` 通过做某事 (**本单元语法核心**)
                        - `work with friends` 与朋友合作
                        - `listen to tapes` 听录音
                        - `ask sb. for help` 向某人寻求帮助
                        - `look up` 查阅（词典等）
                        - `take notes` 做笔记
                        - `pay attention to` 注意
                        - `connect ... with ...` 把...与...联系起来
                        - `be afraid to do sth.` 害怕做某事
                        - `fall in love with` 爱上
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. How do you study for a test? — I study by working with a group. (你如何准备考试？—— 我通过小组合作学习。)
                        - **【考点详解】**：`by + v.-ing` 结构表示手段、方式或方法。对该结构提问用 `How`。
                        
                        #### 2. The more you read, the faster you'll be. (你读得越多，你就变得越快。)
                        - **【结构剖析】**：`The + 比较级, the + 比较级` 表示“越...就越...”。
                        
                        #### 3. I sometimes don't understand what people are saying. (我有时听不懂人们在说什么。)
                        - **【语法核心】**：`what` 引导的宾语从句。从句使用陈述语序。
                        
                        #### 4. It's too hard to understand spoken English. (听懂英语口语太难了。)
                        - **【用法拓展】**：`It is + adj. + to do sth.` 重点考查 `it` 作形式主语。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：by + 动名词 (v.-ing)
                        **1. 功能**：表示通过某种方式、手段达到目的。
                        **2. 句式**：
                        - *I learn English **by watching** movies.*
                        **3. 特别注意**：对 `by...` 短语提问，必须用 `How`。
                        *   *— **How** do you improve your speaking? — **By talking** with foreigners.*

                        ### 核心语法二：宾语从句 (初步接触)
                        **1. 语序**：永远使用**陈述句语序**（主语在前，谓语在后）。
                        **2. 时态一致**：主句若是一般现在时，从句时态根据需要而定。

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— ________ do you know so much about the Silk Road? — By reading books and surfing the Internet.*
                        A. Why   B. How   C. Where   D. When
                        
                        **[解析]**：答语是由 by 引导的方式状语，提问用 How，选 **B**。

                        *(2023·北京中考)* *I've learned that ________ you practice, ________ you will be.*
                        A. more; better   B. the more; the better   C. most; best   D. the most; the best
                        
                        **[解析]**：考查“the+比较级，the+比较级”结构，表示“越...越...”，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的英语学习建议 (Advice on Learning English)
                        #### 1. 写作要点
                        - **存在的问题**：I have some problems with...
                        - **解决方法 (使用 by doing)**：First, you can learn by... Second, ...
                        - **态度与鼓励**：Don't be afraid. Believe in yourself.

                        #### 2. 高分句式
                        - *Many students think English is difficult.*
                        - *The best way to improve is by listening to tapes.*
                        - *You should not be afraid of making mistakes.*
                        - *As for grammar, you can learn it by taking notes.*

                        #### 3. 满分范文
                        **How to Learn English Well**
                        
                        Many students think learning English is a big challenge. Here is some advice for you. 
                        
                        First, listening is very important. You can improve it by listening to English songs or watching English movies. Second, don't be afraid to speak. You can practice your speaking by having conversations with your friends. Third, reading a lot is a good way to build your vocabulary. If you meet new words, you can look them up in a dictionary. Finally, remember that "Practice makes perfect." 
                        
                        I believe you can become a good English learner if you follow these methods.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u2", "Unit 2", "I think that mooncakes are delicious!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 历史、社会与文化（传统节日）。
                        *   **深层意义**：本单元围绕“中外传统节日”展开（如中秋节、端午节、泼水节、圣诞节、万圣节）。旨在引导学生用英语讲述节日传说（如嫦娥奔月），理解不同节日背后的文化内涵。通过对比，增强文化理解力，学会客观地评价和传播中华文化。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **节日名词**：lantern (灯笼), stranger (陌生人), relative (亲戚), goddess (女神), ghost (鬼魂), ancestor (祖先)。
                        - **动作与庆祝**：celebrate (庆祝), admire (欣赏), tie (捆绑), spread (传播), punish (惩罚), steal (偷)。
                        - **节日食物**：mooncake (月饼), dessert (甜点), zongzi (粽子)。
                        - **形容词/副词**：haunted (有鬼魂出没的), scary (吓人的), crowded (拥挤的)。

                        ### 2. 核心短语金牌储备
                        - `put on weight` 发胖；增加体重
                        - `lay out` 摆开；布置
                        - `give out` 分发
                        - `end up` 最终成为；最后处于
                        - `shoot down` 射下
                        - `shout out` 大声喊出
                        - `care about` 关心；在意
                        - `remind sb. of sth.` 使某人想起某事
                        - `the Water Festival` 泼水节
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I think that mooncakes are delicious! (我认为月饼很美味！)
                        - **【考点详解】**：`that` 引导的宾语从句。在口语中 `that` 常省略。
                        
                        #### 2. I wonder if they'll have the races again next year. (我不知道明年他们是否还会举行比赛。)
                        - **【结构剖析】**：`if / whether` 引导的宾语从句，意为“是否”。
                        
                        #### 3. What a great day! (多么棒的一天啊！)
                        - **【语法核心】**：`What` 引导的感叹句。结构：`What + a/an + adj. + n. + 主语 + 谓语!`。
                        
                        #### 4. How special the story is! (这个故事多么特别啊！)
                        - **【语法核心】**：`How` 引导的感叹句。结构：`How + adj./adv. + 主语 + 谓语!`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：宾语从句 (I) - that, if/whether 引导
                        **1. that 引导**：连接陈述句，that 无意义，常省略。
                        **2. if / whether 引导**：连接一般疑问句，意为“是否”。
                        - **注意**：宾语从句必须使用陈述句语序。

                        ### 核心语法二：感叹句 (Exclamatory Sentences)
                        - **What 型**：
                          1. *What + a/an + adj. + 可数名词单数 (+ 主谓)!*
                          2. *What + adj. + 名词复数/不可数名词 (+ 主谓)!*
                        - **How 型**：
                          *How + adj./adv. (+ 主谓)!*

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *I'm not sure ________ there will be a film tonight.*
                        A. what   B. that   C. whether   D. which
                        
                        **[解析]**：根据 I'm not sure，表示不确定，应用 whether (是否)，选 **C**。

                        *(2023·河北中考)* *________ great fun we had playing games yesterday!*
                        A. What   B. What a   C. How   D. How a
                        
                        **[解析]**：fun 是不可数名词，用 What 修饰，且不加 a，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍一个中国传统节日 (Chinese Traditional Festival)
                        #### 1. 写作逻辑
                        - **名称与时间**：... is a traditional festival in China. It's on...
                        - **习俗与食物**：People usually... They eat...
                        - **意义与感受**：It's a time for family. We feel...

                        #### 2. 高分句式
                        - *The Dragon Boat Festival is one of the most popular festivals.*
                        - *People celebrate it to remember Qu Yuan.*
                        - *The most exciting part is the dragon boat races.*
                        - *What a meaningful festival it is!*

                        #### 3. 满分范文
                        **The Mid-Autumn Festival**
                        
                        The Mid-Autumn Festival is a traditional Chinese festival. It falls on the 15th day of the 8th lunar month.
                        
                        On this day, the moon is round and bright. Family members usually get together and have a big dinner. We eat mooncakes and admire the full moon in the open air. Mooncakes are round, like the moon. They are a symbol of reunion. My grandmother often tells us the story of Chang'e. 
                        
                        I love this festival because it makes me feel warm and happy. How wonderful it is to spend time with my family!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u3", "Unit 3", "Could you please tell me where the restrooms are?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 社区服务与礼貌交际。
                        *   **深层意义**：本单元围绕“问路、咨询及公共场所交际”展开。旨在引导学生学会礼貌地向他人请求帮助。通过对比直接提问（Where is...?）与间接提问（Could you tell me where...?），理解语用差异，培养得体、文明的社交素养。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **地点名词**：restroom (洗手间), mall (购物中心), museum (博物馆), bookstore (书店), post office (邮局)。
                        - **指示与动作**：rush (仓促), suggest (建议), direct (直接的/指引), central (中央的)。
                        - **形容词/副词**：convenient (便利的), fascinating (迷人的), expensive (昂贵的), polite (礼貌的)。
                        - **其他词汇**：staff (职员), clerk (职员), request (要求), choice (选择)。

                        ### 2. 核心短语金牌储备
                        - `pardon me` 抱歉；请再说一遍
                        - `pass by` 路过；经过
                        - `on one's way to` 在去...的路上
                        - `suggest doing sth.` 建议做某事 (**必考：不能接 to do**)
                        - `look forward to` 期待
                        - `between A and B` 在A与B之间
                        - `turn left/right` 向左/右转
                        - `go past` 经过
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Could you please tell me where the restrooms are? (请问你能告诉我在哪儿吗？)
                        - **【考点详解】**：宾语从句的高级形式。从句语序必须陈述（where + 主语 + are）。
                        
                        #### 2. Do you know when the bookstore closes today? (你知道书店今天什么时候关门吗？)
                        - **【结构剖析】**：`when` 引导的宾语从句。
                        
                        #### 3. I wonder where I should go next. (我不知道接下来该去哪儿。)
                        - **【用法拓展】**：`wonder` 意为“想知道”，常接宾语从句。
                        
                        #### 4. To be polite, we often use indirect questions. (为了表现礼貌，我们常使用间接提问。)
                        - **【语法核心】**：`to be polite` 是动词不定式作目的状语。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：宾语从句 (II) - 特殊疑问词引导
                        **1. 引导词**：what, where, when, how, who, which 等。
                        **2. 核心原则：语序必须陈述！**
                        - *Where is the bank?* (直接提问)
                        - -> *Can you tell me **where the bank is**?* (宾语从句)
                        **3. 标点符号**：取决于主句。如果主句是疑问句，句末用问号；主句是陈述句，用句号。

                        ### 核心语法二：suggest 的用法
                        - `suggest sth. to sb.` (向某人建议某事)
                        - `suggest doing sth.` (建议做某事)
                        - **注意**：千万不能说 *suggest sb. to do sth.*。

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— Excuse me, do you know ________? — Sure. It's next to the library.*
                        A. where is the post office   B. where the post office is   C. when does the post office open   D. when the post office opens
                        
                        **[解析]**：宾语从句用陈述语序，根据回答“在图书馆旁边”可知问的是地点，选 **B**。

                        *(2023·上海中考)* *I suggest ________ to the park this afternoon.*
                        A. to go   B. go   C. going   D. goes
                        
                        **[解析]**：suggest doing sth.，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：礼貌询问与指路 (Asking for Help Politely)
                        #### 1. 写作要点
                        - **礼貌开头**：Excuse me. / Pardon me.
                        - **间接询问**：使用 Could you tell me...? / I wonder...
                        - **清晰指路**：Go straight, turn left, it's on your right.
                        - **感谢**：Thank you very much.

                        #### 2. 高分句式
                        - *Excuse me, I'm new here.*
                        - *Could you please tell me how I can get to...?*
                        - *Is it a long way from here?*
                        - *It's very kind of you.*

                        #### 3. 满分范文
                        **Asking the Way**
                        
                        A: Excuse me. Could you please tell me where the nearest bookstore is?
                        B: Sure. It's on Central Street. 
                        A: I wonder if it is a long way from here.
                        B: No, it's about 10 minutes' walk. Just go straight and turn right at the first crossing. Then go past a bank, and you'll see the bookstore on your left.
                        A: I see. Thank you very much!
                        B: You're welcome.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u4", "Unit 4", "I used to be afraid of the dark.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 成长与变化。
                        *   **深层意义**：本单元围绕“个人的过去与现状”展开。通过学习 `used to` 结构，引导学生对比自己在外貌、性格、爱好等方面的变化。旨在培养学生积极乐观的成长观，学会接受并拥抱变化，理解成长是一个不断克服恐惧、完善自我的过程。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **性格特征**：humorous (幽默的), silent (沉默的), helpful (有帮助的), brave (勇敢的), shy (害羞的)。
                        - **外貌描述**：curly (卷曲的), straight (直的), weight (重量), height (高度)。
                        - **动作与状态**：absent (缺席), fail (失败), influence (影响), dare (敢于), require (要求), pride (骄傲)。
                        - **其他名词**：background (背景), speech (演讲), insect (昆虫), guard (卫兵)。

                        ### 2. 核心短语金牌储备
                        - `used to` 过去常常 (**本单元核心**)
                        - `be afraid of` 害怕
                        - `deal with` 处理；对付
                        - `take pride in` 为...感到自豪
                        - `be proud of` 为...感到骄傲
                        - `in person` 亲身；亲自
                        - `give up` 放弃
                        - `from time to time` 时常
                        - `take up` 开始从事
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I used to be afraid of the dark. (我以前害怕黑暗。)
                        - **【考点详解】**：`used to + 动词原形` 表示过去常常做某事，而现在不再做了。
                        
                        #### 2. Did you use to be shy? (你以前很害羞吗？)
                        - **【结构剖析】**：疑问句：`Did + 主语 + use to do...?`。否定句：`didn't use to`。
                        
                        #### 3. He is now one of the most helpful students in our class. (他现在是班上最有帮助的学生之一。)
                        - **【用法拓展】**：`one of + 名词复数`。
                        
                        #### 4. It's been five years since I last saw her. (自从我上次见到她已经五年了。)
                        - **【语法核心】**：`It's been + 时间 + since + 过去时的从句`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：used to do sth.
                        **1. 含义**：表示过去经常发生的动作或存在的状态，但现在已不再。
                        **2. 句式**：
                        - 肯定：I used to play basketball.
                        - 否定：I **didn't use to** play...
                        - 疑问：**Did** you **use to** play...?
                        **3. 辨析 (必考)**：
                        - `used to do` (过去常常做)
                        - `be/get used to doing` (习惯于做某事)
                        - `be used to do` (被用来做某事)

                        ### 核心语法二：宾语从句的时态
                        主句是一般过去时，从句必须用**过去时态的某种形式**（如一般过去时、过去进行时、过去将来时）。

                        ### 中考真题特训
                        
                        *(2024·广东中考)* *I ________ silent in class, but now I am active.*
                        A. used to be   B. am used to being   C. was used to be   D. use to be
                        
                        **[解析]**：表达过去的状态，选 **A**。

                        *(2023·北京中考)* *Paper ________ making books in ancient China.*
                        A. used to   B. is used to   C. is used for   D. use to
                        
                        **[解析]**：纸被用来做书，表用途用 be used for doing 或 be used to do，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的变化 (My Changes)
                        #### 1. 写作逻辑
                        - **过去 (Past)**：I used to be... I used to like...
                        - **转折 (Change)**：However, something happened...
                        - **现在 (Now)**：Now I am... My favorite hobby is...
                        - **感悟**：Change is good for me.

                        #### 2. 高分句式
                        - *I have changed a lot in the last three years.*
                        - *I used to be short and thin, but now I am tall and strong.*
                        - *I didn't use to like English, but now I love it.*
                        - *My parents take pride in my growth.*

                        #### 3. 满分范文
                        **Great Changes in My Life**
                        
                        I have changed a lot since I came to middle school. 
                        
                        I used to be very shy and quiet. I was afraid to speak in front of many people. I also used to be short and a little heavy. I didn't like sports and spent most of my time playing computer games. 
                        
                        However, I am quite different now. I have become much more outgoing. I like making friends and sharing ideas. Also, I have taken up running. Now I am tall and strong. These changes have made me more confident. I think everyone should embrace changes to become a better person.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u5", "Unit 5", "What is it made of?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 科学技术与物品制造。
                        *   **深层意义**：本单元聚焦“物品的原材料、产地及传统工艺”（如风筝、剪纸、陶瓷）。旨在引导学生了解世界贸易与中国制造（Made in China）。通过介绍中国传统手工艺术，培养民族自豪感，理解在全球化背景下，如何传承和发扬传统文化。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **材料名词**：glass (玻璃), cotton (棉花), steel (钢), silver (银), silk (丝绸), wood (木头)。
                        - **农业与产品**：tea (茶), product (产品), brand (品牌), handbag (手提包), glove (手套)。
                        - **传统艺术**：kite (风筝), clay (黏土), paper cutting (剪纸), fairy tale (神话/童话)。
                        - **动词**：produce (生产), process (处理), chop (砍), pack (包装), avoid (避免), polish (擦亮)。

                        ### 2. 核心短语金牌储备
                        - `be made of` 由...制成 (**物理变化：看得出原材料**)
                        - `be made from` 由...制成 (**化学变化：看不出原材料**)
                        - `be known for` 以...闻名
                        - `be produced in` 在...生产
                        - `as far as I know` 据我所知
                        - `no matter` 不管；无论
                        - `turn into` 变成
                        - `according to` 根据
                        - `Made in China` 中国制造
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What is it made of? — It's made of silk. (它是由什么制成的？—— 由丝绸制成。)
                        - **【考点详解】**：一般现在时被动语态的特殊疑问句。
                        
                        #### 2. Tea is produced in many different areas of China. (茶叶在中国很多不同地区都有生产。)
                        - **【结构剖析】**：`is + 过去分词` 构成被动语态。
                        
                        #### 3. No matter what you may buy, you might find they were made in China. (无论你买什么，你可能发现它们是中国制造的。)
                        - **【用法拓展】**：`no matter what` 引导让步状语从句。
                        
                        #### 4. Kites were used for sending messages in the past. (过去风筝被用来传递信息。)
                        - **【语法核心】**：`be used for doing sth.` 被用来做某事。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：一般现在时的被动语态 (Passive Voice)
                        **1. 功能**：强调动作的承受者，或者不知道动作的执行者是谁。
                        **2. 构成**：`am / is / are + 动词的过去分词 (v.-ed)`。
                        **3. 句式变换**：
                        - 肯定：*English **is spoken** by many people.*
                        - 否定：*The room **is not cleaned** every day.*
                        - 疑问：***Is** tea **grown** in South China?*

                        ### 辨析 (中考必考)
                        - **be made of**：看不出原料 (错，是**看得出**) -> *The table is made of wood.*
                        - **be made from**：**看不出**原料 -> *Paper is made from wood.*
                        - **be made in**：产地。
                        - **be made by**：生产者。

                        ### 中考真题特训
                        
                        *(2024·四川中考)* *Many beautiful kites ________ in Weifang every year.*
                        A. make   B. made   C. are made   D. are making
                        
                        **[解析]**：主语 kites 与 make 之间是被动关系，且有 every year 提示用一般现在时，选 **C**。

                        *(2023·北京中考)* *Cheese is made ________ milk.*
                        A. of   B. from   C. in   D. by
                        
                        **[解析]**：芝士由牛奶制成，看不出牛奶的原样，属于化学变化，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍一种中国传统工艺品 (A Traditional Chinese Product)
                        #### 1. 写作逻辑
                        - **名称与地位**：... is a famous traditional product in China.
                        - **制作材料与过程**：It is made of... It is produced in...
                        - **功能与文化**：It is used for... People think it is a symbol of...

                        #### 2. 高分句式
                        - *... has a long history in China.*
                        - *It is widely known for its beauty.*
                        - *It is produced by hand.*
                        - *No matter where you go, you can see it.*

                        #### 3. 满分范文
                        **The Beauty of Paper Cutting**
                        
                        Paper cutting is one of the most popular traditional arts in China. 
                        
                        It has a history of more than 1,500 years. Paper cutting is usually made of red paper. It is produced in many parts of China. When people celebrate festivals, especially the Spring Festival, they like to put paper cuttings on windows or doors. They are symbols of luck and happiness. They are often made into the shapes of flowers, animals or characters. 
                        
                        Paper cutting is a great part of Chinese culture. We should do something to keep this traditional art alive.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u6", "Unit 6", "When was it invented?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 科学技术与人类文明（发明的历史）。
                        *   **深层意义**：本单元聚焦“伟大发明的起源及其影响”（如电话、电灯、拉链、薯片、茶）。旨在引导学生客观地看待科技进步，理解偶然发现（Accidental Inventions）背后的必然逻辑。通过探索发明背后的故事，激发学生的创新意识和探究精神，培养其对人类智慧文明的尊重。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **发明与创造**：invent (发明), discovery (发现), create (创造), designer (设计师), pioneer (先驱)。
                        - **物品名词**：telephone (电话), bell (铃铛), zipper (拉链), refrigerator (冰箱), earthquake (地震)。
                        - **生活与美食**：potato chips (薯片), tea (茶), salt (盐), vinegar (醋), sweet (甜的), sour (酸的), crispy (脆的)。
                        - **抽象词汇**：mistake (错误), customer (顾客), pleasure (愉快), accident (事故/意外), style (风格)。

                        ### 2. 核心短语金牌储备
                        - `be used for (doing) sth.` 被用来（做）某事
                        - `by accident` 偶然地；无意中
                        - `take place` 发生 (**不及物，无被动**)
                        - `without doubt` 毫无疑问
                        - `all of a sudden` 突然地
                        - `divide ... into ...` 把...分开
                        - `look up to` 钦佩；仰慕
                        - `at a high/low price` 以高/低价
                        - `the history of ...` ...的历史
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. When was the telephone invented? — It was invented in 1876. (电话是什么时候发明的？—— 1876年。)
                        - **【考点详解】**：一般过去时被动语态的特殊疑问句。强调动作发生的时间。
                        
                        #### 2. Tea was brought to Korea and Japan during the 6th and 7th centuries. (茶在6、7世纪被带到了朝鲜和日本。)
                        - **【结构剖析】**：`was + v.-ed` 构成被动语态。
                        
                        #### 3. Potato chips were invented by mistake. (薯片是无意中被发明的。)
                        - **【用法拓展】**：`by mistake` 意为“错误地；无意中”。
                        
                        #### 4. People believed that the earth was flat. (人们过去相信地球是平的。)
                        - **【语法核心】**：`that` 引导的宾语从句。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：一般过去时的被动语态 (Passive Voice)
                        **1. 功能**：描述过去发生的动作，且主语是动作的承受者。
                        **2. 构成**：`was / were + 动词的过去分词 (v.-ed)`。
                        **3. 句式变换**：
                        - 肯定：*The bridge **was built** ten years ago.*
                        - 否定：*The letter **was not sent**.*
                        - 疑问：***Were** these photos **taken** in Beijing?*

                        ### 辨析：take place vs happen (中考常考)
                        - **take place**：常指“举行”，通常指事先安排好的活动。
                        - **happen**：常指“发生”，多指偶然发生或突发事件。
                        - **共同点**：都是**不及物动词**，都没有被动语态！ (*It was happened* 错误)

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *The 19th Asian Games ________ in Hangzhou in 2023.*
                        A. held   B. were held   C. are held   D. was held
                        
                        **[解析]**：亚运会与举办之间是被动关系，且是2023年的事，主语是复数 Games，选 **B**。

                        *(2023·河北中考)* *Telephone ________ by Alexander Graham Bell in 1876.*
                        A. invented   B. was invented   C. is invented   D. invents
                        
                        **[解析]**：考察一般过去时的被动语态，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍一项伟大的发明 (A Great Invention)
                        #### 1. 写作要点
                        - **基本信息**：What is it? Who invented it? When was it invented?
                        - **发明过程**：Was it an accidental invention?
                        - **影响与意义**：How does it change our lives?

                        #### 2. 高分句式
                        - *I think ... is one of the most useful inventions.*
                        - *It was invented by ... in ...*
                        - *It is used for ... in our daily life.*
                        - *Without it, our lives would be very different.*

                        #### 3. 满分范文
                        **The Invention of Tea**
                        
                        Tea is one of the most popular drinks in the world. But do you know how it was invented?
                        
                        It is believed that tea was first discovered by the Chinese emperor Shen Nong about 5,000 years ago. One day, he was boiling water under a tree. All of a sudden, some leaves from the tree fell into the water. After he drank it, he found it was very delicious. That's how tea was invented by accident. 
                        
                        Today, tea is produced in many countries. It is healthy and can help people relax. I think it is a great invention that has made a big difference to the world.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u7", "Unit 7", "Teenagers should be allowed to choose their own clothes.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活与学习（青少年的规则与自由）。
                        *   **深层意义**：本单元围绕“校规、家规及青少年的自主权”展开。旨在引导学生在规则与个人自由之间寻找平衡。通过讨论是否应被允许“打耳洞、染发、选择衣服”，培养学生的辩证思维和社交沟通能力。强调责任（Responsibility）是拥有自由的前提，鼓励学生与家长、老师进行深度对话。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **规则与允许**：allow (允许), license (执照/许可证), safety (安全), smoke (吸烟), part-time (兼职的)。
                        - **情绪与态度**：regret (后悔), poem (诗), community (社区), field (田野), support (支持)。
                        - **动作词汇**：pierce (刺穿), flash (闪光), hug (拥抱), lift (举起), educate (教育), manage (管理)。
                        - **形容词/副词**：awful (极坏的), tiny (极小的), serious (严肃的), sleepy (困倦的)。

                        ### 2. 核心短语金牌储备
                        - `be allowed to do sth.` 被允许做某事 (**语法核心**)
                        - `choose one's own ...` 选择某人自己的...
                        - `get one's ears pierced` 打耳洞
                        - `stay up` 熬夜
                        - `stop sb. from doing sth.` 阻止某人做某事
                        - `get a part-time job` 找一份兼职工作
                        - `keep ... away from` 远离
                        - `make one's own decision` 自己做决定
                        - `take care of` 照顾
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Teenagers should be allowed to choose their own clothes. (青少年应该被允许选择他们自己的衣服。)
                        - **【考点详解】**：含情态动词的被动语态。结构：`should be + v.-ed`。
                        
                        #### 2. I think sixteen-year-olds should be allowed to get a driver's license. (我认为16岁的青少年应该被允许考驾照。)
                        - **【结构剖析】**：`sixteen-year-olds` 表示“16岁的人”，作名词用。
                        
                        #### 3. I regret talking back to my mom. (我后悔跟我妈顶嘴了。)
                        - **【用法拓展】**：`regret doing sth.` 后悔做了某事。对比 `regret to do sth.` 遗憾要做某事。
                        
                        #### 4. My parents are very strict with me. (我父母对我非常严厉。)
                        - **【语法核心】**：`be strict with sb.` 对某人严厉。`be strict in sth.` 对某事严格。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：含情态动词的被动语态
                        **1. 功能**：表示某种主观建议、必要性或可能性的被动动作。
                        **2. 构成**：`情态动词 (can/must/should/may) + be + 过去分词`。
                        - *The work **can be finished** in two days.*
                        - *Rules **must be followed**.*
                        
                        ### 辨析：stop / prevent / keep ... from doing (中考必考)
                        - `stop sb. (from) doing` (from可省)
                        - `prevent sb. (from) doing` (from可省)
                        - `keep sb. from doing` (**from不可省！**)

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *Teenagers ________ not ________ to smoke. It's bad for their health.*
                        A. should; allow   B. should; be allowed   C. must; allow   D. must; be allowed
                        
                        **[解析]**：主语是 Teenagers，与 allow 是被动关系，用 should be allowed 的否定形式，选 **B**。

                        *(2023·北京中考)* *We should do what we can ________ the pollution.*
                        A. to stop   B. stop   C. stopping   D. stopped
                        
                        **[解析]**：此处 to stop 作目的状语，注意 can 后面的动词省略了（如 do），不要误以为是 can stop，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：关于校规/家规的看法 (Rules and Freedom)
                        #### 1. 写作逻辑
                        - **现状描述**：What rules do you have?
                        - **观点表达**：Do you agree with them? Why or why not? (使用 should be allowed)。
                        - **建设性建议**：What changes would you like to see?

                        #### 2. 高分句式
                        - *In my opinion, some rules are necessary.*
                        - *I agree that we should wear school uniforms.*
                        - *On the other hand, I don't think we should be stopped from...*
                        - *I believe that communication can help solve problems.*

                        #### 3. 满分范文
                        **Should Students Be Allowed to Bring Mobiles to School?**
                        
                        Nowadays, many students bring mobile phones to school. In my opinion, students should not be allowed to use mobile phones in class.
                        
                        First, mobile phones can be very distracting. If students play games or text friends in class, they won't focus on their studies. Second, it's unfair to other students. However, I think we should be allowed to use them after school for safety reasons. For example, we can call our parents if we are late. 
                        
                        In a word, rules are important. We should follow the school rules while enjoying some freedom properly.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u8", "Unit 8", "It must belong to Carla.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活中的推测与推断。
                        *   **深层意义**：本单元围绕“根据线索进行逻辑推断”展开。通过寻找遗失物品的主人、解释奇怪的噪音（Stonehenge）等情境，引导学生学会运用逻辑思维解决问题。旨在培养学生的观察力（Observation）和分析力，鼓励学生不仅看表面现象，更要深入挖掘背后的逻辑。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **推测词汇**：must (肯定), might (可能), could (可能), can't (绝对不)。
                        - **物品名词**：truck (卡车), picnic (野餐), rabbit (兔子), laboratory (实验室), vest (背心), suit (西服)。
                        - **神秘与自然**：mystery (奥秘), Stonehenge (巨石阵), alien (外星人), creature (生物), circle (圆圈)。
                        - **动作词汇**：attend (参加), land (着陆), receive (收到), smell (闻到), chase (追逐)。

                        ### 2. 核心短语金牌储备
                        - `belong to` 属于 (**无被动，无进行时**)
                        - `make up` 编造；化妆；组成
                        - `use up` 用完；耗尽
                        - `be uneasy` 心神不安
                        - `run after` 追逐
                        - `have no idea` 不知道
                        - `at the same time` 同时
                        - `in charge of` 负责；掌管
                        - `communicate with` 交流
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. It must belong to Carla. (它一定属于卡拉。)
                        - **【考点详解】**：`must` 表示有把握的肯定推测。`belong to` 固定搭配。
                        
                        #### 2. It might/could be Linda's. (它可能是琳达的。)
                        - **【结构剖析】**：`might / could` 表示不太有把握的推测。
                        
                        #### 3. It can't be a dog. It's too big. (它不可能是狗。它太大了。)
                        - **【语法核心】**：`can't` 表示有把握的否定推测（不可能是）。
                        
                        #### 4. I have no idea what it is. (我不知道它是什么。)
                        - **【用法拓展】**：`what it is` 是宾语从句作 idea 的同位语（或宾语），语序为陈述语序。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：情态动词表推测
                        **1. 肯定推测**：
                        - `must`：100% 确定（一定...）。
                        - `could / might`：20-50% 确定（可能...）。
                        **2. 否定推测**：
                        - `can't`：100% 确定（不可能...）。
                        - `couldn't / might not`：可能不...。
                        **3. 疑问推测**：常用 `can`。
                        - *Can it be true?* (这可能是真的吗？)

                        ### 辨析：belong to vs one's (中考必考)
                        - `That book belongs to me.` (正确)
                        - `That book is mine.` (正确)
                        - `That book is belonged to me.` (错误！没有被动语态)

                        ### 中考真题特训
                        
                        *(2024·广东中考)* *— Whose dictionary is this? — It ________ be Li Hua's. Look, his name is on it.*
                        A. might   B. can't   C. must   D. could
                        
                        **[解析]**：根据后文“名字在上面”，可知是有把握的肯定推测，选 **C**。

                        *(2023·上海中考)* *The man ________ be our teacher. He has gone to Beijing.*
                        A. mustn't   B. can't   C. shouldn't   D. needn't
                        
                        **[解析]**：根据“他去北京了”，可知“不可能是”，否定推测用 can't，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：解开谜团 (Solving a Mystery)
                        #### 1. 写作逻辑
                        - **现状描述**：What happened? What did you see/hear?
                        - **线索分析**：Use clues (What are the facts?).
                        - **推测结论**：Use must, might, can't to explain your ideas.

                        #### 2. 高分句式
                        - *Something strange happened in our neighborhood.*
                        - *It could be ... because ...*
                        - *It can't be ... because ...*
                        - *The most likely explanation is that ...*

                        #### 3. 满分范文
                        **The Strange Noise**
                        
                        Last night, I heard a strange noise outside my window. It was a loud "thump". 
                        
                        First, I thought it might be a thief. But then I saw no one there. It couldn't be a thief because the yard gate was locked. Could it be a big bird? No, it couldn't be. The noise was too heavy for a bird. Finally, I went out with a flashlight. I found a big football under the tree. It must belong to my little brother. He must have left it there yesterday afternoon, and it just fell down from the chair. 
                        
                        Now the mystery is solved!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u9", "Unit 9", "I like music that I can dance to.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 文化、艺术与个人审美（音乐与电影）。
                        *   **深层意义**：本单元聚焦“个人喜好与审美取向”。通过学习定语从句，引导学生更加精确地描述自己喜欢的音乐类型、电影风格及艺术家（如阿炳的《二泉映月》）。旨在提升学生的艺术鉴赏力，学会用英语表达深刻的情感体验，理解艺术背后的灵魂与生命力。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **艺术与媒体**：music (音乐), movie (电影), director (导演), document (记录), drama (剧本/戏), dialogue (对话)。
                        - **乐器与名作**：guitar (吉他), Erhu (二胡), masterpiece (杰作), string (弦)。
                        - **形容词/感受**：smooth (悦耳的), lyrics (歌词), electronic (电子的), moving (动人的), painful (痛苦的)。
                        - **动作词汇**：dance (跳舞), suppose (推断), stick (坚持), prefer (更喜欢), sense (感觉到), pity (遗憾)。

                        ### 2. 核心短语金牌储备
                        - `prefer ... to ...` 相比...更喜欢...
                        - `dance to` 随着...跳舞
                        - `sing along with` 跟着...唱
                        - `stick to` 坚持；固守
                        - `be down` 悲伤；沮丧
                        - `in total` 总共
                        - `plenty of` 许多
                        - `shut off` 关闭；停止
                        - `once in a while` 偶尔地
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I like music that I can dance to. (我喜欢我可以随之跳舞的音乐。)
                        - **【考点详解】**：`that` 引导的定语从句，修饰 music。
                        
                        #### 2. I prefer movies that/which are scary. (我更喜欢恐怖电影。)
                        - **【结构剖析】**：`prefer ... that ...` 结构。注意 `that` 在从句中作主语。
                        
                        #### 3. He is the musician who/that wrote Erquan Yingyue. (他就是写了《二泉映月》的那个音乐家。)
                        - **【语法核心】**：先行词是人（musician），引导词用 `who` 或 `that`。
                        
                        #### 4. What a pity that you missed the concert! (你错过了音乐会，多么遗憾啊！)
                        - **【用法拓展】**：`It is a pity that ...` 结构的感叹句形式。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：定语从句 (I) - that, which, who 引导
                        **1. 先行词 (Antecedent)**：被修饰的名词或代词。
                        **2. 引导词 (Relative Pronouns)**：
                        - **人**：用 `who` 或 `that`。
                        - **物**：用 `which` 或 `that`。
                        **3. 只能用 that 的情况 (必考)**：
                        - 先行词被序数词或最高级修饰时。 (*the first book that...*)
                        - 先行词被 all, any, few, little, no, every 等修饰时。
                        - 先行词既有人又有物时。

                        ### 辨析：prefer 的常用结构 (中考常考)
                        - `prefer A to B` (相比B更喜欢A)
                        - `prefer doing A to doing B`
                        - `prefer to do A rather than do B`

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *I love movies ________ have happy endings.*
                        A. who   B. whom   C. which   D. what
                        
                        **[解析]**：先行词是 movies (物)，引导词用 which 或 that，选 **C**。

                        *(2023·北京中考)* *The teacher ________ teaches us English is very kind.*
                        A. which   B. who   C. whose   D. what
                        
                        **[解析]**：先行词是 teacher (人)，引导词用 who 或 that，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我最喜欢的音乐/电影 (My Favorite Music/Movie)
                        #### 1. 写作要点
                        - **类型描述**：What kind of music/movie do you like? (使用定语从句)。
                        - **特点分析**：Why do you like it? (Lyrics, melody, plot).
                        - **情感连接**：How do you feel when you listen to/watch it?

                        #### 2. 高分句式
                        - *I like music that has great lyrics.*
                        - *I prefer movies that can make me laugh.*
                        - *When I am down, I listen to ... to cheer myself up.*
                        - *It is the most moving story that I have ever heard.*

                        #### 3. 满分范文
                        **My Favorite Movie**
                        
                        I love watching movies in my free time. Among all the movies, my favorite is "The Lion King". 
                        
                        It is a cartoon movie that was made by Disney. I like it because it has a very moving plot and beautiful songs. The story is about a young lion who learns to be a brave king. It tells us that we should be responsible for our lives. Every time I watch it, I feel very encouraged. I prefer movies that can teach me something important about life. 
                        
                        I think "The Lion King" is a masterpiece that everyone should see.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u10", "Unit 10", "You're supposed to shake hands.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 礼仪与习俗（跨文化交际）。
                        *   **深层意义**：本单元围绕“不同国家的礼仪习俗”展开（如见面礼、用餐礼仪、守时观念）。通过学习 `be supposed to` 结构，引导学生理解文化多样性。旨在培养学生的跨文化交际意识（Cross-cultural Awareness），教导学生在异国他乡如何表现得体，尊重他人的文化禁忌，成为文明的“世界公民”。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **社交动作**：shake (握手), bow (鞠躬), kiss (亲吻), greet (问候), relax (放松)。
                        - **餐桌礼仪**：chopsticks (筷子), fork (叉子), spoon (勺子), knife (刀), napkins (餐巾)。
                        - **国家名词**：Brazil (巴西), Mexico (墨西哥), Japan (日本), Korea (朝鲜/韩国), Switzerland (瑞士)。
                        - **描述与态度**：relaxed (放松的), strict (严格的), polite (礼貌的), rude (无礼的), basic (基本的)。

                        ### 2. 核心短语金牌储备
                        - `be supposed to do sth.` 应该做某事 (**语法核心**)
                        - `shake hands` 握手
                        - `for the first time` 第一次
                        - `as soon as` 一...就...
                        - `to one's surprise` 令某人惊讶的是
                        - `drop by` 顺便拜访
                        - `make an effort` 努力
                        - `clean out` 清理
                        - `go out of one's way` 特地；费力
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. You're supposed to shake hands. (你应该握手。)
                        - **【考点详解】**：`be supposed to do` 表示“被期望做...；应该做...”，语气比 must 委婉。
                        
                        #### 2. In Japan, you're expected to bow when you meet someone for the first time. (在日本，当你第一次见到某人时，你应该鞠躬。)
                        - **【结构剖析】**：`be expected to do` 相当于 `be supposed to do`。
                        
                        #### 3. It's very important to be on time. (准时非常重要。)
                        - **【用法拓展】**：`on time` 准时；`in time` 及时。
                        
                        #### 4. You shouldn't point with your chopsticks. (你不应该用筷子指人。)
                        - **【语法核心】**：餐桌礼仪中的禁忌表达。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：be supposed to do sth.
                        **1. 含义**：表示根据规定、习俗、安排等“应该”做某事。
                        **2. 句式**：
                        - 肯定：*You **are supposed to** arrive at 7:00.*
                        - 否定：*You **are not supposed to** talk loudly.* (不应该/不准)
                        **3. 辨析：be supposed to vs should**：
                        - `be supposed to` 侧重于外界的期望或要求。
                        - `should` 侧重于说话人的主观建议。

                        ### 核心语法二：it 作形式主语
                        `It is + adj. + (for sb.) + to do sth.`
                        - *It is polite to greet people.*

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *In China, children ________ to take off their shoes before entering a house.*
                        A. are supposed   B. suppose   C. are supposing   D. supposed
                        
                        **[解析]**：考查 be supposed to 结构，选 **A**。

                        *(2023·北京中考)* *It's rude ________ loudly in the library.*
                        A. talk   B. talking   C. to talk   D. talked
                        
                        **[解析]**：It is + adj. + to do sth.，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍中国的礼仪习俗 (Table Manners in China)
                        #### 1. 写作要点
                        - **见面礼仪**：How to greet people?
                        - **用餐礼仪 (重点)**：Use chopsticks, Dos and Don'ts.
                        - **作客礼仪**：Be on time, bring a gift.

                        #### 2. 高分句式
                        - *When you are in China, you should know some basic manners.*
                        - *You are supposed to greet the oldest person first.*
                        - *It is impolite to stick your chopsticks into your food.*
                        - *You are not expected to eat with your hands.*

                        #### 3. 满分范文
                        **Table Manners in China**
                        
                        If you are invited to a dinner in China, you should follow some table manners. 
                        
                        First, you are supposed to wait for the elders to start eating first. It shows your respect. Second, you are not supposed to point at others with your chopsticks. It is very rude. Also, you shouldn't make too much noise while eating soup. Third, when you want to take food from a dish, you'd better take the piece that is closest to you. 
                        
                        In a word, "When in Rome, do as the Romans do." Following these rules will help you have a pleasant dinner with your Chinese friends.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u11", "Unit 11", "Sad movies make me cry.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 情感、心态与健康。
                        *   **深层意义**：本单元聚焦于“事物对情绪的影响”。通过探讨音乐、天气、颜色、电影、广告及他人的言行如何左右我们的感受，引导学生建立情感自觉。旨在教导学生如何管理负面情绪，在竞争中保持平常心（如足球比赛、金钱与快乐的关系），树立正确的金钱观和价值观。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **情感与感觉**：comfortable (舒适的), uncomfortable (不舒服的), nervous (紧张的), relieved (放心的), jealous (嫉妒的), crazy (疯狂的)。
                        - **动作词汇**：examine (检查), skip (跳过), kick (踢), nod (点头), disappointed (失望的)。
                        - **抽象词汇**：friendship (友谊), goal (目标/得分), power (权力), wealth (财富), courage (勇气), shame (羞耻)。
                        - **其他**：lemon (柠檬), concert (音乐会), grey (灰色的), neither (也不)。

                        ### 2. 核心短语金牌储备
                        - `make sb. + adj.` 使某人... (**语法核心**)
                        - `make sb. do sth.` 使某人做某事 (**语法核心**)
                        - `rather than` 而不是
                        - `leave out` 忽略；遗漏
                        - `be hard on sb.` 对某人严厉
                        - `let sb. down` 使某人失望
                        - `kick sb. off` 把某人开除
                        - `be friends with sb.` 与某人交朋友
                        - `to start with` 起初；开始时
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Sad movies make me cry. (悲伤的电影使我哭泣。)
                        - **【考点详解】**：`make sb. do sth.` 结构中，`make` 是使役动词，后接省略 to 的不定式作宾语补足语。
                        
                        #### 2. Waiting for her made me angry. (等她使我很生气。)
                        - **【结构剖析】**：`make sb. + adj.` 结构。`Waiting for her` 是动名词短语作主语。
                        
                        #### 3. The loud music makes me want to leave. (响亮的音乐使我想离开。)
                        - **【用法拓展】**：`make sb. do sth.` 的变体，宾补是一个含有不定式的短语。
                        
                        #### 4. Neither money nor power can give you true happiness. (金钱和权力都不能给你真正的幸福。)
                        - **【语法核心】**：`neither ... nor ...` 连接并列成分，作主语时谓语遵循“就近原则”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：make 的用法汇总
                        **1. make sb. + adj.**：使某人处于某种状态。
                        - *Winning the game made us **happy**.*
                        **2. make sb. do sth.**：使某人做某事。
                        - *My boss made me **work** ten hours a day.*
                        **3. 特别注意：被动语态中 to 要还原！**
                        - *I **was made to work** ten hours a day.* (中考高频考点)

                        ### 核心语法二：neither ... nor ...
                        - **含义**：既不...也不...。
                        - **就近原则**：*Neither you nor **he is** wrong.*

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *The teacher made the students ________ the words ten times.*
                        A. write   B. to write   C. writing   D. wrote
                        
                        **[解析]**：make sb. do sth.，选 **A**。

                        *(2023·广东中考)* *I was made ________ the piano for two hours every day when I was a child.*
                        A. play   B. to play   C. playing   D. played
                        
                        **[解析]**：make sb. do sth. 变为被动语态，不定式符号 to 必须还原，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：谈谈颜色/音乐对你的影响 (Effects of Colors/Music)
                        #### 1. 写作要点
                        - **点题**：Different things make me have different feelings.
                        - **具体阐述**：Music/Colors make me feel... (使用 make 句型)。
                        - **总结建议**：How to keep a good mood.

                        #### 2. 高分句式
                        - *Music has a great effect on my feelings.*
                        - *Soft music makes me feel relaxed after a busy day.*
                        - *Loud music, however, makes me want to cover my ears.*
                        - *I prefer bright colors because they make me feel energetic.*

                        #### 3. 满分范文
                        **How Music Affects Me**
                        
                        Music is a part of my life. Different kinds of music can make me have different feelings.
                        
                        When I feel stressed or tired, I like to listen to soft and quiet music. It makes me feel relaxed and peaceful. It can even help me fall asleep quickly. On the other hand, fast and loud music always makes me feel energetic. When I exercise, I prefer this kind of music. It makes me want to move and never give up. 
                        
                        In a word, music can influence my mood a lot. I think it is a great way to help us manage our emotions.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u12", "Unit 12", "Life is full of the unexpected.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活中的意外与遗憾。
                        *   **深层意义**：本单元围绕“过去发生的意外事件”展开。通过描述错过早班车、忘记带钥匙、甚至重大的历史事件（如911事件中的幸存者），学习过去完成时。旨在引导学生学会客观地叙述过去，反思生活中的不确定性，培养面对挫折时的乐观心态和对时间的规划意识。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **生活琐事**：backpack (背包), overshoot (超载), block (街区), worker (工人), stair (楼梯)。
                        - **动作词汇**：oversleep (睡过头), ring (响), burn (燃烧), stare (凝视), disappear (消失), discover (发现)。
                        - **形容词/状态**：unexpected (出乎意料的), alive (活着的), cream (奶油色的), empty (空的), embarrassed (尴尬的)。
                        - **其他**：airport (机场), market (市场), bean (豆), officer (官员)。

                        ### 2. 核心短语金牌储备
                        - `by the time ...` 到...的时候为止 (**语法标志词**)
                        - `go off` (闹钟) 发出响声
                        - `show up` 出现；露面
                        - `run off` 跑掉；迅速离开
                        - `on time` 准时
                        - `in line with` 与...成一排
                        - `stare at` 凝视；盯着看
                        - `take off` (飞机) 起飞；脱下
                        - `get a ride` 乘便车
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. By the time I got up, my brother had already gone into the shower. (到我起床的时候，我哥哥已经进浴室冲凉了。)
                        - **【考点详解】**：过去完成时的标准用法。`got up` 发生在过去，`gone into` 发生在“过去的过去”。
                        
                        #### 2. When I got to school, I realized I had left my backpack at home. (当我到达学校时，我意识到我把书包落在家里了。)
                        - **【结构剖析】**：`realized` 是过去时，`had left` 是在意识到之前发生的动作。
                        
                        #### 3. I was about to go up when I decided to get a coffee first. (我正要上去，这时我决定先买杯咖啡。)
                        - **【用法拓展】**：`be about to do sth. when ...` 正要做某事，就在这时...
                        
                        #### 4. I was so lucky that I stayed alive. (我很幸运，我活了下来。)
                        - **【语法核心】**：`so ... that ...` 结构。`alive` 是表语形容词，不能作定语修饰名词。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：过去完成时 (Past Perfect Tense)
                        **1. 功能**：表示在过去某一时间或动作之前已经发生或完成的动作（即“过去的过去”）。
                        **2. 构成**：`had + 动词的过去分词 (v.-ed)`。
                        **3. 标志词 (中考眼位)**：
                        - `By the time + 一般过去时的从句`
                        - `When / Before / After + 动作对比`
                        - `Already / yet` 在过去语境中的应用。

                        ### 辨析：leave vs forget (中考常考)
                        - **leave**：指把某物遗留在某地。`leave sth. + 地点`。
                        - **forget**：指忘记某事或某物，通常不接具体地点。

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *When I arrived at the cinema, the movie ________ for ten minutes.*
                        A. had begun   B. had been on   C. began   D. was beginning
                        
                        **[解析]**：arrived 是过去，电影开始在 arrived 之前，且 for ten minutes 要求延续性动词，选 **B**。

                        *(2023·北京中考)* *By the time we got to the station, the train ________.*
                        A. left   B. has left   C. had left   D. was leaving
                        
                        **[解析]**：By the time 引导从句用过去时，主句用过去完成时，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：一个倒霉/难忘的一天 (An Unexpected Day)
                        #### 1. 写作要素
                        - **起因**：What happened first? (Overslept, forgot something).
                        - **经过**：The sequence of events (使用 By the time, when, had done)。
                        - **结果**：How did it end?
                        - **感悟**：What did you learn?

                        #### 2. 高分句式
                        - *It was the most unexpected day I have ever had.*
                        - *By the time I woke up, it was already 8:00 a.m.*
                        - *I had just finished breakfast when I realized...*
                        - *Luckily, things didn't go too bad in the end.*

                        #### 3. 满分范文
                        **A Bad Morning**
                        
                        Yesterday was a terrible day for me. Everything went wrong.
                        
                        First, my alarm clock didn't go off, so I overslept. By the time I woke up, it was already 7:30 a.m. I rushed to the bathroom, but my brother had already gone in. After a quick breakfast, I ran to the bus stop. However, the bus had already left. I had to walk to school. When I finally got to the classroom, I realized that I had left my math book at home. 
                        
                        What a bad morning! From this experience, I learned that I should prepare everything the night before.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u13", "Unit 13", "We're trying to save the earth!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自然 —— 环境保护与可持续发展。
                        *   **深层意义**：本单元聚焦“环境污染现状及环保行动”。通过讨论空气、水、土地污染及濒危动物保护，学习“Reduce, Reuse, Recycle (3Rs)”理念。旨在引导学生从我做起，从小事做起（如不用塑料袋、骑自行车、废物利用），培养全球公民的环保责任感。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **污染与环境**：pollution (污染), environment (环境), litter (垃圾), garbage (垃圾), waste (浪费/废弃物)。
                        - **资源与工业**：fuel (燃料), coal (煤), oil (石油), industry (工业), metal (金属), plastic (塑料)。
                        - **动作词汇**：recycle (回收), reuse (再利用), reduce (减少), transport (运输), afford (支付得起)。
                        - **形容词**：harmful (有害的), cruel (残忍的), scientific (科学的), effective (有效的)。

                        ### 2. 核心短语金牌储备
                        - `be harmful to` 对...有害
                        - `at the top of` 在...顶部
                        - `take part in` 参加；参与
                        - `pay for` 付费
                        - `take action` 采取行动
                        - `throw away` 扔掉
                        - `put ... to good use` 充分利用...
                        - `make a difference` 产生影响
                        - `stop sb. from doing sth.` 阻止某人做某事
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. We're trying to save the earth! (我们正在努力拯救地球！)
                        - **【考点详解】**：现在进行时强调正在进行的环保努力。
                        
                        #### 2. The air is badly polluted. (空气被严重污染了。)
                        - **【结构剖析】**：被动语态。`badly` 是副词，修饰过去分词 polluted。
                        
                        #### 3. We should use public transport instead of driving. (我们应该使用公共交通而不是开车。)
                        - **【用法拓展】**：`instead of` 后面接名词、代词或动名词。
                        
                        #### 4. It's our duty to protect the environment. (保护环境是我们的责任。)
                        - **【语法核心】**：`It's one's duty to do sth.` 重点考查形式主语 it。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：时态语态大综合
                        九年级下学期要求学生能在环保这一宏大主题下灵活运用：
                        - 现在进行时：描述正在进行的污染或保护。
                        - 被动语态：描述环境被破坏的现状。
                        - 情态动词：提出环保建议 (should, must)。
                        - 现在完成时：描述已经造成的环境影响。

                        ### 核心语法二：used to, be used to, get used to (终极辨析)
                        - `used to do`：过去常常。
                        - `be used to do`：被用来做。
                        - `be used to doing`：习惯于。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *We should stop people from ________ trees to protect the environment.*
                        A. cut down   B. to cut down   C. cutting down   D. cuts down
                        
                        **[解析]**：stop sb. from doing sth.，选 **C**。

                        *(2023·上海中考)* *More and more trees ________ on the mountains every year.*
                        A. plant   B. planted   C. are planted   D. are planting
                        
                        **[解析]**：树与种之间是被动关系，且有 every year，用一般现在时的被动语态，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：如何保护环境 (How to Protect the Environment)
                        #### 1. 写作逻辑
                        - **现状描述**：Pollution is serious now.
                        - **具体措施**：What can we do in daily life? (3Rs, public transport).
                        - **呼吁总结**：Let's work together to save the earth.

                        #### 2. 高分句式
                        - *The environment is becoming worse and worse.*
                        - *To protect our home, we should take action right now.*
                        - *It's a good idea to recycle paper and bottles.*
                        - *Even a small action can make a big difference.*

                        #### 3. 满分范文
                        **Save Our Earth**
                        
                        Environmental protection is very important for everyone. Our earth is in danger because of pollution. What can we do to save it?
                        
                        First, we should follow the "3Rs" — reduce, reuse and recycle. For example, we can reuse shopping bags instead of using plastic ones. Second, we should save energy. We are supposed to turn off the lights when we leave a room. Third, it's better to go to school by bike or on foot. This can reduce air pollution. Finally, we should stop people from littering. 
                        
                        If everyone makes an effort, our world will become more and more beautiful.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u14", "Unit 14", "I remember meeting all of you in Grade 7.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 毕业、回忆与未来。
                        *   **深层意义**：作为初中阶段的最后一个单元，本单元聚焦于“毕业感怀”。通过回顾三年的校园生活（如军训、运动会、老师的教导、同学的友谊），表达对母校的眷恋。旨在引导学生学会感恩（Gratitude），在毕业之际对未来做出庄严承诺，展示青少年积极向上的精神风貌。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **回顾与情感**：remember (记得), overcome (克服), proud (自豪的), thankful (感激的), graduate (毕业)。
                        - **动作词汇**：congratulate (祝贺), thirst (口渴/渴望), level (水平), double (双倍)。
                        - **抽象词汇**：survey (调查), standard (标准), method (方法), instruction (教导/说明)。
                        - **地点与身份**：senior high (高中), keyboard (键盘), manager (经理)。

                        ### 2. 核心短语金牌储备
                        - `remember doing sth.` 记得做过某事 (**语法标志词**)
                        - `win a prize` 获奖
                        - `make a mess` 弄得一团糟
                        - `keep one's cool` 保持冷静
                        - `be thirsty for` 渴望
                        - `be proud of` 为...自豪
                        - `set out` 出发；启程
                        - `go one's separate ways` 分道扬镳
                        - `believe in oneself` 相信自己
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I remember meeting all of you in Grade 7. (我记得初一见到你们大家的情景。)
                        - **【考点详解】**：`remember doing sth.` 记得做过某事（已发生）。对比 `remember to do sth.` 记得要做某事（未发生）。
                        
                        #### 2. I have learned to be more independent. (我已经学会了更加独立。)
                        - **【结构剖析】**：现在完成时强调三年的学习结果。
                        
                        #### 3. We have overcome many difficulties together. (我们已经一起克服了许多困难。)
                        - **【用法拓展】**：`overcome` 是不规则动词，过去分词仍为 `overcome`。
                        
                        #### 4. I am looking forward to senior high school. (我正期待着高中生活。)
                        - **【语法核心】**：`look forward to` 后面接名词或动名词。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：初中英语全时态/全语态总复习
                        本单元作为收官之作，要求学生能在毕业演讲的情境下熟练运用：
                        - 一般过去时：回忆过去的趣事。
                        - 现在完成时：总结三年的收获。
                        - 一般将来时：展望未来的高中生活。

                        ### 辨析：remember / forget / regret (doing vs to do)
                        - `doing`：事情已经发生 (记得做过/忘记做过/后悔做过)。
                        - `to do`：事情还未发生 (记得要做/忘记要做/遗憾要做)。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *I will never forget ________ the tree with my classmates three years ago.*
                        A. plant   B. to plant   C. planting   D. plants
                        
                        **[解析]**：forget doing sth. 忘记做过某事，根据 three years ago 可知事情已发生，选 **C**。

                        *(2023·河北中考)* *Congratulations ________ you on your graduation!*
                        A. to   B. for   C. with   D. at
                        
                        **[解析]**：Congratulations to sb. on sth. 固定搭配，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：毕业演讲稿 (A Graduation Speech)
                        #### 1. 写作逻辑
                        - **开场白**：Greetings and purpose.
                        - **回忆往事**：Memory of Grade 7/8/9.
                        - **表达感谢**：Thank teachers, parents and friends.
                        - **展望未来**：Future plans and wishes.

                        #### 2. 高分句式
                        - *Time flies! It has been three years since...*
                        - *I will never forget the time we spent together.*
                        - *Thanks to my teachers, I have learned a lot.*
                        - *I believe that our future will be bright.*

                        #### 3. 满分范文
                        **A Graduation Speech**
                        
                        Good morning, teachers and fellow students!
                        
                        It is a great honor for me to stand here. Time flies! Three years have passed since we first met in Grade 7. I still remember the first day I came to this school. I was so shy and quiet at that time. 
                        
                        During these three years, we have learned many things and made many friends. We have also overcome many difficulties together. I want to say thanks to our teachers. You have taught us so much and helped us grow up. I also want to thank my friends for your support. 
                        
                        Now we are going to set out on a new journey. I hope all of us can try our best in senior high school. Believe in ourselves, and our dreams will come true. 
                        
                        Thank you!
                    """.trimIndent())
                )
            )
        )
    )
}
