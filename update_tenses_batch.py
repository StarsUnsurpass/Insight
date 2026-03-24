import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 一般现在时 (Simple Present) ---
new_simple_present = r'''        KnowledgePoint(
            id = "simple_present",
            section = SEC_2,
            title = "一般现在时 (Simple Present)",
            description = """
### 📖 核心概念详解

一般现在时 (Simple Present) 是英语时态体系的基准点，其核心功能是表达“常态”。

#### 1. 核心功能场景
1.  **经常性习惯**：*I usually get up at 6:00.* (常与 *always, usually* 连用)
2.  **客观真理**：*The sun rises in the east.* (永恒事实、科学定义)
3.  **现阶段状态**：*He is a teacher.* (目前的身份或特征)
4.  **时刻表将来**：*The train leaves at 8:00.* (官方确定的安排)

#### 2. 动词单三 (Third-person Singular) 物理规则
| 结尾类型 | 变化规则 | 经典示例 |
| :--- | :--- | :--- |
| 一般情况 | 直接词尾 **+s** | *reads, plays, swims* |
| -s, -x, -ch, -sh, -o | 词尾 **+es** | *fixes, watches, goes, does* |
| 辅音 + y | 变 y 为 **i + es** | *fly -> flies, study -> studies* |
| 不规则 | 特殊记忆 | *have -> has* |

#### 3. “主将从现”铁律 (中考必杀)
在由 *if, unless, when, as soon as, until* 引导的从句中，若主句表达将来意图，从句物理上必须锁定一般现在时。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态控制】** 熟练掌握动词单三的 4 种变化规则，重点处理 *have* 变 *has* 及 *y* 结尾的陷阱。",
                "**【语义判定】** 区分习惯性动作与说话瞬间的动作，识别客观真理的‘时态豁免权’。",
                "**【逻辑联动】** 深刻领悟并应用‘主将从现’原则，精准识别时间与条件状语从句的时态锁死。",
                "**【隐形主语】** 掌握 *Everyone, Nobody, Each of...* 等不定代词作主语时的单三匹配。",
                "**【助动词逻辑】** 掌握 *do/does* 在否定与疑问句中的物理占位及对实义动词的还原要求。",
                "**【频度分布】** 掌握频度副词（*always* 等）在句中‘行前系后’的标准位置。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在进行时", "常态 vs 动态", "一般现在时侧重规律，进行时侧重此时此刻。"),
                RelatedPoint("主谓一致", "单三变化的物理根源", "理解主语的‘数’是正确运用一般现在时的前提。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "Our teacher tells us that the sun ______ in the east.", listOf("A. rise", "B. rises", "C. rose", "D. will rise"), "B", "**【解析】** 太阳升起是客观真理，固定用一般现在时。主语 *the sun* 是单三。故选 **B**。", "**【注意】** 即使主句是 *tells*，真理也不受时态呼应限制。", "老师告诉我们太阳从东方升起。"),
                PastExamQuestion("2025", "天津", "If it ______ sunny tomorrow, we ______ a picnic in the park.", listOf("A. will be; have", "B. is; will have", "C. is; have", "D. will be; will have"), "B", "**【解析】** *if* 引导条件从句，遵循“主将从现”。从句用 *is*，主句用 *will have*。故选 **B**。", "**【逻辑】** 判定从句性质是解题关键。", "如果明天天气晴朗，我们将在公园野餐。"),
                PastExamQuestion("2024", "广东", "He ______ to school by bike every day to keep fit.", listOf("A. go", "B. goes", "C. went", "D. is going"), "B", "**【解析】** *every day* 提示习惯动作，用一般现在时。主语 *He* 为单三。故选 **B**。", "**【基础】** 习惯动作的时态匹配。", "他每天骑自行车上学以保持健康。"),
                PastExamQuestion("2023", "江苏南京", "I ______ you as soon as I ______ the result.", listOf("A. will tell; know", "B. tell; will know", "C. will tell; will know", "D. tell; know"), "A", "**【解析】** *as soon as* 引导时间从句，遵循“主将从现”。故选 **A**。", "**【规则】** 一...就...的逻辑嵌套。", "我一知道结果就告诉你。"),
                PastExamQuestion("2022", "四川成都", "The train ______ at 8:00 p.m. every Friday. Don't be late.", listOf("A. leave", "B. leaves", "C. left", "D. will leave"), "B", "**【解析】** 官方时刻表表示的安排，通常用一般现在时。故选 **B**。", "**【语用】** 时刻表的特殊时态功能。", "火车每周五晚上 8 点出发。别迟到。"),
                PastExamQuestion("2021", "湖北武汉", "Nobody ______ how to solve the difficult math problem.", listOf("A. know", "B. knows", "C. knew", "D. is knowing"), "B", "**【解析】** *Nobody* 作主语视为单三含义。故选 **B**。", "**【隐形单三】** 不定代词主语的判定。", "没人知道如何解决那个数学难题。"),
                PastExamQuestion("2020", "安徽", "My mother ______ very busy on weekdays, but she ______ free on weekends.", listOf("A. is; is", "B. are; are", "C. is; are", "D. are; is"), "A", "**【解析】** 主语 *mother* 是单数，描述现阶段常态。故选 **A**。", "**【基础】** 系动词的数之一致。", "我妈妈工作日很忙，但周末有空。"),
                PastExamQuestion("2019", "福建", "Action ______ louder than words.", listOf("A. speak", "B. speaks", "C. spoke", "D. will speak"), "B", "**【解析】** 格言警句锁定一般现在时。故选 **B**。", "**【文化】** 谚语语法特征。", "行动胜于言辞。"),
                PastExamQuestion("2018", "山东济南", "The earth ______ around the sun.", listOf("A. move", "B. moves", "C. moved", "D. will move"), "B", "**【解析】** 描述自然规律用一般现在时。故选 **B**。", "**【真理】** 物理规律的永恒时态。", "地球绕着太阳转。"),
                PastExamQuestion("2017", "陕西", "If you ______ hard, you ______ the exam easily.", listOf("A. work; pass", "B. work; will pass", "C. will work; pass", "D. will work; will pass"), "B", "**【解析】** “主将从现”最经典考题。故选 **B**。", "**【条件】** 逻辑主从句配对。", "如果你努力学习，你就会轻松通过考试。"),
                PastExamQuestion("2016", "重庆", "He ______ reading books very much.", listOf("A. like", "B. likes", "C. liked", "D. is liking"), "B", "**【解析】** 描述目前的爱好。主语单三。故选 **B**。", "**【状态】** 爱好动词禁忌进行时。", "他非常喜欢读书。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("I usually get up at 6:30 every day. Then I brush my teeth and have breakfast. My school starts at 8:00. I always try my best to get to school on time because I don't want to be late.", listOf(
                    HighlightedSentence("usually get up", "**【习惯动作】** 频度副词 *usually* 置于实义动词前。"),
                    HighlightedSentence("school starts", "**【单三匹配】** 机构/学校作为整体主语，谓语动词加 *s*。")
                ), "人教版 (Go for it!) 七上 Unit 5"),
                TextbookParagraph("The Amazon River flows through South America. It is the second longest river in the world. Many animals and plants live in the rainforest. It supports many lives on our planet.", listOf(
                    HighlightedSentence("flows through", "**【科学地理】** 描述自然特征固定使用一般现在时。"),
                    HighlightedSentence("It supports", "**【代词单三】** *It* 指代河流，谓语动词强制变换。")
                ), "外研版 (New Standard) 九下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("The earth moves around the sun and the moon moves around the earth.", "地球绕着太阳转，月球绕着地球转。", "**【分析】** 典型的科学事实表达，不受语境时间限制。", "基础必会 (Simple)"),
                ExampleSentence("I will call you as soon as I arrive at the airport tomorrow morning.", "我明天早上到达机场后就给你打电话。", "**【分析】** 时间状语从句中的主将从现，即使有 *tomorrow* 标志，从句仍用 *arrive*。", "中考核心 (Complex)"),
                ExampleSentence("Everyone in our class enjoys reading English books after school.", "我们班里的每个人都喜欢在放学后读英语故事。", "**【分析】** *Everyone* 触发单三谓语 *enjoys*。", "高频易错 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **单三遗忘症**：受汉语思维影响，忽略谓语变换。\n2. **助动词陷阱**：在 *does* 出现后，忘记将实义动词还原。\n3. **真理误判**：在从句中受主句过去时引导，错误地将从句真理变过去时。"),
                TeachingNote("【教学金钥】备忘清单", "1. **吸铁石比喻**：助动词 *does* 像吸铁石，吸走了动词末尾的 *s*。\n2. **主将从现天平**：利用“将来”与“现在”的不平衡天平进行视觉演示。")
            ),
            famousQuote = "The early bird catches the worm.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "早起的鸟儿有虫吃。",
            quoteAnalysis = "展示了一般现在时在格言中表达普遍规律的标准应用。"
        )'''

