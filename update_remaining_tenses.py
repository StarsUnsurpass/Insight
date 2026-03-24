import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 一般过去时 (Simple Past) ---
new_simple_past = r'''        KnowledgePoint(
            id = "simple_past",
            section = SEC_2,
            title = "一般过去时 (Simple Past)",
            description = """
### 📖 核心概念详解

一般过去时 (Simple Past) 是记录历史的“刻刀”，描述在过去特定时间发生的动作或状态。

#### 1. 核心标志词
*   *yesterday, last night, two days ago, in 2010, just now* (刚才)。

#### 2. 动词过去式 (Past Tense) 变换规则
| 类别 | 变化规则 | 经典示例 |
| :--- | :--- | :--- |
| **规则变化 1** | 直接词尾 **+ed** | *worked, played* |
| **规则变化 2** | 以 e 结尾只 **+d** | *lived, loved* |
| **规则变化 3** | 辅音 + y 变 **i + ed** | *studied, cried* |
| **规则变化 4** | 重闭单 **双写 + ed** | *stopped, planned, fitted* |
| **不规则变换** | 强制记忆 | *go-went, buy-bought, read-read* |

#### 3. 句式变换 (助动词 did)
*   **肯定**：*He bought a gift.*
*   **否定**：*He **didn't buy** a gift.* (动词还原)
*   **疑问**：***Did** he buy a gift?* (动词还原)

#### 4. 核心习惯表达
*   **used to do**：过去常常（暗示现在不做了）。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态转换】** 熟练掌握规则动词过去式的 4 种物理变化，重点处理双写字母的规则。",
                "**【不规则表】** 强制性记忆 100 个以上中考高频不规则动词（特别是 ABC, ABB 型）。",
                "**【助动词霸权】** 掌握 *did* 在否定与疑问句中的物理占位及其对实义动词的还原逻辑。",
                "**【时间雷达】** 精准识别 *ago, last week* 等过去标志词，区分 *just now* 与 *right now*。",
                "**【习惯辨析】** 深刻区分 *used to do* (过去习惯) 与 *be used to doing* (现在习惯)。",
                "**【叙事功能】** 掌握其在描述一连串连续动作或已故人物生平时的叙述功能。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在完成时", "点线之争", "过去时强调历史点的终结，完成时强调逻辑线的延续。"),
                RelatedPoint("过去进行时", "瞬间 vs 背景", "一般过去时描述突发的点动作，过去进行时提供宏观背景。"),
                RelatedPoint("过去完成时", "参照系", "一般过去时是过去完成时逻辑链条中的参考基准点。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— Where is your sister?\n— She ______ for the library ten minutes ago.", listOf("A. leaves", "B. left", "C. has left", "D. is leaving"), "B", "**【解析】** *ten minutes ago* 提示一般过去时。故选 **B**。", "**【陷阱】** 容易受中文“已经走了”干扰而选完成时。", "—— 你姐姐在哪？ —— 她十分钟前去图书馆了。"),
                PastExamQuestion("2025", "上海", "My father ______ to work by bike, but now he takes the subway.", listOf("A. used to go", "B. is used to go", "C. used to going", "D. uses to go"), "A", "**【解析】** “过去常常（现在不做了）”用 *used to do*。故选 **A**。", "**【注意】** 与 *now* 形成鲜明对比。", "我爸爸过去骑车上班，但现在坐地铁。"),
                PastExamQuestion("2024", "广东", "I ______ my lost keys under the sofa just now.", listOf("A. find", "B. found", "C. have found", "D. will find"), "B", "**【解析】** *just now* (刚才) 常用于一般过去时。故选 **B**。", "**【标志词】** *just now* 是雷达词。", "我刚才在沙发下找到了丢的钥匙。"),
                PastExamQuestion("2023", "江苏南京", "Shakespeare ______ many famous plays hundreds of years ago.", listOf("A. writes", "B. wrote", "C. has written", "D. was writing"), "B", "**【解析】** 描述已故历史人物生平用一般过去时。故选 **B**。", "**【人物背景】** 历史叙事必选。", "莎士比亚在几百年前写了许多著名的剧作。"),
                PastExamQuestion("2022", "湖北武汉", "— Did you ______ the film last night?\n— Yes, I ______ it with my parents.", listOf("A. watch; watch", "B. watched; watched", "C. watch; watched", "D. watching; watched"), "C", "**【解析】** 疑问句借用 *Did* 动词还原；答句肯定句用过去式。故选 **C**。", "**【还原逻辑】** 助动词出现，动词‘脱敏’。", "—— 昨晚你看电影了吗？ —— 看了，我和父母一起看的。"),
                PastExamQuestion("2021", "河南", "I ______ a student ten years ago, but now I'm a teacher.", listOf("A. am", "B. was", "C. were", "D. been"), "B", "**【解析】** 过去状态。主语 *I* 匹配 *was*。故选 **B**。", "**【基础】** 系动词的过去形态匹配。", "十年前我是一名学生，现在我是一名老师。"),
                PastExamQuestion("2020", "安徽", "He ______ down from the bike and hurt his leg yesterday.", listOf("A. fall", "B. falls", "C. fell", "D. is falling"), "C", "**【解析】** *fall* 的过去式是 *fell*。故选 **C**。", "**【不规则变化】** 必考词汇形态。", "昨天他从自行车上摔了下来，伤了腿。"),
                PastExamQuestion("2019", "山东济南", "When I was a child, my mother ______ often take me to the park.", listOf("A. will", "B. would", "C. should", "D. must"), "B", "**【解析】** *would* 表达过去习惯。故选 **B**。", "**【习惯语义】** 过去经常性动作的替代表达。", "当我还是个孩子时，妈妈经常带我去公园。"),
                PastExamQuestion("2018", "陕西", "I ______ my homework late last night.", listOf("A. finish", "B. finished", "C. have finished", "D. will finish"), "B", "**【解析】** *last night* 锁定过去。故选 **B**。", "**【基础】** 时间状语匹配。", "昨晚我很晚才写完作业。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Yesterday was a busy day. I got up at 7:00 and had breakfast. Then I went to the history museum. We saw many exhibitions.", listOf(
                    HighlightedSentence("Yesterday was...", "**【基调锁定】** 开篇确立了整个叙事的时间坐标。"),
                    HighlightedSentence("got up... had... went... saw", "**【动作链】** 连续的不规则动词展示了过去动作的衔接。")
                ), "人教版 (Go for it!) 七下 Unit 11"),
                TextbookParagraph("In ancient times, people used to communicate by sending smoke signals. It took a long time to deliver a message.", listOf(
                    HighlightedSentence("used to communicate", "**【历史习惯】** 描述过去长期存在但在现代已消失的状态。")
                ), "外研版 (New Standard) 九下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("He stopped smoking three years ago and now he feels much healthier.", "他三年前戒烟了，现在觉得健康多了。", "**【分析】** *ago* 标志过去；*now* 切换回现在。", "基础必会 (Compound)"),
                ExampleSentence("The plane took off on time despite the heavy rain yesterday morning.", "尽管昨天早上下大雨，飞机还是准时起飞了。", "**【分析】** 描述过去确定的、已完成的动作。", "中考核心 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **还原失误**：在 *didn't* 之后仍用过去式（如 *didn't went*）。\n2. **拼写盲点**：双写规则遗忘及不规则形态混淆（如 *buyed* 错误）。"),
                TeachingNote("【教学金钥】备忘清单", "1. **吸铁石比喻**：助动词 *did* 吸走了动词末尾的 *ed*。\n2. **不规则分类卡**：按照 AAA, ABB, ABC 型分组记忆。")
            ),
            famousQuote = "The past is a foreign country; they do things differently there.",
            quoteAuthor = "L.P. Hartley",
            quoteTranslation = "过去是个异国他乡；他们在那里做事的方式不同。",
            quoteAnalysis = "展现了过去时态在描述历史状态与现代对立时的修辞功能。"
        )'''

