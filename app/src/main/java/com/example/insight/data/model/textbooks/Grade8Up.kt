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
                "g8up_u1", "Unit 1", "Vacations and Experiences",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 个人经历、旅游与休闲。
                        *   **深层意义**：本单元聚焦于分享旅行见闻，引导学生记录生活、分享快乐。同时重点掌握复合不定代词的语法规律。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **anyone** /'eniwʌn/ pron. 任何人
                        **anywhere** /'eniweə(r)/ adv. 在任何地方
                        **wonderful** /'wʌndəfl/ adj. 精彩的；绝妙的
                        **few** /fjuː/ adj. & pron. 不多；很少
                        **quite a few** 相当多；不少
                        **most** /məʊst/ adj. & adv. 最多；大多数
                        **something** /'sʌmθɪŋ/ pron. 某事；某物
                        **nothing** /'nʌθɪŋ/ pron. 没有什么；没有一件东西
                        **myself** /maɪ'self/ pron. 我自己；我本人
                        **everyone** /'evriwʌn/ pron. 每人；人人
                        **yourself** /jɔː'self/ pron. 你自己；您自己
                        **hen** /hen/ n. 母鸡
                        **pig** /pɪɡ/ n. 猪
                        **seem** /siːm/ v. 好像；似乎
                        **bored** /bɔːd/ adj. 厌倦的；烦闷的
                        **someone** /'sʌmwʌn/ pron. 某人
                        **diary** /'daɪəri/ n. 日记；记事簿
                        **activity** /æk'tɪvəti/ n. 活动
                        **decide** /dɪ'saɪd/ v. 决定；选定
                        **try** /traɪ/ v. 尝试；设法
                        **bird** /bɜːd/ n. 鸟
                        **bicycle** /'baɪsɪkl/ n. 自行车
                        **building** /'bɪldɪŋ/ n. 建筑物；房子
                        **trader** /'treɪdə(r)/ n. 商人
                        **wonder** /'wʌndə(r)/ v. 想知道；琢磨
                        **difference** /'dɪfrəns/ n. 差别；差异
                        **top** /tɒp/ n. 顶部；表面
                        **wait** /weɪt/ v. 等待；等候
                        **umbrella** /ʌm'brelə/ n. 伞；雨伞
                        **wet** /wet/ adj. 湿的；潮湿的
                        **below** /bɪ'ləʊ/ prep. & adv. 在……下面
                        **enough** /ɪ'nʌf/ adj. 足够的；充分的
                        **hungry** /'hʌŋɡri/ adj. 饥饿的
                        **as** /əz/ adv. 像……一样；如同
                        **hill** /hɪl/ n. 小山；山丘
                        **duck** /dʌk/ n. 鸭
                        **dislike** /dɪs'laɪk/ v. & n. 不喜爱；厌恶
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
                "g8up_u2", "Unit 2", "Habits and Health",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 生活方式与健康习惯。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **housework** /'haʊswɜːk/ n. 家务劳动
                        **hardly** /'hɑːdli/ adv. 几乎不；简直不
                        **ever** /'evə(r)/ adv. 在任何时候；从来
                        **hardly ever** 几乎从不
                        **once** /wʌns/ adv. 一次；曾经
                        **twice** /twaɪs/ adv. 两次；两倍
                        **Internet** /'ɪntənet/ n. 因特网
                        **program** /'prəʊɡræm/ n. 节目
                        **full** /fʊl/ adj. 忙的；满的
                        **swing** /swɪŋ/ n. & v. 摇摆；秋千
                        **maybe** /'meɪbi/ adv. 大概；也许
                        **least** /liːst/ adv. 最小；最少
                        **at least** 至少；不少于
                        **junk** /dʒʌŋk/ n. 无用的东西
                        **junk food** 垃圾食品
                        **coffee** /'kɒfi/ n. 咖啡
                        **health** /helθ/ n. 健康；身体状况
                        **result** /rɪ'zʌlt/ n. 结果；后果
                        **percent** /pə'sent/ n. 百分之……
                        **online** /ˌɒn'laɪn/ adj. & adv. 在线（的）
                        **television** /'telɪvɪʒn/ n. 电视机；电视节目
                        **although** /ɔːl'ðəʊ/ conj. 虽然；尽管
                        **through** /θruː/ prep. 穿过；凭借
                        **mind** /maɪnd/ n. 头脑；心智
                        **body** /'bɒdi/ n. 身体
                        **such** /sʌtʃ/ adj. & pron. 这样的
                        **such as** 例如
                        **together** /tə'ɡeðə(r)/ adv. 在一起；共同
                        **die** /daɪ/ v. 消失；死亡
                        **writer** /'raɪtə(r)/ n. 作者；作家
                        **dentist** /'dentɪst/ n. 牙科医生
                        **magazine** /ˌmæɡə'ziːn/ n. 杂志
                        **however** /haʊ'evə(r)/ adv. 然而；可是
                        **than** /ðæn/ conj. 比
                        **more than** 多于
                        **almost** /'ɔːlməʊst/ adv. 几乎
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
                "g8up_u3", "Unit 3", "Friends and Similarities",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 友谊。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **outgoing** /'aʊtɡəʊɪŋ/ adj. 外向的
                        **better** /'betə(r)/ adj. & adv. 更好的
                        **loudly** /'laʊdli/ adv. 大声地
                        **quietly** /'kwaɪətli/ adv. 轻声地
                        **hard-working** /ˌhɑːd 'wɜːkɪŋ/ adj. 工作努力的
                        **competition** /ˌkɒmpə'tɪʃn/ n. 比赛；竞争
                        **fantastic** /fæn'tæstɪk/ adj. 极好的
                        **which** /wɪtʃ/ pron. & adj. 哪一个
                        **clearly** /'klɪəli/ adv. 清楚地
                        **win** /wɪn/ v. 获胜
                        **though** /ðəʊ/ conj. & adv. 虽然；不过
                        **talented** /'tæləntɪd/ adj. 有天赋的
                        **truly** /'truːli/ adv. 真正；确实
                        **care** /keə(r)/ v. 在意；担忧
                        **care about** 关心；在意
                        **serious** /'sɪəriəs/ adj. 严肃的
                        **mirror** /'mɪrə(r)/ n. 镜子
                        **kid** /kɪd/ n. 小孩
                        **as long as** 只要
                        **necessary** /'nesəsəri/ adj. 必要的
                        **both** /bəʊθ/ adj. & pron. 两个都
                        **bring out** 使显现
                        **grade** /ɡreɪd/ n. 成绩
                        **should** /ʃʊd/ modal v. 应该
                        **saying** /'seɪɪŋ/ n. 谚语；格言
                        **reach** /riːtʃ/ v. 伸手；到达
                        **hand** /hænd/ n. 手
                        **touch** /tʌtʃ/ v. 感动；触摸
                        **heart** /hɑːt/ n. 内心；心脏
                        **fact** /fækt/ n. 事实
                        **in fact** 事实上
                        **break** /breɪk/ v. 打碎；折断
                        **arm** /ɑːm/ n. 手臂
                        **share** /ʃeə(r)/ v. 分享
                        **loud** /laʊd/ adj. 响亮的
                        **similar** /'sɪmələ(r)/ adj. 相像的
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
                "g8up_u4", "Unit 4", "Best in Town",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **theater** /'θɪətə(r)/ n. 剧场；电影院
                        **comfortable** /'kʌmftəbl/ adj. 舒服的
                        **seat** /siːt/ n. 座位
                        **screen** /skriːn/ n. 屏幕
                        **close** /kləʊs/ adj. 近的
                        **ticket** /'tɪkɪt/ n. 票
                        **worst** /wɜːst/ adj. & adv. 最坏的
                        **cheaply** /'tʃiːpli/ adv. 便宜地
                        **song** /sɒŋ/ n. 歌曲
                        **choose** /tʃuːz/ v. 选择
                        **carefully** /'keəfəli/ adv. 细致地
                        **reporter** /rɪ'pɔːtə(r)/ n. 记者
                        **fresh** /freʃ/ adj. 新鲜的
                        **comfortably** /'kʌmftəbli/ adv. 舒适地
                        **worse** /wɜːs/ adj. & adv. 更坏的
                        **service** /'sɜːvɪs/ n. 服务
                        **pretty** /'prɪti/ adv. 相当
                        **menu** /'menjuː/ n. 菜单
                        **act** /ækt/ v. 表演
                        **meal** /miːl/ n. 晚餐
                        **creative** /kri'eɪtɪv/ adj. 有创造力的
                        **performer** /pə'fɔːmə(r)/ n. 表演者
                        **talent** /'tælənt/ n. 天资
                        **common** /'kɒmən/ adj. 常见的
                        **magician** /mə'dʒɪʃn/ n. 魔术师
                        **all kinds of** 各种各样的
                        **beautifully** /'bjuːtɪfli/ adv. 美丽地
                        **role** /rəʊl/ n. 角色
                        **play a role** 发挥作用
                        **winner** /'wɪnə(r)/ n. 获胜者
                        **prize** /praɪz/ n. 奖品
                        **everybody** /'evribɒdi/ pron. 每人
                        **make up** 编造
                        **example** /ɪɡ'zɑːmpl/ n. 例子
                        **for example** 例如
                        **poor** /pɔː(r)/ adj. 贫穷的
                        **seriously** /'sɪəriəsli/ adv. 严重地
                        **give** /ɡɪv/ v. 给
                        **crowded** /'kraʊdɪd/ adj. 拥挤的
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：最高级
                        - the + adj.est / most + adj.
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "Entertainment",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **sitcom** /'sɪtkɒm/ n. 情景喜剧
                        **news** /njuːz/ n. 新闻
                        **soap** /səʊp/ n. 肥皂
                        **soap opera** 肥皂剧
                        **educational** /ˌedʒu'keɪʃənl/ adj. 教育的
                        **plan** /plæn/ v. & n. 计划
                        **hope** /həʊp/ v. & n. 希望
                        **discussion** /dɪ'skʌʃn/ n. 讨论
                        **stand** /stænd/ v. 忍受
                        **happen** /'æpən/ v. 发生
                        **may** /meɪ/ modal v. 也许
                        **expect** /ɪk'spekt/ v. 期待
                        **joke** /dʒəʊk/ n. 玩笑
                        **comedy** /'kɒmədi/ n. 喜剧
                        **meaningless** /'miːnɪŋləs/ adj. 毫无意义的
                        **action** /'ækʃn/ n. 行动
                        **action movie** 动作片
                        **cartoon** /kɑː'tuːn/ n. 动画片
                        **culture** /'kʌltʃə(r)/ n. 文化
                        **famous** /'feɪməs/ adj. 著名的
                        **appear** /ə'pɪə(r)/ v. 出现
                        **become** /bɪ'ʌm/ v. 变成
                        **rich** /rɪtʃ/ adj. 富有的
                        **successful** /sək'sesfl/ adj. 成功的
                        **might** /maɪt/ modal v. 可能
                        **main** /meɪn/ adj. 主要的
                        **reason** /'riːzn/ n. 原因
                        **film** /fɪlm/ n. 电影
                        **unlucky** /ʌn'lʌki/ adj. 不幸的
                        **lose** /luːz/ v. 丢失
                        **ready** /'ready/ adj. 愿意的
                        **be ready to** 准备好
                        **character** /'kærəktə(r)/ n. 人物
                        **simple** /'sɪmpl/ adj. 简单的
                        **dress up** 装扮
                        **take sb's place** 代替
                        **army** /'ɑːmi/ n. 军队
                        **do a good job** 工作出色
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "Dreams and Resolutions",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **doctor** /'dɒktə(r)/ n. 医生
                        **engineer** /ˌendʒɪ'nɪə(r)/ n. 工程师
                        **violinist** /ˌvaɪə'lɪnɪst/ n. 小提琴手
                        **pilot** /'paɪlət/ n. 飞行员
                        **pianist** /'pɪənɪst/ n. 钢琴家
                        **scientist** /'saɪəntɪst/ n. 科学家
                        **college** /'kɒlɪdʒ/ n. 学院
                        **education** /ˌedʒu'keɪʃn/ n. 教育
                        **medicine** /'medsn/ n. 药
                        **university** /[ˌjuːnɪ'vɜːsəti]/ n. 大学
                        **article** /'ɑːtɪkl/ n. 文章
                        **send** /send/ v. 邮寄
                        **resolution** /[ˌrezə'luːʃn]/ n. 决心
                        **team** /tiːm/ n. 队
                        **foreign** /'fɒrən/ adj. 外国的
                        **able** /'eɪbl/ adj. 能够
                        **be able to** 能够
                        **question** /'kwestʃən/ v. 提问
                        **meaning** /'miːnɪŋ/ n. 意义
                        **discuss** /dɪ'skʌs/ v. 讨论
                        **promise** /'prɒmɪs/ v. & n. 承诺
                        **beginning** /bɪ'ɡɪn/ n. 开头
                        **at the beginning of** 在……开始
                        **improve** /ɪm'pruːv/ v. 改进
                        **physical** /'fɪzɪkl/ adj. 身体的
                        **self-improvement** /ˌself ɪm'pruːvmənt/ n. 自我改进
                        **hobby** /'hɒbi/ n. 业余爱好
                        **own** /əʊn/ adj. 自己的
                        **personal** /'pɜːsənl/ adj. 个人的
                        **relationship** /rɪ'leɪʃnʃɪp/ n. 关系
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "The Future",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **paper** /'peɪpə(r)/ n. 纸
                        **pollution** /pə'luːʃn/ n. 污染
                        **prediction** /prɪ'dɪkʃn/ n. 预测
                        **future** /'fjuːtʃə(r)/ n. 将来
                        **pollute** /pə'luːt/ v. 污染
                        **environment** /ɪn'vaɪrənmənt/ n. 环境
                        **planet** /'plænɪt/ n. 行星
                        **earth** /ɜːθ/ n. 地球
                        **plant** /plɑːnt/ v. 种植
                        **part** /pɑːt/ n. 部分
                        **play a part** 参与
                        **peace** /piːs/ n. 和平
                        **sea** /siː/ n. 海
                        **build** /bɪld/ v. 建筑
                        **sky** /skaɪ/ n. 天空
                        **astronaut** /'æstrənɔːt/ n. 宇航员
                        **apartment** /ə'pɑːtmənt/ n. 公寓
                        **rocket** /'rɒkɪt/ n. 火箭
                        **space** /speɪs/ n. 太空
                        **space station** 太空站
                        **human** /'hjuːmən/ adj. 人的
                        **servant** /'sɜːvənt/ n. 仆人
                        **dangerous** /'deɪndʒərəs/ adj. 危险的
                        **already** /ɔːl'redi/ adv. 已经
                        **factory** /'fæktri/ n. 工厂
                        **believe** /bɪ'liːv/ v. 相信
                        **disagree** /ˌdɪsə'ɡriː/ v. 不同意
                        **even** /'iːvn/ adv. 甚至
                        **agree** /ə'ɡriː/ v. 同意
                        **shape** /ʃeɪp/ n. 形状
                        **fall** /fɔːl/ v. 倒塌
                        **fall down** 突然倒下
                        **inside** /ˌin'saɪd/ adv. 在里面
                        **possible** /'pɒsəbl/ adj. 可能的
                        **impossible** /ɪm'pɒsəbl/ adj. 不可能的
                        **side** /saɪd/ n. 一方
                        **probably** /'prɒbəbli/ adv. 很可能
                        **during** /'djʊərɪŋ/ prep. 在……期间
                        **holiday** /'hɒlədeɪ/ n. 假期
                        **word** /wɜːd/ n. 单词
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "Cooking and Recipes",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **shake** /ʃeɪk/ n. & v. 摇动
                        **milk shake** 奶昔
                        **blender** /'blendə(r)/ n. 搅拌机
                        **turn on** 打开
                        **peel** /piːl/ v. 剥皮
                        **pour** /pɔː(r)/ v. 倒出
                        **yogurt** /'jɒɡət/ n. 酸奶
                        **honey** /'hʌni/ n. 蜂蜜
                        **watermelon** /'wɔːtəmelən/ n. 西瓜
                        **spoon** /spuːn/ n. 勺
                        **pot** /pɒt/ n. 锅
                        **add** /æd/ v. 增加
                        **finally** /'faɪnəli/ adv. 最后
                        **salt** /sɔːlt/ n. 盐
                        **sugar** /'ʃʊɡə(r)/ n. 糖
                        **cheese** /tʃiːz/ n. 奶酪
                        **popcorn** /'pɒpkɔːn/ n. 爆米花
                        **corn** /kɔːn/ n. 玉米
                        **machine** /mə'ʃiːn/ n. 机器
                        **dig** /dɪɡ/ v. 掘
                        **hole** /həʊl/ n. 洞
                        **sandwich** /'sænwɪtʃ/ n. 三明治
                        **butter** /'bʌtə(r)/ n. 黄油
                        **turkey** /'tɜːki/ n. 火鸡
                        **lettuce** /'letɪs/ n. 生菜
                        **piece** /piːs/ n. 片
                        **traditional** /trə'dɪʃənl/ adj. 传统的
                        **autumn** /'ɔːtəm/ n. 秋天
                        **traveler** /'trævələ(r)/ n. 旅行者
                        **celebrate** /'selɪbreɪt/ v. 庆祝
                        **mix** /mɪks/ v. 混合
                        **pepper** /'pepə(r)/ n. 胡椒
                        **fill** /fɪl/ v. 充满
                        **oven** /'ʌvn/ n. 烤箱
                        **plate** /pleɪt/ n. 盘子
                        **cover** /'kʌvə(r)/ v. 覆盖
                        **gravy** /'ɡreɪvi/ n. 肉汁
                        **serve** /sɜːv/ v. 服务
                        **temperature** /'temprətʃə(r)/ n. 温度
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u9", "Unit 9", "Invitations",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **prepare** /prɪ'peə(r)/ v. 准备
                        **prepare for** 为……做准备
                        **exam** /ɪɡ'zæm/ n. 考试
                        **flu** /fluː/ n. 流感
                        **available** /ə'veɪləbl/ adj. 有空的
                        **until** /ən'tɪl/ conj. & prep. 直到
                        **hang** /hæŋ/ v. 悬挂
                        **hang out** 闲逛
                        **catch** /ætʃ/ v. 抓住
                        **invite** /ɪn'vaɪt/ v. 邀请
                        **accept** /ək'sept/ v. 接受
                        **refuse** /rɪ'fjuːz/ v. 拒绝
                        **invitation** /ˌɪnvɪ'teɪʃn/ n. 邀请
                        **reply** /rɪ'plaɪ/ v. & n. 回答
                        **forward** /'fɔːwəd/ v. 转寄
                        **delete** /dɪ'liːt/ v. 删除
                        **print** /prɪnt/ v. 打印
                        **sad** /sæd/ adj. 悲伤的
                        **goodbye** /ˌɡʊd'baɪ/ interj. & n. 再见
                        **take a trip** 去旅行
                        **glad** /ɡlæd/ adj. 高兴的
                        **preparation** /ˌprepə'reɪʃn/ n. 准备
                        **glue** /ɡluː/ n. 胶水
                        **without** /wɪ'ðəʊt/ prep. 没有
                        **surprised** /sə'praɪzd/ adj. 惊奇的
                        **look forward to** 盼望
                        **hear from** 接到……的信
                        **housewarming** /'haʊswɔːmɪŋ/ n. 乔迁宴
                        **opening** /'əʊpnɪŋ/ n. 开幕式
                        **concert** /'kɒnsət/ n. 音乐会
                        **headmaster** /ˌhed'mɑːstə(r)/ n. 校长
                        **event** /ɪ'vent/ n. 大事
                        **guest** /ɡest/ n. 客人
                        **calendar** /'ælɪndə(r)/ n. 日历
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u10", "Unit 10", "Advice and Decisions",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **meeting** /'miːtɪŋ/ n. 会议
                        **video** /'vɪdiəʊ/ n. 视频
                        **organize** /'ɔːɡənaɪz/ v. 组织
                        **potato chips** 炸土豆片
                        **chocolate** /'tʃɒklət/ n. 巧克力
                        **upset** /ʌp'set/ adj. 难过的
                        **taxi** /'tæksi/ n. 出租车
                        **advice** /əd'vaɪs/ n. 建议
                        **travel** /'trævl/ v. & n. 旅行
                        **agent** /'eɪdʒənt/ n. 代理人
                        **expert** /'ekspɜːt/ n. 专家
                        **keep to oneself** 保守秘密
                        **teenager** /'tiːneɪdʒə(r)/ n. 青少年
                        **normal** /'nɔːml/ adj. 正常的
                        **unless** /ən'les/ conj. 除非
                        **certainly** /'sɜːtnli/ adv. 无疑
                        **wallet** /'wɒlɪt/ n. 钱包
                        **mile** /maɪl/ n. 英里
                        **angry** /'æŋɡri/ adj. 发怒的
                        **understanding** /ˌʌndə'stændɪŋ/ adj. 善解人意的
                        **careless** /'keələs/ adj. 粗心的
                        **mistake** /mɪ'steɪk/ n. 错误
                        **himself** /hɪm'self/ pron. 他自己
                        **careful** /'keəfl/ adj. 小心的
                        **advise** /əd'vaɪs/ v. 建议
                        **solve** /sɒlv/ v. 解决
                        **step** /step/ n. 步骤
                        **trust** /trʌst/ v. 相信
                        **experience** /ɪk'spɪəriəns/ n. 经验
                        **halfway** /ˌhɑːf'weɪ/ adj. 中途的
                        **else** /els/ adv. 别的
                    """.trimIndent())
                )
            )
        )
    )
}