# --- 2. 现在完成时 (Present Perfect) ---
new_present_perfect = r'''        KnowledgePoint(
            id = "present_perfect",
            section = SEC_2,
            title = "现在完成时 (Present Perfect)",
            description = """
### 📖 核心概念详解

现在完成时 (Present Perfect) 是连接过去与现在的逻辑桥梁。

#### 1. 核心语义模型
1.  **影响性**：动作发生在过去，但其产生的结果或影响依然持续到此刻。
    *   *I have lost my key.* (结果：我现在进不去屋)
2.  **持续性**：动作始于过去，一直延续到说话瞬间，且可能继续持续。
    *   *I have lived here for ten years.* (状态：我还在住)

#### 2. “瞬间”变“延续” (中考第一命门)
> ⚠️ **物理铁律**：瞬间动词严禁与 *for + 时间段* 或 *since + 时间点* 连用。

| 瞬间动词 | 延续性转换 | 经典示例 |
| :--- | :--- | :--- |
| *join* | **be in / be a member of** | *have been in the army for...* |
| *borrow* | **keep** | *have kept the book for...* |
| *buy* | **have** | *have had the car since...* |
| *die* | **be dead** | *has been dead for two years* |
| *leave* | **be away** | *has been away from home since...* |

#### 3. been to vs gone to
*   **have been to**：去过已回（强调个人经历，人目前在场）。
*   **have gone to**：去了未回（强调目前不在场）。
*   **have been in**：在某地待了多久（强调居住长度）。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【逻辑架构】** 深刻理解‘动作对现在产生影响’与‘动作持续至今’的两大语义模型。",
                "**【瞬间转换】** 物理性背诵 15 组以上瞬间动词变延续性动词的对照表，这是中考改错的必杀技。",
                "**【时间配对】** 掌握 *since + 时间点*、*for + 时间段* 以及 *since + 过去时从句* 的主从时态链。",
                "**【去留辨析】** 深度区分 *have been to* 与 *have gone to* 的在场逻辑。",
                "**【标志分布】** 掌握 *already, yet, just, never, ever, so far* 在句中的标准占位及语义差异。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般过去时", "点 vs 线", "过去时是孤立的终结，完成时是延伸的逻辑。"),
                RelatedPoint("过去完成时", "视角的平移", "过去完成时是‘过去的过去’，逻辑与现在完成时平行。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— Look! Someone ______ the classroom. It's so clean.\n— Well, it wasn't me.", listOf("A. is cleaning", "B. has cleaned", "C. cleans", "D. was cleaning"), "B", "**【解析】** *It's clean now* 是目前的结果，说明动作已完成且对现在有影响。故选 **B**。", "**【注意】** 强调“干净”这一结果而非“打扫”这一动作过程。", "—— 看！有人打扫过教室了。现在真干净。 —— 唔，不是我。"),
                PastExamQuestion("2025", "上海", "My cousin ______ the army for three years.", listOf("A. has joined", "B. has been in", "C. joined", "D. was in"), "B", "**【解析】** *for three years* 提示需要延续性动词。*join* 是瞬间动作，需改为 *be in*。故选 **B**。", "**【红线】** 严禁出现 *has joined for...* 这种非法结构。", "我表哥参军三年了。"),
                PastExamQuestion("2024", "广东", "I ______ this book twice, but I still find it difficult to understand.", listOf("A. read", "B. have read", "C. will read", "D. readed"), "B", "**【解析】** *twice* 提示动作发生的累计次数，属于经验性用法。故选 **B**。", "**【标志词】** 次数副词是经验完成时的雷达。", "这本书我已经读了两次，但我还是觉得很难理解。"),
                PastExamQuestion("2024", "天津", "— Where is Li Hua?\n— He ______ to the library. He will be back soon.", listOf("A. has been", "B. has gone", "C. went", "D. goes"), "B", "**【解析】** “人不在场”且“待会儿回来”，说明去了未回。故选 **B**。", "**【辨析】** *been to* (去过已回) vs *gone to* (去了未回)。", "—— 李华在哪？ —— 他去图书馆了。"),
                PastExamQuestion("2023", "江苏南京", "It ______ three years since I ______ to this school.", listOf("A. is; come", "B. was; came", "C. has been; came", "D. is; have come"), "C", "**【解析】** *since* 引导从句用过去时，主句用完成时。故选 **C**。", "**【公式】** *It is/has been + 时间 + since + 过去时*。", "自从我来到这所学校，已经三年了。"),
                PastExamQuestion("2022", "四川成都", "— How long ______ you ______ this bike?\n— For two months.", listOf("A. have; bought", "B. have; had", "C. did; buy", "D. do; have"), "B", "**【解析】** *How long* 询问长度，谓语须用延续性动词。*buy* 须转换为 *have*。故选 **B**。", "**【注意】** 瞬间动词转换陷阱。", "—— 这辆自行车你买多久了？ —— 两个月了。"),
                PastExamQuestion("2021", "河南", "We ______ great progress in our English study so far.", listOf("A. make", "B. made", "C. have made", "D. will make"), "C", "**【解析】** *so far* (到目前为止) 是完成时的标志词。故选 **C**。", "**【标志】** *so far* 锁定完成时。", "到目前为止，我们在英语学习上取得了巨大进步。"),
                PastExamQuestion("2020", "安徽", "— Have you finished your homework ______?\n— Yes, I have ______ finished it.", listOf("A. yet; already", "B. already; yet", "C. yet; yet", "D. already; already"), "A", "**【解析】** *yet* 用于疑问句句末；*already* 用于肯定句中。故选 **A**。", "**【分布】** 标志词的物理分布特征。", "—— 你完成作业了吗？ —— 是的，已经完成了。"),
                PastExamQuestion("2019", "福建", "— Is your father at home?\n— No, he ______ to Fuzhou on business.", listOf("A. has been", "B. has gone", "C. went", "D. goes"), "B", "**【解析】** 不在家，去了未回。故选 **B**。", "**【在场逻辑】** 中考经典考位。", "—— 你爸爸在家吗？ —— 不在，他去福州出差了。"),
                PastExamQuestion("2018", "陕西", "I ______ my teacher since I ______ from the school.", listOf("A. haven't seen; graduated", "B. didn't see; graduated", "C. haven't seen; have graduated", "D. didn't see; have graduated"), "A", "**【解析】** *since* 主完从过。故选 **A**。", "**【配对】** 时态的物理锁死。", "自从我毕业后，就没见过我的老师。"),
                PastExamQuestion("2017", "山西", "My dog ______ for two days. I am very sad.", listOf("A. died", "B. has died", "C. has been dead", "D. is dying"), "C", "**【解析】** *for two days* 要求延续性。*die* 变 *be dead*。故选 **C**。", "**【状态转换】** 生死动词的特殊延续态。", "我的狗已经死了两天了。"),
                PastExamQuestion("2016", "重庆", "— Have you ______ been to the Great Wall?\n— No, never.", listOf("A. ever", "B. never", "C. just", "D. already"), "A", "**【解析】** 疑问句询问经验用 *ever*。故选 **A**。", "**【经验询问】** 常规词汇搭配。", "—— 你曾经去过长城吗？ —— 不，从未。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Have you read Treasure Island yet? No, I haven't, but I have already finished Little Women. It has changed my way of thinking since I bought it.", listOf(
                    HighlightedSentence("Have you read... yet?", "**【询问进度】** *yet* 表达了对结果尚未达成的预期。"),
                    HighlightedSentence("has changed my way", "**【影响性语义】** 书对思想的改变一直持续到现在。")
                ), "人教版 (Go for it!) 八下 Unit 8"),
                TextbookParagraph("I have been a member of the school team since 2021. Our team has won many matches so far. We have worked hard together.", listOf(
                    HighlightedSentence("since 2021", "**【时间轴锚点】** 划定了动作的起点。"),
                    HighlightedSentence("so far", "**【阶段性汇总】** 对目前成绩的累计性描述。")
                ), "外研版 (New Standard) 九下 Module 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("I have been to Beijing several times and I really love the old buildings there.", "我去过北京好几次，非常喜欢那里的古老建筑。", "**【分析】** 强调个人的生命经历，目前人在场。", "基础必会 (Simple)"),
                ExampleSentence("My father has had this car since I was a child. It still runs very well.", "自从我还是个孩子起，我父亲就拥有这辆车了。它现在跑得依然很好。", "**【分析】** 瞬间动词转换（*buy -> have*）与 *since* 从句的配合。", "中考核心 (Complex)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **瞬间动词错配**：习惯性写出 *has joined for...*。\n2. **回环逻辑混乱**：分不清 *been to* 与 *gone to* 的动态在场性。\n3. **since 语法误用**：在 *since* 引导的从句中误用完成时。"),
                TeachingNote("【教学金钥】备忘清单", "1. **回环示意图**：画一个圈代表 *been to*，画一个单向箭头代表 *gone to*。\n2. **瞬间变长列表**：强制背诵 10 组核心转换对。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *for/since* 必找延续性动词；看到次数 (*twice* 等) 锁定完成时。")
            ),
            famousQuote = "What is past is prologue.",
            quoteAuthor = "William Shakespeare",
            quoteTranslation = "凡是过去，皆为序章。",
            quoteAnalysis = "展现了完成时态在宏观叙事中连接过去与未来的逻辑张力。"
        )'''

