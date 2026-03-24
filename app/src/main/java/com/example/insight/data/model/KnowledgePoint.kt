package com.example.insight.data.model

data class ExampleProblem(
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String
)

data class PastExamQuestion(
    val year: String,
    val location: String,
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String,
    val errorProne: String? = null,
    val translation: String? = null
)

data class HighlightedSentence(
    val text: String,
    val analysis: String
)

data class TextbookParagraph(
    val content: String,
    val highlightedSentences: List<HighlightedSentence>,
    val source: String
)

data class ExampleSentence(
    val english: String,
    val chinese: String,
    val analysis: String? = null,
    val difficulty: String = "中考难度"
)

data class RelatedPoint(
    val title: String,
    val description: String,
    val connectionReason: String
)

data class TeachingNote(
    val title: String,
    val content: String
)

data class KnowledgePoint(
    val id: String,
    val section: String,
    val title: String,
    val description: String,
    val syllabusDetails: List<String>,
    val relatedPoints: List<RelatedPoint>,
    val exampleProblems: List<ExampleProblem>,
    val pastExamQuestions: List<PastExamQuestion>,
    val textbookParagraphs: List<TextbookParagraph>,
    val exampleSentences: List<ExampleSentence> = emptyList(),
    val teachingNotes: List<TeachingNote> = emptyList(),
    val famousQuote: String = "",
    val quoteTranslation: String = "",
    val quoteAnalysis: String = "",
    val quoteAuthor: String = ""
)

object KnowledgeProvider {
    const val SEC_1 = "板块一：词法体系 (Morphology)"
    const val SEC_2 = "板块二：时态与语态体系 (Tenses & Voices)"
    const val SEC_3 = "板块三：句法体系 (Syntax)"

    fun getPoint(id: String): KnowledgePoint? = allPoints.find { it.id == id }

