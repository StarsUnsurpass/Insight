package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade7Down {
    val data = Textbook(
        id = "g7_down",
        grade = "七年级",
        term = "下册",
        coverColor = Color(0xFFC8E6C9),
        units = listOf(
            TextbookUnit("g7d_u1", "Unit 1", "Can you play the guitar?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 2025新课标主题透视
                    *   **主题范畴**：人与自我 (Man and Self) —— 个人特长与意愿。
                    *   **核心内容**：谈论能力 (Abilities) 与加入社团 (Joining clubs)。
                    *   **核心素养**：学会发现自身闪光点，并根据特长进行社交协作。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇金牌解析 (Vocabulary)", """
                    #### ① **play the guitar / chess / the piano**
                    - **【黄金法则】**：
                      1. **乐器类**：名词前必须加 **the**。 *play the violin/drums*.
                      2. **球类/棋类**：名词前**不加**任何冠词。 *play football/chess*.
                    
                    #### ② **speak / tell / say / talk** (四“说”辨析)
                    - **speak**: 强调“说某种语言”。 *speak English/Chinese*.
                    - **tell**: “讲述；告诉”。常接双宾语。 *tell sb. a story*.
                    - **say**: “说出”，强调说话内容。 *say it in English*.
                    - **talk**: “交谈”。强调双向性。 *talk to/with sb.*.
                    
                    #### ③ **be good at / with**
                    - **be good at**: 擅长某事。后接名词或 v-ing。 *He is good at swimming.*
                    - **be good with**: 与某人相处得好。 *She is good with old people.*
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲 (Grammar Master)", """
                    ### 情态动词 "can" 的全能用法
                    - **【物理属性】**：
                      1. 无人称和数的变化（I can, She can, They can）。
                      2. 后面必须接**动词原形**。
                    - **【句式结构】**：
                      - 肯定：*I can dance.*
                      - 否定：*I can't (cannot) dance.*
                      - 疑问：*Can you dance?* -> *Yes, I can. / No, I can't.*
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **What club do you want to join?** (询问意愿)
                    - **I want to join the music club.** (陈述目标)
                    - **Are you good at telling stories?** (探查专长)
                """.trimIndent()),
                UnitDetailSection("🎯 中考考点模拟 (Exam Drill)", """
                    - **【考点1：play的冠词】**
                      *He likes playing ________ basketball, but he doesn't like playing ________ guitar.*
                      A. /; the  B. the; /  C. the; the  D. /; /
                      **[解析]**：球类不加the，乐器加the，选 **A**。
                """.trimIndent())
            )),
            TextbookUnit("g7d_u2", "Unit 2", "What time do you go to school?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 核心主题
                    *   **内容**：描述日常作息 (Daily routine) 与精准时间表达。
                    *   **重点**：What time vs When；频率副词的物理分布。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇金牌解析", """
                    #### ① **get up / get dressed / take a shower**
                    - **【动作链】**：描述早起后的连续物理动作。
                    
                    #### ② **either ... or ...** (要么……要么……)
                    - **【就近原则】**：当连接两个主语时，谓语动词随最近的那个变化。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 1. 频率副词 (Frequency Adverbs)
                    - **【梯度梯度】**：*always (100%) > usually (80%) > often (60%) > sometimes (30%) > never (0%)*。
                    - **【物理位置】**：**行前 be 后** (实义动词前，be动词/助动词后)。
                    - *I **usually** get up early.* / *He **is** never late.*
                    
                    ### 2. 时间表达法深度总结
                    - **顺读法**：*7:10 (seven ten)*。
                    - **逆读法**：
                      - 分钟 ≤ 30 用 **past**。 *twenty past seven* (7:20)。
                      - 分钟 > 30 用 **to**。 *ten to eight* (7:50)。
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **What time do you usually get up?** (询问具体时刻)
                    - **When do you exercise?** (询问泛指时间)
                    - **That's a funny time for breakfast!** (口语评价)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u3", "Unit 3", "How do you get to school?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 核心逻辑
                    *   **内容**：描述交通方式 (Means of transport)；距离与时长计算。
                    *   **物理常识**：将距离 (Distance) 与速度 (Speed) 转化为时间 (Time)。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **by train / on a bus / ride a bike**
                    - **【搭配守则】**：
                      1. **by + 交通工具**：中间**不加**任何冠词。 *by car/train*.
                      2. **take + (a/the) + 交通工具**：必须加限定词。 *take the bus*.
                    
                    #### ② **How long vs How far**
                    - **How long**: 询问时间长度。 *How long does it take?* (多久？)
                    - **How far**: 询问路程远近。 *How far is it?* (多远？)
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 时间消耗模型 (Fixed Sentence Pattern)
                    - **【金牌句型】**：**It takes sb. some time to do sth.** (花费某人多少时间做某事)
                    - **【解析】**：*It* 是形式主语，真正的主语是后面的动变不定式。
                    - *It takes me 30 minutes to get to school.*
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **How do you get to school?** (询问方式)
                    - **How far is it from your home to school?** (询问物理跨度)
                    - **It's about five kilometers.** (回答距离)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u4", "Unit 4", "Don't eat in class.", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 核心主题
                    *   **领域**：校园/家庭规则 (Rules & Regulations)。
                    *   **考点**：祈使句的负向控制；情态动词 must/have to 辨析。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **on time vs in time**
                    - **on time**: 准时 (指按规定时刻)。
                    - **in time**: 及时 (指在发生意外前赶上)。
                    
                    #### ② **have to vs must** (必须)
                    - **must**: 侧重主观意愿，“我觉得必须”。
                    - **have to**: 侧重客观需要，“不得不”，有数和时态变化。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 1. 祈使句 (Imperatives)
                    表示命令、请求或劝告。
                    - **肯定**：动词原形开头。 *Listen to me.*
                    - **否定**：**Don't** + 动词原形。 *Don't be late.*
                    
                    ### 2. 情态动词 can / must / can't 的逻辑限制
                    - **can/can't**: 许可与禁令。 *You can't eat in class.*
                    - **must**: 强制性义务。
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **Don't arrive late for class.** (警示语)
                    - **We must be on time.** (义务陈述)
                    - **What are the rules at your school?** (规则询问)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u5", "Unit 5", "Why do you like pandas?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 主题情境
                    *   **内容**：描述动物及其特质；表达喜好原因。
                    *   **核心逻辑**：因果论证 (Reasoning with 'Why' and 'Because')。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **kind of** (稍微; 有点)
                    - 后面接形容词。 *They are kind of shy.* (它们有点害羞)。
                    
                    #### ② **be from / come from** (来自)
                    - **物理属性**：描述原产地。 *Pandas are from China.*
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### Why 引导的特殊疑问句探秘
                    - **【逻辑闭合】**：Why 问 because 答。
                    - **【注意】**：在英语表达中，**because** 和 **so** 不能同时出现在一句话里（避免逻辑重叠）。
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **Why do you like pandas? — Because they are very intelligent.**
                    - **Where are lions from? — They are from South Africa.**
                    - **Let's see the elephants first.** (建议用语)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u6", "Unit 6", "I'm watching TV.", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 核心时态
                    *   **内容**：谈论正在发生的动作。
                    *   **重点**：现在进行时的基本结构与动词-ing变化规则。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 现在进行时 (Present Continuous)
                    - **【物理本质】**：描述此刻“当下”正在进行的物理位移或动作状态。
                    - **【基本结构】**：**am/is/are + 动词-ing** (现在分词)。
                    - **【动词-ing变化四法则】**：
                      1. 直接加 -ing (*doing*)。
                      2. 去e加 -ing (*using*)。
                      3. 双写末尾辅音加 -ing (针对重读闭音节单词, *running*)。
                      4. 变ie为y加 -ing (*dying*)。
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **What are you doing? — I'm reading a book.**
                    - **Is he doing his homework? — Yes, he is. / No, he isn't.**
                    - **Do you want to join me for dinner?** (邀请用语)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u7", "Unit 7", "It's raining!", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 核心话题
                    *   **内容**：天气状况描述及其引发的人类活动。
                    *   **语法**：询问天气的两种经典方案。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **weather** /ˈweðə(r)/ (n. 天气)
                    - **【重要属性】**：**不可数名词**。前通常加 *the*。
                    
                    #### ② **rainy / snowy / sunny / cloudy / windy**
                    - **【构词法】**：名词 (rain, snow, sun...) + 后缀 **-y** 演变为形容词物理场。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 询问天气的双全法
                    1. **How is the weather?** (用 how 提问)
                    2. **What is the weather like?** (用 what 引导，带介词 like)
                    - **回答**：*It's raining.* / *It's sunny.*
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **How's it going?** (近况询问) -> *Great! / Not bad.*
                    - **What are they doing in the park? — They are playing games.**
                """.trimIndent())
            )),
            TextbookUnit("g7d_u8", "Unit 8", "Is there a post office near here?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 物理空间定位
                    *   **内容**：街道设施及其方位辨别。
                    *   **重点**：There be 句型的存在逻辑；方位介词的精准投射。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **between ... and ...** (在……之间)
                    - 指在两个具体物体或地点中间。
                    
                    #### ② **across from / next to / in front of**
                    - **方位坐标系**：
                      - *next to*: 紧挨着。
                      - *across from*: 在……对面（通常隔着街道）。
                      - *in front of*: 在……前面（外部空间）。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### There be 句型 (存留物理场)
                    - **肯定句**：*There is a park near my house.*
                    - **否定句**：*There is not (isn't) any park...* (注：否定/疑问句中用 any)。
                    - **疑问句**：*Is there a park...?*
                    - **【就近原则】**：当有多个主语并列时，be 动词随最近的名词。
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **Is there a supermarket on Center Street?** (存在性询问)
                    - **The library is between the hotel and the bank.** (位置定点)
                    - **Just go along Bridge Street and turn right.** (导航指引)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u9", "Unit 9", "What does he look like?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 人物建模
                    *   **内容**：描述人物的外貌特征（头发、身高、体型）。
                    *   **核心**：形容词排序逻辑与 look like 的句法结构。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **look like** (看起来像)
                    - *look* 是连系动词，*like* 是介词。
                    
                    #### ② **curly vs straight** (头发形状)
                    #### ③ **tall / thin / heavy** (身材指标)
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精析", """
                    ### 1. 描述人物特征的动词选择
                    - **is**: 接身高、胖瘦等抽象体征。 *He is tall/heavy.*
                    - **has**: 接具体的器官或特征（头发、眼睛）。 *She has long hair.*
                    
                    ### 2. 形容词排序物理定律
                    - **基本顺序**：长短 + 形状 + 颜色 + 名词。
                    - *She has **long curly black** hair.*
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **What does he look like?** (询问外貌)
                    - **He is of medium height and has glasses.**
                    - **Is that man your teacher?** (确认性疑问)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u10", "Unit 10", "I'd like some noodles.", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 核心话题
                    *   **情境**：餐厅订餐、点菜。
                    *   **重点**：可数/不可数名词的物理计数；would like 的委婉请求。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇金牌解析", """
                    #### ① **would like** (想要)
                    - 比 *want* 更加礼貌委婉。
                    - **固定结构**：
                      1. *would like sth.*
                      2. *would like to do sth.*
                    
                    #### ② **noodle (n.)**
                    - 在表示该种食物时，通常用复数 **noodles**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 可数名词与不可数名词的物理界限
                    - **可数 (Countable)**：可以按个数数。 *apple, potato, vegetable*.
                    - **不可数 (Uncountable)**：难以单独计数，常需借助容器/单位。 *beef, mutton, soup*.
                    - **特殊属性**：*chicken* (鸡肉-不可数 / 雏鸡-可数)。
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **What size bowl of noodles would you like?** (询问规格)
                    - **I'd like a large bowl of beef noodles.**
                    - **Are there any vegetables in the soup?** (成分询问)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u11", "Unit 11", "How was your school trip?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 时间轴回溯
                    *   **内容**：描述过去发生的学校旅行。
                    *   **核心**：一般过去时 (Simple Past) 的初次接触。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 一般过去时 (Simple Past) —— 状态场
                    - **be 动词的变化**：
                      - am, is -> **was**
                      - are -> **were**
                    - **【肯定句】**：*It **was** exciting.* / *They **were** happy.*
                    - **【否定句】**：*It **was not (wasn't)** boring.*
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **How was your school trip? — It was great!** (评价过去体验)
                    - **Were the strawberries good? — Yes, they were.**
                    - **What did you do there?** (询问过去的活动)
                """.trimIndent())
            )),
            TextbookUnit("g7d_u12", "Unit 12", "What did you do last weekend?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    ### 1. 核心剧情
                    *   **内容**：叙述上周末的活动。
                    *   **难点**：实义动词变过去式的规则与不规则变化；did 助动词的介入。
                """.trimIndent()),
                UnitDetailSection("⚙️ 核心语法精讲", """
                    ### 一般过去时 (Simple Past) —— 实义动词场
                    - **动词变位规则**：
                      1. 加 -ed (*played*)。
                      2. y 变为 i 加 -ed (*studied*)。
                      3. 不规则变化 (需死记硬背)：*go -> went*, *have -> had*, *see -> saw*.
                    - ** did 助动词的物理控制**：
                      - 在**疑问句**和**否定句**中，必须请出 **did**，且请出 did 后实义动词必须**还原**为原形！
                      - *Did you go...?* (不能说 Did you went...?)
                """.trimIndent()),
                UnitDetailSection("📚 重点句式深度解析", """
                    - **What did you do last weekend? — I did my homework.**
                    - **Did you go to the cinema? — No, I didn't. I stayed at home.**
                    - **It was kind of scary.** (心理感受评价)
                """.trimIndent())
            ))
        )
    )
}

