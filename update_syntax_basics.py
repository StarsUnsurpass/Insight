import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 句子种类 (Sentence Types) ---
new_sentence_types = r'''        KnowledgePoint(
            id = "sentence_types",
            section = SEC_3,
            title = "句子种类 (Sentence Types)",
            description = """
### 📖 核心概念详解

句子种类按交际职能分为陈述句、疑问句、祈使句和感叹句。

#### 1. 疑问句的四大家族
| 类别 | 物理构成特征 | 回答逻辑 |
| :--- | :--- | :--- |
| **一般疑问句** | *Be/Do/助动词/情态动词* 开头 | *Yes / No* |
| **特殊疑问句** | *疑问词 + 一般疑问语序* | 根据疑问词回答具体信息 |
| **选择疑问句** | *句 A + or + 句 B* | 二选一回答，忌用 *Yes/No* |
| **反义疑问句** | *陈述部分 + 附加简短问句* | 前肯后否，前否后肯 |

#### 2. 反义疑问句的“否定陷阱” (核心考位)
> 💡 **隐性否定词**：若陈述部分包含 *few, little, never, hardly, seldom, nobody, nothing* 等，附加部分必须用 **肯定**。
> *   示例：*He can **hardly** speak English, **can** he?*

#### 3. 感叹句的中心语判定法
1.  ***What*** 引导：修饰名词。
    *   *What + (a/an) + adj. + 名词 (+主谓)!*
2.  ***How*** 引导：修饰形容词或副词。
    *   *How + adj./adv. (+主谓)!*
> 💡 **技巧**：遮住主谓，末尾是名词选 *What*，是形/副选 *How*。

#### 4. 祈使句的混合逻辑
*   ***祈使句 + and + 陈述句***：表示“如果...就...”。
*   ***祈使句 + or + 陈述句***：表示“快点，否则...”。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【功能判定】** 熟练区分四类句子的语气差异，掌握陈述句向各类疑问句的物理转换规律。",
                "**【反义疑问】** 深度掌握 10 种以上特殊反义疑问句（如 *Let's* 开头、隐性否定、*I am* 结构等）。",
                "**【感叹互换】** 精准掌握 *What* 与 *How* 结构的互换逻辑，重点处理不可数名词感叹句。",
                "**【祈使语气】** 掌握祈使句的否定形态 (*Don't do*) 及其在复合逻辑句中的连接词选择。",
                "**【选择回答】** 明确选择疑问句的回答禁止使用 *Yes/No* 的交际红线。",
                "**【陈述化转换】** 掌握疑问句进入宾语从句后的陈述语序平移规则。"
            ),
            relatedPoints = listOf(
                RelatedPoint("简单句基本句型", "语法的微观基石", "句子种类是基本句型在语气和情感维度的变体。"),
                RelatedPoint("连词 (Conjunctions)", "祈使句的逻辑纽带", "*and* 与 *or* 在祈使句复合结构中起到了逻辑触发的作用。"),
                RelatedPoint("宾语从句", "语序的重塑", "宾语从句考查的核心即是将疑问句种类物理性还原为陈述语序。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "— ______ amazing story it is!\n— Yes, I have never read such a good book.", listOf("A. What", "B. What an", "C. How", "D. How an"), "B", "**【解析】** *story* 是可数名词单数，*amazing* 以元音音素开头。物理结构为 *What + an + adj. + n.*。故选 **B**。", "**【注意】** 遮住 *it is*，末尾是名词 *story*，锁定 *What*。", "—— 多么神奇的一个故事啊！ —— 是的，我从未读过这么好的书。"),
                PastExamQuestion("2025", "天津", "He can hardly speak French, ______ he?", listOf("A. can", "B. can't", "C. does", "D. doesn't"), "A", "**【解析】** *hardly* 是隐性否定词，附加问句用肯定。故选 **A**。", "**【陷阱】** 容易被陈述部分没有 *not* 迷惑而选 B。", "他几乎不会说法语，是吗？"),
                PastExamQuestion("2024", "广东", "Work hard, ______ you will make great progress.", listOf("A. and", "B. or", "C. but", "D. so"), "A", "**【解析】** “祈使句 + and + 正面结果”。故选 **A**。", "**【逻辑】** 顺承关系，表示“那么”。", "努力学习，你就会取得巨大进步。"),
                PastExamQuestion("2024", "上海", "— ______ fine weather it is today!\n— Let's go for a picnic.", listOf("A. What", "B. What a", "C. How", "D. How a"), "A", "**【解析】** *weather* 是不可数名词，不能加冠词 *a/an*。故选 **A**。", "**【难点】** 识别不可数名词是感叹句的物理红线。", "—— 今天天气真好啊！ —— 我们去野餐吧。"),
                PastExamQuestion("2023", "江苏南京", "There is little water in the bottle, ______ there?", listOf("A. is", "B. isn't", "C. are", "D. aren't"), "A", "**【解析】** *little* 表否定，反义疑问句用肯定。*There be* 结构主语对应 *there*。故选 **A**。", "**【双重考位】** 隐性否定 + *There be* 后缀。", "瓶子里几乎没水了，是吗？"),
                PastExamQuestion("2022", "湖北武汉", "— ______ does it take to walk to the station?\n— About ten minutes.", listOf("A. How long", "B. How soon", "C. How often", "D. How far"), "A", "**【解析】** 询问时间长度。故选 **A**。", "**【特殊疑问词】** 掌握 *How* 家族的各种维度提问。", "—— 步行去车站要多久？ —— 大约十分钟。"),
                PastExamQuestion("2021", "河南", "Let's go to the museum this weekend, ______?", listOf("A. shall we", "B. will you", "C. won't you", "D. don't we"), "A", "**【解析】** *Let's* 开头的祈使句包含对方在内，后缀固定为 *shall we*。故选 **A**。", "**【辨析】** *Let us* (不含对方) 后缀用 *will you*。", "这周末我们去博物馆吧，好吗？"),
                PastExamQuestion("2020", "安徽", "— ______ do you visit your grandparents?\n— Once a week.", listOf("A. How long", "B. How soon", "C. How often", "D. How far"), "C", "**【解析】** 询问频率用 *How often*。故选 **C**。", "**【频度提问】** 对应关系判定。", "—— 你多久看望一次祖父母？ —— 每周一次。"),
                PastExamQuestion("2019", "福建", "Don't make any noise in the library, ______?", listOf("A. will you", "B. won't you", "C. shall we", "D. do you"), "A", "**【解析】** 否定祈使句的后缀固定用 *will you*。故选 **A**。", "**【固定格式】** 祈使句后缀的物理公式。", "别在图书馆里吵闹，好吗？"),
                PastExamQuestion("2018", "山东济南", "— Would you like some tea ______ coffee?\n— Tea, please.", listOf("A. and", "B. or", "C. but", "D. so"), "B", "**【解析】** 选择疑问句。故选 **B**。", "**【逻辑】** 非此即彼的选择语境。", "—— 你想要点茶还是咖啡？ —— 请给我茶。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("What a wonderful concert the students gave! Everyone was excited. How beautifully they played the music! Don't forget to give them a big hand.", listOf(
                    HighlightedSentence("What a wonderful concert!", "**【感叹结构】** 修饰中心词 *concert*，由于是单数可数名词，必须由 *a* 领航。"),
                    HighlightedSentence("How beautifully they played!", "**【感叹结构】** 修饰副词 *beautifully*，展示了动作的优美程度。"),
                    HighlightedSentence("Don't forget to...", "**【否定祈使】** 用于提出明确的建议或要求。")
                ), "人教版 (Go for it!) 七上 Unit 3"),
                TextbookParagraph("Hurry up, or you will miss the bus. If you are late, the teacher won't be happy. Why not set an alarm clock earlier next time?", listOf(
                    HighlightedSentence("Hurry up, or you...", "**【混合句式】** 使用连词 *or* 表达不执行动作的负面后果。"),
                    HighlightedSentence("Why not set...?", "**【特殊疑问变体】** 表达提议的固定结构，本质是省略了主谓的询问。")
                ), "外研版 (New Standard) 八下 Module 6")
            ),
            exampleSentences = listOf(
                ExampleSentence("What bad weather it is for a football match in the open air today!", "今天的露天足球赛天气多么糟糕啊！", "**【分析】** *weather* 是不可数名词，感叹句结构中严禁加 *a/an*。", "基础必会 (Simple)"),
                ExampleSentence("He has never been late for school, has he?", "他上学从未迟到过，是吗？", "**【分析】** 包含隐性否定词 *never* 的反义疑问句。", "中考核心 (Simple)"),
                ExampleSentence("Open the window to let in some fresh air, won't you?", "打开窗户让新鲜空气进来，好吗？", "**【分析】** 肯定祈使句后缀用 *won't you* 表示委婉语气。", "高阶句法 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **感叹混淆**：看到形容词就想选 *How*，忽略了后面的名词主体。\n2. **后缀失误**：在反义疑问句中识别不出 *few, little* 的否定性。\n3. **选择回答**：习惯性回答 *Yes/No* 导致逻辑断裂。"),
                TeachingNote("【教学金钥】备忘清单", "1. **遮盖判定法**：教给学生感叹句“遮住主谓看末尾”的物理口诀。\n2. **否定词清单**：将 *few, little, never* 等编成“否定家族”重点记忆。\n3. **语气轴**：通过语调起伏演示祈使句后缀 *will you* 与 *won't you* 的委婉度差异。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *little/never* 选肯定后缀；看到名词末尾找 *What*；选择疑问句不选 *Yes*。")
            ),
            famousQuote = "Actions speak louder than words!",
            quoteAuthor = "Abraham Lincoln",
            quoteTranslation = "行动胜于言辞！",
            quoteAnalysis = "本句展示了感叹句在表达坚定信念与强烈情感时的爆发力。"
        )'''