    val allPoints = listOf(
        KnowledgePoint(
            id = "nouns",
            section = SEC_1,
            title = "名词 (Nouns)",
            description = """### 📖 核心概念详解
            
            名词 (Nouns) 是英语语言的“物质基础”，在中考评价中占据核心地位。
            
            #### 1. 范畴逻辑与界限划分
            名词分为 **专有名词** (Proper Nouns) 和 **普通名词** (Common Nouns)。
            
            | 类别 | 定义 | 示例 | 注意事项 |
            | :--- | :--- | :--- | :--- |
            | **专有名词** | 特定人、地、机构、节日 | *China, Monday, Christmas* | 首字母必须大写 |
            | **个体名词** | 单个的人或物 | *book, student* | 可数 |
            | **集体名词** | 一群人或物 | *family, police* | 主谓一致是难点 |
            | **物质名词** | 无法分为个体的物质 | *water, air, snow* | 通常不可数 |
            | **抽象名词** | 动作、状态、品质、情感 | *success, health, fun* | 通常不可数 |
            
            > 💡 **动态转化 (重点)**：中考常考词性的灵活运用。
            > * *success* (成功, 不可数) -> *a success* (一件成功的事, 可数)
            > * *experience* (经验, 不可数) -> *an experience* (一次经历, 可数)
            
            #### 2. “数”的精密体系 (Number)
            
            ##### **规则复数变化**
            | 结尾类型 | 变化规则 | 经典示例 |
            | :--- | :--- | :--- |
            | 一般情况 | 直接词尾 **+s** | *maps, bags, boys* |
            | -s, -x, -ch, -sh | 词尾 **+es** | *buses, boxes, watches, dishes* |
            | 辅音 + y | 变 y 为 **i + es** | *baby -> babies, city -> cities* |
            | -f, -fe | 变 f/fe 为 **v + es** | *thief, knife, leaf, life, half, wolf, wife, shelf, self* |
            | -o 结尾 | 有生命 **+es** / 无生命 **+s** | *heroes, tomatoes, potatoes* vs *pianos, photos* |
            
            ##### **不规则复数变化**
            *   **变元音**：*foot -> feet, tooth -> teeth, goose -> geese, man -> men, woman -> women*
            *   **变词尾**：*child -> children, ox -> oxen, mouse -> mice*
            *   **单复同形**：*sheep, deer, fish, Chinese, Japanese, Swiss*
            
            > ⚠️ **不可数名词核心禁区**：
            > 以下单词严禁加 -s 或 a/an：
            > `advice, news, information, progress, homework, housework, fun, weather, furniture, money`
            
            #### 3. “格”的归属逻辑 (Case)
            *   **'s 所有格**：用于有生命的对象。
            *   单数：*the boy's bag*
            *   以 -s 结尾的复数：*the teachers' office*
            *   **of 所有格**：用于无生命对象 (*the window of the classroom*)。
            *   **双重所有格**：*a friend of my father's* (强调是众多朋友中的一个)。
            *   **共同与各自所有**：
            *   *Lily and Lucy's room* (两人共有)
            *   *Lily's and Lucy's rooms* (每人各有一间)
            
            #### 4. 主谓一致陷阱
            1.  **恒复数**：*police, cattle, people* 谓语必用复数。
            2.  **量化整体**：表示时间、距离、金钱、重量的短语作主语，谓语用单数 (*Ten dollars **is** enough.*)。
            3.  **单位词控制**：*a pair of shoes* (谓语看 *pair* -> 单数)；*two pairs of shoes* (复数)。""".trimIndent(),
            syllabusDetails = listOf(
            "**【分类记忆】** 精准区分专有名词、个体、集体、物质及抽象名词，掌握抽象名词具体化的转换逻辑（如 *a failure/a surprise*）。",
            "**【规则变数】** 深度掌握名词复数规则变化（特别是 *-o, -f(e), -y* 结尾）及 20 个以上的高频不规则名词。",
            "**【不可数清单】** 牢记 *advice, news, information, progress* 等 10 大核心不可数名词，杜绝 **errors in agreement**。",
            "**【格位辨析】** 熟练处理 *'s, of* 及双重所有格，重点区分 **共同所有** 与 **分别所有** 的表达差异。",
            "**【限定修饰】** 掌握名词作定语时的数之原则，深刻理解 *man/woman* 的变格例外。",
            "**【单位量化】** 掌握 15 种以上常用量词结构（*a loaf of, a flight of, a set of* 等）。",
            "**【主谓一致】** 理解集体名词在不同语境下的数（*family* 是整体还是成员），掌握时间/金钱作主语的整体原则。"
            ),
            relatedPoints = listOf(
            RelatedPoint("冠词 (Articles)", "名词的‘身份证明’与‘存在土壤’", "冠词与名词是共生关系。名词的可数性与首音素直接决定了不定冠词 *a/an* 的选择；而名词在语篇中的特指、泛指、唯一性则决定了 *the* 的分布逻辑。"),
            RelatedPoint("代词 (Pronouns)", "名词的‘逻辑替身’", "代词（如 *it, one, that, those*）必须在‘数’和‘格’上与所替代的名词保持 100% 的契合。"),
            RelatedPoint("主谓一致 (S-V Agreement)", "名词的‘行政权力’", "名词作为主语时，其单复数形式直接控制谓语动词的形态变换。"),
            RelatedPoint("形容词 (Adjectives)", "名词的‘精修画笔’", "掌握多个形容词修饰名词的特定语序（**OPSHCOM**）是衡量语言地道性的指标。"),
            RelatedPoint("定语从句 (Attributive Clause)", "名词的‘延展描述’", "先行词通常是一个名词，从句通过关系词对该名词进行维度更广的补充说明。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
            PastExamQuestion("2025", "北京", "The ______ of the local museum are open to the public for free.", listOf("A. doors", "B. news", "C. advice", "D. information"), "A", "**【解析】** 谓语动词 `are` 是复数，要求主语必须是可数名词复数。`news, advice, information` 均为不可数名词，排除。故选 **A**。", "**【注意】** 忽略 `are` 而根据中文逻辑选‘信息’是典型错误。", "博物馆的大门免费向公众开放。"),
            PastExamQuestion("2024", "上海", "To my surprise, the little boy has already finished three ______ of bread.", listOf("A. loaf", "B. loafs", "C. loaves", "D. love"), "C", "**【解析】** 考查单位词。`bread` 不可数，三条面包用 `three loaves of...`。`loaf` 以 f 结尾，复数变 f 为 v 加 es. 故选 **C**。", "**【考点】** 不规则复数拼写 `loaf -> loaves`。", "令我惊讶的是，那个小男孩已经吃完了三条面包。"),
            PastExamQuestion("2023", "广东", "— What would you like to have for dinner?\n— Some ______. They are my favorite.", listOf("A. tomato", "B. potato", "C. noodles", "D. beefs"), "C", "**【解析】** 答语中 `They` 说明主语是复数。`A/B` 为单数；`D` 项 `beef` 是不可数名词。故选 **C**。", "**【技巧】** 注意代词 `They` 对名词数的暗示作用。", "—— 你晚餐想吃什么？ —— 一些面条。它们是我的最爱。"),
            PastExamQuestion("2022", "江苏南京", "The teacher gave us some helpful ______ on how to protect the environment.", listOf("A. advice", "B. suggestions", "C. news", "D. information"), "A", "**【解析】** 虽然四个词都说得通，但 `advice` 是中考考察频率最高的。注意 `some` 修饰可数名词 `suggestion` 需用复数。故选 **A**。", "**【陷阱】** 汉语认为建议可数，但 `advice` 绝对不可数。", "老师就如何保护环境给我们提了一些有用的建议。"),
            PastExamQuestion("2021", "湖北武汉", "This is my ______ room. It's clean and tidy.", listOf("A. parent's", "B. parents'", "C. parent", "D. parents"), "B", "**【解析】** 父母两人的房间用复数所有格 `parents'`。故选 **B**。", "**【规则】** 以 s 结尾的复数只加 `'`。", "这是我父母的房间。"),
            PastExamQuestion("2020", "安徽", "The ______ are looking for the lost girl in the mountains.", listOf("A. police", "B. fireman", "C. group", "D. policeman"), "A", "**【解析】** 谓语 `are` 提示主语复数。`police` 恒复数。故选 **A**。", "**【属性】** 集体名词语法特征。", "警察在搜救女孩。"),
            PastExamQuestion("2019", "福建", "It's ______ walk from my home to the school.", listOf("A. ten minutes", "B. ten minute's", "C. ten minutes'", "D. ten-minutes"), "C", "**【解析】** 考查时间所有格。复数 `minutes` 后加 `'`。故选 **C**。", "**【结构】** 数词 + 名词复数所有格 + 名词。", "从我家到学校步行需十分钟。"),
            PastExamQuestion("2018", "云南", "There are three ______ in my family.", listOf("A. people", "B. peoples", "C. person", "D. persons"), "A", "**【解析】** `people` 恒为复数。故选 **A**。", "**【常识】** `people` 的特殊属性。", "我家有三口人。"),
            PastExamQuestion("2017", "山西", "I need two ______ of paper to write a letter.", listOf("A. piece", "B. pieces", "C. bit", "D. bits"), "B", "**【解析】** `two` 后面接量词复数 `pieces`。故选 **B**。", "**【搭配】** 不可数名词的量化。", "我需要两张纸。"),
            PastExamQuestion("2016", "重庆", "He has two ______ and he loves them very much.", listOf("A. child", "B. childs", "C. children", "D. childrens"), "C", "**【解析】** `child` 不规则复数 `children`。故选 **C**。", "**【基础】** 不规则复数形式。", "他有两个孩子。")
            ),
            textbookParagraphs = listOf(
            TextbookParagraph("In our modern world, information is growing faster than ever before. We can get different kinds of news from the Internet, television and newspapers. It is important for us to learn how to choose helpful advice from the massive data.", listOf(
            HighlightedSentence("information is growing faster", "**【语法分析】** `information` 是核心不可数名词，作主语时谓语动词必须使用单数 `is`。"),
            HighlightedSentence("different kinds of news", "**【结构剖析】** `news` 是不可数名词。表达复数概念必须借助 `kind/piece` 等单位词。"),
            HighlightedSentence("choose helpful advice", "**【易错提示】** `advice` 绝对不可数。不能说 *an advice* 或 *many advices*。")
            ), "人教版 (Go for it!) 九年级 Unit 1"),
            TextbookParagraph("There are three library buildings and ten science laboratories in the school. Many students like to spend their free time in the library, reading books or searching for information.", listOf(
            HighlightedSentence("three library buildings", "**【定语规则】** 名词 `library` 修饰 `buildings` 时充当定语，遵循“名词作定语通常用单数”的原则。"),
            HighlightedSentence("ten science laboratories", "**【数之一致】** 数词 `ten` 要求名词使用复数形态 `laboratories` (-y 变 -i 加 -es)。")
            ), "外研版 (New Standard) 八下 Module 3"),
            TextbookParagraph("To keep healthy, we should eat more fruits and vegetables instead of junk food. An apple a day keeps the doctor away. Health is the real wealth.", listOf(
            HighlightedSentence("fruits and vegetables", "**【并列属性】** `fruit` 侧重‘种类’时可数。此处与 `vegetables` 并列，指代不同种类的果蔬。"),
            HighlightedSentence("health is the real wealth", "**【抽象逻辑】** `health` 和 `wealth` 都是抽象名词，表达普适真理时不用冠词。")
            ), "沪教版 (Oxford) 九上 Unit 2"),
            TextbookParagraph("Last week, our class went on a trip to the farm. We saw many sheep and cows there. The farmers were busy picking tomatoes and potatoes.", listOf(
            HighlightedSentence("saw many sheep", "**【单复同形】** `sheep` 的单复数形式一致。此处被 `many` 修饰，严禁加 -s。"),
            HighlightedSentence("tomatoes and potatoes", "**【-o 结尾】** 中考必背：黑人英雄爱吃西红柿土豆。复数必须加 -es。")
            ), "人教版 (Go for it!) 七下 Unit 11"),
            TextbookParagraph("The police are looking for a missing boy who was last seen near the park. His parents are very worried and have asked for help.", listOf(
            HighlightedSentence("The police are looking", "**【集体名词】** `police` 始终代表警察群体，语法上恒复数，谓语必须用 `are`。"),
            HighlightedSentence("His parents are", "**【指代逻辑】** `parents` 指父母双亲。复数主语对应 `are`。")
            ), "外研版 (New Standard) 九上 Module 5")
            ),
            exampleSentences = listOf(
            ExampleSentence("Two months' holiday is what the children look forward to every summer.", "两个月的假期是孩子们每年夏天都期待的。", "**【深度解析】** 融合了‘复数名词所有格’与‘时间主语整体性’。`months` 是以 s 结尾的复数，所有格只加 `'`。‘两个月假期’被视为一个时间整体，谓语用单数 `is`。", "中考核心 (Complex)"),
            ExampleSentence("A friend of my father's, who is an engineer, gave me some useful advice.", "我父亲的一个朋友（他是一名工程师）给我提了一些有用的建议。", "**【深度解析】** 包含：1. 双重所有格 (*a friend of my father's*)；2. 非限制性定语从句；3. 核心不可数名词 `advice`。", "高阶句式 (Complex)"),
            ExampleSentence("The police are searching for the thieves who stole several boxes of jewelry.", "警察正在搜寻从博物馆偷走几盒珠宝的窃贼。", "**【深度解析】** `police` 恒复数；`thief -> thieves`；`boxes of jewelry` (不可数名词量化)。", "高频易错 (Complex)"),
            ExampleSentence("Whether we can achieve success depends on our hard work and the progress we make.", "我们是否能获得成功取决于我们的努力和我们取得的进步。", "**【深度解析】** `Success` 和 `progress` 均为抽象不可数名词，在此复杂句中起逻辑支撑作用。", "哲理句式 (Complex)")
            ),
            teachingNotes = listOf(
            TeachingNote("【学情透视】核心症结", "1. **母语迁移干扰**：汉语缺乏‘数’的变化，学生习惯性漏掉 `-s` 或误在 `advice` 后加 s。\n2. **规则泛化陷阱**：掌握 `-es` 规律后，容易出现 *roofs -> rooves* 的过度类推错误。\n3. **逻辑一致性缺失**：在长句子中，主语用复数，句末代词却误用单数 `it`。"),
            TeachingNote("【教学金钥】备忘清单", "1. **分类突破法**：将不可数名词归类为‘四大金刚’(*advice, news, information, progress*) 重点标记。\n2. **口诀记忆法**：‘英雄吃土豆...’、‘九个变 v 的...’等口诀要反复操练。\n3. **实物情景法**：通过 *a bottle of*, *a cup of* 等实物强化量词语感。\n4. **错题档案**：重点收集共同所有 vs 分别所有的错例。"),
            TeachingNote("【冲刺技巧】中考必杀技", "1. **看修饰语**：`much, a little` 锁定不可数；`many, a few` 锁定复数。\n2. **找谓语**：`is/was` 考虑单数/不可数；`are/were` 找复数/集体名词。\n3. **代词指代**：看到 `they/them` 往前找复数名词。")
            ),
            famousQuote = "A room without books is like a body without a soul.",
            quoteAuthor = "Cicero",
            quoteTranslation = "居无书，犹身无魂。",
            quoteAnalysis = "本句巧妙运用了四个名词：*room, books, body, soul*。生动展示了名词在类比修饰中的表现力。"
        ),
        KnowledgePoint(
            id = "pronouns",
            section = SEC_1,
            title = "代词 (Pronouns)",
            description = """
            ### 📖 核心概念详解
            
            代词 (Pronouns) 是英语句法的“替代艺术”，其核心功能是简化语言并避免重复。
            
            #### 1. 代词的分类矩阵
            | 类别 | 定义 | 核心成员 | 语法职能 |
            | :--- | :--- | :--- | :--- |
            | **人称代词** | 替代人或物 | *I, you, he, she, it, us...* | 主格作主语，宾格作宾语 |
            | **物主代词** | 表示所有关系 | *my, mine, your, yours...* | 形容词性 vs 名词性 |
            | **反身代词** | 动作反回主语 | *myself, yourself...* | 用于 *enjoy oneself* 等搭配 |
            | **指示代词** | 指代特定对象 | *this, that, these, those* | 远指 vs 近指 |
            | **疑问代词** | 引导询问 | *who, what, which, whose* | 引导特殊疑问句 |
            | **不定代词** | 指代不确定对象 | *some, any, all, both...* | 数量、范围的逻辑判定 |
            
            #### 2. 指代一致性之辨 (核心难点)
            > 💡 **it, one, that, those 的终极区分**：
            > *   **it**：指代“同名同物”（同一个）。
            > *   **one**：指代“同名异物”（同类中的一个，复数 *ones*）。
            > *   **that**：指代“同名异物”（常用于比较结构，特指单数或不可数名词）。
            > *   **those**：*that* 的复数形式。
            
            #### 3. 不定代词的逻辑陷阱
            *   **肯定 vs 否定**：*some* (肯定句/委婉请求) vs *any* (否定/疑问)。
            *   **两者 vs 三者以上**：
            *   **两者**：*both* (都), *either* (任一), *neither* (都不)。
            *   **三者以上**：*all* (都), *any* (任一), *none* (都不)。
            *   **复合不定代词**：*something, someone...* 形容词修饰必须 **后置** (*something special*)。
            
            #### 4. it 的多重分身
            1.  **实指**：指代前文提到的事物、天气、时间、距离。
            2.  **形式主语**：*It is adj. (for/of sb.) to do sth.*
            3.  **形式宾语**：*find/think it adj. to do sth.*
            """.trimIndent(),
            syllabusDetails = listOf(
            "**【八大分类】** 熟练掌握人称、物主、反身、指示、疑问、不定、关系及连接代词的拼写与用法。",
            "**【格位转换】** 精准处理人称代词主宾格切换，尤其在动词/介词后的宾格要求。",
            "**【物主区分】** 深刻理解形容词性物主代词（须接名词）与名词性物主代词（独立存在）的替代逻辑。",
            "**【指代逻辑】** 攻克 *it, one, that* 在长难句中的指代判定，这是完形填空的必考点。",
            "**【复合结构】** 掌握复合不定代词与形容词后置的修饰规则（如 *nothing serious*）。",
            "**【形式句法】** 熟练运用 *it* 作形式主语和形式宾语的高级句式结构。"
            ),
            relatedPoints = listOf(
            RelatedPoint("主谓一致 (S-V Agreement)", "代词对谓语的逻辑锁定", "不定代词（如 *each, someone, neither*）作主语时，谓语动词通常必须使用单数形态。"),
            RelatedPoint("形容词 (Adjectives)", "修饰语的位移", "当形容词修饰复合不定代词时，必须打破常规的前置定语逻辑，进行强制后置。"),
            RelatedPoint("名词 (Nouns)", "代词的‘根源’", "代词必须在数、格上与所替代的名词保持 100% 的一致性。"),
            RelatedPoint("定语从句 (Attributive Clause)", "关系代词的职能", "关系代词 *that, which, who* 在从句中既起引导作用，又充当特定的句法成分。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
            PastExamQuestion("2025", "北京", "— Have you seen my keys anywhere?\n— No, but there is ______ on the dining table.", listOf("A. one", "B. it", "C. that", "D. this"), "A", "**【解析】** 此处指代“一把钥匙”，是同类中的一个（同名异物），故选 **A**。*it* 指同一个，不符合语境。", "**【难点】** 区分同名异物与同名同物。", "—— 你在到处见过我的钥匙吗？ —— 没有，但餐桌上有一把。"),
            PastExamQuestion("2024", "上海", "The students enjoyed ______ at the science museum last Friday.", listOf("A. them", "B. their", "C. themselves", "D. they"), "C", "**【解析】** 考查反身代词。*enjoy oneself* 为固定搭配，主语是 students，故用 *themselves*。选 **C**。", "**【语法点】** 动作返回主语本身。", "学生们上周五在科学博物馆玩得很开心。"),
            PastExamQuestion("2023", "广东", "I have two sisters. ______ of them are doctors in this hospital.", listOf("A. All", "B. Both", "C. Neither", "D. None"), "B", "**【解析】** 由 *two sisters* 锁定范围为“两者”；谓语 *are* 说明是肯定含义。*both* 表示“两者都”。选 **B**。", "**【技巧】** 先看范围（两者/三者），再看肯定否定。", "我有两个姐姐。她们两个都是这家医院的医生。"),
            PastExamQuestion("2022", "江苏南京", "The population of China is much larger than ______ of the United States.", listOf("A. it", "B. one", "C. that", "D. this"), "C", "**【解析】** 考查指代词比较结构。指代不可数名词 *population* 且表示同类对比（同名异物），固定用 *that*。选 **C**。", "**【经典】** 比较级中的指代规则。", "中国的人口比美国的人口多得多。"),
            PastExamQuestion("2021", "湖北武汉", "— Which of these two storybooks would you like to read?\n— ______. I'm interested in science books now.", listOf("A. Neither", "B. None", "C. Both", "D. Either"), "A", "**【解析】** *two books* 提示两者；答句说喜欢科学书，暗示故事书都不选。*Neither* 表示两者都不。选 **A**。", "**【辨析】** 混淆两者否定 *neither* 与三者否定 *none*。", "—— 这两本故事书你想读哪一本？ —— 都不想读。我现在对科学书感兴趣。"),
            PastExamQuestion("2020", "安徽", "Is there ______ in today's newspaper? I haven't read it yet.", listOf("A. anything interesting", "B. interesting anything", "C. something interesting", "D. interesting something"), "A", "**【解析】** 疑问句中常用 *anything*；形容词修饰不定代词需后置。选 **A**。", "**【规则】** 复合不定代词的后置修饰规律。", "今天的报纸上有什么有趣的消息吗？"),
            PastExamQuestion("2019", "福建", "— Who helped you fix the broken bike?\n— ______. I fixed it all by myself.", listOf("A. Somebody", "B. Anybody", "C. Nobody", "D. Everybody"), "C", "**【解析】** *by myself* 说明没人帮忙。*Nobody* 意为“没有人”。选 **C**。", "**【逻辑】** 根据答语推断代词语义。", "—— 谁帮你修的坏自行车？ —— 没人。是我自己修好的。"),
            PastExamQuestion("2018", "河南", "We should learn how to look after ______ when our parents are not at home.", listOf("A. we", "B. us", "C. our", "D. ourselves"), "D", "**【解析】** 主语是 *we*，动作“照顾”指向主语自己，需用反身代词 *ourselves*。选 **D**。", "**【结构】** *look after oneself* 固定搭配。", "当父母不在家时，我们应该学会如何照顾自己。"),
            PastExamQuestion("2017", "陕西", "I'd like to buy this dictionary. How much is ______?", listOf("A. it", "B. one", "C. that", "D. this"), "A", "**【解析】** 特指刚才提到的“这本字典”（同名同物），用 *it*。选 **A**。", "**【指代】** 同名同物特指应用。", "我想买这本字典。多少钱？"),
            PastExamQuestion("2016", "重庆", "— May I borrow your dictionary? ______ is at home.", listOf("A. My", "B. Me", "C. Mine", "D. Myself"), "C", "**【解析】** 替代 *my dictionary* 且在句中作主语，需用名词性物主代词 *Mine*。选 **C**。", "**【基础】** 物主代词两性辨析。", "—— 我可以借你的字典吗？我自己的那本在家里。")
            ),
            textbookParagraphs = listOf(
            TextbookParagraph("If you have something important to tell your parents, you should speak to them directly. Don't keep it to yourself, because sharing your feelings can help you feel better. Trusting each other is the key to a happy family life.", listOf(
            HighlightedSentence("something important", "**【语法剖析】** *something* 是复合不定代词，形容词 *important* 必须后置。这是中考最高频的代词陷阱之一。"),
            HighlightedSentence("keep it to yourself", "**【语义分析】** *it* 指代前文的 *something*；*yourself* 与 *you* 呼应，表示“独自保守”。")
            ), "人教版 (Go for it!) 八下 Unit 4"),
            TextbookParagraph("Learning a foreign language is a challenge for everyone. Some find it easy, while others may find it difficult. But for me, none of us can master it without hard work and constant practice.", listOf(
            HighlightedSentence("Some... while others", "**【逻辑矩阵】** *some... others...* 用于描述不同群体的不确定分布，是阅读对比逻辑的核心。"),
            HighlightedSentence("find it easy", "**【形式宾语】** *it* 是形式宾语，真正的宾语是后文隐藏的学外语动作。"),
            HighlightedSentence("none of us", "**【范围判定】** *none* 明确了范围是三者或三者以上全否定。")
            ), "外研版 (New Standard) 九下 Module 5"),
            TextbookParagraph("My sister bought two bottles of juice. She gave one to me and the other to our brother. Both of us thought the juice tasted very fresh on such a hot afternoon.", listOf(
            HighlightedSentence("one... the other", "**【唯一性】** 专指两者中的“一个”与“另一个”，逻辑关系非常严密。"),
            HighlightedSentence("Both of us", "**【肯定逻辑】** *Both* 强调两者的共同属性。")
            ), "沪教版 (Oxford) 七上 Unit 3")
            ),
            exampleSentences = listOf(
            ExampleSentence("The climate of Kunming is much milder than that of Harbin in winter.", "昆明的气候比哈尔滨冬天的气候要温和得多。", "**【分析】** *that* 代替不可数名词 *climate*，是中考比较结构中的顶级考点。", "中考核心 (Complex)"),
            ExampleSentence("I found it impossible to finish all the work by myself in such a short time.", "我发现凭我一个人的力量在这么短的时间内完成所有工作是不可能的。", "**【分析】** 融合了形式宾语 *it*、不定式及反身代词的高阶句式。", "高频易错 (Complex)"),
            ExampleSentence("Neither of the two books is interesting enough for me to read twice.", "这两本书中哪一本都不够有趣，不值得我读第二遍。", "**【分析】** *Neither of* 接复数名词但谓语动词固定用单数 *is*。", "主谓一致 (Compound)")
            ),
            teachingNotes = listOf(
            TeachingNote("【学情透视】核心症结", "1. **母语迁移干扰**：汉语无宾格变化，学生在 *he/him* 区分上频繁出错。\n2. **指代链断裂**：长难句中找不到 *that* 或 *one* 的先行词。\n3. **范围混淆**：对于两者/三者的逻辑界限模糊。"),
            TeachingNote("【教学金钥】备忘清单", "1. **图表记忆法**：利用 2x2 矩阵拆解不定代词（两者/三者 x 肯定/否定）。\n2. **指代搜索法**：训练学生在阅读中用箭头连接代词与其指代名词。\n3. **公式化句型**：将 *It is adj. to do* 总结为形式主语的“万能套路”。")
            ),
            famousQuote = "Be yourself; everyone else is already taken.",
            quoteAuthor = "Oscar Wilde",
            quoteTranslation = "做你自己；因为别人都有人做了。",
            quoteAnalysis = "巧妙运用反身代词 *yourself* 与不定代词 *everyone else*，展示了个体与整体的语义张力。"
        ),
        KnowledgePoint(
            id = "articles",
            section = SEC_1,
            title = "冠词 (Articles)",
            description = """
            ### 📖 核心概念详解
            
            冠词 (Articles) 被称为英语中的“虚词之王”，其规则之细腻、使用频率之高，是衡量语感是否纯正的试金石。
            
            #### 1. 不定冠词 (a / an) 的首音素准则
            > ⚠️ **黄金法则**：选择 *a* 还是 *an*，物理依据是单词的 **首个音素 (Phoneme)**，而非首个字母。
            
            | 示例 | 音素分析 | 正确选择 | 常见误区 |
            | :--- | :--- | :--- | :--- |
            | *hour* | /'aʊə/ (元音) | **an** hour | 误选 a (因 h 是辅音字母) |
            | *honest* | /'ɒnɪst/ (元音) | **an** honest boy | 忽略 h 不发音 |
            | *university* | /ˌjuːnɪ'vɜːsəti/ (辅音) | **a** university | 误选 an (因 u 是元音字母) |
            | *useful* | /'juːsfl/ (辅音) | **a** useful tool | 仅看拼写不看发音 |
            | *unusual* | /ʌn'juːʒuəl/ (元音) | **an** unusual story | 元音发音选 an |
            | *MP3* | /ˌem piː 'θriː/ (元音) | **an** MP3 player | 字母 M 以元音 /e/ 开头 |
            
            #### 2. 定冠词 (the) 的“特指”逻辑
            1.  **回头见原则**：上文提到过的人或物 (*I saw a bird. The bird was...*)。
            2.  **独一无二**：世界上独一无二的事物 (*the sun, the moon, the earth*)。
            3.  **序数词与最高级**：*the first, the best, the most interesting*。
            4.  **西洋乐器**：*play the piano, play the guitar* (对比：*play football* 无 the)。
            5.  **方位与方向**：*in the east, on the left*。
            6.  **姓氏复数**：表示“一家人” (*the Greens*)。
            7.  **the + 形容词**：表示一类人 (*the rich, the blind*)。
            
            #### 3. 零冠词 (Zero Article) 的“法定”场景
            *   **球类、棋类**：*play basketball, play chess*。
            *   **三餐、季节、月份**：*have breakfast, in summer, in March* (若有修饰词例外，如 *in the cold winter of 2023*)。
            *   **学科、语言**：*speak English, study physics*。
            *   **节日**：*at Christmas, on Children's Day* (注意：*the Spring Festival* 通常带 the)。
            *   **代词/名词所有格后**：*my book* (不说 *a my book*)。
            
            #### 4. 固定短语中的“有无”玄机
            | 短语 (有 the) | 含义 | 短语 (无 the) | 含义 |
            | :--- | :--- | :--- | :--- |
            | *in the hospital* | 在医院里 (如探视) | *in hospital* | 住院 (因病) |
            | *at the table* | 在桌子旁 | *at table* | 在进餐 |
            | *go to the school* | 去那所学校 (如开会) | *go to school* | 去上学 (学生身份) |
            | *in the prison* | 在监狱里 (如参观) | *in prison* | 坐牢 (罪犯身份) |
            | *by the sea* | 在海边 | *by sea* | 乘船 (交通方式) |
            """.trimIndent(),
            syllabusDetails = listOf(
            "**【音法判定】** 深刻掌握首音素判别法，重点记忆 *h, u, e, m, s, x* 等字母开头的特殊词汇发音。",
            "**【特指锁定】** 掌握 *the* 在语篇衔接、特定范围修饰（如 *of* 短语修饰）以及独一无二事物前的应用法则。",
            "**【零冠词清单】** 熟练识别球类、三餐、学科等零冠词场景，理解有无冠词产生的语义质变。",
            "**【习惯搭配】** 掌握 30 组以上带有/不带冠词的固定短语，尤其是在阅读理解中分辨身份职能（如 *in hospital*）。",
            "**【数量转换】** 掌握 *a second/a third* 表示“又一个、再一个”而非顺序的递进逻辑语义。"
            ),
            relatedPoints = listOf(
            RelatedPoint("名词 (Nouns)", "冠词的语法宿主", "名词的可数性、单复数属性是冠词存在的物理前提。"),
            RelatedPoint("形容词最高级 (Superlatives)", "the 的固定伴侣", "最高级前通常强制使用 *the*，除非有物主代词。"),
            RelatedPoint("数词 (Numerals)", "序数词的伴侣", "序数词前通常加 *the* 表示顺序，加 *a/an* 表示增加。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
            PastExamQuestion("2025", "北京", "Zhang Hua is ______ honest boy. He always tells ______ truth.", listOf("A. a; the", "B. an; the", "C. an; a", "D. a; a"), "B", "**【解析】** *honest* 首音素为元音 /ɒ/，用 *an*；*tell the truth*（说实话）为固定搭配。故选 **B**。", "**【陷阱】** 容易根据首字母 h 误选 a。", "张华是个诚实的孩子。他总是说真话。"),
            PastExamQuestion("2024", "上海", "Look! ______ boy in a blue jacket is playing ______ guitar.", listOf("A. The; the", "B. A; the", "C. The; /", "D. A; /"), "A", "**【解析】** *in a blue jacket* 介词短语作定语，表示特指，用 *the*；西洋乐器前加 *the*。故选 **A**。", "**【提醒】** 介词短语的特指功能是中考常考点。", "看！那个穿蓝色夹克的男孩正在弹吉他。"),
            PastExamQuestion("2023", "广东", "I usually have ______ breakfast at 7:00. It's ______ important meal.", listOf("A. /; an", "B. a; an", "C. the; a", "D. /; a"), "A", "**【解析】** 三餐前通常不用冠词（零冠词）；*important* 元音开头用 *an*。故选 **A**。", "**【注意】** 零冠词与不定冠词的混合考查。", "我通常 7 点吃早餐。这是一天中重要的一餐。"),
            PastExamQuestion("2022", "江苏南京", "Beijing, ______ capital of China, will hold ______ 24th Winter Olympic Games.", listOf("A. a; the", "B. the; the", "C. /; the", "D. the; a"), "B", "**【解析】** “中国的首都”表唯一身份用 *the*；序数词前加 *the*。故选 **B**。", "**【考点】** 唯一性身份与序数词的前置冠词。", "北京，中国的首都，将举办第 24 届冬奥会。"),
            PastExamQuestion("2021", "湖北武汉", "— What ______ useful information it is!\n— Yes. It helps me a lot.", listOf("A. a", "B. an", "C. /", "D. the"), "C", "**【解析】** *information* 是不可数名词，感叹句 *What + adj + 名词* 结构中，不可数名词前不用 a/an。故选 **C**。", "**【错误率】** 极高。学生常因 *useful* 而选 a。", "—— 多么有用的信息啊！ —— 是的。它对我帮助很大。"),
            PastExamQuestion("2020", "安徽", "— Do you like playing ______ football?\n— No, I prefer playing ______ violin.", listOf("A. a; the", "B. /; the", "C. the; /", "D. /; /"), "B", "**【解析】** 球类运动前零冠词，乐器前加 *the*。故选 **B**。", "**【口诀】** 球类零，乐器定。", "—— 你喜欢踢足球吗？ —— 不，我更喜欢拉小提琴。"),
            PastExamQuestion("2019", "福建", "Fuzhou is ______ beautiful city. It's ______ capital of Fujian Province.", listOf("A. a; the", "B. an; the", "C. a; a", "D. the; a"), "A", "**【解析】** 第一空表泛指“一个美丽的城市”用 *a*；第二空表特指“福建省的省会”用 *the*。故选 **A**。", "**【逻辑】** 先泛指后特指。", "福州是一个美丽的城市。它是福建省的省会。"),
            PastExamQuestion("2018", "河南", "After ______ hour's exercise, I felt ______ bit tired.", listOf("A. a; a", "B. an; a", "C. an; /", "D. a; /"), "B", "**【解析】** *hour* 元音开头用 *an*；*a bit*（一点儿）是固定短语。故选 **B**。", "**【音素】** /'aʊə/ 是元音音素。", "锻炼了一个小时后，我感到有一点点累。"),
            PastExamQuestion("2017", "重庆", "Mr. Smith is ______ English teacher. He is from ______ UK.", listOf("A. a; the", "B. an; the", "C. an; /", "D. a; /"), "B", "**【解析】** *English* 元音开头用 *an*；由普通名词构成的国家简称前加 *the*。故选 **B**。", "**【国家】** UK, USA, PRC 都要加 the。", "史密斯先生是一名英语老师。他来自英国。"),
            PastExamQuestion("2016", "陕西", "Music is ______ international language. We can express our feelings through it.", listOf("A. a", "B. an", "C. the", "D. /"), "B", "**【解析】** 表泛指“一种国际语言”，*international* 元音开头用 *an*。故选 **B**。", "**【基础】** 泛指概念与元音判定。", "音乐是一种国际语言。我们可以通过它表达情感。")
            ),
            textbookParagraphs = listOf(
            TextbookParagraph("It takes me an hour to finish my homework every day. After that, I usually play the violin for thirty minutes. Music makes me feel relaxed. It is an important part of my life.", listOf(
            HighlightedSentence("an hour", "**【发音红线】** *hour* 的 h 不发音，首音素为元音 /aʊ/，必须用 *an*。"),
            HighlightedSentence("play the violin", "**【乐器逻辑】** 西洋乐器前须加 *the*，体现了英语对艺术形式的特指传统。"),
            HighlightedSentence("an important part", "**【泛指逻辑】** 表达“其中一个重要部分”，元音音素 /ɪ/ 开头用 *an*。")
            ), "人教版 (Go for it!) 七下 Unit 6"),
            TextbookParagraph("Yesterday, the Greens went on a trip to the beach. They saw the sun rise from the east in the morning. They had a great time playing football on the sand. It was an unforgettable day.", listOf(
            HighlightedSentence("the Greens", "**【家族用法】** *the + 姓氏复数* 表示一家人。"),
            HighlightedSentence("from the east", "**【方位特指】** 方位词前固定使用定冠词 *the*。"),
            HighlightedSentence("playing football", "**【运动禁忌】** 球类运动前严禁加 *the*。")
            ), "外研版 (New Standard) 八下 Module 5"),
            TextbookParagraph("In hospital, doctors and nurses work day and night to save lives. My aunt is a nurse. She works in the hospital near our school. She loves her job very much.", listOf(
            HighlightedSentence("In hospital", "**【职能语义】** 指“在住院”或“在从事医疗工作”，强调职能而非建筑。"),
            HighlightedSentence("in the hospital", "**【建筑语义】** 指“在那栋医院大楼里”，强调具体的地理位置。")
            ), "沪教版 (Oxford) 九上 Unit 2"),
            TextbookParagraph("Li Hua is a university student now. He is an honest person and always helps the old in his community. Everyone thinks he is a useful man.", listOf(
            HighlightedSentence("a university student", "**【发音陷阱】** *university* 首字母虽是 u，但音素是辅音 /j/，故用 *a*。"),
            HighlightedSentence("helps the old", "**【群体表达】** *the + 形容词* 表示一类人，此处指“老人”。"),
            HighlightedSentence("a useful man", "**【发音陷阱】** *useful* 音素为辅音 /j/，用 *a*。")
            ), "人教版 (Go for it!) 九年级 Unit 1")
            ),
            exampleSentences = listOf(
            ExampleSentence("He is an 11-year-old boy who has already become a university student.", "他是一个 11 岁的男孩，却已经成了一名大学生。", "**【深度解析】** *11 (eleven)* 元音开头用 *an*；*university* 辅音开头用 *a*。", "中考核心 (Complex)"),
            ExampleSentence("The rich should help the poor, because we all live on the same planet.", "富人应当帮助穷人，因为我们都生活在同一个星球上。", "**【深度解析】** “the + 形容词” 结构表示一类人。*the same* 是固定搭配。", "高阶句法 (Compound)"),
            ExampleSentence("We usually have lunch at school, but last Sunday we had a big lunch in a restaurant.", "我们通常在学校吃午饭，但上周日我们在一家餐馆吃了一顿丰盛的午餐。", "**【深度解析】** 三餐前通常零冠词，但有形容词修饰且表泛指时可用 *a*。", "高频考点 (Complex)"),
            ExampleSentence("The moon goes around the earth. It's a natural satellite.", "月亮绕着地球转。它是一颗卫星。", "**【深度解析】** 独一无二的事物用 *the*；泛指身份用 *a*。", "基础必会 (Simple)")
            ),
            teachingNotes = listOf(
            TeachingNote("【学情透视】核心症结", "1. **母语缺失**：汉语完全没有冠词概念，学生容易漏掉冠词或根据拼写而非发音选择 a/an。\n2. **教条主义**：死记硬背“元音字母”，在 *useful, honest* 等词上反复栽跟头。\n3. **功能混淆**：分不清 *in hospital* 与 *in the hospital* 的语义差异。"),
            TeachingNote("【教学金钥】备忘清单", "1. **音标前置法**：在教冠词前先复习 48 个音标，特别是元音。强调“看音标，不看字母”。\n2. **情景差异法**：通过图片展示“在桌子旁 (*at the table*)”与“在吃饭 (*at table*)”的区别。\n3. **口诀辅助法**：‘球类棋类零冠词，西洋乐器 the 领头；序数词最高级 the 必有，姓氏复数 the 一家。’"),
            TeachingNote("【冲刺技巧】中考必杀技", "1. **第一眼看首音**：如果是 *U* 开头，发 /ju:/ 选 *a*，发 /ʌ/ 选 *an*。如果是 *H* 开头，不发音选 *an*。\n2. **第二眼看修饰**：有 *of* 或介词短语修饰名词，大概率选 *the*。\n3. **第三眼看固定搭配**：*at the same time, in the end, tell the truth* 等务必背熟。")
            ),
            famousQuote = "Details create the big picture.",
            quoteAuthor = "Sanford I. Weill",
            quoteTranslation = "细节成就大局。",
            quoteAnalysis = "冠词 (a/an/the) 在英语中虽细微如沙，却是构建精准语义大局的基石，少了一个冠词，句子的逻辑可能完全崩塌。"
        ),
        KnowledgePoint(
            id = "numerals",
            section = SEC_1,
            title = "数词 (Numerals)",
            description = """
            ### 📖 核心概念详解
            
            数词 (Numerals) 是描述客观世界“数量”与“顺序”的精密工具，在中考中主要考查其物理形态变换与特定应用逻辑。
            
            #### 1. 基数词 (Cardinals) 与序数词 (Ordinals)
            | 基数词 | 序数词 | 缩写 | 记忆要点 |
            | :--- | :--- | :--- | :--- |
            | *one* | **first** | 1st | 特殊记忆 |
            | *two* | **second** | 2nd | 特殊记忆 |
            | *three* | **third** | 3rd | 特殊记忆 |
            | *five* | **fifth** | 5th | **ve** 变 **f** 加 **th** |
            | *eight* | **eighth** | 8th | 词尾只加 **h** (避免两个 t) |
            | *nine* | **ninth** | 9th | 去 **e** 加 **th** |
            | *twelve* | **twelfth** | 12th | **ve** 变 **f** 加 **th** |
            | *twenty* | **twentieth** | 20th | **y** 变 **ie** 加 **th** |
            | *forty* | **fortieth** | 40th | 易错拼写：无 **u** (*four* 有 u) |
            
            #### 2. 大数的“s定律” (核心难点)
            > 💡 **“精准”与“模糊”的权力交接**：
            > *   **精准数 (具体数字)**：数字 + *hundred/thousand/million/billion* (**不加 s, 不接 of**)
            >     *   示例：*three hundred students* (三百个学生)
            > *   **模糊数 (约数)**：*hundreds/thousands/millions/billions* + **of** (**必须加 s, 必须接 of**)
            >     *   示例：*thousands of people* (成千上万的人)
            > ⚠️ **禁忌**：千万不要写成 *five hundreds of*。
            
            #### 3. 分数与百分数的逻辑
            *   **分数规则**：
            1. 分子用 **基数词**，分母用 **序数词**。
            2. 分子 > 1 时，分母序数词需加 **-s**。
            *   *1/3*: **one-third**
            *   *2/5*: **two-fifths**
            *   **百分数**：数字 + *percent* (始终不加 s)。
            *   其谓语动词的数由修饰的名词决定：*30% of the water **is**...* / *30% of the apples **are**...*
            
            #### 4. 时间、日期与年龄
            1.  **时刻表达**：
            *   *8:10* -> *ten past eight* (30分以内用 **past**)
            *   *8:50* -> *ten to nine* (超过30分用 **to**)
            *   *8:15* -> *a quarter past eight* / *8:30* -> *half past eight*
            2.  **年龄表达**：
            *   *in one's twenties* (在某人二十多岁时)
            3.  **日期表达**：
            *   *June 1st, 2025* (读作：*June the first*)
            """.trimIndent(),
            syllabusDetails = listOf(
            "**【形态拼写】** 熟练掌握 1-100 基数词及其对应序数词的物理变换规律，重点攻克 *eighth, ninth, twelfth, forty, ninety* 等拼写陷阱。",
            "**【大数逻辑】** 深刻理解 *hundred, thousand, million, billion* 在精准与模糊语境下的‘s定律’与‘of关联’。",
            "**【单位量化】** 精准运用分数（分子基、分母序、分子大于一分母加 s）、小数及百分数的标准表达。",
            "**【时空坐标】** 掌握日期、时刻（past/to 逆读法）、年龄（*in one's twenties*）及编号（*Lesson One* vs *the first lesson*）的转换。",
            "**【倍数逻辑】** 掌握 *once, twice, three times* 及其在比较结构中的应用。",
            "**【特殊含义】** 理解 *a second/a third* 表示“又一、再一”的递进逻辑语义。"
            ),
            relatedPoints = listOf(
            RelatedPoint("名词 (Nouns)", "数词的物理容器", "基数词直接决定名词复数；分数/百分数作主语时，谓语动词由修饰的名词决定。"),
            RelatedPoint("冠词 (Articles)", "序数词的‘护卫’", "序数词前通常须加 *the* 表示排序；但加 *a/an* 时则转化为“数量递进”语义。"),
            RelatedPoint("主谓一致 (S-V Agreement)", "分数与百分数的控制权", "这是中考的高阶考点，动词的单复数取决于 *of* 之后名词的逻辑属性。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
            PastExamQuestion("2025", "北京", "About ______ of the students in our school like playing basketball.", listOf("A. two third", "B. two thirds", "C. second three", "D. second thirds"), "B", "**【解析】** 考查分数。分子 2 用基数词 *two*，分母 3 用序数词复数 *thirds*。故选 **B**。", "**【注意】** 分子大于 1，分母必加 s。", "我们学校大约三分之二的学生喜欢打篮球。"),
            PastExamQuestion("2025", "天津", "There are ______ people in the park on weekends.", listOf("A. five hundred of", "B. five hundreds", "C. hundreds of", "D. five hundreds of"), "C", "**【解析】** 模糊大数用 *hundreds of*；精准数字后不加 s/of。故选 **C**。", "**【陷阱】** 不要混淆精准与模糊结构，两者不能杂交。", "周末公园里有数百人。"),
            PastExamQuestion("2024", "上海", "— How many books are there?\n— There are ______ books.", listOf("A. two thousand", "B. two thousands", "C. thousand of", "D. two thousands of"), "A", "**【解析】** 精准数字后单位词保持单数（不加 s）。故选 **A**。", "**【基础】** 基数词大数原则，千/百/百万在具体数字后不加 s。", "—— 有多少本书？ —— 有两千本书。"),
            PastExamQuestion("2024", "广东", "Today is my mother's ______ birthday.", listOf("A. forty", "B. fortieth", "C. the fortieth", "D. fourteenth"), "B", "**【解析】** 生日、序号用序数词；*forty* 变为序数词是 *fortieth*。已有 *my* 限制，不再加 *the*。故选 **B**。", "**【拼写】** *fortieth* 拼写无 u，容易受 *four* 干扰。", "今天是我妈妈四十岁生日。"),
            PastExamQuestion("2023", "江苏南京", "Beijing held ______ 24th Winter Olympic Games in 2022.", listOf("A. a", "B. an", "C. the", "D. /"), "C", "**【解析】** 序数词前加 *the* 表示特定届数。故选 **C**。", "**【常考】** 序数词与冠词的固定搭配。", "北京在 2022 年举办了第 24 届冬奥会。"),
            PastExamQuestion("2023", "湖北武汉", "It's ______ walk from my home to the school.", listOf("A. ten minute", "B. ten minute's", "C. ten minutes'", "D. ten minutes"), "C", "**【解析】** 复数名词所有格表时间。*ten minutes* 的所有格只需加 *'*。故选 **C**。", "**【关联】** 名词所有格与数词的综合考查。", "从家到学校步行十分钟。"),
            PastExamQuestion("2022", "四川成都", "About ______ of the surface of the earth is covered by water.", listOf("A. three-fourth", "B. three-fourths", "C. third-four", "D. third-fourths"), "B", "**【解析】** 分子 3 (*three*)，分母 4 序数复数 (*fourths*)。故选 **B**。", "**【分数】** 分子基，分母序，分子超一加 s。", "地球表面约四分之三被水覆盖。"),
            PastExamQuestion("2022", "浙江杭州", "I have read this book twice, but I want to read it ______ third time.", listOf("A. a", "B. the", "C. an", "D. /"), "A", "**【解析】** *a + 序数词* 意为“再一，又一”。故选 **A**。", "**【高阶】** 数词语义的动态化，不表顺序表增加。", "我已经读了两遍，还想读第三遍。"),
            PastExamQuestion("2021", "山东济南", "The ______ lesson is the most interesting one in this unit.", listOf("A. nine", "B. ninth", "C. nineteenth", "D. nineteen"), "B", "**【解析】** “第九课”表示顺序用序数词。*nine* 变序数词需去 e。故选 **B**。", "**【拼写】** *ninth* 去 e 是中考必杀技。", "第九课是这一单元中最有趣的。"),
            PastExamQuestion("2021", "河南", "Li Ming is in his ______. He is very energetic.", listOf("A. twenty", "B. twenties", "C. twentieth", "D. twenty's"), "B", "**【解析】** “在某人二十多岁时”用 *in one's twenties*。故选 **B**。", "**【年龄】** 整数基数词变复数表示年龄段。", "李明二十多岁。他在充满活力。"),
            PastExamQuestion("2020", "安徽", "There are ______ months in a year. December is the ______ month.", listOf("A. twelve; twelve", "B. twelfth; twelfth", "C. twelve; twelfth", "D. twelfth; twelve"), "C", "**【解析】** 数量用基数 *twelve*，顺序用序数 *twelfth*。故选 **C**。", "**【辨析】** 基数词表数量，序数词表顺序。", "一年有 12 个月，12 月是第 12 个月。"),
            PastExamQuestion("2019", "福建", "The moon is about ______ kilometers away from the earth.", listOf("A. three hundred eighty thousand", "B. three hundred and eighty thousand", "C. three hundreds eighty thousands", "D. three hundreds and eighty thousands"), "B", "**【解析】** 复合大数表达：单位词不加 s，百位十位间通常加 *and*。故选 **B**。", "**【规则】** 三十万八千：*three hundred and eighty thousand*。", "月球距地球约 38 万公里。")
            ),
            textbookParagraphs = listOf(
            TextbookParagraph("The library has thousands of books on different subjects. Last year, about five hundred new books were added. On the second floor, you can find many interesting magazines. More than two-thirds of the students visit the library at least once a week.", listOf(
            HighlightedSentence("thousands of books", "**【模糊逻辑】** *thousand* 加 *s* 且接 *of*，用于表达不确定的庞大数量级指标。"),
            HighlightedSentence("five hundred new books", "**【精准逻辑】** 具体数词后单位词保持单数，不可受名词复数干扰。"),
            HighlightedSentence("two-thirds of the students", "**【分数主谓】** 谓语动词由 *students* 决定。若改为 *water*，则谓语用单数。")
            ), "人教版 (Go for it!) 八下 Unit 2"),
            TextbookParagraph("The 19th Asian Games were held in Hangzhou. Athletes competed for hundreds of gold medals. For some, it was their first time to join such a big event in China.", listOf(
            HighlightedSentence("The 19th Asian Games", "**【活动届数】** 序数词表示届数时，通常由定冠词 *the* 领航。"),
            HighlightedSentence("their first time", "**【限定冲突】** 物主代词与定冠词不可并存，序数词前已有 *their*，故省去 *the*。")
            ), "外研版 (New Standard) 九下 Module 3"),
            TextbookParagraph("He lives in Room 302 on the third floor. He usually gets up at a quarter past six and leaves home at seven o'clock.", listOf(
            HighlightedSentence("Room 302", "**【编号法则】** 编号通常用基数词且置于名词后，不带冠词。"),
            HighlightedSentence("the third floor", "**【序数属性】** 序数词修饰名词表顺序，通常带冠词 *the*。")
            ), "人教版 (Go for it!) 七下 Unit 1"),
            TextbookParagraph("Practice makes perfect. He has failed twice, but he is going to have a third try. He believes success belongs to those who never give up.", listOf(
            HighlightedSentence("have a third try", "**【语义突变】** 此处的 *a* 表示“又一”，打破了序数词单纯排序的逻辑功能。"),
            HighlightedSentence("failed twice", "**【频次副词】** *once, twice* 是独立的语义单元，三次及以上需用 *times*。")
            ), "沪教版 (Oxford) 九上 Unit 4")
            ),
            exampleSentences = listOf(
            ExampleSentence("Three-quarters of the population in this city are against the new plan.", "这个城市四分之三的人口反对这项新计划。", "**【分析】** 分数主语。谓语动词随 *population* 的逻辑属性变复数。", "中考核心 (Complex)"),
            ExampleSentence("In the 1990s, many people in their twenties moved to big cities for work.", "在 20 世纪 90 年代，许多二十多岁的人搬到大城市工作。", "**【分析】** 包含年代 (*the 1990s*) 与年龄段 (*in one's twenties*)。", "年代语境 (Complex)"),
            ExampleSentence("The moon is about three hundred and eighty thousand kilometers away from the earth.", "月球距离地球大约 38 万公里。", "**【分析】** 复合大数物理拼写演示：百位十位间须有 *and*，单位不加 s。", "科学描述 (Simple)"),
            ExampleSentence("Please open your books to Page 20 and read the second paragraph carefully.", "请翻到第 20 页，仔细阅读第二段。", "**【分析】** 编号与排序的语法对照。", "基础必会 (Compound)")
            ),
            teachingNotes = listOf(
            TeachingNote("【学情透视】核心症结", "1. **拼写惯性**：受 *four* 影响写 *fourty* (应为 *forty*)，受 *nine* 影响写 *nineth* (应为 *ninth*)。\n2. **大数混淆**：分不清精准与模糊的界限，常出现 *five hundreds of* 这种混合错误。\n3. **分母盲点**：分子大于 1 时分母忘了加 s，或分子分母用错基/序数词。"),
            TeachingNote("【教学金钥】备忘清单", "1. **拼写口诀**：‘八去 t，九去 e，ve 要用 f 替，ty 变成 tie，再加 th 莫忘记。’\n2. **s 定律判定**：‘有 s 就有 of，无 s 就无 of。’\n3. **时钟实战**：利用闹钟模型练习 *past* 与 *to* 的逆读法，重点区分 *a quarter* 与 *half*。"),
            TeachingNote("【冲刺技巧】中考必杀技", "1. **看分子**：分子大于一，分母必加 s。 2. **看单位**：*hundred, thousand* 前有具体数，单位不加 s。 3. **看位置**：名词在前数在后用基数 (*Lesson One*)，数在前名词在后用序数 (*the first lesson*)。")
            ),
            famousQuote = "Not everything that can be counted counts, and not everything that counts can be counted.",
            quoteAuthor = "William Bruce Cameron",
            quoteTranslation = "并非所有能被计算的东西都有价值，也并非所有有价值的东西都能被计算。",
            quoteAnalysis = "利用 *count* 的双关义（计数与价值）生动展示了数词在哲学层面的表现力。"
        ),
        KnowledgePoint(
            id = "adj_adv",
            section = SEC_1,
            title = "形容词与副词 (Adj & Adv)",
            description = """
### 📖 核心概念详解

形容词 (Adjectives) 与副词 (Adverbs) 是英语句法的“色彩描绘器”。形容词修饰名词/代词；副词修饰动词、形容词、副词或全句。

#### 1. 比较等级 (Degrees of Comparison) 的不规则陷阱
| 原级 | 比较级 | 最高级 | 变换逻辑 |
| :--- | :--- | :--- | :--- |
| *good/well* | **better** | **best** | 经典不规则 |
| *bad/badly* | **worse** | **worst** | 经典不规则 |
| *many/much* | **more** | **most** | 经典不规则 |
| *little* | **less** | **least** | 表“少”时 (中考高频) |
| *far* | **farther/further** | **farthest/furthest** | 物理距离 vs 抽象程度 |

#### 2. 形容词的“排位金律” (OPSHCOM)
> 💡 **多个形容词修饰名词的语序**：
> **观** (观点) + **形** (大小/形状) + **龄** (新旧) + **色** (颜色) + **国** (产地) + **材** (材料)
> *   示例：*a beautiful small old black Chinese stone bridge* (一座美丽的黑色中国古石桥)

#### 3. 副词的“位移”法则
*   **Enough 的强制后置**：形容词/副词 + *enough* (*rich enough, fast enough*)。
*   **频度副词的“行前系后”**：实义动词前，系/助/情态动词后。

#### 4. 核心比较句型
1.  **同级**：*as + 原级 + as* (像...一样) / *not as/so...as*。
2.  **差级**：*比较级 + than* (比...更...)。
3.  **递增**：*the + 比较级, the + 比较级* (越...就越...)。
4.  **排他**：*比较级 + than any other + 名词单数* (比任何其他...都，表最高级意义)。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态变换】** 熟练掌握 100% 规则拼写（双写、y 变 i）及 5 组核心不规则比较级/最高级形态。",
                "**【位置控制】** 掌握 *enough* 在句中的位移规则，及多个形容词修饰名词时的 OPSHCOM 标准语序。",
                "**【逻辑辨析】** 深度区分 *hard/hardly, late/lately, wide/widely* 等形近义异的副词功能。",
                "**【句式进阶】** 精准运用 *the + 比较级*、*as...as* 结构及比较级表示最高级语义的逻辑转换。",
                "**【倍数逻辑】** 掌握 *three times as...as* 及 *three times the size of* 等倍数表达公式。",
                "**【修饰限制】** 明确 *very, quite* (修饰原级) 与 *much, even, far, a bit* (修饰比较级) 的阶级划分。"
            ),
            relatedPoints = listOf(
                RelatedPoint("系动词 (Link Verbs)", "形容词的物理出口", "感官系动词 (*look, sound, smell, taste, feel*) 及变化系动词 (*become, get, turn*) 后须强制匹配形容词作表语。"),
                RelatedPoint("比较级修饰语", "程度的精确量化", "比较级前可加 *much, far, a bit* 等词进行程度量化，这是中考改错题的常客。"),
                RelatedPoint("名词 (Nouns)", "形容词的宿主", "形容词作为定语修饰名词时，其位置与数量直接影响语言的地道性。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "The more books you read, the ______ your knowledge will be.", listOf("A. rich", "B. richer", "C. richest", "D. the richest"), "B", "**【解析】** 考查“越...越...”句型。物理结构为 *the + 比较级, the + 比较级*。故选 **B**。", "**【注意】** 第二个分句已有 *the*，只需填比较级形态。", "你读的书越多，你的知识就会越丰富。"),
                PastExamQuestion("2025", "天津", "He is ______ enough to carry that heavy box for his grandma.", listOf("A. strong", "B. stronger", "C. the strongest", "D. strongly"), "A", "**【解析】** *enough* 修饰形容词原级且必须后置。*strong* 是原级。故选 **A**。", "**【陷阱】** 不要根据中文“足够强”误选比较级。", "他力气足够大，能帮奶奶搬那个重盒子。"),
                PastExamQuestion("2024", "上海", "The Yellow River is the ______ longest river in China.", listOf("A. second", "B. two", "C. twice", "D. secondary"), "A", "**【解析】** 序数词置于最高级之前，用于精准锁定排名。故选 **A**。", "**【常考】** 序数词 + 最高级。", "黄河是中国第二长河。"),
                PastExamQuestion("2024", "广东", "I think Chinese is as ______ as English. Both are important.", listOf("A. interesting", "B. more interesting", "C. most interesting", "D. the most interesting"), "A", "**【解析】** *as...as* 结构物理锁定形容词原级。故选 **A**。", "**【基础】** 同级比较物理法则。", "我认为中文和英文一样有趣。两个都很重要。"),
                PastExamQuestion("2023", "江苏南京", "My English teacher is very patient. She speaks ______ in class than before.", listOf("A. more slowly", "B. most slowly", "C. slowly", "D. slowlier"), "A", "**【解析】** *than* 提示比较级；*slowly* 是双音节副词，比较级前加 *more*。故选 **A**。", "**【形态】** 严禁出现 *slowlier* 这种非法拼写。", "我的英语老师很有耐心。她在课上说话比以前更慢了。"),
                PastExamQuestion("2022", "四川成都", "This room is ______ smaller than that one.", listOf("A. very", "B. quite", "C. a bit", "D. too"), "C", "**【解析】** 修饰比较级的合法程度副词有 *much, even, far, a bit*。*very, too, quite* 仅能修饰原级。故选 **C**。", "**【等级】** 程度副词的阶级限制。", "这个房间比那个稍微小一点。"),
                PastExamQuestion("2021", "河南", "He works hard and he ______ finds time to rest.", listOf("A. hard", "B. hardly", "C. late", "D. lately"), "B", "**【解析】** *hard* 是努力，*hardly* 是几乎不。根据句意选 **B**。", "**【辨析】** 形似副词的词义突变。", "他工作努力，几乎找不到休息时间。"),
                PastExamQuestion("2020", "浙江杭州", "Which city is ______, Beijing, Shanghai or Guangzhou?", listOf("A. large", "B. larger", "C. largest", "D. the largest"), "D", "**【解析】** 三者对比物理锁定最高级，且最高级前须由 *the* 守卫。故选 **D**。", "**【范围】** 明确三者对比语境。", "北京、上海和广州，哪座城市最大？"),
                PastExamQuestion("2019", "福建", "The film is so ______ that I feel ______ with it.", listOf("A. boring; bored", "B. bored; boring", "C. boring; boring", "D. bored; bored"), "A", "**【解析】** 物之特征用 *-ing* (*boring*)；人之感受用 *-ed* (*bored*)。故选 **A**。", "**【情感】** 形容词后缀的逻辑指向。", "这部电影太无聊了，我感到很厌烦。"),
                PastExamQuestion("2018", "山东济南", "Li Hua is taller than ______ boy in his class.", listOf("A. any", "B. any other", "C. others", "D. the other"), "B", "**【解析】** 比较级表达最高级语义，需加 *other* 排除自身。故选 **B**。", "**【排他性】** 逻辑严密性的考查。", "李华比他班上任何其他男孩都高。"),
                PastExamQuestion("2017", "陕西", "The air in the countryside is much ______ than that in the city.", listOf("A. clean", "B. cleaner", "C. cleanest", "D. the cleanest"), "B", "**【解析】** *than* 提示比较级，*much* 修饰比较级。故选 **B**。", "**【规则】** *clean* 的比较级是 *cleaner*。", "农村的空气比城市干净得多。"),
                PastExamQuestion("2016", "重庆", "He runs ______ than any other student in our grade.", listOf("A. fast", "B. faster", "C. fastest", "D. the fastest"), "B", "**【解析】** *than* 锁定比较级。故选 **B**。", "**【逻辑】** 比较级表最高级含义。", "他跑得比我们年级任何其他学生都快。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Traveling by train is slower than by plane, but it is much more interesting for most travelers. You can see many beautiful villages and mountains through the window during the journey. For me, it is the most relaxing way to spend my holiday.", listOf(
                    HighlightedSentence("much more interesting", "**【程度强化】** *much* 修饰多音节比较级，这种双重修饰是中考阅读理解的高频定位点。"),
                    HighlightedSentence("the most relaxing way", "**【最高级判定】** 明确了范围是“所有旅行方式”中的最值。")
                ), "人教版 (Go for it!) 八下 Unit 3"),
                TextbookParagraph("In the soccer match yesterday, Lin Tao played really well. He ran faster than any other player in his team and scored two goals. Although he felt extremely tired after the game, he was very happy because they won.", listOf(
                    HighlightedSentence("played really well", "**【副词链】** *really* 修饰副词 *well*，*well* 修饰动词 *played*，构成严密的修饰链条。"),
                    HighlightedSentence("faster than any other player", "**【逻辑排他】** 必须使用 *other* 才能使林涛在队内的比较具有合法性。")
                ), "外研版 (New Standard) 九上 Module 4"),
                TextbookParagraph("The Amazon River is the second longest river in the world. It flows through the largest rainforest on earth. Many animals and plants live there because the environment is suitable for them.", listOf(
                    HighlightedSentence("the second longest", "**【精准排名】** 展示了序数词与最高级结合表达精确地理数据的标准语法。"),
                    HighlightedSentence("the largest rainforest", "**【绝对最值】** 定冠词 *the* 锁定了唯一的地理冠军。")
                ), "外研版 (New Standard) 九下 Module 1"),
                TextbookParagraph("Practice makes perfect. He has failed twice, but he is still hard-working. The harder you work, the luckier you will get in the future. Don't give up your dreams easily.", listOf(
                    HighlightedSentence("The harder..., the luckier...", "**【递进比例】** 这种句式在 2025 中考写作中被视为高分亮点句型。"),
                    HighlightedSentence("hard-working", "**【复合形容词】** 展示了英语通过连字符构建复杂属性的能力。")
                ), "沪教版 (Oxford) 九上 Unit 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("The climate of Kunming is much milder than that of Harbin in winter.", "昆明的气候比哈尔滨冬天的气候要温和得多。", "**【分析】** 包含比较级修饰语 *much* 及代词 *that* 的高级比较句。", "中考核心 (Complex)"),
                ExampleSentence("He is not so brave as his younger brother when facing serious challenges.", "在面对严重挑战时，他不像他弟弟那样勇敢。", "**【分析】** *not so...as* 用于否定句中的同级比较。", "基础必会 (Compound)"),
                ExampleSentence("The modern city where I live is becoming more and more beautiful every year.", "我居住的这座现代化城市每年正变得越来越漂亮。", "**【分析】** *more and more + adj.* 表达动态持续的趋势。", "趋势描述 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **修饰错位**：习惯性用 *very* 修饰比较级（如 *very taller*）。\n2. **形态混淆**：分不清 *hardly* (几乎不) 与 *hard* (努力) 的语义本质。\n3. **排他遗忘**：在比较级中漏掉 *other* 导致逻辑自相矛盾。"),
                TeachingNote("【教学金钥】备忘清单", "1. **天平平衡法**：利用天平演示 *as...as* 的物理平衡感。\n2. **OPSHCOM 顺口溜**：‘观形龄色国产材’，强化形容词排序语感。\n3. **情感后缀卡**：对比 *-ed* (心) 与 *-ing* (物) 的逻辑指向。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *than* 必选比较级；看到 *in/of* 锁定最高级；见到 *enough* 往后站。")
            ),
            famousQuote = "Comparison is the thief of joy.",
            quoteAuthor = "Theodore Roosevelt",
            quoteTranslation = "比较是偷走快乐的贼。",
            quoteAnalysis = "本句巧妙运用了名词性比较逻辑，警示我们关注自我而非盲目攀比。"
        ),
        KnowledgePoint(
            id = "prepositions",
            section = SEC_1,
            title = "介词 (Prepositions)",
            description = """
### 📖 核心概念详解

介词 (Prepositions) 是英语句子的“逻辑粘合剂”，用于精准定义时间、方位、方式及原因。

#### 1. 时间介词 (at, on, in) 的物理模型
| 介词 | 逻辑范畴 | 经典示例 |
| :--- | :--- | :--- |
| **at** | 具体时刻 / 瞬间点 | *at 8:00, at noon, at night, at Christmas* (指节日期间) |
| **on** | 具体某一天 / 某日早中晚 | *on Monday, on a rainy day, on the evening of May 1st* |
| **in** | 宽泛的时间段 | *in 2025, in winter, in the morning* |

#### 2. 方位介词的“三维建模”
*   **across vs through**：
    *   **across**：表面穿过 (*cross the road*)。
    *   **through**：内部穿过 (*through the forest/window/tunnel*)。
*   **over vs above**：
    *   **over**：正上方，且有覆盖感 (*flew over the mountain*)。
    *   **above**：仅指位置高，不一定正对 (*above the sea level*)。
*   **between vs among**：
    *   **between**：两者之间。
    *   **among**：三者及以上之间。

#### 3. 方式介词辨析 (by, with, in)
1.  **by**：交通方式 (*by bus*)、手段 (*by doing*)。
2.  **with**：具体物理工具 (*with a pen*)、身体部位 (*with my eyes*)。
3.  **in**：语言媒介 (*in English*)、穿着 (*in red*)。

#### 4. “in + 段时间”的将来逻辑
在中考中，*in + a week* 表示“一周之后”，常用于一般将来时，对其提问必须物理锁定 **How soon**。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【时间精准化】** 熟练区分 *at, on, in* 的应用边界，重点攻克‘具体某天早中晚’用 *on* 的陷阱。",
                "**【空间三维化】** 建立 *through, across, past* 的运动路径模型，掌握 *over/above* 的高度差逻辑。",
                "**【固定搭配】** 熟练掌握 50 组以上核心介词短语（如 *look forward to, depend on, be good at*）。",
                "**【手段判定】** 精准区分 *by, with, in* 表达手段与媒介时的微小语义质变。",
                "**【将来提问】** 掌握 *in + 段时间* 的时态功能及其对应的 *How soon* 提问逻辑。",
                "**【宾语形态】** 明确介词后须接名词、代词宾格或动名词 *doing* 的硬性语法物理要求。"
            ),
            relatedPoints = listOf(
                RelatedPoint("动词短语", "语义的灵魂", "动词与介词结合后常产生特定语义（如 *look for* 寻找 vs *look after* 照顾），不可分割。"),
                RelatedPoint("非谓语动词 (Gerunds)", "介词的天然宾语", "绝大多数介词后接动词必须转化为 *doing* 态以维持句法平衡。"),
                RelatedPoint("状语从句", "逻辑的简化", "介词短语常可替代原因、让步状语从句（如 *because of* vs *because*）。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "天津", "The library is closed ______ August 1st ______ August 15th.", listOf("A. from; to", "B. between; and", "C. at; on", "D. in; at"), "A", "**【解析】** 考查时间起止。*from...to...* 是标准物理结构。故选 **A**。", "**【注意】** 也可以用 *between...and*，但选项中无此组合。", "图书馆从 8 月 1 日关闭到 8 月 15 日。"),
                PastExamQuestion("2025", "北京", "The meeting will start ______ 9:00 ______ the morning of Monday.", listOf("A. at; in", "B. on; in", "C. at; on", "D. in; on"), "C", "**【解析】** 9点是时刻用 *at*；周一早晨是具体某天早晨用 *on*。故选 **C**。", "**【陷阱】** 容易看到 *morning* 盲目选 *in*。", "会议将在周一早晨 9 点开始。"),
                PastExamQuestion("2024", "广东", "I usually go to school ______ bike, but ______ a snowy day, I walk.", listOf("A. by; in", "B. on; on", "C. by; on", "D. in; in"), "C", "**【解析】** *by bike* 交通方式；*on a snowy day* 具体天气的一天用 *on*。故选 **C**。", "**【标志】** 具体日期的前缀词判定。", "我通常骑车上学，但在下雪天我走路。"),
                PastExamQuestion("2024", "上海", "It's dangerous to walk ______ the busy road without looking.", listOf("A. across", "B. through", "C. past", "D. along"), "A", "**【解析】** 表面横穿马路用 *across*。故选 **A**。", "**【建模】** 马路是平面，故用 *across*。", "不看路就横穿马路是很危险的。"),
                PastExamQuestion("2023", "江苏南京", "— How soon will your father return?\n— ______ two weeks.", listOf("A. After", "B. In", "C. For", "D. Since"), "B", "**【解析】** *How soon* 提问多久之后，用 *In + 段时间* 回答。故选 **B**。", "**【提问关联】** 提问词与介词的锁定关系。", "—— 你爸爸多久后回来？ —— 两周后。"),
                PastExamQuestion("2022", "湖北武汉", "The plane flew ______ the mountains and disappeared into the clouds.", listOf("A. through", "B. over", "C. across", "D. on"), "B", "**【解析】** 垂直经过高山上方用 *over*。故选 **B**。", "**【高度】** *over* 强调物理跨越感。", "飞机飞过了群山，消失在云中。"),
                PastExamQuestion("2021", "河南", "We should solve problems ______ our own efforts instead of depending ______ others.", listOf("A. with; on", "B. through; in", "C. by; on", "D. with; in"), "C", "**【解析】** *by efforts* 表达手段；*depend on* 固定搭配。故选 **C**。", "**【搭配】** 动词 + 介词的锁定关系。", "我们应该通过自己的努力解决问题，而不是依赖他人。"),
                PastExamQuestion("2020", "山东济南", "My home is ______ the post office and the hospital.", listOf("A. among", "B. between", "C. in", "D. at"), "B", "**【解析】** 两者之间用 *between*。故选 **B**。", "**【范围】** 区分两者与三者。", "我家在邮局和医院之间。"),
                PastExamQuestion("2019", "陕西", "I am looking forward ______ hearing from you soon.", listOf("A. at", "B. to", "C. for", "D. with"), "B", "**【解析】** *look forward to* 是固定短语，其中 *to* 是介词。故选 **B**。", "**【红线】** *to* 后接 *doing* 是必考点。", "我期待很快收到你的回信。"),
                PastExamQuestion("2018", "云南", "There are hundreds ______ students on the playground.", listOf("A. of", "B. in", "C. with", "D. for"), "A", "**【解析】** 模糊数量 *hundreds of*。故选 **A**。", "**【s定律】** 有 *s* 必有 *of*。", "操场上有数百名学生。"),
                PastExamQuestion("2017", "山西", "The park is ______ the north of the city.", listOf("A. in", "B. on", "C. to", "D. at"), "A", "**【解析】** 在城市内部的北部用 *in*。故选 **A**。", "**【方位】** *in* (内), *on* (接壤), *to* (隔海/不接壤)。", "公园在城市的北部。"),
                PastExamQuestion("2016", "安徽", "We usually have lunch ______ noon.", listOf("A. at", "B. in", "C. on", "D. for"), "A", "**【解析】** *at noon* 固定表达。故选 **A**。", "**【时刻】** 精确时间点用 *at*。", "我们通常在中午吃午饭。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("My school is in front of a big park. There is a clean river behind it. To get to the library, you need to go across the bridge and walk through the woods.", listOf(
                    HighlightedSentence("in front of", "**【空间关系】** 外部的前面（不含内部）。"),
                    HighlightedSentence("across the bridge", "**【运动轨迹】** 表面横切面的运动。"),
                    HighlightedSentence("through the woods", "**【内部穿透】** 强调在三维空间内的位移。")
                ), "人教版 (Go for it!) 七下 Unit 1"),
                TextbookParagraph("I usually have breakfast at 7:00. After school, I often play the violin for an hour. On Saturday mornings, I go to the library with my friends.", listOf(
                    HighlightedSentence("at 7:00", "**【精确时刻】** *at* 锁定了具体的时间刻度。"),
                    HighlightedSentence("On Saturday mornings", "**【特定时段】** 具体某天的早晨必须物理性切换为 *on*。")
                ), "人教版 (Go for it!) 七下 Unit 6"),
                TextbookParagraph("He arrived at the station in time to catch the last train. He was concerned about missing it. Luckily, his father drove him there with his old car.", listOf(
                    HighlightedSentence("in time", "**【语义辨析】** “及时”，与 *on time* (准时) 构成中考核心对立。"),
                    HighlightedSentence("concerned about", "**【形容词搭配】** 展示了情绪形容词对介词的依赖。")
                ), "沪教版 (Oxford) 八上 Unit 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("The plane flew over the mountains and disappeared into the thick clouds.", "飞机飞过了群山，消失在浓云中。", "**【分析】** *over* 表示跨越感；*into* 表达动态的进入。", "空间描述 (Complex)"),
                ExampleSentence("With the help of the new machine, they finished the work ahead of time.", "在机器的帮助下，他们提前完成了工作。", "**【分析】** *With the help of* 与 *ahead of time* (提前) 的双重介词应用。", "高阶句法 (Compound)"),
                ExampleSentence("I am interested in learning Chinese history by visiting the local museums.", "我通过参观当地博物馆对学习中国历史产生了兴趣。", "**【分析】** *interested in* 后接 *doing*；*by doing* 表达手段。", "基础必会 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **母语直译**：受汉语“在...之下”影响误写 *under one's help* (应为 *with*)。\n2. **三维盲点**：分不清 *across* (面) 与 *through* (体) 的模型。\n3. **标志性缺失**：分不清 *in time* 与 *on time* 的语义力度。"),
                TeachingNote("【教学金钥】备忘清单", "1. **空间实物演示**：利用粉笔盒演示方位关系。\n2. **时间金字塔**：底部大范围 *in*，顶端精准 *at*。\n3. **搭配记忆网**：以介词为核心节点，辐射关联的动词与形容词。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到森林隧道选 *through*；看到具体日期选 *on*；看到 *the help of* 必选 *with*。")
            ),
            famousQuote = "To be or not to be, that is the question.",
            quoteAuthor = "William Shakespeare",
            quoteTranslation = "生存还是毁灭，这是一个值得考虑的问题。",
            quoteAnalysis = "介词 'to' 虽然在此作为不定式符号，但它连接了人类历史上最深刻的逻辑抉择。"
        ),
        KnowledgePoint(
            id = "conjunctions",
            section = SEC_1,
            title = "连词 (Conjunctions)",
            description = """
### 📖 核心概念详解

连词 (Conjunctions) 是英语句子的“逻辑骨架”。

#### 1. 并列连词 (Coordinating Conjunctions)
| 类别 | 成员 | 逻辑含义 |
| :--- | :--- | :--- |
| **并列** | *and, as well as* | 顺接，逻辑一致 |
| **转折** | *but, yet* | 逆接，相反含义 |
| **选择** | *or, either...or* | 非此即彼 |
| **因果** | *so, for* | 推导出结果或补充原因 |

#### 2. 关联连词的“就近原则” (核心考位)
> 💡 **权力中心法则**：谓语动词的形态由离它最近的主语决定。
> *   *not only A but also **B*** + 谓语
> *   *either A or **B*** + 谓语
> *   *neither A nor **B*** + 谓语
> ⚠️ **例外**：*both A and B* 谓语恒用复数。

#### 3. 中考逻辑禁忌红线
*   **BC/SO 不并存**：*because* 与 *so* 不能在同一句中同时出现。
*   **AL/BUT 不并存**：*although/though* 与 *but* 不能在同一句中同时出现。

#### 4. 特殊句式逻辑
*   **祈使句 + and + 陈述句**：表示“如果...就...”。
*   **祈使句 + or + 陈述句**：表示“快点，否则...”。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【并列逻辑】** 精准判定四种并列关系，掌握 *and/or* 在祈使句混合结构中的语用功能。",
                "**【就近一致】** 熟练运用关联连词，掌握 *neither...nor* 等结构对谓语动词数的物理控制权。",
                "**【互斥铁律】** 严格执行 *because/so* 及 *although/but* 的二选一法则，杜绝母语负迁移。",
                "**【条件代换】** 掌握 *unless* 与 *if...not* 的等值逻辑转换技巧。",
                "**【引导词判定】** 理解从属连词对从句性质的锁定（如 *until* 对主句谓语延续性的要求）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "距离产生的权力", "关联连词是中考考查就近原则的主战场。"),
                RelatedPoint("祈使句", "隐性条件表达", "‘祈使句 + 连词’ 是高级复合句的逻辑变体。"),
                RelatedPoint("状语从句", "逻辑的旗手", "从属连词直接决定了从句是时间、地点还是原因状语。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "Work hard, ______ you will achieve your goals one day.", listOf("A. and", "B. or", "C. but", "D. so"), "A", "**【解析】** 考查“祈使句 + and + 结果”结构。表示正向结果。故选 **A**。", "**【注意】** 这里的 and 带有“那么”的意思。", "努力工作，总有一天你会实现目标。"),
                PastExamQuestion("2025", "上海", "Neither my parents nor my brother ______ to the Great Wall before.", listOf("A. have", "B. has", "C. are", "D. is"), "B", "**【解析】** *neither...nor* 遵循就近原则。主语 *my brother* 是单三。故选 **B**。", "**【陷阱】** 不要因为 *parents* 选 have。", "我父母和我弟弟以前都没去过长城。"),
                PastExamQuestion("2024", "广东", "Hurry up, ______ you will miss the early train.", listOf("A. and", "B. but", "C. or", "D. so"), "C", "**【解析】** 考查“祈使句 + or + 后果”结构。表示“否则”。故选 **C**。", "**【逻辑】** 动作不执行的负面后果。", "快点，否则你会错过早班火车。"),
                PastExamQuestion("2024", "天津", "______ she is very busy, ______ she still finds time to read.", listOf("A. Although; but", "B. Because; so", "C. Although; /", "D. Because; /"), "C", "**【解析】** *although* 与 *but* 不能共存。故选 **C**。", "**【红线】** 英语逻辑严禁双重标记。", "虽然她很忙，但她仍抽时间阅读。"),
                PastExamQuestion("2023", "江苏南京", "— Which would you like, tea ______ coffee?\n— Either is OK. I don't mind.", listOf("A. and", "B. or", "C. but", "D. so"), "B", "**【解析】** 询问二选一，用并列连词 *or*。故选 **B**。", "**【语境】** 选择疑问句标志词。", "—— 你想要茶还是咖啡？ —— 哪个都行。我不介意。"),
                PastExamQuestion("2022", "四川成都", "I didn't go to bed ______ I finished all my work last night.", listOf("A. until", "B. because", "C. though", "D. if"), "A", "**【解析】** *not...until* 意为“直到...才”。故选 **A**。", "**【结构】** 否定句 + *until* + 终止点。", "昨天晚上我直到做完工作才睡觉。"),
                PastExamQuestion("2021", "河南", "He didn't come to school ______ he was badly ill.", listOf("A. so", "B. because", "C. although", "D. unless"), "B", "**【解析】** 后句是前句的原因。故选 **B**。", "**【基础】** 因果关系判定。", "他没来上学，因为他病得很重。"),
                PastExamQuestion("2020", "安徽", "You can't pass the exam ______ you work harder than before.", listOf("A. if", "B. unless", "C. because", "D. although"), "B", "**【解析】** *unless* 意为“除非”，相当于 *if...not*。故选 **B**。", "**【条件】** 逻辑排除法。", "除非你比以前更努力，否则你无法通过考试。"),
                PastExamQuestion("2019", "福建", "— Would you like to go shopping?\n— I'd like to, ______ I am busy today.", listOf("A. and", "B. but", "C. or", "D. so"), "B", "**【解析】** 前后语义转折。故选 **B**。", "**【交际】** 转折逻辑应用。", "—— 你想去购物吗？ —— 我想去，但我今天很忙。"),
                PastExamQuestion("2018", "山东济南", "Both you and he ______ good at playing the piano.", listOf("A. is", "B. are", "C. was", "D. were"), "B", "**【解析】** *both...and* 谓语恒用复数。故选 **B**。", "**【规则】** *both* 是绝对复数的标志。", "你和他都擅长弹钢琴。"),
                PastExamQuestion("2017", "陕西", "I'll wait here ______ she comes back.", listOf("A. until", "B. because", "C. if", "D. so"), "A", "**【解析】** 肯定句 *wait until* 意为“一直等到...”。故选 **A**。", "**【延续性】** 动词时长对连词的要求。", "我会一直在这儿等到她回来。"),
                PastExamQuestion("2016", "重庆", "Hurry up, ______ you will be late for school.", listOf("A. and", "B. or", "C. but", "D. so"), "B", "**【解析】** “否则”逻辑。故选 **B**。", "**【固定句式】** 祈使句 + *or*。", "快点，否则你上学会迟到。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Although the weather was bad, the volunteers still went there. They brought not only food but also medicine to the people. Both the young and the old were moved.", listOf(
                    HighlightedSentence("not only... but also...", "**【并列递进】** 用于强调服务范围的广泛性。"),
                    HighlightedSentence("Both... and...", "**【复数一致】** 展示了该连词对动词形态的物理锁定。")
                ), "人教版 (Go for it!) 九年级 Unit 5"),
                TextbookParagraph("Study hard, or you will fail. If you manage your time well, you will find learning is interesting. Don't give up because success belongs to those who work hard.", listOf(
                    HighlightedSentence("Study hard, or...", "**【隐性条件】** 将命令语气转化为逻辑推导。"),
                    HighlightedSentence("because success belongs", "**【因果逻辑】** 用于解释“为什么”要坚持。")
                ), "外研版 (New Standard) 八下 Module 6"),
                TextbookParagraph("Not only the students but also the teacher likes the idea. Neither of them wants to change the plan. Either you or I am going to tell them the news.", listOf(
                    HighlightedSentence("but also the teacher likes", "**【就近原则】** 谓语动词物理性靠近 *teacher* 故用单三。"),
                    HighlightedSentence("Either you or I am", "**【就近原则】** 谓语动词物理性靠近 *I* 故用 *am*。")
                ), "沪教版 (Oxford) 九下 Unit 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("Not only the students but also the teacher likes this book.", "不仅学生而且老师也喜欢这本书。", "**【分析】** 典型的就近原则复杂句，谓语随 *teacher* 变动。", "中考核心 (Complex)"),
                ExampleSentence("He won't leave for his hometown unless it stops raining.", "除非雨停，否则他不会启程回老家。", "**【分析】** *unless* 引导的条件从句遵循主将从现原则。", "高频易错 (Complex)"),
                ExampleSentence("Either you or I am going to the meeting this afternoon.", "要么是你，要么是我去开会。", "**【分析】** 就近原则在 *be* 动词选择上的体现。", "基础必会 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **汉语负迁移**：*bc/so* 连用是高发错误。\n2. **一致性盲点**：忽略 *both* 的绝对复数与 *neither* 等的就近原则。\n3. **逻辑倒置**：分不清 *unless* 与 *if* 的方向性。"),
                TeachingNote("【教学金钥】备忘清单", "1. **逻辑对对碰**：将连词与逻辑符号（+、-、?、=）匹配。\n2. **距离感应图**：画出谓语与主语的距离，强化就近意识。\n3. **红线划销法**：见到 *although* 强制划掉 *but* 的视觉训练。"),
                TeachingNote("【冲刺技巧】中考必杀技", "有 *both* 找复数；有 *neither* 找最近；见到 *although* 赶走 *but*。")
            ),
            famousQuote = "United we stand, divided we fall.",
            quoteAuthor = "Aesop",
            quoteTranslation = "团结则存，分裂则亡。",
            quoteAnalysis = "连词在平行结构与对立逻辑中的灵魂体现，展示了语言的逻辑张力。"
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
            id = "passive_voice",
            section = SEC_2,
            title = "被动语态 (Passive Voice)",
            description = """
### 📖 核心概念详解

被动语态 (Passive Voice) 强调“受动者”或“动作本身”，而非执行者。

#### 1. 核心物理公式
> 💡 **万变不离其宗**：**be + 过去分词 (done)**
> *be 动词承担所有的时态重任。*

| 时态 | 结构公式 | 示例 |
| :--- | :--- | :--- |
| 一般现在时 | **am/is/are + done** | *English is spoken here.* |
| 一般过去时 | **was/were + done** | *The tree was planted yesterday.* |
| 一般将来时 | **will be + done** | *The work will be finished soon.* |
| 现在完成时 | **have/has been + done** | *The room has been cleaned.* |
| 情态动词 | **情态动词 + be + done** | *It must be done at once.* |

#### 2. 中考禁忌：不进被动的“黑名单”
*   **不及物动词**：*happen, take place, stay, appear, disappear*。
*   **所属/特征动词**：*belong to, suit, cost, fail*。
*   ⚠️ **注意**：*The accident was happened* 是绝对的物理性错误。

#### 3. “复活”的 to (核心考位)
在主动语态中省略 *to* 的使役/感官动词 (*make, see, hear, watch*)，在被动语态中 ***to*** 必须强制“复活”。
*   主动：*He made me **cry**.*
*   被动：*I was made **to cry**.*
""".trimIndent(),
            syllabusDetails = listOf(
                "**【时态匹配】** 熟练掌握 5 种中考核心时态下的被动构成，重点关注完成时与将来时的被动物理形态。",
                "**【To的复活】** 掌握使役/感官动词变被动时，不定式符号 *to* 的物理还原规则。",
                "**【黑名单识别】** 强制熟记 *happen, belong to* 等不能使用被动语态的动词清单。",
                "**【短语完整性】** 掌握动词短语（如 *look after*）变被动时，末尾介词绝不可遗漏的原则。",
                "**【主动表被动】** 理解感官系动词（*tastes good*）及特征词（*sells well*）的主动形态被动语义。"
            ),
            relatedPoints = listOf(
                RelatedPoint("及物动词", "被动的前提", "只有及物动词或动词短语才具备物理转换为被动语态的资格。"),
                RelatedPoint("过去分词", "被动的形态灵魂", "熟练掌握不规则动词的过去分词是写对被动语态的基础。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "天津", "Computer is ______ widely ______ all over the world.", listOf("A. used; /", "B. being; used", "C. used; being", "D. is; used"), "A", "**【解析】** 考查一般现在时的被动语态。物理结构为 *is + done*。故选 **A**。", "**【注意】** 描述客观现状。", "电脑在全世界被广泛使用。"),
                PastExamQuestion("2025", "北京", "The flowers ______ every morning. They look fresh.", listOf("A. water", "B. are watered", "C. watered", "D. will water"), "B", "**【解析】** 花“被浇水”，主语复数，一般现在时被动。故选 **B**。", "**【基础】** 动作执行者不言自明。", "花每天早上都被浇水。"),
                PastExamQuestion("2024", "上海", "The heavy box ______ away by the workers in ten minutes.", listOf("A. will take", "B. will be taken", "C. is taking", "D. was taken"), "B", "**【解析】** *in ten minutes* 指将来；盒子“被搬走”。故选 **B**。", "**【将来被动】** 锁定时态与语态的双重交叉点。", "重盒子将在十分钟内由工人搬走。"),
                PastExamQuestion("2024", "广东", "Paper was first ______ in ancient China by Cai Lun.", listOf("A. invent", "B. invented", "C. inventing", "D. invention"), "B", "**【解析】** *was* 后跟动词过去分词构成过去被动。故选 **B**。", "**【发明背景】** 历史叙事必用被动。", "纸最初是由蔡伦在中国古代发明的。"),
                PastExamQuestion("2023", "江苏南京", "— I saw you come in just now.\n— No, I ______ to enter by the back door.", listOf("A. made", "B. was made", "C. was making", "D. am made"), "B", "**【解析】** “被要求/被使”进入。故选 **B**。", "**【To还原】** 此处虽未考 *to*，但结构上是 *be made to do*。", "—— 我刚才看见你进来了。 —— 不，我是被要求从后门进的。"),
                PastExamQuestion("2022", "湖北武汉", "English ______ in many countries as a first language.", listOf("A. speaks", "B. is spoken", "C. is speaking", "D. was spoken"), "B", "**【解析】** 英语“被说”，客观事实。故选 **B**。", "**【语用】** 语言描述的固定被动逻辑。", "英语在许多国家被作为第一语言使用。"),
                PastExamQuestion("2021", "河南", "The sick girl ______ to the hospital immediately yesterday.", listOf("A. took", "B. was taking", "C. was taken", "D. had taken"), "C", "**【解析】** 女孩“被送到”医院；*yesterday* 提示过去。故选 **C**。", "**【常规】** 过去被动语态应用。", "那个生病的女孩昨天立刻被送往医院了。"),
                PastExamQuestion("2020", "安徽", "A new bridge ______ over the river last year.", listOf("A. builds", "B. built", "C. was built", "D. will be built"), "C", "**【解析】** 桥“被建造”；*last year* 提示过去。故选 **C**。", "**【基础】** 基础设施描述时态。", "去年河上建起了一座新桥。"),
                PastExamQuestion("2019", "山东济南", "The bridge ______ after for many years and it is still strong.", listOf("A. was looked", "B. was looked after", "C. looked after", "D. is looking after"), "B", "**【解析】** 考查动词短语被动。*after* 绝不能丢。故选 **B**。", "**【短语被动】** 介词不遗漏原则。", "这座桥被照看（维护）了很多年，依然很坚固。"),
                PastExamQuestion("2018", "陕西", "What ______ last night? We heard a loud noise.", listOf("A. was happened", "B. happened", "C. was happening", "D. is happened"), "B", "**【解析】** *happen* 是不及物动词，严禁使用被动语态。故选 **B**。", "**【红线】** 区分及物与不及物动词的被动资格。", "昨晚发生了什么？我们听到了一声巨响。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Tea was first discovered in ancient China. It is said that Shen Nong first tasted it more than 5,000 years ago. Today, it is widely grown in South China.", listOf(
                    HighlightedSentence("Tea was first discovered", "**【发现史】** 描述未知来源的事实发现常选过去被动。"),
                    HighlightedSentence("it is widely grown", "**【现状描述】** 农业作物的分布固定使用现在被动。")
                ), "人教版 (Go for it!) 九年级 Unit 6"),
                TextbookParagraph("Many trees are cut down to make paper every year. We should try our best to save paper to protect the forests. If we don't, the earth will be polluted.", listOf(
                    HighlightedSentence("are cut down", "**【短语完整】** *cut down* 作为一个整体被动化，*down* 保留在原地。"),
                    HighlightedSentence("will be polluted", "**【未来预测】** 对环境恶化结果的客观预测。")
                ), "外研版 (New Standard) 九下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("The broken chair was repaired by my father in the garden yesterday.", "那把坏椅子昨天由我爸爸在花园里修好了。", "**【分析】** 包含动作执行者 *by sb* 的标准过去被动句。", "基础必会 (Simple)"),
                ExampleSentence("He was seen to enter the building by the neighbors just before the fire.", "邻居们在火灾前刚好看到他进了大楼。", "**【分析】** *see sb do* 变被动时，不定式符号 *to* 物理性还原。", "高阶句法 (Complex)"),
                ExampleSentence("The project must be finished on time to ensure the success of the plan.", "该项目必须准时完成，以确保计划的成功。", "**【分析】** 包含情态动词 *must* 的被动语态结构。", "中考核心 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **To的脱落**：在 *make/see* 变被动时漏掉 *to*。\n2. **黑名单误用**：受汉语“被发生”影响写出 *was happened*。\n3. **be动词遗漏**：写成 *The book written by...* (此处充当定语而非谓语)。"),
                TeachingNote("【教学金钥】备忘清单", "1. **身份互换图**：通过主动主语变 *by* 宾语的连线演示语态转换。\n2. **复活节比喻**：告诉学生 *to* 在被动语态中会“复活”。\n3. **黑名单口诀**：‘发生、消失、属于、值，被动语态不关事。’"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到不及物动词划掉被动选项；检查使役动词后是否有 *to*。")
            ),
            famousQuote = "Rome was not built in a day.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "罗马不是一天建成的。",
            quoteAnalysis = "本句展示了被动语态在表达客观真理与历史积淀时的庄重感。"
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
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
                PastExamQuestion(
                    "2024", "上海",
                    "— Do you know ______?\n— He is an engineer.",
                    listOf("A. what does he do", "B. what he does", "C. where does he work", "D. where he works"),
                    "B",
                    "**【解析】** 根据答语“他是工程师”确定询问职业。从句用陈述语序。故选 **B**。",
                    "**【综合】** 语序与语境的双重考查。",
                    "—— 你知道他是做什么的吗？ —— 他是个工程师。"
                ),
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
        ),
        KnowledgePoint(
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
        ),
        KnowledgePoint(
            id = "sv_agreement",
            section = SEC_3,
            title = "主谓一致 (Subject-Verb Agreement)",
            description = """
### 📖 核心概念详解

主谓一致是指谓语动词在“人称”和“数”上必须与主语保持逻辑契合。

#### 1. 语法一致原则 (Grammatical Agreement)
主语是单数，谓语用单数；主语是复数，谓语用复数。
*   *The boy **is** reading.* / *The boys **are** reading.*

#### 2. 意义一致原则 (Notional Agreement)
根据主语表达的逻辑意义而非表面形式决定。
*   **集体名词**：*family, class, team*。强调整体用单数 (*My family is large*)；强调成员用复数 (*My family are watching TV*)。
*   **时间/金钱/距离**：视为整体，谓语用单数。 (*Ten dollars **is** enough.*)
*   **不定代词**：*Everyone, each, neither* 作主语，谓语必用单数。

#### 3. 就近一致原则 (Proximity)
谓语动词的数由离它最近的主语决定。
*   **关联连词**关键词：*or, either... or, neither... nor, not only... but also*, 以及 *there be* 句型。
*   *Neither you nor **I am** right.*
""".trimIndent(),
            syllabusDetails = listOf(
                "**【三原则锁定】** 熟练判别语法一致、意义一致与就近一致的不同物理应用场景。",
                "**【集体名词】** 掌握 *family, police, cattle* 等词在不同语境下的数之选择。",
                "**【单位化主语】** 明确时间、金钱、长度等作为整体概念时对单数谓语的锁定性。",
                "**【并列逻辑】** 区分 *and* 连接时的“同一性”与“多样性”对动词形态的影响。"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词 (Nouns)", "数的源头", "名词的分类是主谓一致发生的物理前提。"),
                RelatedPoint("代词 (Pronouns)", "数的继承", "不定代词的逻辑单数属性是导致谓语变换的核心诱因。"),
                RelatedPoint("连词 (Conjunctions)", "就近的纽带", "关联连词是触发就近一致原则的主战场。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "Each of the students ______ a new dictionary from the school.", listOf("A. have", "B. has", "C. is having", "D. are having"), "B", "**【解析】** *Each of...* 作主语，谓语动词锁定单数。故选 **B**。", "**【注意】** 忽略介词短语修饰，聚焦核心。"),
                PastExamQuestion("2024", "广东", "The number of the students in our class ______ 50.", listOf("A. is", "B. are", "C. were", "D. be"), "A", "**【解析】** *The number of...* 强调“……的数量”，谓语用单数。故选 **A**。", "**【辨析】** *A number of...* (许多) 谓语用复数。")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **表象误解**：看到 *and* 就用复数，忽略了 *The singer and dancer* (同一个人)。\n2. **距离迷失**：被 *with his friends* 介词短语带偏，忽略了真正的主语。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("My family is large. My family are all busy with their work.", listOf(
                    HighlightedSentence("family is", "**【整体】** 强调整体，谓语用单数。"),
                    HighlightedSentence("family are", "**【成员】** 强调个体，谓语用复数。")
                ), "人教版 (Go for it!) 七上 Unit 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("Not only the teacher but also the students are looking forward to the holiday.", "不仅老师，学生们也都在期待假期。", "**【分析】** 遵循就近原则。"),
                ExampleSentence("Ten years is a long time for a person to wait.", "十年对一个人来说是漫长的等待。", "**【分析】** 时间整体主格。")
            ),
            famousQuote = "A team is only as strong as its weakest link.",
            quoteAuthor = "English Proverb",
            quoteTranslation = "团队的实力取决于它最薄弱的一环。",
            quoteAnalysis = "本句展示了主谓一致在界定整体逻辑强度时的精确性。"
        ),
        KnowledgePoint(
            id = "adverbial_clause",
            section = SEC_3,
            title = "状语从句 (Adverbial Clause)",
            description = """
### 📖 核心概念详解

状语从句在主句中充当状语，描述动作发生的时间、原因、条件、结果等。

#### 1. 时间状语从句 (Time)
引导词：*when, while, as, before, after, until, as soon as*。
*   ⚠️ **物理限制**：**“主将从现”** —— 主句用将来时，从句强制用一般现在时。

#### 2. 条件状语从句 (Condition)
引导词：*if, unless* (除非)。
*   ⚠️ **物理限制**：同样遵循 **“主将从现”** 原则。

#### 3. 原因状语从句 (Reason)
引导词：*because, as, since*。
*   *Because* 语气最强，回答 *Why* 提问。

#### 4. 让步状语从句 (Concession)
引导词：*although, though, even though*。
*   ⚠️ **红线**：英语中 *although* 不能与 *but* 连用。

#### 5. 目的与结果状语从句 (Purpose & Result)
*   **目的**：*so that...* (为了)。
*   **结果**：*so... that...* (如此...以至于...)。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【主将从现】** 深度掌握时间、条件状语从句中的时态物理差异。",
                "**【引导词匹配】** 区分 *if* (如果/是否)、*since* (既然/自从) 在从句中的多重身份。",
                "**【逻辑排斥】** 掌握 *because... (so)* 与 *although... (but)* 的物理互斥规则。",
                "**【so...that】** 掌握 *so* 与 *such* 的物理层级匹配（*so* 后面通常接 adj/adv）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般现在时", "替代将来", "状语从句是‘主将从现’语法规律的核心应用点。"),
                RelatedPoint("连词 (Conjunctions)", "逻辑信号", "状语从句本质上是连词驱动的逻辑复合体。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "天津", "I will tell him the news as soon as he ______ back.", listOf("A. come", "B. comes", "C. will come", "D. came"), "B", "**【解析】** *as soon as* 引导时间状语从句，主将从现。故选 **B**。", "**【时态】** 锁定一般现在时。"),
                PastExamQuestion("2024", "北京", "Although it was raining hard, ______ the students kept on practicing.", listOf("A. but", "B. so", "C. and", "D. /"), "D", "**【解析】** *Although* 与 *but* 不连用。语境中无需额外连词。故选 **D**。", "**【禁忌】** 物理排斥逻辑。")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **时态僵化**：在 *if* 引导的条件句中习惯性匹配 *will*。\n2. **母语迁移**：在受 *although* 影响时下意识加 *but*。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("If it is sunny tomorrow, we will go for a picnic. Although we are busy, we should still find time to relax.", listOf(
                    HighlightedSentence("If it is", "**【条件状语】** 遵循主将从现原则。"),
                    HighlightedSentence("Although we are", "**【让步状语】** *Although* 后面严禁加 *but*。")
                ), "外研版 (New Standard) 八下 Module 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("I will tell him the news as soon as he returns.", "他一回来我就告诉他。", "**【分析】** *as soon as* 引导时间状语从句。"),
                ExampleSentence("Since you are here, why not have dinner with us?", "既然你在这儿，就和我们一起吃晚饭吧。", "**【分析】** *Since* 引导原因状语从句。")
            ),
            famousQuote = "If at first you don't succeed, try, try again.",
            quoteAuthor = "William Hickson",
            quoteTranslation = "如果起初你没有成功，那就再试一次，再试一次。",
            quoteAnalysis = "本句生动诠释了条件状语从句在构建人生逻辑链条时的驱动作用。"
        )
    )
}
