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
        coverColor = Color(0xFFE1F5FE),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc9q_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g9full_u1", "Unit 1", "How can we become good learners?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：学习与生活 (Learning and life)
                        *   **子主题**：学习方法，终身学习，克服困难 (Learning strategies)。

                        ### 2. 单元主题内容
                        作为九年级的开篇，本单元聚焦“学习策略”。通过探讨不同的英语学习方法（如 watching English movies, making word cards, asking the teacher 等），引导学生找到最适合自己的学习路径。单元强调了学习中的情感因素（如 interest, persistence），鼓励学生面对困难不退缩，培养高效学习的能力和终身学习的意识。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **学习动作**：pronounce (发音), memorize (记忆), repeat (重复), note (笔记), discover (发现).
                        - **核心名词**：expression (表达方式), grammar (语法), physics (物理), chemistry (化学), secret (秘密).
                        - **高频短语**：by doing sth. (通过做某事), word by word (逐字地), fall in love with (爱上), look up (查阅), pay attention to (注意).

                        ### 2. 核心句式
                        1.  **询问方法**：How do you study for a test? — I study by working with a group.
                        2.  **表达困难**：It's too hard to understand spoken English.
                        3.  **给出建议**：Why don't you read aloud to practice pronunciation?
                        4.  **描述过程**：The more you read, the faster you'll be.

                        ### 3. 重点语法
                        - **by + v.-ing** 结构表达方式、手段。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Jack**: How do you study for a test, Annie? 
                        
                        **Annie**: I study by making word cards. It really helps. 
                        
                        **Jack**: Have you ever studied with a group? 
                        
                        **Annie**: Yes, I have. I've learned a lot that way. 
                        
                        **Jack**: What about listening to tapes? 
                        
                        **Annie**: Oh, it's too hard to understand the voices. 

                        **【译文】**
                        
                        **杰克**：安妮，你如何为考试复习？
                        
                        **安妮**：我通过制作单词卡片来学习。这很有帮助。
                        
                        **杰克**：你曾经参加过小组学习吗？
                        
                        **安妮**：是的，参加过。那样我学到了很多。
                        
                        **杰克**：听录音带怎么样？
                        
                        **安妮**：噢，要听懂那些声音太难了。

                        ### Section B (Reading) 阅读文段：How I Learned to Learn English
                        **【原文】**
                        
                        Last year, I did not like my English class. Every class was like a bad dream. But one day, I watched an English movie called Toy Story. I fell in love with the characters. I started to listen to the expressions and look them up in a dictionary. Now, I find that the secret to good learning is interest. If you enjoy it, you will learn well.

                        **【译文】**
                        
                        去年，我不喜欢英语课。每一节课都像场噩梦。但有一天，我看了部名叫《玩具总动员》的英语电影。我爱上了其中的角色。我开始倾听那些表达方式并查阅词典。现在，我发现学好英语的秘诀是兴趣。如果你乐在其中，你就能学好。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. How can we become good learners? (我们怎样才能成为优秀的学习者？)
                        - **【句式剖析】**：`How` 引导特殊疑问句询问手段或方式。
                        
                        #### 2. I study by listening to English songs. (我通过听英文歌学习。)
                        - **【要点精讲】**：`by + v.-ing` 是本单元的核心语法，表示“通过...方式”。
                        
                        #### 3. It's too hard to understand the voices. (要听懂那些声音太难了。)
                        - **【词块归纳】**：`It is + adj. + to do sth.` 做某事是...的。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① look up (查阅; 抬头看)
                        - **【用法】**：动副短语。名词放中间或后，代词放中间。
                        - **【例题】**：
                        
                        *If you don't know the word, you can ________ in the dictionary.*
                        A. look it up   B. look up it   C. look for it   D. look at it
                        
                        **[解析]**：查阅单词用 look up，代词 it 放中间，选 **A**。

                        #### ② the more ... the more ... (越...就越...)
                        - **【用法】**：表示一方随另一方的程度增加而增加。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：by + 动名词的“万能”用法
                        **1. 含义**
                        表示通过某种手段、方式或方法。
                        
                        **2. 常见场景**
                        - *How do you go to school? — By bus.* (乘车)
                        - *How did you do that? — By working hard.* (通过努力)

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *You can improve your English ________ reading more books.*
                        A. in   B. by   C. with   D. for
                        
                        **[解析]**：通过读书来提高英语，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Advice on Learning English (我的英语学习建议)
                        **Many students think learning English is difficult.**
                        
                        In my opinion, the best way is **by watching English movies**. It's very interesting. You can also **practice speaking** by **talking with friends**. Don't be afraid of **making mistakes**. The **secret** to success is **interest and practice**. I hope my advice will help you.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u2", "Unit 2", "I think that mooncakes are delicious!",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：历史、社会与文化 (History and culture)
                        *   **子主题**：国内外传统节日，习俗与传统 (Festivals and traditions)。

                        ### 2. 单元主题内容
                        本单元以“节日与文化”为主题，重点学习宾语从句（Objective Clauses）。通过探讨中国的传统节日（如 Mid-Autumn Festival, Dragon Boat Festival）以及西方的节日（如 Halloween, Christmas），学生能够运用 `that`, `whether/if` 引导的从句来表达个人观点和客观事实。单元旨在培养学生的文化意识，学会在跨文化交流中自信地传播中华文化。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **节日名词**：mooncake, lantern, stranger, relative (亲戚), pound (磅).
                        - **核心动词/形容词**：steal (偷), lay (放置), admire (欣赏), haunted (闹鬼的).
                        - **高频短语**：the Lantern Festival, the Dragon Boat Festival, shoot down (射下), put on (增加重量), lay out (摆开).

                        ### 2. 核心句式
                        1.  **陈述观点**：I think that mooncakes are delicious.
                        2.  **表达感受**：I wonder whether they'll have a race again next year.
                        3.  **描述节日**：What a fun festival it is!
                        4.  **感叹句**：How beautifully the lanterns shine!

                        ### 3. 重点语法
                        - **宾语从句**（由 that, if/whether 引导）。
                        - **感叹句**（How 与 What 引导）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Bill**: Did you know that the Mid-Autumn Festival is coming? 
                        
                        **Lin Tao**: Yes, I think that mooncakes are really delicious. 
                        
                        **Bill**: I agree. I wonder if there will be a full moon tonight. 
                        
                        **Lin Tao**: I hope so. People like to admire the moon with their families. 
                        
                        **Bill**: What a beautiful tradition!

                        **【译文】**
                        
                        **比尔**：你知道中秋节快到了吗？
                        
                        **林涛**：知道，我觉得月饼真的很好吃。
                        
                        **比尔**：我同意。我想知道今晚是否会有圆月。
                        
                        **林涛**：我希望如此。人们喜欢和家人一起赏月。
                        
                        **比尔**：多么优美的传统啊！

                        ### Section B (Reading) 阅读文段：The Spirit of Christmas
                        **【原文】**
                        
                        Christmas is an important festival in Western countries. Many people think that it's just about gifts and food. But the true spirit of Christmas is sharing and giving. Charles Dickens' story, A Christmas Carol, tells us about this. Scrooge, a mean man, changes his life after seeing three ghosts. He realizes that helping others makes him happy.

                        **【译文】**
                        
                        圣诞节是西方国家的一个重要节日。许多人认为它仅仅关乎礼物和美食。但圣诞节真正的精神是分享和给予。查尔斯·狄更斯的故事《圣诞颂歌》告诉了我们这一点。守财奴斯克鲁奇在见到三个幽灵后改变了他的生活。他意识到帮助他人让他快乐。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. I think that mooncakes are delicious. (我觉得月饼很好吃。)
                        - **【句式剖析】**：`that` 引导宾语从句，在口语中经常省略。
                        
                        #### 2. What a fun festival! (多么有趣的节日啊！)
                        - **【要点精讲】**：`What` 引导感叹句，中心词是名词 `festival`。
                        
                        #### 3. I wonder whether they'll have a race. (我想知道他们是否会举行比赛。)
                        - **【词块归纳】**：`whether` 引导宾语从句，意为“是否”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① put on (增加; 穿上; 上演)
                        - **【用法】**：在本单元指“体重增加”。*put on weight*。
                        
                        #### ② admire (v. 欣赏; 崇拜)
                        - **【搭配】**：`admire the moon` (赏月)。
                        
                        #### ③ How vs What (感叹句)
                        - **【中考真题/例题】**：
                        
                        *________ exciting news it is! We will have a long holiday.*
                        A. What   B. What an   C. How   D. How an
                        
                        **[解析]**：news 是不可数名词，不能加 an，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：宾语从句与感叹句
                        **1. 宾语从句三要素**
                        - **引导词**：陈述句用 that；一般疑问句用 if/whether。
                        - **语序**：必须用**陈述语序**（主语在前，谓语在后）。
                        - **时态**：主句现在，从句随意；主句过去，从句必过；真理永现。

                        **2. 感叹句口诀**
                        - **What** 名，**How** 形副。
                        - *What a tall boy!*
                        - *How tall the boy is!*

                        **3. 中考真题特训**
                        
                        *(2024·重庆中考)* *I don't know ________ the train will arrive on time.*
                        A. that   B. if   C. what   D. which
                        
                        **[解析]**：表达“是否”准时到达，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite Festival (我最喜欢的节日)
                        **The Spring Festival is my favourite festival.**
                        
                        I think **that** it is the most important festival in China. During the festival, I **believe that** family members should stay together. We usually **eat dumplings** and **get lucky money**. **What a** happy time it is! I like it because it means a new beginning.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u3", "Unit 3", "Could you please tell me where the restrooms are?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：询问信息，礼貌沟通，公共场所交流 (Inquiring about information)。

                        ### 2. 单元主题内容
                        本单元聚焦“礼貌询问”，重点学习特殊疑问词引导的宾语从句。通过模拟在商场、游乐园、街头询问地点的场景，引导学生理解在不同场合下使用得体语言（Polite Language）的重要性。单元强调了“间接引语”比“直接引语”更具礼貌感，培养学生的社交情商和跨文化交际技巧。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **公共设施**：restroom, bookstore, post office, mall, bank.
                        - **核心词汇**：suggest (建议), staff (员工), grape (葡萄), direction (方向), central (中央的).
                        - **高频短语**：pass by (路过), pardon me (抱歉/请再说一遍), depend on (取决于), on one's way to (在去...的路上).

                        ### 2. 核心句式
                        1.  **礼貌询问地点**：Could you please tell me where the restrooms are?
                        2.  **询问时间**：Do you know when the bookstore closes?
                        3.  **描述位置**：Go past the bank and then turn left.
                        4.  **委婉建议**：I suggest that you go to the supermarket.

                        ### 3. 重点语法
                        - **宾语从句** 的特殊疑问句转换（陈述语序）。
                        - **礼貌语气的表达** (Could, would, please)。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Tourist**: Excuse me, could you tell me where I can buy some stamps? 
                        
                        **Girl**: Sure. There's a post office on Center Street. 
                        
                        **Tourist**: Could you please tell me how to get there? 
                        
                        **Girl**: Go past the bank and turn right. It's next to the library. 
                        
                        **Tourist**: Thank you very much!

                        **【译文】**
                        
                        **游客**：打扰了，你能告诉我哪儿能买到邮票吗？
                        
                        **女孩**：当然。中心街有一个邮局。
                        
                        **游客**：你能告诉我怎么走吗？
                        
                        **女孩**：经过银行，然后右转。它就在图书馆旁边。
                        
                        **游客**：非常感谢！

                        ### Section B (Reading) 阅读文段：Polite Language
                        **【原文】**
                        
                        When we ask for help, we should use polite language. Sometimes it's not enough to just be correct. For example, "Where are the restrooms?" is correct but may sound rude. Instead, we should say, "Could you please tell me where the restrooms are?" This sounds much more polite. Using polite language shows respect to others and helps us communicate better.

                        **【译文】**
                        
                        当我们请求帮助时，我们应该使用礼貌用语。有时仅仅做到正确是不够的。例如，“洗手间在哪儿？”是正确的，但听起来可能没礼貌。相反，我们应该说，“请问你能告诉我洗手间在哪儿吗？”这听起来要有礼貌得多。使用礼貌用语体现了对他人的尊重，并帮助我们更好地沟通。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Could you please tell me where the restrooms are? (请问你能告诉我洗手间在哪儿吗？)
                        - **【句式剖析】**：`where` 引导的从句作 `tell` 的宾语，从句中 `the restrooms` 是主语，`are` 是谓语（陈述语序）。
                        
                        #### 2. Do you know when the bookstore closes? (你知道书店什么时候关门吗？)
                        - **【注意】**：不能说 *when does the bookstore close?*
                        
                        #### 3. It depends on who you are talking to. (这取决于你在和谁说话。)
                        - **【词块归纳】**：`depend on` 意为“取决于；依靠”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① suggest (v. 建议)
                        - **【用法总结】**：
                            *   `suggest doing sth.` 建议做某事。
                            *   `suggest + that 从句` (从句用 should + 动词原形，should 可省略)。
                        - **【例题】**：
                        
                        *My teacher suggested ________ more English books.*
                        A. read   B. to read   C. reading   D. reads
                        
                        **[解析]**：suggest doing 选 **C**。

                        #### ② go past (经过)
                        - **【近义词】**：`pass` (v.)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：特殊疑问句变宾语从句
                        **1. 变序原则**
                        无论主句是疑问句还是陈述句，从句一律用**陈述语序**（主 + 谓）。
                        - *Where is he?* -> *I don't know **where he is**.*
                        
                        **2. 连接词**
                        原来的疑问词 (when, where, how, why, who, what) 即为连接词。

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *Could you tell me ________?*
                        A. where is the library   B. where the library is   C. where the library was   D. where was the library
                        
                        **[解析]**：陈述语序排除 A/D，且主句 Could 只是委婉语气并非过去式，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Asking for Directions (问路与指路)
                        #### 1. 必备佳句
                        *   *Excuse me, do you know where ... is?*
                        *   *Can you tell me the way to ...?*
                        *   *Go straight and turn left at the first crossing.*
                        *   *It's on your right.*

                        #### 2. 满分范文
                        **Excuse me.** Could you please tell me **how I can get to** the People's Park? Go **straight** along this street and **turn left** at the bank. **Go past** a bookstore, and you will see the park **on your right**. It's not far from here. **Thank you for your help!**
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u4", "Unit 4", "I used to be afraid of the dark.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：自我认识与自我管理 (Self-management)
                        *   **子主题**：个人成长与变化，克服弱点 (Personal growth)。

                        ### 2. 单元主题内容
                        本单元围绕“成长与变化”展开，重点学习 `used to` 结构的用法。通过描述自己在性格（outgoing / quiet）、外貌（tall / short）、爱好（sports / music）以及恐惧（dark / spiders）等方面的过去与现状，引导学生审视自己的成长轨迹。单元强调了“坚持与努力”在个人蜕变中的作用，培养学生积极面对自我、不断追求进步的人生态度。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **性格形容词**：humorous, silent, helpful, brave, shy.
                        - **核心名词/动词**：background (背景), speech (演说), ant (蚂蚁), insect (昆虫), guard (守卫).
                        - **高频短语**：used to do (过去常常), be proud of (为...自豪), take up (开始从事), deal with (处理), in public (公开地).

                        ### 2. 核心句式
                        1.  **描述过去**：I used to be shy. / He used to play soccer.
                        2.  **询问变化**：Did you use to wear glasses? — Yes, I did.
                        3.  **表达自豪**：My parents are proud of me.
                        4.  **处理困难**：It's difficult to deal with these problems.

                        ### 3. 重点语法
                        - **used to do sth.** 表示过去的习惯或状态。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Bob**: Mario, you look different! 
                        
                        **Mario**: Really? How? 
                        
                        **Bob**: Well, you used to be short, but now you are very tall. 
                        
                        **Mario**: That's true. And I used to wear glasses. 
                        
                        **Bob**: Did you use to be quiet? 
                        
                        **Mario**: Yes, I did. But now I'm more outgoing.

                        **【译文】**
                        
                        **鲍勃**：马里奥，你看起来不一样了！
                        
                        **马里奥**：真的吗？哪儿变了？
                        
                        **鲍勃**：嗯，你过去很矮，但现在你很高。
                        
                        **马里奥**：那是事实。而且我以前戴眼镜。
                        
                        **鲍勃**：你以前很文静吗？
                        
                        **马里奥**：是的。但现在我更外向了。

                        ### Section B (Reading) 阅读文段：He Studied Harder
                        **【原文】**
                        
                        Li Wen used to be a problem child. He didn't like school and often fought with others. His parents were worried. Then his teacher talked to him and helped him. Li Wen realized that his parents worked very hard for him. He started to study harder. Now, he is one of the best students in his class. He changed himself through hard work.

                        **【译文】**
                        
                        李文过去是个问题少年。他不喜欢上学，经常和别人打架。他的父母很担心。后来他的老师找他谈话并帮助了他。李文意识到父母为他辛勤工作。他开始更加努力学习。现在，他是班里最好的学生之一。他通过努力改变了自己。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. I used to be afraid of the dark. (我以前怕黑。)
                        - **【句式剖析】**：`used to be + adj.` 过去是...样的状态。
                        
                        #### 2. Did you use to wear glasses? (你以前戴眼镜吗？)
                        - **【注意】**：疑问句中要借用 `Did`，且 `used` 要恢复原形 `use`。
                        
                        #### 3. He took up singing to deal with his shyness. (他开始从事唱歌来应对他的害羞。)
                        - **【词块归纳】**：`take up` (开始做某事)；`deal with` (处理；应对)。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① used to do vs be used to doing
                        - **【辨析】**：
                            *   `used to do`：过去常常做某事（现在不做了）。
                            *   `be used to doing`：习惯于做某事。
                        - **【例题】**：
                        
                        *I ________ early, but now I ________ getting up at six.*
                        A. used to get up; am used to   B. am used to; used to   C. used to getting up; am used to   D. used to get up; used to
                        
                        **[解析]**：第一空指过去习惯，第二空指现在习惯，选 **A**。

                        #### ② be proud of (为...骄傲)
                        - **【同义词】**：`take pride in`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：used to 的“前世今生”
                        **1. 基本用法**
                        表示过去经常发生的动作或存在的状态（暗示现在已改变）。
                        
                        **2. 句式变换**
                        - 否定：I **didn't use to** smoke.
                        - 疑问：**Did** you **use to** have long hair?
                        - 反义疑问句：He used to be tall, **didn't he**?

                        **3. 中考真题特训**
                        
                        *(2024·江苏中考)* *My uncle ________ live in the countryside, but now he works in the city.*
                        A. is used to   B. used to   C. used to be   D. was used to
                        
                        **[解析]**：表示过去住在乡下，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Changes (我的变化)
                        **I have changed a lot in the last three years.**
                        
                        I **used to be** a shy girl and I was **afraid of speaking** in public. But now, I am **more outgoing** and brave. I **used to spend** much time playing games, but now I **study very hard**. My teachers and parents are **proud of** me. I think I am **growing up**.
                    """.trimIndent())
                )
            )
        ,
            TextbookUnit(
                "g9full_u5", "Unit 5", "What is it made of?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：科学与技术 (Science and technology)
                        *   **子主题**：物品制造，传统艺术，中国制造的影响力 (Manufacturing and crafts)。

                        ### 2. 单元主题内容
                        本单元以“产品与制造”为核心，重点学习一般现在时的被动语态（Passive Voice）。通过探讨日常用品（如 shirts, tea, chopsticks）的产地及原材料，以及中国传统艺术（如 sky lanterns, paper cutting, clay art），学生能够运用英语描述生产过程。单元旨在培养学生的民族自豪感，通过“中国制造”和“传统手工艺”的话题，增强文化传承意识。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **原材料词汇**：cotton, steel, silver, glass, leaf.
                        - **核心动词**：produce (生产), process (处理), pack (包装), avoid (避免).
                        - **传统艺术**：sky lantern, paper cutting, clay art, fairy tale.
                        - **高频短语**：be made of (由...制成 - 看出原料), be made from (由...制成 - 看不出原料), be known for (因...闻名), by hand (手工地), no matter (无论).

                        ### 2. 核心句式
                        1.  **询问构成**：What is it made of? — It's made of silk.
                        2.  **询问产地**：Where is tea produced? — It's produced in Anxi.
                        3.  **描述工艺**：The pieces of paper are cut by hand.
                        4.  **让步表达**：No matter what you do, you should try your best.

                        ### 3. 重点语法
                        - **一般现在时的被动语态** (am/is/are + p.p.)。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Alice**: This shirt is very beautiful. What is it made of? 
                        
                        **Li Hua**: It's made of cotton. It's produced in Xinjiang. 
                        
                        **Alice**: Xinjiang is known for its high-quality cotton. 
                        
                        **Li Hua**: Yes. It's picked by hand and then processed into cloth. 
                        
                        **Alice**: That's interesting!

                        **【译文】**
                        
                        **艾丽丝**：这件衬衫很漂亮。它是用什么做的？
                        
                        **李华**：它是棉做的。产自新疆。
                        
                        **艾丽丝**：新疆以其高质量的棉花而闻名。
                        
                        **李华**：是的。它是手工采摘，然后加工成布料的。
                        
                        **艾丽丝**：那很有意思！

                        ### Section B (Reading) 阅读文段：The Art of Paper Cutting
                        **【原文】**
                        
                        Paper cutting has been around for over 1,500 years. These art pieces are made of bright red paper. During the Spring Festival, they are put on windows and doors. They are usually symbols of good luck and health. No matter how difficult it is, people like to learn this traditional art to keep the culture alive.

                        **【译文】**
                        
                        剪纸已经存在超过1500年了。这些艺术品是用大红纸做成的。春节期间，它们被贴在门窗上。它们通常是好运和健康的象征。无论多么困难，人们都喜欢学习这种传统艺术，以保持文化的生命力。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What is it made of? (它是用什么做的？)
                        - **【用法拓展】**：`be made of` 侧重于物理变化，能看出原材料。
                        
                        #### 2. Tea is produced in China. (茶产自中国。)
                        - **【要点精讲】**：被动语态结构：`助动词 be + 动词的过去分词`。
                        
                        #### 3. No matter what happens, stay calm. (无论发生什么，保持冷静。)
                        - **【词块归纳】**：`no matter + 疑问词` 引导让步状语从句。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① be made of vs be made from
                        - **【辨析】**：
                            *   `be made of`：物理变化（如桌子由木头制成）。
                            *   `be made from`：化学变化（如纸由木头制成）。
                        - **【例题】**：
                        
                        *The paper is made ________ wood, and the chair is made ________ wood.*
                        A. of; from   B. from; of   C. in; of   D. from; in
                        
                        **[解析]**：纸看不出木头选 from，椅子看得出木头选 of，选 **B**。

                        #### ② be known for (以...闻名)
                        - **【近义】**：`be famous for`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：一般现在时的被动语态
                        **1. 构成**
                        主语 + am / is / are + 动词的过去分词 (p.p.).
                        
                        **2. 适用场景**
                        不知道动作发出者，或强调动作的承受者。
                        - *English is spoken around the world.*
                        
                        **3. 变被动步骤**
                        宾变主，谓变 be + p.p.，原主变 by 宾。

                        **4. 中考真题特训**
                        
                        *(2024·安徽中考)* *Many trees ________ on the hill every spring.*
                        A. plant   B. planted   C. are planted   D. are planting
                        
                        **[解析]**：树是被种的，且 every spring 提示一般现在时，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：A Local Product (介绍当地特产)
                        **Tea is a famous product in my hometown.** 
                        
                        It **is produced** in the mountains. It **is known for** its special taste. To make it, the leaves **are picked** by hand and then **dried** in the sun. It **is loved by** many people. I think **no matter** where you are, you will like it.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u6", "Unit 6", "When was it invented?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：科学与技术 (Science and technology)
                        *   **子主题**：伟大发明，历史变迁，创新的意义 (Inventions)。

                        ### 2. 单元主题内容
                        本单元以“发明与创造”为话题，重点学习一般过去时的被动语态（Passive Voice in Past Tense）。通过了解电话、拉链、薯片、茶等日常用品的起源故事，引导学生思考科学技术如何改变人类生活。单元强调了“意外的发现（Accidental Inventions）”，激发学生的好奇心和探索精神，培养其创新思维。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **发明名词**：invention, telephone, zipper, light bulb, refrigerator.
                        - **核心动词/形容词**：invent (发明), discover (发现), accidental (意外的), salty (咸的).
                        - **高频短语**：be used for (被用来...), by mistake (错误地), in the end (最后), divide ... into ... (把...分成...).

                        ### 2. 核心句式
                        1.  **询问时间**：When was it invented? — It was invented in 1876.
                        2.  **询问发明者**：Who was it invented by? — It was invented by Bell.
                        3.  **描述用途**：What is it used for? — It's used for taking photos.
                        4.  **历史叙述**：Tea was first drunk by accident.

                        ### 3. 重点语法
                        - **一般过去时的被动语态** (was/were + p.p.)。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Boy**: Look at this old telephone! When was it invented? 
                        
                        **Girl**: It was invented in 1876. 
                        
                        **Boy**: Who was it invented by? 
                        
                        **Girl**: It was invented by Alexander Graham Bell. 
                        
                        **Boy**: What a great invention! It changed the way people communicate.

                        **【译文】**
                        
                        **男孩**：看这个旧电话！它是什么时候被发明的？
                        
                        **女孩**：它是在1876年被发明的。
                        
                        **男孩**：它是由谁发明的？
                        
                        **女孩**：它是由亚历山大·格拉汉姆·贝尔发明的。
                        
                        **男孩**：多么伟大的发明啊！它改变了人们交流的方式。

                        ### Section B (Reading) 阅读文段：The History of Potato Chips
                        **【原文】**
                        
                        Did you know that potato chips were invented by mistake? In 1853, a cook named George Crum made them. A customer thought the potatoes were too thick. George got angry and cut them very thin. Then he fried them until they were crispy. The customer loved them! In the end, they became the most popular snack.

                        **【译文】**
                        
                        你知道薯片是错误地被发明的吗？1853年，一位名叫乔治·克拉姆的厨师制作了它们。一位顾客认为土豆太厚了。乔治生气了，把它们切得非常薄。然后他炸了它们直到它们变得酥脆。顾客非常喜欢！最后，它们成为了最受欢迎的零食。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. When was it invented? (它是何时被发明的？)
                        - **【用法拓展】**：`was + p.p.` 表示过去发生的被动动作。
                        
                        #### 2. What is it used for? (它被用来做什么？)
                        - **【要点精讲】**：`be used for + v.-ing` 强调用途；`be used to do` 强调目的。
                        
                        #### 3. It was discovered by accident. (它是被偶然发现的。)
                        - **【词块归纳】**：`by accident` = `by mistake` 意为“偶然地；无意中”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① invent (v. 发明) vs discover (v. 发现)
                        - **【辨析】**：
                            *   `invent`：创造出原本不存在的东西。
                            *   `discover`：找到原本已存在但未被发现的东西。
                        - **【例题】**：
                        
                        *Edison ________ the light bulb, and Columbus ________ America.*
                        A. invented; discovered   B. discovered; invented   C. created; found   D. made; saw
                        
                        **[解析]**：灯泡是创造的，美洲是本来就有的，选 **A**。

                        #### ② divide ... into ... (把...分成...)
                        - **【例题】**：
                        
                        *The cake was ________ four pieces.*
                        A. divided into   B. made of   C. used for   D. looked for
                        
                        **[解析]**：被分成四块，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：一般过去时的被动语态
                        **1. 构成**
                        主语 + was / were + 动词的过去分词 (p.p.).
                        
                        **2. 句式变换**
                        - 否定：was / were + not + p.p.
                        - 疑问：Was / Were + 主语 + p.p. ...?

                        **3. 中考真题特训**
                        
                        *(2023·北京中考)* *The first airplane ________ by the Wright brothers in 1903.*
                        A. invented   B. is invented   C. was invented   D. will be invented
                        
                        **[解析]**：1903 提示过去时，飞机是被发明的，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite Invention (我最喜欢的发明)
                        **The computer is my favourite invention.** 
                        
                        It **was invented** many years ago. It **is used for** many things, such as studying and working. I think it **has changed** our lives a lot. We can **find out** information easily. I **believe that** more and more useful things **will be invented** in the future.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u7", "Unit 7", "Teenagers should be allowed to choose their own clothes.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：人际关系与社会交往 (Communication)
                        *   **子主题**：家规校规，自我管理，亲子沟通 (Rules and choices)。

                        ### 2. 单元主题内容
                        本单元围绕“规矩与自由”展开，重点学习含有情态动词的被动语态。通过探讨青少年是否应该被允许选择自己的衣服、穿耳洞、做兼职等话题，引导学生辩证地看待规则与个人意愿之间的关系。单元强调了父母与子女之间沟通的必要性（如 Mom Knows Best），旨在培养学生的独立思考能力和对他人的理解力。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **规则动词**：allow (允许), permit (许可), smoke (抽烟), pierce (穿透).
                        - **核心名词**：teenager, license (执照), safety (安全), community (社区).
                        - **高频短语**：be allowed to (被允许...), get one's ears pierced (穿耳洞), stay up (熬夜), clean up (打扫), keep ... away from (使...远离).

                        ### 2. 核心句式
                        1.  **表达被动允许**：Teenagers should be allowed to choose their own clothes.
                        2.  **表达禁止**：I don't think sixteen-year-olds should be allowed to drive.
                        3.  **询问看法**：Do you think teenagers should be allowed to work at night?
                        4.  **因果表达**：They are not old enough to make their own decisions.

                        ### 3. 重点语法
                        - **含有情态动词的被动语态** (should/can + be + p.p.)。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Anna**: I want to get my ears pierced. 
                        
                        **Mom**: I don't think teenagers should be allowed to do that. It's not safe. 
                        
                        **Anna**: But many of my friends have done it! 
                        
                        **Mom**: Well, they should be allowed to do it when they are older. 
                        
                        **Anna**: I think I should be allowed to choose my own style.

                        **【译文】**
                        
                        **安娜**：我想去打耳洞。
                        
                        **妈妈**：我觉得青少年不应该被允许那样做。那不安全。
                        
                        **安娜**：但我很多朋友都打了！
                        
                        **妈妈**：嗯，他们应该在长大点后再被允许去做。
                        
                        **安娜**：我觉得我应该被允许选择自己的风格。

                        ### Section B (Reading) 阅读文段：Mom Knows Best?
                        **【原文】**
                        
                        When I was a little boy, my mom told me what to do. Now I'm a teenager and I want to make my own decisions. I want to spend time with my friends and choose my own clothes. But my mom always says, "I'm doing this for your own good." I know she loves me, but I hope I can be allowed to grow up in my own way.

                        **【译文】**
                        
                        当我还是个小男孩时，我妈妈告诉我该做什么。现在我是一个青少年了，我想自己做决定。我想和朋友们待在一起，选择自己的衣服。但我妈妈总是说，“我这是为了你好。”我知道她爱我，但我希望我能被允许以我自己的方式成长。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Teenagers should be allowed to do ... (青少年应该被允许做...)
                        - **【句式剖析】**：`should be + p.p.` 是情态动词被动语态的标准形式。
                        
                        #### 2. Six-year-olds should be kept away from danger. (六岁大的孩子应远离危险。)
                        - **【用法拓展】**：`数字-year-old` 作形容词或名词（加s），表示年龄。
                        
                        #### 3. It's not for your own good. (这不仅仅是为了你好。)
                        - **【词块归纳】**：`for one's own good` 为了某人好。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① allow sb. to do sth. (允许某人做某事)
                        - **【被动式】**：`sb. be allowed to do sth.`
                        - **【例题】**：
                        
                        *Our teacher doesn't allow ________ in class.*
                        A. sleep   B. to sleep   C. sleeping   D. slept
                        
                        **[解析]**：allow doing sth. (允许做某事)，此处无 sb.，选 **C**。

                        #### ② enough (足够的)
                        - **【位置】**：修饰名词在前 (*enough money*)；修饰形容词在后 (*old enough*)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：含情态动词的被动语态
                        **1. 结构**
                        主语 + 情态动词 (can/should/must/may) + be + 动词的过去分词 (p.p.).
                        
                        **2. 句式变换**
                        - 否定：情态动词 + not + be + p.p.
                        - 疑问：情态动词 + 主语 + be + p.p. ...?

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *Waste paper ________ into the dustbin.*
                        A. should throw   B. should be throw   C. should be thrown   D. was thrown
                        
                        **[解析]**：废纸“应该被扔”，含有情态动词的被动语态，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Rules at School (谈论校规)
                        **Every school has its own rules.** 
                        
                        In our school, we **should be allowed to** wear our own clothes on Fridays. I think it's good for our **creativity**. However, we **mustn't be allowed to** use mobile phones in class because it **interferes with** our study. Rules are **important**, and we should follow them.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u8", "Unit 8", "It must belong to Carla.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：社会服务与人际沟通 (Social services)
                        *   **子主题**：物品所属推测，逻辑推理，科学解释 (Inferences)。

                        ### 2. 单元主题内容
                        本单元以“逻辑推测”为核心，学习情态动词 `must, might, could, can't` 表示推测的用法。通过寻找遗失物品的主人、解释奇怪的现象（如 Stonehenge 的秘密），学生能够运用英语进行严密的逻辑分析。单元旨在培养学生的观察力、分析能力和对未知世界的好奇心，引导学生学会根据已有证据做出合理解释。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **推理词汇**：must (肯定), might/could (可能), can't (不可能).
                        - **物品词汇**：folder, truck, picnic, laboratory, jewelry.
                        - **核心动词/形容词**：belong (属于), attend (参加), valuable (宝贵的), pink (粉红色的).
                        - **高频短语**：belong to (属于), run after (追逐), at the same time (同时), make up (编造; 化妆).

                        ### 2. 核心句式
                        1.  **肯定推测**：It must belong to Carla. She has a guitar.
                        2.  **可能推测**：It could be a present for her mother.
                        3.  **否定推测**：It can't be a dog. It's too big.
                        4.  **科学猜测**：The stones must have been moved by many people.

                        ### 3. 重点语法
                        - **情态动词表推测** 的肯定、否定与可能性。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Linda**: Look! Someone left a book on the bench. 
                        
                        **Jack**: It must belong to Carla. Her name is on it. 
                        
                        **Linda**: What about this hair band? 
                        
                        **Jack**: It could be Linda's. She likes the color pink. 
                        
                        **Linda**: No, it can't be hers. She's wearing hers right now.

                        **【译文】**
                        
                        **琳达**：看！有人把书落在长凳上了。
                        
                        **杰克**：它一定属于卡拉。她的名字在上面。
                        
                        **琳达**：那这个发带呢？
                        
                        **杰克**：可能是琳达的。她喜欢粉色。
                        
                        **琳达**：不，不可能是她的。她现在正戴着她的呢。

                        ### Section B (Reading) 阅读文段：Stonehenge
                        **【原文】**
                        
                        Stonehenge is one of the world's greatest mysteries. Who built it? Why was it built? Some people think it was a temple. Others believe it was a kind of calendar. The stones are so heavy that it must have been very hard to move them. Even today, scientists are still trying to find the truth about it.

                        **【译文】**
                        
                        巨石阵是世界上最伟大的谜团之一。谁建造了它？为什么要建造它？有些人认为它是一座神庙。另一些人相信它是一种日历。那些石头如此沉重，以至于移动它们一定非常困难。即使是今天，科学家们仍在努力寻找关于它的真相。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. It must belong to Carla. (它一定属于卡拉。)
                        - **【用法拓展】**：`belong to` 意为“属于”，不用于被动语态，也不用于进行时。
                        
                        #### 2. It can't be hers. (它不可能是她的。)
                        - **【要点精讲】**：`can't` 表示有把握的否定推测。
                        
                        #### 3. I saw him running after a bus. (我看到他正在追一辆公交车。)
                        - **【词块归纳】**：`see sb. doing sth.` 看到某人正在做某事。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① belong to (属于)
                        - **【注意】**：to 是介词，后接名词或人称代词宾格。
                        - **【例题】**：
                        
                        *The beautiful bike belongs to ________.*
                        A. I   B. me   C. my   D. mine
                        
                        **[解析]**：belong to 后用宾格，选 **B**。

                        #### ② valuable (adj. 宝贵的)
                        - **【词汇梳理】**：`value` (价值) + `able` (后缀) = `valuable`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：情态动词推测“三兄弟”
                        **1. must (肯定)**
                        意为“一定”，语气最强，用于肯定推测。
                        
                        **2. might / could (可能)**
                        意为“可能”，语气较弱，用于不确定的推测。
                        
                        **3. can't (否定)**
                        意为“不可能”，语气最强，用于否定推测。

                        **4. 中考真题特训**
                        
                        *(2024·江苏中考)* *— Is that Mr. Black? — No, it ________ be him. He is in London now.*
                        A. must   B. may   C. can't   D. shouldn't
                        
                        **[解析]**：根据“他在伦敦”可知“不可能是他”，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Mystery at School (校园里的推测)
                        **There is a backpack on the playground.** 
                        
                        It **must belong to** a student. There are some **valuable** books in it. It **might be** Li Hua's because I saw him **running** there. But it **can't be** Tom's because his backpack is blue. I will **take it to** the teachers' office. I hope the owner **will find** it soon.
                    """.trimIndent())
                )
            )

        ,
            TextbookUnit(
                "g9full_u13", "Unit 13", "We're trying to save the earth!",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自然 (Man and Nature)
                        *   **主题群**：环境保护 (Environmental protection)
                        *   **子主题**：污染现状，环保行动，可持续生活 (Saving the planet)。

                        ### 2. 单元主题内容
                        本单元聚焦“环境保护”，重点复习多种时态（现在进行时、现在完成时、被动语态、used to 等）在环保话题下的综合应用。通过探讨污染问题（如 air pollution, water pollution）及环保措施（如 recycling, reducing plastic），引导学生树立危机意识。单元强调了“垃圾是放错地方的资源”（如 Rethink, Reuse, Recycle），鼓励学生从身边小事做起，共同守护地球家园。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **环保词汇**：litter, rubbish, pollution, ocean, planet, reusable.
                        - **核心动词**：recycle (回收), reduce (减少), reuse (再利用), afford (负担得起), transport (运输).
                        - **高频短语**：throw away (扔掉), take part in (参加), turn off (关掉), pay for (付款), make a difference (产生影响).

                        ### 2. 核心句式
                        1.  **描述现状**：The river used to be clean, but now it's very dirty.
                        2.  **呼吁行动**：We're trying to save the earth!
                        3.  **表达必要性**：It's crucial to stop using plastic bags.
                        4.  **提供方法**：We should recycle paper and glass.

                        ### 3. 重点语法
                        - **多种时态的综合应用**（描述环保情境）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mark**: Look at the river! It's full of rubbish. 
                        
                        **Sarah**: Yes, it used to be so clean. 
                        
                        **Mark**: We should do something to clean it up. 
                        
                        **Sarah**: I agree. We can take part in the city's cleanup day. 
                        
                        **Mark**: Good idea! We should also tell people to stop throwing litter into it.

                        **【译文】**
                        
                        **马克**：看那条河！到处都是垃圾。
                        
                        **莎拉**：是的，它过去非常干净。
                        
                        **马克**：我们应该做点什么来清理它。
                        
                        **莎拉**：我同意。我们可以参加城市的清理日活动。
                        
                        **马克**：好主意！我们也应该告诉人们停止往河里扔垃圾。

                        ### Section B (Reading) 阅读文段：Rethink, Reuse, Recycle!
                        **【原文】**
                        
                        The world is full of waste. But did you know that much of it can be reused? For example, an artist in the UK makes beautiful sculptures from old metal. A woman in China makes bags from plastic bottles. These people show us that we should rethink what we throw away. By recycling and reusing, we can save resources and protect our environment.

                        **【译文】**
                        
                        世界充满了废弃物。但你知道其中很多是可以再利用的吗？例如，英国的一位艺术家用废旧金属制作美丽的雕塑。中国的一位女士用塑料瓶制作包。这些人向我们展示了我们应该重新审视我们扔掉的东西。通过回收和再利用，我们可以节约资源并保护环境。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. We're trying to save the earth! (我们正在努力拯救地球！)
                        - **【句式剖析】**：`try to do sth.` 努力做某事。
                        
                        #### 2. The river used to be clean. (这条河过去很干净。)
                        - **【要点精讲】**：`used to be` 描述过去的某种状态。
                        
                        #### 3. It's crucial to stop using plastic bags. (停止使用塑料袋是至关重要的。)
                        - **【词块归纳】**：`crucial` 意为“至关重要的；关键的”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① throw away (扔掉; 抛弃)
                        - **【用法】**：动副短语。代词放中间。
                        - **【例题】**：
                        
                        *Don't ________ the old books. We can give them to the library.*
                        A. throw away   B. throw it away   C. throw away them   D. throw them away
                        
                        **[解析]**：books 为复数，代词用 them 并放中间，选 **D**。

                        #### ② make a difference (起作用; 产生影响)
                        - **【拓展】**：`make a difference to...`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：环保话题下的综合语法
                        **1. used to 与 be used to**
                        - *I used to litter.* (过去常扔垃圾)
                        - *I am used to recycling.* (现在习惯于回收)
                        
                        **2. 被动语态的环保应用**
                        - *Paper should be recycled.* (纸应该被回收)
                        - *The trees are being cut down.* (树正在被砍伐)

                        **3. 中考真题特训**
                        
                        *(2024·安徽中考)* *Everyone should ________ the lights when they leave the room.*
                        A. turn off   B. turn on   C. turn up   D. turn down
                        
                        **[解析]**：离开房间应“关掉”灯，节约能源，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：How to Protect the Environment (如何环保)
                        **Our earth is in danger, so we must protect it.** 
                        
                        First, we should **stop using** plastic bags. We can take a cloth bag when shopping. Second, we should **recycle** waste paper and bottles. Third, it's a good habit to **turn off the lights** when we leave. If **everyone** makes an effort, our world will **be more beautiful**.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u14", "Unit 14", "I remember meeting all of you in Grade 7.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：个人成长 (Personal growth)
                        *   **子主题**：毕业回忆，感恩，未来展望 (Graduation and memories)。

                        ### 2. 单元主题内容
                        作为初中阶段的最后一个单元，本单元以“毕业与回忆”为主题。学生通过回顾从七年级到九年级的点点滴滴（如 meeting friends, winning competitions, dealing with pressure），表达对老师、同学的感激之情。单元重点复习了非谓语动词（remember doing/to do）及各种时态的综合运用。旨在引导学生在离别之际珍藏回忆，树立远大理想，勇敢奔赴未来。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **回忆词汇**：memory, survey, standard, degree, manager.
                        - **核心动词**：graduate (毕业), congratulate (祝贺), thirst (渴望), overcome (克服).
                        - **高频短语**：remember doing (记得做过), look back at (回顾), keep one's cool (沉住气), prepare for (准备), ahead of (在...前面).

                        ### 2. 核心句式
                        1.  **美好回忆**：I remember meeting all of you in Grade 7.
                        2.  **表达收获**：I've learned a lot from my teachers and friends.
                        3.  **未来愿望**：I hope to achieve my dreams in the future.
                        4.  **感恩寄语**：Thank you for your help and support.

                        ### 3. 重点语法
                        - **非谓语动词**（remember, forget, stop 后接 to do 与 doing 的区别）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teacher**: How do you feel about leaving school, Lily? 
                        
                        **Lily**: I'm a bit sad. I remember meeting everyone for the first time in Grade 7. 
                        
                        **Teacher**: What about you, Ken? 
                        
                        **Ken**: I'm excited about high school, but I'll miss my friends. 
                        
                        **Teacher**: You've all grown up a lot. Good luck to everyone!

                        **【译文】**
                        
                        **老师**：丽作，对于毕业你有什么感受？
                        
                        **丽丽**：我有点难过。我记得七年级第一次见到大家的情景。
                        
                        **老师**：你呢，肯？
                        
                        **肯**：我对高中感到兴奋，但我会想念我的朋友们。
                        
                        **老师**：你们都长大了许多。祝大家好运！

                        ### Section B (Reading) 阅读文段：A Graduation Speech
                        **【原文】**
                        
                        Today is our graduation day. Looking back at the last three years, we have had many challenges. We worked hard for exams and sometimes we felt stressed. But we also had many happy times. We should thank our teachers for their patience and our parents for their love. The future is ahead of us. Let's go forth and follow our dreams!

                        **【译文】**
                        
                        今天是我们的毕业典礼。回顾过去的三年，我们遇到了很多挑战。我们为考试努力学习，有时感到压力很大。但我们也度过了许多快乐的时光。我们应该感谢老师们的耐心和父母们的爱。未来就在我们面前。让我们出发，去追逐梦想吧！
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. I remember meeting all of you. (我记得见过你们大家。)
                        - **【句式剖析】**：`remember doing sth.` 记得做过某事（已发生）。
                        
                        #### 2. I'm looking forward to high school. (我期待着高中。)
                        - **【用法拓展】**：`look forward to` 后面接名词或 **动词-ing**。
                        
                        #### 3. It's time to say goodbye. (该说再见了。)
                        - **【词块归纳】**：`It's time to do sth.` 到该做某事的时间了。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① remember to do vs remember doing
                        - **【辨析】**：
                            *   `remember to do`：记得要做某事（未做）。
                            *   `remember doing`：记得做过某事（已做）。
                        - **【例题】**：
                        
                        *Please ________ the window when you leave.*
                        A. remember to close   B. remember closing   C. remember close   D. remembering to close
                        
                        **[解析]**：提醒将来要做的事，用 to do，选 **A**。

                        #### ② look back at (回顾; 回头看)
                        - **【反义词】**：`look forward to` (展望; 期待)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：非谓语动词的“分水岭”
                        **1. remember / forget / stop**
                        - + to do：去做（未发生）。
                        - + doing：做了（已发生）。
                        
                        **2. need / want**
                        - `need to do` (主语是人)。
                        - `need doing` (主语是物，表示被动)。

                        **3. 中考真题特训**
                        
                        *(2024·江苏中考)* *I will never forget ________ the beautiful sunset with you last summer.*
                        A. to see   B. seeing   C. see   D. seen
                        
                        **[解析]**：last summer 提示是已经发生过的经历，用 forget doing，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Junior High Memories (我的初中回忆)
                        **Three years have passed quickly.** 
                        
                        I still **remember my first day** in this school. I was very **shy** at that time. But now, I have **many friends**. I want to **thank my teachers** because they helped me **overcome difficulties**. I will **miss** my school life. I'm **ready for** the next part of my life!
                    """.trimIndent())
                )
            )


        )

        )

        }
