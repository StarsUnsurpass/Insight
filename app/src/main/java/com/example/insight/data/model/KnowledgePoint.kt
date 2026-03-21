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
    val explanation: String
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
    val section: String, // "板块一：词法体系", "板块二：时态与语态体系", "板块三：句法体系"
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
        // 板块一：词法体系 (Morphology)
        KnowledgePoint(
            id = "0", section = "板块一：词法体系", title = "名词 (Nouns)",
            description = "表示人、事物、地点或抽象概念的词。",
            syllabusDetails = listOf("可数与不可数名词区分", "名词复数规则变化与不规则变化", "名词所有格（'s 与 of 结构）"),
            relatedPoints = listOf(RelatedPoint("冠词", "名词前的限定词。", "数决定了 a/an 的使用。")),
            exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Knowledge is power.", quoteAuthor = "Bacon"
        ),
        KnowledgePoint(
            id = "1", section = "板块一：词法体系", title = "代词 (Pronouns)",
            description = "代替名词或起名词作用的短语、句子的词。",
            syllabusDetails = listOf("人称代词（主/宾格）", "物主代词（形容词性/名词性）", "反身代词", "指示代词", "疑问代词", "不定代词（some/any/no 等复合代词极其重要）"),
            relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Be yourself.", quoteAuthor = "Wilde"
        ),
        KnowledgePoint(id = "2", section = "板块一：词法体系", title = "冠词 (Articles)", description = "置于名词前说明指代对象。", syllabusDetails = listOf("定冠词 (the)", "不定冠词 (a/an)", "零冠词的固定搭配"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "A single step.", quoteAuthor = "Lao Tzu"),
        KnowledgePoint(id = "3", section = "板块一：词法体系", title = "数词 (Numerals)", description = "表示数量或顺序的词。", syllabusDetails = listOf("基数词", "序数词", "分数表达", "时间/日期/年代表达法"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Counting the days.", quoteAuthor = "Ali"),
        KnowledgePoint(id = "4", section = "板块一：词法体系", title = "形容词与副词 (Adj & Adv)", description = "修饰名词、动词、形容词或全句。", syllabusDetails = listOf("原级用法 (as...as)", "比较级与最高级规则与不规则变化", "常见修饰语 (much, a little, even)", "易混淆形副词辨析"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Stay hungry.", quoteAuthor = "Jobs"),
        KnowledgePoint(id = "5", section = "板块一：词法体系", title = "介词 (Prepositions)", description = "表示名词等与句中其他词的关系。", syllabusDetails = listOf("时间介词 (in/on/at)", "方位/空间介词", "方式介词 (by/with/in)", "固定介词搭配"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Under the sun.", quoteAuthor = "Solomon"),
        KnowledgePoint(id = "6", section = "板块一：词法体系", title = "连词 (Conjunctions)", description = "连接词、短语或句子的词。", syllabusDetails = listOf("并列连词 (and, but, or, so)", "从属连词 (when, if, because, although)"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "United we stand.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "21", section = "板块一：词法体系", title = "动词基础 (Verbs)", description = "动词的分类与基础用法。", syllabusDetails = listOf("实义动词", "连系动词 (be, look, sound, get)", "助动词 (do/have/will)", "情态动词 (can, must, should, may 及其表推测)", "常见短语动词"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Actions speak.", quoteAuthor = "Proverb"),

        // 板块二：时态与语态体系 (Tenses & Voices)
        KnowledgePoint(id = "22", section = "板块二：时态与语态体系", title = "一般现在时 (Simple Present)", description = "经常性动作或客观真理。", syllabusDetails = listOf("基本结构", "单三变化", "客观真理用法"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Today counts.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "23", section = "板块二：时态与语态体系", title = "一般过去时 (Simple Past)", description = "过去发生的动作。", syllabusDetails = listOf("过去式变化", "时间标志词", "used to 结构"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Past is prologue.", quoteAuthor = "Shakespeare"),
        KnowledgePoint(id = "24", section = "板块二：时态与语态体系", title = "一般将来时 (Simple Future)", description = "将要发生的动作。", syllabusDetails = listOf("will / be going to", "时刻表将来意义"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Future belongs.", quoteAuthor = "Roosevelt"),
        KnowledgePoint(id = "25", section = "板块二：时态与语态体系", title = "现在进行时 (Present Continuous)", description = "正在进行的动作。", syllabusDetails = listOf("be + doing", "将来意义用法"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Life is doing.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "26", section = "板块二：时态与语态体系", title = "过去进行时 (Past Continuous)", description = "过去某时刻正在进行。", syllabusDetails = listOf("was/were + doing", "when/while 结合"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Remembering now.", quoteAuthor = "Unknown"),
        
        KnowledgePoint(
            id = "7",
            section = "板块二：时态与语态体系",
            title = "现在完成时 (Present Perfect)",
            description = "初中英语最难、考频最高的知识点，考查动作的持续与影响。",
            syllabusDetails = listOf(
                "基本结构：主语 + have / has + 动词的过去分词 (V-ed / done)。",
                "核心语境一（影响结果）：表示过去发生的动作对现在造成的影响或结果（标志词：already, yet, just, ever, never）。",
                "核心语境二（持续动作）：表示动作从过去开始一直持续到现在（标志词：for + 时间段, since + 时间点/过去时句子）。",
                "瞬间动词转换：与 for/since 连用时，谓语动词必须是延续性动词。"
            ),
            relatedPoints = listOf(
                RelatedPoint("不规则变化", "动词过去分词的不规则变化表。", "这是构成现在完成时的基础。"),
                RelatedPoint("一般过去时", "一般过去时 vs 现在完成时辨析。", "一个强调过去时间点，一个强调对现在的影响。"),
                RelatedPoint("动词分类", "瞬间动词与延续性动词的转换规律。", "解决 for/since 句型的核心陷阱。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "苏州中考", "— Look! Someone ______ the classroom. It's so clean now.\n— Well, it wasn't me. I didn't do it.", listOf("A. is cleaning", "B. has cleaned", "C. was cleaning", "D. cleans"), "B", "选 B。考察现在完成时的“影响结果”。教室现在很干净（It's so clean now），说明打扫的动作发生在过去，但对现在造成了影响。"),
                PastExamQuestion("2023", "苏州中考", "Mr. Wu ______ in this school since he graduated from university.", listOf("A. teaches", "B. taught", "C. has taught", "D. will teach"), "C", "选 C。考察现在完成时的“持续动作”。标志词为 since + 过去时的句子，主句必须用现在完成时，且 teach 为延续性动词。"),
                PastExamQuestion("2021", "南京中考", "His uncle _______ for three years.", listOf("A. has died", "B. has been dead", "C. died", "D. dies"), "B", "选 B。这是现在完成时最经典的“瞬间动词转换”陷阱。有 for three years 必须用延续性动词，die 是瞬间动词，必须转为状态 be dead。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Have you read Treasure Island yet? No, I haven't. But I have finished reading Little Women already.",
                    listOf(
                        HighlightedSentence("Have you read Treasure Island yet?", "此处 'yet' 用于疑问句，表示‘已经’（期待肯定回答）。"),
                        HighlightedSentence("I have finished reading Little Women already.", "此处 'already' 用于肯定句，强调动作已完成的影响。")
                    ),
                    "—— 摘自《人教版八下》Unit 8"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I have already finished my homework. (我已经做完作业了。—— 影响：现在可以出去玩了)", "已经做完作业。"),
                ExampleSentence("She hasn't arrived yet. (她还没到。—— 影响：我们还要继续等)", "她还没到。"),
                ExampleSentence("We have lived in Suzhou since 10 years ago. (我们住在苏州已经 10 年了。—— 持续：现在依然住在这里)", "住在苏州十年。")
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 忘记把动词变为过去分词，常跟一般过去时的过去式混淆；2. 做单选题时，忽略了动词是否具有延续性。"),
                TeachingNote("辅导建议", "画时间轴！一定要在黑板/课件上画出一条带有 'Past' 和 'Now' 的箭头线，用视觉化的方式展示跨越时间的桥梁。")
            ),
            famousQuote = "Procrastination is the thief of time.",
            quoteAuthor = "Edward Young"
        ),
        KnowledgePoint(id = "27", section = "板块二：时态与语态体系", title = "过去完成时 (Past Perfect)", description = "过去的过去。", syllabusDetails = listOf("had + done", "by the time 搭配"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Before the end.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "28", section = "板块二：时态与语态体系", title = "过去将来时 (Past Future)", description = "过去看将来。", syllabusDetails = listOf("would + do", "was/were going to"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Looking back.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "8", section = "板块二：时态与语态体系", title = "被动语态 (Passive Voice)", description = "动作的承受者。", syllabusDetails = listOf("一般现在/过去/将来时被动", "含情态动词的被动语态"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Love is needed.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "10", section = "板块二：时态与语态体系", title = "非谓语动词 (Non-finite Verbs)", description = "不做谓语的动词。", syllabusDetails = listOf("不定式 (to do)", "动名词 (doing)", "分词 (doing/done)"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "To be or not.", quoteAuthor = "Shakespeare"),

        // 板块三：句法体系 (Syntax)
        KnowledgePoint(id = "16", section = "板块三：句法体系", title = "句子种类 (Sentence Types)", description = "功能分类。", syllabusDetails = listOf("陈述句", "疑问句 (一般/特殊/选择/反意)", "祈使句", "感叹句 (What/How)"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Ask why.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "18", section = "板块三：句法体系", title = "简单句基本句型 (Five Patterns)", description = "基本骨架。", syllabusDetails = listOf("主谓 (SV)", "主谓宾 (SVO)", "主系表 (SVP)", "主谓双宾 (SVOO)", "主谓宾宾补 (SVOC)"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Keep it simple.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "13", section = "板块三：句法体系", title = "宾语从句 (Object Clause)", description = "作宾语的句子。", syllabusDetails = listOf("引导词 (that/if/whether/wh-)", "陈述语序", "时态呼应规则"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "I think.", quoteAuthor = "Descartes"),
        KnowledgePoint(id = "15", section = "板块三：句法体系", title = "状语从句 (Adverbial Clause)", description = "修饰谓语的句子。", syllabusDetails = listOf("时间、条件 (主将从现)", "原因、结果 (so...that)", "目的、让步、比较"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "If not now.", quoteAuthor = "Unknown"),
        KnowledgePoint(id = "14", section = "板块三：句法体系", title = "定语从句 (Attributive Clause)", description = "修饰名词的句子。", syllabusDetails = listOf("关系代词 (who, whom, whose, which, that)", "关系副词 (where, when, why)"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Imagination.", quoteAuthor = "Ali"),
        KnowledgePoint(id = "19", section = "板块三：句法体系", title = "特殊句式 (Special Patterns)", description = "固定模式。", syllabusDetails = listOf("There be 句型", "It 的固定句型", "倒装句 (so/neither)", "主谓一致原则"), relatedPoints = listOf(), exampleProblems = listOf(), pastExamQuestions = listOf(), textbookParagraphs = listOf(), exampleSentences = listOf(), famousQuote = "Unity.", quoteAuthor = "Unknown")
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints.find { it.id == "7" } // Default to Present Perfect if search not found for demo
    }
}
