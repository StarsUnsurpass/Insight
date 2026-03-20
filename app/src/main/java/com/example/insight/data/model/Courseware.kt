package com.example.insight.data.model

import androidx.compose.ui.graphics.Color

data class Courseware(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val themeColor: Color,
    val slides: List<Slide>,
    val style: CoursewareStyle = CoursewareStyle.MODERN,
    val author: String = "Admin",
    val lastModified: Long = System.currentTimeMillis()
)

data class Slide(
    val id: String,
    val title: String,
    val content: String,
    val subContent: String = "",
    val visualHint: String = "",
    val interactionType: InteractionType = InteractionType.NONE,
    val options: List<String> = emptyList(),
    val correctAnswer: String = "",
    val layoutType: SlideLayoutType = SlideLayoutType.CENTERED,
    val animationType: SlideAnimationType = SlideAnimationType.FADE,
    val backgroundType: SlideBackgroundType = SlideBackgroundType.SOLID
)

enum class CoursewareStyle {
    MODERN,      // 现代极简
    DETECTIVE,   // 悬疑侦探
    PAPER,       // 复古纸张
    TECH,        // 科技感
    WATERCOLOR,  // 清新水彩
    GAME         // 趣味游戏
}

enum class SlideLayoutType {
    CENTERED,    // 居中布局
    SPLIT_LR,    // 左右分割
    SPLIT_TB,    // 上下分割
    GRID,        // 九宫格/四宫格
    TIMELINE     // 时间轴布局
}

enum class SlideAnimationType {
    FADE,
    SLIDE,
    ZOOM,
    BOUNCE
}

enum class SlideBackgroundType {
    SOLID,
    GRADIENT,
    MESH,
    IMAGE_OVERLAY
}

enum class InteractionType {
    NONE,
    CLICK_TO_REVEAL,
    FLIP_CARD,
    FILL_IN_BLANK,
    MULTIPLE_CHOICE,
    DRAG_AND_DROP,
    VOICE_INPUT,     // 新增：语音输入
    SKETCH_BOARD     // 新增：绘图/涂鸦
}

