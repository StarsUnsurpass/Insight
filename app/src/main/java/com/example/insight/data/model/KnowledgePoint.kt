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
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        // Handle "search_x" as well by mapping to available real IDs
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return points[cleanId] ?: points["0"] // Default to "0" (定语从句) if not found
    }
}
