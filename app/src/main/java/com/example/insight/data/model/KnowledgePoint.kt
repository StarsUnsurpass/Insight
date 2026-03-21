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

data class KnowledgePoint(
    val id: String,
    val title: String,
    val description: String,
    val syllabusDetails: List<String>,
    val relatedPoints: List<RelatedPoint>,
    val exampleProblems: List<ExampleProblem>,
    val pastExamQuestions: List<PastExamQuestion>,
    val textbookParagraphs: List<TextbookParagraph>,
    val exampleSentences: List<ExampleSentence>,
    val famousQuote: String,
    val quoteAuthor: String
)

object KnowledgeProvider {
    val allPoints = listOf(
        KnowledgePoint(
            id = "0",
            title = "名词 (Nouns)",
            description = "名词是表示人、事物、地点或抽象概念的词。中考重点在于数的变化与所有格。",
            syllabusDetails = listOf(
                "可数名词与不可数名词判定。",
                "复数的不规则变化（child-children, sheep-sheep等）。",
                "名词所有格（'s 与 of）。",
                "名词作定语（shoe factory）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("冠词", "名词前常需冠词限定。", "名词的数决定了 a/an 的使用。"),
                RelatedPoint("主谓一致", "主语名词的数决定谓语形式。", "复数名词作主语，谓语用复数。")
            ),
            exampleProblems = listOf(
                ExampleProblem("There are some ______ on the table.", listOf("A. orange", "B. orange juice", "C. bottles of juice", "D. juices"), "C", "juice不可数，需用量词表达。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "北京", "There are many ______ in the kitchen.", listOf("A. tomatoes", "B. beef", "C. bread", "D. milk"), "A", "考查可数名词复数。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("In my school, there are many clubs.", listOf(HighlightedSentence("clubs", "名词复数形式。")), "——人教八上")
            ),
            exampleSentences = listOf(ExampleSentence("Information is important.", "信息很重要。")),
            famousQuote = "Knowledge is power.",
            quoteAuthor = "Bacon"
        ),
        KnowledgePoint(
            id = "1",
            title = "代词 (Pronouns)",
            description = "代词代替名词，避免重复。",
            syllabusDetails = listOf("人称代词主宾格。", "物主代词形名词性。", "反身代词用法。", "不定代词辨析（some/any等）。"),
            relatedPoints = listOf(RelatedPoint("名词", "代词指代名词。", "代词需与名词在性、数上一致。")),
            exampleProblems = listOf(ExampleProblem("Is this yours? — No, it's ______.", listOf("A. my", "B. mine", "C. me", "D. I"), "B", "名词性物主代词。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "天津", "She did it by ______.", listOf("A. she", "B. her", "C. herself", "D. hers"), "C", "反身代词。")),
            textbookParagraphs = listOf(TextbookParagraph("Everyone is having a good time.", listOf(HighlightedSentence("Everyone", "复合不定代词。")), "——人教七下")),
            exampleSentences = listOf(ExampleSentence("I can do it myself.", "我可以自己做。")),
            famousQuote = "Be yourself.",
            quoteAuthor = "Wilde"
        ),
        KnowledgePoint(
            id = "2",
            title = "冠词 (Articles)",
            description = "冠词置于名词前，说明指代对象。",
            syllabusDetails = listOf("a/an 区别（元音音素）。", "the 特指用法。", "零冠词（球类、三餐）。"),
            relatedPoints = listOf(RelatedPoint("名词", "冠词限定名词。", "不可数名词前通常不用 a/an。")),
            exampleProblems = listOf(ExampleProblem("He is ______ honest boy.", listOf("A. a", "B. an", "C. the", "D. /"), "B", "honest元音音素开头。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "广东", "It is ______ useful book.", listOf("A. a", "B. an", "C. the", "D. /"), "A", "useful辅音音素开头。")),
            textbookParagraphs = listOf(TextbookParagraph("The sun rises in the east.", listOf(HighlightedSentence("The sun", "独一无二。")), "——科普版")),
            exampleSentences = listOf(ExampleSentence("I play the piano.", "我弹钢琴。")),
            famousQuote = "A single step.",
            quoteAuthor = "Lao Tzu"
        ),
        KnowledgePoint(
            id = "3",
            title = "数词 (Numerals)",
            description = "表示数量或顺序的词。",
            syllabusDetails = listOf("基数词与序数词。", "分数表达。", "时间、日期表达。"),
            relatedPoints = listOf(RelatedPoint("名词", "数词修饰名词。", "具体数词不加 s。")),
            exampleProblems = listOf(ExampleProblem("My ______ birthday.", listOf("A. fortieth", "B. forty", "C. the forty", "D. the fortieth"), "A", "序数词。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "河南", "Three ______ students.", listOf("A. thousand", "B. thousands", "C. thousand of", "D. thousands of"), "A", "具体数字不加 s。")),
            textbookParagraphs = listOf(TextbookParagraph("Two thirds are girls.", listOf(HighlightedSentence("Two thirds", "分数表达。")), "——外研初三")),
            exampleSentences = listOf(ExampleSentence("I live on the 5th floor.", "我住五楼。")),
            famousQuote = "Counting the days.",
            quoteAuthor = "Ali"
        ),
        KnowledgePoint(
            id = "4",
            title = "形容词与副词 (Adj & Adv)",
            description = "修饰名词或动词。",
            syllabusDetails = listOf("比较级与最高级。", "as...as 结构。", "词性转换。"),
            relatedPoints = listOf(RelatedPoint("动词", "副词修饰动词。", "形容词修饰名词。")),
            exampleProblems = listOf(ExampleProblem("Warmer and ______.", listOf("A. warmer", "B. warm", "C. warmest", "D. more warm"), "A", "比较级叠加。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "武汉", "The more, the ______.", listOf("A. more", "B. much", "C. many", "D. most"), "A", "the + 比较级。")),
            textbookParagraphs = listOf(TextbookParagraph("Music is more interesting.", listOf(HighlightedSentence("more interesting", "比较级。")), "——人教七上")),
            exampleSentences = listOf(ExampleSentence("I am as tall as him.", "我跟他一样高。")),
            famousQuote = "Stay hungry.",
            quoteAuthor = "Jobs"
        ),
        KnowledgePoint(
            id = "5",
            title = "介词 (Prepositions)",
            description = "表示词与词之间的关系。",
            syllabusDetails = listOf("时间介词辨析。", "地点介词用法。", "固定搭配。"),
            relatedPoints = listOf(RelatedPoint("动词", "介词常与动词搭配。", "构成动词短语。")),
            exampleProblems = listOf(ExampleProblem("At ______ ten o'clock.", listOf("A. at", "B. in", "C. on", "D. for"), "A", "时刻。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "河北", "On ______ June 30th.", listOf("A. on", "B. at", "C. in", "D. for"), "A", "具体日期。")),
            textbookParagraphs = listOf(TextbookParagraph("We have breakfast at 7:30.", listOf(HighlightedSentence("at 7:30", "时间介词。")), "——人教七上")),
            exampleSentences = listOf(ExampleSentence("Between A and B.", "在 A 与 B 之间。")),
            famousQuote = "Under the sun.",
            quoteAuthor = "Solomon"
        ),
        KnowledgePoint(
            id = "6",
            title = "连词 (Conjunctions)",
            description = "连接词、短语或句子。",
            syllabusDetails = listOf("并列连词用法。", "从属连词用法。", "就近原则。"),
            relatedPoints = listOf(RelatedPoint("状语从句", "从属连词引导从句。", "逻辑关系的核心。")),
            exampleProblems = listOf(ExampleProblem("Though... ______.", listOf("A. /", "B. but", "C. so", "D. and"), "A", "虽然但不连用。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "重庆", "Work hard, ______ you will succeed.", listOf("A. and", "B. but", "C. or", "D. so"), "A", "祈使句 + and。")),
            textbookParagraphs = listOf(TextbookParagraph("Work hard, and you will succeed.", listOf(HighlightedSentence("and", "并列连词。")), "——科普版")),
            exampleSentences = listOf(ExampleSentence("Either you or I.", "要么是你，要么是我。")),
            famousQuote = "United we stand.",
            quoteAuthor = "Dickinson"
        ),
        KnowledgePoint(
            id = "7",
            title = "动词时态 (Tenses)",
            description = "动作发生的时间与状态。",
            syllabusDetails = listOf("六大基本时态。", "主将从现原则。", "完成时延续性。"),
            relatedPoints = listOf(RelatedPoint("被动语态", "语态依托于时态。", "be 动词决定时态。")),
            exampleProblems = listOf(ExampleProblem("I ______ yet.", listOf("A. haven't finished", "B. finished", "C. finish", "D. will finish"), "A", "完成时否定。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "广东", "She ______ dishes.", listOf("A. is washing", "B. washes", "C. washed", "D. was washing"), "A", "进行时。")),
            textbookParagraphs = listOf(TextbookParagraph("I was reading then.", listOf(HighlightedSentence("was reading", "过去进行时。")), "——人教九Unit4")),
            exampleSentences = listOf(ExampleSentence("He will come tomorrow.", "他明天来。")),
            famousQuote = "Time is money.",
            quoteAuthor = "Franklin"
        ),
        KnowledgePoint(
            id = "8",
            title = "被动语态 (Passive Voice)",
            description = "主语是承受者。",
            syllabusDetails = listOf("基本结构 be + done。", "时态变化。", "情态动词被动。"),
            relatedPoints = listOf(RelatedPoint("动词时态", "被动取决于 be 动词时态。", "时态掌握是基础。")),
            exampleProblems = listOf(ExampleProblem("Flowers ______ every day.", listOf("A. are watered", "B. water", "C. watered", "D. watering"), "A", "一般现在被动。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "陕西", "Culture ______ by people.", listOf("A. is loved", "B. loves", "C. loved", "D. was loved"), "A", "现在被动。")),
            textbookParagraphs = listOf(TextbookParagraph("Paper was invented.", listOf(HighlightedSentence("was invented", "过去被动。")), "——人教九")),
            exampleSentences = listOf(ExampleSentence("English is spoken.", "英语被使用。")),
            famousQuote = "Love is needed.",
            quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "9",
            title = "情态动词 (Modal Verbs)",
            description = "表达语气与情态。",
            syllabusDetails = listOf("can/must/may 用法。", "must 疑问句回答。", "推测用法。"),
            relatedPoints = listOf(RelatedPoint("被动语态", "情态动词可加被动。", "结构为 情+be+done。")),
            exampleProblems = listOf(ExampleProblem("Must I? — No, ______. ", listOf("A. needn't", "B. mustn't", "C. can't", "D. shouldn't"), "A", "否定回答。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "成都", "Must I? — No, ______.", listOf("A. needn't", "B. mustn't", "C. can't", "D. shouldn't"), "A", "否定回答。")),
            textbookParagraphs = listOf(TextbookParagraph("You should listen.", listOf(HighlightedSentence("should", "建议。")), "——人教七")),
            exampleSentences = listOf(ExampleSentence("I must go.", "我必须走。")),
            famousQuote = "You can do it.",
            quoteAuthor = "Self"
        ),
        KnowledgePoint(
            id = "10",
            title = "非谓语动词 (Non-finite Verbs)",
            description = "不作谓语的动词形式。",
            syllabusDetails = listOf("不定式用法。", "动名词用法。", "感官动词后 do/doing。"),
            relatedPoints = listOf(RelatedPoint("动词", "属于动词范畴。", "充当其他句子成分。")),
            exampleProblems = listOf(ExampleProblem("Remember ______ off.", listOf("A. to turn", "B. turning", "C. turn", "D. turned"), "A", "记得要做。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "长沙", "Enjoy ______.", listOf("A. watching", "B. watch", "C. to watch", "D. watched"), "A", "enjoy doing。")),
            textbookParagraphs = listOf(TextbookParagraph("I want to be an engineer.", listOf(HighlightedSentence("to be", "不定式。")), "——外研")),
            exampleSentences = listOf(ExampleSentence("Stop talking.", "停止说话。")),
            famousQuote = "To be or not to be.",
            quoteAuthor = "Shakespeare"
        ),
        KnowledgePoint(
            id = "11",
            title = "主谓一致 (S-V Agreement)",
            description = "主语与谓语一致。",
            syllabusDetails = listOf("语法一致。", "就近原则。", "意义一致。"),
            relatedPoints = listOf(RelatedPoint("名词", "主语多为名词。", "数决定谓语。")),
            exampleProblems = listOf(ExampleProblem("Neither nor ______.", listOf("A. is", "B. are", "C. am", "D. be"), "A", "就近原则。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "临沂", "Not only but also ______.", listOf("A. is", "B. are", "C. am", "D. were"), "A", "就近原则。")),
            textbookParagraphs = listOf(TextbookParagraph("Twenty years is long.", listOf(HighlightedSentence("is", "时间作单数。")), "——科普")),
            exampleSentences = listOf(ExampleSentence("There is a pen.", "那儿有一支笔。")),
            famousQuote = "Unity is strength.",
            quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "12",
            title = "简单句与并列句 (Simple & Compound)",
            description = "句子基本结构。",
            syllabusDetails = listOf("五大句型。", "祈使句。", "并列句。"),
            relatedPoints = listOf(RelatedPoint("连词", "并列句需连词。", "连接分句。")),
            exampleProblems = listOf(ExampleProblem("Hurry, ______ late.", listOf("A. or", "B. and", "C. but", "D. so"), "A", "否则。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "广东", "Hurry, ______ miss.", listOf("A. or", "B. and", "C. but", "D. so"), "A", "否则。")),
            textbookParagraphs = listOf(TextbookParagraph("Open your books.", listOf(HighlightedSentence("Open", "祈使句。")), "——人教七")),
            exampleSentences = listOf(ExampleSentence("I like apples.", "我喜欢苹果。")),
            famousQuote = "Simplicity is beauty.",
            quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "13",
            title = "宾语从句 (Object Clause)",
            description = "从句作宾语。",
            syllabusDetails = listOf("引导词选择。", "陈述语序。", "时态一致。"),
            relatedPoints = listOf(RelatedPoint("代词", "what/who 引导。", "充当成分。")),
            exampleProblems = listOf(ExampleProblem("Don't know ______.", listOf("A. where he is", "B. where is he", "C. he is where", "D. is he where"), "A", "陈述语序。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "天津", "Tell me ______.", listOf("A. where it is", "B. where is it", "C. how can I", "D. how I got"), "A", "陈述语序。")),
            textbookParagraphs = listOf(TextbookParagraph("I wonder if you can.", listOf(HighlightedSentence("if you can", "宾从。")), "——人教八下")),
            exampleSentences = listOf(ExampleSentence("I think he's right.", "我觉得他没错。")),
            famousQuote = "Think again.",
            quoteAuthor = "Descartes"
        ),
        KnowledgePoint(
            id = "14",
            title = "定语从句 (Attributive Clause)",
            description = "修饰名词的从句。",
            syllabusDetails = listOf("关系代词用法。", "关系副词用法。", "that vs which。"),
            relatedPoints = listOf(RelatedPoint("名词", "从句修饰名词。", "先行词是核心。")),
            exampleProblems = listOf(ExampleProblem("Book ______ I bought.", listOf("A. which", "B. who", "C. whom", "D. whose"), "A", "物。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "杭州", "Person ______ won.", listOf("A. who", "B. which", "C. whom", "D. whose"), "A", "人作主语。")),
            textbookParagraphs = listOf(TextbookParagraph("Wall which is wonder.", listOf(HighlightedSentence("which is", "定从。")), "——外研九")),
            exampleSentences = listOf(ExampleSentence("People who study.", "学习的人。")),
            famousQuote = "Imagination wings.",
            quoteAuthor = "Ali"
        ),
        KnowledgePoint(
            id = "15",
            title = "状语从句 (Adverbial Clause)",
            description = "修饰谓语的从句。",
            syllabusDetails = listOf("时间状语从句。", "条件状语从句。", "因果关系。"),
            relatedPoints = listOf(RelatedPoint("连词", "由于连词引导。", "确定逻辑。")),
            exampleProblems = listOf(ExampleProblem("If it ______.", listOf("A. rains", "B. will rain", "C. rain", "D. rained"), "A", "主将从现。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "广西", "If sunny, ______.", listOf("A. is", "B. will be", "C. was", "D. are"), "A", "主将从现。")),
            textbookParagraphs = listOf(TextbookParagraph("If you study, succeed.", listOf(HighlightedSentence("If you study", "条件状从。")), "——人教八")),
            exampleSentences = listOf(ExampleSentence("Because he was ill.", "因为他病了。")),
            famousQuote = "Never give up.",
            quoteAuthor = "Churchill"
        ),
        KnowledgePoint(
            id = "16",
            title = "疑问句与感叹句 (Questions & Exclamations)",
            description = "询问或表达情感。",
            syllabusDetails = listOf("一般/特殊疑问句。", "反义疑问句。", "感叹句结构。"),
            relatedPoints = listOf(RelatedPoint("代词", "特殊疑问词。", "who/what 等代词。")),
            exampleProblems = listOf(ExampleProblem("______ cold!", listOf("A. What", "B. How", "C. What a", "D. How a"), "A", "感叹句。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "内蒙古", "______ wonderful!", listOf("A. How", "B. What", "C. What a", "D. How a"), "A", "How 感叹句。")),
            textbookParagraphs = listOf(TextbookParagraph("What a great day!", listOf(HighlightedSentence("What a", "感叹。")), "——外研")),
            exampleSentences = listOf(ExampleSentence("Aren't you?", "对吧？")),
            famousQuote = "What a life.",
            quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "17",
            title = "直接引语与间接引语 (Direct & Indirect)",
            description = "转述他人的话。",
            syllabusDetails = listOf("人称变化。", "时态退后。", "状语变化。"),
            relatedPoints = listOf(RelatedPoint("宾语从句", "间引是宾从。", "时态一致是重点。")),
            exampleProblems = listOf(ExampleProblem("Said he ______ a teacher.", listOf("A. was", "B. is", "C. am", "D. were"), "A", "时态退后。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "海南", "Said sun ______.", listOf("A. rises", "B. rose", "C. rising", "D. was rising"), "A", "客观真理。")),
            textbookParagraphs = listOf(TextbookParagraph("He asked where.", listOf(HighlightedSentence("where", "间引。")), "——科普")),
            exampleSentences = listOf(ExampleSentence("She liked music.", "她说她喜欢。")),
            famousQuote = "Truth hurts.",
            quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "18",
            title = "句子成分与基本句型 (Sentence Structure)",
            description = "句子的组成部分。",
            syllabusDetails = listOf("六大成分。", "五大句型。", "宾补。"),
            relatedPoints = listOf(RelatedPoint("简单句", "句型的基础。", "掌握主谓宾。")),
            exampleProblems = listOf(ExampleProblem("Made us ______.", listOf("A. happy", "B. happily", "C. happiness", "D. to happy"), "A", "宾补。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "沈阳", "Tells us ______.", listOf("A. to work", "B. work", "C. working", "D. worked"), "A", "tell sb to do。")),
            textbookParagraphs = listOf(TextbookParagraph("I found city beautiful.", listOf(HighlightedSentence("beautiful", "宾补。")), "——人教八上")),
            exampleSentences = listOf(ExampleSentence("Mother looks young.", "妈妈年轻。")),
            famousQuote = "Beauty is truth.",
            quoteAuthor = "Keats"
        ),
        KnowledgePoint(
            id = "19",
            title = "It 句型与 There be 句型 (Special Patterns)",
            description = "英语特殊句型。",
            syllabusDetails = listOf("It 形式主语。", "There be 就近原则。", "It 表示时间。"),
            relatedPoints = listOf(RelatedPoint("主谓一致", "There be 的数。", "随第一个主语变化。")),
            exampleProblems = listOf(ExampleProblem("Kind ______ you.", listOf("A. of", "B. for", "C. with", "D. to"), "A", "性格特征。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "扬州", "There ______ match.", listOf("A. will be", "B. is", "C. have", "D. has"), "A", "将来时。")),
            textbookParagraphs = listOf(TextbookParagraph("It's a long way.", listOf(HighlightedSentence("It's", "It 指代距离。")), "——人教七上")),
            exampleSentences = listOf(ExampleSentence("There are birds.", "有鸟。")),
            famousQuote = "It is never late.",
            quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "20",
            title = "核心词汇辨析 (Vocabulary Distinctions)",
            description = "易混词区分。",
            syllabusDetails = listOf("花费四词。", "看字诀。", "说字诀。", "借字诀。"),
            relatedPoints = listOf(RelatedPoint("核心动词", "词汇是基础。", "语境决定词义。")),
            exampleProblems = listOf(ExampleProblem("Spent money ______.", listOf("A. on", "B. in", "C. at", "D. for"), "A", "固定搭配。")),
            pastExamQuestions = listOf(PastExamQuestion("2024", "随州", "Bike ______ 500.", listOf("A. cost", "B. spent", "C. paid", "D. took"), "A", "花费。")),
            textbookParagraphs = listOf(TextbookParagraph("Spent vacation.", listOf(HighlightedSentence("Spent", "人作主语。")), "——人教八上")),
            exampleSentences = listOf(ExampleSentence("Lend me pen.", "借笔给我。")),
            famousQuote = "Words matter.",
            quoteAuthor = "Unknown"
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints[0]
    }
}
