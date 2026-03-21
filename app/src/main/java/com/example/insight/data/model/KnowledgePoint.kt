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

data class TextbookParagraph(
    val content: String,
    val source: String
)

data class ExampleSentence(
    val english: String,
    val chinese: String
)

data class KnowledgePoint(
    val id: String,
    val title: String,
    val description: String,
    val relatedPoints: List<String>,
    val exampleProblems: List<ExampleProblem>,
    val pastExamQuestions: List<PastExamQuestion> = emptyList(),
    val textbookParagraphs: List<TextbookParagraph>,
    val exampleSentences: List<ExampleSentence>
)

object KnowledgeProvider {
    val allPoints = listOf(
        KnowledgePoint(
            id = "0",
            title = "名词 (Nouns)",
            description = "名词是表示人、事物、地点或抽象概念的词。中考大纲要求：1. 可数名词及其复数形式；2. 不可数名词及其数量表达；3. 专有名词和普通名词的区别；4. 名词所有格的构成及用法（'s 所有格与 of 所有格）。",
            relatedPoints = listOf("可数名词复数变化规则", "不可数名词常见词汇", "双重所有格", "名词作定语"),
            exampleProblems = listOf(
                ExampleProblem("How many ______ are there in the basket?", listOf("A. apple", "B. apples", "C. milk", "D. water"), "B", "how many 修饰可数名词复数。"),
                ExampleProblem("The ______ of the twin brothers are both teachers.", listOf("A. father", "B. mother", "C. parents", "D. parent"), "C", "双胞胎兄弟的父母，主语是复数，且谓语是 are。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "北京中考", "My father bought three ______ yesterday. We will make beef and potato soup tonight.", listOf("A. tomatoes", "B. tomato", "C. potato", "D. potatoes"), "A", "three 后接可数名词复数。tomato 的复数是加 es。"),
                PastExamQuestion("2022", "江苏苏州中考", "The ______ of the research is to find out more about how we can protect the environment.", listOf("A. standard", "B. purpose", "C. method", "D. result"), "B", "考查名词辨析。purpose 目的；这项研究的目的是找出如何保护环境。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I have a lot of homework to do today.", "—— 摘自《人教版初二上》")),
            exampleSentences = listOf(ExampleSentence("Information is very important.", "信息非常重要。"), ExampleSentence("This is my sister's room.", "这是我妹妹的房间。"))
        ),
        KnowledgePoint(
            id = "1",
            title = "代词 (Pronouns)",
            description = "代词是代替名词或起名词作用的短语、句子的词。中考大纲要求：1. 人称代词（主格和宾格）；2. 物主代词（形容词性和名词性）；3. 反身代词；4. 指示代词（this, that, these, those）；5. 不定代词（some, any, no, every 及其复合物）；6. 疑问代词。",
            relatedPoints = listOf("人称代词语序", "it 的特殊用法", "形容词性 vs 名词性物主代词", "不定代词辨析"),
            exampleProblems = listOf(
                ExampleProblem("Is this your pen? — No, it's not ______. It's hers.", listOf("A. my", "B. mine", "C. me", "D. I"), "B", "这里指代“我的钢笔”，需用名词性物主代词。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "天津中考", "My grandmother is 80 years old, but she still looks after ______ well.", listOf("A. she", "B. her", "C. herself", "D. hers"), "C", "考查反身代词。look after herself 照顾她自己。"),
                PastExamQuestion("2022", "上海中考", "If you have any questions, you can ask ______ for help.", listOf("A. someone", "B. anyone", "C. everyone", "D. no one"), "B", "考查不定代词。anyone 用于疑问句或条件句表示“任何人”。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Everyone is having a good time.", "—— 摘自《人教版初一上》")),
            exampleSentences = listOf(ExampleSentence("I can do it by myself.", "我自己能行。"), ExampleSentence("There is something wrong with my phone.", "我的手机出问题了。"))
        ),
        KnowledgePoint(
            id = "2",
            title = "冠词 (Articles)",
            description = "冠词是置于名词前并说明名词所指的人或事物的词。中考大纲要求：1. 不定冠词 a/an 的用法（音素区分）；2. 定冠词 the 的特指、最高级前等用法；3. 零冠词的情况（球类、三餐等）。",
            relatedPoints = listOf("an 的特殊词汇 (hour, honest)", "定冠词 the 的 10 种情况", "球类 vs 乐器", "零冠词口诀"),
            exampleProblems = listOf(
                ExampleProblem("He is ______ honest boy.", listOf("A. a", "B. an", "C. the", "D. /"), "B", "honest [ˈɒnɪst] 以元音音素开头，用 an。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "河北中考", "They usually have ______ breakfast at 7:00 a.m. in the morning.", listOf("A. a", "B. an", "C. the", "D. /"), "D", "考查零冠词。三餐、球类、学科前不加冠词。"),
                PastExamQuestion("2022", "四川成都中考", "Li Lei is ______ honest boy. He never tells lies.", listOf("A. a", "B. an", "C. the", "D. /"), "B", "考查冠词。honest 是以元音音素开头的单词，用 an。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("The sun rises in the east.", "—— 摘自《科普版英语》")),
            exampleSentences = listOf(ExampleSentence("I play the piano every day.", "我每天弹钢琴。"), ExampleSentence("She goes to school by bus.", "她乘公交车上学。"))
        ),
        KnowledgePoint(
            id = "3",
            title = "数词 (Numerals)",
            description = "数词是表示数量或顺序的词。中考大纲要求：1. 基数词的写法与读法；2. 序数词的构成及缩写；3. 分数、小数、百分数的表达；4. 时间、日期、年份的表达。",
            relatedPoints = listOf("序数词构成规则", "分数构成 (子基母序)", "概数表达 (thousands of)", "具体数 (two thousand)"),
            exampleProblems = listOf(
                ExampleProblem("Today is my father's ______ birthday.", listOf("A. forty", "B. fortieth", "C. the forty", "D. the fortieth"), "B", "序数词表示第几个，且形容词性物主代词后不加 the。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "河南中考", "Our school library has more than ______ books.", listOf("A. two thousands", "B. two thousand", "C. thousand of", "D. thousands of"), "B", "考查具体数词。具体数字 + hundred/thousand/million 不加 s。"),
                PastExamQuestion("2022", "山东青岛中考", "This is the ______ time for him to visit the Great Wall.", listOf("A. three", "B. third", "C. thirsty", "D. thirteenth"), "B", "考查序数词。the third time 第三次。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Two thirds of the students are girls.", "—— 摘自《外研版初三上》")),
            exampleSentences = listOf(ExampleSentence("He lives on the fifth floor.", "他住在五楼。"), ExampleSentence("There are millions of stars in the sky.", "天空中有数百万颗星星。"))
        ),
        KnowledgePoint(
            id = "4",
            title = "形容词与副词 (Adj & Adv)",
            description = "形容词修饰名词，表示性质或特征；副词修饰动词、形容词、副词或全句。中考大纲要求：1. 形容词/副词的比较级和最高级；2. 比较级/最高级的规则与不规则变化；3. 常用比较结构（as...as, than 等）；4. 词性转换规律；5. 多个形容词修饰名词的顺序。",
            relatedPoints = listOf("比较级不规则变化", "越...越...结构", "the + 序数词 + 最高级", "形容词顺序口诀"),
            exampleProblems = listOf(
                ExampleProblem("The weather is getting ______.", listOf("A. warm and warm", "B. warmer and warmer", "C. warmest", "D. more warm"), "B", "“比较级 + and + 比较级”表示“越来越...”。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "湖北武汉中考", "The higher we climb, ______ the view is.", listOf("A. more beautiful", "B. the most beautiful", "C. the more beautiful", "D. beautiful"), "C", "考查 the + 比较级，the + 比较级。表示“越...就越...”。"),
                PastExamQuestion("2022", "福建中考", "The soup tastes ______ enough. I'd like more salt.", listOf("A. salty", "B. delicious", "C. sweet", "D. fresh"), "B", "考查形容词。tastes delicious 尝起来美味。enough 修饰形容词后置。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Music is more interesting than art.", "—— 摘自《人教版初一上》")),
            exampleSentences = listOf(ExampleSentence("I am as tall as my brother.", "我和我哥哥一样高。"), ExampleSentence("The news sounds exciting.", "这个消息听起来很令人兴奋。"))
        ),
        KnowledgePoint(
            id = "5",
            title = "介词 (Prepositions)",
            description = "介词表示名词、代词等与句中其他词的关系。中考大纲要求：1. 时间介词（in, on, at, for, since, before, after, by 等）；2. 地点介词（in, on, at, under, behind, next to, in front of 等）；3. 工具与手段介词（with, by, in）；4. 常用固定搭配。",
            relatedPoints = listOf("at/on/in 时间辨析", "by/in/with 工具辨析", "between vs among", "in front of vs in the front of"),
            exampleProblems = listOf(
                ExampleProblem("I usually go to bed ______ ten o'clock.", listOf("A. in", "B. on", "C. at", "D. for"), "C", "具体时刻前用 at。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "浙江杭州中考", "We will have a sports meeting ______ June 5th.", listOf("A. at", "B. in", "C. on", "D. by"), "C", "考查时间介词。具体的某一天用 on。"),
                PastExamQuestion("2022", "广东中考", "The library is ______ the park and the museum.", listOf("A. between", "B. among", "C. next", "D. across"), "A", "考查方位介词。between...and... 表示在两者之间。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("We have breakfast at 7:30 in the morning.", "—— 摘自《人教版初一上》")),
            exampleSentences = listOf(ExampleSentence("I'll be back in two days.", "我两天后回来。"), ExampleSentence("Everyone is here except Tom.", "除了汤姆大家都到了。"))
        ),
        KnowledgePoint(
            id = "6",
            title = "连词 (Conjunctions)",
            description = "连词是连接词、短语、从句或句子的词。中考大纲要求：1. 并列连词（and, but, or, so, both...and, either...or, neither...nor, not only...but also）；2. 从属连词（because, after, before, when, while, as soon as, although, if, unless, until 等）。",
            relatedPoints = listOf("but 与 although 不同时用", "so 与 because 不同时用", "neither...nor 就近原则", "or 在否定句用法"),
            exampleProblems = listOf(
                ExampleProblem("______ he is young, ______ he knows a lot.", listOf("A. Though; but", "B. Because; so", "C. Though; /", "D. Although; but"), "C", "though/although 不能与 but 连用。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "山西中考", "I don't like coffee ______ tea, I only like water.", listOf("A. and", "B. but", "C. or", "D. with"), "C", "考查并列连词。在否定句中表示两者都不，用 or 连接。"),
                PastExamQuestion("2022", "陕西中考", "______ my mother ______ my father can drive, so we have to go by taxi.", listOf("A. Not only; but also", "B. Both; and", "C. Neither; nor", "D. Either; or"), "C", "考查关联连词。根据语境“必须打车”可知都不会开车，选 neither...nor。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Work hard, and you will succeed.", "—— 摘自《科普版英语》")),
            exampleSentences = listOf(ExampleSentence("I'll wait until you come.", "我会一直等到你来。"), ExampleSentence("Study hard, or you'll fail.", "好好学习，否则你会挂科。"))
        ),
        KnowledgePoint(
            id = "7",
            title = "动词时态 (Tenses)",
            description = "动词时态表示动作发生的时间和状态。中考大纲要求掌握六种时态：1. 一般现在时；2. 一般过去时；3. 一般将来时；4. 现在进行时；5. 过去进行时；6. 现在完成时。",
            relatedPoints = listOf("现在完成时 for vs since", "since 后的时态", "主将从现原则", "过去完成时入门"),
            exampleProblems = listOf(
                ExampleProblem("I ______ my homework yet.", listOf("A. finished", "B. haven't finished", "C. am finishing", "D. will finish"), "B", "yet 用于否定句，常与现在完成时连用。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "安徽中考", "— Where is your sister? — She ______ the flowers in the garden.", listOf("A. water", "B. watered", "C. is watering", "D. was watering"), "C", "考查现在进行时。根据问句可知动作正在发生。"),
                PastExamQuestion("2022", "湖南长沙中考", "I ______ this book for two weeks. I have to return it now.", listOf("A. have lent", "B. have kept", "C. lent", "D. kept"), "B", "考查现在完成时延续性动词。for two weeks 是时间段，谓语需用延续性动词 keep。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I have been to the Great Wall twice.", "—— 摘自《人教版初二下》")),
            exampleSentences = listOf(ExampleSentence("I was reading at 8 last night.", "昨晚八点我正在读书。"), ExampleSentence("He will come back tomorrow.", "他明天回来。"))
        ),
        KnowledgePoint(
            id = "8",
            title = "被动语态 (Passive Voice)",
            description = "被动语态表示主语是动作的承受者。中考大纲要求：1. 被动语态的基本结构（be + done）；2. 一般现在时、一般过去时和含情态动词的被动语态；3. 主动语态变被动语态的步骤。",
            relatedPoints = listOf("主动变被动步骤", "by 短语省略", "不及物动词无被动", "make/hear 被动补 to"),
            exampleProblems = listOf(
                ExampleProblem("The flowers ______ every day.", listOf("A. water", "B. are watered", "C. watered", "D. are watering"), "B", "一般现在时被动语态：am/is/are + p.p.")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "四川达州中考", "Waste paper ______ in the bin, and then it can be recycled.", listOf("A. should put", "B. should be put", "C. must put", "D. must be put"), "B", "考查含情态动词的被动语态：情态动词 + be + done。"),
                PastExamQuestion("2022", "云南中考", "Cotton ______ in many parts of the world.", listOf("A. grows", "B. is grown", "C. grown", "D. is growing"), "B", "考查一般现在时的被动语态。棉花是被种植的。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Paper was invented by the Chinese.", "—— 摘自《人教版初三》")),
            exampleSentences = listOf(ExampleSentence("English is spoken world-wide.", "英语在全球范围内被使用。"), ExampleSentence("Children should be looked after well.", "孩子们应该被好好照看。"))
        ),
        KnowledgePoint(
            id = "9",
            title = "情态动词 (Modal Verbs)",
            description = "情态动词表示说话人的语气和情态。中考大纲要求掌握：1. can/could（能力、许可）；2. may/might（许可、推测）；3. must（必须、推测）；4. should（建议、义务）；5. need（需要）。",
            relatedPoints = listOf("must 否定回答用法", "must be 推测 vs can't be", "could/would 委婉语气", "need 作为实义动词"),
            exampleProblems = listOf(
                ExampleProblem("May I go now? — No, you ______.", listOf("A. needn't", "B. mustn't", "C. can't", "D. shouldn't"), "B/C", "否定回答“不可以”用 mustn't 或 can't。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "广东中考", "— Can I cross the road now? — No, you ______. The light is red.", listOf("A. needn't", "B. shouldn't", "C. can't", "D. mustn't"), "C", "考查情态动词表禁止。红灯时“不能”过马路用 can't。"),
                PastExamQuestion("2022", "湖北黄冈中考", "This dictionary ______ belong to Mary. Her name is on the cover.", listOf("A. can", "B. may", "C. must", "D. might"), "C", "考查肯定的推测。证据充分时用 must 表示“一定”。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("You should listen to the teacher.", "—— 摘自《人教版初一》")),
            exampleSentences = listOf(ExampleSentence("I must go now.", "我必须走了。"), ExampleSentence("It might rain tonight.", "今晚可能会下雨。"))
        ),
        KnowledgePoint(
            id = "10",
            title = "非谓语动词 (Non-finite Verbs)",
            description = "非谓语动词在句中不作谓语。中考大纲重点：1. 动词不定式（to do）作宾语、宾补、定语和目的状语；2. 动名词（-ing）作宾语；3. 分词（现在分词/过去分词）作定语或状语的初步认知。",
            relatedPoints = listOf("want/decide to do", "enjoy/finish doing", "stop to do vs doing", "感官动词 + do/doing"),
            exampleProblems = listOf(
                ExampleProblem("Remember ______ the light when you leave.", listOf("A. turn off", "B. to turn off", "C. turning off", "D. turned off"), "B", "remember to do 记得去做某事；doing 记得做过某事。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "江苏南京中考", "My mother often encourages me ______ more books.", listOf("A. read", "B. reading", "C. to read", "D. to reading"), "C", "考查 encourage sb to do sth 结构。"),
                PastExamQuestion("2022", "四川内江中考", "I forgot ______ the window, and the rain came in.", listOf("A. to close", "B. closing", "C. closed", "D. close"), "A", "考查 forget to do 忘记去做某事。根据雨进来了可知窗户没关。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I want to be an engineer.", "—— 摘自《外研版》")),
            exampleSentences = listOf(ExampleSentence("Thank you for helping me.", "谢谢你帮我。"), ExampleSentence("It's time to have lunch.", "该吃午饭了。"))
        ),
        KnowledgePoint(
            id = "11",
            title = "主谓一致 (S-V Agreement)",
            description = "谓语动词的人称和数必须与主语一致。中考大纲要求掌握三种原则：1. 语法一致原则（单数主语用单数谓语）；2. 意义一致原则（集体名词等）；3. 就近原则（neither...nor, either...or, not only...but also, there be）。",
            relatedPoints = listOf("就近原则应用", "neither/each/none 用法", "both vs either", "时间/距离作主语看作单数"),
            exampleProblems = listOf(
                ExampleProblem("Neither I nor he ______ Chinese.", listOf("A. am", "B. is", "C. are", "D. be"), "B", "就近原则，谓语动词与 he 保持一致。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "山东临沂中考", "Not only the students but also the teacher ______ excited about the news.", listOf("A. are", "B. is", "C. was", "D. were"), "B", "考查 not only...but also 的就近原则。靠近谓语的是 teacher。"),
                PastExamQuestion("2022", "吉林中考", "Either you or Lily ______ going to clean the classroom.", listOf("A. am", "B. is", "C. are", "D. be"), "B", "考查 either...or 的就近原则。靠近谓语的是 Lily。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Twenty years is a long time.", "—— 摘自《科普版》")),
            exampleSentences = listOf(ExampleSentence("There is a pen and two books.", "那儿有一支笔和两本书。"), ExampleSentence("Reading is very important.", "阅读非常重要。"))
        ),
        KnowledgePoint(
            id = "12",
            title = "简单句与并列句 (Simple & Compound)",
            description = "简单句只包含一个主谓结构；并列句由等立连词连接。中考大纲要求：1. 五种基本句型；2. there be 句型；3. 祈使句（肯定/否定）；4. 并列句的等立连词用法。",
            relatedPoints = listOf("S+V+O 句型", "There be 句型", "祈使句 + and/or", "反义疑问句基础"),
            exampleProblems = listOf(
                ExampleProblem("Stop talking, ______ you'll be punished.", listOf("A. and", "B. but", "C. or", "D. so"), "C", "“祈使句, or + 句子”表示“否则...”。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "福建中考", "Work hard, ______ you will achieve your dream.", listOf("A. but", "B. or", "C. and", "D. so"), "C", "考查“祈使句 + and + 句子”结构，表示“...就会...”。"),
                PastExamQuestion("2022", "辽宁大连中考", "Don't be afraid to fail, ______ you will never learn anything.", listOf("A. and", "B. but", "C. so", "D. or"), "D", "考查“祈使句 + or + 句子”结构，表示“否则”。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("Open your books and read after me.", "—— 摘自《人教版初一》")),
            exampleSentences = listOf(ExampleSentence("I like apples but he likes pears.", "我喜欢苹果但他喜欢梨。"), ExampleSentence("What a beautiful girl!", "多漂亮的女孩啊！"))
        ),
        KnowledgePoint(
            id = "13",
            title = "宾语从句 (Object Clause)",
            description = "宾语从句在主句中充当宾语。中考大纲三要素：1. 引导词（that, if/whether, 疑问词）；2. 语序（必须是陈述语序）；3. 时态（主现从任意，主过从必过，客观真理用一般现在时）。",
            relatedPoints = listOf("if vs whether 区别", "语序陷阱", "疑问词引导从句", "that 的省略情况"),
            exampleProblems = listOf(
                ExampleProblem("I don't know ______ next week.", listOf("A. when will he come", "B. when he will come", "C. where will he go", "D. where he go"), "B", "宾语从句需用陈述语序。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "甘肃武威中考", "Could you tell me ______?", listOf("A. where is the post office", "B. where the post office is", "C. how can I get to the post office", "D. how I got to the post office"), "B", "考查宾语从句语序。从句需用陈述句语序（主语在前）。"),
                PastExamQuestion("2022", "贵州贵阳中考", "I wonder ______ you would like to go with me.", listOf("A. that", "B. if", "C. what", "D. who"), "B", "考查宾语从句引导词。表示“是否”用 if 或 whether。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I wonder if it will rain.", "—— 摘自《外研版》")),
            exampleSentences = listOf(ExampleSentence("She asked me where I lived.", "她问我住哪儿。"), ExampleSentence("I think that he is right.", "我觉得他是对的。"))
        ),
        KnowledgePoint(
            id = "14",
            title = "定语从句 (Attributive Clause)",
            description = "定语从句修饰名词或代词。中考大纲要求：1. 关系代词（that, which, who, whom, whose）的基本用法；2. 关系副词（when, where, why）的基本用法；3. 限制性定语从句的认知。",
            relatedPoints = listOf("that vs which 特例", "who vs whom", "whose 表示所属", "先行词辨析"),
            exampleProblems = listOf(
                ExampleProblem("The book ______ I bought is very good.", listOf("A. who", "B. whom", "C. which", "D. whose"), "C", "先行词为物，且在从句中作宾语。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "青海中考", "He is the teacher ______ taught us English last year.", listOf("A. which", "B. who", "C. whose", "D. what"), "B", "考查定语从句。先行词是人，且在从句中作主语，用 who。"),
                PastExamQuestion("2022", "黑龙江中考", "The boy ______ you saw just now is my cousin.", listOf("A. who", "B. which", "C. whose", "D. what"), "A", "考查定语从句。先行词是人，在从句中作宾语，用 who/whom/that。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("The girl who is singing is Lily.", "—— 摘自《人教版初二》")),
            exampleSentences = listOf(ExampleSentence("This is the factory where he works.", "这是他工作的工厂。"), ExampleSentence("I like people who are kind.", "我喜欢善良的人。"))
        ),
        KnowledgePoint(
            id = "15",
            title = "状语从句 (Adverbial Clause)",
            description = "状语从句修饰主句的动词、形容词等。中考大纲重点掌握：1. 时间状语从句（when, while, as soon as 等）；2. 条件状语从句（if, unless）；3. 原因状语从句（because, since, as）；4. 让步状语从句（although, though）；5. 结果状语从句（so...that, such...that）；6. 目的状语从句（so that）。",
            relatedPoints = listOf("主将从现原则", "because vs since", "so...that 结构", "although 引导让步"),
            exampleProblems = listOf(
                ExampleProblem("I'll call you as soon as I ______ home.", listOf("A. get", "B. will get", "C. gets", "D. got"), "A", "as soon as 引导时间状语从句，主将从现。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "广西中考", "If it ______ sunny tomorrow, we will have a picnic.", listOf("A. is", "B. are", "C. will be", "D. was"), "A", "考查“主将从现”原则。if 引导条件状语从句，主句用将来时，从句用一般现在时。"),
                PastExamQuestion("2022", "西藏中考", "We didn't go out ______ it rained heavily.", listOf("A. because", "B. so", "C. although", "D. if"), "A", "考查原因状语从句。表示原因用 because。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("If it rains, we won't go out.", "—— 摘自《人教版初二》")),
            exampleSentences = listOf(ExampleSentence("He was so tired that he fell asleep.", "他太累了以至于睡着了。"), ExampleSentence("I study hard so that I can succeed.", "我努力学习为了成功。"))
        ),
        KnowledgePoint(
            id = "16",
            title = "疑问句与感叹句 (Questions & Exclamations)",
            description = "中考大纲要求：1. 一般疑问句及其回答；2. 特殊疑问句及疑问词的选择；3. 选择疑问句；4. 反义疑问句（前肯后否原则）；5. what 和 how 引导的感叹句。",
            relatedPoints = listOf("反义疑问句特殊情况", "What vs How 感叹句", "疑问词辨析", "感叹句结构转换"),
            exampleProblems = listOf(
                ExampleProblem("______ cold weather it is!", listOf("A. What", "B. What a", "C. How", "D. How a"), "A", "weather 不可数，what + adj + [U].")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "内蒙古中考", "______ wonderful music they are playing!", listOf("A. What", "B. What a", "C. How", "D. How a"), "A", "考查感叹句。music 是不可数名词，结构为 What + adj + [U]。"),
                PastExamQuestion("2022", "新疆中考", "You have never been to Beijing, ______ you?", listOf("A. have", "B. haven't", "C. do", "D. don't"), "A", "考查反义疑问句。陈述部分含有 never 表示否定，疑问部分用肯定形式。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("What a great day it is!", "—— 摘自《外研版》")),
            exampleSentences = listOf(ExampleSentence("You are a student, aren't you?", "你是学生，对吧？"), ExampleSentence("How fast he runs!", "他跑得真快！"))
        ),
        KnowledgePoint(
            id = "17",
            title = "直接引语与间接引语 (Direct & Indirect Speech)",
            description = "中考大纲要求：1. 陈述句变间接引语（人称、时态、状语的变化）；2. 一般疑问句/特殊疑问句变间接引语（语序和引导词的变化）；3. 时态退后原则及特殊情况（客观真理）。",
            relatedPoints = listOf("said to -> told", "this -> that / now -> then", "时态退后法则", "客观真理时态不变"),
            exampleProblems = listOf(
                ExampleProblem("He said, 'I am a teacher.' -> He said that ______ a teacher.", listOf("A. I am", "B. he is", "C. I was", "D. he was"), "D", "时态需由一般现在时变为一般过去时。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "海南中考", "The teacher said that the sun ______ in the east.", listOf("A. rises", "B. rose", "C. is rising", "D. was rising"), "A", "考查间接引语时态。从句是客观真理时，时态保持一般现在时。"),
                PastExamQuestion("2021", "黑龙江齐齐哈尔中考", "He asked me ______ I would go to the zoo.", listOf("A. if", "B. that", "C. what", "D. who"), "A", "考查间接引语。一般疑问句变间接引语，用 if 或 whether 引导。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("He asked me where I was going.", "—— 摘自《科普版》")),
            exampleSentences = listOf(ExampleSentence("She told me she liked music.", "她告诉我她喜欢音乐。"), ExampleSentence("He said that the earth goes round the sun.", "他说地球绕着太阳转。"))
        ),
        KnowledgePoint(
            id = "18",
            title = "句子成分与基本句型 (Sentence Structure)",
            description = "中考大纲要求：1. 掌握句子六大成分（主、谓、宾、表、定、状）；2. 掌握五种基本句型（S+V, S+V+O, S+V+P, S+V+IO+DO, S+V+O+OC）；3. 理解宾语补足语与表语的区别。",
            relatedPoints = listOf("主谓宾结构", "系表结构", "宾语补足语", "定语与状语的位置"),
            exampleProblems = listOf(
                ExampleProblem("The news made us ______. ", listOf("A. happily", "B. happy", "C. happiness", "D. to happy"), "B", "made us happy 属于 S+V+O+OC 结构，happy 是宾补。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "辽宁沈阳中考", "Our teacher always tells us ______ hard for our future.", listOf("A. work", "B. working", "C. to work", "D. worked"), "C", "考查 S+V+O+OC 结构。tell sb to do sth。"),
                PastExamQuestion("2022", "黑龙江哈尔滨中考", "He found the book very ______.", listOf("A. interest", "B. interesting", "C. interested", "D. interests"), "B", "考查宾语补足语。find sth + adj.")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I found the city very beautiful.", "—— 摘自《人教版初二上》")),
            exampleSentences = listOf(ExampleSentence("He plays football every day.", "他每天踢足球。"), ExampleSentence("My mother looks young.", "我妈妈看起来很年轻。"))
        ),
        KnowledgePoint(
            id = "19",
            title = "It 句型与 There be 句型 (Special Patterns)",
            description = "中考大纲重点：1. It 作形式主语/形式宾语的句型（It's adj. for/of sb to do...）；2. It 指代时间、天气、距离、距离、身份等；3. There be 句型的就近原则及各时态变化；4. There be 与 have/has 的区别。",
            relatedPoints = listOf("It's time to do", "There's no need to", "It seems that", "就近原则"),
            exampleProblems = listOf(
                ExampleProblem("It's kind ______ you to help me.", listOf("A. for", "B. of", "C. with", "D. to"), "B", "kind 是描写人物性格的形容词，用 of sb to do。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "江苏扬州中考", "There ______ a football match in our school tomorrow.", listOf("A. is", "B. will have", "C. will be", "D. has"), "C", "考查 There be 句型的一般将来时：There will be 或 There is going to be。"),
                PastExamQuestion("2022", "广东广州中考", "It is very important ______ us ______ protect the environment.", listOf("A. for; to", "B. of; to", "C. for; for", "D. of; of"), "A", "考查 It is adj for sb to do 结构。")
            ),
            textbookParagraphs = listOf(TextbookParagraph("It's a long way to the library.", "—— 摘自《人教版初一上》")),
            exampleSentences = listOf(ExampleSentence("There are some birds in the tree.", "树上有一些鸟。"), ExampleSentence("It takes me an hour to do my homework.", "做作业花了我一个小时。"))
        ),
        KnowledgePoint(
            id = "20",
            title = "核心词汇辨析 (Vocabulary Distinctions)",
            description = "中考高频易混词辨析：1. spend/take/pay/cost (花费)；2. also/too/either/as well (也)；3. dress/wear/put on/in (穿戴)；4. look/see/watch/read (看)；5. say/speak/tell/talk (说)；6. borrow/lend/keep (借)。",
            relatedPoints = listOf("花费四巨头", "借走 vs 借入", "看字诀", "说字诀"),
            exampleProblems = listOf(
                ExampleProblem("He ______ 20 yuan on the book.", listOf("A. paid", "B. cost", "C. spent", "D. took"), "C", "spend money on sth 为固定搭配。")
            ),
            pastExamQuestions = listOf(
                PastExamQuestion("2023", "湖北随州中考", "I ______ the book for two weeks.", listOf("A. borrowed", "B. lent", "C. kept", "D. have borrowed"), "C", "考查延续性动词。for two weeks 要求用 keep。"),
                PastExamQuestion("2022", "四川达州中考", "The new dress ______ her 200 yuan.", listOf("A. spent", "B. paid", "C. cost", "D. took"), "C", "考查花费。sth cost sb money.")
            ),
            textbookParagraphs = listOf(TextbookParagraph("I spent my vacation in the mountains.", "—— 摘自《人教版初二上》")),
            exampleSentences = listOf(ExampleSentence("Can you lend me your pen?", "你能把笔借我吗？"), ExampleSentence("He wears a pair of glasses.", "他戴着一副眼镜。"))
        )
    )

    fun getPoint(id: String): KnowledgePoint? {
        val cleanId = if (id.startsWith("search_")) id.substringAfter("search_") else id
        return allPoints.find { it.id == cleanId } ?: allPoints[0]
    }
}
