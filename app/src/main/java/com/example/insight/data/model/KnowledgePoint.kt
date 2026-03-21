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
    val allPoints = listOf(
        KnowledgePoint(
            id = "0",
            title = "名词 (Nouns)",
            description = "名词表示人、事物、地点或抽象概念。中考重点包括：名词的数（可数与不可数）、名词所有格（'s, of）、名词作定语等。",
            relatedPoints = listOf("可数名词复数变化", "不可数名词", "双重所有格", "抽象名词具体化"),
            exampleProblems = listOf(
                ExampleProblem("How many ______ are there in the basket?", listOf("A. apple", "B. apples", "C. milk", "D. water"), "B", "how many 修饰可数名词复数。"),
                ExampleProblem("The ______ of the twin brothers are both teachers.", listOf("A. father", "B. mother", "C. parents", "D. parent"), "C", "双胞胎兄弟的父母，主语是复数，且谓语是 are。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I have a lot of homework to do today.", "—— 摘自《人教版初二上》")),
            exampleSentences = listOf(ExampleSentence("Information is very important.", "信息非常重要。"), ExampleSentence("This is my sister's room.", "这是我妹妹的房间。"))
        ),
        KnowledgePoint(
            id = "1",
            title = "代词 (Pronouns)",
            description = "代词是代替名词或起名词作用的短语。中考重点：人称代词（主格/宾格）、物主代词（形容词性/名词性）、反身代词、不定代词（some, any, no, every 及其复合物）、指示代词（this, that, these, those）。",
            relatedPoints = listOf("人称代词顺序", "形容词性 vs 名词性物主代词", "it 的用法", "不定代词辨析"),
            exampleProblems = listOf(
                ExampleProblem("Is this your pen? — No, it's not ______. It's hers.", listOf("A. my", "B. mine", "C. me", "D. I"), "B", "这里指代“我的钢笔”，需用名词性物主代词。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Everyone is having a good time.", "—— 摘自《人教版初一上》")),
            exampleSentences = listOf(ExampleSentence("I can do it by myself.", "我自己能行。"), ExampleSentence("There is something wrong with my phone.", "我的手机出问题了。"))
        ),
        KnowledgePoint(
            id = "2",
            title = "冠词 (Articles)",
            description = "冠词放在名词前说明名词所指的人或事物。分为不定冠词（a/an）、定冠词（the）和零冠词（不填）。中考重点：a/an 区别（元音音素）、the 特指/泛指、固定搭配。",
            relatedPoints = listOf("an 用法特例 (hour, honest)", "the 序数词/最高级", "球类/乐器冠词差异", "习惯搭配"),
            exampleProblems = listOf(
                ExampleProblem("He is ______ honest boy.", listOf("A. a", "B. an", "C. the", "D. /"), "B", "honest [ˈɒnɪst] 以元音音素开头，用 an。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("The sun rises in the east.", "—— 摘自《科普版英语》")),
            exampleSentences = listOf(ExampleSentence("I play the piano every day.", "我每天弹钢琴。"), ExampleSentence("She goes to school by bus.", "她乘公交车上学。"))
        ),
        KnowledgePoint(
            id = "3",
            title = "数词 (Numerals)",
            description = "数词表示数目或顺序。中考重点：基数词与序数词（特别是 first, second, third, fifth, ninth, twelfth）、年份/日期表达、分数表达、hundred/thousand/million 变复数规律。",
            relatedPoints = listOf("序数词构成规则", "分数构成 (子基母序)", "概数表达 (hundreds of)", "具体数表达 (two hundred)"),
            exampleProblems = listOf(
                ExampleProblem("Today is my father's ______ birthday.", listOf("A. forty", "B. fortieth", "C. the forty", "D. the fortieth"), "B", "序数词表示第几个，且形容词性物主代词后不加 the。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Two thirds of the students are girls.", "—— 摘自《外研版初三上》")),
            exampleSentences = listOf(ExampleSentence("He lives on the fifth floor.", "他住在五楼。"), ExampleSentence("There are millions of stars in the sky.", "天空中有数百万颗星星。"))
        ),
        KnowledgePoint(
            id = "4",
            title = "形容词与副词 (Adj & Adv)",
            description = "形容词修饰名词，副词修饰动词、形容词、副词或全句。中考重点：比较级与最高级、as...as 结构、-ed 与 -ing 形容词区别、词性转换、修饰语位置。",
            relatedPoints = listOf("比较级不规则变化", "越...越...结构", "the + 序数词 + 最高级", "形容词顺序"),
            exampleProblems = listOf(
                ExampleProblem("The weather is getting ______.", listOf("A. warm and warm", "B. warmer and warmer", "C. warmest", "D. more warm"), "B", "“比较级 + and + 比较级”表示“越来越...”。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Music is more interesting than art.", "—— 摘自《人教版初一上》")),
            exampleSentences = listOf(ExampleSentence("I am as tall as my brother.", "我和我哥哥一样高。"), ExampleSentence("The news sounds exciting.", "这个消息听起来很令人兴奋。"))
        ),
        KnowledgePoint(
            id = "5",
            title = "介词 (Prepositions)",
            description = "介词表示名词、代词等与句中其他词的关系。中考重点：时间介词 (in, on, at)、地点介词、工具/手段介词 (with, by, in)、易混淆介词辨析 (besides, except)。",
            relatedPoints = listOf("at/on/in 时间点/线/面", "by/in/with 方法/工具", "between/among 数量差异", "介词短语"),
            exampleProblems = listOf(
                ExampleProblem("I usually go to bed ______ ten o'clock.", listOf("A. in", "B. on", "C. at", "D. for"), "C", "具体时刻前用 at。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("We have breakfast at 7:30 in the morning.", "—— 摘自《人教版初一上》")),
            exampleSentences = listOf(ExampleSentence("I'll be back in two days.", "我两天后回来。"), ExampleSentence("Everyone is here except Tom.", "除了汤姆大家都到了。"))
        ),
        KnowledgePoint(
            id = "6",
            title = "连词 (Conjunctions)",
            description = "连词连接词、短语或句子。中考重点：并列连词 (and, but, or, so)、关联连词 (both...and, neither...nor, not only...but also)、从属连词 (because, although, if, unless, until)。",
            relatedPoints = listOf("but 与 although 不连用", "so 与 because 不连用", "neither...nor 谓语就近原则", "or 在否定句中的用法"),
            exampleProblems = listOf(
                ExampleProblem("______ he is young, ______ he knows a lot.", listOf("A. Though; but", "B. Because; so", "C. Though; /", "D. Although; but"), "C", "though/although 不能与 but 连用。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Work hard, and you will succeed.", "—— 摘自《科普版英语》")),
            exampleSentences = listOf(ExampleSentence("I'll wait until you come.", "我会一直等到你来。"), ExampleSentence("Study hard, or you'll fail.", "好好学习，否则你会挂科。"))
        ),
        KnowledgePoint(
            id = "7",
            title = "动词时态 (Tenses)",
            description = "动词时态表示动作发生的时间和状态。中考重点：一般现在时、一般过去时、一般将来时、现在进行时、过去进行时、现在完成时。",
            relatedPoints = listOf("现在完成时 for/since 区别", "since 后的时态", "主将从现原则", "过去完成时入门"),
            exampleProblems = listOf(
                ExampleProblem("I ______ my homework yet.", listOf("A. finished", "B. haven't finished", "C. am finishing", "D. will finish"), "B", "yet 用于否定或疑问句，常与现在完成时连用。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I have been to the Great Wall twice.", "—— 摘自《人教版初二下》")),
            exampleSentences = listOf(ExampleSentence("I was reading at 8 last night.", "昨晚八点我正在读书。"), ExampleSentence("He will come back tomorrow.", "他明天回来。"))
        ),
        KnowledgePoint(
            id = "8",
            title = "被动语态 (Passive Voice)",
            description = "被动语态表示主语是动作的承受者。基本结构：be + 过去分词。重点掌握：一般现在时、一般过去时及含有情态动词的被动语态。",
            relatedPoints = listOf("主动变被动步骤", "by 短语的省略", "不使用被动语态的情况", "make/hear 等词变被动补 to"),
            exampleProblems = listOf(
                ExampleProblem("The flowers ______ every day.", listOf("A. water", "B. are watered", "C. watered", "D. are watering"), "B", "花每天被浇，用一般现在时被动语态。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Paper was invented by the Chinese.", "—— 摘自《人教版初三》")),
            exampleSentences = listOf(ExampleSentence("English is spoken world-wide.", "英语在全球范围内被使用。"), ExampleSentence("Children should be looked after well.", "孩子们应该被好好照看。"))
        ),
        KnowledgePoint(
            id = "9",
            title = "情态动词 (Modal Verbs)",
            description = "情态动词表示语气、情态。中考重点：can/could (能力/允许)、may/might (可能/允许)、must (必须/推测)、should (建议)、need (需要)。",
            relatedPoints = listOf("must 否定回答用法", "must be 推测 vs can't be", "could/would 委婉语气", "情态动词被动语态"),
            exampleProblems = listOf(
                ExampleProblem("May I go now? — No, you ______.", listOf("A. needn't", "B. mustn't", "C. can't", "D. shouldn't"), "B/C", "否定回答“不可以”用 mustn't 或 can't。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("You should listen to the teacher.", "—— 摘自《人教版初一》")),
            exampleSentences = listOf(ExampleSentence("I must go now.", "我必须走了。"), ExampleSentence("It might rain tonight.", "今晚可能会下雨。"))
        ),
        KnowledgePoint(
            id = "10",
            title = "非谓语动词 (Non-finite Verbs)",
            description = "非谓语动词在句中不作谓语。重点：动词不定式 (to do)、动名词 (-ing)、现在分词 (-ing) 和过去分词 (-ed)。",
            relatedPoints = listOf("want/decide to do", "enjoy/finish doing", "stop to do vs doing", "感官动词用法"),
            exampleProblems = listOf(
                ExampleProblem("Remember ______ the light when you leave.", listOf("A. turn off", "B. to turn off", "C. turning off", "D. turned off"), "B", "remember to do 记得去做；doing 记得做过。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I want to be an engineer.", "—— 摘自《外研版》")),
            exampleSentences = listOf(ExampleSentence("Thank you for helping me.", "谢谢你帮我。"), ExampleSentence("It's time to have lunch.", "该吃午饭了。"))
        ),
        KnowledgePoint(
            id = "11",
            title = "主谓一致 (S-V Agreement)",
            description = "谓语动词的人称和数必须与主语一致。重点：语法一致、意义一致、就近原则 (neither...nor, not only...but also, there be)。",
            relatedPoints = listOf("就近原则应用", "neither/either/each/none 用法", "both vs either", "不定代词作主语"),
            exampleProblems = listOf(
                ExampleProblem("Neither I nor he ______ Chinese.", listOf("A. am", "B. is", "C. are", "D. be"), "B", "neither...nor 遵循就近原则，离谓语近的是 he。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Twenty years is a long time.", "—— 摘自《科普版》")),
            exampleSentences = listOf(ExampleSentence("There is a pen and two books.", "那儿有一支笔和两本书。"), ExampleSentence("Reading is very important.", "阅读非常重要。"))
        ),
        KnowledgePoint(
            id = "12",
            title = "简单句与并列句 (Simple & Compound)",
            description = "简单句包含一个主谓结构。并列句由连词连接两个简单句。重点：五种基本句型、并列句连词选择、祈使句。",
            relatedPoints = listOf("S+V+O 句型", "There be 句型", "祈使句 + and/or + 简单句", "反义疑问句基础"),
            exampleProblems = listOf(
                ExampleProblem("Stop talking, ______ you'll be punished.", listOf("A. and", "B. but", "C. or", "D. so"), "C", "“祈使句, or + 句子”表示“否则...”。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Open your books and read after me.", "—— 摘自《人教版初一》")),
            exampleSentences = listOf(ExampleSentence("I like apples but he likes pears.", "我喜欢苹果但他喜欢梨。"), ExampleSentence("What a beautiful girl!", "多漂亮的女孩啊！"))
        ),
        KnowledgePoint(
            id = "13",
            title = "宾语从句 (Object Clause)",
            description = "宾语从句在句中作宾语。重点：引导词选择、陈述句语序、时态一致性（主现从任意，主过从必过，客观真理现）。",
            relatedPoints = listOf("whether/if 区别", "从句时态退后", "疑问词引导", "that 的省略"),
            exampleProblems = listOf(
                ExampleProblem("I don't know ______ next week.", listOf("A. when will he come", "B. when he will come", "C. where will he go", "D. where he go"), "B", "宾语从句使用陈述句语序。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I wonder if it will rain.", "—— 摘自《外研版》")),
            exampleSentences = listOf(ExampleSentence("She asked me where I lived.", "她问我住哪儿。"), ExampleSentence("I think that he is right.", "我觉得他是对的。"))
        ),
        KnowledgePoint(
            id = "14",
            title = "定语从句 (Attributive Clause)",
            description = "定语从句修饰名词或代词。重点：关系代词 (that, which, who, whom, whose) 与关系副词 (when, where, why) 的基本用法。",
            relatedPoints = listOf("that vs which 特例", "who vs whom", "whose 表示所属", "先行词辨析"),
            exampleProblems = listOf(
                ExampleProblem("The book ______ I bought is very good.", listOf("A. who", "B. whom", "C. which", "D. whose"), "C", "先行词是 book (物)，在从句中作宾语，用 which/that。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("The girl who is singing is Lily.", "—— 摘自《人教版初二》")),
            exampleSentences = listOf(ExampleSentence("This is the factory where he works.", "这是他工作的工厂。"), ExampleSentence("I like people who are kind.", "我喜欢善良的人。"))
        ),
        KnowledgePoint(
            id = "15",
            title = "状语从句 (Adverbial Clause)",
            description = "状语从句在句中作状语。重点：时间、原因、条件、让步、比较、结果、目的状语从句。",
            relatedPoints = listOf("主将从现 (if/when/unless/as soon as)", "because vs since vs as", "so...that vs such...that", "although 引导的让步"),
            exampleProblems = listOf(
                ExampleProblem("I'll call you as soon as I ______ home.", listOf("A. get", "B. will get", "C. gets", "D. got"), "A", "as soon as 引导时间状语从句，主将从现。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("If it rains, we won't go out.", "—— 摘自《人教版初二》")),
            exampleSentences = listOf(ExampleSentence("He was so tired that he fell asleep.", "他太累了以至于睡着了。"), ExampleSentence("I study hard so that I can succeed.", "我努力学习为了成功。"))
        ),
        KnowledgePoint(
            id = "16",
            title = "疑问句与感叹句 (Questions & Exclamations)",
            description = "疑问句包括一般、特殊、选择和反义疑问句。感叹句由 what 或 how 引导。",
            relatedPoints = listOf("反义疑问句前肯后否", "What + 名词 vs How + 形容词", "疑问词的选择", "回答选择疑问句"),
            exampleProblems = listOf(
                ExampleProblem("______ cold weather it is!", listOf("A. What", "B. What a", "C. How", "D. How a"), "A", "weather 是不可数名词，用 What 修饰。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("What a great day it is!", "—— 摘自《外研版》")),
            exampleSentences = listOf(ExampleSentence("You are a student, aren't you?", "你是学生，对吧？"), ExampleSentence("How fast he runs!", "他跑得真快！"))
        ),
        KnowledgePoint(
            id = "17",
            title = "直接引语与间接引语 (Direct & Indirect Speech)",
            description = "间接引语通常由宾语从句构成。重点：人称变化、时态退后、指示代词/地点状语/时间状语变化。",
            relatedPoints = listOf("said to -> told", "this -> that", "now -> then", "tomorrow -> the next day"),
            exampleProblems = listOf(
                ExampleProblem("He said, 'I am a teacher.' -> He said that ______ a teacher.", listOf("A. I am", "B. he is", "C. I was", "D. he was"), "D", "变间接引语需改人称且时态退后。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("He asked me where I was going.", "—— 摘自《科普版》")),
            exampleSentences = listOf(ExampleSentence("She told me she liked music.", "她告诉我她喜欢音乐。"), ExampleSentence("He said that the earth goes round the sun.", "他说地球绕着太阳转。"))
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints[0]
    }
}
