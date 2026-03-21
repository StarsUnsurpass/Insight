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
            description = """【核心概念】
名词 (Nouns) 是语言中最为基础且体量最大的词类，用于指代人、物、地点、行为、品质或抽象概念。在初中英语语法体系中，名词不仅是构建句子的基本原材料，更是理解“数”（单复数）、“格”（所有格）以及“限定”（冠词搭配）的核心枢纽。掌握名词，即掌握了英语句子结构的一半。

【考纲要求】
1. **名词的分类与判定**：准确区分可数名词（Countable Nouns）与不可数名词（Uncountable Nouns）。特别要熟练掌握那些在汉语中可数但在英语中不可数的词汇，如 advice, information, news, progress, weather, furniture 等。
2. **名词的数 (Plural Forms)**：
   - 规则变化：直加 -s，以 s, x, ch, sh 结尾加 -es，以“辅音字母 + y”结尾变 y 为 i 加 -es，以 f/fe 结尾变 f/fe 为 v 加 -es（个别例外如 roofs, beliefs）。
   - 不规则变化：元音发生变化（foot-teeth, mouse-mice），单复同形（sheep, deer, Chinese），以及词尾特殊变化（child-children, ox-oxen）。
3. **名词所有格 (Possessive Case)**：
   - 's 所有格：表示有生命的东西，注意以 s 结尾的复数名词只加 '。
   - of 所有格：表示无生命的东西，如 the window of the room。
   - 双重所有格：a friend of my father's。
4. **名词作定语**：理解名词修饰名词的用法，掌握 man/woman 作定语时需随被修饰词同步变复数的特殊规则（men doctors vs. apple trees）。

【重难点剖析】
1. **主谓一致的陷阱**：集体名词（family, class, team）既可看作整体（谓语用单数），也可看作其中的成员（谓语用复数），需结合语境判断。
2. **抽象名词具体化**：一些抽象名词（如 success, failure, pleasure, surprise）在表示具体的人或事时可变为可数名词，如 "a great success"（一件成功的事）。
3. **单位词的使用**：熟练运用“数词 + 量词 + of + 不可数名词”结构，如 three bottles of water, two pieces of paper。""",
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
                    "【答案】C\n【解析】本题考查不可数名词的用法。information（信息）是典型的不可数名词，没有复数形式，排除D。some 既可以修饰可数名词复数也可以修饰不可数名词，A项 message 为可数名词单数，若选 A 需改为 a message 或 some messages。故选C。", 
                    errorProne = "极易错选 A 或 B。受汉语思维影响，学生常认为“消息”是可数的。务必牢记 information, advice, news, weather 是中考四大核心不可数名词。", 
                    translation = "布告栏上有一些关于即将到来的运动会的信息。"
                ),
                PastExamQuestion(
                    "2023", "上海中考", 
                    "The ______ of the twins are both doctors in this hospital.", 
                    listOf("A. father", "B. mother", "C. parents", "D. parent"), 
                    "C", 
                    "【答案】C\n【解析】本题考查名词的数与上下文的一致性。由句中的 twins（双胞胎）以及谓语动词 are、表语 doctors 可知，主语必须是复数概念。A、B、D 均为单数，只有 parents 为复数形式。故选C。",
                    errorProne = "若只看局部（twins），容易忽略后面的 are 和 doctors，从而错选单数形式。做题时应具备全局意识。",
                    translation = "这对双胞胎的父母都是这家医院的医生。"
                ),
                PastExamQuestion(
                    "2023", "江苏苏州中考",
                    "We can get much ______ about the history of Suzhou from this museum.",
                    listOf("A. ideas", "B. knowledge", "C. stories", "D. pictures"),
                    "B",
                    "【答案】B\n【解析】本题考查不可数名词的辨析。much 用于修饰不可数名词。A、C、D 均为可数名词复数形式，只有 knowledge（知识）是不可数名词。故选B。",
                    errorProne = "混淆 many 和 much 的用法。many 修饰可数名词复数，much 修饰不可数名词。",
                    translation = "我们可以从这家博物馆获得很多关于苏州历史的知识。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "In our school, students have many different kinds of activities after class. Some join the music club to practice playing instruments, while others spend a lot of time in the library reading different kinds of books. Every student can find their own interests and make many new friends here. The teachers always give us helpful advice on how to balance our studies and hobbies.",
                    listOf(
                        HighlightedSentence("Some join the music club to practice playing instruments", "instruments 是 instrument 的规则复数形式。在英语中，泛指一类事物时，可数名词通常使用复数形式。"),
                        HighlightedSentence("The teachers always give us helpful advice on how to balance our studies and hobbies.", "advice 是核心不可数名词，即使前面有 helpful 修饰，也不能加 -s。这是中考最高频的陷阱之一。")
                    ),
                    "—— 出处参考：人教版 (PEP) 八年级上册 Unit 2"
                ),
                TextbookParagraph(
                    "Last summer, my family went to Qingdao for a vacation. We saw the beautiful scenery and enjoyed the fresh air there. We stayed in a small hotel near the sea. The owner of the hotel was very friendly and provided us with delicious seafood. It was a wonderful experience for all of us, and we took many photos to remember those happy moments.",
                    listOf(
                        HighlightedSentence("The owner of the hotel was very friendly", "此处使用了 of 所有格结构。hotel 是无生命名词，通常使用 of 来表示所属关系。"),
                        HighlightedSentence("we took many photos to remember those happy moments.", "photo 的复数形式是 photos，属于以 o 结尾直接加 s 的特殊情况（常考的还有 pianos, radios, zoos）。")
                    ),
                    "—— 出处参考：外研版 (FLTRP) 八年级下册 Module 1"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "Could you give me some advice on how to learn English well?", 
                    "你能给我一些关于如何学好英语的建议吗？", 
                    analysis = "【核心考点】advice 为不可数名词，不能说 an advice 或 advices。some 可以修饰不可数名词。on 介词表示“关于……”。", 
                    difficulty = "中考高频"
                ),
                ExampleSentence(
                    "Two months' holiday is too short for these tired students who have just finished their exams.", 
                    "两个月的假期对于这些疲惫的学生来说太短了。", 
                    analysis = "【核心考点】1. 名词所有格：以 s 结尾的复数名词 months 的所有格直接加 '。2. 主谓一致：表示时间、距离、金额的名词短语作主语时，通常视作整体，谓语动词用单数 is。", 
                    difficulty = "中考压轴"
                ),
                ExampleSentence(
                    "The number of girls in our class is forty, and a number of them are good at singing.",
                    "我们班女生的数量是40人，其中有许多人擅长唱歌。",
                    analysis = "【核心考点】the number of 表示“……的数量”，谓语动词用单数 is；a number of 表示“许多”，修饰可数名词复数，谓语动词用复数 are。",
                    difficulty = "中考核心"
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
            description = """【核心概念】
代词 (Pronouns) 是用于替代名词或名词短语的词类。它的核心功能是避免重复，使语言表达更加简洁、流畅。在英语中，代词不仅具有指代功能，还承载着人称、数、格（主格/宾格/所有格）以及限定等丰富的语法信息。

【考纲要求】
1. **人称代词 (Personal Pronouns)**：熟练掌握主格（作主语）和宾格（作宾语、表语）的变换。注意人称排列顺序（单数：二、三、一；复数：一、二、三；承担责任时：第一人称在前）。
2. **物主代词 (Possessive Pronouns)**：
   - 形容词性物主代词：相当于形容词，后必须接名词（my book）。
   - 名词性物主代词：相当于“形容词性物主代词 + 名词”，可单独作主语、宾语或表语（This book is mine）。
3. **反身代词 (Reflexive Pronouns)**：掌握 -self/-selves 结尾的形式，及其在 enjoy oneself, help oneself to, by oneself, learn... by oneself 等短语中的用法。
4. **指示代词 (Demonstrative Pronouns)**：区分 this/that (单数) 与 these/those (复数)，及其在电话用语中的特殊用法（This is... Who's that?）。
5. **不定代词 (Indefinite Pronouns)**：中考重点！
   - some vs. any (肯定句 vs. 疑问/否定句/期待肯定回答的建议句)。
   - few/a few vs. little/a little (可数 vs. 不可数；否定意义 vs. 肯定意义)。
   - many/much, each/every, both/all/neither/none 的区别。
   - 复合不定代词 (something, anybody, nothing 等) 的定语后置原则及谓语单数原则。

【重难点剖析】
1. **it, one, that 的指代辨析**：
   - it：指代上文提到的“同一事物”。
   - one：指代上文提到的“同类但不同一”的可数名词单数。
   - that：常用于特指“同类但不同一”的事物，多用于比较结构中。
2. **复合不定代词的修饰语位置**：形容词修饰复合不定代词时，必须放在代词后面（something interesting）。
3. **it 的形式语法功能**：掌握 it 作形式主语和形式宾语的高阶用法。""",
            syllabusDetails = listOf(
                "人称代词的主格与宾格及其排列顺序", 
                "形容词性与名词性物主代词的相互转换", 
                "反身代词的固定短语搭配", 
                "复合不定代词的定语后置与主谓一致"
            ),
            relatedPoints = listOf(
                RelatedPoint("形容词与副词", "复合不定代词的修饰规则", "当形容词修饰 something, anything 等复合不定代词时，形容词必须放在其后面（即定语后置），如 something important。"),
                RelatedPoint("It 特殊句型", "it 作为形式主语与形式宾语", "在句法体系中，it 的存在使得句子结构避免“头重脚轻”。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "天津中考", 
                    "My cousin is good at drawing. She can draw a beautiful picture by ______.", 
                    listOf("A. she", "B. her", "C. herself", "D. hers"), 
                    "C", 
                    "【答案】C\n【解析】本题考查反身代词。句中 by 为介词，by oneself 意为“独自地”或“靠自己”。主语是 My cousin (she)，对应的反身代词是 herself。故选C。", 
                    errorProne = "混淆宾格与反身代词。虽然 by 后常接宾格，但表达“独自”这一含义时必须使用反身代词短语。", 
                    translation = "我表妹擅长画画。她能独自画出一幅美丽的画。"
                ),
                PastExamQuestion(
                    "2023", "武汉中考", 
                    "— Is this your dictionary?\n— No, ______ is in my schoolbag.", 
                    listOf("A. my", "B. me", "C. mine", "D. myself"), 
                    "C", 
                    "【答案】C\n【解析】本题考查名词性物主代词。句意：——这是你的字典吗？——不，我的在书包里。这里需要一个词来指代“我的字典”，名词性物主代词 mine 相当于 my dictionary，可单独作主语。故选C。", 
                    errorProne = "极易错选 A (my)。形容词性物主代词 my 后面必须跟名词，不能单独作主语。", 
                    translation = "— 这是你的字典吗？\n— 不，我的字典在书包里。"
                ),
                PastExamQuestion(
                    "2023", "安徽中考",
                    "I have two sisters. One is a teacher, and ______ is a doctor.",
                    listOf("A. other", "B. another", "C. the other", "D. others"),
                    "C",
                    "【答案】C\n【解析】本题考查不定代词。one... the other... 意为“（两者中的）一个……，另一个……”。文中明确提到有 two sisters，故指代剩下的那一个用 the other。故选C。",
                    errorProne = "混淆 the other 与 another。another 用于三者或三者以上中的“另一个”；the other 用于两者中的“另一个”。",
                    translation = "我有两个姐姐。一个是老师，另一个是医生。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Everyone in our class is preparing for the art festival. Some are practicing dancing, while others are making colorful clothes by themselves. There is nothing impossible if we put our hearts into it. We believe that we can make the festival a great success through our own efforts. Nobody wants to be left behind.",
                    listOf(
                        HighlightedSentence("Some are practicing dancing, while others are making colorful clothes by themselves.", "some... others... 表示“一些人……，另一些人……（并非全部）”。by themselves 强调“独自、亲自”。"),
                        HighlightedSentence("There is nothing impossible if we put our hearts into it.", "nothing 是复合不定代词，修饰它的形容词 impossible 必须置于其后，这种结构是中考的高频考点。")
                    ),
                    "—— 出处参考：人教版 (PEP) 七年级下册 Unit 1"
                ),
                TextbookParagraph(
                    "I have many hobbies, and reading is my favorite one. I find it very interesting to read stories from different countries. It helps me learn a lot about their cultures. My parents always encourage me to share my stories with them. They say that sharing can bring us more happiness than keeping them to ourselves.",
                    listOf(
                        HighlightedSentence("I find it very interesting to read stories from different countries.", "it 在这里作形式宾语，真正的宾语是后面的不定式短语 to read stories...。这是代词的高阶用法。"),
                        HighlightedSentence("sharing can bring us more happiness than keeping them to ourselves.", "ourselves 是反身代词，在这里作介词 to 的宾语，对应主格 we/us。")
                    ),
                    "—— 出处参考：外研版 (FLTRP) 八年级上册 Module 2"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "If you have anything important to tell me, please call me at once.", 
                    "如果你有重要的事情要告诉我，请立刻给我打电话。", 
                    analysis = "【核心考点】1. anything 为复合不定代词，常用于 if 引导的条件从句中；2. 形容词 important 修饰复合不定代词需后置。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "It's very kind of you to help me with my English studies during the summer holiday.", 
                    "你暑假期间帮我学习英语真是太好了。", 
                    analysis = "【核心考点】1. it 作形式主语，指代后文的 to help...；2. kind 为描述性格品质的形容词，介词用 of 而非 for。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "The population of China is much larger than that of the United States.",
                    "中国的人口比美国的人口多得多。",
                    analysis = "【核心考点】代词 that 的指代功能。that 在此指代 population，避免重复。在比较结构中，常用 that 指代不可数名词或单数名词，用 those 指代复数名词。",
                    difficulty = "中考压轴"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 总是忘记形容词修饰 something/anything 时要后置。\n2. 搞不清 it (同名同物), one (同名异物), that (特指同名异物) 的区别。"),
                TeachingNote("辅导建议", "强调口诀：“形物代，像破鞋，不能单独来存在；名物代，真可爱，单独使用显豪迈”。")
            ),
            famousQuote = "Trust yourself. You know more than you think you do.",
            quoteAuthor = "Benjamin Spock"
        ),

        KnowledgePoint(
            id = "present_perfect", section = "板块二：时态语态 (Tenses & Voices)", title = "现在完成时 (Present Perfect)",
            description = """【核心概念】
现在完成时 (Present Perfect) 是连接“过去”与“现在”的桥梁。它主要用于表示过去发生的动作对现在产生的影响或结果，或者表示动作从过去开始一直持续到现在且可能继续。它是初中英语中最具迷惑性且逻辑性最强的时态。

【考纲要求】
1. **基本结构**：主语 + have/has + 过去分词 (Past Participle)。熟练掌握规则动词与不规则动词的过去分词形式。
2. **两大核心用法**：
   - **影响性用法**：动作发生在过去，强调对现在产生的影响。常与 already, yet, just, before, ever, never 等连用。
   - **持续性用法**：动作从过去开始持续到现在。常与 for + 时间段, since + 时间点/从句连用。
3. **重点句型转换**：
   - 肯定句变否定句：在 have/has 后加 not。
   - 肯定句变疑问句：将 have/has 提前。
   - 对 for/since 提问：使用 How long。
4. **延续性动词与非延续性动词的转换**：这是中考核心考点。在 for/since 结构中，必须将非延续性动词（如 borrow, die, buy, join）转换为对应的状态或延续性动词（如 keep, be dead, have, be in/be a member of）。

【重难点剖析】
1. **have been to vs. have gone to vs. have been in**：
   - have been to: 去过某地（已回来）。
   - have gone to: 去了某地（还没回来）。
   - have been in: 呆在某地（强调持续了一段时间）。
2. **现在完成时 vs. 一般过去时**：一般过去时仅强调过去发生的事，与现在无关；现在完成时则强调与现在的联系。
3. **since 引导的时间从句**：since 引导的从句通常用一般过去时，主句用现在完成时。""",
            syllabusDetails = listOf(
                "现在完成时的构成及其助动词 have/has 的用法", 
                "already, yet, ever, never 在完成时中的位置与意义", 
                "for 与 since 在持续性用法中的区别与转换",
                "延续性动词与瞬间动词的考点深度解析"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般过去时 (Simple Past)", "动作时间属性的差异", "一般过去时表示过去某个特定时间的动作，而现在完成时强调过去动作对现在的影响。"),
                RelatedPoint("过去分词 (Past Participle)", "构成完成时的核心零件", "必须熟记不规则动词表，如 go-went-gone, write-wrote-written。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "四川成都中考", 
                    "— Have you ever seen the film 'Successor'?\n— Yes, I ______ it with my parents last weekend.", 
                    listOf("A. see", "B. have seen", "C. saw", "D. will see"), 
                    "C", 
                    "【答案】C\n【解析】本题考查时态辨析。虽然问句使用的是现在完成时（Have you ever seen...?），但答句中明确给出了过去时间状语 last weekend，表示动作发生在过去特定的时间点。因此，答句应使用一般过去时。故选C。", 
                    errorProne = "极易错选 B。学生往往看到问句的时态，就下意识地在答句中也使用相同的时态，而忽略了具体的时间状语。", 
                    translation = "— 你看过电影《抓娃娃》吗？\n— 看过，上周末我和父母一起看的。"
                ),
                PastExamQuestion(
                    "2023", "湖北武汉中考", 
                    "Great changes ______ in my hometown since the new bridge was built.", 
                    listOf("A. take place", "B. took place", "C. have taken place", "D. will take place"), 
                    "C", 
                    "【答案】C\n【解析】本题考查现在完成时。since 引导的时间状语从句（since the new bridge was built）是现在完成时的标志词，表示动作从过去持续到现在。主语 changes 为复数，故用 have taken place。故选C。", 
                    errorProne = "错选 B。部分学生只看到 since 从句中的 built，误认为整句都要用过去时。牢记：since 后面接过去时，主句通常用现在完成时。", 
                    translation = "自从那座新桥建成以来，我的家乡发生了巨大的变化。"
                ),
                PastExamQuestion(
                    "2023", "山东青岛中考",
                    "I ______ the library book for two weeks. I must return it tomorrow.",
                    listOf("A. have borrowed", "B. have kept", "C. borrowed", "D. kept"),
                    "B",
                    "【答案】B\n【解析】本题考查延续性动词。句中 for two weeks 是时间段，谓语动词必须使用延续性动词。borrow 是瞬间动作（非延续性动词），不能与时间段连用，需改为 keep。故选B。",
                    errorProne = "错选 A。受汉语思维“我借了这本书两周”影响，容易直接套用 borrow 的完成时，忽略了它的瞬间性属性。",
                    translation = "这本书我已经借了两周了。我明天必须归还。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "I have already finished my homework, so I can go out to play soccer with you. My brother has also finished his, but he hasn't cleaned his room yet. Our mother said that we can't leave the house until everything is tidy. We have been busy all morning, but we feel very happy because we have done a good job.",
                    listOf(
                        HighlightedSentence("I have already finished my homework, so I can go out to play soccer with you.", "already 常用于肯定句中，置于 have/has 之后，表示动作已经完成。"),
                        HighlightedSentence("but he hasn't cleaned his room yet.", "yet 常用于否定句和疑问句的句末，表示“还（未）”或“已经（了吗）”。")
                    ),
                    "—— 出处参考：人教版 (PEP) 八年级下册 Unit 1"
                ),
                TextbookParagraph(
                    "Tony has lived in this city for ten years. He has made many friends here and he has learned a lot about the local culture. He has been to many famous places like the Great Wall and the Summer Palace. He says that he has never seen such a beautiful city before and he has fallen in love with it.",
                    listOf(
                        HighlightedSentence("Tony has lived in this city for ten years.", "live 是延续性动词，可以与 for + 时间段连用，表示动作的持续。"),
                        HighlightedSentence("He has been to many famous places like the Great Wall and the Summer Palace.", "have been to 表示“去过某地且已经回来”，强调的是经历。")
                    ),
                    "—— 出处参考：外研版 (FLTRP) 九年级上册 Module 3"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "How long have you been a member of the school swimming club?", 
                    "你加入学校游泳俱乐部多久了？", 
                    analysis = "【核心考点】1. 对 for/since 时间状语提问用 How long；2. join 是非延续性动词，在完成时中与时间段连用需改为 be a member of 或 be in。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "My father has gone to Shanghai on business, and he will be back in three days.", 
                    "我父亲去上海出差了，他三天后回来。", 
                    analysis = "【核心考点】have gone to 表示“去了某地还没回来”。根据后文 will be back 可知，人还在上海。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "It is three years since he joined the army, and he has become a brave soldier.",
                    "自从他参军以来已经三年了，他已经变成了一名勇敢的士兵。",
                    analysis = "【核心考点】1. 固定句型：It is + 时间段 + since + 一般过去时从句 = 时间段 + has passed since...；2. become 的过去分词仍为 become。",
                    difficulty = "中考压轴"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 混淆 have been to 和 have gone to。\n2. 忘记在 for/since 句型中将瞬间动词改为延续性动词。"),
                TeachingNote("辅导建议", "总结常用动词转换表：buy -> have, borrow -> keep, die -> be dead, join -> be in/be a member of, come/go -> be, start/begin -> be on。")
            ),
            famousQuote = "I have a dream that one day this nation will rise up and live out the true meaning of its creed.",
            quoteAuthor = "Martin Luther King Jr."
        ),

        KnowledgePoint(
            id = "attributive_clause", 
            section = "板块三：句法体系 (Syntax)", 
            title = "定语从句 (Attributive Clause)",
            description = """【核心概念】
定语从句（Attributive Clause）在复合句中充当定语的角色，其本质功能是为一个名词或代词（即“先行词”）提供额外的修饰、限制或补充说明。它就像是英语句法中的“加长版形容词”，是连接初级英语与高级表达的重要纽带。在定语从句中，引导词（关系代词或关系副词）不仅起连接主从句的作用，还在从句中充当特定的成分，这是它与宾语从句最本质的区别。

【考纲要求】
1. **先行词的识别**：能够准确找出从句所修饰的名词或代词，这是选择正确关系词的前提。
2. **关系代词的精准选用**：
   - 指人：who（主格/宾格）, whom（宾格）, that（主格/宾格）, whose（定语）。
   - 指物：which（主格/宾格）, that（主格/宾格）, whose（定语，常表示“……的”）。
3. **关系代词作宾语的省略**：在限制性定语从句中，当关系代词充当从句的宾语时，可以省略，但在非限制性定语从句中不可省略。
4. **只用 that 的特殊情境**：掌握当先行词被形容词最高级、序数词修饰，或先行词为不定代词（something, anything等），或先行词既有人又有物时，必须使用 that 的规则。
5. **非限制性定语从句**：理解由逗号隔开的非限制性定语从句，重点掌握 which 引导的非限制性定语从句。

【重难点剖析】
1. **关系词在从句中的成分分析**：很多学生分不清 when/where 和 which/that。核心技巧在于看从句谓语动词。如果谓语动词是及物动词且缺宾语，必须选代词（which/that）；如果从句结构完整，则选副词（when/where/why）。
2. **定语从句与宾语从句的混淆**：判断标准：如果引导词 that 可以在从句中充当成分（主语或宾语），则为定语从句；如果 that 仅起连接作用且不充当成分，则为宾语从句。""",
            syllabusDetails = listOf(
                "先行词（人/物/特殊情况）的识别与关系词匹配",
                "关系代词 who, whom, whose, which, that 的句法功能",
                "关系副词 when, where, why 的引导条件与应用场景",
                "只用 that 而不用 which 的 6 种典型中考语法情境",
                "限制性与非限制性定语从句的区别与转换"
            ),
            relatedPoints = listOf(
                RelatedPoint("宾语从句 (Object Clause)", "三大从句的横向对比", "定语从句的 that 必须充当从句成分，而宾语从句的 that 仅起连接作用。"),
                RelatedPoint("关系代词 vs 关系副词", "深入理解从句成分缺失", "根据从句中谓语动词的性质（及物/不及物）来决定选择代词还是副词。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "苏州中考", 
                    "The book ______ you lent me yesterday is very interesting. I have finished reading half of it.", 
                    listOf("A. who", "B. whose", "C. that", "D. what"), 
                    "C", 
                    "【答案】C\n【解析】本题考查定语从句关系代词的选择。先行词是 the book（物），且在从句中充当 lent 的直接宾语（lent sb. sth.）。指物且作宾语，可用 that 或 which。D项 what 不能引导定语从句。", 
                    errorProne = "错选 D。受翻译思维“你借给我的那个东西”影响，容易选 what。记住 what 不引导定语从句。", 
                    translation = "你昨天借给我的那本书非常有趣。我已经读完一半了。"
                ),
                PastExamQuestion(
                    "2023", "杭州中考", 
                    "I like teachers ______ are friendly and can make their classes lively and interesting.", 
                    listOf("A. which", "B. who", "C. whom", "D. whose"), 
                    "B", 
                    "【答案】B\n【解析】本题考查定语从句关系代词。先行词是 teachers（人），在从句中作谓语动词 are 的主语。指人且作主语应用主格关系代词 who 或 that。", 
                    errorProne = "错选 C。认为作成分都要用宾格。实际上谓语动词 are 前面缺的是主语。", 
                    translation = "我喜欢那些友好且能让课堂生动有趣的老师。"
                ),
                PastExamQuestion(
                    "2023", "上海中考", 
                    "This is the most beautiful park ______ I have ever visited since I came to this city.", 
                    listOf("A. which", "B. that", "C. what", "D. who"), 
                    "B", 
                    "【答案】B\n【解析】本题考查 that 的特殊用法。虽然先行词是 park（物），但前面有形容词最高级 the most beautiful 修饰。根据中考核心规则，先行词受最高级、序数词修饰时，关系词首选 that。", 
                    errorProne = "看到指“物”就习惯性直接选 which，忽略了最高级的限制。D项 who 指人。", 
                    translation = "这是自打我来到这座城市以来，去过的最美丽的公园。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "I like music that I can dance to. Music that is loud and energetic is my favorite because it helps me relax after a long day of study. I also like musicians who write their own lyrics. They seem to express their true feelings through their music, which makes the songs more moving and meaningful to the listeners.",
                    listOf(
                        HighlightedSentence("I like music that I can dance to.", "【深度分析】that 引导定语从句修饰 music，并在从句中作介词 to 的宾语。由于是作宾语，这里的 that 在口语中常被省略，这种现象体现了英语句法的简洁性。"),
                        HighlightedSentence("I also like musicians who write their own lyrics.", "【深度分析】who 引导定语从句修饰 musicians，在从句中充当主语成分。注意先行词是复数，从句谓语 write 也使用了原形，体现了定语从句中的主谓一致规则。")
                    ),
                    "—— 出处同步：人教版 (PEP) 九年级 Unit 9"
                ),
                TextbookParagraph(
                    "The Great Wall, which is one of the greatest wonders in the world, attracts millions of tourists every year. It is an ancient structure that shows the wisdom of the Chinese people who lived thousands of years ago. Visiting this place is an experience that most people will never forget in their entire lives.",
                    listOf(
                        HighlightedSentence("The Great Wall, which is one of the greatest wonders in the world, attracts millions of tourists every year.", "【深度分析】这是一个典型的非限制性定语从句，对 The Great Wall 进行补充说明。注意：在这种由逗号隔开的结构中，不可使用 that 来替换 which，这是区分两类从句的重要标志。"),
                        HighlightedSentence("It is an ancient structure that shows the wisdom of the Chinese people who lived thousands of years ago.", "【深度分析】此句包含两个定语从句：that 引导的从句修饰 structure，who 引导的从句修饰 people。这种嵌套结构体现了定语从句在处理复杂信息时的核心地位。")
                    ),
                    "—— 出处同步：外研版 (FLTRP) 九年级上册 Module 5"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "The reason why he was late for the meeting was that he missed the early bus.", 
                    "他开会迟到的原因是他错过了早班车。", 
                    analysis = "【句法分析】why 引导定语从句修饰 the reason，在从句中作原因状语。主句的谓语是 was，后面接 that 引导的表语从句，结构复杂精巧。", 
                    difficulty = "中考压轴"
                ),
                ExampleSentence(
                    "Anyone who breaks the school rules will be punished according to the regulations.", 
                    "任何违反校规的人都将受到相应规章制度的处罚。", 
                    analysis = "【句法分析】who 引导定语从句修饰 anyone。当先行词是不定代词（如 anyone, someone, those）时，常用 who 而非 that 来指代人，以增强指代的清晰度。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "The village where I spent my childhood has changed a lot over the past twenty years.", 
                    "我度过童年的那个村庄在过去的二十年里发生了巨大的变化。", 
                    analysis = "【句法分析】where 引导定语从句修饰 the village，在从句中作地点状语. 判断依据：从句 I spent my childhood 结构完整，缺的是地点信息而非名词成分。", 
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 在定语从句中多余地保留了宾格代词（如 The movie that I saw it...）；2. 搞不清关系副词与关系代词的本质区别。"),
                TeachingNote("辅导建议", "引导学生进行“拆句练习”：将一个长句拆成两个简单句，再寻找共同的词块进行合并。这种从底层构建句子的方法能彻底根治由于死记硬背导致的语法错误。")
            ),
            famousQuote = "A room without books is like a body without a soul.",
            quoteAuthor = "Marcus Tullius Cicero"
        ),

        KnowledgePoint(
            id = "object_clause", 
            section = "板块三：句法体系 (Syntax)", 
            title = "宾语从句 (Object Clause)",
            description = """【核心概念】
宾语从句（Object Clause）是在复合句中充当宾语成分的从句。它通常位于及物动词、介词或某些表示心理状态的形容词（如 sure, afraid, glad）之后。宾语从句的本质是将一个完整的信息（句子）嵌入到另一个句子的宾语位置上，是初中英语三大从句中出现频率最高、掌握难度相对适中的核心语法点。

【考纲要求】
1. **引导词的选择（三种类型）**：
   - 陈述句作宾语：用 that（连接词，不充当成分，常省略）。
   - 一般疑问句作宾语：用 if 或 whether（意为“是否”，不能省略）。
   - 特殊疑问句作宾语：用原有的疑问词（who, what, when, where, why, how 等）。
2. **语序（中考死穴）**：无论原句是什么语序，进入宾语从句后必须使用“陈述语序”（即：引导词 + 主语 + 谓语）。
3. **时态的一致性（逻辑核心）**：
   - 主句是一般现在时，从句可根据实际需要使用任何时态。
   - 主句是一般过去时，从句必须使用相应的过去时态（过去式、过去进行、过去完成、过去将来）。
   - **特殊例外**：若从句表达的是客观真理、自然规律或格言警句，无论主句时态如何，从句一律使用一般现在时。

【重难点剖析】
1. **if 与 whether 的差异化选择**：虽然两者在引导宾语从句时多可互换，但在介词后、与 or not 连用、或引导主语/表语从句时，通常只能使用 whether。
2. **疑问词 + 动词不定式的等价转换**：掌握如何将宾语从句转化为更简洁的 to do 结构，如：I don't know what I should do. -> I don't know what to do.""",
            syllabusDetails = listOf(
                "三大引导词（that, if/whether, 疑问词）的选择逻辑",
                "宾语从句陈述语序（主语+谓语）的变换与巩固",
                "时态一致性原则及客观真理的例外情况处理",
                "宾语从句中 it 作形式宾语的高阶用法",
                "宾语从句与简单句（疑问词+to do）的相互转化"
            ),
            relatedPoints = listOf(
                RelatedPoint("陈述语序 (Statement Order)", "宾语从句的灵魂", "无论原句是疑问句还是感叹句，进入宾语从句后一律变为陈述句的顺序。"),
                RelatedPoint("客观真理 (Objective Truth)", "超越时态的束缚", "当表达自然规律（如太阳从东方升起）时，时态的一致性原则必须让位于客观事实。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion(
                    "2024", "武汉中考", 
                    "Excuse me, could you tell me ______?", 
                    listOf("A. where is the nearest post office", "B. where the nearest post office is", "C. how can I get to the bank", "D. what time does the bus leave"), 
                    "B", 
                    "【答案】B\n【解析】本题考查宾语从句的语序。宾语从句必须使用陈述语序（主语 + 谓语）。A、C、D 均为疑问语序，故排除。B项中 where 是引导词，the nearest post office 是主语，is 是谓语，符合规则。", 
                    errorProne = "极易错选 A 或 C。受口语习惯影响，学生在提问时习惯用疑问语序。在心里默念“引导词+主语+谓语”是解决此题的金钥匙。", 
                    translation = "打扰一下，你能告诉我最近的邮局在哪里吗？"
                ),
                PastExamQuestion(
                    "2023", "南京中考", 
                    "Our geography teacher told us that the earth ______ around the sun.", 
                    listOf("A. goes", "B. went", "C. is going", "D. has gone"), 
                    "A", 
                    "【答案】A\n【解析】本题考查宾语从句的时态。虽然主句谓语 told 是过去式，但从句表达的是“地球绕着太阳转”这一永恒不变的客观真理，因此必须用一般现在时。故选A。", 
                    errorProne = "机械套用“主句过去，从句必过去”的原则而错选 B。务必对客观真理保持敏感。", 
                    translation = "我们的地理老师告诉我们，地球绕着太阳转。"
                ),
                PastExamQuestion(
                    "2023", "扬州中考", 
                    "I don't know ______ he will come or not. If he comes, I will tell him the news.", 
                    listOf("A. if", "B. that", "C. whether", "D. when"), 
                    "C", 
                    "【答案】C\n【解析】本题考查 if 与 whether 的用法区别。宾语从句中表示“是否”时，虽然两者通用，但当从句末尾出现 or not 时，通常只使用 whether 构成 whether... or not 搭配。", 
                    errorProne = "错选 A。if 虽然也能表达“是否”，但与 or not 搭配的紧密程度不如 whether。", 
                    translation = "我不知道他是否会来。如果他来，我会把这个消息告诉他。"
                )
            ),
            textbookParagraphs = listOf(
                TextbookParagraph(
                    "Many students wonder how they can improve their English speaking skills. Some think that watching English movies is a good way, while others suggest that we should join an English club. I believe that if we practice every day, we will eventually be able to speak English fluently and confidently.",
                    listOf(
                        HighlightedSentence("Many students wonder how they can improve their English speaking skills.", "【深度分析】how 引导宾语从句。注意从句内部使用了陈述语序 'they can improve' 而非疑问语序 'how can they'，这是中考最高频的丢分点。"),
                        HighlightedSentence("I believe that if we practice every day, we will eventually be able to speak English fluently.", "【深度分析】that 引导宾语从句，that 在此仅起连接作用，不充当任何成分。从句内部又巧妙地嵌套了一个 if 引导的条件状语从句，展示了复杂句式的表达魅力。")
                    ),
                    "—— 出处同步：人教版 (PEP) 九年级 Unit 1"
                ),
                TextbookParagraph(
                    "Our teacher asked us whether we had finished the project on time. She wanted to know what difficulties we had met during the process. We told her that we had encountered some problems but we managed to solve them with the help of our parents and friends.",
                    listOf(
                        HighlightedSentence("Our teacher asked us whether we had finished the project on time.", "【深度分析】whether 引导宾语从句，表示“是否”。由于主句谓语 asked 表示过去的时间点，从句相应地使用了过去完成时 had finished，体现了严格的时态一致性原则。"),
                        HighlightedSentence("She wanted to know what difficulties we had met during the process.", "【深度分析】what 引导宾语从句，并在从句中修饰名词 difficulties。其语序依然严格遵循陈述语序，即引导词块 + 主语 + 谓语。")
                    ),
                    "—— 出处同步：外研版 (FLTRP) 九年级上册 Module 2"
                )
            ),
            exampleSentences = listOf(
                ExampleSentence(
                    "Could you please tell me how I can get to the library as quickly as possible?", 
                    "请问你能告诉我如何才能尽快到达图书馆吗？", 
                    analysis = "【句法分析】这是一个由 could you... 引导的委婉礼貌询问。注意 could 在此并不表示过去，因此主句视为现在时。宾语从句 how I can get... 必须使用陈述语序。", 
                    difficulty = "中考核心"
                ),
                ExampleSentence(
                    "I am not sure whether he has received the letter that I sent him last week.", 
                    "我不确定 he 是否已经收到了我上周寄给他的那封信。", 
                    analysis = "【句法分析】whether 引导宾语从句。而在宾语从句内部，又嵌入了一个由 that 引导的定语从句修饰 the letter。这种多重复合句是阅读理解中长难句的典型结构。", 
                    difficulty = "中考压轴"
                ),
                ExampleSentence(
                    "He asked me why I hadn't finished my work and what I was planning to do next.", 
                    "他问我为什么还没完成工作，以及我接下来的计划是什么。", 
                    analysis = "【句法分析】这是一个由 and 连接的并列宾语从句. 由于主句谓语是 asked，两个从句均根据“主过从过”原则分别使用了过去完成时和过去进行时。", 
                    difficulty = "中考核心"
                )
            ),
            teachingNotes = listOf(
                TeachingNote("常见学生错因", "1. 宾语从句忘记变陈述语序；2. 主句是过去时，从句忘记变相应的过去时（客观真理除外）。"),
                TeachingNote("辅导建议", "反复练习“三要素”检查法：一扣引导词，二查陈述序，三对时态轴。只要这三点不乱，宾语从句就绝不会失分。")
            ),
            famousQuote = "I know that I am intelligent because I know that I know nothing.",
            quoteAuthor = "Socrates"
        )
    )
}
