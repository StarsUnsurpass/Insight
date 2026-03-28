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
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/sc8x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g8up_u1", "Unit 1", "Where did you go on vacation?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活与学习 (旅游与度假)。
                        *   **深层意义**：本单元复习并深化了一般过去时的应用。通过分享假期旅行经历，引导学生走出家门，开阔眼界。在此过程中，培养学生对不同地域文化的包容性，学会撰写旅行日记，记录生活中的美好瞬间，同时反思旅行中的得与失。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **复合不定代词**：anyone (任何人), anywhere (任何地方), anything (任何事物), someone (某人), everyone (每个人), nothing (没什么)。
                        - **假期活动**：camp (扎营), study (学习), buy (买), taste (尝起来)。
                        - **评价形容词**：wonderful (精彩的), boring (无聊的), delicious (美味的), exciting (令人兴奋的)。
                        - **名词**：diary (日记), activity (活动), difference (差异), top (顶部)。

                        ### 2. 核心短语金牌储备
                        - `go on vacation` 去度假
                        - `go to the mountains` 去爬山
                        - `stay at home` 待在家里
                        - `quite a few` 相当多 (**必考：修饰可数名词复数**)
                        - `take photos` 拍照
                        - `most of the time` 大部分时间
                        - `feel like` 感觉像...
                        - `because of` 因为 (**对比：because + 句子**)
                        - `keep a diary` 记日记
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Where did you go on vacation? (你去哪里度假了？)
                        - **【考点详解】**：特殊疑问词 `Where` + 一般过去时疑问句（助动词 `did` 提至主语前，谓语动词用原形）。
                        
                        #### 2. Did you buy anything special? (你买了什么特别的东西吗？)
                        - **【结构剖析】**：形容词修饰复合不定代词（如 anything, someone）时，**形容词必须后置**。
                        
                        #### 3. We decided to take the train. (我们决定乘火车。)
                        - **【用法拓展】**：`decide to do sth.` 决定做某事。
                        
                        #### 4. I felt like I was a bird. (我感觉自己像一只鸟。)
                        - **【语法延伸】**：`feel like` 后面可接名词、代词、动词-ing或从句。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：一般过去时的进阶
                        - **标志词强化**：`yesterday`, `last night/week`, `in 2019`, `two days ago`, `just now`。
                        - **不规则动词**：重点记忆 *buy-bought, find-found, see-saw, go-went, take-took*。

                        ### 核心语法二：复合不定代词的用法
                        1.  **some类 vs any类**：`some-` 常用于肯定句；`any-` 常用于否定句和疑问句。（但在表示请求、建议的疑问句中，用 some-）。
                        2.  **谓语动词**：复合不定代词作主语时，谓语动词一律用**单数**。
                        3.  **形容词定语**：形容词必须放在不定代词之后。*something interesting*。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *Is there ________ in today's newspaper?*
                        A. something new   B. new something   C. anything new   D. new anything
                        
                        **[解析]**：疑问句中用 anything，且形容词 new 要后置，选 **C**。

                        *(2023·广东中考)* *— Why didn't you buy the sweater? — Because there was ________ wrong with it.*
                        A. anything   B. nothing   C. something   D. everything
                        
                        **[解析]**：因为衣服“有毛病”所以没买。肯定句中用 something，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的假期日记 (My Vacation Diary)
                        #### 1. 写作要点
                        - **日期与天气**：Tuesday, July 15th. Sunny.
                        - **行程与活动**：使用一般过去时叙述（First we went to... Then we...）。
                        - **见闻与感受**：运用不定代词和评价性形容词（We saw something interesting. The food was delicious.）。

                        #### 2. 高分句式
                        - *I went to Beijing on vacation with my family.*
                        - *We decided to visit the Great Wall.*
                        - *There were quite a few people there.*
                        - *I felt very tired, but I really enjoyed it.*

                        #### 3. 满分范文
                        **A Great Vacation**
                        
                        Monday, August 12th
                        
                        Today I went to the Great Wall with my parents. It was sunny and hot. We went there by bus. There were quite a few people on the bus. When we arrived, we walked up the wall. It was very high. We took a lot of beautiful photos. For lunch, we ate something delicious in a restaurant. In the afternoon, we bought some special gifts for my friends. Although we were very tired, we had a great time!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "How often do you exercise?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活习惯与健康。
                        *   **深层意义**：本单元聚焦“活动的频率与生活习惯”。通过调查和统计个人做某事的频率（如锻炼、上网、喝牛奶），引导学生反思自己的生活方式，建立数据意识，并最终树立“自律即自由”的健康生活理念。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **频率副词**：always (总是), usually (通常), often (经常), sometimes (有时), hardly ever (几乎不), never (从不)。
                        - **活动词汇**：exercise (锻炼), skateboard (滑板), surf (冲浪), Internet (互联网)。
                        - **健康/身体**：health (健康), mind (头脑), body (身体), tooth/teeth (牙齿)。
                        - **数量与百分比**：percent (百分之...), result (结果)。

                        ### 2. 核心短语金牌储备
                        - `how often` 多久一次
                        - `hardly ever` 几乎从不
                        - `once a week` 一周一次
                        - `twice a month` 一月两次
                        - `go online` 上网
                        - `at least` 至少
                        - `such as` 例如
                        - `be good for` 对...有好处
                        - `junk food` 垃圾食品
                        - `more than` 多于
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. How often do you exercise? (你多久锻炼一次？)
                        - **【考点详解】**：`How often` 询问频率。回答通常用：频率副词（usually等）或“次数+时间段”（twice a week等）。
                        
                        #### 2. He hardly ever watches TV. (他几乎从不看电视。)
                        - **【结构剖析】**：`hardly ever` 相当于半否定词，位于实义动词之前。
                        
                        #### 3. Twenty percent of the students do not exercise at all. (20%的学生根本不锻炼。)
                        - **【语法核心】**：`not... at all` 意为“根本不；完全不”。
                        
                        #### 4. It is good to relax by using the Internet or watching game shows. (通过上网或看游戏节目来放松是很好的。)
                        - **【避坑指南】**：`by + doing sth.` 表示“通过...的方式”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：频率的表达方式
                        1.  **百分比频率副词**：always(100%) > usually(80%) > often(60%) > sometimes(30%) > hardly ever(5%) > never(0%)。
                        2.  **具体次数表达**：`次数 + a/an + 时间段`。
                            *   一次：`once`
                            *   两次：`twice`
                            *   三次及以上：`基数词 + times` (如 *three times a week*)

                        ### 核心语法二：How 疑问词组辨析
                        - `How often`：多久一次（问频率）。
                        - `How long`：多久（问时间段）。
                        - `How soon`：多久以后（常用于将来时）。
                        - `How far`：多远（问距离）。

                        ### 中考真题特训
                        
                        *(2024·江苏中考)* *— ________ do you go to the library? — Twice a month.*
                        A. How long   B. How often   C. How much   D. How soon
                        
                        **[解析]**：答语是频率，提问用 How often，选 **B**。

                        *(2023·北京中考)* *My grandparents live in the countryside. I visit them ________.*
                        A. once a month   B. one a month   C. a month once   D. month once
                        
                        **[解析]**：表达“一个月一次”，次数在前，时间在后，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：关于生活习惯的调查报告 (A Report on Habits)
                        #### 1. 写作要点
                        - **引言**：交代调查对象和内容（Here are the results of the student activity survey at...）。
                        - **数据展示**：使用百分比和比例表达（Most students..., ... percent of the students...）。
                        - **结论与建议**：给出健康建议（I think students should...）。

                        #### 2. 高分句式
                        - *We asked fifty students about their exercise habits.*
                        - *Only ten percent of the students exercise every day.*
                        - *Some students often go online, but it is bad for their eyes.*
                        - *In a word, we should exercise more to keep healthy.*

                        #### 3. 满分范文
                        **Our Exercise Habits**
                        
                        Last week, we asked 50 students in our class about their exercise habits. Here are the results.
                        
                        Most students are active. Twenty percent of the students exercise every day. They often play basketball or run. Fifty percent of the students exercise three to four times a week. However, twenty percent of the students exercise only once or twice a week. And ten percent of the students hardly ever exercise. They only watch TV or play computer games.
                        
                        I think students should do more exercise. It is very important to keep healthy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "I'm more outgoing than my sister.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 自我认识与他人。
                        *   **深层意义**：本单元探讨“人物特征的比较与友谊”。通过学习形容词的比较级，引导学生客观地对比自己与他人的异同。同时，在讨论“怎样才是一个好朋友”时，帮助学生树立正确的交友观：朋友不需要一模一样，互补的性格也能成为好朋友。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **性格形容词**：outgoing (外向的), hard-working (勤奋的), serious (严肃的), quiet (安静的), funny (滑稽的)。
                        - **评价形容词**：fantastic (极好的), clearly (清晰地), loudly (大声地)。
                        - **名词**：competition (比赛), mirror (镜子), kid (小孩), grade (成绩)。
                        - **动词**：win (赢), care (关心), touch (触摸), break (打碎)。

                        ### 2. 核心短语金牌储备
                        - `more outgoing` 更外向的
                        - `as ... as ...` 和...一样...
                        - `the singing competition` 歌咏比赛
                        - `be similar to` 与...相似
                        - `the same as` 和...一样
                        - `be different from` 与...不同
                        - `bring out` 使显现；使表现出
                        - `in fact` 事实上
                        - `make friends` 交朋友
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I'm more outgoing than my sister. (我比我妹妹更外向。)
                        - **【考点详解】**：`than` 是比较级的标志词。`outgoing` 是多音节词，比较级在前面加 `more`。
                        
                        #### 2. Tara works as hard as Tina. (塔拉和蒂娜工作一样努力。)
                        - **【结构剖析】**：`as + adj./adv.原级 + as` 表示“和...一样”。否定形式为 `not as/so ... as`。
                        
                        #### 3. A true friend reaches for your hand and touches your heart. (一个真正的朋友在你需要时给你帮助，使你感动。)
                        - **【经典佳句】**：极具文学色彩的排比句，常用于作文结尾升华主题。
                        
                        #### 4. My best friend is similar to me. (我最好的朋友和我相似。)
                        - **【避坑指南】**：`be similar to` 固定搭配。不要用 `with`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：形容词与副词的比较级
                        **1. 规则变化**：
                        - 一般加 -er：*tall -> taller, hard -> harder*。
                        - 辅音+y结尾，改y为i加er：*funny -> funnier, early -> earlier*。
                        - 重读闭音节双写加er：*big -> bigger, thin -> thinner, hot -> hotter*。
                        - 多音节词前加 more：*outgoing -> more outgoing, beautiful -> more beautiful*。
                        
                        **2. 不规则变化 (必背)**：
                        - *good / well -> better*
                        - *bad / badly / ill -> worse*
                        - *many / much -> more*
                        - *little / few -> less*
                        - *far -> farther / further*

                        **3. 程度修饰**：
                        - 比较级前可以用 `much, a lot, even, a little, a bit` 修饰，表示程度加深或减弱。(*much better* 好得多)。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *I think English is as ________ as math.*
                        A. important   B. more important   C. most important   D. importantly
                        
                        **[解析]**：as...as 之间必须用形容词或副词的原级，选 **A**。

                        *(2023·广东中考)* *The weather in Guangzhou is ________ than that in Beijing in winter.*
                        A. hot   B. hotter   C. hottest   D. much hot
                        
                        **[解析]**：than 提示用比较级，hot 的比较级需双写t，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：对比我与朋友 (My Friend and I)
                        #### 1. 写作逻辑
                        - **引入**：交代我和朋友的名字。
                        - **相同点**：运用 as...as, both... 描述共同点。
                        - **不同点**：运用比较级 (taller, more outgoing) 描述差异。
                        - **结论**：差异不影响我们成为好朋友。

                        #### 2. 高分句式
                        - *Tom is my best friend. We have some things in common.*
                        - *We both like sports, but he plays tennis better than me.*
                        - *I am quieter, and he is much more outgoing.*
                        - *I think differences are not important for friendship.*

                        #### 3. 满分范文
                        **My Best Friend and I**
                        
                        Li Ming is my best friend. We look similar. We are both tall and thin. And we both have short black hair. We have the same hobbies. We both like reading and playing basketball. 
                        
                        But we also have some differences. Li Ming is much more outgoing than me. He talks a lot and likes to make friends. I am quieter and I like to stay at home. Also, he studies harder than me. He always gets better grades. In fact, we are very different, but we are good friends.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "What's the best movie theater?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 社区服务与休闲场所。
                        *   **深层意义**：本单元聚焦于评价和选择身边的公共设施（如电影院、餐厅、超市）。通过学习形容词的最高级，培养学生比较事物的能力和做出合理决策的能力。同时，引导学生关注社区生活，学会在日常消费中进行理性评估。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **地点名词**：theater (剧院), seat (座位), screen (屏幕), ticket (票), radio (广播)。
                        - **评价形容词**：comfortable (舒适的), close (近的), fresh (新鲜的), cheap (便宜的), expensive (昂贵的), bad (差的), worse (更差的), worst (最差的)。
                        - **动词**：choose (选择), carefully (细致地), act (扮演), give (提供)。
                        - **其他**：town (城镇), song (歌曲), meal (一餐)。

                        ### 2. 核心短语金牌储备
                        - `so far` 到目前为止
                        - `no problem` 没问题
                        - `have... in common` 有相同特征
                        - `all kinds of` 各种各样的
                        - `be up to` 由...决定
                        - `play a role` 发挥作用
                        - `make up` 编造
                        - `for example` 例如
                        - `take... seriously` 认真对待...
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What's the best movie theater to go to? (去哪家电影院最好？)
                        - **【考点详解】**：`the best` 是 `good/well` 的最高级形式。`to go to` 是不定式作后置定语修饰 theater。
                        
                        #### 2. Town Cinema is the closest to home. (城镇影院离家最近。)
                        - **【结构剖析】**：`be close to` 离...近。`closest` 前面必须加定冠词 `the`。
                        
                        #### 3. It has the most comfortable seats. (它有最舒适的座位。)
                        - **【语法核心】**：多音节形容词的最高级在其前面加 `the most`。
                        
                        #### 4. You can buy clothes the most cheaply there. (在那儿你能买到最便宜的衣服。)
                        - **【避坑指南】**：`cheaply` 是副词修饰动词 buy，副词最高级前面的 `the` 可以省略。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：形容词与副词的最高级
                        **1. 变化规则**：
                        与比较级类似，一般加 -est 或在前面加 (the) most。
                        *   *tall - taller - the tallest*
                        *   *big - bigger - the biggest*
                        *   *heavy - heavier - the heaviest*
                        *   *interesting - more interesting - the most interesting*

                        **2. 不规则变化 (必背)**：
                        *   *good / well -> better -> the best*
                        *   *bad / badly / ill -> worse -> the worst*
                        *   *many / much -> more -> the most*
                        *   *little -> less -> the least*
                        *   *far -> farther / further -> the farthest / furthest*

                        **3. 最高级常用句型**：
                        - `主语 + be + the + 最高级 + in/of 范围.` (它是全班最高的。)
                        - `主语 + be + one of the + 最高级 + 名词复数.` (它是最受欢迎的城市之一。)

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *Of all the students, Lily speaks English ________.*
                        A. good   B. better   C. best   D. the best
                        
                        **[解析]**：Of all... 提示范围是三者及以上，用最高级。修饰动词 speaks 用副词 well 的最高级 best，副词最高级前 the 可省，选 **C/D (中考多为单选，此处选best最贴切，有时带the也可)**。（注：严谨来说，选C，但D在日常中也被接受，中考一般会避开这种双胞胎选项）。
                        
                        *(2023·广东中考)* *China is one of ________ countries in the world.*
                        A. oldest   B. older   C. the oldest   D. the older
                        
                        **[解析]**：one of the + 形容词最高级 + 复数名词，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：评价我所在城市的场所 (The Best Places in My Town)
                        #### 1. 写作逻辑
                        - **总述**：I live in a great town and there are many good places.
                        - **分类评价**：分别评价餐厅、电影院、超市等（使用最高级）。
                        - **总结**：Welcome to my town!

                        #### 2. 高分句式
                        - *The best supermarket is... because it has the freshest food.*
                        - *If you want to watch movies, ... is the best place to go.*
                        - *You can eat the most delicious noodles at...*
                        - *It has the best service in town.*

                        #### 3. 满分范文
                        **The Best Places in My Town**
                        
                        I live in a beautiful town. There are many good places to go. 
                        
                        If you want to buy things, the best supermarket is Sun Supermarket. It is the biggest and has the freshest food. The clothes there are the cheapest, too. For eating out, Miller's Restaurant is the best. It has the most delicious food and the friendliest service. If you want to watch a movie, Town Cinema is the best choice. It has the biggest screens and the most comfortable seats. 
                        
                        Welcome to my town. You will have a great time here!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "Do you want to watch a game show?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 文化娱乐与传媒。
                        *   **深层意义**：本单元围绕“电视节目类型及个人偏好”展开。旨在引导学生了解不同类型的媒体节目，学会表达计划、希望和期待。同时，培养学生批判性地观看电视节目的能力，合理分配娱乐与学习的时间。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **电视节目类型**：sitcom (情景喜剧), news (新闻), soap (肥皂剧), educational (教育的), comedy (喜剧), action (动作), cartoon (卡通片)。
                        - **动词**：mind (介意), stand (忍受), expect (期待), happen (发生), become (成为), discuss (讨论)。
                        - **名词**：culture (文化), joke (笑话), reason (原因), film (电影)。
                        - **其他**：meaningless (毫无意义的), famous (著名的), rich (富有的), successful (成功的)。

                        ### 2. 核心短语金牌储备
                        - `talk show` 访谈节目
                        - `game show` 游戏节目
                        - `soap opera` 肥皂剧
                        - `find out` 查明；弄清
                        - `be ready to` 准备好做...
                        - `dress up` 打扮
                        - `take sb's place` 代替某人
                        - `do a good job` 干得好
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What do you think of talk shows? (你觉得访谈节目怎么样？)
                        - **【考点详解】**：`What do you think of...?` 询问观点。相当于 `How do you like...?`
                        
                        #### 2. I can't stand them. (我受不了它们。)
                        - **【结构剖析】**：`can't stand (doing) sth.` 意为“无法忍受(做)某事”。
                        
                        #### 3. I hope to find out what's going on around the world. (我希望能了解世界各地正在发生的事情。)
                        - **【语法核心】**：`hope to do sth.` 希望做某事。注意不能说 `hope sb. to do sth.`。
                        
                        #### 4. We can learn a lot from them. (我们可以从中学到很多。)
                        - **【用法拓展】**：`learn from sb./sth.` 从...中学习。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：动词不定式作宾语
                        **1. 概念**：动词不定式 (to + 动词原形) 可以在句中作宾语。
                        **2. 常见接 to do 作宾语的动词 (必背口诀)**：
                        *   **决心学会想希望 (decide, learn, want, hope/wish)**
                        *   **拒绝设法愿假装 (refuse, manage, would like, pretend)**
                        *   **主动答应选计划 (offer, promise, choose, plan)**
                        *   **同意请求帮准备 (agree, ask, help, prepare)**

                        ### 中考真题特训
                        
                        *(2024·四川中考)* *I plan ________ my grandparents this weekend.*
                        A. visit   B. to visit   C. visiting   D. visited
                        
                        **[解析]**：plan to do sth. 计划做某事，选 **B**。

                        *(2023·北京中考)* *— What do you think of soap operas? — I don't mind ________.*
                        A. they   B. it   C. them   D. their
                        
                        **[解析]**：soap operas 是复数，作宾语用宾格 them，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我最喜欢的电视节目 (My Favorite TV Show)
                        #### 1. 写作要点
                        - **引入**：I like watching TV.
                        - **表明偏好**：My favorite TV show is...
                        - **解释原因**：Why do you like it? (Educational, interesting, learn a lot).
                        - **对其他节目的看法**：I don't mind... / I can't stand...

                        #### 2. 高分句式
                        - *I like to watch the news because I hope to find out what's going on.*
                        - *I can't stand soap operas. I think they are meaningless.*
                        - *Game shows are fun to watch.*

                        #### 3. 满分范文
                        **My TV Preferences**
                        
                        I usually watch TV in my free time. There are many kinds of TV shows. My favorite shows are news and talk shows. I watch the news every day because I hope to find out what's going on around the world. And talk shows are very educational. We can learn a lot from them.
                        
                        However, I don't like soap operas. I can't stand them because I think they are meaningless and boring. I don't mind game shows. Sometimes they are interesting. In a word, I like watching educational programs.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "I'm going to study computer science.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 职业规划与未来。
                        *   **深层意义**：本单元围绕“未来的职业理想及如何实现目标”展开。旨在引导学生思考自己的未来，设定长远目标（New Year's Resolutions），并学会为实现目标制定切实可行的计划。这不仅是语言学习，更是生涯规划教育。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **职业名词**：doctor (医生), engineer (工程师), violinist (小提琴手), pilot (飞行员), pianist (钢琴家), scientist (科学家), cook (厨师)。
                        - **与计划相关的动词**：grow (成长), build (建筑), promise (承诺), improve (改进), physical (身体的)。
                        - **名词**：college (大学), education (教育), medicine (药), university (大学), resolution (决心), foreign (外国的)。
                        - **其他**：sure (确信的), beginning (开始), able (能够)。

                        ### 2. 核心短语金牌储备
                        - `grow up` 长大；成熟
                        - `computer science` 计算机科学
                        - `take acting lessons` 上表演课
                        - `make a resolution` 下决心
                        - `make promises` 许下诺言
                        - `have to do with` 关于；与...有关系
                        - `take up` 开始从事
                        - `at the beginning of` 在...的开始
                        - `write down` 写下
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What do you want to be when you grow up? (你长大后想当什么？)
                        - **【考点详解】**：`want to be` 表示“想成为...（指职业）”。`when` 引导时间状语从句。
                        
                        #### 2. I'm going to study computer science. (我打算学习计算机科学。)
                        - **【结构剖析】**：`be going to do sth.` 意为“打算/将要做某事”，表示未来的计划。
                        
                        #### 3. Where are you going to work? (你打算去哪里工作？)
                        - **【语法核心】**：一般将来时的特殊疑问句。
                        
                        #### 4. Many resolutions have to do with self-improvement. (许多新年决心都与自我提升有关。)
                        - **【避坑指南】**：`have to do with` 是中考常考短语，意为“与...有关”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：一般将来时 (be going to)
                        **1. 功能**：表示主观打算、计划要做的事情，或根据现有迹象推测将要发生的事情。
                        **2. 构成**：`am / is / are + going to + 动词原形`。
                        **3. 句式变化**：
                        - 否定：`be + not + going to do`。
                        - 疑问：`Be` 动词提前。
                        **4. 标志词**：`tomorrow`, `next week/year`, `in the future`, `soon`。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *I ________ a new bike next week.*
                        A. am going to buy   B. buy   C. bought   D. buys
                        
                        **[解析]**：next week 提示将来时，选 **A**。

                        *(2023·河北中考)* *— What are your plans for the weekend? — I ________ visit my grandparents in the countryside.*
                        A. am going to   B. went to   C. have to   D. used to
                        
                        **[解析]**：询问计划，用 be going to 结构表达打算，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的梦想与新年决心 (My Dream / New Year's Resolutions)
                        #### 1. 写作要点
                        - **职业梦想**：What do you want to be?
                        - **原因**：Why do you want to be a...?
                        - **实现路径**：How are you going to do that? (列举具体行动)。

                        #### 2. 高分句式
                        - *When I grow up, I want to be an engineer.*
                        - *I am going to study hard to get good grades.*
                        - *I believe my dream will come true.*
                        - *Next year, I am going to make some resolutions.*

                        #### 3. 满分范文
                        **My Dream Job**
                        
                        Everyone has a dream. When I grow up, I want to be a doctor. I think it is a great job because doctors can help sick people and save their lives.
                        
                        How am I going to do that? First, I am going to study science and math really hard. They are very important for a doctor. Second, I am going to read more books about medicine. Third, I am going to exercise every day to keep healthy, because a doctor needs a strong body.
                        
                        I know it is not easy to be a doctor, but I will try my best. I believe my dream will come true in the future.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "Will people have robots?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自然/人与社会 —— 未来的世界。
                        *   **深层意义**：本单元围绕“对未来世界的预测”展开。引导学生发挥想象力，预测科技发展对人类生活、环境的影响。通过讨论环保问题（less pollution, fewer trees），培养学生的全球视野和环保意识，理解科技发展与自然环境的辩证关系。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **科技与环境**：robot (机器人), paper (纸), pollution (污染), environment (环境), planet (行星/地球), earth (地球)。
                        - **动词预测**：predict (预测), plant (种植), play (播放/扮演), fly (飞行), fall (倒塌/跌倒)。
                        - **名词**：part (部分), peace (和平), sea (海), sky (天空), space (太空)。
                        - **其他**：already (已经), even (甚至), inside (在...里面), impossible (不可能的)。

                        ### 2. 核心短语金牌储备
                        - `in the future` 在将来
                        - `free time` 业余时间
                        - `live to be 200 years old` 活到200岁
                        - `on the earth` 在地球上
                        - `play a part in` 参与；发挥作用
                        - `hundreds of` 数百的
                        - `over and over again` 多次；反复地
                        - `fall down` 倒塌；跌倒
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Will people have robots? (人们会有机器人吗？)
                        - **【考点详解】**：`will` 引导的一般将来时的一般疑问句。回答用 `Yes, they will. / No, they won't.`
                        
                        #### 2. There will be less pollution. (将会更少污染。)
                        - **【结构剖析】**：`There be` 句型的将来时为 `There will be`。`less` 修饰不可数名词 pollution。
                        
                        #### 3. People will live to be 200 years old. (人们将活到200岁。)
                        - **【用法拓展】**：`live to be + 年龄` 意为“活到...岁”。
                        
                        #### 4. The environment will be in great danger. (环境将处于极大危险中。)
                        - **【避坑指南】**：`be in danger` 处于危险中。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：一般将来时 (will)
                        **1. 功能**：表示对未来的推测，或者临时决定的意愿。
                        **2. 构成**：`主语 + will + 动词原形`。 (will 的否定是 won't)。
                        **3. 与 be going to 的区别**：
                        - `be going to` 强调事先计划好的事。
                        - `will` 强调主观预测或说话瞬间的决定。

                        ### 核心语法二：more, less, fewer 辨析
                        - **more** (更多)：既可修饰可数名词复数，也可修饰不可数名词。
                        - **fewer** (更少)：只能修饰**可数名词复数**。 (*fewer trees, fewer cars*)
                        - **less** (更少)：只能修饰**不可数名词**。 (*less water, less pollution*)

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *I think there will be ________ cars and ________ air pollution in 2050.*
                        A. fewer; less   B. less; fewer   C. more; fewer   D. fewer; more
                        
                        **[解析]**：cars 是可数名词复数，用 fewer；pollution 是不可数名词，用 less，选 **A**。

                        *(2023·北京中考)* *Look at the dark clouds. It ________ rain.*
                        A. will   B. is going to   C. would   D. was going to
                        
                        **[解析]**：根据迹象（乌云）推测将要发生的事，更倾向用 is going to，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：未来的世界 (The World in the Future)
                        #### 1. 写作要点
                        - **时间背景**：What will the world be like in 100 years?
                        - **环境与生活**：使用 will/won't 和 more/less/fewer 进行预测（如机器人的使用、环境变化）。
                        - **个人期望**：I hope our world will be better.

                        #### 2. 高分句式
                        - *I think there will be more robots in our homes.*
                        - *People will have more free time because robots will do the heavy work.*
                        - *I hope there will be less pollution and the sky will be bluer.*

                        #### 3. 满分范文
                        **Life in the Future**
                        
                        What will our life be like in 100 years? I think there will be many changes. 
                        
                        First, people will have more robots in their homes. Robots will help us do the housework, so people will have more free time. Second, kids won't go to school. They will study at home on computers. Third, people will live to be 150 years old. 
                        
                        What about the environment? I hope there will be less pollution and the air will be cleaner. But if we don't protect the earth now, the environment will be worse. Let's work together to make the world a better place.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "How do you make a banana milk shake?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活技能与美食。
                        *   **深层意义**：本单元围绕“制作食物的过程”展开。通过学习祈使句及顺序副词（first, next, then, finally），引导学生掌握叙述操作步骤的能力。在动手实践中，培养学生的劳动意识、生活自理能力和对传统节日美食（如感恩节火鸡）的跨文化理解。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **烹饪动作**：peel (剥皮), pour (倒出), put (放), turn on (打开), cut up (切碎), mix (混合), add (增加)。
                        - **食材名词**：yogurt (酸奶), honey (蜂蜜), watermelon (西瓜), salt (盐), sugar (糖), cheese (奶酪), butter (黄油)。
                        - **用具名词**：blender (搅拌器), spoon (勺子), pot (锅), machine (机器)。
                        - **其他**：finally (最后), traditional (传统的), traveler (旅行者)。

                        ### 2. 核心短语金牌储备
                        - `milk shake` 奶昔
                        - `turn on` 打开 (电器)
                        - `cut up` 切碎 (**必考：代词放中间 cut it up**)
                        - `pour ... into ...` 把...倒入...
                        - `add ... to ...` 把...加到...里
                        - `one more thing` 还有一件事
                        - `at this time` 在此时
                        - `fill ... with ...` 用...填满...
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. How do you make a banana milk shake? (你是怎么做香蕉奶昔的？)
                        - **【考点详解】**：`How` 询问制作方法/过程。
                        - **【避坑指南】**：`banana` 在这里作定语修饰 `milk shake`，不用复数。
                        
                        #### 2. Peel the bananas and cut them up. (剥香蕉皮然后把它们切碎。)
                        - **【结构剖析】**：祈使句表指令。`cut up` 是动副短语，代词 `them` 必须放在中间。
                        
                        #### 3. Finally, turn on the blender. (最后，打开搅拌器。)
                        - **【句式连接】**：使用表示顺序的副词（First, Next, Then, Finally）使表达有条理。
                        
                        #### 4. How many bananas do we need? (我们需要多少香蕉？)
                        - **【语法延伸】**：`How many` 问可数名词数量，`How much` 问不可数名词（如 yogurt, honey）的数量。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：祈使句表达操作步骤
                        祈使句常用于提供说明、给出指示或食谱。以动词原形开头。

                        ### 核心语法二：数量词 How many 与 How much
                        - `How many + 可数名词复数`
                        - `How much + 不可数名词`

                        ### 核心语法三：动副短语的宾语位置
                        对于像 `turn on`, `cut up`, `put off` 等动词+副词构成的短语：
                        - 名词作宾语：放中间或后面均可 (*turn on the TV / turn the TV on*)。
                        - 代词作宾语：**必须放中间** (*turn it on, cut them up*)。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *Here are some apples. Please ________.*
                        A. cut up them   B. cut them up   C. cut it up   D. cut up it
                        
                        **[解析]**：apples 是复数用 them，代词必须放在动副短语中间，选 **B**。

                        *(2023·广东中考)* *— ________ honey do we need? — Only a little.*
                        A. How many   B. How much   C. How long   D. How often
                        
                        **[解析]**：honey (蜂蜜) 是不可数名词，提问用 How much，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：如何制作一种食物 (How to make...)
                        #### 1. 写作要点
                        - **材料准备**：First, you need...
                        - **制作步骤**：熟练运用表示顺序的连词（First, Next, Then, After that, Finally）。
                        - **动作描写**：准确使用 cut, put, add, pour, turn on 等动词。

                        #### 2. 高分句式
                        - *It's easy to make a fruit salad.*
                        - *First, wash the apples and cut them up.*
                        - *Next, put the fruit in a bowl.*
                        - *Finally, add some yogurt to the fruit and mix it all up.*

                        #### 3. 满分范文
                        **How to Make a Fruit Salad**
                        
                        It's very easy to make a fruit salad. You need two apples, three bananas, a watermelon and some yogurt. 
                        
                        First, wash the apples. Peel the apples and bananas. Then, cut up all the fruit. Next, put the fruit in a big bowl. After that, pour the yogurt into the bowl. Finally, mix it all up. Now, a delicious fruit salad is ready. You can enjoy it with your friends!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u9", "Unit 9", "Can you come to my party?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 社交邀请与回应。
                        *   **深层意义**：本单元围绕“发出、接受和拒绝邀请”展开。旨在培养学生在社交场合的礼貌用语和得体交际的能力。学会用适当的理由婉拒他人，并在安排日程时权衡各项活动的优先级，提升时间管理和社交情商。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **活动/事件**：exam (考试), concert (音乐会), event (事件), calendar (日历), daytime (白天)。
                        - **动词**：prepare (准备), hang (悬挂), catch (抓住), invite (邀请), accept (接受), refuse (拒绝), reply (回复)。
                        - **形容词/副词**：available (有空的), sad (悲伤的), glad (高兴的), forward (向前)。
                        - **其他**：guest (客人), opening (开幕), without (没有)。

                        ### 2. 核心短语金牌储备
                        - `prepare for` 为...做准备
                        - `go to the doctor` 去看医生
                        - `have the flu` 得流感
                        - `hang out` 闲逛；常去某处
                        - `catch you on Monday` 咱们周一见
                        - `turn down` 拒绝
                        - `take a trip` 去旅行
                        - `look forward to (doing) sth.` 期待做某事 (**必考：to是介词**)
                        - `hear from sb.` 收到某人的来信
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Can you come to my party? (你能来参加我的派对吗？)
                        - **【考点详解】**：`Can` 引导一般疑问句，用于发出邀请。
                        - **【回答礼仪】**：
                            *   接受：`Sure, I'd love to.`
                            *   拒绝：`I'm sorry, I can't. I have to...` (拒绝时必须给出理由以示礼貌)。
                        
                        #### 2. I have to prepare for an exam. (我必须为考试做准备。)
                        - **【结构剖析】**：`prepare for sth.` 意为“为...做准备”。
                        
                        #### 3. I look forward to hearing from you. (我期待收到你的回信。)
                        - **【句式金牌】**：`look forward to doing sth.` 重点考查 `to` 为介词，后接动名词。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：情态动词 can 表邀请
                        在口语中，`Can you...?` 常用于朋友或熟人间的邀请。更委婉的表达是 `Could you...?` 或 `Would you like to...?`。

                        ### 核心语法二：介词 to 与不定式 to 的区分
                        英语中很多含有 to 的短语，to 实际上是介词，后面必须接 **名词、代词或动名词(v.-ing)**。
                        **必背介词to短语**：
                        *   `look forward to doing` (期待做)
                        *   `be/get used to doing` (习惯于做)
                        *   `pay attention to doing` (注意做)
                        *   `make a contribution to doing` (为...做贡献)

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *— Can you come to my birthday party tomorrow? — ________. I have to look after my little sister.*
                        A. Yes, I'd love to   B. Sure, no problem   C. I'm afraid not   D. That's a good idea
                        
                        **[解析]**：根据后文“得照顾妹妹”可知是拒绝邀请，选 **C**。

                        *(2023·广东中考)* *We are all looking forward to ________ a great vacation in Beijing.*
                        A. have   B. having   C. has   D. had
                        
                        **[解析]**：look forward to doing sth. 期待做某事，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：写邀请函及回复 (Invitations and Replies)
                        #### 1. 写作要点
                        - **邀请函 (Invitation)**：说明活动内容、时间、地点；表达希望对方参加的意愿。
                        - **接受回复 (Accepting)**：表达感谢；确认参加。
                        - **拒绝回复 (Refusing)**：表达感谢和歉意；说明不能参加的真实原因。

                        #### 2. 高分句式
                        - *I am having a party at my house this Saturday.*
                        - *I would love to come to your party.*
                        - *I am really sorry, but I can't come.*
                        - *I look forward to seeing you soon.*

                        #### 3. 满分范文
                        **An Invitation & A Reply**
                        
                        (Invitation)
                        Dear Jane,
                        I am going to have a birthday party at my house this Saturday evening. It will start at 7:00 p.m. We will eat delicious food and play games. Can you come to my party? I look forward to hearing from you.
                        Yours,
                        Li Hua
                        
                        (Reply)
                        Dear Li Hua,
                        Thanks so much for your invitation. I'm really sorry, but I can't come to your party. I have a piano lesson this Saturday evening. Have a great time!
                        Yours,
                        Jane
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u10", "Unit 10", "If you go to the party, you'll have a great time!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 决策与结果。
                        *   **深层意义**：本单元围绕“假设与结果”展开，学习 `If` 引导的条件状语从句。旨在引导学生理解因果逻辑，学会在做决定前评估可能产生的后果。通过讨论青少年常见问题（如考试焦虑、友谊危机），培养解决问题的能力和为自己行为负责的意识。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **事件与问题**：meeting (会议), video (录像), step (步骤), mistake (错误), problem (问题), experience (经验)。
                        - **动词**：organize (组织), travel (旅行), advise (建议), solve (解决), trust (信任)。
                        - **形容词/副词**：upset (难过的), normal (正常的), certainly (无疑), angry (生气的), careless (粗心的)。
                        - **其他**：else (别的), halfway (在中途)。

                        ### 2. 核心短语金牌储备
                        - `have a great time` 玩得开心
                        - `stay at home` 待在家里
                        - `take a taxi` 乘出租车
                        - `give sb. some advice` 给某人一些建议
                        - `keep ... to oneself` 把...保守为秘密
                        - `talk to sb.` 跟某人谈话
                        - `in half` 分成两半
                        - `make mistakes` 犯错误
                        - `run away from` 逃避
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. If you go to the party, you'll have a great time! (如果你去参加派对，你会玩得很开心的！)
                        - **【考点详解】**：`If` 引导条件状语从句。遵循**“主将从现”**原则，即主句用将来时(you'll)，从句用一般现在时(go)。
                        
                        #### 2. What will happen if they have the party today? (如果他们今天举行派对，会发生什么？)
                        - **【结构剖析】**：`happen` 是不及物动词，常用于 `Sth. happens to sb.` 结构。
                        
                        #### 3. It is best not to run away from our problems. (最好不要逃避我们的问题。)
                        - **【语法核心】**：`It's best (not) to do sth.` 意为“最好(不)做某事”。
                        
                        #### 4. A problem shared is a problem halved. (与人分担一个烦恼，就像把烦恼减半了。)
                        - **【经典佳句】**：英语谚语。`shared` 和 `halved` 都是过去分词作后置定语。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：If 引导的条件状语从句
                        **1. “主将从现” 原则**：
                        当讨论未来的情况时，`if` 从句中不能用 will，必须用一般现在时表将来；而主句使用一般将来时。
                        *   *If it **rains** tomorrow, we **will stay** at home.*

                        **2. “主情从现” 与 “主祈从现”**：
                        - 主句可以是含有情态动词的句子：*If you are tired, you **can rest**.*
                        - 主句可以是祈使句：*If you don't know the word, **look** it up in a dictionary.*

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *We will go for a picnic if it ________ tomorrow.*
                        A. won't rain   B. doesn't rain   C. didn't rain   D. hasn't rained
                        
                        **[解析]**：If引导的条件状语从句遵循“主将从现”，主句是将来时，从句用一般现在时表将来，选 **B**。

                        *(2023·河北中考)* *If you want to be healthy, you ________ eat more vegetables.*
                        A. must to   B. should   C. had to   D. are going to
                        
                        **[解析]**：主句用情态动词给出建议（主情从现），选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：给面临困境的朋友写建议信 (Advice for a Friend)
                        #### 1. 写作逻辑
                        - **表达同情**：I am sorry to hear that you are upset.
                        - **分析问题**：指出问题所在。
                        - **提供建议**：使用 If 句型说明采取不同行动可能产生的结果。
                        - **鼓励结语**：Don't worry. Everything will be OK.

                        #### 2. 高分句式
                        - *You should talk to your parents about your problems.*
                        - *If you keep the problems to yourself, you will feel worse.*
                        - *If you tell your friend the truth, he will understand you.*
                        - *A problem shared is a problem halved.*

                        #### 3. 满分范文
                        **A Letter of Advice**
                        
                        Dear Tom,
                        I am sorry to hear that you had a fight with your best friend. Don't be too sad. Here is some advice for you. 
                        
                        I think you should write a letter to him and say sorry. If you write a letter, he will know you still care about him. Also, you can invite him to play basketball this weekend. If you play together, you will soon become good friends again. It's best not to keep the problem to yourself. A problem shared is a problem halved. 
                        
                        I hope things will work out for you.
                        Yours,
                        Li Hua
                    """.trimIndent())
                )
            )
        )
    )
}
