import re

file_path = 'app/src/main/java/com/example/insight/data/model/textbooks/Grade8Down.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Pattern to find the insertion point before the last closing ) ) )
insertion_point = re.compile(r'(\s*)\)\s*\)\s*\}\s*$', re.DOTALL)

new_units = ''',
            TextbookUnit(
                "g8down_u5", "Unit 5", "What were you doing when the rainstorm came?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self) / 人与社会 (Man and Society)
                        *   **主题群**：自然现象，历史事件 (Natural phenomena and events)
                        *   **子主题**：重大事件发生时的个人经历，自然灾害应对 (Past events)。

                        ### 2. 单元主题内容
                        本单元以“过去发生的重大事件”为背景，重点学习过去进行时（Past Progressive Tense）。通过描述暴雨来袭时（What were you doing when the rainstorm came?）或历史性时刻（如马丁·路德·金遇刺、911事件）人们正在进行的活动，引导学生学会有逻辑地叙述过去。单元强调在困难和灾难面前人们的互助与团结，培养学生的共情能力和面对突发事件的沉着态度。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **自然现象**：rainstorm, storm, wind, light, ice.
                        - **核心名词/动词**：alarm (闹钟), window (窗户), match (火柴), wood (木头), beat (敲击), rise (上升).
                        - **高频短语**：go off (闹钟响), take down (拆除), pick up (接电话), fall asleep (入睡), in a mess (乱七八糟).

                        ### 2. 核心句式
                        1.  **过去动作询问**：What were you doing when the rainstorm came? — I was sleeping.
                        2.  **时间引导**：While my mom was cooking, I was doing my homework.
                        3.  **状态描述**：The wind was blowing hard and the rain was beating against the windows.
                        4.  **因果表达**：I was so busy that I didn't see the light.

                        ### 3. 重点语法
                        - **过去进行时** 的构成 (was/were + v.-ing)。
                        - **when 与 while** 在时间状语从句中的用法辨析。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mary**: What were you doing at eight last night? 
                        
                        **Linda**: I was taking a shower. What about you? 
                        
                        **Mary**: I was doing my homework. Then the rainstorm came. 
                        
                        **Linda**: Oh, I heard it. The wind was blowing very hard. 
                        
                        **Mary**: Yes. My dad was helping my mom in the kitchen at that time.

                        **【译文】**
                        
                        **玛丽**：昨晚八点你正在做什么？
                        
                        **琳达**：我正在洗澡。你呢？
                        
                        **玛丽**：我正在做作业。然后暴雨就来了。
                        
                        **琳达**：噢，我听到了。风刮得很大。
                        
                        **玛丽**：是的。那时我爸爸正在厨房帮我妈妈。

                        ### Section B (Reading) 阅读文段：The Storm Brought Us Together
                        **【原文】**
                        
                        The weather was terrible last Friday. A heavy rainstorm came. My father was looking for some wood to put on the windows. My mother was making sure the flashlights and matches were ready. I was helping my younger brother. We were all busy, but we felt safe because we were together. The storm was strong, but it brought the family closer.

                        **【译文】**
                        
                        上周五天气很糟糕。一场大暴雨来袭。我爸爸正在找木头钉在窗户上。我妈妈正在确保手电筒和火柴准备好了。我正在帮助我的弟弟。我们都很忙，但我们感到安全，因为我们在一起。暴雨很猛烈，但它让家人联系得更紧密了。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What were you doing when the rainstorm came? (当暴雨来袭时你正在做什么？)
                        - **【句式剖析】**：`when` 引导的时间状语从句用一般过去时，主句用过去进行时。表示一个长动作正在进行时被一个短动作打断。
                        
                        #### 2. While my mom was cooking, my dad was washing the car. (当妈妈在做饭时，爸爸在洗车。)
                        - **【用法拓展】**：`while` 引导的两个动作通常都是延续性的，主从句均用过去进行时。
                        
                        #### 3. The alarm went off. (闹钟响了。)
                        - **【词块归纳】**：`go off` 指（闹钟）发出响声、爆炸、（电）断掉。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① when vs while
                        - **【辨析】**：
                            *   `when`：既可接点动词也可接延续动词。
                            *   `while`：必须接延续性动词，强调主从句动作同步进行。
                        - **【例题】**：
                        
                        *I was watching TV ________ my brother was playing games.*
                        A. when   B. while   C. since   D. after
                        
                        **[解析]**：前后都是过去进行时，强调同步，选 **B**。

                        #### ② fall asleep (入睡)
                        - **【辨析】**：`go to bed` (上床睡觉 - 动作)；`sleep` (睡觉 - 状态)；`fall asleep` (入睡 - 动作)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：过去进行时 (Past Progressive)
                        表示在过去某一时刻或某一段时间内正在进行的动作。
                        **1. 构成：was/were + v.-ing.**
                        
                        **2. 句式变换**
                        - 否定：wasn't/weren't + v.-ing.
                        - 疑问：Was/Were + 主语 + v.-ing ...?

                        **3. 常见标志词**
                        at that time, at 8:00 last night, when..., while...

                        **4. 中考真题特训**
                        
                        *(2024·安徽中考)* *I ________ a letter to my friend when someone knocked at the door.*
                        A. write   B. wrote   C. am writing   D. was writing
                        
                        **[解析]**：knocked 是过去式，主句表示当时正在进行的动作，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：An Important Event (记叙一次经历)
                        **Last Sunday, a heavy rain came suddenly.**
                        
                        At that time, I **was walking** in the park. People **were running** everywhere to find cover. I **was waiting** for the bus when I saw an old lady. She **was carrying** a lot of bags. I **ran to** her and helped her. Although we were both wet, we were happy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u6", "Unit 6", "An old man tried to move the mountains.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：文学、艺术与体育 (Literature and art)
                        *   **子主题**：中国传统故事，西方经典童话，文化传承 (Fairy tales and legends)。

                        ### 2. 单元主题内容
                        本单元以“经典故事”为线索，学习如何使用过去时态讲述中国传说（如《愚公移山》、《西游记》）和西方童话（如《糖果屋》、《皇帝的新衣》）。通过学习 as soon as, so...that, unless 等连词，学生能够更有逻辑地串联故事情节。单元旨在引导学生感悟故事背后的智慧、勤劳与善良，树立文化自信并进行跨文化比较。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **故事角色**：god, stone, king, tail, princess, husband, wife.
                        - **核心名词/形容词**：object (物体), hidden (隐藏的), magic (有魔力的), brave (勇敢的).
                        - **高频短语**：remind sb. of (提醒某人某事), turn ... into (把...变成), once upon a time (从前), keep doing (继续做某事).

                        ### 2. 核心句式
                        1.  **引入故事**：Once upon a time, there was an old man...
                        2.  **描述变化**：He can turn himself into different animals.
                        3.  **转折连词**：Unless you work hard, you won't finish the task.
                        4.  **因果结果**：The king was so stupid that he didn't wear any clothes.

                        ### 3. 重点语法
                        - **连词的应用**：as soon as (一...就), unless (除非), so...that (如此...以至于).
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Lily**: Have you ever heard of Yu Gong? 
                        
                        **Tom**: Yes. He was an old man who tried to move the mountains. 
                        
                        **Lily**: Why did he do that? 
                        
                        **Tom**: Because the mountains were so big that people couldn't walk easily. 
                        
                        **Lily**: It sounds difficult. 
                        
                        **Tom**: Yes, but he kept working and finally the god helped him.

                        **【译文】**
                        
                        **莉莉**：你听说过愚公吗？
                        
                        **汤姆**：是的。他是一位试图搬走大山的的老人。
                        
                        **莉莉**：他为什么要那样做？
                        
                        **汤姆**：因为那些山太大了，以至于人们走起路来不方便。
                        
                        **莉莉**：听起来很难。
                        
                        **汤姆**：是的，但他坚持工作，最后上帝帮助了他。

                        ### Section B (Reading) 阅读文段：Hansel and Gretel
                        **【原文】**
                        
                        Once upon a time, Hansel and Gretel lived near a forest. One day, they got lost. They walked until they saw a house made of candy. They were so hungry that they started to eat the house. Suddenly, an old woman came out. She wasn't kind. She was a witch! But Hansel and Gretel were brave and clever. In the end, they found their way home.

                        **【译文】**
                        
                        从前，韩塞尔和葛雷特住在森林附近。一天，他们迷路了。他们一直走，直到看到一座由糖果做的房子。他们太饿了，以至于开始吃那座房子。突然，一位老妇人走了出来。她并不友善。她是个女巫！但韩塞尔和葛雷特既勇敢又聪明。最后，他们找到了回家的路。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. As soon as the sun comes out, we should leave. (太阳一出来，我们就该离开。)
                        - **【句式剖析】**：`as soon as` 引导时间状语从句，遵循“主将从现”或“主情从现”原则。
                        
                        #### 2. Unless you work hard, you will fail. (除非你努力，否则你会失败。)
                        - **【用法拓展】**：`unless` = `if ... not`。
                        
                        #### 3. He was so excited that he couldn't sleep. (他如此兴奋以至于睡不着。)
                        - **【词块归纳】**：`so + adj./adv. + that + 从句`。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① remind sb. of sth. (使某人想起某事)
                        - **【例题】**：
                        
                        *This photo always ________ me ________ my happy childhood.*
                        A. reminds; of   B. reminds; at   C. remembers; of   D. tells; about
                        
                        **[解析]**：remind sb. of 为固定搭配，选 **A**。

                        #### ② turn ... into ... (把...变成...)
                        - **【拓展】**：`turn around` (回头), `turn off` (关上)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：复杂句中的连词
                        **1. as soon as** (一...就)
                        - *I will call you as soon as I arrive.*
                        
                        **2. unless** (除非; 如果不)
                        - *We'll go to the park unless it rains.*
                        
                        **3. so...that** (如此...以至于)
                        - *The box is so heavy that I can't lift it.*

                        **4. 中考真题特训**
                        
                        *(2023·北京中考)* *You will miss the bus ________ you hurry up.*
                        A. because   B. unless   C. if   D. until
                        
                        **[解析]**：语义为“除非你快点，否则会错过”，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite Story (我最喜欢的故事)
                        **My favourite story is Monkey King.**
                        
                        **Once upon a time**, there was a clever monkey. He was **brave and strong**. He could **turn himself into** 72 different things. He used a **magic** stick to fight against bad people. I like him **because** he never gives up. He **reminds me of** the importance of being brave.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u7", "Unit 7", "What's the highest mountain in the world?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自然 (Man and Nature)
                        *   **主题群**：世界地理与环境保护 (Geography and environment)
                        *   **子主题**：地理之最，自然奇观，动物保护 (Nature and wildlife)。

                        ### 2. 单元主题内容
                        本单元以“世界之最”为话题，深入学习大数字的表达以及形容词/副词比较级与最高级的进阶用法。学生将通过探讨珠穆朗玛峰、长江、大熊猫等地理和生物知识，增强对祖国大好河山的热爱。单元特别强调了大熊猫保护的现状，引导学生关注濒危动物，培养环保意识和人与自然和谐共处的全球视野。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **大数字/度量**：square (平方), meter (米), deep (深), wide (宽), population (人口).
                        - **自然/动物**：mountain, desert (沙漠), ocean, panda, bamboo, whale (鲸).
                        - **核心词汇**：condition (条件), achieve (实现), force (力量; 强迫), protect (保护).
                        - **高频短语**：as far as I know (据我所知), in the world (世界上), take in (吸入; 欺骗), up to (到达; 多达).

                        ### 2. 核心句式
                        1.  **询问高度/长度**：How high is Qomolangma? — It's 8,848.86 meters high.
                        2.  **最高级表达**：What is the longest river in the world?
                        3.  **倍数比较**：China is much bigger than any other country in Asia.
                        4.  **保护建议**：We should try our best to protect pandas.

                        ### 3. 重点语法
                        - **大数字的读法** (thousand, million, billion)。
                        - **比较级与最高级** 的进阶应用（any other, the second highest 等）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teacher**: Does anyone know what's the highest mountain in the world? 
                        
                        **Student**: Yes, it's Qomolangma. It's about 8,848 meters high. 
                        
                        **Teacher**: Correct. And what's the longest river in China? 
                        
                        **Student**: That's the Yangtze River. It's about 6,300 kilometers long. 
                        
                        **Teacher**: Very good! China has many amazing natural wonders.

                        **【译文】**
                        
                        **老师**：有人知道世界上最高的山峰是什么吗？
                        
                        **学生**：知道，是珠穆朗玛峰。它大约8848米高。
                        
                        **老师**：正确。那中国最长的河流是什么？
                        
                        **学生**：是长江。它大约6300千米长。
                        
                        **老师**：非常好！中国有很多神奇的自然奇观。

                        ### Section B (Reading) 阅读文段：Saving the Pandas
                        **【原文】**
                        
                        Pandas are one of the most famous animals in the world. They live in the forests of China and eat bamboo. But now there are only about 1,800 pandas living in the wild. Many people are working hard to save them. They set up panda bases to help the pandas have more babies. We must protect their homes so they won't disappear.

                        **【译文】**
                        
                        大熊猫是世界上最著名的动物之一。它们住在中国森林里，吃竹子。但现在野外大约只有1800只大熊猫。许多人正在努力拯救它们。他们建立大熊猫基地来帮助大熊猫繁育后代。我们必须保护它们的家园，这样它们才不会消失。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Qomolangma is 8,848 meters high. (珠穆朗玛峰有8848米高。)
                        - **【用法拓展】**：`数字 + 单位 + 形容词(high/long/wide/deep)` 表达度量。
                        
                        #### 2. It's much deeper than the Atlantic Ocean. (它比大西洋深得多。)
                        - **【要点精讲】**：比较级前加 `much, far, a lot, even, a little` 表示程度。
                        
                        #### 3. China has the largest population in the world. (中国拥有世界上最多的人口。)
                        - **【词块归纳】**：`population` 指人口，问数量用 `How large` 而非 how many。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① any other ... (任何其他的...)
                        - **【注意】**：用于比较级表达最高级含义。
                        - **【例题】**：
                        
                        *Li Hua is taller than ________ student in his class.*
                        A. any   B. any other   C. all   D. other
                        
                        **[解析]**：在同一班级内比较，需排除李华本人，选 **B**。

                        #### ② protect ... from ... (保护...免受...)
                        - **【例题】**：
                        
                        *We should protect the earth ________ pollution.*
                        A. from   B. with   C. at   D. for
                        
                        **[解析]**：固定搭配 protect ... from ...，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：大数字与进阶比较级
                        **1. 大数字三位一分法**
                        - 1,234,567 -> one million, two hundred and thirty-four thousand, five hundred and sixty-seven.
                        - thousand (千), million (百万), billion (十亿)。注意这些词本身不加 s。
                        
                        **2. 最高级变体**
                        - `one of the + 最高级 + 名词复数` (最...之一)。
                        - `the + 序数词 + 最高级` (第几个最...)。

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *The Yangtze River is one of ________ rivers in the world.*
                        A. long   B. longer   C. longest   D. the longest
                        
                        **[解析]**：one of the + 最高级 + 复数名词，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：An Animal in Danger (保护濒危动物)
                        **Pandas are very cute and famous.**
                        
                        They **live in** China and **eat** bamboo. However, they are **in danger** now. There is **less and less** bamboo for them. We should **protect** the forests and **stop** people from hurting them. I believe if we **work together**, we can save the pandas. Let's **take action** now!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u8", "Unit 8", "Have you read Treasure Island yet?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：文学、艺术与体育 (Literature and art)
                        *   **子主题**：经典名著阅读，音乐喜好，个人经历分享 (Books and music)。

                        ### 2. 单元主题内容
                        本单元以“经典阅读与现代音乐”为媒介，重点学习现在完成时（Present Perfect Tense）。学生将通过讨论著名的文学作品（如《金银岛》、《鲁滨逊漂流记》）以及现代流行音乐（如乡村音乐），学习如何表达过去发生且影响至今的经历。单元强调文学与音乐作为人类精神食粮的重要性，引导学生在快节奏生活中通过经典文化寻找内心的平静与力量。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **文学词汇**：novel, classic, ship, tool, island, treasure, mark.
                        - **音乐/艺术**：pop, rock, country music, fan, record.
                        - **核心词汇**：already, yet, ever, never, since, towards (朝向).
                        - **高频短语**：finish reading (读完), hurry up (快点), belong to (属于), laugh at (嘲笑), full of (充满).

                        ### 2. 核心句式
                        1.  **询问经历**：Have you read Treasure Island yet? — Yes, I have. / No, I haven't.
                        2.  **陈述经历**：I have already finished my homework. / He has never been to the UK.
                        3.  **表达看法**：What is it like? — It's fantastic!
                        4.  **时间关联**：I've lived here since I was five.

                        ### 3. 重点语法
                        - **现在完成时** 的基本用法（have/has + done）。
                        - **already 与 yet** 在完成时中的位置与含义。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Alice**: Have you read Treasure Island yet, Nick? 
                        
                        **Nick**: No, I haven't. But I've already read Little Women. 
                        
                        **Alice**: What's it like? 
                        
                        **Nick**: It's very good. I've read it twice. Have you finished reading your book? 
                        
                        **Alice**: Not yet. I'm still reading the last chapter.

                        **【译文】**
                        
                        **艾丽丝**：尼克，你读过《金银岛》了吗？
                        
                        **尼克**：不，还没读过。但我已经读过《小妇人》了。
                        
                        **艾丽丝**：它怎么样？
                        
                        **尼克**：非常好。我已经读过两遍了。你读完你的书了吗？
                        
                        **艾丽丝**：还没呢。我还在读最后一章。

                        ### Section B (Reading) 阅读文段：Country Music
                        **【原文】**
                        
                        Sarah is a fan of country music. She has listened to many songs by Garth Brooks. She says country music reminds her of her home. It is about simple things like family, friends and beauty of nature. Sarah has been to many concerts. Music has changed her life and made her a happy person.

                        **【译文】**
                        
                        莎拉是一个乡村音乐迷。她听过很多加斯·布鲁克斯的歌。她说乡村音乐让她想起家乡。它是关于家庭、朋友和自然美景等简单的事物。莎拉去过很多场音乐会。音乐改变了她的生活，使她成为一个快乐的人。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Have you read ... yet? (你读过...了吗？)
                        - **【用法拓展】**：`yet` 用于疑问句或否定句末尾；`already` 用于肯定句。
                        
                        #### 2. Robinson Crusoe has been on the island for 28 years. (鲁滨逊已经在岛上待了28年了。)
                        - **【要点精讲】**：现在完成时中，延续性动作常用 `for + 一段时间` 或 `since + 时间点`。
                        
                        #### 3. It reminds me of the beauty of nature. (它让我想起自然之美。)
                        - **【词块归纳】**：`remind sb. of sth.` 使某人想起某事。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① finish (v. 完成)
                        - **【用法总结】**：`finish doing sth.` 完成做某事。
                        
                        #### ② yet vs already
                        - **【辨析】**：
                            *   `already`：通常放中（have后）或句末，意为“已经”。
                            *   `yet`：放句末，意为“还（没）”或“已经（了吗？）”。
                        - **【例题】**：
                        
                        *I haven't seen the movie ________.*
                        A. already   B. yet   C. never   D. ever
                        
                        **[解析]**：否定句末用 yet，选 **B**。

                        #### ③ be full of (充满)
                        - **【同义词】**：`be filled with`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：现在完成时初探 (Present Perfect)
                        表示过去发生的动作对现在产生的影响，或过去开始持续到现在的动作。
                        **1. 构成：have/has + 动词的过去分词 (p.p.)**
                        
                        **2. already 与 yet 的分工**
                        - I have **already** eaten lunch. (肯定)
                        - Have you eaten lunch **yet**? (疑问)
                        - I haven't eaten lunch **yet**. (否定)

                        **3. 中考真题特训**
                        
                        *(2024·江苏中考)* *— Have you ________ been to the Great Wall? — Yes, twice.*
                        A. already   B. yet   C. ever   D. never
                        
                        **[解析]**：疑问句询问经历，用 ever (曾经)，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite Book (我最喜欢的一本书)
                        **I have read many books, but my favourite one is Robinson Crusoe.**
                        
                        It **is about** a man who lived on an island for many years. He was **brave and clever**. He **built** a house and **grew** food. I have **read it twice** because it is very **exciting**. It **reminds me** that we should never **give up**. I think everyone should read it.
                    """.trimIndent())
                )
            )'''

# Append to the file
new_content = insertion_point.sub(r'\1' + new_units + r'\1)\1)\1}\n', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_content)
