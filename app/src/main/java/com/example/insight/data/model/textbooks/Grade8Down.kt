package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade8Down {
    val data = Textbook(
        id = "g8_down",
        grade = "八年级",
        term = "下册",
        coverColor = Color(0xFFF3E5F5),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc8x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g8down_u1", "Unit 1", "What's the matter?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 健康与急救。
                        *   **深层意义**：本单元围绕“身体不适与急救措施”展开。不仅要求学生掌握描述病痛的词汇，更重要的是培养学生面对突发健康问题时的应急处理能力。通过学习“登山者Aron Ralston”等真实急救故事，向学生传递敬畏生命、坚韧不拔的求生精神。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **身体部位**：head (头), stomach (胃), back (背), arm (手臂), leg (腿), foot (脚), neck (脖子), tooth (牙齿), throat (喉咙), knee (膝盖)。
                        - **病痛与症状**：fever (发烧), cough (咳嗽), toothache (牙痛), headache (头痛), stomachache (胃痛), sore (疼痛的)。
                        - **急救与动作**：lie (躺), rest (休息), hurt (伤害), hit (击打), cut (切/割), fall (落下), bleed (流血)。
                        - **其他名词**：passenger (乘客), trouble (问题/麻烦), danger (危险)。

                        ### 2. 核心短语金牌储备
                        - `have a stomachache` 胃痛
                        - `have a cold` 感冒
                        - `lie down and rest` 躺下休息
                        - `take one's temperature` 量体温
                        - `get off` 下车 (**对比: get on 上车**)
                        - `to one's surprise` 令某人惊讶的是
                        - `right away` 立即；马上
                        - `get into trouble` 陷入麻烦
                        - `be used to doing sth.` 习惯于做某事
                        - `run out of` 用尽；耗尽
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What's the matter? (怎么了？/ 出什么事了？)
                        - **【考点详解】**：询问某人遇到什么麻烦或生什么病时的常用语。同义句：`What's wrong (with you)?`
                        
                        #### 2. I have a sore back. (我背痛。)
                        - **【疾病表达】**：`have a sore + 身体部位` (如 sore throat)。或者 `have a + 部位ache` (如 headache)。
                        
                        #### 3. You should lie down and rest. (你应该躺下休息。)
                        - **【建议句型】**：`should / shouldn't + 动词原形` 表示建议。
                        
                        #### 4. The bus driver stopped the bus without thinking twice. (公交车司机毫不犹豫地停下了车。)
                        - **【结构剖析】**：`without` 是介词，后接动名词 `thinking`。`without thinking twice` 意为“没有三思；毫不犹豫”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：情态动词 should 表建议
                        **1. 用法**：`should` 意为“应该”，用于提出建议、劝告或义务。
                        **2. 句式**：
                        - 肯定句：You should drink some hot water.
                        - 否定句：You shouldn't eat too much junk food.
                        - 疑问句：Should I take my temperature?
                        
                        ### 核心语法二：反身代词
                        **1. 构成**：myself, yourself, himself, herself, itself, ourselves, yourselves, themselves。
                        **2. 常用短语**：
                        - `enjoy oneself` (玩得开心)
                        - `help oneself to...` (随便吃/喝点...)
                        - `by oneself` (独自)
                        - `teach oneself` (自学)

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— It's raining hard outside. You ________ stay at home.*
                        A. could   B. might   C. should   D. would
                        
                        **[解析]**：根据雨下得很大，给出强烈的建议“应该”待在家里，选 **C**。

                        *(2023·北京中考)* *The little girl is only five years old, but she can look after ________.*
                        A. she   B. her   C. hers   D. herself
                        
                        **[解析]**：主语与宾语为同一人时，宾语用反身代词，look after herself (照顾她自己)，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：健康建议信 (Health Advice)
                        #### 1. 写作逻辑
                        - **引入**：说明对方的问题 (I'm sorry to hear that you have a bad cold.)。
                        - **具体建议 (Dos)**：列出应该做的事情 (You should...)。
                        - **禁忌事项 (Don'ts)**：列出不该做的事情 (You shouldn't...)。
                        - **祝愿**：I hope you will feel better soon.

                        #### 2. 高分句式
                        - *It's a good idea to drink plenty of water.*
                        - *You should lie down and rest right away.*
                        - *It's important to keep yourself warm.*
                        - *Don't go out until you feel well.*

                        #### 3. 满分范文
                        **Advice for a Cold**
                        
                        Dear Tom,
                        I'm sorry to hear that you have a bad cold. Don't worry. Here is some advice for you.
                        
                        First, you should go to see a doctor and take some medicine. Second, it's a good idea to drink plenty of hot water. Third, you should lie down and rest in bed for a few days. You shouldn't stay up late or play computer games. Also, you shouldn't eat cold food like ice-cream.
                        
                        Have a good rest. I hope you will get well soon.
                        Yours,
                        Li Hua
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u2", "Unit 2", "I'll help to clean up the city parks.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 志愿服务与社会责任。
                        *   **深层意义**：本单元围绕“志愿工作（Volunteer Work）”展开。旨在引导学生关注弱势群体（如老人、病童、残疾人），培养学生的社会责任感、同理心和奉献精神。通过讨论如何提供帮助，理解“赠人玫瑰，手有余香”的深层价值观。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **动词短语核心词**：cheer (欢呼), volunteer (自愿/志愿者), notice (注意), raise (筹集), repair (修理), fix (修理), imagine (想象)。
                        - **名词**：sign (标志), feeling (感觉), difficulty (困难), joy (高兴), journey (旅程), letter (信)。
                        - **形容词/副词**：lonely (孤独的), several (几个), strong (强壮的), blind (瞎的), deaf (聋的)。

                        ### 2. 核心短语金牌储备
                        - `clean up` 打扫（或清除）干净
                        - `cheer up` （使）变得更高兴
                        - `give out` 分发；散发
                        - `put off` 推迟
                        - `set up` 建立；设立
                        - `make a difference` 产生影响；有关系
                        - `come up with` 想出；提出（主意）
                        - `put to good use` 充分利用
                        - `call up` 打电话给...
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I'll help to clean up the city parks. (我将帮忙打扫城市公园。)
                        - **【考点详解】**：`help (to) do sth.` 帮忙做某事。`clean up` 是动副短语。
                        
                        #### 2. We need to come up with a plan. (我们需要想出一个计划。)
                        - **【结构剖析】**：`come up with` 是中考高频词组，意为“想出（主意、计划等）”。
                        
                        #### 3. The boy could tell that his mother was making a difference. (男孩能看出来他母亲正在产生影响。)
                        - **【词法精辨】**：`make a difference` 意为“有影响，起作用”。
                        
                        #### 4. Not only do I feel good about helping other people, but I get to spend time doing what I love to do. (我不仅对帮助他人感觉很好，而且我得以花时间做我热爱的事情。)
                        - **【句式金牌】**：`not only... but also...` 连接两个并列成分。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：动词不定式作宾语、状语、定语
                        1.  **作宾语**：`decide/hope/want to do sth.`。
                        2.  **作目的状语**：*He volunteers there **to help** kids.* (他去那里做志愿服务是为了帮助孩子)。
                        3.  **作定语**：放在被修饰名词后。*I have a lot of homework **to do**.*

                        ### 核心语法二：由动词+副词构成的短语动词
                        **规则**：如果宾语是代词 (it/them)，必须放在动词和副词中间！
                        *   `clean up the park` = `clean the park up` = `clean it up`
                        *   `give out the books` = `give the books out` = `give them out`
                        **常考短语**：*cheer up, turn on/off, put on, take off, pick up, put away, throw away*。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *The old clothes are still useful. Please don't ________.*
                        A. throw it away   B. throw them away   C. throw away it   D. throw away them
                        
                        **[解析]**：clothes 是复数，代词用 them；动副短语代词放中间，选 **B**。

                        *(2023·广东中考)* *We should do what we can ________ the environment.*
                        A. to protect   B. protect   C. protecting   D. protected
                        
                        **[解析]**：动词不定式 to protect 作目的状语，表示“为了保护”，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的志愿服务经历 (My Volunteer Experience)
                        #### 1. 写作逻辑
                        - **背景介绍**：Where and when did you volunteer?
                        - **具体工作**：What did you do there? (使用动词短语如 clean up, cheer up, read to...)。
                        - **感受与意义**：How did you feel? Why is it important?

                        #### 2. 高分句式
                        - *Last weekend, I worked as a volunteer in an old people's home.*
                        - *I helped to clean up their rooms and washed their clothes.*
                        - *We told jokes to cheer them up.*
                        - *I learned that helping others is helping ourselves.*

                        #### 3. 满分范文
                        **A Meaningful Weekend**
                        
                        Last Saturday, I went to an old people's home with my classmates. We worked as volunteers there. 
                        
                        First, we helped to clean up the yard and wash the windows. Then, we gave out some gifts to the old people. Some of them were lonely, so we talked with them and read newspapers to them. We also told funny stories to cheer them up. They were very happy. 
                        
                        Although I was tired, I felt very proud. I think volunteering is a great way to make a difference in our community. Helping others brings me a lot of joy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u3", "Unit 3", "Could you please clean your room?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 家庭分工与规矩。
                        *   **深层意义**：本单元围绕“家务劳动与请求允许”展开。旨在引导学生理解家务劳动是每个家庭成员的共同责任。通过学习委婉请求和许可的表达方式，培养学生在家庭内部礼貌沟通、相互体谅的习惯，树立劳动光荣的价值观。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **家务劳动**：rubbish (垃圾), fold (折叠), sweep (扫), floor (地板), mess (杂乱), shirt (衬衫)。
                        - **动词**：pass (给/递), borrow (借入), lend (借出), hate (讨厌), drop (落下), throw (扔)。
                        - **形容词/副词**：fair (公平的), unfair (不公平的), neither (也不), ill (生病的)。
                        - **名词**：finger (手指), chore (杂务/家务), stress (精神压力), independent (独立的)。

                        ### 2. 核心短语金牌储备
                        - `do the dishes` 洗餐具
                        - `take out the rubbish` 倒垃圾
                        - `fold your clothes` 叠衣服
                        - `sweep the floor` 扫地
                        - `make your bed` 整理床铺
                        - `hang out` 闲逛
                        - `pass sb. sth.` 把某物递给某人
                        - `in order to` 为了
                        - `depend on` 依靠；依赖
                        - `take care of` 照顾；处理
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Could you please clean your room? (你能打扫一下你的房间吗？)
                        - **【考点详解】**：`Could you please (not) do sth.?` 是非常委婉的请求句型。后接动词原形。
                        - **【回答方式】**：`Yes, sure. / No problem.` 或 `Sorry, I can't. I have to...`。
                        
                        #### 2. Could I borrow that book? (我能借那本书吗？)
                        - **【结构剖析】**：`Could I...?` 用于请求许可。注意 `borrow` (借入) 和 `lend` (借出) 的区别。
                        
                        #### 3. It's not fair! (这不公平！)
                        - **【用法拓展】**：表达对分配不均的不满。反义词为 `fair`。
                        
                        #### 4. The earlier kids learn to be independent, the better it is for their future. (孩子们越早学会独立，对他们的未来就越好。)
                        - **【句式金牌】**：`The + 比较级..., the + 比较级...` 表示“越...，就越...”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：情态动词 Could 表委婉请求与许可
                        **1. Could you please...?** (请求别人做某事)
                        - 此处 could 不是过去式，而是表示**委婉、客气**的语气。
                        - 否定形式：`Could you please NOT do sth.?`
                        
                        **2. Could I...?** (请求允许自己做某事)
                        - 回答时为了表明态度明确，通常不用 could，而用 can 或 may。
                        - *— Could I watch TV? — Yes, you **can**. / No, you **can't**.*

                        ### 核心语法二：borrow, lend, keep 辨析
                        - **borrow** (借入)：指把东西从别人那里借来。`borrow sth. from sb.` (瞬间动词)。
                        - **lend** (借出)：指把东西借给别人。`lend sth. to sb.` (瞬间动词)。
                        - **keep** (保存/借了)：表示借用的状态，可与表示时间段的状语连用。*You can keep the book for two weeks.*

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— ________ you please turn down the radio? The baby is sleeping.*
                        A. Must   B. Need   C. Could   D. Should
                        
                        **[解析]**：委婉地请求对方做某事，用 Could you please，选 **C**。

                        *(2023·北京中考)* *— How long can I ________ this book? — For a week.*
                        A. borrow   B. lend   C. keep   D. buy
                        
                        **[解析]**：与时间段 For a week 连用，必须用延续性动词 keep，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：谈论做家务的看法 (Doing Chores)
                        #### 1. 写作逻辑
                        - **引入观点**：Should kids do chores at home? (提出自己的立场)。
                        - **阐述理由**：First... Second... (如：培养独立性、帮助父母分担)。
                        - **自身经历**：I often help my parents do...
                        - **总结升华**：Doing chores is good for our future.

                        #### 2. 高分句式
                        - *In my opinion, teenagers should help their parents do chores.*
                        - *Parents are tired after working all day, so we should share the housework.*
                        - *By doing chores, we can learn to take care of ourselves.*
                        - *The more we do, the more independent we will be.*

                        #### 3. 满分范文
                        **Should Kids Do Chores?**
                        
                        Some parents think kids should just focus on their studies. But in my opinion, it is very important for kids to do chores at home. 
                        
                        First, our parents are very busy and tired after working all day. We are members of the family, so we should help them share the housework. Second, doing chores can help us develop good habits. The earlier we learn to do chores, the more independent we will be. For example, I always sweep the floor and take out the rubbish after dinner. It doesn't take much time. 
                        
                        In a word, doing chores is not only a duty, but also a good way to prepare for our future life.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u4", "Unit 4", "Why don't you talk to your parents?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 心理健康与人际沟通。
                        *   **深层意义**：本单元围绕“青少年的烦恼与建议”展开。旨在引导学生正视成长过程中的压力（如学业压力、同伴关系），学会用英语倾诉烦恼，并运用恰当的句型向他人提出建设性建议。通过沟通，培养学生积极乐观的心态和解决冲突的能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **情绪名词**：pressure (压力), relation (关系), communication (交流), fear (害怕)。
                        - **动词**：allow (允许), guess (猜测), copy (抄袭), return (归还), drop (落下), compare (比较), push (推/逼迫)。
                        - **形容词**：crazy (疯狂的), typical (典型的), clear (清楚的), proper (恰当的)。
                        - **其他**：wrong (错误的), instead (代替), whatever (任何)。

                        ### 2. 核心短语金牌储备
                        - `allow sb. to do sth.` 允许某人做某事
                        - `get into a fight with sb.` 和某人打架
                        - `look through` 快速查看；浏览
                        - `work out` 成功地发展；解决
                        - `get on well with sb.` 和某人相处融洽
                        - `communicate with` 与...交流
                        - `compare ... with ...` 比较...与...
                        - `instead of` 代替；反而
                        - `in one's opinion` 依...看
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Why don't you talk to your parents? (你为什么不和父母谈谈呢？)
                        - **【考点详解】**：`Why don't you do sth.?` 是提出建议的句型。相当于 `Why not do sth.?`
                        
                        #### 2. What's wrong? (怎么了？)
                        - **【情景交际】**：询问对方遇到了什么麻烦或问题。
                        
                        #### 3. He refused to let me watch my favorite TV show. (他拒绝让我看我最喜欢的电视节目。)
                        - **【结构剖析】**：`refuse to do sth.` 拒绝做某事。`let sb. do sth.` 让某人做某事（省略to的不定式作宾补）。
                        
                        #### 4. It's time to learn how to relax. (是时候学习如何放松了。)
                        - **【语法核心】**：`It's time to do sth.` = `It's time for (doing) sth.` 到了做某事的时间了。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：提出建议的句型汇总 (必考)
                        1.  `Why don't you + 动词原形?` = `Why not + 动词原形?`
                        2.  `You should / shouldn't + 动词原形.`
                        3.  `How about / What about + 动词-ing?`
                        4.  `Let's + 动词原形.`
                        5.  `It's a good idea to do sth.`

                        ### 核心语法二：until 与 so that 引导的状语从句
                        - **until (直到...为止)**：
                          肯定句中，主句谓语必须是**延续性动词**：*I waited until he came back.*
                          否定句中 `not... until` (直到...才)，谓语常是瞬间动词：*I didn't go to bed until 11:00.*
                        - **so that (以便；为了)**：引导目的状语从句，从句常包含 can/could/may 等情态动词。*Speak louder so that everyone can hear you.*

                        ### 中考真题特训
                        
                        *(2024·江苏中考)* *You look tired. ________ taking a rest?*
                        A. Why not   B. How about   C. Why don't you   D. Let's
                        
                        **[解析]**：后面接的是 taking (v.-ing)，只有 How/What about 符合，选 **B**。

                        *(2023·北京中考)* *My father didn't buy me the computer ________ I promised to get good grades.*
                        A. because   B. if   C. until   D. since
                        
                        **[解析]**：固定句型 not... until (直到...才)，“直到我保证取得好成绩，爸爸才给我买电脑”，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：回信解忧 (Replying to an Agony Aunt Letter)
                        #### 1. 写作逻辑
                        - **共情与安慰**：I know how you feel. / It's normal to have these feelings.
                        - **分析原因**：Maybe your parents are just worried about you.
                        - **给出具体建议**：Why don't you...? / You should... / How about...?
                        - **鼓励**：I hope things will work out soon.

                        #### 2. 高分句式
                        - *It's normal for teenagers to feel stressed out.*
                        - *Why don't you sit down and communicate with them?*
                        - *Instead of getting angry, you should tell them your true feelings.*
                        - *I believe they will understand you if you talk to them patiently.*

                        #### 3. 满分范文
                        **A Letter to a Troubled Friend**
                        
                        Dear Peter,
                        I'm sorry to hear that you have problems with your parents. It's normal for teenagers to get into fights with their parents. Don't worry too much.
                        
                        First, why don't you talk to your parents? Communication is the best way to solve problems. You should tell them your true feelings patiently. Second, instead of getting angry, you could try to understand them. They push you hard because they love you and want you to have a good future. Third, how about writing a letter to them if you can't speak face to face? 
                        
                        I hope my advice can help you. Things will work out soon.
                        Yours,
                        Li Hua
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u5", "Unit 5", "What were you doing when the rainstorm came?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自然/社会 —— 突发事件与难忘时刻。
                        *   **深层意义**：本单元围绕“重大历史事件或突发自然灾害发生时的个人状态”展开（如暴雨、马丁·路德·金遇刺、911事件）。通过学习过去进行时，引导学生学会将个人生活与社会历史事件联系起来，理解历史的瞬间如何定格在普通人的记忆中，培养面对突发事件的心理素质。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **自然与灾害**：rainstorm (暴风雨), wind (风), light (光), icy (冰冷的), shock (震惊)。
                        - **动作与状态**：beat (敲打), fall (倒下), report (报道), realize (意识到), wait (等待), wake (醒)。
                        - **时间与事件**：recently (最近), date (日期), event (事件), silence (沉默)。
                        - **其他**：heavily (沉重地), suddenly (突然地), truth (真相), completely (完全地)。

                        ### 2. 核心短语金牌储备
                        - `go off` (闹钟) 发出响声
                        - `pick up` 接电话；捡起
                        - `fall asleep` 入睡
                        - `die down` 逐渐变弱；平息
                        - `make one's way to` 艰难地走向...
                        - `in silence` 沉默地
                        - `take down` 拆除；记录
                        - `at first` 首先；起初
                        - `have meaning to` 对...有意义
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What were you doing when the rainstorm came? (暴风雨来临时你在做什么？)
                        - **【考点详解】**：`when` 引导的时间状语从句用了一般过去时(came)，主句表示在那一特定瞬间正在进行的动作，用过去进行时(were doing)。
                        
                        #### 2. While Linda was sleeping, Jenny was helping Mary with her homework. (当琳达在睡觉的时候，珍妮正在辅导玛丽做作业。)
                        - **【结构剖析】**：`while` 引导的从句通常使用进行时，表示两个动作在过去同一时段同时发生。
                        
                        #### 3. I called at seven and you didn't pick up. (我七点打的电话，你没接。)
                        - **【词法精辨】**：`pick up` 在此处特指“接电话”。
                        
                        #### 4. Although he was young, he was brave enough to face the danger. (虽然他很年轻，但他足够勇敢去面对危险。)
                        - **【语法核心】**：`although` 引导让步状语从句。注意：英语中 although 不能和 but 连用！
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：过去进行时 (Past Continuous Tense)
                        **1. 功能**：表示在过去某一时刻或某一时间段内正在进行的动作。
                        **2. 构成**：`was / were + 动词的现在分词 (v.-ing)`。
                        **3. 标志词**：`at 8:00 last night`, `at that time`, `when/while引导的特定从句`。

                        ### When 与 While 的巅峰对决 (必考重灾区)
                        - **when**：意为“当...时”，后接**短暂性动词**或**延续性动词**。
                          *句型*：`主句(过去进行时) + when + 从句(一般过去时)`。
                          *(I was reading when the telephone rang.)*
                        - **while**：意为“在...期间”，后必须接**延续性动词**。
                          *句型*：`主句(一般过去时) + while + 从句(过去进行时)`。
                          *(The telephone rang while I was reading.)*
                          或者两个动作同时进行：`主句(过去进行时) + while + 从句(过去进行时)`。

                        ### 中考真题特训
                        
                        *(2024·安徽中考)* *I ________ a book in the library when the rainstorm started.*
                        A. read   B. was reading   C. am reading   D. will read
                        
                        **[解析]**：when 引导的从句是一般过去时，主句表示在暴雨开始的那一瞬间正在发生的事，用过去进行时，选 **B**。

                        *(2023·广东中考)* *My mother was cooking dinner ________ I was doing my homework.*
                        A. when   B. while   C. until   D. since
                        
                        **[解析]**：主句和从句都是过去进行时，表示两个动作同时进行，用 while，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：一个难忘的事件/灾难经历 (An Unforgettable Event)
                        #### 1. 写作要素
                        - **事件背景**：When and where did it happen?
                        - **当时状态**：What were you doing when it happened? (使用过去进行时)。
                        - **事件经过**：描述突发情况及人们的反应。
                        - **事后感受**：How did you feel? What did you learn?

                        #### 2. 高分句式
                        - *I will never forget the terrible rainstorm last week.*
                        - *I was doing my homework when suddenly the lights went out.*
                        - *While the wind was blowing heavily, we stayed together in silence.*
                        - *Although we were scared, we helped each other.*

                        #### 3. 满分范文
                        **An Unforgettable Rainstorm**
                        
                        I will never forget the terrible rainstorm last week. 
                        
                        It happened at eight o'clock in the evening. At that time, my father was reading a newspaper on the sofa. My mother was doing the dishes in the kitchen. And I was doing my homework in my room. Suddenly, strong winds started to blow. Then it rained heavily. While we were listening to the rain, the lights went out. We were a little scared. My father quickly found some candles and lit them. We sat together in the living room and played some games to relax. 
                        
                        The storm died down late at night. Although the storm was terrible, it brought my family closer together.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u6", "Unit 6", "An old man tried to move the mountains.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 历史、社会与文化（中外神话与传说）。
                        *   **深层意义**：本单元聚焦于中西方经典故事（如《愚公移山》、《西游记》、《糖果屋》、《睡美人》）。旨在引导学生学会用英语复述故事，感悟故事背后的文化内涵和传统美德（如坚持不懈、惩恶扬善）。通过对比中西文学作品，增强文化自信并提升跨文化交际能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **故事角色**：god (神), monkey (猴子), emperor (皇帝), tailor (裁缝), woodcutter (伐木工), stepmother (继母), prince (王子)。
                        - **动作与情节**：remind (提醒), hide (隐藏), magic (魔术的), weak (虚弱的), lead (领导), marry (结婚)。
                        - **物品与状态**：stone (石头), silk (丝绸), gold (黄金), brave (勇敢的), stupid (愚蠢的), whole (整个的)。
                        - **其他名词**：object (物体), ground (地面), husband (丈夫), scene (场景)。

                        ### 2. 核心短语金牌储备
                        - `move the mountains` 移山
                        - `work on` 从事；忙于
                        - `remind sb. of sth.` 提醒某人某事
                        - `a little bit` 有一点儿
                        - `give up` 放弃
                        - `instead of` 代替；反而
                        - `turn ... into ...` 把...变成...
                        - `get married` 结婚
                        - `keep doing sth.` 坚持做某事
                        - `as soon as` 一...就...
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. An old man tried to move the mountains. (一个老人尝试移走大山。)
                        - **【考点详解】**：`try to do sth.` 努力做某事（强调尽力）。对比 `try doing sth.` 尝试做某事（看结果如何）。
                        
                        #### 2. He can make himself so small that he can sometimes keep the stick in his ear. (他能把自己变得那么小，以至于有时能把金箍棒藏在耳朵里。)
                        - **【结构剖析】**：`so ... that ...` 引导结果状语从句。`make + 宾语 + 宾补`。
                        
                        #### 3. Unless he can hide his tail, he cannot turn himself into a person. (除非他能藏住尾巴，否则他不能把自己变成人。)
                        - **【语法核心】**：`unless` 引导条件状语从句，相当于 `if ... not`。从句同样遵循“主将从现”或“主情从现”。
                        
                        #### 4. The stepmother planned to kill the children. (继母计划杀掉孩子们。)
                        - **【用法拓展】**：`plan to do sth.` 计划做某事。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：unless 引导的条件状语从句
                        **1. 含义**：意为“除非；如果不”。
                        **2. 用法**：`unless` = `if ... not`。
                        *   *I will go there **unless** it rains.* 
                        *   = *I will go there **if** it **doesn't** rain.*
                        **3. 时态原则**：遵循“主将从现”。

                        ### 核心语法二：so ... that ... 与 such ... that ...
                        - **so + adj./adv. + that**：*The movie was **so interesting that** I watched it twice.*
                        - **such + (a/an) + (adj.) + 名词 + that**：*It was **such an interesting movie that** I watched it twice.*
                        - **注意**：如果名词前有 many, much, few, little 等词，必须用 **so**。 (*so many people*)

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *You will fail the exam ________ you work hard.*
                        A. if   B. although   C. because   D. unless
                        
                        **[解析]**：根据逻辑，“除非你努力，否则你会考试不及格”，选 **D**。

                        *(2023·河北中考)* *The music is ________ sweet ________ I want to listen to it again.*
                        A. so; that   B. such; that   C. very; that   D. too; to
                        
                        **[解析]**：sweet 是形容词，用 so ... that 结构，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：讲一个你最喜欢的故事 (My Favorite Story)
                        #### 1. 写作要素
                        - **介绍背景**：Once upon a time... / Long long ago...
                        - **主要情节**：起因 -> 经过 (First, then, suddenly) -> 结果。
                        - **个人评价**：I like the story because... / It teaches us that...

                        #### 2. 高分句式
                        - *Long long ago, there was a man named...*
                        - *He was so brave that he could fight against monsters.*
                        - *Although the work was difficult, he never gave up.*
                        - *As soon as the prince saw her, he fell in love.*

                        #### 3. 满分范文
                        **The Story of Yu Gong**
                        
                        My favorite Chinese story is "Yu Gong Moves the Mountains". Long ago, there was an old man called Yu Gong. There were two big mountains in front of his house. It was difficult for his family to get out. 
                        
                        So Yu Gong decided to move the mountains. Some people laughed at him and said he was stupid. But Yu Gong said, "When I die, my children can keep doing it. Then their children and grandchildren can continue." God was so moved by Yu Gong that he helped move the mountains. 
                        
                        I like this story because it tells us that if we keep working hard and never give up, everything is possible.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u7", "Unit 7", "What's the highest mountain in the world?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自然 —— 自然地理与环境保护。
                        *   **深层意义**：本单元围绕“地理之最”展开（如珠穆朗玛峰、长江、里海）。通过学习形容词、副词最高级的进阶用法及大额数字的读法，引导学生认识自然界的伟大与壮丽。同时，通过介绍大熊猫保护，唤起学生的生态责任感，思考人类该如何与自然和谐共处。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **地理名词**：mountain (山), ocean (海洋), desert (沙漠), forest (森林), river (河流), population (人口)。
                        - **度量衡**：meter (米), kilometer (千米), square (平方的), deep (深的), wide (宽的), thick (厚的)。
                        - **动物保护**：panda (熊猫), bamboo (竹子), adult (成年人), research (研究), endangered (濒危的), protect (保护)。
                        - **形容词最高级核心**：highest, longest, deepest, biggest。

                        ### 2. 核心短语金牌储备
                        - `in the world` 在世界上
                        - `as far as I know` 据我所知
                        - `feel free to do sth.` 随便做某事
                        - `take in` 吸入；吞入
                        - `run out of` 用完
                        - `cut down` 砍倒
                        - `in danger` 处于危险中
                        - `up to` 到达；多达
                        - `prepare for` 为...做准备
                        - `the size of` ...的大小
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What's the highest mountain in the world? (世界上最高的山是什么？)
                        - **【考点详解】**：形容词最高级最高级前必须加 `the`。
                        
                        #### 2. Qomolangma is 8,848.86 meters high. (珠穆朗玛峰高8848.86米。)
                        - **【结构剖析】**：`数量词 + 单位名词 + 形容词(high/wide/deep等)` 表示长度、高度、宽度等。
                        
                        #### 3. China has the largest population in the world. (中国拥有世界上最多的人口。)
                        - **【词法精辨】**：`population` 常与 `large/small` 连用，不能用 many/few。
                        
                        #### 4. One of the main reasons is that humans are cutting down the forests. (主要原因之一是人类正在砍伐森林。)
                        - **【句式金牌】**：`One of the + 形容词最高级 + 名词复数`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：形容词最高级的进阶用法
                        1.  **the + 最高级 + 比较范围**：*The Nile is **the longest river** in Africa.*
                        2.  **one of the + 最高级 + 名词复数**：*He is **one of the tallest boys** in our class.*
                        3.  **第几个最高级**：`the + 序数词 + 最高级 + 名词`。*The Yellow River is **the second longest river** in China.*

                        ### 核心语法二：大额数字的表达
                        - 英语中没有“万”和“亿”的直接单词。
                        - 10,000 -> *ten thousand*
                        - 100,000,000 -> *one hundred million*
                        - **注意**：hundred, thousand, million 前面有数字时，**不加 -s**。

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *Mount Qomolangma is ________ than any other mountain in the world.*
                        A. high   B. higher   C. highest   D. the highest
                        
                        **[解析]**：比较级 + than any other + 名词单数 = 最高级含义。选 **B**。

                        *(2023·上海中考)* *About ________ students in our school like playing basketball.*
                        A. two hundreds   B. two hundred   C. two hundred of   D. hundreds of
                        
                        **[解析]**：数词+hundred不加s，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍一个著名的自然景观 (A Natural Wonder)
                        #### 1. 写作逻辑
                        - **概况**：地点、高度、宽度等数据。
                        - **特征**：为什么出名？风景如何？
                        - **现状与保护**：是否面临危险？我们该怎么做？

                        #### 2. 高分句式
                        - *The Yangtze River is the longest river in China.*
                        - *It is over 6,300 kilometers long.*
                        - *Many tourists come to visit it every year.*
                        - *We must do something to protect our mother river.*

                        #### 3. 满分范文
                        **The Giant Panda**
                        
                        The giant panda is one of the most famous animals in the world. It is also a symbol of China. 
                        
                        Pandas are black and white. An adult panda can be 1.5 meters long and weigh up to 100 kilos. They live in the forests of Sichuan and mainly eat bamboo. However, pandas are in danger now. One reason is that people are cutting down bamboo forests. There isn't enough food for them. 
                        
                        The Chinese government is setting up more nature reserves to save them. As students, we should also try our best to protect pandas and their homes.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u8", "Unit 8", "Have you read Treasure Island yet?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活与学习（文学与音乐）。
                        *   **深层意义**：本单元引入了初中最重要的时态 —— 现在完成时。通过讨论经典文学作品（如《金银岛》、《小妇人》、《鲁滨逊漂流记》）和现代音乐（如Country Music），引导学生学会分享个人经历和感悟。培养学生的阅读兴趣和审美情操，理解经典艺术对现代生活的持续影响。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **文学体词**：treasure (珠宝), island (岛), classic (经典), fiction (小说), biography (传记)。
                        - **音乐元素**：pop (流行音乐), rock (摇滚乐), country music (乡村音乐), fan (狂热仰慕者), record (唱片), melody (曲调)。
                        - **标志性副词**：yet (还/已经), already (已经), ever (曾经), never (从不), since (自...以来), for (持续)。
                        - **动词**：belong (属于), mark (做标记), introduce (介绍), laugh (笑)。

                        ### 2. 核心短语金牌储备
                        - `full of` 充满
                        - `hurry up` 赶快
                        - `classic literature` 经典文学
                        - `belong to` 属于 (**必考：无进行时和被动语态**)
                        - `at least` 至少
                        - `ever since` 自从
                        - `one another` 互相
                        - `think about` 考虑；思考
                        - `come home` 回家
                        - `used to do sth.` 过去常常做某事
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Have you read Treasure Island yet? (你读过《金银岛》了吗？)
                        - **【考点详解】**：现在完成时的一般疑问句。`yet` 常用于否定句或疑问句末尾。
                        
                        #### 2. I have already finished my homework. (我已经完成了作业。)
                        - **【结构剖析】**：`already` 常用于现在完成时的肯定句中，置于助动词 have/has 之后。
                        
                        #### 3. That book belongs to me. (那本书属于我。)
                        - **【词法精辨】**：`belong to` 的主语通常是物，不能说 *I am belonged to...*。
                        
                        #### 4. Country music reminds me of my hometown. (乡村音乐使我想起家乡。)
                        - **【语法核心】**：`remind sb. of sth.` 使某人想起某事。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：现在完成时 (I)
                        **1. 概念**：表示过去发生的动作对现在产生的影响或结果。
                        **2. 构成**：`have / has + 过去分词 (v.-ed)`。
                        **3. 标志词**：`already` (肯定), `yet` (疑/否), `ever`, `never`, `before`, `just`。
                        **4. have been to vs have gone to**：
                        - `have been to`：去过某地（已回来）。
                        - `have gone to`：去了某地（还没回来）。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *— Have you seen the movie yet? — Yes, I ________ it yesterday.*
                        A. see   B. saw   C. have seen   D. will see
                        
                        **[解析]**：虽然问句是完成时，但答句有明确的过去时间 yesterday，必须用一般过去时，选 **B**。

                        *(2023·北京中考)* *— Where is Linda? — She ________ to the library. She will be back in an hour.*
                        A. has been   B. has gone   C. went   D. goes
                        
                        **[解析]**：根据“一小时后回来”可知人还没回来，用 has gone to，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我最喜欢的书/音乐 (My Favorite Book / Singer)
                        #### 1. 写作要点
                        - **基本信息**：书名、作者或歌手名。
                        - **主要内容/经历**：你什么时候读/听的？（使用现在完成时）。
                        - **推荐理由**：为什么喜欢？它对你有什么影响？

                        #### 2. 高分句式
                        - *I have read many books, but my favorite is...*
                        - *It was written by...*
                        - *The book is so interesting that I can't put it down.*
                        - *I have learned that we should be brave from the story.*

                        #### 3. 满分范文
                        **My Favorite Book**
                        
                        I am a book lover. I have read many classics, but my favorite is "Robinson Crusoe". 
                        
                        I have read it three times. It tells a story about a man named Robinson who lived on an island for 28 years after his ship broke. Robinson was very brave and smart. He built a house and even found a friend called Friday. 
                        
                        From this book, I have learned that we should never give up when we are in trouble. It has made me a stronger person. I think everyone should read it.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u9", "Unit 9", "Have you ever been to a museum?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 旅游与文娱（有趣的地点）。
                        *   **深层意义**：本单元继续深化现在完成时的学习，聚焦“旅游经历”。通过介绍各种特色博物馆（如电影博物馆、太空博物馆）及异国风情（如新加坡），引导学生学会分享人生体验。培养学生的求知欲和跨文化视野，理解旅游不仅是消遣，更是学习和成长的过程。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **场所名词**：museum (博物馆), amusement park (游乐场), planetarium (天文馆), zoo (动物园), camera (照相机)。
                        - **动词**：invent (发明), discover (发现), encourage (鼓励), collect (收集), improve (提高)。
                        - **形容词/副词**：unusual (特别的), social (社会的), peaceful (和平的), rapid (快速的)。
                        - **其他**：invention (发明物), whether (是否), tea set (茶具)。

                        ### 核心短语金牌储备
                        - `have been to` 去过某地
                        - `amusement park` 游乐场
                        - `on the one hand ... on the other hand` 一方面...另一方面
                        - `in a rapid way` 快速地
                        - `encourage sb. to do sth.` 鼓励某人做某事
                        - `all year round` 全年
                        - `be close to` 靠近
                        - `a couple of` 一些；几个
                        - `whether ... or ...` 不管...还是...
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Have you ever been to a science museum? (你曾经去过科学博物馆吗？)
                        - **【考点详解】**：`ever` 用于完成时的疑问句中，表示“曾经”。
                        
                        #### 2. I've never been to a water park. (我从没去过水上公园。)
                        - **【结构剖析】**：`never` 表示否定。
                        
                        #### 3. It's a great way to spend Saturday afternoon. (那是度过周六下午的好方式。)
                        - **【句式金牌】**：`It's a great way to do sth.` 做某事的好方法。
                        
                        #### 4. The museum has been around for 20 years. (这座博物馆已经存在20年了。)
                        - **【语法核心】**：现在完成时与 `for + 时间段` 连用，谓语必须使用**延续性动词**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：现在完成时 (II) - 延续性动词
                        **1. 瞬间动词与延续性动词的转换 (必考)**：
                        在现在完成时中，若有 `since + 时间点` 或 `for + 时间段`，谓语动词必须是延续性的。
                        - *buy -> have had*
                        - *borrow -> have kept*
                        - *join -> have been in*
                        - *die -> have been dead*
                        - *leave -> have been away*
                        - *begin -> have been on*

                        ### 中考真题特训
                        
                        *(2024·四川中考)* *I ________ this bike for three years. It's still in good condition.*
                        A. bought   B. have bought   C. have had   D. buy
                        
                        **[解析]**：for three years 是时间段，谓语动词必须延续，buy 是瞬间动词，需改为 have had，选 **C**。

                        *(2023·广东中考)* *— How long have you ________ members of the club? — Since last year.*
                        A. become   B. became   C. been   D. joined
                        
                        **[解析]**：How long 与 since 连用，选延续性动词 been，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍一个你去过的地方 (A Place I Have Been To)
                        #### 1. 写作要点
                        - **开头**：点明地点 (I have been to... before.)。
                        - **内容**：描述那里的特色（风景、食物、文化）。
                        - **经历**：你在那里做了什么？（使用完成时和过去时交替）。
                        - **评价**：为什么推荐这个地方？

                        #### 2. 高分句式
                        - *Among all the places I've been to, ... is the most interesting.*
                        - *On the one hand, it is modern; on the other hand, it has many old buildings.*
                        - *I have never seen such beautiful scenery before.*
                        - *If you have time, you should visit it.*

                        #### 3. 满分范文
                        **A Trip to Singapore**
                        
                        I have been to many places, but the most special one is Singapore. 
                        
                        Singapore is a small country in Southeast Asia. It is called the "Garden City". I went there last summer vacation with my parents. On the one hand, Singapore is a very clean and safe place. On the other hand, it is a multicultural country. You can try food from different countries, like China and India. 
                        
                        I have seen the famous Merlion and visited the Night Safari. It was an amazing experience. I look forward to going there again.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u10", "Unit 10", "I've had this bike for three years.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 生活中的物品（怀旧与分享）。
                        *   **深层意义**：本单元围绕“旧物义卖（Yard Sale）”展开。通过学习现在完成时表达“拥有某物的时间”，引导学生反思物品的价值及其中蕴含的情感（如儿时的玩具、旧自行车）。培养学生节约资源、珍惜情感以及乐于分享、参与公益活动的优良品质。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **物品名词**：bicycle (自行车), doll (洋娃娃), scarf (围巾), board game (棋类游戏), toy (玩具)。
                        - **动词/分词**：own (拥有), check (检查), search (搜寻), cleared (清除了的), parted (分开了的)。
                        - **抽象名词**：shame (羞耻/遗憾), memory (记忆), century (世纪), truth (真相)。
                        - **其他**：soft (软的), honest (诚实的), especially (尤其)。

                        ### 2. 核心短语金牌储备
                        - `yard sale` 庭院拍卖会
                        - `give away` 赠送；分发
                        - `check out` 察看；观察
                        - `clear out` 清理；丢弃
                        - `no longer` 不再
                        - `part with` 与...分开；舍弃
                        - `as for` 至于；关于
                        - `to be honest` 老实说
                        - `close to` 接近；靠近
                        - `search for` 搜寻
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I've had this bike for three years. (我买这辆自行车已经三年了。)
                        - **【考点详解】**：`have had` 是完成时延续性用法。
                        
                        #### 2. How long have you had that toy bear? (你买那个玩具熊多久了？)
                        - **【结构剖析】**：`How long` 引导的现在完成时特殊疑问句，谓语动词必须延续。
                        
                        #### 3. It's a shame, but I don't use it anymore. (很遗憾，但我不再用它了。)
                        - **【词法精辨】**：`It's a shame` 常用于口语，意为“真遗憾”。
                        
                        #### 4. To be honest, I've not played it for a long time. (老实说，我很久没玩它了。)
                        - **【用法拓展】**：`To be honest` 作插入语，使表达更地道。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：现在完成时 (III) - since 与 for
                        **1. for + 时间段**：表示动作持续了多久。 (*for 5 years*)
                        **2. since + 时间点**：表示动作自何时开始。 (*since 2010*)
                        **3. since + 一般过去时的从句**：*I have lived here **since I was born**.*
                        **4. 提问方式**：统一用 `How long`。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *My uncle ________ in this city for over twenty years.*
                        A. lives   B. is living   C. has lived   D. lived
                        
                        **[解析]**：for + 时间段，用现在完成时，选 **C**。

                        *(2023·河北中考)* *— How long ________ you ________ your English teacher? — Since I came to this school.*
                        A. do; know   B. did; know   C. have; known   D. will; know
                        
                        **[解析]**：since 引导从句提示用完成时，know 的过去分词是 known，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍你最珍爱的一件旧物 (A Childhood Possession)
                        #### 1. 写作逻辑
                        - **是什么**：What is it?
                        - **来源与时间**：Who gave it to you? How long have you had it?
                        - **故事与情感**：它带给你什么记忆？为什么珍贵？
                        - **现状**：你会保留它还是捐出去？

                        #### 2. 高分句式
                        - *I have a special possession. It is a...*
                        - *My grandfather gave it to me when I was six.*
                        - *I have had it for eight years.*
                        - *Every time I see it, I think of my happy childhood.*

                        #### 3. 满分范文
                        **My Favorite Old Toy**
                        
                        I have a lot of toys, but my favorite is a small toy car. It was a birthday gift from my father when I was seven years old. 
                        
                        I have had this toy car for seven years. It is blue and still looks new because I have taken good care of it. When I was young, I used to play with it every day. Now I am a middle school student and I am very busy, so I don't play with it anymore. However, I will never give it away. It has many happy memories of my childhood. Every time I see it, I feel very warm. It is more than just a toy to me.
                    """.trimIndent())
                )
            )
        )
    )
}