val sampleCoursewares = listOf(
    Courseware(
        id = "grammar_present_perfect",
        title = "时间旅行者：现在完成时 vs 一般过去时",
        description = "探秘时态的魔法，解决初中生最头疼的时态混淆问题。",
        category = "语法突破",
        themeColor = Color(0xFF6200EE),
        style = CoursewareStyle.PAPER,
        slides = listOf(
            Slide(
                id = "s1",
                title = "Have you ever traveled through time?",
                content = "探秘时态的魔法。",
                visualHint = "一条跨越屏幕的巨大时间轴，左边是黑白的过去，右边是彩色的现在。",
                layoutType = SlideLayoutType.TIMELINE
            ),
            Slide(
                id = "s2",
                title = "核心概念降维",
                content = "一般过去时 = 关在盒子里的过去（与现在无关）",
                subContent = "现在完成时 = 延伸到现在的桥梁（对现在有影响）",
                visualHint = "左右分栏布局。",
                layoutType = SlideLayoutType.SPLIT_LR
            ),
            Slide(
                id = "s3",
                title = "标志词捕鼠器",
                content = "点击翻转出它所属的时态和例句。",
                interactionType = InteractionType.FLIP_CARD,
                options = listOf("yesterday", "just", "already", "last year"),
                layoutType = SlideLayoutType.GRID
            ),
            Slide(
                id = "s4",
                title = "实战演练",
                content = "I _______ (lose) my keys yesterday. vs I _______ (lose) my keys, so I can't open the door now.",
                interactionType = InteractionType.FILL_IN_BLANK,
                correctAnswer = "lost, have lost"
            )
        )
    ),
    Courseware(
        id = "reading_past_continuous",
        title = "贝克街的迷雾：过去进行时探秘",
        description = "侦探悬疑剧本杀，语法与阅读深度结合。",
        category = "阅读精讲",
        themeColor = Color(0xFF03DAC5),
        style = CoursewareStyle.DETECTIVE,
        slides = listOf(
            Slide(
                id = "s1",
                title = "The Mysterious Disappearance",
                content = "案发时间：昨晚 8:00。",
                visualHint = "悬疑风格暗色调插图，图中人物被绑架，周围散落着怀表、咖啡杯等线索。",
                backgroundType = SlideBackgroundType.IMAGE_OVERLAY
            ),
            Slide(
                id = "s2",
                title = "嫌疑人供词",
                content = "Mr. Green: 'I was watching TV at 8:00 PM.'\nMrs. White: 'I was reading a book when the lights went out.'",
                subContent = "核心句型：was/were + doing (表示过去某一时刻正在发生的动作)。",
                visualHint = "三个嫌疑人的头像和对话气泡。",
                layoutType = SlideLayoutType.SPLIT_LR
            ),
            Slide(
                id = "s3",
                title = "线索剖析",
                content = "分析主句与 when/while 引导的时间状语从句的关系。",
                visualHint = "提取超长破案线索句，使用不同颜色的下划线拆解主谓宾。"
            ),
            Slide(
                id = "s4",
                title = "案情推理结案",
                content = "根据语法线索和阅读理解，选出真正的凶手。",
                interactionType = InteractionType.MULTIPLE_CHOICE,
                options = listOf("Mr. Green", "Mrs. White", "The Butler"),
                correctAnswer = "The Butler"
            )
        )
    ),
    Courseware(
        id = "vocab_uncountable_nouns",
        title = "舌尖上的英伦：不可数名词的量化",
        description = "生活化的美食文化，攻克枯燥词法。",
        category = "趣味拓展",
        themeColor = Color(0xFFFF9800),
        style = CoursewareStyle.WATERCOLOR,
        slides = listOf(
            Slide(
                id = "s1",
                title = "A Taste of Britain",
                content = "如何优雅地点一份下午茶？",
                visualHint = "精致的英式下午茶餐桌俯视图（红茶、司康饼、牛奶、方糖）。"
            ),
            Slide(
                id = "s2",
                title = "物质名词可视化",
                content = "为什么 water, milk, sugar 是不可数名词？",
                subContent = "你无法数清一滴水。",
                visualHint = "液体和粉末状物品的动画（水倒入杯中）。"
            ),
            Slide(
                id = "s3",
                title = "量词的魔法搭配",
                content = "如何用可数的容器来量化不可数的物质？",
                interactionType = InteractionType.DRAG_AND_DROP,
                options = listOf("a cup of", "a piece of", "a slice of"),
                subContent = "tea, bread, cheese"
            )
        )
    ),
    Courseware(
        id = "oral_greetings",
        title = "社交达人：地道的问候与寒暄",
        description = "告别 How are you, I'm fine，解锁地道口语表达。",
        category = "口语交际",
        themeColor = Color(0xFFE91E63),
        style = CoursewareStyle.MODERN,
        slides = listOf(
            Slide(
                id = "s1",
                title = "Break the Ice",
                content = "当你见到老朋友，第一句话会说什么？",
                visualHint = "两个年轻人在咖啡馆偶遇，击掌问候的插图。"
            ),
            Slide(
                id = "s2",
                title = "地道表达 Top 3",
                content = "1. How's it going?\n2. What's up?\n3. How have you been?",
                subContent = "注意语气语调的自然波动。",
                visualHint = "三个发音波形图，点击可播放模拟音效。"
            ),
            Slide(
                id = "s3",
                title = "回应的艺术",
                content = "不仅仅是 'Fine'，尝试这些：\n'Pretty good!' / 'Not bad.' / 'Same as usual.'",
                interactionType = InteractionType.CLICK_TO_REVEAL,
                correctAnswer = "地道回应：Not too shabby! (还不错哦！)"
            ),
            Slide(
                id = "s4",
                title = "情景模拟",
                content = "A: Long time no see! ______?\nB: Pretty good, thanks!",
                interactionType = InteractionType.MULTIPLE_CHOICE,
                options = listOf("How are you", "How's it going", "What do you do"),
                correctAnswer = "How's it going"
            )
        )
    ),
    Courseware(
        id = "writing_postcard",
        title = "笔尖上的旅行：明信片写作指南",
        description = "掌握英文信函的基本格式，学习如何描述旅行体验。",
        category = "写作提分",
        themeColor = Color(0xFF2196F3),
        style = CoursewareStyle.PAPER,
        slides = listOf(
            Slide(
                id = "s1",
                title = "Wish You Were Here",
                content = "明信片虽然小，但承载着远方的思念。",
                visualHint = "一张写满文字、贴着邮票的复古明信片背面。"
            ),
            Slide(
                id = "s2",
                title = "明信片“黄金四部曲”",
                content = "1. Greeting (称呼)\n2. Travel details (行程描述)\n3. Feelings (感受)\n4. Closing (结尾签名)",
                visualHint = "明信片布局分解图，不同部分用彩色色块标注。"
            ),
            Slide(
                id = "s3",
                title = "万能描述词",
                content = "让你的风景描写更有画面感：\nbreathtaking (惊人的), magnificent (壮丽的), cozy (舒适的)",
                interactionType = InteractionType.FLIP_CARD,
                options = listOf("breathtaking", "magnificent", "cozy")
            ),
            Slide(
                id = "s4",
                title = "拼写挑战",
                content = "I'm having a _______ (w-o-n-d-e-r-f-u-l) time in London!",
                interactionType = InteractionType.FILL_IN_BLANK,
                correctAnswer = "wonderful"
            )
        )
    ),
    Courseware(
        id = "culture_festivals",
        title = "东西方碰撞：万圣节 vs 中元节",
        description = "对比中外传统节日，提升跨文化意识与词汇量。",
        category = "文化透视",
        themeColor = Color(0xFF9C27B0),
        style = CoursewareStyle.MODERN,
        slides = listOf(
            Slide(
                id = "s1",
                title = "Ghosts and Traditions",
                content = "当南瓜灯遇上纸莲灯，会有怎样的故事？",
                visualHint = "左边是万圣节南瓜灯，右边是中元节河灯，视觉对比强烈。"
            ),
            Slide(
                id = "s2",
                title = "万圣节关键词",
                content = "Jack-o'-lantern, Trick-or-treat, Costume, Bat",
                visualHint = "点击图标，弹出对应的文化小常识。"
            ),
            Slide(
                id = "s3",
                title = "中元节关键词",
                content = "Ghost Festival, Ancestor worship, Paper lanterns",
                visualHint = "展示中国传统祭祀场景的剪纸风格插图。"
            ),
            Slide(
                id = "s4",
                title = "连线游戏",
                content = "将习俗与其对应的节日匹配：\n1. Trick-or-treat\n2. Light river lanterns",
                interactionType = InteractionType.DRAG_AND_DROP,
                options = listOf("Halloween", "Ghost Festival")
            )
        )
    ),
    Courseware(
        id = "grammar_relative_clauses",
        title = "逻辑链条：定语从句 (Who/Which/That)",
        description = "攻克初中语法重难点，让你的句子长而优美。",
        category = "语法突破",
        themeColor = Color(0xFF4CAF50),
        style = CoursewareStyle.TECH,
        slides = listOf(
            Slide(
                id = "s1",
                title = "The Hero Who Saves the World",
                content = "定语从句就像给名词穿上了漂亮的衣服。",
                visualHint = "一个基础的名词（Hero），通过定语从句逐渐增加装备（披风、剑、面具）。"
            ),
            Slide(
                id = "s2",
                title = "先行词是关键",
                content = "人用 Who/That，物用 Which/That。",
                subContent = "先行词就是被修饰的那个名词。",
                visualHint = "天平布局：左边是人（Who），右边是物（Which），中间是万能的 That。"
            ),
            Slide(
                id = "s3",
                title = "合并句子魔法",
                content = "1. I know a boy. 2. The boy plays football well.\n合并：I know a boy who plays football well.",
                interactionType = InteractionType.CLICK_TO_REVEAL,
                correctAnswer = "合并秘籍：去掉重复的名词，换上引导词。"
            ),
            Slide(
                id = "s4",
                title = "实战通关",
                content = "The book _______ I bought yesterday is very interesting.",
                interactionType = InteractionType.MULTIPLE_CHOICE,
                options = listOf("who", "which", "whom"),
                correctAnswer = "which"
            )
        )
    ),
    Courseware(
        id = "phonetics_melody",
        title = "英语的旋律：重音与语调",
        description = "让你的英语听起来不再生硬，掌握母语者的发音韵律。",
        category = "听力口语",
        themeColor = Color(0xFF00BCD4),
        style = CoursewareStyle.GAME,
        slides = listOf(
            Slide(
                id = "s1",
                title = "Music of Language",
                content = "英语是有节奏的，就像一段美妙的旋律。",
                visualHint = "五线谱上跳动的英文字符插图。"
            ),
            Slide(
                id = "s2",
                title = "单词重音 (Word Stress)",
                content = "重音位置不同，意思可能完全不同！\n'RE-cord (记录, n.) vs re-CORD (录制, v.)",
                visualHint = "两个鼓点图标，一个大，一个小，点击可对比发音节奏。"
            ),
            Slide(
                id = "s3",
                title = "句子语调 (Intonation)",
                content = "升调表示不确定或提问，降调表示肯定或结束。",
                subContent = "Are you ready? ↗ vs I'm ready. ↘",
                interactionType = InteractionType.CLICK_TO_REVEAL,
                correctAnswer = "口诀：升调像爬坡，降调像下坡。"
            ),
            Slide(
                id = "s4",
                title = "听力挑战",
                content = "听到这段话，你认为说话人的心情是？",
                interactionType = InteractionType.MULTIPLE_CHOICE,
                options = listOf("Excited", "Sad", "Angry"),
                correctAnswer = "Excited"
            )
        )
    )
)
