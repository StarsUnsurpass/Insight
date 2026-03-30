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
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：复合不定代词
                        - *something special* (形容词后置)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u2", "Unit 2", "How do we communicate?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 沟通与交流。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **full** /fʊl/ adj. 忙的；满的
                        
                        **online** /ˌɒnˈlaɪn/ adj. & adv. 在线的；联网的
                        
                        **grade** /ɡreɪd/ n. 成绩等级；评分等级
                        
                        **hand** /hænd/ n. & v. 手；交，递
                        
                        **heart** /hɑːt/ n. 内心；心脏
                        
                        **information** /ˌɪnfəˈmeɪʃn/ n. 信息；消息
                        
                        **communicate** /kəˈmjuːnɪkeɪt/ v. 交流；沟通
                        
                        **communication** /kəˌmjuːnɪˈkeɪʃn/ n. 交流；通讯
                        
                        **message** /ˈmesɪdʒ/ n. 信息；消息
                        
                        **call** /kɔːl/ v. & n. 打电话；呼叫
                        
                        **text** /tekst/ n. & v. 正文；发短信
                        
                        **internet** /ˈɪntənet/ n. 因特网
                        
                        **social media** /ˌsəʊʃl ˈmiːdiə/ n. 社交媒体
                        
                        **better** /ˈbetə(r)/ adj. & adv. 更好的（地）
                        
                        **understand** /ˌʌndəˈstænd/ v. 理解；明白
                        
                        **difference** /ˈdɪfrəns/ n. 差别；差异
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u3", "Unit 3", "What can you do for your home?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 家庭责任。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **housework** /ˈhaʊswɜːk/ n. 家务劳动
                        
                        **chore** /tʃɔː(r)/ n. 杂务；琐事
                        
                        **clean** /kliːn/ v. & adj. 打扫；干净的
                        
                        **sweep** /swɪp/ v. 扫；打扫
                        
                        **floor** /flɔː(r)/ n. 地板；地面
                        
                        **kitchen** /ˈkɪtʃɪn/ n. 厨房
                        
                        **living room** /ˈlɪvɪŋ ruːm/ n. 客厅
                        
                        **arrival** /əˈraɪvl/ n. 到达
                        
                        **yet** /jet/ adv. 还；仍然
                        
                        **add** /æd/ v. 添加；加
                        
                        **biscuit** /ˈbɪskɪt/ n. 饼干
                        
                        **borrow** /ˈbɒrəʊ/ v. 借；借入
                        
                        **take notes** 短语 做笔记
                        
                        **clean up** 短语 打扫干净
                        
                        **community** /kəˈmjuːnɪti/ n. 社区；社团
                        
                        **rubbish** /ˈrʌbɪʃ/ n. 垃圾
                        
                        **almost** /ˈɔːlməʊst/ adv. 差不多；几乎
                        
                        **journey** /ˈdʒɜːni/ n. & v. 旅行；历程
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u4", "Unit 4", "Nature's wonders",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 自然奇观。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **moss** /mɒs/ n. 苔藓
                        
                        **redwood** /ˈredwʊd/ n. 红杉；红木
                        
                        **cheetah** /ˈtʃiːtə/ n. 猎豹
                        
                        **folding** /ˈfəʊldɪŋ/ adj. 折叠式的
                        
                        **bamboo** /bæmˈbuː/ n. 竹子
                        
                        **popular** /ˈpɒpjələ(r)/ adj. 受欢迎的；流行的
                        
                        **tool** /tuːl/ n. 工具；手段
                        
                        **actually** /ˈæktʃuəli/ adv. 实际上；居然
                        
                        **shoot** /ʃuːt/ n. & v. 幼苗；射击
                        
                        **appear** /əˈpɪə(r)/ v. 出现；呈现
                        
                        **land** /lænd/ n. & v. 陆地；降落
                        
                        **African** /ˈæfrɪkən/ adj. & n. 非洲的；非洲人
                        
                        **rose** /rəʊz/ n. 玫瑰；蔷薇
                        
                        **peony** /ˈpiːəni/ n. 牡丹；芍药
                        
                        **lotus** /ˈləʊtəs/ n. 莲花
                        
                        **butterfly** /ˈbʌtəflaɪ/ n. 蝴蝶
                        
                        **wing** /wɪŋ/ n. 翅膀；翼
                        
                        **frog** /frɒɡ/ n. 青蛙
                        
                        **weigh** /weɪ/ v. 有……重；称重
                        
                        **kg** /ˌkiːləʊˈɡræm/ n. 千克；公斤
                        
                        **ginkgo** /ˈɡɪŋkɡəʊ/ n. 银杏
                        
                        **province** /ˈprɒvɪns/ n. 省份
                        
                        **connect** /kəˈnekt/ v. 连接；关联
                        
                        **without** /wɪˈðaʊt/ prep. 没有；缺乏
                        
                        **imagine** /ɪˈmædʒɪn/ v. 想象；猜想
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u5", "Unit 5", "What a Delicious Meal!",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 饮食文化。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **honey** /ˈhʌni/ n. 蜂蜜
                        
                        **disappointed** /ˌdɪsəˈpɔɪntɪd/ adj. 失望的；沮丧的
                        
                        **connection** /kəˈnekʃn/ n. 联系；连接
                        
                        **pollination** /ˌpɒləˈneɪʃn/ n. 授粉
                        
                        **pollen** /ˈpɒlən/ n. 花粉
                        
                        **action** /ˈækʃn/ n. 行动；行为
                        
                        **percent** /pəˈsent/ n. & adj. 百分之……
                        
                        **planet** /ˈplænɪt/ n. 行星
                        
                        **store** /stɔː(r)/ v. & n. 储存；商店
                        
                        **delicious** /dɪˈlɪʃəs/ adj. 美味的
                        
                        **meal** /miːl/ n. 早（或午、晚）餐
                        
                        **cooking** /ˈkʊkɪŋ/ n. 烹饪；厨艺
                        
                        **food** /fuːd/ n. 食物
                        
                        **recipe** /ˈresəpi/ n. 食谱
                        
                        **ingredient** /ɪnˈɡriːdiənt/ n. 原料；成分
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u6", "Unit 6", "Plan for Yourself",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 个人规划与未来理想。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **yourself** /jɔːˈself/ pron. 你自己
                        
                        **yourselves** /jɔːˈselvz/ pron. 你们自己
                        
                        **engineer** /ˌendʒɪˈnɪə(r)/ n. 工程师
                        
                        **fashion** /ˈfæʃn/ n. 时尚；流行样式
                        
                        **designer** /dɪˈzaɪnə(r)/ n. 设计者；设计家
                        
                        **director** /dəˈrektə(r)/ n. 导演；部门负责人
                        
                        **musician** /mjuˈzɪʃn/ n. 音乐家
                        
                        **intelligence** /ɪnˈtelɪdʒəns/ n. 智力；才智
                        
                        **essay** /ˈeseɪ/ n. 文章；短文
                        
                        **classic** /ˈklæsɪk/ adj. & n. 经典的；经典著作
                        
                        **literature** /ˈlɪtrətʃə(r)/ n. 文学
                        
                        **athlete** /ˈæθliːt/ n. 运动员
                        
                        **fireman** /ˈfaɪəmən/ n. 消防员
                        
                        **photographer** /fəˈtɒɡrəfə(r)/ n. 摄影师
                        
                        **painter** /ˈpeɪntə(r)/ n. 画家
                        
                        **businessman** /ˈbɪznəsmæn/ n. 商人
                        
                        **actress** /ˈæktrəs/ n. 女演员
                        
                        **lawyer** /ˈlɔːjə(r)/ n. 律师
                        
                        **law** /lɔː/ n. 法律
                        
                        **miss** /mɪs/ v. 错过；思念
                        
                        **able** /ˈeɪbl/ adj. 能够；有能力的
                        
                        **stick** /stɪk/ v. 坚持；粘贴
                        
                        **achieve** /əˈtʃiːv/ v. 达到；完成
                        
                        **confident** /ˈkɒnfɪdənt/ adj. 自信的
                        
                        **organized** /ˈɔːɡənaɪzd/ adj. 有组织的；有条理的
                        
                        **wisely** /ˈwaɪzli/ adv. 明智地
                        
                        **paragraph** /ˈpærəɡrɑːf/ n. 段落
                        
                        **fail** /feɪl/ v. 失败；不及格
                        
                        **introduce** /ˌɪntrəˈdjuːs/ v. 介绍
                        
                        **meaning** /ˈmiːnɪŋ/ n. 意义；意思
                        
                        **relationship** /rɪˈleɪʃnʃɪp/ n. 关系
                        
                        **energetic** /ˌenəˈdʒetɪk/ adj. 精力充沛的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u7", "Unit 7", "How do we communicate?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 沟通与交流。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **communicate** /kəˈmjuːnɪkeɪt/ v. 交流；沟通
                        
                        **communication** /kəˌmjuːnɪˈkeɪʃn/ n. 交流；通讯
                        
                        **message** /ˈmesɪdʒ/ n. 信息；消息
                        
                        **social** /ˈsəʊʃl/ adj. 社会的；社交的
                        
                        **media** /ˈmiːdiə/ n. 媒体
                        
                        **smartphone** /ˈsmɑːtfəʊn/ n. 智能手机
                        
                        **app** /æp/ n. 应用程序
                        
                        **online** /ˌɒnˈlaɪn/ adj. & adv. 在线的；联网地
                        
                        **connect** /kəˈnekt/ v. 连接；与……建立联系
                        
                        **express** /ɪkˈspres/ v. 表达；表示
                        
                        **feeling** /ˈfiːlɪŋ/ n. 感觉；情感
                        
                        **opinion** /əˈpɪnjən/ n. 意见；看法
                        
                        **gesture** /ˈdʒestʃə(r)/ n. 手势；姿态
                        
                        **body language** n. 身势语；肢体语言
                        
                        **face-to-face** adj. & adv. 面对面的
                        
                        **misunderstand** /ˌmɪsʌndəˈstænd/ v. 误解；误会
                        
                        **polite** /pəˈlaɪt/ adj. 有礼貌的
                        
                        **reply** /rɪˈply/ v. & n. 回答；答复
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u8", "Unit 8", "How do we understand differences?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 文化差异与尊重。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **difference** /ˈdɪfrəns/ n. 差异；不同
                        
                        **different** /ˈdɪfrənt/ adj. 不同的
                        
                        **culture** /ˈkʌltʃə(r)/ n. 文化
                        
                        **custom** /ˈkʌstəm/ n. 风俗；习惯
                        
                        **tradition** /trəˈdɪʃn/ n. 传统
                        
                        **respect** /rɪˈspekt/ v. & n. 尊重；敬重
                        
                        **accept** /əkˈsept/ v. 接受
                        
                        **similar** /ˈsɪmələ(r)/ adj. 相似的
                        
                        **background** /ˈbækɡraʊnd/ n. 背景
                        
                        **experience** /ɪkˈspɪəriəns/ n. & v. 经验；经历
                        
                        **understand** /ˌʌndəˈstænd/ v. 理解；懂
                        
                        **valuable** /ˈvæljuəbl/ adj. 有价值的
                        
                        **unique** /juˈniːk/ adj. 唯一的；独特的
                        
                        **diverse** /daɪˈvɜːs/ adj. 多样的；不同的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u9", "Unit 9", "How do we help others?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 志愿服务与帮助他人。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **volunteer** /ˌvɒlənˈtɪə(r)/ v. & n. 自愿；志愿者
                        
                        **community** /kəˈmjuːnɪti/ n. 社区；社团
                        
                        **service** /ˈsɜːvɪs/ n. 服务
                        
                        **charity** /ˈtʃærəti/ n. 慈善机构
                        
                        **donation** /dəʊˈneɪʃn/ n. 捐赠；捐款
                        
                        **support** /səˈpɔːt/ v. & n. 支持；帮助
                        
                        **kindness** /ˈkaɪndnəs/ n. 仁慈；善良
                        
                        **generous** /ˈdʒenərəs/ adj. 慷慨的；大方的
                        
                        **helpful** /ˈhelpfl/ adj. 有帮助的
                        
                        **care** /keə(r)/ v. & n. 照顾；关怀
                        
                        **homeless** /ˈhəʊmləs/ adj. 无家可归的
                        
                        **disabled** /dɪsˈeɪbld/ adj. 有残疾的
                        
                        **encourage** /ɪnˈkʌrɪdʒ/ v. 鼓励
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8up_u10", "Unit 10", "How do we protect the environment?",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 环境保护。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **environment** /ɪnˈvaɪrənmənt/ n. 环境
                        
                        **protect** /pəˈtekt/ v. 保护
                        
                        **protection** /pəˈtekʃn/ n. 保护
                        
                        **pollution** /pəˈluːʃn/ n. 污染
                        
                        **recycle** /ˌriːˈsaɪkl/ v. 回收利用
                        
                        **waste** /weɪst/ n. & v. 浪费；废料
                        
                        **plastic** /ˈplæstɪk/ n. & adj. 塑料（的）
                        
                        **energy** /ˈenədʒi/ n. 能量；能源
                        
                        **nature** /ˈneɪtʃə(r)/ n. 自然
                        
                        **wildlife** /ˈwaɪldlaɪf/ n. 野生动物
                        
                        **reduce** /rɪˈdjuːs/ v. 减少
                        
                        **reuse** /ˌriːˈjuːz/ v. 再次使用
                        
                        **earth** /ɜːθ/ n. 地球；大地
                        
                        **global warming** n. 全球变暖
                    """.trimIndent())
                )
            )
        )
    )
}
