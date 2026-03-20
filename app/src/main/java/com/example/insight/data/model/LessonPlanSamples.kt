package com.example.insight.data.model

import androidx.compose.ui.graphics.Color

data class LessonPlanSample(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val targetClass: String,
    val themeColor: Color,
    val blocks: List<LessonBlock>
)

data class LessonBlock(
    val id: String,
    val type: String, // e.g., "Lead-in", "Presentation", "Practice", "Production", "Summary"
    val title: String,
    val timeLimit: String,
    val teacherAction: String = "",
    val content: String,
    val colorIndicator: Color
)

val sampleLessonPlans = listOf(
    LessonPlanSample(
        id = "lp_unit5_explorer",
        title = "Unit 5 - The Missing Explorer（失踪的探险家）",
        category = "阅读精讲",
        description = "侦探悬疑剧本杀，训练上下文提取线索能力。",
        targetClass = "初二 (3) 班",
        themeColor = Color(0xFF4CAF50),
        blocks = listOf(
            LessonBlock(
                id = "b1",
                type = "Lead-in",
                title = "导入激趣",
                timeLimit = "5 mins",
                teacherAction = "投影展示本课的核心背景图。",
                content = "展示一张悬疑风格的暗色调插图，图中人物被绑架，双手被反绑在椅子上，旁边打翻的咖啡杯还在冒着热气，地上散落着一块停在 8:15 的怀表和半张纸条。\n\n话术引导：'Look at this picture. What happened? What were the suspects doing at 8:15 last night?' 引发学生用英语进行猜测。",
                colorIndicator = Color(0xFFFFC107)
            ),
            LessonBlock(
                id = "b2",
                type = "Presentation",
                title = "语篇呈现",
                timeLimit = "15 mins",
                teacherAction = "引导学生快速阅读课文。",
                content = "核心任务：快速阅读课文（嫌疑人供词），圈出所有带有 was/were + v-ing 的句子。\n\n结构拆解：将文中三个嫌疑人的供词分别提炼出来：\nSuspect A: I was watching TV when the lights went out.\nSuspect B: I was reading a book in my study.",
                colorIndicator = Color(0xFF2196F3)
            ),
            LessonBlock(
                id = "b3",
                type = "Practice",
                title = "深度剖析",
                timeLimit = "15 mins",
                teacherAction = "组织互动填空练习。",
                content = "对比一般过去时与过去进行时。\n例如：The kidnapper entered (enter) the room while the man was drinking (drink) coffee.",
                colorIndicator = Color(0xFFE91E63)
            ),
            LessonBlock(
                id = "b4",
                type = "Production",
                title = "产出与结案",
                timeLimit = "10 mins",
                teacherAction = "指导小组 Role-play 活动。",
                content = "小组活动：Role-play。四人一组，一人扮演警长，三人扮演嫌疑人进行交叉询问。最终根据供词中的逻辑漏洞（时间线冲突）找出真正的绑匪。",
                colorIndicator = Color(0xFF9C27B0)
            )
        )
    ),
    LessonPlanSample(
        id = "lp_grammar_perfect",
        title = "Have you ever...?（连接过去与现在的隐形桥梁）",
        category = "语法突破",
        description = "现在完成时降维打击，理清两种时态本质区别。",
        targetClass = "初二 (1) 班",
        themeColor = Color(0xFF2196F3),
        blocks = listOf(
            LessonBlock(
                id = "b1",
                type = "Warming-up",
                title = "破冰游戏",
                timeLimit = "5 mins",
                teacherAction = "在黑板上写下三句话。",
                content = "活动：'Two Truths and a Lie' (两个真相一个谎言)。\n\n1. I have been to Mount Everest.\n2. I have eaten snake meat.\n3. I have met a pop star.\n\n让学生猜哪一个是假的，自然引出“生活经历”这一现在完成时的核心语境。",
                colorIndicator = Color(0xFFFFC107)
            ),
            LessonBlock(
                id = "b2",
                type = "Concept Mapping",
                title = "概念图谱",
                timeLimit = "10 mins",
                teacherAction = "展示时间轴对比图。",
                content = "讲解逻辑：\n- 一般过去时：强调动作发生的时间点，如 'I lost my key yesterday.'（重点在昨天发生的动作）。\n- 现在完成时：强调对现在造成的影响，如 'I have lost my key.'（潜台词：所以我现在进不了门）。",
                colorIndicator = Color(0xFF2196F3)
            ),
            LessonBlock(
                id = "b3",
                type = "Signal Words",
                title = "标志词排雷",
                timeLimit = "15 mins",
                teacherAction = "梳理关键词位置规则。",
                content = "核心精讲：梳理 already, yet, just, ever, never 的站位规则。\n\n避坑指南：提醒学生绝对不能和 last night, in 2010 这种明确的过去时间状语连用。",
                colorIndicator = Color(0xFFE91E63)
            ),
            LessonBlock(
                id = "b4",
                type = "Summary",
                title = "总结与巩固",
                timeLimit = "5 mins",
                teacherAction = "布置课后调研任务。",
                content = "作业布置：调查 3 位好朋友或家人的特殊经历，用 He/She has... 写一段 50 字的英文微报道。",
                colorIndicator = Color(0xFF9C27B0)
            )
        )
    )
)
