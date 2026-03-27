package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade7Down {
    val data = Textbook(
        id = "g7_down",
        grade = "七年级",
        term = "下册",
        coverColor = Color(0xFFFFF9C4),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc7x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g7down_u1", "Unit 1", "Can you play the guitar?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：个人特长、爱好与社团选择 (Interests and clubs)。

                        ### 2. 单元主题内容
                        本单元围绕“社团招新”这一校园社交情境，重点学习情态动词 can 询问和表达能力。学生将学会如何用英语介绍自己的特长（如 sing, dance, play chess 等），并学习如何根据自身优势选择合适的学校社团。本单元旨在培养学生的自信心，鼓励其积极参与校园活动，发现并展示自我价值。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **特长动词**：sing (唱), dance (跳舞), swim (游泳), draw (画), speak (说), join (参加).
                        - **乐器/运动**：guitar (吉他), chess (国际象棋), piano (钢琴), drums (鼓), violin (小提琴).
                        - **核心名词**：club (社团), story (故事), show (演出), musician (音乐家).
                        - **高频短语**：play the guitar (弹吉他), play chess (下象棋), speak English (说英语), be good at (擅长), help ... with ... (帮助某人做某事).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问能力**：Can you sing? — Yes, I can. / No, I can't.
                        2.  **询问意图**：What club do you want to join? — I want to join the art club.
                        3.  **陈述特长**：I can speak English but I can't speak Chinese.
                        4.  **招聘/招聘建议**：We need help for the school show. / Can you help kids with swimming?

                        ### 3. 重点语法 (Key Grammar)
                        - **情态动词 can** 表示能力的用法。
                        - **what 引导的特殊疑问句** 询问个人意向。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teacher**: Hi, I am the music teacher. What club do you want to join?
                        
                        **Li Hua**: I want to join the music club.
                        
                        **Teacher**: Can you sing?
                        
                        **Li Hua**: Yes, I can. I can also dance well.
                        
                        **Teacher**: Great! We need you for the school concert.
                        
                        **Li Hua**: Thank you, I'd love to come!

                        **【译文】**
                        
                        **老师**：你好，我是音乐老师。你想加入什么社团？
                        
                        **李华**：我想加入音乐社团。
                        
                        **老师**：你会唱歌吗？
                        
                        **李华**：是的，我会。我舞也跳得很好。
                        
                        **老师**：太棒了！我们的校音乐会需要你。
                        
                        **李华**：谢谢，我很乐意去！

                        ### Section B (Reading) 阅读文段：Wanted: Help for Old People's Home
                        **【原文】**
                        
                        Are you good with old people? Do you have time on weekends? We need help at the old people's home. Can you talk to them? Can you play games with them? They can tell you stories and you can make friends with them. Please call us at 689-7729.

                        **【译文】**
                        
                        你善于与老人相处吗？你在周末有时间吗？我们在老人院需要帮助。你能和他们聊天吗？你能和他们一起玩游戏吗？他们能给你讲故事，而你可以和他们交朋友。请拨打电话 689-7729 联系我们。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What club do you want to join? (你想加入什么社团？)
                        - **【句式剖析】**：`want to do sth.` 意为“想要做某事”。`join` 指加入一个组织。
                        
                        #### 2. Can you play the guitar? (你会弹吉他吗？)
                        - **【要点精讲】**：在西洋乐器名词前必须加定冠词 **the**。
                        - **【对比】**：在球类运动名词前**不加**冠词。*play basketball* (打篮球)。
                        
                        #### 3. Be good with kids. (善于与孩子们相处。)
                        - **【辨析】**：`be good at` (擅长于...) vs `be good with` (善于与...相处)。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① speak (v. 说; 讲)
                        - **【辨析】**：
                            *   `speak`：讲某种语言。*speak English*。
                            *   `say`：强调说话的内容。*say hello*。
                            *   `talk`：强调交谈、谈话。*talk to sb.*
                            *   `tell`：告诉、讲述故事/笑话。*tell a story*。
                        - **【中考真题/例题】**：
                        
                        *Jack can ________ English very well.*
                        A. say   B. speak   C. talk   D. tell
                        
                        **[解析]**：讲某种语言用 speak，选 **B**。

                        #### ② musician (n. 音乐家)
                        - **【词汇梳理】**：`music` (音乐) + `ian` (后缀) = `musician`。
                        - **【拓展】**：`artist` (艺术家), `scientist` (科学家)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：情态动词 can 的“能力”与“请求”
                        **1. 语法特征**
                        *   无人称和数的变化（I can, He can, They can）。
                        *   后接动词原形。

                        **2. 句式结构**
                        - 肯定：I can dance.
                        - 否定：I can't (cannot) dance.
                        - 疑问：Can you dance? — Yes, I can. / No, I can't.

                        **3. 中考真题特训**
                        
                        *(2024·河北中考)* *— ________ you swim? — Yes, I ________.*
                        A. Can; can   B. Do; do   C. Must; must   D. Should; should
                        
                        **[解析]**：询问能力用 Can，回答也用 can，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：Ad for a Club (社团招新广告)
                        #### 1. 写作模板
                        - **Wanted** (招聘/招人)
                        - **Requirements** (要求/特长)
                        - **Contact** (联系方式)

                        #### 2. 满分范文
                        **Wanted: Music Club**
                        
                        Are you a music lover? Can you sing or dance? We need you for our school band. **I am good at** playing the piano, and I can help you with your music. Come and join us! Please call Li Hua at 123-4567. 
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u2", "Unit 2", "What time do you go to school?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：个人日常作息，良好的生活习惯 (Daily routines)。

                        ### 2. 单元主题内容
                        本单元以“日常作息”为话题，重点学习如何询问和表达时间，以及描述一天中不同时间段进行的活动（如 get up, eat breakfast, go to school 等）。通过对比健康与不健康的作息，引导学生反思自己的生活方式，学会科学地安排时间，养成早睡早起、规律饮食的良好习惯。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **动作短语**：get up (起床), brush teeth (刷牙), take a shower (洗澡), go to school (去上学), eat breakfast (吃早餐), do homework (做作业), go to bed (睡觉).
                        - **频率副词**：usually (通常), always (总是), never (从不), sometimes (有时).
                        - **时间短语**：early (早), late (迟), at night (在晚上), on school days (在上学日).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问作息**：What time do you usually get up? — I usually get up at 6:30.
                        2.  **询问时间**：What time is it? / What's the time?
                        3.  **描述习惯**：I'm never late for school. / He has a very healthy life.
                        4.  **表达感受**：That's a funny time for breakfast!

                        ### 3. 重点语法 (Key Grammar)
                        - **What time / When 引导的疑问句** 询问动作发生的时间。
                        - **频率副词的位置**（行前 be 后）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Rick**: Hi, Scott. What time do you go to school?
                        
                        **Scott**: I usually go to school at seven thirty.
                        
                        **Rick**: That's early! What time do you get up?
                        
                        **Scott**: I get up at six o'clock every morning.
                        
                        **Rick**: Wow, you have a very healthy life!

                        **【译文】**
                        
                        **里克**：嗨，斯科特。你几点去上学？
                        
                        **斯科特**：我通常在七点半去上学。
                        
                        **里克**：那真早！你几点起床？
                        
                        **斯科特**：我每天早晨六点钟起床。
                        
                        **里克**：哇，你的生活方式非常健康！

                        ### Section B (Reading) 阅读文段：A Healthy Life
                        **【原文】**
                        
                        My name is Tony. I have a healthy life. I always get up early. I eat a good breakfast. After school, I often play basketball. I do my homework in the evening. I go to bed at 9:30. My sister has an unhealthy life. She always gets up late and she never eats breakfast. She needs to change her habits.

                        **【译文】**
                        
                        我的名字叫托尼。我有着健康的生活。我总是起得很早。我吃一顿丰盛的早餐。放学后，我经常打篮球。我在晚上做作业。我9:30睡觉。我妹妹的生活方式不健康。她总是起得很晚，而且从不吃早餐。她需要改变她的习惯。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What time is it? (几点了？)
                        - **【用法拓展】**：常用 `It's + 时间` 来回答。
                        
                        #### 2. I'm never late for school. (我上学从不迟到。)
                        - **【要点精讲】**：`be late for...` 意为“做某事迟到”。
                        - **【位置法则】**：频率副词 `never` 放在系动词 `am` 之后。
                        
                        #### 3. She needs to change her habits. (她需要改变她的习惯。)
                        - **【词块归纳】**：`need to do sth.` 需要做某事。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① usually (adv. 通常)
                        - **【频度辨析】**：*always (100%) > usually (80%) > often (60%) > sometimes (30%) > never (0%)*。
                        - **【中考真题/例题】**：
                        
                        *I ________ go to bed late, because I want to be healthy.*
                        A. always   B. usually   C. never   D. often
                        
                        **[解析]**：为了健康，“从不”晚睡，选 **C**。

                        #### ② take a shower (洗澡)
                        - **【用法总结】**：等同于 `have a shower`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：When 与 What time 的异同
                        **1. 联系**
                        两者都可以询问时间点。
                        
                        **2. 区别**
                        *   `What time`：询问具体的时间刻度（几点几分）。
                        *   `When`：范围更广，可以询问具体日期、月份、季节等。

                        **3. 频率副词的“排位法”**
                        - **be 动词后**：*He **is** always happy.*
                        - **行为动词前**：*I **usually** get up at 6.*

                        **4. 中考真题特训**
                        
                        *(2023·广东中考)* *— ________ do you visit your grandparents? — Once a week.*
                        A. How often   B. When   C. What time   D. How long
                        
                        **[解析]**：回答是频率，选 **A**。 (注意：本单元重点是 When/What time，但常与频率副词考察)。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：My Daily Routine (我的作息表)
                        #### 1. 写作佳句
                        *   *I usually ... at ...*
                        *   *From ... to ..., I ...*
                        *   *In my free time, I like ...*
                        *   *I have a busy but happy day.*

                        #### 2. 满分范文
                        **My School Day**
                        
                        I have a regular daily routine. **I always get up at** 6:30. After a quick breakfast, I **go to school** at 7:15. Lessons start at 8:00. I have lunch at school. In the afternoon, I **often play** sports. I **do my homework** at 7:00 p.m. and go to bed at 10:00 p.m. I think my life is very healthy. 
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u3", "Unit 3", "How do you get to school?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：交通与通讯 (Transport and communication)
                        *   **子主题**：交通方式，出行计划，地理空间意识 (Getting around)。

                        ### 2. 单元主题内容
                        本单元以“交通出行”为核心，重点学习如何表达交通方式（如 take the bus, ride a bike, walk 等）以及询问距离（How far）和耗时（How long）。通过讨论不同国家学生上学方式的差异（如 Crossing the River to School），培养学生的跨文化意识和对社会民生的关注。本单元旨在增强学生的逻辑规划能力，学会选择最高效的出行方案。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **交通工具**：train (火车), bus (公交), subway (地铁), bike (自行车), boat (小船).
                        - **动词短语**：ride a bike (骑车), take the subway (乘地铁), walk (步行), drive (开车).
                        - **核心名词/副词**：kilometer (千米), mile (英里), bridge (桥), village (村庄), afraid (害怕).
                        - **高频短语**：get to school (到达学校), how far (多远), how long (多久), every day (每天), cross the river (过河).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问方式**：How do you get to school? — I take the bus.
                        2.  **询问距离**：How far is it from your home to school? — It's about 10 kilometers.
                        3.  **询问耗时**：How long does it take? — It takes 20 minutes.
                        4.  **结构用法**：It takes sb. some time to do sth.

                        ### 3. 重点语法 (Key Grammar)
                        - **How 引导的特殊疑问句** 询问方式、距离、耗时。
                        - **It takes... 的固定句型**。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mary**: How do you get to school, Bob?
                        
                        **Bob**: I usually take the subway.
                        
                        **Mary**: How far is it from your home?
                        
                        **Bob**: It's about 5 kilometers.
                        
                        **Mary**: How long does it take?
                        
                        **Bob**: It takes about 15 minutes.

                        **【译文】**
                        
                        **玛丽**：鲍勃，你平时怎么去上学？
                        
                        **鲍勃**：我通常乘地铁。
                        
                        **玛丽**：从你家走有多远？
                        
                        **鲍勃**：大约5千米。
                        
                        **玛丽**：要花多长时间？
                        
                        **鲍勃**：大约花15分钟。

                        ### Section B (Reading) 阅读文段：Crossing the River to School
                        **【原文】**
                        
                        For many students, it is easy to get to school. But for the students in one small village, it is difficult. There is a big river between their home and the school. There is no bridge. So they go on a ropeway to cross the river. One 11-year-old boy, Liangliang, says he is not afraid. He loves school and wants to see his friends.

                        **【译文】**
                        
                        对于许多学生来说，上学很容易。但对于一个小村庄的学生来说，这很困难。在他们的家和学校之间有一条大河。没有桥。所以他们系着溜索过河。一个11岁的男孩，亮亮，说他不害怕。他热爱学校，想见他的朋友们。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. How do you get to school? (你如何到达学校？)
                        - **【用法拓展】**：`get to` 意为“到达”。注意：如果后面跟 `home`, `here`, `there` 等副词，要省去 `to`。如：*get home*。
                        
                        #### 2. How far is it from A to B? (从A地到B地有多远？)
                        - **【要点精讲】**：用来询问“距离”。回答用 `It's ... kilometers/meters.`
                        
                        #### 3. It takes about 20 minutes. (大约花费20分钟。)
                        - **【句式金牌】**：`It takes sb. some time to do sth.` 做某事花费某人多少时间。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① ride (v. 骑)
                        - **【搭配】**：`ride a bike` (骑自行车), `ride a horse` (骑马)。
                        - **【例题】**：
                        
                        *It is good exercise to ________ a bike to work.*
                        A. take   B. drive   C. ride   D. sit
                        
                        **[解析]**：骑车用 ride，选 **C**。

                        #### ② how long (多久) vs how far (多远)
                        - **【辨析】**：
                            *   `how long`：问时间长度或物体长度。
                            *   `how far`：问物理距离。
                        - **【中考真题/例题】**：
                        
                        *— ________ is it from the airport? — About half an hour's drive.*
                        A. How far   B. How long   C. How soon   D. How much
                        
                        **[解析]**：回答是“开车半小时的路程”，表示距离，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：交通方式的三种表达法
                        **1. 动词短语 (作谓语)**
                        - *I **take the bus** to school.*
                        - *He **rides his bike** to work.*

                        **2. by + 交通工具 (作状语)**
                        - *I go to school **by bus**.* (注意：by后不加冠词)
                        - *He goes to work **by bike**.*

                        **3. on/in + 冠词/物主代词 + 交通工具 (作状语)**
                        - *I go to school **on a bus**.*
                        - *He goes to work **on his bike**.*

                        **4. 中考真题特训**
                        
                        *(2024·江苏中考)* *It ________ me half an hour ________ my homework yesterday.*
                        A. took; to do   B. takes; doing   C. took; doing   D. takes; to do
                        
                        **[解析]**：固定句型 It takes/took sb. time to do sth.，且发生在昨天用过去时，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：My Trip to School (我的上学之路)
                        #### 1. 写作要点
                        - **How** (方式)
                        - **Distance** (距离)
                        - **Time** (耗时)
                        - **Feeling** (感受)

                        #### 2. 满分范文
                        I live far from my school. Every morning, I **get up at** 6:00. I usually **go to school by subway**. It is about **15 kilometers** from my home. It **takes me 30 minutes to get there**. I like the subway because it is very fast. 
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u4", "Unit 4", "Don't eat in class.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：社会服务与人际沟通 (Social services and communication)
                        *   **子主题**：规则与准则，社会责任，文明行为 (Rules and regulations)。

                        ### 2. 单元主题内容
                        本单元围绕“规矩与准则”展开，涉及校规、家规以及公共场所的各种限制。通过学习祈使句（Imperatives）和情态动词 must, have to，学生学会如何表达命令、禁止、责任与义务。本单元旨在引导学生理解规则存在的意义——不是为了束缚自由，而是为了保障集体的高效与安全，培养学生成为遵纪守法、有责任感的社会公民。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **规则动词**：listen (听), fight (打架), follow (遵守), arrive (到达), relax (放松).
                        - **核心名词**：rule (规则), hallway (走廊), uniform (制服), kitchen (厨房), hair (头发).
                        - **描述词/短语**：strict (严厉的), noisy (吵闹的), terrible (糟糕的), dirty (脏的).
                        - **高频短语**：on time (准时), listen to (听...), wear the school uniform (穿校服), make the bed (整理床铺), be strict with sb. (对某人严厉).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **表达禁止**：Don't eat in class. / Don't run in the hallways.
                        2.  **表达义务**：We must arrive on time. / We have to wear the school uniform.
                        3.  **询问规则**：What are the rules at your school?
                        4.  **描述约束**：I can't go out on school nights.

                        ### 3. 重点语法 (Key Grammar)
                        - **祈使句**（肯定与否定形式）。
                        - **情态动词 must 与 have to** 的区分与用法。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teacher**: Hi, Peter. You are late. 
                        
                        **Peter**: Sorry, Mr. Smith.
                        
                        **Teacher**: Don't be late for class next time. Remember the school rules.
                        
                        **Peter**: What are the rules?
                        
                        **Teacher**: We must be on time. We can't eat in class. And don't run in the hallways.
                        
                        **Peter**: I see. I will follow the rules.

                        **【译文】**
                        
                        **老师**：嗨，彼得。你迟到了。
                        
                        **彼得**：对不起，史密斯先生。
                        
                        **老师**：下次上课不要迟到。记住校规。
                        
                        **彼得**：规则都有哪些？
                        
                        **老师**：我们必须准时。我们不能在教室吃东西。而且不要在走廊奔跑。
                        
                        **彼得**：我明白了。我会遵守规则的。

                        ### Section B (Reading) 阅读文段：Rules at Home
                        **【原文】**
                        
                        Molly has too many rules at home. She can't play with her friends on school nights. She must do her homework after school. She has to help her mom in the kitchen and make her bed every morning. She can't watch TV on school days. She feels terrible because she doesn't have any fun.

                        **【译文】**
                        
                        莫莉家里的规矩太多了。在上学日的晚上她不能和朋友们玩。放学后她必须做作业。她每天早晨不得不帮妈妈做家务并且整理床铺。在上学日她不能看电视。她感觉很糟糕，因为她一点乐趣也没有。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Don't eat in class. (不要在课堂上吃东西。)
                        - **【句式剖析】**：否定祈使句结构：`Don't + 动词原形`。
                        
                        #### 2. We have to wear the school uniform. (我们不得不穿校服。)
                        - **【用法拓展】**：`have to` 强调客观需求；`must` 强调主观意愿。
                        
                        #### 3. Be strict with sb. (对某人要求严格。)
                        - **【辨析】**：`be strict with sb.` (对人严厉) vs `be strict in sth.` (对事严谨)。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① arrive (v. 到达)
                        - **【用法总结】**：
                            *   `arrive in` + 大地点 (城市、国家)。
                            *   `arrive at` + 小地点 (车站、学校)。
                        - **【例题】**：
                        
                        *When did you ________ at the airport?*
                        A. reach   B. get   C. arrive   D. come
                        
                        **[解析]**：reach是及物动词，get需加to，arrive接小地点加at，选 **C**。

                        #### ② listen to (听...)
                        - **【注意】**：`listen` 是不及物动词，接宾语必须加 `to`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心一：祈使句 (Imperatives)
                        用于表达请求、命令、劝告或禁止。
                        **1. 结构**
                        *   肯定：动词原形 + 其他. (*Keep quiet!*)
                        *   否定：Don't + 动词原形 + 其他. (*Don't fight!*)

                        ### 语法核心二：must 与 have to
                        - **must**：主观意愿上的“必须”。 (*I must study hard.*)
                        - **have to**：客观环境迫使的“不得不”。 (*It's raining, I have to stay here.*)

                        **3. 中考真题特训**
                        
                        *(2024·安徽中考)* *________ in the hallways. It's dangerous.*
                        A. Not run   B. Don't run   C. Doesn't run   D. Not to run
                        
                        **[解析]**：否定祈使句用 Don't 开头，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：School Rules (我们的校规)
                        #### 1. 写作佳句
                        *   *There are many rules in our school.*
                        *   *First, we must ...*
                        *   *We can't ... in the ...*
                        *   *I think the rules are good for us.*

                        #### 2. 满分范文
                        **Our School Rules**
                        
                        We have many rules at school. We must **arrive at school on time**. We **can't eat** in the classroom. We **have to wear the school uniform** every day. In the library, we **must keep quiet**. I think these rules help us learn well and keep us safe. 
                    """.trimIndent())
                )
            ),
        )
    )
}
