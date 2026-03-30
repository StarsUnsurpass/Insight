package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection
import kotlin.collections.listOf
import kotlin.text.trimIndent

object Grade9Full {
    val data = Textbook(
        id = "g9_full",
        grade = "九年级",
        term = "全一册",
        coverColor = Color(0xFFFFCCBC),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/qc9x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g9_u1", "Unit 1", "How can we become good learners?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 学习策略与个人成长。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **textbook** /ˈtekstbʊk/ n. 教科书；课本
                        
                        **conversation** /ˌkɒnvəˈseɪʃn/ n. 交谈；谈话
                        
                        **aloud** /əˈlaʊd/ adv. 大声地；出声地
                        
                        **pronunciation** /prəˌnʌnsiˈeɪʃn/ n. 发音；读音
                        
                        **sentence** /ˈsentəns/ n. 句子
                        
                        **patient** /ˈpeɪʃnt/ adj. 有耐心的 n. 病人
                        
                        **expression** /ɪkˈspreʃn/ n. 表达方式；表示
                        
                        **discover** /dɪˈskʌvə(r)/ v. 发现；发觉
                        
                        **secret** /ˈsiːkrət/ n. 秘密；秘诀 adj. 秘密的
                        
                        **grammar** /ˈɡræmə(r)/ n. 语法
                        
                        **repeat** /rɪˈpiːt/ v. 重复；重做
                        
                        **note** /nəʊt/ n. 笔记；记录 v. 注意
                        
                        **physics** /ˈfɪzɪks/ n. 物理；物理学
                        
                        **chemistry** /ˈkemɪstri/ n. 化学
                        
                        **memorize** /ˈmeməraɪz/ v. 记忆；记住
                        
                        **pattern** /ˈpætən/ n. 模式；方式
                        
                        **pronounce** /prəˈnaʊns/ v. 发音
                        
                        **increase** /ɪnˈkriːs/ v. 增加；增长
                        
                        **speed** /spiːd/ n. 速度
                        
                        **partner** /ˈpɑːtnə(r)/ n. 搭档；同伴
                        
                        **ability** /əˈbɪləti/ n. 能力；才能
                        
                        **brain** /breɪn/ n. 大脑
                        
                        **active** /ˈæktɪv/ adj. 活跃的；积极的
                        
                        **attention** /əˈtenʃn/ n. 注意；关注
                        
                        **connect** /kəˈnekt/ v. （使）连接；与……有联系
                        
                        **overnight** /ˌəʊvəˈnaɪt/ adv. 一夜之间；在夜间
                        
                        **review** /rɪˈvjuː/ v. & n. 回顾；复习
                        
                        **knowledge** /ˈnɒlɪdʒ/ n. 知识；学问
                        
                        **wisely** /ˈwaɪzli/ adv. 明智地；聪明地
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：by 引导的方式状语
                        - *I study English **by listening** to tapes.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u2", "Unit 2", "I think that mooncakes are delicious!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 传统节日。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **mooncake** /ˈmuːnkeɪk/ n. 月饼
                        
                        **lantern** /ˈlæntən/ n. 灯笼
                        
                        **stranger** /ˈstreɪndʒə(r)/ n. 陌生人
                        
                        **relative** /ˈrelətɪv/ n. 亲属；亲戚
                        
                        **pound** /paʊnd/ n. 磅；英镑
                        
                        **steal** /stiːl/ v. 偷；窃取
                        
                        **lay** /leɪ/ v. 放置；下蛋
                        
                        **dessert** /dɪˈzɜːt/ n. （饭后）甜点
                        
                        **admire** /ədˈmaɪə(r)/ v. 欣赏；仰慕
                        
                        **garden** /ˈɡɑːdn/ n. 花园；园子
                        
                        **tie** /taɪ/ n. 领带 v. 捆；系
                        
                        **haunted** /ˈhɔːntɪd/ adj. 有鬼魂出没的
                        
                        **ghost** /ɡəʊst/ n. 鬼；幽灵
                        
                        **trick** /trɪk/ n. 诡计；花招
                        
                        **treat** /triːt/ n. 款待；乐事 v. 款待
                        
                        **Christmas** /ˈkrɪsməs/ n. 圣诞节
                        
                        **lie** /laɪ/ v. 躺；平躺；撒谎
                        
                        **novel** /ˈnɒvl/ n. 小说
                        
                        **eve** /iːv/ n. （节日或事件的）前夕
                        
                        **dead** /ded/ adj. 死的；无生命的
                        
                        **business** /ˈbɪznəs/ n. 生意；商业
                        
                        **punish** /ˈpʌnɪʃ/ v. 惩罚；惩治
                        
                        **warn** /ˈwɔːn/ v. 警告；告诫
                        
                        **present** /ˈpreznt/ n. 礼物 adj. 现在的
                        
                        **nobody** /ˈnəʊbədi/ pron. 没有人
                        
                        **warmth** /wɔːmθ/ n. 温暖；暖和
                        
                        **spread** /spred/ v. 传播；展开
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：宾语从句 (that 引导)
                        - *I think **that** mooncakes are delicious!*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u3", "Unit 3", "Could you please tell me where the restrooms are?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **restroom** /ˈrestruːm/ n. 洗手间
                        
                        **stamp** /stæmp/ n. 邮票
                        
                        **bookstore** /ˈbʊkstɔː(r)/ n. 书店
                        
                        **beside** /bɪˈsaɪd/ prep. 在……旁边
                        
                        **postcard** /ˈpəʊstkɑːd/ n. 明信片
                        
                        **pardon** /ˈpɑːdn/ interj. & v. 原谅
                        
                        **washroom** /ˈwɒʃruːm/ n. 洗手间
                        
                        **bathroom** /ˈbɑːθruːm/ n. 浴室；洗手间
                        
                        **quick** /kwɪk/ adj. 快的；迅速的
                        
                        **rush** /rʌʃ/ v. & n. 仓促；急促
                        
                        **suggest** /səˈdʒest/ v. 建议；提议
                        
                        **staff** /stɑːf/ n. 管理人员；职工
                        
                        **grape** /ɡreɪp/ n. 葡萄
                        
                        **central** /ˈsentrəl/ adj. 中央的；中心的
                        
                        **nearby** /ˈnɪəbaɪ/ adj. 附近的 adv. 在附近
                        
                        **mail** /meɪl/ v. 邮寄 n. 邮件
                        
                        **east** /iːst/ adj. 东方的 n. 东方
                        
                        **fascinating** /ˈfæsɪneɪtɪŋ/ adj. 迷人的
                        
                        **convenient** /kənˈviːniənt/ adj. 便利的；方便的
                        
                        **mall** /mɔːl/ n. 购物商场
                        
                        **clerk** /klɜːk/ n. 职员
                        
                        **corner** /ˈkɔːnə(r)/ n. 拐角；角落
                        
                        **polite** /pəˈlaɪt/ adj. 有礼貌的
                        
                        **speaker** /ˈspiːkə(r)/ n. 发言者；扬声器
                        
                        **request** /rɪˈkwest/ n. & v. 要求；请求
                        
                        **choice** /tʃɔɪs/ n. 选择
                        
                        **direction** /daɪˈrekʃn/ n. 方向；方位
                        
                        **correct** /kəˈrekt/ adj. 正确的；恰当的
                        
                        **direct** /dəˈrekt/ adj. 直接的；直率的
                        
                        **address** /əˈdres/ n. 住址；地址
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：宾语从句 (wh- 引导)
                        - *Could you tell me **where the restrooms are**?*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u4", "Unit 4", "I used to be afraid of the dark.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **humorous** /ˈhjuːmərəs/ adj. 有幽默感的
                        
                        **silent** /ˈsaɪlənt/ adj. 沉默的
                        
                        **helpful** /ˈhelpfl/ adj. 有帮助的
                        
                        **score** /skɔː(r)/ n. & v. 得分；分数
                        
                        **background** /ˈbækɡraʊnd/ n. 背景
                        
                        **interview** /ˈɪntəvjuː/ v. & n. 采访；面试
                        
                        **Asian** /ˈeɪʒn/ adj. 亚洲的 n. 亚洲人
                        
                        **deal with** 处理；应对
                        
                        **dare** /deə(r)/ v. 敢于；胆敢
                        
                        **private** /ˈpraɪvət/ adj. 私人的；私有的
                        
                        **guard** /ɡɑːd/ n. 警卫；看守 v. 守卫
                        
                        **require** /rɪˈkwaɪə(r)/ v. 需要；要求
                        
                        **European** /ˌjʊərəˈpiːən/ adj. 欧洲的 n. 欧洲人
                        
                        **African** /ˈæfrɪkən/ adj. 非洲的 n. 非洲人
                        
                        **British** /ˈbrɪtɪʃ/ adj. 英国的；英国人的
                        
                        **speech** /spiːtʃ/ n. 演讲
                        
                        **public** /ˈspʌblɪk/ n. 民众 adj. 公开的
                        
                        **ant** /ænt/ n. 蚂蚁
                        
                        **insect** /ˈɪnsekt/ n. 昆虫
                        
                        **seldom** /ˈseldəm/ adv. 不常；很少
                        
                        **influence** /ˈɪnfluəns/ v. & n. 影响
                        
                        **absent** /ˈæbsənt/ adj. 缺席的
                        
                        **fail** /feɪl/ v. 失败；不及格
                        
                        **examination** /ɪɡˌzæmɪˈneɪʃn/ n. 考试；审查
                        
                        **boarding school** 寄宿学校
                        
                        **in person** 亲身；亲自
                        
                        **exactly** /ɪɡˈzæktli/ adv. 确切地；精确地
                        
                        **pride** /praɪd/ n. 自豪；骄傲
                        
                        **proud** /praʊd/ adj. 自豪的；骄傲的
                        
                        **general** /ˈdʒenrəl/ adj. 总的；普遍的
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：used to do sth.
                        - 表示过去常常做某事（现在不做了）。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u5", "Unit 5", "What are the shirts made of?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **material** /məˈtɪəriəl/ n. 材料；原料
                        
                        **chopstick** /ˈtʃɒpstɪk/ n. 筷子
                        
                        **coin** /kɔɪn/ n. 硬币
                        
                        **fork** /fɔːk/ n. 餐叉；叉
                        
                        **blouse** /blaʊz/ n. （女式）短上衣；衬衫
                        
                        **silver** /ˈsɪlvə(r)/ n. 银；银器 adj. 银色的
                        
                        **glass** /ɡlɑːs/ n. 玻璃
                        
                        **cotton** /ˈkɒtn/ n. 棉；棉花
                        
                        **steel** /ˈstiːl/ n. 钢；钢铁
                        
                        **fair** /feə(r)/ n. 展览会；游乐场
                        
                        **leaf** /liːf/ n. 叶；叶子 (pl. leaves)
                        
                        **produce** /prəˈdjuːs/ v. 生产；制造
                        
                        **widely** /ˈwaɪdli/ adv. 广泛地
                        
                        **process** /ˈprəʊses/ v. 加工；处理
                        
                        **France** /frɑːns/ n. 法国
                        
                        **no matter** 不论；无论
                        
                        **local** /ˈləʊkl/ adj. 当地的；本地的
                        
                        **brand** /brænd/ n. 品牌
                        
                        **avoid** /əˈvɔɪd/ v. 避免；回避
                        
                        **product** /ˈprɒdʌkt/ n. 产品
                        
                        **hand-made** /ˌhænd ˈmeɪd/ adj. 手工制作的
                        
                        **mobile** /ˈməʊbaɪl/ adj. 可移动的
                        
                        **everyday** /ˈevrideɪ/ adj. 每天的；日常的
                        
                        **boss** /bɒs/ n. 老板
                        
                        **Germany** /ˈdʒɜːməni/ n. 德国
                        
                        **surface** /ˈsɜːfɪs/ n. 表面
                        
                        **postman** /ˈpəʊstmən/ n. 邮递员
                        
                        **cap** /kæp/ n. （尤指有檐的）帽子
                        
                        **glove** /ɡlʌv/ n. 手套
                        
                        **international** /ˌɪntəˈnæʃnəl/ adj. 国际的
                        
                        **competitor** /kəmˈpetɪtə(r)/ n. 参赛者
                        
                        **its** /ɪts/ adj. 它的
                        
                        **pride** /praɪd/ n. 自豪；骄傲
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：被动语态 (I)
                        - *What **is** it **made of**?*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u6", "Unit 6", "When was it invented?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **heel** /hiːl/ n. 鞋后跟
                        
                        **scoop** /skuːp/ n. 勺子
                        
                        **electricity** /ɪˌlekˈtrɪsəti/ n. 电；电能
                        
                        **style** /staɪl/ n. 样式；款式
                        
                        **project** /ˈprɒdʒekt/ n. 项目；工程
                        
                        **pleasure** /ˈpleʒə(r)/ n. 愉快；快乐
                        
                        **zipper** /ˈzɪpə(r)/ n. 拉链
                        
                        **daily** /ˈdeɪli/ adj. 每日的
                        
                        **website** /ˈwebsaɪt/ n. 网站
                        
                        **pioneer** /ˌpaɪəˈnɪə(r)/ n. 先驱
                        
                        **list** /lɪst/ v. 列表 n. 列表
                        
                        **mention** /ˈmenʃn/ v. 提到；说到
                        
                        **accidental** /ˌæksɪˈdentl/ adj. 意外的；偶然的
                        
                        **ruler** /ˈruːlə(r)/ n. 统治者；尺子
                        
                        **boil** /bɔɪl/ v. 沸腾；煮沸
                        
                        **remain** /rɪˈmeɪn/ v. 保持不变；剩余
                        
                        **smell** /smel/ n. 气味 v. 闻到
                        
                        **saint** /seɪnt/ n. 圣徒
                        
                        **national** /ˈnæʃnəl/ adj. 国家的
                        
                        **trade** /treɪd/ n. 贸易；交易
                        
                        **popularity** /ˌpɒpjuˈlærəti/ n. 普及；流行
                        
                        **doubt** /daʊt/ n. 怀疑 v. 怀疑
                        
                        **fridge** /frɪdʒ/ n. 冰箱
                        
                        **low** /ləʊ/ adj. 低的
                        
                        **translate** /trænzˈleɪt/ v. 翻译
                        
                        **lock** /lɒk/ v. 锁上
                        
                        **earthquake** /ˈɜːθkweɪk/ n. 地震
                        
                        **sudden** /ˈsʌdn/ adj. 突然的
                        
                        **bell** /bel/ n. 钟（声）；铃（声）
                        
                        **biscuit** /ˈbɪskɪt/ n. 饼干
                        
                        **musical** /ˈmjuːzɪkl/ adj. 音乐的
                        
                        **instrument** /ˈɪnstrəmənt/ n. 仪器；乐器
                        
                        **bitter** /ˈbɪtə(r)/ adj. 苦的；有苦味的
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：被动语态 (II) - 一般过去时
                        - *When **was** it **invented**?*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u7", "Unit 7", "Teenagers should be allowed to choose their own clothes.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **license** /ˈlaɪsns/ n. 证；证件
                        
                        **safety** /ˈseɪfti/ n. 安全；保险
                        
                        **smoke** /sməʊk/ v. 吸烟；冒烟
                        
                        **part-time** /ˌpɑːt ˈtaɪm/ adj. & adv. 兼职
                        
                        **pierce** /pɪəs/ v. 刺穿；刺破
                        
                        **earring** /ˈɪərɪŋ/ n. 耳环
                        
                        **flash** /flæʃ/ n. 闪光
                        
                        **tiny** /ˈtaɪni/ adj. 极小的
                        
                        **cry** /kraɪ/ v. & n. 哭
                        
                        **field** /fiːld/ n. 田野；场地
                        
                        **hug** /hʌɡ/ v. & n. 拥抱
                        
                        **lift** /lɪft/ v. 举起
                        
                        **badly** /ˈbædli/ adv. 严重地；差
                        
                        **awful** /ˈɔːfl/ adj. 可怕的；糟糕的
                        
                        **teen** /tiːn/ n. 青少年
                        
                        **regret** /rɪˈɡret/ v. & n. 后悔；遗憾
                        
                        **poem** /ˈpəʊɪm/ n. 诗；韵文
                        
                        **community** /kəˈmjuːnəti/ n. 社区
                        
                        **keep away from** 远离；不接近
                        
                        **decision** /dɪˈsɪʒn/ n. 决定
                        
                        **educate** /ˈedjukeɪt/ v. 教育
                        
                        **manage** /ˈmænɪdʒ/ v. 管理；控制
                        
                        **society** /səˈsaɪəti/ n. 社会
                        
                        **support** /səˈpɔːt/ v. & n. 支持
                        
                        **enter** /ˈentə(r)/ v. 进来；进去
                        
                        **choice** /tʃɔɪs/ n. 选择；挑选
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：含情态动词的被动语态
                        - *Teenagers **should be allowed** to ...*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u8", "Unit 8", "It must belong to Carla.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **whose** /huːz/ pron. 谁的
                        
                        **truck** /trʌk/ n. 卡车；货车
                        
                        **picnic** /ˈpɪknɪk/ n. 野餐
                        
                        **rabbit** /ˈræbɪt/ n. 兔；野兔
                        
                        **attend** /əˈtend/ v. 出席；参加
                        
                        **valuable** /ˈvæljuəbl/ adj. 贵重的
                        
                        **pink** /pɪŋk/ adj. & n. 粉红色
                        
                        **anybody** /ˈenibɒdi/ pron. 任何人
                        
                        **happening** /ˈhæpnɪŋ/ n. 发生的事情
                        
                        **noise** /nɔɪz/ n. 声音；噪音
                        
                        **policeman** /ˈpəʊlɪsmən/ n. 男警察
                        
                        **wolf** /wʊlf/ n. 狼 (pl. wolves)
                        
                        **uneasy** /ʌnˈiːzi/ adj. 心神不安的
                        
                        **laboratory** /ləˈbɒrətri/ n. 实验室
                        
                        **outdoors** /ˌaʊtˈdɔːz/ adv. 在户外
                        
                        **coat** /kəʊt/ n. 外套
                        
                        **sleepy** /ˈsliːpi/ adj. 困倦的
                        
                        **land** /lænd/ n. 陆地 v. 着陆
                        
                        **alien** /ˈeɪliən/ n. 外星人
                        
                        **run after** 追逐；追赶
                        
                        **suit** /suːt/ n. 西服 v. 适合
                        
                        **express** /ɪkˈspres/ v. 表达
                        
                        **circle** /ˈsɜːkl/ n. 圆圈 v. 圈出
                        
                        **Britain** /ˈbrɪtn/ n. 英国
                        
                        **receive** /rɪˈsiːv/ v. 接到；收到
                        
                        **leader** /ˈliːdə(r)/ n. 领导；领袖
                        
                        **medical** /ˈmedɪkl/ adj. 医疗的；医学的
                        
                        **purpose** /ˈpɜːpəs/ n. 目的
                        
                        **prevent** /rɪˈsiːv/ v. 阻止；预防
                        
                        **energy** /ˈenədʒi/ n. 能量；精力
                        
                        **position** /ˈpəzɪʃn/ n. 位置；地方
                        
                        **victory** /ˈvɪktəri/ n. 胜利
                        
                        **enemy** /ˈenəmi/ n. 敌人
                        
                        **period** /ˈpɪəriəd/ n. 一段时间；时期
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：情态动词表推测
                        - must (一定), might/could (可能), can't (不可能)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u9", "Unit 9", "I like music that I can dance to.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **prefer** /prɪˈfɜː(r)/ v. 更喜欢
                        
                        **lyrics** /ˈlɪrɪks/ n. 歌词
                        
                        **Australian** /ɒˈstreɪliən/ adj. 澳大利亚的
                        
                        **electronic** /ɪˌlekˈtrɒnɪk/ adj. 电子的
                        
                        **suppose** /səˈpəʊz/ v. 推断；料想
                        
                        **smooth** /smuːð/ adj. 悦耳的；平滑的
                        
                        **spare** /speə(r)/ adj. 空闲的 v. 抽出
                        
                        **director** /dəˈrektə(r)/ n. 导演；负责人
                        
                        **case** /keɪs/ n. 情况；实例
                        
                        **war** /wɔː(r)/ n. 战争
                        
                        **stick** /stɪk/ v. 粘贴；坚持
                        
                        **down** /daʊn/ adj. 悲哀的；沮丧的
                        
                        **dialogue** /ˈdaɪəlɒɡ/ n. 对话；谈话
                        
                        **ending** /ˈendɪŋ/ n. 结尾；结局
                        
                        **documentary** /ˌdɒkjuˈmentri/ n. 纪录片
                        
                        **drama** /ˈdrɑːmə/ n. 戏；剧
                        
                        **plenty** /ˈplenti/ pron. 大量；众多
                        
                        **shut** /ʃʌt/ v. 关闭
                        
                        **superhero** /ˈsuːpəhɪərəʊ/ n. 超级英雄
                        
                        **intelligent** /ɪnˈtelɪdʒənt/ adj. 有才智的；聪明的
                        
                        **sense** /sens/ v. 感觉到 n. 感觉
                        
                        **sadness** /ˈsædnəs/ n. 悲哀；忧伤
                        
                        **pain** /peɪn/ n. 痛苦；苦恼
                        
                        **reflect** /rɪˈflekt/ v. 反映；映射
                        
                        **moving** /ˈmuːvɪŋ/ adj. 动人的
                        
                        **pity** /ˈpɪti/ n. 遗憾；怜悯
                        
                        **total** /ˈtəʊtl/ adj. & n. 总数
                        
                        **master** /ˈmɑːstə(r)/ n. 大师 v. 掌握
                        
                        **praise** /preɪz/ v. & n. 表扬；赞扬
                        
                        **recall** /rɪˈkɔːl/ v. 回忆起；回想起
                        
                        **wound** /wuːnd/ n. 伤；伤口 v. 使受伤
                        
                        **lifetime** /ˈlaɪftaɪm/ n. 一生
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：定语从句 (I)
                        - 修饰人用 who/that，修饰物用 which/that。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u10", "Unit 10", "You're supposed to shake hands.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **custom** /ˈkʌstəm/ n. 风俗；习俗
                        
                        **bow** /baʊ/ v. & n. 鞠躬
                        
                        **kiss** /kɪs/ v. & n. 吻
                        
                        **greet** /ɡriːt/ v. 问候；打招呼
                        
                        **relaxed** /rɪˈlækst/ adj. 放松的
                        
                        **value** /ˈvæljuː/ v. 重视 n. 价值
                        
                        **drop by** 顺便拜访
                        
                        **capital** /ˈkæpɪtl/ n. 首都
                        
                        **after all** 毕竟
                        
                        **noon** /nuːn/ n. 正午
                        
                        **mad** /mæd/ adj. 疯狂的
                        
                        **effort** /ˈefət/ n. 努力
                        
                        **passport** /ˈpɑːspɔːt/ n. 护照
                        
                        **clean** /kliːn/ v. 擦干净
                        
                        **chalk** /tʃɔːk/ n. 粉笔
                        
                        **blackboard** /ˈblækbɔːd/ n. 黑板
                        
                        **northern** /ˈnɔːðən/ adj. 北方的
                        
                        **coast** /kəʊst/ n. 海岸；海滨
                        
                        **season** /ˈsiːzn/ n. 季；季节
                        
                        **knock** /nɒk/ v. 敲
                        
                        **eastern** /ˈiːstən/ adj. 东方的
                        
                        **worth** /wɜːθ/ adj. 值得的
                        
                        **manner** /ˈmænə(r)/ n. 礼貌；方式
                        
                        **empty** /ˈempti/ adj. 空的
                        
                        **basic** /ˈbeɪsɪk/ adj. 基本的
                        
                        **exchange** /ɪksˈtʃeɪndʒ/ v. & n. 交换
                        
                        **granddaughter** /ˈɡrændɔːtə(r)/ n. 孙女
                        
                        **behave** /bɪˈheɪv/ v. 表现
                        
                        **except** /ɪkˈsept/ prep. 除……之外
                        
                        **elbow** /ˈelbəʊ/ n. 肘部
                        
                        **gradually** /ˈɡrædʒuəli/ adv. 逐渐地
                        
                        **suggestion** /səˈdʒestʃən/ n. 建议；提议
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：be supposed to do
                        - 表示“应该做某事”。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u11", "Unit 11", "Sad movies make me cry.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **drive** /draɪv/ v. 迫使；驾驶
                        
                        **friendship** /ˈfrendʃɪp/ n. 友谊；友情
                        
                        **king** /kɪŋ/ n. 君主；国王
                        
                        **prime** /praɪm/ adj. 首要的；基本的
                        
                        **minister** /ˈmɪnɪstə(r)/ n. 大臣；部长
                        
                        **banker** /ˈbæŋkə(r)/ n. 银行家
                        
                        **pale** /peɪl/ adj. 苍白的
                        
                        **queen** /kwiːn/ n. 王后；女王
                        
                        **examine** /ɪɡˈzæmɪn/ v. 检查
                        
                        **nor** /nɔː(r)/ conj. 也不
                        
                        **palace** /ˈpæləs/ n. 王宫；宫殿
                        
                        **power** /ˈpaʊə(r)/ n. 权力
                        
                        **wealth** /welθ/ n. 财富
                        
                        **grey** /ɡreɪ/ adj. 灰色的
                        
                        **lemon** /ˈlemən/ n. 柠檬
                        
                        **cancel** /ˈkænsl/ v. 取消；终止
                        
                        **weight** /weɪt/ n. 重量；分量
                        
                        **shoulder** /ˈʃəʊldə(r)/ n. 肩膀
                        
                        **goal** /ɡəʊl/ n. 球门；目标
                        
                        **coach** /kəʊtʃ/ n. 教练
                        
                        **kick** /kɪk/ v. 踢
                        
                        **courage** /ˈkʌrɪdʒ/ n. 勇气；胆量
                        
                        **rather** /ˈrɑːðə(r)/ adv. 相当；宁愿
                        
                        **pull** /pʊl/ v. 拉；拽
                        
                        **relief** /rɪˈliːf/ n. 解脱；轻松
                        
                        **nod** /nɒd/ v. 点头
                        
                        **agreement** /əˈɡriːmənt/ n. 协议；协定
                        
                        **fault** /fɔːlt/ n. 过错；缺点
                        
                        **disappoint** /ˌdɪsəˈpɒɪnt/ v. 使失望
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：make 的用法
                        - make sb. do sth. (使某人做某事)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u12", "Unit 12", "Life is full of the unexpected.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **backpack** /ˈbækpæk/ n. 背包
                        
                        **oversleep** /ˌəʊvəˈsliːp/ v. 睡过头
                        
                        **ring** /rɪŋ/ v. 响 n. 戒指
                        
                        **block** /blɒk/ n. 街区
                        
                        **in line** 排队
                        
                        **worker** /ˈwɜːkə(r)/ n. 工作者；工人
                        
                        **stare** /steə(r)/ v. 凝视
                        
                        **disbelief** /ˌdɪsbɪˈliːf/ n. 不信；怀疑
                        
                        **above** /əˈbʌv/ prep. 在……上面
                        
                        **burn** /bɜːn/ v. 燃烧
                        
                        **alive** /əˈlaɪv/ adj. 活着的
                        
                        **airport** /ˈeəpɔːt/ n. 机场
                        
                        **till** /tɪl/ conj. & prep. 直到
                        
                        **west** /west/ adv. & n. 西方
                        
                        **cream** /kriːm/ n. 奶油
                        
                        **workday** /ˈwɜːkdeɪ/ n. 工作日
                        
                        **pie** /paɪ/ n. 馅饼
                        
                        **bean** /biːn/ n. 豆
                        
                        **market** /ˈmɑːkɪt/ n. 市场
                        
                        **believe** /bɪˈliːv/ v. 相信
                        
                        **believable** /bɪˈliːvəbl/ adj. 可信的
                        
                        **disappear** /ˌdɪsəˈpɪə(r)/ v. 消失
                        
                        **discovery** /dɪˈskʌvəri/ n. 发现
                        
                        **lady** /ˈleɪdi/ n. 女士
                        
                        **officer** /ˈɒfɪsə(r)/ n. 军官；官员
                        
                        **unexpected** /ˌʌnɪkˈspektɪd/ adj. 出乎意料的
                        
                        **embarrassed** /ɪmˈbærəst/ adj. 尴尬的
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：过去完成时
                        - 表示“过去的过去”。构成：had + 过去分词。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u13", "Unit 13", "We're trying to save the earth!",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **litter** /ˈlɪtə(r)/ n. 垃圾 v. 乱扔
                        
                        **bottom** /ˈbɒtəm/ n. 底部
                        
                        **fisherman** /ˈfɪʃəmən/ n. 渔民
                        
                        **coal** /kəʊl/ n. 煤
                        
                        **public** /ˈpʌblɪk/ adj. 公共的
                        
                        **ugly** /ˈʌɡli/ adj. 丑陋的
                        
                        **advantage** /ədˈvɑːntɪdʒ/ n. 优点
                        
                        **cost** /kɒst/ v. 花费 n. 成本
                        
                        **wooden** /ˈwʊdn/ adj. 木制的
                        
                        **plastic** /ˈplæstɪk/ n. & adj. 塑料
                        
                        **take action** 采取行动
                        
                        **gate** /ɡeɪt/ n. 大门
                        
                        **bottle** /ˈbɒtl/ n. 瓶子
                        
                        **president** /ˈprezɪdənt/ n. 总统；负责人
                        
                        **inspiration** /ˌɪnspəˈreɪʃn/ n. 灵感
                        
                        **metal** /ˈmetl/ n. 金属
                        
                        **recycle** /ˌriːˈsaɪkl/ v. 回收
                        
                        **napkin** /ˈnæpkɪn/ n. 餐巾纸
                        
                        **throw away** 扔掉
                        
                        **put to good use** 好好利用
                        
                        **pull down** 拆下
                        
                        **upside down** 颠倒
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u14", "Unit 14", "I remember meeting all of you in Grade 7.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **survey** /ˈsɜːveɪ/ n. 调查
                        
                        **standard** /ˈstændəd/ n. 标准
                        
                        **row** /rəʊ/ n. 一排
                        
                        **keyboard** /ˈkiːbɔːd/ n. 键盘
                        
                        **method** /ˈmeθəd/ n. 方法
                        
                        **instruction** /ɪnˈstrʌkʃn/ n. 指示
                        
                        **double** /ˈdʌbl/ v. 加倍
                        
                        **shall** /ʃæl/ modal v. 将要
                        
                        **look back at** 回顾
                        
                        **overcome** /ˌəʊvəˈkʌm/ v. 克服
                        
                        **make a mess** 弄得一团糟
                        
                        **graduate** /ˈɡrædʒueɪt/ v. 毕业
                        
                        **keep one's cool** 沉住气
                        
                        **caring** /ˈkeərɪŋ/ adj. 体贴人的
                        
                        **ours** /aʊəz/ pron. 我们的
                        
                        **senior** /ˈsiːniə(r)/ adj. 级别高的
                        
                        **text** /tekst/ n. 课文
                        
                        **go by** 逝去
                        
                        **level** /ˈlevl/ n. 水平
                        
                        **degree** /dɪˈɡriː/ n. 学位；度数
                        
                        **manager** /ˈmænɪdʒə(r)/ n. 经理
                        
                        **believe in** 信任
                        
                        **gentleman** /ˈdʒentlmən/ n. 先生
                        
                        **ceremony** /ˈserəməni/ n. 典礼
                        
                        **congratulate** /kənˈɡrætʃuleɪt/ v. 祝贺
                        
                        **thirsty** /ˈθɜːsti/ adj. 渴望的；口渴的
                        
                        **thankful** /ˈθæŋkfl/ adj. 感激的
                        
                        **lastly** /ˈlɑːstli/ adv. 最后
                        
                        **task** /tɑːsk/ n. 任务
                        
                        **ahead** /əˈhed/ adv. 在前面
                        
                        **responsible** /rɪˈspɒnsəbl/ adj. 有责任心的
                        
                        **separate** /ˈsepəreɪt/ v. 分离
                        
                        **wing** /wɪŋ/ n. 翅膀
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：remember doing vs remember to do
                        - doing: 记得做过某事；to do: 记得要做某事。
                    """.trimIndent())
                )
            )
        )
    )
}