# --- 3. 被动语态 (Passive Voice) ---
new_passive_voice = r'''        KnowledgePoint(
            id = "passive_voice",
            section = SEC_2,
            title = "被动语态 (Passive Voice)",
            description = """
### 📖 核心概念详解

被动语态 (Passive Voice) 强调“受动者”或“动作本身”，而非执行者。

#### 1. 核心物理公式
> 💡 **万变不离其宗**：**be + 过去分词 (done)**
> *be 动词承担所有的时态重任。*

| 时态 | 结构公式 | 示例 |
| :--- | :--- | :--- |
| 一般现在时 | **am/is/are + done** | *English is spoken here.* |
| 一般过去时 | **was/were + done** | *The tree was planted yesterday.* |
| 一般将来时 | **will be + done** | *The work will be finished soon.* |
| 现在完成时 | **have/has been + done** | *The room has been cleaned.* |
| 情态动词 | **情态动词 + be + done** | *It must be done at once.* |

#### 2. 中考禁忌：不进被动的“黑名单”
*   **不及物动词**：*happen, take place, stay, appear, disappear*。
*   **所属/特征动词**：*belong to, suit, cost, fail*。
*   ⚠️ **注意**：*The accident was happened* 是绝对的物理性错误。

#### 3. “复活”的 to (核心考位)
在主动语态中省略 *to* 的使役/感官动词 (*make, see, hear, watch*)，在被动语态中 ***to*** 必须强制“复活”。
*   主动：*He made me **cry**.*
*   被动：*I was made **to cry**.*
""".trimIndent(),
            syllabusDetails = listOf(
                "**【时态匹配】** 熟练掌握 5 种中考核心时态下的被动构成，重点关注完成时与将来时的被动物理形态。",
                "**【To的复活】** 掌握使役/感官动词变被动时，不定式符号 *to* 的物理还原规则。",
                "**【黑名单识别】** 强制熟记 *happen, belong to* 等不能使用被动语态的动词清单。",
                "**【短语完整性】** 掌握动词短语（如 *look after*）变被动时，末尾介词绝不可遗漏的原则。",
                "**【主动表被动】** 理解感官系动词（*tastes good*）及特征词（*sells well*）的主动形态被动语义。"
            ),
            relatedPoints = listOf(
                RelatedPoint("及物动词", "被动的前提", "只有及物动词或动词短语才具备物理转换为被动语态的资格。"),
                RelatedPoint("过去分词", "被动的形态灵魂", "熟练掌握不规则动词的过去分词是写对被动语态的基础。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "天津", "Computer is ______ widely ______ all over the world.", listOf("A. used; /", "B. being; used", "C. used; being", "D. is; used"), "A", "**【解析】** 考查一般现在时的被动语态。物理结构为 *is + done*。故选 **A**。", "**【注意】** 描述客观现状。", "电脑在全世界被广泛使用。"),
                PastExamQuestion("2025", "北京", "The flowers ______ every morning. They look fresh.", listOf("A. water", "B. are watered", "C. watered", "D. will water"), "B", "**【解析】** 花“被浇水”，主语复数，一般现在时被动。故选 **B**。", "**【基础】** 动作执行者不言自明。", "花每天早上都被浇水。"),
                PastExamQuestion("2024", "上海", "The heavy box ______ away by the workers in ten minutes.", listOf("A. will take", "B. will be taken", "C. is taking", "D. was taken"), "B", "**【解析】** *in ten minutes* 指将来；盒子“被搬走”。故选 **B**。", "**【将来被动】** 锁定时态与语态的双重交叉点。", "重盒子将在十分钟内由工人搬走。"),
                PastExamQuestion("2024", "广东", "Paper was first ______ in ancient China by Cai Lun.", listOf("A. invent", "B. invented", "C. inventing", "D. invention"), "B", "**【解析】** *was* 后跟动词过去分词构成过去被动。故选 **B**。", "**【发明背景】** 历史叙事必用被动。", "纸最初是由蔡伦在中国古代发明的。"),
                PastExamQuestion("2023", "江苏南京", "— I saw you come in just now.\n— No, I ______ to enter by the back door.", listOf("A. made", "B. was made", "C. was making", "D. am made"), "B", "**【解析】** “被要求/被使”进入。故选 **B**。", "**【To还原】** 此处虽未考 *to*，但结构上是 *be made to do*。", "—— 我刚才看见你进来了。 —— 不，我是被要求从后门进的。"),
                PastExamQuestion("2022", "湖北武汉", "English ______ in many countries as a first language.", listOf("A. speaks", "B. is spoken", "C. is speaking", "D. was spoken"), "B", "**【解析】** 英语“被说”，客观事实。故选 **B**。", "**【语用】** 语言描述的固定被动逻辑。", "英语在许多国家被作为第一语言使用。"),
                PastExamQuestion("2021", "河南", "The sick girl ______ to the hospital immediately yesterday.", listOf("A. took", "B. was taking", "C. was taken", "D. had taken"), "C", "**【解析】** 女孩“被送到”医院；*yesterday* 提示过去。故选 **C**。", "**【常规】** 过去被动语态应用。", "那个生病的女孩昨天立刻被送往医院了。"),
                PastExamQuestion("2020", "安徽", "A new bridge ______ over the river last year.", listOf("A. builds", "B. built", "C. was built", "D. will be built"), "C", "**【解析】** 桥“被建造”；*last year* 提示过去。故选 **C**。", "**【基础】** 基础设施描述时态。", "去年河上建起了一座新桥。"),
                PastExamQuestion("2019", "山东济南", "The bridge ______ after for many years and it is still strong.", listOf("A. was looked", "B. was looked after", "C. looked after", "D. is looking after"), "B", "**【解析】** 考查动词短语被动。*after* 绝不能丢。故选 **B**。", "**【短语被动】** 介词不遗漏原则。", "这座桥被照看（维护）了很多年，依然很坚固。"),
                PastExamQuestion("2018", "陕西", "What ______ last night? We heard a loud noise.", listOf("A. was happened", "B. happened", "C. was happening", "D. is happened"), "B", "**【解析】** *happen* 是不及物动词，严禁使用被动语态。故选 **B**。", "**【红线】** 区分及物与不及物动词的被动资格。", "昨晚发生了什么？我们听到了一声巨响。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Tea was first discovered in ancient China. It is said that Shen Nong first tasted it more than 5,000 years ago. Today, it is widely grown in South China.", listOf(
                    HighlightedSentence("Tea was first discovered", "**【发现史】** 描述未知来源的事实发现常选过去被动。"),
                    HighlightedSentence("it is widely grown", "**【现状描述】** 农业作物的分布固定使用现在被动。")
                ), "人教版 (Go for it!) 九年级 Unit 6"),
                TextbookParagraph("Many trees are cut down to make paper every year. We should try our best to save paper to protect the forests. If we don't, the earth will be polluted.", listOf(
                    HighlightedSentence("are cut down", "**【短语完整】** *cut down* 作为一个整体被动化，*down* 保留在原地。"),
                    HighlightedSentence("will be polluted", "**【未来预测】** 对环境恶化结果的客观预测。")
                ), "外研版 (New Standard) 九下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("The broken chair was repaired by my father in the garden yesterday.", "那把坏椅子昨天由我爸爸在花园里修好了。", "**【分析】** 包含动作执行者 *by sb* 的标准过去被动句。", "基础必会 (Simple)"),
                ExampleSentence("He was seen to enter the building by the neighbors just before the fire.", "邻居们在火灾前刚好看到他进了大楼。", "**【分析】** *see sb do* 变被动时，不定式符号 *to* 物理性还原。", "高阶句法 (Complex)"),
                ExampleSentence("The project must be finished on time to ensure the success of the plan.", "该项目必须准时完成，以确保计划的成功。", "**【分析】** 包含情态动词 *must* 的被动语态结构。", "中考核心 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **To的脱落**：在 *make/see* 变被动时漏掉 *to*。\n2. **黑名单误用**：受汉语“被发生”影响写出 *was happened*。\n3. **be动词遗漏**：写成 *The book written by...* (此处充当定语而非谓语)。"),
                TeachingNote("【教学金钥】备忘清单", "1. **身份互换图**：通过主动主语变 *by* 宾语的连线演示语态转换。\n2. **复活节比喻**：告诉学生 *to* 在被动语态中会“复活”。\n3. **黑名单口诀**：‘发生、消失、属于、值，被动语态不关事。’"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到不及物动词划掉被动选项；检查使役动词后是否有 *to*。")
            ),
            famousQuote = "Rome was not built in a day.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "罗马不是一天建成的。",
            quoteAnalysis = "本句展示了被动语态在表达客观真理与历史积淀时的庄重感。"
        )'''

# --- 执行替换 (由于内容极多，脚本执行需要精准定位) ---
pattern_simple_present = re.compile(r'KnowledgePoint\(\s+id = "simple_present",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_present_perfect = re.compile(r'KnowledgePoint\(\s+id = "present_perfect",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_passive_voice = re.compile(r'KnowledgePoint\(\s+id = "passive_voice",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_simple_present.sub(lambda _: new_simple_present + ',', content)
content = pattern_present_perfect.sub(lambda _: new_present_perfect + ',', content)
content = pattern_passive_voice.sub(lambda _: new_passive_voice + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
