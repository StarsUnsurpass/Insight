package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade8Up {
    val data = Textbook(
        id = "g8_up",
        grade = "八年级",
        term = "上册",
        coverColor = Color(0xFFE8F5E9),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/sc8x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g8up_u1", "Unit 1", "Where did you go on vacation?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 个人经历、旅游与休闲。
                        *   **深层意义**：本单元聚焦于分享旅行见闻，引导学生记录生活、分享快乐。同时重点掌握复合不定代词的语法规律。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **anyone** /ˈeniwʌn/ pron. 任何人
                        
                        **anywhere** /ˈeniweə(r)/ adv. 在任何地方
                        
                        **wonderful** /ˈwʌndəfl/ adj. 精彩的；绝妙的
                        
                        **few** /fjuː/ adj. & pron. 不多；很少
                        
                        **quite a few** 相当多；不少
                        
                        **most** /məʊst/ adj. & adv. 最多；大多数
                        
                        **something** /ˈsʌmθɪŋ/ pron. 某事；某物
                        
                        **nothing** /ˈnʌθɪŋ/ pron. 没有什么；没有一件东西
                        
                        **myself** /maɪˈself/ pron. 我自己；我本人
                        
                        **everyone** /ˈevriwʌn/ pron. 每人；人人
                        
                        **yourself** /jɔːˈself/ pron. 你自己；您自己
                        
                        **hen** /hen/ n. 母鸡
                        
                        **pig** /pɪɡ/ n. 猪
                        
                        **seem** /siːm/ v. 好像；似乎
                        
                        **bored** /bɔːd/ adj. 厌倦的；烦闷的
                        
                        **someone** /ˈsʌmwʌn/ pron. 某人
                        
                        **diary** /ˈdaɪəri/ n. 日记；记事簿
                        
                        **activity** /ækˈtɪvəti/ n. 活动
                        
                        **decide** /dɪˈsaɪd/ v. 决定；选定
                        
                        **try** /traɪ/ v. 尝试；设法
                        
                        **bird** /bɜːd/ n. 鸟
                        
                        **bicycle** /ˈbaɪsɪkl/ n. 自行车
                        
                        **building** /ˈbɪldɪŋ/ n. 建筑物；房子
                        
                        **trader** /ˈtreɪdə(r)/ n. 商人
                        
                        **wonder** /ˈwʌndə(r)/ v. 想知道；琢磨
                        
                        **difference** /ˈdɪfrəns/ n. 差别；差异
                        
                        **top** /tɒp/ n. 顶部；表面
                        
                        **wait** /weɪt/ v. 等待；等候
                        
                        **umbrella** /ʌmˈbrelə/ n. 伞；雨伞
                        
                        **wet** /wet/ adj. 湿的；潮湿的
                        
                        **below** /bɪˈlɒʊ/ prep. & adv. 在……下面
                        
                        **enough** /ɪˈnʌf/ adj. 足够的；充分的
                        
                        **hungry** /ˈhʌŋɡri/ adj. 极饿的
                        
                        **as** /əz/ adv. 像……一样；如同
                        
                        **hill** /hɪl/ n. 小山；山丘
                        
                        **duck** /dʌk/ n. 鸭
                        
                        **dislike** /dɪsˈlaɪk/ v. & n. 不喜爱；厌恶
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：复合不定代词 (Compound Indefinite Pronouns)
                        **1. 构成**：some/any/no/every + thing/body/one。
                        **2. 形容词位置**：形容词修饰复合不定代词时，**必须后置**。
                        - *something **special*** (特别的东西)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "How often do you exercise?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活方式与健康习惯。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **housework** /ˈhaʊswɜːk/ n. 家务劳动
                        
                        **hardly** /ˈhɑːdli/ adv. 几乎不；简直不
                        
                        **ever** /ˈevə(r)/ adv. 在任何时候；从来
                        
                        **hardly ever** 几乎从不
                        
                        **once** /wʌns/ adv. 一次；曾经
                        
                        **twice** /twaɪs/ adv. 两次；两倍
                        
                        **Internet** /ˈɪntənet/ n. 因特网
                        
                        **program** /ˈprəʊɡræm/ n. 节目
                        
                        **full** /fʊl/ adj. 忙的；满的
                        
                        **swing** /swɪŋ/ n. & v. 摇摆；秋千
                        
                        **maybe** /ˈmeɪbi/ adv. 大概；也许
                        
                        **least** /liːst/ adv. 最小；最少
                        
                        **at least** 至少；不少于
                        
                        **junk** /dʒʌŋk/ n. 无用的东西
                        
                        **junk food** 垃圾食品
                        
                        **coffee** /ˈkɒfi/ n. 咖啡
                        
                        **health** /helθ/ n. 健康；身体状况
                        
                        **result** /rɪˈzʌlt/ n. 结果；后果
                        
                        **percent** /pəˈsent/ n. 百分之……
                        
                        **online** /ˌɒnˈlaɪn/ adj. & adv. 在线（的）
                        
                        **television** /ˈtelɪvɪʒn/ n. 电视机；电视节目
                        
                        **although** /ɔːlˈðəʊ/ conj. 虽然；尽管
                        
                        **through** /θruː/ prep. 穿过；凭借
                        
                        **mind** /maɪnd/ n. 头脑；心智
                        
                        **body** /ˈbɒdi/ n. 身体
                        
                        **such** /sʌtʃ/ adj. & pron. 这样的
                        
                        **such as** 例如
                        
                        **together** /təˈɡeðə(r)/ adv. 在一起；共同
                        
                        **die** /daɪ/ v. 消失；死亡
                        
                        **writer** /ˈraɪtə(r)/ n. 作者；作家
                        
                        **dentist** /ˈdentɪst/ n. 牙科医生
                        
                        **magazine** /ˌmæɡəˈziːn/ n. 杂志
                        
                        **however** /haʊˈevə(r)/ adv. 然而；可是
                        
                        **than** /ðæn/ conj. 比
                        
                        **more than** 多于
                        
                        **almost** /ˈɔːlməʊst/ adv. 几乎
                        
                        **none** /nʌn/ pron. 没有一个
                        
                        **less** /les/ adv. 较少；较小
                        
                        **less than** 少于
                        
                        **point** /pɔɪnt/ n. 得分；点
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：频度副词
                        - 询问频率：统一用 **How often**。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "I'm more outgoing than my sister.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 友谊。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **outgoing** /ˈaʊtɡəʊɪŋ/ adj. 外向的
                        
                        **better** /ˈbetə(r)/ adj. & adv. 更好的
                        
                        **loudly** /ˈlaʊdli/ adv. 大声地
                        
                        **quietly** /ˈkwaɪətli/ adv. 轻声地
                        
                        **hard-working** /ˌhɑːd ˈwɜːkɪŋ/ adj. 工作努力的
                        
                        **competition** /ˌkɒmpəˈtɪʃn/ n. 比赛；竞争
                        
                        **fantastic** /fænˈtæstɪk/ adj. 极好的
                        
                        **which** /wɪtʃ/ pron. & adj. 哪一个
                        
                        **clearly** /ˈklɪəli/ adv. 清楚地
                        
                        **win** /wɪn/ v. 获胜
                        
                        **though** /ðəʊ/ conj. & adv. 虽然；不过
                        
                        **talented** /ˈtæləntɪd/ adj. 有天赋的
                        
                        **truly** /ˈtruːli/ adv. 真正；确实
                        
                        **care** /keə(r)/ v. 在意；担忧
                        
                        **care about** 关心；在意
                        
                        **serious** /ˈsɪəriəs/ adj. 严肃的
                        
                        **mirror** /ˈmɪrə(r)/ n. 镜子
                        
                        **kid** /kɪd/ n. 小孩
                        
                        **as long as** 只要
                        
                        **necessary** /ˈnesəsəri/ adj. 必要的
                        
                        **both** /bəʊθ/ adj. & pron. 两个都
                        
                        **bring out** 使显现
                        
                        **grade** /ɡreɪd/ n. 成绩
                        
                        **should** /ʃʊd/ modal v. 应该
                        
                        **saying** /ˈseɪɪŋ/ n. 谚语；格言
                        
                        **reach** /riːtʃ/ v. 伸手；到达
                        
                        **hand** /hænd/ n. 手
                        
                        **touch** /tʌtʃ/ v. 感动；触摸
                        
                        **heart** /hɑːt/ n. 内心；心脏
                        
                        **fact** /fækt/ n. 事实
                        
                        **in fact** 事实上
                        
                        **break** /break/ v. 打碎；折断
                        
                        **arm** /ɑːm/ n. 手臂
                        
                        **share** /ʃeə(r)/ v. 分享
                        
                        **loud** /laʊd/ adj. 响亮的
                        
                        **similar** /ˈsɪmələ(r)/ adj. 相像的
                        
                        **be similar to** 与……相像
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：比较级
                        - 变y为i加er：*funny -> funnier*。
                        - 多音节加 more：*more outgoing*。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "What's the best movie theater?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **theater** /ˈθɪətə(r)/ n. 剧场；电影院
                        
                        **comfortable** /ˈkʌmftəbl/ adj. 舒服的
                        
                        **seat** /siːt/ n. 座位
                        
                        **screen** /skriːn/ n. 屏幕
                        
                        **close** /kləʊs/ adj. 近的
                        
                        **ticket** /ˈtɪkɪt/ n. 票
                        
                        **worst** /wɜːst/ adj. & adv. 最坏的
                        
                        **cheaply** /ˈtʃiːpli/ adv. 便宜地
                        
                        **song** /sɒŋ/ n. 歌曲
                        
                        **choose** /tʃuːz/ v. 选择
                        
                        **carefully** /ˈkeəfəli/ adv. 细致地
                        
                        **reporter** /rɪˈpɔːtə(r)/ n. 记者
                        
                        **fresh** /freʃ/ adj. 新鲜的
                        
                        **comfortably** /ˈkʌmftəbli/ adv. 舒适地
                        
                        **worse** /wɜːs/ adj. & adv. 更坏的
                        
                        **service** /ˈsɜːvɪs/ n. 服务
                        
                        **pretty** /ˈprɪti/ adv. 相当
                        
                        **menu** /ˈmenjuː/ n. 菜单
                        
                        **act** /ækt/ v. 表演
                        
                        **meal** /miːl/ n. 晚餐
                        
                        **creative** /kriˈeɪtɪv/ adj. 有创造力的
                        
                        **performer** /pəˈfɔːmə(r)/ n. 表演者
                        
                        **talent** /ˈtælənt/ n. 天资
                        
                        **common** /ˈkɒmən/ adj. 常见的
                        
                        **magician** /məˈdʒɪʃn/ n. 魔术师
                        
                        **all kinds of** 各种各样的
                        
                        **beautifully** /ˈbjuːtɪfli/ adv. 美丽地
                        
                        **role** /rəʊl/ n. 角色
                        
                        **play a role** 发挥作用
                        
                        **winner** /ˈwɪnə(r)/ n. 获胜者
                        
                        **prize** /praɪz/ n. 奖品
                        
                        **everybody** /ˈevribɒdi/ pron. 每人
                        
                        **make up** 编造
                        
                        **example** /ɪɡˈzɑːmpl/ n. 例子
                        
                        **for example** 例如
                        
                        **poor** /pɔː(r)/ adj. 贫穷的
                        
                        **seriously** /ˈsɪəriəsli/ adv. 严重地
                        
                        **give** /ɡɪv/ v. 给
                        
                        **crowded** /ˈkraʊdɪd/ adj. 拥挤的
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：最高级
                        - the + adj.est / most + adj.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "Do you want to watch a game show?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **sitcom** /ˈsɪtkɒm/ n. 情景喜剧
                        
                        **news** /njuːz/ n. 新闻
                        
                        **soap** /səʊp/ n. 肥皂
                        
                        **soap opera** 肥皂剧
                        
                        **educational** /ˌedʒuˈkeɪʃənl/ adj. 教育的
                        
                        **plan** /plæn/ v. & n. 计划
                        
                        **hope** /həʊp/ v. & n. 希望
                        
                        **discussion** /dɪˈskʌʃn/ n. 讨论
                        
                        **stand** /stænd/ v. 忍受
                        
                        **happen** /ˈæpən/ v. 发生
                        
                        **may** /meɪ/ modal v. 也许
                        
                        **expect** /ɪkˈspekt/ v. 期待
                        
                        **joke** /dʒəʊk/ n. 玩笑
                        
                        **comedy** /ˈkɒmədi/ n. 喜剧
                        
                        **meaningless** /ˈmiːnɪŋləs/ adj. 毫无意义的
                        
                        **action** /ˈækʃn/ n. 行动
                        
                        **action movie** 动作片
                        
                        **cartoon** /kɑːˈtuːn/ n. 动画片
                        
                        **culture** /ˈkʌltʃə(r)/ n. 文化
                        
                        **famous** /ˈfeɪməs/ adj. 著名的
                        
                        **appear** /əˈpɪə(r)/ v. 出现
                        
                        **become** /bɪˈkʌm/ v. 变成
                        
                        **rich** /rɪtʃ/ adj. 富有的
                        
                        **successful** /səkˈsesfl/ adj. 成功的
                        
                        **might** /maɪt/ modal v. 可能
                        
                        **main** /meɪn/ adj. 主要的
                        
                        **reason** /ˈriːzn/ n. 原因
                        
                        **film** /fɪlm/ n. 电影
                        
                        **unlucky** /ʌnˈlʌki/ adj. 不幸的
                        
                        **lose** /luːz/ v. 丢失
                        
                        **ready** /ˈredi/ adj. 愿意的
                        
                        **be ready to** 准备好
                        
                        **character** /ˈkærəktə(r)/ n. 人物
                        
                        **simple** /ˈsɪmpl/ adj. 简单的
                        
                        **dress up** 装扮
                        
                        **take sb's place** 代替
                        
                        **army** /ˈɑːmi/ n. 军队
                        
                        **do a good job** 工作出色
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "I'm going to study computer science.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **doctor** /ˈdɒktə(r)/ n. 医生
                        
                        **engineer** /ˌendʒɪˈnɪə(r)/ n. 工程师
                        
                        **violinist** /ˌvaɪəˈlɪnɪst/ n. 小提琴手
                        
                        **pilot** /ˈpaɪlət/ n. 飞行员
                        
                        **pianist** /ˈpɪənɪst/ n. 钢琴家
                        
                        **scientist** /ˈsaɪəntɪst/ n. 科学家
                        
                        **college** /ˈkɒlɪdʒ/ n. 学院
                        
                        **education** /ˌedʒuˈkeɪʃn/ n. 教育
                        
                        **medicine** /ˈmedsn/ n. 药
                        
                        **university** /ˌjuːnɪˈvɜːsəti/ n. 大学
                        
                        **article** /ˈɑːtɪkl/ n. 文章
                        
                        **send** /send/ v. 邮寄
                        
                        **resolution** /ˌrezəˈluːʃn/ n. 决心
                        
                        **team** /tiːm/ n. 队
                        
                        **foreign** /ˈfɒrən/ adj. 外国的
                        
                        **able** /ˈeɪbl/ adj. 能够
                        
                        **be able to** 能够
                        
                        **question** /ˈkwestʃən/ v. 提问
                        
                        **meaning** /ˈmiːnɪŋ/ n. 意义
                        
                        **discuss** /dɪˈskʌs/ v. 讨论
                        
                        **promise** /ˈprɒmɪs/ v. & n. 承诺
                        
                        **beginning** /bɪˈɡɪn/ n. 开头
                        
                        **at the beginning of** 在……开始
                        
                        **improve** /ɪmˈpruːv/ v. 改进
                        
                        **physical** /ˈfɪzɪkl/ adj. 身体的
                        
                        **self-improvement** /ˌself ɪmˈpruːvmənt/ n. 自我改进
                        
                        **hobby** /ˈhɒbi/ n. 业余爱好
                        
                        **own** /əʊn/ adj. 自己的
                        
                        **personal** /ˈpɜːsənl/ adj. 个人的
                        
                        **relationship** /rɪˈleɪʃnʃɪp/ n. 关系
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "Will people have robots?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **paper** /ˈpeɪpə(r)/ n. 纸
                        
                        **pollution** /pəˈluːʃn/ n. 污染
                        
                        **prediction** /prɪˈdɪkʃn/ n. 预测
                        
                        **future** /ˈfjuːtʃə(r)/ n. 将来
                        
                        **pollute** /pəˈluːt/ v. 污染
                        
                        **environment** /ɪnˈvaɪrənmənt/ n. 环境
                        
                        **planet** /ˈplænɪt/ n. 行星
                        
                        **earth** /ɜːθ/ n. 地球
                        
                        **plant** /plɑːnt/ v. 种植
                        
                        **part** /pɑːt/ n. 部分
                        
                        **play a part** 参与
                        
                        **peace** /piːs/ n. 和平
                        
                        **sea** /siː/ n. 海
                        
                        **build** /bɪld/ v. 建筑
                        
                        **sky** /skaɪ/ n. 天空
                        
                        **astronaut** /ˈæstrənɔːt/ n. 宇航员
                        
                        **apartment** /əˈpɑːtmənt/ n. 公寓
                        
                        **rocket** /ˈrɒkɪt/ n. 火箭
                        
                        **space** /speɪs/ n. 太空
                        
                        **space station** 太空站
                        
                        **human** /ˈhjuːmən/ adj. 人的
                        
                        **servant** /ˈsɜːvənt/ n. 仆人
                        
                        **dangerous** /ˈdeɪndʒərəs/ adj. 危险的
                        
                        **already** /ɔːlˈredi/ adv. 已经
                        
                        **factory** /ˈfæktri/ n. 工厂
                        
                        **believe** /bɪˈliːv/ v. 相信
                        
                        **disagree** /ˌdɪsəˈɡriː/ v. 不同意
                        
                        **even** /ˈiːvn/ adv. 甚至
                        
                        **agree** /əˈɡriː/ v. 同意
                        
                        **shape** /ʃeɪp/ n. 形状
                        
                        **fall** /fɔːl/ v. 倒塌
                        
                        **fall down** 突然倒下
                        
                        **inside** /ˌinˈsaɪd/ adv. 在里面
                        
                        **possible** /ˈpɒsəbl/ adj. 可能的
                        
                        **impossible** /ɪmˈpɒsəbl/ adj. 不可能的
                        
                        **side** /saɪd/ n. 一方
                        
                        **probably** /ˈprɒbəbli/ adv. 很可能
                        
                        **during** /ˈdjʊərɪŋ/ prep. 在……期间
                        
                        **holiday** /ˈɒlədeɪ/ n. 假期
                        
                        **word** /wɜːd/ n. 单词
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "How do you make a banana milk shake?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **shake** /ʃeɪk/ n. & v. 摇动
                        
                        **milk shake** 奶昔
                        
                        **blender** /ˈblendə(r)/ n. 搅拌机
                        
                        **turn on** 打开
                        
                        **peel** /piːl/ v. 剥皮
                        
                        **pour** /pɔː(r)/ v. 倒出
                        
                        **yogurt** /ˈjɒɡət/ n. 酸奶
                        
                        **honey** /ˈhʌni/ n. 蜂蜜
                        
                        **watermelon** /ˈwɔːtəmelən/ n. 西瓜
                        
                        **spoon** /spuːn/ n. 勺
                        
                        **pot** /pɒt/ n. 锅
                        
                        **add** /æd/ v. 增加
                        
                        **finally** /ˈfaɪnəli/ adv. 最后
                        
                        **salt** /sɔːlt/ n. 盐
                        
                        **sugar** /ˈʃʊɡə(r)/ n. 糖
                        
                        **cheese** /tʃiːz/ n. 奶酪
                        
                        **popcorn** /ˈpɒpkɔːn/ n. 爆米花
                        
                        **corn** /kɔːn/ n. 玉米
                        
                        **machine** /məˈʃiːn/ n. 机器
                        
                        **dig** /dɪɡ/ v. 掘
                        
                        **hole** /həʊl/ n. 洞
                        
                        **sandwich** /ˈsænwɪtʃ/ n. 三明治
                        
                        **butter** /ˈbʌtə(r)/ n. 黄油
                        
                        **turkey** /ˈtɜːki/ n. 火鸡
                        
                        **lettuce** /ˈletɪs/ n. 生菜
                        
                        **piece** /piːs/ n. 片
                        
                        **traditional** /trəˈdɪʃənl/ adj. 传统的
                        
                        **autumn** /ˈɔːtəm/ n. 秋天
                        
                        **traveler** /ˈtrævələ(r)/ n. 旅行者
                        
                        **celebrate** /ˈselɪbreɪt/ v. 庆祝
                        
                        **mix** /mɪks/ v. 混合
                        
                        **pepper** /ˈpepə(r)/ n. 胡椒
                        
                        **fill** /fɪl/ v. 充满
                        
                        **oven** /ˈʌvn/ n. 烤箱
                        
                        **plate** /pleɪt/ n. 盘子
                        
                        **cover** /ˈkʌvə(r)/ v. 覆盖
                        
                        **gravy** /ˈɡreɪvi/ n. 肉汁
                        
                        **serve** /sɜːv/ v. 服务
                        
                        **temperature** /ˈtemprətʃə(r)/ n. 温度
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u9", "Unit 9", "Can you come to my party?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **prepare** /prɪˈpeə(r)/ v. 准备
                        
                        **prepare for** 为……做准备
                        
                        **exam** /ɪɡˈzæm/ n. 考试
                        
                        **flu** /fluː/ n. 流感
                        
                        **available** /əˈveɪləbl/ adj. 有空的
                        
                        **until** /ənˈtɪl/ conj. & prep. 直到
                        
                        **hang** /hæŋ/ v. 悬挂
                        
                        **hang out** 闲逛
                        
                        **catch** /ætʃ/ v. 抓住
                        
                        **invite** /ɪnˈvaɪt/ v. 邀请
                        
                        **accept** /əkˈsept/ v. 接受
                        
                        **refuse** /rɪˈfjuːz/ v. 拒绝
                        
                        **invitation** /ˌɪnvɪˈteɪʃn/ n. 邀请
                        
                        **reply** /rɪˈplaɪ/ v. & n. 回答
                        
                        **forward** /ˈfɔːwəd/ v. 转寄
                        
                        **delete** /dɪˈliːt/ v. 删除
                        
                        **print** /prɪnt/ v. 打印
                        
                        **sad** /sæd/ adj. 悲伤的
                        
                        **goodbye** /ˌɡʊdˈbaɪ/ interj. & n. 再见
                        
                        **take a trip** 去旅行
                        
                        **glad** /ɡlæd/ adj. 高兴的
                        
                        **preparation** /ˌprepəˈreɪʃn/ n. 准备
                        
                        **glue** /ɡluː/ n. 胶水
                        
                        **without** /wɪˈðəʊt/ prep. 没有
                        
                        **surprised** /səˈpraɪzd/ adj. 惊奇的
                        
                        **look forward to** 盼望
                        
                        **hear from** 接到……的信
                        
                        **housewarming** /ˈhaʊswɔːmɪŋ/ n. 乔迁宴
                        
                        **opening** /ˈəʊpnɪŋ/ n. 开幕式
                        
                        **concert** /ˈkɒnsət/ n. 音乐会
                        
                        **headmaster** /ˌhedˈmɑːstə(r)/ n. 校长
                        
                        **event** /ɪˈvent/ n. 大事
                        
                        **guest** /ɡest/ n. 客人
                        
                        **calendar** /ˈælɪndə(r)/ n. 日历
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u10", "Unit 10", "If you go to the party, you'll have a great time!",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **meeting** /ˈmiːtɪŋ/ n. 会议
                        
                        **video** /ˈvɪdiəʊ/ n. 视频
                        
                        **organize** /ˈɔːɡənaɪz/ v. 组织
                        
                        **potato chips** 炸土豆片
                        
                        **chocolate** /ˈtʃɒklət/ n. 巧克力
                        
                        **upset** /ʌpˈset/ adj. 难过的
                        
                        **taxi** /ˈtæksi/ n. 出租车
                        
                        **advice** /ədˈvaɪs/ n. 建议
                        
                        **travel** /ˈtrævl/ v. & n. 旅行
                        
                        **agent** /ˈeɪdʒənt/ n. 代理人
                        
                        **expert** /ˈekspɜːt/ n. 专家
                        
                        **keep to oneself** 保守秘密
                        
                        **teenager** /ˈtiːneɪdʒə(r)/ n. 青少年
                        
                        **normal** /ˈnɔːml/ adj. 正常的
                        
                        **unless** /ənˈles/ conj. 除非
                        
                        **certainly** /ˈsɜːtnli/ adv. 无疑
                        
                        **wallet** /ˈwɒlɪt/ n. 钱包
                        
                        **mile** /maɪl/ n. 英里
                        
                        **angry** /ˈæŋɡri/ adj. 发怒的
                        
                        **understanding** /ˌʌndəˈstændɪŋ/ adj. 善解人意的
                        
                        **careless** /ˈkeələs/ adj. 粗心的
                        
                        **mistake** /mɪˈsteɪk/ n. 错误
                        
                        **himself** /hɪmˈself/ pron. 他自己
                        
                        **careful** /ˈkeəfl/ adj. 小心的
                        
                        **advise** /ədˈvaɪs/ v. 建议
                        
                        **solve** /sɒlv/ v. 解决
                        
                        **step** /step/ n. 步骤
                        
                        **trust** /trʌst/ v. 相信
                        
                        **experience** /ɪkˈspɪəriəns/ n. 经验
                        
                        **halfway** /ˌhɑːfˈweɪ/ adj. 中途的
                        
                        **else** /els/ adv. 别的
                    """.trimIndent())
                )
            )
        )
    )
}
