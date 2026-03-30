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
                "g7down_u1", "Unit 1", "Animal Friends",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 保护动物与自然。
                        *   **核心内容**：学习常见动物名称及其生存环境，培养保护野生动物的意识。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **duck** /ˈdʌk/ n. 鸭子
                        
                        **chicken** /ˈtʃɪkɪn/ n. 鸡
                        
                        **rabbit** /ˈræbit/ n. 兔子
                        
                        **cow** /kaʊ/ n. 母牛；奶牛
                        
                        **horse** /hɔːs/ n. 马
                        
                        **sheep** /ʃiːp/ n. 绵羊
                        
                        **goat** /ɡəʊt/ n. 山羊
                        
                        **pig** /piɡ/ n. 猪
                        
                        **farm** /fɑːm/ n. 农场
                        
                        **fox** /fɒks/ n. 狐狸
                        
                        **giraffe** /dʒɪˈrɑːf/ n. 长颈鹿
                        
                        **eagle** /ˈiːɡl/ n. 雕；鹰
                        
                        **wolf** /wʊlf/ n. 狼 (pl. wolves)
                        
                        **penguin** /ˈpeŋɡwɪn/ n. 企鹅
                        
                        **snake** /sneɪk/ n. 蛇
                        
                        **shark** /ʃɑːk/ n. 鲨鱼
                        
                        **whale** /weɪl/ n. 鲸
                        
                        **scary** /ˈskeəri/ adj. 吓人的
                        
                        **huge** /hjuːd/ adj. 巨大的
                        
                        **dangerous** /ˈdeɪndʒərəs/ adj. 危险的
                        
                        **save** /seɪv/ v. 救；保存
                        
                        **culture** /ˈkʌltʃə(r)/ n. 文化
                        
                        **danger** /ˈdeɪndʒə(r)/ n. 危险
                        
                        **in danger** 处于危险中
                        
                        **forest** /ˈfɒrɪst/ n. 森林
                        
                        **friendly** /ˈfrendli/ adj. 友好的
                        
                        **Antarctica** /ænˈtɑːktɪkə/ n. 南极洲
                        
                        **Africa** /ˈæfrɪkə/ n. 非洲
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. Why do you like pandas? — Because they are cute.
                        - **【考点】**：`Why` 引导的特殊疑问句与 `because` 的因果对应。
                        
                        #### 2. Animals are our friends. We must save them.
                        - **【考点】**：情态动词 `must` 表示义务。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u2", "Unit 2", "No Rules, No Order",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 学校与生活规则。
                        *   **核心内容**：学习制定和遵守规则，培养自律意识和社会责任感。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **rule** /ruːl/ n. 规则
                        
                        **order** /ˈɔːdə(r)/ n. 顺序；命令
                        
                        **follow** /ˈfɒləʊ/ v. 遵循；跟随
                        
                        **arrive** /əˈraɪv/ v. 到达
                        
                        **on time** 准时
                        
                        **uniform** /ˈjuːnɪfɔːm/ n. 制服
                        
                        **litter** /ˈlɪtə(r)/ v. 乱扔垃圾 n. 垃圾
                        
                        **polite** /pəˈlaɪt/ adj. 有礼貌的
                        
                        **noise** /nɔɪz/ n. 噪音
                        
                        **practise** /ˈpræktɪs/ v. 练习
                        
                        **awful** /ˈɔːfl/ adj. 糟糕的
                        
                        **become** /bɪˈkʌm/ v. 变成
                        
                        **focus** /ˈfəʊkəs/ v. 集中（注意力）
                        
                        **focus on** 专注于
                        
                        **relax** /rɪˈlæks/ v. 放松
                        
                        **must** /mʌst/ modal v. 必须
                        
                        **can** /kæn/ modal v. 能；可以
                        
                        **quiet** /ˈkwaɪət/ adj. 安静的
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. Don't eat in class.
                        - **【考点】**：祈使句的否定形式 `Don't + 动词原形`。
                        
                        #### 2. You must wear the school uniform.
                        - **【考点】**：`must` 表示强烈的必要性。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u3", "Unit 3", "Keep Fit",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 体育运动与锻炼。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **volleyball** /ˈvɒlibɔːl/ n. 排球
                        
                        **jog** /dʒɒɡ/ v. 慢跑
                        
                        **skateboarding** /ˈskeɪtbɔːdɪŋ/ n. 滑板运动
                        
                        **goal** /ɡəʊl/ n. 目标；进球
                        
                        **work out** 锻炼
                        
                        **progress** /ˈprəʊɡres/ n. 进步
                        
                        **match** /mætʃ/ n. 比赛
                        
                        **team** /tiːm/ n. 队伍
                        
                        **spirit** /ˈspɪrɪt/ n. 精神
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. How often do you exercise? — Once a week.
                        - **【考点】**：`How often` 询问频率。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u4", "Unit 4", "Eat Well",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 饮食习惯与健康。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **watermelon** /ˈwɔːtəmelən/ n. 西红柿
                        
                        **cabbage** /ˈkæbɪdʒ/ n. 卷心菜
                        
                        **mutton** /ˈmʌtn/ n. 羊肉
                        
                        **cookie** /ˈkʊki/ n. 曲奇饼
                        
                        **onion** /ˈʌnjən/ n. 洋葱
                        
                        **dumpling** /ˈdʌmplɪŋ/ n. 饺子
                        
                        **coffee** /ˈkɒfi/ n. 咖啡
                        
                        **bean** /biːn/ n. 豆
                        
                        **chip** /tʃɪp/ n. 炸薯条
                        
                        **porridge** /ˈpɒrɪdʒ/ n. 粥；麦片粥
                        
                        **salad** /ˈsæləd/ n. 沙拉
                        
                        **Mapo tofu** 麻婆豆腐
                        
                        **fast food** 快餐
                        
                        **salt** /sɔːlt/ n. 盐
                        
                        **fat** /fæt/ n. 脂肪 adj. 肥胖的
                        
                        **weight** /weɪt/ n. 体重
                        
                        **put on weight** 增加体重
                        
                        **cause** /kɔːz/ v. 造成；导致
                        
                        **balanced** /ˈbælənst/ adj. 均衡的
                        
                        **result** /rɪˈzʌlt/ n. 结果
                        
                        **improve** /ɪmˈpruːv/ v. 改进；改善
                        
                        **habit** /ˈhæbɪt/ n. 习惯
                        
                        **energy** /ˈenədʒi/ n. 能量；精力
                        
                        **article** /ˈɑːtɪkl/ n. 文章
                        
                        **would like to** 想要
                        
                        **traditional** /trəˈdɪʃənl/ adj. 传统的
                        
                        **common** /ˈkɒmən/ adj. 共同的；常见的
                        
                        **after all** 毕竟
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. What would you like? — I'd like some mutton noodles.
                        - **【考点】**：`would like` 表示委婉的请求或意愿。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u5", "Unit 5", "Here and Now",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 正在发生的活动。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **moment** /ˈməʊmənt/ n. 片刻；瞬间
                        
                        **at the moment** 现在；此刻
                        
                        **dragon** /ˈdræɡən/ n. 龙
                        
                        **Dragon Boat Festival** 端午节
                        
                        **festival** /ˈfestɪvl/ n. 节日
                        
                        **voice** /vɔɪs/ n. 嗓音；声音
                        
                        **race** /reɪs/ n. 比赛
                        
                        **message** /ˈmesɪdʒ/ n. 消息；信息
                        
                        **shuttlecock** /ˈʃʌtlkɒk/ n. 羽毛球
                        
                        **sight** /saɪt/ n. 名胜；风景
                        
                        **exam** /ɪɡˈzæm/ n. 考试
                        
                        **zone** /zəʊn/ n. 地区；时区
                        
                        **sunshine** /ˈsʌnʃaɪ/ n. 阳光
                        
                        **passenger** /ˈpæsɪndʒə(r)/ n. 乘客
                        
                        **subway** /ˈsʌbweɪ/ n. 地铁
                        
                        **ride** /raɪd/ v. 骑
                        
                        **hold** /həʊld/ v. 拿着；抓住
                        
                        **kick** /kɪk/ v. 踢
                        
                        **skate** /skeɪt/ v. 滑冰
                        
                        **happen** /ˈhæpən/ v. 发生
                        
                        **rush** /rʌʃ/ v. 冲；奔
                        
                        **shine** /ʃaɪn/ v. 发光；照耀
                        
                        **drive** /draɪv/ v. 开车
                        
                        **drop** /drɒp/ v. 落下；（开车）送到
                        
                        **online** /ˌɒnˈlaɪn/ adj. & adv. 在线的
                        
                        **colourful** /ˈkʌləfl/ adj. 色彩鲜艳的
                        
                        **brightly** /ˈbraɪtli/ adv. 明亮地
                        
                        **slowly** /ˈsləʊli/ adv. 缓慢地
                        
                        **work on** 从事
                        
                        **hold on** 别挂断；等一等
                        
                        **take a message** 捎个口信
                        
                        **leave a message** 留个口信
                        
                        **look forward to** 期待
                        
                        **right now** 现在；立刻
                        
                        **in a hurry** 匆忙
                        
                        **such as** 例如
                        
                        **rush hour** 交通高峰期
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. What are you doing? — I'm watching the Dragon Boat races.
                        - **【考点】**：现在进行时 `am/is/are + doing`。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u6", "Unit 6", "Rain or Shine",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 天气与季节。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **lightning** /ˈlaɪtnɪŋ/ n. 闪电
                        
                        **temperature** /ˈtemprətʃə(r)/ n. 温度
                        
                        **snowman** /ˈsnəʊmæn/ n. 雪人
                        
                        **tourist** /ˈtʊərɪst/ n. 旅行者
                        
                        **mountain** /ˈmaʊntən/ n. 山；山峰
                        
                        **cloud** /klaʊd/ n. 云
                        
                        **peak** /piːk/ n. 山顶
                        
                        **fog** /fɒɡ/ n. 雾
                        
                        **ground** /ɡraʊnd/ n. 地面
                        
                        **sunlight** /ˈsʌnlaɪt/ n. 阳光
                        
                        **storm** /stɔːm/ n. 暴风雨
                        
                        **wind** /wɪnd/ n. 风
                        
                        **north** /nɔːθ/ n. 北
                        
                        **south** /saʊθ/ n. 南
                        
                        **east** /iːst/ n. 东
                        
                        **west** /west/ n. 西
                        
                        **centre** /ˈsentə(r)/ n. 中心
                        
                        **affect** /əˈfekt/ v. 影响
                        
                        **sunbathe** /ˈsʌnbeɪð/ v. 晒太阳
                        
                        **experience** /ɪkˈspɪəriəns/ n. 经历；体验
                        
                        **seem** /siːm/ v. 似乎
                        
                        **pour** /pɔː(r)/ v. 倾倒；倒出
                        
                        **dry** /draɪ/ adj. 干的
                        
                        **stormy** /ˈstɔːmi/ adj. 有暴风雨的
                        
                        **lucky** /ˈlʌki/ adj. 幸运的
                        
                        **snowy** /ˈsnəʊi/ adj. 下雪的
                        
                        **freezing** /ˈfriːzɪŋ/ adj. 极冷的
                        
                        **magical** /ˈmædʒɪkl/ adj. 魔法的
                        
                        **wet** /wet/ adj. 湿的
                        
                        **tiring** /ˈtaɪərɪŋ/ adj. 累人的
                        
                        **rain or shine** 无论阴晴
                        
                        **heavily** /ˈhevɪli/ adv. 大量地
                        
                        **although** /ɔːlˈðəʊ/ conj. 虽然
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. How's the weather? — It's raining heavily.
                        - **【考点】**：询问天气的句型及其回答。副词修饰动词（raining heavily）。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u7", "Unit 7", "A Day to Remember",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 难忘的过去经历。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **museum** /mjuˈziːəm/ n. 博物馆
                        
                        **machine** /məˈʃiːn/ n. 机器
                        
                        **exhibition** /ˌeksɪˈbɪʃn/ n. 展览
                        
                        **germ** /dʒɜːm/ n. 细菌
                        
                        **direction** /daɪˈrekʃn/ n. 方向
                        
                        **step** /step/ n. 步骤；迈步
                        
                        **trip** /trɪp/ n. 旅行
                        
                        **wastewater** /ˈweɪstwɔːtə(r)/ n. 废水
                        
                        **diary** /ˈdaɪəri/ n. 日记
                        
                        **meet up** 会面
                        
                        **waste** /weɪst/ v. 浪费
                        
                        **realize** /ˈrɪəlaɪz/ v. 意识到
                        
                        **agree** /əˈɡriː/ v. 同意
                        
                        **terrible** /ˈterəbl/ adj. 可怕的；糟糕的
                        
                        **inside** /ˌɪnˈsaɪd/ prep. & adv. 在里面
                        
                        **certainly** /ˈsɜːtnli/ adv. 当然；肯定地
                        
                        **used to** 过去常常
                        
                        **school trip** 学校郊游
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. Where did you go on your school trip? — We visited the museum.
                        - **【考点】**：一般过去时的特殊疑问句与动词过去式。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u8", "Unit 8", "Once upon a Time",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 故事与传说。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **hunter** /ˈhʌntə(r)/ n. 猎人
                        
                        **promise** /ˈprɒmɪs/ n. & v. 承诺
                        
                        **war** /wɔː(r)/ n. 战争
                        
                        **neighbour** /ˈneɪbə(r)/ n. 邻居
                        
                        **emperor** /ˈempərə(r)/ n. 皇帝
                        
                        **lie** /laɪ/ n. 谎言 v. 撒谎
                        
                        **official** /əˈfɪʃl/ n. 官员
                        
                        **truth** /truːθ/ n. 真相
                        
                        **king** /kɪŋ/ n. 国王
                        
                        **bite** /baɪt/ v. 咬
                        
                        **pretend** /prɪˈtend/ v. 假装
                        
                        **decide** /daɪˈsaɪd/ v. 决定
                        
                        **praise** /preɪz/ v. 表扬；赞美
                        
                        **hate** /heɪt/ v. 讨厌
                        
                        **smile** /smaɪl/ v. & n. 微笑
                        
                        **wise** /waɪz/ adj. 明智的
                        
                        **silly** /ˈsɪli/ adj. 愚蠢的
                        
                        **afraid** /əˈfreɪd/ adj. 害怕的
                        
                        **true** /truː/ adj. 真实的
                        
                        **honest** /ˈɒnɪst/ adj. 诚实的
                        
                        **once upon a time** 从前
                        
                        **suddenly** /ˈsʌdənli/ adv. 突然
                        
                        **at first** 起初
                        
                        **tell the truth** 说实话
                        
                        **make money** 赚钱
                        
                        **keep a promise** 信守诺言
                        
                        **break a promise** 违背诺言
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. Once upon a time, there was a king.
                        - **【考点】**：故事叙述中的一般过去时应用。
                    """.trimIndent())
                )
            )
        )
    )
}
