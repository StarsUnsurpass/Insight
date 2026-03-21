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
            description = "初中英语词汇体系的基石，主要考查名词的分类、数的变化以及所有格形式。\n\n" +
                          "核心考点一：不可数名词（如 news, advice, information, weather）没有复数形式，不能直接与 a/an 或具体数字连用。\n" +
                          "核心考点二：名词复数的不规则变化（如 man-men, child-children, foot-teeth, sheep-sheep, deer-deer）。\n" +
                          "核心考点三：名词所有格，表示“某人的”，主要有 's 所有格和 of 所有格两种形式。",
            syllabusDetails = listOf(
                "可数与不可数名词区分", 
                "名词复数规则变化与不规则变化", 
                "名词所有格（'s 与 of 结构）"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词与冠词搭配", "可数名词单数前通常必须有冠词限定。", "考查名词时经常连带考查不定冠词 a/an 的使用。"),
                RelatedPoint("主谓一致", "主语名词的单复数直接决定谓语动词的形式。", "不可数名词作主语，谓语动词用单数。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "北京中考",
                    "Can you give me some ______ on how to learn English well?",
                    listOf("A. advices", "B. advice", "C. an advice", "D. piece of advice"),
                    "B",
                    "【答案】B\n【解析】advice 是不可数名词，不能加 s，也不能直接用 an 修饰。some advice 意为“一些建议”。",
                    errorProne = "常将 advice 误认为可数名词。注意汉语中说“一条建议”，英语中要用 a piece of advice。",
                    translation = "你能给我一些关于如何学好英语的建议吗？"
                ),
                PastExamQuestion(
                    "2022", "广东中考",
                    "Today is ______ Day. Let's say \"Thank you\" to our teachers.",
                    listOf("A. Teacher's", "B. Teachers", "C. Teachers'", "D. Teacher"),
                    "C",
                    "【答案】C\n【解析】考查名词所有格。教师节是全体教师的节日，先变复数 teachers，再加 '，即 Teachers' Day。",
                    errorProne = "极易错选 A，忽略了教师节的群体性（不止一个老师）。",
                    translation = "今天是教师节。让我们对老师们说声“谢谢”。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "There is some good news for you. The weather will be fine this weekend.",
                    listOf(
                        HighlightedSentence("There is some good news for you.", "news 是不可数名词，谓语动词用 is。")
                    ),
                    "—— 出处同步：常见课本语境"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "These children are brushing their teeth.",
                    "这些孩子们正在刷牙。",
                    analysis = "child 的复数是 children，tooth 的复数是 teeth，都是不规则变化。",
                    difficulty = "基础必会"
                ),
                ExampleSentence(
                    "It's about ten minutes' walk from my home to school.",
                    "从我家到学校大约十分钟的步行路程。",
                    analysis = "时间、距离等名词也可以用 's 所有格。ten minutes 以 s 结尾，直接加 '。",
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 将 news, money, fun 等不可数名词误用作复数。\n2. 拼写错误，如把 potatoes 漏掉 e。"),
                TeachingNote("辅导建议", "总结常考不可数名词，用口诀记忆；强调做题时要“先看可数不可数，再看单数和复数”。")
            ),
            famousQuote = "Name is the blueprint of the thing.", quoteAuthor = "Philosopher"
        ),
        KnowledgePoint(
            id = "pronouns", section = "板块一：词法体系 (Morphology)", title = "代词 (Pronouns)",
            description = "代替名词或起名词作用的词类，考点细致且繁杂。\n\n" +
                          "核心考点一：人称代词的主格和宾格（动词和介词后用宾格）。\n" +
                          "核心考点二：形容词性物主代词 vs 名词性物主代词（名词性 = 形容词性 + 名词）。\n" +
                          "核心考点三：不定代词辨析（如 something/anything/nothing，以及 other/another/the other 等）。\n" +
                          "核心考点四：反身代词及其固定搭配（如 by oneself, enjoy oneself）。",
            syllabusDetails = listOf(
                "人称代词（主/宾格）", 
                "物主代词（形容词性/名词性）", 
                "反身代词", 
                "指示代词", 
                "疑问代词", 
                "不定代词（some/any/no 等复合代词极其重要）"
            ),
            relatedPoints = listOf(
                RelatedPoint("代词与名词的指代一致", "代词在使用时，其单复数、性别必须与所指代的名词保持一致。", "完形填空中常见的逻辑线索。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "江苏中考",
                    "—Is this your jacket, Tom?\n—No, ______ is in my schoolbag.",
                    listOf("A. my", "B. mine", "C. me", "D. I"),
                    "B",
                    "【答案】B\n【解析】考查名词性物主代词。此处指代“我的夹克衫 (my jacket)”，作主语，应使用名词性物主代词 mine。",
                    errorProne = "错选 A。my 是形容词性物主代词，后面必须接名词，不能单独使用。",
                    translation = "——汤姆，这是你的夹克衫吗？\n——不，我（的夹克衫）在书包里。"
                ),
                PastExamQuestion(
                    "2022", "浙江中考",
                    "The box is too heavy. I can't carry it by ______.",
                    listOf("A. me", "B. my", "C. mine", "D. myself"),
                    "D",
                    "【答案】D\n【解析】考查反身代词。by oneself 是固定搭配，意为“某人自己/独自”。",
                    errorProne = "基础薄弱的学生可能不熟悉固定搭配，误选 A。",
                    translation = "这个箱子太重了。我无法自己搬动它。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "If you want to know more about the city, you can search for some information on the Internet by yourself.",
                    listOf(
                        HighlightedSentence("by yourself", "反身代词用于强调“亲自、独自”。")
                    ),
                    "—— 出处同步：人教版八年级教材"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "There is something wrong with my bike.",
                    "我的自行车出毛病了。",
                    analysis = "形容词修饰复合不定代词（如 something）时，形容词必须后置。",
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "Some students are cleaning the classroom, and others are sweeping the floor.",
                    "一些学生在打扫教室，另一些在扫地。",
                    analysis = "some ... others ... 搭配表示“一些……，另一些……”。",
                    difficulty = "拔高难点"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 混淆形容词性物主代词和名词性物主代词。\n2. 复合不定代词定语后置容易遗忘，写成 wrong something。"),
                TeachingNote("辅导建议", "编制顺口溜：“有名则形，无名则名”（后面有名词用形容词性，没名词用名词性）；强调复合代词作主语看作单数。")
            ),
            famousQuote = "Substitute not your own power.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "articles", section = "板块一：词法体系 (Morphology)", title = "冠词 (Articles)",
            description = "置于名词之前，说明名词所指的人或事物。\n\n" +
                          "核心考点一：不定冠词 a/an 的区别。a 用于辅音音素开头的词，an 用于元音音素开头的词。\n" +
                          "核心考点二：定冠词 the 的特指用法、世上独一无二的事物前、乐器前等。\n" +
                          "核心考点三：零冠词，如球类运动、三餐、学科前不加冠词。",
            syllabusDetails = listOf("定冠词 (the)", "不定冠词 (a/an)", "零冠词的固定搭配"),
            relatedPoints = listOf(
                RelatedPoint("冠词与发音", "a/an 的选择不仅看拼写，更要看音标（发音）。", "例如 an hour, a university。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "四川中考",
                    "My father is ______ honest man. He is a doctor.",
                    listOf("A. a", "B. an", "C. the", "D. /"),
                    "B",
                    "【答案】B\n【解析】honest 以不发音的 h 开头，第一个音素是元音 /ɒ/，所以用 an。",
                    errorProne = "极易看到 h 就认为是辅音字母而选 A，忽略了 a/an 取决于发音而非字母。",
                    translation = "我父亲是一个诚实的人。他是一名医生。"
                ),
                PastExamQuestion(
                    "2021", "武汉中考",
                    "Let's play ______ basketball after school.",
                    listOf("A. a", "B. an", "C. the", "D. /"),
                    "D",
                    "【答案】D\n【解析】考查零冠词。play 与球类名词连用时，中间不加任何冠词。",
                    errorProne = "混淆 play the piano（乐器加 the）和 play basketball（球类不加）。",
                    translation = "放学后我们打篮球吧。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "The sun is shining brightly in the sky.",
                    listOf(
                        HighlightedSentence("The sun", "sun 是世界上独一无二的事物，前面必须加定冠词 the。")
                    ),
                    "—— 出处同步：七年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "He plays the piano very well, but he doesn't like playing football.",
                    "他钢琴弹得很好，但他不喜欢踢足球。",
                    analysis = "鲜明对比：乐器前加 the，球类前零冠词。",
                    difficulty = "基础必会"
                ),
                ExampleSentence(
                    "This is the best book that I have ever read.",
                    "这是我读过的最好的书。",
                    analysis = "形容词最高级前必须加定冠词 the。",
                    difficulty = "基础必会"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 错误判断元音/辅音音素，如 a uniform, an hour。\n2. 记忆固定搭配时混淆，如 in hospital（住院）和 in the hospital（在医院里）。"),
                TeachingNote("辅导建议", "强调“音素”而非“字母”；把乐器和球类做对比记忆。")
            ),
            famousQuote = "A single step begins the journey.", quoteAuthor = "Lao Tzu"
        ),
        KnowledgePoint(
            id = "numerals", section = "板块一：词法体系 (Morphology)", title = "数词 (Numerals)",
            description = "表示数目多少或顺序先后的词。\n\n" +
                          "核心考点一：基数词与序数词的转换（尤其是不规则变化，如 one-first, two-second, twelve-twelfth, twenty-twentieth）。\n" +
                          "核心考点二：hundred/thousand/million 的用法。具体数字后不加s，泛指（如 hundreds of）加s和of。\n" +
                          "核心考点三：分数的表达（分子基数词，分母序数词；分子大于一，分母加 -s）。",
            syllabusDetails = listOf("基数词", "序数词", "分数表达", "时间/日期/年代表达法"),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "分数或百分数作主语时，谓语动词看后面的名词单复数。", "Two thirds of the water is polluted.")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "山东中考",
                    "About ______ of the students in our class like playing chess.",
                    listOf("A. two third", "B. two thirds", "C. second three", "D. second thirds"),
                    "B",
                    "【答案】B\n【解析】考查分数。分子用基数词(two)，分母用序数词(third)；分子大于1，分母加 s(thirds)。",
                    errorProne = "未记住分数表达规则，忘记给分母加 s。",
                    translation = "我们班大约三分之二的学生喜欢下国际象棋。"
                ),
                PastExamQuestion(
                    "2022", "湖南中考",
                    "Every year, ______ visitors come to visit the Great Wall.",
                    listOf("A. million", "B. millions of", "C. two millions", "D. two millions of"),
                    "B",
                    "【答案】B\n【解析】考查数量级词的模糊表示。没有具体数字时，表示“数以百万计的”，用 millions of。",
                    errorProne = "混淆具体数字与模糊数字的规则，如写成 two millions。",
                    translation = "每年，数以百万计的游客来参观长城。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "In the twentieth century, many great inventions changed the world.",
                    listOf(
                        HighlightedSentence("In the twentieth century", "世纪的表达：in the + 序数词 + century。")
                    ),
                    "—— 出处同步：九年级教材"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "He is an eight-year-old boy.",
                    "他是一个八岁的男孩。",
                    analysis = "复合形容词“数词-名词”作定语时，名词只能用单数（year）。",
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "We have learned about three thousand English words so far.",
                    "到目前为止，我们已经学了大约三千个英语单词。",
                    analysis = "thousand 前面有具体数字 three，不能加 -s。",
                    difficulty = "基础必会"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 序数词拼写错误，如 nineth(错) -> ninth(对)，twelveth(错) -> twelfth(对)。\n2. 分数表达时分母忘记加 -s。"),
                TeachingNote("辅导建议", "总结序数词变化口诀：“基变序，有规律，词尾加上-th。一二三，特殊记，八去t，九除e，ve要用f替，以y结尾变ie，然后再加-th。”")
            ),
            famousQuote = "Numbers rule the universe.", quoteAuthor = "Pythagoras"
        ),
        KnowledgePoint(
            id = "adj_adv", section = "板块一：词法体系 (Morphology)", title = "形容词与副词 (Adjectives & Adverbs)",
            description = "修饰名词、动词、形容词或全句的词，重点在比较级和词义辨析。\n\n" +
                          "核心考点一：形容词修饰名词（作定语）或放在系动词后（作表语）；副词修饰动词、形容词或其他副词。\n" +
                          "核心考点二：原级比较：as + 形容词/副词原级 + as，表示“和……一样”。\n" +
                          "核心考点三：比较级标志词：than, much, even, a little, a lot。\n" +
                          "核心考点四：最高级标志词：in/of 短语，one of the + 最高级 + 名词复数。\n" +
                          "核心考点五：特殊句型：The + 比较级..., the + 比较级...（越……，就越……）。",
            syllabusDetails = listOf(
                "原级用法 (as...as)", 
                "比较级与最高级规则与不规则变化", 
                "常见修饰语 (much, a little, even)", 
                "易混淆形副词辨析"
            ),
            relatedPoints = listOf(
                RelatedPoint("系动词与形容词", "感官动词（look, sound, taste, smell, feel）后面必须接形容词作表语，不能用副词。", "极易错考点，例如 sound beautifully(错) -> sound beautiful(对)。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "天津中考",
                    "The harder you work, the ______ you will be.",
                    listOf("A. lucky", "B. luckier", "C. luckiest", "D. luckily"),
                    "B",
                    "【答案】B\n【解析】考查“The + 比较级，the + 比较级”句型，意为“越……，就越……”。因此后半句也需要用比较级 luckier。",
                    errorProne = "忘记该固定句型，误选 A 或 C。",
                    translation = "你越努力，就会越幸运。"
                ),
                PastExamQuestion(
                    "2022", "安徽中考",
                    "The young man plays the guitar as ______ as his teacher.",
                    listOf("A. good", "B. well", "C. better", "D. best"),
                    "B",
                    "【答案】B\n【解析】考查 as...as 句型及形副词区分。as...as 中间用原级，排除 C 和 D。修饰动词 plays 要用副词 well，不用形容词 good。",
                    errorProne = "极易错选 A，只知道 as...as 中间加原级，却忽略了修饰动词必须用副词。",
                    translation = "这个年轻人吉他弹得和他的老师一样好。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Shanghai is one of the biggest cities in the world.",
                    listOf(
                        HighlightedSentence("one of the biggest cities", "one of the + 形容词最高级 + 可数名词复数，意为“最……的……之一”。")
                    ),
                    "—— 出处同步：八年级上册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "This math problem is much easier than that one.",
                    "这道数学题比那道容易得多。",
                    analysis = "much 可以修饰比较级，表示程度加深。",
                    difficulty = "基础必会"
                ),
                ExampleSentence(
                    "The food tastes delicious.",
                    "这食物尝起来很美味。",
                    analysis = "taste 是连系动词，后面跟形容词作表语。",
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 形容词和副词混淆，如 He runs very quick (错) -> quickly (对)。\n2. 比较级修饰词用错，如用 very 修饰比较级（very better 是错的，应为 much better）。"),
                TeachingNote("辅导建议", "强调“修饰名词找形容，修饰动作找副词”；牢记比较级的“黄金修饰词”：much, a little, even, still, far。")
            ),
            famousQuote = "Description is the key to clarity.", quoteAuthor = "Writer"
        ),
        KnowledgePoint(
            id = "prepositions", section = "板块一：词法体系 (Morphology)", title = "介词 (Prepositions)",
            description = "表示名词、代词等与句中其他词的关系。\n\n" +
                          "核心考点一：时间介词的区分。in 加年/月/季节/泛指的上下午；on 加具体某一天/星期/具体某天的上下午；at 加具体时刻/节假日。\n" +
                          "核心考点二：方位介词。如 in (在内部), on (在表面), under (在正下方), above (在正上方), between (在两者之间), among (在三者或以上之间)。\n" +
                          "核心考点三：方式介词。by + 交通工具/doing；with + 具体工具/身体部位；in + 语言/颜色/材料。\n" +
                          "核心考点四：常见固定搭配，如 be interested in, be good at, depend on。",
            syllabusDetails = listOf("时间介词 (in/on/at)", "方位/空间介词", "方式介词 (by/with/in)", "固定介词搭配"),
            relatedPoints = listOf(
                RelatedPoint("介词与动名词", "介词后面如果接动词，必须变成动名词（V-ing）形式。", "例如 be good at playing basketball。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "陕西中考",
                    "We will have a school trip ______ the morning of May 15th.",
                    listOf("A. in", "B. on", "C. at", "D. for"),
                    "B",
                    "【答案】B\n【解析】考查时间介词。表示在具体某一天的上午、下午或晚上，介词必须用 on。May 15th 限制了这是具体某一天。",
                    errorProne = "极易错选 A。很多学生看到 the morning 就条件反射用 in，忽略了后面的修饰语。",
                    translation = "我们将在5月15日上午进行一次学校旅行。"
                ),
                PastExamQuestion(
                    "2022", "河北中考",
                    "Can you write the word ______ English?",
                    listOf("A. in", "B. with", "C. by", "D. at"),
                    "A",
                    "【答案】A\n【解析】考查方式介词。用某种语言或墨水/颜色，介词常用 in。in English 意为“用英语”。",
                    errorProne = "受汉语“用”的影响，误选 with 或 by。",
                    translation = "你能用英语写这个单词吗？"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "My mother goes to work by bus every day, but sometimes she walks.",
                    listOf(
                        HighlightedSentence("by bus", "by + 交通工具单数名词（中间不加任何冠词）表示出行方式。")
                    ),
                    "—— 出处同步：七年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "He is standing between the two trees.",
                    "他站在两棵树之间。",
                    analysis = "between 用于两者之间，常与 and 搭配；among 用于三者或以上。",
                    difficulty = "基础必会"
                ),
                ExampleSentence(
                    "Thank you for helping me with my math.",
                    "谢谢你帮我学数学。",
                    analysis = "介词 for 后面接 V-ing (helping)；help sb. with sth. 也是固定介词搭配。",
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 时间介词 in/on/at 的混淆，特别是在加上修饰语后。\n2. with/by/in 表达“用……”时的错用。"),
                TeachingNote("辅导建议", "利用时间轴或金字塔图形（at 顶点最小，on 中间，in 底部最大）来帮助记忆时间介词。")
            ),
            famousQuote = "Positioning is everything.", quoteAuthor = "Strategist"
        ),
        KnowledgePoint(
            id = "conjunctions", section = "板块一：词法体系 (Morphology)", title = "连词 (Conjunctions)",
            description = "用来连接词与词、短语与短语或句与句的词。\n\n" +
                          "核心考点一：并列连词（and, but, or, so）。其中 or 在祈使句中有“否则”的意思。\n" +
                          "核心考点二：成对连词（both...and, either...or, neither...nor, not only...but also）。注意主谓一致的“就近原则”。\n" +
                          "核心考点三：从属连词引导状语从句（because, although, if, unless, until）。\n" +
                          "核心考点四：英语逻辑的排他性：because 和 so 不能同句使用；although/though 和 but 不能同句使用。",
            syllabusDetails = listOf("并列连词 (and, but, or, so)", "从属连词 (when, if, because, although)"),
            relatedPoints = listOf(
                RelatedPoint("连词与句子结构", "连词是英语长难句的骨架，决定了句子的主从关系。", "完形填空中，连词是解题的重要逻辑标志。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "辽宁中考",
                    "Hurry up, ______ you will miss the early bus.",
                    listOf("A. and", "B. or", "C. so", "D. but"),
                    "B",
                    "【答案】B\n【解析】考查并列连词。“祈使句 + or + 陈述句”是一个固定句型，or 意为“否则”。句意：快点，否则你就会错过早班车。",
                    errorProne = "不知道 or 有“否则”的意思，从而误选其它选项。",
                    translation = "快点，否则你会错过早班车。"
                ),
                PastExamQuestion(
                    "2022", "福建中考",
                    "______ he was very tired, he kept on working.",
                    listOf("A. Because", "B. If", "C. Although", "D. So"),
                    "C",
                    "【答案】C\n【解析】考查从属连词。句意“虽然他很累，但他继续工作”。表示让步转折关系，使用 Although。",
                    errorProne = "学生可能受中文习惯影响，在填了 Although 之后，还想在下半句加上 but（英语中绝对禁止）。",
                    translation = "虽然他很累，但他还是坚持工作。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Not only the students but also the teacher is enjoying the movie.",
                    listOf(
                        HighlightedSentence("but also the teacher is", "not only... but also... 连接主语时，谓语动词遵循“就近原则”，与 the teacher 保持一致，用 is。")
                    ),
                    "—— 出处同步：九年级教材"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "Both my father and my mother are doctors.",
                    "我的父亲和母亲都是医生。",
                    analysis = "both...and... 连接主语时，谓语动词永远用复数。",
                    difficulty = "基础必会"
                ),
                ExampleSentence(
                    "I didn't go to school yesterday because it rained heavily.",
                    "我昨天没去上学，因为雨下得很大。",
                    analysis = "because 引导原因状语从句，切记不可在主句前再加 so。",
                    difficulty = "基础必会"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 中式英语思维，将 although 和 but，或者 because 和 so 连用。\n2. 就近原则掌握不牢，neither...nor... 连接主语时选错谓语动词单复数。"),
                TeachingNote("辅导建议", "强调“一山不容二虎”（because/so, although/but 只能留一个）；将就近原则的连词编成口诀记忆。")
            ),
            famousQuote = "Connect the dots.", quoteAuthor = "Thinker"
        ),
        KnowledgePoint(
            id = "verbs_basic", section = "板块一：词法体系 (Morphology)", title = "动词基础 (Verbs)",
            description = "英语句子的核心，涵盖四大类基本动词及其基础用法。\n\n" +
                          "核心考点一：实义动词。能独立作谓语，根据是否需要宾语分为及物动词(vt.)和不及物动词(vi.)。\n" +
                          "核心考点二：连系动词。不能独立作谓语，必须接表语（通常为形容词）。常见如 be, get, turn, look, smell, taste 等。\n" +
                          "核心考点三：助动词（do, does, did, have, has, will 等）。本身无词义，协助构成疑问句、否定句或各种时态。\n" +
                          "核心考点四：情态动词（can, may, must, should 等）。本身有词义，表示语气或推测，其后必须加动词原形。",
            syllabusDetails = listOf(
                "实义动词", 
                "连系动词 (be, look, sound, get)", 
                "助动词 (do/have/will)", 
                "情态动词 (can, must, should, may 及其表推测的用法)", 
                "常见短语动词 (Phrasal Verbs)"
            ),
            relatedPoints = listOf(
                RelatedPoint("情态动词与时态", "含有情态动词的句子变否定或疑问时，直接操作情态动词，无需借助助动词。", "例如 Can you...? / You shouldn't...")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "武汉中考",
                    "—Listen! Is that Kate playing the piano in the room?\n—No. It ______ be Kate. She has gone to Beijing.",
                    listOf("A. may not", "B. needn't", "C. can't", "D. shouldn't"),
                    "C",
                    "【答案】C\n【解析】考查情态动词表推测。因为她去了北京，所以“不可能是她”。否定推测且语气极其肯定，必须用 can't（不可能）。",
                    errorProne = "混淆推测用法：肯定的必然推测用 must，否定的必然推测用 can't，而不是 mustn't（mustn't 意为“禁止”）。",
                    translation = "——听！是凯特在房间里弹钢琴吗？\n——不。不可能是凯特。她去北京了。"
                ),
                PastExamQuestion(
                    "2022", "重庆中考",
                    "The story ______ true, but I'm not completely sure.",
                    listOf("A. must be", "B. might be", "C. can't be", "D. should be"),
                    "B",
                    "【答案】B\n【解析】考查情态动词表推测。后半句说“我不完全确定”，说明推测语气较弱，用 might be（可能是）。",
                    errorProne = "未根据语境分辨出推测的确定程度。",
                    translation = "这个故事可能是真的，但我不完全确定。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "You must not play with fire in the forest. It's too dangerous.",
                    listOf(
                        HighlightedSentence("must not", "mustn't 表示“禁止，千万不要”，常用于规则和警告。")
                    ),
                    "—— 出处同步：八年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "Leaves turn yellow in autumn.",
                    "秋天树叶变黄。",
                    analysis = "turn 在此为连系动词，表示状态的改变，后接形容词 yellow。",
                    difficulty = "基础必会"
                ),
                ExampleSentence(
                    "I don't know the word, so I will look it up in the dictionary.",
                    "我不认识这个词，所以我要在字典里查一下。",
                    analysis = "look up 是动副短语，代词宾语（it）必须放在中间。",
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 情态动词表推测的否定搞错，用 mustn't 代替 can't。\n2. 实义动词和系动词混淆，感官动词后加了副词。\n3. 动词短语中代词位置放错，写成 look up it。"),
                TeachingNote("辅导建议", "总结情态动词推测用法矩阵（100%确定：must / can't；不确定：may/might）；总结“动词+副词”短语中代词放中间的规则。")
            ),
            famousQuote = "Action speaks louder than words.", quoteAuthor = "Proverb"
        ),

        // ================= 板块二：时态与语态体系 (Tenses & Voices) =================
        KnowledgePoint(
            id = "simple_present", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "一般现在时 (Simple Present)",
            description = "表示经常性动作、客观真理或目前的普遍状态。",
            syllabusDetails = listOf("主语为第三人称单数时的动词变化", "客观真理、格言的固定时态表达", "时刻表或既定日程的将来意义用法"),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "一般现在时中，若主语为第三人称单数，动词需随之变化。", "考查动词形式时，主语人称和数是首要判断标准。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "北京中考",
                    "My grandfather ______ newspapers after dinner every day.",
                    listOf("A. reads", "B. read", "C. is reading", "D. will read"),
                    "A",
                    "【答案】A\n【解析】标志词 every day 表示习惯性动作，主语是第三人称单数，动词需用 reads。",
                    errorProne = "易忽略第三人称单数主语，误选原形 read。",
                    translation = "我爷爷每天晚饭后读报纸。"
                ),
                PastExamQuestion(
                    "2022", "广东中考",
                    "Light ______ faster than sound. That's why we see lightning before hearing thunder.",
                    listOf("A. travel", "B. travels", "C. travelled", "D. travelling"),
                    "B",
                    "【答案】B\n【解析】光速快于声速属于客观真理，不受时间限制，永远使用一般现在时，Light 不可数，动词加 -s。",
                    errorProne = "如果语境带有过去时间，可能误选过去时，但客观事实恒用现在时。",
                    translation = "光比声音传播得快。这就是为什么我们先看到闪电后听到雷声。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Water boils at 100 degrees Celsius. It is an important fact in science.",
                    highlightedSentences = listOf(
                        HighlightedSentence("Water boils at 100 degrees Celsius.", "客观事实的表达，主语 water 不可数，动词用单三形式 boils。")
                    ),
                    source = "人教版九年级 Unit 6"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("The train leaves at 8:00 tomorrow morning.", "火车明早八点开。", "表示既定日程，用一般现在时表将来。"),
                ExampleSentence("He always goes to school on foot.", "他总是步行上学。", "always 提示经常性动作。")
            ),
            teachingNotes = listOf(
                TeachingNote("动词三单变形", "口诀：一般加 s；s/x/sh/ch 结尾加 es；辅音加 y 变 i 加 es；have 变 has。"),
                TeachingNote("易错提示", "条件状语从句（if）和时间状语从句（when/as soon as）中，遵循“主将从现”原则，从句使用一般现在时。")
            ),
            famousQuote = "Live in the present.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "simple_past", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "一般过去时 (Simple Past)",
            description = "表示过去某个时间发生的动作或存在的状态。",
            syllabusDetails = listOf("动词过去式的规则与不规则变化", "带有特定过去时间状语的句子", "used to do 结构的用法"),
            relatedPoints = listOf(
                RelatedPoint("不规则动词表", "必须熟记常见动词的过去式和过去分词。", "一般过去时的核心就是动词变为过去式，不规则变化是重中之重。"),
                RelatedPoint("一般过去时与现在完成时", "区分明确的过去时间点与对现在造成的影响。", "中考常把这两种时态放在一起对比考查。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "上海中考",
                    "My parents ______ me to the zoo last Sunday.",
                    listOf("A. take", "B. took", "C. takes", "D. are taking"),
                    "B",
                    "【答案】B\n【解析】标志词 last Sunday 表示过去的时间，谓语动词需用一般过去时。take 的过去式是不规则变化 took。",
                    errorProne = "未记住 take 的过去式是不规则的，可能凭空捏造 taked。",
                    translation = "上周日我父母带我去了动物园。"
                ),
                PastExamQuestion(
                    "2022", "杭州中考",
                    "— ______ you ______ the football match yesterday?\n— Yes, I did. It was great.",
                    listOf("A. Do; watch", "B. Did; watch", "C. Did; watched", "D. Are; watching"),
                    "B",
                    "【答案】B\n【解析】yesterday 提示一般过去时，疑问句需借助于助动词 did，且 did 后面的实义动词必须还原为原形 watch。",
                    errorProne = "使用了 did 后，后面的动词忘记还原，错选 C。",
                    translation = "——你昨天看足球比赛了吗？\n——看了。非常棒。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "When I was a little boy, I used to play in the park with my friends. We had a lot of fun.",
                    highlightedSentences = listOf(
                        HighlightedSentence("I used to play", "used to do 表示“过去常常做某事”，暗含现在已经不这么做了。"),
                        HighlightedSentence("We had a lot of fun.", "had 是 have 的过去式，描述过去的状态。")
                    ),
                    source = "人教版九年级 Unit 4"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("He bought a new bike three days ago.", "他三天前买了一辆新自行车。", "three days ago 是一般过去时的典型标志词。", "基础必会"),
                ExampleSentence("I didn't know the answer at that time.", "那时我不知道答案。", "at that time 提示过去，否定句借助于 didn't + 原形。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("常见时间状语", "归纳常考标志词：yesterday, last... (last night), ...ago, in 1990, just now, at that time。"),
                TeachingNote("动词还原原则", "强调“助动词(did/didn't)犹如照妖镜，后面的动词全现原形”。")
            ),
            famousQuote = "The past is never dead.", quoteAuthor = "Faulkner"
        ),
        KnowledgePoint(
            id = "simple_future", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "一般将来时 (Simple Future)",
            description = "表示将来某个时间要发生的动作或状态。",
            syllabusDetails = listOf("will / be going to 的区别与用法", "条件/时间状语从句中的主将从现原则"),
            relatedPoints = listOf(
                RelatedPoint("主将从现", "在 if/when/as soon as 引导的从句中，主句用将来时，从句用一般现在时。", "中考必考的高频考点。"),
                RelatedPoint("will vs be going to", "will 多用于临时决定或客观预测；be going to 多用于事先计划或有迹象表明。", "完形填空中常考语境辨析。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "深圳中考",
                    "I will tell him the good news as soon as he ______ back.",
                    listOf("A. comes", "B. will come", "C. came", "D. is coming"),
                    "A",
                    "【答案】A\n【解析】考查“主将从现”。as soon as 引导时间状语从句，主句用了一般将来时(will tell)，从句需用一般现在时，主语he是单三，所以用 comes。",
                    errorProne = "极易受汉语思维影响，认为“他还没回来”，所以在从句里也用将来时 will come。",
                    translation = "他一回来我就会把这个好消息告诉他。"
                ),
                PastExamQuestion(
                    "2022", "成都中考",
                    "Look at the dark clouds! It ______ rain.",
                    listOf("A. is going to", "B. will", "C. is raining", "D. rained"),
                    "A",
                    "【答案】A\n【解析】黑云密布(dark clouds)是有迹象表明即将发生的事，这种情况一般用 be going to。",
                    errorProne = "未区分 will 和 be going to 的语境差异，随便选 B。",
                    translation = "看那些乌云！天要下雨了。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "If it doesn't rain tomorrow, we will go for a picnic.",
                    highlightedSentences = listOf(
                        HighlightedSentence("If it doesn't rain", "if引导条件状语从句，用一般现在时表将来。"),
                        HighlightedSentence("we will go", "主句使用一般将来时。")
                    ),
                    source = "人教版八年级上册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I am going to study abroad next year.", "我打算明年出国留学。", "事先的计划用 be going to。", "基础必会"),
                ExampleSentence("— The phone is ringing.\n— I will answer it.", "——电话在响。\n——我去接。", "临时做出的决定用 will。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("标志词记忆", "常见标志词：tomorrow, next year/week, in the future, in + 时间段（如 in two days）。"),
                TeachingNote("特殊用法提醒", "There be 句型的将来时是 There will be 或 There is/are going to be，绝对不能说 There will have。")
            ),
            famousQuote = "The future belongs to those who prepare for it.", quoteAuthor = "Malcolm X"
        ),
        KnowledgePoint(
            id = "present_continuous", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "现在进行时 (Present Continuous)",
            description = "表示现在（说话瞬间）正在进行或发生的动作。",
            syllabusDetails = listOf("be + doing 结构", "不用于进行时的状态动词", "表示按计划或安排即将发生的将来动作"),
            relatedPoints = listOf(
                RelatedPoint("动词的 -ing 变化规则", "重读闭音节双写尾字母加ing是常考易错点。", "如 swim-swimming, run-running, stop-stopping。"),
                RelatedPoint("现在进行时表将来", "表示位置移动的动词（如 go, come, leave, arrive）常用现在进行时表将来。", "例如 He is leaving for Beijing tomorrow。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "武汉中考",
                    "— Where is your brother?\n— He ______ basketball on the playground.",
                    listOf("A. plays", "B. played", "C. is playing", "D. has played"),
                    "C",
                    "【答案】C\n【解析】通过问句“Where is...”可知动作正在发生，答语需用现在进行时 (is/am/are + doing)。",
                    errorProne = "无明显标志词 look/listen 等，只通过问答语境判断时态，容易错选 A。",
                    translation = "——你哥哥在哪？\n——他正在操场上打篮球。"
                ),
                PastExamQuestion(
                    "2022", "济南中考",
                    "Listen! Someone ______ the violin in the next room.",
                    listOf("A. plays", "B. is playing", "C. played", "D. will play"),
                    "B",
                    "【答案】B\n【解析】标志词 Listen! 提示说话时动作正在发生，用现在进行时 is playing。",
                    errorProne = "极基础题，个别学生可能漏掉系动词 is，直接写 playing，但在选择题中不易错。",
                    translation = "听！有人在隔壁房间拉小提琴。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Look! The children are swimming in the river. They are having a great time.",
                    highlightedSentences = listOf(
                        HighlightedSentence("are swimming", "现在进行时的基本结构，swim 是重读闭音节，需双写 m 加 ing。")
                    ),
                    source = "人教版七年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I am doing my homework now.", "我现在正在做作业。", "now 是最直接的标志词。", "基础必会"),
                ExampleSentence("My uncle is coming to see us this weekend.", "我叔叔这个周末要来看我们。", "位移动词用进行时表将来计划。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("常见标志词", "now, at present, look!, listen!, at the moment。"),
                TeachingNote("状态动词", "感官动词（hear, see）、情感动词（like, love）、拥有动词（have, belong）一般不用于进行时。")
            ),
            famousQuote = "Life is happening now.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "past_continuous", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "过去进行时 (Past Continuous)",
            description = "表示过去某一时刻或某段时间正在进行的动作。",
            syllabusDetails = listOf("was/were + doing 结构", "when 和 while 引导的时间状语从句中的动作长短配合"),
            relatedPoints = listOf(
                RelatedPoint("when 与 while 辨析", "when 后面常接瞬间动词（一般过去时），while 后面必须接延续性动词（过去进行时）。", "这是过去进行时最核心的考法。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "广州中考",
                    "I ______ a book when the telephone rang.",
                    listOf("A. read", "B. have read", "C. was reading", "D. am reading"),
                    "C",
                    "【答案】C\n【解析】考查“when + 瞬间动作，主句 + 延续动作”。电话铃响(rang)是瞬间动作，发生时“看书”这个动作正在进行，因此主句用过去进行时 was reading。",
                    errorProne = "未掌握 when 和 while 句型的时态配合规律，乱猜 A 或 D。",
                    translation = "电话铃响时我正在看书。"
                ),
                PastExamQuestion(
                    "2022", "天津中考",
                    "What ______ you ______ at 8:00 last night?",
                    listOf("A. did; do", "B. are; doing", "C. were; doing", "D. do; do"),
                    "C",
                    "【答案】C\n【解析】时间状语是“at 8:00 last night（昨晚八点）”，表示过去具体某一个时刻正在发生的动作，必须用过去进行时。",
                    errorProne = "看到 last night 就直接选 A (did do)，忽略了前面的具体时刻 at 8:00。",
                    translation = "昨晚八点你正在做什么？"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "While the alien was buying a souvenir, the girl called the police.",
                    highlightedSentences = listOf(
                        HighlightedSentence("While the alien was buying", "while 引导的从句描述一个正在持续的背景动作，用过去进行时。"),
                        HighlightedSentence("the girl called", "主句描述在此背景下突然发生的动作，用一般过去时。")
                    ),
                    source = "人教版八年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("They were playing football from 3 to 5 yesterday afternoon.", "昨天下午三点到五点他们一直在踢足球。", "表示过去某一段时间内一直在进行的动作。", "基础必会"),
                ExampleSentence("While my mother was cooking, my father was watching TV.", "妈妈在做饭的时候，爸爸在看电视。", "两个过去的动作同时进行，都可以用过去进行时。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("时间标志词定位", "at this time yesterday, at 9:00 last night, from 7 to 9 yesterday。"),
                TeachingNote("长短动作图解法", "在黑板上画一条长线代表 while 引导的进行时动作，在线中间画一个短叉代表 when 引导的瞬间动作，极大地帮助学生理解。")
            ),
            famousQuote = "Time was flowing like a river.", quoteAuthor = "Unknown"
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
            relatedPoints = listOf(
                RelatedPoint("过去的过去", "必须有一个参照的过去时间点（一般过去时），在其之前发生的动作才能用过去完成时。", "没有比较就没有过去完成时。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "北京中考",
                    "By the time we got to the cinema, the movie ______ for 10 minutes.",
                    listOf("A. was starting", "B. had started", "C. has started", "D. had been on"),
                    "D",
                    "【答案】D\n【解析】“到达电影院”(got) 是一般过去时，电影开始在到达之前，即“过去的过去”，用过去完成时。加上 for 10 minutes 需要用延续性动词状态 be on。",
                    errorProne = "极易选 B。忽视了 start 是瞬间动词，不能和 for 10 minutes 连用。",
                    translation = "当我们到达电影院时，电影已经放映了 10 分钟。"
                ),
                PastExamQuestion(
                    "2022", "江苏中考",
                    "She said she ______ the Great Wall twice.",
                    listOf("A. have visited", "B. had visited", "C. has gone to", "D. went to"),
                    "B",
                    "【答案】B\n【解析】主句是 She said (过去时)，去过长城是在说之前发生的动作，因此从句要用过去完成时 had visited。",
                    errorProne = "没有注意到主句是过去时，误选 A 认为是一般的完成时。",
                    translation = "她说她已经去过长城两次了。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "When I got to school, I realized that I had left my backpack at home.",
                    highlightedSentences = listOf(
                        HighlightedSentence("When I got to school", "参照的过去时间点。"),
                        HighlightedSentence("had left my backpack", "把书包落在家里是在到达学校之前发生的，用过去完成时。")
                    ),
                    source = "人教版九年级 Unit 11"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("By the end of last year, we had learned 2,000 words.", "到去年年底，我们已经学了2000个单词。", "By + 过去时间，是过去完成时的最典型标志词。", "基础必会"),
                ExampleSentence("He told me he had never been to Beijing before.", "他告诉我他以前从未去过北京。", "宾语从句中的时态呼应，主过从过完。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("解题核心", "寻找题干中是否有“过去的动作或时间(如 got, arrived, by 1990)”，若有，且空格动作发生在其之前，必选 had done。"),
                TeachingNote("瞬间动词限制", "过去完成时同样受瞬间动词不能接一段时间(for/since)的限制，必须做转换。")
            ),
            famousQuote = "Before the end.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "past_future", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "过去将来时 (Past Future)",
            description = "表示从过去某一时间看将要发生的动作或存在的状态。",
            syllabusDetails = listOf("would + do", "was/were going to do", "常用于宾语从句中"),
            relatedPoints = listOf(
                RelatedPoint("宾语从句的时态呼应", "主句是一般过去时，从句若表示将来的动作，必须用过去将来时。", "这是过去将来时在中考中最主要的考查形式。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "长春中考",
                    "She said she ______ a computer scientist in the future.",
                    listOf("A. will be", "B. would be", "C. is", "D. has been"),
                    "B",
                    "【答案】B\n【解析】主句谓语动词 said 是一般过去时，宾语从句中有 in the future，表示过去的将来，必须用过去将来时 would be。",
                    errorProne = "只看到 in the future 就选 A (will be)，忽略了主句是过去时。",
                    translation = "她说她将来会成为一名计算机科学家。"
                ),
                PastExamQuestion(
                    "2022", "青岛中考",
                    "I didn't know when they ______ for Beijing.",
                    listOf("A. will leave", "B. are leaving", "C. would leave", "D. have left"),
                    "C",
                    "【答案】C\n【解析】主句 didn't know 是一般过去时，从句动作（离开去北京）发生在主句动作之后，用过去将来时 would leave。",
                    errorProne = "时态前后不呼应，误选 A 或 B。",
                    translation = "我不知道他们什么时候动身去北京。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "He told his mother that he would study hard and get good grades.",
                    highlightedSentences = listOf(
                        HighlightedSentence("told", "主句动词，一般过去时。"),
                        HighlightedSentence("would study", "在过去的某个时间（告诉妈妈的时候）看将来的打算。")
                    ),
                    source = "人教版九年级教材"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I thought it was going to rain.", "我以为天要下雨了。", "was going to 表示过去计划或预料要发生的事。", "基础必会"),
                ExampleSentence("Nobody knew what would happen next.", "没有人知道接下来会发生什么。", "would do 用于表示过去的将来。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("解题口诀", "主过从必过，将来变过将（主句过去时，从句必须是过去时态的一种；如果从句含将来意义，就用过去将来时）。")
            ),
            famousQuote = "Looking back at what was to come.", quoteAuthor = "Unknown"
        ),
        KnowledgePoint(
            id = "passive_voice", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "被动语态 (Passive Voice)",
            description = "表示主语是动作的承受者。",
            syllabusDetails = listOf("一般现在时被动", "一般过去时被动", "一般将来时被动", "含有情态动词的被动语态"),
            relatedPoints = listOf(
                RelatedPoint("语态与时态结合", "被动语态(be done)中的 be 动词随着时态变化，如 is/are done, was/were done, will be done。", "做题时必须同时判断时态和语态。"),
                RelatedPoint("主动表被动", "某些连系动词（如 sound, smell, taste）或表示事物固有属性的词（如 read, write）用主动形式表示被动意义。", "例如 The book sells well。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "南京中考",
                    "A lot of trees ______ in our city every year to make it greener.",
                    listOf("A. plant", "B. are planted", "C. were planted", "D. will plant"),
                    "B",
                    "【答案】B\n【解析】主语 trees 是动作 plant（种植）的承受者，用被动语态；时间状语 every year 提示一般现在时，故用 are planted。",
                    errorProne = "未判断出主被动关系错选 A，或未看清时间状语错选 C。",
                    translation = "为了让城市更绿，我们城市每年都会种很多树。"
                ),
                PastExamQuestion(
                    "2022", "西安中考",
                    "The missing boy ______ by the police yesterday.",
                    listOf("A. is found", "B. was found", "C. found", "D. has found"),
                    "B",
                    "【答案】B\n【解析】男孩是被找到的，所以用被动语态。yesterday 表示一般过去时，被动语态的 be 动词用 was。",
                    errorProne = "忘记被动语态公式 be + done，错选 C。",
                    translation = "那个走失的男孩昨天被警察找到了。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Tea is produced in many different areas in China. It is planted on the sides of mountains.",
                    highlightedSentences = listOf(
                        HighlightedSentence("is produced", "一般现在时被动语态。主语 Tea 不可数，be 动词用 is。"),
                        HighlightedSentence("is planted", "也是一般现在时被动语态，描述客观事实。")
                    ),
                    source = "人教版九年级 Unit 5"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("The classroom must be cleaned every day.", "教室必须每天打扫。", "含有情态动词的被动语态：情态动词 + be + done。", "基础必会"),
                ExampleSentence("He was seen to leave the room.", "有人看到他离开了房间。", "主动语态中省略 to 的动词不定式作宾补（如 see sb do），变被动时必须加上 to。", "拔高难点")
            ),
            teachingNotes = listOf(
                TeachingNote("解题步骤", "一看主语定语态（主动还是被动），二看标志词定时态，三看主语单复数定 be 动词形式。"),
                TeachingNote("常见错因", "过去分词拼写错误；被动句中丢掉 be 动词（直接写 trees planted）。")
            ),
            famousQuote = "Things are done, not just do.", quoteAuthor = "Grammarian"
        ),
        KnowledgePoint(
            id = "non_finite_verbs", section = "板块二：时态与语态体系 (Tenses & Voices)", title = "非谓语动词 (Non-finite Verbs)",
            description = "在句中不单独作谓语的动词形式。",
            syllabusDetails = listOf("动词不定式 (to do) 作主/宾/宾补/状/定语", "动名词 (doing) 作主/宾语", "分词 (doing/done) 作定语或状语"),
            relatedPoints = listOf(
                RelatedPoint("不定式与动名词的区别", "有些动词后只能接 to do（如 want, decide），有些只能接 doing（如 enjoy, finish, mind），有些都可以但意义不同（如 stop, forget, remember）。", "初中非谓语动词的绝对核心考点。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "成都中考",
                    "We should avoid ______ too much junk food. It's bad for our health.",
                    listOf("A. to eat", "B. eating", "C. eat", "D. eaten"),
                    "B",
                    "【答案】B\n【解析】avoid（避免）是典型的只能接动名词 doing 作宾语的动词。",
                    errorProne = "未记住 avoid 的固定搭配，凭语感乱选 to eat。",
                    translation = "我们应该避免吃太多垃圾食品。这对我们的健康有害。"
                ),
                PastExamQuestion(
                    "2022", "郑州中考",
                    "He stopped ______ and had a rest when he felt tired.",
                    listOf("A. working", "B. to work", "C. work", "D. worked"),
                    "A",
                    "【答案】A\n【解析】stop doing 表示“停止正在做的事”；stop to do 表示“停下来（原先的事）去做（另一件）事”。因为他累了，所以是停止工作去休息，选 working。",
                    errorProne = "混淆 stop doing 和 stop to do 的语义差别。",
                    translation = "当他觉得累的时候，他停止了工作去休息。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "I'm looking forward to visiting the museum. It is exciting to learn about the past.",
                    highlightedSentences = listOf(
                        HighlightedSentence("looking forward to visiting", "这里的 to 是介词，后面必须接动名词 doing。"),
                        HighlightedSentence("It is exciting to learn", "It 作形式主语，真正的主语是后面的不定式 to learn。")
                    ),
                    source = "人教版八年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("My dream is to be a teacher.", "我的梦想是当一名老师。", "不定式作表语。", "基础必会"),
                ExampleSentence("Reading books is a good habit.", "读书是一个好习惯。", "动名词作主语。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("必背口诀", "只接 doing 的动词：完成实践值千金，建议继续防错过，承认介意期盼原谅（finish, practice, suggest, keep, mind, look forward to...）。"),
                TeachingNote("形式主语 it", "在 It takes sb. time to do sth. 和 It is adj. for/of sb. to do sth. 句型中，真正的主语永远是 to do。")
            ),
            famousQuote = "Infinite possibilities.", quoteAuthor = "Unknown"
        ),

        // ================= 板块三：句法体系 (Syntax) =================
        KnowledgePoint(
            id = "sentence_types", section = "板块三：句法体系 (Syntax)", title = "句子种类",
            description = "按句子的使用目的进行的分类。",
            syllabusDetails = listOf("陈述句", "疑问句（一般/特殊/选择/反意疑问句）", "祈使句", "感叹句 (What/How 引导)"),
            relatedPoints = listOf(
                RelatedPoint("反意疑问句", "遵循“前肯后否，前否后肯”的原则，特别注意前面有 never, seldom, hardly 等否定词的情况。", "反意疑问句是中考高频也是易错点。"),
                RelatedPoint("感叹句的 What 与 How", "What 修饰名词（What a/an + adj + n + 主谓），How 修饰形容词/副词（How + adj/adv + 主谓）。", "这是感叹句的核心考点。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "长沙中考",
                    "He has never been to Beijing, ______ he?",
                    listOf("A. has", "B. hasn't", "C. is", "D. isn't"),
                    "A",
                    "【答案】A\n【解析】前句含有否定副词 never，属于“前否”，因此后面要用肯定形式“后肯”。主句有助动词 has，后面也用 has。",
                    errorProne = "没看出 never 是否定词，按照“前肯后否”误选 B。",
                    translation = "他从未去过北京，是吗？"
                ),
                PastExamQuestion(
                    "2022", "广州中考",
                    "______ exciting news it is! We're all thrilled.",
                    listOf("A. What a", "B. What an", "C. What", "D. How"),
                    "C",
                    "【答案】C\n【解析】中心词是 news（不可数名词），用 What 引导感叹句。因为不可数，所以不能加 a/an。",
                    errorProne = "看到 exciting 就选 What an (没看后面的不可数名词) 或者直接选 How (认为修饰形容词)。",
                    translation = "这是多么激动人心的消息啊！我们都很兴奋。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Don't run in the hallways. Please keep quiet in the library.",
                    highlightedSentences = listOf(
                        HighlightedSentence("Don't run", "祈使句的否定形式：Don't + 动词原形。"),
                        HighlightedSentence("Please keep quiet", "祈使句的肯定形式：动词原形开头。")
                    ),
                    source = "人教版七年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("What a beautiful flower it is!", "多美的一朵花啊！", "What + a + adj + 单数可数名词 + 主语 + 谓语！", "基础必会"),
                ExampleSentence("Let's go to the park, shall we?", "我们去公园吧，好吗？", "Let's ... 的反意疑问句固定用 shall we?", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("感叹句口诀", "找主谓，画个圈；剩下名词 what 填，剩下形副 how 填；单数名词加 a/an。"),
                TeachingNote("祈使句+并列连词", "注意“祈使句 + and/or + 简单句”结构，相当于 if 条件句的变体。")
            ),
            famousQuote = "Ask why.", quoteAuthor = "Socrates"
        ),
        KnowledgePoint(
            id = "five_basic_patterns", section = "板块三：句法体系 (Syntax)", title = "简单句基本句型",
            description = "构成英语句子的五种最基本结构。",
            syllabusDetails = listOf("主谓 (SV)", "主谓宾 (SVO)", "主系表 (SVP)", "主谓双宾 (SVOO)", "主谓宾宾补 (SVOC)"),
            relatedPoints = listOf(
                RelatedPoint("双宾语结构", "动词后接人（间接宾语）和物（直接宾语）。有些动词转换为物在前时加 to (give sth to sb)，有些加 for (buy sth for sb)。", "这是句型转换中的常考点。"),
                RelatedPoint("宾语补足语", "补充说明宾语的状态或动作。常考 make sb adj. 和 ask/tell sb to do sth.", "理解宾补是分析长难句的关键。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "上海中考",
                    "My father bought ______ a new bicycle on my birthday.",
                    listOf("A. I", "B. me", "C. my", "D. mine"),
                    "B",
                    "【答案】B\n【解析】考查“主谓双宾 (SVOO)”。buy sb. sth. 意为“给某人买某物”，人称代词作宾语必须用宾格 me。",
                    errorProne = "用错代词格。",
                    translation = "我生日那天，我爸爸给我买了一辆新自行车。"
                ),
                PastExamQuestion(
                    "2022", "大连中考",
                    "The good news made everyone in the class ______.",
                    listOf("A. happy", "B. happily", "C. to be happy", "D. happiness"),
                    "A",
                    "【答案】A\n【解析】考查“主谓宾宾补 (SVOC)”。make sb. + adj. 意为“使某人处于某种状态”，形容词 happy 作宾语 everyone 的补足语。",
                    errorProne = "用副词 happily 去修饰动词 made，没有理解这是宾语补足语结构。",
                    translation = "这个好消息让班上的每个人都很高兴。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "We found him a very good teacher. The teacher always tells us to work hard.",
                    highlightedSentences = listOf(
                        HighlightedSentence("found him a very good teacher", "主谓双宾：我们给他找了一个好老师；主谓宾宾补：我们发现他是一个好老师。此处存在结构歧义，需结合语境。"),
                        HighlightedSentence("tells us to work hard", "主谓宾宾补：tell sb. to do sth.")
                    ),
                    source = "通用语法教材"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("The bird is flying.", "鸟在飞。", "SV (主谓)：不及物动词单独作谓语。", "基础必会"),
                ExampleSentence("He looks very tired.", "他看起来很累。", "SVP (主系表)：连系动词 + 形容词作表语。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("核心拆解", "在分析阅读理解长难句时，引导学生剥离定语和状语，只看核心的五种基本句型，句子主干就一目了然。"),
                TeachingNote("双宾转换口诀", "送给、传递用 to (give, pass, send)；购买、制作用 for (buy, make, cook)。")
            ),
            famousQuote = "Structure is everything.", quoteAuthor = "Architect"
        ),
        KnowledgePoint(
            id = "object_clause", section = "板块三：句法体系 (Syntax)", title = "宾语从句 (Object Clause)",
            description = "在复合句中充当宾语的从句。",
            syllabusDetails = listOf("引导词 (that/if/whether/wh-)", "语序（必须是陈述语序）", "时态呼应规则"),
            relatedPoints = listOf(
                RelatedPoint("陈述语序", "无论是疑问词还是 whether 引导，从句中必须是“主语 + 谓语”的陈述语序。", "这是中考单选中逢出必考的绝对核心。"),
                RelatedPoint("时态呼应", "主句是一般现在时，从句时态任意；主句是一般过去时，从句必须用过去时态的某一种（除非是客观真理）。", "时态与语序结合是常见的双重考点。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "武汉中考",
                    "Could you tell me ______?",
                    listOf("A. where is the post office", "B. where the post office is", "C. how can I get to the post office", "D. how get to the post office"),
                    "B",
                    "【答案】B\n【解析】考查宾语从句语序。从句必须是陈述语序，A 和 C 都是疑问语序。D 缺少主语。B 是“主语(the post office) + 谓语(is)”，符合。",
                    errorProne = "受疑问句习惯影响，误选 A（倒装语序）。",
                    translation = "你能告诉我邮局在哪里吗？"
                ),
                PastExamQuestion(
                    "2022", "南京中考",
                    "The teacher asked ______.",
                    listOf("A. if everyone is here", "B. whether is everyone here", "C. if everyone was here", "D. that everyone was here"),
                    "C",
                    "【答案】C\n【解析】主句动词 asked 是一般过去时，从句必须使用过去时态，排除 A 和 B。D 选项 that 不引导疑问意义的从句。所以选 C。",
                    errorProne = "忘记了“主过从过”的时态呼应原则，误选 A。",
                    translation = "老师问大家是否都到了。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "I don't know whether he will come tomorrow. I hope that he can join us.",
                    highlightedSentences = listOf(
                        HighlightedSentence("whether he will come", "whether 引导的宾语从句，陈述语序。"),
                        HighlightedSentence("that he can join us", "that 引导的陈述意义的宾语从句，在口语中 that 常可省略。")
                    ),
                    source = "人教版九年级教材"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("He said that the earth goes around the sun.", "他说地球绕着太阳转。", "主句虽是过去时，但从句是客观真理，必须用一般现在时。", "中考核心"),
                ExampleSentence("Do you know when the meeting will start?", "你知道会议什么时候开始吗？", "疑问词 when 引导，后接陈述语序。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("三大要素", "解宾语从句题，死盯三个要素：1. 引导词（缺什么意思补什么），2. 语序（永远陈述），3. 时态（主过从必过，真理永现）。"),
                TeachingNote("if/whether 辨析", "在介词后、与 or not 连用或接不定式(to do)时，只能用 whether，不能用 if。")
            ),
            famousQuote = "I know that I know nothing.", quoteAuthor = "Socrates"
        ),
        KnowledgePoint(
            id = "adverbial_clause", section = "板块三：句法体系 (Syntax)", title = "状语从句 (Adverbial Clause)",
            description = "在复合句中充当状语的从句。",
            syllabusDetails = listOf("时间状语从句", "条件状语从句 (主将从现原则)", "原因状语从句", "结果状语从句 (so...that / such...that)", "目的、让步、比较状语从句"),
            relatedPoints = listOf(
                RelatedPoint("主将从现原则", "在 if/unless/when/as soon as 引导的条件或时间状语从句中，主句用将来时，从句用现在时。", "中考必考考点。"),
                RelatedPoint("so...that 与 such...that", "so 修饰形容词或副词，such 修饰名词。两者引导结果状语从句，意为“如此……以至于……”。", "极易混淆的搭配。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "苏州中考",
                    "We won't go out for a picnic ______ the weather is fine tomorrow.",
                    listOf("A. if", "B. unless", "C. because", "D. when"),
                    "B",
                    "【答案】B\n【解析】考查条件状语从句。句意：我们不会去野餐，除非明天天气好。unless 相当于 if not。",
                    errorProne = "没看懂句意逻辑，把 unless 和 if 弄反。",
                    translation = "除非明天天气好，否则我们不会出去野餐。"
                ),
                PastExamQuestion(
                    "2022", "杭州中考",
                    "The boy is ______ young ______ he can't go to school.",
                    listOf("A. so; that", "B. such; that", "C. too; to", "D. enough; to"),
                    "A",
                    "【答案】A\n【解析】考查结果状语从句。young 是形容词，前面用 so 修饰，构成 so...that 句型。如果选 C，后面不能跟从句，只能跟动词原形。",
                    errorProne = "混淆 so/such 的修饰对象，或把 too...to 结构后面误接了从句。",
                    translation = "这个男孩太小了，还不能去上学。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Although he is very old, he still works hard every day.",
                    highlightedSentences = listOf(
                        HighlightedSentence("Although he is very old", "although 引导让步状语从句，切记不能与 but 同用在主句中。")
                    ),
                    source = "人教版八年级下册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I will wait here until you come back.", "我会在这里一直等到你回来。", "until 引导时间状语从句，遵循主将从现。", "基础必会"),
                ExampleSentence("He ran so fast that nobody could catch up with him.", "他跑得如此快，以至于没人能追上他。", "so+副词+that 引导结果状语从句。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("逻辑关系是核心", "做状语从句的题，本质是考查两个分句之间的逻辑关系（因果、让步、条件等），必须先翻译出句意。"),
                TeachingNote("中式英语避坑", "再次强调：because 和 so 不能连用；although 和 but 不能连用。")
            ),
            famousQuote = "When in Rome, do as the Romans do.", quoteAuthor = "Proverb"
        ),
        KnowledgePoint(
            id = "attributive_clause", section = "板块三：句法体系 (Syntax)", title = "定语从句 (Attributive Clause)",
            description = "在复合句中修饰名词或代词的从句。",
            syllabusDetails = listOf("关系代词 (who, whom, whose, which, that) 的用法与省略", "关系副词 (where, when, why) 的基本概念"),
            relatedPoints = listOf(
                RelatedPoint("关系代词的选择", "先行词是人，用 who/that/whom；先行词是物，用 which/that。whose 表所属关系（某人的/某物的）。", "定语从句最基础也是最重要的考点。"),
                RelatedPoint("关系代词的省略", "当关系代词在定语从句中作宾语时，可以省略。", "例如 The book (which) I bought yesterday is very interesting。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "北京中考",
                    "I like the teacher ______ classes are very interesting and creative.",
                    listOf("A. who", "B. whose", "C. which", "D. that"),
                    "B",
                    "【答案】B\n【解析】先行词是 the teacher，后面的名词是 classes。老师和课程之间是所属关系（老师的课程），所以用 whose。",
                    errorProne = "看到先行词是 teacher 就习惯性选 who，没看后面的名词构成的所属关系。",
                    translation = "我喜欢那位课讲得很有趣、很有创意的老师。"
                ),
                PastExamQuestion(
                    "2022", "广东中考",
                    "The movie ______ we saw last night was wonderful.",
                    listOf("A. who", "B. whom", "C. what", "D. which"),
                    "D",
                    "【答案】D\n【解析】先行词是 movie (物)，关系代词在从句中作 saw 的宾语，只能用 which 或 that。what 不能引导定语从句。",
                    errorProne = "混淆宾语从句和定语从句，误选 what。",
                    translation = "我们昨晚看的那部电影非常棒。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Do you know the boy who is playing basketball over there? He is the one that I told you about.",
                    highlightedSentences = listOf(
                        HighlightedSentence("who is playing basketball", "先行词是 boy，who 在从句中作主语。"),
                        HighlightedSentence("that I told you about", "先行词是不定代词 the one，关系代词常用 that，且作 about 的宾语，可省略。")
                    ),
                    source = "人教版九年级 Unit 9"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("This is the most beautiful place that I have ever visited.", "这是我去过的最美丽的地方。", "先行词被最高级修饰时，关系代词只能用 that。", "中考核心"),
                ExampleSentence("A friend who helps you in time of need is a real friend.", "患难见真情。", "先行词是 A friend，who 引导定语从句。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("解题三步法", "1. 找先行词（看是人还是物），2. 判断关系词在从句中的成分（主/宾/定），3. 检查是否有只能用 that 的特殊情况（如最高级、序数词修饰时）。"),
                TeachingNote("that 的局限", "介词后面不能用 that（如 in which，不能 in that）；非限制性定语从句（逗号隔开）不能用 that。")
            ),
            famousQuote = "The man who reads lives a thousand lives.", quoteAuthor = "George R.R. Martin"
        ),
        KnowledgePoint(
            id = "special_patterns", section = "板块三：句法体系 (Syntax)", title = "特殊句式",
            description = "英语中特殊的语法结构和一致性原则。",
            syllabusDetails = listOf("There be 句型", "It 的固定句型 (It takes sb. some time to do...)", "倒装句（so/neither 引起的半倒装）", "主谓一致原则（语法一致、意义一致、就近原则）"),
            relatedPoints = listOf(
                RelatedPoint("There be 句型的就近原则", "There is a pen and two books. There are two books and a pen.", "谓语动词单复数由离它最近的名词决定。"),
                RelatedPoint("So do I 倒装句", "表示“某人也是一样”，So + 助动词/情态动词/be动词 + 主语。", "注意助动词的时态要与前句保持一致。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2023", "天津中考",
                    "— I have never been to the water park.\n— ______.",
                    listOf("A. So have I", "B. Neither have I", "C. So I have", "D. Neither I have"),
                    "B",
                    "【答案】B\n【解析】前句是否定句（never），表示“我也没去过”，用 Neither 引导的倒装。前句助动词是 have，所以是 Neither have I。",
                    errorProne = "错选 A (未看清 never 否定含义) 或 C/D (语序未倒装)。",
                    translation = "——我从未去过那个水上公园。\n——我也没去过。"
                ),
                PastExamQuestion(
                    "2022", "重庆中考",
                    "There ______ a football match on TV this evening.",
                    listOf("A. will have", "B. is going to be", "C. has", "D. is going to have"),
                    "B",
                    "【答案】B\n【解析】考查 There be 句型的将来时。There is/are going to be 或 There will be。绝不能用 have。",
                    errorProne = "受汉语“将要有”影响，极易错选 A 或 D。",
                    translation = "今晚电视上将有一场足球赛。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "It takes me about half an hour to get to school by bike.",
                    highlightedSentences = listOf(
                        HighlightedSentence("It takes me... to get", "It takes sb. time to do sth. 核心固定句型，it 是形式主语。")
                    ),
                    source = "人教版八年级上册"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("Not only you but also he is wrong.", "不仅你错了，他也错了。", "not only...but also 连接主语，遵循就近原则，与 he 一致用 is。", "中考核心"),
                ExampleSentence("There are a lot of people in the park.", "公园里有很多人。", "There be 句型表示“存在有”。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("There be 的绝对禁忌", "There be 和 have 绝对不能同时出现表示“有”。There is a book (对)；There has a book (大错特错)。"),
                TeachingNote("It 句型辨析", "It takes sb time to do (花费时间)；It costs sb money to buy (花费金钱)；It is adj for sb to do (做某事是...的)。")
            ),
            famousQuote = "Rules are meant to be understood.", quoteAuthor = "Unknown"
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints[0]
    }
}
