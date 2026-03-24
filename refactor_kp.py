import re

file_path = r'E:\Code\IDE\AndroidStudio\Insight\app\src\main\java\com\example\insight\data\model\KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# New Articles Content
new_articles = r'''        KnowledgePoint(
            id = "articles",
            section = SEC_1,
            title = "冠词 (Articles)",
            description = """
                ### 📖 核心概念详解

                冠词 (Articles) 被称为英语中的“虚词之王”，其规则之细腻、使用频率之高，是衡量语感是否纯正的试金石。

                #### 1. 不定冠词 (a / an) 的首音素准则
                > ⚠️ **黄金法则**：选择 *a* 还是 *an*，物理依据是单词的 **首个音素 (Phoneme)**，而非首个字母。

                | 示例 | 音素分析 | 正确选择 | 常见误区 |
                | :--- | :--- | :--- | :--- |
                | *hour* | /'aʊə/ (元音) | **an** hour | 误选 a (因 h 是辅音字母) |
                | *honest* | /'ɒnɪst/ (元音) | **an** honest boy | 忽略 h 不发音 |
                | *university* | /ˌjuːnɪ'vɜːsəti/ (辅音) | **a** university | 误选 an (因 u 是元音字母) |
                | *useful* | /'juːsfl/ (辅音) | **a** useful tool | 仅看拼写不看发音 |
                | *unusual* | /ʌn'juːʒuəl/ (元音) | **an** unusual story | 元音发音选 an |
                | *MP3* | /ˌem piː 'θriː/ (元音) | **an** MP3 player | 字母 M 以元音 /e/ 开头 |

                #### 2. 定冠词 (the) 的“特指”逻辑
                1.  **回头见原则**：上文提到过的人或物 (*I saw a bird. The bird was...*)。
                2.  **独一无二**：世界上独一无二的事物 (*the sun, the moon, the earth*)。
                3.  **序数词与最高级**：*the first, the best, the most interesting*。
                4.  **西洋乐器**：*play the piano, play the guitar* (对比：*play football* 无 the)。
                5.  **方位与方向**：*in the east, on the left*。
                6.  **姓氏复数**：表示“一家人” (*the Greens*)。
                7.  **the + 形容词**：表示一类人 (*the rich, the blind*)。

                #### 3. 零冠词 (Zero Article) 的“法定”场景
                *   **球类、棋类**：*play basketball, play chess*。
                *   **三餐、季节、月份**：*have breakfast, in summer, in March* (若有修饰词例外，如 *in the cold winter of 2023*)。
                *   **学科、语言**：*speak English, study physics*。
                *   **节日**：*at Christmas, on Children's Day* (注意：*the Spring Festival* 通常带 the)。
                *   **代词/名词所有格后**：*my book* (不说 *a my book*)。

                #### 4. 固定短语中的“有无”玄机
                | 短语 (有 the) | 含义 | 短语 (无 the) | 含义 |
                | :--- | :--- | :--- | :--- |
                | *in the hospital* | 在医院里 (如探视) | *in hospital* | 住院 (因病) |
                | *at the table* | 在桌子旁 | *at table* | 在进餐 |
                | *go to the school* | 去那所学校 (如开会) | *go to school* | 去上学 (学生身份) |
                | *in the prison* | 在监狱里 (如参观) | *in prison* | 坐牢 (罪犯身份) |
                | *by the sea* | 在海边 | *by sea* | 乘船 (交通方式) |
            """.trimIndent(),
            syllabusDetails = listOf(
                "**【音法判定】** 深刻掌握首音素判别法，重点记忆 *h, u, e, m, s, x* 等字母开头的特殊词汇发音。",
                "**【特指锁定】** 掌握 *the* 在语篇衔接、特定范围修饰（如 *of* 短语修饰）以及独一无二事物前的应用法则。",
                "**【零冠词清单】** 熟练识别球类、三餐、学科等零冠词场景，理解有无冠词产生的语义质变。",
                "**【习惯搭配】** 掌握 30 组以上带有/不带冠词的固定短语，尤其是在阅读理解中分辨身份职能（如 *in hospital*）。",
                "**【数量转换】** 掌握 *a second/a third* 表示“又一个、再一个”而非顺序的递进逻辑语义。"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词 (Nouns)", "冠词的语法宿主", "名词的可数性、单复数属性是冠词存在的物理前提。"),
                RelatedPoint("形容词最高级 (Superlatives)", "the 的固定伴侣", "最高级前通常强制使用 *the*，除非有物主代词。"),
                RelatedPoint("数词 (Numerals)", "序数词的伴侣", "序数词前通常加 *the* 表示顺序，加 *a/an* 表示增加。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "Zhang Hua is ______ honest boy. He always tells ______ truth.", listOf("A. a; the", "B. an; the", "C. an; a", "D. a; a"), "B", "**【解析】** *honest* 首音素为元音 /ɒ/，用 *an*；*tell the truth*（说实话）为固定搭配。故选 **B**。", "**【陷阱】** 容易根据首字母 h 误选 a。", "张华是个诚实的孩子。他总是说真话。"),
                PastExamQuestion("2024", "上海", "Look! ______ boy in a blue jacket is playing ______ guitar.", listOf("A. The; the", "B. A; the", "C. The; /", "D. A; /"), "A", "**【解析】** *in a blue jacket* 介词短语作定语，表示特指，用 *the*；西洋乐器前加 *the*。故选 **A**。", "**【提醒】** 介词短语的特指功能是中考常考点。", "看！那个穿蓝色夹克的男孩正在弹吉他。"),
                PastExamQuestion("2023", "广东", "I usually have ______ breakfast at 7:00. It's ______ important meal.", listOf("A. /; an", "B. a; an", "C. the; a", "D. /; a"), "A", "**【解析】** 三餐前通常不用冠词（零冠词）；*important* 元音开头用 *an*。故选 **A**。", "**【注意】** 零冠词与不定冠词的混合考查。", "我通常 7 点吃早餐。这是一天中重要的一餐。"),
                PastExamQuestion("2022", "江苏南京", "Beijing, ______ capital of China, will hold ______ 24th Winter Olympic Games.", listOf("A. a; the", "B. the; the", "C. /; the", "D. the; a"), "B", "**【解析】** “中国的首都”表唯一身份用 *the*；序数词前加 *the*。故选 **B**。", "**【考点】** 唯一性身份与序数词的前置冠词。", "北京，中国的首都，将举办第 24 届冬奥会。"),
                PastExamQuestion("2021", "湖北武汉", "— What ______ useful information it is!\n— Yes. It helps me a lot.", listOf("A. a", "B. an", "C. /", "D. the"), "C", "**【解析】** *information* 是不可数名词，感叹句 *What + adj + 名词* 结构中，不可数名词前不用 a/an。故选 **C**。", "**【错误率】** 极高。学生常因 *useful* 而选 a。", "—— 多么有用的信息啊！ —— 是的。它对我帮助很大。"),
                PastExamQuestion("2020", "安徽", "— Do you like playing ______ football?\n— No, I prefer playing ______ violin.", listOf("A. a; the", "B. /; the", "C. the; /", "D. /; /"), "B", "**【解析】** 球类运动前零冠词，乐器前加 *the*。故选 **B**。", "**【口诀】** 球类零，乐器定。", "—— 你喜欢踢足球吗？ —— 不，我更喜欢拉小提琴。"),
                PastExamQuestion("2019", "福建", "Fuzhou is ______ beautiful city. It's ______ capital of Fujian Province.", listOf("A. a; the", "B. an; the", "C. a; a", "D. the; a"), "A", "**【解析】** 第一空表泛指“一个美丽的城市”用 *a*；第二空表特指“福建省的省会”用 *the*。故选 **A**。", "**【逻辑】** 先泛指后特指。", "福州是一个美丽的城市。它是福建省的省会。"),
                PastExamQuestion("2018", "河南", "After ______ hour's exercise, I felt ______ bit tired.", listOf("A. a; a", "B. an; a", "C. an; /", "D. a; /"), "B", "**【解析】** *hour* 元音开头用 *an*；*a bit*（一点儿）是固定短语。故选 **B**。", "**【音素】** /'aʊə/ 是元音音素。", "锻炼了一个小时后，我感到有一点点累。"),
                PastExamQuestion("2017", "重庆", "Mr. Smith is ______ English teacher. He is from ______ UK.", listOf("A. a; the", "B. an; the", "C. an; /", "D. a; /"), "B", "**【解析】** *English* 元音开头用 *an*；由普通名词构成的国家简称前加 *the*。故选 **B**。", "**【国家】** UK, USA, PRC 都要加 the。", "史密斯先生是一名英语老师。他来自英国。"),
                PastExamQuestion("2016", "陕西", "Music is ______ international language. We can express our feelings through it.", listOf("A. a", "B. an", "C. the", "D. /"), "B", "**【解析】** 表泛指“一种国际语言”，*international* 元音开头用 *an*。故选 **B**。", "**【基础】** 泛指概念与元音判定。", "音乐是一种国际语言。我们可以通过它表达情感。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("It takes me an hour to finish my homework every day. After that, I usually play the violin for thirty minutes. Music makes me feel relaxed. It is an important part of my life.", listOf(
                    HighlightedSentence("an hour", "**【发音红线】** *hour* 的 h 不发音，首音素为元音 /aʊ/，必须用 *an*。"),
                    HighlightedSentence("play the violin", "**【乐器逻辑】** 西洋乐器前须加 *the*，体现了英语对艺术形式的特指传统。"),
                    HighlightedSentence("an important part", "**【泛指逻辑】** 表达“其中一个重要部分”，元音音素 /ɪ/ 开头用 *an*。")
                ), "人教版 (Go for it!) 七下 Unit 6"),
                TextbookParagraph("Yesterday, the Greens went on a trip to the beach. They saw the sun rise from the east in the morning. They had a great time playing football on the sand. It was an unforgettable day.", listOf(
                    HighlightedSentence("the Greens", "**【家族用法】** *the + 姓氏复数* 表示一家人。"),
                    HighlightedSentence("from the east", "**【方位特指】** 方位词前固定使用定冠词 *the*。"),
                    HighlightedSentence("playing football", "**【运动禁忌】** 球类运动前严禁加 *the*。")
                ), "外研版 (New Standard) 八下 Module 5"),
                TextbookParagraph("In hospital, doctors and nurses work day and night to save lives. My aunt is a nurse. She works in the hospital near our school. She loves her job very much.", listOf(
                    HighlightedSentence("In hospital", "**【职能语义】** 指“在住院”或“在从事医疗工作”，强调职能而非建筑。"),
                    HighlightedSentence("in the hospital", "**【建筑语义】** 指“在那栋医院大楼里”，强调具体的地理位置。")
                ), "沪教版 (Oxford) 九上 Unit 2"),
                TextbookParagraph("Li Hua is a university student now. He is an honest person and always helps the old in his community. Everyone thinks he is a useful man.", listOf(
                    HighlightedSentence("a university student", "**【发音陷阱】** *university* 首字母虽是 u，但音素是辅音 /j/，故用 *a*。"),
                    HighlightedSentence("helps the old", "**【群体表达】** *the + 形容词* 表示一类人，此处指“老人”。"),
                    HighlightedSentence("a useful man", "**【发音陷阱】** *useful* 音素为辅音 /j/，用 *a*。")
                ), "人教版 (Go for it!) 九年级 Unit 1")
            ),
            exampleSentences = listOf(
                ExampleSentence("He is an 11-year-old boy who has already become a university student.", "他是一个 11 岁的男孩，却已经成了一名大学生。", "**【深度解析】** *11 (eleven)* 元音开头用 *an*；*university* 辅音开头用 *a*。", "中考核心 (Complex)"),
                ExampleSentence("The rich should help the poor, because we all live on the same planet.", "富人应当帮助穷人，因为我们都生活在同一个星球上。", "**【深度解析】** “the + 形容词” 结构表示一类人。*the same* 是固定搭配。", "高阶句法 (Compound)"),
                ExampleSentence("We usually have lunch at school, but last Sunday we had a big lunch in a restaurant.", "我们通常在学校吃午饭，但上周日我们在一家餐馆吃了一顿丰盛的午餐。", "**【深度解析】** 三餐前通常零冠词，但有形容词修饰且表泛指时可用 *a*。", "高频考点 (Complex)"),
                ExampleSentence("The moon goes around the earth. It's a natural satellite.", "月亮绕着地球转。它是一颗卫星。", "**【深度解析】** 独一无二的事物用 *the*；泛指身份用 *a*。", "基础必会 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **母语缺失**：汉语完全没有冠词概念，学生容易漏掉冠词或根据拼写而非发音选择 a/an。\n2. **教条主义**：死记硬背“元音字母”，在 *useful, honest* 等词上反复栽跟头。\n3. **功能混淆**：分不清 *in hospital* 与 *in the hospital* 的语义差异。"),
                TeachingNote("【教学金钥】备忘清单", "1. **音标前置法**：在教冠词前先复习 48 个音标，特别是元音。强调“看音标，不看字母”。\n2. **情景差异法**：通过图片展示“在桌子旁 (*at the table*)”与“在吃饭 (*at table*)”的区别。\n3. **口诀辅助法**：‘球类棋类零冠词，西洋乐器 the 领头；序数词最高级 the 必有，姓氏复数 the 一家。’"),
                TeachingNote("【冲刺技巧】中考必杀技", "1. **第一眼看首音**：如果是 *U* 开头，发 /ju:/ 选 *a*，发 /ʌ/ 选 *an*。如果是 *H* 开头，不发音选 *an*。\n2. **第二眼看修饰**：有 *of* 或介词短语修饰名词，大概率选 *the*。\n3. **第三眼看固定搭配**：*at the same time, in the end, tell the truth* 等务必背熟。")
            ),
            famousQuote = "Details create the big picture.",
            quoteAuthor = "Sanford I. Weill",
            quoteTranslation = "细节成就大局。",
            quoteAnalysis = "冠词 (a/an/the) 在英语中虽细微如沙，却是构建精准语义大局的基石，少了一个冠词，句子的逻辑可能完全崩塌。"
        )'''

