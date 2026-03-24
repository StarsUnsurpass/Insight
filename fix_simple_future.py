import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

new_simple_future = r'''        KnowledgePoint(
            id = "simple_future",
            section = SEC_2,
            title = "一般将来时 (Simple Future)",
            description = """
### 📖 核心概念详解

一般将来时 (Simple Future) 是通往“明天”的窗口，用于表达将来发生的动作或存在的状态。

#### 1. 两大主力：will vs be going to
| 结构 | 核心语义 | 典型语境 |
| :--- | :--- | :--- |
| **will + do** | 纯粹预测 / 临时决定 / 承诺 | *I will help you.* (临时起意) |
| **be going to + do** | 计划打算 / 明显迹象推测 | *Look at the clouds! It's going to rain.* |

#### 2. There be 句型的将来形态 (中考红线)
*   **正确**：*There will be...* / *There is going to be...*
*   **错误**：*There will have...* (物理上绝对禁止)

#### 3. 句式变换
*   **否定句**：*He **won't** (will not) go there.* / *He isn't going to go there.*
*   **疑问句**：***Will** he go there?* / ***Is** he going to go there?*

#### 4. “进行”表“将来”
位移动词 (*go, come, leave, start, arrive*) 的现在进行时常表示近期已确定的、正在准备中的位移计划。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【语义辨析】** 深度区分 *will* (意愿/预测) 与 *be going to* (计划/迹象) 的语用边界。",
                "**【结构陷阱】** 掌握 *There be* 句型将来时的标准物理构成，严防 *have* 的母语干扰。",
                "**【逻辑联动】** 熟练识别“主将从现”原则，掌握时间/条件从句对主句将来时的逻辑锁定。",
                "**【时间标志】** 掌握 *in + 段时间* (多久之后) 的将来时用法，及其提问词 *How soon*。",
                "**【替代时态】** 理解位移动词用现在进行时表达‘确定安排’的将来含义。",
                "**【固定短语】** 掌握 *be about to do* (正要做某事) 表示即将发生的即刻将来动作。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在进行时", "意图的重叠", "进行时表将来侧重已确定的位移安排。"),
                RelatedPoint("一般现在时", "时刻表的客观性", "官方时刻表常用一般现在时表达确定的将来。"),
                RelatedPoint("过去将来时", "视角的后退", "主句为过去式时，将来时态物理后退至 *would* 层级。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— What's your plan for the summer holiday?\n— I ______ a volunteer in the library.", listOf("A. am", "B. was", "C. will be", "D. have been"), "C", "**【解析】** 问句提到 *plan*，暗示动作尚未发生，用一般将来时。故选 **C**。", "**【语境】** 计划打算的询问。", "—— 你暑假有什么计划？ —— 我要在图书馆当志愿者。"),
                PastExamQuestion("2025", "天津", "There ______ a wonderful concert in our school next week.", listOf("A. will have", "B. will be", "C. is going to have", "D. was"), "B", "**【解析】** *There be* 句型将来时不用 *have*。*next week* 提示将来。故选 **B**。", "**【红线】** *There will have* 是中考物理性错误第一名。", "下周我们学校将有一场精彩的音乐会。"),
                PastExamQuestion("2024", "广东", "If I ______ any news about the competition, I ______ you.", listOf("A. get; tell", "B. get; will tell", "C. will get; tell", "D. will get; will tell"), "B", "**【解析】** *if* 引导条件从句遵循“主将从现”。从句用 *get*，主句用 *will tell*。故选 **B**。", "**【逻辑】** 时态的条件配对。", "如果我有关于比赛的消息，我会告诉你。"),
                PastExamQuestion("2024", "上海", "— How soon ______ he come back?\n— In two days.", listOf("A. does", "B. did", "C. will", "D. has"), "C", "**【解析】** *In + 时间段* 回答，用一般将来时提问。故选 **C**。", "**【标志词】** *In two days* 是将来时的黄金标志。", "—— 他多久之后回来？ —— 两天后。"),
                PastExamQuestion("2023", "江苏南京", "Look at the dark clouds! It ______ rain very soon.", listOf("A. will", "B. is going to", "C. rains", "D. was"), "B", "**【解析】** 根据目前的明显迹象（黑云）推测必然结果，用 *be going to*。故选 **B**。", "**【迹象推测】** *will* 较主观，*be going to* 基于客观迹象。", "看那些黑云！马上就要下雨了。"),
                PastExamQuestion("2022", "四川成都", "I ______ for London tonight. Everything is ready.", listOf("A. leave", "B. am leaving", "C. left", "D. will leave"), "B", "**【解析】** 位移动词 *leave* 用现在进行时表示确定的、近期已准备好的安排。故选 **B**。", "**【语用】** 强调“一切已就绪”的确定性。", "我今晚启程去伦敦。一切都准备好了。"),
                PastExamQuestion("2021", "河南", "I don't think there ______ any schools in 100 years.", listOf("A. will be", "B. are going to have", "C. will have", "D. are"), "A", "**【解析】** 对未来的长期预测用 *will be*。*There be* 句型排除 C。故选 **A**。", "**【预测】** 科技与社会发展的宏观预测。", "我认为 100 年后不会有学校了。"),
                PastExamQuestion("2020", "安徽", "Hurry up! The film ______ in five minutes.", listOf("A. start", "B. starts", "C. started", "D. will start"), "B", "**【解析】** 电影开始是时刻表安排，常用一般现在时。若选 D 虽通但 B 更地道且常考。故选 **B**。", "**【时刻表】** 官方计划时态。", "快点！电影五分钟后开始。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("In the future, robots will do most of the boring work for humans. We will have more free time to enjoy our lives. Scientists are going to develop smarter machines. It is going to be an exciting world.", listOf(
                    HighlightedSentence("robots will do", "**【科技预测】** 使用 *will* 对宏观未来进行预测。"),
                    HighlightedSentence("going to develop", "**【既定计划】** 表达科学家们正在进行的研发意图。")
                ), "人教版 (Go for it!) 八上 Unit 7"),
                TextbookParagraph("Next month, our class is going to have a sports meeting. I am going to join the race. I will practice every afternoon. I hope I will win a gold medal for my class.", listOf(
                    HighlightedSentence("is going to have", "**【近期安排】** 学校已排定的集体活动。"),
                    HighlightedSentence("I will practice", "**【个人决心】** 说话者当下的决心或意愿。")
                ), "外研版 (New Standard) 七下 Module 10"),
                TextbookParagraph("Wait a minute! I'll help you with those heavy boxes. We are going to put them in the storeroom on the first floor. It won't take long.", listOf(
                    HighlightedSentence("I'll help you", "**【临时起意】** 说话瞬间决定提供的帮助。"),
                    HighlightedSentence("won't take long", "**【逻辑预测】** 对动作所需时间的评估。")
                ), "沪教版 (Oxford) 八上 Unit 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("If you don't hurry up, you will be late for the opening ceremony.", "如果你不快点，你开幕式就会迟到。", "**【分析】** 典型的“主将从现”复杂句结构。", "中考核心 (Complex)"),
                ExampleSentence("There is going to be a heavy rainstorm tonight, so stay at home.", "今晚将有一场大暴雨，所以待在家里。", "**【分析】** *There be* 句型的 *be going to* 形态，表示基于气象预报的推测。", "基础必会 (Compound)"),
                ExampleSentence("Are you coming to the party tomorrow? Everyone is expecting you.", "明天你来参加派对吗？大家都在期待你。", "**【分析】** 用现在进行时询问确定的将来位移计划。", "交际英语 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **There will have**：受汉语“将会有”影响最深。一定要强调 *There be* 的独立性。\n2. **从句误用 will**：在 *if/when* 引导的从句中顺手写出 *will*。\n3. **be 动词遗漏**：写成 *I going to do*。"),
                TeachingNote("【教学金钥】备忘清单", "1. **吸铁石法则**：强调 *will* 后动词必须原形。\n2. **天平平衡法**：演示主句将来与从句现在的时间天平。\n3. **时刻表角色扮演**：利用校车、电影时刻表练习一般现在时表将来。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *in + 段时间* 锁定将来时；看到 *There* 划掉 *have*；看到 *if* 检查主从时态配对。")
            ),
            famousQuote = "The best way to predict the future is to create it.",
            quoteAuthor = "Peter Drucker",
            quoteTranslation = "预测未来最好的方法就是去创造未来。",
            quoteAnalysis = "表达了主动采取行动（*create*）以改变未来的积极价值观。"
        )'''

pattern_simple_future = re.compile(r'KnowledgePoint\(\s+id = "simple_future",.*?^\s+\),', re.DOTALL | re.MULTILINE)

new_content = pattern_simple_future.sub(lambda _: new_simple_future + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_content)

print("Success")
