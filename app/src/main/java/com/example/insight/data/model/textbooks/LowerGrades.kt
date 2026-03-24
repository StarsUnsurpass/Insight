package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade7Down {
    val data = Textbook(
        id = "g7_down",
        grade = "七年级",
        term = "下册",
        coverColor = Color(0xFFC8E6C9),
        units = listOf(
            TextbookUnit("g7d_u1", "Unit 1", "Can you play the guitar?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    *   **主题范畴**：人与自我 (Man and Self) —— 个人特长与意愿（能力场）。
                    *   **核心逻辑**：通过询问能力，构建社交合作的物理锚点。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇详析 (Vocabulary)", """
                    #### ① **play the guitar / chess / the piano**
                    - **物理守则**：乐器前加 **the**；球类/棋类前 **不加** the。
                    
                    #### ② **speak / tell / say / talk** (四说辨析)
                    - **speak**: 说某种语言。 *speak English*.
                    - **tell**: 讲述，告诉。 *tell a story*.
                    - **say**: 强调内容。 *say hello*.
                    - **talk**: 交谈，谈话。 *talk with sb.*.
                    
                    #### ③ **be good at / with**
                    - **be good at**: 擅长某事。 *be good at swimming*.
                    - **be good with**: 与某人相处得好。 *be good with children*.
                """.trimIndent()),
                UnitDetailSection("⚙️ 单元语法 (Grammar)", """
                    #### 情态动词 "can" (能力磁场)
                    - **物性特征**：无谓数、无人称变化。后接 **动词原形**。
                    - **否定式**：*can't*. **疑问式**：*Can* 提至句首。
                """.trimIndent()),
                UnitDetailSection("📚 核心句式", """
                    - *Can you join the music club?*
                    - *I'm good at drawing and telling stories.*
                """.trimIndent())
            )),
            TextbookUnit("g7d_u2", "Unit 2", "What time do you go to school?", listOf(
                UnitDetailSection("📖 单元导读", "日常作息规律与时间物理对标。"),
                UnitDetailSection("🔤 词汇精析", """
                    #### ① **get up / get dressed / take a shower**
                    - **动作集锦**：清晨物理动作链条。
                    
                    #### ② **What time vs When**
                    - **What time**: 询问具体时刻。 *At 8:00*.
                    - **When**: 询问大概时间段。 *In the morning*.
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 频率副词 (Frequency Adverbs)
                    - **磁感应强度**：*always > usually > often > sometimes > never*.
                    - **物理位置**：行前 be 后。 *I usually eat breakfast at 7:00.*
                """.trimIndent()),
                UnitDetailSection("📚 典句必背", """
                    - *What time do you usually get up? — I usually get up at six thirty.*
                    - *That's a funny time for breakfast!*
                """.trimIndent())
            )),
            TextbookUnit("g7d_u3", "Unit 3", "How do you get to school?", listOf(
                UnitDetailSection("📖 单元导读", "交通运输物理路径与时长计算。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **by train / ride a bike / take the bus**
                    - **物理轨迹转换**：
                      - 介词短语：`by + 交通工具` (中间不加冠词)。
                      - 动词短语：`take the + 交通工具`。
                    
                    #### ② **How long vs How far**
                    - **How long**: 询问时间长度 (多少分钟)。
                    - **How far**: 询问路程远近 (多少千米)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 时间消耗模型 (Physics Formula)
                    - **It takes sb. some time to do sth.** (花费某人多少时间做某事)。
                    - *It takes me 20 minutes to get to school.*
                """.trimIndent()),
                UnitDetailSection("📚 典句必背", """
                    - *How far is it from your home to school? — It's about five kilometers.*
                    - *How long does it take? — It takes 30 minutes by bus.*
                """.trimIndent())
            )),
            TextbookUnit("g7d_u4", "Unit 4", "Don't eat in class.", listOf(
                UnitDetailSection("📖 单元导读", "规章制度与场域禁止法则。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **on time vs in time**
                    - **on time**: 准时 (指时刻)。
                    - **in time**: 及时 (指赶上了)。
                    
                    #### ② **have to vs must**
                    - **have to**: 客观需要 (由于外部原因)。
                    - **must**: 主观义务 (自己认为必须做)。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 祈使句 (Imperatives) —— 指令场
                    - **肯定句**：动词原形开头。 *Wear the school uniform.*
                    - **否定句**：**Don't** 开头。 *Don't run in the hallways.*
                """.trimIndent())
            )),
            TextbookUnit("g7d_u5", "Unit 5", "Why do you like pandas?", listOf(
                UnitDetailSection("📖 单元导读", "生命科学偏好与因果逻辑分析。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **kind of** (稍微; 有点)
                    - 相当于 *a little bit*。 *He is kind of shy.*
                    
                    #### ② **be from / come from**
                    - *Pandas are from China.* = *Pandas come from China.*
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### Why 引导的特殊疑问句
                    - **逻辑闭环**：Why 问 because 答。
                    - *Why do you like them? — Because they are very intelligent.*
                """.trimIndent())
            )),
            TextbookUnit("g7d_u6", "Unit 6", "I'm watching TV.", listOf(
                UnitDetailSection("📖 单元导读", "正在发生的动作（即时状态场）。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **make soup / wash dishes / read newspaper**
                    - 生活动作集合。
                    
                    #### ② **join sb for dinner**
                    - 加入某人一起吃晚饭。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 现在进行时 (Present Continuous)
                    - **物理本质**：动作正在进行中。
                    - **结构**：**am/is/are + v-ing**。
                    - **标志词**：*now, look, listen, at the moment*.
                """.trimIndent())
            )),
            TextbookUnit("g7d_u7", "Unit 7", "It's raining!", listOf(
                UnitDetailSection("📖 单元导读", "描述天气状况与人们正在进行的活动。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **weather [ˈweðə(r)]** (天气)
                    - 不可数名词。 *What's the weather like?* = *How's the weather?*
                    
                    #### ② **rainy / snowy / sunny / cloudy / windy**
                    - 名词 + **y** 构成的形容词物理场。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 现在进行时 (续)
                    - 询问天气下的活动：*What are they doing in the rain?*
                """.trimIndent())
            )),
            TextbookUnit("g7d_u8", "Unit 8", "Is there a post office near here?", listOf(
                UnitDetailSection("📖 单元导读", "街道物理空间位置与邻里导航。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **between ... and ...**
                    - 在……和……之间 (两者之间)。
                    
                    #### ② **post office / pay phone / police station**
                    - 城市公共设施集合。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### There be 句型 (存在场)
                    - **物理定律**：表示某地存在某物。
                    - **就近原则**：be 动词数与最近的内容一致。 *There is a pen and two books.*
                """.trimIndent())
            )),
            TextbookUnit("g7d_u9", "Unit 9", "What does he look like?", listOf(
                UnitDetailSection("📖 单元导读", "人物外貌描述与特征提取。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### curly vs straight (头发)
                    #### tall / short / medium height (身高)
                    #### thin / heavy / medium build (体型)
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 1. have vs is (外貌分布)
                    - **is**: 接身高、体型。 *He is tall.*
                    - **has**: 接头发、眼睛。 *She has long hair.*
                    
                    #### 2. 形容词排序规则
                    - **物性顺序**：长短 + 形状 + 颜色。 *long curly black hair*.
                """.trimIndent())
            )),
            TextbookUnit("g7d_u10", "Unit 10", "I'd like some noodles.", listOf(
                UnitDetailSection("📖 单元导读", "点餐礼仪与食物数量表述。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **would like** (想要)
                    - 语气比 *want* 委婉。 *I'd like a large bowl of noodles.*
                    
                    #### ② **countable vs uncountable nouns**
                    - **可数**：apple, egg, noodle.
                    - **不可数**：beef, water, bread.
                """.trimIndent())
            )),
            TextbookUnit("g7d_u11", "Unit 11", "How was your school trip?", listOf(
                UnitDetailSection("📖 单元导读", "回顾过去发生的学校旅行活动（过去时叙事）。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 一般过去时 (Simple Past) I
                    - **Was/Were**：表示过去的某种状态。
                    - **动词变化**：规则动词 +ed；不规则动词 (go -> **went**, see -> **saw**)。
                """.trimIndent())
            )),
            TextbookUnit("g7d_u12", "Unit 12", "What did you do last weekend?", listOf(
                UnitDetailSection("📖 单元导读", "周末活动的详细叙述与疑问。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 一般过去时 (Simple Past) II
                    - **疑问句**：借助助动词 **did**。 *Did you go to the cinema?*
                    - **否定句**：**didn't + 动词原形**。
                """.trimIndent())
            )
        )
    )
)
}

object Grade8Down {
    val data = Textbook(
        id = "g8_down",
        grade = "八年级",
        term = "下册",
        coverColor = Color(0xFFFFCCBC),
        units = listOf(
            TextbookUnit("g8d_u1", "Unit 1", "What's the matter?", listOf(
                UnitDetailSection("📖 单元导读 (Unit Overview)", """
                    *   **主题范畴**：人与自我 —— 健康管理与安全救援。
                    *   **核心内容**：表述疾病情况，给出急救或健康建议。
                """.trimIndent()),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **have a + 疾病名称**
                    - *have a fever* (发烧); *have a stomachache* (胃痛)。
                    
                    #### ② **reflexive pronouns** (反身代词)
                    - *himself, herself, yourself...*
                    - **物理逻辑**：主语和宾语指代同一个人。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### should / shouldn't (建议磁场)
                    - 用于给出建议。 *You should drink more water.*
                """.trimIndent())
            )),
            TextbookUnit("g8d_u2", "Unit 2", "I'll help to clean up the city parks.", listOf(
                UnitDetailSection("📖 单元导读", "志愿精神与社区回馈。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### Phrasal Verbs (动词+副词)
                    - *cheer up, give away, pick up*.
                    - **物理规则**：如果宾语是人称代词 (*it/them*)，必须放在短语 **中间**。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### used to do (过去常常) —— 习惯场
                    - 表示过去存在的状态或反复发生的动作。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u3", "Unit 3", "Could you please clean your room?", listOf(
                UnitDetailSection("📖 单元导读", "家务协作与委婉拒绝礼仪。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### borrow vs lend
                    - **borrow (from)**: 借入。
                    - **lend (to)**: 借出。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### Could you please...?
                    - 这里的 *Could* 表达 **礼貌语气**，而非过去式。
                    - 答语：*Yes, sure.* / *No, I can't, because...*
                """.trimIndent())
            )),
            TextbookUnit("g8d_u4", "Unit 4", "Why don't you talk to your parents?", listOf(
                UnitDetailSection("📖 单元导读", "人际压力与心理辅导策略。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 1. 提建议的多种句式
                    - *Why don't you do...?*
                    - *What about doing...?*
                    
                    #### 2. Conjunctions (连词场)
                    - *although* (虽然), *so that* (以便), *until* (直到)。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u5", "Unit 5", "What were you doing when the rainstorm came?", listOf(
                UnitDetailSection("📖 单元导读", "重大瞬间的叙事背景（过去进行时）。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 过去进行时 (Past Continuous)
                    - **物理本质**：过去某个时间点正在发生的动作场景。
                    - **结构**：**was/were + v-ing**。
                    
                    #### when vs while
                    - **when**: 后跟时间点/瞬间动词。
                    - **while**: 后跟时间段/延续性动词。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u6", "Unit 6", "An old man tried to move the mountains.", listOf(
                UnitDetailSection("📖 单元导读", "古代神话的哲学叙事。"),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 叙事逻辑连词
                    - *as soon as* (一……就); *unless* (除非)。
                    - **主将从现**：在 *as soon as, unless* 等引导的状语从句中用现在时代替将来。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u7", "Unit 7", "What's the highest mountain in the world?", listOf(
                UnitDetailSection("📖 单元导读", "自然地理极值与世界概况（形容词最高级应用场）。"),
                UnitDetailSection("🔤 核心词汇详析", """
                    #### ① **population [ˌpɒpjuˈleɪʃn]** (人口)
                    - 询问人口：*What is the population of...?*
                    - 表示人口多/少用 **large / small**。
                    
                    #### ② **feet / meter / centimeter**
                    - 长度单位物理对标。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 形容词比较级与最高级 (续)
                    - **数量级差**：*three times as big as* (三倍大)。
                    - **最高级标志**：*the + largest / most beautiful*.
                """.trimIndent())
            )),
            TextbookUnit("g8d_u8", "Unit 8", "Have you read Treasure Island yet?", listOf(
                UnitDetailSection("📖 单元导读", "文学名著与阅读习惯（现在完成时初探）。"),
                UnitDetailSection("🔤 核心词汇", """
                    #### ① **already vs yet**
                    - **already**: 用于肯定句。
                    - **yet**: 用于疑问句/否定句。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 现在完成时 (Present Perfect) I
                    - **结构**：**have/has + done (过去分词)**。
                    - **物理意义**：过去发生的动作对现在造成的影响。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u9", "Unit 9", "Have you ever been to a museum?", listOf(
                UnitDetailSection("📖 单元导读", "旅行经历与打卡地点。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### been to vs gone to
                    - **have been to**: 去过某地（已回来）。
                    - **have gone to**: 去了某地（还没回来）。
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### Have you ever...?
                    - 表示“曾经是否做过某事”的询问。
                """.trimIndent())
            )),
            TextbookUnit("g8d_u10", "Unit 10", "I've had this bike for three years.", listOf(
                UnitDetailSection("📖 单元导读", "家乡记忆与旧物情节（现在完成时延续态）。"),
                UnitDetailSection("🔤 词汇辨析", """
                    #### since vs for (时间段法则)
                    - **for + 时间段**：*for three years*.
                    - **since + 时间点/从句**：*since 2020 / since I was a child*.
                """.trimIndent()),
                UnitDetailSection("⚙️ 语法精析", """
                    #### 延续性动词 vs 瞬间动词
                    - *buy* -> **have had**; *borrow* -> **have kept**.
                    - 在 `since/for` 结构中必须使用 **延续性动词**。
                """.trimIndent())
            )
        )
    )
)
}
