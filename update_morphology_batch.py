import re
import os

file_path = r'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'

with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# --- 1. 形容词与副词 (Adj & Adv) ---
new_adj_adv = r'''        KnowledgePoint(
            id = "adj_adv",
            section = SEC_1,
            title = "形容词与副词 (Adj & Adv)",
            description = """
### 📖 核心概念详解

形容词 (Adjectives) 与副词 (Adverbs) 是英语句法的“色彩描绘器”。形容词修饰名词/代词；副词修饰动词、形容词、副词或全句。

#### 1. 比较等级 (Degrees of Comparison) 的不规则陷阱
| 原级 | 比较级 | 最高级 | 变换逻辑 |
| :--- | :--- | :--- | :--- |
| *good/well* | **better** | **best** | 经典不规则 |
| *bad/badly* | **worse** | **worst** | 经典不规则 |
| *many/much* | **more** | **most** | 经典不规则 |
| *little* | **less** | **least** | 表“少”时 (中考高频) |
| *far* | **farther/further** | **farthest/furthest** | 物理距离 vs 抽象程度 |

#### 2. 形容词的“排位金律” (OPSHCOM)
> 💡 **多个形容词修饰名词的语序**：
> **观** (观点) + **形** (大小/形状) + **龄** (新旧) + **色** (颜色) + **国** (产地) + **材** (材料)
> *   示例：*a beautiful small old black Chinese stone bridge* (一座美丽的黑色中国古石桥)

#### 3. 副词的“位移”法则
*   **Enough 的强制后置**：形容词/副词 + *enough* (*rich enough, fast enough*)。
*   **频度副词的“行前系后”**：实义动词前，系/助/情态动词后。

#### 4. 核心比较句型
1.  **同级**：*as + 原级 + as* (像...一样) / *not as/so...as*。
2.  **差级**：*比较级 + than* (比...更...)。
3.  **递增**：*the + 比较级, the + 比较级* (越...就越...)。
4.  **排他**：*比较级 + than any other + 名词单数* (比任何其他...都，表最高级意义)。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【形态变换】** 熟练掌握 100% 规则拼写（双写、y 变 i）及 5 组核心不规则比较级/最高级形态。",
                "**【位置控制】** 掌握 *enough* 在句中的位移规则，及多个形容词修饰名词时的 OPSHCOM 标准语序。",
                "**【逻辑辨析】** 深度区分 *hard/hardly, late/lately, wide/widely* 等形近义异的副词功能。",
                "**【句式进阶】** 精准运用 *the + 比较级*、*as...as* 结构及比较级表示最高级语义的逻辑转换。",
                "**【倍数逻辑】** 掌握 *three times as...as* 及 *three times the size of* 等倍数表达公式。",
                "**【修饰限制】** 明确 *very, quite* (修饰原级) 与 *much, even, far, a bit* (修饰比较级) 的阶级划分。"
            ),
            relatedPoints = listOf(
                RelatedPoint("系动词 (Link Verbs)", "形容词的物理出口", "感官系动词 (*look, sound, smell, taste, feel*) 及变化系动词 (*become, get, turn*) 后须强制匹配形容词作表语。"),
                RelatedPoint("比较级修饰语", "程度的精确量化", "比较级前可加 *much, far, a bit* 等词进行程度量化，这是中考改错题的常客。"),
                RelatedPoint("名词 (Nouns)", "形容词的宿主", "形容词作为定语修饰名词时，其位置与数量直接影响语言的地道性。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "The more books you read, the ______ your knowledge will be.", listOf("A. rich", "B. richer", "C. richest", "D. the richest"), "B", "**【解析】** 考查“越...越...”句型。物理结构为 *the + 比较级, the + 比较级*。故选 **B**。", "**【注意】** 第二个分句已有 *the*，只需填比较级形态。", "你读的书越多，你的知识就会越丰富。"),
                PastExamQuestion("2025", "天津", "He is ______ enough to carry that heavy box for his grandma.", listOf("A. strong", "B. stronger", "C. the strongest", "D. strongly"), "A", "**【解析】** *enough* 修饰形容词原级且必须后置。*strong* 是原级。故选 **A**。", "**【陷阱】** 不要根据中文“足够强”误选比较级。", "他力气足够大，能帮奶奶搬那个重盒子。"),
                PastExamQuestion("2024", "上海", "The Yellow River is the ______ longest river in China.", listOf("A. second", "B. two", "C. twice", "D. secondary"), "A", "**【解析】** 序数词置于最高级之前，用于精准锁定排名。故选 **A**。", "**【常考】** 序数词 + 最高级。", "黄河是中国第二长河。"),
                PastExamQuestion("2024", "广东", "I think Chinese is as ______ as English. Both are important.", listOf("A. interesting", "B. more interesting", "C. most interesting", "D. the most interesting"), "A", "**【解析】** *as...as* 结构物理锁定形容词原级。故选 **A**。", "**【基础】** 同级比较物理法则。", "我认为中文和英文一样有趣。两个都很重要。"),
                PastExamQuestion("2023", "江苏南京", "My English teacher is very patient. She speaks ______ in class than before.", listOf("A. more slowly", "B. most slowly", "C. slowly", "D. slowlier"), "A", "**【解析】** *than* 提示比较级；*slowly* 是双音节副词，比较级前加 *more*。故选 **A**。", "**【形态】** 严禁出现 *slowlier* 这种非法拼写。", "我的英语老师很有耐心。她在课上说话比以前更慢了。"),
                PastExamQuestion("2022", "四川成都", "This room is ______ smaller than that one.", listOf("A. very", "B. quite", "C. a bit", "D. too"), "C", "**【解析】** 修饰比较级的合法程度副词有 *much, even, far, a bit*。*very, too, quite* 仅能修饰原级。故选 **C**。", "**【等级】** 程度副词的阶级限制。", "这个房间比那个稍微小一点。"),
                PastExamQuestion("2021", "河南", "He works hard and he ______ finds time to rest.", listOf("A. hard", "B. hardly", "C. late", "D. lately"), "B", "**【解析】** *hard* 是努力，*hardly* 是几乎不。根据句意选 **B**。", "**【辨析】** 形似副词的词义突变。", "他工作努力，几乎找不到休息时间。"),
                PastExamQuestion("2020", "浙江杭州", "Which city is ______, Beijing, Shanghai or Guangzhou?", listOf("A. large", "B. larger", "C. largest", "D. the largest"), "D", "**【解析】** 三者对比物理锁定最高级，且最高级前须由 *the* 守卫。故选 **D**。", "**【范围】** 明确三者对比语境。", "北京、上海和广州，哪座城市最大？"),
                PastExamQuestion("2019", "福建", "The film is so ______ that I feel ______ with it.", listOf("A. boring; bored", "B. bored; boring", "C. boring; boring", "D. bored; bored"), "A", "**【解析】** 物之特征用 *-ing* (*boring*)；人之感受用 *-ed* (*bored*)。故选 **A**。", "**【情感】** 形容词后缀的逻辑指向。", "这部电影太无聊了，我感到很厌烦。"),
                PastExamQuestion("2018", "山东济南", "Li Hua is taller than ______ boy in his class.", listOf("A. any", "B. any other", "C. others", "D. the other"), "B", "**【解析】** 比较级表达最高级语义，需加 *other* 排除自身。故选 **B**。", "**【排他性】** 逻辑严密性的考查。", "李华比他班上任何其他男孩都高。"),
                PastExamQuestion("2017", "陕西", "The air in the countryside is much ______ than that in the city.", listOf("A. clean", "B. cleaner", "C. cleanest", "D. the cleanest"), "B", "**【解析】** *than* 提示比较级，*much* 修饰比较级。故选 **B**。", "**【规则】** *clean* 的比较级是 *cleaner*。", "农村的空气比城市干净得多。"),
                PastExamQuestion("2016", "重庆", "He runs ______ than any other student in our grade.", listOf("A. fast", "B. faster", "C. fastest", "D. the fastest"), "B", "**【解析】** *than* 锁定比较级。故选 **B**。", "**【逻辑】** 比较级表最高级含义。", "他跑得比我们年级任何其他学生都快。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Traveling by train is slower than by plane, but it is much more interesting for most travelers. You can see many beautiful villages and mountains through the window during the journey. For me, it is the most relaxing way to spend my holiday.", listOf(
                    HighlightedSentence("much more interesting", "**【程度强化】** *much* 修饰多音节比较级，这种双重修饰是中考阅读理解的高频定位点。"),
                    HighlightedSentence("the most relaxing way", "**【最高级判定】** 明确了范围是“所有旅行方式”中的最值。")
                ), "人教版 (Go for it!) 八下 Unit 3"),
                TextbookParagraph("In the soccer match yesterday, Lin Tao played really well. He ran faster than any other player in his team and scored two goals. Although he felt extremely tired after the game, he was very happy because they won.", listOf(
                    HighlightedSentence("played really well", "**【副词链】** *really* 修饰副词 *well*，*well* 修饰动词 *played*，构成严密的修饰链条。"),
                    HighlightedSentence("faster than any other player", "**【逻辑排他】** 必须使用 *other* 才能使林涛在队内的比较具有合法性。")
                ), "外研版 (New Standard) 九上 Module 4"),
                TextbookParagraph("The Amazon River is the second longest river in the world. It flows through the largest rainforest on earth. Many animals and plants live there because the environment is suitable for them.", listOf(
                    HighlightedSentence("the second longest", "**【精准排名】** 展示了序数词与最高级结合表达精确地理数据的标准语法。"),
                    HighlightedSentence("the largest rainforest", "**【绝对最值】** 定冠词 *the* 锁定了唯一的地理冠军。")
                ), "外研版 (New Standard) 九下 Module 1"),
                TextbookParagraph("Practice makes perfect. He has failed twice, but he is still hard-working. The harder you work, the luckier you will get in the future. Don't give up your dreams easily.", listOf(
                    HighlightedSentence("The harder..., the luckier...", "**【递进比例】** 这种句式在 2025 中考写作中被视为高分亮点句型。"),
                    HighlightedSentence("hard-working", "**【复合形容词】** 展示了英语通过连字符构建复杂属性的能力。")
                ), "沪教版 (Oxford) 九上 Unit 4")
            ),
            exampleSentences = listOf(
                ExampleSentence("The climate of Kunming is much milder than that of Harbin in winter.", "昆明的气候比哈尔滨冬天的气候要温和得多。", "**【分析】** 包含比较级修饰语 *much* 及代词 *that* 的高级比较句。", "中考核心 (Complex)"),
                ExampleSentence("He is not so brave as his younger brother when facing serious challenges.", "在面对严重挑战时，他不像他弟弟那样勇敢。", "**【分析】** *not so...as* 用于否定句中的同级比较。", "基础必会 (Compound)"),
                ExampleSentence("The modern city where I live is becoming more and more beautiful every year.", "我居住的这座现代化城市每年正变得越来越漂亮。", "**【分析】** *more and more + adj.* 表达动态持续的趋势。", "趋势描述 (Simple)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **修饰错位**：习惯性用 *very* 修饰比较级（如 *very taller*）。\n2. **形态混淆**：分不清 *hardly* (几乎不) 与 *hard* (努力) 的语义本质。\n3. **排他遗忘**：在比较级中漏掉 *other* 导致逻辑自相矛盾。"),
                TeachingNote("【教学金钥】备忘清单", "1. **天平平衡法**：利用天平演示 *as...as* 的物理平衡感。\n2. **OPSHCOM 顺口溜**：‘观形龄色国产材’，强化形容词排序语感。\n3. **情感后缀卡**：对比 *-ed* (心) 与 *-ing* (物) 的逻辑指向。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到 *than* 必选比较级；看到 *in/of* 锁定最高级；见到 *enough* 往后站。")
            ),
            famousQuote = "Comparison is the thief of joy.",
            quoteAuthor = "Theodore Roosevelt",
            quoteTranslation = "比较是偷走快乐的贼。",
            quoteAnalysis = "本句巧妙运用了名词性比较逻辑，警示我们关注自我而非盲目攀比。"
        )'''

