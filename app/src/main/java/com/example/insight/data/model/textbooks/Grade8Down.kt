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
                "g8down_u1", "Unit 1", "Health and First Aid",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 健康生活、突发事件与应急处理。
                        *   **深层意义**：本单元不仅要求学生掌握描述病痛的词汇，更强调急救常识（First Aid）和面对困难时的勇气。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **matter** /'mætə(r)/ n. 问题；事情
                        **What's the matter?** 怎么了？出什么事了？
                        **sore** /sɔː(r)/ adj. 疼痛的；酸痛的
                        **cold** /kəʊld/ n. 感冒；伤风
                        **have a cold** 感冒
                        **stomachache** /'stʌməkeɪk/ n. 胃痛；腹痛
                        **have a stomachache** 胃痛
                        **foot** /fʊt/ n. 足；脚
                        **neck** /nek/ n. 颈；脖子
                        **stomach** /'stʌmək/ n. 胃；腹部
                        **throat** /θrəʊt/ n. 咽喉；喉咙
                        **fever** /'fiːvə(r)/ n. 发烧
                        **lie** /laɪ/ v. 躺；平躺
                        **lie down** 躺下
                        **rest** /rest/ v. & n. 放松；休息
                        **cough** /kɒf/ v. 咳嗽
                        **X-ray** /'eks reɪ/ n. X射线；X光
                        **toothache** /'tuːθeɪk/ n. 牙痛
                        **temperature** /'temprətʃə(r)/ n. 温度；体温
                        **take one's temperature** 量体温
                        **headache** /'hedeɪk/ n. 头痛
                        **have a fever** 发烧
                        **break** /breɪk/ n. 间歇；休息
                        **take breaks** 休息
                        **hurt** /hɜːt/ v. （使）疼痛；受伤
                        **passenger** /'pæsɪndʒə(r)/ n. 乘客；旅客
                        **off** /ɒf/ adv. & prep. 离开；不工作
                        **get off** 下车
                        **surprise** /sə'praɪz/ n. 惊奇；惊讶
                        **to one's surprise** 使……惊讶的是
                        **onto** /'ɒntə/ prep. 向；朝
                        **trouble** /'trʌbl/ n. 问题；苦恼
                        **hit** /hɪt/ v. 击；打
                        **right away** 立即；马上
                        **get into** 陷入；参与
                        **herself** /hɜː'self/ pron. 她自己
                        **bandage** /'bændɪdʒ/ n. 绷带 v. 用绷带包扎
                        **sick** /sɪk/ adj. 生病的；有病的
                        **knee** /niː/ n. 膝盖；膝
                        **nosebleed** /'nəʊzbliːd/ n. 鼻出血
                        **breathe** /briːð/ v. 呼吸
                        **sunburned** /'sʌnbɜːnd/ adj. 晒伤的
                        **ourselves** /ˌaʊə'selvz/ pron. 我们自己
                        **climber** /'klaɪmə(r)/ n. 登山者
                        **be used to** 习惯于……
                        **risk** /rɪsk/ n. & v. 危险；风险
                        **take risks** 冒险
                        **accident** /'æksɪdənt/ n. 事故；意外遭遇
                        **situation** /ˌsɪtʃu'eɪʃn/ n. 情况；状况
                        **kilo** /'kiːləʊ/ n. 千克；公斤
                        **rock** /rɒk/ n. 岩石
                        **run out (of)** /rʌn aʊt/ 用尽；耗尽
                        **knife** /naɪf/ n. 刀
                        **cut off** 切除
                        **blood** /blʌd/ n. 血
                        **mean** /miːn/ v. 意思是；打算
                        **get out of** 离开；从……出来
                        **importance** /ɪm'pɔːtns/ n. 重要性
                        **decision** /dɪ'sɪʒn/ n. 决定；抉择
                        **control** /kən'trəʊl/ n. & v. 限制；管理
                        **be in control of** 掌管；管理
                        **spirit** /'spɪrɪt/ n. 勇气；意志
                        **death** /deθ/ n. 死；死亡
                        **give up** 放弃
                        **nurse** /nɜːs/ n. 护士
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练 (中考标准)", """
                        ### 核心语法一：情态动词 should 表建议
                        - *You **should** lie down and rest.*
                        
                        ### 核心语法二：反身代词
                        - *I cut **myself**.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u2", "Unit 2", "Volunteering and Responsibility",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 志愿服务。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **clean up** 打扫（或清除）干净
                        **cheer up** （使）变得更高兴
                        **give out** 分发；散发
                        **volunteer** /ˌvɒlən'tɪə(r)/ v. 自愿 n. 志愿者
...
                        **imagine** /ɪ'mædʒɪn/ v. 想象；设想
                        **difficulty** /'dɪfɪkəlti/ n. 困难；难题
                        **open** /'əʊpən/ v. 开；打开
                        **door** /dɔː(r)/ n. 门
                        **carry** /'kæri/ v. 拿；提；扛
                        **train** /treɪn/ v. 训练；培训
                        **excited** /ɪk'saɪtɪd/ adj. 激动的；兴奋的
                        **training** /'treɪnɪŋ/ n. 训练；培训
                        **kindness** /'kaɪndnəs/ n. 仁慈；善良
                        **clever** /'klevə(r)/ adj. 聪明的；机灵的
                        **understand** /ˌʌndə'stænd/ v. 理解；懂
                        **change** /tʃeɪndʒ/ v. & n. 改变；变化
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u3", "Unit 3", "Family Chores",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **rubbish** /'rʌbɪʃ/ n. 垃圾；废物
                        **take out the rubbish** 倒垃圾
...
                        **independent** /ˌɪndɪ'pendənt/ adj. 独立的
                        **fall** /fɔːl/ v. 落下；跌落
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u4", "Unit 4", "Communication and Advice",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **allow** /ə'laʊ/ v. 允许；准许
                        **wrong** /rɒŋ/ adj. 错误的；有毛病的
...
                        **usual** /'juːʒuəl/ adj. 通常的
                        **in one's opinion** 依某人看来
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u5", "Unit 5", "Memorable Events",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **rainstorm** /'reɪnstɔːm/ n. 暴风雨
                        **alarm** /ə'lɑːm/ n. 闹钟
...
                        **at first** 首先；最初
                        **truth** /truːθ/ n. 实情；事实
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：过去进行时
                        - *I **was doing** my homework when the rainstorm came.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u6", "Unit 6", "Stories and Legends",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **shoot** /ʃuːt/ v. 射击；发射
...
                        **voice** /vɔɪs/ n. 声音
                        **brave** /breɪv/ adj. 勇敢的；无畏的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u7", "Unit 7", "Nature and Geography",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **square** /skweə(r)/ n. 平方；正方形
...
                        **huge** /hjuːd/ adj. 巨大的；极大的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u8", "Unit 8", "Literature and Music",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **treasure** /'treʒə(r)/ n. 珠宝；财富
...
                        **line** /laɪn/ n. 排；列；行
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：现在完成时 (I)
                        - *I **have read** Treasure Island.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u9", "Unit 9", "Experience and Progress",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **amusement** /ə'mjuːzmənt/ n. 娱乐；游戏
...
                        **spring** /sprɪŋ/ n. 春天
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u10", "Unit 10", "Memories and Hometown",
                listOf(
                    UnitDetailSection("📖 课本同步单词表 (完全一致)", """
                        **yard** /jɑːd/ n. 院子
...
                        **shame** /ʃeɪm/ n. 羞耻；遗憾的事
                    """.trimIndent())
                )
            )
        )
    )
}
