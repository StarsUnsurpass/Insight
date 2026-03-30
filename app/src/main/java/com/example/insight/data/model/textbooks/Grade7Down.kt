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
                "g7down_s1", "Starter Unit 1", "Animal Friends",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 常见动物。
                        *   **核心内容**：学习常见农场动物名称及其基础表达。
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
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_s2", "Starter Unit 2", "No Rules, No Order",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 秩序与规则。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **rule** /ruːl/ n. 规则；规章
                        
                        **order** /ˈɔːdə(r)/ n. 顺序；秩序
                        
                        **follow** /ˈfɒləʊ/ v. 遵循；跟随
                        
                        **must** /mʌst/ modal v. 必须
                        
                        **quiet** /ˈkwaɪət/ adj. 安静的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u1", "Unit 1", "Animal Friends",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 保护动物与自然。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
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
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：名词复数的不规则变化
                        - *wolf -> wolves*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u2", "Unit 2", "No Rules, No Order",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 学校与生活规则。
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
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：祈使句与情态动词 must/can
                        - *Don't litter!*
                        - *We must wear the school uniform.*
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
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u4", "Unit 4", "Food and Healthy Diet",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自我 —— 饮食习惯与健康。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **salt** /sɔːlt/ n. 盐
                        
                        **fat** /fæt/ n. 脂肪 adj. 肥胖的
                        
                        **weight** /weɪt/ n. 体重
                        
                        **put on weight** 增加体重
                        
                        **cause** /kɔːz/ v. 造成；导致
                        
                        **balanced** /ˈbælənst/ adj. 均衡的
                        
                        **result** /rɪˈzʌlt/ n. 结果
                        
                        **improve** /ɪmˈpruːv/ v. 改进；改善
                        
                        **habit** /ˈhæbɪt/ n. 习惯
                        
                        **fast food** 快餐
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u5", "Unit 5", "Daily Activities and Festivals",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 日常活动与文化。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **activity** /ækˈtɪvəti/ n. 活动
                        
                        **festival** /ˈfestɪvl/ n. 节日
                        
                        **celebrate** /ˈselɪbreɪt/ v. 庆祝
                        
                        **traditional** /trəˈdɪʃənl/ adj. 传统的
                        
                        **right now** 此刻；现在
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u6", "Unit 6", "Weather and Travel",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与自然 —— 天气描述与旅游计划。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **rain** /reɪn/ v. 下雨 n. 雨
                        
                        **stormy** /ˈstɔːmi/ adj. 有暴风雨的
                        
                        **affect** /əˈfekt/ v. 影响
                        
                        **dry** /draɪ/ adj. 干燥的
                        
                        **lucky** /ˈlʌki/ adj. 幸运的
                        
                        **centre** /ˈsentə(r)/ n. 中心
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7down_u7", "Unit 7", "Social Activities and Explorations",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 社会实践与探索精神。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **explore** /ɪkˈsplɔː(r)/ v. 探索
                        
                        **social** /ˈsəʊʃl/ adj. 社会的
                        
                        **experience** /ɪkˈspɪəriəns/ n. 经验；经历
                        
                        **skill** /skɪl/ n. 技能
                    """.trimIndent())
                )
            )
        )
    )
}