# --- 2. 介词 (Prepositions) ---
new_prepositions = r'''        KnowledgePoint(
            id = "prepositions",
            section = SEC_1,
            title = "介词 (Prepositions)",
            description = """
### 📖 核心概念详解

介词 (Prepositions) 是英语句子的“逻辑粘合剂”，用于精准定义时间、方位、方式及原因。

#### 1. 时间介词 (at, on, in) 的物理模型
| 介词 | 逻辑范畴 | 经典示例 |
| :--- | :--- | :--- |
| **at** | 具体时刻 / 瞬间点 | *at 8:00, at noon, at night, at Christmas* (指节日期间) |
| **on** | 具体某一天 / 某日早中晚 | *on Monday, on a rainy day, on the evening of May 1st* |
| **in** | 宽泛的时间段 | *in 2025, in winter, in the morning* |

#### 2. 方位介词的“三维建模”
*   **across vs through**：
    *   **across**：表面穿过 (*cross the road*)。
    *   **through**：内部穿过 (*through the forest/window/tunnel*)。
*   **over vs above**：
    *   **over**：正上方，且有覆盖感 (*flew over the mountain*)。
    *   **above**：仅指位置高，不一定正对 (*above the sea level*)。
*   **between vs among**：
    *   **between**：两者之间。
    *   **among**：三者及以上之间。

#### 3. 方式介词辨析 (by, with, in)
1.  **by**：交通方式 (*by bus*)、手段 (*by doing*)。
2.  **with**：具体物理工具 (*with a pen*)、身体部位 (*with my eyes*)。
3.  **in**：语言媒介 (*in English*)、穿着 (*in red*)。

#### 4. “in + 段时间”的将来逻辑
在中考中，*in + a week* 表示“一周之后”，常用于一般将来时，对其提问必须物理锁定 **How soon**。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【时间精准化】** 熟练区分 *at, on, in* 的应用边界，重点攻克‘具体某天早中晚’用 *on* 的陷阱。",
                "**【空间三维化】** 建立 *through, across, past* 的运动路径模型，掌握 *over/above* 的高度差逻辑。",
                "**【固定搭配】** 熟练掌握 50 组以上核心介词短语（如 *look forward to, depend on, be good at*）。",
                "**【手段判定】** 精准区分 *by, with, in* 表达手段与媒介时的微小语义质变。",
                "**【将来提问】** 掌握 *in + 段时间* 的时态功能及其对应的 *How soon* 提问逻辑。",
                "**【宾语形态】** 明确介词后须接名词、代词宾格或动名词 *doing* 的硬性语法物理要求。"
            ),
            relatedPoints = listOf(
                RelatedPoint("动词短语", "语义的灵魂", "动词与介词结合后常产生特定语义（如 *look for* 寻找 vs *look after* 照顾），不可分割。"),
                RelatedPoint("非谓语动词 (Gerunds)", "介词的天然宾语", "绝大多数介词后接动词必须转化为 *doing* 态以维持句法平衡。"),
                RelatedPoint("状语从句", "逻辑的简化", "介词短语常可替代原因、让步状语从句（如 *because of* vs *because*）。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "天津", "The library is closed ______ August 1st ______ August 15th.", listOf("A. from; to", "B. between; and", "C. at; on", "D. in; at"), "A", "**【解析】** 考查时间起止。*from...to...* 是标准物理结构。故选 **A**。", "**【注意】** 也可以用 *between...and*，但选项中无此组合。", "图书馆从 8 月 1 日关闭到 8 月 15 日。"),
                PastExamQuestion("2025", "北京", "The meeting will start ______ 9:00 ______ the morning of Monday.", listOf("A. at; in", "B. on; in", "C. at; on", "D. in; on"), "C", "**【解析】** 9点是时刻用 *at*；周一早晨是具体某天早晨用 *on*。故选 **C**。", "**【陷阱】** 容易看到 *morning* 盲目选 *in*。", "会议将在周一早晨 9 点开始。"),
                PastExamQuestion("2024", "广东", "I usually go to school ______ bike, but ______ a snowy day, I walk.", listOf("A. by; in", "B. on; on", "C. by; on", "D. in; in"), "C", "**【解析】** *by bike* 交通方式；*on a snowy day* 具体天气的一天用 *on*。故选 **C**。", "**【标志】** 具体日期的前缀词判定。", "我通常骑车上学，但在下雪天我走路。"),
                PastExamQuestion("2024", "上海", "It's dangerous to walk ______ the busy road without looking.", listOf("A. across", "B. through", "C. past", "D. along"), "A", "**【解析】** 表面横穿马路用 *across*。故选 **A**。", "**【建模】** 马路是平面，故用 *across*。", "不看路就横穿马路是很危险的。"),
                PastExamQuestion("2023", "江苏南京", "— How soon will your father return?\n— ______ two weeks.", listOf("A. After", "B. In", "C. For", "D. Since"), "B", "**【解析】** *How soon* 提问多久之后，用 *In + 段时间* 回答。故选 **B**。", "**【提问关联】** 提问词与介词的锁定关系。", "—— 你爸爸多久后回来？ —— 两周后。"),
                PastExamQuestion("2022", "湖北武汉", "The plane flew ______ the mountains and disappeared into the clouds.", listOf("A. through", "B. over", "C. across", "D. on"), "B", "**【解析】** 垂直经过高山上方用 *over*。故选 **B**。", "**【高度】** *over* 强调物理跨越感。", "飞机飞过了群山，消失在云中。"),
                PastExamQuestion("2021", "河南", "We should solve problems ______ our own efforts instead of depending ______ others.", listOf("A. with; on", "B. through; in", "C. by; on", "D. with; in"), "C", "**【解析】** *by efforts* 表达手段；*depend on* 固定搭配。故选 **C**。", "**【搭配】** 动词 + 介词的锁定关系。", "我们应该通过自己的努力解决问题，而不是依赖他人。"),
                PastExamQuestion("2020", "山东济南", "My home is ______ the post office and the hospital.", listOf("A. among", "B. between", "C. in", "D. at"), "B", "**【解析】** 两者之间用 *between*。故选 **B**。", "**【范围】** 区分两者与三者。", "我家在邮局和医院之间。"),
                PastExamQuestion("2019", "陕西", "I am looking forward ______ hearing from you soon.", listOf("A. at", "B. to", "C. for", "D. with"), "B", "**【解析】** *look forward to* 是固定短语，其中 *to* 是介词。故选 **B**。", "**【红线】** *to* 后接 *doing* 是必考点。", "我期待很快收到你的回信。"),
                PastExamQuestion("2018", "云南", "There are hundreds ______ students on the playground.", listOf("A. of", "B. in", "C. with", "D. for"), "A", "**【解析】** 模糊数量 *hundreds of*。故选 **A**。", "**【s定律】** 有 *s* 必有 *of*。", "操场上有数百名学生。"),
                PastExamQuestion("2017", "山西", "The park is ______ the north of the city.", listOf("A. in", "B. on", "C. to", "D. at"), "A", "**【解析】** 在城市内部的北部用 *in*。故选 **A**。", "**【方位】** *in* (内), *on* (接壤), *to* (隔海/不接壤)。", "公园在城市的北部。"),
                PastExamQuestion("2016", "安徽", "We usually have lunch ______ noon.", listOf("A. at", "B. in", "C. on", "D. for"), "A", "**【解析】** *at noon* 固定表达。故选 **A**。", "**【时刻】** 精确时间点用 *at*。", "我们通常在中午吃午饭。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("My school is in front of a big park. There is a clean river behind it. To get to the library, you need to go across the bridge and walk through the woods.", listOf(
                    HighlightedSentence("in front of", "**【空间关系】** 外部的前面（不含内部）。"),
                    HighlightedSentence("across the bridge", "**【运动轨迹】** 表面横切面的运动。"),
                    HighlightedSentence("through the woods", "**【内部穿透】** 强调在三维空间内的位移。")
                ), "人教版 (Go for it!) 七下 Unit 1"),
                TextbookParagraph("I usually have breakfast at 7:00. After school, I often play the violin for an hour. On Saturday mornings, I go to the library with my friends.", listOf(
                    HighlightedSentence("at 7:00", "**【精确时刻】** *at* 锁定了具体的时间刻度。"),
                    HighlightedSentence("On Saturday mornings", "**【特定时段】** 具体某天的早晨必须物理性切换为 *on*。")
                ), "人教版 (Go for it!) 七下 Unit 6"),
                TextbookParagraph("He arrived at the station in time to catch the last train. He was concerned about missing it. Luckily, his father drove him there with his old car.", listOf(
                    HighlightedSentence("in time", "**【语义辨析】** “及时”，与 *on time* (准时) 构成中考核心对立。"),
                    HighlightedSentence("concerned about", "**【形容词搭配】** 展示了情绪形容词对介词的依赖。")
                ), "沪教版 (Oxford) 八上 Unit 2")
            ),
            exampleSentences = listOf(
                ExampleSentence("The plane flew over the mountains and disappeared into the thick clouds.", "飞机飞过了群山，消失在浓云中。", "**【分析】** *over* 表示跨越感；*into* 表达动态的进入。", "空间描述 (Complex)"),
                ExampleSentence("With the help of the new machine, they finished the work ahead of time.", "在机器的帮助下，他们提前完成了工作。", "**【分析】** *With the help of* 与 *ahead of time* (提前) 的双重介词应用。", "高阶句法 (Compound)"),
                ExampleSentence("I am interested in learning Chinese history by visiting the local museums.", "我通过参观当地博物馆对学习中国历史产生了兴趣。", "**【分析】** *interested in* 后接 *doing*；*by doing* 表达手段。", "基础必会 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **母语直译**：受汉语“在...之下”影响误写 *under one's help* (应为 *with*)。\n2. **三维盲点**：分不清 *across* (面) 与 *through* (体) 的模型。\n3. **标志性缺失**：分不清 *in time* 与 *on time* 的语义力度。"),
                TeachingNote("【教学金钥】备忘清单", "1. **空间实物演示**：利用粉笔盒演示方位关系。\n2. **时间金字塔**：底部大范围 *in*，顶端精准 *at*。\n3. **搭配记忆网**：以介词为核心节点，辐射关联的动词与形容词。"),
                TeachingNote("【冲刺技巧】中考必杀技", "看到森林隧道选 *through*；看到具体日期选 *on*；看到 *the help of* 必选 *with*。")
            ),
            famousQuote = "To be or not to be, that is the question.",
            quoteAuthor = "William Shakespeare",
            quoteTranslation = "生存还是毁灭，这是一个值得考虑的问题。",
            quoteAnalysis = "介词 'to' 虽然在此作为不定式符号，但它连接了人类历史上最深刻的逻辑抉择。"
        )'''

