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

        ,
            TextbookUnit(
                "g8down_u11", "Unit 11", "How was your school trip?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：研学经历，校外实践，自然观察 (School trips)。

                        ### 2. 单元主题内容
                        本单元以“学校郊游”为话题，深入学习一般过去时的应用。通过描述去农场、博物馆、天文馆等地的经历，学生学会如何使用过去式动词（如 milked, fed, took, saw 等）来串联事件。单元强调了“在体验中学习”的教育理念，引导学生走进自然、走进科学，培养其观察力、好奇心和分享个人经历的社交能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **出游活动**：milked a cow (挤牛奶), fed chickens (喂鸡), took photos (照相), went for a walk (散步).
                        - **场所/物品**：farm, museum, robot, gift, shark, aquarium.
                        - **核心形容词**：interesting, exciting, lovely, expensive, cheap.
                        - **高频短语**：all in all (总的来说), quite a lot (许多), guide (导游), learn about (了解).

                        ### 2. 核心句式
                        1.  **询问感受**：How was your school trip? — It was excellent!
                        2.  **询问活动**：What did you see? — I saw some robots.
                        3.  **确认经历**：Did you go to the zoo? — No, I didn't.
                        4.  **总结评价**：All in all, the trip was very educational.

                        ### 3. 重点语法
                        - **一般过去时** 的不规则动词变化（feed -> fed, ride -> rode, eat -> ate）。
                        - **形容词评价语** 的逻辑分类。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Eric**: Hi, Carol. How was your school trip?
                        
                        **Carol**: It was great! We went to a farm.
                        
                        **Eric**: Did you see any cows?
                        
                        **Carol**: Yes, I did. I even milked a cow. 
                        
                        **Eric**: Did you ride a horse? 
                        
                        **Carol**: No, I didn't. But I fed some chickens. It was so much fun!

                        **【译文】**
                        
                        **埃里克**：嗨，卡罗尔。你的学校郊游怎么样？
                        
                        **卡罗尔**：太棒了！我们去了一个农场。
                        
                        **埃里克**：你看到牛了吗？
                        
                        **卡罗尔**：看到了。我甚至还挤了牛奶。
                        
                        **埃里克**：你骑马了吗？
                        
                        **卡罗尔**：没骑。但我喂了一些鸡。真的很有趣！

                        ### Section B (Reading) 阅读文段：A School Trip to the Museum
                        **【原文】**
                        
                        Yesterday we went to the Science Museum. First, we saw some robots. They were very cool! Then we went to the gift shop and bought some lovely gifts. The weather was a bit rainy, but it didn't stop us. All in all, the trip was very educational and I learned quite a lot about science.

                        **【译文】**
                        
                        昨天我们去了科学博物馆。首先，我们看到了一些机器人。它们非常酷！然后我们去了礼品店，买了一些可爱的礼物。天气有点下雨，但这并没有阻碍我们。总的来说，这次旅行非常有教育意义，我学到了不少关于科学的知识。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. How was your school trip? (你的学校郊游怎么样？)
                        - **【用法拓展】**：这里的 `was` 是 `is` 的过去式。
                        
                        #### 2. I learned quite a lot about science. (我学到了很多关于科学的知识。)
                        - **【词块归纳】**：`quite a lot` 意为“很多/相当多”。
                        
                        #### 3. All in all, it was a great day. (总的来说，这是伟大的一天。)
                        - **【要点精讲】**：`all in all` 常用于文章末尾进行总结。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① ride -> rode (过去式)
                        - **【词块归纳】**：`ride a bike`, `ride a horse`。
                        
                        #### ② exciting vs excited
                        - **【辨析】**：`exciting` 修饰物；`excited` 修饰人。
                        - **【例题】**：
                        
                        *The children were very ________ when they saw the sharks.*
                        A. exciting   B. excited   C. excite   D. to excite
                        
                        **[解析]**：修饰人，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：一般过去时的评价表达
                        **1. 积极评价**
                        excellent, great, exciting, lovely, wonderful.
                        
                        **2. 消极评价**
                        terrible, boring, expensive, noisy.

                        **3. 中考真题特训**
                        
                        *(2023·北京中考)* *— How ________ your trip to London last month? — It ________ wonderful!*
                        A. is; is   B. was; was   C. is; was   D. was; is
                        
                        **[解析]**：last month 提示全用过去时，选 **B**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My School Trip (我的学校郊游)
                        **I went to the Science Museum for my school trip.** 
                        
                        The weather was **sunny**. First, we **saw many robots**. They could **talk to** people. I thought they were **very cool**. Then we **bought some gifts**. **All in all**, it was an **exciting** day. I **learned a lot** about science. I want to go there again!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u12", "Unit 12", "What did you do last weekend?",
                listOf(
                    UnitDetailSection("🌍 单元主题透视", """
                        ### 1. 单元主题层级
                        *   **主题语境**：人与自我 (Man and Self)
                        *   **主题群**：生活与学习 (Life and study)
                        *   **子主题**：周末活动，个人经历分享 (Weekend stories)。

                        ### 2. 单元主题内容
                        作为八年级下册的总结单元，本单元旨在巩固和拓展一般过去时的叙事能力。通过描述周末的活动（如 camping, visiting relatives 等）以及遇到的意外事件（如 seeing a snake），学生能够更有条理地讲述生活中的小故事。单元鼓励学生分享真实的感触，培养其对生活细节的观察力和乐观的社交态度。
                    """.trimIndent()),

                    UnitDetailSection("💡 单元新知预览", """
                        ### 1. 重点单词短语
                        - **日常活动**：went camping, played badminton, did homework, went boating.
                        - **核心名词**：weekend, mouse, snake, forest, fire.
                        - **描述形容词**：scary, high, tired, surprised.
                        - **高频短语**：stay up late, run away, wake up, in the middle of (在...中间).

                        ### 2. 核心句式
                        1.  **询问过去**：What did you do last weekend? — I went camping.
                        2.  **描述状态**：How was your weekend? — It was scary.
                        3.  **叙述意外**：Suddenly, I saw a big snake in my tent!
                        4.  **表达感叹**：What an exciting weekend!

                        ### 3. 重点语法
                        - **一般过去时** 的综合巩固（特殊疑问句与一般疑问句）。
                        - **不规则动词过去式** 集中记忆。
                    """.trimIndent()),

                    UnitDetailSection("📝 教材原文与译文", """
                        ### Section A (1a-2d) 核心对话
                        **【原文】**
                        
                        **Lucy**: Hi, Alice. What did you do last weekend?
                        
                        **Alice**: I stayed at home and did my homework. 
                        
                        **Lucy**: Was it boring?
                        
                        **Alice**: No, it wasn't. It was busy but I learned a lot. 
                        
                        **Lucy**: I went camping with my friends. We sat by the fire and told stories. 
                        
                        **Alice**: That sounds like a lot of fun!

                        **【译文】**
                        
                        **露西**：嗨，艾丽丝。你上周末做什么了？
                        
                        **艾丽丝**：我待在家里做作业了。
                        
                        **露西**：无聊吗？
                        
                        **艾丽丝**：不，不无聊。虽然很忙但我学到了很多。
                        
                        **露西**：我和朋友们去露营了。我们坐在火堆旁讲故事。
                        
                        **艾丽丝**：那听起来非常有趣！

                        ### Section B (Reading) 阅读文段：A Scary Weekend
                        **【原文】**
                        
                        Last weekend, my brother and I went to the forest. We put up our tent and started a fire. We were very happy. But in the middle of the night, we woke up because we heard a strange sound. Suddenly, a big snake came into our tent! We were so scared that we ran away quickly. It was a very scary weekend.

                        **【译文】**
                        
                        上周末，我和我弟弟去了森林。我们搭起帐篷并生了火。我们很快乐。但在半夜，我们醒了，因为我们听到了奇怪的声音。突然，一条大蛇爬进了我们的帐篷！我们太害怕了，飞快地跑开了。那是一个非常惊险的周末。
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子详解与翻译", """
                        #### 1. What did you do last weekend? (你上周末做什么了？)
                        - **【用法拓展】**：询问过去动作的标准句型。
                        
                        #### 2. I saw a big snake in the tent. (我在帐篷里看到一条大蛇。)
                        - **【词块归纳】**：`saw` 是 `see` 的过去式。
                        
                        #### 3. We were so scared that we ran away. (我们如此害怕以至于跑开了。)
                        - **【句式金牌】**：`so + adj. + that + 从句`。
                    """.trimIndent()),

                    UnitDetailSection("🔑 重点单词短语详解与例题", """
                        #### ① stay up late (熬夜)
                        - **【注意】**：stay up 表示“不睡觉”。
                        
                        #### ② run away (跑掉; 逃跑)
                        - **【例题】**：
                        
                        *When the thief saw the police, he ________ quickly.*
                        A. ran away   B. ran into   C. ran after   D. ran out
                        
                        **[解析]**：看到警察后“跑掉”，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 语法核心：一般过去时的终极巩固
                        **1. 助动词 did 的统治地位**
                        只要句子中有 did，后面的动词必须恢复原形。
                        - *Did you go?* (不说 Did you went?)
                        
                        **2. 动词过去式的读音**
                        - [t]：清辅音结尾 (helped).
                        - [d]：浊辅音或元音结尾 (played).
                        - [id]：t 或 d 结尾 (needed).

                        **3. 中考真题特训**
                        
                        *(2024·山东中考)* *— ________ you ________ to the movies last Saturday? — Yes, I did.*
                        A. Do; go   B. Did; went   C. Did; go   D. Do; went
                        
                        **[解析]**：过去时疑问句 Did ... go ...，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作微技能", """
                        ### 写作主题：My Weekend Story (我的周末故事)
                        **My weekend was interesting.** 
                        
                        On Saturday, I **did my homework**. On Sunday morning, I **went camping** with my parents. We **put up a tent** near a lake. It was **exciting**. But then, I **heard a strange sound**. It was just a little **mouse**. We laughed and had a good time. It was a weekend **I will never forget**.
                    """.trimIndent())
                )
            )


        )

        )

        }
