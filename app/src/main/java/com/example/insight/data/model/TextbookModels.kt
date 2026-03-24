package com.example.insight.data.model

import androidx.compose.ui.graphics.Color

data class Textbook(
    val id: String,
    val grade: String,
    val term: String, // "上册", "下册", "全一册"
    val coverColor: Color,
    val units: List<TextbookUnit>
)

data class TextbookUnit(
    val id: String,
    val title: String,
    val topic: String,
    val isFilled: Boolean = false, // Marker to indicate if this unit has real content yet
    val coreGrammar: String = "核心内容尚未收录",
    val sections: List<UnitSection> = emptyList()
)

sealed class UnitSection {
    data class SectionA(
        val title: String = "Section A (基础输入)",
        val vocabulary: List<String>,
        val sentencePatterns: List<String>
    ) : UnitSection()
    
    data class GrammarFocus(
        val title: String = "Grammar Focus (语法聚焦)",
        val grammarNodeIds: List<String> // Maps to KnowledgePoint IDs
    ) : UnitSection()
    
    data class SectionB(
        val title: String = "Section B (能力输出)",
        val readingSkills: List<String>,
        val writingSkills: List<String>
    ) : UnitSection()
}

object TextbookProvider {
    val textbooks = listOf(
        Textbook(
            id = "g7_up",
            grade = "七年级",
            term = "上册",
            coverColor = Color(0xFFFCE4EC), // Light Pink
            units = listOf(
                TextbookUnit(
                    id = "g7up_s1",
                    title = "Starter Unit 1",
                    topic = "Hello! (你好！)",
                    isFilled = true,
                    coreGrammar = "26个字母与基本问候语",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("hello", "hi", "good morning", "good afternoon", "good evening"),
                            sentencePatterns = listOf("Hello, I'm...", "Good morning, class!")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("articles") // a/an introductory
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("识别26个字母的书写与发音"),
                            writingSkills = listOf("正确书写大小写字母")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_s2",
                    title = "Starter Unit 2",
                    topic = "Keep Tidy! (保持整洁！)",
                    isFilled = true,
                    coreGrammar = "确认物体与辨色",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("what", "this", "that", "it", "color", "red", "blue", "yellow"),
                            sentencePatterns = listOf("What's this in English?", "It's a/an...", "What color is it?")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("pronouns") // this/that/it
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("根据颜色描述物体"),
                            writingSkills = listOf("编写关于询问物体的对话")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_s3",
                    title = "Starter Unit 3",
                    topic = "Welcome! (欢迎！)",
                    isFilled = true,
                    coreGrammar = "基本指令与数字",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("one to ten", "sit down", "stand up", "open", "close"),
                            sentencePatterns = listOf("Stand up, please.", "How many...?")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("numerals") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("理解课堂基本常用指令"),
                            writingSkills = listOf("数字的拼写练习")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_u1",
                    title = "Unit 1",
                    topic = "You and Me (你和我)",
                    isFilled = true,
                    coreGrammar = "be动词 (am, is, are) & 人称代词",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("name", "nice", "meet", "first name", "last name"),
                            sentencePatterns = listOf("What's your name?", "Nice to meet you!", "Where are you from?")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("simple_present", "pronouns") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("获取他人基本个人信息"),
                            writingSkills = listOf("介绍自己与介绍新朋友")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_u2",
                    title = "Unit 2",
                    topic = "We're Family (我们是一家人)",
                    isFilled = true,
                    coreGrammar = "名词所有格 & 指示代词 (these/those)",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("father", "mother", "brother", "sister", "grandparents", "photo"),
                            sentencePatterns = listOf("Who's she?", "These are my parents.", "That's my family photo.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("nouns", "pronouns") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("理解家庭关系图谱"),
                            writingSkills = listOf("根据照片介绍全家福")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_u3",
                    title = "Unit 3",
                    topic = "My School (我的学校)",
                    isFilled = true,
                    coreGrammar = "There be 句型 & 方位介词",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("classroom", "library", "playground", "desk", "chair", "next to"),
                            sentencePatterns = listOf("Is there a...?", "Where is the library?", "It's behind the hall.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("prepositions", "five_basic_patterns") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("看图识位与寻找路线"),
                            writingSkills = listOf("写一篇介绍自己理想校园的短文")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_u4",
                    title = "Unit 4",
                    topic = "My Favourite Food (我最喜欢的食物)",
                    isFilled = true,
                    coreGrammar = "可数与不可数名词 & some/any",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("apple", "banana", "bread", "milk", "vegetable", "healthy"),
                            sentencePatterns = listOf("Do you like...?", "I like apples but I don't like milk.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("nouns") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("获取饮食偏好与营养建议"),
                            writingSkills = listOf("制定一份健康的购物清单或食谱")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_u5",
                    title = "Unit 5",
                    topic = "Fun Times (欢乐时光)",
                    isFilled = true,
                    coreGrammar = "情态动词 can & but 连词",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("play", "tennis", "guitar", "dance", "sing", "swim", "club"),
                            sentencePatterns = listOf("Can you swim?", "Yes, I can.", "What club do you want to join?")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("conjunctions") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("理解招新海报的核心信息"),
                            writingSkills = listOf("写一则社团招聘启事或个人特长申请")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_u6",
                    title = "Unit 6",
                    topic = "A Day in the Life (生活中的一天)",
                    isFilled = true,
                    coreGrammar = "一般现在时 & 时间表达法",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("get up", "eat breakfast", "go to school", "o'clock", "time"),
                            sentencePatterns = listOf("What time is it?", "I usually get up at 6:30.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("simple_present") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("理清动作发生的时间先后顺序"),
                            writingSkills = listOf("描述自己典型一天的作息安排")
                        )
                    )
                ),
                TextbookUnit(
                    id = "g7up_u7",
                    title = "Unit 7",
                    topic = "Happy Birthday (生日快乐)",
                    isFilled = true,
                    coreGrammar = "序数词 & 介词 in/on/at",
                    sections = listOf(
                        UnitSection.SectionA(
                            vocabulary = listOf("month", "January", "February", "date", "birthday", "gift"),
                            sentencePatterns = listOf("When is your birthday?", "It's on January 5th.")
                        ),
                        UnitSection.GrammarFocus(
                            grammarNodeIds = listOf("numerals", "prepositions") 
                        ),
                        UnitSection.SectionB(
                            readingSkills = listOf("识别并匹配日期与活动日程"),
                            writingSkills = listOf("写一封生日派对的邀请函")
                        )
                    )
                )
            )
        ),
        Textbook(
            id = "g7_down",
            grade = "七年级",
            term = "下册",
            coverColor = Color(0xFFE8F5E9), // Green
            units = generatePlaceholderUnits("g7d", 12)
        ),
        Textbook(
            id = "g8_up",
            grade = "八年级",
            term = "上册",
            coverColor = Color(0xFFFFF3E0), // Light Orange
            units = generatePlaceholderUnits("g8u", 10)
        ),
        Textbook(
            id = "g8_down",
            grade = "八年级",
            term = "下册",
            coverColor = Color(0xFFFFE0B2), // Orange
            units = generatePlaceholderUnits("g8d", 10)
        ),
        Textbook(
            id = "g9_full",
            grade = "九年级",
            term = "全一册",
            coverColor = Color(0xFFE3F2FD), // Light Blue
            units = generatePlaceholderUnits("g9f", 14)
        )
    )

    private fun generatePlaceholderUnits(prefix: String, count: Int, startIndex: Int = 1): List<TextbookUnit> {
        return (startIndex until startIndex + count).map {
            TextbookUnit(
                id = "${prefix}_u$it",
                title = "Unit $it",
                topic = "教学大纲内容准备中...",
                isFilled = false
            )
        }
    }
}
