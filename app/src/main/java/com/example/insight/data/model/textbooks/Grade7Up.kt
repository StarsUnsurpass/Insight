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
                    UnitDetailSection("📖 课本同步单词表", """
                        **unit** /ˈjuːnɪt/ n. 单元
                        
                        **starter** /ˈstɑːtə(r)/ n. 第一步；开端
                        
                        **starter unit** 过渡单元
                        
                        **section** /ˈsekʃn/ n. 部分；地区
                        
                        **greet** /ɡriːt/ v. 招呼；问候
                        
                        **everyone** /ˈevriwʌn/ pron. 每人；所有人
                        
                        **start** /stɑːt/ v. 开始；着手
                        
                        **conversation** /ˌkɒnvəˈseɪʃn/ n. 谈话；交谈
                        
                        **spell** /spel/ v. 用字母拼；拼写
                        
                        **oh** /əʊ/ interj. 哦；啊
                        
                        **bell** /bel/ n. 铃（声）；钟（声）
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_s2", "Starter Unit 2", "Keep Tidy!",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **bottle** /ˈbɒtl/ n. 瓶子
                        
                        **eraser** /ɪˈreɪzə(r)/ n. 橡皮
                        
                        **key** /kiː/ n. 钥匙；关键
                        
                        **thing** /θɪŋ/ n. 东西；事情
                        
                        **need** /niːd/ v. & n. 需要
                        
                        **You're welcome.** 别客气；不用谢。
                        
                        **tidy** /ˈtaɪdi/ adj. 整洁的；整齐的
                        
                        **where** /weə(r)/ adv. 在哪里
                        
                        **can** /kæn/ modal v. 能；会
                        
                        **find** /faɪnd/ v. 找到；发现
                        
                        **lost** /lɒst/ adj. 丢失的
                        
                        **found** /faʊnd/ v. (find的过去式)
                        
                        **lost and found** 失物招领（处）
                        
                        **please** /pliːz/ interj. 请
                        
                        **schoolbag** /ˈskuːlbæɡ/ n. 书包
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_s3", "Starter Unit 3", "Welcome!",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **fun** /fʌn/ n. 乐趣；快乐
                        
                        **yard** /jɑːd/ n. 院子；园圃
                        
                        **carrot** /ˈkærət/ n. 胡萝卜
                        
                        **goose** /ɡuːs/ n. 鹅
                        
                        **geese** /ɡiːs/ n. (goose的复数)
                        
                        **count** /kaʊnt/ v. 数数
                        
                        **another** /əˈnʌðə(r)/ adj. & pron. 另一；又一
                        
                        **else** /els/ adv. 其他的；别的
                        
                        **look** /lʊk/ v. 看；瞧
                        
                        **look at** 看；瞧
                        
                        **circle** /ˈsɜːkl/ v. 圈出 n. 圆形
                        
                        **welcome** /ˈwelkəm/ adj. & v. 欢迎
                        
                        **tomato** /təˈmɑːtəʊ/ n. 西红柿
                        
                        **potato** /pəˈteɪtəʊ/ n. 马铃薯；土豆
                        
                        **animal** /ˈænɪml/ n. 动物
                        
                        **many** /ˈmeni/ adj. & pron. 许多
                        
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
                    UnitDetailSection("📖 课本同步单词表", """
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
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u2", "Unit 2", "We're Family!",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **husband** /ˈhʌzbənd/ n. 丈夫
                        
                        **wife** /waɪf/ n. 妻子
                        
                        **grandchild** /ˈɡræntʃaɪld/ n. (外)孙子；(外)孙女
                        
                        **son** /sʌn/ n. 儿子
                        
                        **daughter** /ˈdɔːtə(r)/ n. 女儿
                        
                        **cousin** /ˈkʌzn/ n. 堂（表）兄弟姐妹
                        
                        **hike** /haɪk/ v. & n. 远足；徒步旅行
                        
                        **go hiking** 去远足
                        
                        **together** /təˈɡeðə(r)/ adv. 在一起；共同
                        
                        **spend** /spend/ v. 花（时间、金钱等）
                        
                        **really** /ˈrɪəli/ adv. 真正地；确实
                        
                        **chess** /tʃes/ n. 国际象棋
                        
                        **funny** /ˈfʌni/ adj. 好笑的；奇怪的
                        
                        **laugh** /lɑːf/ v. 笑；发笑
                        
                        **different** /ˈdɪfrənt/ adj. 不同的
                        
                        **violin** /ˌvaɪəˈlɪn/ n. 小提琴
                        
                        **play the violin** 拉小提琴
                        
                        **have fun** 玩得开心
                        
                        **hat** /hæt/ n. 帽子
                        
                        **handsome** /ˈhænsəm/ adj. 英俊的
                        
                        **knee** /niː/ n. 膝；膝盖
                        
                        **as** /æz/ prep. 如同；作为
                        
                        **AM** /ˌeɪ 'em/ 上午
                        
                        **PM** /ˌpiː 'em/ 下午
                        
                        **French** /frentʃ/ n. 法语 adj. 法国的
                        
                        **excellent** /ˈeksələnt/ adj. 优秀的；极好的
                        
                        **instrument** /ˈɪnstrəmənt/ n. 乐器；工具
                        
                        **relative** /ˈrelətɪv/ n. 亲戚
                        
                        **father** /ˈfɑːðə(r)/ n. 父亲
                        
                        **mother** /ˈmʌðə(r)/ n. 母亲
                        
                        **parents** /ˈpeərənts/ n. 父母
                        
                        **brother** /ˈbrʌðə(r)/ n. 兄弟
                        
                        **sister** /ˈsɪstə(r)/ n. 姐；妹
                        
                        **grandfather** /ˈɡrænfɑːðə(r)/ n. 祖父；外祖父
                        
                        **grandmother** /ˈɡrænmʌðə(r)/ n. 祖母；外祖母
                        
                        **grandparents** /ˈɡrænpeərənts/ n. 祖父母；外祖父母
                        
                        **uncle** /ˈʌŋkl/ n. 叔；伯；舅
                        
                        **aunt** /ˈɑːnt/ n. 姨；婶；姑
                        
                        **family tree** 家谱
                        
                        **pink** /pɪŋk/ adj. & n. 粉红色
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u3", "Unit 3", "My School",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **hall** /hɔːl/ n. 大厅；会堂
                        
                        **dining hall** 餐厅；食堂
                        
                        **gym** /dʒɪm/ n. 体育馆；健身房
                        
                        **field** /fiːld/ n. 田地；场地
                        
                        **sports field** 运动场
                        
                        **office** /ˈɒfɪs/ n. 办公室
                        
                        **large** /lɑːdʒ/ adj. 大的；宽敞的
                        
                        **special** /ˈspeʃl/ adj. 特别的；特殊的
                        
                        **smart** /smɑːt/ adj. 智能的；聪明的
                        
                        **whiteboard** /ˈwaɪtbɔːd/ n. 白板
                        
                        **important** /ɪmˈpɔːtnt/ adj. 重要的
                        
                        **notice** /ˈnəʊtɪs/ n. 通知；公告 v. 注意到
                        
                        **locker** /ˈlɒkə(r)/ n. 储物柜
                        
                        **drawer** /drɔː(r)/ n. 抽屉
                        
                        **back** /bæk/ n. 后面；背部
                        
                        **at the back (of)** 在……后面
                        
                        **corner** /ˈkɔːnə(r)/ n. 角落；拐角
                        
                        **bookcase** /ˈbʊkkeɪs/ n. 书柜；书架
                        
                        **screen** /skriːn/ n. 屏幕；银幕
                        
                        **school** /skuːl/ n. 学校
                        
                        **at school** 在学校
                        
                        **modern** /ˈmɒdn/ adj. 现代的；时髦的
                        
                        **exercise** /ˈeksəsaɪz/ n. & v. 练习；运动
                        
                        **do exercises** 做运动；做操
                        
                        **put** /pʊt/ v. 放
                        
                        **up** /ʌp/ adv. 向上
                        
                        **put up** 张贴；搭建
                        
                        **classroom** /ˈklɑːsruːm/ n. 教室
                        
                        **library** /ˈlaɪbrəri/ n. 图书馆
                        
                        **playground** /ˈplaɪɡraʊnd/ n. 操场
                        
                        **building** /ˈbɪldɪŋ/ n. 建筑物
                        
                        **science** /ˈsaɪəns/ n. 科学
                        
                        **lab** /læb/ n. 实验室
                        
                        **science lab** 科学实验室
                        
                        **behind** /bɪˈhaɪnd/ prep. 在...后面
                        
                        **between** /bɪˈtwiːn/ prep. 在...之间
                        
                        **front** /frʌnt/ n. 前面
                        
                        **in front of** 在...前面
                        
                        **across** /əˈrɒs/ adv. & prep. 穿过
                        
                        **across from** 在...对面
                        
                        **next** /nekst/ adj. 下一个的
                        
                        **next to** 紧挨着
                        
                        **wall** /wɔːl/ n. 墙
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u4", "Unit 4", "My Favourite Subject",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **subject** /ˈsʌbdʒɪkt/ n. 学科；科目
                        
                        **biology** /baɪˈɒlədʒi/ n. 生物学
                        
                        **IT** /ˌaɪ 'tiː/ n. 信息技术 (Information Technology)
                        
                        **history** /ˈhɪstri/ n. 历史
                        
                        **geography** /dʒiˈɒɡrəfi/ n. 地理
                        
                        **PE** /ˌpiː 'iː/ n. 体育 (Physical Education)
                        
                        **art** /ɑːt/ n. 艺术；美术
                        
                        **music** /ˈmjuːzɪk/ n. 音乐
                        
                        **math** /mæθ/ n. 数学
                        
                        **Chinese** /ˌtʃaɪˈniːz/ n. 语文；汉语
                        
                        **English** /ˈɪŋɡlɪʃ/ n. 英语
                        
                        **because** /bɪˈkɒz/ conj. 因为
                        
                        **reason** /ˈriːzn/ n. 原因；理由
                        
                        **useful** /ˈjuːsfl/ adj. 有用的；有益的
                        
                        **interesting** /ˈintristiŋ/ adj. 有趣的
                        
                        **relaxing** /rɪˈlæksɪŋ/ adj. 令人放松的
                        
                        **difficult** /ˈdɪfɪkəlt/ adj. 困难的
                        
                        **boring** /ˈbɔːrɪŋ/ adj. 乏味的；无聊的
                        
                        **easy** /ˈiːzi/ adj. 容易的
                        
                        **Monday** /ˈmʌndeɪ/ n. 星期一
                        
                        **Tuesday** /ˈtjuːzdeɪ/ n. 星期二
                        
                        **Wednesday** /ˈwenzdeɪ/ n. 星期三
                        
                        **Thursday** /ˈθɜːzdeɪ/ n. 星期四
                        
                        **Friday** /ˈfraɪdeɪ/ n. 星期五
                        
                        **Saturday** /ˈsætədeɪ/ n. 星期六
                        
                        **Sunday** /ˈsʌndeɪ/ n. 星期日
                        
                        **week** /wiːk/ n. 星期；周
                        
                        **day** /deɪ/ n. 一天；白昼
                        
                        **time** /taɪm/ n. 时间
                        
                        **schedule** /ˈʃedjuːl/ n. 日程表；时刻表
                        
                        **lesson** /ˈlesn/ n. 课；教训
                        
                        **class** /klɑːs/ n. 班级；课
                        
                        **why** /waɪ/ adv. 为什么
                        
                        **when** /wen/ adv. 什么时候
                        
                        **start** /stɑːt/ v. 开始
                        
                        **finish** /ˈfɪnɪʃ/ v. 完成；结束
                        
                        **past** /pɑːst/ prep. 晚于；过
                        
                        **quarter** /ˈkwɔːtə(r)/ n. 一刻钟
                        
                        **half** /hɑːf/ n. 一半
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u5", "Unit 5", "Fun Clubs",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **club** /klʌb/ n. 俱乐部；社团
                        
                        **join** /dʒɔɪn/ v. 加入；参加
                        
                        **ability** /əˈbɪləti/ n. 能力；才能
                        
                        **paint** /peɪnt/ v. 用颜料画；刷漆
                        
                        **swim** /swɪm/ v. 游泳
                        
                        **dance** /dɑːns/ v. 跳舞
                        
                        **act** /ækt/ v. 表演；行动
                        
                        **instrument** /ˈɪnstrəmənt/ n. 乐器；工具
                        
                        **drum** /drʌm/ n. 鼓
                        
                        **collect** /kəˈlekt/ v. 收集；采集
                        
                        **choose** /tʃuːz/ v. 选择；挑选
                        
                        **drama** /ˈdrɑːmə/ n. 戏剧；戏剧表演
                        
                        **chess** /tʃes/ n. 象棋
                        
                        **feeling** /ˈfiːlɪŋ/ n. 感觉；情感
                        
                        **news** /njuːz/ n. 消息；新闻
                        
                        **musical** /ˈmjuːzɪkl/ adj. 音乐的
                        
                        **exactly** /ɪɡˈzæktli/ adv. 正是如此
                        
                        **climb** /klaɪm/ v. 攀登；爬
                        
                        **more** /mɔː(r)/ adj. & pron. 更多（的）
                        
                        **nature** /ˈneɪtʃə(r)/ n. 自然界
                        
                        **beef** /biːf/ n. 牛肉
                        
                        **soon** /suːn/ adv. 不久；很快
                        
                        **than** /ðən/ prep. & conj. 比
                        
                        **mind** /maɪnd/ n. 头脑；心思
                        
                        **fall** /fɔːl/ v. & n. 进入；落下；秋天
                        
                        **photo** /ˈfəʊtəʊ/ n. 照片
                        
                        **insect** /ˈɪnsekt/ n. 昆虫
                        
                        **discover** /dɪˈskʌvə(r)/ v. 发现；发觉
                        
                        **wildlife** /ˈwaɪldlaɪf/ n. 野生动物
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u6", "Unit 6", "A Day in the Life",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **o'clock** /əˈklɒk/ adv. ……点钟
                        
                        **past** /pɑːst/ prep. 晚于；经过
                        
                        **quarter** /ˈkwɔːtə(r)/ n. 一刻钟；四分之一
                        
                        **shower** /ˈʃaʊə(r)/ n. & v. 淋浴
                        
                        **brush** /brʌʃ/ v. 刷；梳
                        
                        **teeth** /tiːθ/ n. 牙齿 (pl. of tooth)
                        
                        **usually** /ˈjuːʒuəli/ adv. 通常地
                        
                        **homework** /ˈhəʊmwɜːk/ n. 家庭作业
                        
                        **never** /ˈnevə(r)/ adv. 从不；绝不
                        
                        **early** /ˈɜːli/ adj. & adv. 早的（地）
                        
                        **use** /juːz/ v. 使用；利用
                        
                        **dress** /dres/ v. 穿衣服 n. 连衣裙
                        
                        **duty** /ˈdjuːti/ n. 值班；职责
                        
                        **up** /ʌp/ adv. 向上
                        
                        **reporter** /rɪˈpɔːtə(r)/ n. 记者
                        
                        **around** /əˈraʊnd/ prep. & adv. 大约；环绕
                        
                        **bed** /bed/ n. 床
                        
                        **saying** /ˈseɪɪŋ/ n. 谚语；格言
                        
                        **rise** /raɪz/ v. 起床；升起
                        
                        **stay** /steɪ/ v. 停留；待
                        
                        **routine** /ruːˈtiːn/ n. 常规
                        
                        **restaurant** /ˈrestrɒnt/ n. 餐馆；餐厅
                        
                        **housework** /ˈhaʊswɜːk/ n. 家务劳动
                        
                        **while** /waɪl/ conj. 当……的时候
                        
                        **weekend** /ˌwiːkˈend/ n. 周末
                        
                        **daily** /ˈdeɪli/ adj. 每日的
                        
                        **only** /ˈəʊnli/ adv. 只；仅
                        
                        **break** /breɪk/ n. 休息；间断
                        
                        **already** /ɔːlˈredi/ adv. 已经；早已
                        
                        **dark** /dɑːk/ adj. 昏暗的；深色的
                        
                        **outside** /ˌaʊtˈsaɪd/ adv. & prep. 在外面
                        
                        **part** /pɑːt/ n. 部分
                        
                        **everyday** /ˈevrideɪ/ adj. 每天的
                        
                        **prepare** /prɪˈpeə(r)/ v. 准备
                        
                        **begin** /bɪˈɡɪn/ v. 开始
                        
                        **dinner** /ˈdɪnə(r)/ n. 正餐
                        
                        **ask** /ɑːsk/ v. 询问；请求
                        
                        **lunch** /lʌntʃ/ n. 午餐
                        
                        **film** /fɪlm/ n. 电影
                        
                        **breakfast** /ˈbrekfəst/ n. 早餐
                        
                        **before** /bɪˈfɔː(r)/ prep. & conj. 在……以前
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u7", "Unit 7", "Happy Birthday!",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **month** /mʌnθ/ n. 月份
                        
                        **January** /ˈdʒænjuəri/ n. 一月
                        
                        **February** /ˈfebruəri/ n. 二月
                        
                        **August** /ˈɔːɡəst/ n. 八月
                        
                        **December** /dɪˈsembə(r)/ n. 十二月
                        
                        **date** /deɪt/ n. 日期
                        
                        **birthday** /ˈbɜːθdeɪ/ n. 生日
                        
                        **happy** /ˈhæpi/ adj. 高兴的；快乐的
                        
                        **party** /ˈpɑːti/ n. 聚会；派对
                        
                        **present** /ˈpreznt/ n. 礼物
                        
                        **buy** /baɪ/ v. 买
                        
                        **store** /stɔː(r)/ n. 商店
                        
                        **shop** /ʃɒp/ n. 商店；v. 逛商店
                        
                        **woman** /ˈwʊmən/ n. 女人 (pl. women)
                        
                        **celebrate** /ˈselɪbreɪt/ v. 庆祝；庆贺
                        
                        **surprise** /səˈpraɪz/ n. 惊奇；v. 使意外
                        
                        **meaningful** /ˈmiːnɪŋfl/ adj. 有意义的
                        
                        **wish** /wɪʃ/ n. & v. 愿望；希望
                        
                        **celebration** /ˌselɪˈbreɪʃn/ n. 庆祝活动
                        
                        **post** /pəʊst/ n. & v. 帖子；发布
                        
                        **contact** /ˈkɒntækt/ v. & n. 联系
                        
                        **symbol** /ˈsɪmbl/ n. 象征
                        
                        **village** /ˈvɪlɪdʒ/ n. 村庄
                        
                        **grow** /ɡrəʊ/ v. 生长；成长
                        
                        **blow** /bləʊ/ v. 吹
                        
                        **enjoy** /ɪnˈdʒɔɪ/ v. 享受；喜爱
                        
                        **height** /haɪt/ n. 高度
                        
                        **later** /ˈleɪtə(r)/ adv. 后来；以后
                        
                        **noodles** /ˈnuːdlz/ n. 面条
                        
                        **open** /ˈəʊpən/ v. 打开
                        
                        **cake** /keɪk/ n. 蛋糕
                        
                        **song** /sɒŋ/ n. 歌曲
                    """.trimIndent())
                )
            )
        )
    )
}
