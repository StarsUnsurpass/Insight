import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 动词基础 (Verbs Basic) ---
new_verbs_basic = r'''        KnowledgePoint(
            id = "verbs_basic",
            section = SEC_2,
            title = "动词基础 (Verbs)",
            description = """
### 📖 核心概念详解

动词 (Verbs) 是英语句子的“心脏”。

#### 1. 动词的四大分类
| 类别 | 职能 | 经典示例 |
| :--- | :--- | :--- |
| **实义动词** | 表达具体动作/状态 | *run, eat, think, sleep* |
| **系动词** | 连接主语与特征 | *be, look, become, stay, smell* |
| **助动词** | 辅助构成时态/否定 | *do, does, did, have, has, will* |
| **情态动词** | 表达语气/推测 | *can, must, may, should, need* |

#### 2. 情态动词表推测 (中考高阶)
> 💡 **可能性的物理等级**：
> 1.  ***must be***：100% 肯定 (*It must be Lily's.*)
> 2.  ***may/might/could be***：不确定推测 (*It may be true.*)
> 3.  ***can't be***：100% 否定 (*It can't be him. He's away.*)
> ⚠️ **注意**：*mustn't* 表禁止，不能用于推测。

#### 3. 经典易混淆动词 ( lie vs lay )
| 原形 | 含义 | 过去式 | 过去分词 | 现在分词 |
| :--- | :--- | :--- | :--- | :--- |
| **lie** | 躺；位于 | **lay** | **lain** | *lying* |
| **lie** | 撒谎 | *lied* | *lied* | *lying* |
| **lay** | 放置；下蛋 | **laid** | **laid** | *laying* |
""".trimIndent(),
            syllabusDetails = listOf(
                "**【分类职能】** 深刻掌握实义、系、助、情四类动词在句中的物理功能位置。",
                "**【推测逻辑】** 掌握情态动词表推测的肯定/否定逻辑链条，重点区分 *can't* 与 *mustn't*。",
                "**【形态辨析】** 强制背诵 *lay/lie, rise/raise, hang* 等高频易混动词的四类形态。",
                "**【系动词矩阵】** 掌握感官类、变化类、持续类系动词后接形容词的标准用法。",
                "**【动词短语】** 掌握动副短语接代词宾语时‘宾语居中’的占位规则（如 *put it on*）。",
                "**【使役感官】** 掌握 *make, let, have* 与感官动词 *see, hear* 的宾补结构及其被动还原规则。"
            ),
            relatedPoints = listOf(
                RelatedPoint("时态与语态", "动词的物理载体", "所有时态的变化最终都体现在动词形态的切换上。"),
                RelatedPoint("形容词", "系动词的搭档", "形容词作为表语时，其物理入口通常是系动词。"),
                RelatedPoint("非谓语动词", "动词的分身", "非谓语动词本质上是丧失了时间属性但保留了动作语义的变体。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— Is that Lily's schoolbag?\n— It ______ be hers. She has gone to the library.", listOf("A. must", "B. can't", "C. may", "D. needn't"), "B", "**【解析】** “她已经背着包去图书馆了”这一事实推导出“书包不可能是她的”。故选 **B**。", "**【注意】** *can't be* 表示有把握的否定推测。", "—— 那是莉莉的书包吗？ —— 一定不是她的。她已经带着书包去图书馆了。"),
                PastExamQuestion("2025", "天津", "The soup ______ delicious. Would you like some?", listOf("A. sounds", "B. tastes", "C. feels", "D. looks"), "B", "**【解析】** 描述汤的味道用感官系动词 *taste*。故选 **B**。", "**【基础】** 感官动词语义匹配。", "这汤尝起来很鲜美。你要来点吗？"),
                PastExamQuestion("2024", "上海", "You ______ smoke here. Look at the sign 'No Smoking'!", listOf("A. mustn't", "B. needn't", "C. couldn't", "D. shouldn't"), "A", "**【解析】** *mustn't* 表示强烈的禁止。故选 **A**。", "**【辨析】** *needn't* 意为没必要。", "你绝对不能在这里抽烟。看那个‘禁止吸烟’的牌子！"),
                PastExamQuestion("2023", "江苏南京", "The little boy ______ on the grass and looked at the sky just now.", listOf("A. lie", "B. lay", "C. laid", "D. lied"), "B", "**【解析】** *just now* 提示过去时。“躺”的过去式是 *lay*。故选 **B**。", "**【形态陷阱】** *lay* 是 *lie* 的过去式。", "那个小男孩刚才躺在草地上看天空。"),
                PastExamQuestion("2022", "湖北武汉", "— Must I finish my homework today?\n— No, you ______. You can do it tomorrow.", listOf("A. mustn't", "B. shouldn't", "C. needn't", "D. can't"), "C", "**【解析】** *Must* 引导的疑问句，否定回答常用 *needn't* 或 *don't have to*。故选 **C**。", "**【交际】** 语气应答的固定模式。", "—— 我必须今天完成作业吗？ —— 不，没必要。你可以明天做。"),
                PastExamQuestion("2021", "河南", "The price of the car ______ too high for me to afford.", listOf("A. seems", "B. looks", "C. smells", "D. tastes"), "A", "**【解析】** 描述某种主观感觉或情况用 *seem*。故选 **A**。", "**【语义】** 价格属性的系动词判定。", "这辆车的价格对我来说似乎太高，买不起。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When we meet new people, we should smile and say hello. This simple action can help us make a good first impression.", listOf(
                    HighlightedSentence("should smile", "**【情态建议】** 使用 *should* 表达一种礼貌性的行为指南。"),
                    HighlightedSentence("make a good impression", "**【使役逻辑】** 展示了 *make* 在构建结果性语义中的作用。")
                ), "人教版 (Go for it!) 七上 Unit 3"),
                TextbookParagraph("The music sounds sweet. I like listening to it. My mother always tells me that we should eat healthy food to keep fit.", listOf(
                    HighlightedSentence("sounds sweet", "**【感官系动词】** *sound* 后接形容词原级表达感知。"),
                    HighlightedSentence("keep fit", "**【状态系动词】** *keep* 表达维持某种状态。")
                ), "外研版 (New Standard) 八下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("He lay on the grass and thought about his future plans just now.", "他刚才躺在草地上思考他的未来计划。", "**【分析】** 重点演示 *lie* 的过去式物理形态。", "高频易错 (Simple)"),
                ExampleSentence("You must be tired after such a long walk. Sit down and have a rest.", "走了这么长路你一定累了。坐下歇会儿。", "**【分析】** 情态动词表推测的最典型语境。", "基础必会 (Simple)"),
                ExampleSentence("It seems that everything is ready for the upcoming big event.", "似乎为即将到来的重大活动一切都准备好了。", "**【分析】** *It seems that...* 结构的系动词高级变体。", "中考核心 (Complex)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **形态混乱**：*lie/lay* 的物理形态交叉是绝大多数学生的噩梦。\n2. **推测误区**：在否定推测中误用 *mustn't* 而非 *can't*。\n3. **宾语位置**：写出 *put on it* (应为 *put it on*)。"),
                TeachingNote("【教学金钥】备忘清单", "1. **lie/lay 形态树**：通过口诀‘规则撒谎，不规则躺，lay 是下蛋或放置’辅助记忆。\n2. **推测百分比法**：must (100%) -> may (50%) -> can't (0%)。\n3. **身体演示法**：做动作练习 *raise* (举起) 与 *rise* (升起)。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *Must* 问句，找 *needn't*；看到否定推测，找 *can't*；看到系动词，划掉副词选项。")
            ),
            famousQuote = "Action speaks louder than words.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "行动胜于言辞。",
            quoteAnalysis = "展现了行为动词在表达坚定决心与事实判定中的核心地位。"
        )'''

