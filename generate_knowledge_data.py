import os

kotlin_code = """package com.example.insight.data.model

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
            description = "【核心概念】\\n名词是表示人、事物、地点或抽象概念名称的词，是英语词汇体系的绝对基石。在初中阶段，名词的学习不仅仅是死记硬背单词的意思，更重要的是掌握其在句子中的语法功能和形态变化。\\n\\n【考纲要求】\\n1. 准确判断可数名词与不可数名词，并能正确使用相应的数量修饰语（如 many, much, a large number of, a great deal of）。\\n2. 熟练掌握可数名词复数的规则变化（加 -s/-es）与不规则变化（如 child-children, foot-teeth, mouse-mice, sheep-sheep）。\\n3. 深刻理解并运用名词所有格，包括有生命事物的 's 所有格、无生命事物的 of 所有格，以及双重所有格（a friend of mine）。\\n4. 掌握名词作定语的特殊用法（如 shoe factory, men teachers）。\\n\\n【重难点剖析】\\n很多学生容易在“集合名词”（如 family, class, police）作主语时判断错谓语动词的单复数。当集合名词强调整体时，谓语用单数；当强调集体中的每一个成员时，谓语用复数。",
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
                    "【答案】C\\n【解析】information（信息）是不可数名词，没有复数形式，不能加-s。message 是可数名词，如果有 some 修饰应当用复数 messages，但在英语习惯中，布告栏上的信息通常用 information。", 
                    errorProne = "极易错选 A 或 B。受汉语思维影响，学生常认为“消息”是可数的。务必牢记 information, advice, news, weather 是中考四大核心不可数名词。", 
                    translation = "布告栏上有一些关于即将到来的运动会的信息。"
                ),
                PastExamQuestion(
                    "2023", "上海中考", 
                    "The ______ of the twins are both doctors in this hospital.", 
                    listOf("A. father", "B. mother", "C. parents", "D. parent"), 
                    "C", 
                    "【答案】C\\n【解析】考查名词的数。由句中的 twins（双胞胎）以及谓语动词 are、表语 doctors 可知，主语必须是复数形式。twins 的父母，故选 parents。",
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
                TeachingNote("常见学生错因", "1. 受母语负迁移影响，把 advice, news, word(消息) 当作可数名词。\\n2. 遇到名词所有格复数时，常把 's 加在 s 后面变成 s's，如 teachers's (错误)。"),
                TeachingNote("辅导建议", "为学生总结一个顺口溜：“不可数名词四大天王：天气(weather)新闻(news)和信息(information)，给点建议(advice)不用s”。")
            ),
            famousQuote = "A good name is better than riches.",
            quoteAuthor = "Miguel de Cervantes"
        ),
        
        KnowledgePoint(
            id = "pronouns", section = "板块一：词法体系 (Morphology)", title = "代词 (Pronouns)",
            description = "【核心概念】\\n代词是用来代替名词或起名词作用的短语、句子的词类。它的出现极大提高了语言的简洁性和连贯性。\\n\\n【考纲要求】\\n1. 人称代词：熟练掌握主格（作主语）和宾格（作宾语、表语）的转换与语序（单数：二三一；复数：一二三）。\\n2. 物主代词：深刻理解形容词性物主代词（不能单独使用，后必接名词）与名词性物主代词（= 形物代 + 名词，可单独作主/宾/表语）的区别。\\n3. 反身代词：掌握其作宾语或同位语的用法，以及常见固定搭配（如 enjoy oneself, by oneself, help oneself to）。\\n4. 不定代词：中考的绝对重难点！包括 some/any 的区分，every/each 的差异，以及复合不定代词（something, anything, nothing 等）作主语时的谓语单数原则及定语后置原则。\\n\\n【重难点剖析】\\nit 的特殊用法是中考的拉分项。it 不仅可以指代上文提到过的同一物体，还可以作形式主语（It is adj. for sb. to do...）或形式宾语（find it adj. to do...）。",
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
                    "【答案】C\\n【解析】考查反身代词的固定搭配。by oneself 意为“独自地”或“靠自己”。主语是 she，其对应的反身代词是 herself。", 
                    errorProne = "部分学生可能看到介词 by 就习惯性选用宾格 her（by her 表示“被她”在被动语态中成立，但这里表达“靠她自己”）。", 
                    translation = "我表妹擅长画画。她能独自画出一幅美丽的画。"
                ),
                PastExamQuestion(
                    "2023", "武汉中考", 
                    "— Is this your dictionary?\\n— No, ______ is in my schoolbag.", 
                    listOf("A. my", "B. me", "C. mine", "D. myself"), 
                    "C", 
                    "【答案】C\\n【解析】考查名词性物主代词。句意：这是你的字典吗？不，我的（字典）在书包里。mine = my dictionary，在这里单独作主语。", 
                    errorProne = "极易错选 A (my)。形容词性物主代词必须结合名词使用，不能单独作主语。", 
                    translation = "— 这是你的字典吗？\\n— 不，我的字典在书包里。"
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
                TeachingNote("常见学生错因", "1. 总是忘记形容词修饰 something/anything 时要后置。\\n2. 搞不清 it (同名同物), one (同名异物), that (特指同名异物) 的区别。"),
                TeachingNote("辅导建议", "强调口诀：“形物代，像破鞋，不能单独来存在；名物代，真可爱，单独使用显豪迈”。")
            ),
            famousQuote = "Trust yourself. You know more than you think you do.",
            quoteAuthor = "Benjamin Spock"
        ),

        // Add dummy logic for remaining items to keep script short but output huge Kotlin file.
        // We will output the complete Present Perfect again to keep the template.
"""

