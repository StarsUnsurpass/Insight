package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade7Down {
    val data = Textbook(
        id = "g7_down",
        grade = "七年级",
        term = "下册",
        coverColor = Color(0xFFFFF9C4),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc7x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g7down_u1", "Unit 1", "Can you play the guitar?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境与价值导向
                        *   **主题语境**：人与自我 —— 个人爱好与特长。
                        *   **深层意义**：本单元不仅要求学生掌握“能力”的表达，更旨在引导学生发现自身潜能，建立自信。通过社团招新的情境，培养学生的社会参与意识与团队协作精神，学会根据自身优势进行合理的社交选择。

                        ### 2. 知识能力目标
                        - **语言能力**：熟练运用情态动词 `can` 询问及陈述能力；掌握社团招聘广告的阅读与写作。
                        - **文化意识**：了解西方校园社团文化（Clubs culture），对比中西课外活动的异同。
                        - **思维品质**：通过对自己特长的评估，提升自我认知及逻辑分类能力。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类记忆
                        - **乐器类 (The)**：guitar (吉他), piano (钢琴), drums (鼓), violin (小提琴)。
                        - **特长动作类**：sing (唱), dance (跳舞), swim (游泳), draw (画), speak (说), write (写), tell (讲)。
                        - **身份与场所**：musician (音乐家), club (社团), home (家/家乡)。
                        - **修饰语**：well (好地), also (也)。

                        ### 2. 核心短语金牌储备
                        - `play the guitar/piano/violin` 弹奏吉他/钢琴/小提琴 (**必考：乐器前加the**)
                        - `play chess/basketball` 下象棋/打篮球 (**必考：球类、棋类前不加冠词**)
                        - `speak English/Chinese` 说英语/汉语
                        - `join the music/art club` 加入音乐/美术社团
                        - `be good at (doing) sth.` 擅长（做）某事
                        - `be good with sb.` 善于与某人相处
                        - `tell stories` 讲故事
                        - `make friends with sb.` 与某人交朋友
                        - `help sb. with sth.` 在某方面帮助某人
                        - `on the weekend / at the weekend` 在周末
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Can you play the guitar? (你会弹吉他吗？)
                        - **【考点详解】**：`can` 为情态动词，后接动词原形。疑问句将 `can` 提至句首。
                        - **【语法延伸】**：注意 `play` 的用法。`play + the + 乐器`；`play + 球类/棋类`。
                        
                        #### 2. What club do you want to join? (你想加入什么社团？)
                        - **【结构剖析】**：`want to do sth.` 想要做某事。`join` 指加入某个组织或团体。
                        - **【中考避坑】**：`join` (加入团体) vs `join in` (参加活动) vs `take part in` (参加大型活动/会议)。
                        
                        #### 3. I can speak English but I can't speak Chinese. (我会说英语，但我不会说汉语。)
                        - **【逻辑连接】**：`but` 连接两个表示转折关系的分句。
                        
                        #### 4. Are you good with kids? (你善于和孩子们相处吗？)
                        - **【词法精辨】**：
                            *   `be good at`：擅长... (后接名词、代词或动词-ing)。
                            *   `be good with`：善于对待.../与...相处得好。
                            *   `be good for`：对...有好处。
                            *   `be good to`：对...友好。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：情态动词 can
                        **1. 基本用法**
                        *   表示能力 (Ability)：*I can swim.*
                        *   表示许可 (Permission)：*Can I sit here?*
                        *   表示请求 (Request)：*Can you help me?*

                        **2. 句式结构**
                        - **肯定句**：主语 + can + 动词原形.
                        - **否定句**：主语 + can't (cannot) + 动词原形.
                        - **疑问句**：Can + 主语 + 动词原形 ...?
                        - **回答**：Yes, 主语 + can. / No, 主语 + can't.

                        **3. 中考真题特训**
                        
                        *(2024·南京中考)* *— Is that boy your brother? — No, it ________ be him. He is in the library now.*
                        A. mustn't   B. can't   C. shouldn't   D. needn't
                        
                        **[解析]**：根据“他在图书馆”可知，这里表示有把握的否定推测“不可能是”，选 **B**。 (注：can 的推测用法是中考高阶考点)。

                        *(2023·北京中考)* *— ________ you play the violin? — Yes, I ________. I want to join the music club.*
                        A. Can; can   B. Do; do   C. Must; must   D. Should; should
                        
                        **[解析]**：询问能力及回答，选 **A**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：社团招新广告 (Ad for a Club)
                        #### 1. 结构布局
                        - **第一步：吸引注意**。使用 Wanted, Help Wanted 或 Are you...? 等开头。
                        - **第二步：说明需求**。明确社团名称及所需人才。
                        - **第三步：列出要求**。使用 Can you...? 或 You need to...。
                        - **第四步：联系方式**。Please call... / Email us at...。

                        #### 2. 高分句式
                        - *Are you a music lover?* (你是个音乐爱好者吗？)
                        - *We need help for our school show.* (我们的学校演出需要帮助。)
                        - *Can you sing or dance?* (你会唱歌或跳舞吗？)
                        - *Come and join us!* (快来加入我们吧！)

                        #### 3. 满分范文
                        **Wanted: Music Club**
                        
                        Are you good at music? Can you sing or dance? Do you want to be a musician? Then come and join the Music Club! We need help for the school concert. If you can play the guitar, the piano or the drums, please call David at 123-4567. Join us now!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u2", "Unit 2", "What time do you go to school?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活与学习。
                        *   **深层意义**：本单元聚焦“时间管理”与“健康习惯”。通过学习作息安排，引导学生建立时间观念，识别健康与不健康的生活方式。不仅是语言的学习，更是对学生生活态度的塑造，教育学生科学作息、珍爱健康。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握时间的多种表达法；熟练运用特殊疑问句 `What time/When` 询问作息；理解频度副词的语义程度。
                        - **核心素养**：能够制定合理的个人日程表，并对他人的作息给出建议。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **日常动作**：get up (起床), dress (穿衣), brush (刷/刷净), wash (洗/洗涤), shower (淋浴), eat (吃)。
                        - **频度副词**：always (总是), usually (通常), often (经常), sometimes (有时), never (从不)。
                        - **时间/状态**：early (早的/地), late (晚的/地), quickly (很快地), funny (奇怪的/滑稽的)。
                        - **其他名词**：job (工作), station (电视台/车站), teeth (牙齿), life (生活)。

                        ### 2. 核心短语金牌储备
                        - `get dressed` 穿上衣服
                        - `brush teeth` 刷牙 (**必考：tooth的复数是teeth**)
                        - `take a shower` 洗淋浴
                        - `go to school` 去上学
                        - `eat breakfast/lunch/dinner` 吃早/中/晚饭 (**必考：三餐前通常不加冠词**)
                        - `do one's homework` 做作业
                        - `go to bed` 去睡觉
                        - `on school days` 在上学日
                        - `be late for` 做某事迟到
                        - `at night` 在晚上
                        - `from ... to ...` 从...到...
                        - `a healthy life` 健康的生活
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What time do you usually get up? (你通常几点起床？)
                        - **【考点详解】**：`What time` 询问具体时间点。`usually` 放在行为动词之前。
                        
                        #### 2. When does Scott go to work? (斯科特什么时候去上班？)
                        - **【结构剖析】**：`When` 询问时间，范围比 `What time` 更广。
                        
                        #### 3. I'm never late for school. (我上学从不迟到。)
                        - **【词法精辨】**：`be late for` 固定搭配。`never` 是频度副词，放在 `be` 动词之后。
                        
                        #### 4. That's a funny time for breakfast! (那是个奇怪的吃早餐时间！)
                        - **【用法拓展】**：`funny` 既可以指“好笑的”，也可以指“古怪的/奇怪的”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：时间表达法 (Telling Time)
                        **1. 顺读法**：直接读数字。*6:10 -> six ten*; *8:30 -> eight thirty*。
                        **2. 逆读法**：
                        *   **分钟 <= 30**：`分钟 + past + 点钟`。 *7:10 -> ten past seven*。
                        *   **分钟 > 30**：`(60-分钟) + to + (点钟+1)`。 *8:50 -> ten to nine* (差十分九点)。
                        *   **特殊点**：15分钟 -> `a quarter`; 30分钟 -> `half`。

                        ### 核心语法二：频度副词的位置
                        **口诀**：行前 be 后。
                        *   行为动词前：*I **usually** run.*
                        *   be 动词后：*He **is** always late.*

                        ### 中考真题特训
                        
                        *(2024·四川中考)* *— ________ do you go to bed? — At ten o'clock.*
                        A. How   B. Why   C. What time   D. Where
                        
                        **[解析]**：询问具体时间点，选 **C**。

                        *(2023·广东中考)* *Linda ________ goes to school by bus. She thinks it's convenient.*
                        A. never   B. seldom   C. sometimes   D. always
                        
                        **[解析]**：根据“觉得方便”可知，应是“总是”或“经常”，选 **D**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的作息时间 (My Daily Routine)
                        #### 1. 写作要素
                        - **时间顺序**：使用 First, Next, After that, Then, Finally 等连接词。
                        - **具体动作**：使用本单元学习的动词短语。
                        - **感受评价**：My life is busy but healthy.

                        #### 2. 高分句式
                        - *I usually get up at six thirty in the morning.*
                        - *I think I have a very healthy life.*
                        - *My school starts at eight o'clock.*
                        - *I don't have much time for games.*

                        #### 3. 满分范文
                        **My School Day**
                        
                        I have a busy school day. I always get up early, at about 6:00 a.m. I brush my teeth and take a shower quickly. Then I eat a healthy breakfast. I go to school at 7:15. Lessons start at 8:00. After school, I often play basketball with my friends. I usually do my homework at 7:00 p.m. and go to bed at 10:00 p.m. I feel tired but happy.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u3", "Unit 3", "How do you get to school?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 交通与出行。
                        *   **深层意义**：本单元探讨“出行方式”与“空间距离”。通过讨论不同地理环境下的学生如何上学（如 Crossing the River to School），不仅学习交通词汇，更培养学生对社会现实的关注，建立跨文化地理意识，理解人类如何克服自然困难追求教育。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握各类交通工具及动作表达；熟练运用 `How long`, `How far` 询问时间与距离；掌握 `It takes...` 句型。
                        - **思维能力**：能够对比不同交通方式的优缺点（Fast, cheap, safe etc.）。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **交通工具**：train (火车), bus (公交), subway (地铁), bike (自行车), boat (小船)。
                        - **动词短语核心**：ride (骑), take (乘坐), walk (步行), drive (驾驶), fly (飞)。
                        - **度量与方位**：kilometer (千米), mile (英里), bridge (桥), village (村庄), river (河)。
                        - **形容词/副词**：afraid (害怕), true (真的), many (许多)。

                        ### 2. 核心短语金牌储备
                        - `get to school` 到达学校 (**注意：get home, get there/here 无 to**)
                        - `take the subway/bus/train` 乘地铁/公交/火车
                        - `ride a bike` 骑自行车
                        - `every day` 每天
                        - `how far` 多远（问距离）
                        - `how long` 多久（问时间）
                        - `between ... and ...` 在...和...之间
                        - `come true` 实现
                        - `cross the river` 过河
                        - `one 11-year-old boy` 一个11岁的男孩 (**必考：连字符结构中名词用单数**)
                        - `be afraid of (doing) sth.` 害怕（做）某事
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. How do you get to school? (你如何到达学校？)
                        - **【考点详解】**：`How` 询问方式。回答通常用 `I take the bus.` 或 `By bus.`。
                        
                        #### 2. How far is it from your home to school? (从你家到学校有多远？)
                        - **【结构剖析】**：`How far` 问距离。常用结构 `It is ... (kilometers) from A to B.`。
                        
                        #### 3. How long does it take? (要花多长时间？)
                        - **【语法核心】**：`How long` 问时间长度。注意助动词 `does`。
                        
                        #### 4. It takes me 20 minutes to get to school. (到学校花了我20分钟。)
                        - **【句式金牌】**：`It takes sb. some time to do sth.` 重点考查 `it` 作形式主语，真正主语是后面的不定式。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：交通方式的三种表达法
                        **1. 动词短语作谓语**：`主语 + take the + 交通工具 + to ...`。
                        *   *I **take the bus** to school.*
                        **2. 介词短语作状语**：`主语 + go to ... + by + 交通工具`。 (**by后不加冠词**)
                        *   *I go to school **by bus**.*
                        **3. 特殊方式**：`walk to ...` (步行); `ride a bike to ...` (骑车)。

                        ### 核心语法二：How 家族疑问词
                        - **How far**：问距离。 *— How far is it? — 5 kilometers.*
                        - **How long**：问时间长短。 *— How long does it take? — 10 minutes.*
                        - **How often**：问频率。 *— How often do you swim? — Twice a week.*

                        ### 中考真题特训
                        
                        *(2024·河北中考)* *It ________ me two hours to finish the work yesterday.*
                        A. takes   B. taking   C. took   D. will take
                        
                        **[解析]**：yesterday 提示用过去时，固定句型 It takes/took sb. time to do sth.，选 **C**。

                        *(2023·江苏中考)* *— ________ is it from your home to the library? — About ten minutes' walk.*
                        A. How long   B. How often   C. How far   D. How much
                        
                        **[解析]**：虽然回答是“步行十分钟”，但本质是描述距离，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的上学之路 (How I get to school)
                        #### 1. 写作要点
                        - **开头**：点明地点及大致距离。
                        - **过程**：详细描述交通方式及耗时。
                        - **感受**：对这种交通方式的看法（Fast, green, healthy...）。

                        #### 2. 高分句式
                        - *My home is far from school, about 8 kilometers.*
                        - *I usually go to school by subway.*
                        - *It takes me about 20 minutes to get there.*
                        - *I think riding a bike is good for my health.*

                        #### 3. 满分范文
                        I live in a beautiful village. It is about 5 kilometers from my home to school. Every morning, I get up at 6:30. I usually ride my bike to school. It takes me about 25 minutes. Sometimes, when it rains, I take the bus. It's faster than riding a bike but not as interesting. I love riding because I can see many flowers on the way.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u4", "Unit 4", "Don't eat in class.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 规则与准则。
                        *   **深层意义**：本单元围绕“校规、家规、社会规则”展开。旨在引导学生理解“规则”的社会功能——规则不是束缚，而是对他人的尊重及对社会秩序的维护。培养学生的自律精神、责任感和契约意识，引导其成为文明、有教养的社会公民。

                        ### 2. 知识能力目标
                        - **语言能力**：熟练运用祈使句（Imperatives）发布指令或禁令；区分 `must` 与 `have to` 的语用差异。
                        - **社交素养**：能够客观、有礼貌地讨论及制定规则。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **规则动词**：listen (听), fight (打架), follow (遵守/跟随), arrive (到达), relax (放松), remember (记住)。
                        - **核心名词**：rule (规则), hallway (走廊), uniform (制服), kitchen (厨房), hair (头发), luck (运气)。
                        - **修饰语**：strict (严厉的), noisy (吵闹的), terrible (糟糕的), dirty (脏的), important (重要的)。

                        ### 2. 核心短语金牌储备
                        - `school rules` 校规
                        - `in class` 在课堂上
                        - `on time` 准时 (**对比：in time 及时**)
                        - `listen to` 听...
                        - `wear the school uniform` 穿校服
                        - `be strict with sb.` 对某人严厉
                        - `be strict in sth.` 对某事严格
                        - `make one's bed` 整理床铺
                        - `follow the rules` 遵守规则
                        - `keep one's hair short` 留短发
                        - `learn to do sth.` 学会做某事
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Don't eat in class. (不要在教室吃东西。)
                        - **【考点详解】**：否定祈使句。以 `Don't` 开头，后接动词原形。
                        
                        #### 2. We must arrive on time. (我们必须准时到达。)
                        - **【结构剖析】**：`must` 强调主观上的“必须”。
                        
                        #### 3. I have to help my mom make dinner. (我不得不帮我妈妈做晚饭。)
                        - **【词法精辨】**：`have to` 强调客观环境的“不得不”。
                        
                        #### 4. There are too many rules. (规则太多了。)
                        - **【辨析】**：`too many` + 可数名词复数；`too much` + 不可数名词。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：祈使句 (Imperatives)
                        **1. 肯定形式**：动词原形开头。 *Stand up!*
                        **2. 否定形式**：`Don't + 动词原形`。 *Don't run!*
                        **3. 特殊点**：`Be + 形容词`。 *Be quiet! / Don't be late!*

                        ### 核心语法二：must 与 have to 的区别
                        - **must**：说话人的主观要求。“我必须...”
                        - **have to**：客观因素导致。“我不得不...” (有三单、时态变化)
                        - **否定区别**：
                            *   `mustn't`：禁止、千万不能。
                            *   `don't have to`：不必（相当于 needn't）。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *— Must I finish the homework now? — No, you ________. You can do it tomorrow.*
                        A. mustn't   B. can't   C. needn't   D. shouldn't
                        
                        **[解析]**：对 must 的一般疑问句做否定回答，用 needn't 或 don't have to，选 **C**。

                        *(2023·北京中考)* *________ in the hallways. It's dangerous.*
                        A. Not run   B. No run   C. Don't run   D. Doesn't run
                        
                        **[解析]**：否定祈使句，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：校规/家规介绍 (Our Rules)
                        #### 1. 常用连接词
                        - Firstly / Secondly / Finally
                        - Besides / Also
                        - However (表示对规则的看法)

                        #### 2. 高分句式
                        - *We have too many rules in our school.*
                        - *We can't arrive late for class.*
                        - *We have to wear the school uniform every day.*
                        - *I think these rules are good for our study.*

                        #### 3. 满分范文
                        **Rules at My Home**
                        
                        I have a lot of rules at home. Firstly, I must get up before 7:00 every morning. Secondly, I can't play computer games on school nights. I have to do my homework first after school. Also, I must help my mother do the dishes after dinner. On weekends, I can't go out with my friends until I finish my homework. I think some rules are strict, but they help me develop good habits.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u5", "Unit 5", "Why do you like pandas?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自然 —— 自然界中的动物。
                        *   **深层意义**：本单元围绕“喜爱动物及其原因”展开。通过学习动物的特征形容词，引导学生学会多角度评价事物。更重要的是，通过介绍大象、熊猫等濒危动物的现状，激发学生的环保意识，培养尊重生命、人与自然和谐共生的价值观。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握描述性格与特征的形容词；熟练运用 `Why` 与 `Because` 进行因果表达。
                        - **情感态度**：能够描述并撰写关于动物保护的短文。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **动物类**：panda (熊猫), elephant (大象), lion (狮子), tiger (老虎), giraffe (长颈鹿), koala (树袋熊), cat (猫), dog (狗)。
                        - **描述词**：cute (可爱的), lazy (懒散的), smart (聪明的), beautiful (美丽的), scary (吓人的), shy (害羞的), friendly (友好的)。
                        - **程度副词**：very (很), really (真地), kind of (有一点)。
                        - **其他**：Africa (非洲), Thailand (泰国), flag (旗帜), place (地点), save (救助)。

                        ### 2. 核心短语金牌储备
                        - `kind of` 有一点；稍微
                        - `be friendly to sb.` 对某人友好
                        - `get lost` 迷路
                        - `be in (great) danger` 处于（极大）危险中
                        - `cut down` 砍倒
                        - `made of` 由...制成 (**对比：made from**)
                        - `one of ...` ...之一 (**必考：后接复数名词**)
                        - `symbol of ...` ...的象征
                        - `all day` 一整天
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Why do you like pandas? (你为什么喜欢熊猫？)
                        - **【考点详解】**：`Why` 引导的疑问句询问原因。回答必用 `Because`。
                        
                        #### 2. Because they're kind of interesting. (因为它们有点意思。)
                        - **【结构剖析】**：`kind of` 修饰形容词。
                        
                        #### 3. Where are they from? (它们来自哪里？)
                        - **【同义句】**：`Where do they come from?`。
                        
                        #### 4. We must save the trees and not buy things made of ivory. (我们必须拯救树木，不买象牙制品。)
                        - **【语法重点】**：`made of ivory` 是过去分词短语作后置定语，修饰 `things`。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：Why 引导的原因状语从句
                        **1. 问句**：`Why + 一般疑问句?`
                        **2. 答句**：`Because + 句子.` (注意：在英语中 because 和 so 不能同时出现在一个句子中)。

                        ### 核心语法二：形容词的语序
                        **规律**：程度副词 + 形容词。
                        *   *They are **really smart**.*
                        *   *He is **a little shy**.*

                        ### 中考真题特训
                        
                        *(2024·南京中考)* *— ________ don't you go to the zoo? — Because I have too much work to do.*
                        A. When   B. Where   C. Why   D. How
                        
                        **[解析]**：根据答语 because 可知，提问用 why，选 **C**。

                        *(2023·北京中考)* *Pandas are in danger ________ people cut down too many bamboo forests.*
                        A. but   B. so   C. because   D. although
                        
                        **[解析]**：后面是前面现象产生的原因，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我最喜欢的动物 (My Favorite Animal)
                        #### 1. 写作模板
                        - **Appearance**：What does it look like? (Size, color)
                        - **Personality**：What is it like? (Smart, lazy, shy)
                        - **Reason**：Why do you like it?
                        - **Protection**：How can we save it?

                        #### 2. 高分句式
                        - *My favorite animal is the panda.*
                        - *They are from China.*
                        - *They are black and white, and they look very cute.*
                        - *We should protect them because they are our friends.*

                        #### 3. 满分范文
                        **The Elephant**
                        
                        My favorite animal is the elephant. They are from Africa and Thailand. Elephants are very big and strong. They have long noses and big ears. I like them because they are very smart. They can play music and draw. They can also remember places with food and water. But now, elephants are in great danger. People kill them for their ivory. We must save the elephants and not buy ivory products.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u6", "Unit 6", "I'm watching TV.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 日常生活。
                        *   **深层意义**：本单元聚焦“当下发生的活动”。通过描述家庭成员和朋友正在做的事情，学习现在进行时。旨在培养学生细致观察生活的能力，学会与他人分享实时状态，并在跨文化语境中（如龙舟节）通过描述活动场景，感受中外文化习俗。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握现在进行时（Present Continuous）的构成及用法；掌握动词 `-ing` 的变化规则；熟悉电话交际用语。
                    """.trimIndent()),

                    UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **实时动作**：read (读), clean (打扫), wash (洗), watch (看), exercise (锻炼), cook (做饭), swim (游泳), shop (购物), sleep (睡觉)。
                        - **场所**：house (房子), apartment (公寓), supermarket (超市), library (图书馆), pool (游泳池)。
                        - **时间/状态**：now (现在), right now (此刻)。
                        - **节日/文化**：Dragon Boat Festival (端午节), zongzi (粽子)。

                        ### 2. 核心短语金牌储备
                        - `watch TV` 看电视
                        - `read a book` 看书
                        - `clean the house` 打扫房子
                        - `do homework` 做作业
                        - `make soup` 做汤
                        - `talk on the phone` 通电话
                        - `listen to a CD` 听唱片
                        - `go to the movies` 去看电影
                        - `wash the dishes` 洗碗
                        - `wish to do sth.` 希望做某事
                    """.trimIndent()),

                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What are you doing? (你在干什么？)
                        - **【考点详解】**：现在进行时的特殊疑问句。`be + 主语 + v.-ing`。
                        
                        #### 2. I'm watching TV. (我正在看电视。)
                        - **【结构剖析】**：`am/is/are + v.-ing`。
                        
                        #### 3. This is Jenny. (我是珍妮。)
                        - **【电话用语】**：在电话中指代自己用 `This is...`，询问对方用 `Is that ...?` 或 `Who's that?`。
                        
                        #### 4. I miss my family. (我想念我的家人。)
                        - **【用法拓展】**：`miss` 既可以表示“思念”，也可以表示“错过”。
                    """.trimIndent()),

                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：现在进行时 (Present Continuous)
                        **1. 功能**：表示现在或现阶段正在进行的动作。
                        **2. 构成**：`am / is / are + 动词的现在分词 (v.-ing)`。
                        **3. v.-ing 变化规则**：
                        *   直接加 ing：*reading, watching*。
                        *   去不发音e加 ing：*making, writing*。
                        *   双写末尾辅音加 ing (重读闭音节)：*swimming, running, shopping, sitting*。
                        **4. 标志词**：`now`, `right now`, `Look!`, `Listen!`。

                        ### 中考真题特训
                        
                        *(2024·天津中考)* *— Where is your father? — He ________ the car in the yard.*
                        A. wash   B. washes   C. is washing   D. washed
                        
                        **[解析]**：根据语境“他在哪”可知是在问“正在做什么”，选 **C**。

                        *(2023·北京中考)* *Listen! The birds ________ in the trees.*
                        A. sing   B. sang   C. are singing   D. will sing
                        
                        **[解析]**：Listen! 提示用现在进行时，选 **C**。
                    """.trimIndent()),

                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：实时场景描述 (What is everyone doing?)
                        #### 1. 写作思路
                        - **时间背景**：It is 8:00 p.m. now.
                        - **人物活动**：依次描述爸爸、妈妈、哥哥和我正在做什么。
                        - **氛围评价**：We are all busy. / We are having fun.

                        #### 2. 高分句式
                        - *Look! My family are all busy at home.*
                        - *My mother is cooking in the kitchen.*
                        - *My brother and I are doing our homework.*
                        - *We are all enjoying our evening.*

                        #### 3. 满分范文
                        I'ts a beautiful Sunday morning. My family are all at home. Look! My father is reading a newspaper on the sofa. My mother is washing the clothes in the bathroom. What about my brother? He is playing with his toy car. I am cleaning my room. Our dog is sleeping under the table. We are all busy but we are having a great time.
                        """.trimIndent())
                        )
                        ),
                        TextbookUnit(
                        "g7down_u7", "Unit 7", "It's raining!",
                        listOf(
                        UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自然 —— 天气与人类活动。
                        *   **深层意义**：本单元围绕“天气状况及人们在不同天气下的活动”展开。旨在引导学生观察自然现象，理解气候对人类生活方式的影响。通过对比全球不同地点的天气（如多伦多的寒冷与悉尼的阳光），培养学生的全球意识和对地理空间的认知。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握描述天气的形容词及动词；熟练运用 `How's the weather?` 与 `What's the weather like?`；掌握现在进行时在描述实时天气活动中的进阶应用。
                        - **文化意识**：了解不同地区的代表性季节景观。
                        """.trimIndent()),

                        UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **天气形容词 (名词+y)**：rainy (下雨的), snowy (下雪的), cloudy (多云的), sunny (晴朗的), windy (多风的)。
                        - **气温形容词**：hot (热), cold (冷), warm (暖和), cool (凉爽)。
                        - **天气动词**：rain (下雨), snow (下雪)。
                        - **描述状态**：dry (干的), humid (潮湿的), bad (坏的), terrible (糟糕的)。
                        - **地点与物品**：mountain (山), vacation (假期), postcard (明信片)。

                        ### 2. 核心短语金牌储备
                        - `on vacation` 在度假
                        - `take a photo / take photos` 拍照
                        - `have a good time` 玩得开心 (同义: have fun / enjoy oneself)
                        - `write a postcard to sb.` 给某人写明信片
                        - `by the pool` 在游泳池旁
                        - `talk on the phone` 通电话
                        - `How's it going?` 最近怎么样？
                        - `just so-so` 普普通通
                        - `right now` 此刻；现在
                        - `sit by the fire` 坐在火炉旁
                        """.trimIndent()),

                        UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. How's the weather in Beijing? (北京的天气怎么样？)
                        - **【考点详解】**：`How's` 是 `How is` 的缩写。用于询问天气状况。
                        - **【同义转换】**：`What's the weather like in Beijing?` (**必考：like是介词，不能丢**)

                        #### 2. How's it going? (最近怎么样？)
                        - **【用法拓展】**：社交常用问候语。回答常用：`Great!`, `Not bad.`, `Terrible!`, `Just so-so.`。

                        #### 3. I'm having a great time visiting my aunt. (我正在探望姑姑，过得很愉快。)
                        - **【句式剖析】**：`have a great time (in) doing sth.` 做某事过得愉快。

                        #### 4. It's windy and cold. (天气又刮风又冷。)
                        - **【语法延伸】**：在描述天气时，`it` 是非人称代词，不指代具体事物。
                        """.trimIndent()),

                        UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：询问天气的表达法
                        **1. 结构对比**：
                        - `How is the weather?`
                        - `What is the weather like?`

                        ### 核心语法二：名词变形容词的 -y 后缀
                        **构词规则**：
                        - 直接加 y：*rain -> rainy, cloud -> cloudy, wind -> windy*。
                        - 双写加 y：*sun -> sunny, fog -> foggy*。

                        ### 中考真题特训

                        *(2024·南京中考)* *— ________ the weather like in Kunming? — It's always like spring.*
                        A. How's   B. What's   C. Where's   D. Why's

                        **[解析]**：结尾有 like，提问用 What's，选 **B**。

                        *(2023·河北中考)* *Look! It's ________ outside. Let's go out and make a snowman.*
                        A. raining   B. snowing   C. blowing   D. shining

                        **[解析]**：根据“堆雪人”可知是在下雪，选 **B**。
                        """.trimIndent()),

                        UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：旅游日记/明信片 (A Postcard/Diary)
                        #### 1. 写作框架
                        - **第一部分：交代地点与天气**。 (I'm in... now. The weather is...)
                        - **第二部分：描述正在进行的活动**。 (Many people are... My family is...)
                        - **第三部分：抒发情感**。 (I'm having a good time. I miss you.)

                        #### 2. 高分句式
                        - *The weather here is warm and sunny.*
                        - *I am sitting on the beach and drinking orange juice.*
                        - *Some people are taking photos by the lake.*
                        - *Wish you were here!*

                        #### 3. 满分范文
                        **A Postcard to a Friend**

                        Dear Jane,
                        I am on vacation in Sanya now. The weather is sunny and hot. I am sitting by the pool and drinking a cold drink. My parents are swimming in the pool. Many people are taking photos on the beach. Everyone is having a great time. I miss you and I want to buy some gifts for you. See you soon!
                        Love, Li Hua
                        """.trimIndent())
                        )
                        ),
                        TextbookUnit(
                        "g7down_u8", "Unit 8", "Is there a post office near here?",
                        listOf(
                        UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 社区生活。
                        *   **深层意义**：本单元聚焦“社区环境与问路”。通过学习社区场所名词及方位介词，引导学生关注生活环境，培养空间规划能力。更重要的是培养学生助人为乐的精神和在公共场所礼貌交流的社交能力，增强社会责任感。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握 `There be` 结构；熟练使用方位介词（next to, across from, between...and...）；掌握礼貌问路及指路。
                        """.trimIndent()),

                        UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **社区场所**：post office (邮局), police station (警察局), hotel (旅馆), restaurant (餐馆), bank (银行), hospital (医院), street (街道), park (公园)。
                        - **方位介词**：near (在...附近), behind (在...后面), front (前面), across (穿过), between (在...之间)。
                        - **其他**：town (城镇), forest (森林), money (钱), pay (付费)。

                        ### 2. 核心短语金牌储备
                        - `in front of` 在...（外部）的前面 (**对比: in the front of 在内部的前面**)
                        - `next to` 紧挨着
                        - `across from` 在...对面
                        - `between ... and ...` 在...和...之间
                        - `turn left/right` 向左/右转
                        - `go straight` 直走
                        - `on the right/left` 在右边/左边
                        - `pay phone` 公用电话
                        - `post office` 邮局
                        """.trimIndent()),

                        UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Is there a post office near here? (这附近有邮局吗？)
                        - **【考点详解】**：`There be` 结构的一般疑问句。`Is/Are there ...?`。

                        #### 2. The bank is across from the library. (银行在图书馆对面。)
                        - **【结构剖析】**：方位介词 `across from` 用于描述两个建筑物的相对位置。

                        #### 3. Go straight and turn left at the first crossing. (直走，在第一个十字路口左转。)
                        - **【指路核心】**：祈使句指路。注意 `at the first crossing` 这个时间点状语。

                        #### 4. I love to watch the monkeys climbing around. (我喜欢看猴子到处爬。)
                        - **【语法延伸】**：`watch sb. doing sth.` 强调看某人正在做某事。
                        """.trimIndent()),

                        UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：There be 结构
                        **1. 功能**：表示“某地存在某物”。
                        **2. 主谓一致（就近原则）**：`There is a pen and two books.` / `There are two books and a pen.`
                        **3. 否定/疑问**：`There isn't/aren't...` / `Is/Are there...?`

                        ### 核心语法二：方位介词辨析
                        - **in front of**：在物体外部的前面。
                        - **in the front of**：在物体内部的前面。

                        ### 中考真题特训

                        *(2024·天津中考)* *— ________ a bank near the supermarket? — Yes, it's just across from it.*
                        A. Is it   B. Is there   C. Are there   D. Are they

                        **[解析]**：询问“某处有某物吗”，选 **B**。

                        *(2023·广东中考)* *There ________ a meeting tomorrow afternoon.*
                        A. is going to be   B. will have   C. is going to have   D. will be have

                        **[解析]**：There be 的将来时结构为 There is/are going to be 或 There will be，选 **A**。
                        """.trimIndent()),

                        UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍我的社区 (My Neighborhood)
                        #### 1. 写作要点
                        - **总述**：My neighborhood is very beautiful and quiet.
                        - **布局描述**：使用 There be 和方位介词描述场所位置。
                        - **活动描述**：我们在公园做什么，在图书馆做什么。
                        - **情感表达**：I like my neighborhood.

                        #### 2. 高分句式
                        - *There is a big supermarket across from my home.*
                        - *Next to the bank, there is a small library.*
                        - *My house is between the park and the post office.*
                        - *I enjoy spending time there with my friends.*

                        #### 3. 满分范文
                        **My Neighborhood**

                        I live in a very convenient neighborhood. There is a big supermarket and a bank near my house. Across from the supermarket, there is a beautiful park. I often go for a walk there after dinner. Next to the park, there is a library. It is quiet and I like reading books there. My house is between the post office and a restaurant. The people here are very friendly. I love living here.
                        """.trimIndent())
                        )
                        ),
                        TextbookUnit(
                        "g7down_u9", "Unit 9", "What does he look like?",
                        listOf(
                        UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 个人特征描述。
                        *   **深层意义**：本单元围绕“外貌描述”展开。旨在引导学生学会客观、细致地观察并描述人物形象。教育价值在于通过讨论外貌，引导学生建立正确的审美观，理解“不以貌取人”的重要性，同时在描述他人时表现出尊重和礼貌。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握描述身高、体型、发型的形容词；熟练区分 `be` 动词（描述整体）与 `have/has`（描述局部特征）的用法。
                        """.trimIndent()),

                        UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **身高/体型**：tall (高), short (矮), thin (瘦), heavy (重), medium (中等的), build (身材), height (高度)。
                        - **头发特征**：straight (直的), curly (卷的), long (长的), short (短的), blonde (金发的), brown (棕色的)。
                        - **其他特征**：glasses (眼镜), beard (胡须), uniform (制服), face (脸), eye (眼睛), nose (鼻子)。
                        - **描述词**：handsome (英俊的), beautiful (美丽的), cute (可爱的)。

                        ### 2. 核心短语金牌储备
                        - `be of medium build` 中等身材
                        - `be of medium height` 中等身高
                        - `straight hair` 直发
                        - `curly hair` 卷发
                        - `wear glasses` 戴眼镜
                        - `go to the movies` 看电影
                        - `look like` 看起来像
                        - `a little bit` 一点点；稍微
                        - `at the end` 在最后
                        - `the same as` 与...一样
                        """.trimIndent()),

                        UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What does he look like? (他长什么样？)
                        - **【考点详解】**：询问外貌的标准句型。
                        - **【辨析必备】**：
                            *   `What does he look like?` (外貌)
                            *   `What is he like?` (性格/品质)
                            *   `What does he like?` (喜好)

                        #### 2. She has long straight black hair. (她留着黑色的长直发。)
                        - **【考点详解】**：多个形容词修饰名词顺序。**长短 + 形状 + 颜色 + 头发**。

                        #### 3. He is of medium height. (他是中等身高。)
                        - **【结构剖析】**：`be of + 特征名词` 结构。

                        #### 4. The person with glasses is my teacher. (那个戴眼镜的人是我的老师。)
                        - **【语法延伸】**：`with glasses` 是介词短语作后置定语。
                        """.trimIndent()),

                        UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：描述外貌的动词分工
                        **1. be 动词组**：描述身高、体型。
                        *   *He **is** tall/short/thin/heavy.*
                        **2. have/has 动词组**：描述发型、五官、配饰。
                        *   *She **has** long hair / big eyes.*
                        *   *He **has** a beard.*

                        ### 核心语法二：形容词排序
                        **口诀**：长短、形状、颜色。
                        *   *a long(长短) straight(形状) black(颜色) hair.*

                        ### 中考真题特训

                        *(2024·南京中考)* *My sister ________ short and ________ big eyes.*
                        A. is; is   B. has; has   C. is; has   D. has; is

                        **[解析]**：身高用 is，眼睛特征用 has，选 **C**。

                        *(2023·河北中考)* *— Who is the girl ________ long hair? — She is my cousin.*
                        A. with   B. in   C. of   D. for

                        **[解析]**：with 表示“具有...特征”，选 **A**。
                        """.trimIndent()),

                        UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：描述我的一位朋友 (My Friend)
                        #### 1. 写作逻辑
                        - **基本信息**：Name, age, job.
                        - **整体外貌**：Height and build.
                        - **细节特征**：Hair, eyes, glasses.
                        - **性格/穿着**：Character and clothes.

                        #### 2. 高分句式
                        - *He is a 13-year-old boy.*
                        - *He is of medium height and a little bit heavy.*
                        - *He has short curly brown hair.*
                        - *He always wears a red T-shirt and blue jeans.*

                        #### 3. 满分范文
                        **My Best Friend**

                        My best friend is Li Hua. He is 14 years old. He is a handsome boy. Li Hua is very tall and he is of medium build. He has short straight black hair and big eyes. He doesn't wear glasses. He always wears a white school uniform. Li Hua is very friendly and smart. We often play basketball together after school. Everyone likes him very much.
                        """.trimIndent())
                        )
                        ),
                        TextbookUnit(
                        "g7down_u10", "Unit 10", "I'd like some noodles.",
                        listOf(
                        UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 饮食与健康。
                        *   **深层意义**：本单元围绕“订餐”与“食物喜好”展开。旨在引导学生掌握在公共服务场所（餐厅）的交际技能。通过对比中西饮食文化（如生日面与生日蛋糕），增强文化包容性。同时引导学生形成健康的饮食习惯，理解均衡营养的重要性。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握食物名词（含可数与不可数）；熟练运用 `would like` 表达意愿；掌握餐厅订餐的典型交际用语。
                        """.trimIndent()),

                        UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **肉类/蛋类**：mutton (羊肉), beef (牛肉), chicken (鸡肉), egg (鸡蛋)。
                        - **蔬菜类**：cabbage (卷心菜), potato (土豆), tomato (西红柿), carrot (胡萝卜), onion (洋葱)。
                        - **主食/饮品**：noodles (面条), rice (米饭), porridge (粥), soup (汤), pancake (薄烤饼), juice (果汁)。
                        - **规格/描述**：size (尺寸), bowl (碗), large (大号), medium (中号), small (小号), special (特色菜)。

                        ### 2. 核心短语金牌储备
                        - `would like` 想要
                        - `what kind of ...` 哪种...
                        - `take one's order` 点菜
                        - `a bowl of ...` 一碗...
                        - `around the world` 全世界
                        - `be a symbol of ...` 是...的象征
                        - `make a wish` 许愿
                        - `cut up` 切碎
                        - `come true` 实现
                        - `birthday noodles` 长寿面
                        """.trimIndent()),

                        UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. I'd like some noodles. (我想要点面条。)
                        - **【考点详解】**：`I'd like` 是 `I would like` 的缩写。
                        - **【用法拓展】**：
                            *   `would like sth.` (想要某物)
                            *   `would like to do sth.` (想要做某事)

                        #### 2. What kind of noodles would you like? (你想要哪种面条？)
                        - **【考点详解】**：`what kind of` 询问种类。

                        #### 3. What size bowl of noodles would you like? (你想要多大碗的面条？)
                        - **【结构剖析】**：`what size` 询问规格。

                        #### 4. The number of people is increasing. (人数正在增加。)
                        - **【语法延伸】**：`the number of ...` ( ...的数量) 谓语用单数。对比 `a number of ...` (许多) 谓语用复数。
                        """.trimIndent()),

                        UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：would like 的句式变换
                        - **肯定句**：I'd like a large bowl.
                        - **疑问句**：`Would you like some tea?` (注意：表示请求/邀请时，用 some 而非 any)。
                        - **回答**：Yes, please. / No, thanks.

                        ### 核心语法二：可数与不可数名词
                        - **不可数**：beef, mutton, meat, rice, juice, porridge. (数量表达：`a glass of...`)
                        - **可数**：potato(es), tomato(es), egg(s), pancake(s). (复数规律：土豆西红柿加 -es)。

                        ### 中考真题特训

                        *(2024·上海中考)* *Would you like ________ to eat?*
                        A. something healthy   B. healthy something   C. anything healthy   D. healthy anything

                        **[解析]**：would you like 引导的请求句用 something，且形容词后置，选 **A**。

                        *(2023·广东中考)* *— I'd like two ________ of apple juice. — Here you are.*
                        A. glass   B. cup   C. glasses   D. bowl

                        **[解析]**：量词修饰不可数名词，数词 two 后接复数，选 **C**。
                        """.trimIndent()),

                        UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：介绍中国传统美食 (Chinese Traditional Food)
                        #### 1. 写作思路
                        - **名称与食材**：Name of the food and ingredients.
                        - **制作/吃法**：How to make/eat it.
                        - **文化寓意**：What does it mean? (Symbol of good luck/long life).
                        - **情感**：I like it very much.

                        #### 2. 高分句式
                        - *In China, people often eat dumplings during festivals.*
                        - *Dumplings are made of flour, meat and vegetables.*
                        - *They are a symbol of luck and wealth.*
                        - *I hope everyone can have a taste of Chinese food.*

                        #### 3. 满分范文
                        **Zongzi**

                        Zongzi is a traditional Chinese food. People always eat it during the Dragon Boat Festival. It is made of sticky rice and different fillings like meat, beans or nuts. They are wrapped in bamboo or reed leaves. In my hometown, people think Zongzi is a symbol of luck. I like eating Zongzi because it is very delicious and healthy. If you come to China, you must have a taste!
                        """.trimIndent())
                        )
                        ),
                        TextbookUnit(
                        "g7down_u11", "Unit 11", "How was your school trip?",
                        listOf(
                        UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 过往经历。
                        *   **深层意义**：本单元聚焦“学校远足与科学探索”。通过描述参观农场、博物馆等经历，学习一般过去时。旨在引导学生走出课堂，探索自然与科学的奥秘。培养学生记录生活、分享快乐的能力，同时在总结行程中提升批判性思维（评价好坏及其原因）。

                        ### 2. 知识能力目标
                        - **语言能力**：掌握一般过去时（Simple Past Tense）的基本构成；熟练掌握 `be` 动词及部分常用动词的过去式变化；掌握评价性形容词。
                        """.trimIndent()),

                        UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **过去式核心动词**：milked (挤奶), farmed (务农), fed (喂养), rode (骑), saw (看见), went (去), took (拿)。
                        - **场所**：farm (农场), museum (博物馆), fire station (消防站), gift shop (礼品店)。
                        - **评价词**：excellent (极好的), exciting (令人兴奋的), interesting (有趣的), expensive (昂贵的), cheap (便宜的), slow (慢的), fast (快的)。
                        - **自然物**：sun (太阳), flower (花), robot (机器人), guide (导游)。

                        ### 2. 核心短语金牌储备
                        - `go for a walk` 去散步
                        - `milk a cow` 挤牛奶
                        - `ride a horse` 骑马
                        - `feed chickens` 喂鸡
                        - `take photos` 拍照
                        - `quite a lot` 许多
                        - `all in all` 总的来说
                        - `be interested in ...` 对...感兴趣
                        - `learn a lot about ...` 学到很多关于...
                        - `fire station` 消防站
                        """.trimIndent()),

                        UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. How was your school trip? (你的学校郊游怎么样？)
                        - **【考点详解】**：`was` 是 `is` 的过去式。用于询问过去的感受。

                        #### 2. Did you see any cows? (你看到牛了吗？)
                        - **【考点详解】**：一般过去时的一般疑问句。助动词 `Did` 提至句首，谓语动词变原形。

                        #### 3. It was so much fun! (那真是太有趣了！)
                        - **【用法拓展】**：`fun` 是不可数名词，前接 `so much`。

                        #### 4. I learned quite a lot about science. (我学到了许多关于科学的知识。)
                        - **【结构剖析】**：`quite a lot` 相当于 `very much` 或 `a lot`。
                        """.trimIndent()),

                        UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：一般过去时 (Simple Past Tense) - be 动词
                        **1. 构成**：
                        - I/He/She/It + **was**
                        - We/You/They + **were**
                        **2. 句式变化**：
                        - 否定：`wasn't / weren't`
                        - 疑问：`Was / Were` 提前。

                        ### 核心语法二：实义动词的过去式
                        - **规则变化**：直接加 ed。 (*milked, farmed*)
                        - **不规则变化**：(*ride -> rode, see -> saw, go -> went, feed -> fed, take -> took*)。

                        ### 中考真题特训

                        *(2024·河北中考)* *— ________ your trip to the Science Museum? — It was great!*
                        A. How's   B. How was   C. What's   D. What was

                        **[解析]**：答语是过去时，问句也要用过去时，选 **B**。

                        *(2023·北京中考)* *Last Sunday, we ________ to the farm and picked some apples.*
                        A. go   B. goes   C. went   D. will go

                        **[解析]**：Last Sunday 是明确的过去时间标志，且 pick 用了过去式，选 **C**。
                        """.trimIndent()),

                        UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：我的学校出游记 (My School Trip)
                        #### 1. 写作三部曲
                        - **When & Where**：什么时候去的，去了哪里。
                        - **What did you do?**：按顺序描述所做的事情（使用 First, Then, After that）。
                        - **Feeling**：对这次旅行的总体评价。

                        #### 2. 高分句式
                        - *Last Friday, we went to the farm for our school trip.*
                        - *The weather was sunny and warm.*
                        - *First, the farmer showed us around.*
                        - *The best part was feeding the animals.*
                        - *All in all, it was an exciting and educational trip.*

                        #### 3. 满分范文
                        **A Trip to the Science Museum**

                        Yesterday, our school organized a trip to the Science Museum. We arrived there at 9:00 a.m. First, we saw some amazing robots. They could talk and dance. Then, our teacher showed us some old inventions. I learned a lot about science history. After that, we went to the gift shop and I bought a robot toy. All in all, the trip was excellent. It was not only interesting but also educational. I had a great time!
                        """.trimIndent())
                        )
                        ),
                        TextbookUnit(
                        "g7down_u12", "Unit 12", "What did you do last weekend?",
                        listOf(
                        UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 周末生活与意外事件。
                        *   **深层意义**：作为本册书的最后一个单元，它对“一般过去时”进行了全面的整合。除了常规活动，还引入了“探险与意外”情境（如在帐篷里遇到蛇）。旨在引导学生学会用英语叙述完整的故事，培养面对意外时的冷静心态，以及热爱生活、敢于探索的精神。

                        ### 2. 知识能力目标
                        - **语言能力**：全面掌握一般过去时的各种句式；熟记更多不规则动词的过去式；能够运用逻辑连接词（Suddenly, so...that...）叙述故事。
                        """.trimIndent()),

                        UnitDetailSection("💡 词汇短语全方位解析", """
                        ### 1. 重点单词分类
                        - **活动词汇**：camp (露营), boat (划船), badminton (羽毛球), sheep (绵羊)。
                        - **动物/自然**：butterfly (蝴蝶), mouse (老鼠), baby (婴儿), snake (蛇), forest (森林), moon (月亮)。
                        - **核心动词/形容词**：shout (呼喊), jump (跳), wake (醒), stay (停留), scary (吓人的)。
                        - **其他**：language (语言), surprise (惊讶)。

                        ### 2. 核心短语金牌储备
                        - `stay up late` 熬夜
                        - `go camping` 去露营
                        - `go boating` 去划船
                        - `run away` 逃跑；跑掉
                        - `shout at sb.` 对某人大声喊叫
                        - `wake up` 醒来
                        - `put up` 搭起；举起
                        - `make a fire` 生火
                        - `each other` 互相
                        - `so ... that ...` 如此...以至于...
                        """.trimIndent()),

                        UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What did you do last weekend? (你上周末做什么了？)
                        - **【考点详解】**：一般过去时的特殊疑问句，询问过去发生的具体动作。

                        #### 2. How was your weekend? (你的周末过得怎么样？)
                        - **【考点详解】**：询问过去状态的常用句型。

                        #### 3. We were so scared that we couldn't move. (我们如此害怕以至于动弹不得。)
                        - **【句式金牌】**：`so + adj. + that + 句子` 引导结果状语从句。

                        #### 4. I saw a big snake looking at me. (我看到一条大蛇正盯着我看。)
                        - **【语法延伸】**：`see sb. doing sth.` 强调看见某人正在做某事。
                        """.trimIndent()),

                        UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：一般过去时的终极总结
                        **1. 常见标志词**：`yesterday`, `last weekend/year`, `... ago`, `just now`。
                        **2. 句式汇总**：
                        - 肯定句：主语 + v.-ed.
                        - 否定句：`主语 + didn't + v. (原形)`。
                        - 疑问句：`Did + 主语 + v. (原形) ...?`
                        **3. 读音规律**：
                        - [t]：清辅音结尾 (*looked*)。
                        - [d]：浊辅音/元音结尾 (*stayed*)。
                        - [id]：t/d 结尾 (*wanted, shouted*)。

                        ### 中考真题特训

                        *(2024·天津中考)* *I ________ a letter to my friend last night.*
                        A. write   B. writes   C. wrote   D. will write

                        **[解析]**：last night 提示过去时，write 的过去式是 wrote，选 **C**。

                        *(2023·江苏中考)* *— Did you go to the zoo yesterday? — No, I ________. I ________ at home.*
                        A. didn't; stay   B. don't; stay   C. didn't; stayed   D. don't; stayed

                        **[解析]**：问句是过去时，答句否定用 didn't，陈述过去事实用 stayed，选 **C**。
                        """.trimIndent()),

                        UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：一个难忘的周末 (A Memorable Weekend)
                        #### 1. 写作要素
                        - **六要素**：Who, When, Where, What, Why, How.
                        - **故事情节**：起因 -> 经过 -> 高潮（意外） -> 结果。
                        - **细节描写**：使用形容词描述感受。

                        #### 2. 高分句式
                        - *Last weekend was the most exciting one I ever had.*
                        - *Suddenly, something unexpected happened.*
                        - *I was so surprised that I couldn't say a word.*
                        - *From this experience, I learned that...*

                        #### 3. 满分范文
                        **An Unexpected Weekend**

                        Last weekend, I went camping in the forest with my brother. On Saturday afternoon, we put up our tent and made a fire. We were very happy. However, in the middle of the night, I woke up because I heard a strange sound. I saw a big snake coming into our tent! We were so scared that we ran away quickly and shouted for help. Luckily, my father came and helped us. It was a scary but unforgettable weekend. I will never forget it!
                        """.trimIndent())
                        )
                        )
                        )
                        )
                        }
