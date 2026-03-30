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
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 学习策略与个人成长。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **textbook** /ˈtekstbʊk/ n. 教科书；课本
                        
                        **conversation** /ˌkɒnvəˈseɪʃn/ n. 交谈；谈话
                        
                        **aloud** /əˈlaʊd/ adv. 大声地；出声地
                        
                        **pronunciation** /prəˌnʌnsiˈeɪʃn/ n. 发音；读音
                        
                        **sentence** /ˈsentəns/ n. 句子
                        
                        **patient** /ˈpeɪʃnt/ adj. 有耐心的 n. 病人
                        
                        **expression** /ɪkˈspreʃn/ n. 表达（方式）；表示
                        
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
                        
                        **pay attention to** 注意；关注
                        
                        **connect** /kəˈnekt/ v. （使）连接；与……有联系
                        
                        **connect...with** 把……和……连接或联系起来
                        
                        **overnight** /ˌəʊvəˈnaɪt/ adv. 一夜之间；在夜间
                        
                        **review** /rɪˈvjuː/ v. & n. 回顾；复习
                        
                        **knowledge** /ˈnɒlɪdʒ/ n. 知识；学问
                        
                        **wisely** /ˈwaɪzli/ adv. 明智地；聪明地
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
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
                        
                        **put on** 增加（体重）；发胖
                        
                        **pound** /paʊnd/ n. 磅；英镑
                        
                        **folk** /fəʊk/ adj. 民间的；民俗的
                        
                        **goddess** /ˈɡɒdəs/ n. 女神
                        
                        **whoever** /huːˈevə(r)/ pron. 无论谁；不管什么人
                        
                        **steal** /stiːl/ v. 偷；窃取
                        
                        **lay** /leɪ/ v. 放置；下蛋
                        
                        **lay out** 摆开；布置
                        
                        **admire** /ədˈmaɪə(r)/ v. 欣赏；仰慕
                        
                        **tie** /taɪ/ n. 领带 v. 捆；系
                        
                        **haunted** /ˈhɔːntɪd/ adj. 有鬼魂出没的
                        
                        **ghost** /ɡəʊst/ n. 鬼；幽灵
                        
                        **novel** /ˈnɒvl/ n. 小说
                        
                        **eve** /iːv/ n. （节日或事件的）前夕
                        
                        **dead** /ded/ adj. 死的；无生命的
                        
                        **business** /ˈbɪznəs/ n. 生意；商业
                        
                        **punish** /ˈpʌnɪʃ/ v. 惩罚；惩治
                        
                        **warn** /ˈwɔːn/ v. 警告；告诫
                        
                        **present** /ˈpreznt/ n. 礼物 v. 呈现；赠送
                        
                        **warmth** /wɔːmθ/ n. 温暖；暖和
                        
                        **spread** /spred/ v. 传播；展开
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：宾语从句 (I)
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
                        
                        **nearby** /ˈsentrəl/ adj. 附近的；adv. 在附近
                        
                        **mail** /meɪl/ v. 邮寄 n. 邮件
                        
                        **east** /iːst/ adj. 东方的 n. 东方
                        
                        **fascinating** /ˈfæsɪneɪtɪŋ/ adj. 迷人的；有极大吸引力的
                        
                        **convenient** /kənˈviːniənt/ adj. 便利的；方便的
                        
                        **mall** /mɔːl/ n. 购物商场
                        
                        **clerk** /klɜːk/ n. 职员
                        
                        **corner** /ˈkɔːnə(r)/ n. 拐角；角落
                        
                        **polite** /pəˈlaɪt/ adj. 有礼貌的
                        
                        **politely** /pəˈlaɪtli/ adv. 有礼貌地
                        
                        **speaker** /ˈspiːkə(r)/ n. 发言者；扬声器
                        
                        **request** /rɪˈkwest/ n. & v. 要求；请求
                        
                        **choice** /tʃɔɪs/ n. 选择
                        
                        **direction** /daɪˈrekʃn/ n. 方向；方位
                        
                        **correct** /kəˈrekt/ adj. 正确的；恰当的
                        
                        **direct** /dəˈrekt/ adj. 直接的；直率的
                        
                        **whom** /huːm/ pron. 谁；什么人（who的宾格）
                        
                        **address** /əˈdres/ n. 住址；地址
                        
                        **underground** /ˌʌndəˈɡraʊnd/ adj. 地下的 n. 地铁
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：宾语从句 (II) - 陈述语序
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
                        
                        **helpful** /ˈsaɪlənt/ adj. 有帮助的
                        
                        **score** /skɔː(r)/ n. & v. 得分；分数
                        
                        **background** /ˈbakɡraʊnd/ n. 背景
                        
                        **interview** /ˈɪntəvjuː/ v. & n. 采访；面试
                        
                        **guard** /ɡɑːd/ n. 警卫；看守 v. 守卫
                        
                        **hang** /haŋ/ v. 悬挂；吊
                        
                        **village** /ˈvɪlɪdʒ/ n. 村庄；村镇
                        
                        **European** /ˌjʊərəˈpiːən/ adj. 欧洲的 n. 欧洲人
                        
                        **African** /ˈafrikən/ adj. 非洲的 n. 亚非人
                        
                        **British** /ˈbrɪtɪʃ/ adj. 英国的；英国人的
                        
                        **speech** /spiːtʃ/ n. 演讲
                        
                        **public** /ˈspʌblɪk/ n. 民众 adj. 公开的
                        
                        **in public** 公开地；在公共场所
                        
                        **ant** /ant/ n. 蚂蚁
                        
                        **seldom** /ˈsiːldəm/ adv. 不常；很少
                        
                        **influence** /ˈɪnfluəns/ v. & n. 影响
                        
                        **absent** /ˈabsənt/ adj. 缺席的
                        
                        **fail** /feɪl/ v. 失败；未能
                        
                        **examination** /ɪɡˌzamɪˈneɪʃn/ n. 考试；审查
                        
                        **boarding** /ɪɡˌzamɪˈneɪʃn/ n. 寄宿
                        
                        **in person** 亲身；亲自
                        
                        **exactly** /ɪɡˈzaktli/ adv. 确切地；精确地
                        
                        **pride** /praɪd/ n. 自豪；骄傲
                        
                        **take pride in** 为……感到自豪
                        
                        **proud** /praɪd/ adj. 自豪的；骄傲的
                        
                        **be proud of** 为……骄傲
                        
                        **general** /ˈdʒenrəl/ adj. 总的；普遍的
                        
                        **introduction** /ˌɪntrəˈdʌkʃn/ n. 介绍
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
                        **chopstick** /ˈtʃɒpstɪk/ n. 筷子
                        
                        **coin** /kɔɪn/ n. 硬币
                        
                        **fork** /fɔːk/ n. 餐叉；叉
                        
                        **blouse** /blaʊz/ n. （女式）短上衣；衬衫
                        
                        **silver** /ˈsɪlvə(r)/ n. 银；银器 adj. 银色的
                        
                        **glass** /ɡlɑːs/ n. 玻璃
                        
                        **cotton** /ˈkɒtn/ n. 棉；棉花
                        
                        **steel** /ˈstiːl/ n. 钢；钢铁
                        
                        **fair** /feə(r)/ n. 展览会；游乐场
                        
                        **environmental** /ɪnˌvaɪrənˈmentl/ adj. 环境的
                        
                        **grass** /ɡrɑːs/ n. 草；草地
                        
                        **leaf** /ɡrɑːs/ n. 叶；叶子
                        
                        **produce** /prəˈdjuːs/ v. 生产；制造
                        
                        **widely** /ˈwaɪdli/ adv. 广泛地
                        
                        **process** /ˈprəʊses/ v. 加工；处理
                        
                        **pack** /pak/ v. 包装；装箱
                        
                        **product** /ˈprɒdʌkt/ n. 产品
                        
                        **France** /frɑːns/ n. 法国
                        
                        **no matter** 不论；无论
                        
                        **local** /ˈləʊkl/ adj. 当地的；本地的
                        
                        **brand** /ləʊkl/ n. 品牌
                        
                        **avoid** /əˈvɔɪd/ v. 避免；回避
                        
                        **handbag** /ˈhandbaɡ/ n. 手提包
                        
                        **mobile** /ˈməʊbaɪl/ adj. 可移动的
                        
                        **everyday** /ˈevrideɪ/ adj. 每天的；日常的
                        
                        **boss** /bɒs/ n. 老板
                        
                        **Germany** /ˈdʒɜːməni/ n. 德国
                        
                        **surface** /ˈsɜːfɪs/ n. 表面
                        
                        **material** /məˈtɪəriəl/ n. 材料；原料
                        
                        **traffic** /ˈtrafɪk/ n. 交通；运输
                        
                        **postman** /ˈpəʊstmən/ n. 邮递员
                        
                        **cap** /kap/ n. （尤指有檐的）帽子
                        
                        **glove** /kap/ n. 手套
                        
                        **international** /ˌɪntəˈnaʃnəl/ adj. 国际的
                        
                        **competitor** /kəmˈpetɪtə(r)/ n. 参赛者
                        
                        **paint** /peɪnt/ v. 刷漆；画画
                        
                        **it's said that** 据说
                        
                        **clay** /kleɪ/ n. 黏土；陶土
                        
                        **celebration** /ˌselɪˈbreɪʃn/ n. 庆祝；庆典
                        
                        **balloon** /bəˈluːn/ n. 气球
                        
                        **paper cutting** 剪纸
                        
                        **scissors** /ˈsɪzəz/ n. （常pl.）剪刀
                        
                        **lively** /ˈlaɪvli/ adj. 生气勃勃的
                        
                        **fairy** /ˈfeəri/ n. 仙女；小精灵
                        
                        **heat** /hiːt/ n. 热；热度
                        
                        **polish** /hiːt/ v. 擦亮；磨光
                        
                        **complete** /kəmˈpliːt/ v. 完成
                        
                        **competition** /ˌkɒmpəˈtɪʃn/ n. 比赛；竞争
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
                        
                        **project** /ˈpraʊdʒekt/ n. 项目；工程
                        
                        **pleasure** /ˈpreʒə(r)/ n. 愉快；快乐
                        
                        **zipper** /ˈzɪpə(r)/ n. 拉链
                        
                        **daily** /ˈdeɪli/ adj. 每日的
                        
                        **website** /ˈdeɪli/ n. 网站
                        
                        **pioneer** /ˌpaɪəˈnɪə(r)/ n. 先驱
                        
                        **list** /lɪst/ v. 列表 n. 列表
                        
                        **mention** /ˈmenʃn/ v. 提到；说到
                        
                        **by accident** 偶然；意外地
                        
                        **nearly** /ˈnaɪəli/ adv. 几乎
                        
                        **boil** /bɔɪl/ v. 沸腾；煮沸
                        
                        **remain** /bɔɪl/ v. 保持不变；剩余
                        
                        **smell** /smel/ n. 气味 v. 闻到
                        
                        **saint** /seɪnt/ n. 圣徒
                        
                        **national** /ˈnaʃnəl/ adj. 国家的
                        
                        **trade** /treɪd/ n. 贸易；交易
                        
                        **popularity** /ˈpɒpjuˈlarəti/ n. 普及；流行
                        
                        **doubt** /daʊt/ n. 怀疑 v. 怀疑
                        
                        **without doubt** 毫无疑问
                        
                        **fridge** /frɪdʒ/ n. 冰箱
                        
                        **low** /ləʊ/ adj. 低的
                        
                        **somebody** /ˈsʌmbədi/ pron. 某人
                        
                        **translate** /transˈleɪt/ v. 翻译
                        
                        **lock** /lɒk/ v. 锁上
                        
                        **ring** /rɪŋ/ v. 发出钟声；按铃
                        
                        **earthquake** /ˈɜːθkweɪk/ n. 地震
                        
                        **sudden** /ˈsʌdn/ adj. 突然的
                        
                        **all of a sudden** 突然
                        
                        **bell** /bel/ n. 钟（声）；铃（声）
                        
                        **biscuit** /ˈbɪskɪt/ n. 饼干
                        
                        **cookie** /ˈbɪskɪt/ n. 曲奇饼
                        
                        **musical** /ˈmjuːzɪkl/ adj. 音乐的
                        
                        **instrument** /ˈɪnstrəmənt/ n. 仪器；乐器
                        
                        **crispy** /ˈkrɪspi/ adj. 脆的
                        
                        **salty** /ˈkrɪspi/ adj. 咸的
                        
                        **sour** /ˈsaʊə(r)/ adj. 酸的
                        
                        **customer** /ˈkʌstəmə(r)/ n. 顾客
                        
                        **Canadian** /kəˈneɪdiən/ adj. 加拿大的
                        
                        **divide** /dɪˈvaɪd/ v. 分开；划分
                        
                        **divide...into** 把……分开
                        
                        **purpose** /ˈpɜːpəs/ n. 目的；目标
                        
                        **basket** /ˈbɑːskɪt/ n. 篮；筐
                        
                        **hero** /ˈhɪərəʊ/ n. 英雄
                        
                        **professional** /prəˈfeʃənl/ adj. 专业的
                        
                        **prevent** /prɪˈvent/ v. 阻止；阻挠
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
                        
                        **flash** /flaʃ/ n. 闪光
                        
                        **tiny** /ˈtaɪni/ adj. 极小的
                        
                        **cry** /kraɪ/ v. & n. 哭
                        
                        **field** /fiːld/ n. 田野；场地
                        
                        **hug** /hʌɡ/ v. & n. 拥抱
                        
                        **lift** /lɪft/ v. 举起
                        
                        **badly** /ˈbadli/ adv. 严重地；差
                        
                        **talk back** 回嘴；顶嘴
                        
                        **awful** /ˈɔːfl/ adj. 可怕的
                        
                        **teen** /tiːn/ n. 青少年
                        
                        **regret** /rɪˈɡret/ v. & n. 后悔；遗憾
                        
                        **poem** /rɪˈɡret/ n. 诗；韵文
                        
                        **bedroom** /ˈbedruːm/ n. 卧室
                        
                        **community** /kəˈmjuːnəti/ n. 社区
                        
                        **keep...away from** 避免接近
                        
                        **make one's own decision** 自己做决定
                        
                        **educate** /ˈedʒukeɪt/ v. 教育
                        
                        **manage** /ˈmanɪdʒ/ v. 管理；控制
                        
                        **society** /səˈsaɪəti/ n. 社会
                        
                        **get in the way of** 挡路；妨碍
                        
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
                        
                        **rabbit** /ˈrabɪt/ n. 兔；野兔
                        
                        **attend** /əˈtend/ v. 出席；参加
                        
                        **valuable** /ˈvaljuəbl/ adj. 贵重的
                        
                        **pink** /pɪŋk/ adj. & n. 粉红色
                        
                        **anybody** /ˈenibɒdi/ pron. 任何人
                        
                        **picnic** /ˈpɪknɪk/ n. 野餐
                        
                        **somebody** /ˈsʌmbədi/ pron. 某人
                        
                        **anywhere** /ˈeniweə(r)/ adv. 在任何地方
                        
                        **noise** /nɔɪz/ n. 声音；噪音
                        
                        **policeman** /ˈpəʊlɪsmən/ n. 男警察
                        
                        **wolf** /wʊlf/ n. 狼
                        
                        **uneasy** /ʌnˈiːzi/ adj. 心神不安的
                        
                        **laboratory** /ləˈbɒrətri/ n. 实验室
                        
                        **outdoors** /ˌaʊtˈdɔːz/ adv. 在户外
                        
                        **coat** /kəʊt/ n. 外套
                        
                        **sleepy** /ˈsliːpi/ adj. 困倦的
                        
                        **land** /land/ v. 着陆
                        
                        **alien** /ˈeɪliən/ n. 外星人
                        
                        **run after** 追逐；追赶
                        
                        **suit** /suːt/ n. 西服 v. 适合
                        
                        **express** /ɪkˈspres/ v. 表达
                        
                        **at the same time** 同时
                        
                        **circle** /ˈsɜːkl/ n. 圆圈 v. 圈出
                        
                        **Britain** /ˈbrɪtn/ n. 英国
                        
                        **receive** /rɪˈsiːv/ v. 接到；收到
                        
                        **leader** /ˈliːdə(r)/ n. 领导；领袖
                        
                        **midsummer** /ˌmɪdˈsʌmə(r)/ n. 仲夏
                        
                        **medical** /ˈmedɪkl/ adj. 医疗的；医学的
                        
                        **prevent** /prɪˈvent/ v. 阻止；预防
                        
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
                        
                        **in that case** 在这种情况下
                        
                        **director** /dəˈrektə(r)/ n. 导演；部门负责人
                        
                        **case** /keɪs/ n. 情况；实例
                        
                        **war** /wɔː(r)/ n. 战争
                        
                        **stick** /stɪk/ v. 坚持；粘贴
                        
                        **stick to** 坚持；固守
                        
                        **down** /daʊn/ adj. 悲哀的；沮丧的
                        
                        **dialogue** /ˈdaɪəlɒɡ/ n. 对话；谈话
                        
                        **ending** /ˈdaɪəlɒɡ/ n. 结尾；结局
                        
                        **documentary** /ˌdɒkjuˈmentri/ n. 纪录片
                        
                        **drama** /ˈdrɑːmə/ n. 戏；剧
                        
                        **plenty** /ˈplenti/ pron. 大量；众多
                        
                        **plenty of** 大量；充足
                        
                        **shut** /ʃʌt/ v. 关闭
                        
                        **shut off** 关闭；停止
                        
                        **superhero** /ˈsuːpəhɪərəʊ/ n. 超级英雄
                        
                        **once in a while** 偶尔
                        
                        **intelligent** /ɪnˈtelɪdʒənt/ adj. 有才智的；聪明的
                        
                        **sense** /sens/ v. 感觉到 n. 感觉
                        
                        **sadness** /ˈsens/ n. 悲哀；忧伤
                        
                        **pain** /peɪn/ n. 痛苦；苦恼
                        
                        **reflect** /rɪˈflekt/ v. 反映；映射
                        
                        **moving** /rɪˈflekt/ adj. 动人的；令人感动的
                        
                        **pity** /pɪti/ n. 遗憾；怜悯
                        
                        **total** /ˈtəʊtl/ adj. 总的 n. 总数
                        
                        **in total** 总共；合计
                        
                        **master** /ˈmɑːstə(r)/ n. 大师 v. 掌握
                        
                        **praise** /preɪz/ v. & n. 表扬；赞扬
                        
                        **recall** /rɪˈkɔːl/ v. 回忆起；回想起
                        
                        **wound** /wuːnd/ n. 伤；伤口 v. 使受伤
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
                        
                        **relaxed** /rɪˈlakst/ adj. 放松的
                        
                        **drop by** 顺便拜访
                        
                        **inventory** /rɪˈlakst/ n. 详细目录
                        
                        **effort** /ˈefət/ n. 努力
                        
                        **make an effort** 作出努力
                        
                        **passport** /ˈpɑːspɔːt/ n. 护照
                        
                        **clean...off** 把……擦干净
                        
                        **chalk** /tʃɔːk/ n. 粉笔
                        
                        **blackboard** /ˈtʃɔːk/ n. 黑板
                        
                        **northern** /ˈnɔːðən/ adj. 北方的
                        
                        **coast** /kəʊst/ n. 海岸；海滨
                        
                        **season** /ˈsiːzn/ n. 季；季节
                        
                        **knock** /nɒk/ v. 敲
                        
                        **eastern** /ˈiːstən/ adj. 东方的
                        
                        **worth** /wɜːθ/ adj. 值得的
                        
                        **manner** /ˈmanə(r)/ n. 方式；礼貌
                        
                        **empty** /ˈempti/ adj. 空的
                        
                        **stick** /stɪk/ v. 刺；戳
                        
                        **chopstick** /ˈtʃɒpstɪk/ n. 筷子
                        
                        **lap** /lap/ n. 大腿
                        
                        **elbow** /lap/ n. 肘；肘部
                        
                        **gradually** /ˈɡradʒuəli/ adv. 逐渐地
                        
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
                        **rather** /ˈrɑːðə(r)/ adv. 相当
                        
                        **would rather** 宁愿
                        
                        **drive** /draɪv/ v. 迫使；驱使
                        
                        **drive sb. crazy** 使人发疯
                        
                        **friendship** /ˈfrendʃɪp/ n. 友谊；友情
                        
                        **king** /kɪŋ/ n. 君主；国王
                        
                        **power** /ˈpaʊə(r)/ n. 权力；力量
                        
                        **prime** /praɪm/ adj. 首要的；基本的
                        
                        **minister** /ˈmɪnɪstə(r)/ n. 大臣；部长
                        
                        **prime minister** 首相；总理
                        
                        **banker** /ˈbaŋkə(r)/ n. 银行家
                        
                        **fame** /feɪm/ n. 名声；名望
                        
                        **pale** /peɪl/ adj. 苍白的
                        
                        **queen** /kwiːn/ n. 王后；女王
                        
                        **examine** /ɪɡˈzamɪn/ v. 检查
                        
                        **neither...nor** 既不……也不
                        
                        **palace** /ˈpaləs/ n. 王宫；宫殿
                        
                        **wealth** /welθ/ n. 财富
                        
                        **grey** /ɡreɪ/ adj. 灰色的
                        
                        **lemon** /ˈlemən/ n. 柠檬
                        
                        **cancel** /ˈkansl/ v. 取消；终止
                        
                        **weight** /weɪt/ n. 重量；分量
                        
                        **shoulder** /ˈʃəʊldə(r)/ n. 肩膀
                        
                        **goal** /ɡəʊl/ n. 球门；目标
                        
                        **coach** /kəʊtʃ/ n. 教练
                        
                        **kick** /kɪk/ v. 踢
                        
                        **be hard on sb.** 对某人苛刻
                        
                        **besides** /ˈbiːsaɪdz/ adv. 而且
                        
                        **teammate** /ˈtiːmmeɪt/ n. 同队队员
                        
                        **courage** /ˈkʌrɪdʒ/ n. 勇气；胆量
                        
                        **rather than** 而不是
                        
                        **guy** /ɡaɪ/ n. 家伙
                        
                        **pull** /pʊl/ v. 拉；拽
                        
                        **pull together** 齐心协力
                        
                        **relief** /rɪˈliːf/ n. 轻松；解脱
                        
                        **nod** /nɒd/ v. 点头
                        
                        **agreement** /nɒd/ n. 同意；协定
                        
                        **fault** /fɔːlt/ n. 过失；错误
                        
                        **disappoint** /ˌdɪsəˈpɔɪnt/ v. 使失望
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
                        **unexpected** /ˌʌnɪkˈspektɪd/ adj. 出乎意料的
                        
                        **by the time** 在……以前
                        
                        **backpack** /ˈbakpak/ n. 背包
                        
                        **oversleep** /ˌəʊvəˈsliːp/ v. 睡过头
                        
                        **ring** /rɪŋ/ v. 发出钟声；响
                        
                        **give...a lift** 捎（某人）一程
                        
                        **block** /blɒk/ n. 街区
                        
                        **in line with** 与……成一排
                        
                        **worker** /ˈwɜːkə(r)/ n. 工作者；工人
                        
                        **stare** /steə(r)/ v. 盯着看
                        
                        **disbelief** /ˌdɪsbɪˈliːf/ n. 不信；怀疑
                        
                        **above** /əˈbʌv/ prep. 在……上面
                        
                        **burn** /bɜːn/ v. 燃烧
                        
                        **alive** /əˈlaɪv/ adj. 活着的
                        
                        **airport** /ˈeəpɔːt/ n. 机场
                        
                        **till** /tɪl/ conj. & prep. 直到
                        
                        **west** /west/ adv. 向西 n. 西方
                        
                        **cream** /kriːm/ n. 奶油
                        
                        **workday** /ˈwɜːkdeɪ/ n. 工作日
                        
                        **pie** /paɪ/ n. 派
                        
                        **bean** /biːn/ n. 豆
                        
                        **market** /ˈmɑːkɪt/ n. 市场
                        
                        **by the end of** 在……结束时
                        
                        **fool** /fuːl/ n. 傻瓜 v. 愚弄
                        
                        **costume** /ˈkɒstjuːm/ n. 服装；装束
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
                        **litter** /ˈlɪtə(r)/ v. 乱扔 n. 垃圾
                        
                        **bottom** /ˈbɒtəm/ n. 底部
                        
                        **fisherman** /ˈfɪʃəmən/ n. 渔民
                        
                        **coal** /kəʊl/ n. 煤
                        
                        **ugly** /ˈʌɡli/ adj. 丑陋的
                        
                        **advantage** /ədˈvɑːntɪdʒ/ n. 优点；有利条件
                        
                        **cost** /kɒst/ v. & n. 花费；代价
                        
                        **wooden** /ˈwʊdn/ adj. 木制的
                        
                        **plastic** /ˈplastɪk/ n. 塑料
                        
                        **takeaway** /ˈplastɪk/ n. 外卖
                        
                        **bin** /bɪn/ n. 垃圾箱
                        
                        **shark** /ʃɑːk/ n. 鲨鱼
                        
                        **fin** /fɪn/ n. 鱼鳍
                        
                        **cut off** 切除
                        
                        **method** /ˈmeθəd/ n. 方法；措施
                        
                        **cruel** /ˈkruːəl/ adj. 残酷的
                        
                        **harmful** /ˈkruːəl/ adj. 有害的
                        
                        **at the top of** 在……顶部
                        
                        **chain** /tʃeɪn/ n. 链子；产业链
                        
                        **ecosystem** /ˈiːkəʊˌsɪstəm/ n. 生态系统
                        
                        **low** /ləʊ/ adj. 低的
                        
                        **industry** /ˈɪndəstri/ n. 工业；行业
                        
                        **law** /lɔː/ n. 法律
                        
                        **scientific** /ˌsaɪənˈtɪfɪk/ adj. 科学的
                        
                        **afford** /əˈfɔːd/ v. 买得起；承担得起
                        
                        **reusable** /ˌriːˈjuːzəbl/ adj. 可重复使用的
                        
                        **transportation** /ˌtranspɔːˈteɪʃn/ n. 运输
                        
                        **recycle** /ˌriːˈsaɪkl/ v. 回收利用
                        
                        **napkin** /ˈnapkɪn/ n. 餐巾纸
                        
                        **upside down** 颠倒
                        
                        **gate** /ɡeɪt/ n. 大门
                        
                        **bottle** /ˈbɒtl/ n. 瓶子
                        
                        **president** /ˈprezɪdənt/ n. 总统；主席
                        
                        **inspiration** /ˌɪnspəˈreɪʃn/ n. 灵感
                        
                        **metal** /ˈmetl/ n. 金属
                        
                        **creativity** /ˌkriːeɪˈtɪvəti/ n. 创造力
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u14", "Unit 14", "I remember meeting all of you in Grade 7.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **survey** /ˈsɜːveɪ/ n. 调查
                        
                        **standard** /ˈstandəd/ n. 标准
                        
                        **row** /rəʊ/ n. 一排；一列；一行
                        
                        **in a row** 连续几次
                        
                        **keyboard** /ˈkiːbɔːd/ n. 键盘
                        
                        **method** /ˈmeθəd/ n. 方法
                        
                        **instruction** /ɪnˈstrʌkʃn/ n. 指导；说明
                        
                        **double** /ˈstʌndəd/ v. 加倍 adj. 两倍的
                        
                        **shall** /ʃal/ modal v. 将要；应该
                        
                        **overcome** /ˌəʊvəˈkʌm/ v. 克服；战胜
                        
                        **make a mess** 弄得一团糟
                        
                        **graduate** /ˈɡradʒuət/ v. 毕业
                        
                        **keep one's cool** 保持沉着
                        
                        **caring** /ˈkeərɪŋ/ adj. 体贴人的
                        
                        **ours** /aʊəz/ pron. 我们的
                        
                        **senior** /ˈsiːniə(r)/ adj. 级别高的
                        
                        **senior high school** 高中
                        
                        **text** /tekst/ n. 文本；课文
                        
                        **go by** （时间）逝去
                        
                        **level** /ˈlevl/ n. 标准；水平
                        
                        **degree** /ˈlevl/ n. 度数；学位
                        
                        **manager** /ˈmanɪdʒə(r)/ n. 经理
                        
                        **believe in** 信任；信赖
                        
                        **gentleman** /ˈdʒentlmən/ n. 绅士
                        
                        **graduation** /ˌɡradʒuˈeɪʃn/ n. 毕业
                        
                        **ceremony** /ˌɡradʒuˈeɪʃn/ n. 典礼；仪式
                        
                        **first of all** 首先
                        
                        **congratulate** /kənˈɡratʃuˌleɪt/ v. 祝贺
                        
                        **thirsty** /ˈθɜːsti/ adj. 渴的；口渴的
                        
                        **none** /nʌn/ pron. 没有一个
                        
                        **task** /tɑːsk/ n. 任务；工作
                        
                        **ahead** /əˈhed/ adv. 向前；在前面
                        
                        **ahead of** 在……前面
                        
                        **along with** 连同；除……以外还
                        
                        **responsible** /rɪˈspɒnsəbl/ adj. 有责任心的
                        
                        **be responsible for** 对……有责任
                        
                        **separate** /ˈsepəreɪt/ v. 分离 adj. 单独的
                        
                        **set sail** 起航
                        
                        **wing** /wɪŋ/ n. 翅膀；翼
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