# New Numerals Content
new_numerals = r'''        KnowledgePoint(
            id = "numerals",
            section = SEC_1,
            title = "数词 (Numerals)",
            description = """
                ### 📖 核心概念详解

                数词 (Numerals) 是描述客观世界“数量”与“顺序”的精密工具，在中考中主要考查其物理形态变换与特定应用逻辑。

                #### 1. 基数词 (Cardinals) 与序数词 (Ordinals)
                | 基数词 | 序数词 | 缩写 | 记忆要点 |
                | :--- | :--- | :--- | :--- |
                | *one* | **first** | 1st | 特殊记忆 |
                | *two* | **second** | 2nd | 特殊记忆 |
                | *three* | **third** | 3rd | 特殊记忆 |
                | *five* | **fifth** | 5th | **ve** 变 **f** 加 **th** |
                | *eight* | **eighth** | 8th | 词尾只加 **h** (避免两个 t) |
                | *nine* | **ninth** | 9th | 去 **e** 加 **th** |
                | *twelve* | **twelfth** | 12th | **ve** 变 **f** 加 **th** |
                | *twenty* | **twentieth** | 20th | **y** 变 **ie** 加 **th** |
                | *forty* | **fortieth** | 40th | 易错拼写：无 **u** (*four* 有 u) |

                #### 2. 大数的“s定律” (核心难点)
                > 💡 **“精准”与“模糊”的权力交接**：
                > *   **精准数 (具体数字)**：数字 + *hundred/thousand/million/billion* (**不加 s, 不接 of**)
                >     *   示例：*three hundred students* (三百个学生)
                > *   **模糊数 (约数)**：*hundreds/thousands/millions/billions* + **of** (**必须加 s, 必须接 of**)
                >     *   示例：*thousands of people* (成千上万的人)
                > ⚠️ **禁忌**：千万不要写成 *five hundreds of*。

                #### 3. 分数与百分数的逻辑
                *   **分数规则**：
                    1. 分子用 **基数词**，分母用 **序数词**。
                    2. 分子 > 1 时，分母序数词需加 **-s**。
                    *   *1/3*: **one-third**
                    *   *2/5*: **two-fifths**
                *   **百分数**：数字 + *percent* (始终不加 s)。
                    *   其谓语动词的数由修饰的名词决定：*30% of the water **is**...* / *30% of the apples **are**...*

                #### 4. 时间、日期与年龄
                1.  **时刻表达**：
                    *   *8:10* -> *ten past eight* (30分以内用 **past**)
                    *   *8:50* -> *ten to nine* (超过30分用 **to**)
                    *   *8:15* -> *a quarter past eight* / *8:30* -> *half past eight*
                2.  **年龄表达**：
                    *   *in one's twenties* (在某人二十多岁时)
                3.  **日期表达**：
                    *   *June 1st, 2025* (读作：*June the first*)
            """.trimIndent(),
            syllabusDetails = listOf(
                "**【形态拼写】** 熟练掌握 1-100 基数词及其对应序数词的物理变换规律，重点攻克 *eighth, ninth, twelfth, forty, ninety* 等拼写陷阱。",
                "**【大数逻辑】** 深刻理解 *hundred, thousand, million, billion* 在精准与模糊语境下的‘s定律’与‘of关联’。",
                "**【单位量化】** 精准运用分数（分子基、分母序、分子大于一分母加 s）、小数及百分数的标准表达。",
                "**【时空坐标】** 掌握日期、时刻（past/to 逆读法）、年龄（*in one's twenties*）及编号（*Lesson One* vs *the first lesson*）的转换。",
                "**【倍数逻辑】** 掌握 *once, twice, three times* 及其在比较结构中的应用。",
                "**【特殊含义】** 理解 *a second/a third* 表示“又一、再一”的递进逻辑语义。"
            ),
            relatedPoints = listOf(
                RelatedPoint("名词 (Nouns)", "数词的物理容器", "基数词直接决定名词复数；分数/百分数作主语时，谓语动词由修饰的名词决定。"),
                RelatedPoint("冠词 (Articles)", "序数词的‘护卫’", "序数词前通常须加 *the* 表示排序；但加 *a/an* 时则转化为“数量递进”语义。"),
                RelatedPoint("主谓一致 (S-V Agreement)", "分数与百分数的控制权", "这是中考的高阶考点，动词的单复数取决于 *of* 之后名词的逻辑属性。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "About ______ of the students in our school like playing basketball.", listOf("A. two third", "B. two thirds", "C. second three", "D. second thirds"), "B", "**【解析】** 考查分数。分子 2 用基数词 *two*，分母 3 用序数词复数 *thirds*。故选 **B**。", "**【注意】** 分子大于 1，分母必加 s。", "我们学校大约三分之二的学生喜欢打篮球。"),
                PastExamQuestion("2025", "天津", "There are ______ people in the park on weekends.", listOf("A. five hundred of", "B. five hundreds", "C. hundreds of", "D. five hundreds of"), "C", "**【解析】** 模糊大数用 *hundreds of*；精准数字后不加 s/of。故选 **C**。", "**【陷阱】** 不要混淆精准与模糊结构，两者不能杂交。", "周末公园里有数百人。"),
                PastExamQuestion("2024", "上海", "— How many books are there?\n— There are ______ books.", listOf("A. two thousand", "B. two thousands", "C. thousand of", "D. two thousands of"), "A", "**【解析】** 精准数字后单位词保持单数（不加 s）。故选 **A**。", "**【基础】** 基数词大数原则，千/百/百万在具体数字后不加 s。", "—— 有多少本书？ —— 有两千本书。"),
                PastExamQuestion("2024", "广东", "Today is my mother's ______ birthday.", listOf("A. forty", "B. fortieth", "C. the fortieth", "D. fourteenth"), "B", "**【解析】** 生日、序号用序数词；*forty* 变为序数词是 *fortieth*。已有 *my* 限制，不再加 *the*。故选 **B**。", "**【拼写】** *fortieth* 拼写无 u，容易受 *four* 干扰。", "今天是我妈妈四十岁生日。"),
                PastExamQuestion("2023", "江苏南京", "Beijing held ______ 24th Winter Olympic Games in 2022.", listOf("A. a", "B. an", "C. the", "D. /"), "C", "**【解析】** 序数词前加 *the* 表示特定届数。故选 **C**。", "**【常考】** 序数词与冠词的固定搭配。", "北京在 2022 年举办了第 24 届冬奥会。"),
                PastExamQuestion("2023", "湖北武汉", "It's ______ walk from my home to the school.", listOf("A. ten minute", "B. ten minute's", "C. ten minutes'", "D. ten minutes"), "C", "**【解析】** 复数名词所有格表时间。*ten minutes* 的所有格只需加 *'*。故选 **C**。", "**【关联】** 名词所有格与数词的综合考查。", "从家到学校步行十分钟。"),
                PastExamQuestion("2022", "四川成都", "About ______ of the surface of the earth is covered by water.", listOf("A. three-fourth", "B. three-fourths", "C. third-four", "D. third-fourths"), "B", "**【解析】** 分子 3 (*three*)，分母 4 序数复数 (*fourths*)。故选 **B**。", "**【分数】** 分子基，分母序，分子超一加 s。", "地球表面约四分之三被水覆盖。"),
                PastExamQuestion("2022", "浙江杭州", "I have read this book twice, but I want to read it ______ third time.", listOf("A. a", "B. the", "C. an", "D. /"), "A", "**【解析】** *a + 序数词* 意为“再一，又一”。故选 **A**。", "**【高阶】** 数词语义的动态化，不表顺序表增加。", "我已经读了两遍，还想读第三遍。"),
                PastExamQuestion("2021", "山东济南", "The ______ lesson is the most interesting one in this unit.", listOf("A. nine", "B. ninth", "C. nineteenth", "D. nineteen"), "B", "**【解析】** “第九课”表示顺序用序数词。*nine* 变序数词需去 e。故选 **B**。", "**【拼写】** *ninth* 去 e 是中考必杀技。", "第九课是这一单元中最有趣的。"),
                PastExamQuestion("2021", "河南", "Li Ming is in his ______. He is very energetic.", listOf("A. twenty", "B. twenties", "C. twentieth", "D. twenty's"), "B", "**【解析】** “在某人二十多岁时”用 *in one's twenties*。故选 **B**。", "**【年龄】** 整数基数词变复数表示年龄段。", "李明二十多岁。他在充满活力。"),
                PastExamQuestion("2020", "安徽", "There are ______ months in a year. December is the ______ month.", listOf("A. twelve; twelve", "B. twelfth; twelfth", "C. twelve; twelfth", "D. twelfth; twelve"), "C", "**【解析】** 数量用基数 *twelve*，顺序用序数 *twelfth*。故选 **C**。", "**【辨析】** 基数词表数量，序数词表顺序。", "一年有 12 个月，12 月是第 12 个月。"),
                PastExamQuestion("2019", "福建", "The moon is about ______ kilometers away from the earth.", listOf("A. three hundred eighty thousand", "B. three hundred and eighty thousand", "C. three hundreds eighty thousands", "D. three hundreds and eighty thousands"), "B", "**【解析】** 复合大数表达：单位词不加 s，百位十位间通常加 *and*。故选 **B**。", "**【规则】** 三十万八千：*three hundred and eighty thousand*。", "月球距地球约 38 万公里。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("The library has thousands of books on different subjects. Last year, about five hundred new books were added. On the second floor, you can find many interesting magazines. More than two-thirds of the students visit the library at least once a week.", listOf(
                    HighlightedSentence("thousands of books", "**【模糊逻辑】** *thousand* 加 *s* 且接 *of*，用于表达不确定的庞大数量级。"),
                    HighlightedSentence("five hundred new books", "**【精准逻辑】** 具体数词后单位词保持单数，不可受名词复数干扰。"),
                    HighlightedSentence("two-thirds of the students", "**【分数主谓】** 分子 2 大于 1，分母 *third* 加 s. 谓语动词随 *students*。")
                ), "人教版 (Go for it!) 八下 Unit 2"),
                TextbookParagraph("The 19th Asian Games were held in Hangzhou. Athletes competed for hundreds of gold medals. For some, it was their first time to join such a big event in China.", listOf(
                    HighlightedSentence("The 19th Asian Games", "**【活动届数】** 序数词表示届数时，通常由定冠词 *the* 领航。"),
                    HighlightedSentence("their first time", "**【限定冲突】** 物主代词与定冠词不可并存，序数词前已有 *their*，故省去 *the*。")
                ), "外研版 (New Standard) 九下 Module 3"),
                TextbookParagraph("In 2024, the world population reached about eight billion. People are concerned about resources. We need to protect the environment for our future generations.", listOf(
                    HighlightedSentence("eight billion", "**【宏观数据】** *billion* 在具体数字后保持单数，描述全球性数据时的标准语法。")
                ), "外研版 (New Standard) 八下 Module 1"),
                TextbookParagraph("He lives in Room 302 on the third floor. He usually gets up at a quarter past six and leaves home at seven o'clock.", listOf(
                    HighlightedSentence("Room 302", "**【编号法则】** 编号通常用基数词且置于名词后，不带冠词。"),
                    HighlightedSentence("the third floor", "**【序数属性】** 序数词修饰名词表顺序，通常带冠词 *the*。")
                ), "人教版 (Go for it!) 七下 Unit 1"),
                TextbookParagraph("Practice makes perfect. He has failed twice, but he is going to have a third try. He believes success belongs to those who never give up.", listOf(
                    HighlightedSentence("have a third try", "**【语义突变】** 此处的 *a* 表示“又一”，打破了序数词单纯排序的逻辑功能。"),
                    HighlightedSentence("failed twice", "**【频次副词】** *once, twice* 是独立的语义单元，三次及以上需用 *times*。")
                ), "沪教版 (Oxford) 九上 Unit 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("Three-quarters of the population in this city are against the new plan.", "这个城市四分之三的人口反对这项新计划。", "**【分析】** 分数主语。谓语动词随 *population* 的逻辑属性变复数。", "中考核心 (Complex)"),
                ExampleSentence("In the 1990s, many people in their twenties moved to big cities for work.", "在 20 世纪 90 年代，许多二十多岁的人搬到大城市工作。", "**【分析】** 包含年代 (*the 1990s*) 与年龄段 (*in one's twenties*)。", "年代语境 (Complex)"),
                ExampleSentence("The moon is about three hundred and eighty thousand kilometers away from the earth.", "月球距离地球大约 38 万公里。", "**【分析】** 复合大数物理拼写演示：百位十位间须有 *and*，单位不加 s。", "科学描述 (Simple)"),
                ExampleSentence("Please open your books to Page 20 and read the second paragraph carefully.", "请翻到第 20 页，仔细阅读第二段。", "**【分析】** 编号与排序的语法对照。", "基础必会 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **拼写惯性**：受 *four* 影响写 *fourty* (应为 *forty*)，受 *nine* 影响写 *nineth* (应为 *ninth*)。\n2. **大数混淆**：分不清精准与模糊的界限，常出现 *five hundreds of* 这种混合错误。\n3. **分母盲点**：分子大于 1 时分母忘了加 s，或分子分母用错基/序数词。"),
                TeachingNote("【教学金钥】备忘清单", "1. **拼写口诀**：‘八去 t，九去 e，ve 要用 f 替，ty 变成 tie，再加 th 莫忘记。’\n2. **s 定律判定**：‘有 s 就有 of，无 s 就无 of。’\n3. **时钟实战**：利用闹钟模型练习 *past* 与 *to* 的逆读法，重点区分 *a quarter* 与 *half*。"),
                TeachingNote("【冲刺技巧】中考必杀技", "1. **看分子**：分子大于一，分母必加 s。 2. **看单位**：*hundred, thousand* 前有具体数，单位不加 s。 3. **看位置**：名词在前数在后用基数 (*Lesson One*)，数在前名词在后用序数 (*the first lesson*)。")
            ),
            famousQuote = "Not everything that can be counted counts, and not everything that counts can be counted.",
            quoteAuthor = "William Bruce Cameron",
            quoteTranslation = "并非所有能被计算的东西都有价值，也并非所有有价值的东西都能被计算。",
            quoteAnalysis = "利用 *count* 的双关义（计数与价值）生动展示了数词在哲学层面的表现力。"
        )'''

# Regex to find KnowledgePoint blocks by id
pattern_articles = re.compile(r'\s+KnowledgePoint\(\s+id = "articles",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_numerals = re.compile(r'\s+KnowledgePoint\(\s+id = "numerals",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_articles.sub(lambda _: '\n' + new_articles + ',', content)
content = pattern_numerals.sub(lambda _: '\n' + new_numerals + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)
