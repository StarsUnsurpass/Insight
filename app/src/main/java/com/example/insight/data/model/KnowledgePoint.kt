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
        KnowledgePoint(
            id = "nouns",
            section = SEC_1,
            title = "名词 (Nouns)",
            description = """### 核心概念详解
名词 (Nouns) 是英语词汇体系的基石，在中考评价框架中占据核心地位。名词不仅用于命名人、事、物及抽象概念，其更深层的考查在于“数”与“格”的动态变化。在义务教育阶段，考生必须深刻理解可数名词与不可数名词之间的本质区别：可数名词具备个体性，能直接与数词连用；不可数名词则具备连续性或抽象性，如 water, advice 等，需借助量词来体现其逻辑单位。此外，名词复数的不规则变化（如 foot-feet, sheep-sheep, mouse-mice）以及以 -o 结尾的名词（如 heroes, tomatoes vs pianos, photos）的变复规则是区分高分考生的关键。复合名词的变复数逻辑（如 apple trees, men doctors, daughter-in-law -> daughters-in-law）也是考试中的进阶点。名词所有格则是对从属关系的精准表达，'s 所有格与 of 所有格的互换与嵌套，常出现在完形填空对逻辑关系的考查中。特别要注意双重所有格（a friend of my father's）的结构，这在描述亲属或朋友关系时极具迷惑性。名词在句中还可充当主语、宾语、表语、定语以及同位语，其形态随功能而变。

### 深度考点解析
*   **不可数名词的‘可数化’趋势**：在中考高阶题目中，advice, information, news, progress, weather 等词常与 a piece of, a bit of 结合，考查考生对抽象名词量化的敏感度。注意：advice 不能加 s，哪怕是‘很多建议’也只能说 much advice 或 many pieces of advice。
*   **集体名词的主谓一致**：police 恒定复数（The police are searching...）；class, family, team 等词则需根据语义（强调整体还是强调个体成员）在单复数谓语之间进行切换。例如：His family is large (整体) vs His family are watching TV (成员)。
*   **名词作定语的数**：通常用单数，如 a shoe factory, an apple tree；但 man/woman 作定语时需随主名词变数，如 two men teachers, three women doctors。
*   **专有名词的泛指用法**：当中考阅读中出现 A Mr. Smith 或 The Smiths 时，考生需识别其代表的‘某位史密斯先生’或‘史密斯一家’的特定语义内涵。此外，一些抽象名词（如 failure, success）在表示具体的人或事时可变为可数名词，如 a success (一个成功的人或事)。""",
            syllabusDetails = listOf(
                "1. 深刻掌握可数名词与不可数名词的本质差异，特别是 advice, news, information 等高频不可数名词的量化表达方式。",
                "2. 熟练运用名词复数的各种规则变化与不规则变化，包括以 f(e) 结尾的特殊词及单复同形词。",
                "3. 精准区分 's 所有格、of 所有格及双重所有格（a friend of mine's 错误辨析）的使用语境。",
                "4. 理解名词作定语时的形态要求，掌握 man/woman 作定语时需随主名词变数的特殊逻辑。",
                "5. 掌握单位词（measure words）的精准搭配，如 a tube of toothpaste, a loaf of bread, a pack of cards 等。",
                "6. 掌握名词所有格在表示共同所有与分别所有时的区别：Tom and Mary's room vs Tom's and Mary's rooms。"
            ),
            relatedPoints = listOf(
                RelatedPoint("冠词", "名词是冠词的载体", "名词的可数性决定了 a/an 的使用。"),
                RelatedPoint("代词", "代词是名词的替代者", "代词必须在数和格上与所替代的名词保持一致。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "北京中考", "There is some ______ about the upcoming traditional festival on the website.", listOf("A. message", "B. stories", "C. information", "D. newses"), "C", "【答案】C。本题考查不可数名词。information 是核心不可数名词，不能加 s。some 可修饰复数或不可数，A、B项均为单数或语义不合，D项拼写错误。", "受汉语影响认为信息是可数的。", "网站上有一些关于即将到来的传统节日的信息。"),
                PastExamQuestion("2023", "上海中考", "These ______ are busy working in the science laboratory now.", listOf("A. woman scientists", "B. women scientist", "C. women scientists", "D. woman scientist"), "C", "【答案】C。本题考查名词作定语。当 man 或 woman 修饰名词变复数时，两个词都要变为复数形式。", "只变后面一个词的形式。", "这些女科学家现在正忙于在科学实验室工作。"),
                PastExamQuestion("2022", "广东中考", "— Would you like some ______?\n— No, thanks. I'm full.", listOf("A. water", "B. bread", "C. pear", "D. apples"), "B", "【答案】B。本题考查语境逻辑与名词属性。I'm full 说明问的是食物。bread 为不可数，some bread 正确；pear 是可数单数，需加 s；apples 虽可，但 bread 更契合不可数名词考点。", "混淆可数与不可数名词。", "—— 你想吃点面包吗？ —— 不了，谢谢，我饱了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("In our modern society, information is growing faster than ever before. We can get different kinds of news from the Internet, television, and newspapers. It is important for us to learn how to choose helpful advice from the massive data. This skill will help us make better decisions in our daily lives and avoid being misled by fake news or useless advertisements which are everywhere today. Moreover, searching for information efficiently has become an essential part of our study and work.", listOf(
                    HighlightedSentence("information is growing faster", "information 是不可数名词，作主语时谓语动词必须用单数 is。"),
                    HighlightedSentence("choose helpful advice", "advice 是不可数名词，不可加 s 或使用 an 修饰，这里直接使用原形。")
                ), "人教版九年级 Unit 1"),
                TextbookParagraph("My school is famous for its beautiful environment and excellent facilities. There are three library buildings and ten science laboratories in the school. Many students like to spend their free time in the library, reading books or searching for information. The teachers always encourage us to explore more knowledge outside the textbooks, which gives us a chance to improve our comprehensive skills. We also learn how to work together with our teammates during group activities.", listOf(
                    HighlightedSentence("three library buildings", "library 在此作定语修饰 buildings，遵循定语名词通常用单数的原则。"),
                    HighlightedSentence("searching for information", "再次强调 information 的不可数属性，在中考阅读中极其高频。")
                ), "外研版八上 Module 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("Two months' holiday is what the children look forward to every summer.", "两个月的假期是孩子们每年夏天都期待的。", "【分析】复数名词以 s 结尾，所有格只加 '。表示时间的名词所有格作主语，谓语动词常用单数。", "中考核心"),
                ExampleSentence("The police are searching for the missing boy in the forest.", "警察正在森林里搜寻失踪的小男孩。", "【分析】police 是集体名词，表复数意义，谓语动词用 are 而非 is。", "高频易错"),
                ExampleSentence("She bought three bottles of milk and two loaves of bread for breakfast.", "她买了三瓶牛奶 and 两个大面包做早餐。", "【分析】考查不可数名词的量化表达。复数变化体现在量词 bottles 和 loaves 上。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 混淆 advice, news, information, furniture 为可数名词；2. 名词作定语时错误使用复数（如 apples trees）；3. 忽略集体名词 police 的复数属性；4. 混淆 joint and separate possession 的所有格表达。"),
                TeachingNote("教学建议", "建议教师利用思维导图将名词分为：食品类（bread, meat）、自然物质类（water, air）、抽象概念类（advice, progress），并重点标注不规则复数变化。可以通过实物或图片演示 a piece of bread 等量化表达。")
            ),
            famousQuote = "Knowledge is power.",
            quoteAuthor = "Francis Bacon"
        ),
        KnowledgePoint(
            id = "pronouns",
            section = SEC_1,
            title = "代词 (Pronouns)",
            description = """### 核心概念详解
代词 (Pronouns) 是英语句法的“替代艺术”，其核心功能是简化语言并避免重复。在中考语境下，代词不仅是词法考查的重点，更是完形填空和阅读理解中指代一致性（Referential Consistency）的关键。代词体系庞杂，包括人称代词（主格 vs 宾格）、物主代词（形容词性 vs 名词性）、反身代词、指示代词、疑问代词、不定代词以及关系代词。其中，人称代词的主格用于句首作主语，宾格用于动词或介词后作宾语；物主代词的区分在于是否需要后续名词（my book vs mine）。最为复杂且高频的考点是不定代词，如 some, any, something, nothing 以及 both, all, neither, none 等。这些词不仅涉及肯定与否定的选择，还涉及范围（两者 vs 三者以上）的界定。此外，it 的多重功能也是重难点，既可以指代时间、距离、天气，也可以作为形式主语或形式宾语，引导不定式或从句。

### 深度考点解析
*   **反身代词的用法界限**：考查 enjoy oneself, learn by oneself, help oneself to 等固定搭配，以及反身代词在句中作为同位语的强调作用（I did it myself）。
*   **it, one, that 的指代迷雾**：这是中考最具杀伤力的考点。it 指代同名同物（特指同一个）；one 指代同名异物（泛指同类中的一个，复数为 ones）；that 指代同名异物（常用于比较结构中指代不可数名词或特指的单数名词）。
*   **复合不定代词的逻辑陷阱**：something, anything, nothing 的选择依赖于句式。肯定句用 something，疑问/否定句用 anything；但当表示委婉请求或希望得到肯定回答时（如 Would you like...?），疑问句也用 something。
*   **None vs Neither vs No one**：None 指三者或以上都不，可接 of；Neither 指两者都不；No one 仅指人不指物。""",
            syllabusDetails = listOf(
                "1. 熟练掌握人称代词主宾格、物主代词两性的拼写及其在句中的功能定位。",
                "2. 深度理解 it, one, that 的指代逻辑，能在长难句中迅速锁定指代对象。",
                "3. 掌握 both, either, neither (两者) 与 all, any, none (三者及以上) 的语义范围对比。",
                "4. 灵活运用 something, anything, nothing 及其与形容词后置的语法规则（如 something interesting）。",
                "5. 掌握 it 作为形式主语 (It's adj to do) 与形式宾语 (find it adj to do) 的句型结构。",
                "6. 掌握反身代词与宾格代词在‘动作指向主语本身’时的区分。"
            ),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "不定代词作主语时的谓语形态", "something 等复合不定代词及 each, every one 作主语，谓语用单数。"),
                RelatedPoint("定语从句", "关系代词的选择", "关系代词 who, whom, which, that 在从句中充当成分。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "杭州中考", "— Which of these two books do you like?\n— ______. I find them both boring.", listOf("A. Either", "B. Neither", "C. None", "D. All"), "B", "【答案】B。本题考查代词范围。问句中提到 two books，说明在两者中选择。根据 boring（无聊）可知是不喜欢，故选 Neither（两者都不）。", "混淆 Neither 与 None 的适用范围。", "—— 这两本书你喜欢哪一本？ —— 都不喜欢。我觉得它们都很无聊。"),
                PastExamQuestion("2023", "南京中考", "The weather in Nanjing is much warmer than ______ in Beijing in spring.", listOf("A. it", "B. one", "C. that", "D. this"), "C", "【答案】C。本题考查指代词辨析。这里指代不可数名词 weather 且表示同名异物，用 that。it 指代同名同物；one 指代可数单数。", "习惯性选 it，不理解同名异物的概念。", "春天南京的天气比北京的天气暖和得多。"),
                PastExamQuestion("2022", "武汉中考", "The boy is old enough to look after ______ now.", listOf("A. him", "B. his", "C. himself", "D. he"), "C", "【答案】C。本题考查反身代词。主语 boy 和动作对象是同一人，用反身代词 himself 表示“照顾他自己”。", "主格与宾格、反身代词混淆。", "这个男孩现在足够大，可以照顾自己了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("If you have something important to tell your parents, you should speak to them directly. Don't keep it to yourself, because sharing your feelings can help you feel better. They are the people who love you most in the world and they will always be there for you when you need help. Trusting each other is the key to a happy family life.", listOf(
                    HighlightedSentence("have something important to tell", "something 是复合不定代词，形容词 important 必须后置。"),
                    HighlightedSentence("Don't keep it to yourself", "it 指代前面提到的 something；yourself 是反身代词，表示‘独自保守秘密’。")
                ), "人教版八下 Unit 4"),
                TextbookParagraph("Learning a foreign language is a challenge for everyone. Some find it easy, while others may find it difficult. But for me, none of us can master it without hard work and constant practice. We should encourage each other and never give up. Remember that everyone has their own way of learning, so don't compare yourself with others too much.", listOf(
                    HighlightedSentence("Some find it easy, while others", "some... others... 是典型的代词配对用法，用于对比不同的人。"),
                    HighlightedSentence("none of us can master it", "none 表示三者或三者以上‘都不’，此处指代所有人。")
                ), "外研版九下 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("Is there anything interesting in today's newspaper?", "今天的报纸上有什么有趣的内容吗？", "【分析】anything 用于疑问句，形容词 interesting 后置。", "基础必会"),
                ExampleSentence("My pen is broken. May I use yours?", "我的笔坏了。我可以用你的吗？", "【分析】yours 是名词性物主代词，相当于 your pen，避免重复。", "基础必会"),
                ExampleSentence("The population of China is larger than that of Japan.", "中国的人口比日本的人口多。", "【分析】that 指代 population，是典型的同名异物特指用法。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 形容词修饰不定代词前置（如 important something）；2. Neither/None 范围混淆；3. 物主代词形容词性与名词性混用；4. 混淆 it/one/that 的指代对象。"),
                TeachingNote("教学建议", "通过‘公式化’记忆法：some/any/no + thing/body/one；利用对比图表展示 it/one/that 的区别。可以使用代指游戏，让学生练习在句子中替换名词。")
            ),
            famousQuote = "Believe in yourself and all that you are.",
            quoteAuthor = "Christian D. Larson"
        ),
        KnowledgePoint(
            id = "articles",
            section = SEC_1,
            title = "冠词 (Articles)",
            description = """### 核心概念详解
冠词 (Articles) 被称为英语中的“虚词之王”，尽管数量极少（a, an, the），但其使用频率极高且规则极其细腻。冠词的本质是名词的“先行官”，用于限定名词的泛指、特指或习惯用法。不定冠词 a/an 核心在于“一”的概念，表示泛指或初次提到。中考的经典陷阱在于 a 与 an 的选择并非取决于首字母是否为元音字母，而是取决于首个音素（Phoneme）是否为元音音素。定冠词 the 的灵魂在于“特指”，即说话双方心领神会的对象，或世界上独一无二的事物，以及序数词、最高级、方位词前。此外，冠词的省略（零冠词）也是考察重点，涉及球类运动、三餐、月份、星期以及学科、节日和某些习惯短语。

### 深度考点解析
*   **首音素判别法**：an honest boy, a useful book, an unusual story, a university student 等特例是每年单选题必考的语音陷阱。重点看发音，不看拼写。
*   **特指的‘回头见’原则**：第一次提到用 a/an，第二次提到同一个事物必须切换为 the，这是考察语篇衔接能力的标志。
*   **乐器与球类的对立**：play the piano, play the violin (有the) vs play basketball, play football (无the)。
*   **固定短语中的冠词**：in hospital (住院) vs in the hospital (在医院里)；at table (吃饭) vs at the table (在桌边)。
*   **零冠词的进阶场景**：当表示职衔、身份的名词作表语或补语时，通常不用冠词（He was elected monitor）。""",
            syllabusDetails = listOf(
                "1. 精准区分 a 与 an，掌握根据首音素而非字母判别的黄金法则（重点：h, u 开头的特殊词）。",
                "2. 掌握定冠词 the 的核心特指功能：上文提及、谈话双方已知、独一无二、序数词、最高级、姓氏复数前（the Smiths）。",
                "3. 熟记零冠词（不加冠词）的法定场景：球类、棋类、三餐、节假日（春节等除外）、学科、季节、月份。",
                "4. 理解冠词在固定搭配中的‘有无’差异及其语义变化（如 go to school vs go to the school）。",
                "5. 掌握‘the + 形容词’（the rich）表示一类人的用法，以及谓语动词的复数匹配。",
                "6. 掌握 a second/a third 表示“又一，再一”的特殊语义。"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词", "冠词的存在前提", "冠词必须依附于名词，名词的可数性与单复数决定冠词形式。"),
                RelatedPoint("形容词最高级", "the 的固定伴侣", "最高级前通常必须加 the，除非有物主代词。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "重庆中考", "I have ______ uncle who is ______ English teacher in a middle school.", listOf("A. a; an", "B. an; a", "C. an; an", "D. a; a"), "C", "【答案】C。本题考查不定冠词。uncle 首音素为元音 /ʌ/，用 an；English 首音素为元音 /ɪ/，用 an。", "根据字母 U 和 E 盲选，虽然此题字母和音素一致，但方法需准确。", "我有一个叔叔，他在一所中学当英语老师。"),
                PastExamQuestion("2023", "天津中考", "Look! ______ boy in a blue jacket is playing ______ guitar on the street.", listOf("A. The; the", "B. A; the", "C. The; /", "D. A; /"), "A", "【答案】A。本题考查定冠词特指与习惯用法。in a blue jacket 是定语修饰 boy，表特指，用 the；play 乐器固定加 the。", "忽略介词短语的特指作用。", "看！那个穿蓝色夹克的男孩正在街上弹吉他。"),
                PastExamQuestion("2022", "成都中考", "______ moon moves around ______ earth.", listOf("A. A; an", "B. The; the", "C. The; /", "D. /; the"), "B", "【答案】B。本题考查独一无二的事物。月球和地球都是世间独一无二的自然天体，均须加 the。", "认为地球前面不用加冠词。", "月球绕着地球转。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("It takes me an hour to finish my homework every day. After that, I usually play the violin for thirty minutes because I want to be a great musician in the future. It is a good way to relax and keep a peaceful mind. Sometimes I go to play basketball with my friends in the park. We always have a great time there because exercise is good for our health.", listOf(
                    HighlightedSentence("takes me an hour", "hour 以辅音字母 h 开头，但音素为元音 /aʊə/，故用 an。"),
                    HighlightedSentence("play the violin... play basketball", "经典对比：西洋乐器前加 the，球类运动前不加冠词。")
                ), "人教版七下 Unit 6"),
                TextbookParagraph("Mount Everest is the highest mountain in the world. It is a symbol of courage for many climbers who want to challenge themselves. People from all over the world come to visit the Himalayas to see the amazing view. However, we should also pay attention to the environment because the mountain needs our protection. It is a treasure of the earth.", listOf(
                    HighlightedSentence("the highest mountain", "形容词最高级 highest 前必须使用定冠词 the。"),
                    HighlightedSentence("a symbol of courage", "symbol 是可数名词，此处表泛指，courage 是抽象名词，不加冠词。")
                ), "外研版九上 Module 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("He is a university student, but he is an honest person.", "他是一名大学生，但他是一个诚实的人。", "【分析】university 首音为辅音 /j/，honest 首音为元音 /ɒ/，极易出错。", "中考核心"),
                ExampleSentence("The rich should help the poor in our community.", "我们社区的富人应该帮助穷人。", "【分析】'the + 形容词' 表示一类人，谓语动词用复数。", "高阶句式"),
                ExampleSentence("Sunday is the first day of a week.", "星期日是一周的第一天。", "【分析】序数词 first 前加 the，week 初次提到用 a。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. an 后面接辅音音素开头的词（如 an useful tool）；2. 球类乐器冠词混淆；3. 忽略形容词最高级前的 the；4. 混淆 in hospital 与 in the hospital 的含义。"),
                TeachingNote("教学建议", "采用‘绕口令’或‘口诀’记忆音素差异：‘元音音素用 an，辅音音素 a 领先；乐器 the，球类零，最高级前 the 必行。’ 配合具体的图画演示特指与泛指。")
            ),
            famousQuote = "The journey of a thousand miles begins with a single step.",
            quoteAuthor = "Lao Tzu"
        ),
        KnowledgePoint(
            id = "numerals",
            section = SEC_1,
            title = "数词 (Numerals)",
            description = """### 核心概念详解
数词 (Numerals) 是描述客观世界数量与顺序的语法工具，分为基数词和序数词。在中考评价中，数词的考查不仅涉及拼写（如 forty, ninety, twelfth, fortieth 的拼写陷阱），更侧重于各种应用场景。基数词用于计数（one, two...），而序数词用于排序（first, second...）。二者的转换规律是基础，特别是 1-3 的特殊形式及以 y 结尾的变化。此外，数词的大数表达（hundred, thousand, million, billion）涉及到“精准”与“模糊”的博弈：当与具体数字连用时，单位词不加 s（two hundred students）；当表示模糊的“成千上万”时，必须加 s 且接 of（hundreds of students）。此外，分数、小数、百分数、时刻、日期及编号（Lesson One vs the first lesson）的切换，也是中考必考内容。

### 深度考点解析
*   **单位词的‘s’定律**：明确数字 + hundred/thousand/million (不加s)；hundreds/thousands/millions + of (必须加s)。注意：如果名词前有 these/those 等修饰，通常也用具体形式（如 five hundred of these students）。
*   **序数词的‘定冠词’特例**：通常序数词前加 the，但当表示‘再一、又一’时，序数词前可接不定冠词 a/an（He has tried three times and he wants a fourth try.）。
*   **编号表达的逆向思维**：Lesson One = The first lesson; Room 302 = the third room (如果指顺序)。注意：名词在前用基数（通常首字母大写），the 在前用序数。
*   **分数与主谓一致**：分数的分子用基数，分母用序数（分子大于1时分母加s）。其谓语动词的数由分数后的名词决定（two-thirds of the books are; two-thirds of the water is）。""",
            syllabusDetails = listOf(
                "1. 熟练掌握 1-100 基数词及其对应序数词的不规则变化拼写（重点：eighth, ninth, twelfth, twentieth, forty, ninety）。",
                "2. 精准运用大数单位 hundred, thousand, million 的‘具体’（不加s/of）与‘模糊’（加s/of）表达法则。",
                "3. 掌握分数的构成法则：分子基数词，分母序数词；分子大于一，分母加 s（如 three-quarters）。",
                "4. 理解编号、电话号码（0读zero或o）、年份（2024读twenty twenty-four）、日期（May 1st）、时间（past/to）的正确读法。",
                "5. 掌握 a second/a third 等表示‘又一，再一’的非排序性用法语义。",
                "6. 掌握百分数 (percent) 的用法及在主谓一致中的体现。"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词", "数词修饰名词", "基数词大于一，名词须用复数。"),
                RelatedPoint("形容词最高级", "序数词后的最高级", "the second longest river 表示‘第二长’。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "合肥中考", "About ______ students in our school will take part in the sports meeting next month.", listOf("A. two hundreds", "B. two hundred of", "C. two hundred", "D. hundreds of"), "C", "【答案】C。本题考查数词大数表达。具体数字 two 后面的 hundred 不加 s，也不接 of。", "two 后面的 hundred 加了 s。", "我们学校大约有两百名学生将参加下个月的运动会。"),
                PastExamQuestion("2023", "西安中考", "Today is my mother's ______ birthday. I will buy her a gift.", listOf("A. forty", "B. fortieth", "C. the fortieth", "D. fourteenth"), "B", "【答案】B。本题考查序数词。表示几岁生日用序数词。forty 的序数词是 fortieth。注意：有了 my 所有格，不能再加 the。", "拼写错误或多加 the。", "今天是我妈妈四十岁生日。我要给她买个礼物。"),
                PastExamQuestion("2022", "沈阳中考", "______ of the students in our class ______ from the countryside.", listOf("A. Two-three; is", "B. Two-thirds; are", "C. Second-three; are", "D. Two-third; is"), "B", "【答案】B。本题考查分数与主谓一致。三分之二：分子 2 (two)，分母 3 (thirds)；主语是 students，复数意义，谓语用 are。", "分子分母词类混淆，主谓一致判断错误。", "我们班三分之二的学生来自农村。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("The library has thousands of books on different subjects for students to read. Last year, about five hundred new books were added to the collection to meet the growing needs. On the second floor, you can find many interesting magazines and newspapers. More than two-thirds of the students visit the library at least once a week to gain more knowledge.", listOf(
                    HighlightedSentence("thousands of books", "模糊表达：thousand 加 s 并接 of，表示成千上万。"),
                    HighlightedSentence("two-thirds of the students", "分数表达：分子基数 2，分母序数 3 且加 s。")
                ), "人教版八下 Unit 2"),
                TextbookParagraph("The 19th Asian Games were held in Hangzhou in 2023. Athletes from many countries competed for hundreds of gold medals in various sports events. For some athletes, it was their first time to join such a big event in China. They tried their best to win and achieved great success for their countries after years of hard training.", listOf(
                    HighlightedSentence("The 19th Asian Games", "序数词 19th 前加 the，表示特定届数。"),
                    HighlightedSentence("their first time", "序数词 first 表达顺序，在形容词性物主代词后不加 the。")
                ), "外研版九下 Module 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("Please open your books to Page 12 and read the second paragraph.", "请把书翻到第 12 页，读第二段。", "【分析】Page 12 (基数词) 等于 the twelfth page (序数词)。", "基础必会"),
                ExampleSentence("One-fifth of the surface of the earth is covered with forests.", "地球表面五分之一被森林覆盖。", "【分析】分子是 1 (one)，分母用序数词单数 (fifth)。", "中考核心"),
                ExampleSentence("The population of this city is about three million.", "这个城市的人口大约是三百万。", "【分析】million 在具体数字后不加 s。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. forty 拼写成 fourty；2. ninety 拼写成 ninty；3. 具体数字后 hundred 加 s；4. 序数词 eighth/twelfth 拼写错误。"),
                TeachingNote("教学建议", "采用‘顺口溜’记忆序数词：‘一二三，特殊记，八去 t，九去 e，ve 要用 f 替，ty 变成 tie，再加 th。’ 练习读大数（如 12,345）的断句。")
            ),
            famousQuote = "A single death is a tragedy; a million deaths is a statistic.",
            quoteAuthor = "Joseph Stalin"
        ),
        KnowledgePoint(
            id = "adj_adv",
            section = SEC_1,
            title = "形容词与副词 (Adj & Adv)",
            description = """### 核心概念详解
形容词 (Adjectives) 与副词 (Adverbs) 是语言的“调色板”。形容词主要修饰名词，描述特征（a big apple）；副词修饰动词、形容词、副词或全句（run fast, very good）。中考的高频考点集中在比较等级（Comparative & Superlative Degrees）的构建与运用。考生需熟练掌握规则变化（+er/est 或 more/most）与不规则变化（good/well-better-best, bad/badly-worse-worst, far-farther/further-farthest/furthest, many/much-more-most, little-less-least）。在句式运用上，as...as 的同级比较、'比较级 + than' 的差级比较、'the + 最高级 + in/of' 的最高级表达是核心。此外，形容词的位置（多个形容词修饰名词的排序：大小形状颜色来源材料）以及副词的位置（enough 必后置，always 等频度副词行前系后）也是重难点。

### 深度考点解析
*   **比较级的隐形对手**：在比较句中，需注意 any other + 单数名词，确保比较的对象不在同一范围内（He is taller than any other boy in his class）。
*   **修饰词的阶级森严**：much, even, far, a bit, a little, still 可修饰比较级；而 very, quite, so, too 只能修饰原级。这是单选题中的常考迷惑项。
*   **Enough 的位移法则**：enough 做形容词修饰名词可在前（enough money），做副词修饰形容词/副词必须在后（tall enough, fast enough）。
*   **-ed vs -ing 形容词**：boring/exciting 修饰物（事物的性质）；bored/excited 修饰人（人的感受）。
*   **The + 比较级, the + 比较级**：表示“越...越...”，这是中考高分作文的必备句型。""",
            syllabusDetails = listOf(
                "1. 掌握形容词作定语、表语的功能；副词修饰动词、形容词、副词及全句的用法。",
                "2. 熟练掌握比较级与最高级的规则拼写与不规则变化表（重点记忆：less, worst, farther/further）。",
                "3. 灵活运用比较级核心句型：as...as, not so/as...as, than, the + 比较级... the + 比较级...。",
                "4. 辨析易混淆词：hard vs hardly, late vs lately, wide vs widely, close vs closely。",
                "5. 掌握多个形容词修饰名词的语序规则（口诀：美小圆长高，颜国材）。",
                "6. 掌握 enough, very, much 等程度副词的精准位置及修饰对象。"
            ),
            relatedPoints = listOf(
                RelatedPoint("系动词", "形容词作表语", "look, smell, taste, sound, feel, become, get, turn 等系动词后接形容词。"),
                RelatedPoint("副词", "动词的修饰", "及物动词与副词的位置关系（如 put them on）。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "贵阳中考", "The more books you read, the ______ your life will be.", listOf("A. rich", "B. richer", "C. richest", "D. the richest"), "B", "【答案】B。本题考查 'the + 比较级, the + 比较级' 结构，表示‘越...越...’。", "在第二个比较级前又加了 the 或选了原级。", "你读的书越多，你的生活就会越丰富。"),
                PastExamQuestion("2023", "长沙中考", "He is ______ enough to carry the heavy box for his grandma.", listOf("A. strong", "B. stronger", "C. the strongest", "D. strongly"), "A", "【答案】A。本题考查 enough 修饰形容词原级且后置的规则。enough 修饰原级，故选 strong。", "选了比较级或副词形式。", "他力气足够大，能帮奶奶搬那个重盒子。"),
                PastExamQuestion("2022", "福州中考", "My English teacher is very patient. She speaks ______ in class than before.", listOf("A. more slowly", "B. most slowly", "C. slowly", "D. slowlier"), "A", "【答案】A。本题考查副词比较级。有 than 提示比较级；slowly 是双音节副词，比较级在前面加 more。", "错误拼写 slowlier 或忽略 than。", "我的英语老师很有耐心。她在课堂上说话比以前更慢了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Traveling by train is slower than by plane, but it is much more interesting for most travelers. You can see many beautiful villages and mountains through the window during the journey. For me, it is the most relaxing way to spend my holiday with my family. I feel very excited whenever I start a new journey to a far place.", listOf(
                    HighlightedSentence("much more interesting", "much 可用来修饰比较级 more interesting，加强程度。"),
                    HighlightedSentence("the most relaxing way", "relaxing 是形容词，三音节及以上词最高级在前面加 the most。")
                ), "人教版八下 Unit 3"),
                TextbookParagraph("In the soccer match yesterday, Lin Tao played really well. He ran faster than any other player in his team and scored two goals. Although he felt extremely tired after the game, he was very happy because they won the first prize. All the students were excited and cheered loudly for their success.", listOf(
                    HighlightedSentence("played really well", "well 是副词修饰动词 played，really 是副词修饰副词 well。"),
                    HighlightedSentence("faster than any other player", "比较级 + than any other + 名词单数，表示在同一范围内最...。")
                ), "外研版九上 Module 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("The film is so boring that I feel bored with it.", "这部电影太无聊了，以至于我对它感到很厌烦。", "【分析】boring 修饰物，bored 修饰人的感受。", "基础必会"),
                ExampleSentence("Li Hua is taller than any other student in his class.", "李华比他班上任何其他学生都高。", "【分析】any other + 名词单数，表示最高级含义。", "中考核心"),
                ExampleSentence("He works hard and he can hardly find time to rest.", "他工作努力，几乎找不到休息的时间。", "【分析】hard 是努力，hardly 是几乎不，词义完全不同。", "高频易错")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. Very 修饰比较级（应为 much/even/a bit）；2. 比较级前多加 more（如 more taller）；3. Enough 位置放错；4. hard/hardly 词义混淆。"),
                TeachingNote("教学建议", "使用‘情感对比法’：-ing 修饰事物，-ed 修饰人；利用‘天平逻辑’讲解 as...as 结构；通过连词成句练习多个形容词的排列顺序。")
            ),
            famousQuote = "The harder you work, the luckier you get.",
            quoteAuthor = "Gary Player"
        ),
        KnowledgePoint(
            id = "prepositions",
            section = SEC_1,
            title = "介词 (Prepositions)",
            description = """### 核心概念详解
介词 (Prepositions) 是英语句子的“粘合剂”，用于表达时间、方位、方式、原因等逻辑关系。中考介词考查的深度在于其多义性与固定搭配。时间介词中，at 用于具体时刻（at 8:00），on 用于具体某一天（on Monday, on a rainy morning），in 用于时间段（in the morning, in 2024）。方位介词涉及 above/over (上方), under/below (下方), between (两者之间) / among (三者及以上), in front of (外部前面) / in the front of (内部前面) 等。此外，介词与动词、形容词的固定搭配（be interested in, look forward to, be good at）是重中之重。方式介词 by, with, in 的辨析：by bus (交通方式), with a pen (工具), in English (语言)。

### 深度考点解析
*   **In 的‘将来时’用法**：in + 时间段表示‘多久之后’，用于一般将来时，对其提问用 How soon。
*   **Through, Across, Past 的三维差异**：Across 强调表面穿过（cross the road）；Through 强调空间内部穿过（through the forest/window）；Past 强调从侧面经过。
*   **By 的多重面孔**：可表交通方式、时间截止（by the end of）、动作执行者（in passive voice）、位置（beside）以及‘通过...方式’（by doing）。
*   **介词短语的同义转换**：because of + n. = because + clause; with the help of = with one's help.
*   **Between vs Among**：Between 通常指两者之间（或三者间的一对一关系）；Among 指三者或三者以上。""",
            syllabusDetails = listOf(
                "1. 深刻理解时间介词 at, on, in 的层级差异及其在特定节日、时刻、早中晚中的运用。",
                "2. 掌握方位介词的动态（into, onto）与静态（in, on）区分，及 above/over, below/under 的辨析。",
                "3. 熟练掌握 50 组以上高频介词固定搭配（动词+介词，形容词+介词，名词+介词）。",
                "4. 区分‘穿过’类介词：through, across, past 的语境模型并能准确应用。",
                "5. 掌握 by, with, in 表示‘方式、工具、语言手段’的语义细微差别。",
                "6. 掌握介词后的宾语形态（名词、代词宾格、动名词 doing）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("动词短语", "介词是核心", "动词+介词构成的短语通常具有特定语义且不可分割。"),
                RelatedPoint("状语从句", "逻辑连接的简化", "介词短语常可与状语从句进行同义转换（如 although -> despite）。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "武汉中考", "The charity show will start ______ 8:00 p.m. ______ the evening of June 1st.", listOf("A. at; on", "B. at; in", "C. on; in", "D. in; on"), "A", "【答案】A。本题考查时间介词。8:00 是具体时刻，用 at；the evening of June 1st 是具体某一天的晚上，用 on。", "认为 evening 必须用 in，忽略了 of 的限定作用。", "慈善义演将于 6 月 1 日晚上 8 点开始。"),
                PastExamQuestion("2023", "济南中考", "It is difficult to walk ______ the forest because of the thick trees.", listOf("A. across", "B. through", "C. past", "D. along"), "B", "【答案】B。本题考查方位介词。穿过森林属于‘从内部穿过’，用 through。", "混淆 across 和 through。", "由于树木茂密，穿过这片森林很困难。"),
                PastExamQuestion("2022", "哈尔滨中考", "The project was finished ______ the help of our teachers.", listOf("A. under", "B. in", "C. with", "D. for"), "C", "【答案】C。本题考查介词固定搭配。with the help of 是固定词组，意为‘在...的帮助下’。", "习惯性选 under（受汉语‘在...之下’影响）。", "这个项目是在我们老师的帮助下完成的。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("My home is between the post office and the bank. To get to the park, you need to go across the bridge and walk along the river for a few minutes. In the morning, many people exercise there with their friends to keep fit. It is quite peaceful on weekdays, but it becomes very crowded on weekends.", listOf(
                    HighlightedSentence("between the post office and the bank", "between... and... 连接两者，表达空间位置。"),
                    HighlightedSentence("go across the bridge", "across 表达在物体表面‘横穿’。")
                ), "人教版七下 Unit 1"),
                TextbookParagraph("Students should focus on their studies in school and participate in different activities. At the same time, they should improve their social skills. Most of them are interested in music or sports. By working together in groups, they can learn a lot from each other and develop their potential during the process.", listOf(
                    HighlightedSentence("focus on... interested in", "考查动词/形容词与介词的固定搭配。"),
                    HighlightedSentence("By working together", "by + doing 结构，表示‘通过...方式’。")
                ), "外研版九下 Module 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("The plane flew over the mountains and disappeared in the clouds.", "飞机飞过了群山，消失在云层中。", "【分析】over 表示垂直上方且有覆盖感。", "基础必会"),
                ExampleSentence("He arrived at the station in time to catch the last train.", "他及时赶到车站，赶上了最后一班火车。", "【分析】in time 是‘及时’，on time 是‘准时’。", "高频易错"),
                ExampleSentence("Don't worry about me. I can take care of myself.", "别担心我。我会照顾好自己的。", "【分析】worry about 和 take care of 是极高频的动宾搭配。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 时间介词 on/in/at 混淆（具体日期的早中晚应选 on）；2. 汉语式翻译（under one's help 是错的）；3. 方位介词 in/on/to (表示地理位置关系时) 的误用。"),
                TeachingNote("教学建议", "采用‘空间模型法’：用盒子演示 in, on, under, above, behind；用时间轴演示 at, on, in 的范围大小；通过地图练习方位介词。")
            ),
            famousQuote = "A man is known by the company he keeps.",
            quoteAuthor = "Aesop"
        ),
        KnowledgePoint(
            id = "conjunctions",
            section = SEC_1,
            title = "连词 (Conjunctions)",
            description = """### 核心概念详解
连词 (Conjunctions) 是句子的“逻辑骨架”。分为并列连词和从属连词。并列连词如 and, but, or, so 用于连接对等成分。其中 but 表转折，or 表选择或‘否则’，so 表结果。关联连词如 not only... but also..., neither... nor..., either... or... 考查“就近原则”（谓语随最近的主语变）。从属连词引导各种状语从句（时间 when, while, as soon as; 原因 because, since, as; 条件 if, unless; 让步 although, though; 结果 so...that）。中考禁忌：because 与 so 不共存，although/though 与 but 不共存。

### 深度考点解析
*   **Or 的‘否则’用法**：祈使句 + or + 陈述句（Hurry up, or you'll be late.）。这里的 or 表达如果不做前者的后果。
*   **Until 的延续与瞬间**：肯定句中接延续性动词（wait until）；否定句中接瞬间动词（not... until...，意为‘直到...才’）。
*   **While 的多义性**：既可引导时间从句（接进行时），也可表示‘然而’用于对比（I like tea while he likes coffee）。
*   **Both...and vs Neither...nor**：Both...and 谓语恒用复数；Neither...nor, Either...or, Not only...but also 遵循就近原则。
*   **So that vs So...that**：So that 引导目的状语从句（为了）；So...that 引导结果状语从句（如此...以至于）。""",
            syllabusDetails = listOf(
                "1. 掌握并列连词 and, but, or, so 的逻辑功能及在‘祈使句+and/or’结构中的运用。",
                "2. 熟练运用关联连词 both...and, either...or, neither...nor, not only...but also 及其主谓一致原则。",
                "3. 精准区分 because, as, since (原因) 与 so, therefore (结果) 的使用，牢记 bc/so 不共存原则。",
                "4. 掌握让步连词 although/though 与 but 不共存原则，以及 though 作为副词的用法。",
                "5. 灵活运用 until, unless, while, as soon as, as long as 等从属连词。",
                "6. 掌握 if 引导宾语从句（是否）与状语从句（如果）的区别。"
            ),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "就近原则", "关联连词引导主语时谓语动词的判定标准。"),
                RelatedPoint("状语从句", "引导词的选用", "从句的逻辑性质完全由从属连词决定。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "昆明中考", "Work hard, ______ you will achieve your dreams in the future.", listOf("A. and", "B. or", "C. but", "D. so"), "A", "【答案】A。本题考查‘祈使句+and+陈述句’结构，表示‘做...，那么就会...’。", "误选 so，虽然语义通，但固定句式用 and。", "努力学习，那么你未来就会实现梦想。"),
                PastExamQuestion("2023", "南昌中考", "Neither my parents nor my brother ______ to the Great Wall before.", listOf("A. have been", "B. has been", "C. were", "D. was"), "B", "【答案】B。本题考查 neither...nor 的就近原则。离谓语最近的是 my brother，单数，且有 before 提示完成时，故选 has been。", "忽略就近原则选了 have been。", "我父母和我弟弟以前都没去过长城。"),
                PastExamQuestion("2022", "天津中考", "He didn't go to bed ______ he finished his work last night.", listOf("A. until", "B. because", "C. although", "D. if"), "A", "【答案】A。本题考查 not...until 结构，表示‘直到...才’。", "逻辑判断错误。", "昨天晚上他直到做完工作才睡觉。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Although the weather was very bad yesterday, the volunteers still decided to go to the remote village to help the children. They brought not only food and clothes but also medicine to the people in need. Both the young and the old were moved by their kindness and they felt very warm in their hearts.", listOf(
                    HighlightedSentence("Although the weather was bad", "although 引导让步状语从句，句中绝不能再出现 but。"),
                    HighlightedSentence("not only food but also medicine", "关联连词连接两个并列的宾语成分。")
                ), "人教版九上 Unit 5"),
                TextbookParagraph("Study hard every day, or you will fail the final exam. If you manage your time well and focus on your studies, you will find that learning is interesting. Don't give up easily because success belongs to those who persevere and work hard for their goals in life.", listOf(
                    HighlightedSentence("Study hard, or you will", "or 在祈使句后表示‘否则’，属于选择逻辑的延伸应用。"),
                    HighlightedSentence("Don't give up because success", "because 引导原因状语从句，详细解释动作的原因。")
                ), "外研版八下 Module 6")
            ),
            exampleSentences = listOf(
                ExampleSentence("Not only the students but also the teacher likes this book.", "不仅学生而且老师也喜欢这本书。", "【分析】就近原则，谓语动词随 teacher 用单数。", "中考核心"),
                ExampleSentence("Either you or I am going to the meeting.", "要么是你，要么是我去开会。", "【分析】就近原则，谓语动词随 I 用 am。", "基础必会"),
                ExampleSentence("I'll wait here until she comes back.", "我会在这儿一直等到她回来。", "【分析】肯定句中 until 接延续性动词 wait。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. because/so, although/but 成对使用（汉语习惯误导）；2. either...or 等结构的主谓一致判断错误；3. unless 引导从句的逻辑理解（除非...否则...）。"),
                TeachingNote("教学建议", "采用‘逻辑配对图’：将 and/but/or/so 对应逻辑符号；通过改错题训练 avoid redundancy (避免 bc/so 共存)；练习 until 与 not...until 的转换。")
            ),
            famousQuote = "Life is 10% what happens to us and 90% how we react to it.",
            quoteAuthor = "Charles R. Swindoll"
        ),
        KnowledgePoint(
            id = "verbs_basic",
            section = SEC_1,
            title = "动词基础 (Verbs)",
            description = """### 核心概念详解
动词 (Verbs) 是句子的灵魂与核心动力源。英语中，没有动词就无法构成完整的逻辑表达。根据功能，动词可分为四类：1. 实义动词（及物/不及物）：表达具体的动作或心理状态（如 eat, think, sleep）；2. 系动词：用于连接主语与表语，描述主语的特征、身份或状态（如 be, look, become, feel）；3. 助动词：无实际意义，辅助构成时态、语态、否定或疑问（如 do, does, did, have, has, will）；4. 情态动词：表达说话人的语气、态度或可能性（如 can, must, may, should, need）。动词的形态变化不仅涵盖了单三、过去式、过去分词及现在分词，还涉及到不规则动词的大量记忆工作。在中考中，动词的考查不仅局限于其物理形态，更侧重于各种固定搭配（动词短语）以及在具体句型结构中的应用（如双宾语结构、宾补结构）。掌握动词的基础知识是进阶学习时态和语态的先决条件。

### 深度考点解析
*   **情态动词表推测**：这是中考的高阶难点。Must be (100%肯定), Can't be (100%否定), May/Might be (不确定推测)。注意：回答 Must 引导的‘推测’疑问句时，否定通常用 can't 而非 mustn't。
*   **感官动词的‘多面’用法**：see/hear/watch sb do (强调动作全过程或经常发生) vs doing (强调动作正在进行或瞬间场景)。这些词在变被动语态时，省略的不定式符号 to 必须‘复活’。
*   **动词短语的分类与位置**：1. 动词+副词（如 put on, pick up），若宾语是人称代词宾格，必须置于中间（put it on）；2. 动词+介词（如 look at, wait for），宾语恒置于介词后。
*   **Lie 与 Lay 的纠缠**：lie (躺；位于-lay-lain), lie (撒谎-lied-lied), lay (放置；产卵-laid-laid)。这一组词的形态区分是每年中考单选题的经典考位。
*   **Need 的‘双面性’**：既可作情态动词（否定 needn't），也可作实义动词（否定 don't need）。""",
            syllabusDetails = listOf(
                "1. 深刻掌握实义动词、系动词、助动词与情态动词的分类及其在句中的功能位置。",
                "2. 强制性背诵 100 个以上核心不规则动词的四类形态（重点：lay, lie, hang, rise/raise, fly）。",
                "3. 掌握情态动词 can, may, must, should, need 的基本用法及其表推测的逻辑链条。",
                "4. 熟练掌握 5 类感官系动词及 3 类变化系动词（become, get, turn）后接形容词作表语的用法。",
                "5. 掌握动词短语的物理分类及其在接代词宾语时的位置规则。",
                "6. 掌握使役动词 let, make, have 的基本用法及其被动还原 to 的语法规则。"
            ),
            relatedPoints = listOf(
                RelatedPoint("时态与语态", "动词的载体", "所有时态与语态的变化都最终体现在动词形态的物理切换上。"),
                RelatedPoint("五大基本句型", "动词决定句型", "动词的及物性、双宾性及系动词性直接决定了句子的走向。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "杭州中考", "— Is that Lily's schoolbag?\n— It ______ be hers. She has gone to the library with it.", listOf("A. must", "B. can't", "C. may", "D. needn't"), "B", "【答案】B。本题考查情态动词表推测。后句提到‘她已经背着包去图书馆了’，说明书包一定不是她的。can't 表示有把握的否定推测。", "忽略后半句逻辑，误选 must。", "—— 那是莉莉的书包吗？ —— 一定不是她的。她已经带着书包去图书馆了。"),
                PastExamQuestion("2023", "上海中考", "The song ______ beautiful and many people like listening to it.", listOf("A. sounds", "B. listens", "C. hears", "D. looks"), "A", "【答案】A。本题考查感官系动词。形容歌曲‘听起来’优美，用 sound。listen 是不及物动词，hear 是及物动词，不可直接加形容词。", "混淆 listen 与 sound 的词性。", "这首歌听起来很美，很多人喜欢听。"),
                PastExamQuestion("2022", "广东中考", "You ______ smoke here. Look at the sign 'No Smoking'!", listOf("A. mustn't", "B. needn't", "C. couldn't", "D. shouldn't"), "A", "【答案】A。本题考查情态动词表禁止。mustn't 意为‘绝对禁止’，符合语境要求。", "认为 needn't 表示不必要。", "你绝对不能在这里抽烟。看那个‘禁止吸烟’的牌子！")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When we meet new people for the first time, we should smile and say hello to them warmly. This simple action can help us make a good first impression on others. If we want to become good friends with people around us, we must learn how to listen to them carefully and share our thoughts honestly with each other.", listOf(
                    HighlightedSentence("should smile and say hello", "should 是情态动词，表示建议，后接动词原形。"),
                    HighlightedSentence("become good friends", "become 是变化系动词，后接名词或形容词作表语。")
                ), "人教版七上 Unit 3"),
                TextbookParagraph("The soup smells delicious! Did you put any salt or pepper in it? I can't wait to taste it right now. My mother always tells me that we should eat healthy food to keep fit and avoid eating too much junk food which may be bad for our health in the long run.", listOf(
                    HighlightedSentence("smells delicious", "smell 是感官系动词，后面直接跟形容词 delicious 作表语。"),
                    HighlightedSentence("can't wait to taste", "taste 此处作为实义动词，表示‘品尝’的动作行为。")
                ), "外研版八下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("He lay on the grass and looked at the blue sky while thinking about his future.", "他躺在草地上，看着蓝天，思考着他的未来。", "【分析】lay 是 lie (躺) 的过去式，形态上极易与 lay (放) 的原形混淆。", "高频易错"),
                ExampleSentence("The plane took off despite the heavy rain and strong wind yesterday morning.", "尽管昨天早上下大雨且刮大风，飞机还是起飞了。", "【分析】take off 是动副短语，此处意为‘起飞’。", "基础必会"),
                ExampleSentence("You must be tired after a long walk through the mountains and forests.", "翻山越岭走了这么长路，你一定累了。", "【分析】must be 表示说话者基于明显迹象做出的肯定推测。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 情态动词后加 to (除 ought to/have to 外)；2. 系动词后接副词而非形容词；3. 不规则动词过去式拼写错误；4. 混淆 raise (及物) 与 rise (不及物) 的语用功能。"),
                TeachingNote("教学建议", "建议教师建立‘动词分类树’；对情态动词采用‘百分比推测法’（100% must, 0% can't）；通过动作表演区分 lie 与 lay 的形态差异；整理 50 个高频动词短语。")
            ),
            famousQuote = "Action speaks louder than words.",
            quoteAuthor = "English Proverb"
        ),
        KnowledgePoint(
            id = "simple_present",
            section = SEC_2,
            title = "一般现在时 (Simple Present)",
            description = """### 核心概念详解
一般现在时 (Simple Present) 是英语时态体系的基准点，其核心功能是表达“常态”。在中考评价体系中，它主要涵盖三个层面的含义：1. 经常性、习惯性的动作或存在的状态，常与 always, usually, often, sometimes, seldom, never 等频度副词连用；2. 客观真理、科学事实、格言警句以及不受时间限制的客观存在（如 The earth moves around the sun）；3. 现阶段的能力、特征或职业。该时态最核心也是最易出错的考点是“单三变化”：当主语是 he, she, it, Tom, everyone, nobody 等单数第三人称时，谓语动词必须进行形态变换（+s/es/ies）。此外，在由 if, unless 引导的条件状语从句或 when, as soon as, before, until 引导的时间状语从句中，必须遵循“主将从现”原则，即从句用一般现在时表达将来的逻辑前提。

### 深度考点解析
*   **单三变化的‘隐形主语’**：Everyone, Nobody, Someone, Each of the students, The number of students 等结构作主语时，谓语动词需视为单三。与之相对的是 A number of students 需接复数谓语。
*   **主将从现的‘扩展应用’**：不仅限于 if，在 as soon as (一...就) 和 until (直到...) 引导的从句中，若主句表达未来意图，从句必须锁定一般现在时。
*   **频度副词的‘黄金定位’**：通常遵循“行前系后”原则（位于实义动词前，系动词/助动词/情态动词后）。
*   **时刻表的‘将来感’**：对于按官方时间表运行的飞机、火车、公交、课程、电影等，常用一般现在时表达已确定的将来安排（The train leaves at 8:00 tomorrow）。
*   **状态动词的‘禁区’**：Know, love, want, belong to, hate 等表示心理状态或所属关系的动词，通常只用于一般现在时，很少进入进行时态。""",
            syllabusDetails = listOf(
                "1. 深刻掌握一般现在时的三大核心功能：习惯动作、客观真理、现阶段状态。",
                "2. 熟练运用动词单三的变化规则（规则加s, 以o/s/x/ch/sh结尾加es, 辅音+y变i加es, have变has）。",
                "3. 掌握否定句 (don't/doesn't + 原形) 与疑问句 (Do/Does... + 原形) 的形态变换及其动词还原逻辑。",
                "4. 深刻领悟并能灵活应用‘主将从现’原则于时间、条件状语从句中。",
                "5. 掌握频度副词的语义层级及其在句中的标准位置规则。",
                "6. 理解一般现在时在描述图片内容、书评或电影情节时的特殊叙述功能。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在进行时", "习惯 vs 瞬间", "一般现在时侧重习惯与规律，现在进行时侧重此刻的动态。"),
                RelatedPoint("主谓一致", "单三变化的基础", "理解主语的‘数’与‘格’是正确运用一般现在时的物理前提。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "北京中考", "Our teacher tells us that the sun ______ in the east every day.", listOf("A. rise", "B. rises", "C. rose", "D. will rise"), "B", "【答案】B。本题考查客观真理。太阳从东方升起是永恒的事实，必须用一般现在时，且主语 sun 为单三，动词加 s。", "看到前句 tells 误以为是宾语从句时态呼应选 rose。", "老师告诉我们太阳每天从东方升起。"),
                PastExamQuestion("2023", "苏州中考", "If it ______ sunny tomorrow, we ______ a picnic in the park.", listOf("A. will be; have", "B. is; will have", "C. will be; will have", "D. is; have"), "B", "【答案】B。本题考查‘主将从现’。if 引导条件状语从句，从句用一般现在时 is，主句用一般将来时 will have。", "从句也使用了将来时 will be。", "如果明天天气晴朗，我们将在公园野餐。"),
                PastExamQuestion("2022", "成都中考", "He ______ to school by bike every day to protect the environment and keep fit.", listOf("A. go", "B. goes", "C. went", "D. is going"), "B", "【答案】B。本题考查日常习惯。every day 提示一般现在时，主语 He 是单三，动词用 goes。", "忽略单三变化。", "他每天骑自行车上学以保护环境并保持健康。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("I usually get up at 6:30 in the morning every day to get ready for school. Then I brush my teeth and have a simple breakfast with my parents. My school starts at 8:00 and we have many interesting classes. I always try my best to get to school on time because I don't want to be late for class and miss anything important.", listOf(
                    HighlightedSentence("usually get up", "usually 提示习惯动作，位于实义动词 get 之前。"),
                    HighlightedSentence("school starts", "school 是单三主语，谓语动词 start 必须加 s。")
                ), "人教版七上 Unit 5"),
                TextbookParagraph("The Amazon River flows through South America and it is very important for the earth. It is the second longest river in the world, but it carries more water than any other river. Many different kinds of animals and plants live in the rainforest around it and they form a complex ecosystem that supports many lives.", listOf(
                    HighlightedSentence("flows through", "描写科学事实或地理特征，固定使用一般现在时。"),
                    HighlightedSentence("animals and plants live", "复数主语 match 动词原形 live。")
                ), "外研版九下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("Practice makes perfect in whatever you choose to do in your life.", "无论你一生中选择做什么，熟能生巧。", "【分析】格言警句永远使用一般现在时。", "基础必会"),
                ExampleSentence("I will call you as soon as I arrive at the bus station tomorrow.", "我一到达汽车站就给你打电话。", "【分析】as soon as 引导时间状语从句，遵循主将从现原则。", "中考核心"),
                ExampleSentence("Everyone in our class enjoys reading English stories after school.", "我们班里的每个人都喜欢在放学后读英语故事。", "【分析】Everyone 在语法上视为单三含义，谓语动词用 enjoys。", "高频易错")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 忘记单三变化（特别是 does 出现后动词不还原）；2. 客观真理误用过去式；3. 主将从现中从句用了将来时；4. 频度副词位置摆放错误。"),
                TeachingNote("教学建议", "设计‘单三警报器’训练；利用学校时刻表进行造句练习；通过对比 if 引导的宾语从句与状语从句来强化‘时态区分’。")
            ),
            famousQuote = "The early bird catches the worm.",
            quoteAuthor = "English Proverb"
        ),
        KnowledgePoint(
            id = "simple_past",
            section = SEC_2,
            title = "一般过去时 (Simple Past)",
            description = """### 核心概念详解
一般过去时 (Simple Past) 是记录历史的“刻刀”，用于描述在过去特定时间发生的动作、存在的状态或反复发生的习惯。在中考语境下，识别该时态的关键在于锁定明确的过去时间状语（如 yesterday, last night, two days ago, in 2010, just now）。物理构成上，该时态的核心是动词过去式（did）。重点难点集中在动词形态的变换：1. 规则变化（+ed），需特别注意双写末尾辅音字母（如 stopped, planned）及辅音+y变i（如 studied）；2. 不规则变化，中考要求掌握约 100 个高频不规则动词（如 begin-began, buy-bought, go-went）。在否定句和疑问句中，强制借用助动词 did，此时随后的实义动词必须“打回原形”。此外，该时态常用于叙述已故人物的生平事迹或描述过去一连串紧凑发生的动作。

### 深度考点解析
*   **不规则动词的‘多胞胎’与‘陷阱’**：read-read (拼写不变音变), cost-cost, cut-cut (AAA型)；begin-began, drink-drank (ABC型)。这些词是语法填空的必考点。
*   **Ago 与 Before 的时态界限**：‘时间段 + ago’是锁定一般过去时的黄金标志；而 before 若不接具体点，通常用于完成时或单独表达‘以前’。
*   **Used to do sth 的习惯表达**：表示‘过去常常做某事’，暗示现在不再做了。需严格区分于 be used to doing (习惯于做某事)。
*   **宾语从句中的‘时态后退’**：当前句主语是 said, thought, told 等过去式时，从句原本的现在时态必须强制退后为过去时态。
*   **Just now vs Right now**：Just now 意为‘刚才’，必接过去时；Right now 意为‘现在’，必接进行时。
*   **描述过去一连串动作**：如 He got up, washed his face and had breakfast. 多个动作并列时，时态必须保持一致。""",
            syllabusDetails = listOf(
                "1. 深刻理解一般过去时的核心语义：过去发生的动作，与现在无因果联结。",
                "2. 熟练掌握规则动词过去式的四种变化规则（重点关注双写字母，如 stop-stopped, plan-planned）。",
                "3. 强制性、精准记忆中考核心 100 个不规则动词表（重点：ABC, ABB 型及形态相似项）。",
                "4. 掌握否定句 (didn't + do) 与疑问句 (Did... + do?) 的构成及动词还原逻辑。",
                "5. 深刻辨析 used to do 与 be used to doing 的语法结构与语义差异。",
                "6. 掌握一般过去时在间接引语转换及宾语从句中的‘时态一致性’原则。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在完成时", "点 vs 线", "过去时强调动作发生的孤立历史点，完成时强调动作对现在的延伸影响。"),
                RelatedPoint("过去进行时", "背景 vs 瞬间", "过去进行时描述宏观背景，一般过去时描述背景下发生的具体、突发动作。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "南京中考", "— Where is your sister?\n— She ______ for the library ten minutes ago to return some books.", listOf("A. leaves", "B. left", "C. has left", "D. is leaving"), "B", "【答案】B。本题考查时间状语的提示。ten minutes ago 明确提示一般过去时，故选 left。", "被现在完成时 C 干扰。", "—— 你姐姐在哪？ —— 她十分钟前去图书馆还书了。"),
                PastExamQuestion("2023", "武汉中考", "My father ______ to work by car, but now he takes the subway every day.", listOf("A. used to go", "B. is used to go", "C. uses to go", "D. used to going"), "A", "【答案】A。本题考查 used to do 结构。表示‘过去常常’，且与后半句的 now 形成鲜明对比。", "混淆 used to do 与 be used to doing。", "我爸爸过去开车上班，但现在他每天乘地铁。"),
                PastExamQuestion("2022", "福州中考", "When I was a child in the village, I ______ often go fishing with my grandfather.", listOf("A. would", "B. will", "C. should", "D. must"), "A", "【答案】A。本题考查 would 表‘过去常常’。在过去语境中（When I was a child），would 可表示过去的习惯性动作。", "误选 will，忽略了过去背景。", "当我还是个孩子在村里时，我经常和爷爷去钓鱼。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Yesterday was a very busy and exciting day for me. I woke up at 7:00 and had a quick breakfast with my family before leaving. Then I went to the history museum with my classmates by school bus. We saw many interesting exhibitions and took a lot of photos during the long visit. It was an unforgettable experience that I will remember forever because I learned so much.", listOf(
                    HighlightedSentence("Yesterday was a busy day", "Yesterday 明确锁定全篇基调为一般过去时。"),
                    HighlightedSentence("went... saw... took", "一系列不规则动词过去式的连用，描述过去连续发生的动作。")
                ), "人教版七下 Unit 11"),
                TextbookParagraph("In ancient times, people used to communicate by sending smoke signals or using birds to deliver messages. It took a long time to deliver an important message to a far place. But after the telephone was invented by Bell, communication became much easier and faster. This great invention changed the way people lived and worked around the world completely.", listOf(
                    HighlightedSentence("used to communicate", "used to do 表达过去长期存在的习惯、状态或方式。"),
                    HighlightedSentence("became much easier", "became 是 become 的过去式，详细描述过去状态的显著改变。")
                ), "外研版九下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("I found my lost key under the sofa in the living room just now.", "我刚才在客厅沙发下面找到了丢的钥匙。", "【分析】just now 是一般过去时的核心标志词，意为‘刚才’。", "基础必会"),
                ExampleSentence("He said he would help me with my English study in the next semester.", "他说过他下学期会帮我学英语。", "【分析】由于主句谓语 said 为过去式，从句 will 必须变为 would。", "中考核心"),
                ExampleSentence("Did you have a good time at the birthday party last Saturday night?", "上周六晚上你在生日派对上玩得开心吗？", "【分析】疑问句中借用助动词 did，随后的实义动词必须还原为 have。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 过去式拼写错误（如 stoped, planed, studyed）；2. 疑问/否定句忘了动词还原（如 Did you went?）；3. 忽略不规则动词（如 buyed, eated）；4. 混淆 used to do 与 be used to doing。"),
                TeachingNote("教学建议", "采用‘故事接龙’法练习过去式应用；将不规则动词分组（如 ABC, ABB, AAA）记忆；利用时间轴区分 ago, before 与 since 的用法差异。")
            ),
            famousQuote = "The past is a foreign country; they do things differently there.",
            quoteAuthor = "L.P. Hartley"
        ),
        KnowledgePoint(
            id = "simple_future",
            section = SEC_2,
            title = "一般将来时 (Simple Future)",
            description = """### 核心概念详解
一般将来时 (Simple Future) 是通往“明天”的窗口，用于表达将来发生的动作、存在的状态或主观的打算。在中考中，该时态主要呈现为两种物理构成：1. 'will + 动词原形'，侧重于表示对未来的纯粹预测、承诺或临时的决定（如 I will help you）；2. 'be going to + 动词原形'，侧重于事先经过考虑的计划、打算或基于当前明显迹象的必然推测（如 Look at the clouds, it's going to rain）。常见的时间状语包括 tomorrow, next week, soon, in the future, 以及极其重要的‘in + 时间段’（表示多久之后）。中考的杀手级考点包括：There be 句型的将来时形态（严禁 There will have）、位移动词用现在进行时表将来、以及在状语从句中严格执行的“主将从现”原则。

### 深度考点解析
*   **Will 与 Be going to 的博弈**：Will 语气正式，多用于第一人称表达意愿或第三人称表达预测；Be going to 语气非正式，强调主观的“意图性”或眼前的“征兆性”。
*   **There will be 的‘变身’法则**：否定形式为 There won't be；疑问形式为 Will there be...?。重点防范汉语思维导致的 There will have 错误。
*   **主将从现的‘广泛适用’**：If (如果), when (当...时), as soon as (一...就), unless (除非), until (直到...) 引导的从句均遵循此规则。
*   **In + 时间段的‘提问专区’**：表示‘...之后’，常用一般将来时，对其提问必须使用 How soon 而非 How long。
*   **官方时刻表表将来**：按计划进行的课程、飞机、火车运行，习惯用一般现在时替代一般将来时（The flight takes off at 9:00 tonight）。""",
            syllabusDetails = listOf(
                "1. 熟练掌握一般将来时的两种基本构成（will vs be going to）及其否定、疑问形态。",
                "2. 深度辨析 will 与 be going to 在‘计划性’、‘意愿性’与‘必然性’上的语境差异。",
                "3. 熟练掌握‘主将从现’原则，并在复合句填空题中正确选择时态。",
                "4. 掌握 There be 句型的一般将来时构成及其与 have 的本质辨析。",
                "5. 理解位移动词（go, come, leave, start, arrive）用现在进行时表示将来确定的、近期的安排。",
                "6. 掌握 be about to (正要做) 表示即将发生的动作，通常不接具体的时间状语。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在进行时", "意图的交叉", "进行时表示将来仅限于特定动词，侧重已确定的、近期的位移安排。"),
                RelatedPoint("过去将来时", "时轴的后退", "主句为过去时（如 said）时，从句 will 变 would，构成过去将来视角。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "重庆中考", "— What's your plan for the upcoming summer holiday?\n— I ______ a volunteer in the local community.", listOf("A. am", "B. was", "C. will be", "D. have been"), "C", "【答案】C。本题考查语境逻辑。问句提到 plan（计划），暗示动作尚未发生，故用一般将来时表达未来的打算。", "误选一般现在时 A，认为是在陈述现状。", "—— 你暑假有什么计划？ —— 我要在当地社区当一名志愿者。"),
                PastExamQuestion("2023", "西安中考", "There ______ a wonderful concert in our school hall tomorrow evening.", listOf("A. will have", "B. is going to have", "C. will be", "D. is going to be"), "D", "【答案】D。本题考查 There be 句型的将来时。不能使用 have，必须用 be。C和D均可，但 D 项 be going to be 更常用于计划好的活动安排。", "错误使用 There will have。", "明天晚上我们学校礼堂将有一场精彩的音乐会。"),
                PastExamQuestion("2022", "沈阳中考", "I ______ you if I get any news about the English competition.", listOf("A. tell", "B. told", "C. will tell", "D. have told"), "C", "【答案】C。本题考查‘主将从现’。if 引导条件状语从句用一般现在时（get），主句用一般将来时。", "主从句时态混淆，或误选 tell。", "如果我有关于英语比赛的消息，我会告诉你的。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("In the future, robots will do most of the heavy, boring and dangerous work for humans. We will have more free time to enjoy our lives and develop our personal hobbies. Scientists are going to develop smarter machines that can understand our feelings. It is going to be an exciting world where everyone can live a better and easier life.", listOf(
                    HighlightedSentence("robots will do", "will 表示对未来客观科技发展的预测。"),
                    HighlightedSentence("going to develop", "be going to 表达科学家们已经制定并正在实施的研发计划。")
                ), "人教版八上 Unit 7"),
                TextbookParagraph("Next month, our class is going to have a sports meeting on the playground. I am going to join the 100-meter race to challenge my speed. I will practice every afternoon after school to get a good result. I hope I will win a gold medal for my class and make my classmates proud of my hard work.", listOf(
                    HighlightedSentence("is going to have", "表达学校已经安排好的、确定的近期活动。"),
                    HighlightedSentence("will practice", "表达说话者个人的决心和未来即将执行的一系列行动。")
                ), "外研版七下 Module 10")
            ),
            exampleSentences = listOf(
                ExampleSentence("Wait a second, I will help you with those heavy bags on the stairs.", "等一下，我来帮你提楼梯上那些沉重的包。", "【分析】will 表达说话瞬间产生的、临时的帮助意图。", "基础必会"),
                ExampleSentence("Look at the dark clouds! It is going to rain very soon, so let's go home.", "看那些乌云！马上就要下雨了，我们回家吧。", "【分析】be going to 表达基于目前明显客观迹象的必然推测。", "中考核心"),
                ExampleSentence("When are you leaving for London to start your new university life?", "你什么时候启程去伦敦开始你的新大学生活？", "【分析】用现在进行时表示已经确定的、正在准备中的位移计划。", "高阶句式")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. There will have (最重灾区)；2. be going to 漏写 be 动词；3. will 后面动词误用单三或过去式；4. 主将从现中从句用了 will。"),
                TeachingNote("教学建议", "采用‘时间轴法’；通过‘天气预报’练习预测语气；设计‘梦想清单’练习 be going to；强化 There be 句型及其将来时变换。")
            ),
            famousQuote = "The best way to predict the future is to create it.",
            quoteAuthor = "Peter Drucker"
        ),
        KnowledgePoint(
            id = "present_continuous",
            section = SEC_2,
            title = "现在进行时 (Present Continuous)",
            description = """### 核心概念详解
现在进行时 (Present Continuous) 是英语语法的“快门”，用于捕捉正在发生的瞬间。其核心功能表达：1. 说话瞬间此时此刻正在进行的动作（常伴随 Look!, Listen!, now, at the moment 等标志词）；2. 现阶段一段时间内一直在进行，但说话瞬间不一定在做的动作（如 I am reading a novel these days）。构成公式为 'am/is/are + 动词-ing'。中考的重难点在于 -ing 形式的物理变换：除了直接加 ing，还包括去 e 加 ing（如 making）、以及最易出错的“双写末尾辅音字母再加 ing”（如 swimming, running, putting, beginning, shopping）。此外，该时态还带有强烈的情感色彩：当它与 always, constantly 连用时，通常表达说话者的极度赞扬或明显反感（如 He is always losing his keys）。

### 深度考点解析
*   **感官提示词的引导作用**：Look! 与 Listen! 是触发现在进行时的绝对雷达，考生必须养成瞬间锁定该时态的直觉。
*   **双写的重难点清单**：需掌握 run, swim, sit, put, get, begin, shop, stop, travel 等核心词。口诀：重读、闭音节、末尾辅音单。
*   **位移动词的‘将来语义’**：Go, come, leave, start, arrive 的现在进行时在中考阅读中常表示‘即将发生’的确定安排。
*   **Always 的情感放大镜**：He is always helping others. (极力赞扬) vs He is always talking in class. (极度反感)。
*   **进行时与一般时的本质对比**：Does he smoke? (询问习惯) vs Is he smoking? (询问此刻行为)。
*   **不能用进行时的动词**：Like, love, want, know, belong to, seem 等静态或所属动词通常不用于进行时。""",
            syllabusDetails = listOf(
                "1. 熟练掌握现在进行时的构成及其否定句、疑问句及肯定回答形态。",
                "2. 深度掌握动词-ing 的三类物理变化规则（重点关注双写辅音字母的高频动词）。",
                "3. 掌握 Look!, Listen!, now, at present 等提示词的识别与精准运用。",
                "4. 领会并能运用现在进行时与 always, constantly 连用时的特殊情感色彩。",
                "5. 理解位移动词用进行时表示‘最近打算或安排好’的将来含义。",
                "6. 区分延续性动作与瞬间动作在进行时中的语义表现。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般现在时", "常态 vs 瞬态", "一般现在时描述客观规律与习惯，进行时描述正在发生的动态瞬间。"),
                RelatedPoint("过去进行时", "时空的平行平移", "过去进行时是将基准拍摄点从‘现在’挪到了‘过去某刻’。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "北京中考", "— Listen! Who ______ in the music room?\n— Oh, it's Mary. She ______ for the concert.", listOf("A. sings; practices", "B. is singing; is practicing", "C. sang; practiced", "D. will sing; will practice"), "B", "【答案】B。本题考查 Listen! 提示的现在进行时。此时此刻正在发生的动作，主语 who 和 she 均匹配 is + doing 结构。", "误选一般现在时 A，忽略了 Listen! 的强制提示作用。", "—— 听！谁在音乐教室唱歌？ —— 噢，是玛丽。她正在为音乐会练习。"),
                PastExamQuestion("2023", "上海中考", "Don't make any noise. The baby ______ in the bedroom now.", listOf("A. sleep", "B. sleeps", "C. is sleeping", "D. slept"), "C", "【答案】C。本题考查语境暗示。Don't make any noise 说明婴儿正处于睡觉的状态中，需用现在进行时。", "习惯性选单三 sleeps。", "别吵。宝宝现在正在卧室睡觉。"),
                PastExamQuestion("2022", "广东中考", "I ______ a book about Chinese history these days. It's very interesting.", listOf("A. read", "B. am reading", "C. have read", "D. readed"), "B", "【答案】B。本题考查现阶段一直在进行的动作。these days 提示现阶段的持续状态，即使此刻不在读。", "认为 readed 是过去式（拼写错），且未识别进行时语境。", "这些天我正在读一本关于中国历史的书。它很有趣。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Look! Some students are cleaning the classroom to prepare for the parent-teacher meeting. Zhang Hua is sweeping the floor and Li Ming is cleaning the windows carefully. They are all working very hard together to make the classroom beautiful and tidy. They are always helping each other when they have difficulties in study.", listOf(
                    HighlightedSentence("are cleaning", "Look! 引导的、说话瞬间此时此刻正在进行的动作。"),
                    HighlightedSentence("always helping each other", "现在进行时与 always 连用，表达说话者对他们的强烈赞扬。")
                ), "人教版七下 Unit 6"),
                TextbookParagraph("I am studying for my final exams these days, so I don't have much time for outdoor sports with my friends. My sister is also preparing for her art exhibition in the city museum. We are both feeling a bit stressed, but we believe we can do it well if we keep trying our best and work hard every day.", listOf(
                    HighlightedSentence("am studying... these days", "these days 引导现阶段一段时间内的、不间断的持续动作。"),
                    HighlightedSentence("are both feeling", "描述目前正在经历的、感官上的主观状态感受。")
                ), "外研版八上 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("Are you using your computer at the moment? I need to send an important email.", "你现在正在用电脑吗？我需要发封重要的邮件。", "【分析】at the moment 是进行时的典型标志，表示此时此刻。", "基础必会"),
                ExampleSentence("The population of the world is growing faster and faster these years.", "这些年来世界人口正增长得越来越快。", "【分析】描述一种正在发生且具有持续变化趋势的客观现状。", "中考核心"),
                ExampleSentence("He is always talking in class when the teacher is explaining the math problem. It's so annoying.", "老师讲解数学题时他总是在课上说话。真烦人。", "【分析】进行时与 always 连用表达说话者明显强烈的反感和厌烦。", "高阶句式")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 动词-ing 漏写或 be 动词漏写（如 I working / I am work）；2. 双写字母错误（如 swiming, runing, stoping）；3. 忽视不能用进行时的静态动词。"),
                TeachingNote("教学建议", "采用‘哑剧表演’游戏描述动作；利用‘重闭单’口诀强化双写规则；通过情景对话区分‘日常习惯’与‘正在行为’。")
            ),
            famousQuote = "I am doing my best. That is all I can do.",
            quoteAuthor = "William McKinley"
        ),
        KnowledgePoint(
            id = "past_continuous",
            section = SEC_2,
            title = "过去进行时 (Past Continuous)",
            description = """### 核心概念详解
过去进行时 (Past Continuous) 是历史的“慢镜头”，用于描述在过去某一特定时刻或某一时间段内正在发生的动作。在中考体系中，该时态的构成公式是 'was/were + 动词-ing'。其核心考点集中在动作的逻辑嵌套：1. 过去某一时刻的“慢镜头”背景（常伴随 at 8:00 last night, at that time）；2. 动作被打断的场景（一长一短：持续的长动作用过去进行时，突然发生的打断动作用一般过去时）；3. 两个过去长动作的同时并行（常由 while 连接）。此外，该时态在文学描写中承担着铺设背景、营造氛围的重要功能。考生需精准区分 when 与 while 在连接此类从句时的引导特性。

### 深度考点解析
*   **While 与 When 的终极对决**：While 后必须接延续性动词，且几乎总是使用进行时态；When 后既可接瞬时动词（一般过去时）也可接延续动词。
*   **打断逻辑的‘主从配对’**：I was reading (长动作/背景) when the phone rang (短动作/干扰)。这里的过去进行时是舞台，一般过去时是演员。
*   **共时逻辑的双重演绎**：While Mom was cooking, Dad was reading the newspaper. 描述两个长动作在过去完全平行发生。
*   **特定的过去时间‘锚点’**：At 10:00 yesterday morning, she was sleeping. 必须有明确的时间锚点。
*   **与一般过去时的本质差异**：I wrote a letter. (强调写完了，动作结束) vs I was writing a letter. (强调正在写的状态，未必写完)。
*   **It was raining 的氛围铺垫**：在故事开头常以此句铺设忧郁或紧张的过去背景。""",
            syllabusDetails = listOf(
                "1. 熟练掌握过去进行时的构成公式及其否定、疑问及应答形态。",
                "2. 理解并识别‘过去某一时刻’或‘过去某段时间’的特定语境含义。",
                "3. 熟练运用 when 与 while 引导的时间状语从句，掌握长短动作的经典搭配逻辑。",
                "4. 理解过去进行时在文学故事中描述场景、铺垫环境背景的修辞功能。",
                "5. 精准掌握 was/were 的人称匹配规则（特别注意 I 匹配 was）。",
                "6. 掌握两个过去长动作同时并行的双进行时句法结构。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般过去时", "短动作 vs 长动作", "一般过去时打破了过去进行时营造的持续背景氛围。"),
                RelatedPoint("现在进行时", "时间轴的平行平移", "逻辑结构完全一致，仅时间坐标从现在切换至过去。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "杭州中考", "— What ______ you ______ at 8:00 last night?\n— I was watching the football match on TV.", listOf("A. do; do", "B. did; do", "C. were; doing", "D. are; doing"), "C", "【答案】C。本题考查特定时刻的动作。at 8:00 last night 是明确的过去时间点，询问在那一刻正在做什么，用过去进行时。", "误选一般过去时 B，忽略了 8:00 这个精确点。精确时刻提示进行。 ", "—— 昨晚八点你正在做什么？ —— 我正在电视上看足球赛。"),
                PastExamQuestion("2023", "武汉中考", "While the children ______ in the garden, it started to rain suddenly.", listOf("A. play", "B. are playing", "C. were playing", "D. played"), "C", "【答案】C。本题考查 while 引导的长动作背景。主句 started 是过去式，从句需用过去进行时 were playing 作为背景。", "选了现在进行时 B，导致时态逻辑不一致。", "当孩子们正在花园里玩耍时，天突然下起雨来。"),
                PastExamQuestion("2022", "广东中考", "The light ______ out while I ______ a shower yesterday evening.", listOf("A. went; was taking", "B. was going; took", "C. goes; am taking", "D. has gone; took"), "A", "【答案】A。本题考查‘打断逻辑’。‘洗澡’是持续的长动作（was taking），‘停电’是突发的短动作（went）。", "长短动作时态逻辑放反了。", "当我正在洗澡时，灯熄灭了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When the heavy rainstorm came yesterday afternoon, I was waiting for the bus at the station. My sister was reading in the quiet library at that time. Many people were running quickly to find a safe place to hide from the rain. No one expected that the storm would be so strong and last so long in our city.", listOf(
                    HighlightedSentence("was waiting for the bus", "过去进行时描述暴风雨来临（突发点动作）那一刻的背景持续长动作。"),
                    HighlightedSentence("were running to find", "复数主语 match were，描述过去那一刻混乱、动态的背景场面。")
                ), "人教版八下 Unit 5"),
                TextbookParagraph("While I was walking in the park with my dog yesterday morning, I saw an old friend from my primary school. We were both wearing the same kind of sports clothes! We were so surprised that we stood there and talked for a long time about our school lives and our future dreams.", listOf(
                    HighlightedSentence("While I was walking", "while 后通常接描述背景的长动作，即过去进行时。"),
                    HighlightedSentence("were both wearing", "描述相遇瞬间的状态背景，wear 在此作为延续性动词使用。")
                ), "外研版八上 Module 8")
            ),
            exampleSentences = listOf(
                ExampleSentence("At that time, she was practicing the piano in her room alone without any light.", "那个时候，她正独自在房间里练钢琴，没开灯。", "【分析】At that time 是过去进行时的典型标志词，锁定过去某瞬时。", "基础必会"),
                ExampleSentence("While my mother was cleaning the house, my father was washing the car outside in the yard.", "我妈妈在打扫屋子时，我爸爸在外面院子里洗车。", "【分析】while 连接两个同时进行的过去长动作，主从句均用进行时。", "中考核心"),
                ExampleSentence("I was just leaving the house when the phone rang suddenly and loudly.", "电话突然大声响的时候我正要出门。", "【分析】进行时态表达‘正要...’的即刻状态，被突发的 rang 动作打断。", "高阶句式")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. when 与 while 用法记反（点动作误用 while）；2. was/were 人称选择错误（特别是 I 误用 were）；3. 忘记 -ing 的双写或去 e 物理规则。"),
                TeachingNote("教学建议", "采用‘老照片’描述法（当时他们在做什么？）；利用‘动作打断’情境进行现场表演；专项训练 when 与 while 的句型转换。")
            ),
            famousQuote = "I was dreaming when they called me.",
            quoteAuthor = "John Lennon"
        ),
        KnowledgePoint(
            id = "present_perfect",
            section = SEC_2,
            title = "现在完成时 (Present Perfect)",
            description = """### 核心概念详解
现在完成时 (Present Perfect) 是英语时态中的“逻辑桥梁”，它立足现在，回溯过去。主要包含两大语义支柱：1. **影响性（已完成）**：动作发生在过去，但其产生的结果或影响依然持续到此刻（如 I have lost my key，重点不在丢钥匙的瞬间，而在我现在进不去屋的结果）；2. **持续性（未完成）**：动作始于过去，一直延续到说话瞬间，且可能继续持续下去（常与 for + 时间段或 since + 时间点连用）。构成公式为 'have/has + 过去分词 (done)'。中考的核心火力网集中在：already (肯定句) 与 yet (疑问/否定句末) 的选择；have been to (去过已回) 与 have gone to (去了未回) 的辨析；以及最具杀伤力的考点——**瞬间动词在含有 for/since 的句中必须强制转换为对应的延续性动词或状态**。

### 深度考点解析
*   **瞬间动词的‘禁区’与转换**：He has joined the club for two years. (必错) -> He has been in the club for two years. (必对)。这是中考语法填空与短文改错的最高频考位。核心转换：join -> be in, borrow -> keep, buy -> have, die -> be dead, leave -> be away。
*   **Since 的‘主完从过’法则**：Since 引导的时间从句固定用一般过去时，主句必须锁定现在完成时。
*   **Already vs Yet vs Just**：Already 用于肯定句，Yet 用于句末表‘还未’，Just 表‘刚刚’。
*   **How long 的‘专属应答’**：当问句以 How long 开头时，答句首选含有 for 或 since 的现在完成时结构。
*   **Been in vs Been to vs Gone to**：Been to 强调经验；Gone to 强调不在场；Been in 强调在某地待了多久。
*   **It is + 时间 + since...**：等同于现在完成时的固定表达句型（It is three years since he left）。""",
            syllabusDetails = listOf(
                "1. 深刻理解现在完成时的内在逻辑：立足此刻，审视过去，强调结果或动作的延续性。",
                "2. 熟练掌握 have/has + 过去分词的物理构成，重点攻克 100 个核心不规则动词表。",
                "3. 掌握 since + 点时间 与 for + 段时间 的精准用法差异及其对主句时态的强制要求。",
                "4. 强制性记忆 15 组以上瞬间动词变延续性动词的对应转换表（重点：join, borrow, buy, die）。",
                "5. 深度辨析 have been to, have gone to 与 have been in 的语境与功能差异。",
                "6. 掌握 already, yet, just, ever, never 的句中标准位置及其语义内涵。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般过去时", "点 vs 线", "过去时是孤立的、已终结的历史点，完成时是延伸到当下的逻辑线。"),
                RelatedPoint("过去完成时", "时轴的平行平移", "过去完成时是‘过去的过去’，其内在逻辑与现在完成时完全平行。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "苏州中考", "— Look! Someone ______ the classroom. It's so clean now.\n— Well, it wasn't me.", listOf("A. is cleaning", "B. has cleaned", "C. cleans", "D. was cleaning"), "B", "【答案】B。本题考查完成时的‘影响’用法。It's clean now 是目前的结果，说明打扫动作已完成且对现在有直接影响。", "看到 Look! 盲选进行时 A。但 clean now 明确强调的是结果而非动作过程。", "—— 看！有人打扫过教室了。现在真干净。 —— 嗯，不是我。"),
                PastExamQuestion("2023", "武汉中考", "My cousin ______ the army for three years. He is a brave soldier now in Tibet.", listOf("A. has joined", "B. has been in", "C. joined", "D. was in"), "B", "【答案】B。本题考查瞬间动词转换为延续性动词。for three years 提示需要延续性动词，join 是瞬时动作，需改为 be in。", "误选 has joined，受汉语‘参军三年’误导。", "我表哥参军三年了。他现在是西藏的一名勇敢士兵。"),
                PastExamQuestion("2022", "南京中考", "I ______ this book twice, but I still find it difficult to understand perfectly.", listOf("A. read", "B. have read", "C. will read", "D. had read"), "B", "【答案】B。本题考查经验性用法。twice 提示动作发生的累计次数，是对现在的经验积累，必须用现在完成时。", "选一般过去时 A，忽略了经验累积的语法含义。", "这本书我已经读过两遍了，但我还是觉得很难完美理解。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Have you read the famous book Treasure Island yet? No, I haven't, but I have already finished reading Little Women and it's absolutely great. It has changed my life and my way of thinking since I bought the book. In fact, I have kept it for two years and read it many times to gain more wisdom.", listOf(
                    HighlightedSentence("Have you read... yet?", "yet 用于疑问句句末，询问某种经验或动作的完成进度。"),
                    HighlightedSentence("have kept it for two years", "keep 是延续性动词，可与 for two years 连用，此处用于代替瞬间动词 buy 的状态延续。")
                ), "人教版八下 Unit 8"),
                TextbookParagraph("I have been a member of the school football team since 2021 when I first joined. Our team has won many important matches so far and we are very proud of our team spirits. We have worked hard together and made great progress in the past few years by training every afternoon on the playground.", listOf(
                    HighlightedSentence("since 2021", "since + 时间点，作为时态锚点，要求主句必须使用现在完成时。"),
                    HighlightedSentence("so far", "so far (到目前为止) 是现在完成时的经典标志词，强调阶段性的累计结果。")
                ), "外研版九下 Module 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("Where is Li Hua now? Oh, he has gone to the library to search for information.", "李华在哪？他去图书馆查资料了（目前不在场）。", "【分析】have gone to 强调‘去了未归’，侧重描述结果。", "基础必会"),
                ExampleSentence("I have been to Beijing three times and I love the culture there very much.", "我去过北京三次（现在人已回）。", "【分析】have been to 强调‘去过已回’，侧重描述个人的经历。", "基础必会"),
                ExampleSentence("How long have you had this beautiful and expensive bike?", "你买这辆漂亮又昂贵的自行车多久了？", "【分析】对 for/since 提问用 How long，谓语动词必须使用延续性的 have。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 瞬间动词与 for/since 连用（中考最重灾区）；2. been to 与 gone to 概念混淆；3. 忽略 since 从句需用过去时；4. 过去分词拼写物理错误。"),
                TeachingNote("教学建议", "采用‘瞬间变长’动态对照表；利用‘时空隧道’图示解析逻辑；通过‘个人经历分享会’练习 been to；设计‘寻物启事’情境模拟‘影响’语义。")
            ),
            famousQuote = "What is past is prologue.",
            quoteAuthor = "William Shakespeare"
        ),
        KnowledgePoint(
            id = "past_perfect",
            section = SEC_2,
            title = "过去完成时 (Past Perfect)",
            description = """### 核心概念详解
过去完成时 (Past Perfect) 形象地被称为“过去的过去”。它描述的是在过去某个特定的动作或时刻之前就已经完成的动作或存在的状态。在中考句法中，该时态的物理构成是 'had + 过去分词 (done)'。其核心逻辑模型是：在时间轴上，如果过去发生的动作 A 是参照点（一般过去时），那么在 A 之前就已经完成的动作 B 必须使用过去完成时。常见的时态标志包括：by the time (接过去时从句), before (接过去时), when (接过去时), 以及 by the end of + 过去时间。中考的重难点在于：1. 正确识别句子中两个过去动作的先后逻辑顺序；2. 在宾语从句中正确执行时态呼应（主过从必过，且从句动作在前时需退至过去完成时）。

### 深度考点解析
*   **By the time 的‘时态锚点’效应**：如果从句用一般过去时（By the time I arrived），主句必须锁定过去完成时（the bus had left）。
*   **先后关系的强调与简化**：虽然 before/after 本身能暗示先后，但在正式语境或强调‘已经完成’时，过去完成时具有不可替代的精确性。
*   **宾语从句的‘退位’规则**：He said he had seen the film already. (看电影发生在‘说’之前)。
*   **Had had 的合法重叠**：第一个 had 是助动词，第二个是实义动词（如 have breakfast）的过去分词形式，这是考试中的拼写迷惑点。
*   **No sooner...than / Hardly...when**：表示‘一...就...’，主句常使用过去完成时的倒装结构，虽中考要求较低，但常作为阅读理解的高级结构出现。
*   **愿望动词的‘虚拟’**：I had hoped to see you. (本来希望见到你，但实际没见到)。""",
            syllabusDetails = listOf(
                "1. 理解并画出‘过去的过去’逻辑模型，能在时间轴上精准定位两点发生的先后顺序。",
                "2. 熟练掌握 had + 过去分词的物理构成，注意 had 不受主语单复数及人称限制。",
                "3. 掌握 By the time... (接过去点) 引导的时间状语从句的主从时态匹配规律。",
                "4. 深刻理解宾语从句中的时态后退原则，准确识别动作发生的绝对先后逻辑。",
                "5. 掌握‘瞬间动词变延续’在过去完成时中的延续性要求（逻辑同现在完成时）。",
                "6. 掌握 by the end of + 过去时间 这一经典的时态锚点标志。"
            ),
            relatedPoints = listOf(
                RelatedPoint("现在完成时", "时轴的镜像", "现在完成时的基准点是现在，过去完成时的基准点是过去某一个特定的时刻。"),
                RelatedPoint("一般过去时", "参照物", "过去完成时的存在逻辑上必须依赖于一般过去时作为参照背景。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "合肥中考", "By the time the bell rang, I ______ my homework carefully.", listOf("A. finished", "B. have finished", "C. had finished", "D. was finishing"), "C", "【答案】C。本题考查‘过去的过去’。铃响（rang）是过去发生的事，作业写完是在响铃之前就已经完成，故用过去完成时。", "误选现在完成时 B 或一般过去时 A，无法体现逻辑先后。", "铃响的时候，我已经仔细地写完作业了。"),
                PastExamQuestion("2023", "济南中考", "She said that she ______ that movie already when we discussed it.", listOf("A. sees", "B. saw", "C. has seen", "D. had seen"), "D", "【答案】D。本题考查宾语从句时态呼应。主句 said 是过去式，从句动作‘看电影’发生在‘说’这一动作之前，必须用过去完成时。", "受 already 误导习惯性选了现在完成时 C。", "她说在我们讨论那部电影时，她已经看过它了。"),
                PastExamQuestion("2022", "沈阳中考", "When I arrived at the train station, the train ______ already.", listOf("A. left", "B. has left", "C. had left", "D. was leaving"), "C", "【答案】C。本题考查语境逻辑。当我到达时，火车‘已经开走’，开走动作发生在到达之前。", "选一般过去时 A，不能体现出清晰的先后逻辑顺序。", "当我到达火车站时，火车已经开走了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When I woke up this morning, I suddenly realized that I had forgotten to set my alarm clock last night. I hurried to the bus stop as fast as I could, but the bus had already gone when I finally arrived there. Luckily, my father drove me to school, or I would have been late for the first class.", listOf(
                    HighlightedSentence("had forgotten to set", "忘记设闹钟（动作B）发生在醒来（动作A）之前，即典型的‘过去的过去’。"),
                    HighlightedSentence("bus had already gone", "公交车开走（动作B）发生在到达车站（动作A）之前，需用过去完成时。")
                ), "人教版九年级 Unit 12"),
                TextbookParagraph("By the end of last year, we had learned about 2,000 English words and many useful phrases. Our teacher was very happy with our great progress in the exams. She said that we had worked much harder than before and deserved a good holiday during the winter vacation with our families.", listOf(
                    HighlightedSentence("By the end of last year", "过去的时间截止点（点A），主句常用过去完成时描述在此之前累计完成的成果。"),
                    HighlightedSentence("had worked much harder", "在宾语从句中，努力工作这一行为发生在老师做出正面评价（said）之前。")
                ), "外研版九下 Module 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("He had lived in London for ten years before he moved to China in 2015.", "在他 2015 年搬到中国之前，他在伦敦住了十年。", "【分析】‘住伦敦’（延续性长动作）发生在‘搬家’（时间点/过去）之前。", "中考核心"),
                ExampleSentence("The film had been on for ten minutes when I finally got to the cinema.", "当我终于到达电影院时，电影已经开始了十分钟。", "【分析】be on 是延续性状态，发生在‘到达’之前，必须使用过去完成时以符逻辑。", "高阶句式"),
                ExampleSentence("I suddenly realized that I had made a big mistake in the final exam.", "我突然意识到我在期末考试中犯了一个大错。", "【分析】‘犯错’这一事实发生在‘意识到’这一心理活动之前。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 脱离过去背景孤立、无根据地使用过去完成时；2. By the time 从句时态判错（需区分将来与过去）；3. 忽略 had had 的物理合法性。"),
                TeachingNote("教学建议", "建议教师采用‘两点一线’教学法：在黑板上画出 A（过去某时）和 B（更早的时刻），强调 had done 是发生在 B 点。练习 past perfect 与 past simple 的排序组合。")
            ),
            famousQuote = "I had already found that it was not so easy to be good.",
            quoteAuthor = "Somerset Maugham"
        ),
        KnowledgePoint(
            id = "past_future",
            section = SEC_2,
            title = "过去将来时 (Past Future)",
            description = """### 核心概念详解
过去将来时 (Past Future) 是一种极具逻辑深度的时态，它要求说话者立足于过去的某一点，去审视在那一点之后将要发生的动作或存在的状态。其核心视角是：从过去的某一点看之后。在中考评价体系中，该时态的物理构成主要有两种：1. 'would + 动词原形'（侧重主观意愿或预测）；2. 'was/were going to + 动词原形'（侧重过去的计划或打算）。绝大多数的应用场景出现在宾语从句中：当主句谓语动词是 said, told, asked, thought, knew 等过去式时，从句中原本应使用 will 的地方必须强制后退为 would。这种时态一致性（Tense Concord）是英语严谨性的体现。此外，该时态也常用于间接引语的转换以及表达过去未实现的愿望或推测（如 I thought you would come）。

### 深度考点解析
*   **宾语从句的时态锁死**：主句 said/told/asked (过去) -> 从句 will 必须无条件变为 would。这是解决此类题目的唯一钥匙。
*   **间接引语的时间平移**：“I will arrive tomorrow” -> He said he would arrive the next day. 需同步修改时间状语。
*   **Would vs Was going to 的语义微差**：逻辑同 will 与 be going to 的区别。Would 侧重意愿或基于过去的预测；Was going to 侧重过去那一刻已经形成的具体计划。
*   **过去未实现的愿望或预测**：I thought he was going to win the gold medal (暗示事实上他没赢)。
*   **进行时表过去将来**：He said he was leaving for Beijing. (过去进行时 was leaving 表示过去视角下的即将启程)。
*   **虚拟语气的入门**：Would 作为虚拟语气的核心助动词，其过去将来时的形态是理解高级句法的基础。""",
            syllabusDetails = listOf(
                "1. 深刻理解过去将来时的核心逻辑：立足过去视角，审视在那一刻之后的‘将来’意图或预测。",
                "2. 熟练掌握 would + 动词原形 与 was/were going to + 动词原形的物理形态转换。",
                "3. 深刻理解宾语从句中的时态一致性原则，能迅速识别主从句时态链条的断裂点。",
                "4. 掌握间接引语转换中时间状语的对应变化规则（如 tomorrow -> the next day）。",
                "5. 识别位移动词用过去进行时表示在过去某刻确定的位移安排。",
                "6. 掌握该时态在叙事性文本中对后续情节的‘预告’或‘剧透’功能。"
            ),
            relatedPoints = listOf(
                RelatedPoint("一般将来时", "时轴的平行迁移", "过去将来时实际上是一般将来时在过去语境下的完美镜像。"),
                RelatedPoint("虚拟语气", "高级语法衔接", "Would 是虚拟语气的主干动词，理解过去将来时是掌握虚拟语气的物理前提。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "哈尔滨中考", "She said she ______ a doctor when she grew up in her diary.", listOf("A. will be", "B. would be", "C. is going to be", "D. was"), "B", "【答案】B。本题考查宾语从句时态呼应。主句 said 是过去式，从句表达将来的愿望，will 必须强制变为 would。", "误选 A，完全忽略了主句 said 的过去时态影响。", "她在日记里说她长大后想当一名医生。"),
                PastExamQuestion("2023", "成都中考", "I thought you ______ to my birthday party yesterday, but you didn't appear.", listOf("A. will come", "B. come", "C. would come", "D. had come"), "C", "【答案】C。本题考查过去视角下的推测。thought 提示过去背景，对未来的推测需用 would come。", "误选 had come，虽然逻辑也通，但 would come 更能体现对未来动作的预期感。", "我以为昨天你会来参加我的生日派对，但你没出现。"),
                PastExamQuestion("2022", "广东中考", "He promised that he ______ late for school again in the future.", listOf("A. won't be", "B. wouldn't be", "C. isn't", "D. wasn't"), "B", "【答案】B。本题考查 promise 的过去用法。promised 提示过去视角，从句中的 won't be 必须变为 wouldn't be。", "忽略了 promised 这一过去式动词的提示作用。", "他保证以后不再上学迟到了。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("When Li Ming left his small hometown for the big city, he knew he would miss his parents and childhood friends very much. He promised that he would write to them every week to share his new and exciting life. He was going to work hard and make his family proud of him in the near future.", listOf(
                    HighlightedSentence("knew he would miss", "主句 knew 是过去式，从句表达对于那个时刻而言未来的感受，必须用 would。"),
                    HighlightedSentence("was going to work hard", "表达在过去那一刻已经做好的、坚定的计划安排，视角锁定为过去。")
                ), "人教版九年级 Unit 14"),
                TextbookParagraph("I asked her if she would join the school singing competition next month. She told me that she was going to have a try, although she was a bit nervous about performing on the stage. I believed that she would succeed in the end because she had a beautiful voice and great talent.", listOf(
                    HighlightedSentence("asked her if she would", "if 引导的宾语从句，主句是过去式 asked，从句必须用 would。"),
                    HighlightedSentence("believed that she would", "描述过去视角下对结局的笃定预测，体现了时态的一致性。")
                ), "外研版九下 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("He told me that he was going to visit his grandparents the next day in the country.", "他告诉我第二天他要去乡下拜访他的祖父母。", "【分析】the next day 提示这是在过去某时刻谈论的、对于当时而言的明天。", "中考核心"),
                ExampleSentence("I knew it would rain very soon, so I took an umbrella with me when I left.", "我知道快要下雨了，所以我离开时带了把伞。", "【分析】knew 提示了说话者对过去将来事情的预知和判断。", "基础必会"),
                ExampleSentence("The teacher said we would have an important meeting on Friday afternoon.", "老师说我们周五下午要开一个重要的会议。", "【分析】这是最常规的间接引语时态变换示例，体现了 reported speech 的规则。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 宾语从句‘主过从将’（如 He said he will...）；2. would 后面错误加了 to；3. was going to 物理性漏写 was；4. 时间状语未随之平移。"),
                TeachingNote("教学建议", "建议教师采用‘时态降级法’：will -> would, is -> was；进行高强度的直接引语转间接引语专项练习；设计‘过去预测’的情境模拟。")
            ),
            famousQuote = "I knew I would be late if I didn't hurry.",
            quoteAuthor = "Anonymous"
        ),
        KnowledgePoint(
            id = "passive_voice",
            section = SEC_2,
            title = "被动语态 (Passive Voice)",
            description = """### 核心概念详解
被动语态 (Passive Voice) 是英语表达中强调“受动者”或“动作本身”而非执行者的关键句法手段。其核心物理构成公式是 'be + 过去分词 (done)'。其中，be 动词承担了时态变化的全部重任：1. am/is/are done (一般现在时)；2. was/were done (一般过去时)；3. will be done (一般将来时)；4. have/has been done (现在完成时)；5. can/must/should be done (情态动词被动语态)。在中考的高频火力网中，陷阱主要布设在以下区域：1. 动词短语变被动时，末尾介词绝不可遗漏（如 be looked after）；2. 主动语态中省略 to 的不定式在被动语态中必须强制‘复活’（如 be made to do）；3. 明确识别不能使用被动语态的‘黑名单’动词（如 happen, cost, stay, belong to）。

### 深度考点解析
*   **To 的复活与还原**：make, see, hear, let, watch sb do sth -> be made to do sth。这是中考单选题中区分高低分考生的最高频陷阱。
*   **短语动词的‘完整性’原则**：We must take care of our earth -> Our earth must be taken care of. 介词 of 的脱落是典型的失分点。
*   **不及物动词的‘被动禁区’**：A traffic accident was happened (绝对错误) -> A traffic accident happened (正确)。
*   **主动形式表达被动语义**：The pen writes well (写起来...). / The cake tastes good (尝起来...). / The books sell like hot cakes (销路好...).
*   **及物动词的双宾被动**：Give me a book -> I am given a book 或 A book is given to me. (指物作主语时，间宾前常需加 to 或 for)。
*   **Get 构成的准被动**：Get married, get lost, get broken 等结构在口语中极常用。""",
            syllabusDetails = listOf(
                "1. 深刻理解被动语态的使用时机：动作执行者不明、不重要或说话者主观需要强调动作承受者。",
                "2. 熟练掌握 5 种中考核心时态下的被动语态构成公式（重点关注完成时与将来时的被动）。",
                "3. 掌握‘使役动词’与‘感官动词’变被动时不定式符号 to 的物理还原规则。",
                "4. 强制熟记不能使用被动语态的动词清单（happen, take place, cost, fail, belong to, remain）。",
                "5. 掌握‘及物动词+副词/介词’短语变被动时，短语物理结构的完整性（介词不遗漏原则）。",
                "6. 理解并识别‘主动形式表被动含义’（感官系动词、特征词）的特殊动词用法。"
            ),
            relatedPoints = listOf(
                RelatedPoint("及物动词", "被动的前提条件", "通常只有及物动词或具有及物性的动词短语才具备转换为被动语态的资格。"),
                RelatedPoint("过去分词", "被动的核心形态", "被动语态的所有时态物理变化最终都体现在 be 动词的形态切换与 done 的组合上。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "武汉中考", "Usually, computers ______ to find information quickly in our daily life.", listOf("A. use", "B. are used", "C. are using", "D. used"), "B", "【答案】B。本题考查一般现在时的被动语态。主语 computers 是动作承受者，电脑‘被使用’，且 Usually 提示一般现在时的基调。", "误选主动语态 A，认为电脑能自己发出‘使用’这一动作。", "通常，电脑在我们的日常生活中被用来快速查找信息。"),
                PastExamQuestion("2023", "上海中考", "The dirty clothes ______ by the washing machine in an hour, so don't worry.", listOf("A. will wash", "B. will be washed", "C. are washing", "D. were washed"), "B", "【答案】B。本题考查一般将来时的被动语态。in an hour 提示将来时间，衣服被洗需用 will be washed 结构。", "选了过去式 D，未能识别出 in an hour 这一将来意义的标志。", "脏衣服将在一小时内由洗衣机洗好，所以别担心。"),
                PastExamQuestion("2022", "广东中考", "English ______ in many countries and regions all over the world as a first language.", listOf("A. speaks", "B. is spoken", "C. is speaking", "D. was spoken"), "B", "【答案】B。本题考查一般现在时的被动语态。英语‘被说’，描述客观事实与现状必须使用一般现在时的被动。", "选了主动语态 A，忽略了主语与动词的受动关系。", "英语在世界上许多国家和地区被作为第一语言使用。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Paper was first invented in ancient China more than 2,000 years ago by Cai Lun. It is still widely used in our daily lives today for many different purposes like writing and packing. However, many trees are cut down to make paper every year, so we should try our best to save paper to protect the environment and our green planet.", listOf(
                    HighlightedSentence("Paper was first invented", "一般过去时的被动语态，用于描述已知的确切历史发明。"),
                    HighlightedSentence("are cut down to make", "一般现在时的被动语态，注意动词短语 cut down 的介词结构必须保持完整。")
                ), "人教版九年级 Unit 6"),
                TextbookParagraph("In the future, more and more clean energy will be used to reduce pollution and protect the earth from global warming. For example, wind and solar power can be used to produce electricity for our homes and factories. If these measures are taken, our planet will become much better for us and our future generations.", listOf(
                    HighlightedSentence("will be used to reduce", "一般将来时的被动语态，用于描述对未来发展的科学预测或既定计划。"),
                    HighlightedSentence("can be used to produce", "包含情态动词 can 的被动语态结构：情态动词 + be + done（分词）。")
                ), "外研版九下 Module 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("The broken chair was repaired by my father yesterday afternoon in the backyard.", "那把坏椅子昨天下午由我爸爸在后院修好了。", "【分析】强调动作的具体执行者时，用 by 引导短语，通常置于句末。", "基础必会"),
                ExampleSentence("He was seen to enter the room just now by the neighbor through the window.", "刚才邻居看到他通过窗户进了房间。", "【分析】see sb do 在被动中变为 be seen to do，必须还原不定式符号 to。", "高阶句式"),
                ExampleSentence("The lost child has been found by the police in the deep forest after two days.", "失踪的孩子在两天后已经被警察在深林里找到了。", "【分析】现在完成时的被动语态 (have/has been done)，强调目前的结果。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. be 动词时态错误或与主语人称不一致；2. 过去分词拼写物理错误；3. 忽略不可用被动的词；4. 忘记‘to 的强制复活’规则。"),
                TeachingNote("教学建议", "采用‘身份互换’游戏练习主动与被动转换；总结‘主动表被动’的核心词单；强化‘短语被动介词不丢失’专项训练；通过新闻标题识别被动语态的应用。")
            ),
            famousQuote = "Rome was not built in a day.",
            quoteAuthor = "English Proverb"
        ),
        KnowledgePoint(
            id = "non_finite_verbs",
            section = SEC_2,
            title = "非谓语动词 (Non-finite Verbs)",
            description = """### 核心概念详解
非谓语动词 (Non-finite Verbs) 是英语句法中的“斜杠动词”，它们虽然来源于动词，却在句中扮演着名词、形容词或副词的多重角色。其核心特征是：不能单独作谓语，因此不受主语人称和数的物理限制。中考重点考查三大类别：1. **不定式 (to do)**：常用于表达动作的目的、将来的意图或具体的一次性动作。考点高度集中在 want/plan/decide to do 以及形式主语 (It is adj to do) 结构中。2. **动名词 (doing)**：侧重于表达爱好、习惯、抽象概念或泛指的动作。考点如 finish/practice/enjoy/mind doing。3. **分词**：包括现在分词 doing (表主动或正在进行) 和过去分词 done (表被动或已完成)。中考最棘手的火力点在于：辨析 forget/remember/stop/try 等词后接 to do 与 doing 的语义对立；掌握“疑问词 + 不定式”的结构转换；以及识别介词（包括 to 是介词的情况）后必须接动名词的铁律。

### 深度考点解析
*   **Stop doing vs Stop to do 的时空逻辑**：Stop doing 停止手中正在进行的事；Stop to do 停下手中的事，目的是去做另一件事。这是逻辑判断题的常客。
*   **Forget/Remember 的记忆方向**：+ doing (记得曾做过某事，指向过去)；+ to do (记得要做某事，指向未来)。
*   **Try doing vs Try to do 的力度**：Try doing 试着做某事（看看结果如何）；Try to do 努力/尽力去做某事（带有克服困难的意味）。
*   **It's time (for sb) to do sth**：固定句型，不定式在其中充当定语或主语成分。
*   **疑问词 + 不定式的‘缩微从句’**：I don't know how to solve it. 这种结构在语义上完美等同于宾语从句 how I can solve it，是长难句简化的利器。
*   **Doing 作主语的‘单数原则’**：Reading books is my favorite hobby. (谓语动词固定使用单数)。
*   **感官动词的宾补差异**：see sb do (全过程) vs doing (正在进行的瞬间)。""",
            syllabusDetails = listOf(
                "1. 深刻理解非谓语动词的基本物理性质：不能独作谓语，具备名、形、副的句法特征。",
                "2. 熟练掌握不定式作宾语、宾补、目的状语及作为形式主语 (It is adj to do) 的标准用法。",
                "3. 强制性熟记只能接动名词 doing 作宾语的 15 个高频动词（enjoy, finish, practice, mind, suggest）。",
                "4. 深度辨析 4 组以上后接 to do 与 doing 语义截然不同的核心动词（forget, remember, stop, regret）。",
                "5. 掌握‘疑问词 + 不定式’结构及其与宾语从句的同义转换逻辑技巧。",
                "6. 掌握介词（包括 look forward to, be used to 等 to 是介词的情况）后接动名词的标准用法。"
            ),
            relatedPoints = listOf(
                RelatedPoint("宾语从句", "句式结构的简化", "疑问词 + 不定式是宾语从句在中考应用中最常见的简化变体形式。"),
                RelatedPoint("介词", "doing 的天然载体", "绝大多数英语介词后接动词时，必须使用动名词形式以维持句法的逻辑平衡。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "重庆中考", "Don't forget ______ the lights and windows when you leave the room.", listOf("A. turn off", "B. to turn off", "C. turning off", "D. turned off"), "B", "【答案】B。本题考查 forget 的逻辑辨析。leave the room 暗示动作尚未发生，‘不要忘记去做某事’固定用 forget to do。", "误选 C，受‘习惯性 doing’的干扰，未识别出将来的逻辑。", "当你离开房间时，别忘了关灯并关窗。"),
                PastExamQuestion("2023", "长沙中考", "He practiced ______ the piano every day to prepare for the national competition.", listOf("A. play", "B. to play", "C. playing", "D. played"), "C", "【答案】C。本题考查 practice 的固定用法。practice 后必须接动名词 doing。", "误选 B，受‘去做某事’的目的逻辑干扰。", "他每天练习弹钢琴，为国家级比赛做准备。"),
                PastExamQuestion("2022", "南京中考", "We are all looking forward to ______ you and your family again soon.", listOf("A. see", "B. seeing", "C. saw", "D. seen"), "B", "【答案】B。本题考查介词 to 的陷阱。look forward to 中的 to 是介词，后接动名词 seeing。", "物理性误认为 to 是不定式符号而选了 A。", "我们大家都期待很快能再次见到你和你的家人。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("I enjoy reading interesting books in the quiet library because it helps me to learn more about the unknown world. Yesterday, I forgot to bring my library card, so I had to go back home to get it. I will remember to take it with me next time I go to the library to borrow some science books for my project.", listOf(
                    HighlightedSentence("enjoy reading books", "enjoy 后必须接动名词 doing，用于表达一种持续的、习惯性的爱好。"),
                    HighlightedSentence("forgot to bring", "忘记了还没做、要做的事（当时还没带），必须使用 forget to do 结构。")
                ), "人教版八上 Unit 1"),
                TextbookParagraph("Our teacher told us to keep practicing English every day to improve our listening and speaking skills. She said that learning a new language is not easy at first, but we should never give up. We are looking forward to having a good result in the final exam through our long-term hard work and perseverance.", listOf(
                    HighlightedSentence("told us to keep practicing", "tell sb to do (不定式作宾补)；keep doing (保持、持续做某事)。"),
                    HighlightedSentence("forward to having", "look forward to 结构中的 to 是介词性质，必须后接动名词 doing。")
                ), "外研版九下 Module 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("He stopped to have a short rest because he was very tired after the long work.", "他停下来休息了一会儿，因为长时工作后他很累了。", "【分析】stop to do 物理上表示‘停下正在做的事，转向去休息’这一动作。", "基础必会"),
                ExampleSentence("It's polite to say hello to others when you meet them for the first time in life.", "初次见到他人时主动打招呼是有礼貌的行为。", "【分析】It is + adj + to do 经典句式，It 是形式主语，真正的对象是不定式。", "基础必会"),
                ExampleSentence("I saw her dancing happily in the hall when I passed by her office yesterday.", "昨天当我经过她办公室时，我看到她正在大厅里开心地跳舞。", "【分析】see sb doing 物理上强调‘目击了动作正在进行的某一动态片段’。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 物理性混淆介词 to 与不定式 to（如 look forward to do）；2. Forget/Remember 的逻辑顺序用反；3. 使役动词 make/let 后错误加了 to。"),
                TeachingNote("教学建议", "建议采用‘时轴法’：Doing 代表‘过去已做或持续习惯’，To do 代表‘未来目的或具体待办’。制作‘doing 俱乐部’动词表。")
            ),
            famousQuote = "The only way to do great work is to love what you do.",
            quoteAuthor = "Steve Jobs"
        ),
        KnowledgePoint(
            id = "sentence_types",
            section = SEC_3,
            title = "句子种类 (Types of Sentences)",
            description = """### 核心概念详解
句子种类 (Types of Sentences) 是英语交流的功能模板，决定了表达的语气、情感与目的。根据其交际职能，英语句子可划分为四大类别：1. **陈述句 (Declarative)**：用于陈述事实或观点，包含肯定与否定两种形态；2. **疑问句 (Interrogative)**：用于获取信息，分为一般疑问句（Yes/No）、特殊疑问句（Wh-）、选择疑问句（or）和反义疑问句（Tag）；3. **祈使句 (Imperative)**：以动词原形开头，用于表达命令、请求、建议或禁止，语气随 context 变化；4. **感叹句 (Exclamatory)**：由 What 或 How 引导，用于宣泄强烈的喜怒哀乐。中考的火力点高度集中在：反义疑问句的“逻辑一致性”与特殊变化规则；感叹句 What 与 How 的结构互换；以及祈使句在“祈使句 + and/or + 陈述句”复合逻辑中的关键作用。

### 深度考点解析
*   **反义疑问句的‘隐性否定词’陷阱**：如果主语中含有 few, little, never, hardly, seldom, nobody, nothing 等词，附加问句必须使用肯定形式。这是考生最易因粗心失分的地方。
*   **感叹句的‘中心语’判定法**：What + (a/an) + adj + N (名词)；How + adj/adv + 主 + 谓。黄金技巧：遮住主语和谓语，若末尾是名词选 What，若是形容词/副词选 How。
*   **反义疑问句的‘主语呼应’**：Everyone -> they; Something -> it; There be -> there; I am -> aren't I。
*   **选择疑问句的‘非此即彼’回答**：绝对禁止使用 Yes 或 No，必须根据实际情况选择其一进行完整或简略回答。
*   **祈使句的‘附加尾巴’**：Open the door, will you/won't you?（语气委婉）；Don't open it, will you? (否定祈使句附加问句固定使用 will you)。
*   **Let's vs Let us 的微差**：Let's... shall we? (包含听话人在内)；Let us... will you? (请求对方允许自己做某事)。""",
            syllabusDetails = listOf(
                "1. 熟练掌握陈述句的肯否定变换，特别是否定词 hardly, never 对反义疑问句附加部分的物理影响。",
                "2. 深度掌握四类疑问句的构成，重点攻克反义疑问句中 10 种以上核心特殊变化规则。",
                "3. 熟练运用祈使句，掌握其否定形式 Don't + 原形，以及在‘祈使句 + and/or’逻辑复合句中的应用。",
                "4. 精准掌握感叹句 What 与 How 的四大基本物理句型及相互转换的逻辑逻辑。",
                "5. 理解不同句子种类在真实语境中的交际功能差异及其背后的情感强度。",
                "6. 掌握各类疑问句在进入宾语从句后物理语序的陈述化转换规则。"
            ),
            relatedPoints = listOf(
                RelatedPoint("简单句基本句型", "语法的微观基石", "所有的句子种类本质上都是基于五大基本句型的语气和情感变体。"),
                RelatedPoint("连词", "祈使句的逻辑桥梁", "or 和 and 是连接祈使句与结果句、表达条件逻辑的核心纽带。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "武汉中考", "______ amazing story it is! I have never read such a good and moving book before.", listOf("A. What", "B. What an", "C. How", "D. How an"), "B", "【答案】B。本题考查感官句结构。story 是可数名词单数，amazing 以元音音素开头，用 What an...! 结构。", "误选 A 物理性漏掉 an；或误选 C，完全忽略了名词 story 的存在。", "多么神奇的故事啊！我以前从未读过这么好、这么动人的书。"),
                PastExamQuestion("2023", "西安中考", "He can hardly speak English in front of the public, ______ he?", listOf("A. can", "B. can't", "C. does", "D. doesn't"), "A", "【答案】A。本题考查反义疑问句。hardly 是否定词，遵循‘前否后肯’逻辑，附加问句必须用肯定 can he。", "误选 B，未能识别出 hardly 这一词汇的隐性否定意义。", "他几乎不会在公众面前说英语，是吗？"),
                PastExamQuestion("2022", "成都中考", "______ careful and patient when you cross the street during the busy rush hour!", listOf("A. Is", "B. Be", "C. Being", "D. To be"), "B", "【答案】B。本题考查祈使句构成。祈使句必须以动词原形开头，be 是连系动词 be 的原形形态。", "误选 Is，受主谓一致思维的干扰。", "在繁忙的高峰期过马路时要小心、要有耐心！")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("What a wonderful concert the students gave! Do you like the beautiful classical music played by them? Please sit down quietly and enjoy the performance. Don't make any noise during the show, will you? Everyone is waiting for the next amazing song to start on the stage right now.", listOf(
                    HighlightedSentence("What a wonderful concert!", "典型的感叹句结构，用于修饰中心名词 concert。"),
                    HighlightedSentence("Don't make any noise, will you?", "否定祈使句的反义疑问句在英语中通常固定使用 will you 以示请求。")
                ), "人教版七上 Unit 3"),
                TextbookParagraph("How fast the time flies in our life! We have already finished our junior high school life and we'll leave soon. Let's say goodbye to our teachers and friends, shall we? We will never forget the time we spent together in this school during the past three years.", listOf(
                    HighlightedSentence("How fast the time flies!", "感叹句结构，修饰副词 fast，表达对时间流逝的感慨。"),
                    HighlightedSentence("Let's..., shall we?", "Let's 引导的祈使句包含了对方在内，其附加问句固定使用 shall we。")
                ), "外研版九下 Module 6")
            ),
            exampleSentences = listOf(
                ExampleSentence("What bad weather it is for a football match in the open air today!", "今天的露天足球赛天气多么糟糕啊！", "【分析】weather 是核心不可数名词，因此感叹句结构中不能加 a 或 an。", "基础必会"),
                ExampleSentence("Open the window to let some fresh air in right now, won't you?", "现在打开窗户让新鲜空气进来好吗？", "【分析】肯定祈使句的反义疑问句常用 will you 或 won't you 以增强委婉语气。", "中考核心"),
                ExampleSentence("How beautiful the flowers are in spring in our big school garden!", "我们学校大花园里的春天花朵多么漂亮啊！", "【分析】How 直接修饰形容词 beautiful，主谓语置于句末。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 感叹句 What 与 How 逻辑混淆（物理漏掉名词或冠词）；2. 反义疑问句忽略隐性否定词（如 few, little）；3. 祈使句动词未用原形。"),
                TeachingNote("教学建议", "采用‘遮盖判定法’锁定 What/How；整理并背诵‘反义疑问句 10 大特殊规则表’；通过情景剧模拟练习祈使句的不同语气。")
            ),
            famousQuote = "Actions speak louder than words!",
            quoteAuthor = "Abraham Lincoln"
        ),
        KnowledgePoint(
            id = "five_basic_patterns",
            section = SEC_3,
            title = "五大基本句型 (Five Basic Sentence Patterns)",
            description = """### 核心概念详解
五大基本句型 (Five Basic Sentence Patterns) 是英语句法的底层基因，所有的长难句无论如何变化，最终都可以还原为这五种骨架。1. **S+V (主+谓)**：由不及物动词构成，动作不涉及承受者（如 He runs）；2. **S+V+O (主+谓+宾)**：由及物动词构成，最常见的结构（如 I love music）；3. **S+V+P (主+系+表)**：由连系动词构成，描述主语的特征或状态（如 She is happy）；4. **S+V+IO+DO (主+谓+间宾+直宾)**：涉及两个宾语，通常是“人”和“物”（如 Give me a book）；5. **S+V+O+OC (主+谓+宾+宾补)**：宾语后面需要补充说明，使语义完整（如 Make me happy）。掌握这些句型是进行长难句拆解、成分分析及精准翻译的先决条件。

### 深度考点解析
*   **双宾语的‘位置置换’与介词选择**：V + sb + sth = V + sth + to/for + sb。给某人用 to (give, show, tell, bring)；为某人用 for (buy, make, get, cook)。这是中考作文和填空的常客。
*   **宾语补足语的‘形态万花筒’**：宾补可以是形容词 (Make him happy)、名词 (Call him Tom)、不带 to 的不定式 (Let him go) 或现在分词 (Keep the fire burning)。
*   **系动词的‘全方位覆盖’**：Be 动词、感官系 (look, smell, taste)、持续系 (keep, stay, remain)、变化系 (become, turn, get)。
*   **不及物动词的状语修饰误区**：He runs fast. 这里的 fast 是副词作状语，并非宾语或表语。
*   **形式宾语 it 的结构**：Find it + adj + to do. 这里的 it 是形式宾语，adj 是宾补，to do 是真正的宾语。""",
            syllabusDetails = listOf(
                "1. 深刻理解并能在各种复杂长难句中迅速识别五大基本句型的物理骨架结构。",
                "2. 熟练掌握 S+V+P 结构中三类系动词（感官类、变化类、状态类）的物理分类与应用。",
                "3. 掌握双宾语结构中 to 与 for 引导间接宾语的 20 个以上核心高频动词的精准区分。",
                "4. 深刻理解宾语补足语的逻辑内涵，掌握 keep, make, find, help 等词接不同形态宾补的用法。",
                "5. 掌握 find it + adj + to do 句型中 it 作为形式宾语的高级语法功能。",
                "6. 能够对复杂的英语长句进行‘剥洋葱式’骨干提取，识别核心语义。"
            ),
            relatedPoints = listOf(
                RelatedPoint("动词基础", "语义的决定性", "动词的及物性、双宾性及系动词属性直接决定了整个句型的基本物理走向。"),
                RelatedPoint("宾语从句", "成分的实质填充", "宾语从句在宏观上本质上是填充了 S+V+O 结构中的 O（宾语）这一位置单元。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "合肥中考", "Our English teacher often tells ______ interesting stories in the afternoon class.", listOf("A. we", "B. us", "C. our", "D. ours"), "B", "【答案】B。本题考查 S+V+IO+DO 结构。tells 是双宾动词，后面接人称代词宾格 us 作为间接宾语。", "误选形容词性物主代词 C，忽略了代词在句中的成分。", "我们的英语老师经常在下午的课上给我们讲有趣的故事。"),
                PastExamQuestion("2023", "长沙中考", "Winning the gold medal in the competition made him ______ beyond description.", listOf("A. happily", "B. happiness", "C. happy", "D. to happy"), "C", "【答案】C。本题考查 S+V+O+OC 结构。make sb + adj，形容词 happy 作为宾语补足语说明主语的状态。", "误选副词 A 或名词 B，未能识别出宾补的属性要求。", "赢得比赛的金牌让他高兴得无法形容。"),
                PastExamQuestion("2022", "南京中考", "He promised ______ me a beautiful gift for my 15th birthday next week.", listOf("A. buy", "B. to buy", "C. buying", "D. bought"), "B", "【答案】B。本题考查 S+V+O 结构。promise to do sth 是固定句法结构，不定式短语充当宾语。", "误选 buying，混淆了非谓语动词的固定搭配规律。", "他承诺下周给我买一份漂亮的 15 岁生日礼物。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("The classical music sounds sweet and peaceful to me after school. It always makes me feel relaxed and calm after a long day of hard work in the classroom. I like listening to it because it is elegant. My parents bought me a new and expensive CD player last year for my birthday.", listOf(
                    HighlightedSentence("The music sounds sweet", "S+V+P (主系表) 结构，sound 是典型的感官连系动词。"),
                    HighlightedSentence("bought me a CD player", "S+V+IO+DO (主谓双宾) 结构，me 是人（间宾），player 是物（直宾）。")
                ), "人教版八上 Unit 4"),
                TextbookParagraph("We found the new film about the brave dog very interesting and moving. It tells a great story about a little boy and his smart pet. They overcame many difficulties and finally returned home together safely. We should learn from their amazing courage and friendship.", listOf(
                    HighlightedSentence("found the film very interesting", "S+V+O+OC (主谓宾宾补) 结构，形容词 interesting 物理上补充说明 film 的核心特征。"),
                    HighlightedSentence("tells a story", "S+V+O (主谓宾) 结构，这是英语中最具代表性的及物动词骨架。")
                ), "外研版九下 Module 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("The birds are singing loudly in the tall trees in our garden today.", "今天鸟儿在我们花园的高树上大声地唱歌。", "【分析】S+V 结构，sing 是典型的不及物动词，后跟状语修饰。", "基础必会"),
                ExampleSentence("Please pass me the salt and pepper on the dining table.", "请把餐桌上的盐和胡椒粉递给我。", "【分析】S+V+IO+DO 结构（祈使句省略了逻辑主语 You）。", "基础必会"),
                ExampleSentence("Keep the classroom clean and tidy every single day for ourselves.", "每一天都要为我们自己保持教室的干净与整洁。", "【分析】S+V+O+OC 结构，形容词短语 clean and tidy 作为宾语补足语。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 物理性混淆宾补与状语（如误用副词作宾补）；2. 双宾语介词 to 与 for 逻辑选错；3. 忽略系动词后必须接形容词的硬性要求。"),
                TeachingNote("教学建议", "建议教师采用‘积木搭建’教学法；利用‘主、谓、宾’物理卡片进行组合练习；通过‘剥洋葱’法拆解复杂的文学长难句。")
            ),
            famousQuote = "Practice makes perfect.",
            quoteAuthor = "English Proverb"
        ),
        KnowledgePoint(
            id = "object_clause",
            section = SEC_3,
            title = "宾语从句 (Object Clause)",
            description = """### 核心概念详解
宾语从句 (Object Clause) 是中考句法体系中的“皇冠”，其综合考查了连接词、语序和时态三大维度的协调性。掌握宾语从句必须死守“三要素”法则：1. **连接词的选择**：that (引导陈述句，在口语中常省略)；if/whether (引导一般疑问句，意为‘是否’)；what, how, where, why, when 等 (引导特殊疑问句)。2. **物理语序的陈述化**：无论原句的疑问语序如何，一旦嵌套进从句，必须强制转换为**“连接词 + 主语 + 谓语”**的陈述形式。3. **时态的呼应一致性**：主句是现在时，从句时态根据实际情况随意选；主句是过去时，从句时态必须强制向后退一级；**特殊例外**：若从句描述的是客观真理、科学事实或自然现象，时态永远锁定一般现在时。

### 深度考点解析
*   **语序的‘拆弹’逻辑**：Do/Does/Did 引导的疑问句入从句，必须彻底拆除助动词，并将谓语动词还原为对应形态（如 Does he live -> where he lives）。
*   **If 与 Whether 的生死抉择**：在 or not 紧跟、介词之后、discuss 之后或引导主语从句时，必须使用 whether 而非 if。
*   **时态的‘客观事实豁免权’**：The teacher told us the earth moves around the sun. 即使主句 told 是过去式，moves 绝不能变 moved。
*   **疑问词 + 不定式的‘极致简化’**：I don't know what I should do = I don't know what to do. 这种转换是句型改写的必考点。
*   **Could you tell me...? 的客套误区**：这只是礼貌委婉语，主句实质上仍是一般现在时，因此从句时态不需要受主句影响而强制后退。
*   **否定转移的‘乾坤大挪移’**：当主句谓语是 think, believe, suppose 且主语是第一人称时，从句的否定语义需物理前移至主句。""",
            syllabusDetails = listOf(
                "1. 深刻理解宾语从句的定义：在主句中整体充当宾语成分的从句物理单元。",
                "2. 熟练掌握三类连接词的选择标准，能精准辨析 if 与 whether 的语用功能差异。",
                "3. 掌握宾语从句的‘陈述语序’强制转换（重点：去除疑问句中的助动词并还原主谓关系）。",
                "4. 深刻领会时态呼应原则及在客观事实、科学真理场景下的‘例外’豁免法则。",
                "5. 熟练掌握‘疑问词 + 不定式’结构与宾语从句之间的同义转换物理技巧。",
                "6. 掌握主句为 I think/believe 时的否定语义转移规则及其在反义疑问句中的表现。"
            ),
            relatedPoints = listOf(
                RelatedPoint("简单句基本句型", "骨干支撑", "宾语从句在宏观句型中实质上是填充了宾语这一成分单元。"),
                RelatedPoint("状语从句", "If 的多重身份辨析", "需深度区分宾从中的 if (是否) 与状从中的 if (如果，适用主将从现)。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "武汉中考", "Could you please tell me ______ in the city center?", listOf("A. where is the post office", "B. where the post office is"), "B", "【答案】B。本题考查宾语从句的语序法则。从句必须强制使用陈述语序（主语在前，谓语在后）。", "误选 A，受汉语思维影响习惯性保留了原句的疑问语序结构。", "你能告诉我市中心的邮局在哪里吗？"),
                PastExamQuestion("2023", "上海中考", "I wonder ______ she will come to our graduation party tonight.", listOf("A. that", "B. if", "C. what", "D. which"), "B", "【答案】B。本题考查连接词的选择。wonder 暗示了说话者的不确定性，引导词应为‘是否’，故选 if。", "误选 that，that 用于引导确定的事实陈述。", "我想知道她今晚是否会来参加我们的毕业派对。"),
                PastExamQuestion("2022", "广东中考", "The teacher told the students that the earth ______ around the sun constantly.", listOf("A. move", "B. moves", "C. moved", "D. is moving"), "B", "【答案】B。本题考查客观真理的时态。虽然主句 told 是过去式，但从句描述的是永恒的科学事实，时态固定锁定一般现在时。", "受时态呼应原则的干扰而选了过去式 moved。", "老师告诉学生们地球恒定地绕着太阳转。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Many people around the world wonder how the Great Wall was built in ancient times without any modern machines. Our history teacher told us that it took hundreds of years and millions of workers to complete the project. She also mentioned that thousands of people worked on it day and night for many centuries.", listOf(
                    HighlightedSentence("wonder how the Great Wall was built", "how 引导特殊疑问句性质的宾语从句，采用陈述语序和一般过去时。"),
                    HighlightedSentence("told us that it took", "that 引导陈述意义的宾语从句，由于主语 told 是过去式，从句时态随之后退一级。")
                ), "人教版九年级 Unit 6"),
                TextbookParagraph("I don't know if he will arrive on time for the important meeting tomorrow. But if he arrives, I will tell him the latest news immediately. My mother asked me whether I had finished my homework or not before I went out to play with my classmates in the park.", listOf(
                    HighlightedSentence("don't know if he will arrive", "if 引导宾语从句，意为‘是否’，在此可以使用将来时态以符逻辑。"),
                    HighlightedSentence("whether I had finished... or not", "当 or not 显性出现时，引导宾语从句的连接词物理上首选 whether。")
                ), "外研版九下 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("Do you know what time the school library opens on Saturday morning?", "你知道学校图书馆周六早上几点开门吗？", "【分析】核心考位在于从句语序必须是 the library opens (主+谓)。", "基础必会"),
                ExampleSentence("He asked me where I had been the day before during the rainstorm.", "他问我前一天暴风雨期间去哪里了。", "【分析】主句 asked 触发时态后退至过去完成时，且语序保持陈述化。", "中考核心"),
                ExampleSentence("I believe that everyone can realize their dreams through their own hard work.", "我相信每个人都能通过他们自己的努力实现梦想。", "【分析】that 引导的最简单的陈述意义宾语从句，that 在口语中可省。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 语序非陈述化（最重灾区）；2. 时态未执行呼应或在客观真理场景下乱呼应；3. if 与 whether 物理性选错。"),
                TeachingNote("教学建议", "建议教师采用‘宾从公式法’：连接词 + 主语 + 谓语；通过‘逻辑拆弹’游戏去掉助动词；制作‘时态呼应’阶梯图。")
            ),
            famousQuote = "I know that I know nothing.",
            quoteAuthor = "Socrates"
        ),
        KnowledgePoint(
            id = "attributive_clause",
            section = SEC_3,
            title = "定语从句 (Attributive Clause)",
            description = """### 核心概念详解
定语从句 (Attributive Clause) 是英语中为名词进行“深度画像”的语法工具。当一个简单的形容词不足以刻画先行词时，我们就需要用一个句子来充当定语。其物理构成包括三个核心组件：1. **先行词 (Antecedent)**：被修饰的名词或代词；2. **关系词 (Relative)**：引导从句并指代先行词（that, which, who, whom, whose）；3. **定语从句本体**。中考的重难点锁定在关系词的精准选择上：逻辑主线是看先行词是“人”还是“物”，以及关系词在从句中承担什么成分（主语或宾语）。此外，考生必须攻克“只能使用 that”的六大硬核场景，以及理解关系代词在作宾语时可以物理省略的隐身规则。

### 深度考点解析
*   **That 的‘霸权’场景**：先行词被 the only, the very, the last 修饰；先行词是不定代词 (all, anything, nothing)；先行词受形容词最高级或序数词修饰。在这些情境下，which 必须让位于 that。
*   **Whose 的‘万能所有格’功能**：先行词 + whose + 名词。既可指代人的所属（The boy whose father...），也可指代物的所属（The house whose window...）。
*   **Who vs Whom 的格位差**：Who 既可作主语也可作宾语；Whom 仅能作宾语（且常出现在介词之后）。
*   **关系词省略的‘识别码’**：当关系词后紧跟“主语+谓语”结构时，该关系词通常作宾语，在中考填空中常可以省略或选‘/’。
*   **Which 引导的非限制性从句**：虽然中考侧重限制性从句，但需识别 comma (逗号) 后的 which 对前句的整体修饰作用。
*   **定语从句的主谓一致陷阱**：The books that are on the desk... (谓语动词 are 取决于先行词 books 的复数形态)。""",
            syllabusDetails = listOf(
                "1. 深刻理解先行词与关系词的对应逻辑模型（人对应 who/that，物对应 which/that）。",
                "2. 熟练掌握 who, whom, which, that 在从句中充当主语或宾语的各种物理规则。",
                "3. 掌握 whose 表达所属关系的独特句法功能，能区分指人与指物的不同语境。",
                "4. 深刻领会并背诵‘只能使用 that’的六大典型中考考查场景清单。",
                "5. 深刻理解并能识别关系词作宾语时的省略规则及其对句子结构的影响。",
                "6. 掌握定语从句中的主谓一致判定标准（即关系词作主语时谓语随先行词变）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词", "先行词的本质属性", "先行词的生命属性与数直接决定了关系词的选择范围与谓语形态。"),
                RelatedPoint("形容词", "定语的职能延伸", "定语从句在本质上是一个具有动态叙述能力的、长链条的复合形容词单元。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "广州中考", "The boy ______ is wearing a red T-shirt and blue jeans is my brother.", listOf("A. who", "B. which", "C. whose", "D. /"), "A", "【答案】A。本题考查关系代词。先行词 boy 是人，在从句中充当主语，必须用 who 或 that。", "误选 which，忽略了先行词的人称属性特征。", "那个穿着红色 T 恤和蓝色牛仔裤的男孩是我弟弟。"),
                PastExamQuestion("2023", "北京中考", "This is the most interesting and moving movie ______ I have ever seen in my life.", listOf("A. which", "B. that", "C. who", "D. whose"), "B", "【答案】B。本题考查只能使用 that 的特殊场景。先行词 movie 前有形容词最高级修饰，关系词物理上锁定为 that。", "习惯性选了 which，忽略了最高级这一限制性因素的限定作用。", "这是我一生中曾看过的最有趣、最动人的电影。"),
                PastExamQuestion("2022", "南京中考", "Do you know the young girl ______ mother is a famous singer in our country?", listOf("A. who", "B. which", "C. whose", "D. whom"), "C", "【答案】C。本题考查关系词 whose 的所有格用法。表示‘那个女孩的妈妈’这一所属关系，必须用 whose。", "误选 who，who 在句中不能表达所属关系。", "你认识那个妈妈是我们国家著名歌手的年轻女孩吗？")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("I like music that I can dance to when I'm happy or excited. My sister prefers songs that have great lyrics and deep meanings. We both enjoy visiting concerts which are held in the public park during every summer holiday for the local people to enjoy.", listOf(
                    HighlightedSentence("music that I can dance to", "先行词 music 是物，that 在从句中充当介词 to 的逻辑宾语。"),
                    HighlightedSentence("concerts which are held", "先行词 concerts 是物，which 在从句中充当主语，谓语动词 are 随先行词变复数。")
                ), "人教版九年级 Unit 9"),
                TextbookParagraph("People who are friendly, helpful and kind are always popular in our society. In our class, Zhang Lei is the one who helps others most. He is a person that we can always depend on whenever we are in great trouble in our daily life.", listOf(
                    HighlightedSentence("People who are friendly", "先行词 people 是人，who 在从句中充当主语，谓语动词用 are。"),
                    HighlightedSentence("person that we can depend on", "that 引导定语从句，指代 person，在从句中充当宾语成分。")
                ), "外研版九下 Module 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("This is the bag (which) I bought yesterday at the shopping mall.", "这就是我昨天在商场买的那个包。", "【分析】关系代词 which 在从句中充当动词 bought 的宾语，因此物理上可以省略。", "基础必会"),
                ExampleSentence("The modern city where I was born is very beautiful and famous in spring.", "我出生的那个现代化城市在春天非常漂亮且著名。", "【分析】where 是关系副词，在从句中整体充当地点状语成分。", "中考核心"),
                ExampleSentence("He is the only student that can solve the hard math problem in our class.", "他是班里唯一能解决那个数学难题的学生。", "【分析】the only 修饰先行词时，关系词必须强制锁定为 that。", "中考核心")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 关系词人/物属性混淆；2. Whose 之后物理性丢掉名词；3. 忽略 that 的六大特殊限定场景；4. 从句主谓一致错误。"),
                TeachingNote("教学建议", "建议采用‘拼图法’：连接主句切口与从句桥梁；强化‘先行词五大特征识别’训练；整理并背诵‘必用 that 情况清单’。")
            ),
            famousQuote = "He who has a why to live for can bear almost any how.",
            quoteAuthor = "Friedrich Nietzsche"
        ),
        KnowledgePoint(
            id = "adverbial_clause",
            section = SEC_3,
            title = "状语从句 (Adverbial Clause)",
            description = """### 核心概念详解
状语从句 (Adverbial Clause) 是英语句子的“逻辑说明书”，负责提供动作发生的背景、原因、条件等关键信息。中考火力点覆盖了九大类别中的前五类：1. **时间状语从句**：掌握 when, while, as soon as (一...就), until, since (自从); 2. **条件状语从句**：核心词为 if 和 unless (除非); 3. **原因状语从句**：掌握 because, since, as; 4. **让步状语从句**：核心词为 although, though (虽有 although 无 but); 5. **结果状语从句**：掌握 so...that (如此...以至于) 与 such...that。中考的绝杀考点在于：在时间与条件从句中严格执行“主将从现”原则；以及 because/so, although/but 的互斥法则。

### 深度考点解析
*   **主将从现的‘三位一体’**：If, When, As soon as。这是中考频率最高的考位，要求考生具备全局时态逻辑感。
*   **Until 的否定逻辑陷阱**：Wait until (等) vs Not... until (直到...才)。否定句中，主句谓语必须是瞬时动词。
*   **Unless 的逻辑代换法**：Unless 物理上完美等同于 If... not，在条件推导中具有排他性。
*   **So vs Such 的物理分界线**：So 直接修饰形容词/副词；Such 必须强制修饰名词（尤其是不可数名词前的 such 极具杀伤力）。
*   **Though 的副词特殊身份**：虽然 although 是连词，但 though 可以在句末作为副词表示‘然而’。
*   **While 的多义逻辑**：既可引导时间从句（强调正在进行），也可表示‘然而’表达强烈的对比逻辑（I like red, while she likes blue）。""",
            syllabusDetails = listOf(
                "1. 深刻理解并运用状语从句的九大分类及其对应的核心从属连词逻辑含义。",
                "2. 熟练、无误地掌握时间与条件状语从句中的‘主将从现’物理原则。",
                "3. 掌握 because 与 so, although/though 与 but 的‘二选一’互斥法则，严防汉语式冗余。",
                "4. 深度辨析 so...that 与 such...that 的物理结构差异（修饰形容词 vs 修饰名词单元）。",
                "5. 掌握 since (自从) 的主从时态固定配对原则（主完从过）。",
                "6. 理解 as soon as (一...就) 的即时逻辑反应链条及其时态应用。"
            ),
            relatedPoints = listOf(
                RelatedPoint("连词", "逻辑引导的灵魂", "引导词的性质直接决定了从句与主句之间的逻辑流向与方向。"),
                RelatedPoint("时态", "主从逻辑配对", "状语从句是中考考查‘主将从现’、‘主完从过’等高级时态协调的主战场。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "杭州中考", "We will have a big picnic if it ______ tomorrow according to the weather report.", listOf("A. won't rain", "B. doesn't rain", "C. isn't raining", "D. wouldn't rain"), "B", "【答案】B。本题考查条件状语从句的时态逻辑。if 引导的从句遵循‘主将从现’，主句 will have，从句必须用一般现在时的否定 doesn't rain。", "受 tomorrow 干扰物理性选了将来时 A。", "如果根据天气预报明天不下雨，我们就去大野餐。"),
                PastExamQuestion("2023", "上海中考", "He was ______ tired after the long match ______ he fell asleep immediately.", listOf("A. so; that", "B. such; that", "C. too; to", "D. enough; to"), "A", "【答案】A。本题考查结果状语从句。tired 是形容词性质，前面必须用 so 修饰，构成 so...that 逻辑结构。", "误选 such，忽略了 such 必须修饰名词性短语的硬性规则。", "在长赛之后他如此疲惫，以至于立刻就睡着了。"),
                PastExamQuestion("2022", "广东中考", "______ she is very busy every day, she still finds some time to exercise.", listOf("A. Because", "B. Although", "C. Since", "D. If"), "B", "【答案】B。本题考查让步状语从句。前句‘忙’与后句‘运动’构成转折关系，必须用 although 引导。", "误选 because，导致句子逻辑因果倒置。", "虽然她每天都很忙，但她仍会找时间运动。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("As soon as the bell rings for the end of the classes, the students will run out of the classroom happily. They will go to the playground because they have an exciting PE class today. Although the sun is very strong at noon, they are still excited about doing sports together.", listOf(
                    HighlightedSentence("As soon as the bell rings", "典型的持续时间状语从句，遵循主将从现的物理规则。"),
                    HighlightedSentence("Although the sun is very strong", "让步状语从句，用于表达转折逻辑关系，句中绝对不加 but。")
                ), "人教版八下 Unit 6"),
                TextbookParagraph("I haven't seen my old best friend since he moved to Shanghai last year with his whole family. He told me that he was having such a great time there that he didn't want to come back. If I have enough time next month, I will certainly visit him.", listOf(
                    HighlightedSentence("since he moved... last year", "since 引导的时间状语从句，从句用一般过去时，主句锁定现在完成时。"),
                    HighlightedSentence("such a great time... that", "such 物理上修饰包含了中心名词 time 的名词短语，引导结果状语从句。")
                ), "外研版九下 Module 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("Wait until the light turns green before you cross the street safely.", "在安全过马路之前，请一直等到绿灯亮起。", "【分析】until 引导时间状语从句，表达动作持续到某一个特定的物理时刻。", "基础必会"),
                ExampleSentence("Unless it rains tomorrow afternoon, the football match will start on time.", "除非明天下午下雨，否则足球赛将准时开始。", "【分析】unless 逻辑上等同于 if...not，同样遵循主将从现原则。", "中考核心"),
                ExampleSentence("The box is so heavy that I can't lift it by myself without any help.", "这个箱子如此之重，以至于我一个人在没有帮助的情况下搬不动。", "【分析】so...that 结构引导结果状语从句，so 负责修饰形容词 heavy。", "基础必会")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. 时态物理匹配错误（从句误用 will）；2. 连词双重冗余套用（bc/so, although/but）；3. so 与 such 物理性误用；4. 逻辑关系颠倒。"),
                TeachingNote("教学建议", "建议教师采用‘逻辑连连看’进行匹配训练；强化‘主将从现’口诀；深度辨析 though 的连词属性与副词属性。")
            ),
            famousQuote = "If you want to go fast, go alone. If you want to go far, go together.",
            quoteAuthor = "African Proverb"
        ),
        KnowledgePoint(
            id = "special_patterns",
            section = SEC_3,
            title = "特殊句式 (Special Sentence Patterns)",
            description = """### 核心概念详解
特殊句式 (Special Sentence Patterns) 是英语中的“表情符号”或“强调滤镜”，用于打破常规句式以突出特定信息或语气。中考高频覆盖：1. **There be 句型**：表达某处存在某物，核心难点在于主谓一致遵循“就近原则”及将来时态的正确构成；2. **It 引导的特殊句式**：包含形式主语（It's adj to do）、形式宾语（Find it adj to do）以及强调句（It is...that...）；3. **部分倒装 (Inversion)**：重点考查 so/neither/nor 引导的倒装，用于表达“也一样/也不一样”；4. **So do I 与 So I do 的逻辑之辩**：前者代表“我也一样”，后者代表“我的确做了”（表示赞同事实）；5. **祈使句混合逻辑**：如“祈使句 + and/or + 陈述句”。掌握特殊句式是提升作文语言档次的关键。

### 深度考点解析
*   **There be 的‘主权’归属**：后面绝不能接 have；当主语是多个并列名词时，谓语动词只看向离它最近的那个（There is a book and two pens）。
*   **So do I 的‘三位一致’原则**：助动词一致（do/does/did）、时态一致、人称对应一致。
*   **It takes sb some time to do sth**：It 为形式主语，真正的逻辑主语是不定式短语。
*   **It is time 的‘虚拟’暗示**：It's time (for sb) to do sth 与 It's time that sb did sth (用过去式) 的结构切换。
*   **倒装句的‘核心诱因’**：当 so, neither, never, hardly 等具有否定或特定语义的词置于句首时，必须触发部分倒装逻辑。
*   **There will be vs There is going to be**：严禁汉语直译导致的 There will have 物理性错误。""",
            syllabusDetails = listOf(
                "1. 深刻理解并熟练运用 There be 句型及其在各种复杂时态（特别是一般将来时）下的变体。",
                "2. 掌握 It 作为形式主语与形式宾语的典型中考句式物理结构（It is adj to do...）。",
                "3. 熟练掌握 so/neither/nor 引导的部分倒装句及其在不同时态语境下的语用功能。",
                "4. 深度辨析 So do I (我也是) 与 So I do (我的确如此) 的语境逻辑差异。",
                "5. 掌握‘祈使句 + and/or + 陈述句’这一带有隐性条件逻辑含义的混合句式物理应用。",
                "6. 掌握 There be 句型中的‘就近原则’主谓一致规律。"
            ),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "就近原则的典型应用", "There be 句型是中考考查就近原则最核心、最典型的应用场景单元。"),
                RelatedPoint("代词", "It 的多功能角色", "It 在特殊句式中充当的形式化成分，是代词功能在中考应用中的高级体现。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2024", "北京中考", "— Li Hua won the first prize in the national math competition.\n— ______. He worked really hard.", listOf("A. So he did", "B. So did he", "C. Neither did he", "D. So was he"), "A", "【答案】A。本题考查 so 引导的强调赞同。后句‘他工作努力’证明了前句的事实，故用 So he did (他的确如此)。", "误选 B，So did he 意为‘他也赢了’，物理逻辑不符合当前语境。", "—— 李华在国家数学竞赛中获得了一等奖。 —— 他确实获得了。他工作非常努力。"),
                PastExamQuestion("2023", "上海中考", "There ______ a football match on TV tonight for us to watch, isn't there?", listOf("A. will have", "B. is going to be", "C. is going to have", "D. was"), "B", "【答案】B。本题考查 There be 句型的将来时构成。物理上不能用 have，排除 A/C。反义疑问句 isn't there 提示主句是 is...be 结构。", "误选 A，汉语式翻译‘将会有’物理性导致错用 have。", "今晚电视上将有一场足球赛给我们看，不是吗？"),
                PastExamQuestion("2022", "广东中考", "— I have never been to Paris in my life. What about you?\n— ______.", listOf("A. So have I", "B. Neither have I", "C. So I have", "D. Neither I have"), "B", "【答案】B。本题考查倒装句逻辑。前句是完成时的否定句，表达‘我也没去过’需用 Neither + 助动词 + 主语。", "误选 A，物理性忽略了前句中 never 这一否定词的存在。", "—— 我一生从未去过巴黎。你呢？ —— 我也没去过。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("There is a small park near our school with many green trees. There are many colorful flowers in it during every spring and summer. It's a good place for us to relax and study. It takes about five minutes to walk there from our classroom every day.", listOf(
                    HighlightedSentence("There is a small park", "There be 句型遵循就近原则，因此谓语动词锁定为单数 is。"),
                    HighlightedSentence("It's a good place for us to relax", "It 在此作形式主语，真正的语义对象是后面的不定式短语 to relax。")
                ), "人教版七下 Unit 1"),
                TextbookParagraph("If you don't go to the graduation party tonight, neither will I because I want to stay with you. I think it is important for us to spend some time together. So I hope you can change your mind and join us in the end.", listOf(
                    HighlightedSentence("neither will I", "部分倒装句式，用于表达‘我也不去’，助动词 will 提前至主语前。"),
                    HighlightedSentence("it is important for us to", "It's + adj + for sb + to do 经典形式主语句法结构。")
                ), "外研版九下 Module 5")
            ),
            exampleSentences = listOf(
                ExampleSentence("There is a world map and two English books on the desk for you.", "桌上有一张世界地图和两本英语书给你。", "【分析】There be 就近原则典型示例，谓语动词随 a world map 用单数。", "基础必会"),
                ExampleSentence("It took me three full hours to finish the hard work yesterday.", "昨天花了我整整三个小时才完成那项艰巨的工作。", "【分析】It takes sb some time to do sth 经典物理结构示例。", "基础必会"),
                ExampleSentence("So fast did he run that I couldn't catch him in the end of the race.", "他跑得如此之快，以至于我在比赛最后都没能追上他。", "【分析】so 修饰的程度成分置于句首，触发部分倒装逻辑（中考高阶语法）。", "高阶句式")
            ),
            teachingNotes = listOf(
                TeachingNote("常见错误", "1. There be 与 have 逻辑混用；2. So do I 与 So I do 的语境逻辑判错；3. 倒装句助动词匹配错误（如实义动词忘了借 do/does）。"),
                TeachingNote("教学建议", "建议教师采用‘镜子原理’讲解倒装：So do I 就像在照镜子；对比练习 so do I 与 so I do 的微差；强化 There be 句型的时态变换训练。")
            ),
            famousQuote = "It is never too late to learn.",
            quoteAuthor = "English Proverb"
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints.first()
    }
}
