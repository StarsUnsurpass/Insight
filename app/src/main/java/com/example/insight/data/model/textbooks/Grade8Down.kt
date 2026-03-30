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
        coverColor = Color(0xFFF3E5F5),
        coverImageUrl = "http://www.dzkbw.com/books/rjb/yingyu/xc8x_2024/coverbig.jpg",
        units = listOf(
            TextbookUnit(
                "g8down_u1", "Unit 1", "What's the matter?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 健康生活、突发事件与应急处理。
                        *   **深层意义**：本单元聚焦于描述病痛及急救处理，引导学生关爱他人并学会基本的生存技能。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **matter** /ˈmætə(r)/ n. 问题；事情
                        
                        **What's the matter?** 怎么了？出什么事了？
                        
                        **stomachache** /ˈstʌməkeɪk/ n. 胃痛；腹痛
                        
                        **throat** /θrəʊt/ n. 咽喉；喉咙
                        
                        **fever** /ˈfiːvə(r)/ n. 发烧
                        
                        **cough** /kɒf/ v. & n. 咳嗽
                        
                        **X-ray** /ˈeks reɪ/ n. X光；X射线
                        
                        **toothache** /ˈtuːθeɪk/ n. 牙痛
                        
                        **headache** /ˈhedeɪk/ n. 头痛
                        
                        **passenger** /ˈpæsɪndʒə(r)/ n. 乘客；旅客
                        
                        **trouble** /ˈtrʌbl/ n. 问题；苦恼
                        
                        **herself** /hɜːˈself/ pron. 她自己
                        
                        **bandage** /ˈbændɪdʒ/ n. 绷带 v. 用绷带包扎
                        
                        **sick** /sɪk/ adj. 生病的；有病的
                        
                        **knee** /niː/ n. 膝盖
                        
                        **situation** /ˌsɪtʃuˈeɪʃn/ n. 情况；状况
                        
                        **blood** /blʌd/ n. 血
                        
                        **decision** /dɪˈsɪʒn/ n. 决定；抉择
                        
                        **death** /deθ/ n. 死；死亡
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：反身代词
                        - *I cut **myself**.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u2", "Unit 2", "I'll help to clean up the city parks.",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 志愿服务。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **clean up** 打扫（或清除）干净
                        
                        **cheer up** （使）变得更高兴
                        
                        **volunteer** /ˌvɒlənˈtɪə(r)/ v. 义务做 n. 志愿者
                        
                        **come up with** 想出；提出
                        
                        **used to** 曾经……；过去……
                        
                        **lonely** /ˈləʊnli/ adj. 孤独的；寂寞的
                        
                        **several** /ˈsevrəl/ pron. 几个；数个
                        
                        **satisfaction** /ˌsætɪsˈfækʃn/ n. 满意；欣慰
                        
                        **journey** /ˈdʒɜːni/ n. 旅行；行程
                        
                        **raise** /reɪz/ v. 筹集；养育
                        
                        **repair** /rɪˈpeə(r)/ v. 修理；修补
                        
                        **fix up** 修理；装饰
                        
                        **disabled** /dɪsˈeɪbld/ adj. 有残疾的
                        
                        **blind** /blaɪnd/ adj. 瞎的；失明的
                        
                        **deaf** /def/ adj. 聋的
                        
                        **imagine** /ˈmædʒɪn/ v. 想象；设想
                        
                        **difficulty** /ˌdɪfɪkəlti/ n. 困难；难题
                        
                        **kindness** /ˈkaɪndnəs/ n. 仁慈；善良
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u3", "Unit 3", "Could you please clean your room?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **rubbish** /ˈrʌbɪʃ/ n. 垃圾；废物
                        
                        **sweep** /swɪp/ v. 扫；打扫
                        
                        **floor** /flɔː(r)/ n. 地板
                        
                        **mess** /mes/ n.杂乱；不整洁
                        
                        **throw** /θrəʊ/ v. 扔；掷
                        
                        **neither** /ˈnaɪðə(r)/ adv. 也不
                        
                        **shirt** /ʃɜːt/ n. 衬衫
                        
                        **pass** /pɑːs/ v. 给；递；经过
                        
                        **borrow** /ˈbɒrəʊ/ v. 借；借用
                        
                        **lend** /lend/ v. 借给；借出
                        
                        **finger** /ˈfɪŋɡə(r)/ n. 手指
                        
                        **hate** /he|t/ v. 憎恶；讨厌
                        
                        **chore** /tʃɔː(r)/ n. 杂务；乏味无聊的工作
                        
                        **while** /waɪl/ conj. 与……同时
                        
                        **waste** /weɪst/ n. 浪费；滥用
                        
                        **provide** /prəˈvaɪd/ v. 提供；供应
                        
                        **anyway** /ˈeɪniweɪ/ adv. 而且；加之
                        
                        **depend** /dɪˈpend/ v. 依靠；信赖
                        
                        **independent** /ˌɪndɪˈpendənt/ adj. 独立的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u4", "Unit 4", "Why don't you talk to your parents?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **allow** /əˈlaʊ/ v. 允许；准许
                        
                        **wrong** /rɒŋ/ adj. 错误的；有毛病的
                        
                        **What's wrong?** 怎么了？
                        
                        **guess** /ɡes/ v. 猜测；估计
                        
                        **deal** /diːl/ n. 协议；交易
                        
                        **relation** /rɪˈleɪʃn/ n. 关系；联系
                        
                        **communication** /kəˌmjuːnɪˈkeɪʃn/ n. 交流；沟通
                        
                        **argue** /ˈɑːɡjuː/ v. 争吵；争论
                        
                        **cloud** /klaʊd/ n. 云；云朵
                        
                        **elder** /ˈeldə(r)/ adj. 年纪较长的
                        
                        **instead** /ɪnˈsted/ adv. 代替；反而
                        
                        **pressure** /ˈpreʃə(r)/ n. 压力
                        
                        **compete** /kəmˈpiːt/ v. 竞争；对抗
                        
                        **opinion** /əˈpɪnjən/ n. 意见；想法
                        
                        **skill** /skɪl/ n. 技能；技巧
                        
                        **typical** /ˈtɪpɪkl/ adj. 典型的
                        
                        **continue** /kənˈtɪnjuː/ v. 持续；继续
                        
                        **compare** /kəmˈpeə(r)/ v. 比较
                        
                        **crazy** /ˈkreɪzi/ adj. 不理智的；疯狂的
                        
                        **push** /pʊʃ/ v. 鞭策；督促
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u5", "Unit 5", "What were you doing when the rainstorm came?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **rainstorm** /ˈreɪnstɔːm/ n. 暴风雨
                        
                        **alarm** /əˈlɑːm/ n. 闹钟
                        
                        **begin** /bɪˈɡɪn/ v. 开始
                        
                        **heavily** /ˈhevɪli/ adv. 大量地
                        
                        **suddenly** /ˈsʌdənli/ adv. 突然；忽然
                        
                        **strange** /ˈstreɪndʒ/ adj. 奇特的；奇怪的
                        
                        **storm** /stɔːm/ n. 暴风雨
                        
                        **wind** /wɪnd/ n. 风
                        
                        **light** /laɪt/ n. 光；光线；灯
                        
                        **report** /rɪˈpɔːt/ v. & n. 报告；汇报
                        
                        **area** /ˈeəriə/ n. 地域；地区
                        
                        **wood** /wʊd/ n. 木；木头
                        
                        **window** /ˈwɪndəʊ/ n. 窗户
                        
                        **flashlight** /ˈflæʃlaɪt/ n. 手电筒
                        
                        **beat** /biːt/ v. 敲打；打败
                        
                        **against** /əˈɡenst/ prep. 反对；倚；碰
                        
                        **asleep** /əˈsliːp/ adj. 睡着的
                        
                        **rise** /raɪz/ v. & n. 上升；升起
                        
                        **fallen** /ˈfɔːlən/ adj. 倒下的；落下的
                        
                        **apart** /əˈpɑːt/ adv. 分离；分开
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：过去进行时
                        - *I **was doing** my homework when it began to rain.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u6", "Unit 6", "An old man tried to move the mountains.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **shoot** /ʃuːt/ v. 射击；发射
                        
                        **stone** /stəʊn/ n. 石头
                        
                        **weak** /wiːk/ adj. 虚弱的；无力的
                        
                        **god** /ɡɒd/ n. 神；上帝
                        
                        **remind** /rɪˈmaɪnd/ v. 提醒；使想起
                        
                        **bit** /bɪt/ n. 一点；小块
                        
                        **silly** /ˈsɪli/ adj. 愚蠢的；傻的
                        
                        **object** /ˈɒbdʒekt/ n. 物体；物品
                        
                        **hide** /haɪd/ v. 隐藏；隐蔽
                        
                        **magic** /ˈmædʒɪk/ adj. 有魔力的
                        
                        **stick** /stɪk/ n. 棍；棒
                        
                        **western** /ˈwestən/ adj. 西方的
                        
                        **fit** /fɪt/ v. 适合；合身
                        
                        **couple** /ˈkʌpl/ n. （一）对；夫妇
                        
                        **smile** /smaɪl/ v. & n. 微笑
                        
                        **marry** /ˈmæri/ v. 结婚
                        
                        **gold** /ɡəʊld/ n. 金子 adj. 金色的
                        
                        **silk** /sɪlk/ n. 丝绸
                        
                        **stupid** /ˈstjuːpɪd/ adj. 愚蠢的
                        
                        **cheat** /tʃiːt/ v. 欺骗；蒙骗
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u7", "Unit 7", "What's the highest mountain in the world?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **square** /skweə(r)/ n. 平方；正方形
                        
                        **meter** /ˈmiːtə(r)/ n. 米；公尺
                        
                        **deep** /diːp/ adj. 深的；纵深的
                        
                        **desert** /ˈdezət/ n. 沙漠
                        
                        **population** /ˌpɒpjuˈleɪʃn/ n. 人口；人口数量
                        
                        **Asia** /ˈeɪʒə/ n. 亚洲
                        
                        **wall** /wɔːl/ n. 墙
                        
                        **tourist** /ˈtʊərɪst/ n. 旅行者；观光者
                        
                        **amazing** /əˈmeɪzɪŋ/ adj. 令人惊奇的
                        
                        **ancient** /ˈeɪnʃənt/ adj. 古代的；古老的
                        
                        **protect** /prəˈtekt/ v. 保护；防护
                        
                        **wide** /waɪd/ adj. 宽的；宽阔的
                        
                        **achievement** /əˈtʃiːvmənt/ n. 成就；成绩
                        
                        **thick** /θɪk/ adj. 厚的；浓的
                        
                        **condition** /kənˈdɪʃn/ n. 条件；状况
                        
                        **succeed** /səkˈsiːd/ v. 成功
                        
                        **challenge** /ˈtʃælɪndʒ/ v. & n. 挑战；考验
                        
                        **ocean** /ˈəʊʃn/ n. 大洋；海洋
                        
                        **nature** /ˈneɪtʃə(r)/ n. 自然界；大自然
                        
                        **weigh** /weɪ/ v. 重量有……；重……
                        
                        **bamboo** /ˌbæmˈbuː/ n. 竹子
                        
                        **endangered** /ɪnˈdeɪndʒəd/ adj. 濒危的
                        
                        **research** /rɪˈsɜːtʃ/ n. & v. 研究；调查
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u8", "Unit 8", "Have you read Treasure Island yet?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **treasure** /ˈtreʒə(r)/ n. 珠宝；财富
                        
                        **island** /ˈaɪlənd/ n. 岛
                        
                        **classic** /ˈklæsɪk/ n. 经典著作；名著
                        
                        **page** /peɪdʒ/ n. （书刊的）页
                        
                        **hurry** /ˈhʌri/ v. 匆忙；赶快
                        
                        **due** /djuː/ adj. 预期；到期
                        
                        **ship** /ʃɪp/ n. 船
                        
                        **tool** /tuːl/ n. 工具
                        
                        **gun** /ɡʌn/ n. 枪；炮
                        
                        **mark** /mɑːk/ n. 记号；分数 v. 做记号
                        
                        **sand** /sænd/ n. 沙；沙滩
                        
                        **cannibal** /ˈkænɪbl/ n. 食人肉者
                        
                        **towards** /təˈwɔːdz/ prep. 朝；向
                        
                        **land** /lænd/ n. 陆地；大地
                        
                        **fiction** /ˈfɪkʃn/ n. 小说
                        
                        **technology** /tekˈnɒlədʒi/ n. 科技；工艺
                        
                        **French** /frentʃ/ n. 法语 adj. 法国的
                        
                        **pop** /pɒp/ n. 流行音乐
                        
                        **rock** /rɒk/ n. 摇滚乐
                        
                        **forever** /fəˈrevə(r)/ adv. 永远
                        
                        **abroad** /əˈbrɔːd/ adv. 在国外
                        
                        **fan** /fæn/ n. 迷；狂热爱好者
                        
                        **southern** /ˈsʌðən/ adj. 南方的
                        
                        **modern** /ˈmɒdn/ adj. 现代的
                        
                        **success** /səkˈses/ n. 成功
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：现在完成时
                        - *I **have** already **read** it.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u9", "Unit 9", "Have you ever been to a museum?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **amusement** /əˈmjuːzmənt/ n. 娱乐；游戏
                        
                        **somewhere** /ˈsʌmweə(r)/ adv. 在某处；到某处
                        
                        **camera** /ˈkæmrə/ n. 照相机
                        
                        **invention** /ɪnˈvenʃn/ n. 发明；发明物
                        
                        **unbelievable** /ˌʌnbɪˈliːvəbl/ adj. 难以置信的
                        
                        **progress** /prəˈɡres/ v. & n. 进步；进展
                        
                        **rapid** /ˈræpɪd/ adj. 迅速的；快速的
                        
                        **unusual** /ʌnˈjuːʒuəl/ adj. 特别的；不寻常的
                        
                        **toilet** /ˈtɔɪlət/ n. 坐便器；厕所
                        
                        **encourage** /ɪnˈkʌrɪdʒ/ v. 鼓励
                        
                        **social** /ˈsəʊʃl/ adj. 社会的
                        
                        **peaceful** /ˈpiːsfl/ adj. 和平的；安宁的
                        
                        **tea** /tiː/ n. 茶；茶叶
                        
                        **performance** /pəˈfɔːməns/ n. 表演；演出
                        
                        **perfect** /ˈpɜːfɪkt/ adj. 完美的；完全的
                        
                        **itself** /ɪtˈself/ pron. 它自己
                        
                        **collect** /kəˈlekt/ v. 收集；采集
                        
                        **German** /ˈdʒɜːmən/ adj. 德国的 n. 德语
                        
                        **ride** /raɪd/ n. 游乐设施 v. 骑
                        
                        **province** /ˈprɒvɪns/ n. 省份
                        
                        **thousand** /ˈθaʊznd/ num. 一千
                        
                        **safe** /seɪf/ adj. 安全的
                        
                        **simply** /ˈsɪmpli/ adv. 仅仅；简单地
                        
                        **fear** /fɪə(r)/ v. & n. 害怕；惧怕
                        
                        **whether** /ˈweðə(r)/ conj. 不管……（还是）；是否
                        
                        **Indian** /ˈɪndiən/ adj. 印度的 n. 印度人
                        
                        **Japanese** /ˌdʒæpəˈniːz/ adj. 日本的 n. 日语
                        
                        **fox** /fɒks/ n. 狐狸
                        
                        **whenever** /wenˈevə(r)/ conj. 无论何时
                        
                        **spring** /sprɪŋ/ n. 春天
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u10", "Unit 10", "I've had this bike for three years.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **yard** /jɑːd/ n. 院子
                        
                        **sweet** /swiːt/ adj. 甜的；可爱的
                        
                        **memory** /ˈmeməri/ n. 记忆；回忆
                        
                        **cent** /sent/ n. 分；分币
                        
                        **toy** /tɔɪ/ n. 玩具
                        
                        **bear** /beə(r)/ n. 熊
                        
                        **maker** /ˈmeɪkə(r)/ n. 生产者；制订者
                        
                        **scarf** /skɑːf/ n. 围巾；披巾
                        
                        **soft** /sɒft/ adj. 软的；柔软的
                        
                        **check** /tʃek/ v. & n. 检查；审查
                        
                        **board** /bɔːd/ n. 板；木板
                        
                        **junior** /ˈdʒuːniə(r)/ adj. 地位（或等级）较低的
                        
                        **clear** /klɪə(r)/ v. 清理；清除
                        
                        **bedroom** /ˈbedruːm/ n. 卧室
                        
                        **no longer** 不再；不复
                        
                        **own** /əʊn/ v. 拥有 adj. 自己的
                        
                        **railway** /ˈreɪlweɪ/ n. 铁路；铁道
                        
                        **part** /pɑːt/ v. 离开；分开 n. 部分
                        
                        **certain** /ˈsɜːtn/ adj. 某种；确信的
                        
                        **honest** /ˈɒnɪst/ adj. 诚实的；正直的
                        
                        **while** /waɪl/ n. 一段时间；一会儿
                        
                        **truth** /truːθ/ n. 真理；真相；事实
                        
                        **hometown** /ˈhəʊmtaʊn/ n. 家乡；故乡
                        
                        **search** /sɜːtʃ/ v. & n. 搜索；搜查
                        
                        **among** /əˈmʌŋ/ prep. 在（其）中
                        
                        **shame** /ʃeɪm/ n. 羞耻；遗憾
                        
                        **regard** /rɪˈɡɑːd/ v. 将……视为
                        
                        **count** /kaʊnt/ v. 数数
                        
                        **century** /ˈsentʃəri/ n. 世纪；百年
                        
                        **opposite** /ˈɒpəzɪt/ prep. 在……对面 adj. 对面的
                        
                        **especially** /ɪˈspeʃəli/ adv. 尤其；特别
                        
                        **childhood** /ˈtʃaɪldhʊd/ n. 童年；幼年
                        
                        **consider** /kənˈsɪdə(r)/ v. 注视；仔细考虑
                        
                        **close to** 几乎；接近；亲近
                    """.trimIndent())
                )
            )
        )
    )
}
