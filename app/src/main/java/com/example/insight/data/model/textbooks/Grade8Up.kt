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
        )
    )
}
