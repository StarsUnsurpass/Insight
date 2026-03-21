package com.example.insight.data.model

data class KnowledgePoint(
    val id: String,
    val title: String,
    val description: String,
    val relatedPoints: List<String>,
    val exampleProblems: List<ExampleProblem>,
    val textbookParagraphs: List<TextbookParagraph>,
    val exampleSentences: List<ExampleSentence>
)

data class ExampleProblem(
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String
)

data class TextbookParagraph(
    val content: String,
    val source: String
)

data class ExampleSentence(
    val english: String,
    val chinese: String
)

object KnowledgeProvider {
    private val points = mapOf(
        "0" to KnowledgePoint(
            id = "0",
            title = "定语从句",
            description = "定语从句（Attributive Clause）在复合句中充当定语，修饰名词或代词。被修饰的词叫先行词，引导从句的词叫关系词。关系词分为关系代词（who, whom, whose, which, that, as）和关系副词（when, where, why）。",
            relatedPoints = listOf("关系代词", "关系副词", "限制性定语从句", "非限制性定语从句", "that 与 which 的区别"),
            exampleProblems = listOf(
                ExampleProblem(
                    question = "The boy ______ is talking with my teacher is my brother.",
                    options = listOf("A. which", "B. who", "C. whom", "D. whose"),
                    answer = "B",
                    explanation = "先行词是 The boy (人)，关系词在从句中作主语，故用 who。"
                ),
                ExampleProblem(
                    question = "I'll never forget the day ______ I joined the League.",
                    options = listOf("A. when", "B. which", "C. that", "D. where"),
                    answer = "A",
                    explanation = "先行词是 the day (时间)，关系词在从句中作时间状语，故用 when。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "The Great Wall, which is one of the eight wonders in the world, attracts millions of tourists every year.",
                    source = "—— 摘自《人教版九年级英语》Unit 5"
                ),
                TextbookParagraph(
                    content = "In the town where I was born, everyone knows each other.",
                    source = "—— 摘自《外研版八年级下册》Module 2"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("This is the book that I bought yesterday.", "这就是我昨天买的那本书。"),
                ExampleSentence("He is the person whom you are looking for.", "他就是你要找的那个人。"),
                ExampleSentence("I like the city where I live.", "我喜欢我居住的这个城市。")
            )
        ),
        "1" to KnowledgePoint(
            id = "1",
            title = "虚拟语气",
            description = "虚拟语气（Subjunctive Mood）表示说话人的主观愿望、假设、怀疑、猜测或建议等，而不表示客观存在的事实。常用于 if 引导的条件句，表示与现在、过去或将来事实相反的情况。",
            relatedPoints = listOf("if 条件句", "与现在事实相反", "与过去事实相反", "wish 的用法", "should + 动词原形"),
            exampleProblems = listOf(
                ExampleProblem(
                    question = "If I ______ you, I would take the offer.",
                    options = listOf("A. am", "B. was", "C. were", "D. be"),
                    answer = "C",
                    explanation = "在 if 引导的与现在事实相反的虚拟语气中，be 动词一律用 were。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "If I were a bird, I could fly in the sky.",
                    source = "—— 摘自《人教版高一英语》Unit 1"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I wish I could speak ten languages.", "我希望我能说十种语言。"),
                ExampleSentence("If it had rained yesterday, we would have stayed at home.", "如果昨天下了雨，我们就会待在家里了。")
            )
        ),
        "2" to KnowledgePoint(
            id = "2",
            title = "现在分词",
            description = "现在分词（Present Participle）即动词的-ing形式，在句中可作定语、表语、状语或宾语补足语。它表示主动或正在进行的动作。",
            relatedPoints = listOf("动名词", "过去分词", "伴随状语", "现在分词作定语"),
            exampleProblems = listOf(
                ExampleProblem(
                    question = "The girl ______ by the window is my sister.",
                    options = listOf("A. sit", "B. sits", "C. sitting", "D. sat"),
                    answer = "C",
                    explanation = "sitting by the window 是现在分词短语作定语，修饰 the girl，表示正在进行的动作。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Hearing the news, they jumped with joy.",
                    source = "—— 摘自《人教版初二英语》Unit 8"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I saw him crossing the street.", "我看见他正在穿过马路。"),
                ExampleSentence("The sleeping baby looks so cute.", "那个正在睡觉的小婴儿看起来好可爱。")
            )
        ),
        "3" to KnowledgePoint(
            id = "3",
            title = "宾语从句",
            description = "宾语从句（Object Clause）在复合句中作主语、动词或介词的宾语。引导宾语从句的词包括连词 that（常省略），if/whether，以及连接代词（who, whom, whose, which, what）和连接副词（when, where, why, how）。",
            relatedPoints = listOf("宾语从句的时态一致", "宾语从句的语序", "if 与 whether 的区别", "that 的省略"),
            exampleProblems = listOf(
                ExampleProblem(
                    question = "Could you tell me ______?",
                    options = listOf("A. where does he live", "B. where he lives", "C. he lives where", "D. where is he living"),
                    answer = "B",
                    explanation = "宾语从句必须使用陈述语序，即“主语 + 谓语”的形式。"
                ),
                ExampleProblem(
                    question = "I don't know ______ he will come or not.",
                    options = listOf("A. if", "B. whether", "C. that", "D. when"),
                    answer = "B",
                    explanation = "当从句末尾有 or not 时，通常只能用 whether 引导宾语从句。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "I wonder if you can help me with my English.",
                    source = "—— 摘自《人教版初二下册》Unit 3"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("He said that he would be back soon.", "他说他很快就会回来。"),
                ExampleSentence("Do you know where the post office is?", "你知道邮局在哪儿吗？")
            )
        ),
        "4" to KnowledgePoint(
            id = "4",
            title = "被动语态",
            description = "被动语态（Passive Voice）表示主语是动作的承受者。其基本结构为“be + 动词的过去分词(done)”。时态的变化体现在 be 动词的形式上。",
            relatedPoints = listOf("一般现在时的被动语态", "一般过去时的被动语态", "情态动词的被动语态", "主动变被动"),
            exampleProblems = listOf(
                ExampleProblem(
                    question = "English ______ by many people in the world.",
                    options = listOf("A. speaks", "B. is spoken", "C. spoken", "D. is speaking"),
                    answer = "B",
                    explanation = "English 是动作 speak 的承受者，且表示一般事实，应用一般现在时的被动语态。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "Paper was first created by the Chinese about 2,000 years ago.",
                    source = "—— 摘自《人教版九年级英语》Unit 6"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("The window was broken by Tom.", "窗户是被汤姆打破的。"),
                ExampleSentence("A new library will be built in our school next year.", "明年我们学校将建一座新图书馆。")
            )
        ),
        "5" to KnowledgePoint(
            id = "5",
            title = "情态动词",
            description = "情态动词（Modal Verbs）表示说话人的语气或情态。常见的情态动词有 can, could, may, might, must, shall, should, will, would, need 等。它们本身有一定的词义，但不能独立作谓语，必须与动词原形一起构成谓语。",
            relatedPoints = listOf("must 与 have to 的区别", "can 与 be able to 的区别", "may 表示推测", "should 表示建议"),
            exampleProblems = listOf(
                ExampleProblem(
                    question = "Must I finish my homework now? — No, you ______.",
                    options = listOf("A. mustn't", "B. can't", "C. needn't", "D. shouldn't"),
                    answer = "C",
                    explanation = "对于 must 开头的疑问句，否定回答通常用 needn't 或 don't have to，表示“不必”。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "You should brush your teeth twice a day.",
                    source = "—— 摘自《人教版初一英语》Unit 2"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("Can you play the guitar?", "你会弹吉他吗？"),
                ExampleSentence("You must be careful when you cross the road.", "过马路时你必须小心。")
            )
        ),
        "6" to KnowledgePoint(
            id = "6",
            title = "形容词比较级与最高级",
            description = "形容词和副词有三个等级：原级、比较级和最高级。比较级用于两者之间的比较，通常后接 than；最高级用于三者或三者以上之间的比较，通常前加 the，后接表示范围的短语。",
            relatedPoints = listOf("比较级的规则变化", "比较级的不规则变化", "as...as... 结构", "the + 比较级, the + 比较级"),
            exampleProblems = listOf(
                ExampleProblem(
                    question = "He is ______ than any other student in his class.",
                    options = listOf("A. tall", "B. taller", "C. tallest", "D. the tallest"),
                    answer = "B",
                    explanation = "than 是比较级的标志词，故用 taller。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    content = "The Yellow River is the second longest river in China.",
                    source = "—— 摘自《人教版八年级英语》Unit 7"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("Beijing is much larger than my hometown.", "北京比我的家乡大得多。"),
                ExampleSentence("This is the most interesting book I've ever read.", "这是我读过的最有趣的一本书。")
            )
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        // Handle "search_x" as well by mapping to available real IDs
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return points[cleanId] ?: points["0"] // Default to "0" (定语从句) if not found
    }
}
