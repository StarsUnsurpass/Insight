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
        )
    )
}