# --- 3. 连词 (Conjunctions) ---
new_conjunctions = r'''        KnowledgePoint(
            id = "conjunctions",
            section = SEC_1,
            title = "连词 (Conjunctions)",
            description = """
### 📖 核心概念详解

连词 (Conjunctions) 是英语句子的“逻辑骨架”。

#### 1. 并列连词 (Coordinating Conjunctions)
| 类别 | 成员 | 逻辑含义 |
| :--- | :--- | :--- |
| **并列** | *and, as well as* | 顺接，逻辑一致 |
| **转折** | *but, yet* | 逆接，相反含义 |
| **选择** | *or, either...or* | 非此即彼 |
| **因果** | *so, for* | 推导出结果或补充原因 |

#### 2. 关联连词的“就近原则” (核心考位)
> 💡 **权力中心法则**：谓语动词的形态由离它最近的主语决定。
> *   *not only A but also **B*** + 谓语
> *   *either A or **B*** + 谓语
> *   *neither A nor **B*** + 谓语
> ⚠️ **例外**：*both A and B* 谓语恒用复数。

#### 3. 中考逻辑禁忌红线
*   **BC/SO 不并存**：*because* 与 *so* 不能在同一句中同时出现。
*   **AL/BUT 不并存**：*although/though* 与 *but* 不能在同一句中同时出现。

#### 4. 特殊句式逻辑
*   **祈使句 + and + 陈述句**：表示“如果...就...”。
*   **祈使句 + or + 陈述句**：表示“快点，否则...”。
""".trimIndent(),
            syllabusDetails = listOf(
                "**【并列逻辑】** 精准判定四种并列关系，掌握 *and/or* 在祈使句混合结构中的语用功能。",
                "**【就近一致】** 熟练运用关联连词，掌握 *neither...nor* 等结构对谓语动词数的物理控制权。",
                "**【互斥铁律】** 严格执行 *because/so* 及 *although/but* 的二选一法则，杜绝母语负迁移。",
                "**【条件代换】** 掌握 *unless* 与 *if...not* 的等值逻辑转换技巧。",
                "**【引导词判定】** 理解从属连词对从句性质的锁定（如 *until* 对主句谓语延续性的要求）。"
            ),
            relatedPoints = listOf(
                RelatedPoint("主谓一致", "距离产生的权力", "关联连词是中考考查就近原则的主战场。"),
                RelatedPoint("祈使句", "隐性条件表达", "‘祈使句 + 连词’ 是高级复合句的逻辑变体。"),
                RelatedPoint("状语从句", "逻辑的旗手", "从属连词直接决定了从句是时间、地点还是原因状语。")
            ),
            exampleProblems = listOf(),
            pastExamQuestions = listOf(
                PastExamQuestion("2025", "北京", "Work hard, ______ you will achieve your goals one day.", listOf("A. and", "B. or", "C. but", "D. so"), "A", "**【解析】** 考查“祈使句 + and + 结果”结构。表示正向结果。故选 **A**。", "**【注意】** 这里的 and 带有“那么”的意思。", "努力工作，总有一天你会实现目标。"),
                PastExamQuestion("2025", "上海", "Neither my parents nor my brother ______ to the Great Wall before.", listOf("A. have", "B. has", "C. are", "D. is"), "B", "**【解析】** *neither...nor* 遵循就近原则。主语 *my brother* 是单三。故选 **B**。", "**【陷阱】** 不要因为 *parents* 选 have。", "我父母和我弟弟以前都没去过长城。"),
                PastExamQuestion("2024", "广东", "Hurry up, ______ you will miss the early train.", listOf("A. and", "B. but", "C. or", "D. so"), "C", "**【解析】** 考查“祈使句 + or + 后果”结构。表示“否则”。故选 **C**。", "**【逻辑】** 动作不执行的负面后果。", "快点，否则你会错过早班火车。"),
                PastExamQuestion("2024", "天津", "______ she is very busy, ______ she still finds time to read.", listOf("A. Although; but", "B. Because; so", "C. Although; /", "D. Because; /"), "C", "**【解析】** *although* 与 *but* 不能共存。故选 **C**。", "**【红线】** 英语逻辑严禁双重标记。", "虽然她很忙，但她仍抽时间阅读。"),
                PastExamQuestion("2023", "江苏南京", "— Which would you like, tea ______ coffee?\n— Either is OK. I don't mind.", listOf("A. and", "B. or", "C. but", "D. so"), "B", "**【解析】** 询问二选一，用并列连词 *or*。故选 **B**。", "**【语境】** 选择疑问句标志词。", "—— 你想要茶还是咖啡？ —— 哪个都行。我不介意。"),
                PastExamQuestion("2022", "四川成都", "I didn't go to bed ______ I finished all my work last night.", listOf("A. until", "B. because", "C. though", "D. if"), "A", "**【解析】** *not...until* 意为“直到...才”。故选 **A**。", "**【结构】** 否定句 + *until* + 终止点。", "昨天晚上我直到做完工作才睡觉。"),
                PastExamQuestion("2021", "河南", "He didn't come to school ______ he was badly ill.", listOf("A. so", "B. because", "C. although", "D. unless"), "B", "**【解析】** 后句是前句的原因。故选 **B**。", "**【基础】** 因果关系判定。", "他没来上学，因为他病得很重。"),
                PastExamQuestion("2020", "安徽", "You can't pass the exam ______ you work harder than before.", listOf("A. if", "B. unless", "C. because", "D. although"), "B", "**【解析】** *unless* 意为“除非”，相当于 *if...not*。故选 **B**。", "**【条件】** 逻辑排除法。", "除非你比以前更努力，否则你无法通过考试。"),
                PastExamQuestion("2019", "福建", "— Would you like to go shopping?\n— I'd like to, ______ I am busy today.", listOf("A. and", "B. but", "C. or", "D. so"), "B", "**【解析】** 前后语义转折。故选 **B**。", "**【交际】** 转折逻辑应用。", "—— 你想去购物吗？ —— 我想去，但我今天很忙。"),
                PastExamQuestion("2018", "山东济南", "Both you and he ______ good at playing the piano.", listOf("A. is", "B. are", "C. was", "D. were"), "B", "**【解析】** *both...and* 谓语恒用复数。故选 **B**。", "**【规则】** *both* 是绝对复数的标志。", "你和他都擅长弹钢琴。"),
                PastExamQuestion("2017", "陕西", "I'll wait here ______ she comes back.", listOf("A. until", "B. because", "C. if", "D. so"), "A", "**【解析】** 肯定句 *wait until* 意为“一直等到...”。故选 **A**。", "**【延续性】** 动词时长对连词的要求。", "我会一直在这儿等到她回来。"),
                PastExamQuestion("2016", "重庆", "Hurry up, ______ you will be late for school.", listOf("A. and", "B. or", "C. but", "D. so"), "B", "**【解析】** “否则”逻辑。故选 **B**。", "**【固定句式】** 祈使句 + *or*。", "快点，否则你上学会迟到。")
            ),
            textbookParagraphs = listOf(
                TextbookParagraph("Although the weather was bad, the volunteers still went there. They brought not only food but also medicine to the people. Both the young and the old were moved.", listOf(
                    HighlightedSentence("not only... but also...", "**【并列递进】** 用于强调服务范围的广泛性。"),
                    HighlightedSentence("Both... and...", "**【复数一致】** 展示了该连词对动词形态的物理锁定。")
                ), "人教版 (Go for it!) 九年级 Unit 5"),
                TextbookParagraph("Study hard, or you will fail. If you manage your time well, you will find learning is interesting. Don't give up because success belongs to those who work hard.", listOf(
                    HighlightedSentence("Study hard, or...", "**【隐性条件】** 将命令语气转化为逻辑推导。"),
                    HighlightedSentence("because success belongs", "**【因果逻辑】** 用于解释“为什么”要坚持。")
                ), "外研版 (New Standard) 八下 Module 6"),
                TextbookParagraph("Not only the students but also the teacher likes the idea. Neither of them wants to change the plan. Either you or I am going to tell them the news.", listOf(
                    HighlightedSentence("but also the teacher likes", "**【就近原则】** 谓语动词物理性靠近 *teacher* 故用单三。"),
                    HighlightedSentence("Either you or I am", "**【就近原则】** 谓语动词物理性靠近 *I* 故用 *am*。")
                ), "沪教版 (Oxford) 九下 Unit 3")
            ),
            exampleSentences = listOf(
                ExampleSentence("Not only the students but also the teacher likes this book.", "不仅学生而且老师也喜欢这本书。", "**【分析】** 典型的就近原则复杂句，谓语随 *teacher* 变动。", "中考核心 (Complex)"),
                ExampleSentence("He won't leave for his hometown unless it stops raining.", "除非雨停，否则他不会启程回老家。", "**【分析】** *unless* 引导的条件从句遵循主将从现原则。", "高频易错 (Complex)"),
                ExampleSentence("Either you or I am going to the meeting this afternoon.", "要么是你，要么是我去开会。", "**【分析】** 就近原则在 *be* 动词选择上的体现。", "基础必会 (Compound)")
            ),
            teachingNotes = listOf(
                TeachingNote("【学情透视】核心症结", "1. **汉语负迁移**：*bc/so* 连用是高发错误。\n2. **一致性盲点**：忽略 *both* 的绝对复数与 *neither* 等的就近原则。\n3. **逻辑倒置**：分不清 *unless* 与 *if* 的方向性。"),
                TeachingNote("【教学金钥】备忘清单", "1. **逻辑对对碰**：将连词与逻辑符号（+、-、?、=）匹配。\n2. **距离感应图**：画出谓语与主语的距离，强化就近意识。\n3. **红线划销法**：见到 *although* 强制划掉 *but* 的视觉训练。"),
                TeachingNote("【冲刺技巧】中考必杀技", "有 *both* 找复数；有 *neither* 找最近；见到 *although* 赶走 *but*。")
            ),
            famousQuote = "United we stand, divided we fall.",
            quoteAuthor = "Aesop",
            quoteTranslation = "团结则存，分裂则亡。",
            quoteAnalysis = "连词在平行结构与对立逻辑中的灵魂体现，展示了语言的逻辑张力。"
        )'''

# --- 执行替换 ---
pattern_adj_adv = re.compile(r'KnowledgePoint\(\s+id = "adj_adv",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_prepositions = re.compile(r'KnowledgePoint\(\s+id = "prepositions",.*?^\s+\),', re.DOTALL | re.MULTILINE)
pattern_conjunctions = re.compile(r'KnowledgePoint\(\s+id = "conjunctions",.*?^\s+\),', re.DOTALL | re.MULTILINE)

content = pattern_adj_adv.sub(lambda _: new_adj_adv + ',', content)
content = pattern_prepositions.sub(lambda _: new_prepositions + ',', content)
content = pattern_conjunctions.sub(lambda _: new_conjunctions + ',', content)

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(content)

print("Success")
