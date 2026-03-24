import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 一般将来时 (Simple Future) ---
new_simple_future = r'''        KnowledgePoint(
            id = "simple_future",
            section = SEC_2,
            title = "一般将来时 (Simple Future)",
            description = """
### 📖 核心概念详解

一般将来时 (Simple Future) 是通往“明天”的窗口，表达将来发生的动作、状态或主观意图。

#### 1. 两大主力：will vs be going to
| 结构 | 核心语义 | 典型语境 |
| :--- | :--- | :--- |
| **will + do** | 纯预测 / 临时决定 / 承诺 | *I will help you.* (临时起意) |
| **be going to + do** | 计划打算 / 明显迹象推测 | *Look at the clouds! It's going to rain.* |

#### 2. There be 句型的将来形态 (中考红线)
*   **正确**：*There will be...* / *There is going to be...*
*   **错误**：*There will have...* (受汉语“将会有”干扰的物理性错误)

#### 3. “进行”表“将来” (地道表达)
位移动词 (*go, come, leave, start, arrive*) 的现在进行时常表示近期已确定的位移计划。
*   *I am leaving for London tonight.* (我已经订好票了)
""".trimIndent(),
            syllabusDetails = listOf(
                "**【语义辨析】** 深度区分 *will* (客观预测/瞬间决定) 与 *be going to* (主观计划/客观迹象) 的语用边界。",
                "**【结构陷阱】** 掌握 *There be* 句型将来时的标准物理构成，严禁使用 *have*。",
                "**【逻辑联动】** 熟练识别“主将从现”原则，掌握 *if, when, as soon as* 从句对主句将来时的逻辑锁定。",
                "**【时间标志】** 掌握 *in + 段时间* (多久之后) 的将来时用法，及其提问词 *How soon*。",
                "**【替代时态】** 理解位移动词用现在进行时表达‘确定、即刻’安排的将来语义。",
                "**【即刻将来】** 掌握 *be about to do* (正要做) 表示即将发生的即刻动作，通常不接具体时间状语。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在进行时", "意图的交叉", "进行时表将来侧重已确定的位移安排，具有更强的“既定性”。"),
                RelatedPoint("一般现在时", "时刻表的硬性", "官方时刻表（飞机、火车）常用一般现在时表达确定的将来。"),
                RelatedPoint("过去将来时", "时轴的后退", "在宾语从句中，若主句为过去式，将来时态物理后退至 *would*。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— What's your plan for the weekend?\n— I ______ my grandparents in the countryside.", listOf("A. visit", "B. visited", "C. am going to visit", "D. have visited"), "C", "**【解析】** 问句提到 *plan*，明确询问打算，用 *be going to*。故选 **C**。", "**【语境】** 计划打算的询问锁定将来时。", "—— 你周末有什么计划？ —— 我打算去乡下看望我的祖父母。"),
                PastExamQuestion("2025", "天津", "There ______ a sports meeting in our school next month.", listOf("A. will have", "B. will be", "C. is going to have", "D. was"), "B", "**【解析】** *There be* 句型将来时。物理上严禁使用 *have*。*next month* 提示将来。故选 **B**。", "**【红线】** *There will have* 是中考物理性错误第一名。", "下个月我们学校将有一场运动会。"),
                PastExamQuestion("2024", "广东", "I ______ you as soon as I ______ the airport tomorrow.", listOf("A. call; reach", "B. will call; reach", "C. call; will reach", "D. will call; will reach"), "B", "**【解析】** *as soon as* 引导时间从句遵循“主将从现”。从句用 *reach*，主句用 *will call*。故选 **B**。", "**【逻辑】** 时态的条件配对。", "明天我一到机场就给你打电话。"),
                PastExamQuestion("2024", "上海", "— How soon ______ the new library be finished?\n— In two months.", listOf("A. does", "B. did", "C. will", "D. has"), "C", "**【解析】** *In + 段时间* 提示将来时，对应提问词 *How soon*。故选 **C**。", "**【标志词】** *In + 段时间* 锁定时态。", "—— 新图书馆多久后能建成？ —— 两个月后。"),
                PastExamQuestion("2023", "江苏南京", "Look at the black clouds! It ______ rain very soon.", listOf("A. will", "B. is going to", "C. rains", "D. was"), "B", "**【解析】** 根据目前的明显客观迹象（黑云）推测必然结果，用 *be going to*。故选 **B**。", "**【迹象推测】** 客观征兆判定。", "看那些黑云！马上就要下雨了。"),
                PastExamQuestion("2022", "湖北武汉", "I ______ for London tonight. Everything is ready.", listOf("A. leave", "B. am leaving", "C. left", "D. will leave"), "B", "**【解析】** 位移动词用现在进行时表示确定的、近期已准备好的安排。故选 **B**。", "**【地道语用】** 强调“一切就绪”。", "我今晚启程去伦敦。一切都准备好了。"),
                PastExamQuestion("2021", "河南", "I hope there ______ more green trees in our city in the future.", listOf("A. will be", "B. are going to have", "C. will have", "D. are"), "A", "**【解析】** 对未来的愿望或预测用 *will be*。*There be* 排除 C。故选 **A**。", "**【愿望】** *hope* 引导的将来预测。", "我希望未来我们城市会有更多绿树。"),
                PastExamQuestion("2020", "安徽", "Don't worry. I ______ you with your math problem after class.", listOf("A. help", "B. will help", "C. helped", "D. have helped"), "B", "**【解析】** 临时决定提供的帮助用 *will*。故选 **B**。", "**【功能】** 承诺与即时决定。", "别担心。下课后我会帮你解决数学题。"),
                PastExamQuestion("2019", "福建", "If it ______ sunny tomorrow, we ______ a picnic.", listOf("A. is; have", "B. will be; have", "C. is; will have", "D. will be; will have"), "C", "**【解析】** “主将从现”经典考法。故选 **C**。", "**【条件句】** 逻辑配对。", "如果明天晴天，我们就去野餐。"),
                PastExamQuestion("2018", "陕西", "The bus ______ in five minutes. Let's hurry up.", listOf("A. comes", "B. come", "C. came", "D. will come"), "A", "**【解析】** 时刻表或即刻发生的确定动作常用一般现在时或进行时。A项最符合时刻表语境。故选 **A**。", "**【语用】** 官方时刻表时态。", "公交车五分钟后到。我们快点。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("In the future, robots will do most of the heavy work for humans. We will have more free time to enjoy our lives. Scientists are going to develop smarter machines. It is going to be an exciting world.", listOf(
                    HighlightedSentence("robots will do", "**【科技预测】** 使用 *will* 表达对宏观、客观未来的预判。"),
                    HighlightedSentence("going to develop", "**【研发计划】** 表达科学家们已经排上日程的意图。")
                ), "人教版 (Go for it!) 八上 Unit 7"),
                TextbookParagraph("Next month, our class is going to have a sports meeting. I am going to join the 100-meter race. I will practice every afternoon after school.", listOf(
                    HighlightedSentence("is going to have", "**【近期安排】** 描述学校已经确定并公布的活动。"),
                    HighlightedSentence("I will practice", "**【个人决心】** 表达说话者当下的决心或意愿。")
                ), "外研版 (New Standard) 七下 Module 10")
            ),
            exampleSentences = listOf(
                ExampleSentence("Wait a minute, I will help you with those heavy bags on the stairs.", "等一下，我来帮你提楼梯上那些沉重的包。", "**【分析】** 说话瞬间产生的、临时的帮助意图。", "基础必会 (Simple)"),
                ExampleSentence("There is going to be a wonderful concert in our school hall tomorrow evening.", "明天晚上我们学校礼堂将有一场精彩的音乐会。", "**【分析】** *There be* 句型的 *be going to* 形态，表示确定的计划。", "中考核心 (Compound)"),
                ExampleSentence("When are you leaving for London to start your new university life?", "你什么时候启程去伦敦开始你的新大学生活？", "**【分析】** 用现在进行时表达已经订好计划的将来位移。", "交际英语 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **There will have**：中考最重灾区，受母语影响极大。\n2. **从句误用 will**：在 *if/when* 从句中顺手写出 *will*。\n3. **计划 vs 迹象**：分不清 *be going to* 的两种驱动力（主观打算与客观证据）。"),
                TeachingNote("【教学金钥】备忘清单", "1. **黑云演示法**：指着窗外模拟 *be going to rain*，建立迹象推测感。\n2. **吸铁石法则**：强调 *will* 后动词必须物理还原为原形。\n3. **时刻表训练**：利用校车、电影票练习一般现在时表将来。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *in + 段时间* 锁定将来时；看到 *There* 划掉 *have*。")
            ),
            famousQuote = "The best way to predict the future is to create it.",
            quoteAuthor = "Peter Drucker",
            quoteTranslation = "预测未来最好的方法就是去创造未来。",
            quoteAnalysis = "本句展示了将来时态在表达主观能动性与改变愿望时的哲学力量。"
        )'''

