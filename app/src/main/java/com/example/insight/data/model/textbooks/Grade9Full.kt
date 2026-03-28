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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **textbook** /'tekstbʊk/ n. 教科书；课本
                        **conversation** /ˌkɒnvə'seɪʃn/ n. 交谈；谈话
                        **aloud** /ə'laʊd/ adv. 大声地；出声地
                        **pronunciation** /prəˌnʌnsi'eɪʃn/ n. 发音；读音
                        **sentence** /'sentəns/ n. 句子
                        **patient** /'peɪʃnt/ adj. 有耐心的 n. 病人
                        **expression** /ɪk'spreʃn/ n. 表达（方式）；表示
                        **discover** /dɪ'skʌvə(r)/ v. 发现；发觉
                        **secret** /'siːkrət/ n. 秘密；秘诀 adj. 秘密的
                        **grammar** /'ɡræmə(r)/ n. 语法
                        **repeat** /rɪ'piːt/ v. 重复；重做
                        **note** /nəʊt/ n. 笔记；记录 v. 注意
                        **physics** /'fɪzɪks/ n. 物理；物理学
                        **chemistry** /'kemɪstri/ n. 化学
                        **memorize** /'meməraɪz/ v. 记忆；记住
                        **pattern** /'pætən/ n. 模式；方式
                        **pronounce** /prə'naʊns/ v. 发音
                        **increase** /ɪn'kriːs/ v. 增加；增长
                        **speed** /spiːd/ n. 速度
                        **partner** /'pɑːtnə(r)/ n. 搭档；同伴
                        **ability** /ə'bɪləti/ n. 能力；才能
                        **brain** /breɪn/ n. 大脑
                        **active** /'æktɪv/ adj. 活跃的；积极的
                        **attention** /ə'tenʃn/ n. 注意；关注
                        **pay attention to** 注意；关注
                        **connect** /kə'nekt/ v. （使）连接；与……有联系
                        **connect...with** 把……和……连接或联系起来
                        **overnight** /ˌəʊvə'naɪt/ adv. 一夜之间；在夜间
                        **review** /rɪ'vjuː/ v. & n. 回顾；复习
                        **knowledge** /'nɒlɪdʒ/ n. 知识；学问
                        **wisely** /'waɪzli/ adv. 明智地；聪明地
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **mooncake** /'muːnkeɪk/ n. 月饼
                        **lantern** /'læntən/ n. 灯笼
                        **stranger** /'streɪndʒə(r)/ n. 陌生人
                        **relative** /'relətɪv/ n. 亲属；亲戚
                        **put on** 增加（体重）；发胖
                        **pound** /paʊnd/ n. 磅；英镑
                        **folk** /fəʊk/ adj. 民间的；民俗的
                        **goddess** /'ɡɒdəs/ n. 女神
                        **whoever** /huː'evə(r)/ pron. 无论谁；不管什么人
...
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **restroom** /'restruːm/ n. 洗手间
                        **stamp** /stæmp/ n. 邮票
...
                        **address** /ə'dres/ n. 住址；地址
                        **underground** /ˌʌndə'ɡraʊnd/ adj. 地下的 n. 地铁
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **humorous** /'hjuːmərəs/ adj. 有幽默感的
                        **silent** /'saɪlənt/ adj. 沉默的
...
                        **general** /'dʒenrəl/ adj. 总的；普遍的
                        **introduction** /ˌɪntrə'dʌkʃn/ n. 介绍
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **chopstick** /'tʃɒpstɪk/ n. 筷子
                        **coin** /kɔɪn/ n. 硬币
...
                        **competition** /ˌkɒmpə'tɪʃn/ n. 比赛；竞争
                        **lively** /'laɪvli/ adj. 生气勃勃的
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **heel** /hiːl/ n. 鞋后跟
                        **scoop** /skuːp/ n. 勺子
...
                        **prevent** /prɪ'vent/ v. 阻止；阻挠
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **license** /'laɪsns/ n. 证；证件
...
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **whose** /huːz/ pron. 谁的
...
                        **period** /'pɪəriəd/ n. 一段时间；时期
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **prefer** /prɪ'fɜː(r)/ v. 更喜欢
...
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **custom** /'kʌstəm/ n. 风俗；习俗
...
                        **suggestion** /sə'dʒestʃən/ n. 建议；提议
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **rather** /'rɑːðə(r)/ adv. 相当
...
                        **disappoint** /ˌdɪsə'pɔɪnt/ v. 使失望
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **unexpected** /ˌʌnɪk'spektɪd/ adj. 出乎意料的
...
                        **costume** /'kɒstjuːm/ n. 服装；装束
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
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **litter** /'lɪtə(r)/ v. 乱扔 n. 垃圾
...
                        **creativity** /ˌkriːeɪ'tɪvəti/ n. 创造力
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g9_u14", "Unit 14", "I remember meeting all of you in Grade 7.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **survey** /'sɜːveɪ/ n. 调查
...
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
