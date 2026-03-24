import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

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

#### 2. “瞬间”变“延续” (中考第一考点)
> ⚠️ **红线铁律**：瞬间动词严禁与 *for + 时间段* 或 *since + 时间点* 连用。必须进行物理形态转换。

| 瞬间动词 | 延续性转换 | 经典示例 |
| :--- | :--- | :--- |
| *join* | **be in / be a member of** | *have been in the army for...* |
| *borrow* | **keep** | *have kept the book for...* |
| *buy* | **have** | *have had the car since...* |
| *die* | **be dead** | *has been dead for two years* |
| *leave* | **be away** | *has been away from home since...* |
| *come/go* | **be in/at** | *has been in Beijing for...* |

#### 3. been to vs gone to
*   **have been to**：去过已回（强调个人经历）。
*   **have gone to**：去了未回（强调目前不在场）。
*   **have been in**：在某地待了多久（强调居住长度）。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【逻辑架构】** 深刻理解‘过去动作对现在产生影响’与‘动作持续至今’的两大语义模型。",
                "**【瞬间转换】** 物理性背诵 15 组以上瞬间动词变延续性动词的对照表，这是中考改错的必杀技。",
                "**【时间配对】** 掌握 *since + 时间点*、*for + 时间段* 以及 *since + 过去时从句* 的主从时态链。",
                "**【去留辨析】** 深度区分 *have been to* 与 *have gone to* 的在场逻辑。",
                "**【标志词分布】** 掌握 *already, yet, just, never, ever, so far* 在句中的标准占位及语义差异。",
                "**【疑问应答】** 掌握 *How long* 引导的问句与完成时态的锁定应答关系。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般过去时", "点 vs 线", "过去时是孤立的终结，完成时是延伸的逻辑。"),
                RelatedPoint("过去完成时", "视角的平移", "过去完成时是‘过去的过去’，逻辑与现在完成时平行。"),
                RelatedPoint("非谓语动词", "完成态的分身", "过去分词 *done* 是构成现在完成时的唯一合法物理单元。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— Look! Someone ______ the classroom. It's so clean.\n— Well, it wasn't me.", listOf("A. is cleaning", "B. has cleaned", "C. cleans", "D. was cleaning"), "B", "**【解析】** *It's clean now* 是目前的结果，说明动作已完成且对现在有影响。故选 **B**。", "**【注意】** 强调“干净”这一结果而非“打扫”这一动作过程。", "—— 看！有人打扫过教室了。现在真干净。 —— 唔，不是我。"),
                PastExamQuestion("2025", "上海", "My cousin ______ the army for three years. He is a brave soldier.", listOf("A. has joined", "B. has been in", "C. joined", "D. was in"), "B", "**【解析】** *for three years* 提示需要延续性动词。*join* 是瞬间动作，需改为 *be in*。故选 **B**。", "**【红线】** 严禁出现 *has joined for...* 这种非法结构。", "我表哥参军三年了。他是一名勇敢的士兵。"),
                PastExamQuestion("2024", "广东", "I ______ this book twice, but I still find it difficult to understand.", listOf("A. read", "B. have read", "C. will read", "D. readed"), "B", "**【解析】** *twice* 提示动作发生的累计次数，属于经验性用法。故选 **B**。", "**【标志】** 次数副词是经验完成时的雷达。", "这本书我已经读了两次，但我还是觉得很难理解。"),
                PastExamQuestion("2024", "天津", "— Where is Li Hua?\n— He ______ to the library. He will be back in an hour.", listOf("A. has been", "B. has gone", "C. went", "D. goes"), "B", "**【解析】** “人不在场”且“一小时后回来”，说明去了未回。故选 **B**。", "**【辨析】** *been to* (去过已回) vs *gone to* (去了未回)。", "—— 李华在哪？ —— 他去图书馆了。他一小时后回来。"),
                PastExamQuestion("2023", "江苏南京", "It ______ three years since I ______ to this school.", listOf("A. is; come", "B. was; came", "C. has been; came", "D. is; have come"), "C", "**【解析】** *since* 引导从句用过去时，主句用完成时。故选 **C**。", "**【公式】** *It is/has been + 时间 + since + 过去时*。", "自从我来到这所学校，已经三年了。"),
                PastExamQuestion("2022", "四川成都", "— How long ______ you ______ this bike?\n— For two months.", listOf("A. have; bought", "B. have; had", "C. did; buy", "D. do; have"), "B", "**【解析】** *How long* 询问长度，谓语须用延续性动词。*buy* 须转换为 *have*。故选 **B**。", "**【注意】** 完成时问句中的瞬间动词转换陷阱。", "—— 这辆自行车你买多久了？ —— 两个月了。"),
                PastExamQuestion("2021", "河南", "We ______ great progress in our English study so far.", listOf("A. make", "B. made", "C. have made", "D. will make"), "C", "**【解析】** *so far* (到目前为止) 是现在完成时的经典标志词。故选 **C**。", "**【标志】** *so far* 锁定完成时。", "到目前为止，我们在英语学习上取得了巨大进步。"),
                PastExamQuestion("2020", "安徽", "— Have you finished your homework ______?\n— Yes, I have ______ finished it.", listOf("A. yet; already", "B. already; yet", "C. yet; yet", "D. already; already"), "A", "**【解析】** *yet* 用于疑问句句末；*already* 用于肯定句中。故选 **A**。", "**【占位】** 掌握标志词的物理分布特征。", "—— 你完成作业了吗？ —— 是的，我已经完成了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Have you read Treasure Island yet? No, I haven't, but I have already finished reading Little Women. It has changed my way of thinking since I bought the book. I have kept it for two years.", listOf(
                    HighlightedSentence("Have you read... yet?", "**【询问经验】** *yet* 在句末展现了对进度的关切。"),
                    HighlightedSentence("have kept it", "**【延续转换】** 使用 *keep* 替代瞬间动词 *buy* 的状态延续。")
                ), "人教版 (Go for it!) 八下 Unit 8"),
                TextbookParagraph("I have been a member of the school team since 2021. Our team has won many matches so far. We have worked hard together and made great progress in the past years.", listOf(
                    HighlightedSentence("since 2021", "**【时间轴】** 以过去某点为起点延伸至今。"),
                    HighlightedSentence("so far", "**【累计成果】** 强调阶段性的汇总结果。")
                ), "外研版 (New Standard) 九下 Module 3"),
                TextbookParagraph("Where is Mom? She has gone to the supermarket to buy some food for dinner. She has been away for half an hour. I think she will be back soon.", listOf(
                    HighlightedSentence("has gone to", "**【不在场逻辑】** 明确指向一个向外的、未完成的回环。"),
                    HighlightedSentence("has been away", "**【状态延续】** 描述离开状态持续的长度。")
                ), "沪教版 (Oxford) 八上 Unit 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("I have been to Beijing several times and I really love the old buildings there.", "我去过北京好几次，非常喜欢那里的古老建筑。", "**【分析】** 强调个人的生命经历，人目前在场。", "基础必会 (Simple)"),
                ExampleSentence("My father has had this car since I was a little child in primary school.", "自从我还是个小学生起，我父亲就拥有这辆车了。", "**【分析】** 典型的瞬间动词转换（*buy -> have*）与 *since* 从句的配合。", "中考核心 (Complex)"),
                ExampleSentence("How long have you been in the school art club as a talented painter?", "作为一名有天赋的画家，你在学校艺术社团待多久了？", "**【分析】** 对持续时间的提问，谓语动词锁定为延续态。", "高阶句式 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **瞬间动词错配**：受汉语“参军三年”影响写出 *has joined for 3 years*。\n2. **been/gone 不分**：分不清动作是否完成回环。\n3. **since 陷阱**：在 *since* 引导的从句中误用完成时。"),
                TeachingNote("【教学金钥】备忘清单", "1. **瞬间变长对照表**：强制背诵 10 组核心转换对（*borrow-keep, buy-have* 等）。\n2. **回环示意图**：画一个圈代表 *been to*，画一个向外的箭头代表 *gone to*。\n3. **点线模型**：点代表过去时，线代表完成时，演示逻辑差异。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *for/since* 必找延续性动词；看到 *yet* 检查是否为疑问或否定；看到次数 (*twice* 等) 锁定完成时。")
            ),
            famousQuote = "What is past is prologue.",
            quoteAuthor = "William Shakespeare",
            quoteTranslation = "凡是过去，皆为序章。",
            quoteAnalysis = "本句展示了完成时态在宏观历史叙事中的逻辑延伸感，强调过去与未来的联结。"
        )'''

pattern_present_perfect = re.compile(r'KnowledgePoint\(\s+id = "present_perfect",.*?^\s+\),', re.DOTALL | re.MULTILINE)

new_content = pattern_present_perfect.sub(lambda _: new_present_perfect + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_content)

print("Success")