# --- 2. 现在进行时 (Present Continuous) ---
new_present_continuous = r'''        KnowledgePoint(
            id = "present_continuous",
            section = SEC_2,
            title = "现在进行时 (Present Continuous)",
            description = """
### 📖 核心概念详解

现在进行时 (Present Continuous) 是英语语法的“快门”，用于捕捉正在发生的瞬间。

#### 1. 核心功能场景
1.  **此刻正在进行**：*I am writing a letter now.* (常伴随 *Look!, Listen!, now*)
2.  **现阶段在进行**：*He is studying hard these days.* (此刻不一定在做)
3.  **位移表将来**：*I am leaving for Beijing tonight.* (确定的近期安排)
4.  **情感放大镜**：与 *always* 连用，表达赞扬或反感。*He is always helping others.*

#### 2. 动词 -ing (现在分词) 物理规则
| 类别 | 变化规则 | 经典示例 |
| :--- | :--- | :--- |
| **一般情况** | 直接 **+ing** | *work -> working* |
| **去 e** | 去不发音 e **+ing** | *make -> making, dance -> dancing* |
| **双写** | **重闭单** 结尾双写 **+ing** | *run -> running, swim -> swimming* |
| **ie 变 y** | 变 ie 为 y **+ing** | *die -> dying, lie -> lying* |

#### 3. 句式构成 (be + doing)
*   **构成**：*am/is/are + 动词现在分词*
*   **注意**：*be* 动词必须随主语人称物理切换。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态控制】** 熟练掌握 -ing 的 4 种物理变化，重点处理双写辅音字母（重闭单）的动词名单。",
                "**【雷达词识别】** 养成对 *Look!, Listen!, at the moment* 等感官提示词的瞬时反应直觉。",
                "**【情感表达】** 理解并能运用进行时与 *always, constantly* 连用时产生的极度赞扬或反感情绪。",
                "**【将来语义】** 掌握位移动词用进行时表达‘近期确定的、正在准备中’的将来计划。",
                "**【静态禁区】** 识别不能用于进行时的动词（如 *know, love, want, belong to* 等状态动词）。",
                "**【辨析视角】** 区分一般现在时（侧重习惯）与现在进行时（侧重动态）的本质差异。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般现在时", "常态 vs 动态", "进行时描述波动的瞬间过程，一般时描述平稳的规律习惯。"),
                RelatedPoint("过去进行时", "时轴平移", "逻辑模型完全一致，仅时间参考坐标系从‘现在’切换至‘过去’。"),
                RelatedPoint("现在分词 (Participles)", "非谓语形态", "区分充当谓语的进行时 ing 与充当名/形成分的非谓语 ing。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "天津", "— Listen! Who ______ in the music room?\n— Oh, it's Mary.", listOf("A. sings", "B. is singing", "C. sang", "D. will sing"), "B", "**【解析】** *Listen!* 提示正在发生的动作。故选 **B**。", "**【雷达】** 感官动词提示进行时。", "—— 听！谁在音乐教室唱歌？ —— 噢，是玛丽。"),
                PastExamQuestion("2025", "北京", "Don't make any noise. The baby ______ in the bedroom.", listOf("A. sleep", "B. sleeps", "C. is sleeping", "D. slept"), "C", "**【解析】** “别吵”语境说明动作正在发生。故选 **C**。", "**【语境推断】** 根据上下文暗示判定时态。", "别吵。宝宝正在卧室睡觉。"),
                PastExamQuestion("2024", "广东", "I ______ a book about Chinese history these days. It's interesting.", listOf("A. read", "B. am reading", "C. have read", "D. readed"), "B", "**【解析】** *these days* 提示现阶段一直在做的持续动作。故选 **B**。", "**【注意】** 这不一定代表说话瞬间正在读。", "这些天我正在读一本关于中国历史的书。"),
                PastExamQuestion("2024", "上海", "— Where is your father?\n— He ______ the car in the yard now.", listOf("A. cleans", "B. is cleaning", "C. cleaned", "D. will clean"), "B", "**【解析】** 询问“人在哪”及 *now* 标志，锁定正在进行。故选 **B**。", "**【场景】** 视觉捕捉瞬间。", "—— 你爸爸在哪？ —— 他现在正在院子里洗车。"),
                PastExamQuestion("2023", "江苏南京", "The population of the world ______ faster and faster these years.", listOf("A. grows", "B. is growing", "C. grew", "D. will grow"), "B", "**【解析】** 描述一种具有持续变化趋势的客观现状。故选 **B**。", "**【趋势】** 进行时表动态变化的趋势。", "这些年来世界人口正增长得越来越快。"),
                PastExamQuestion("2022", "四川成都", "He ______ always ______ his keys. He is so careless.", listOf("A. is; losing", "B. does; lose", "C. was; losing", "D. has; lost"), "A", "**【解析】** 进行时与 *always* 连用，表达反感情绪。故选 **A**。", "**【色彩】** 考查进行时的特殊语气功能。", "他总是丢钥匙。他太粗心了。"),
                PastExamQuestion("2021", "河南", "Look! The children ______ happily on the playground.", listOf("A. play", "B. played", "C. are playing", "D. will play"), "C", "**【解析】** *Look!* 捕捉正在进行的瞬间。故选 **C**。", "**【标志】** *Look!* 锁定进行时。", "看！孩子们在操场上玩得很开心。"),
                PastExamQuestion("2020", "安徽", "I ______ for the airport in ten minutes. See you later.", listOf("A. leave", "B. am leaving", "C. left", "D. have left"), "B", "**【解析】** 位移动词用进行时表确定的安排。故选 **B**。", "**【将来语义】** 典型的地道表达。", "我十分钟后启程去机场。回头见。"),
                PastExamQuestion("2019", "福建", "— What ______ you ______?\n— I'm making a model plane.", listOf("A. do; do", "B. are; doing", "C. did; do", "D. will; do"), "B", "**【解析】** 根据答语进行时锁定问句。故选 **B**。", "**【呼应】** 问答时态必须一致。", "—— 你在做什么？ —— 我在做模型飞机。"),
                PastExamQuestion("2018", "山东济南", "Listen! Someone ______ for help in the distance.", listOf("A. cry", "B. cries", "C. is crying", "D. was crying"), "C", "**【解析】** *Listen!* 锁定此时正在发生的动作。故选 **C**。", "**【感官】** 听觉瞬间定位。", "听！远处有人在呼救。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Look! Some students are cleaning the classroom. Zhang Hua is sweeping the floor and Li Ming is cleaning the windows. They are always helping each other.", listOf(
                    HighlightedSentence("are cleaning", "**【快门瞬间】** 由 *Look!* 触发的视觉动作捕捉。"),
                    HighlightedSentence("always helping", "**【肯定赞扬】** 表达对学生互助精神的高度评价。")
                ), "人教版 (Go for it!) 七下 Unit 6"),
                TextbookParagraph("I am studying for my exams these days. I don't have much time for sports. My sister is also preparing for her art show. We are both feeling a bit stressed.", listOf(
                    HighlightedSentence("am studying... these days", "**【阶段重心】** 描述目前生活的核心任务，而非瞬间动作。"),
                    HighlightedSentence("are both feeling", "**【感知主观性】** 描述目前处于的心理状态中。")
                ), "外研版 (New Standard) 八上 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("Are you using your computer at the moment? I need to send an email.", "你现在正在用电脑吗？我需要发封邮件。", "**【分析】** *at the moment* 是进行时的标准物理锚点。", "基础必会 (Simple)"),
                ExampleSentence("The climate is changing rapidly due to the serious pollution on earth.", "由于严重的污染，地球的气候正发生迅速变化。", "**【分析】** 描述一种客观存在的动态演变趋势。", "中考核心 (Simple)"),
                ExampleSentence("Why is he always complaining about his work in front of his friends?", "他为什么总是在朋友面前抱怨他的工作？", "**【分析】** 进行时 + *always* 表示强烈的反感语气。", "高阶语用 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **双写失误**：物理性漏写字母（如 *runing*）。\n2. **be缺失**：受汉语影响写出 *I working*。\n3. **静态动词误用**：试图将 *love, know* 放入进行时。"),
                TeachingNote("【教学金钥】备忘清单", "1. **动作快闪法**：通过闪卡展示动作，要求学生立刻用进行时描述。\n2. **重闭单口诀**：‘重读、闭音节、末尾辅音单，双写 ing 莫记乱。’\n3. **情感对比轴**：对比 *always does* (陈述) 与 *always doing* (带情绪)。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *Look/Listen* 直接锁定进行时；检查 *always* 是否带有个人情绪色彩。")
            ),
            famousQuote = "I am doing my best. That is all I can do.",
            quoteAuthor = "William McKinley",
            quoteTranslation = "我正在竭尽全力。这是我唯一能做的。",
            quoteAnalysis = "展现了进行时在表达当下坚定状态与极致投入时的语用力量。"
        )'''

