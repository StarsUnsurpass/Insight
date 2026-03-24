import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

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

#### 3. 句式变换 (助动词 do/does)
*   **肯定句**：*He works hard.*
*   **否定句**：*He **doesn't** work hard.* (助动词出现，动词必还原)
*   **疑问句**：***Does** he work hard?* (助动词置顶，动词必还原)

#### 4. “主将从现”铁律 (中考必杀)
在由 *if, unless, when, as soon as, until* 引导的从句中，若主句表达将来意图，从句物理上必须锁定一般现在时。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态控制】** 熟练掌握动词单三的 4 种变化规则，重点处理 *have* 变 *has* 及 *y* 结尾的陷阱。",
                "**【语义判定】** 区分习惯性动作与说话瞬间的动作（进行时），识别客观真理的‘时态豁免权’。",
                "**【逻辑联动】** 深刻领悟并应用‘主将从现’原则，精准识别时间与条件状语从句的时态锁死。",
                "**【隐形主语】** 掌握 *Everyone, Nobody, Each of...* 等不定代词作主语时的单三匹配。",
                "**【助动词逻辑】** 掌握 *do/does* 在否定与疑问句中的物理占位及对实义动词的还原要求。",
                "**【频度分布】** 掌握频度副词（*always* 等）在句中‘行前系后’的标准位置。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在进行时", "常态 vs 动态", "一般现在时侧重规律，进行时侧重此时此刻。"),
                RelatedPoint("主谓一致", "单三变化的物理根源", "理解主语的‘数’是正确运用一般现在时的前提。"),
                RelatedPoint("状语从句", "主将从现的战场", "从句的逻辑性质决定了时态的强制降级。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "Our teacher tells us that the sun ______ in the east.", listOf("A. rise", "B. rises", "C. rose", "D. will rise"), "B", "**【解析】** 太阳升起是客观真理，固定用一般现在时。主语 *the sun* 是单三。故选 **B**。", "**【注意】** 即使主句是 *tells*，真理也不受时态呼应限制。", "老师告诉我们太阳从东方升起。"),
                PastExamQuestion("2025", "天津", "If it ______ sunny tomorrow, we ______ a picnic in the park.", listOf("A. will be; have", "B. is; will have", "C. is; have", "D. will be; will have"), "B", "**【解析】** *if* 引导条件从句，遵循“主将从现”。从句用 *is*，主句用 *will have*。故选 **B**。", "**【逻辑】** 判定从句性质是解题关键。", "如果明天天气晴朗，我们将在公园野餐。"),
                PastExamQuestion("2024", "广东", "He ______ to school by bike every day to keep fit.", listOf("A. go", "B. goes", "C. went", "D. is going"), "B", "**【解析】** *every day* 提示习惯动作，用一般现在时。主语 *He* 为单三。故选 **B**。", "**【基础】** 习惯动作的时态匹配。", "他每天骑自行车上学以保持健康。"),
                PastExamQuestion("2024", "上海", "— Does Tom usually ______ computer games?\n— No, but he ______ playing basketball.", listOf("A. plays; likes", "B. play; likes", "C. play; like", "D. plays; like"), "B", "**【解析】** 疑问句有助动词 *Does*，动词还原为 *play*；答句肯定句主语 *he* 是单三，用 *likes*。故选 **B**。", "**【还原逻辑】** 助动词出现，动词‘脱敏’（还原）。", "—— 汤姆通常玩电脑游戏吗？ —— 不，但他喜欢打篮球。"),
                PastExamQuestion("2023", "江苏南京", "I ______ you as soon as I ______ the result.", listOf("A. will tell; know", "B. tell; will know", "C. will tell; will know", "D. tell; know"), "A", "**【解析】** *as soon as* 引导时间从句，遵循“主将从现”。故选 **A**。", "**【规则】** 一...就...的逻辑嵌套。", "我一知道结果就告诉你。"),
                PastExamQuestion("2022", "四川成都", "The train ______ at 8:00 p.m. every Friday. Don't be late.", listOf("A. leave", "B. leaves", "C. left", "D. will leave"), "B", "**【解析】** 官方时刻表表示的安排，通常用一般现在时。故选 **B**。", "**【语用】** 时刻表的特殊时态功能。", "火车每周五晚上 8 点出发。别迟到。"),
                PastExamQuestion("2021", "河南", "Nobody ______ how to solve the difficult math problem at the moment.", listOf("A. know", "B. knows", "C. knew", "D. is knowing"), "B", "**【解析】** *Nobody* 作主语视为单三含义；描述现阶段状态。故选 **B**。", "**【隐形单三】** 不定代词主语的判定。", "目前没人知道如何解决那个数学难题。"),
                PastExamQuestion("2020", "安徽", "My mother ______ very busy on weekdays, but she ______ free on weekends.", listOf("A. is; is", "B. are; are", "C. is; are", "D. are; is"), "A", "**【解析】** 主语 *mother* 是单数，描述现阶段常态。故选 **A**。", "**【基础】** 系动词的数之一致。", "我妈妈工作日很忙，但周末有空。"),
                PastExamQuestion("2019", "福建", "Action ______ louder than words.", listOf("A. speak", "B. speaks", "C. spoke", "D. will speak"), "B", "**【解析】** 格言警句锁定一般现在时。故选 **B**。", "**【文化】** 谚语语法特征。", "行动胜于言辞。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("I usually get up at 6:30 every day. Then I brush my teeth and have breakfast. My school starts at 8:00. I always try my best to get to school on time because I don't want to be late.", listOf(
                    HighlightedSentence("usually get up", "**【习惯动作】** 频度副词 *usually* 置于实义动词前。"),
                    HighlightedSentence("school starts", "**【单三匹配】** 机构/学校作为整体主语，谓语动词加 *s*。")
                ), "人教版 (Go for it!) 七上 Unit 5"),
                TextbookParagraph("The Amazon River flows through South America. It is the second longest river in the world. Many animals and plants live in the rainforest. It supports many lives on our planet.", listOf(
                    HighlightedSentence("flows through", "**【科学地理】** 描述自然特征固定使用一般现在时。"),
                    HighlightedSentence("It supports", "**【代词单三】** *It* 指代河流，谓语动词强制变换。")
                ), "外研版 (New Standard) 九下 Module 1"),
                TextbookParagraph("If you study hard, you will succeed. Practice makes perfect. Whether you succeed or not depends on your effort and your strong will.", listOf(
                    HighlightedSentence("If you study..., you will...", "**【逻辑主将从现】** 展示了条件与结果的时态不对称美。"),
                    HighlightedSentence("Practice makes perfect", "**【格言】** 永恒的一般现在时示例。")
                ), "沪教版 (Oxford) 九上 Unit 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("The earth moves around the sun and the moon moves around the earth.", "地球绕着太阳转，月球绕着地球转。", "**【分析】** 典型的科学事实表达，不受语境时间限制。", "基础必会 (Simple)"),
                ExampleSentence("I will call you as soon as I arrive at the airport tomorrow morning.", "我明天早上到达机场后就给你打电话。", "**【分析】** 时间状语从句中的主将从现，即使有 *tomorrow* 标志，从句仍用 *arrive*。", "中考核心 (Complex)"),
                ExampleSentence("Everyone in our class enjoys reading English books after school.", "我们班里的每个人都喜欢在放学后读英语书。", "**【分析】** *Everyone* 触发单三谓语 *enjoys*，这是完形填空的常见考点。", "高频易错 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **单三遗忘症**：受汉语思维影响，完全忽略谓语变换。\n2. **助动词陷阱**：在 *does* 出现后，忘记将实义动词还原。\n3. **真理误判**：在宾语从句中受主句过去时引导，错误地将从句真理变过去时。"),
                TeachingNote("【教学金钥】备忘清单", "1. **单三警报器**：训练学生看到 *he, she, it* 就下意识寻找 *s*。\n2. **助动词还原图**：用“吸铁石”比喻助动词 *does* 将动词末尾的 *s* “吸走”了。\n3. **主将从现逻辑链**：利用“将来”与“现在”的不平衡天平进行视觉演示。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *always, usually* 找单三；看到 *if* 引导的条件句找“主将从现”；看到太阳、月亮等自然现象找一般现在时。")
            ),
            famousQuote = "The early bird catches the worm.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "早起的鸟儿有虫吃。",
            quoteAnalysis = "本句生动展示了一般现在时在描述普遍规律与格言中的标准应用。"
        )'''

pattern_simple_present = re.compile(r'KnowledgePoint\(\s+id = "simple_present",.*?^\s+\),', re.DOTALL | re.MULTILINE)

new_content = pattern_simple_present.sub(lambda _: new_simple_present + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_content)

print("Success")