# --- 2. 过去进行时 (Past Continuous) ---
new_past_continuous = r'''        KnowledgePoint(
            id = "past_continuous",
            section = SEC_2,
            title = "过去进行时 (Past Continuous)",
            description = """
### 📖 核心概念详解

过去进行时 (Past Continuous) 是历史的“慢镜头”，描述在过去某一特定时刻正在发生的动作。

#### 1. 核心功能场景
1.  **过去时刻背景**：*I was watching TV at 8:00 last night.*
2.  **动作打断模型**：一长一短。长动作（背景）用进行时，短动作（打断）用过去时。
    *   *I was reading when the phone rang.*
3.  **动作并行模型**：两个过去长动作同时发生。
    *   *While Mom was cooking, Dad was reading.*

#### 2. while vs when 的逻辑博弈
| 引导词 | 后接动词属性 | 常选时态 | 逻辑侧重 |
| :--- | :--- | :--- | :--- |
| **while** | 延续性动词 | 过去进行时 | 强调过程性，“在...期间” |
| **when** | 瞬时或延续 | 过去时 / 进行时 | 强调点触发，“在那一刻” |

#### 3. 物理公式 (was/were + doing)
*   **构成**：*was/were + 动词现在分词*
*   **注意**：*I* 与 *he/she/it* 均匹配 ***was***。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态匹配】** 熟练掌握 *was/were* 的人称对应，重点处理 *I* 匹配 *was* 的规则。",
                "**【逻辑嵌套】** 深刻理解“背景 vs 打断”模型，掌握长动作（进行时）与短动作（过去时）的配对。",
                "**【连词选择】** 掌握 *while* 后必须锁定延续性动词且常接进行时的硬性法则。",
                "**【语境判定】** 养成对 *at that time, at 8:00 yesterday* 等精确过去锚点的识别习惯。",
                "**【氛围铺垫】** 理解过去进行时在叙事中交代环境、营造氛围的文学功能。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般过去时", "短 vs 长", "一般过去时打破了进行时营造的持续背景氛围。"),
                RelatedPoint("现在进行时", "时轴平移", "逻辑模型完全一致，仅时间参考点发生平移。"),
                RelatedPoint("连词", "逻辑纽带", "*when* 与 *while* 是连接过去进行时的语法骨干。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— What ______ you ______ at 8:00 last night?\n— I was doing my homework.", listOf("A. do; do", "B. did; do", "C. were; doing", "D. are; doing"), "C", "**【解析】** *at 8:00 last night* 是精确点时刻，询问在那一刻正在做什么。故选 **C**。", "**【注意】** 精确时间点是进行时的黄金标志。", "—— 昨晚八点你正在做什么？ —— 我正在做作业。"),
                PastExamQuestion("2025", "上海", "While the children ______ in the garden, it started to rain.", listOf("A. play", "B. are playing", "C. were playing", "D. played"), "C", "**【解析】** *while* 引导长动作背景，主句 *started* 提示过去。故选 **C**。", "**【陷阱】** 容易误选现在进行时 B。", "当孩子们在花园玩耍时，开始下雨了。"),
                PastExamQuestion("2024", "广东", "The light ______ out while I ______ a shower yesterday.", listOf("A. went; was taking", "B. was going; took", "C. goes; am taking", "D. has gone; took"), "A", "**【解析】** “打断逻辑”。‘洗澡’是背景长动作，‘停电’是突发点动作。故选 **A**。", "**【逻辑】** 长短动作的主从配对。", "昨天当我正在洗澡时，灯熄灭了。"),
                PastExamQuestion("2023", "江苏南京", "When the teacher came in, the students ______ about the sports meeting.", listOf("A. talk", "B. talked", "C. were talking", "D. are talking"), "C", "**【解析】** 描述动作发生的瞬间背景。故选 **C**。", "**【场景】** 视觉瞬间的快门效应。", "当老师进来时，学生们正在谈论运动会。"),
                PastExamQuestion("2022", "湖北武汉", "I ______ my room when I heard a loud noise outside.", listOf("A. cleaned", "B. am cleaning", "C. was cleaning", "D. clean"), "C", "**【解析】** 听到巨响时“正在打扫”。故选 **C**。", "**【语境】** 用进行时交代事件发生的背景。", "当听到外面一声巨响时，我正在打扫房间。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When the heavy rainstorm came, I was waiting for the bus. My sister was reading in the library at that time. Many people were running quickly.", listOf(
                    HighlightedSentence("was waiting for", "**【背景长动作】** 描述暴风雨来临那一刻的持续状态。"),
                    HighlightedSentence("at that time", "**【时间锚点】** 锁定了过去某瞬时的“慢镜头”画面。")
                ), "人教版 (Go for it!) 八下 Unit 5"),
                TextbookParagraph("While I was walking in the park yesterday, I saw an old friend. We were both wearing the same sports clothes.", listOf(
                    HighlightedSentence("While I was walking", "**【过程逻辑】** *while* 明确指向一个具有长度的运动过程。")
                ), "外研版 (New Standard) 八上 Module 8")
            ),
            exampleSentences = listOf(
                ExampleSentence("At that time, she was practicing the piano alone in the quiet hall.", "那个时候，她正独自在安静的大厅里练钢琴。", "**【分析】** 标准的过去瞬时背景描写。", "基础必会 (Simple)"),
                ExampleSentence("I was just leaving the house when the alarm clock rang again.", "今天早上闹钟再次响起的时候我正要出门。", "**【分析】** 动作被打断的经典时态对立。", "中考核心 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **连词记反**：在点动作后错误使用 *while*（如 *while the phone rang*）。\n2. **动作属性**：分不清瞬间动词与延续动词的进行态资格。"),
                TeachingNote("【教学金钥】备忘清单", "1. **一长一短图示**：画一条长线代表进行时，一个叉号代表过去时。\n2. **延续性判定法**：拉长读音测试动词是否能持续。")
            ),
            famousQuote = "I was dreaming when they called me.",
            quoteAuthor = "John Lennon",
            quoteTranslation = "当他们叫我时，我正在做梦。",
            quoteAnalysis = "展现了过去进行时在刻画心理背景被外界打断时的张力。"
        )'''

