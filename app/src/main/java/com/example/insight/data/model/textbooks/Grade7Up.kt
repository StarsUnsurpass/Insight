package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade7Up {
    val data = Textbook(
        id = "g7_up",
        grade = "七年级",
        term = "上册",
        coverColor = Color(0xFFE3F2FD),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/sc7x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g7up_s1", "Starter Unit 1", "Hello!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 结交新朋友与问候。
                        *   **深层意义**：作为初中英语的起点，本单元通过最基础的问候语，引导学生跨出社交的第一步，培养礼貌交往的意识。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **unit** /'juːnɪt/ n. 单元
                        **starter** /'stɑːtə(r)/ n. 第一步；开端
                        **starter unit** 过渡单元
                        **section** /'sekʃn/ n. 部分；地区
                        **greet** /ɡriːt/ v. 招呼；问候
                        **everyone** /'evriwʌn/ pron. 每人；所有人
                        **start** /stɑːt/ v. 开始；着手
                        **conversation** /ˌkɒnvə'seɪʃn/ n. 谈话；交谈
                        **spell** /spel/ v. 用字母拼；拼写
                        **oh** /əʊ/ interj. 哦；啊
                        **bell** /bel/ n. 铃（声）；钟（声）
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲与核心考点", """
                        *   **greet**：常用结构 *greet sb. with a smile*。
                        *   **everyone**：复合不定代词，谓语用单数。
                        *   **拼写句型**：*How do you spell your name?*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_s2", "Starter Unit 2", "Keep Tidy!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 生活习惯（整洁）。
                        *   **深层意义**：引导学生学会整理个人物品，养成良好的生活自理习惯。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **bottle** /'bɒtl/ n. 瓶子
                        **eraser** /ɪ'reɪzə(r)/ n. 橡皮
                        **key** /kiː/ n. 钥匙；关键
                        **thing** /θɪŋ/ n. 东西；事情
                        **need** /niːd/ v. & n. 需要
                        **You're welcome.** 别客气；不用谢。
                        **tidy** /'taɪdi/ adj. 整洁的；整齐的
                        **where** /weə(r)/ adv. 在哪里
                        **can** /kæn/ modal v. 能；会
                        **find** /faɪnd/ v. 找到；发现
                        **lost** /lɒst/ adj. 丢失的
                        **found** /faʊnd/ v. (find的过去式)
                        **lost and found** 失物招领（处）
                        **please** /pliːz/ interj. 请
                        **schoolbag** /'skuːlbæɡ/ n. 书包
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲与核心考点", """
                        *   **There be 句型**：初步接触物体的存在表达。
                        *   **Where 引导的疑问句**：询问位置。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_s3", "Starter Unit 3", "Welcome!",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **fun** /fʌn/ n. 乐趣；快乐
                        **yard** /jɑːd/ n. 院子；园圃
                        **carrot** /'kærət/ n. 胡萝卜
                        **goose** /ɡuːs/ n. 鹅
                        **geese** /ɡiːs/ n. (goose的复数)
                        **count** /kaʊnt/ v. 数数
                        **another** /ə'nʌðə(r)/ adj. & pron. 另一；又一
                        **else** /els/ adv. 其他的；别的
                        **look** /lʊk/ v. 看；瞧
                        **look at** 看；瞧
                        **circle** /'sɜːkl/ v. 圈出 n. 圆形
                        **welcome** /'welkəm/ adj. & v. 欢迎
                        **tomato** /tə'mɑːtəʊ/ n. 西红柿
                        **potato** /pə'teɪtəʊ/ n. 马铃薯；土豆
                        **animal** /'ænɪml/ n. 动物
                        **many** /'meni/ adj. & pron. 许多
                        **how many** 多少
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u1", "Unit 1", "You and Me",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境与价值导向
                        *   **主题语境**：人与自我 —— 个人爱好与特长。
                        *   **深层意义**：本单元旨在引导学生发现自身潜能，建立自信。通过社团招新的情境，培养学生的社会参与意识与团队协作精神。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **each** /iːtʃ/ adj. & pron. 每个；各自
                        **other** /ˈʌðə(r)/ pron. & adj. 另外的人（或物）；另外的
                        **each other** 互相；彼此
                        **full** /fʊl/ adj. 完整的；满的
                        **full name** 全名
                        **grade** /ɡreɪd/ n. 年级；等级
                        **last** /lɑːst/ adj. 最近的；最后的；末尾
                        **last name** 姓氏
                        **classmate** /ˈklɑːsmeɪt/ n. 同班同学
                        **class teacher** 班主任
                        **first** /fɜːst/ adj. & n. 第一；最初
                        **first name** 名字
                        **mistake** /mɪˈsteɪk/ n. 错误；失误
                        **country** /ˈkʌntri/ n. 国家
                        **same** /seɪm/ adj. 相同的
                        **twin** /twɪn/ n. & adj. 双胞胎之一；双胞胎之一的
                        **both** /bəʊθ/ adj. & pron. 两个；两个都
                        **band** /bænd/ n. 乐队
                        **pot** /pɒt/ n. 锅
                        **hot pot** 火锅
                        **a lot** 很；非常
                        **tofu** /ˈtəʊfuː/ n. 豆腐
                        **parrot** /ˈpærət/ n. 鹦鹉
                        **guitar** /ɡɪˈtɑː(r)/ n. 吉他
                        **tennis** /ˈtenɪs/ n. 网球
                        **post** /pəʊst/ n. & v. 帖子；邮寄；发布
                        **even** /ˈiːvn/ adv. 甚至；连
                        **hey** /heɪ/ interj. 嘿；喂
                        **would** /wʊd/ modal v. 想（用于礼貌邀请）
                        **would like to** 想要
                        **information** /ˌɪnfəˈmeɪʃn/ n. 信息
                        **hobby** /ˈhɒbi/ n. 爱好

                        **[专有名词]**
                        **Green** /ɡriːn/ 格林（姓）
                        **UK** /ˌjuː ˈkeɪ/ 英国
                        **US** /ˌjuː ˈes/ 美国
                        **Smith** /smɪθ/ 史密斯（姓）
                        **Lisa** /ˈliːsə/ 莉萨（女名）
                        **Tom** /tɒm/ 汤姆（男名）
                        **Sally** /ˈsæli/ 萨莉（女名）
                        **Wood** /wʊd/ 伍德（姓）
                        **Sydney** /ˈsɪdni/ 悉尼（澳大利亚城市）
                        **Australia** /ɒˈstreɪliə/ 澳大利亚
                        **Singapore** /ˌsɪŋəˈpɔː(r)/ 新加坡
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. What club do you want to join? (你想加入什么社团？)
                        - **【结构剖析】**：`want to do sth.` 想要做某事。`join` 指加入某个组织或团体。
                        
                        #### 2. Are you good with kids? (你善于和孩子们相处吗？)
                        - **【词法精辨】**：
                            *   `be good at`：擅长...
                            *   `be good with`：善于对待.../与...相处得好。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：情态动词 can
                        **1. 基本用法**
                        *   表示能力 (Ability)：*I can swim.*
                        **2. 句式结构**
                        - **肯定句**：主语 + can + 动词原形.
                        - **否定句**：主语 + can't + 动词原形.

                        ### 中考真题特训
                        *(2024·南京中考)* *— ________ you play the violin? — Yes, I ________.*
                        A. Can; can   B. Do; do   C. Must; must   D. Should; should
                        **[解析]**：询问能力，选 **A**。
                    """.trimIndent()),
                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：自我介绍 (Self-introduction)
                        **满分范文**：
                        Hello, everyone! My name is Li Hua. I am 13 years old. I am in Grade 7. My first name is Hua and my last name is Li. I like music very much and I can play the guitar. My hobby is playing tennis. I want to make friends with you.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u2", "Unit 2", "We're Family!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 家庭成员与亲情。
                        *   **深层意义**：引导学生学会关爱家人，增进家庭和谐。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **grandchild** /'ɡræntʃaɪld/ n. (外)孙子；(外)孙女
                        **son** /sʌn/ n. 儿子
                        **hike** /haɪk/ v. & n. 远足；徒步旅行
                        **go hiking** 去远足
                        **funny** /'fʌni/ adj. 好笑的；奇怪的
                        **laugh** /lɑːf/ v. 笑；发笑
                        **different** /'dɪfrənt/ adj. 不同的
                        **violin** /ˌvaɪə'lɪn/ n. 小提琴
                        **play the violin** 拉小提琴
                        **have fun** 玩得开心
                        **hat** /hæt/ n. 帽子
                        **handsome** /'hænsəm/ adj. 英俊的
                        **knee** /niː/ n. 膝；膝盖
                        **as** /æz/ prep. 如同；作为
                        **AM** /ˌeɪ 'em/ 上午
                        **PM** /ˌpiː 'em/ 下午
                        **French** /frentʃ/ n. 法语 adj. 法国的
                        **excellent** /'eksələnt/ adj. 优秀的；极好的
                        **instrument** /'ɪnstrəmənt/ n. 乐器；工具
                        **relative** /'relətɪv/ n. 亲戚
                        **father** /'fɑːðə(r)/ n. 父亲
                        **mother** /'mʌðə(r)/ n. 母亲
                        **parents** /'peərənts/ n. 父母
                        **brother** /'brʌðə(r)/ n. 兄弟
                        **sister** /'sɪstə(r)/ n. 姐；妹
                        **grandfather** /'ɡrænfɑːðə(r)/ n. 祖父；外祖父
                        **grandmother** /'ɡrænmʌðə(r)/ n. 祖母；外祖母
                        **grandparents** /'ɡrænpeərənts/ n. 祖父母；外祖父母
                        **uncle** /'ʌŋkl/ n. 叔；伯；舅
                        **aunt** /'ɑːnt/ n. 姨；婶；姑
                        **cousin** /'kʌzn/ n. 堂(表)兄弟姐妹
                        **family tree** 家谱
                        **really** /'rɪəli/ adv. 真正地；确实
                        **pink** /'rɪŋk/ adj. & n. 粉红色
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. These are my parents. (这些是我的父母。)
                        - **【结构剖析】**：`These are...` 后接名词复数。注意 `parents` 指双亲。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：名词所有格
                        - 单数后加 *'s*：*father's book*。
                        - 以 s 结尾的复数后只加 *'*：*parents' room*。
                    """.trimIndent()),
                    UnitDetailSection("✍️ 单元写作专项指导", """
                        ### 写作主题：全家福介绍
                        **满分范文**：
                        Look at this photo! This is my family. These are my grandparents. They are very healthy. This handsome man is my father. He is a teacher. This is my mother. She is excellent at cooking. The girl next to me is my sister. We often have fun playing the violin together. I love my family!
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u3", "Unit 3", "My School",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 校园环境与设施。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **important** /ɪm'pɔːtnt/ adj. 重要的
                        **notice** /'nəʊtɪs/ n. 通知；公告 v. 注意到
                        **locker** /'lɒkə(r)/ n. 储物柜
                        **drawer** /drɔː(r)/ n. 抽屉
                        **back** /bæk/ n. 后面；背部
                        **at the back (of)** 在……后面
                        **corner** /'kɔːnə(r)/ n. 角落；拐角
                        **bookcase** /'bʊkkeɪs/ n. 书柜；书架
                        **screen** /skriːn/ n. 屏幕；银幕
                        **school** /skuːl/ n. 学校
                        **at school** 在学校
                        **modern** /'mɒdn/ adj. 现代的；时髦的
                        **exercise** /'eksəsaɪz/ n. & v. 练习；运动
                        **do exercises** 做运动；做操
                        **special** /'speʃl/ adj. 特别的；特殊的
                        **smart** /smɑːt/ adj. 智能的；聪明的
                        **whiteboard** /'waɪtbɔːd/ n. 白板
                        **put** /pʊt/ v. 放
                        **up** /ʌp/ adv. 向上
                        **put up** 张贴；搭建
                        **classroom** /'klɑːsruːm/ n. 教室
                        **library** /'laɪbrəri/ n. 图书馆
                        **playground** /'plaɪɡraʊnd/ n. 操场
                        **hall** /hɔːl/ n. 大厅；会堂
                        **dining** /'daɪnɪŋ/ n. 进餐
                        **dining hall** 餐厅
                        **gym** /dʒɪm/ n. 体育馆
                        **building** /'bɪldɪŋ/ n. 建筑物
                        **science** /'saɪəns/ n. 科学
                        **lab** /læb/ n. 实验室
                        **science lab** 科学实验室
                        **office** /'ɒfɪs/ n. 办公室
                        **behind** /bɪ'haɪnd/ prep. 在...后面
                        **between** /bɪ'twiːn/ prep. 在...之间
                        **front** /frʌnt/ n. 前面
                        **in front of** 在...前面
                        **across** /ə'krɒs/ adv. & prep. 穿过
                        **across from** 在...对面
                        **next** /nekst/ adj. 下一个的
                        **next to** 紧挨着
                        **large** /lɑːdʒ/ adj. 大的
                        **wall** /wɔːl/ n. 墙
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子深度解剖", """
                        #### 1. Where are my keys? (我的钥匙在哪？)
                        - **【语法核心】**：复数名词提问，助动词用 `are`。回答用 `They're...`。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：There be 结构
                        **1. 含义**：表示“某地有某物”。
                        **2. 主谓一致**：遵循“就近原则”。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u4", "Unit 4", "My Favourite Subject",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 学校生活与学科偏好。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **subject** /'sʌbdʒɪkt/ n. 学科；科目
                        **biology** /baɪ'ɒlədʒi/ n. 生物学
                        **IT** /ˌaɪ 'tiː/ n. 信息技术 (Information Technology)
                        **history** /'hɪstri/ n. 历史
                        **geography** /dʒi'ɒɡrəfi/ n. 地理
                        **PE** /ˌpiː 'iː/ n. 体育 (Physical Education)
                        **art** /ɑːt/ n. 艺术；美术
                        **music** /'mjuːzɪk/ n. 音乐
                        **math** /mæθ/ n. 数学
                        **Chinese** /ˌtʃaɪ'niːz/ n. 语文；汉语
                        **English** /'ɪŋɡlɪʃ/ n. 英语
                        **because** /bɪ'kɒz/ conj. 因为
                        **interesting** /'ɪntrəstɪŋ/ adj. 有趣的
                        **fun** /fʌn/ adj. 有趣的；n. 乐趣
                        **relaxing** /rɪ'læksɪŋ/ adj. 令人放松的
                        **difficult** /'dɪfɪkəlt/ adj. 困难的
                        **boring** /'bɔːrɪŋ/ adj. 乏味的；无聊的
                        **easy** /'iːzi/ adj. 容易的
                        **Monday** /'mʌndeɪ/ n. 星期一
                        **Tuesday** /'tjuːzdeɪ/ n. 星期二
                        **Wednesday** /'wenzdeɪ/ n. 星期三
                        **Thursday** /'θɜːzdeɪ/ n. 星期四
                        **Friday** /'fraɪdeɪ/ n. 星期五
                        **Saturday** /'sætədeɪ/ n. 星期六
                        **Sunday** /'sʌndeɪ/ n. 星期日
                        **week** /wiːk/ n. 星期；周
                        **day** /deɪ/ n. 一天；白昼
                        **time** /taɪm/ n. 时间
                        **schedule** /'ʃedjuːl/ n. 日程表；时刻表
                        **lesson** /'lesn/ n. 课；教训
                        **class** /klɑːs/ n. 班级；课
                        **why** /waɪ/ adv. 为什么
                        **when** /wen/ adv. 什么时候
                        **start** /stɑːt/ v. 开始
                        **finish** /'fɪnɪʃ/ v. 完成；结束
                        **past** /pɑːst/ prep. 晚于；过
                        **quarter** /'kwɔːtə(r)/ n. 一刻钟
                        **half** /hɑːf/ n. 一半
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：Why 与 Because 的因果链
                        - *— **Why** do you like math? — **Because** it's interesting.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u5", "Unit 5", "Fun Clubs",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 个人爱好与特长。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **club** /klʌb/ n. 俱乐部；社团
                        **join** /dʒɔɪn/ v. 参加；加入
                        **choose** /tʃuːz/ v. 选择；挑选
                        **drama** /'drɑːmə/ n. 戏剧；戏剧表演
                        **chess** /tʃes/ n. 象棋
                        **play Chinese chess** 下中国象棋
                        **feeling** /'fiːlɪŋ/ n. 感觉；情感
                        **news** /njuːz/ n. 消息；新闻
                        **musical** /'mjuːzɪkl/ adj. 音乐的；有音乐天赋的
                        **instrument** /'ɪnstrəmənt/ n. 乐器；工具
                        **musical instrument** 乐器
                        **exactly** /ɪɡ'zæktli/ adv. 正是如此；准确地
                        **drum** /drʌm/ n. 鼓
                        **ability** /ə'bɪləti/ n. 能力；才能
                        **paint** /peɪnt/ v. 用颜料画；n. 油漆
                        **climb** /klaɪm/ v. 攀登；爬
                        **more** /mɔː(r)/ adj. & pron. 更多（的）
                        **act** /ækt/ v. 扮演；行动
                        **act out** 表演；将……表演出来
                        **home** /həʊm/ n. & adv. 家
                        **at home** 在家里
                        **interested** /'ɪntrəstɪd/ adj. 感兴趣的
                        **interested in** 对……感兴趣
                        **nature** /'neɪtʃə(r)/ n. 自然界；大自然
                        **beef** /biːf/ n. 牛肉
                        **soon** /suːn/ adv. 不久；很快
                        **than** /ðən/ prep. & conj. 比
                        **more than** 多于；超过
                        **mind** /maɪnd/ n. 头脑；心思
                        **fall** /fɔːl/ v. & n. 进入；落下；秋天
                        **fall in love with** 爱上
                        **photo** /'fəʊtəʊ/ n. 照片
                        **take photos** 拍照
                        **collect** /kə'lekt/ v. 收集；采集
                        **insect** /'ɪnsekt/ n. 昆虫
                        **discover** /dɪ'skʌvə(r)/ v. 发现；发觉
                        **wildlife** /'waɪldlaɪf/ n. 野生动物
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u6", "Unit 6", "A Day in the Life",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 生活习惯与日常作息。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **use** /juːz/ v. 使用；利用
                        **make use of** 使用；利用
                        **shower** /'ʃaʊə(r)/ n. 淋浴；v. 洗淋浴
                        **take a shower** 淋浴
                        **dress** /dres/ v. 穿衣服 n. 连衣裙
                        **get dressed** 穿衣服
                        **brush** /brʌʃ/ v. 刷；n. 刷子
                        **tooth** /tuːθ/ n. 牙齿
                        **teeth** /tiːθ/ n. (tooth的复数) 牙齿
                        **duty** /'djuːti/ n. 值班；职责
                        **on duty** 值班
                        **usually** /'juːʒuəli/ adv. 通常地；一般地
                        **up** /ʌp/ adv. 向上
                        **get up** 起床
                        **reporter** /rɪ'pɔːtə(r)/ n. 记者
                        **around** /ə'raʊnd/ prep. & adv. 大约；环绕
                        **homework** /'həʊmwɜːk/ n. 家庭作业
                        **bed** /bed/ n. 床
                        **go to bed** 上床睡觉
                        **saying** /'saying/ n. 谚语；格言
                        **rise** /raɪz/ v. 起床；升起；增长
                        **stay** /steɪ/ v. 停留；待
                        **routine** /ruː'tiːn/ n. 常规
                        **restaurant** /'restrɒnt/ n. 餐馆；餐厅
                        **housework** /'haʊswɜːk/ n. 家务劳动
                        **while** /waɪl/ n. 一段时间；conj. 当……的时候
                        **weekend** /ˌwiːk'end/ n. 周末
                        **at weekends** 在周末
                        **daily** /'deɪli/ adj. 每日的；日常的
                        **daily routine** 日常生活
                        **only** /'əʊnli/ adv. 只；仅
                        **break** /breɪk/ n. 休息；间断
                        **already** /ɔːl'redi/ adv. 已经；早已
                        **dark** /dɑːk/ adj. 昏暗的；深色的
                        **outside** /ˌaʊt'saɪd/ adv. & prep. 在……外面
                        **part** /pɑːt/ n. 部分
                        **everyday** /'evrideɪ/ adj. 每天的；日常的
                        **prepare** /prɪ'peə(r)/ v. 准备
                        **begin** /bɪ'ɡɪn/ v. 开始
                        **dinner** /'dɪnə(r)/ n. 正餐；主餐
                        **early** /'ɜːli/ adj. 早的；adv. 提前
                        **ask** /ɑːsk/ v. 询问；请求
                        **lunch** /lʌntʃ/ n. 午餐
                        **film** /fɪlm/ n. 电影
                        **o'clock** /ə'klɒk/ adv. ……点钟
                        **breakfast** /'brekfəst/ n. 早餐
                        **before** /bɪ'fɔː(r)/ prep. & conj. 在……以前
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u7", "Unit 7", "Happy Birthday!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 个人庆典与人际交往。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **birthday** /'bɜːθdeɪ/ n. 生日
                        **month** /mʌnθ/ n. 月份
                        **date** /deɪt/ n. 日期
                        **gift** /ɡɪft/ n. 礼物
                        **party** /'pɑːti/ n. 聚会
                        **buy** /baɪ/ v. 买
                        **store** /stɔː(r)/ n. 商店
                        **shop** /ʃɒp/ n. 商店；v. 逛商店
                        **woman** /'wʊmən/ n. 女人
                        **women** /'wɪmɪn/ n. (woman的复数) 女人
                        **celebrate** /'selɪbreɪt/ v. 庆祝；庆贺
                        **surprise** /sə'praɪz/ n. 惊奇；v. 使感到意外
                        **meaningful** /'miːnɪŋfl/ adj. 有意义的
                        **wish** /wɪʃ/ n. & v. 愿望；希望
                        **make a wish** 许愿
                        **celebration** /ˌselɪ'breɪʃn/ n. 庆祝活动
                        **post** /pəʊst/ n. 帖子；v. 邮寄；发布
                        **contact** /'kɒntækt/ v. & n. 联系
                        **symbol** /'sɪmbl/ n. 象征；符号
                        **village** /'vɪlɪdʒ/ n. 村庄
                        **grow** /ɡrəʊ/ v. 生长；成长
                        **blow** /bləʊ/ v. 吹
                        **blow out** 吹灭
                        **enjoy** /ɪn'dʒɔɪ/ v. 享受；喜爱
                        **height** /haɪt/ n. 高度
                        **later** /'leɪtə(r)/ adv. 后来；以后
                        **next time** 下次
                        **noodles** /'nuːdlz/ n. 面条
                        **eat birthday noodles** 吃长寿面
                        **open** /'əʊpən/ v. 打开
                        **open birthday gifts** 拆生日礼物
                        **cake** /keɪk/ n. 蛋糕
                        **have a birthday cake** 吃生日蛋糕
                        **song** /sɒŋ/ n. 歌曲
                        **hear the "Happy Birthday" song** 听《祝你生日快乐》歌
                    """.trimIndent())
                )
            )
        )
    )
}
