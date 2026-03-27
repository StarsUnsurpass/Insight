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
        ,
            TextbookUnit(
                "g7down_u5", "Unit 5", "What are you doing?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：人际关系与社会交往 (Social communication)
                        *   **子主题**：正在发生的活动，电话交流，日常社交礼仪 (Ongoing activities)。

                        ### 2. 单元主题内容
                        本单元以“正在进行的活动”为核心，重点学习现在进行时（Present Progressive Tense）。通过描述家庭成员、朋友在不同场景下的实时动作（如 reading, cleaning, watching TV 等），学生能够准确捕捉并表达当下的状态。本单元还涉及了电话交际用语，引导学生在交流中表现出礼貌与关怀，增强观察生活的能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **实时动作**：reading (读), cleaning (打扫), washing (洗), watching TV (看电视), exercising (锻炼), cooking (做饭).
                        - **场所地点**：house (房子), apartment (公寓), supermarket (超市), library (图书馆), pool (游泳池).
                        - **核心动词**：shop (购物), study (学习), sleep (睡觉), drink (喝).
                        - **高频短语**：do homework (做作业), go to the movies (去看电影), listen to a CD (听唱片), talk on the phone (讲电话).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问动作**：What are you doing? — I'm reading a book.
                        2.  **询问他人**：What is he doing? — He's cleaning his room.
                        3.  **确认动作**：Are they swimming? — Yes, they are. / No, they aren't.
                        4.  **电话用语**：Hello! This is Jenny. Is Laura there?

                        ### 3. 重点语法 (Key Grammar)
                        - **现在进行时**的结构：am/is/are + 动词-ing。
                        - **动词-ing形式**的四种变化规则。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Jenny**: Hello! This is Jenny.
                        
                        **Laura**: Hi, Jenny. It's Laura. What are you doing?
                        
                        **Jenny**: I'm watching TV. What about you?
                        
                        **Laura**: I'm cleaning my room. My brother is exercising in the yard.
                        
                        **Jenny**: Is your mom cooking?
                        
                        **Laura**: No, she isn't. She is shopping at the supermarket.

                        **【译文】**
                        
                        **珍妮**：喂！我是珍妮。
                        
                        **劳拉**：嗨，珍妮。我是劳拉。你在做什么？
                        
                        **珍妮**：我在看电视。你呢？
                        
                        **劳拉**：我在打扫房间。我哥哥正在院子里锻炼。
                        
                        **珍妮**：你妈妈正在做饭吗？
                        
                        **劳拉**：不，她没在做。她正在超市购物。

                        ### Section B (Reading) 阅读文段：A Letter from China
                        **【原文】**
                        
                        Dear Mom and Dad, I'm having a great time in China. Now I'm sitting in a tea house with my Chinese friends. We are drinking tea and talking. My friend Zhu Hui is showing me some old photos. People here are very friendly. I miss you! See you soon. Love, Alice.

                        **【译文】**
                        
                        亲爱的爸爸妈妈，我在中国过得很愉快。现在我和我的中国朋友们正坐在一家茶馆里。我们正在喝茶聊天。我的朋友朱辉正在给我看一些旧照片。这里的人们非常友好。我思念你们！期待很快见到你们。爱您的，艾丽丝。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What are you doing? (你在干什么？)
                        - **【句式剖析】**：现在进行时的特殊疑问句。`What + be + 主语 + doing?`
                        
                        #### 2. This is Jenny. (我是珍妮。)
                        - **【电话礼仪】**：在电话中介绍自己用 `This is...`，询问对方是谁用 `Who's that?` 或 `Is that...?`。不能用 I am... 或 Who are you?
                        
                        #### 3. What about you? (你呢？)
                        - **【用法拓展】**：相当于 `How about you?` 用于询问对方的情况或征求意见。后面接名词、代词或动词-ing形式。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① shop (v. 购物; n. 商店)
                        - **【用法总结】**：
                            *   作动词时，现在分词双写p，即 **shopping**。
                            *   `go shopping` 去购物。
                        - **【例题】**：
                        
                        *Look! My mother ________ at the mall.*
                        A. shops   B. is shopping   C. shoping   D. shopping
                        
                        **[解析]**：Look! 提示动作正在进行，且分词需双写p，选 **B**。

                        #### ② exercise (v./n. 锻炼; 练习)
                        - **【辨析】**：
                            *   指“锻炼”时，通常为不可数名词。*do exercise*。
                            *   指“体操；练习题”时，为可数名词。*do morning exercises*。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：现在进行时 (Present Progressive)
                        表示现在或现阶段正在进行的动作。
                        **1. 构成：主语 + be (am/is/are) + v.-ing.**
                        
                        **2. v.-ing 变化规则**
                        *   直接加 ing：*read -> reading*。
                        *   去不发音的e加 ing：*write -> writing*。
                        *   双写结尾辅音加 ing (重读闭音节)：*run -> running, swim -> swimming, shop -> shopping*。
                        *   ie 变 y 加 ing：*die -> dying*。

                        **3. 中考真题特训**
                        
                        *(2024·江苏中考)* *Listen! The birds ________ in the trees.*
                        A. sing   B. sings   C. are singing   D. will sing
                        
                        **[解析]**：Listen! 是现在进行时的标志词，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：A Scene at the Moment (描述实时场景)
                        #### 1. 写作佳句
                        *   *It's a beautiful Sunday afternoon.*
                        *   *Look! Everyone is busy.*
                        *   *My father is reading a newspaper.*
                        *   *We are having a good time.*

                        #### 2. 满分范文
                        It's 8:00 p.m. now. My family members **are all at home**. My father **is watching** news on TV. My mother **is cleaning** the kitchen. What about me? **I am doing** my homework in my room. My little dog **is sleeping** under the desk. We are all busy but happy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u6", "Unit 6", "It's raining!",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自然 (Man and Nature)
                        *   **主题群**：自然现象与环境保护 (Natural phenomena)
                        *   **子主题**：天气状况，不同天气的活动，季节感受 (Weather and activities)。

                        ### 2. 单元主题内容
                        本单元以“天气”为中心，学习描述各种天气状况（如 sunny, cloudy, raining 等）以及在特定天气下人们进行的活动。通过对全球不同城市天气的对比，培养学生观察自然、适应环境的能力。本单元进一步巩固了现在进行时的用法，并引入了如何询问及表达“近况如何（How's it going?）”的社交用语。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **天气形容词**：sunny (晴朗的), cloudy (多云的), windy (有风的), rainy (下雨的), snowy (下雪的).
                        - **天气动词**：rain (下雨), snow (下雪).
                        - **状态形容词**：hot (热的), cold (冷的), cool (凉爽的), warm (温暖的), dry (干燥的), humid (潮湿的).
                        - **高频短语**：How's it going? (最近怎么样?), take a photo (照相), on vacation (在度假), right now (此刻).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问天气**：How's the weather in Beijing? / What's the weather like?
                        2.  **表达天气**：It's sunny and warm. / It's raining right now.
                        3.  **询问近况**：How's it going? — Great! / Not bad. / Terrible.
                        4.  **描述假期**：I'm having a great time on vacation.

                        ### 3. 重点语法 (Key Grammar)
                        - **询问天气的两种方式** (How vs What)。
                        - **形容词后缀 -y** 的构词法（名词变形容词）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Tom**: Hi, Rick! How's it going?
                        
                        **Rick**: Not bad. How's the weather in Shanghai?
                        
                        **Tom**: It's terrible! It's raining right now. 
                        
                        **Rick**: That's too bad. What are you doing?
                        
                        **Tom**: I'm just staying at home and reading. What's the weather like in London?
                        
                        **Rick**: It's sunny and cool. I'm playing soccer with my friends.

                        **【译文】**
                        
                        **汤姆**：嗨，里克！最近怎么样？
                        
                        **里克**：不错。上海的天气怎么样？
                        
                        **汤姆**：糟糕透了！现在正在下雨。
                        
                        **里克**：那太糟了。你在做什么？
                        
                        **汤姆**：我只是待在家里读书。伦敦的天气怎么样？
                        
                        **里克**：天气晴朗且凉爽。我正在和朋友们踢足球。

                        ### Section B (Reading) 阅读文段：A Vacation Postcard
                        **【原文】**
                        
                        Hi, Jane! I'm on vacation in Canada. The weather is snowy and cold, but it's beautiful. Everyone is having a good time. Some people are skating on the lake. My brother is taking photos. I'm sitting by the fire and writing postcards. See you next month! Love, Su Lin.

                        **【译文】**
                        
                        嗨，简！我在加拿大度假。天气阴冷且有雪，但很美。每个人都过得很开心。一些人正在湖面上滑冰。我哥哥正在拍照。我正坐在火炉旁写明信片。下个月见！爱你的，苏琳。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. How's the weather? (天气怎么样？)
                        - **【同义句】**：`What's the weather like?` (like 是介词，意为“像”)。
                        
                        #### 2. How's it going? (情况怎么样？/最近好吗？)
                        - **【常见答语】**：`Great!`, `Not bad.`, `Just so-so.`, `Terrible!`.
                        
                        #### 3. I'm on vacation. (我在度假。)
                        - **【词块归纳】**：`be on vacation` 在度假中；`take a vacation` 去度假。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① sunny / rainy / windy (天气形容词)
                        - **【词汇梳理】**：名词 + y = 形容词。
                            *   sun (双写n) -> sunny
                            *   rain -> rainy
                            *   cloud -> cloudy
                        - **【例题】**：
                        
                        *The wind is strong. It is a ________ day.*
                        A. wind   B. windy   C. winddy   D. winds
                        
                        **[解析]**：修饰名词 day 用形容词，且不用双写，选 **B**。

                        #### ② take a photo (拍照)
                        - **【用法总结】**：复数为 `take photos`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：询问天气的固定结构
                        **1. 结构对比**
                        - **How** is the weather?
                        - **What** is the weather **like**? (千万不要漏掉 like!)

                        **2. 状态与动作的区分**
                        - It's rainy. (它是多雨的 - 状态)
                        - It's raining. (它正在下雨 - 动作)

                        **3. 中考真题特训**
                        
                        *(2023·北京中考)* *— ________ the weather in your hometown? — It's often windy in spring.*
                        A. What's   B. How   C. How's   D. What
                        
                        **[解析]**：由问句结尾无 like 可知，选用 How's，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：A Vacation Diary (旅游日记)
                        #### 1. 写作框架
                        - **Place & Weather** (地点与天气)
                        - **Activities** (正在进行的活动)
                        - **Feeling** (心情感受)

                        #### 2. 满分范文
                        July 15th, Sunday. Sunny.
                        
                        I am in Sanya with my family today. The weather is **sunny and hot**. We are **on vacation** here. Look! Many people **are swimming** in the blue sea. My father **is lying** on the beach. I **am eating** a big ice-cream. We are having a wonderful time! 
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u7", "Unit 7", "What does he look like?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：自我认识与他人评价 (Self and others)
                        *   **子主题**：外貌特征描述，人物识别，审美意识 (Describing people)。

                        ### 2. 单元主题内容
                        本单元以“外貌特征”为核心，学习如何从身高、体型、发型及其他特征（如胡须、眼镜）来描述一个人。通过学习 short, tall, thin, heavy, long hair 等词汇，学生能够清晰地描绘人物形象。本单元旨在引导学生发现他人的闪光点，学会在描述中尊重差异，不以貌取人，建立健康的审美观。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **身高体型**：short (矮的), tall (高的), thin (瘦的), heavy (重的), medium build (中等身材), medium height (中等身高).
                        - **头发特征**：straight hair (直发), curly hair (卷发), long hair (长发), short hair (短发), blonde hair (金发).
                        - **其他特征**：glasses (眼镜), beard (胡须), uniform (制服), artist (艺术家).
                        - **高频短语**：look like (看起来像), a little bit (一点点), in the end (最后), be of medium build (中等身材).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **询问外貌**：What does he look like? — He is tall and has short hair.
                        2.  **描述发型**：She has long straight black hair.
                        3.  **询问身高**：Is he tall or short? — He is of medium height.
                        4.  **辨认人物**：The girl with glasses is my sister.

                        ### 3. 重点语法 (Key Grammar)
                        - **描述外貌的两大动词**：be (描述整体状态) 与 have/has (描述局部特征)。
                        - **多个形容词修饰名词的顺序**。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mike**: Do you know the new student, David?
                        
                        **Li Hua**: Yes, I do. 
                        
                        **Mike**: What does he look like?
                        
                        **Li Hua**: He's very tall. He has short curly brown hair.
                        
                        **Mike**: Does he wear glasses?
                        
                        **Li Hua**: No, he doesn't. But he always wears a blue school uniform.

                        **【译文】**
                        
                        **迈克**：你认识那个新生大卫吗？
                        
                        **李华**：是的，我认识。
                        
                        **迈克**：他长什么样？
                        
                        **李华**：他很高。他留着棕色的短卷发。
                        
                        **迈克**：他戴眼镜吗？
                        
                        **李华**：不，他不戴。但他总是穿着蓝色的校服。

                        ### Section B (Reading) 阅读文段：An Artist
                        **【原文】**
                        
                        Joe is an artist. He draws pictures of people. Many people tell him what the criminal looks like. Then Joe draws a picture. He says, "The criminal is of medium height. He has a big nose and small eyes. He is a little bit thin." Joe's pictures help the police find the criminals. He is a great helper.

                        **【译文】**
                        
                        乔是一名艺术家。他画人物肖像。许多人告诉他罪犯长什么样。然后乔画出一张图。他说：“罪犯中等身材。他有一个大鼻子和小眼睛。他有一点点瘦。”乔的画帮助警察找到了罪犯。他是一个伟大的助手。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What does he look like? (他长什么样？)
                        - **【用法拓展】**：用于询问人的外貌。注意区分 `What is he like?` (他性格怎么样/他是个怎样的人？)。
                        
                        #### 2. She has long straight black hair. (她留着黑色的长直发。)
                        - **【要点精讲】**：多个形容词修饰名词顺序：**长短 + 形状 + 颜色 + 名词**。
                        
                        #### 3. He is of medium height. (他是中等身高。)
                        - **【句式剖析】**：`be of + 特征名词` 表示“具有...特征”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① look like (看起来像)
                        - **【注意】**：`like` 这里是介词，后接名词或代词。
                        - **【例题】**：
                        
                        *The cloud ________ a big white rabbit.*
                        A. look   B. looks like   C. looks   D. looking like
                        
                        **[解析]**：主语是单数，后面接宾语需加 like，选 **B**。

                        #### ② a little bit (一点儿)
                        - **【用法总结】**：后面直接接形容词。等于 `a little` 或 `a bit`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：外貌描述的“动词分工”
                        **1. be 动词组 (主语 + be + 形容词)**
                        用于描述：身高 (tall/short)、体型 (thin/heavy)、年龄 (young/old)。
                        - *He **is** heavy.*
                        
                        **2. have/has 动词组 (主语 + have/has + 名词)**
                        用于描述：发型、五官特征、配饰。
                        - *She **has** curly hair.*
                        - *He **has** a beard.*

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *My sister ________ short and ________ big eyes.*
                        A. has; is   B. is; has   C. is; is   D. has; has
                        
                        **[解析]**：身高用 is，眼睛特征用 has，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：My Best Friend (我的好朋友)
                        #### 1. 写作要点
                        - **Name & Age** (姓名年龄)
                        - **Body & Height** (身材身高)
                        - **Hair & Face** (头发五官)
                        - **Clothes & Hobbies** (着装爱好)

                        #### 2. 满分范文
                        I have a best friend. Her name is Lily. She is 13 years old. Lily is **of medium height** and she is **a little bit thin**. She **has long straight black hair** and **big blue eyes**. She always **wears glasses**. Lily is very kind and we often study together. I like her very much.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u8", "Unit 8", "I'd like some noodles.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视 (Unit Theme Analysis)", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：饮食与健康，订餐服务，中外饮食文化 (Food and ordering)。

                        ### ### 2. 单元主题内容
                        本单元以“订餐”为核心情境，学习各种食物名称（如 beef, mutton, noodles, cabbage 等）以及如何表达需求（would like）。通过模拟餐馆点餐，学生不仅掌握了数量与规格的表达（如 large, medium, small），还学习了中国传统美食文化（如生日面、饺子）。本单元旨在培养学生的社会实践能力，学会在公共服务场所进行得体、清晰的沟通。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览 (Unit Preview)", """
                        ### 1. 重点单词短语 (Key Words & Phrases)
                        - **肉类蔬菜**：beef (牛肉), mutton (羊肉), chicken (鸡肉), cabbage (卷心菜), potato (土豆), tomato (西红柿), carrot (胡萝卜).
                        - **主食饮品**：noodles (面条), rice (米饭), pancake (薄烤饼), porridge (粥), soup (汤), juice (果汁).
                        - **规格数量**：size (尺寸), large (大号的), medium (中号的), small (小号的), bowl (碗).
                        - **高频短语**：would like (想要), take one's order (点菜), what size (什么规格), birthday noodles (长寿面).

                        ### 2. 核心句式 (Key Sentences)
                        1.  **表达想要**：I'd like a large bowl of beef noodles.
                        2.  **询问点餐**：May I take your order? / What would you like to eat?
                        3.  **询问规格**：What size bowl of noodles would you like?
                        4.  **描述传统**：In China, people eat long noodles for their birthdays.

                        ### 3. 重点语法 (Key Grammar)
                        - **would like** 的各种句式变换。
                        - **可数名词与不可数名词**的分类及其数量表达（a bowl of...）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文 (Text & Translation)", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Waiter**: Hello! May I take your order?
                        
                        **Boy**: Yes. I'd like some noodles, please.
                        
                        **Waiter**: What kind of noodles would you like?
                        
                        **Boy**: I'd like beef and tomato noodles.
                        
                        **Waiter**: And what size would you like?
                        
                        **Boy**: A medium bowl, please.

                        **【译文】**
                        
                        **服务员**：您好！可以点餐了吗？
                        
                        **男孩**：是的。请给我来点面条。
                        
                        **服务员**：您想要哪种面条？
                        
                        **男孩**：我想要牛肉西红柿面。
                        
                        **服务员**：那您想要多大碗的？
                        
                        **男孩**：请给我来个中碗的。

                        ### Section B (Reading) 阅读文段：Birthday Food Around the World
                        **【原文】**
                        
                        What do people eat on their birthdays? In many countries, people have a cake with candles. But in China, it's different. People often eat long noodles. They think long noodles mean a long life. In some places, people also eat red eggs. They are a symbol of good luck. What about you? What do you like to eat on your birthday?

                        **【译文】**
                        
                        人们在生日那天吃什么？在许多国家，人们吃带蜡烛的蛋糕。但在中国，情况有所不同。人们经常吃长寿面。他们认为长寿面意味着长寿。在一些地方，人们也吃红鸡蛋。它们是好运的象征。你呢？你在生日那天喜欢吃什么？
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. I'd like some noodles. (我想要点面条。)
                        - **【句式剖析】**：`I'd like` 是 `I would like` 的缩写。比 `I want` 更委婉、更有礼貌。
                        
                        #### 2. What kind of noodles would you like? (你想要哪种面条？)
                        - **【词块归纳】**：`what kind of...` 意为“哪种/哪类...”。
                        
                        #### 3. It is a symbol of good luck. (它是好运的象征。)
                        - **【要点精讲】**：`a symbol of...` ...的象征。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① would like (想要)
                        - **【用法总结】**：
                            *   `would like sth.` 想要某物。
                            *   `would like to do sth.` 想要做某事。
                        - **【例题】**：
                        
                        *Would you like ________ some orange juice?*
                        A. drinking   B. drinks   C. to drink   D. drink
                        
                        **[解析]**：would like to do 固定搭配，选 **C**。

                        #### ② potato / tomato (名词复数)
                        - **【记忆口诀】**：英雄(hero)爱吃土豆(potato)和西红柿(tomato)，复数后面直接加 -es。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (Grammar Master)", """
                        ### 语法核心：数量的“精细化”表达
                        **1. 可数与不可数的界限**
                        *   可数：noodles (常用复数), potatoes, carrots.
                        *   不可数：beef, mutton, rice, water, juice.
                        
                        **2. 不可数名词的数量表达**
                        公式：`数词 + 容器/量词 + of + 不可数名词`。
                        - *a bowl of rice* (一碗米饭)
                        - *two glasses of juice* (两杯果汁)

                        **3. 中考真题特训**
                        
                        *(2023·广东中考)* *I'm hungry. I'd like ________ and ________.*
                        A. two bowl of noodle; some beef   B. two bowls of noodles; some beef   C. two bowl of noodles; some beefs   D. two bowls of noodle; some beefs
                        
                        **[解析]**：bowl 和 noodle 需用复数，beef 为不可数无复数，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能 (Writing Skills)", """
                        ### 写作主题：Menu & Ordering (设计菜单与模拟订餐)
                        #### 1. 常用句式
                        *   *Can I help you? / May I take your order?*
                        *   *I'd like ... bowl of ...*
                        *   *What size would you like?*
                        *   *Wait a minute, please.*

                        #### 2. 满分范文
                        Welcome to our restaurant! We have many kinds of food. For meat lovers, we have **beef and mutton**. For vegetables, we have **cabbages and potatoes**. **What would you like?** If you want noodles, we have **large, medium and small** bowls. We also have delicious **strawberry pancakes**. Please come and have a taste!
                    """.trimIndent())
                )
            )
        )
        )
        }
