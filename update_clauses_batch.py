import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 宾语从句 (Object Clause) ---
new_object_clause = r'''        KnowledgePoint(
            id = "object_clause",
            section = SEC_3,
            title = "宾语从句 (Object Clause)",
            description = """
### 📖 核心概念详解

宾语从句是中考句法的“皇冠”，综合考查连接词、语序和时态。

#### 1. 连接词的“精准打击”
| 原句类型 | 引导词 | 语义 / 注意 |
| :--- | :--- | :--- |
| **陈述句** | *that* | 无义，口语中常省 |
| **一般疑问句** | *if / whether* | 意为“是否” |
| **特殊疑问句** | *原疑问词 (what, how...)* | 保留原义 |

#### 2. 语序的“拆弹”逻辑 (核心考位)
> ⚠️ **强制陈述化**：无论原句如何，入从句后必须物理还原为 **“主语 + 谓语”**。
> *   *Does he live here?* -> *...if **he lives** here.* (拆除助动词，还原谓语)

#### 3. 时态的“步调一致”与“豁免权”
1.  **主现从随意**：主句是一般现在时，从句根据实际情况选时态。
2.  **主过从必过**：主句是一般过去时，从句强制物理后退一级。
3.  **真理豁免权**：若从句是客观真理，时态恒定锁定 **一般现在时**。
    *   *Teacher told us the earth **moves** around the sun.*
""".trimIndent(),
            syllabusDetails = listOf(
                "**【三要素锁定】** 熟练掌握连接词选择、陈述语序平移、时态呼应一致性的综合应用法则。",
                "**【语序转换】** 掌握从疑问句到从句的“去助动词”物理逻辑，确保主谓关系正确。",
                "**【时态呼应】** 深刻理解宾从中的时态后退原则，重点攻克客观真理、科学事实的‘例外’场景。",
                "**【whether抉择】** 掌握 *whether...or not*、介词后、引导词前置等必须用 *whether* 的硬性语境。",
                "**【否定转移】** 掌握 *I think... not...* 结构的否定语义前移物理规则。",
                "**【结构简化】** 掌握‘疑问词 + 不定式’对宾语从句的极致简化转换。"
            ),
            relatedPoints = listOf(
                RelatedPoint("简单句基本句型", "成分的实质填充", "宾语从句在宏观上实质上是填充了宾语这一物理单元。"),
                RelatedPoint("一般现在时", "真理的永恒性", "客观真理在宾从中的表现是时态板块的高阶考点。"),
                RelatedPoint("动词基础", "主句动词的牵引力", "只有及物动词或特定动词短语后才能挂载宾语从句。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— Could you please tell me ______ in the city center?\n— Of course. Just walk along this street.", listOf("A. where is the museum", "B. where the museum is", "C. how can I get to the museum", "D. how I can get to the museum"), "B", "**【解析】** 宾语从句强制使用陈述语序（主语在前，谓语在后）。A/C 均为疑问语序。故选 **B**。", "**【注意】** *Could you...* 只是礼貌用语，主句实质仍为现在时，语序是核心考点。", "—— 你能告诉我市中心博物馆在哪里吗？ —— 当然。沿着这条街走。"),
                PastExamQuestion("2025", "天津", "The teacher told us that the earth ______ around the sun.", listOf("A. move", "B. moves", "C. moved", "D. was moving"), "B", "**【解析】** 客观真理永远使用一般现在时，即使主句是过去式。故选 **B**。", "**【真理豁免】** 时态一致性的唯一法外之地。", "老师告诉我们地球绕着太阳转。"),
                PastExamQuestion("2024", "广东", "I wonder ______ she will come to the party or not.", listOf("A. if", "B. that", "C. whether", "D. what"), "C", "**【解析】** 句末有 *or not*，引导词物理锁定 *whether*。故选 **C**。", "**【红线】** *or not* 紧跟或语义关联时首选 *whether*。", "我想知道她是否会来参加聚会。"),
                PastExamQuestion("2024", "上海", "— Do you know ______?\n— He is an engineer.", listOf("A. what does he do", "B. what he does", "C. where does he work", "D. where he works"), "B", "**【解析】** 根据答语“他是工程师”确定询问职业。从句用陈述语序。故选 **B**。", "**【综合】** 语序与语境的双重考查。", "—— 你知道他是做什么的吗？ —— 他是个工程师。"),
                PastExamQuestion("2023", "江苏南京", "— I want to know ______.\n— Sorry, I didn't see him just now.", listOf("A. where is Li Ming", "B. where was Li Ming", "C. where Li Ming is", "D. where Li Ming was"), "D", "**【解析】** 宾从陈述语序排除 A/B。根据答语 *didn't see* 及 *just now* 锁定过去时态。故选 **D**。", "**【语境时态】** 结合上下文判断从句发生的具体时间。", "—— 我想知道李明在哪。 —— 对不起，我刚才没看到他。"),
                PastExamQuestion("2022", "湖北武汉", "Could you tell me ______ to buy this beautiful bike?", listOf("A. where you bought", "B. where did you buy", "C. where did you bought", "D. where you buy"), "A", "**【解析】** 询问过去的动作，用过去时且陈述语序。故选 **A**。", "**【还原】** 拆除助动词 *did* 后动词变为过去式形态。", "你能告诉我你在哪儿买的这辆漂亮的自行车吗？"),
                PastExamQuestion("2021", "河南", "I don't know ______ the train will leave tomorrow.", listOf("A. what time", "B. that", "C. if", "D. why"), "A", "**【解析】** 根据语义“不知道火车几点出发”。故选 **A**。", "**【连接词】** 逻辑语义的精准匹配。", "我不知道明天火车几点出发。"),
                PastExamQuestion("2020", "安徽", "Our teacher asked us ______ we had finished our homework.", listOf("A. that", "B. if", "C. what", "D. which"), "B", "**【解析】** 询问“是否完成”，引导一般疑问句变体的宾从。故选 **B**。", "**【功能】** 掌握 *if* 作为宾从引导词的地位。", "老师问我们是否完成了作业。"),
                PastExamQuestion("2019", "福建", "I think ______ he will be a successful doctor in the future.", listOf("A. that", "B. if", "C. whether", "D. /"), "A", "**【解析】** 引导陈述意义的宾从，*that* 可省略。故选 **A**。", "**【基础】** 最常规的宾从引导。", "我认为他未来会成为一名成功的医生。"),
                PastExamQuestion("2018", "陕西", "Could you tell me how ______ to the airport?", listOf("A. can I get", "B. I can get", "C. did I get", "D. I got"), "B", "**【解析】** 询问方式，陈述语序。故选 **B**。", "**【礼貌语】** *Could you* 不影响从句语序。", "你能告诉我怎么去机场吗？"),
                PastExamQuestion("2017", "山西", "I want to know ______ will win the match.", listOf("A. that", "B. who", "C. whether", "D. if"), "B", "**【解析】** 询问“谁”，*who* 在从句中作主语。故选 **B**。", "**【成分】** 引导词在从句中充当主语时，语序本身就是陈述的。", "我想知道谁会赢得比赛。"),
                PastExamQuestion("2016", "重庆", "He said he ______ to Beijing the next month.", listOf("A. goes", "B. will go", "C. would go", "D. has gone"), "C", "**【解析】** 宾从时态呼应。主句 *said* 为过去时，从句 *next month* 提示将来。物理后退为 *would go*。故选 **C**。", "**【一致性】** 时态链条的传导。", "他说他下个月要去北京。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Many people wonder how the Great Wall was built without modern machines. Our teacher told us that it took millions of workers to complete it.", listOf(
                    HighlightedSentence("wonder how the Great Wall was built", "**【语序演示】** 特殊疑问句性质的从句，采用陈述语序。"),
                    HighlightedSentence("told us that it took", "**【时态传导】** 展示了主句过去时对从句历史动作的影响。")
                ), "人教版 (Go for it!) 九年级 Unit 6"),
                TextbookParagraph("I asked her if she would join the competition. She told me she was going to have a try, although she was nervous.", listOf(
                    HighlightedSentence("asked... if she would", "**【逻辑后退】** 询问将来的打算，受主句 *asked* 驱动变 *would*。"),
                    HighlightedSentence("told me she was", "**【that省略】** 在口语化叙事中，*that* 通常被物理性撤销。")
                ), "外研版 (New Standard) 九下 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("Do you know what time the school library opens on Saturdays?", "你知道学校图书馆周六几点开门吗？", "**【分析】** 重点在于语序必须物理还原为 *the library opens*。", "基础必会 (Simple)"),
                ExampleSentence("He asked me where I had been during the heavy rainstorm last night.", "他问我昨晚那场大雨期间去哪儿了。", "**【分析】** 包含了时态后退（过去完成时）与陈述语序的综合句式。", "中考核心 (Complex)"),
                ExampleSentence("I believe that everyone can realize their dreams through hard work.", "我相信每个人都能通过努力实现梦想。", "**【分析】** 最基础的陈述性宾从，用于表达坚定的信念。", "基础必会 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **语序习惯**：受汉语或原疑问句影响，死守疑问语序不放。\n2. **时态僵化**：在客观真理场景下依然执行时态呼应，导致语义偏差。\n3. **whether盲点**：分不清 *if* 与 *whether* 的物理界限。"),
                TeachingNote("【教学金钥】备忘清单", "1. **拆弹公式**：连接词 + 主语 + 谓语。要求学生先写主谓，再补连接词。\n2. **真理红线图**：画一条不动的横线代表真理时态，不随主句变化。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到问句结尾没问号，选项中先划掉疑问语序；看到 *said/told* 找过去范畴的时态。")
            ),
            famousQuote = "I know that I know nothing.",
            quoteAuthor = "Socrates",
            quoteTranslation = "我唯一知道的，就是我一无所知。",
            quoteAnalysis = "本句展示了宾语从句在表达认知局限与哲学思辨时的简洁结构。"
        )'''

