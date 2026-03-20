package com.example.insight.data.model

import androidx.compose.ui.graphics.Color

data class Courseware(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val themeColor: Color,
    val slides: List<Slide>
)

data class Slide(
    val id: String,
    val title: String,
    val content: String,
    val subContent: String = "",
    val visualHint: String = "",
    val interactionType: InteractionType = InteractionType.NONE,
    val options: List<String> = emptyList(),
    val correctAnswer: String = ""
)

enum class InteractionType {
    NONE,
    CLICK_TO_REVEAL,
    FLIP_CARD,
    FILL_IN_BLANK,
    MULTIPLE_CHOICE,
    DRAG_AND_DROP
}

val sampleCoursewares = listOf(
    Courseware(
        id = "grammar_present_perfect",
        title = "时间旅行者：现在完成时 vs 一般过去时",
        description = "探秘时态的魔法，解决初中生最头疼的时态混淆问题。",
        category = "语法突破",
        themeColor = Color(0xFF6200EE),
        slides = listOf(
            Slide(
                id = "s1",
                title = "Have you ever traveled through time?",
                content = "探秘时态的魔法。",
                visualHint = "一条跨越屏幕的巨大时间轴，左边是黑白的过去，右边是彩色的现在。"
            ),
            Slide(
                id = "s2",
                title = "核心概念降维",
                content = "一般过去时 = 关在盒子里的过去（与现在无关）",
                subContent = "现在完成时 = 延伸到现在的桥梁（对现在有影响）",
                visualHint = "左右分栏布局。"
            ),
            Slide(
                id = "s3",
                title = "标志词捕鼠器",
                content = "点击翻转出它所属的时态和例句。",
                interactionType = InteractionType.FLIP_CARD,
                options = listOf("yesterday", "just", "already", "last year")
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
        slides = listOf(
            Slide(
                id = "s1",
                title = "The Mysterious Disappearance",
                content = "案发时间：昨晚 8:00。",
                visualHint = "悬疑风格暗色调插图，图中人物被绑架，周围散落着怀表、咖啡杯等线索。"
            ),
            Slide(
                id = "s2",
                title = "嫌疑人供词",
                content = "Mr. Green: 'I was watching TV at 8:00 PM.'\nMrs. White: 'I was reading a book when the lights went out.'",
                subContent = "核心句型：was/were + doing (表示过去某一时刻正在发生的动作)。",
                visualHint = "三个嫌疑人的头像和对话气泡。"
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
    )
)