# --- 2. 五大基本句型 (Five Basic Sentence Patterns) ---
new_five_basic_patterns = r'''        KnowledgePoint(
            id = "five_basic_patterns",
            section = SEC_3,
            title = "五大基本句型 (Five Basic Sentence Patterns)",
            description = """
### 📖 核心概念详解

五大基本句型是英语所有长难句的“基因骨架”。

#### 1. 物理结构矩阵
| 符号 | 结构名称 | 核心逻辑 | 经典示例 |
| :--- | :--- | :--- | :--- |
| **S+V** | 主 + 谓 | 动作不涉及承受者 | *The sun rises.* |
| **S+V+P** | 主 + 系 + 表 | 描述主语的状态/特征 | *She looks happy.* |
| **S+V+O** | 主 + 谓 + 宾 | 动作直接涉及承受者 | *I love music.* |
| **S+V+InO+DO** | 主 + 谓 + 间宾 + 直宾 | 给某人某物 | *Give me a book.* |
| **S+V+O+OC** | 主 + 谓 + 宾 + 宾补 | 宾语需补充说明 | *Make me happy.* |

#### 2. 双宾语的“位置置换” (核心考位)
> 💡 **物理公式**：**V + 人 + 物 = V + 物 + to/for + 人**
> *   ***to*** (侧重方向)：*give, show, tell, bring*
> *   ***for*** (侧重目的)：*buy, make, get, cook*

#### 3. 宾语补足语的“形态万花筒”
宾补可以是：
1.  **形容词**：*Keep the room **clean**.*
2.  **名词**：*We call him **Tom**.*
3.  **不带 to 不定式**：*Let him **go**.*
4.  **分词**：*I saw her **dancing**.*

#### 4. 形式宾语 it
*   **物理公式**：***find/think it + adj. + to do sth.***
*   这里的 *it* 只是占位，真正的逻辑宾语是后文的不定式。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【骨架提取】** 能在各种复杂长难句中迅速剥离修饰语，识别核心物理句型结构。",
                "**【系表判定】** 熟练掌握 5 类感官系动词及变化系动词后接形容词的表语结构。",
                "**【双宾介词】** 精准区分 *to* 与 *for* 在双宾置换中的动词归属（20 个以上高频词）。",
                "**【宾补形态】** 掌握 *keep, make, find, help* 后接不同形态宾补（名、形、动）的规则。",
                "**【形式宾语】** 深度掌握 *find it adj to do* 句型，理解 *it* 的占位与逻辑指向。",
                "**【成分分析】** 能够对复杂长句进行主、谓、宾、状、定、补的深度句法解构。"
            ),
            relatedPoints = listOf(
                RelatedPoint("动词基础", "语义的决定权", "动词的及物性与系动词属性直接决定了整个句型的走向。"),
                RelatedPoint("宾语从句", "成分的填充", "宾语从句在宏观上本质上是填充了宾语这一物理单元。"),
                RelatedPoint("被动语态", "成分的位移", "被动语态实质上是宾语主语化后的句型物理重组。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "上海", "Our English teacher often tells ______ interesting stories.", listOf("A. we", "B. us", "C. our", "D. ours"), "B", "**【解析】** *tells* 是双宾动词，后接人称代词宾格 *us* 作间宾。故选 **B**。", "**【注意】** 区分代词格位与句法成分的对应关系。", "我们的英语老师经常给我们讲有趣的故事。"),
                PastExamQuestion("2025", "北京", "Winning the competition made him ______ beyond words.", listOf("A. happily", "B. happiness", "C. happy", "D. to happy"), "C", "**【解析】** *make sb. + adj.* 结构，形容词 *happy* 作宾补。故选 **C**。", "**【陷阱】** 容易受中文“高兴地”影响而选副词 A。", "赢得比赛让他高兴得无法形容。"),
                PastExamQuestion("2024", "广东", "I found ______ impossible to finish the work alone.", listOf("A. it", "B. that", "C. this", "D. /"), "A", "**【解析】** *it* 作形式宾语，真正的宾语是不定式。故选 **A**。", "**【公式】** *find it + adj. + to do*。", "我发现一个人完成这项工作是不可能的。"),
                PastExamQuestion("2024", "天津", "Please ______ me your photos when you come back.", listOf("A. show", "B. tell", "C. look", "D. talk"), "A", "**【解析】** *show sb. sth.* 双宾结构。故选 **A**。", "**【基础】** 动词语义与句型的匹配。", "当你回来的时候请给我看看你的照片。"),
                PastExamQuestion("2023", "江苏南京", "The music sounds ______ and I like it very much.", listOf("A. sweet", "B. sweetly", "C. sweetness", "D. to sweet"), "A", "**【解析】** *sound* 是系动词，后接形容词作表语。故选 **A**。", "**【规则】** 系动词后禁止匹配副词。", "这音乐听起来很甜美，我非常喜欢。"),
                PastExamQuestion("2022", "湖北武汉", "He promised ______ me a beautiful gift for my birthday.", listOf("A. buy", "B. to buy", "C. buying", "D. bought"), "B", "**【解析】** *promise to do sth.* 不定式作宾语。故选 **B**。", "**【结构】** *S + V + O* 句型应用。", "他承诺给我买一份漂亮的生日礼物。"),
                PastExamQuestion("2021", "河南", "My parents bought a new bike ______ me yesterday.", listOf("A. to", "B. for", "C. with", "D. at"), "B", "**【解析】** *buy sth. for sb.* 固定置换介词。故选 **B**。", "**【辨析】** *buy* 强调“为了”，用 *for*。", "我父母昨天给我买了一辆新自行车。"),
                PastExamQuestion("2020", "安徽", "Keep the classroom ______ and tidy, please.", listOf("A. clean", "B. cleaning", "C. to clean", "D. cleaned"), "A", "**【解析】** *keep + n. + adj.* 结构，形容词作宾补。故选 **A**。", "**【状态】** 宾补描述事物的状态。", "请保持教室干净整洁。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("The classical music sounds sweet. It makes me feel relaxed. My parents bought me a CD player for my birthday.", listOf(
                    HighlightedSentence("The music sounds sweet", "**【S+V+P】** 展示了感官系动词的基本骨架。"),
                    HighlightedSentence("makes me feel relaxed", "**【S+V+O+OC】** *feel relaxed* 作为宾补说明我的状态。"),
                    HighlightedSentence("bought me a CD player", "**【S+V+InO+DO】** 典型的双宾语结构。")
                ), "人教版 (Go for it!) 八上 Unit 4"),
                TextbookParagraph("We found the film very interesting. It tells a great story about a brave dog. We should learn from its courage.", listOf(
                    HighlightedSentence("found the film very interesting", "**【S+V+O+OC】** 形容词短语补充说明电影的特征。"),
                    HighlightedSentence("tells a story", "**【S+V+O】** 英语中最具代表性的及物动词骨架。")
                ), "外研版 (New Standard) 九下 Module 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("The birds are singing loudly in the tall trees today.", "今天鸟儿在树上大声唱歌。", "**【分析】** *S+V* 结构，*sing* 是不及物动词，后接状语。", "基础必会 (Simple)"),
                ExampleSentence("Please pass me the salt and pepper on the table.", "请把桌上的盐和胡椒粉递给我。", "**【分析】** *S+V+InO+DO* 结构，包含两个名词宾语。", "基础必会 (Simple)"),
                ExampleSentence("I found it difficult to master a foreign language in a year.", "我发现一年内精通一门外语是很困难的。", "**【分析】** 形式宾语 *it* 与真正的宾语不定式构成的复杂句。", "中考核心 (Complex)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **宾补误用副词**：物理性混淆宾补与状语（如 *make him happily*）。\n2. **双宾介词用反**：分不清 *buy for* 与 *give to* 的逻辑动力。\n3. **系动词后遗症**：在系动词后习惯性添加 *to* 或用副词。"),
                TeachingNote("【教学金钥】备忘清单", "1. **积木搭建法**：利用彩色卡片代表主谓宾补，进行物理拼凑练习。\n2. **剥洋葱法**：在长难句中，先划掉定语和状语，露出骨干句型。\n3. **介词归类网**：将 *to* 家族与 *for* 家族的动词进行网格化对比记忆。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *make/keep* 找形容词宾补；看到 *buy/make* 找 *for* 介词。")
            ),
            famousQuote = "Practice makes perfect.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "熟能生巧。",
            quoteAnalysis = "本句是典型的 *S+V+O+OC* 结构，生动展示了动作导致结果的句法逻辑。"
        )'''

# --- 执行替换 ---
pattern_sentence_types = re.compile(r'KnowledgePoint\(\s+id = "sentence_types",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_five_basic_patterns = re.compile(r'KnowledgePoint\(\s+id = "five_basic_patterns",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_sentence_types.sub(lambda _: new_sentence_types + ',', content)
content = pattern_five_basic_patterns.sub(lambda _: new_five_basic_patterns + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
