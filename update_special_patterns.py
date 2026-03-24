import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 特殊句式 (Special Patterns) ---
new_special_patterns = r'''        KnowledgePoint(
            id = "special_patterns",
            section = SEC_3,
            title = "特殊句式 (Special Sentence Patterns)",
            description = """
### 📖 核心概念详解

特殊句式是英语中的“滤镜”，用于强调特定信息或打破常规语气。

#### 1. There be 句型 (存现句)
> 💡 **权力靠近法**：谓语动词物理性随离它最近的主语变。
> *   *There **is** a book and two pens.*
> *   *There **are** two pens and a book.*
> ⚠️ **将来形态**：*There will be* / *There is going to be*。

#### 2. It 引导的语法丛林
1.  **形式主语**：*It is + adj. + (for/of sb.) + to do sth.*
2.  **形式宾语**：*find/think it + adj. + to do sth.*
3.  **强调句**：*It is/was + 被强调部分 + that/who + 其他.*

#### 3. 倒装句 (Inversion)
1.  **也/也不**：
    *   *So + 助动词 + 主语* (我也是)。
    *   *Neither/Nor + 助动词 + 主语* (我也不是)。
2.  **否定词首**：*Never/Hardly/Seldom* 等置于句首，主谓须部分倒装。

#### 4. So do I vs So I do
*   ***So do I***：我也是 (强调行为的一致性)。
*   ***So I do***：我的确如此 (强调对事实的确认)。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【就近原则】** 熟练掌握 *There be* 句型中谓语动词的物理指向规则。",
                "**【It占位符】** 深度掌握形式主语与形式宾语的句法物理模型，能识别不定式作为真正逻辑主语的功能。",
                "**【倒装逻辑】** 掌握 *so/neither* 引导的部分倒装句，确保助动词、时态与前句完美匹配。",
                "**【强调句识别】** 掌握强调句的基本公式，能区分强调句与定语从句、宾语从句的物理差异。",
                "**【混合逻辑】** 掌握‘祈使句 + 连词 + 结果’结构在特殊语境下的表现。",
                "**【There将来式】** 严格杜绝 *There will have* 等受汉语干扰的非法句式结构。"
            ),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "距离产生的逻辑", "*There be* 句型是中考考查就近原则的最核心场景。"),
                RelatedPoint("代词 (Pronouns)", "It的多重身份", "*It* 在特殊句式中充当的虚指成分是代词功能的高级体现。"),
                RelatedPoint("助动词", "倒装的支撑", "所有的部分倒装逻辑都必须依赖于助动词的物理前移。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— Li Hua won the gold medal in the competition.\n— ______. He worked really hard.", listOf("A. So he did", "B. So did he", "C. Neither did he", "D. So was he"), "A", "**【解析】** 后句证明了事实（的确赢了）。故选 **A**。", "**【注意】** *So he did* 表示对事实的确认，*So did he* 表示“他也赢了”。", "—— 李华在比赛中赢得了金牌。 —— 他的确赢了。他工作非常努力。"),
                PastExamQuestion("2025", "天津", "There ______ a football match on TV tonight.", listOf("A. will have", "B. is going to be", "C. is going to have", "D. was"), "B", "**【解析】** *There be* 句型将来时不能用 *have*。故选 **B**。", "**【红线】** *There will have* 是物理性禁区。", "今晚电视上将有一场足球赛。"),
                PastExamQuestion("2024", "广东", "— I have never been to Paris.\n— ______.", listOf("A. So have I", "B. Neither have I", "C. So I have", "D. Neither I have"), "B", "**【解析】** 否定句的“我也是”。*Neither + 助动词 + 主语*。故选 **B**。", "**【倒装】** 助动词必须物理前移至主语前。", "—— 我从未去过巴黎。 —— 我也没去过。"),
                PastExamQuestion("2024", "上海", "There ______ a book and some pens on the desk just now.", listOf("A. is", "B. are", "C. was", "D. were"), "C", "**【解析】** *There be* 就近原则。主语 *a book* 为单数；*just now* 提示过去。故选 **C**。", "**【双重考点】** 就近原则 + 时态判定。", "桌上刚才有一本书和几支笔。"),
                PastExamQuestion("2023", "江苏南京", "It ______ me three hours to finish the work yesterday.", listOf("A. takes", "B. took", "C. will take", "D. has taken"), "B", "**【解析】** *It takes sb. some time to do sth.* 句型。*yesterday* 提示过去时。故选 **B**。", "**【固定句式】** *It* 作形式主语的时间句型。", "昨天花了我三个小时完成这项工作。"),
                PastExamQuestion("2022", "湖北武汉", "— My father has never been abroad.\n— ______ my mother.", listOf("A. So has", "B. Neither has", "C. So is", "D. Neither is"), "B", "**【解析】** 否定句倒装。故选 **B**。", "**【一致性】** 助动词必须与前句的 *has* 呼应。", "—— 我爸爸从未出国。 —— 我妈妈也没去过。"),
                PastExamQuestion("2021", "河南", "I find ______ interesting to study history with my friends.", listOf("A. it", "B. that", "C. this", "D. /"), "A", "**【解析】** *it* 作形式宾语。故选 **A**。", "**【占位】** 识别形式化成分的物理位置。", "我发现和朋友一起学历史很有趣。"),
                PastExamQuestion("2020", "安徽", "There ______ some milk and two apples in the fridge.", listOf("A. is", "B. are", "C. was", "D. were"), "A", "**【解析】** *There be* 就近原则。*milk* 是不可数名词。故选 **A**。", "**【基础】** 经典就近原则考位。", "冰箱里有一些牛奶和两个苹果。"),
                PastExamQuestion("2019", "福建", "It's generous ______ him to provide so much help for us.", listOf("A. for", "B. of", "C. with", "D. to"), "B", "**【解析】** *generous* 是描述人的品质，介词用 *of*。故选 **B**。", "**【介词抉择】** *for* (事物特征) vs *of* (人物品质)。", "他提供这么多帮助对我们来说真是太慷慨了。"),
                PastExamQuestion("2018", "山东济南", "Only in this way ______ solve the problem in a short time.", listOf("A. you can", "B. can you", "C. you could", "D. could you"), "B", "**【解析】** *Only + 状语* 置于句首，触发部分倒装。故选 **B**。", "**【高阶倒装】** 限定性副词置顶的逻辑。", "只有用这种方法你才能在短时间内解决问题。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("There is a small park near our school. There are many green trees in it. It's a good place for us to relax and study. It takes five minutes to walk there.", listOf(
                    HighlightedSentence("There is a small park", "**【就近原则】** 谓语动词随单数名词 *park* 变动。"),
                    HighlightedSentence("It takes five minutes", "**【形式主语】** 展示了时间成本表达的标准句法骨架。")
                ), "人教版 (Go for it!) 七下 Unit 1"),
                TextbookParagraph("If you don't go to the party, neither will I. I think it is important for us to spend time together. So I hope you can change your mind.", listOf(
                    HighlightedSentence("neither will I", "**【部分倒装】** 助动词 *will* 物理性前移，表达否定意义的一致性。"),
                    HighlightedSentence("it is important for us", "**【形式主语】** 典型的 *It is adj. for sb. to do* 结构。")
                ), "外研版 (New Standard) 九下 Module 5"),
                TextbookParagraph("It was because of the rain that we were late. We found it difficult to get a taxi. There were hundreds of people waiting there.", listOf(
                    HighlightedSentence("It was because... that", "**【强调句】** 将原因部分置于 *It was...that* 之间进行语法聚焦。"),
                    HighlightedSentence("found it difficult to", "**【形式宾语】** *it* 代替后文沉重的不定式短语。")
                ), "沪教版 (Oxford) 九上 Unit 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("There is a world map and two English dictionaries on the desk.", "桌上有一张世界地图和两本英语字典。", "**【分析】** 重点展示 *There be* 句型中离谓语最近的名词决定其单复数。", "基础必会 (Simple)"),
                ExampleSentence("So hard did he study that he finally passed the exam successfully.", "他学习如此努力，以至于最终成功通过了考试。", "**【分析】** *So + adj.* 置于句首引起的部分倒装结构。", "高阶句法 (Complex)"),
                ExampleSentence("I found it impossible to master all the skills in such a short time.", "我发现短时间内掌握所有技能是不可能的。", "**【分析】** 形式宾语 *it* 保持了句子结构的平衡。 ", "中考核心 (Complex)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **There will have**：受母语直译影响最深的物理性错误。\n2. **So do I 误用**：分不清是“我也是”还是“我的确做了”。\n3. **强调句 vs 定从**：分不清 *that* 在句中是否充当成分（强调句中不充当成分）。"),
                TeachingNote("【教学金钥】备忘清单", "1. **镜子原理法**：解释 *So do I* 就像在照镜子，助动词必须一模一样。\n2. **权力中心图**：画出 *There be* 谓语与最近主语的连接线。\n3. **拆除测试法**：教学生遮住 *It is...that*，看剩余部分是否完整，以此判定强调句。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *neither/nor* 必选倒装语序；看到品质形容词 (*kind/generous*) 选 *of sb.*；看到 *There* 划掉 *have*。")
            ),
            famousQuote = "It is never too late to learn.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "活到老，学到老。",
            quoteAnalysis = "本句展示了 *It* 作为形式主语在构建具有普适真理感的警句时的优雅物理结构。"
        )'''

# --- 执行替换 ---
pattern_special_patterns = re.compile(r'KnowledgePoint\(\s+id = "special_patterns",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_special_patterns.sub(lambda _: new_special_patterns + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
