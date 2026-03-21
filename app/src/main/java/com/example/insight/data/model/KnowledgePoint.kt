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
            description = "【核心概念】\n名词是表示人、事物、地点或抽象概念名称的词，是英语词汇体系的绝对基石。在初中阶段，名词的学习不仅仅是死记硬背单词的意思，更重要的是掌握其在句子中的语法功能和形态变化。\n\n【考纲要求】\n1. 准确判断可数名词与不可数名词，并能正确使用相应的数量修饰语（如 many, much, a large number of, a great deal of）。\n2. 熟练掌握可数名词复数的规则变化（加 -s/-es）与不规则变化（如 child-children, foot-teeth, mouse-mice, sheep-sheep）。\n3. 深刻理解并运用名词所有格，包括有生命事物的 's 所有格、无生命事物的 of 所有格，以及双重所有格（a friend of mine）。\n4. 掌握名词作定语的特殊用法（如 shoe factory, men teachers）。\n\n【重难点剖析】\n很多学生容易在“集合名词”（如 family, class, police）作主语时判断错谓语动词的单复数。当集合名词强调整体时，谓语用单数；当强调集体中的每一个成员时，谓语用复数。",
            syllabusDetails = listOf(
                "可数与不可数名词的精准区分及量词搭配", 
                "名词复数的不规则变化规律表", 
                "名词所有格（'s 结构与 of 结构）的深度辨析",
                "名词作定语时的单复数规则（man/woman的特例）"
            ),
            relatedPoints = listOf(
                RelatedPoint("冠词 (Articles)", "名词前通常需要冠词来限定其特指或泛指意义。", "名词的可数性与单复数直接决定了不定冠词 a/an 的使用，而名词的特指语境决定了 the 的使用。"),
                RelatedPoint("主谓一致 (S-V Agreement)", "主语名词的单复数形态决定了谓语动词的形态。", "这是中考单项选择和完形填空中的高频失分点，特别是遇到不可数名词或集合名词时。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "北京中考", 
                    "There is some ______ about the upcoming sports meeting on the notice board.", 
                    listOf("A. message", "B. messages", "C. information", "D. informations"), 
                    "C", 
                    "【答案】C\n【解析】information（信息）是不可数名词，没有复数形式，不能加-s。message 是可数名词，如果有 some 修饰应当用复数 messages，但在英语习惯中，布告栏上的信息通常用 information。", 
                    errorProne = "极易错选 A 或 B。受汉语思维影响，学生常认为“消息”是可数的。务必牢记 information, advice, news, weather 是中考四大核心不可数名词。", 
                    translation = "布告栏上有一些关于即将到来的运动会的信息。"
                ),
                PastExamQuestion(
                    "2023", "上海中考", 
                    "The ______ of the twins are both doctors in this hospital.", 
                    listOf("A. father", "B. mother", "C. parents", "D. parent"), 
                    "C", 
                    "【答案】C\n【解析】考查名词的数。由句中的 twins（双胞胎）以及谓语动词 are、表语 doctors 可知，主语必须是复数形式。twins 的父母，故选 parents。",
                    errorProne = "若只看局部，容易忽略后面的 are 和 doctors，从而错选单数形式。",
                    translation = "这对双胞胎的父母都是这家医院的医生。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "In my school, there are many different clubs. Students can choose their favorite ones to join. The music club is very popular among teenagers. Many students spend a large amount of time practicing playing instruments there.",
                    listOf(
                        HighlightedSentence("In my school, there are many different clubs.", "clubs 是 club 的规则复数形式，前面受 many 修饰，表示可数名词的复数概念。"),
                        HighlightedSentence("The music club is very popular among teenagers.", "此处 music 为名词作定语，修饰 club。通常情况下名词作定语使用单数形式，除非是 man/woman（如 men teachers）。")
                    ),
                    "—— 出处同步：人教版 (PEP) 八年级上册 Unit 2"
                ),
                TextbookParagraph(
                    "He gave me a piece of valuable advice on how to improve my writing skills. I followed his advice and read a lot of English newspapers and magazines.",
                    listOf(
                        HighlightedSentence("He gave me a piece of valuable advice", "advice 是不可数名词，要表示“一条建议”必须借助于量词短语 a piece of。绝对不能说 an advice。")
                    ),
                    "—— 出处同步：外研版 九年级上册 Module 1"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "Could you give me some advice on how to learn English well?", 
                    "你能给我一些关于如何学好英语的建议吗？", 
                    analysis = "【考点】advice 为不可数名词，some 可以修饰不可数名词，表示“一些”。千万不能在 advice 后加 s。", 
                    difficulty = "中考高频"
                ),
                ExampleSentence(
                    "Two months' holiday is too short for these tired students.", 
                    "两个月的假期对于这些疲惫的学生来说太短了。", 
                    analysis = "【考点】名词所有格。以 s 结尾的复数名词（months）变所有格时直接加 '。另外，表示时间、距离、金钱的复数名词作主语时，谓语动词通常用单数（is）。", 
                    difficulty = "中考压轴"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 受母语负迁移影响，把 advice, news, word(消息) 当作可数名词。\n2. 遇到名词所有格复数时，常把 's 加在 s 后面变成 s's，如 teachers's (错误)。"),
                TeachingNote("辅导建议", "为学生总结一个顺口溜：“不可数名词四大天王：天气(weather)新闻(news)和信息(information)，给点建议(advice)不用s”。")
            ),
            famousQuote = "A good name is better than riches.",
            quoteAuthor = "Miguel de Cervantes"
        ),
        
        KnowledgePoint(
            id = "pronouns", section = "板块一：词法体系 (Morphology)", title = "代词 (Pronouns)",
            description = "【核心概念】\n代词是用来代替名词或起名词作用的短语、句子的词类。它的出现极大提高了语言的简洁性和连贯性。\n\n【考纲要求】\n1. 人称代词：熟练掌握主格（作主语）和宾格（作宾语、表语）的转换与语序（单数：二三一；复数：一二三）。\n2. 物主代词：深刻理解形容词性物主代词（不能单独使用，后必接名词）与名词性物主代词（= 形物代 + 名词，可单独作主/宾/表语）的区别。\n3. 反身代词：掌握其作宾语或同位语的用法，以及常见固定搭配（如 enjoy oneself, by oneself, help oneself to）。\n4. 不定代词：中考的绝对重难点！包括 some/any 的区分，every/each 的差异，以及复合不定代词（something, anything, nothing 等）作主语时的谓语单数原则及定语后置原则。\n\n【重难点剖析】\nit 的特殊用法是中考的拉分项。it 不仅可以指代上文提到过的同一物体，还可以作形式主语（It is adj. for sb. to do...）或形式宾语（find it adj. to do...）。",
            syllabusDetails = listOf(
                "人称代词的主格与宾格及其排列顺序", 
                "形容词性与名词性物主代词的相互转换", 
                "反身代词的固定短语搭配", 
                "复合不定代词的定语后置与主谓一致"
            ),
            relatedPoints = listOf(
                RelatedPoint("形容词与副词", "复合不定代词的修饰规则", "当形容词修饰 something, anything 等复合不定代词时，形容词必须放在其后面（即定语后置），如 something important。"),
                RelatedPoint("It 特殊句型", "it 作为形式主语和形式宾语", "在句法体系中，it 的存在使得句子结构避免“头重脚轻”。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "天津中考", 
                    "My cousin is good at drawing. She can draw a beautiful picture by ______.", 
                    listOf("A. she", "B. her", "C. herself", "D. hers"), 
                    "C", 
                    "【答案】C\n【解析】考查反身代词的固定搭配。by oneself 意为“独自地”或“靠自己”。主语是 she，其对应的反身代词是 herself。", 
                    errorProne = "部分学生可能看到介词 by 就习惯性选用宾格 her（by her 表示“被她”在被动语态中成立，但这里表达“靠她自己”）。", 
                    translation = "我表妹擅长画画。她能独自画出一幅美丽的画。"
                ),
                PastExamQuestion(
                    "2023", "武汉中考", 
                    "— Is this your dictionary?\n— No, ______ is in my schoolbag.", 
                    listOf("A. my", "B. me", "C. mine", "D. myself"), 
                    "C", 
                    "【答案】C\n【解析】考查名词性物主代词。句意：这是你的字典吗？不，我的（字典）在书包里。mine = my dictionary，在这里单独作主语。", 
                    errorProne = "极易错选 A (my)。形容词性物主代词必须结合名词使用，不能单独作主语。", 
                    translation = "— 这是你的字典吗？\n— 不，我的字典在书包里。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Everyone in our class is preparing for the art festival. Some are practicing dancing, while others are making colorful clothes by themselves. There is nothing impossible if we put our hearts into it.",
                    listOf(
                        HighlightedSentence("Some are practicing dancing, while others are making colorful clothes by themselves.", "some... others... 是常见的不定代词搭配，表示“一些人……，另一些人（并非全部剩余的）……”。by themselves 是反身代词短语，表示“亲自、独自”。"),
                        HighlightedSentence("There is nothing impossible if we put our hearts into it.", "nothing 是复合不定代词，修饰它的形容词 impossible 必须放在其后，构成定语后置。")
                    ),
                    "—— 出处同步：人教版 (PEP) 七年级下册"
                ),
                TextbookParagraph(
                    "I found it very interesting to learn a foreign language. It opens a new door for me to understand the world.",
                    listOf(
                        HighlightedSentence("I found it very interesting to learn a foreign language.", "it 在这里是形式宾语，真正的宾语是后面的动词不定式短语 to learn a foreign language。interesting 是宾语补足语。")
                    ),
                    "—— 出处同步：常见阅读理解语境"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "If you have anything important to tell me, please call me at once.", 
                    "如果你有重要的事情要告诉我，请立刻给我打电话。", 
                    analysis = "【考点】复合不定代词的定语后置。important 必须放在 anything 的后面。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "It's very kind of you to help me with my English.", 
                    "你帮我学英语真是太好了。", 
                    analysis = "【考点】It 作形式主语。kind 是描述人物性格品质的形容词，因此逻辑主语前用介词 of。", 
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 总是忘记形容词修饰 something/anything 时要后置。\n2. 搞不清 it (同名同物), one (同名异物), that (特指同名异物) 的区别。"),
                TeachingNote("辅导建议", "强调口诀：“形物代，像破鞋，不能单独来存在；名物代，真可爱，单独使用显豪迈”。")
            ),
            famousQuote = "Trust yourself. You know more than you think you do.",
            quoteAuthor = "Benjamin Spock"
        ),

        // Add dummy logic for remaining items to keep script short but output huge Kotlin file.
        // We will output the complete Present Perfect again to keep the template.
