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
                "g8up_u1", "Unit 1", "Happy Holiday",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 个人经历、旅游与休闲。
                        *   **核心内容**：分享旅行见闻，记录假期生活。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **ancient** /ˈeɪnʃənt/ adj. 古代的；古老的
                        
                        **camp** /kæmp/ n. & v. 度假营；露营
                        
                        **landscape** /ˈlændskeɪp/ n. 风景；景色
                        
                        **strange** /streɪndʒ/ adj. 奇怪的；陌生的
                        
                        **vacation** /vəˈkeɪʃn/ n. 假期；度假
                        
                        **fantastic** /fænˈtæstɪk/ adj. 极好的；了不起的
                        
                        **town** /taʊn/ n. 镇；商业区
                        
                        **breath** /breθ/ n. 呼吸的空气；一口气
                        
                        **especially** /ɪˈspeʃəli/ adv. 尤其；特别
                        
                        **anywhere** /ˈeniweə(r)/ adv. & pron. 在任何地方
                        
                        **nothing** /ˈnʌθɪŋ/ pron. 没有任何东西
                        
                        **guide** /ɡaɪd/ n. & v. 导游；指导
                        
                        **scenery** /ˈsiːnəri/ n. 风景；景色
                        
                        **silk** /sɪlk/ n. 丝绸；丝
                        
                        **scarf** /skɑːf/ n. 围巾；披巾
                        
                        **ready** /ˈredi/ adj. 准备好的
                        
                        **somewhere** /ˈsʌmweə(r)/ adv. & pron. 在某处；某地
                        
                        **myself** /maɪˈself/ pron. 我自己
                        
                        **hotel** /həʊˈtel/ n. 旅馆；旅社
                        
                        **comfortable** /ˈkʌmftəbl/ adj. 舒适的；使人舒服的
                        
                        **bored** /bɔːd/ adj. 厌倦的；烦闷的
                        
                        **sky** /skaɪ/ n. 天；天空
                        
                        **towards** /təˈwɔːdz/ prep. 向；朝
                        
                        **rainbow** /ˈreɪnbəʊ/ n. 虹；彩虹
                        
                        **square** /skweə(r)/ n. 广场 adj. 正方形的
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. Where did you go on vacation? — I went to somewhere interesting.
                        - **【考点】**：复合不定代词的用法（形容词后置）。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "Home Life",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 家庭生活与沟通。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **communicate** /kəˈmjuːnɪkeɪt/ v. 交流；沟通
                        
                        **communication** /kəˌmjuːnɪˈkeɪʃn/ n. 交流；通讯
                        
                        **message** /ˈmesɪdʒ/ n. 信息；消息
                        
                        **text** /tekst/ n. 正文；文本 v. 发短信
                        
                        **internet** /ˈɪntənet/ n. 互联网
                        
                        **social media** 社交媒体
                        
                        **app** /æp/ n. 应用程序
                        
                        **share** /ʃeə(r)/ v. 分享；共用
                        
                        **information** /ˌɪnfəˈmeɪʃn/ n. 信息；资料
                        
                        **keep in touch** 保持联系
                        
                        **housework** /ˈhaʊswɜːk/ n. 家务劳动
                        
                        **hardly** /ˈhɑːdli/ adv. 几乎不
                        
                        **ever** /ˈevə(r)/ adv. 曾经；在任何时候
                        
                        **once** /wʌns/ adv. 一次
                        
                        **twice** /twaɪs/ adv. 两次
                        
                        **program** /ˈprəʊɡræm/ n. 节目；计划
                        
                        **full** /fʊl/ adj. 忙的；满的
                        
                        **maybe** /ˈmeɪbi/ adv. 大概；或许
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. How often do you help with housework? — Hardly ever.
                        - **【考点】**：频度副词的用法。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "Same or Different?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 人际差异与理解。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **outgoing** /ˈaʊtɡəʊɪŋ/ adj. 外向的
                        
                        **better** /ˈbetə(r)/ adj. & adv. 较好的（地）
                        
                        **loudly** /ˈlaʊdli/ adv. 大声地
                        
                        **quietly** /ˈkwaɪətli/ adv. 安静地
                        
                        **hard-working** /ˌhɑːd ˈwɜːkɪŋ/ adj. 勤奋的
                        
                        **competition** /ˌkɒmpəˈtɪʃn/ n. 比赛；竞争
                        
                        **clearly** /ˈklɪəli/ adv. 清楚地
                        
                        **win** /wɪn/ v. 获胜；赢得
                        
                        **talented** /ˈtæləntɪd/ adj. 有才能的
                        
                        **truly** /ˈtruːli/ adv. 真正地
                        
                        **care** /keə(r)/ v. 在意；关心
                        
                        **laugh** /lɑːf/ v. & n. 笑
                        
                        **serious** /ˈsɪəriəs/ adj. 严肃的；严重的
                        
                        **mirror** /ˈmɪrə(r)/ n. 镜子
                        
                        **necessary** /ˈnesəsəri/ adj. 必要的
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. I'm more outgoing than my sister.
                        - **【考点】**：形容词/副词的比较级。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "Nature and Us",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 自然奇观与保护。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **theater** /ˈθɪətə(r)/ n. 戏院；剧场
                        
                        **seat** /siːt/ n. 座位
                        
                        **screen** /skriːn/ n. 屏幕
                        
                        **close** /kləʊs/ adj. 接近的 v. 关闭
                        
                        **worst** /wɜːst/ adj. & adv. 最坏的（地）
                        
                        **cheaply** /ˈtʃiːpli/ adv. 便宜地
                        
                        **song** /sɒŋ/ n. 歌曲
                        
                        **choose** /tʃuːz/ v. 选择
                        
                        **carefully** /ˈkeəfəli/ adv. 小心翼翼地
                        
                        **reporter** /rɪˈpɔːtə(r)/ n. 记者
                        
                        **fresh** /freʃ/ adj. 新鲜的
                        
                        **service** /ˈsɜːvɪs/ n. 服务
                        
                        **pretty** /ˈprɪti/ adv. 相当；很
                        
                        **menu** /ˈmenjuː/ n. 菜单
                        
                        **act** /ækt/ v. 表演 n. 行动
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. What's the best movie theater? — It has the most comfortable seats.
                        - **【考点】**：形容词/副词的最高级。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "What a Delicious Meal!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 饮食文化与烹饪。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **delicious** /dɪˈlɪʃəs/ adj. 美味的
                        
                        **meal** /miːl/ n. 早（或午、晚）餐
                        
                        **bamboo** /ˌbæmˈbuː/ n. 竹子
                        
                        **stick** /stɪk/ n. 棍；条 v. 粘贴
                        
                        **chopsticks** /ˈtʃɒpstɪks/ n. 筷子
                        
                        **spoon** /spuːn/ n. 勺子
                        
                        **fork** /fɔːk/ n. 叉子
                        
                        **knife** /naɪf/ n. 刀
                        
                        **plate** /pleɪt/ n. 盘子
                        
                        **bowl** /bəʊl/ n. 碗
                        
                        **glass** /ɡlɑːs/ n. 玻璃杯
                        
                        **salt** /sɔːlt/ n. 盐
                        
                        **sugar** /ˈʃʊɡə(r)/ n. 糖
                        
                        **cheese** /tʃiːz/ n. 干酪；奶酪
                        
                        **corn** /kɔːn/ n. 玉米
                        
                        **machine** /məˈʃiːn/ n. 机器
                        
                        **dig** /dɪɡ/ v. 掘（地）；凿（洞）
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. How do you make a fruit salad?
                        - **【考点】**：祈使句说明步骤，使用 sequence words (First, Next, Then, Finally)。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "Plan for Yourself",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 个人规划与目标。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **doctor** /ˈdɒktə(r)/ n. 医生
                        
                        **engineer** /ˌendʒɪˈnɪə(r)/ n. 工程师
                        
                        **violinist** /ˌvaɪəˈlɪnɪst/ n. 小提琴手
                        
                        **pilot** /ˈpaɪlət/ n. 飞行员
                        
                        **pianist** /ˈpɪənɪst/ n. 钢琴家
                        
                        **scientist** /ˈsɪəntɪst/ n. 科学家
                        
                        **college** /ˈkɒlɪdʒ/ n. 学院；大学
                        
                        **education** /ˌedʒuˈkeɪʃn/ n. 教育
                        
                        **medicine** /ˈmedsn/ n. 药；医学
                        
                        **university** /ˌjuːnɪˈvɜːsəti/ n. 大学
                        
                        **article** /ˈɑːtɪkl/ n. 文章；论文
                        
                        **send** /send/ v. 邮寄；发送
                        
                        **resolution** /ˌrezəˈluːʃn/ n. 决心；决定
                        
                        **team** /tiːm/ n. 队；组
                        
                        **foreign** /ˈfɒrən/ adj. 外国的
                        
                        **able** /ˈeɪbl/ adj. 能够
                        
                        **be able to** 能够做某事
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. What are you going to be when you grow up? — I'm going to be an engineer.
                        - **【考点】**：`be going to` 表示将来的打算。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "When Tomorrow Comes",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 未来预测与科技。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **paper** /ˈpeɪpə(r)/ n. 纸；试卷
                        
                        **pollution** /pəˈluːʃn/ n. 污染
                        
                        **prediction** /rɪˈdɪkʃn/ n. 预言；预测
                        
                        **future** /ˈfjuːtʃə(r)/ n. 将来；未来
                        
                        **environment** /ɪnˈvaɪrənmənt/ n. 环境
                        
                        **planet** /ˈplænɪt/ n. 行星
                        
                        **earth** /ɜːθ/ n. 地球；泥土
                        
                        **plant** /plɑːnt/ v. 种植 n. 植物
                        
                        **part** /pɑːt/ n. 部分
                        
                        **play a part** 参与；发挥作用
                        
                        **space** /speɪs/ n. 太空；空间
                        
                        **human** /ˈhjuːmən/ adj. 人的 n. 人
                        
                        **dangerous** /ˈdeɪndʒərəs/ adj. 危险的
                        
                        **already** /ɔːlˈredi/ adv. 已经
                        
                        **factory** /ˈfæktri/ n. 工厂
                        
                        **believe** /bɪˈliːv/ v. 相信
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. Will people have robots in their homes? — Yes, they will.
                        - **【考点】**：`will` 引导的一般将来时表示预测。注意 `more/less/fewer` 的用法。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "Let's Communicate!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 人际沟通与交流。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **shake** /ʃeɪk/ v. & n. 摇动；抖动
                        
                        **shake hands** 握手
                        
                        **custom** /ˈkustəm/ n. 风俗；习俗
                        
                        **bow** /baʊ/ v. & n. 鞠躬
                        
                        **kiss** /kɪs/ v. & n. 吻；亲吻
                        
                        **greet** /ɡriːt/ v. 问候；打招呼
                        
                        **relaxed** /rɪˈlækst/ adj. 放松的；自在的
                        
                        **drop by** 顺便拜访
                        
                        **inventory** /ˈɪnvəntri/ n. 清单；存货
                        
                        **passport** /ˈpɑːspɔːt/ n. 护照
                        
                        **chalk** /tʃɔːk/ n. 粉笔
                        
                        **blackboard** /ˈblækbɔːd/ n. 黑板
                        
                        **northern** /ˈnɔːðən/ adj. 北方的；北部的
                        
                        **coast** /kəʊst/ n. 海岸；海滨
                        
                        **manner** /ˈmænə(r)/ n. 礼貌；举止
                        
                        **empty** /ˈempti/ adj. 空的
                    """.trimIndent()),
                    UnitDetailSection("📚 重点句子与语法", """
                        #### 1. You're supposed to shake hands.
                        - **【考点】**：`be supposed to do` 表示“应该”。
                    """.trimIndent())
                )
            )
        )
    )
}
