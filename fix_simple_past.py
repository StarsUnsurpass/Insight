import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

new_simple_past = r'''        KnowledgePoint(
            id = "simple_past",
            section = SEC_2,
            title = "一般过去时 (Simple Past)",
            description = """
### 📖 核心概念详解

一般过去时 (Simple Past) 是记录历史的“刻刀”，用于描述在过去特定时间发生的动作或存在的状态。

#### 1. 核心标志词
*   *yesterday, last night, two days ago, in 2010, just now* (刚才)。

#### 2. 动词过去式 (Past Tense) 变化规则
| 类别 | 变化规则 | 经典示例 |
| :--- | :--- | :--- |
| **规则变化 1** | 直接词尾 **+ed** | *work -> worked* |
| **规则变化 2** | 以 e 结尾只 **+d** | *live -> lived* |
| **规则变化 3** | 辅音 + y 变 **i + ed** | *study -> studied* |
| **规则变化 4** | 重读闭音节 **双写 + ed** | *stop -> stopped, plan -> planned* |
| **不规则变化** | 强制记忆 | *go-went, buy-bought, read-read* |

#### 3. 句式变换 (助动词 did)
*   **肯定句**：*He bought a car yesterday.*
*   **否定句**：*He **didn't** buy a car yesterday.* (did 出现，动词还原)
*   **疑问句**：***Did** he buy a car yesterday?* (did 置顶，动词还原)

#### 4. 核心固定句式
*   **used to do**：过去常常做某事（现在不做了）。
*   **was/were... when...**：过去发生某事时，另一动作正在发生。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态转换】** 熟练掌握规则动词过去式的 4 种物理变化，重点攻克双写末尾辅音字母的规则。",
                "**【不规则表】** 强制性记忆 100 个以上核心不规则动词，特别注意 *read* (读音变) 和 *cost* (形态不变)。",
                "**【助动词逻辑】** 掌握 *did* 在否定与疑问句中的语法霸权，确保实义动词物理还原为原形。",
                "**【时间锁定】** 精准识别 *ago, last week* 等过去标志词，区分 *just now* (过去时) 与 *right now* (进行时)。",
                "**【习惯表达】** 深刻辨析 *used to do* (过去习惯) 与 *be used to doing* (现在习惯) 的结构与语义。",
                "**【叙事功能】** 掌握一般过去时在描述一连串连续动作或已故人物生平时的应用。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在完成时", "点 vs 线", "过去时强调动作在历史点的终结，完成时强调对现在的持续影响。"),
                RelatedPoint("过去进行时", "背景 vs 瞬间", "过去进行时提供宏观背景，一般过去时描述突发的短促动作。"),
                RelatedPoint("过去完成时", "过去的过去", "一般过去时通常作为过去完成时的参考坐标点。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— Where is your sister?\n— She ______ for the library ten minutes ago.", listOf("A. leaves", "B. left", "C. has left", "D. is leaving"), "B", "**【解析】** *ten minutes ago* 是明确的过去时间状语，锁定一般过去时。故选 **B**。", "**【易错点】** 容易根据中文“已经走了”而误选现在完成时 C。", "—— 你姐姐在哪里？ —— 她十分钟前去图书馆了。"),
                PastExamQuestion("2025", "上海", "My father ______ to work by car, but now he takes the subway.", listOf("A. used to go", "B. is used to go", "C. uses to go", "D. was used to go"), "A", "**【解析】** 表达“过去常常做某事（现在不做了）”用 *used to do*。故选 **A**。", "**【注意】** 与后文的 *now* 形成鲜明对比。", "我爸爸过去开车上班，但现在他坐地铁。"),
                PastExamQuestion("2024", "广东", "I ______ my lost key under the sofa just now.", listOf("A. find", "B. found", "C. will find", "D. have found"), "B", "**【解析】** *just now* 意为“刚才”，常与一般过去时连用。故选 **B**。", "**【标志词】** *just now* 是过去时的雷达词。", "我刚才在沙发下面找到了丢的钥匙。"),
                PastExamQuestion("2024", "天津", "— ______ you ______ the football match on TV last night?\n— Yes, it was exciting.", listOf("A. Do; watch", "B. Did; watch", "C. Did; watched", "D. Were; watch"), "B", "**【解析】** *last night* 提示过去时，疑问句借用助动词 *Did*，动词还原。故选 **B**。", "**【还原原则】** 选 C 是典型的助动词后动词不还原错误。", "—— 昨晚你看电视上的足球赛了吗？ —— 看了，很精彩。"),
                PastExamQuestion("2023", "江苏南京", "Shakespeare ______ many famous plays in his life.", listOf("A. writes", "B. wrote", "C. has written", "D. was writing"), "B", "**【解析】** 描述已故历史人物的生平事迹用一般过去时。故选 **B**。", "**【人物背景】** 历史事实视角。", "莎士比亚一生写了许多著名的剧作。"),
                PastExamQuestion("2022", "四川成都", "I ______ a student ten years ago, but now I am a doctor.", listOf("A. am", "B. was", "C. were", "D. been"), "B", "**【解析】** *ten years ago* 提示过去时，主语 *I* 对应连系动词 *was*。故选 **B**。", "**【数之一致】** 注意 I 匹配 was 而非 were。", "十年前我是一名学生，但现在我是一名医生。"),
                PastExamQuestion("2021", "河南", "The boy ______ down from the bike and hurt his leg.", listOf("A. fall", "B. falls", "C. fell", "D. felt"), "C", "**【解析】** *hurt* 是过去式（不规则变化，原形也是 hurt），暗示整句为过去时。*fall* 的过去式是 *fell*。故选 **C**。", "**【不规则变化】** 注意 *fell* 与 *felt* (feel的过去式) 的形近辨析。", "那个男孩从自行车上摔了下来，伤了腿。"),
                PastExamQuestion("2020", "安徽", "When I was a child, my grandfather ______ often tell me stories.", listOf("A. will", "B. would", "C. should", "D. must"), "B", "**【解析】** 在过去语境中，*would* 可表示过去反复发生的习惯。故选 **B**。", "**【高阶语用】** *would* 表达过去习惯的一种方式。", "当我还是个孩子的时候，我爷爷经常给我讲故事。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Yesterday was a busy day for me. I got up at 7:00 and had breakfast quickly. Then I went to the history museum with my classmates. We saw many interesting things and took a lot of photos.", listOf(
                    HighlightedSentence("Yesterday was...", "**【时态背景】** 第一句话确立了全篇的过去时间坐标。"),
                    HighlightedSentence("got up... had... went... saw... took", "**【动作链】** 连续的不规则动词过去式，展示了叙事逻辑的连贯性。")
                ), "人教版 (Go for it!) 七下 Unit 11"),
                TextbookParagraph("In ancient times, people used to communicate by sending smoke signals. It took a long time to deliver a message. But after the telephone was invented, communication became easier.", listOf(
                    HighlightedSentence("used to communicate", "**【历史习惯】** 用于描述过去长期存在但在现代已消失的习惯。"),
                    HighlightedSentence("became easier", "**【状态改变】** 描述过去某一发明带来的历史性变化。")
                ), "外研版 (New Standard) 九下 Module 1"),
                TextbookParagraph("I found my lost book under the bed just now. I was so happy because I had searched for it for two days. Now I can prepare for the exam tomorrow.", listOf(
                    HighlightedSentence("found... just now", "**【即时过去】** *just now* 锁定了刚刚完成的过去动作。"),
                    HighlightedSentence("was so happy", "**【情感状态】** 描述过去那一刻的心理感受。")
                ), "沪教版 (Oxford) 八上 Unit 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("He stopped smoking two years ago and now he feels much healthier.", "他两年前戒烟了，现在觉得健康多了。", "**【分析】** *ago* 标志一般过去时；*now* 切换回一般现在时。", "基础必会 (Compound)"),
                ExampleSentence("The plane took off on time despite the heavy rain yesterday morning.", "尽管昨天早上下大雨，飞机还是准时起飞了。", "**【分析】** *took off* 是 *take off* 的过去式，描述过去确定的动作。", "中考核心 (Simple)"),
                ExampleSentence("I thought you were in the office just now, but I couldn't find you.", "我刚才以为你在办公室，但我找不到你。", "**【分析】** 两个分句均使用了过去时以维持时态逻辑的一致性。", "高频易错 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **拼写盲点**：双写 ed 规则（如 *stoped* 错误）及不规则变化（如 *buyed* 错误）。\n2. **助动词冗余**：否定句写成 *didn't bought*。\n3. **混淆习惯**：分不清 *used to do* 与 *be used to doing*。"),
                TeachingNote("【教学金钥】备忘清单", "1. **故事接龙法**：利用过去式编写连续的短篇故事，强化动词链变换。\n2. **不规则归类卡**：将动词分为 AAA, ABB, ABC 型分类记忆。\n3. **吸铁石比喻**：助动词 *did* 像吸铁石，吸走了动词末尾的 ed。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *ago, last, yesterday* 找过去式；看到 *Did* 找动词原形；看到历史名人找一般过去时。")
            ),
            famousQuote = "The past is a foreign country; they do things differently there.",
            quoteAuthor = "L.P. Hartley",
            quoteTranslation = "过去是个异国他乡；他们在那里做事的方式不同。",
            quoteAnalysis = "本句生动暗示了过去时态在描述与现在截然不同的历史状态时的功能。"
        )'''

pattern_simple_past = re.compile(r'KnowledgePoint\(\s+id = "simple_past",.*?^\s+\),', re.DOTALL | re.MULTILINE)

new_content = pattern_simple_past.sub(lambda _: new_simple_past + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_content)

print("Success")
