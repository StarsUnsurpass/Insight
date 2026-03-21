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
    val exampleSentences: List<ExampleSentence>,
    val teachingNotes: List<TeachingNote> = emptyList(),
    val famousQuote: String,
    val quoteAuthor: String
)

object KnowledgeProvider {
    val allPoints = listOf(
        // ================= 板块一：词法体系 (Morphology) =================
        KnowledgePoint(
            id = "nouns", section = "板块一：词法体系 (Morphology)", title = "名词 (Nouns)",
            description = "初中英语词汇体系的基石，主要考查名词的分类、数的变化以及所有格形式。",
            syllabusDetails = listOf(
                "可数与不可数名词区分", 
                "名词复数规则变化与不规则变化", 
                "名词所有格（'s 与 of 结构）"
            ),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Name is the blueprint of the thing.", quoteAuthor = "Philosopher"
        ),
        KnowledgePoint(
            id = "pronouns", section = "板块一：词法体系 (Morphology)", title = "代词 (Pronouns)",
            description = "代替名词或起名词作用的词类，考点细致且繁杂。",
            syllabusDetails = listOf(
                "人称代词（主/宾格）", 
                "物主代词（形容词性/名词性）", 
                "反身代词", 
                "指示代词", 
                "疑问代词", 
                "不定代词（some/any/no 等复合代词极其重要）"
            ),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Substitute not your own power.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "articles", section = "板块一：词法体系 (Morphology)", title = "冠词 (Articles)",
            description = "置于名词之前，说明名词所指的人或事物。",
            syllabusDetails = listOf("定冠词 (the)", "不定冠词 (a/an)", "零冠词的固定搭配"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "A single step begins the journey.", quoteAuthor = "Lao Tzu"
        ),
        KnowledgePoint(
            id = "numerals", section = "板块一：词法体系 (Morphology)", title = "数词 (Numerals)",
            description = "表示数目多少或顺序先后的词。",
            syllabusDetails = listOf("基数词", "序数词", "分数表达", "时间/日期/年代表达法"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Numbers rule the universe.", quoteAuthor = "Pythagoras"
        ),
        KnowledgePoint(
            id = "adj_adv", section = "板块一：词法体系 (Morphology)", title = "形容词与副词 (Adjectives & Adverbs)",
            description = "修饰名词、动词、形容词或全句的词，重点在比较级和词义辨析。",
            syllabusDetails = listOf(
                "原级用法 (as...as)", 
                "比较级与最高级规则与不规则变化", 
                "常见修饰语 (much, a little, even)", 
                "易混淆形副词辨析"
            ),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Description is the key to clarity.", quoteAuthor = "Writer"
        ),
        KnowledgePoint(
            id = "prepositions", section = "板块一：词法体系 (Morphology)", title = "介词 (Prepositions)",
            description = "表示名词、代词等与句中其他词的关系。",
            syllabusDetails = listOf("时间介词 (in/on/at)", "方位/空间介词", "方式介词 (by/with/in)", "固定介词搭配"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Positioning is everything.", quoteAuthor = "Strategist"
        ),
        KnowledgePoint(
            id = "conjunctions", section = "板块一：词法体系 (Morphology)", title = "连词 (Conjunctions)",
            description = "用来连接词与词、短语与短语或句与句的词。",
            syllabusDetails = listOf("并列连词 (and, but, or, so)", "从属连词 (when, if, because, although)"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Connect the dots.", quoteAuthor = "Thinker"
        ),
        KnowledgePoint(
            id = "verbs_basic", section = "板块一：词法体系 (Morphology)", title = "动词基础 (Verbs)",
            description = "英语句子的核心，涵盖四大类基本动词及其基础用法。",
            syllabusDetails = listOf(
                "实义动词", 
                "连系动词 (be, look, sound, get)", 
                "助动词 (do/have/will)", 
                "情态动词 (can, must, should, may 及其表推测的用法)", 
                "常见短语动词 (Phrasal Verbs)"
            ),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Action speaks louder than words.", quoteAuthor = "Proverb"
        ),

        // ================= 板块二：时态与语态体系 (Tenses & Voices) =================
        KnowledgePoint(
            id = "simple_present", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "一般现在时 (Simple Present)",
            description = "表示经常性动作、客观真理或目前的普遍状态。",
            syllabusDetails = listOf("主语为第三人称单数时的动词变化", "客观真理、格言的固定时态表达", "时刻表或既定日程的将来意义用法"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Live in the present.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "simple_past", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "一般过去时 (Simple Past)",
            description = "表示过去某个时间发生的动作或存在的状态。",
            syllabusDetails = listOf("动词过去式的规则与不规则变化", "带有特定过去时间状语的句子", "used to do 结构的用法"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "The past is never dead.", quoteAuthor = "Faulkner"
        ),
        KnowledgePoint(
            id = "simple_future", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "一般将来时 (Simple Future)",
            description = "表示将来某个时间要发生的动作或状态。",
            syllabusDetails = listOf("will / be going to 的区别与用法", "条件/时间状语从句中的主将从现原则"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "The future belongs to those who prepare for it.", quoteAuthor = "Malcolm X"
        ),
        KnowledgePoint(
            id = "present_continuous", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "现在进行时 (Present Continuous)",
            description = "表示现在（说话瞬间）正在进行或发生的动作。",
            syllabusDetails = listOf("be + doing 结构", "不用于进行时的状态动词", "表示按计划或安排即将发生的将来动作"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Life is happening now.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "past_continuous", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "过去进行时 (Past Continuous)",
            description = "表示过去某一时刻或某段时间正在进行的动作。",
            syllabusDetails = listOf("was/were + doing 结构", "when 和 while 引导的时间状语从句中的动作长短配合"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Time was flowing like a river.", quoteAuthor = "Unknown"
        ),
        
        // 🌟 满级打样示范节点：现在完成时 🌟
        KnowledgePoint(
            id = "present_perfect", 
            section = "板块二：时态与语态体系 (Tenses & Voices)", 
            title = "现在完成时 (Present Perfect)",
            description = "基本结构：主语 + have / has + 动词的过去分词 (V-ed / done)。\n\n" +
                          "核心语境一（影响结果）：表示过去发生的动作对现在造成了影响或结果。\n" +
                          "特征：动作已经结束，但影响还在。\n" +
                          "标志词：already (已经，用于肯定句), yet (还，用于否定/疑问句), just (刚刚), ever (曾经), never (从不)。\n\n" +
                          "核心语境二（持续动作）：表示动作从过去某一时刻开始，一直持续到现在，甚至可能继续持续下去。\n" +
                          "特征：动作还在进行中。\n" +
                          "标志词：for + 时间段 (e.g., for 3 years), since + 时间点/过去时的句子 (e.g., since 2020 / since he left)。\n\n" +
                          "⚠️ 核心考点预警：与 for/since 连用时，谓语动词必须是延续性动词（如 live, teach, keep），瞬间动词（如 buy, borrow, leave）必须进行转换（如 buy -> have, borrow -> keep, leave -> be away）。",
            syllabusDetails = listOf(
                "基本结构与动词过去分词的变化",
                "核心语境一（影响结果）及标志词用法",
                "核心语境二（持续动作）及 for/since 搭配",
                "瞬间动词与延续性动词的强制转换规则"
            ),
            relatedPoints = listOf(
                RelatedPoint("动词过去分词的不规则变化表", "不规则动词的变化是写对完成时的基础。", "现在完成时的核心构成即为 have/has + done。"),
                RelatedPoint("一般过去时 vs 现在完成时", "两者都涉及过去的动作，但关注点不同。", "一般过去时强调动作发生的时间点，完成时强调对现在的影响。"),
                RelatedPoint("瞬间动词与延续性动词的转换规律", "核心考点，解决 for/since 语法错误的关键。", "例如 die 必须转换为 be dead 才能与 for 3 years 连用。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "苏州中考", 
                    "— Look! Someone ______ the classroom. It's so clean now.\n— Well, it wasn't me. I didn't do it.", 
                    listOf("A. is cleaning", "B. has cleaned", "C. was cleaning", "D. cleans"), 
                    "B", 
                    "【答案】B\n【解析】考察现在完成时的“影响结果”。教室现在很干净（It's so clean now），说明打扫的动作发生在过去，但对现在造成了影响。",
                    errorProne = "学生容易看到 'Look!' 就习惯性选择现在进行时 (A. is cleaning)。但在本题语境中，打扫的动作已经完成，强调的是造成的结果（教室干净了），而非动作正在进行。",
                    translation = "— 看！有人打扫过教室了。现在真干净。\n— 哎，不是我。我没打扫。"
                ),
                PastExamQuestion(
                    "2023", "苏州中考", 
                    "Mr. Wu ______ in this school since he graduated from university.", 
                    listOf("A. teaches", "B. taught", "C. has taught", "D. will teach"), 
                    "C", 
                    "【答案】C\n【解析】考察现在完成时的“持续动作”。标志词为 since + 过去时的句子，主句必须用现在完成时，且 teach 为延续性动词，符合语法规范。",
                    translation = "吴老师自从大学毕业以来，一直在这所学校教书。"
                ),
                PastExamQuestion(
                    "2021", "南京中考改编", 
                    "His uncle _______ for three years.", 
                    listOf("A. has died", "B. has been dead", "C. died", "D. dies"), 
                    "B", 
                    "【答案】B\n【解析】这是现在完成时最经典的“瞬间动词转换”陷阱。有 for three years 必须用延续性动词，die 是瞬间动词，不能和 for 连用，必须转为状态 be dead。",
                    errorProne = "极易错选 A。很多学生看到 for three years 知道用现在完成时，但忽略了 die 是瞬间动作，不能延续三年。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Have you read Treasure Island yet? No, I haven't. But I have already finished reading Little Women. I like music that I can dance to.",
                    listOf(
                        HighlightedSentence("Have you read Treasure Island yet?", "此处 yet 用于疑问句，表示‘已经’（期待肯定回答），是完成时‘影响结果’用法的典型标志。"),
                        HighlightedSentence("I have already finished reading Little Women.", "此处 already 用于肯定句，强调动作已完成并且对现在产生了影响。")
                    ),
                    "—— 出处同步：人教版 (PEP) 八年级下册 Unit 8 & 九年级 Unit 9"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "I have already finished my homework.", 
                    "我已经做完作业了。", 
                    analysis = "【影响】过去完成的动作（写作业）对现在产生了影响（现在可以出去玩了）。already 是标志词，通常放在 have/has 和过去分词之间。",
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "She hasn't arrived yet.", 
                    "她还没到。", 
                    analysis = "【影响】过去的动作未发生，其影响是“我们现在还需要继续等”。yet 常用于否定句和疑问句句末。",
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "We have lived in Suzhou since 10 years ago.", 
                    "我们住在苏州已经 10 年了。", 
                    analysis = "【持续】表示“居住”这个动作从 10 年前开始，一直延续到现在，并且可能继续下去。live 是延续性动词，可以和 since + 时间点连用。",
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 忘记把动词变为过去分词，常跟一般过去时的过去式混淆（尤其是 catch, bring 等不规则变化）。\n2. 做单选题时，看到 since/for 不假思索直接选完成时，忽略了动词是否具有延续性。"),
                TeachingNote("辅导建议", "画时间轴！一定要在黑板/课件上画出一条带有 'Past' 和 'Now' 的箭头线，用视觉化的方式展示跨越时间的桥梁，比讲语言规则有效得多。")
            ),
            famousQuote = "What is past is prologue.",
            quoteAuthor = "William Shakespeare"
        ),

        KnowledgePoint(
            id = "past_perfect", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "过去完成时 (Past Perfect)",
            description = "表示在过去某一时间或动作之前已经发生或完成了的动作（即“过去的过去”）。",
            syllabusDetails = listOf("had + 过去分词结构", "与一般过去时的时间先后顺序对比"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Before the end.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "past_future", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "过去将来时 (Past Future)",
            description = "表示从过去某一时间看将要发生的动作或存在的状态。",
            syllabusDetails = listOf("would + do", "was/were going to do", "常用于宾语从句中"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Looking back at what was to come.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "passive_voice", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "被动语态 (Passive Voice)",
            description = "表示主语是动作的承受者。",
            syllabusDetails = listOf("一般现在时被动", "一般过去时被动", "一般将来时被动", "含有情态动词的被动语态"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Things are done, not just do.", quoteAuthor = "Grammarian"
        ),
        KnowledgePoint(
            id = "non_finite_verbs", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "非谓语动词 (Non-finite Verbs)",
            description = "在句中不单独作谓语的动词形式。",
            syllabusDetails = listOf("动词不定式 (to do) 作主/宾/宾补/状/定语", "动名词 (doing) 作主/宾语", "分词 (doing/done) 作定语或状语"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Infinite possibilities.", quoteAuthor = "Unknown"
        ),

        // ================= 板块三：句法体系 (Syntax) =================
        KnowledgePoint(
            id = "sentence_types", section = "板块三：句法体系 (Syntax)", title = "句子种类",
            description = "按句子的使用目的进行的分类。",
            syllabusDetails = listOf("陈述句", "疑问句（一般/特殊/选择/反意疑问句）", "祈使句", "感叹句 (What/How 引导)"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Ask why.", quoteAuthor = "Socrates"
        ),
        KnowledgePoint(
            id = "five_basic_patterns", section = "板块三：句法体系 (Syntax)", title = "简单句基本句型",
            description = "构成英语句子的五种最基本结构。",
            syllabusDetails = listOf("主谓 (SV)", "主谓宾 (SVO)", "主系表 (SVP)", "主谓双宾 (SVOO)", "主谓宾宾补 (SVOC)"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Structure is everything.", quoteAuthor = "Architect"
        ),
        KnowledgePoint(
            id = "object_clause", section = "板块三：句法体系 (Syntax)", title = "宾语从句 (Object Clause)",
            description = "在复合句中充当宾语的从句。",
            syllabusDetails = listOf("引导词 (that/if/whether/wh-)", "语序（必须是陈述语序）", "时态呼应规则"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "I know that I know nothing.", quoteAuthor = "Socrates"
        ),
        KnowledgePoint(
            id = "adverbial_clause", section = "板块三：句法体系 (Syntax)", title = "状语从句 (Adverbial Clause)",
            description = "在复合句中充当状语的从句。",
            syllabusDetails = listOf("时间状语从句", "条件状语从句 (主将从现原则)", "原因状语从句", "结果状语从句 (so...that / such...that)", "目的、让步、比较状语从句"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "When in Rome, do as the Romans do.", quoteAuthor = "Proverb"
        ),
        KnowledgePoint(
            id = "attributive_clause", section = "板块三：句法体系 (Syntax)", title = "定语从句 (Attributive Clause)",
            description = "在复合句中修饰名词或代词的从句。",
            syllabusDetails = listOf("关系代词 (who, whom, whose, which, that) 的用法与省略", "关系副词 (where, when, why) 的基本概念"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "The man who reads lives a thousand lives.", quoteAuthor = "George R.R. Martin"
        ),
        KnowledgePoint(
            id = "special_patterns", section = "板块三：句法体系 (Syntax)", title = "特殊句式",
            description = "英语中特殊的语法结构和一致性原则。",
            syllabusDetails = listOf("There be 句型", "It 的固定句型 (It takes sb. some time to do...)", "倒装句（so/neither 引起的半倒装）", "主谓一致原则（语法一致、意义一致、就近原则）"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Rules are meant to be understood.", quoteAuthor = "Unknown"
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        val point = allPoints.find { it.id == cleanId }
        
        // Demo mode: If the requested point has no detailed content, show the Present Perfect template
        if (point != null && point.pastExamQuestions.isEmpty() && point.textbookParagraphs.isEmpty()) {
            return allPoints.find { it.id == "present_perfect" }
        }
        
        return point ?: allPoints.find { it.id == "present_perfect" }
    }
}