# --- 3. 过去完成时 (Past Perfect) ---
new_past_perfect = r'''        KnowledgePoint(
            id = "past_perfect",
            section = SEC_2,
            title = "过去完成时 (Past Perfect)",
            description = """
### 📖 核心概念详解

过去完成时 (Past Perfect) 形象地被称为“过去的过去”。

#### 1. 核心逻辑模型
在时间轴上，如果过去发生的动作 A 是参照点（一般过去时），那么在 A 之前就已经完成的动作 B 必须物理性锁定过去完成时。

#### 2. 物理公式 (had + done)
*   **构成**：*had + 过去分词*
*   **特点**：*had* 不受主语单复数及人称限制，通用性极强。

#### 3. 典型标志词/句
*   ***by the time*** + 一般过去时从句
*   ***before / when*** + 一般过去时从句
*   ***by the end of*** + 过去时间
""".trimIndent(),
            syllabusDetails = listOf(
                "**【逻辑建模】** 建立‘过去的过去’思维模型，能在时间轴上精准定位两点的先后关系。",
                "**【配对原则】** 掌握 *By the time* 从句（过去时）与主句（完成时）的强制配对规则。",
                "**【退位法则】** 深刻理解宾语从句中的时态一致性，识别动作发生的绝对先后。",
                "**【转换逻辑】** 掌握瞬间动词在过去完成时语境下的延续性转换（同现在完成时）。",
                "**【had had】** 识别 *had had* 的合法物理重叠（助动词 + 实义分词）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在完成时", "时轴镜像", "现在完成时的基准点是现在，过去完成时的基准点是过去某瞬时。"),
                RelatedPoint("一般过去时", "坐标物", "一般过去时作为参照背景是过去完成时存在的物理前提。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "By the time the bell rang, I ______ my homework carefully.", listOf("A. finished", "B. have finished", "C. had finished", "D. was finishing"), "C", "**【解析】** “响铃”是过去（*rang*），“写完”发生在响铃之前。故选 **C**。", "**【注意】** 典型的“过去的过去”逻辑。", "铃响的时候，我已经仔细地写完作业了。"),
                PastExamQuestion("2024", "上海", "She said that she ______ that movie already when we discussed it.", listOf("A. sees", "B. saw", "C. has seen", "D. had seen"), "D", "**【解析】** 宾语从句时态呼应。主句 *said* 为过去时，“看电影”发生在此之前。故选 **D**。", "**【陷阱】** 容易受 *already* 干扰而选现在完成时 C。", "她说在我们讨论那部电影时，她已经看过它了。"),
                PastExamQuestion("2023", "广东", "When I arrived at the station, the train ______ already.", listOf("A. left", "B. has left", "C. had left", "D. was leaving"), "C", "**【解析】** “到达”是过去，“开走”发生在到达之前。故选 **C**。", "**【逻辑】** 描述两个过去动作的绝对先后。", "当我到达车站时，火车已经开走了。"),
                PastExamQuestion("2022", "江苏南京", "By the end of last term, we ______ about 2,000 words.", listOf("A. learned", "B. have learned", "C. had learned", "D. learn"), "C", "**【解析】** *by the end of + 过去时间* 是过去完成时的黄金标志。故选 **C**。", "**【标志】** 锁定截止到过去的累计结果。", "到上学期末，我们已经学了大约 2000 个单词。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When I woke up this morning, I realized that I had forgotten to set my alarm clock. I hurried to the bus stop, but the bus had already gone.", listOf(
                    HighlightedSentence("had forgotten to set", "**【逻辑先后】** “忘记”发生在“醒来”这一过去事实之前。"),
                    HighlightedSentence("bus had already gone", "**【结果呈现】** 描述到达车站时面对的既定结果。")
                ), "人教版 (Go for it!) 九年级 Unit 12")
            ),
            exampleSentences = listOf(
                ExampleSentence("He had lived in London for ten years before he moved to China in 2015.", "在他 2015 年搬到中国之前，他在伦敦住了十年。", "**【分析】** 典型的延续性状态在过去某一参考点之前的累积。", "中考核心 (Complex)"),
                ExampleSentence("The film had been on for ten minutes when I finally got to the cinema.", "当我终于赶到电影院时，电影已经开始了十分钟。", "**【分析】** 融合了瞬间动词转换（*start -> be on*）的过去完成时句式。", "高阶句式 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **孤立使用**：无过去参照背景而滥用过去完成时。\n2. **呼应失灵**：在宾语从句中忽略时态强制退后的原则。"),
                TeachingNote("【教学金钥】备忘清单", "1. **两点一线法**：在黑板画出 A、B 两点，强调 B 比 A 更早。\n2. **By the time 联动公式**：主过完，从过简。")
            ),
            famousQuote = "I had already found that it was not so easy to be good.",
            quoteAuthor = "Somerset Maugham",
            quoteTranslation = "我早就发现，做一个好人没那么容易。",
            quoteAnalysis = "展现了过去完成时在描述先于认知的感悟时的逻辑力量。"
        )'''

# --- 执行替换 ---
pattern_simple_past = re.compile(r'KnowledgePoint\(\s+id = "simple_past",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_past_continuous = re.compile(r'KnowledgePoint\(\s+id = "past_continuous",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_past_perfect = re.compile(r'KnowledgePoint\(\s+id = "past_perfect",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_simple_past.sub(lambda _: new_simple_past + ',', content)
content = pattern_past_continuous.sub(lambda _: new_past_continuous + ',', content)
content = pattern_past_perfect.sub(lambda _: new_past_perfect + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