# --- 3. 过去将来时 (Past Future) ---
new_past_future = r'''        KnowledgePoint(
            id = "past_future",
            section = SEC_2,
            title = "过去将来时 (Past Future)",
            description = """
### 📖 核心概念详解

过去将来时 (Past Future) 立足于过去的某一点，审视在那之后将要发生的动作。

#### 1. 核心应用场景
该时态 90% 以上出现在 **宾语从句** 中。当主句谓语是 *said, told, thought, knew* 等过去式时，从句必须物理性执行“时态后退”。

#### 2. 物理公式 (would + do)
*   **构成 1**：**would + 动词原形** (侧重预测或意愿)
*   **构成 2**：**was/were going to + do** (侧重过去的计划)

#### 3. 间接引语的时间平移
当直接引语转为间接引语时，不仅动词变 *would*，时间状语也要平移：
*   *tomorrow* -> ***the next day***
*   *next week* -> ***the following week***
""".trimIndent(),
            syllabusDetails = listOf(
                "**【逻辑原点】** 深刻理解‘从过去看之后’的视角转换，掌握其作为一般将来时镜像的关系。",
                "**【时态一致性】** 熟练掌握宾语从句中的时态一致性原则，识别主句过去式对从句的锁定作用。",
                "**【形态转换】** 物理性掌握 *would + do* 与 *was/were going to + do* 的形态结构。",
                "**【时间状语】** 掌握间接引语中时间状语的对应平移规则（如 *tomorrow* 变 *the next day*）。",
                "**【愿望推测】** 识别过去未实现的愿望（*I thought you would...*）及叙事中的伏笔逻辑。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般将来时", "时轴镜像", "过去将来时是一般将来时在过去语境下的完美逻辑投影。"),
                RelatedPoint("虚拟语气 (Subjunctive)", "高级衔接", "理解 *would* 的将来属性是掌握虚拟语气（尤其是对现在的虚拟）的物理前提。"),
                RelatedPoint("宾语从句", "天然载体", "宾语从句是过去将来时态展示其“一致性规律”的最核心平台。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "She said she ______ a doctor when she grew up.", listOf("A. will be", "B. would be", "C. is going to be", "D. was"), "B", "**【解析】** 宾语从句时态呼应。主句 *said* 为过去式，从句表达将来的愿望，*will* 物理后退为 *would*。故选 **B**。", "**【注意】** 不要被中文“将要”误导选 A。", "她在日记里说她长大后想当一名医生。"),
                PastExamQuestion("2024", "上海", "I thought you ______ to my birthday party yesterday.", listOf("A. will come", "B. come", "C. would come", "D. had come"), "C", "**【解析】** *thought* 提示过去背景，在那一刻对未来的预期。故选 **C**。", "**【推测】** 过去视角下的结果预判。", "我以为昨天你会来参加我的生日派对。"),
                PastExamQuestion("2023", "广东", "He promised that he ______ late for school again.", listOf("A. won't be", "B. wouldn't be", "C. isn't", "D. wasn't"), "B", "**【解析】** *promised* 为过去式，从句 *won't* 变 *wouldn't*。故选 **B**。", "**【承诺逻辑】** 过去做出的关于未来的保证。", "他保证以后不再上学迟到了。"),
                PastExamQuestion("2022", "江苏南京", "He told me that he ______ his grandparents the next day.", listOf("A. visits", "B. will visit", "C. was going to visit", "D. has visited"), "C", "**【解析】** *the next day* 是间接引语标志，主句 *told* 锁定过去将来。故选 **C**。", "**【标志平移】** 时间状语的暗示功能。", "他告诉我第二天他要去拜访他的祖父母。"),
                PastExamQuestion("2021", "河南", "I knew it ______ rain soon, so I took an umbrella with me.", listOf("A. will", "B. would", "C. rains", "D. has rained"), "B", "**【解析】** *knew* 提示过去，对即将发生事情的预判。故选 **B**。", "**【逻辑一致】** 行为与认知的时态匹配。", "我知道快要下雨了，所以我带了把伞。"),
                PastExamQuestion("2020", "安徽", "The teacher asked if we ______ the science museum next week.", listOf("A. visit", "B. will visit", "C. would visit", "D. visited"), "C", "**【解析】** 宾语从句询问将来的计划，主句 *asked* 决定了后退。故选 **C**。", "**【疑问转述】** 疑问词引导从句的时态法则。", "老师问我们下周是否要去参观科技馆。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When Li Ming left his hometown, he knew he would miss his friends. He promised that he would write to them every week.", listOf(
                    HighlightedSentence("knew he would miss", "**【认知后退】** 描述离开那一刻对未来的预感。"),
                    HighlightedSentence("promised that he would", "**【保证逻辑】** 展示了转述性承诺的标准形态。")
                ), "人教版 (Go for it!) 九年级 Unit 14"),
                TextbookParagraph("I asked her if she would join the competition. She told me that she was going to have a try, although she was nervous.", listOf(
                    HighlightedSentence("asked... would", "**【探询语气】** 将直接疑问句平移至过去视角。"),
                    HighlightedSentence("was going to have", "**【坚定打算】** 描述过去那一刻已成型的意图。")
                ), "外研版 (New Standard) 九下 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("He said he would arrive at the airport at eight the next morning.", "他说他第二天早上八点会到达机场。", "**【分析】** 典型的间接引语时态与时间状语同步平移示例。", "基础必会 (Simple)"),
                ExampleSentence("I knew the plan would succeed if we all worked together as a team.", "我知道如果我们团结一致，计划就会成功。", "**【分析】** 在复合句中展示了层层嵌套的时态一致性。", "中考核心 (Complex)"),
                ExampleSentence("She thought it was going to be a sunny day, but it rained heavily.", "她原以为会是晴天，结果却下了大雨。", "**【分析】** 表达过去未实现的推测，常带转折逻辑。", "高频易错 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **主过从将**：考生常写出 *He said he will...*，忽略时态一致性原则。\n2. **状语断裂**：动词变了 *would* 但时间词忘了变 *the next day*。\n3. **形态多加 to**：在 *would* 后面错误添加 *to*。"),
                TeachingNote("【教学金钥】备忘清单", "1. **时态降级法**：教给学生‘降级’口诀：*is -> was*, *will -> would*, *can -> could*。\n2. **影子法**：将过去将来时描述为一般将来时的‘影子’，影子永远随主人（主句）移动。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到主句是 *said/told/asked*，从句选项中划掉所有现在时和将来时。")
            ),
            famousQuote = "I knew I would be late if I didn't hurry up at that moment.",
            quoteAuthor = "Anonymous",
            quoteTranslation = "我知道如果在那时不赶紧的话，我就会迟到了。",
            quoteAnalysis = "展现了过去将来时在描述紧迫感与逻辑预判中的应用。"
        )'''

# --- 执行替换 ---
pattern_simple_future = re.compile(r'KnowledgePoint\(\s+id = "simple_future",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_present_continuous = re.compile(r'KnowledgePoint\(\s+id = "present_continuous",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_past_future = re.compile(r'KnowledgePoint\(\s+id = "past_future",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_simple_future.sub(lambda _: new_simple_future + ',', content)
content = pattern_present_continuous.sub(lambda _: new_present_continuous + ',', content)
content = pattern_past_future.sub(lambda _: new_past_future + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
