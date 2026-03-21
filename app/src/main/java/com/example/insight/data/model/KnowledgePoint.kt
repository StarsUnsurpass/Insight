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
    const val SEC_1 = "板块一：词法体系 (Morphology)"
    const val SEC_2 = "板块二：时态与语态体系 (Tenses & Voices)"
    const val SEC_3 = "板块三：句法体系 (Syntax)"

    val allPoints = listOf(
        // ================= 板块一：词法体系 (Morphology) =================
        KnowledgePoint(
            id = "nouns", section = SEC_1, title = "名词 (Nouns)",
            description = """【核心概念】
名词 (Nouns) 是语言中最为基础且体量最大的词类，用于指代人、物、地点、行为、品质或抽象概念。在初中英语语法体系中，名词不仅是构建句子的基本原材料，更是理解“数”（单复数）、“格”（所有格）以及“限定”（冠词搭配）的核心枢纽。掌握名词，即掌握了英语句子结构的一半。

【考纲要求】
1. **名词的分类与判定**：准确区分可数名词（Countable Nouns）与不可数名词（Uncountable Nouns）。特别要熟练掌握那些在汉语中可数但在英语中不可数的词汇，如 advice, information, news, progress, weather, furniture 等。
2. **名词的数 (Plural Forms)**：规则变化（-s/-es）与不规则变化（child-children, sheep-sheep）。
3. **名词所有格 (Possessive Case)**：'s 所有格、of 所有格及双重所有格。
4. **名词作定语**：理解名词修饰名词的用法（man/woman的特例）。""",
            syllabusDetails = listOf("可数/不可数区分", "不规则复数变化", "所有格用法", "名词作定语"),
            relatedPoints = listOf(
                RelatedPoint("冠词 (Articles)", "名词前通常需要冠词来限定。", "名词的可数性与单复数直接决定了不定冠词 a/an 的使用。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "北京中考", "There is some ______ about the upcoming sports meeting on the notice board.", 
                    listOf("A. message", "B. messages", "C. information", "D. informations"), "C", 
                    "【答案】C\n【解析】information（信息）是典型的不可数名词，没有复数形式，排除D。", 
                    errorProne = "极易错选 A 或 B。受汉语思维影响，学生常认为“消息”是可数的。", 
                    translation = "布告栏上有一些关于即将到来的运动会的信息。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "In our school, there are many different clubs. The teachers always give us helpful advice on how to balance our studies and hobbies.", 
                    listOf(HighlightedSentence("The teachers always give us helpful advice", "advice 是核心不可数名词，不能加 -s。")), 
                    "人教版八上 Unit 2"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "Could you give me some advice on how to learn English well?", 
                    "你能给我一些关于如何学好英语的建议吗？", 
                    analysis = "【核心考点】advice 为不可数名词，不能说 an advice 或 advices。", 
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(TeachingNote("常见错因", "受母语负迁移影响，把 advice, news 当作可数名词。")),
            famousQuote = "A good name is better than riches.",
            quoteAuthor = "Cervantes"
        ),
        
        KnowledgePoint(
            id = "pronouns", section = SEC_1, title = "代词 (Pronouns)",
            description = """【核心概念】
代词 (Pronouns) 是用于替代名词或名词短语的词类。它的核心功能是避免重复，使语言表达更加简洁。

【考纲要求】
1. 人称代词：主格与宾格。
2. 物主代词：形容词性与名词性。
3. 反身代词：-self 结构及其搭配。
4. 不定代词：some/any, few/little, many/much 以及复合不定代词。""",
            syllabusDetails = listOf("人称代词主宾格", "物主代词区分", "反身代词用法", "复合不定代词"),
            relatedPoints = listOf(RelatedPoint("形容词", "定语后置原则。", "修饰复合不定代词需后置。")),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "天津中考", "She can draw a beautiful picture by ______.", 
                    listOf("A. she", "B. her", "C. herself", "D. hers"), "C", 
                    "【答案】C\n【解析】本题考查反身代词。by oneself 意为“独自地”或“靠自己”。", 
                    errorProne = "误选宾格 her。", 
                    translation = "她能独自画出一幅美丽的画。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Everyone in our class is preparing for the art festival. There is nothing impossible if we put our hearts into it.", 
                    listOf(HighlightedSentence("There is nothing impossible", "nothing 是复合不定代词，修饰它的形容词 impossible 必须置于其后。")), 
                    "人教版七下 Unit 1"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "If you have anything important to tell me, please call me at once.", 
                    "如果你有重要的事情要告诉我，请立刻给我打电话。", 
                    analysis = "【核心考点】important 修饰复合不定代词需后置。", 
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(TeachingNote("技巧", "名物代单独显豪迈。")),
            famousQuote = "Trust yourself.",
            quoteAuthor = "Spock"
        ),

        KnowledgePoint(
            id = "articles", section = SEC_1, title = "冠词 (Articles)",
            description = """【核心概念】
冠词是置于名词前说明指代对象的虚词。

【考纲要求】
1. 不定冠词 a/an：音素区分。
2. 定冠词 the：特指用法。
3. 零冠词的情况。""",
            syllabusDetails = listOf("a/an 区别", "the 特指用法", "零冠词搭配"),
            relatedPoints = listOf(RelatedPoint("名词", "依附于名词。", "名词属性决定冠词。")),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "广东中考", "It is ______ useful book.", 
                    listOf("A. a", "B. an", "C. the", "D. /"), "A", 
                    "【答案】A\n【解析】useful 以辅音音素 [j] 开头，故用 a。", 
                    errorProne = "看字母不看音素误选 an。", 
                    translation = "这是一本有用的书。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("The sun rises in the east.", listOf(HighlightedSentence("The sun", "独一无二事物加 the。")), "科普版")
            ),
            exampleSentences = listOf(
                ExampleSentence("He is an honest boy.", "他是诚实的孩子。", analysis = "honest 元音开头用 an。", difficulty = "中考核心")
            ),
            teachingNotes = listOf(TeachingNote("口诀", "乐器前加the, 球类前不加。")),
            famousQuote = "A single step begins the journey.",
            quoteAuthor = "Lao Tzu"
        ),

        KnowledgePoint(id="numerals", section=SEC_1, title="数词 (Numerals)", description="基数词与序数词。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="adj_adv", section=SEC_1, title="形容词与副词 (Adj & Adv)", description="修饰词。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="prepositions", section=SEC_1, title="介词 (Prepositions)", description="连接词。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="conjunctions", section=SEC_1, title="连词 (Conjunctions)", description="连接词。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="verbs_basic", section=SEC_1, title="动词基础 (Verbs)", description="基础动词。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        
        KnowledgePoint(id="simple_present", section=SEC_2, title="一般现在时 (Simple Present)", description="经常动作。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="simple_past", section=SEC_2, title="一般过去时 (Simple Past)", description="过去动作。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="simple_future", section=SEC_2, title="一般将来时 (Simple Future)", description="将来动作。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="present_continuous", section=SEC_2, title="现在进行时 (Present Continuous)", description="正在动作。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="past_continuous", section=SEC_2, title="过去进行时 (Past Continuous)", description="过去进行。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        
        KnowledgePoint(
            id = "present_perfect", section = SEC_2, title = "现在完成时 (Present Perfect)",
            description = """【核心概念】
现在完成时 (Present Perfect) 是连接“过去”与“现在”的桥梁。它主要用于表示过去发生的动作对现在产生的影响或结果，或者表示动作从过去开始一直持续到现在且可能继续。

【考纲要求】
1. **基本结构**：主语 + have / has + 过去分词 (Past Participle)。
2. **两大核心用法**：
   - **影响性用法**：动作发生在过去，强调对现在产生的影响。
   - **持续性用法**：动作从过去开始持续到现在。常与 for + 时间段, since + 时间点连用。
3. **重点句型转换**：对 for/since 提问使用 How long。
4. **延续性动词与非延续性动词的转换**：中考核心考点。""",
            syllabusDetails = listOf("基本结构构成", "already/yet 用法", "for/since 搭配", "延续性动词转换"),
            relatedPoints = listOf(RelatedPoint("一般过去时", "时态辨析。", "一个强调点，一个强调影响。")),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "苏州中考", "— Look! Someone ______ the classroom. It's so clean now.\n— Well, it wasn't me.", 
                    listOf("A. is cleaning", "B. has cleaned", "C. was cleaning", "D. cleans"), "B", 
                    "【答案】B\n【解析】考察现在完成时的“影响结果”。教室现在很干净，说明打扫的动作发生在过去，但对现在造成了影响。", 
                    errorProne = "误选进行时", translation = "看！有人打扫过教室了。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Have you read Treasure Island yet? No, I haven't. But I have already finished reading Little Women.", 
                    listOf(HighlightedSentence("Have you read Treasure Island yet?", "此处 yet 用于疑问句。"), HighlightedSentence("I have already finished reading Little Women.", "此处 already 用于肯定句。")), 
                    "人教版八下 Unit 8"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence("I have already finished my homework.", "我已经做完作业了。", analysis = "影响用法。", difficulty = "中考核心")
            ),
            teachingNotes = listOf(TeachingNote("技巧", "画时间轴展示桥梁感。")),
            famousQuote = "What is past is prologue.",
            quoteAuthor = "Shakespeare"
        ),

        KnowledgePoint(id="past_perfect", section=SEC_2, title="过去完成时 (Past Perfect)", description="过去的过去。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="past_future", section=SEC_2, title="过去将来时 (Past Future)", description="过去看将来。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="passive_voice", section=SEC_2, title="被动语态 (Passive Voice)", description="承受者。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="non_finite_verbs", section=SEC_2, title="非谓语动词 (Non-finite Verbs)", description="非谓语。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        
        KnowledgePoint(id="sentence_types", section=SEC_3, title="句子种类", description="功能分类。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="five_basic_patterns", section=SEC_3, title="简单句基本句型", description="基本结构。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="object_clause", section=SEC_3, title="宾语从句 (Object Clause)", description="作宾语。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="adverbial_clause", section=SEC_3, title="状语从句 (Adverbial Clause)", description="修饰谓语。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="attributive_clause", section=SEC_3, title="定语从句 (Attributive Clause)", description="修饰名词。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor=""),
        KnowledgePoint(id="special_patterns", section=SEC_3, title="特殊句式", description="It/There be等。", syllabusDetails=listOf(), relatedPoints=listOf(), exampleProblems=listOf(), pastExamQuestions=listOf(), textbookParagraphs=listOf(), exampleSentences=listOf(), famousQuote="", quoteAuthor="")
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        val point = allPoints.find { it.id == cleanId }
        
        // Demo mode fallback: if point is mostly empty, return present_perfect
        if (point != null && point.pastExamQuestions.isEmpty() && point.textbookParagraphs.isEmpty()) {
            return allPoints.find { it.id == "present_perfect" }
        }
        
        return point ?: allPoints.find { it.id == "nouns" }
    }
}
