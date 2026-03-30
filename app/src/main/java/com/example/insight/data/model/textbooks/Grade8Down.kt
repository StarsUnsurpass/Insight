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
                "g8down_u1", "Unit 1", "Time to Relax",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        ### 1. 核心语境
                        *   **主题语境**：人与自我 —— 健康生活、突发事件与应急处理。
                        *   **深层意义**：本单元不仅要求学生掌握描述病痛的词汇，更强调急救常识（First Aid）和面对困难时的勇气。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **matter** /ˈmætə(r)/ n. 问题；事情
                        
                        **What's the matter?** 怎么了？出什么事了？
                        
                        **sore** /sɔː(r)/ adj. 疼痛的；酸痛的
                        
                        **cold** /kəʊld/ n. 感冒；伤风
                        
                        **have a cold** 感冒
                        
                        **stomachache** /ˈstʌməkeɪk/ n. 胃痛；腹痛
                        
                        **have a stomachache** 胃痛
                        
                        **foot** /fʊt/ n. 足；脚
                        
                        **neck** /nek/ n. 颈；脖子
                        
                        **stomach** /ˈstʌmək/ n. 胃；腹部
                        
                        **throat** /θrəʊt/ n. 咽喉；喉咙
                        
                        **fever** /ˈfiːvə(r)/ n. 发烧
                        
                        **lie** /laɪ/ v. 躺；平躺
                        
                        **lie down** 躺下
                        
                        **rest** /rest/ v. & n. 放松；休息
                        
                        **cough** /kɒf/ v. 咳嗽
                        
                        **X-ray** /ˈeks reɪ/ n. X射线；X光
                        
                        **toothache** /ˈtuːθeɪk/ n. 牙痛
                        
                        **temperature** /ˈtemprətʃə(r)/ n. 温度；体温
                        
                        **take one's temperature** 量体温
                        
                        **headache** /ˈhedeɪk/ n. 头痛
                        
                        **have a fever** 发烧
                        
                        **break** /breɪk/ n. 间歇；休息
                        
                        **take breaks** 休息
                        
                        **hurt** /hɜːt/ v. （使）疼痛；受伤
                        
                        **passenger** /ˈpæsɪndʒə(r)/ n. 乘客；旅客
                        
                        **off** /ɒf/ adv. & prep. 离开；不工作
                        
                        **get off** 下车
                        
                        **surprise** /səˈpraɪz/ n. 惊奇；惊讶
                        
                        **to one's surprise** 使……惊讶的是
                        
                        **onto** /ˈɒntə/ prep. 向；朝
                        
                        **trouble** /ˈtrʌbl/ n. 问题；苦恼
                        
                        **hit** /hɪt/ v. 击；打
                        
                        **right away** 立即；马上
                        
                        **get into** 陷入；参与
                        
                        **herself** /hɜːˈself/ pron. 她自己
                        
                        **bandage** /ˈbændɪdʒ/ n. 绷带 v. 用绷带包扎
                        
                        **sick** /sɪk/ adj. 生病的；有病的
                        
                        **knee** /niː/ n. 膝盖；膝
                        
                        **nosebleed** /ˈnəʊzbliːd/ n. 鼻出血
                        
                        **breathe** /briːð/ v. 呼吸
                        
                        **sunburned** /ˈsʌnbɜːnd/ adj. 晒伤的
                        
                        **ourselves** /ˌaʊəˈselvz/ pron. 我们自己
                        
                        **climber** /ˈklaɪmə(r)/ n. 登山者
                        
                        **be used to** 习惯于……
                        
                        **risk** /rɪsk/ n. & v. 危险；风险
                        
                        **take risks** 冒险
                        
                        **accident** /ˈæksɪdənt/ n. 事故；意外遭遇
                        
                        **situation** /ˌsɪtʃuˈeɪʃn/ n. 情况；状况
                        
                        **kilo** /ˈkiːləʊ/ n. 千克；公斤
                        
                        **rock** /rɒk/ n. 岩石
                        
                        **run out (of)** /rʌn aʊt/ 用尽；耗尽
                        
                        **knife** /naɪf/ n. 刀
                        
                        **cut off** 切除
                        
                        **blood** /blʌd/ n. 血
                        
                        **mean** /miːn/ v. 意思是；打算
                        
                        **get out of** 离开；从……出来
                        
                        **importance** /ɪmˈpɔːtns/ n. 重要性
                        
                        **decision** /dɪˈsɪʒn/ n. 决定；抉择
                        
                        **control** /kənˈtrəʊl/ n. & v. 限制；管理
                        
                        **be in control of** 掌管；管理
                        
                        **spirit** /ˈspɪrɪt/ n. 勇气；意志
                        
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
                "g8down_u2", "Unit 2", "Stay Healthy",
                listOf(
                    UnitDetailSection("🌍 单元主题深度透视", """
                        *   **主题语境**：人与社会 —— 志愿服务。
                    """.trimIndent()),
                    UnitDetailSection("📖 课本同步单词表", """
                        **clean up** 打扫（或清除）干净
                        
                        **cheer up** （使）变得更高兴
                        
                        **give out** 分发；散发
                        
                        **volunteer** /ˌvɒlənˈtɪə(r)/ v. 自愿 n. 志愿者
                        
                        **sign** /saɪn/ n. 标志；信号
                        
                        **notice** /ˈnəʊtɪs/ n. 通知；公告
                        
                        **lonely** /ˈləʊnli/ adj. 孤独的；寂寞的
                        
                        **used to** 曾经；过去
                        
                        **cheer** /tʃɪə(r)/ v. 欢呼；喝彩
                        
                        **give up** 放弃
                        
                        **several** /ˈsevrəl/ adj. 几个；数个
                        
                        **feeling** /ˈfiːlɪŋ/ n. 感觉；感触
                        
                        **satisfaction** /ˌsætɪsˈfækʃn/ n. 满意；满足
                        
                        **joy** /dʒɔɪ/ n. 快乐；喜悦
                        
                        **owner** /ˈəʊnə(r)/ n. 物主；主人
                        
                        **journey** /ˈdʒɜːni/ n. 旅行；旅程
                        
                        **raise** /reɪz/ v. 筹集；提升
                        
                        **midnight** /ˈmaɪdnaɪt/ n. 子夜；午夜
                        
                        **alone** /əˈləʊn/ adv. 独自；单独
                        
                        **repair** /rɪˈpeə(r)/ v. 修理；修补
                        
                        **fix** /fɪks/ v. 修理；安装
                        
                        **wheel** /wiːl/ n. 轮子；车轮
                        
                        **letter** /ˈletə(r)/ n. 信；字母
                        
                        **blind** /blaɪnd/ adj. 瞎的；失明的
                        
                        **deaf** /dlaɪf/ adj. 聋的
                        
                        **imagine** /ˈmædʒɪn/ v. 想象；设想
                        
                        **difficulty** /ˈdɪfɪkəlti/ n. 困难；难题
                        
                        **open** /ˈəʊpən/ v. 开；打开
                        
                        **door** /dɔː(r)/ n. 门
                        
                        **carry** /ˈkæri/ v. 拿；提；扛
                        
                        **train** /treɪn/ v. 训练；培训
                        
                        **excited** /ɪkˈsaɪtɪd/ adj. 激动的；兴奋的
                        
                        **training** /ˈtreɪnɪŋ/ n. 训练；培训
                        
                        **kindness** /ˈkaɪndnəs/ n. 仁慈；善良
                        
                        **clever** /ˈklevə(r)/ adj. 聪明的；机灵的
                        
                        **understand** /ˌʌndəˈstænd/ v. 理解；懂
                        
                        **change** /tʃeɪndʒ/ v. & n. 改变；变化
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u3", "Unit 3", "Could you please clean your room?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **rubbish** /ˈrʌbɪʃ/ n. 垃圾；废物
                        
                        **take out the rubbish** 倒垃圾
                        
                        **fold** /fəʊld/ v. 折叠；对折
                        
                        **sweep** /swiːp/ v. 扫；打扫
                        
                        **floor** /swiːp/ n. 地板
                        
                        **mess** /mes/ n. 杂乱；脏乱
                        
                        **throw** /θrəʊ/ v. 扔；投
                        
                        **all the time** 频繁；反复
                        
                        **neither** /ˈnaɪðə(r)/ adv. 也不
                        
                        **shirt** /ʃɜːt/ n. 衬衫
                        
                        **as soon as** 一……就……
                        
                        **pass** /pɑːs/ v. 给；递
                        
                        **borrow** /ˈbɒrəʊ/ v. 借；借用
                        
                        **lend** /ˈlend/ v. 借给；借出
                        
                        **finger** /ˈfɪŋɡə(r)/ n. 手指
                        
                        **hate** /heɪt/ v. 憎恶；讨厌
                        
                        **while** /waɪl/ conj. 与……同时
                        
                        **snack** /snæk/ n. 点心；小吃
                        
                        **anyway** /ˈeɪniweɪ/ adv. 而且；加之
                        
                        **develop** /dɪˈveləp/ v. 发展；壮大
                        
                        **independence** /ˌɪndɪˈpendəns/ n. 独立
                        
                        **independent** /ˌɪndɪˈpendənt/ adj. 独立的
                        
                        **fall** /fɔːl/ v. 落下；跌落
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
                        
                        **look through** 快速查看；浏览
                        
                        **guess** /ɡes/ v. 猜测；估计
                        
                        **deal** /diːl/ n. 协议；交易
                        
                        **big deal** 重要的事
                        
                        **work out** 成功地发展；解决
                        
                        **get on with** 和睦相处；关系良好
                        
                        **relation** /rɪˈleɪʃn/ n. 关系；联系
                        
                        **communication** /kəˌmjuːnɪˈkeɪʃn/ n. 交流；沟通
                        
                        **argue** /ˈɑːɡjuː/ v. 争吵；争论
                        
                        **cloud** /klaʊd/ n. 云；云朵
                        
                        **elder** /ˈeldə(r)/ adj. 年记较长的
                        
                        **instead** /ɪnˈsted/ adv. 代替；反而
                        
                        **whatever** /wɒtˈevə(r)/ pron. 任何；无论什么
                        
                        **nervous** /ˈnɜːvəs/ adj. 紧张不安的
                        
                        **offer** /ˈɒfə(r)/ v. 主动提出；自愿给予
                        
                        **proper** /ˈprəʊpə(r)/ adj. 正确的；恰当的
                        
                        **secondly** /ˈsekəndli/ adv. 第二；其次
                        
                        **explain** /ɪkˈspleɪn/ v. 解释；说明
                        
                        **clear** /ˈklɪə(r)/ adj. 清晰的；清楚的
                        
                        **copy** /ˈkɒpi/ v. 复制；复印
                        
                        **return** /rɪˈtɜːn/ v. 回来；返回
                        
                        **pressure** /ˈpreʃə(r)/ n. 压力
                        
                        **compete** /kəmˈpiːt/ v. 竞争；对抗
                        
                        **opinion** /əˈpɪnjən/ n. 意见；想法
                        
                        **skill** /skɪl/ n. 技能；技巧
                        
                        **typical** /ˈtɪpɪkl/ adj. 典型的
                        
                        **football** /ˈfʊtbɔːl/ n. 足球
                        
                        **cut out** 删去；删除
                        
                        **quick** /kwɪk/ adj. 快的；迅速的
                        
                        **continue** /kənˈtɪnjuː/ v. 继续；连续
                        
                        **compare** /kəmˈpeə(r)/ v. 比较
                        
                        **crazy** /ˈkreɪzi/ adj. 不理智的；疯狂的
                        
                        **push** /pʊʃ/ v. 推动；督促
                        
                        **development** /dɪˈveləpmənt/ n. 发展；发育
                        
                        **cause** /kɔːz/ v. 造成；引起
                        
                        **usual** /ˈjuːʒuəl/ adj. 通常的
                        
                        **in one's opinion** 依某人看来
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u5", "Unit 5", "What were you doing when the rainstorm came?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **rainstorm** /ˈreɪnstɔːm/ n. 暴风雨
                        
                        **alarm** /əˈlɑːm/ n. 闹钟
                        
                        **go off** （闹钟）发出响声
                        
                        **begin** /bɪˈɡɪn/ v. 开始
                        
                        **heavily** /ˈhevɪli/ adv. 在很大程度上；大量地
                        
                        **suddenly** /ˈsʌdənli/ adv. 突然；骤然
                        
                        **pick up** 接电话
                        
                        **strange** /ˈstreɪndʒ/ adj. 奇特的；奇怪的
                        
                        **storm** /stɔːm/ n. 风暴；暴风雨
                        
                        **wind** /wɪnd/ n. 风
                        
                        **light** /laɪt/ n. 光；光线；灯
                        
                        **report** /rɪˈpɔːt/ v. & n. 报道；报告
                        
                        **area** /ˈeəriə/ n. 地域；地区
                        
                        **wood** /wʊd/ n. 木头；木材
                        
                        **window** /ˈwɪndəʊ/ n. 窗户
                        
                        **flashlight** /ˈflaʃlaɪt/ n. 手电筒
                        
                        **match** /matʃ/ n. 火柴
                        
                        **beat** /biːt/ v. 敲打；打败
                        
                        **against** /əˈɡenst/ prep. 倚；碰；撞
                        
                        **asleep** /əˈsliːp/ adj. 睡着的
                        
                        **fall asleep** 进入梦乡；睡着
                        
                        **die down** 逐渐变弱；逐渐消失
                        
                        **rise** /raɪz/ v. 升起；增加
                        
                        **apart** /əˈpɑːt/ adv. 分离；隔开
                        
                        **fallen** /ˈfɔːlən/ adj. 倒下的；落下的
                        
                        **icy** /ˈaɪsi/ adj. 冰冷的；结冰的
                        
                        **kid** /kɪd/ v. 开玩笑；欺骗
                        
                        **realize** /ˈriːəlaɪz/ v. 理解；领会
                        
                        **passage** /ˈpasɪdʒ/ n. 章节；段落
                        
                        **pupil** /ˈpjuːpɪl/ n. 学生
                        
                        **completely** /ˈriːəlaɪz/ adv. 彻底地；完全地
                        
                        **shocked** /ʃɒkt/ adj. 震惊的
                        
                        **silence** /ˈsaɪləns/ n. 沉默；无声
                        
                        **in silence** 沉默地
                        
                        **recently** /ˈsiːsntli/ adv. 最近；近来
                        
                        **take down** 拆除；记录
                        
                        **terrorist** /ˈterərɪst/ n. 恐怖分子
                        
                        **date** /deɪt/ n. 日期；日子
                        
                        **tower** /ˈtaʊə(r)/ n. 塔；塔楼
                        
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
                "g8down_u6", "Unit 6", "An old man tried to move the mountains.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **shoot** /ʃuːt/ v. 射击；发射
                        
                        **stone** /stəʊn/ n. 石头
                        
                        **weak** /wiːk/ adj. 虚弱的；无力的
                        
                        **god** /ɡɒd/ n. 神；上帝
                        
                        **remind** /rɪˈmaɪnd/ v. 提醒；使想起
                        
                        **bit** /bɪt/ n. 一点；小块
                        
                        **a little bit** 有点儿
                        
                        **silly** /ˈsɪli/ adj. 愚蠢的；傻的
                        
                        **instead of** 代替；反而
                        
                        **turn...into** 变成
                        
                        **object** /əbˈdʒekt/ n. 物体；物品
                        
                        **hide** /haɪd/ v. 隐藏；隐蔽
                        
                        **tail** /haɪd/ n. 尾巴
                        
                        **magic** /ˈmadʒɪk/ adj. 有魔力的
                        
                        **stick** /stɪk/ n. 棍；棒
                        
                        **excite** /ɪkˈsaɪt/ v. 使激动；使兴奋
                        
                        **Western** /ˈwestən/ adj. 西方的
                        
                        **once upon a time** 从前
                        
                        **stepsister** /ˈstepˌsɪstə(r)/ n. 继姐（妹）
                        
                        **prince** /prɪns/ n. 王子
                        
                        **fall in love** 爱上；喜欢上
                        
                        **fit** /fɪt/ v. 适合；合身
                        
                        **couple** /ˈkʌpl/ n. （一）对；（一）双
                        
                        **smile** /smaɪl/ v. & n. 微笑
                        
                        **marry** /smaɪl/ v. 结婚
                        
                        **get married** 结婚
                        
                        **gold** /ɡəʊld/ n. 金子；金币
                        
                        **emperor** /ˈempərə(r)/ n. 皇帝
                        
                        **silk** /sɪlk/ n. 丝绸；丝织物
                        
                        **underwear** /ˈempərə(r)/ n. 内衣
                        
                        **nobody** /ˈnəʊbədi/ pron. 没有人
                        
                        **stupid** /ˈstjuːpɪd/ adj. 愚蠢的
                        
                        **cheat** /tʃiːt/ v. 欺骗；蒙骗
                        
                        **stepmother** /ˈstepˌmʌðə(r)/ n. 继母
                        
                        **wife** /waɪf/ n. 妻子
                        
                        **husband** /ˈhʌzbənd/ n. 丈夫
                        
                        **whole** /həʊl/ adj. 全部的；整体的
                        
                        **scene** /siːn/ n. 舞台；场景
                        
                        **match** /matʃ/ n. 火柴
                        
                        **flame** /fleɪm/ n. 火焰
                        
                        **modern** /ˈmɒdn/ adj. 现代的
                        
                        **as soon as** 一……就……
                        
                        **voice** /vɔɪs/ n. 声音
                        
                        **brave** /breɪv/ adj. 勇敢的；无畏的
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
                        
                        **feel free** 随意（做某事）
                        
                        **tour** /tʊə(r)/ n. & v. 旅行；观光
                        
                        **tourist** /ˈtʊərɪst/ n. 旅行者；观光者
                        
                        **Wall** /wɔːl/ n. 墙
                        
                        **amazing** /əˈmeɪzɪŋ/ adj. 令人惊奇的
                        
                        **ancient** /əˈmeɪzɪŋ/ adj. 古老的；古代的
                        
                        **protect** /prəˈtekt/ v. 保护；保卫
                        
                        **wide** /waɪd/ adj. 宽的；阔的
                        
                        **as far as I know** 就我所知
                        
                        **achievement** /əˈtʃiːvmənt/ n. 成就；成绩
                        
                        **southwestern** /saʊθˈwestən/ adj. 西南的
                        
                        **thick** /θɪk/ adj. 厚的；浓的
                        
                        **include** /ɪnˈkluːd/ v. 包括；包含
                        
                        **freezing** /ˈfriːzɪŋ/ adj. 极冷的；冰冻的
                        
                        **condition** /kənˈdɪʃn/ n. 条件；状况
                        
                        **take in** 吸入；吞入
                        
                        **succeed** /səkˈsiːd/ v. 实现目标；成功
                        
                        **challenge** /ˈtʃalɪndʒ/ v. & n. 挑战；考验
                        
                        **in the face of** 面对（问题、困难等）
                        
                        **achieve** /əˈtʃiːv/ v. 达到；完成
                        
                        **force** /fɔːs/ n. 力量；武力
                        
                        **nature** /ˈneɪtʃə(r)/ n. 自然界；大自然
                        
                        **even though** 即使；虽然
                        
                        **ocean** /ˈəʊʃn/ n. 大洋；海洋
                        
                        **the Pacific Ocean** 太平洋
                        
                        **centimeter** /ˈsenɪˌmiːtə(r)/ n. 厘米
                        
                        **weigh** /weɪ/ v. 重量是……；称重
                        
                        **birth** /bɜːθ/ n. 出生；诞生
                        
                        **at birth** 出生时
                        
                        **adult** /ˈadʌlt/ adj. 成年的；n. 成人
                        
                        **bamboo** /ˌbamˈbuː/ n. 竹子
                        
                        **endangered** /ɪnˈdeɪndʒəd/ adj. 濒危的
                        
                        **research** /rɪˈsɜːtʃ/ n. & v. 研究；调查
                        
                        **keeper** /rɪˈsɜːtʃ/ n. 饲养员；保管人
                        
                        **awake** /əˈweɪk/ adj. 醒着的
                        
                        **excitement** /ɪkˈsaɪtmənt/ n. 激动；兴奋
                        
                        **walk into** 走路时撞上
                        
                        **fall over** 摔倒
                        
                        **illness** /ˈɪlnəs/ n. 疾病；病
                        
                        **remaining** /rɪˈmeɪnɪŋ/ adj. 遗留的；剩余的
                        
                        **or so** 大约
                        
                        **artwork** /ˈɑːtˌwɜːk/ n. 插图；艺术品
                        
                        **wild** /waɪld/ adj. 野生的
                        
                        **government** /ˈɡʌvnmənt/ n. 政府
                        
                        **whale** /we|l/ n. 鲸
                        
                        **oil** /ɔɪl/ n. 油；石油
                        
                        **protection** /prəˈtekʃn/ n. 保护；保卫
                        
                        **huge** /hjuːd/ adj. 巨大的；极大的
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u8", "Unit 8", "Have you read Treasure Island yet?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **treasure** /ˈtreʒə(r)/ n. 珠宝；财富
                        
                        **island** /ˈtreʒə(r)/ n. 岛
                        
                        **full of** 满是……的
                        
                        **classic** /ˈklasɪk/ n. 经典著作
                        
                        **page** /peɪdʒ/ n. （书页）页
                        
                        **hurry** /ˈhʌri/ v. 匆忙；赶快
                        
                        **hurry up** 赶快；急忙
                        
                        **due** /djuː/ adj. 预期；到期
                        
                        **ship** /ʃɪp/ n. 船
                        
                        **tool** /tuːl/ n. 工具
                        
                        **gun** /ɡʌn/ n. 枪；炮
                        
                        **mark** /mɑːk/ n. 迹象；记号
                        
                        **sand** /sand/ n. 沙；沙滩
                        
                        **cannibal** /ˈkanɪbl/ n. 食人肉者
                        
                        **towards** /təˈwɔːdz/ prep. 朝；向
                        
                        **land** /land/ n. 陆地；大地
                        
                        **fiction** /ˈfɪkʃn/ n. 小说
                        
                        **science fiction** 科幻小说（或影片）
                        
                        **technology** /tekˈnɒlədʒi/ n. 科技；工艺
                        
                        **French** /frentʃ/ n. 法语
                        
                        **pop** /pɒp/ n. 流行音乐
                        
                        **rock** /rɒk/ n. 摇滚乐
                        
                        **band** /band/ n. 乐队
                        
                        **country music** 乡村音乐
                        
                        **forever** /fəˈrevə(r)/ adv. 永远
                        
                        **abroad** /əˈbrɔːd/ adv. 在国外；到国外
                        
                        **fan** /fan/ n. 迷；狂热爱好者
                        
                        **southern** /ˈsʌðən/ adj. 南方的
                        
                        **modern** /ˈmɒdn/ adj. 现代的；当代的
                        
                        **success** /səkˈses/ n. 成功
                        
                        **belong** /bɪˈlɒŋ/ v. 属于；归属
                        
                        **belong to** 属于
                        
                        **laughter** /ˈlaʊftə(r)/ n. 笑；笑声
                        
                        **beauty** /ˈlaʊftə(r)/ n. 美；美丽
                        
                        **record** /ˈrekɔːd/ n. 记录；唱片
                        
                        **introduce** /ɪnˈtrədjuːs/ v. 介绍；引见
                        
                        **line** /laɪn/ n. 排；列；行
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲精练", """
                        ### 核心语法：现在完成时 (I)
                        - *I **have read** Treasure Island.*
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u9", "Unit 9", "Have you ever been to a museum?",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **amusement** /əˈmjuːzmənt/ n. 娱乐；游戏
                        
                        **amusement park** 游乐场
                        
                        **somewhere** /ˈsʌmweə(r)/ adv. 在某处；到某处
                        
                        **camera** /ˈkamərə/ n. 照相机
                        
                        **invention** /ɪnˈvenʃn/ n. 发明；发明物
                        
                        **invent** /ɪnˈvent/ v. 发明；创造
                        
                        **unbelievable** /ˌʌnbɪˈliːvəbl/ adj. 难以置信的
                        
                        **progress** /prəˈɡres/ n. 进步；进展
                        
                        **rapid** /ˈrapɪd/ adj. 迅速的；快速的
                        
                        **unusual** /ʌnˈjuːʒuəl/ adj. 特别的；不寻常的
                        
                        **toilet** /ˈtɔɪlət/ n. 座便器；厕所
                        
                        **encourage** /ɪnˈkʌrɪdʒ/ v. 鼓励
                        
                        **social** /ˈsəʊʃl/ adj. 社会的
                        
                        **peaceful** /ˈpiːsfl/ adj. 和平的；安宁的
                        
                        **tea art** 茶艺
                        
                        **performance** /pəˈfɔːməns/ n. 表演；演出
                        
                        **perfect** /ˈpɜːfɪkt/ adj. 完美的；理想的
                        
                        **tea set** 茶具
                        
                        **itself** /ɪtˈself/ pron. 它自己
                        
                        **collect** /kəˈlekt/ v. 收集；采集
                        
                        **a couple of** 两个；一些
                        
                        **German** /ˈdʒɜːmən/ adj. 德国的；德语的
                        
                        **theme** /θiːm/ n. 主题
                        
                        **ride** /raɪd/ n. 供乘骑的游乐设施
                        
                        **province** /ˈpraʊvɪns/ n. 省份
                        
                        **thousand** /ˈθaʊznd/ num. 一千
                        
                        **thousands of** 数以千计的
                        
                        **on the one hand... on the other hand...** 一方面……另一方面……
                        
                        **safe** /seɪf/ adj. 安全的；无危险的
                        
                        **simply** /ˈʃɪmpli/ adv. 仅仅；只
                        
                        **fear** /fɪə(r)/ v. & n. 害怕；惧怕
                        
                        **whether** /ˈweðə(r)/ conj. 不管……（还是）；是否
                        
                        **Indian** /ˈɪndiən/ adj. 印度的；n. 印度人
                        
                        **Japanese** /ˌdʒapəˈniːz/ adj. 日本的；n. 日本人
                        
                        **fox** /fɒks/ n. 狐狸
                        
                        **all year round** 全年
                        
                        **equator** /ɪˈkweɪtə(r)/ n. 赤道
                        
                        **whenever** /wenˈevə(r)/ conj. 在任何时候
                        
                        **spring** /sprɪŋ/ n. 春天
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g8down_u10", "Unit 10", "I've had this bike for three years.",
                listOf(
                    UnitDetailSection("📖 课本同步单词表", """
                        **yard** /jɑːd/ n. 院子
                        
                        **yard sale** 庭院拍卖会
                        
                        **sweet** /swiːt/ adj. 甜蜜的；甜的
                        
                        **memory** /ˈmeməri/ n. 回忆；记忆
                        
                        **cent** /sent/ n. 分；分币
                        
                        **toy** /tɔɪ/ n. 玩具
                        
                        **bear** /tɔɪ/ n. 熊
                        
                        **maker** /ˈmeɪkə(r)/ n. 生产者；制订者
                        
                        **bread maker** 面包机
                        
                        **scarf** /skɑːf/ n. 围巾；披巾
                        
                        **soft** /sɒft/ adj. 软的；柔软的
                        
                        **soft toy** 软体玩具；布制玩具
                        
                        **check** /tʃek/ v. & n. 检查；审查
                        
                        **check out** 察看；观察
                        
                        **board** /bɔːd/ n. 板；木板
                        
                        **board game** 棋类游戏
                        
                        **junior** /ˈdʒuːniə(r)/ adj. 地位（或等级）较低的
                        
                        **junior high school** 初级中学
                        
                        **clear out** 清理；丢弃
                        
                        **toss** /tɒs/ v. 扔；抛
                        
                        **part with** 舍弃；离别
                        
                        **as for** 至于；关于
                        
                        **honest** /ˈɒnɪst/ adj. 诚实的；正直的
                        
                        **to be honest** 说实在的
                        
                        **while** /waɪl/ n. 一段时间；一会儿
                        
                        **truthful** /ˈtruːθfl/ adj. 诚实的；真实的
                        
                        **hometown** /ˈhəʊmtaʊn/ n. 家乡；故乡
                        
                        **search** /sɜːtʃ/ v. & n. 搜索；查找
                        
                        **among** /əˈmʌŋ/ prep. 在（其）中；之一
                        
                        **crayon** /ˈkreɪən/ n. 彩色蜡笔
                        
                        **shame** /ʃeɪm/ n. 羞耻；遗憾的事
                    """.trimIndent())
                )
            )
        )
    )
}