# --- 2. 定语从句 (Attributive Clause) ---
new_attributive_clause = r'''        KnowledgePoint(
            id = "attributive_clause",
            section = SEC_3,
            title = "定语从句 (Attributive Clause)",
            description = """
### 📖 核心概念详解

定语从句为名词进行“深度画像”。当简单形容词不足以刻画时，就需要出动定语从句。

#### 1. 关系词的物理选择
| 先行词属性 | 充当成分 | 关系代词 |
| :--- | :--- | :--- |
| **人** | 主语 / 宾语 | *who / that* |
| **物** | 主语 / 宾语 | *which / that* |
| **人或物** | 宾语 (可省) | */ (省略)* |
| **所属关系** | 定语 (某人的) | *whose* |

#### 2. 只能用 that 的霸权场景 (中考硬核)
在以下物理语境中，*which* 必须物理性让位于 ***that***：
1. 先行词被 *the only, the last, the very* 修饰。
2. 先行词是不定代词 (*all, anything, nothing*)。
3. 先行词受形容词最高级或序数词修饰。
4. 先行词既有人又有物。

#### 3. 关系词省略法则
当关系词在从句中充当 **宾语** 时，可以被物理性抹除（选‘/’）。
*   *This is the gift (that) I bought.*
""".trimIndent(),
            syllabusDetails = listOf(
                "**【配对逻辑】** 深刻理解先行词（人/物）与关系词（who/which/that）的逻辑对应关系。",
                "**【成分判定】** 熟练判定关系词在从句中充当主语还是宾语，以决定是否可以物理省略。",
                "**【that特权】** 物理性背诵 6 大只能使用 *that* 的典型中考场景清单。",
                "**【whose用法】** 掌握 *whose* 表达所属关系的独特句法功能（指人或指物）。",
                "**【主谓一致】** 掌握关系词充当主语时，谓语动词物理性随先行词变单复数的原则。",
                "**【介词位置】** 识别“介词 + 关系代词”结构中的关系词选择限制（通常禁 that）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词 (Nouns)", "先行词的本质", "先行词的生命属性与数直接决定了关系词的选择。"),
                RelatedPoint("形容词", "定语的职能延伸", "定语从句实质上是一个具有动态叙述能力的复合形容词单元。"),
                RelatedPoint("主谓一致", "从句内的权力传导", "关系词作为主语时，其数的形式物理来源于先行词。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "天津", "The boy ______ is wearing a blue jacket is my brother.", listOf("A. who", "B. which", "C. whose", "D. /"), "A", "**【解析】** 先行词 *boy* 是人，从句缺主语。故选 **A**。", "**【基础】** 关系代词人称属性判定。", "那个穿着蓝色夹克的男孩是我弟弟。"),
                PastExamQuestion("2025", "北京", "This is the most interesting book ______ I have ever read.", listOf("A. which", "B. that", "C. who", "D. /"), "B", "**【解析】** 先行词 *book* 受最高级 *the most interesting* 修饰，只能用 *that*。故选 **B**。", "**【霸权场景】** 物理限制 *which* 的典型语境。", "这是我读过的最有趣的书。"),
                PastExamQuestion("2024", "广东", "Do you know the girl ______ mother is a famous writer?", listOf("A. who", "B. which", "C. whose", "D. whom"), "C", "**【解析】** “那个女孩的妈妈”。表示所属关系。故选 **C**。", "**【关系】** *whose* 在句中充当定语，修饰 *mother*。", "你认识那个妈妈是著名作家的女孩吗？"),
                PastExamQuestion("2024", "上海", "I like music ______ I can dance to.", listOf("A. who", "B. whose", "C. that", "D. /"), "C", "**【解析】** 先行词 *music* 是物，宾语可填 *that* 或 *which*。故选 **C**。", "**【宾语成分】** *that* 指代音乐并在从句中作介词宾语。", "我喜欢能跟着跳舞的音乐。"),
                PastExamQuestion("2023", "江苏南京", "The building ______ stands near the river is a library.", listOf("A. who", "B. which", "C. whose", "D. /"), "B", "**【解析】** 先行词是物，充当主语。故选 **B**。", "**【不可省略】** 作主语时关系词严禁物理抹除。", "那栋位于河边的建筑是个图书馆。"),
                PastExamQuestion("2022", "湖北武汉", "This is the only thing ______ I can do for you now.", listOf("A. that", "B. which", "C. who", "D. whose"), "A", "**【解析】** 先行词受 *the only* 修饰。故选 **A**。", "**【限定性】** 唯一性修饰锁定 *that*。", "这是我现在唯一能为你做的事。"),
                PastExamQuestion("2021", "河南", "He is the person ______ helped me solve the problem.", listOf("A. whom", "B. who", "C. which", "D. whose"), "B", "**【解析】** 先行词是人，主语。故选 **B**。", "**【形态】** *who* 充当主语的标准用法。", "他就是帮我解决问题的那个。"),
                PastExamQuestion("2020", "安徽", "I'll never forget the days ______ we spent together.", listOf("A. when", "B. which", "C. where", "D. who"), "B", "**【解析】** 先行词 *days* 虽然是时间，但在从句中作 *spent* 的宾语（物）。故选 **B**。", "**【逻辑陷阱】** 不要看到时间词就盲选 *when*，需看成分。", "我永远不会忘记我们一起度过的那些日子。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("I like music that I can dance to. My sister prefers songs that have lyrics. We enjoy visiting concerts which are held in the park.", listOf(
                    HighlightedSentence("music that I can dance to", "**【宾语关系词】** *that* 指代音乐并在从句中担任介词宾语。"),
                    HighlightedSentence("concerts which are held", "**【主语一致】** *which* 代表复数 *concerts*，故谓语动词锁定 *are*。")
                ), "人教版 (Go for it!) 九年级 Unit 9"),
                TextbookParagraph("People who are friendly are popular. In our class, Zhang Lei is the one who helps others. He is a person that we can depend on.", listOf(
                    HighlightedSentence("People who are friendly", "**【主语代词】** 展示了对人类群体进行宏观描述的句法标准。"),
                    HighlightedSentence("person that we can depend on", "**【关系词功能】** *that* 引导从句并作为介词 *on* 的逻辑承受者。")
                ), "外研版 (New Standard) 九下 Module 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("He is the only student that can solve the hard math problem.", "他是班上唯一能解开那道数学难题的学生。", "**【分析】** 先行词受 *the only* 限定，物理性锁定关系词为 *that*。", "中考核心 (Complex)"),
                ExampleSentence("The modern city where I was born has changed a lot these years.", "我出生的那个现代化城市这些年来变化很大。", "**【分析】** 使用关系副词 *where* 替代介词短语地点状语。", "基础必会 (Simple)"),
                ExampleSentence("This is the bag (which) my father bought for me last week.", "这就是我爸爸上周给我买的那个包。", "**【分析】** 关系词充当宾语，物理上可以隐身省略。", "基础必会 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **盲选when/where**：习惯性看到时间地点就选副词，忽略了其在从句中是否充当主谓宾。\n2. **that霸权遗忘**：在最高级或不定代词场景下仍坚持用 *which*。\n3. **whose缺失**：无法在所属关系语境中识别出 *whose* 的物理占位。"),
                TeachingNote("【教学金钥】备忘清单", "1. **先行词X光机**：训练学生第一眼扫描先行词的“生命”与“限定”属性。\n2. **成分补位法**：将从句还原为独立句，看先行词回填后担任什么成分，以此反推关系词。\n3. **that 专属清单口诀**：‘最高序数不定代，唯一人加物，that 必登台。’"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到最高级/序数词锁定 *that*；看到 *whose* 检查后面是否有名词；作宾语关系词可隐身。")
            ),
            famousQuote = "He who has a why to live for can bear almost any how.",
            quoteAuthor = "Friedrich Nietzsche",
            quoteTranslation = "知道为什么而活的人，便能生存。",
            quoteAnalysis = "展现了定语从句在定义个体生命哲学与驱动力时的逻辑力量。"
        )'''

