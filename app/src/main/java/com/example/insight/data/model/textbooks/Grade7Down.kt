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
                "g7down_u1", "Unit 1", "Rules and Customs",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与社会 —— 社会规则与文化习俗。
                        *   **深层意义**：本单元聚焦于公共场所及家庭内部的规则（Rules），并延伸至不同文化背景下的礼仪习俗（Customs）。旨在引导学生建立契约意识、自律精神，同时培养文化包容性。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **rule** /ruːl/ n. 规则；规章
                        
                        **hallway** /ˈhɔːlweɪ/ n. 走廊；过道
                        
                        **hall** /hɔːl/ n. 大厅；礼堂
                        
                        **listen** /ˈlɪsn/ v. 听；倾听
                        
                        **listen to** 听……
                        
                        **fight** /faɪt/ v. & n. 打架；战斗
                        
                        **sorry** /ˈsɒri/ adj. 抱歉的；难过的
                        
                        **outside** /ˌaʊtˈsaɪd/ adv. 在外面 adj. 外面的
                        
                        **wear** /weə(r)/ v. 穿；戴
                        
                        **important** /ɪmˈpɔːtnt/ adj. 重要的
                        
                        **bring** /brɪn/ v. 带来；取来
                        
                        **uniform** /ˈjuːnɪfɔːm/ n. 制服；校服
                        
                        **quiet** /ˈkwaɪət/ adj. 安静的
                        
                        **quietly** /ˈkwaɪətli/ adv. 安静地
                        
                        **late** /leɪt/ adj. & adv. 晚；迟
                        
                        **be late for** 迟到
                        
                        **on time** 准时
                        
                        **eat** /iːt/ v. 吃
                        
                        **in class** 在课堂上
                        
                        **library** /ˈlaɪbrəri/ n. 图书馆
                        
                        **must** /mʌst/ modal v. 必须
                        
                        **follow** /ˈfɒləʊ/ v. 遵循；跟随
                        
                        **follow the rules** 遵守规则
                        
                        **can** /kæn/ modal v. 能；可以
                        
                        **can't** (cannot) 不能
                        
                        **dishes** /ˈdɪʃɪz/ n. 餐具；盘碟
                        
                        **do the dishes** 清洗餐具
                        
                        **before** /bɪˈfɔː(r)/ prep. & conj. 在……以前
                        
                        **after** /ˈɑːftə(r)/ prep. & conj. 在……以后
                        
                        **strict** /strɪkt/ adj. 严格的；严厉的
                        
                        **be strict with sb.** 对某人严厉
                        
                        **remember** /rɪˈmembə(r)/ v. 记住；记起
                        
                        **luck** /lʌk/ n. 运气；幸运
                        
                        **keep** /kiːp/ v. 保持；保留
                        
                        **hair** /heə(r)/ n. 头发；毛发
                        
                        **learn** /lɜːn/ v. 学习；学会
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：祈使句 (Imperatives)
                        **1. 肯定形式**：动词原形开头。 *Listen to the teacher!*
                        **2. 否定形式**：`Don't + 动词原形`。 *Don't fight!*
                        
                        ### 核心语法二：情态动词 must 与 can
                        - **must** 表示“必须”，语气强烈。
                        - **can** 表示“许可”。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u2", "Unit 2", "Weather and Vacation",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自然 —— 天气状况与假期生活。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **rain** /reɪn/ v. 下雨 n. 雨
                        
                        **rainy** /ˈreɪni/ adj. 下雨的；有雨的
                        
                        **snow** /snəʊ/ v. 下雪 n. 雪
                        
                        **snowy** /ˈsnəʊi/ adj. 下雪的
                        
                        **cloud** /klaʊd/ n. 云
                        
                        **cloudy** /ˈklaʊdi/ adj. 多云的
                        
                        **sun** /sʌn/ n. 太阳
                        
                        **sunny** /ˈsʌni/ adj. 晴朗的
                        
                        **wind** /wɪnd/ n. 风
                        
                        **windy** /ˈwɪndi/ adj. 多风的
                        
                        **weather** /ˈweðə(r)/ n. 天气
                        
                        **How's the weather?** 天气怎么样？
                        
                        **What's the weather like?** 天气怎么样？
                        
                        **cook** /kʊk/ v. 做饭
                        
                        **bad** /bæd/ adj. 坏的；糟糕的
                        
                        **terrible** /ˈterəbl/ adj. 糟糕的；可怕的
                        
                        **pretty** /ˈprɪti/ adv. 相当；很
                        
                        **hot** /hɒt/ adj. 热的
                        
                        **cold** /kəʊld/ adj. 冷的
                        
                        **cool** /kuːl/ adj. 凉爽的
                        
                        **warm** /wɔːm/ adj. 温暖的
                        
                        **visit** /ˈvɪzɪt/ v. 访问；拜访
                        
                        **vacation** /veɪˈkeɪʃn/ n. 假期
                        
                        **on vacation** 在度假
                        
                        **postcard** /ˈpəʊstkɑːd/ n. 明信片
                        
                        **photo** /ˈfəʊtəʊ/ n. 照片
                        
                        **take a photo** 拍照
                        
                        **beach** /biːtʃ/ n. 海滩
                        
                        **group** /ɡruːp/ n. 组；群
                        
                        **surprise** /səˈpraɪz/ n. 惊奇；惊讶
                        
                        **to one's surprise** 令某人惊讶的是
                        
                        **relaxed** /rɪˈlækst/ adj. 放松的
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法：询问天气的句型转换
                        1. `How is the weather?`
                        2. `What is the weather like?`
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u3", "Unit 3", "Appearance",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 人物外貌特征。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **short** /ʃɔːt/ adj. 短的；矮的
                        
                        **tall** /tɔːl/ adj. 高的
                        
                        **height** /haɪt/ n. 高度
                        
                        **of medium height** 中等身高
                        
                        **thin** /θɪn/ adj. 瘦的
                        
                        **heavy** /ˈhevi/ adj. 重的
                        
                        **build** /build/ n. 体格；身材
                        
                        **of medium build** 中等身材
                        
                        **hair** /heə(r)/ n. 头发
                        
                        **straight** /streɪt/ adj. 直的
                        
                        **curly** /ˈkɜːli/ adj. 卷曲的
                        
                        **long** /lɒŋ/ adj. 长的
                        
                        **blonde** /blɒnd/ adj. 金黄色的
                        
                        **brown** /braʊn/ adj. 棕色的
                        
                        **glasses** /ˈɡlɑːsɪz/ n. 眼镜
                        
                        **wear glasses** 戴眼镜
                        
                        **look like** 看起来像
                        
                        **actor** /ˈæktə(r)/ n. 演员
                        
                        **actress** /ˈæktrəs/ n. 女演员
                        
                        **person** /ˈpɜːsn/ n. 人
                        
                        **nose** /nəʊz/ n. 鼻子
                        
                        **mouth** /mʌʊθ/ n. 嘴
                        
                        **eye** /aɪ/ n. 眼睛
                        
                        **face** /feɪs/ n. 脸
                        
                        **singer** /ˈsɪŋə(r)/ n. 歌手
                        
                        **artist** /ˈɑːtɪst/ n. 艺术家
                        
                        **handsome** /ˈhænsəm/ adj. 英俊的
                        
                        **beautiful** /ˈbjuːtɪfl/ adj. 美丽的
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：描述外貌的 be 与 have
                        1. **be 动词**：描述身高、体格。
                        2. **have / has**：描述发型、五官。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u4", "Unit 4", "Food and Health",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 饮食习惯与健康。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **noodle** /ˈnuːdl/ n. 面条
                        
                        **mutton** /ˈmʌtn/ n. 羊肉
                        
                        **beef** /biːf/ n. 牛肉
                        
                        **cabbage** /ˈkæbɪdʒ/ n. 卷心菜
                        
                        **potato** /pəˈteɪtəʊ/ n. 土豆
                        
                        **tomato** /təˈmɑːtəʊ/ n. 西红柿
                        
                        **special** /ˈspeʃl/ n. 特色菜 adj. 特别的
                        
                        **size** /saɪz/ n. 尺寸；大小
                        
                        **bowl** /bəʊl/ n. 碗
                        
                        **a bowl of** 一碗……
                        
                        **large** /lɑːdʒ/ adj. 大号的
                        
                        **medium** /ˈmiːdiəm/ adj. 中号的
                        
                        **small** /smɔːl/ adj. 小号的
                        
                        **order** /ˈɔːdə(r)/ n. & v. 点菜；订购
                        
                        **take one's order** 点菜
                        
                        **tofu** /ˈtəʊfuː/ n. 豆腐
                        
                        **pancake** /ˈpænkeɪk/ n. 薄饼
                        
                        **juice** /dʒuːs/ n. 果汁
                        
                        **porridge** /ˈpɒrɪdʒ/ n. 粥
                        
                        **tea** /tiː/ n. 茶
                        
                        **dumpling** /ˈdʌmplɪŋ/ n. 饺子
                        
                        **rice** /raɪs/ n. 米饭
                        
                        **fish** /fɪʃ/ n. 鱼
                        
                        **meat** /miːt/ n. 肉
                        
                        **vegetable** /ˈvedʒtəbl/ n. 蔬菜
                        
                        **fruit** /fruːt/ n. 水果
                        
                        **answer** /ˈɑːnsə(r)/ v. 回答
                        
                        **different** /ˈdɪfrənt/ adj. 不同的
                        
                        **birthday** /ˈɜːθdeɪ/ n. 生日
                        
                        **cake** /keɪk/ n. 蛋糕
                        
                        **candle** /ˈkændl/ n. 蜡烛
                        
                        **blow** /bləʊ/ v. 吹
                        
                        **wish** /wɪʃ/ n. 愿望
                        
                        **make a wish** 许愿
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：would like 的用法
                        1. `would like sth.` 想要某物。
                        2. `would like to do sth.` 想要做某事。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u5", "Unit 5", "School Trip",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 过往经历（郊游）。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **went** /went/ v. (go的过去式) 去
                        
                        **farm** /fɑːm/ n. 农场
                        
                        **farmer** /ˈfɑːmə(r)/ n. 农民
                        
                        **show** /ʃəʊ/ v. 表演；展示
                        
                        **show sb. around** 带某人参观
                        
                        **anything** /ˈeniθɪŋ/ pron. 任何事
                        
                        **saw** /sɔː/ v. (see的过去式) 看见
                        
                        **cow** /kaʊ/ n. 奶牛
                        
                        **milk** /mɪlk/ v. 挤奶
                        
                        **milk a cow** 给奶牛挤奶
                        
                        **horse** /hɔːs/ n. 马
                        
                        **ride a horse** 骑马
                        
                        **feed** /fiːd/ v. 喂养
                        
                        **feed chickens** 喂鸡
                        
                        **expensive** /ɪkˈspensɪv/ adj. 昂贵的
                        
                        **cheap** /tʃiːp/ adj. 便宜的
                        
                        **fast** /fɑːst/ adj. 快的
                        
                        **slow** /sləʊ/ adj. 慢的
                        
                        **exciting** /ɪkˈsaɪtɪŋ/ adj. 令人兴奋的
                        
                        **lovely** /ˈlʌvli/ adj. 可爱的
                        
                        **museum** /mjuˈziːəm/ n. 博物馆
                        
                        **gift** /ɡɪft/ n. 礼物
                        
                        **gift shop** 礼品店
                        
                        **all in all** 总的来说
                        
                        **everything** /ˈevriθɪŋ/ pron. 所有事物
                        
                        **robot** /ˈrəʊbɒt/ n. 机器人
                        
                        **guide** /ɡaɪd/ n. 导游
                        
                        **yesterday** /ˈjestədeɪ/ n. & adv. 昨天
                        
                        **flower** /ˈflaʊə(r)/ n. 花
                        
                        **pick** /pɪk/ v. 采；摘
                        
                        **sun** /sʌn/ n. 太阳
                        
                        **worry** /ˈwʌri/ v. 担心
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：一般过去时 (Simple Past Tense)
                        **1. be 动词**：was/were。
                        **2. 实义动词**：规则动词加 -ed。
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u6", "Unit 6", "Unforgettable Weekend",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **stay** /steɪ/ v. 停留；待
                        
                        **stay up late** 熬夜
                        
                        **practice** /ˈpræktɪs/ v. & n. 练习
                        
                        **competition** /ˌkɒmpəˈtɪʃn/ n. 比赛；竞争
                        
                        **win** /wɪn/ v. 赢得
                        
                        **won** /wʌn/ v. (win的过去式) 赢
                        
                        **prize** /praɪz/ n. 奖品；奖赏
                        
                        **nature** /ˈneɪtʃə(r)/ n. 自然
                        
                        **camping** /ˈkæmpɪŋ/ n. 露营
                        
                        **go camping** 去露营
                        
                        **lake** /leɪk/ n. 湖
                        
                        **beach** /biːtʃ/ n. 海滩
                        
                        **badminton** /ˈbædmɪntən/ n. 羽毛球
                        
                        **sheep** /ʃiːp/ n. 绵羊
                        
                        **butterfly** /ˈbʌtəflaɪ/ n. 蝴蝶
                        
                        **visitor** /ˈvɪzɪtə(r)/ n. 游客；访问者
                        
                        **mouse** /maʊs/ n. 老鼠
                        
                        **mice** /maɪs/ n. (mouse的复数) 老鼠
                        
                        **baby** /ˈbeɪbi/ n. 婴儿
                        
                        **shout** /ʃaʊt/ v. 呼喊；叫嚷
                        
                        **shout at** 对……大声叫嚷
                        
                        **shout to** 对……大声喊
                        
                        **jump** /dʒʌmp/ v. 跳跃
                        
                        **jump up and down** 上下跳跃
                        
                        **scary** /ˈskeəri/ adj. 吓人的
                        
                        **snake** /sneɪk/ n. 蛇
                        
                        **forest** /ˈfɒrɪst/ n. 森林
                        
                        **wake** /weɪk/ v. 醒来
                        
                        **wake up** 醒来
                        
                        **into** /ˈɪntə/ prep. 到……里面
                        
                        **moon** /muːn/ n. 月亮
                        
                        **amazed** /əˈmeɪzd/ adj. 惊奇的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u7", "Unit 7", "Around the World",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **world** /wɜːld/ n. 世界
                        
                        **around the world** 全世界
                        
                        **country** /ˈkʌntri/ n. 国家
                        
                        **Canada** /ˈkænədə/ n. 加拿大
                        
                        **France** /frɑːns/ n. 法国
                        
                        **Japan** /dʒəˈpæn/ n. 日本
                        
                        **USA** 美国
                        
                        **UK** 英国
                        
                        **language** /ˈlæŋɡwɪdʒ/ n. 语言
                        
                        **capital** /ˈkæpɪtl/ n. 首都；省会
                        
                        **tower** /ˈtaʊə(r)/ n. 塔
                        
                        **mountain** /ˈmaʊntən/ n. 山
                        
                        **vacation** /veɪˈkeɪʃn/ n. 假期
                        
                        **summer** /ˈsʌmə(r)/ n. 夏天
                        
                        **winter** /ˈwɪntə(r)/ n. 冬天
                        
                        **spring** /sprɪŋ/ n. 春天
                        
                        **autumn** /ˈɔːtəm/ n. 秋天
                        
                        **palace** /ˈpæləs/ n. 宫殿
                        
                        **museum** /mjuˈziːəm/ n. 博物馆
                        
                        **flag** /flæɡ/ n. 旗帜
                        
                        **symbol** /ˈsɪmbl/ n. 象征
                        
                        **map** /mæp/ n. 地图
                        
                        **passport** /ˈpɑːspɔːt/ n. 护照
                        
                        **famous** /ˈfeɪməs/ adj. 著名的
                        
                        **interesting** /ˈɪntrestɪŋ/ adj. 有趣的
                        
                        **different** /ˈdɪfrənt/ adj. 不同的
                        
                        **traditional** /trəˈdɪʃənl/ adj. 传统的
                        
                        **food** /fuːd/ n. 食物
                        
                        **wish** /wɪʃ/ v. & n. 愿望
                        
                        **hope** /həʊp/ v. & n. 希望
                    """.trimIndent())
                )
            )
        )
    )
}
