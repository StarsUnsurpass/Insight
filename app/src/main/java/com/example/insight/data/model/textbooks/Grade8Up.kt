package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade8Up {
    val data = Textbook(
        id = "g8_up",
        grade = "八年级",
        term = "上册",
        coverColor = Color(0xFFE8F5E9),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc8s_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g8up_u1", "Unit 1", "Where did you go on vacation?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：暑假生活，旅游经历，分享与感受 (Vacation experiences)。

                        ### 2. 单元主题内容
                        本单元以“暑假旅游”为核心，重点复习并进阶学习一般过去时（Simple Past Tense）。学生将学会如何描述过去的行程（Where did you go?）、见闻（What did you see?）及个人感受（How was the food?）。通过对比不同人的度假经历，引导学生热爱自然，热爱生活，培养在社交场合中倾听并分享个人经历的能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **不定代词**：anyone, someone, everyone, anything, something, everything, nothing.
                        - **核心动词**：stay (停留), decide (决定), try (尝试), wonder (想知道), feel (感觉).
                        - **地点/物品**：museum (博物馆), mountain (山), umbrella (雨伞), hill (小山).
                        - **高频短语**：go on vacation (去度假), take photos (照相), buy something special (买特别的东西), of course (当然), enjoy oneself (玩得开心).

                        ### 2. 核心句式
                        1.  **询问去向**：Where did you go on vacation? — I went to the mountains.
                        2.  **询问同伴**：Did you go with anyone? — No, I went with my family.
                        3.  **询问感受**：How was the weather? — It was hot and humid.
                        4.  **描述经历**：Everything was so beautiful!

                        ### 3. 重点语法
                        - **一般过去时** 的特殊疑问句与一般疑问句。
                        - **复合不定代词** (someone, anything等) 的用法及形容词后置规则。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Grace**: Hi, Kevin. Long time no see. Where did you go on vacation?
                        
                        **Kevin**: I went to the beach. 
                        
                        **Grace**: Oh, did you go with anyone?
                        
                        **Kevin**: Yes, I went with my parents.
                        
                        **Grace**: How was the weather?
                        
                        **Kevin**: It was sunny and hot. We had a great time there.

                        **【译文】**
                        
                        **格蕾丝**：嗨，凯文。好久不见。你暑假去哪儿度假了？
                        
                        **凯文**：我去了海边。
                        
                        **格蕾丝**：噢，你和谁一起去的吗？
                        
                        **凯文**：是的，我和我的父母一起去的。
                        
                        **格蕾丝**：天气怎么样？
                        
                        **凯文**：天气晴朗且炎热。我们在那儿玩得很开心。

                        ### Section B (Reading) 阅读文段：My Diary in Penang
                        **【原文】**
                        
                        Monday, July 15th. It arrived in Penang today. The weather was hot and sunny. We decided to go to the beach. I tried paragliding. It was so exciting! For lunch, we had something very special — Penang Laksa. It tasted delicious. I feel very tired now but very happy.

                        **【译文】**
                        
                        7月15日，周一。今天到达了槟城。天气炎热且晴朗。我们决定去海边。我尝试了滑翔伞。它太令人兴奋了！午餐我们吃了一些非常特别的东西——槟城叻沙。它吃起来味道很美。我现在感觉很累，但是很快乐。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① try (v. 尝试; 努力)
                        - **【用法总结】**：
                            *   `try to do sth.` 尽力做某事（强调努力的过程）。
                            *   `try doing sth.` 尝试做某事（强调尝试某种方法）。
                        - **【例题】**：
                        
                        *You should ________ talking to him. Maybe he will agree.*
                        A. try to   B. try   C. try doing   D. trying
                        
                        **[解析]**：强调尝试某种方式，用 try doing，选 **C**。

                        #### ② enjoy oneself (玩得开心)
                        - **【同义转换】**：`have a good time` / `have fun`.
                        - **【用法】**：oneself 需随主语变化。*We enjoyed ourselves.*
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：复合不定代词的“三大法宝”
                        **1. 修饰语后置**
                        形容词修饰不定代词时，必须放在不定代词之后。
                        - *something interesting* (有趣的事)
                        - *anything special* (特别的东西)

                        **2. 肯定与否定的分工**
                        - **some-** 系列通常用于肯定句。
                        - **any-** 系列通常用于否定句或疑问句。

                        **3. 谓语动词单数**
                        复合不定代词作主语时，谓语动词用单数。
                        - *Everything **is** ready.*

                        **4. 中考真题特训**
                        
                        *(2024·山东中考)* *I'm hungry. Is there ________ to eat in the fridge?*
                        A. something   B. anything   C. everything   D. nothing
                        
                        **[解析]**：疑问句中询问是否有东西，用 anything，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：A Vacation Diary (旅游日记)
                        **Monday, August 12th. Sunny.**
                        
                        Today I went to **Mount Tai** with my friends. We started at 6:00 a.m. The weather was **sunny and cool**, very good for climbing. On the way to the top, we saw many **beautiful flowers**. **Everything** was so fresh. We felt very tired, but when we saw the sunrise, we were very **excited**. It was **something special** in my life.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "How often do you exercise?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：生活方式，运动习惯，饮食健康 (Healthy habits)。

                        ### 2. 单元主题内容
                        本单元以“生活习惯”为话题，重点学习询问频率的特殊疑问句 `How often` 及各类频度副词。通过对比不同频率的活动（如 exercise, watch TV, drink milk 等），引导学生分析自己的生活方式是否健康。本单元旨在培养学生良好的作息习惯，增强自我健康管理意识。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **频度副词**：always, usually, often, sometimes, hardly ever, never.
                        - **频度短语**：once a week, twice a month, three times a day.
                        - **健康词汇**：exercise (锻炼), diet (饮食), health (健康), junk food (垃圾食品), habit (习惯).
                        - **高频短语**：be good for (对...有好处), keep healthy (保持健康), help with (在某方面提供帮助).

                        ### 2. 核心句式
                        1.  **询问频率**：How often do you exercise? — Once a week.
                        2.  **询问百分比**：What do students do in their free time?
                        3.  **陈述习惯**：I hardly ever watch TV. / She eats junk food once a month.
                        4.  **给出建议**：You should eat more vegetables.

                        ### 3. 重点语法
                        - **How often** 引导的特殊疑问句。
                        - **频度副词** 的语义程度排序。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teacher**: How often do you exercise, Claire?
                        
                        **Claire**: I exercise every day.
                        
                        **Teacher**: And how often do you eat vegetables?
                        
                        **Claire**: I eat them twice a day. It's good for my health.
                        
                        **Teacher**: What about you, Jack?
                        
                        **Jack**: I hardly ever exercise. And I like eating junk food.
                        
                        **Teacher**: Oh, you should change your habits!

                        **【译文】**
                        
                        **老师**：克莱尔，你多久锻炼一次？
                        
                        **克莱尔**：我每天都锻炼。
                        
                        **老师**：那你多久吃一次蔬菜？
                        
                        **克莱尔**：我每天吃两次。这对我的健康有好处。
                        
                        **老师**：你呢，杰克？
                        
                        **杰克**：我几乎不锻炼。而且我喜欢吃垃圾食品。
                        
                        **老师**：哦，你应该改变你的习惯！

                        ### Section B (Reading) 阅读文段：What Do No. 5 High School Students Do?
                        **【原文】**
                        
                        We asked our students what they do in their free time. The results were interesting. 90% of students exercise every day. 80% of students watch TV twice a week. But only 15% of students drink milk every day. We hope all students can have a healthy lifestyle.

                        **【译文】**
                        
                        我们询问了学生们在业余时间做什么。结果很有趣。90%的学生每天锻炼。80%的学生每周看两次电视。但只有15%的学生每天喝牛奶。我们希望所有的学生都能拥有健康的生活方式。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① how often (多久一次)
                        - **【辨析】**：
                            *   `how often`：问频率。*Once a week.*
                            *   `how long`：问时长。*For two hours.*
                            *   `how soon`：问多久以后。*In three days.*
                        - **【中考真题/例题】**：
                        
                        *— ________ do you go to the cinema? — Once a month.*
                        A. How often   B. How many   C. How long   D. How much
                        
                        **[解析]**：根据回答 Once a month 可知问频率，选 **A**。

                        #### ② be good for (对...有好处)
                        - **【对比】**：
                            *   `be good for`：对...有益。
                            *   `be good at`：擅长于...。
                            *   `be good with`：善于与...相处。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：频度副词与频率表达
                        **1. 频度副词百分比**
                        always (100%) > usually (80%) > often (60%) > sometimes (40%) > hardly ever (10%) > never (0%).

                        **2. 具体的频率表达**
                        - *Once a week* (一周一次)
                        - *Twice a month* (一月两次)
                        - *Three times a year* (一年三次)

                        **3. 中考真题特训**
                        
                        *(2023·北京中考)* *— How ________ do you help with housework? — Every day.*
                        A. long   B. soon   C. often   D. far
                        
                        **[解析]**：回答是频率，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Healthy Lifestyle (我的健康生活方式)
                        **Hello! My name is Li Hua.**
                        
                        I think I have a **healthy lifestyle**. I **exercise every day** to keep fit. I **usually eat** vegetables and fruit. I **hardly ever eat** junk food because it is **bad for** my health. I **often drink** milk before I go to bed. I **usually sleep** eight hours every night. 
                        
                        What about you? Do you have a healthy life?
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "I'm more outgoing than my sister.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：个人特征对比，朋友的选择与相处 (Friends and personality)。

                        ### 2. 单元主题内容
                        本单元以“性格与外貌对比”为核心，重点学习形容词和副词的比较级（Comparative Degree）。通过对比兄弟姐妹或朋友之间的差异（如 taller, more outgoing 等），学生学会如何进行多维度的客观描述。同时，单元探讨了“什么样的朋友才是好朋友”，引导学生建立正确的友谊观，学会在差异中欣赏他人。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **描述词**：outgoing (外向的), serious (严肃的), hard-working (勤奋的), talented (有天赋的), athletic (擅长运动的).
                        - **核心名词**：competition (比赛), mirror (镜子), difference (差异), grade (成绩).
                        - **程度副词**：much, even, a little, a bit (修饰比较级).
                        - **高频短语**：as ... as ... (和...一样), both ... and ... (两者都), be different from (与...不同), reach for (伸手去够).

                        ### 2. 核心句式
                        1.  **直接对比**：I'm taller than my sister. / He's more outgoing than me.
                        2.  **同级比较**：She's as serious as my mother.
                        3.  **程度修饰**：Sam is a little bit more athletic than Tom.
                        4.  **友谊观点**：A good friend is like a mirror.

                        ### 3. 重点语法
                        - **形容词/副词比较级** 的构成规则（-er 与 more）。
                        - **比较级句型**：A + be/v. + 比较级 + than + B。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Tina**: Is that your sister, Tara?
                        
                        **Tara**: Yes, it is. 
                        
                        **Tina**: You look similar. But who is more outgoing?
                        
                        **Tara**: I think I'm more outgoing than Tara. She is quieter.
                        
                        **Tina**: Is she as hard-working as you?
                        
                        **Tara**: Yes, she is. She always gets better grades than me.

                        **【译文】**
                        
                        **蒂娜**：那是你姐姐塔拉吗？
                        
                        **塔拉**：是的。
                        
                        **蒂娜**：你们看起来很像。但谁更外向呢？
                        
                        **塔拉**：我觉得我比塔拉更外向。她更文静。
                        
                        **蒂娜**：她像你一样勤奋吗？
                        
                        **塔拉**：是的。她总是比我取得更好的成绩。

                        ### Section B (Reading) 阅读文段：Best Friends
                        **【原文】**
                        
                        My best friend is Larry. He is much more intellectual than me. I'm quieter and more serious than him. Some people say we are very different. But I think friends are like mirrors. Larry helps me reach my goals. I don't care if my friend is different from me.

                        **【译文】**
                        
                        我最好的朋友是拉里。他比我聪明得多。我比他更文静、更严肃。有人说我们非常不同。但我觉得朋友就像镜子。拉里帮助我实现目标。我不在乎我的朋友是否和我不同。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① as ... as ... (和...一样)
                        - **【用法总结】**：
                            *   中间必须接形容词或副词的**原级**。
                            *   否定形式：`not as/so ... as ...` (不如...那样...)。
                        - **【例题】**：
                        
                        *This math problem is as ________ as that one.*
                        A. difficult   B. more difficult   C. the most difficult   D. difficulty
                        
                        **[解析]**：as...as 中间用原级，选 **A**。

                        #### ② both ... and ... (两者都)
                        - **【用法】**：连接两个并列主语时，谓语动词一律用**复数**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：比较级的“变身”与“法则”
                        **1. 构成规则口诀**
                        单音词尾加 -er；双音多音 more 在前；辅音加 y 变 i -er；重读闭音双写末。
                        - *big -> bigger, thin -> thinner*
                        - *easy -> easier*
                        - *difficult -> more difficult*

                        **2. 比较级的修饰语**
                        只能用 much, even, a little, a bit, far 等修饰，**绝对不能用 very**！

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *Health is ________ than money.*
                        A. important   B. more important   C. most important   D. the most important
                        
                        **[解析]**：由 than 可知需用比较级，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Comparison between Friends (对比朋友)
                        #### 1. 写作要点
                        - **Appearance** (外貌)
                        - **Personality** (性格)
                        - **Hobbies** (爱好)
                        - **Common ground** (共同点)

                        #### 2. 满分范文
                        I have a good friend, Peter. He is **taller and stronger** than me. I am **quieter** and more **serious**. He is **more athletic** and he is **better at** sports. However, we are **both hard-working**. I think a good friend is like a mirror. We help **each other**.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "What's the best movie theater?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：服务与场所 (Services and places)
                        *   **子主题**：公共设施评价，社区生活，客观标准评价 (Public facilities)。

                        ### 2. 单元主题内容
                        本单元以“社区设施评价”为核心，重点学习形容词和副词的最高级（Superlative Degree）。通过评价电影院、餐厅、超市等场所（如 the cheapest, the most popular 等），学生学会如何多维度比较并选出“最之最”。单元还涉及了达人秀（Talent Show）等话题，引导学生在评价中保持客观，同时积极发现身边的优秀事物。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **场所/物品**：theater (电影院), screen (屏幕), seat (座位), service (服务), ticket (票).
                        - **评价形容词**：cheap (便宜的), close (近的), comfortable (舒适的), creative (有创意的).
                        - **核心名词**：talent (天赋), magician (魔术师), prize (奖品), example (例子).
                        - **高频短语**：movie theater, wait for (等待), for example (例如), take ... seriously (认真对待...).

                        ### 2. 核心句式
                        1.  **最高级询问**：What's the best movie theater? — Sun Cinema is the best.
                        2.  **客观理由**：It has the most comfortable seats and the best service.
                        3.  **多维度比较**：Which theater is the cheapest?
                        4.  **才艺评价**：He is the funniest actor in our school.

                        ### 3. 重点语法
                        - **形容词/副词最高级** 的构成规则。
                        - **最高级句型**：The + 最高级 + 范围 (in / of)。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Boy**: I want to go to a movie theater tonight. Which one is the best?
                        
                        **Girl**: I think Town Cinema is the best. 
                        
                        **Boy**: Why? Is it the closest?
                        
                        **Girl**: No, but it has the biggest screens and the best sound.
                        
                        **Boy**: What about Movie City?
                        
                        **Girl**: It's the cheapest, but the seats are not comfortable.

                        **【译文】**
                        
                        **男孩**：我今晚想去电影院。哪一家最好？
                        
                        **女孩**：我觉得城镇电影院是最好的。
                        
                        **男孩**：为什么？它是最近的吗？
                        
                        **女孩**：不是，但它有最大的屏幕和最好的音响。
                        
                        **男孩**：那电影城呢？
                        
                        **女孩**：它是最便宜的，但是座位不舒服。

                        ### Section B (Reading) 阅读文段：Who's Got Talent?
                        **【原文】**
                        
                        Everyone is good at something. That's why talent shows are so popular. Some people are the funniest, some are the most creative, and some are the most talented. These shows give people a chance to show what they can do. It's always interesting to watch!

                        **【译文】**
                        
                        每个人都擅长某些事情。这就是才艺表演如此受欢迎的原因。有些人是最滑稽的，有些是最有创意的，还有些是最有天赋的。这些节目给人们一个展示自己才能的机会。看这些节目总是很有趣！
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① the best (最好的)
                        - **【用法总结】**：`good / well` 的最高级。
                        - **【对比】**：`the worst` (坏的最高级)。
                        
                        #### ② for example (例如)
                        - **【注意】**：常用于句中作插入语，前后加逗号。
                        
                        #### ③ take ... seriously (认真对待)
                        - **【例题】**：
                        
                        *You should ________ your homework ________.*
                        A. take; serious   B. take; seriously   C. takes; serious   D. taking; seriously
                        
                        **[解析]**：修饰动词 take 需用副词 seriously，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：最高级的“王冠”法则
                        **1. 标志范围**
                        最高级常与表示范围的短语连用：
                        - `in + 范围名词` (in my class, in the world).
                        - `of + 数量/代词` (of all the students, of the three).

                        **2. 冠词 rules**
                        - 形容词最高级前必须加 **the**。
                        - 副词最高级前的 the 可以省略。

                        **3. 中考真题特训**
                        
                        *(2024·安徽中考)* *Of all the students, Zhang Hua is ________.*
                        A. tall   B. taller   C. tallest   D. the tallest
                        
                        **[解析]**：Of all... 提示在三者及以上范围，需用最高级，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Evaluation of My Town (我的社区评价)
                        **Welcome to my town!**
                        
                        I think Sun Cinema is the **best movie theater** because it has the **most comfortable** seats. If you want to buy things, the Big Mall is the **cheapest** place. For food, Green Restaurant is the **most popular** because its food is **the best**. Come and visit my town! 
                    """.trimIndent())
                )
            ),
       
            TextbookUnit(
                "g8up_u5", "Unit 5", "Do you want to watch a game show?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：大众媒体与文体活动 (Media and entertainment)
                        *   **子主题**：电视节目偏好，文化娱乐生活 (TV programs and preferences)。

                        ### 2. 单元主题内容
                        本单元围绕“电视节目”展开，学习各种电视节目名称（如 game show, news, soap opera 等）及如何表达对它们的看法。通过学习动词不定式作宾语的用法，学生能够陈述自己想看或计划看的节目。单元还涉及了动画片的发展（如 Mickey Mouse），引导学生思考娱乐背后的文化意义，培养审慎选择媒体内容的习惯。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **电视节目**：news (新闻), sitcom (情景喜剧), soap opera (肥皂剧), comedy (喜剧), cartoon (动画片).
                        - **态度动词**：love, like, don't mind (不介意), don't like, can't stand (受不了).
                        - **核心动词/短语**：happen (发生), expect (期待), plan (计划), hope (希望).
                        - **高频短语**：find out (查明), watch a movie, be ready to (准备好...), think of (认为).

                        ### 2. 核心句式
                        1.  **表达看法**：What do you think of talk shows? — I love them. / I can't stand them.
                        2.  **表达意愿**：Do you want to watch the news? — Yes, I do.
                        3.  **询问喜好原因**：Why do you like soap operas? — Because they are relaxing.
                        4.  **陈述计划**：We plan to watch an action movie tonight.

                        ### 3. 重点语法
                        - **动词不定式 (to do)** 作宾语的用法。
                        - **think of / think about** 询问看法的句型。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mark**: What do you think of sitcoms, Sarah?
                        
                        **Sarah**: I don't mind them. They're OK. What about you?
                        
                        **Mark**: I can't stand them! They're so boring.
                        
                        **Sarah**: Well, do you want to watch a game show?
                        
                        **Mark**: Yes, I love game shows. I want to see who wins!

                        **【译文】**
                        
                        **马克**：莎拉，你觉得情景喜剧怎么样？
                        
                        **莎拉**：我不介意看它们。还可以。你呢？
                        
                        **马克**：我受不了它们！太无聊了。
                        
                        **莎拉**：好吧，那你想看比赛节目吗？
                        
                        **马克**：是的，我喜欢比赛节目。我想看看谁赢！

                        ### Section B (Reading) 阅读文段：Mickey Mouse
                        **【原文】**
                        
                        In 1928, Mickey Mouse appeared in the movie Steamboat Willie. He became the first cartoon character with a voice. People love Mickey because he is always ready to face any danger. He shows us that even a small person can do big things. Mickey is a symbol of American culture.

                        **【译文】**
                        
                        1928年，米老鼠出现在电影《威利号汽船》中。他成为了第一个有声音的卡通形象。人们爱米奇，因为他总是准备好面对任何危险。他向我们展示了即使是一个小人物也能做出大事业。米奇是美国文化的一种象征。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① what do you think of ...? (你认为...怎么样?)
                        - **【同义转换】**：`How do you like ...?`
                        - **【例题】**：
                        
                        *— ________ do you think of the new sitcom? — It's fantastic!*
                        A. How   B. What   C. Why   D. Where
                        
                        **[解析]**：think of 搭配 what，like 搭配 how，选 **B**。

                        #### ② can't stand (受不了)
                        - **【注意】**：这里的 stand 是动词，意为“忍受”。后接名词、代词或动词-ing。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：动词不定式作宾语
                        **1. 必背搭配**
                        有些动词后面必须接 `to do` 作宾语：
                        - want to do (想做)
                        - plan to do (计划做)
                        - hope to do (希望做)
                        - expect to do (期待做)
                        - decide to do (决定做)

                        **2. happen 的用法**
                        - `sth. happens to sb.` (某事发生在某人身上)
                        - `sb. happens to do sth.` (某人碰巧做某事)

                        **3. 中考真题特训**
                        
                        *(2024·重庆中考)* *My parents plan ________ to Beijing this summer vacation.*
                        A. go   B. going   C. to go   D. goes
                        
                        **[解析]**：plan to do sth. 固定搭配，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite TV Program (我最喜欢的电视节目)
                        **I like watching TV very much.**
                        
                        My **favourite TV program** is news. I **think** it is very **educational**. It helps me **find out** what's happening around the world. I also **don't mind** sitcoms because they are **funny**. However, I **can't stand** soap operas. I think they are too **boring**. I usually watch TV for one hour on weekends.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "I'm going to study computer science.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：职业理想，未来计划，新年展望 (Future plans and resolutions)。

                        ### 2. 单元主题内容
                        本单元以“职业理想与未来计划”为核心，重点学习一般将来时 `be going to` 的用法。学生通过讨论未来的职业选择（如 computer programmer, pilot, teacher 等）以及实现理想的具体步骤（how, when, where），学会设定人生目标并制定行动计划。单元还涉及了新年计划（New Year's Resolutions），引导学生学会规划生活，坚持梦想。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **职业名词**：programmer, cook, doctor, engineer, violinist, driver, pilot, scientist.
                        - **核心名词/动词**：resolution (决心), team (队伍), foreign (外国的), improve (改进), discuss (讨论).
                        - **高频短语**：grow up (长大), be sure about (确信), make sure (确保), send ... to ... (把...发送到...), take singing lessons (上歌唱课).

                        ### 2. 核心句式
                        1.  **询问职业理想**：What do you want to be when you grow up? — I want to be a scientist.
                        2.  **询问实现方式**：How are you going to do that? — I'm going to study hard.
                        3.  **询问时间/地点**：Where are you going to work? — In Shanghai.
                        4.  **描述新年计划**：My New Year's resolution is to learn a new language.

                        ### 3. 重点语法
                        - **一般将来时 (be going to)** 表示打算或计划。
                        - **want to be + 职业** 的用法。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Lucy**: What do you want to be when you grow up, Sam?
                        
                        **Sam**: I want to be a computer programmer.
                        
                        **Lucy**: How are you going to do that?
                        
                        **Sam**: I'm going to study computer science in university.
                        
                        **Lucy**: Where are you going to work?
                        
                        **Sam**: I'm going to work in Beijing.

                        **【译文】**
                        
                        **露西**：萨姆，你长大后想做什么？
                        
                        **萨姆**：我想做一名电脑程序员。
                        
                        **露西**：你打算怎么做？
                        
                        **萨姆**：我打算在大学里学习计算机科学。
                        
                        **露西**：你打算在哪儿工作？
                        
                        **萨姆**：我打算在北京工作。

                        ### Section B (Reading) 阅读文段：New Year's Resolutions
                        **【原文】**
                        
                        A resolution is a kind of promise. Most of the time, we make resolutions to other people. But the most common resolutions are the ones we make to ourselves at the beginning of a year. Some people want to improve their health. Some want to get better grades. But many people forget their resolutions after a few weeks. The best way is to make a plan and follow it.

                        **【译文】**
                        
                        决心是一种承诺。大多数时候，我们向他人做出承诺。但最常见的决心是我们在年初对自己做出的承诺。有些人想改善健康。有些人想取得更好的成绩。但许多人在几周后就忘记了自己的决心。最好的方法是制定计划并执行它。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① grow up (长大; 成长)
                        - **【注意】**：grow 是不规则动词，过去式为 grew。
                        
                        #### ② be sure about (确信; 对...有把握)
                        - **【用法总结】**：后面接名词、代词或动词-ing。
                        - **【例题】**：
                        
                        *Are you ________ about the date of the meeting?*
                        A. sure   B. surely   C. clear   D. known
                        
                        **[解析]**：be sure about 固定短语，选 **A**。

                        #### ③ improve (v. 改进; 改善)
                        - **【名词形式】**：`improvement`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：一般将来时 (be going to)
                        **1. 基本结构**
                        主语 + be (am/is/are) + going to + 动词原形.
                        
                        **2. 句式变换**
                        - 否定：be + not + going to.
                        - 疑问：Be + 主语 + going to ...?

                        **3. 标志词**
                        tomorrow, next week, soon, in two days 等。

                        **4. 中考真题特训**
                        
                        *(2024·安徽中考)* *We ________ a basketball match against Class 2 next Sunday.*
                        A. have   B. had   C. are going to have   D. were having
                        
                        **[解析]**：next Sunday 提示用将来时，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Future Plan (我的未来计划)
                        **When I grow up, I want to be an English teacher.**
                        
                        To achieve my dream, I am **going to study** English very hard. I'm also **going to read** many English books to improve my knowledge. After I finish university, I am **going to work** in a middle school. I want to help more students love English. This is my plan. I **will make sure** it comes true.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "Will people have robots?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：科学与技术 (Science and technology)
                        *   **子主题**：未来生活预测，科技发展，环境变化 (Future life)。

                        ### 2. 单元主题内容
                        本单元以“预测未来”为核心，重点学习一般将来时 `will` 的用法。学生通过畅想 100 年后的世界（如 robots, flying cars, environment 等），学习如何表达可能性和预见性。单元对比了 more / less / fewer 的用法，引导学生关注环境问题（pollution），思考人类科技进步与自然和谐共生的关系。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **科技词汇**：robot, space station, apartment, human, servant.
                        - **数量修饰词**：more (更多), less (更少 - 不可数), fewer (更少 - 可数).
                        - **核心动词**：believe (相信), agree (同意), disagree (不同意), possible (可能的).
                        - **高频短语**：on a computer, hundreds of (成百上千的), fall in love with (爱上), play a part in (参与).

                        ### 2. 核心句式
                        1.  **未来预测**：Will people have robots in their homes? — Yes, they will.
                        2.  **环境预测**：There will be more pollution and fewer trees.
                        3.  **数量对比**：There will be less free time for people.
                        4.  **表达观点**：I disagree. I think there will be more green trees.

                        ### 3. 重点语法
                        - **一般将来时 (will)** 的用法。
                        - **There will be** 句型。
                        - **fewer 与 less** 的辨析。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Bill**: What will the future be like?
                        
                        **Nancy**: I think there will be more robots. They will do all the work.
                        
                        **Bill**: Will people live to be 200 years old?
                        
                        **Nancy**: Yes, they will. And they will live on other planets.
                        
                        **Bill**: That's amazing! But I hope there will be less pollution.

                        **【译文】**
                        
                        **比尔**：未来会是什么样子？
                        
                        **南希**：我觉得会有更多的机器人。它们会做所有的工作。
                        
                        **比尔**：人们会活到200岁吗？
                        
                        **南希**：是的，会。而且他们会住在其他星球上。
                        
                        **比尔**：那太惊人了！但我希望污染会更少。

                        ### Section B (Reading) 阅读文段：Do You Have a Robot?
                        **【原文】**
                        
                        Today there are already robots working in factories. But in the future, will every home have a robot? Some scientists believe robots will be like humans. They will help us with housework and even talk to us. However, it is difficult to make robots think like humans. We don't know what will happen in the future.

                        **【译文】**
                        
                        今天已经有机器人在工厂工作了。但在未来，每个家庭都会有机器人吗？一些科学家相信机器人会像人类一样。它们会帮我们做家务，甚至和我们聊天。然而，让机器人像人类一样思考是困难的。我们不知道未来会发生什么。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① fewer vs less (更少)
                        - **【辨析】**：
                            *   `fewer`：修饰**可数名词复数**。*fewer cars*。
                            *   `less`：修饰**不可数名词**。*less water*。
                        - **【例题】**：
                        
                        *If we protect the environment, there will be ________ pollution.*
                        A. fewer   B. less   C. more   D. many
                        
                        **[解析]**：pollution 是不可数名词，表示更少用 less，选 **B**。

                        #### ② agree (v. 同意)
                        - **【搭配】**：`agree with sb.` 同意某人；`agree to do sth.` 同意做某事。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：There will be 句型
                        表示“将来某地会有某物”。
                        **1. 结构**
                        There will be + 主语 + 地点/时间.
                        - *There will be a meeting tomorrow.*
                        
                        **2. 易错点**
                        不能说 There will have...。

                        **3. will 与 be going to 的微差**
                        - `will`：常用于临时的决定、客观规律或纯粹的预测。
                        - `be going to`：常用于主观的打算、计划或有迹象表明要发生的事。

                        **4. 中考真题特训**
                        
                        *(2023·广东中考)* *I think there ________ more trees in our city in two years.*
                        A. is   B. are   C. will be   D. will have
                        
                        **[解析]**：in two years 提示将来时，且为 there be 句型，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Life in 100 Years (百年后的生活)
                        **Life in 100 years will be very different.**
                        
                        I think **there will be** robots in every home. They **will help** us do all the chores. People **won't use** money; everything will be paid by face. Children **will study** at home on computers. I also believe there **will be less pollution** because people **will use** clean energy. It will be a wonderful world!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "How do you make a banana milk shake?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：饮食制作，烹饪步骤，健康生活 (Food preparation)。

                        ### 2. 单元主题内容
                        本单元以“制作食物”为话题，重点学习描述过程的说明性语言。学生将学会使用 First, Next, Then, Finally 等连接词来描述步骤（如 make a milk shake, turkey sandwich 等）。同时，单元强化了可数与不可数名词在数量表达上的差异（how many / how much），旨在培养学生的动手能力和生活自理能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **食物原材料**：banana, milk, yogurt, honey, salt, sugar, cheese, butter, turkey, pepper.
                        - **烹饪动词**：peel (剥皮), cut up (切碎), put ... into ... (放入), pour (倒), add (添加), mix up (混合).
                        - **核心名词**：shake (奶昔), blender (搅拌机), hole (洞), piece (片).
                        - **高频短语**：how many / how much, turn on (接通电源), a cup of (一杯), First... Next... Then... Finally...

                        ### 2. 核心句式
                        1.  **询问制作方法**：How do you make a banana milk shake?
                        2.  **询问数量**：How many bananas do we need? / How much milk do we need?
                        3.  **描述步骤**：First, peel the bananas. Next, put them into the blender.
                        4.  **描述传统饮食**：In America, people eat turkey on Thanksgiving.

                        ### 3. 重点语法
                        - **祈使句** 用于描述指令。
                        - **可数与不可数名词** 的数量询问。
                        - **序列词** (First, Next...) 的应用。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Anna**: Let's make a banana milk shake. 
                        
                        **Sam**: OK. How do we start?
                        
                        **Anna**: First, peel three bananas and cut them up. 
                        
                        **Sam**: Done. What's next?
                        
                        **Anna**: Next, put the bananas and ice-cream into the blender. Then pour the milk into it. 
                        
                        **Sam**: Should I turn it on now?
                        
                        **Anna**: Yes. Finally, add some honey if you like.

                        **【译文】**
                        
                        **安娜**：让我们做香蕉奶昔吧。
                        
                        **萨姆**：好的。我们怎么开始？
                        
                        **安娜**：首先，剥三个香蕉并把它们切碎。
                        
                        **萨姆**：做好了。下一步呢？
                        
                        **安娜**：接下来，把香蕉和冰淇淋放入搅拌机。然后把牛奶倒进去。
                        
                        **萨姆**：我现在应该打开电源吗？
                        
                        **安娜**：是的。最后，如果你喜欢的话加点蜂蜜。

                        ### Section B (Reading) 阅读文段：Thanksgiving in North America
                        **【原文】**
                        
                        Thanksgiving is a traditional festival in North America. People always have a big dinner with their families. The most important dish is roast turkey. To make it, you need to fill the turkey with bread pieces and onions. Then put it in the oven. When it is ready, everyone enjoys the delicious food together.

                        **【译文】**
                        
                        感恩节是北美的一个传统节日。人们总是和家人一起吃一顿丰盛的晚餐。最重要的菜肴是烤火鸡。制作它，你需要用面包块和洋葱填满火鸡。然后把它放进烤箱。当它准备好时，大家一起享用美食。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① how many vs how much (多少)
                        - **【辨析】**：
                            *   `how many`：修饰可数名词复数。
                            *   `how much`：修饰不可数名词。
                        - **【例题】**：
                        
                        *— ________ honey do we need? — Two spoons.*
                        A. How many   B. How much   C. How long   D. How far
                        
                        **[解析]**：honey 不可数，选 **B**。

                        #### ② cut up (切碎)
                        - **【用法】**：动副短语。代词作宾语放中间。*cut it up*。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：序列词与祈使句
                        **1. 序列词 (Sequence Words)**
                        - First (首先)
                        - Next (接下来)
                        - Then (然后)
                        - Finally (最后)
                        这些词让过程描述逻辑清晰。

                        **2. 祈使句在说明书中的应用**
                        省略主语 you，直接动词原形开头。
                        - *Add some salt.*
                        - *Don't mix them up yet.*

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *________ the meat into small pieces, and then put it into the pot.*
                        A. Cut up   B. To cut up   C. Cutting up   D. Cuts up
                        
                        **[解析]**：表示指令，用祈使句动词原形开头，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：How to Make My Favourite Food (如何制作我最喜欢的食物)
                        **My favourite food is fruit salad. It's easy to make.**
                        
                        **First**, buy some fresh fruit like apples, bananas and grapes. **Next**, wash the fruit and **cut them up** into small pieces. **Then**, put them into a large bowl. **After that**, add two spoons of salad cream. **Finally**, **mix them up**. Now you can enjoy the delicious fruit salad!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u9", "Unit 9", "Can you come to my party?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：发出邀请，接受/拒绝邀请，礼貌社交 (Invitations)。

                        ### 2. 单元主题内容
                        本单元围绕“社交邀请”展开，重点学习如何得体地发出邀请（Can you...? / Would you like to...?）以及如何礼貌地做出应答。学生将学习在不同情境下（如 party, concert, exam study 等）平衡社交与责任。单元旨在培养学生的跨文化交际礼仪，学会在拒绝他人时给出合理的理由（excuses），维护和谐的人际关系。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **活动词汇**：party, concert, exam, competition, opening.
                        - **回复词汇**：accept (接受), refuse (拒绝), invitation (邀请), reason (理由).
                        - **核心动词**：prepare (准备), catch (赶上), hang (悬挂), delete (删除).
                        - **高频短语**：have to (不得不), go to the doctor (看医生), study for a test (为考试复习), hang out (闲逛), look after (照顾).

                        ### 2. 核心句式
                        1.  **发出邀请**：Can you come to my party on Saturday?
                        2.  **接受邀请**：Sure, I'd love to. / Certainly.
                        3.  **礼貌拒绝**：I'm sorry, I can't. I have to study for a test.
                        4.  **告知日期**：The opening is on Monday, January 10th.

                        ### 3. 重点语法
                        - **情态动词 can** 表示发出邀请。
                        - **be + v.-ing** 表示按计划将要发生的未来动作。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Jeff**: Hey, Mary. Can you come to my party on Saturday night?
                        
                        **Mary**: I'm sorry, Jeff. I can't. I have to look after my sister.
                        
                        **Jeff**: That's too bad. What about you, May?
                        
                        **May**: I'd love to, but I am going to the concert with my mom.
                        
                        **Jeff**: OK. Maybe next time.

                        **【译文】**
                        
                        **杰夫**：嘿，玛丽。你周六晚上能来参加我的派对吗？
                        
                        **玛丽**：抱歉，杰夫。我不能去。我不得不照顾我的妹妹。
                        
                        **杰夫**：那太遗憾了。你呢，小梅？
                        
                        **小梅**：我很乐意去，但我打算和我妈妈一起去听音乐会。
                        
                        **杰夫**：好吧。也许下次吧。

                        ### Section B (Reading) 阅读文段：An Invitation to a Moving Party
                        **【原文】**
                        
                        Dear friends, I'm moving to a new house next week! I want to have a moving party. Can you come? It will be on Friday, June 5th at 6:00 p.m. We will have great food and games. Please reply to my invitation by Wednesday. I hope to see you all! Love, Ms. Steen.

                        **【译文】**
                        
                        亲爱的朋友们，下周我要搬新家了！我想举办一个乔迁派对。你们能来吗？时间是6月5日，周五，下午6点。我们将会有美食和游戏。请在周三前回复我的邀请。我希望能见到你们大家！爱您的，斯汀女士。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① prepare (v. 准备)
                        - **【用法】**：`prepare for sth.` 为某事做准备。
                        
                        #### ② look after (照顾)
                        - **【同义词】**：`take care of`。
                        
                        #### ③ reply to (回复)
                        - **【注意】**：reply 是不及物动词，后接对象需加 to。
                        - **【例题】**：
                        
                        *Please ________ my email as soon as possible.*
                        A. answer to   B. reply   C. reply to   D. answer for
                        
                        **[解析]**：reply to = answer，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：情态动词 can 的邀请功能
                        **1. 邀请句式**
                        - Can you come to ...?
                        - Would you like to come to ...?
                        
                        **2. 答语的艺术**
                        - 接受：Sure, I'd love to. / I'd be happy to.
                        - 拒绝：I'm sorry, I'm afraid I can't. I have to ... (一定要加理由)。

                        **3. 含有 to 的不定式作宾语补足语**
                        - `invite sb. to do sth.` (邀请某人做某事)

                        **4. 中考真题特训**
                        
                        *(2024·安徽中考)* *— Would you like to go to the museum with me? — ________, but I'm busy today.*
                        A. No, I wouldn't   B. I'd love to   C. Yes, please   D. It doesn't matter
                        
                        **[解析]**：but 提示转折，前句应表示“我很想去”，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：An Invitation (一封邀请函)
                        **Dear Jack,**
                        
                        How's it going? I'm having a **birthday party** at my home this Sunday afternoon. **Can you come?** We will have some **delicious food** and **play games**. The party starts at 2:00 p.m. 
                        
                        I really hope you can make it. Please **reply to me** by Friday. 
                        
                        Yours, 
                        Li Hua
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u10", "Unit 10", "If you go to the party, you'll have a great time!",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：决策后果，问题解决，社交建议 (Decision making and advice)。

                        ### 2. 单元主题内容
                        本单元以“决策与后果”为核心，重点学习 `if` 引导的条件状语从句。通过讨论派对安排、职业选择及青少年面临的困惑（如 problem solving），学生能够运用“主将从现”的逻辑进行推理预测。单元旨在引导学生学会理性思考，明白每一个选择都有其相应的后果，并学习在遇到问题时积极寻求帮助，构建积极的人生态度。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **社交词汇**：party, meeting, video, chocolate, flower.
                        - **问题解决**：solve (解决), experience (经验), advice (建议 - 不可数), share (分享).
                        - **核心名词/动词**：expert (专家), trust (相信), mistake (错误), careless (粗心的).
                        - **高频短语**：stay at home, have a great time, keep ... to oneself (保守秘密), in half (分成两半), solve a problem (解决问题).

                        ### 2. 核心句式
                        1.  **条件预测**：If you go to the party, you'll have a great time.
                        2.  **否定预测**：If you don't study hard, you won't pass the exam.
                        3.  **询问后果**：What will happen if we have the party today?
                        4.  **寻求建议**：What should I do? — You should talk to your parents.

                        ### 3. 重点语法
                        - **If 引导的条件状语从句** (主将从现)。
                        - **情态动词 should** 表示建议。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Nancy**: Are you going to the party, Jeff?
                        
                        **Jeff**: If I finish my homework, I'll go.
                        
                        **Nancy**: If you go, will you wear jeans?
                        
                        **Jeff**: No, I won't. If I wear jeans, the teacher won't let me in.
                        
                        **Nancy**: That's true. You should wear your school uniform.

                        **【译文】**
                        
                        **南希**：你要去参加派对吗，杰夫？
                        
                        **杰夫**：如果我完成了作业，我就去。
                        
                        **南希**：如果你去，你会穿牛仔裤吗？
                        
                        **杰夫**：不，我不会。如果我穿牛仔裤，老师不会让我进去的。
                        
                        **南希**：那倒是。你应该穿校服。

                        ### Section B (Reading) 阅读文段：Students' Problems
                        **【原文】**
                        
                        Everyone has problems. Some students worry about their grades. Others worry about their friends. If you have a problem, you should talk to someone. Don't keep it to yourself. If you talk to an expert or a friend, they can help you solve it. Remember, sharing a problem is like cutting it in half.

                        **【译文】**
                        
                        每个人都有问题。一些学生担心他们的成绩。另一些人担心他们的朋友。如果你有问题，你应该找人谈谈。不要闷在心里。如果你找专家或朋友谈，他们能帮你解决。记住，分享一个问题就像把它切成两半。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① advice (n. 建议)
                        - **【用法总结】**：**不可数名词**。表示一条建议用 `a piece of advice`。
                        - **【动词形式】**：`advise` (v. 建议)。
                        
                        #### ② solve vs settlement
                        - **【搭配】**：`solve a problem` 解决问题。
                        
                        #### ③ keep ... to oneself (守口如瓶; 独自承受)
                        - **【例题】**：
                        
                        *If you feel sad, you shouldn't ________. Share it with your mother.*
                        A. keep it to yourself   B. keep it up   C. keep away   D. keep on
                        
                        **[解析]**：根据 Share it 可知，不要“闷在心里”，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：If 条件句之“主将从现”
                        **1. 法则定义**
                        在 if 引导的条件状语从句中，如果主句用一般将来时 (will)，从句要用**一般现在时**表示将来。
                        
                        **2. 句式结构**
                        - 主句 (will) + if + 从句 (一般现在时).
                        - If + 从句 (一般现在时), 主句 (will).
                        
                        **3. 特殊情况**
                        如果主句是祈使句或含有情态动词 (should, can)，从句依然用一般现在时。

                        **4. 中考真题特训**
                        
                        *(2024·天津中考)* *If it ________ tomorrow, we ________ go to the park.*
                        A. rains; won't   B. will rain; don't   C. rain; won't   D. raining; don't
                        
                        **[解析]**：if 从句用一般现在时（主语 it 用单三 rains），主句用将来时，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Giving Advice (提供建议)
                        **Dear Friend,**
                        
                        I know you are worried about your English study. **If you practice** every day, you **will improve** quickly. First, you should **listen to** English tapes. **If you have** problems, don't **keep them to yourself**. You should **talk to** your teacher. I believe you will do better.
                        
                        Best wishes!
                    """.trimIndent())
                )
            )
        )
        )
        }