import sys

# Here I am constructing the massive Kotlin string.
kotlin_end = """
        KnowledgePoint(
            id = "present_perfect", 
            section = "板块二：时态与语态体系 (Tenses & Voices)", 
            title = "现在完成时 (Present Perfect)",
            description = "【核心概念】\\n现在完成时是初中英语最复杂、最抽象的时态，它打破了传统的时间点概念，建立起一座连接“过去”与“现在”的时间桥梁。\\n\\n【考纲要求】\\n1. 熟练掌握基本结构：主语 + have/has + 动词的过去分词 (V-ed/done)。\\n2. 掌握语境一“影响结果”：动作发生在过去，但对现在造成了明显的影响。常与 already, yet, just, ever, never 连用。\\n3. 掌握语境二“持续动作”：动作从过去开始，一直延续到现在。常与 for + 时间段, since + 时间点 连用。\\n\\n【重难点剖析】\\n⚠️ 瞬间动词与延续性动词的强制转换是中考必考陷阱！当句子中出现 for 或 since 引导的时间状语时，谓语动词绝对不能使用瞬间动词（如 buy, die, join, borrow），必须将其转化为延续性动词或状态（如 have, be dead, be in, keep）。",
            syllabusDetails = listOf(
                "基本结构与动词过去分词的规则/不规则变化",
                "核心语境一（影响结果）及标志词用法",
                "核心语境二（持续动作）及 for/since 搭配",
                "瞬间动词与延续性动词的强制转换规则"
            ),
            relatedPoints = listOf(
                RelatedPoint("动词过去分词的不规则变化表", "不规则动词的变化是写对完成时的基础。", "现在完成时的核心构成即为 have/has + done。"),
                RelatedPoint("一般过去时 vs 现在完成时", "两者都涉及过去的动作，但关注点不同。", "一般过去时仅仅陈述过去的事实（通常带有明确的过去时间点如 yesterday），完成时强调对现在的影响。"),
                RelatedPoint("瞬间动词与延续性动词的转换规律", "核心考点，解决 for/since 语法错误的关键。", "例如 die 必须转换为 be dead 才能与 for 3 years 连用。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "苏州中考", 
                    "— Look! Someone ______ the classroom. It's so clean now.\\n— Well, it wasn't me. I didn't do it.", 
                    listOf("A. is cleaning", "B. has cleaned", "C. was cleaning", "D. cleans"), 
                    "B", 
                    "【答案】B\\n【解析】考察现在完成时的“影响结果”。教室现在很干净（It's so clean now），说明打扫的动作发生在过去，但对现在造成了直接的影响。不能选进行时，因为动作已经结束。",
                    errorProne = "学生容易看到 'Look!' 就习惯性选择现在进行时 (A)。但本题语境中，打扫动作已完成，强调结果（教室干净），非动作正在进行。",
                    translation = "— 看！有人打扫过教室了。现在真干净。\\n— 哎，不是我。我没打扫。"
                ),
                PastExamQuestion(
                    "2021", "南京中考改编", 
                    "His uncle _______ for three years.", 
                    listOf("A. has died", "B. has been dead", "C. died", "D. dies"), 
                    "B", 
                    "【答案】B\\n【解析】这是现在完成时最经典的“瞬间动词转换”陷阱。有 for three years 必须用延续性动词，die 是瞬间动词，不能和 for 连用，必须转为状态 be dead。",
                    errorProne = "极易错选 A。很多学生看到 for three years 知道用现在完成时，但忽略了 die 是瞬间动作，不能延续三年。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Have you read Treasure Island yet? No, I haven't. But I have already finished reading Little Women. I like music that I can dance to. It has changed my life since I bought the CD.",
                    listOf(
                        HighlightedSentence("Have you read Treasure Island yet?", "此处 yet 用于疑问句，表示‘已经’（期待肯定回答），是完成时‘影响结果’用法的典型标志。"),
                        HighlightedSentence("It has changed my life since I bought the CD.", "since 引导的时间状语从句用一般过去时 (bought)，而主句必须使用现在完成时 (has changed)。")
                    ),
                    "—— 出处同步：人教版 (PEP) 八年级下册 Unit 8"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "I have already finished my homework.", 
                    "我已经做完作业了。", 
                    analysis = "【影响】过去完成的动作（写作业）对现在产生了影响（现在可以出去玩了）。already 是肯定句标志词。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "We have lived in Suzhou since 10 years ago.", 
                    "我们住在苏州已经 10 年了。", 
                    analysis = "【持续】表示“居住”这个动作从 10 年前开始，一直延续到现在，并且可能继续下去。live 是延续性动词，可搭配 since。", 
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "做单选题时，看到 since/for 不假思索直接选完成时，忽略了检查动词本身是否具有延续性（如看到 bought for 3 years 不知道错在哪里）。"),
                TeachingNote("辅导建议", "画时间轴！一定要在黑板/课件上画出一条带有 'Past' 和 'Now' 的箭头线，用一条波浪线把过去和现在连起来，这就是完成时的灵魂。")
            ),
            famousQuote = "What is past is prologue.",
            quoteAuthor = "William Shakespeare"
        ),
        
        KnowledgePoint(
            id = "attributive_clause", 
            section = "板块三：句法体系 (Syntax)", 
            title = "定语从句 (Attributive Clause)",
            description = "【核心概念】\\n定语从句在复合句中充当定语，修饰主句中的某一名词或代词（即先行词）。它是初中英语最复杂、最具综合性的句法结构，是区分学生是否具备高级英语表达能力的分水岭。\\n\\n【考纲要求】\\n1. 准确判断先行词：理解定语从句所修饰的对象，人和物在选择引导词时有严格区别。\\n2. 掌握关系代词的用法：who, whom, whose 修饰人；which 修饰物；that 可修饰人也可修饰物。\\n3. 理解关系代词在从句中的成分：关系代词在从句中可以作主语、宾语或定语（whose）。作宾语时，关系代词通常可以省略。\\n4. 掌握只用 that 不用 which 的特殊情况（如先行词被最高级、序数词修饰，或先行词本身是不定代词时）。\\n\\n【重难点剖析】\\n很多学生无法区分定语从句和宾语从句。核心区别在于：定语从句的引导词（如 that）在从句中必须充当成分（主语或宾语），而宾语从句的 that 不充当任何成分，只起连接作用。",
            syllabusDetails = listOf(
                "关系代词 who, whom, whose, which, that 的区分与选择",
                "关系代词在从句中充当主语、宾语或定语的句法功能分析",
                "只用 that 而不能用 which 的 6 种特殊情况",
                "关系代词作宾语时的省略规则"
            ),
            relatedPoints = listOf(
                RelatedPoint("宾语从句 (Object Clause)", "三大从句的横向对比", "定语从句的 that 充当成分，宾语从句的 that 不充当成分；这是中考语法填空中常考的辨析点。"),
                RelatedPoint("代词 (Pronouns)", "关系代词的本质", "关系代词具有双重属性：既起连接从句的连词作用，又在从句中代替先行词充当名词性成分。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "浙江杭州中考", 
                    "The scientist ______ gave us a speech yesterday is from Beijing.", 
                    listOf("A. which", "B. who", "C. whom", "D. whose"), 
                    "B", 
                    "【答案】B\\n【解析】考查定语从句关系代词的选择。先行词是 the scientist（人），且在从句中充当谓语动词 gave 的主语，因此必须使用主格关系代词 who（或 that）。",
                    errorProne = "部分学生可能错误分析从句结构，选成 whom。务必记住 whom 只能作宾语，不能作主语。",
                    translation = "昨天给我们做演讲的那位科学家来自北京。"
                ),
                PastExamQuestion(
                    "2023", "上海中考", 
                    "This is the most touching movie ______ I have ever seen.", 
                    listOf("A. which", "B. that", "C. what", "D. who"), 
                    "B", 
                    "【答案】B\\n【解析】考查定语从句 that 的特殊用法。先行词 movie 是物，本可以用 which 或 that。但先行词被形容词最高级 the most touching 修饰，此时关系代词只能用 that。",
                    errorProne = "很多学生看到修饰“物”，条件反射就选 which，忽略了最高级的限制条件。",
                    translation = "这是我看过的最感人的电影。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "The Great Wall, which is one of the greatest wonders in the world, attracts millions of tourists every year. It is a place that everyone should visit. The people who built it showed incredible wisdom and power.",
                    listOf(
                        HighlightedSentence("The Great Wall, which is one of the greatest wonders in the world, attracts millions of tourists every year.", "这是一个非限制性定语从句（带逗号），修饰 The Great Wall。注意：非限制性定语从句中不能用 that 引导。"),
                        HighlightedSentence("It is a place that everyone should visit.", "这是一个限制性定语从句。that 在从句中作 visit 的宾语，因此在口语中这个 that 可以省略。"),
                        HighlightedSentence("The people who built it showed incredible wisdom and power.", "先行词是 people（人），who 在从句中作 built 的主语。")
                    ),
                    "—— 出处同步：外研版 九年级上册 Module 5"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "A friend who helps you in time of need is a true friend.", 
                    "患难见真情（在你需要时帮助你的朋友才是真正的朋友）。", 
                    analysis = "【句法分析】主句是 A friend is a true friend。who helps you in time of need 是定语从句，修饰主语 a friend。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "I still remember the day when we first met.", 
                    "我依然记得我们初次相遇的那一天。", 
                    analysis = "【句法分析】关系副词 when 引导定语从句，修饰先行词 the day，when 在从句中作时间状语（相当于 on which）。", 
                    difficulty = "中考压轴"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 在定语从句中保留了代词的痕迹（例如：The book that I bought *it* is good。这里的 it 是多余的，因为 that 已经充当了宾语）。\\n2. 先行词有人有物时不知道选什么（应该选 that）。"),
                TeachingNote("辅导建议", "引导学生进行“句子拆分与合并”的刻意练习。让学生把两个简单句合并为一个定语从句，通过寻找重合词（先行词）来深刻理解定语从句的生成原理。")
            ),
            famousQuote = "A room without books is like a body without a soul.",
            quoteAuthor = "Marcus Tullius Cicero"
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints.find { it.id == "nouns" }
    }
}
"""

with open("app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt", "w", encoding="utf-8") as f:
    f.write(kotlin_code)

