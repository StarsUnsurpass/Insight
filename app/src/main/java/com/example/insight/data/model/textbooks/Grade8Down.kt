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
        coverColor = Color(0xFFFFF3E0),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc8x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g8down_u1", "Unit 1", "What's the matter?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：健康与安全 (Health and safety)
                        *   **子主题**：身体不适描述，医疗救助，急救常识 (Describing illness)。

                        ### 2. 单元主题内容
                        本单元以“健康与急救”为核心，重点学习描述身体各种不适（如 stomachache, backache, fever 等）以及如何针对这些症状给出合理的医疗建议（should/shouldn't）。单元还引入了公交司机救人等英雄事迹，引导学生关注社会互助，学习在突发状况下如何冷静救人，培养其人文关怀精神和基本的急救常识。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **身体部位**：stomach, back, neck, throat, foot, knee.
                        - **病症描述**：stomachache, backache, headache, fever, cough, sore throat.
                        - **急救行为**：lie down, take one's temperature, see a dentist, put some medicine on.
                        - **高频短语**：What's the matter? (怎么了?), have a cold (感冒), run out of (用完), cut oneself (割伤自己).

                        ### 2. 核心句式
                        1.  **询问病情**：What's the matter? / What's the trouble?
                        2.  **描述病情**：I have a sore throat. / My head hurts.
                        3.  **给出建议**：You should lie down and rest. / You shouldn't eat anything.
                        4.  **因果链接**：He was so surprised that he couldn't say a word.

                        ### 3. 重点语法
                        - **should/shouldn't** 表示建议。
                        - **reflexive pronouns** (反身代词) 的基本用法。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mom**: What's the matter, Peter?
                        
                        **Peter**: I have a stomachache. 
                        
                        **Mom**: Maybe you ate too much junk food. You should lie down and rest. 
                        
                        **Peter**: I think I should see a doctor. 
                        
                        **Mom**: OK. Let's go to the hospital.

                        **【译文】**
                        
                        **妈妈**：怎么了，彼得？
                        
                        **彼得**：我胃痛。
                        
                        **妈妈**：也许你吃了太多垃圾食品。你应该躺下休息。
                        
                        **彼得**：我觉得我应该去看医生。
                        
                        **妈妈**：好的。我们去医院吧。

                        ### Section B (Reading) 阅读文段：Bus Driver Saves Old Man
                        **【原文】**
                        
                        At 9:00 a.m. yesterday, bus driver Wang Ping was driving on Zhongshan Road. Suddenly, he saw an old man lying on the side of the road. Wang Ping stopped the bus and ran to help him. Many passengers thought he should not help, but he didn't listen. He sent the man to the hospital. Thanks to Wang Ping, the old man was saved.

                        **【译文】**
                        
                        昨天上午9点，公交司机王平正开车行驶在中山路上。突然，他看到一位老人躺在路边。王平停下车跑过去帮忙。许多乘客认为他不该帮忙，但他没听。他把老人送到了医院。多亏了王平，老人获救了。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① what's the matter? (怎么了?)
                        - **【用法拓展】**：后接 with sb. 表示“某人怎么了？”。
                        - **【同义转换】**：`What's wrong?`
                        
                        #### ② give up (放弃)
                        - **【注意】**：`give up doing sth.` 放弃做某事。
                        - **【例题】**：
                        
                        *You should never ________ your dreams.*
                        A. give up   B. give out   C. give in   D. give away
                        
                        **[解析]**：不放弃梦想，选 **A**。

                        #### ③ run out of (用完; 耗尽)
                        - **【注意】**：主语通常是人。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：should 与 反身代词
                        **1. should 的委婉建议**
                        - 肯定：should + 动词原形.
                        - 否定：shouldn't + 动词原形.
                        
                        **2. 反身代词 (Reflexive Pronouns)**
                        myself, yourself, himself, herself, itself, ourselves, yourselves, themselves.
                        - *I cut myself.* (我割伤了自己)

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *You ________ look after yourself when your parents are not at home.*
                        A. may   B. can   C. should   D. would
                        
                        **[解析]**：表示你应该照顾好自己，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Giving Health Advice (给出健康建议)
                        **Dear Friend,**
                        
                        I'm sorry to hear that you **have a cold**. To get better soon, you **should drink** more water. You **shouldn't study** too late at night. It's important to **lie down and rest**. I hope you will **be better** soon. 
                        
                        Best wishes!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u2", "Unit 2", "I'll help to clean up the city parks.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：社会服务与人际沟通 (Social service)
                        *   **子主题**：志愿者工作，慈善事业，奉献与关爱 (Volunteering)。

                        ### 2. 单元主题内容
                        本单元以“志愿者活动”为中心，重点学习动词短语的分类与用法。学生通过了解在公园、养老院、医院等地的志愿者工作，学会表达如何通过自己的行动去帮助他人。单元强调“小善举大爱心”，通过讲述为盲人导盲犬筹款等感人故事，培养学生的社会责任感和奉献精神。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **动词短语**：clean up (打扫), cheer up (使高兴), give out (分发), set up (建立), work out (制定).
                        - **核心名词**：volunteer (志愿者), notice (通知), sign (标志), repair (修理), blindness (盲).
                        - **高频短语**：hand out, call up, put off (推迟), make a difference (产生影响), take after (与...相像).

                        ### 2. 核心句式
                        1.  **陈述意愿**：I'd like to help old people.
                        2.  **计划行动**：We are going to set up a food bank.
                        3.  **表达价值**：You could see the joy in their eyes.
                        4.  **呼吁捐赠**：You can help by giving money to the charity.

                        ### 3. 重点语法
                        - **动词短语的分类** (v. + adv. / v. + prep.)。
                        - **不定式 (to do)** 作目的状语。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Boy**: I'd like to help lonely old people. 
                        
                        **Girl**: You could help to clean up their houses. 
                        
                        **Boy**: That's a good idea. I can also cheer them up.
                        
                        **Girl**: We could give out notices to ask for more volunteers.
                        
                        **Boy**: OK. Let's do it this Saturday!

                        **【译文】**
                        
                        **男孩**：我想帮助那些孤独的老人。
                        
                        **女孩**：你可以帮他们打扫房子。
                        
                        **男孩**：那是个好主意。我也可以让他们高兴起来。
                        
                        **女孩**：我们可以发通知来招募更多的志愿者。
                        
                        **男孩**：好的。我们这周六就做吧！

                        ### Section B (Reading) 阅读文段：Animal Helpers
                        **【原文】**
                        
                        "Lucky" is a dog that helps people with disabilities. Ben Smith, the owner of Lucky, lost his sight after a car accident. He was very sad until Lucky came. Lucky was trained by a volunteer group. Now Lucky helps Ben with his daily life. Ben says Lucky has made a big difference to him.

                        **【译文】**
                        
                        “幸运”是一只帮助残疾人的狗。它的主人本·史密斯在一次车祸后失明了。在幸运到来之前，他非常难过。幸运是由一个志愿者组织培训的。现在幸运帮助本处理日常生活。本说幸运对他产生了巨大的影响。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① cheer up (振作起来; 使...高兴起来)
                        - **【用法】**：动副短语。名词放中间或后面，代词必须放中间。
                        - **【例题】**：
                        
                        *The funny story ________.*
                        A. cheered up him   B. cheered him up   C. cheer him up   D. cheered up he
                        
                        **[解析]**：代词 him 需放中间，选 **B**。

                        #### ② make a difference (产生影响; 起作用)
                        - **【搭配】**：`make a difference to sth.` 对某事产生影响。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：动词短语 (Phrasal Verbs)
                        **1. 动词 + 副词 (v. + adv.)**
                        - *clean up, put off, hand out*
                        - **口诀**：名词可内可外，代词必留内。
                        
                        **2. 动词 + 介词 (v. + prep.)**
                        - *look after, talk to, listen to*
                        - **口诀**：无论名代，统统放最后。

                        **3. 中考真题特训**
                        
                        *(2023·广东中考)* *Please ________ the TV. Your brother is sleeping.*
                        A. turn off   B. turn on   C. turn down   D. turn up
                        
                        **[解析]**：根据睡觉可知要“关掉”电视，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Being a Volunteer (成为一名志愿者)
                        **I want to be a volunteer at the city library.**
                        
                        I love reading and I want to **help others**. I can **hand out** books to children and **clean up** the reading rooms. I think **volunteering** can **make a big difference** to the society. It can also help me **learn new things**. Let's **join us** and be a volunteer!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u3", "Unit 3", "Could you please clean your room?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：家庭与家庭生活 (Family life)
                        *   **子主题**：家务劳动，礼貌请求，平衡责任 (Doing chores)。

                        ### 2. 单元主题内容
                        本单元以“家务劳动”为载体，重点学习如何使用 `Could you please...?` 发出礼貌的请求以及如何得体地回答。通过讨论孩子与父母之间关于家务的矛盾（如 Reading 中的 Mom's Strike），引导学生明白家庭成员应共同承担责任。单元旨在培养学生的自理能力和感恩之心，学会在沟通中达成共识。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **家务动词**：fold (折叠), sweep (扫), throw (扔), wash (洗), lend (借出), borrow (借入).
                        - **核心名词**：chore (家务), floor (地板), finger (手指), stress (压力), waste (浪费).
                        - **高频短语**：do chores, take out the rubbish (倒垃圾), make the bed, do the dishes (洗碗), in order to (为了).

                        ### 2. 核心句式
                        1.  **礼貌请求**：Could you please sweep the floor? — Yes, sure. / Sorry, I can't.
                        2.  **寻求许可**：Could I go to the movies? — Yes, you can. / No, you can't.
                        3.  **表达目的**：Children should learn to do chores in order to be independent.
                        4.  **描述不满**：I don't think it's fair.

                        ### 3. 重点语法
                        - **情态动词 could** 用于委婉语气。
                        - **in order to** 引导目的状语。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mom**: Could you please do the dishes, Tom?
                        
                        **Tom**: Yes, sure. I'll do them in a minute.
                        
                        **Mom**: And could you please take out the rubbish? 
                        
                        **Tom**: I'm sorry, Mom. I have to do my homework now. 
                        
                        **Mom**: Well, could you do it after you finish your homework?
                        
                        **Tom**: OK, no problem.

                        **【译文】**
                        
                        **妈妈**：汤姆，你能洗下碗吗？
                        
                        **汤姆**：好的，没问题。我马上就洗。
                        
                        **妈妈**：那你能不能把垃圾倒了？
                        
                        **汤姆**：抱歉，妈妈。我现在必须做作业。
                        
                        **妈妈**：好吧，那你做完作业后再倒可以吗？
                        
                        **汤姆**：好的，没问题。

                        ### Section B (Reading) 阅读文段：The Sunday Task
                        **【原文】**
                        
                        Mrs. Miller was tired of doing all the chores. She decided to have a "strike" on Sunday. She didn't cook or clean. Her children, Dave and Amy, had to do everything. They realized how much their mother did for them. Now they always help with the chores. They think it's important to share the work.

                        **【译文】**
                        
                        米勒夫人厌倦了做所有的家务。她决定在周日进行“罢工”。她不做饭也不打扫。她的孩子们，戴夫和艾米，不得不做所有的事情。他们意识到母亲为他们付出了多少。现在他们总是帮忙做家务。他们认为分担家务很重要。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① borrow vs lend (借)
                        - **【辨析】**：
                            *   `borrow`：借入。*borrow sth. from sb.*
                            *   `lend`：借出。*lend sth. to sb.*
                        - **【例题】**：
                        
                        *Can I ________ your bike? I will ________ it back tomorrow.*
                        A. lend; borrow   B. borrow; give   C. lend; give   D. borrow; take
                        
                        **[解析]**：第一空是借入，选 **B**。

                        #### ② in order to (为了)
                        - **【用法】**：后接动词原形。置于句首或句中。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：情态动词 could 的礼貌艺术
                        **1. 委婉语气**
                        这里的 could 不代表过去，而是为了表示更客气、更委婉。
                        - *Could you help me?* (比 Can you 更地道)
                        
                        **2. 答语规范**
                        虽然问句用 could，但肯定回答常用 `Yes, I can.` 或 `Sure.`；否定回答用 `I'm afraid I can't.`。

                        **3. 中考真题特训**
                        
                        *(2024·安徽中考)* *— ________ I use your dictionary? — Of course. Here you are.*
                        A. Must   B. Should   C. Could   D. Will
                        
                        **[解析]**：表示委婉请求许可，用 Could，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Sharing Chores (分担家务)
                        **In my family, we share the chores.**
                        
                        My mother usually **does the dishes** and **cooks**. My father **sweeps the floor**. I **take out the rubbish** and **make my bed**. I think doing chores is **good for** us. It helps us learn to **be independent**. We are a happy family because we help each other.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u4", "Unit 4", "Why don't you talk to your parents?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：自我认识与人际沟通 (Communication)
                        *   **子主题**：青少年压力，烦恼解决，沟通策略 (Dealing with problems)。

                        ### 2. 单元主题内容
                        本单元关注青少年的心理健康与人际沟通。通过探讨学习压力（too many after-school classes）和人际纠纷（fight with friends），学习如何通过对话寻求解决方法。单元对比了中西方家庭对课外班的不同态度，引导学生学会减压，掌握积极的沟通技巧，培养其处理生活矛盾和情感波动的能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **烦恼动词**：argue (争吵), compete (竞争), worry (担心), explain (解释).
                        - **核心名词**：pressure (压力), skill (技能), opinion (看法), member (成员).
                        - **高频短语**：Why don't you...? (为什么不...?), look through (浏览), big deal (大惊小怪), get on with (与...相处), communicate with (沟通).

                        ### 2. 核心句式
                        1.  **提出建议**：Why don't you talk to your parents? / You should write him a letter.
                        2.  **描述烦恼**：I found my sister looking through my things.
                        3.  **对比观点**：American parents think it's important to develop skills.
                        4.  **劝慰引导**：It's not a big deal.

                        ### 3. 重点语法
                        - **Why don't you + v.** 的用法。
                        - **until, so that, although** 等连词的引导应用。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Julie**: What's wrong, Kim?
                        
                        **Kim**: I had a fight with my best friend. 
                        
                        **Julie**: Why don't you call him up and talk? 
                        
                        **Kim**: No, I'm still angry. 
                        
                        **Julie**: Well, you could write a letter to him. 
                        
                        **Kim**: That's a good idea. Maybe I will try that.

                        **【译文】**
                        
                        **朱莉**：怎么了，金？
                        
                        **金**：我和我最好的朋友吵架了。
                        
                        **朱莉**：你为什么不给他打个电话谈谈呢？
                        
                        **金**：不，我还在生气。
                        
                        **朱莉**：好吧，那你可以给他写封信。
                        
                        **金**：那是个好主意。也许我会试试。

                        ### Section B (Reading) 阅读文段：Too Many After-school Classes?
                        **【原文】**
                        
                        Now many children in China are very busy. They have too many after-school classes on weekends. Their parents want them to be the best. But children are under too much pressure. They don't have time to relax. Experts think children should have more free time to develop their own interests.

                        **【译文】**
                        
                        现在中国的许多孩子都很忙。他们在周末有太多的课外班。他们的父母希望他们成为最好的。但孩子们承受着太大的压力。他们没有时间放松。专家认为孩子们应该有更多的业余时间来发展他们自己的兴趣。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① why don't you ...? (为什么不...?)
                        - **【同义转换】**：`Why not ...?`
                        - **【用法】**：后接动词原形。
                        
                        #### ② although (虽然; 尽管)
                        - **【注意】**：在英语中，although 和 but 不能出现在同一个句子里。
                        - **【例题】**：
                        
                        *________ it was raining, ________ he still went out.*
                        A. Although; but   B. But; although   C. Although; /   D. /; but
                        
                        **[解析]**：although 和 but 二选一，选 **C**。

                        #### ③ so that (为了; 以便)
                        - **【用法】**：引导目的状语从句。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：建议的多种表达
                        **1. Why don't you + v. ?**
                        - *Why don't you go home?*
                        
                        **2. What/How about + v.-ing ?**
                        - *How about going shopping?*
                        
                        **3. You should/could + v.**
                        - *You should talk to him.*

                        **4. 中考真题特训**
                        
                        *(2023·江苏中考)* *— I'm very tired. — Why ________ have a rest?*
                        A. not   B. not to   C. don't   D. no
                        
                        **[解析]**：Why not do sth. 或 Why don't you do sth.，此处选 **A** (注意如果是 don't 需加 you)。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Giving Advice to a Friend (给朋友提建议)
                        **Dear Kim,**
                        
                        I'm sorry to hear that you are **under much pressure**. **Why don't you** talk to your teacher? She can help you **solve the problems**. Also, you **shouldn't study** all the time. You should **communicate with** your parents. I hope you will feel better.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u5", "Unit 5", "What were you doing when the rainstorm came?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self) / 人与社会 (Man and Society)
                        *   **主题群**：自然现象，历史事件 (Natural phenomena and events)
                        *   **子主题**：重大事件发生时的个人经历，自然灾害应对 (Past events)。

                        ### 2. 单元主题内容
                        本单元以“过去发生的重大事件”为背景，重点学习过去进行时（Past Progressive Tense）。通过描述暴雨来袭时（What were you doing when the rainstorm came?）或历史性时刻（如马丁·路德·金遇刺、911事件）人们正在进行的活动，引导学生学会有逻辑地叙述过去。单元强调在困难和灾难面前人们的互助与团结，培养学生的共情能力和面对突发事件的沉着态度。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **自然现象**：rainstorm, storm, wind, light, ice.
                        - **核心名词/动词**：alarm (闹钟), window (窗户), match (火柴), wood (木头), beat (敲击), rise (上升).
                        - **高频短语**：go off (闹钟响), take down (拆除), pick up (接电话), fall asleep (入睡), in a mess (乱七八糟).

                        ### 2. 核心句式
                        1.  **过去动作询问**：What were you doing when the rainstorm came? — I was sleeping.
                        2.  **时间引导**：While my mom was cooking, I was doing my homework.
                        3.  **状态描述**：The wind was blowing hard and the rain was beating against the windows.
                        4.  **因果表达**：I was so busy that I didn't see the light.

                        ### 3. 重点语法
                        - **过去进行时** 的构成 (was/were + v.-ing)。
                        - **when 与 while** 在时间状语从句中的用法辨析。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Mary**: What were you doing at eight last night? 
                        
                        **Linda**: I was taking a shower. What about you? 
                        
                        **Mary**: I was doing my homework. Then the rainstorm came. 
                        
                        **Linda**: Oh, I heard it. The wind was blowing very hard. 
                        
                        **Mary**: Yes. My dad was helping my mom in the kitchen at that time.

                        **【译文】**
                        
                        **玛丽**：昨晚八点你正在做什么？
                        
                        **琳达**：我正在洗澡。你呢？
                        
                        **玛丽**：我正在做作业。然后暴雨就来了。
                        
                        **琳达**：噢，我听到了。风刮得很大。
                        
                        **玛丽**：是的。那时我爸爸正在厨房帮我妈妈。

                        ### Section B (Reading) 阅读文段：The Storm Brought Us Together
                        **【原文】**
                        
                        The weather was terrible last Friday. A heavy rainstorm came. My father was looking for some wood to put on the windows. My mother was making sure the flashlights and matches were ready. I was helping my younger brother. We were all busy, but we felt safe because we were together. The storm was strong, but it brought the family closer.

                        **【译文】**
                        
                        上周五天气很糟糕。一场大暴雨来袭。我爸爸正在找木头钉在窗户上。我妈妈正在确保手电筒和火柴准备好了。我正在帮助我的弟弟。我们都很忙，但我们感到安全，因为我们在一起。暴雨很猛烈，但它让家人联系得更紧密了。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What were you doing when the rainstorm came? (当暴雨来袭时你正在做什么？)
                        - **【句式剖析】**：`when` 引导的时间状语从句用一般过去时，主句用过去进行时。表示一个长动作正在进行时被一个短动作打断。
                        
                        #### 2. While my mom was cooking, my dad was washing the car. (当妈妈在做饭时，爸爸在洗车。)
                        - **【用法拓展】**：`while` 引导的两个动作通常都是延续性的，主从句均用过去进行时。
                        
                        #### 3. The alarm went off. (闹钟响了。)
                        - **【词块归纳】**：`go off` 指（闹钟）发出响声、爆炸、（电）断掉。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① when vs while
                        - **【辨析】**：
                            *   `when`：既可接点动词也可接延续动词。
                            *   `while`：必须接延续性动词，强调主从句动作同步进行。
                        - **【例题】**：
                        
                        *I was watching TV ________ my brother was playing games.*
                        A. when   B. while   C. since   D. after
                        
                        **[解析]**：前后都是过去进行时，强调同步，选 **B**。

                        #### ② fall asleep (入睡)
                        - **【辨析】**：`go to bed` (上床睡觉 - 动作)；`sleep` (睡觉 - 状态)；`fall asleep` (入睡 - 动作)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：过去进行时 (Past Progressive)
                        表示在过去某一时刻或某一段时间内正在进行的动作。
                        **1. 构成：was/were + v.-ing.**
                        
                        **2. 句式变换**
                        - 否定：wasn't/weren't + v.-ing.
                        - 疑问：Was/Were + 主语 + v.-ing ...?

                        **3. 常见标志词**
                        at that time, at 8:00 last night, when..., while...

                        **4. 中考真题特训**
                        
                        *(2024·安徽中考)* *I ________ a letter to my friend when someone knocked at the door.*
                        A. write   B. wrote   C. am writing   D. was writing
                        
                        **[解析]**：knocked 是过去式，主句表示当时正在进行的动作，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：An Important Event (记叙一次经历)
                        **Last Sunday, a heavy rain came suddenly.**
                        
                        At that time, I **was walking** in the park. People **were running** everywhere to find cover. I **was waiting** for the bus when I saw an old lady. She **was carrying** a lot of bags. I **ran to** her and helped her. Although we were both wet, we were happy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u6", "Unit 6", "An old man tried to move the mountains.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与社会 (Man and Society)
                        *   **主题群**：文学、艺术与体育 (Literature and art)
                        *   **子主题**：中国传统故事，西方经典童话，文化传承 (Fairy tales and legends)。

                        ### 2. 单元主题内容
                        本单元以“经典故事”为线索，学习如何使用过去时态讲述中国传说（如《愚公移山》、《西游记》）和西方童话（如《糖果屋》、《皇帝的新衣》）。通过学习 as soon as, so...that, unless 等连词，学生能够更有逻辑地串联故事情节。单元旨在引导学生感悟故事背后的智慧、勤劳与善良，树立文化自信并进行跨文化比较。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **故事角色**：god, stone, king, tail, princess, husband, wife.
                        - **核心名词/形容词**：object (物体), hidden (隐藏的), magic (有魔力的), brave (勇敢的).
                        - **高频短语**：remind sb. of (提醒某人某事), turn ... into (把...变成), once upon a time (从前), keep doing (继续做某事).

                        ### 2. 核心句式
                        1.  **引入故事**：Once upon a time, there was an old man...
                        2.  **描述变化**：He can turn himself into different animals.
                        3.  **转折连词**：Unless you work hard, you won't finish the task.
                        4.  **因果结果**：The king was so stupid that he didn't wear any clothes.

                        ### 3. 重点语法
                        - **连词的应用**：as soon as (一...就), unless (除非), so...that (如此...以至于).
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Lily**: Have you ever heard of Yu Gong? 
                        
                        **Tom**: Yes. He was an old man who tried to move the mountains. 
                        
                        **Lily**: Why did he do that? 
                        
                        **Tom**: Because the mountains were so big that people couldn't walk easily. 
                        
                        **Lily**: It sounds difficult. 
                        
                        **Tom**: Yes, but he kept working and finally the god helped him.

                        **【译文】**
                        
                        **莉莉**：你听说过愚公吗？
                        
                        **汤姆**：是的。他是一位试图搬走大山的的老人。
                        
                        **莉莉**：他为什么要那样做？
                        
                        **汤姆**：因为那些山太大了，以至于人们走起路来不方便。
                        
                        **莉莉**：听起来很难。
                        
                        **汤姆**：是的，但他坚持工作，最后上帝帮助了他。

                        ### Section B (Reading) 阅读文段：Hansel and Gretel
                        **【原文】**
                        
                        Once upon a time, Hansel and Gretel lived near a forest. One day, they got lost. They walked until they saw a house made of candy. They were so hungry that they started to eat the house. Suddenly, an old woman came out. She wasn't kind. She was a witch! But Hansel and Gretel were brave and clever. In the end, they found their way home.

                        **【译文】**
                        
                        从前，韩塞尔和葛雷特住在森林附近。一天，他们迷路了。他们一直走，直到看到一座由糖果做的房子。他们太饿了，以至于开始吃那座房子。突然，一位老妇人走了出来。她并不友善。她是个女巫！但韩塞尔和葛雷特既勇敢又聪明。最后，他们找到了回家的路。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. As soon as the sun comes out, we should leave. (太阳一出来，我们就该离开。)
                        - **【句式剖析】**：`as soon as` 引导时间状语从句，遵循“主将从现”或“主情从现”原则。
                        
                        #### 2. Unless you work hard, you will fail. (除非你努力，否则你会失败。)
                        - **【用法拓展】**：`unless` = `if ... not`。
                        
                        #### 3. He was so excited that he couldn't sleep. (他如此兴奋以至于睡不着。)
                        - **【词块归纳】**：`so + adj./adv. + that + 从句`。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① remind sb. of sth. (使某人想起某事)
                        - **【例题】**：
                        
                        *This photo always ________ me ________ my happy childhood.*
                        A. reminds; of   B. reminds; at   C. remembers; of   D. tells; about
                        
                        **[解析]**：remind sb. of 为固定搭配，选 **A**。

                        #### ② turn ... into ... (把...变成...)
                        - **【拓展】**：`turn around` (回头), `turn off` (关上)。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：复杂句中的连词
                        **1. as soon as** (一...就)
                        - *I will call you as soon as I arrive.*
                        
                        **2. unless** (除非; 如果不)
                        - *We'll go to the park unless it rains.*
                        
                        **3. so...that** (如此...以至于)
                        - *The box is so heavy that I can't lift it.*

                        **4. 中考真题特训**
                        
                        *(2023·北京中考)* *You will miss the bus ________ you hurry up.*
                        A. because   B. unless   C. if   D. until
                        
                        **[解析]**：语义为“除非你快点，否则会错过”，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite Story (我最喜欢的故事)
                        **My favourite story is Monkey King.**
                        
                        **Once upon a time**, there was a clever monkey. He was **brave and strong**. He could **turn himself into** 72 different things. He used a **magic** stick to fight against bad people. I like him **because** he never gives up. He **reminds me of** the importance of being brave.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u7", "Unit 7", "What's the highest mountain in the world?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自然 (Man and Nature)
                        *   **主题群**：世界地理与环境保护 (Geography and environment)
                        *   **子主题**：地理之最，自然奇观，动物保护 (Nature and wildlife)。

                        ### 2. 单元主题内容
                        本单元以“世界之最”为话题，深入学习大数字的表达以及形容词/副词比较级与最高级的进阶用法。学生将通过探讨珠穆朗玛峰、长江、大熊猫等地理和生物知识，增强对祖国大好河山的热爱。单元特别强调了大熊猫保护的现状，引导学生关注濒危动物，培养环保意识和人与自然和谐共处的全球视野。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **大数字/度量**：square (平方), meter (米), deep (深), wide (宽), population (人口).
                        - **自然/动物**：mountain, desert (沙漠), ocean, panda, bamboo, whale (鲸).
                        - **核心词汇**：condition (条件), achieve (实现), force (力量; 强迫), protect (保护).
                        - **高频短语**：as far as I know (据我所知), in the world (世界上), take in (吸入; 欺骗), up to (到达; 多达).

                        ### 2. 核心句式
                        1.  **询问高度/长度**：How high is Qomolangma? — It's 8,848.86 meters high.
                        2.  **最高级表达**：What is the longest river in the world?
                        3.  **倍数比较**：China is much bigger than any other country in Asia.
                        4.  **保护建议**：We should try our best to protect pandas.

                        ### 3. 重点语法
                        - **大数字的读法** (thousand, million, billion)。
                        - **比较级与最高级** 的进阶应用（any other, the second highest 等）。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Teacher**: Does anyone know what's the highest mountain in the world? 
                        
                        **Student**: Yes, it's Qomolangma. It's about 8,848 meters high. 
                        
                        **Teacher**: Correct. And what's the longest river in China? 
                        
                        **Student**: That's the Yangtze River. It's about 6,300 kilometers long. 
                        
                        **Teacher**: Very good! China has many amazing natural wonders.

                        **【译文】**
                        
                        **老师**：有人知道世界上最高的山峰是什么吗？
                        
                        **学生**：知道，是珠穆朗玛峰。它大约8848米高。
                        
                        **老师**：正确。那中国最长的河流是什么？
                        
                        **学生**：是长江。它大约6300千米长。
                        
                        **老师**：非常好！中国有很多神奇的自然奇观。

                        ### Section B (Reading) 阅读文段：Saving the Pandas
                        **【原文】**
                        
                        Pandas are one of the most famous animals in the world. They live in the forests of China and eat bamboo. But now there are only about 1,800 pandas living in the wild. Many people are working hard to save them. They set up panda bases to help the pandas have more babies. We must protect their homes so they won't disappear.

                        **【译文】**
                        
                        大熊猫是世界上最著名的动物之一。它们住在中国森林里，吃竹子。但现在野外大约只有1800只大熊猫。许多人正在努力拯救它们。他们建立大熊猫基地来帮助大熊猫繁育后代。我们必须保护它们的家园，这样它们才不会消失。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Qomolangma is 8,848 meters high. (珠穆朗玛峰有8848米高。)
                        - **【用法拓展】**：`数字 + 单位 + 形容词(high/long/wide/deep)` 表达度量。
                        
                        #### 2. It's much deeper than the Atlantic Ocean. (它比大西洋深得多。)
                        - **【要点精讲】**：比较级前加 `much, far, a lot, even, a little` 表示程度。
                        
                        #### 3. China has the largest population in the world. (中国拥有世界上最多的人口。)
                        - **【词块归纳】**：`population` 指人口，问数量用 `How large` 而非 how many。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① any other ... (任何其他的...)
                        - **【注意】**：用于比较级表达最高级含义。
                        - **【例题】**：
                        
                        *Li Hua is taller than ________ student in his class.*
                        A. any   B. any other   C. all   D. other
                        
                        **[解析]**：在同一班级内比较，需排除李华本人，选 **B**。

                        #### ② protect ... from ... (保护...免受...)
                        - **【例题】**：
                        
                        *We should protect the earth ________ pollution.*
                        A. from   B. with   C. at   D. for
                        
                        **[解析]**：固定搭配 protect ... from ...，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：大数字与进阶比较级
                        **1. 大数字三位一分法**
                        - 1,234,567 -> one million, two hundred and thirty-four thousand, five hundred and sixty-seven.
                        - thousand (千), million (百万), billion (十亿)。注意这些词本身不加 s。
                        
                        **2. 最高级变体**
                        - `one of the + 最高级 + 名词复数` (最...之一)。
                        - `the + 序数词 + 最高级` (第几个最...)。

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *The Yangtze River is one of ________ rivers in the world.*
                        A. long   B. longer   C. longest   D. the longest
                        
                        **[解析]**：one of the + 最高级 + 复数名词，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：An Animal in Danger (保护濒危动物)
                        **Pandas are very cute and famous.**
                        
                        They **live in** China and **eat** bamboo. However, they are **in danger** now. There is **less and less** bamboo for them. We should **protect** the forests and **stop** people from hurting them. I believe if we **work together**, we can save the pandas. Let's **take action** now!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u8", "Unit 8", "Have you read Treasure Island yet?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：文学、艺术与体育 (Literature and art)
                        *   **子主题**：经典名著阅读，音乐喜好，个人经历分享 (Books and music)。

                        ### 2. 单元主题内容
                        本单元以“经典阅读与现代音乐”为媒介，重点学习现在完成时（Present Perfect Tense）。学生将通过讨论著名的文学作品（如《金银岛》、《鲁滨逊漂流记》）以及现代流行音乐（如乡村音乐），学习如何表达过去发生且影响至今的经历。单元强调文学与音乐作为人类精神食粮的重要性，引导学生在快节奏生活中通过经典文化寻找内心的平静与力量。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **文学词汇**：novel, classic, ship, tool, island, treasure, mark.
                        - **音乐/艺术**：pop, rock, country music, fan, record.
                        - **核心词汇**：already, yet, ever, never, since, towards (朝向).
                        - **高频短语**：finish reading (读完), hurry up (快点), belong to (属于), laugh at (嘲笑), full of (充满).

                        ### 2. 核心句式
                        1.  **询问经历**：Have you read Treasure Island yet? — Yes, I have. / No, I haven't.
                        2.  **陈述经历**：I have already finished my homework. / He has never been to the UK.
                        3.  **表达看法**：What is it like? — It's fantastic!
                        4.  **时间关联**：I've lived here since I was five.

                        ### 3. 重点语法
                        - **现在完成时** 的基本用法（have/has + done）。
                        - **already 与 yet** 在完成时中的位置与含义。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Alice**: Have you read Treasure Island yet, Nick? 
                        
                        **Nick**: No, I haven't. But I've already read Little Women. 
                        
                        **Alice**: What's it like? 
                        
                        **Nick**: It's very good. I've read it twice. Have you finished reading your book? 
                        
                        **Alice**: Not yet. I'm still reading the last chapter.

                        **【译文】**
                        
                        **艾丽丝**：尼克，你读过《金银岛》了吗？
                        
                        **尼克**：不，还没读过。但我已经读过《小妇人》了。
                        
                        **艾丽丝**：它怎么样？
                        
                        **尼克**：非常好。我已经读过两遍了。你读完你的书了吗？
                        
                        **艾丽丝**：还没呢。我还在读最后一章。

                        ### Section B (Reading) 阅读文段：Country Music
                        **【原文】**
                        
                        Sarah is a fan of country music. She has listened to many songs by Garth Brooks. She says country music reminds her of her home. It is about simple things like family, friends and beauty of nature. Sarah has been to many concerts. Music has changed her life and made her a happy person.

                        **【译文】**
                        
                        莎拉是一个乡村音乐迷。她听过很多加斯·布鲁克斯的歌。她说乡村音乐让她想起家乡。它是关于家庭、朋友和自然美景等简单的事物。莎拉去过很多场音乐会。音乐改变了她的生活，使她成为一个快乐的人。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Have you read ... yet? (你读过...了吗？)
                        - **【用法拓展】**：`yet` 用于疑问句或否定句末尾；`already` 用于肯定句。
                        
                        #### 2. Robinson Crusoe has been on the island for 28 years. (鲁滨逊已经在岛上待了28年了。)
                        - **【要点精讲】**：现在完成时中，延续性动作常用 `for + 一段时间` 或 `since + 时间点`。
                        
                        #### 3. It reminds me of the beauty of nature. (它让我想起自然之美。)
                        - **【词块归纳】**：`remind sb. of sth.` 使某人想起某事。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① finish (v. 完成)
                        - **【用法总结】**：`finish doing sth.` 完成做某事。
                        
                        #### ② yet vs already
                        - **【辨析】**：
                            *   `already`：通常放中（have后）或句末，意为“已经”。
                            *   `yet`：放句末，意为“还（没）”或“已经（了吗？）”。
                        - **【例题】**：
                        
                        *I haven't seen the movie ________.*
                        A. already   B. yet   C. never   D. ever
                        
                        **[解析]**：否定句末用 yet，选 **B**。

                        #### ③ be full of (充满)
                        - **【同义词】**：`be filled with`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：现在完成时初探 (Present Perfect)
                        表示过去发生的动作对现在产生的影响，或过去开始持续到现在的动作。
                        **1. 构成：have/has + 动词的过去分词 (p.p.)**
                        
                        **2. already 与 yet 的分工**
                        - I have **already** eaten lunch. (肯定)
                        - Have you eaten lunch **yet**? (疑问)
                        - I haven't eaten lunch **yet**. (否定)

                        **3. 中考真题特训**
                        
                        *(2024·江苏中考)* *— Have you ________ been to the Great Wall? — Yes, twice.*
                        A. already   B. yet   C. ever   D. never
                        
                        **[解析]**：疑问句询问经历，用 ever (曾经)，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Favourite Book (我最喜欢的一本书)
                        **I have read many books, but my favourite one is Robinson Crusoe.**
                        
                        It **is about** a man who lived on an island for many years. He was **brave and clever**. He **built** a house and **grew** food. I have **read it twice** because it is very **exciting**. It **reminds me** that we should never **give up**. I think everyone should read it.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u9", "Unit 9", "Have you ever been to a museum?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self) / 人与社会 (Man and Society)
                        *   **主题群**：世界与环境 (The world and environment)
                        *   **子主题**：旅游经历，名胜古迹，文化场馆参观 (Traveling and museums)。

                        ### 2. 单元主题内容
                        本单元以“游历与名胜”为主题，重点进阶学习现在完成时（Present Perfect Tense）。通过讨论曾经去过的博物馆、太空站、游乐园等场所，学生学会如何表达个人的人生经历。单元还涉及了新加坡等地的多元文化介绍，引导学生开阔国际视野，尊重多元文化，培养其作为全球公民的文化素养和分享意识。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **场馆词汇**：museum, planetarium, aquarium, zoo, amusement park.
                        - **核心动词/形容词**：invent (发明), explore (探索), unbelievable (难以置信的), unusual (不寻常的).
                        - **高频短语**：have been to (去过), have gone to (去了), thousands of (数以千计的), encourage sb. to do sth. (鼓励某人做某事), take a subway (乘地铁).

                        ### 2. 核心句式
                        1.  **询问经历**：Have you ever been to a science museum? — Yes, I have. / No, I haven't.
                        2.  **表达感叹**：I've never been to a water park.
                        3.  **数量表达**：There are thousands of students in the school.
                        4.  **因果逻辑**：It's so beautiful that I want to visit it again.

                        ### 3. 重点语法
                        - **现在完成时** 的进阶用法（ever, never）。
                        - **have been to** 与 **have gone to** 的深度辨析。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Sarah**: Have you ever been to the space museum, Leo? 
                        
                        **Leo**: No, I haven't. How about you? 
                        
                        **Sarah**: I went there last year. It was fantastic! 
                        
                        **Leo**: Have you been to the art museum? 
                        
                        **Sarah**: No, I've never been there. Is it good? 
                        
                        **Leo**: Yes, it is. I've been there many times.

                        **【译文】**
                        
                        **莎拉**：利奥，你去过太空博物馆吗？
                        
                        **利奥**：不，我没去过。你呢？
                        
                        **莎拉**：我去年去了。那儿太棒了！
                        
                        **利奥**：你去过艺术博物馆吗？
                        
                        **莎拉**：没，我从没去过那儿。那儿好吗？
                        
                        **利奥**：是的，很好。我去过那里很多次了。

                        ### Section B (Reading) 阅读文段：Singapore — A Place You Will Never Forget
                        **【原文】**
                        
                        Singapore is an island in Southeast Asia. It is a great place to take a vacation. On the one hand, more than three quarters of the population are Chinese, so you can speak Chinese. On the other hand, it's an English-speaking country. You can find food from all over the world. The Night Safari is the most exciting place. It's a place you will never forget!

                        **【译文】**
                        
                        新加坡是东南亚的一个岛国。它是一个度假的好地方。一方面，超过四分之三的人口是华人，所以你可以说中文。另一方面，它是一个说英语的国家。你可以找到来自世界各地的美食。夜间野生动物园是最令人兴奋的地方。这是一个你永远不会忘记的地方！
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. Have you ever been to ...? (你曾经去过...吗？)
                        - **【用法拓展】**：用于询问某人的经历。`ever` 意为“曾经”，常放于 have/has 之后。
                        
                        #### 2. On the one hand ... on the other hand ... (一方面...另一方面...)
                        - **【要点精讲】**：用于表达两个不同的方面，常作连接词。
                        
                        #### 3. It's a good way to practice your English. (这是练习英语的一个好方法。)
                        - **【词块归纳】**：`a good way to do sth.` 做某事的好方法。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① have been to vs have gone to
                        - **【辨析】**：
                            *   `have been to`：去过某地（已回来）。强调经历。
                            *   `have gone to`：去了某地（未回来）。强调状态。
                        - **【例题】**：
                        
                        *— Where is Tom? — He ________ the library.*
                        A. has been to   B. has gone to   C. goes   D. went
                        
                        **[解析]**：根据问句询问人在哪，可知人去了还没回来，选 **B**。

                        #### ② population (n. 人口)
                        - **【注意】**：谓语动词用单数。询问人口多少用 `How large`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：现在完成时之“人生经历”
                        **1. 常用时间状语**
                        - ever (曾经), never (从不), before (以前), many times (多次).
                        
                        **2. 句式注意点**
                        - 肯定句：I have been there before.
                        - 疑问句：Have you ever been there?
                        - 否定句：I have never been there.

                        **3. 中考真题特训**
                        
                        *(2024·重庆中考)* *My father ________ to Beijing twice. He loves the city very much.*
                        A. has gone   B. has been   C. went   D. will go
                        
                        **[解析]**：twice 表示经历，且人现在在这说话（已回来），选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Travel Experience (我的旅行经历)
                        **I love traveling. I have been to many interesting places.**
                        
                        Last summer, I **went to Beijing** with my parents. I **have been to** the Great Wall twice. It is **fantastic**! I also **visited** the Palace Museum. I **have learned** a lot about Chinese history. TRAVELING is a **good way** to see the world. I hope to **visit** more places in the future.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u10", "Unit 10", "I've had this bike for three years.",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self) / 人与社会 (Man and Society)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：个人物品，童年回忆，城乡变迁 (Memories and changes)。

                        ### 2. 单元主题内容
                        本单元围绕“旧物与回忆”展开，重点学习现在完成时（延续性用法）。通过讨论捐赠旧物（如 bike, toy, book 等）以及家乡的变迁（如 Hometown 故事），引导学生学会珍惜当下，感恩过去。单元强调了“断舍离”的极简生活态度以及社会慈善意识，培养学生的人文情怀和对社会发展的深度思考。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **旧物名词**：yard, sweet, soft toy, board game, scarf.
                        - **核心动词/形容词**：own (拥有), part (离开; 分开), honest (诚实的), certain (某些).
                        - **高频短语**：for three years (三年了), since I was five (自从五岁起), yard sale (庭院拍卖), part with (放弃), check out (查看).

                        ### 2. 核心句式
                        1.  **询问持续时长**：How long have you had that bike? — For three years.
                        2.  **表达所有权**：I've had this toy since I was a baby.
                        3.  **描述变化**：My hometown has changed a lot in the last few years.
                        4.  **捐赠建议**：We can give these things to the children in need.

                        ### 3. 重点语法
                        - **现在完成时** 的延续性用法（for 与 since 的搭配）。
                        - **短暂性动词与延续性动词** 的转换。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Amy**: What's that, Jeff? 
                        
                        **Jeff**: It's my old bike. I've had it for three years. 
                        
                        **Amy**: Are you going to sell it at the yard sale? 
                        
                        **Jeff**: Yes. I don't use it anymore. But I want to part with my old books. 
                        
                        **Amy**: Why? 
                        
                        **Jeff**: Because they've brought me so much joy. I want to give them to someone who needs them.

                        **【译文】**
                        
                        **艾米**：那是什么，杰夫？
                        
                        **杰夫**：是我的旧自行车。我已经买了三年了。
                        
                        **艾米**：你打算在庭院拍卖会上卖掉它吗？
                        
                        **杰夫**：是的。我不怎么用它了。但我还想舍弃我的旧书。
                        
                        **艾米**：为什么？
                        
                        **杰夫**：因为它们给我带来了很多快乐。我想把它们给需要它们的人。

                        ### Section B (Reading) 阅读文段：Hometown Feelings
                        **【原文】**
                        
                        Many people in China have left their hometowns to find work in the cities. Zhong Wei is one of them. He has lived in Wenzhou for ten years. But he still misses his hometown. He remembers the big tree and the small river. He says, "Hometown is a part of me. I will go back one day."

                        **【译文】**
                        
                        中国有很多人离开家乡去城市找工作。钟伟就是其中之一。他在温州已经住了十年了。但他依然思念家乡。他记得那棵大树和那条小河。他说：“家乡是我的一部分。总有一天我会回去的。”
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. How long have you had that bike? (你买那辆自行车多久了？)
                        - **【用法拓展】**：询问某状态持续了多久。回答常用 `for + 一段时间` 或 `since + 时间点`。
                        
                        #### 2. I've had it since I was five. (自从我五岁起我就拥有它了。)
                        - **【要点精讲】**：`since` 后面可以接具体的时间点，也可以接一个一般过去时的从句。
                        
                        #### 3. It's hard to part with these things. (舍弃这些东西很难。)
                        - **【词块归纳】**：`part with` 意为“舍弃；放弃；与...分开”。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① for vs since
                        - **【辨析】**：
                            *   `for` + 时间段 (three years, a long time)。
                            *   `since` + 时间点 (2010, last year, he came here)。
                        - **【例题】**：
                        
                        *I have studied English ________ five years ago.*
                        A. for   B. since   C. in   D. during
                        
                        **[解析]**：five years ago 是时间点，选 **B**。

                        #### ② 短暂性动词变延续性动词
                        - buy -> have
                        - borrow -> keep
                        - come -> be here
                        - join -> be in / be a member of
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：现在完成时之“持续状态”
                        **1. for 与 since 的转换**
                        - `since + 过去的时间点`
                        - `for + 时间段`
                        - *I have been a teacher since 2015.* = *I have been a teacher for 9 years.*
                        
                        **2. 延续性法则**
                        现在完成时与 for/since 连用时，动词必须是**延续性动词**。
                        - 错误：I have bought the book for two days. (buy是瞬间动作)
                        - 正确：I have **had** the book for two days.

                        **3. 中考真题特训**
                        
                        *(2024·天津中考)* *I ________ this book since I ________ ten years old.*
                        A. have had; was   B. have had; am   C. have; was   D. had; was
                        
                        **[解析]**：since 引导从句用过去时，主句用完成时，且 have 需变延续性 had，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：Changes in My Hometown (家乡的变化)
                        **My hometown has changed a lot in the last few years.**
                        
                        There **used to be** old houses and narrow roads. But now, there are **many tall buildings**. I **have lived** here **for twelve years**, and I love it. The river **is cleaner** than before. Many people **have moved** into new apartments. I think our life **is getting better and better**.
                    """.trimIndent())
                )
            )
        )
    )
}