# --- 2. 非谓语动词 (Non-finite Verbs) ---
new_non_finite_verbs = r'''        KnowledgePoint(
            id = "non_finite_verbs",
            section = SEC_2,
            title = "非谓语动词 (Non-finite Verbs)",
            description = """
### 📖 核心概念详解

非谓语动词 (Non-finite Verbs) 是英语句法中的“斜杠动词”，它们不担任谓语，但拥有动词的语义及名、形、副的职能。

#### 1. 三大物理类别
| 类别 | 核心物理特征 | 逻辑侧重 |
| :--- | :--- | :--- |
| **不定式 (to do)** | 物理标志：*to* | 将来、目的、具体一次性动作 |
| **动名词 (doing)** | 物理标志：*-ing* | 习惯、爱好、抽象概念 |
| **分词 (done/doing)** | 物理标志：分词形态 | 形容词化，表主动/被动/完成 |

#### 2. “记忆方向”大不同 (核心难点)
*   **forget/remember + to do**：忘记/记得 **去做** 某事 (动作未发生)。
*   **forget/remember + doing**：忘记/记得 **做过** 某事 (动作已发生)。
*   **stop + to do**：停下手中的事，**去做** 另一件事。
*   **stop + doing**：**停止** 正在做的事。

#### 3. 只能接 doing 作宾语的“俱乐部”
> 💡 **中考必背口诀**：
> *喜欢 (*enjoy*), 完成 (*finish*), 练习 (*practice*), 介意 (*mind*), 建议 (*suggest*)...*
> ⚠️ **注意**：介词 (*of, in, at, to*等) 后面若有动词，必须物理锁定 ***doing***。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【职能判定】** 深刻理解非谓语动词不充当谓语的本质，掌握其名、形、副的句法角色。",
                "**【不定式应用】** 熟练掌握不定式作宾语、宾补、目的状语及形式主语 (*It is adj to do*) 的结构。",
                "**【doing俱乐部】** 强制熟记只能接 *doing* 的 15 个核心高频动词（*enjoy, finish, practice*等）。",
                "**【逻辑对立】** 深度辨析 *forget, remember, stop, regret* 后接 *to do* 与 *doing* 的时空对立。",
                "**【疑问+to do】** 掌握‘疑问词 + 不定式’结构及其与宾语从句的等值逻辑转换。",
                "**【介词宾语】** 明确介词后动词必须 *ing* 化的铁律，重点处理 *to* 是介词的特殊场景。"
            ),
            relatedPoints = listOf(
                RelatedPoint("宾语从句", "结构的简化形式", "‘疑问词 + 不定式’是宾语从句在中考应用中最常见的简化平替。"),
                RelatedPoint("介词 (Prepositions)", "doing 的生存土壤", "大多数介词物理上要求其后续动词必须以动名词形态出现。"),
                RelatedPoint("主谓一致", "doing 作主语的单数性", "动名词短语作主语时，谓语动词必须锁定单数形态。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "Don't forget ______ the lights when you leave the room.", listOf("A. turn off", "B. to turn off", "C. turning off", "D. turned off"), "B", "**【解析】** *leave the room* 提示动作尚未发生，“别忘了去做某事”。故选 **B**。", "**【时空逻辑】** *to do* 指向未来，*doing* 指向过去。", "当你离开房间时，别忘了关灯。"),
                PastExamQuestion("2025", "上海", "He practiced ______ the piano every day to prepare for the competition.", listOf("A. play", "B. to play", "C. playing", "D. played"), "C", "**【解析】** *practice* 后固定接 *doing* 作宾语。故选 **C**。", "**【基础】** 动宾搭配的硬性规定。", "他每天练习弹钢琴，为比赛做准备。"),
                PastExamQuestion("2024", "广东", "We are looking forward to ______ you and your family soon.", listOf("A. see", "B. seeing", "C. saw", "D. seen"), "B", "**【解析】** *look forward to* 中的 *to* 是介词，后接 *doing*。故选 **B**。", "**【物理陷阱】** *to* 是介词还是不定式符号是中考第一陷阱。", "我们期待很快见到你和你的家人。"),
                PastExamQuestion("2023", "江苏南京", "It's important ______ us ______ English well in modern society.", listOf("A. for; to learn", "B. of; to learn", "C. for; learning", "D. of; learning"), "A", "**【解析】** *It is adj. for sb. to do* 形式主语句型。*learn* 是事物的特征。故选 **A**。", "**【句型】** 形式主语的标准配对。", "在现代社会学好英语对我们很重要。"),
                PastExamQuestion("2022", "湖北武汉", "I don't know ______ to solve the difficult math problem.", listOf("A. what", "B. how", "C. which", "D. why"), "B", "**【解析】** 疑问词 + 不定式。根据句意“如何解决”。故选 **B**。", "**【转换】** 此结构等于 *how I can solve*。", "我不知道如何解决这个数学难题。"),
                PastExamQuestion("2021", "河南", "I enjoy ______ books in the library when I am free.", listOf("A. read", "B. to read", "C. reading", "D. reads"), "C", "**【解析】** *enjoy* 后面必跟 *doing*。故选 **C**。", "**【习惯】** 表达爱好的固定模式。", "我有空的时候喜欢在图书馆看书。"),
                PastExamQuestion("2020", "安徽", "He stopped ______ a rest because he was too tired.", listOf("A. to have", "B. having", "C. had", "D. has"), "A", "**【解析】** “停下来去休息”。动作发生转变。故选 **A**。", "**【辨析】** *stop to do* 与 *stop doing* 的动作切换。", "他停下来休息了一会儿，因为他太累了。"),
                PastExamQuestion("2019", "福建", "It took me two hours ______ my homework yesterday.", listOf("A. finish", "B. finishing", "C. to finish", "D. finished"), "C", "**【解析】** *It takes sb. some time to do sth.* 经典句式。故选 **C**。", "**【公式】** 时间句型中的不定式占位。", "昨天花了我两个小时完成作业。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("I enjoy reading books because it helps me learn more. Yesterday, I forgot to bring my card, so I will remember to take it next time.", listOf(
                    HighlightedSentence("enjoy reading", "**【习惯性doing】** 用于表达持续的心理喜好。"),
                    HighlightedSentence("forgot to bring", "**【待办to do】** 描述尚未执行的动作。")
                ), "人教版 (Go for it!) 八上 Unit 1"),
                TextbookParagraph("Our teacher told us to keep practicing English every day. We are looking forward to having a good result in the exam.", listOf(
                    HighlightedSentence("tell sb to do", "**【不定式宾补】** 动作尚未执行，带有指令性意图。"),
                    HighlightedSentence("forward to having", "**【介词doing】** 这里的 *to* 具有极强的磁性，要求后续动词 *ing* 化。")
                ), "外研版 (New Standard) 九下 Module 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("He stopped to have a short rest after walking for three hours.", "走了三小时后，他停下来休息了一会儿。", "**【分析】** 重点在于动作的转移：停下走路，转向休息。", "基础必会 (Simple)"),
                ExampleSentence("It is polite to say hello to your neighbors when you meet them.", "见到邻居时主动打招呼是有礼貌的。", "**【分析】** 形式主语句式中不定式充当逻辑主语。", "基础必会 (Simple)"),
                ExampleSentence("I saw the boy drawing a beautiful picture when I passed his room.", "我经过他房间时，看到那个男孩正在画一幅漂亮的画。", "**【分析】** 感官动词 *see* 接 *doing* 强调目击了动作的正在进行感。", "中考核心 (Complex)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **物理混淆**：分不清 *to* 的两种身份（介词 vs 不定式符号）。\n2. **逻辑用反**：*remember* 后面的动词时态逻辑经常记反。\n3. **使役多 to**：在 *make/let* 后面习惯性加 *to*。"),
                TeachingNote("【教学金钥】备忘清单", "1. **时空坐标法**：Doing 代表‘过去/持续’，To do 代表‘未来/目的’。\n2. **doing俱乐部口诀**：编写顺口溜辅助记忆特定动词。\n3. **疑问词拼图**：练习将宾语从句拆解为‘疑问词+to do’。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *look forward to* 找 *doing*；看到 *adj. for/of sb.* 找 *to do*；看到 *stop* 检查是“停止”还是“转去做”。")
            ),
            famousQuote = "The only way to do great work is to love what you do.",
            quoteAuthor = "Steve Jobs",
            quoteTranslation = "成就伟大事业的唯一途径，就是热爱你所做的事。",
            quoteAnalysis = "本句展示了不定式在界定目标与定义方式时的核心作用。"
        )'''

# --- 执行替换 ---
pattern_verbs_basic = re.compile(r'KnowledgePoint\(\s+id = "verbs_basic",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_non_finite_verbs = re.compile(r'KnowledgePoint\(\s+id = "non_finite_verbs",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_verbs_basic.sub(lambda _: new_verbs_basic + ',', content)
content = pattern_non_finite_verbs.sub(lambda _: new_non_finite_verbs + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