object Grade8Down {
    val data = Textbook(
        id = "g8_down",
        grade = "八年级",
        term = "下册",
        coverColor = Color(0xFFFFCCBC),
        units = listOf(
            TextbookUnit("g8d_u1", "Unit 1", "What's the matter?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    *   **主题范畴**：人与自我 —— 健康管理与安全救援。
                    *   **核心内容**：表述疾病情况，给出急救或健康建议。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **have a + 疾病名称**
                    - *have a fever* (发烧); *have a stomachache* (胃痛)。
                    
                    #### ② **reflexive pronouns** (反身代词)
                    - *himself, herself, yourself...*
                    - **物理逻辑**：主语和宾语指代同一个人。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### should / shouldn't (建议磁场)
                    - 用于给出建议。 *You should drink more water.*
                """.trimIndent())
            )),
            TextbookUnit("g8d_u2", "Unit 2", "I'll help to clean up the city parks.", listOf(
                UnitDetailSection("📖 单元导读", "志愿精神与社区回馈。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### Phrasal Verbs (动词+副词)
                    - *cheer up, give away, pick up*.
                    - **物理规则**：如果宾语是人称代词 (*it/them*)，必须放在短语 **中间**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### used to do (过去常常) —— 习惯场
                    - 表示过去存在的状态或反复发生的动作。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u3", "Unit 3", "Could you please clean your room?", listOf(
                UnitDetailSection("📖 单元导读", "家务协作与委婉拒绝礼仪。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### borrow vs lend
                    - **borrow (from)**: 借入。
                    - **lend (to)**: 借出。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### Could you please...?
                    - 这里的 *Could* 表达 **礼貌语气**，而非过去式。
                    - 答语：*Yes, sure.* / *No, I can't, because...*
                """.trimIndent())
            )),
            TextbookUnit("g8d_u4", "Unit 4", "Why don't you talk to your parents?", listOf(
                UnitDetailSection("📖 单元导读", "人际压力与心理辅导策略。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 1. 提建议的多种句式
                    - *Why don't you do...?*
                    - *What about doing...?*
                    
                    #### 2. Conjunctions (连词场)
                    - *although* (虽然), *so that* (以便), *until* (直到)。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u5", "Unit 5", "What were you doing when the rainstorm came?", listOf(
                UnitDetailSection("📖 单元导读", "重大瞬间的叙事背景（过去进行时）。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 过去进行时 (Past Continuous)
                    - **物理本质**：过去某个时间点正在发生的动作场景。
                    - **结构**：**was/were + v-ing**。
                    
                    #### when vs while
                    - **when**: 后跟时间点/瞬间动词。
                    - **while**: 后跟时间段/延续性动词。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u6", "Unit 6", "An old man tried to move the mountains.", listOf(
                UnitDetailSection("📖 单元导读", "古代神话的哲学叙事。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 叙事逻辑连词
                    - *as soon as* (一……就); *unless* (除非)。
                    - **主将从现**：在 *as soon as, unless* 等引导的状语从句中用现在时代代替将来。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u7", "Unit 7", "What's the highest mountain in the world?", listOf(
                UnitDetailSection("📖 单元导读", "自然地理极值与世界概况（形容词最高级应用场）。"),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **population [ˌpɒpjuˈleɪʃn]** (人口)
                    - 询问人口：*What is the population of...?*
                    - 表示人口多/少用 **large / small**。
                    
                    #### ② **feet / meter / centimeter**
                    - 长度单位物理对标。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 形容词比较级与最高级 (续)
                    - **数量级差**：*three times as big as* (三倍大)。
                    - **最高级标志**：*the + largest / most beautiful*.
                """.trimIndent())
            )),
            TextbookUnit("g8d_u8", "Unit 8", "Have you read Treasure Island yet?", listOf(
                UnitDetailSection("📖 单元导读", "文学名著与阅读习惯（现在完成时初探）。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **already vs yet**
                    - **already**: 用于肯定句。
                    - **yet**: 用于疑问句/否定句。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 现在完成时 (Present Perfect) I
                    - **结构**：**have/has + done (过去分词)**。
                    - **物理意义**：过去发生的动作对现在造成的影响。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u9", "Unit 9", "Have you ever been to a museum?", listOf(
                UnitDetailSection("📖 单元导读", "旅行经历与打卡地点。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### been to vs gone to
                    - **have been to**: 去过某地（已回来）。
                    - **have gone to**: 去了某地（还没回来）。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### Have you ever...?
                    - 表示“曾经是否做过某事”的询问。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u10", "Unit 10", "I've had this bike for three years.", listOf(
                UnitDetailSection("📖 单元导读", "家乡记忆与旧物情节（现在完成时延续态）。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### since vs for (时间段法则)
                    - **for + 时间段**：*for three years*.
                    - **since + 时间点/从句**：*since 2020 / since I was a child*.
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 延续性动词 vs 瞬间动词
                    - *buy* -> **have had**; *borrow* -> **have kept**.
                    - 在 `since/for` 结构中必须使用 **延续性动词**。
                """.trimIndent())
            )
        )
    )
)
}