# --- 3. 状语从句 (Adverbial Clause) ---
new_adverbial_clause = r'''        KnowledgePoint(
            id = "adverbial_clause",
            section = SEC_3,
            title = "状语从句 (Adverbial Clause)",
            description = """
### 📖 核心概念详解

状语从句是句子的“环境说明书”，提供背景、原因及条件。

#### 1. 九大分类中考高频项
| 类别 | 引导词 | 物理规则 / 时态 |
| :--- | :--- | :--- |
| **时间** | *when, while, as soon as* | **主将从现** |
| **条件** | *if, unless* (除非) | **主将从现** |
| **原因** | *because, since, as* | **AL/SO 互斥** |
| **让步** | *although, though* | **AL/BUT 互斥** |
| **结果** | *so...that / such...that* | 形容词 vs 名词 |

#### 2. “主将从现”铁律 (绝杀考位)
在时间、条件状语从句中，若主句表达“将来”含义，从句物理上必须退回 **一般现在时**。
*   *I **will** call you if I **get** there.*

#### 3. until 的延续性博弈
1. **肯定句**：接延续性动词。*Wait until he comes.* (一直等)
2. **否定句**：接瞬时动词。*Not... until...* (直到...才)。*I didn't go to bed until I finished work.*
""".trimIndent(),
            syllabusDetails = listOf(
                "**【逻辑分类】** 深刻理解九大分类状语从句的语义指向，掌握核心从属连词的物理引导功能。",
                "**【时态锁死】** 无误应用“主将从现”原则，并在 *since* 引导的时间从句中执行“主完从过”配对。",
                "**【二选一红线】** 严禁 *because/so* 及 *although/but* 的双重标记，杜绝冗余逻辑。",
                "**【so vs such】** 精准掌握 *so...that* (修饰形/副) 与 *such...that* (修饰名词短语) 的结构界限。",
                "**【unless代换】** 掌握 *unless* 与 *if...not* 的等值逻辑转换及其对“主将从现”的继承。",
                "**【while多义】** 掌握 *while* 在时间、让步及对比（然而）语境下的多重功能逻辑。"
            ),
            relatedPoints = listOf(
                RelatedPoint("连词 (Conjunctions)", "逻辑的指挥旗", "状从的性质完全由其引导词的物理语义属性决定。"),
                RelatedPoint("一般将来时", "主句的锚点", "主句的将来意图是触发从句“时态降级”的唯一动力。"),
                RelatedPoint("现在完成时", "since的伴侣", "现在完成时是描述自过去某点延续至今的逻辑载体。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "We will have a picnic if it ______ tomorrow.", listOf("A. won't rain", "B. doesn't rain", "C. isn't raining", "D. wouldn't rain"), "B", "**【解析】** *if* 引导条件从句，主句 *will have* 触发“主将从现”。从句用一般现在时的否定。故选 **B**。", "**【标志】** *tomorrow* 虽然指将来，但物理地位受从句降级。 ", "如果明天不下雨，我们就去野餐。"),
                PastExamQuestion("2025", "上海", "He was ______ tired ______ he couldn't walk any further.", listOf("A. so; that", "B. such; that", "C. too; to", "D. enough; to"), "A", "**【解析】** *tired* 是形容词，结果状语从句用 *so...that*。故选 **A**。", "**【配对】** 形容词前用 *so*，名词短语前用 *such*。", "他如此疲惫，以至于不能再走一步了。"),
                PastExamQuestion("2024", "广东", "______ he is only ten years old, ______ he knows a lot.", listOf("A. Although; but", "B. Because; so", "C. Although; /", "D. Because; /"), "C", "**【解析】** *although* 与 *but* 互斥。故选 **C**。", "**【红线】** 英语逻辑严禁双重标记。", "虽然他只有十岁，但他知道很多。"),
                PastExamQuestion("2024", "天津", "I ______ my teacher since I ______ to this school.", listOf("A. haven't seen; came", "B. didn't see; came", "C. haven't seen; come", "D. didn't see; come"), "A", "**【解析】** *since* 主完从过。故选 **A**。", "**【公式】** *since* 引导的时间从句时态锁定。", "自从我来到这所学校，我就没见过我的老师。"),
                PastExamQuestion("2023", "江苏南京", "You won't pass the exam ______ you work hard.", listOf("A. if", "B. unless", "C. because", "D. as soon as"), "B", "**【解析】** “如果不努力，就不会通过”。*unless* 相当于 *if...not*。故选 **B**。", "**【条件逻辑】** 判定逻辑推导的正负方向。", "除非你努力，否则你不会通过考试。"),
                PastExamQuestion("2022", "湖北武汉", "I ______ you as soon as I ______ the result tomorrow.", listOf("A. tell; know", "B. will tell; know", "C. will tell; will know", "D. tell; will know"), "B", "**【解析】** *as soon as* 时间状从，遵循“主将从现”。故选 **B**。", "**【即时逻辑】** 一...就...的时态联动。", "明天我一知道结果就告诉你。"),
                PastExamQuestion("2021", "河南", "I didn't go home ______ I finished the work last night.", listOf("A. until", "B. after", "C. before", "D. when"), "A", "**【解析】** *not...until* 直到...才。故选 **A**。", "**【结构】** 否定句与瞬时动词的配合。", "昨天晚上我直到做完工作才回家。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("As soon as the bell rings, students run out. They go to the playground because they have PE class. Although it's hot, they are excited.", listOf(
                    HighlightedSentence("As soon as the bell rings", "**【即时从句】** 展示了物理反应般的时态降级逻辑。"),
                    HighlightedSentence("Although it's hot", "**【转折从句】** 用于表达逆向的逻辑驱动。")
                ), "人教版 (Go for it!) 八下 Unit 6"),
                TextbookParagraph("I haven't seen him since he moved last year. He told me that he was having such a great time that he didn't want to come back.", listOf(
                    HighlightedSentence("since he moved", "**【时间轴联动】** 锁定了现在完成时的逻辑起点。"),
                    HighlightedSentence("such a great time that", "**【结构重心】** *such* 物理上必须笼罩包含名词 *time* 的短语。")
                ), "外研版 (New Standard) 九下 Module 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("Wait until the light turns green before you cross the street.", "一直等到绿灯亮了再过马路。", "**【分析】** 肯定句中 *until* 展示了动作的持续终点。", "基础必会 (Simple)"),
                ExampleSentence("Unless it rains tomorrow afternoon, the match will start on time.", "除非明天下午下雨，否则比赛将准时开始。", "**【分析】** *unless* 驱动的条件从句展示了排除法逻辑。", "中考核心 (Complex)"),
                ExampleSentence("He is such a clever boy that he can solve the problem easily.", "他是一个如此聪明的孩子，以至于能轻松解决问题。", "**【分析】** *such...that* 修饰名词性单数可数短语的范例。", "基础必会 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **时态惯性**：在从句中看到 *tomorrow* 无法克制写出 *will* 的冲动。\n2. **逻辑冗余**：受母语习惯影响，在同一个句子里同时使用 *although* 和 *but*。\n3. **until 盲点**：分不清肯定句与否定句对主句动词持续性的要求。"),
                TeachingNote("【教学金钥】备忘清单", "1. **逻辑开关图**：将 *if, unless, because* 视为电路开关，演示逻辑流向。\n2. **二选一红牌**：准备红牌道具，学生若写出 *bc/so* 同句，立刻举牌示警。\n3. **since 阶梯**：画出一个从过去延伸到现在的阶梯，标注主从时态位。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *since* 找 *have done*；看到 *if* 划掉从句里的 *will*；看到名词前有 *a/an* 必填 *such*。")
            ),
            famousQuote = "If you want to go fast, go alone. If you want to go far, go together.",
            quoteAuthor = "African Proverb",
            quoteTranslation = "想要走得快，就独行；想要走得远，就结伴而行。",
            quoteAnalysis = "本句展示了条件状语从句在构建平行智慧逻辑与指导人生行动中的力量。"
        )'''

# --- 执行替换 ---
pattern_object_clause = re.compile(r'KnowledgePoint\(\s+id = "object_clause",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_attributive_clause = re.compile(r'KnowledgePoint\(\s+id = "attributive_clause",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_adverbial_clause = re.compile(r'KnowledgePoint\(\s+id = "adverbial_clause",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_object_clause.sub(lambda _: new_object_clause + ',', content)
content = pattern_attributive_clause.sub(lambda _: new_attributive_clause + ',', content)
content = pattern_adverbial_clause.sub(lambda _: new_adverbial_clause + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
