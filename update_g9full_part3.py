import re

file_path = 'app/src/main/java/com/example/insight/data/model/textbooks/Grade9Full.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Pattern to find the insertion point before the last closing ) ) )
insertion_point = re.compile(r'(\s*)\)\s*\)\s*\}\s*$', re.DOTALL)

new_units = ''',
            TextbookUnit(
                "g9full_u9", "Unit 9", "I like music that I can dance to.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：文学、艺术与体育 (Literature and art)
                        *   **子主题**：音乐与电影喜好，个人审美，文化生活 (Arts and preferences)。

                        ### 2. 单元主题内容
                        本单元以“音乐与电影”为话题，重点学习定语从句（Relative Clauses）。通过表达自己对不同艺术形式的偏好（如 I like music that... / I prefer movies which...），学生能够运用关系代词 that, which, who 引导的从句进行更复杂的语义表达。单元旨在培养学生的审美情趣，引导其在欣赏多元艺术的过程中形成独立的思考与品味。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **艺术词汇**：lyrics (歌词), director (导演), documentary (纪录片), drama (戏剧), Australian.
                        - **核心动词/形容词**：prefer (更喜欢), electronic (电子的), smooth (平滑的), spare (空闲的).
                        - **高频短语**：stick to (坚持), down (悲哀), plenty of (大量的), shut off (关闭), in total (总共).

                        ### 2. 核心句式
                        1.  **表达喜好**：I like music that I can dance to.
                        2.  **选择偏好**：I prefer movies that can give me something to think about.
                        3.  **描述特征**：She is the musician who plays the piano beautifully.
                        4.  **建议与动作**：What do you do in your spare time?

                        ### 3. 重点语法
                        - **定语从句**（关系代词 that, which, who 的用法）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Tony**: What kind of music do you like, Betty? 
                        
                        **Betty**: I like music that has great lyrics. What about you? 
                        
                        **Tony**: I prefer music that I can dance to. 
                        
                        **Betty**: Do you like smooth music? 
                        
                        **Tony**: No, I think it's too quiet. I like loud music that makes me feel energetic.

                        **【译文】**
                        
                        **托尼**：贝蒂，你喜欢哪种音乐？
                        
                        **贝蒂**：我喜欢歌词写得好的音乐。你呢？
                        
                        **托尼**：我更喜欢能跟着跳舞的音乐。
                        
                        **贝蒂**：你喜欢悦耳柔和的音乐吗？
                        
                        **托尼**：不，我不喜欢。我觉得那太安静了。我喜欢能让我感到精力充沛的大声音乐。

                        ### Section B (Reading) 阅读文段：Abing's Music
                        **【原文】**
                        
                        Erhu music is very famous in China. One of the greatest Erhu musicians was Abing. His music, like "Erquan Yingyue", is very moving. It tells a story of sadness and pain. Abing was blind, but he could "see" the world through music. People can feel his deep love for life when they listen to his songs. It is a masterpiece that everyone should hear.

                        **【译文】**
                        
                        二胡音乐在中国非常著名。最伟大的二胡音乐家之一是阿炳。他的音乐，如《二泉映月》，非常动人。它讲述了一个忧伤和痛苦的故事。阿炳失明了，但他能通过音乐“看”世界。人们听他的歌时能感受到他对他对生活深沉的爱。这是一部每个人都应该听的杰作。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. I like music that has great lyrics. (我喜欢歌词很棒的音乐。)
                        - **【句式剖析】**：`that` 是关系代词，在从句中充当主语，修饰先行词 `music`。
                        
                        #### 2. I prefer movies which are interesting. (我更喜欢有趣的电影。)
                        - **【要点精讲】**：`prefer` 意为“更喜欢”。常用 `prefer A to B` 表示“比起B更喜欢A”。
                        
                        #### 3. He is the person who taught me English. (他是那个教我英语的人。)
                        - **【词块归纳】**：先行词是“人”时，引导词用 `who` 或 `that`。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① prefer (v. 更喜欢)
                        - **【用法总结】**：
                            *   `prefer A to B`：比起B更喜欢A。
                            *   `prefer doing A to doing B`：比起做B更喜欢做A。
                            *   `prefer to do sth.`：宁愿做某事。
                        - **【例题】**：
                        
                        *I prefer ________ at home to ________ outside.*
                        A. stay; go   B. staying; going   C. to stay; go   D. staying; go
                        
                        **[解析]**：prefer doing to doing，选 **B**。

                        #### ② stick to (坚持; 粘住)
                        - **【搭配】**：`stick to one's promise` (坚持承诺)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：定语从句 (Relative Clauses)
                        **1. 引导词的选择**
                        - **that**：既可指人也可指物。
                        - **which**：只能指物。
                        - **who**：只能指人。
                        
                        **2. 谓语一致性**
                        从句的谓语动词在人称和数上必须与先行词保持一致。
                        - *The boy who **is** (单数) talking is my friend.*
                        - *The boys who **are** (复数) talking are my friends.*

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *I like the teacher ________ is always kind to students.*
                        A. which   B. who   C. whose   D. what
                        
                        **[解析]**：先行词是 teacher (人)，引导词用 who，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite Art (我最喜欢的艺术形式)
                        **Music is an important part of my life.** 
                        
                        I like **music that** has a beautiful melody. It makes me **feel relaxed** after a busy day. I also **prefer movies which** are educational. I think **documentaries** are great because they teach me **plenty of** knowledge. Art makes our life **colorful**.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u10", "Unit 10", "You're supposed to shake hands.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：各国社交礼仪，文化差异，得体行为 (Customs and manners)。

                        ### 2. 单元主题内容
                        本单元以“社交礼仪”为核心，重点学习 `be supposed to` 结构的用法。通过探讨不同国家在初次见面、用餐、聚会等场合下的习俗差异（如 shaking hands, bowing, arriving on time 等），引导学生学会尊重文化多元性。单元强调了“入乡随俗（When in Rome, do as the Romans do）”的重要性，培养学生的国际视野和跨文化沟通的敏感度。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **礼仪词汇**：custom, bow (鞠躬), kiss, handshake, greet.
                        - **餐桌礼仪**：chopsticks, spoon, napkin, fork, manner.
                        - **核心形容词/动词**：relaxed, basic, behave (表现), except (除...之外).
                        - **高频短语**：be supposed to (被要求...), shake hands (握手), for the first time, drop by (顺便拜访), pointing at (指向).

                        ### 2. 核心句式
                        1.  **描述惯例**：You're supposed to shake hands.
                        2.  **表达禁止/不当**：You're not supposed to eat with your hands.
                        3.  **询问习俗**：What are you supposed to do if you're invited to a party?
                        4.  **描述感受**：I was a bit relaxed about time.

                        ### 3. 重点语法
                        - **be supposed to do sth.** 的用法。
                        - **It is + adj. + to do sth.** 的应用。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Maria**: Hi, Katie. How was the party last night? 
                        
                        **Katie**: It was OK, but I made a mistake. 
                        
                        **Maria**: What happened? 
                        
                        **Katie**: I arrived at seven, but the party was supposed to start at eight. 
                        
                        **Maria**: Oh, in America, people are supposed to arrive a bit late for parties. 
                        
                        **Katie**: I see. Next time I'll be more careful.

                        **【译文】**
                        
                        **玛丽亚**：嗨，凯蒂。昨晚的聚会怎么样？
                        
                        **凯蒂**：还好，但我犯了个错误。
                        
                        **玛丽亚**：发生什么了？
                        
                        **凯蒂**：我七点到的，但聚会本应该八点开始。
                        
                        **玛丽亚**：哦，在美国，人们参加聚会应该是要晚到一会儿的。
                        
                        **凯蒂**：我明白了。下次我会更小心的。

                        ### Section B (Reading) 阅读文段：Table Manners in France
                        **【原文】**
                        
                        Table manners are very important in France. First, you are not supposed to start eating until everyone is ready. Second, you should keep your hands on the table, but not your elbows. Also, it is rude to cut your bread with a knife. You should break it with your hands. If you follow these rules, you will have a great dinner with your French friends.

                        **【译文】**
                        
                        在法国餐桌礼仪非常重要。首先，在每个人准备好之前你不应该开始吃。第二，你应该把手放在桌子上，但不要把肘部放上去。此外，用刀切面包是不礼貌的。你应该用手掰开它。如果你遵守这些规则，你将和你的法国朋友们度过一个愉快的晚餐。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. You're supposed to shake hands. (你应该握手。)
                        - **【句式剖析】**：`be supposed to` 意为“应当；被期望”，通常用来表达社会习惯、惯例或规则。
                        
                        #### 2. It's polite to arrive on time. (准时到达是有礼貌的。)
                        - **【用法拓展】**：`It is + adj. + to do sth.` 这里的 `It` 是形式主语。
                        
                        #### 3. We are relaxed about time. (我们对时间比较随意。)
                        - **【词块归纳】**：`be relaxed about sth.` 对某事感到放松/随意。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① except (prep. 除...之外)
                        - **【辨析】**：
                            *   `except`：除...之外（不包括在内）。
                            *   `besides`：除...之外（包括在内，还有）。
                        - **【例题】**：
                        
                        *Everyone is here ________ Tom. He is ill.*
                        A. except   B. besides   C. including   D. but
                        
                        **[解析]**：汤姆没来，不包括他在内，选 **A**。

                        #### ② shake hands (握手)
                        - **【注意】**：hands 必须用复数。`shake hands with sb.` 与某人握手。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：be supposed to 的“社交”语义
                        **1. 含义**
                        表达根据习俗、规则、约定等“应该...”或“被要求...”。
                        
                        **2. 时态变化**
                        - *was/were supposed to*：表示“本应该...（但没做）”。
                        
                        **3. 句式注意点**
                        - 否定：be not supposed to (不应该)。

                        **4. 中考真题特训**
                        
                        *(2023·广东中考)* *You are ________ to bring a gift when you visit a friend.*
                        A. supposed   B. needed   C. let   D. asked
                        
                        **[解析]**：根据社交礼仪，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Customs in My Country (介绍家乡习俗)
                        **China has a long history and many special customs.** 
                        
                        When you visit a Chinese home, you **are supposed to** take off your shoes. It is **polite** to bring some fruit as a gift. When having dinner, the older people **are supposed to** start eating first. You should never **point at** others with your chopsticks. I hope you will **enjoy your stay** in China.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u11", "Unit 11", "Sad movies make me cry.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：自我认识与自我管理 (Self-management)
                        *   **子主题**：情绪表达，环境对人的影响，友谊与快乐 (Emotions)。

                        ### 2. 单元主题内容
                        本单元聚焦“情绪与感受”，重点学习使役动词 `make` 的用法。通过探讨环境（如 background music, colors）、电影、天气及人际关系对个人心情的影响，引导学生认识并管理自己的情绪。单元强调了“友谊与责任比金钱更珍贵”的主题（如 The Shirt of a Happy Man），旨在培养学生积极乐观的心态，学会在压力中寻找快乐。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **情绪形容词**：sad, excited, uncomfortable, nervous, disappointed.
                        - **核心动词**：examine, kick, nod, shoulder, weight.
                        - **高频短语**：make sb. do sth. (使某人做某事), make sb. + adj., drive sb. crazy (使某人发疯), wait for (等待), the more ... the more ... (越...越...).

                        ### 2. 核心句式
                        1.  **表达影响**：Sad movies make me cry. / Loud music makes me nervous.
                        2.  **比较感受**：The more I study, the more I know.
                        3.  **描述状态**：I'd rather stay at home than go out.
                        4.  **哲理陈述**：Neither wealth nor power can bring you happiness.

                        ### 3. 重点语法
                        - **使役动词 make** 的两种主要用法（接省 to 不定式或接形容词）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Tina**: Let's go to the Blue Lagoon restaurant. 
                        
                        **Amy**: No, I'd rather go to the Rockin' Restaurant. 
                        
                        **Tina**: Why? 
                        
                        **Amy**: The soft music at Blue Lagoon makes me sleepy. 
                        
                        **Tina**: Well, loud music at Rockin' Restaurant makes me want to leave! 
                        
                        **Amy**: But the food is great there!

                        **【译文】**
                        
                        **蒂娜**：我们去蓝湖餐厅吧。
                        
                        **艾米**：不，我宁愿去摇滚餐厅。
                        
                        **蒂娜**：为什么？
                        
                        **艾米**：蓝湖餐厅轻柔的音乐让我昏昏欲睡。
                        
                        **蒂娜**：嗯，摇滚餐厅大声的音乐让我很想离开！
                        
                        **艾米**：但那里的食物很棒啊！

                        ### Section B (Reading) 阅读文段：The Shirt of a Happy Man
                        **【原文】**
                        
                        A king was very sad and ill. A doctor told him that he needed the shirt of a happy man to get well. The king sent his generals to find a happy man. They found a poor prime minister, but he wasn't happy. Finally, they met a beggar who was very happy. But the beggar didn't have a shirt at all! The king realized that happiness doesn't come from things.

                        **【译文】**
                        
                        一位国王非常忧郁且病重。一位医生告诉他，他需要穿上一个快乐的人的衬衫才能痊愈。国王派他的将军们去找一个快乐的人。他们找到了一个贫穷的首相，但他不快乐。最后，他们遇到一个非常快乐的乞丐。但那个乞丐根本没有衬衫！国王意识到快乐并不来源于物质。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Sad movies make me cry. (悲伤的电影让我哭泣。)
                        - **【句式剖析】**：`make` 是使役动词，后接宾语 `me`，再接宾语补足语（省略 to 的不定式 `cry`）。
                        
                        #### 2. I'd rather stay at home. (我宁愿待在家里。)
                        - **【要点精讲】**：`would rather do sth.` 宁愿做某事。否定形式为 `would rather not do`。
                        
                        #### 3. Neither wealth nor power can bring you happiness. (财富和权力都不能带给你快乐。)
                        - **【词块归纳】**：`neither ... nor ...` 既不...也不...。遵循“就近原则”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① make (使役动词)
                        - **【用法总结】**：
                            *   `make sb. do sth.` (让某人做某事 - 省 to)。
                            *   `make sb. + adj.` (使某人感到...)。
                        - **【例题】**：
                        
                        *The funny movie made us ________ for a long time.*
                        A. laugh   B. to laugh   C. laughing   D. laughed
                        
                        **[解析]**：make sb. do，选 **A**。

                        #### ② drive sb. crazy (使某人发狂/受不了)
                        - **【近义词】**：`drive sb. mad`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：make 的“变幻莫测”
                        **1. make + 宾语 + 形容词**
                        - *The news made him happy.*
                        
                        **2. make + 宾语 + 动词原形**
                        - *The teacher made us finish the work.*
                        
                        **3. 被动语态注意点**
                        当 make 用于被动语态时，原来省略的 **to** 必须还原。
                        - *We were made **to** clean the room.* (我们被要求打扫房间)

                        **4. 中考真题特训**
                        
                        *(2024·天津中考)* *Doing sports can make us ________ and ________.*
                        A. healthy; strong   B. health; strength   C. healthy; strength   D. health; strong
                        
                        **[解析]**：make sb. + adj.，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Emotions (我的情绪变化)
                        **Last week, I felt very disappointed.** 
                        
                        Because I failed the math test. The result **made me feel** sad. My mother **made me** talk to her about it. She said that **failure** was not the end. Her words **made me** feel much better. Now, I study **even harder**. I believe **persistence** will **make me** successful.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9full_u12", "Unit 12", "Life is full of the unexpected.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：意外事件，生活中的变数，时间管理 (Past events)。

                        ### 2. 单元主题内容
                        本单元以“生活中的意外”为话题，正式引入过去完成时（Past Perfect Tense）。通过讲述由于起晚、迟到、错过公交或遇到地震等突发事件（如 9/11 幸存者故事），学生能够运用 `had + p.p.` 来表达“过去的过去”。单元旨在引导学生学会从意外中吸取教训，培养积极应对挑战的心态，并强调珍惜生命与时间的重要性。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **核心动词**：oversleep (睡过头), rush (冲), realize (意识到), ring (响), disappear (消失).
                        - **核心名词**：airport, backpack, backpack, earthquake, survivor.
                        - **高频短语**：by the time (到...时候为止), give sb. a lift (捎某人一程), show up (赶到), in line with (排队等候), staring in disbelief (难以置信地盯着).

                        ### 2. 核心句式
                        1.  **描述过去先后**：By the time I got up, my brother had already gone to school.
                        2.  **表达意识到**：I realized that I had left my keys at home.
                        3.  **询问经历**：What happened to you this morning?
                        4.  **状态感叹**：How lucky I was!

                        ### 3. 重点语法
                        - **过去完成时** (had + 动词的过去分词)。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mary**: Why were you late for school, Matt? 
                        
                        **Matt**: I overslept. By the time I woke up, my father had already left. 
                        
                        **Mary**: Oh, no! What did you do? 
                        
                        **Matt**: I ran to the bus stop, but the bus had already gone. 
                        
                        **Mary**: That's terrible. How did you get here? 
                        
                        **Matt**: My neighbor gave me a lift.

                        **【译文】**
                        
                        **玛丽**：马特，你上学为什么迟到了？
                        
                        **马特**：我睡过头了。等我醒来的时候，我爸爸已经出发了。
                        
                        **玛丽**：噢，不！你怎么办的？
                        
                        **马特**：我跑向公交站，但公交车已经走了。
                        
                        **玛丽**：那太糟了。你是怎么到这儿的？
                        
                        **马特**：我的邻居捎了我一程。

                        ### Section B (Reading) 阅读文段：Unexpected Events in History
                        **【原文】**
                        
                        On September 11, 2001, many people had unexpected experiences. One man, for example, stayed at home because he had lost his keys. This saved his life. Another lady was late for work because she had forgotten to set her alarm. When the planes hit the buildings, she hadn't arrived yet. Life is indeed full of the unexpected.

                        **【译文】**
                        
                        2001年9月11日，许多人都有意想不到的经历。例如，一位男士因为丢了钥匙而待在家里。这救了他的命。另一位女士因为忘了设闹钟上班迟到了。当飞机撞击大楼时，她还没赶到。生活确实充满了意外。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. By the time I arrived, the meeting had started. (当我到达时，会议已经开始了。)
                        - **【句式剖析】**：`by the time` 引导的时间状语从句用一般过去时，主句通常用过去完成时。
                        
                        #### 2. I realized that I had left my backpack at home. (我意识到我把背包忘在家里了。)
                        - **【要点精讲】**：`realize` 之后接宾语从句，“忘在家里”发生在“意识到”之前，故用过去完成时。
                        
                        #### 3. My neighbor gave me a lift. (我的邻居载了我一程。)
                        - **【词块归纳】**：`give sb. a lift` 捎某人一程。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① leave (v. 遗忘; 离开)
                        - **【辨析】**：
                            *   `leave`：把某物忘在某地。*leave sth. at ...*
                            *   `forget`：忘记某事。*forget to do sth.*
                        - **【例题】**：
                        
                        *Oh, I ________ my umbrella on the bus.*
                        A. forgot   B. left   C. lost   D. missed
                        
                        **[解析]**：把物忘在特定地点用 leave，选 **B**。

                        #### ② show up (赶到; 露面)
                        - **【近义词】**：`arrive` / `appear`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：过去完成时 (Past Perfect)
                        **1. 定义**
                        表示“过去的过去”，即在过去某一动作或时间之前已经发生或完成的动作。
                        
                        **2. 构成**
                        had + 动词的过去分词 (p.p.).
                        
                        **3. 标志词**
                        by the time ..., when ..., before ..., already, by the end of ...

                        **4. 中考真题特训**
                        
                        *(2024·安徽中考)* *When I got to the station, the train ________ for ten minutes.*
                        A. left   B. has left   C. had been away   D. had left
                        
                        **[解析]**：get 是过去式，离开发生在之前，且持续了十分钟需用延续性短语 be away，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：An Unexpected Day (意外的一天)
                        **Yesterday was an unexpected day for me.** 
                        
                        I **overslept** in the morning. **By the time** I got to the bus stop, the bus **had already gone**. I had to **walk to** school. When I got to class, I **realized** that I **had forgotten** my homework. Luckily, my teacher **was not angry** with me. What an **unlucky** day!
                    """.trimIndent())
                )
            )
'''

# Append logic
new_content = insertion_point.sub(r'\1' + new_units + r'\1)\1)\1}\n', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_content)
