package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade7Up {
    val data = Textbook(
        id = "g7_up",
        grade = "七年级",
        term = "上册",
        coverColor = Color(0xFFFCE4EC),
        units = listOf(
            TextbookUnit(
                "g7up_u1", "Unit 1", "You and Me",
                listOf(
                    UnitDetailSection("📖 单元导读 (Unit Overview)", """
                        ### 1. 单元主题层级 (Theme Hierarchy)
                        *   **主题范畴**：人与自我
                        *   **子主题**：个人情况；人际交往；校园新生活。
                        
                        ### 2. 单元主题内容 (Unit Content)
                        本单元是人教版新教材的开篇之作。通过询问姓名（Name）、年龄（Age）、籍贯（From）等基本个人信息，引导学生学会在初中新环境下如何结识新朋友，建立和谐、友好的同学关系。
                        
                        ### 3. 单元新知预览 (New Knowledge Preview)
                        *   **单词短语**：friend, each other, be from, full name, last name, first name...
                        *   **核心句式**：
                            *   What's your name? / My name is...
                            *   Where are you from? / I'm from...
                            *   How old are you? / I'm ... years old.
                        *   **重点语法**：be动词 (am, is, are) 的一般现在时用法及其缩写形式。
                        *   **语音知识**：26个字母的正确读音、书写规范及在单词中的初步发音感悟。
                        *   **主题写作**：Introduce yourself and your new friends (自我介绍与介绍他人)。
                    """.trimIndent()),
                    
                    UnitDetailSection("🔤 知识详解 (Vocabulary & Phrases)", """
                        #### 1. friend (n.) 朋友
                        *   **【教材原句】**：I have a new friend. (我有一个新朋友。)
                        *   **【用法详析】**：
                            *   **复数形式**：friends。
                            *   **派生词**：**friendly** (adj.) 友好的。常用短语：*be friendly to sb.* (对某人友好)。
                            *   **固定搭配**：**make friends with sb.** (与某人交朋友)。
                            *   **名言积累**：A friend in need is a friend indeed. (患难见真情。)
                        
                        #### 2. nice (adj.) 令人愉快的；宜人的
                        *   **【教材原句】**：Nice to meet you! (很高兴见到你！)
                        *   **【用法详析】**：
                            *   常用于初次见面时的客套话。
                            *   **近义词**：pleasant, glad, happy.
                            *   **语法点**：It is nice to do sth. (做某事很愉快)。
                        
                        #### 3. meet (v.) 遇见；相逢
                        *   **【词性变化】**：过去式为 **met**。
                        *   **【名词形式】**：**meeting** (会议)。
                        *   **【辨析】**：*meet* 强调偶然相遇或按约定见面；*know* 强调认识并了解。
                        
                        #### 4. each other 互相；彼此
                        *   **【用法详析】**：
                            *   通常用于两者之间。指三者或以上常用 *one another*（但在现代英语中两者常互换）。
                            *   **例句**：We should help each other. (我们应该互相帮助。)
                    """.trimIndent()),
                    
                    UnitDetailSection("🌐 翻译与语篇分析 (Text & Discourse)", """
                        #### 【Section A 2a 重点对话翻译】
                        *   **Teacher**: Good morning, class! (老师：同学们，早上好！)
                        *   **Class**: Good morning, Ms. Li! (学生：老师，早上好！)
                        *   **Teacher**: I have a new student here. What's your name? (老师：这里有一位新同学。你叫什么名字？)
                        *   **Peter**: My name is Peter. Nice to meet you all! (彼得：我的名字叫彼得。很高兴见到大家！)
                        
                        #### 【语篇逻辑拆解】
                        本单元的文本多为**交互式对话**（Interactional Talk）。
                        1.  **起笔**：通过招呼语（Greeting）打破僵局。
                        2.  **核心**：通过 *What / Where / How* 引导的特殊疑问句获取关键个人档案信息。
                        3.  **收尾**：通过 *Nice to meet you / Welcome* 等表达建立情感连接。
                    """.trimIndent()),
                    
                    UnitDetailSection("🔍 长难句分析 (Sentence Structure)", """
                        #### 1. 经典并列句
                        > *Original:* "I am from the UK and my new friend is from the US."
                        
                        *   **成分拆解**：
                            *   `[I]` (主) + `[am]` (系) + `[from the UK]` (表)
                            *   `[and]` (并列连词，表示顺承或补充)
                            *   `[my new friend]` (主) + `[is]` (系) + `[from the US]` (表)
                        *   **考点**：and 连接两个独立的句子，前后时态需保持一致。
                        
                        #### 2. 介词短语作后置定语
                        > *Original:* "The boy with glasses is my classmate."
                        
                        *   **解析**：`with glasses` 是一个介词短语，紧跟在名词 boy 后面，起修饰限制作用，翻译为“戴眼镜的那个男孩”。
                    """.trimIndent()),
                    
                    UnitDetailSection("📌 终点速记 (Key Points to Remember)", """
                        #### 【速记口诀：be动词用法】
                        > 我(I)用 **am**，你(you)用 **are**，
                        > **is** 连着他(he)、她(she)、它(it)；
                        > 单数名词用 **is**，复数名词全用 **are**。
                        > 变疑问，往前提，句末问号莫忘记。
                        > 变否定，更容易，**not** 就在 be 后立。
                        
                        #### 【核心短语归纳】
                        1.  **full name** 全名 (First name + Last name)
                        2.  **in Class 1** 在一班 (注意 Class 首字母大写)
                        3.  **at school** 在学校
                        4.  **an English teacher** 一位英语老师 (注意用 an)
                    """.trimIndent()),
                    
                    UnitDetailSection("⚙️ 语法精讲 (Grammar Pro)", """
                        #### be 动词的一般现在时详解
                        
                        | 人称 | be动词 | 肯定形式 | 否定形式 | 疑问形式 |
                        | :--- | :--- | :--- | :--- | :--- |
                        | 第一人称单数 | **am** | I am... | I am not... | Am I...? |
                        | 第二人称单/复数 | **are** | You are... | You are not... | Are you...? |
                        | 第三人称单数 | **is** | He/She/It is... | He is not... | Is he...? |
                        | 第一/三人称复数 | **are** | We/They are... | They are not... | Are they...? |
                        
                        #### 【深度陷阱】
                        *   **缩写限制**：*this is* 不能缩写为 *this's*；*am not* 没有缩写形式（不能写成 amn't）。
                        *   **回答一致**：用 *Are you...?* 提问，回答必须用 *I am.*。
                    """.trimIndent()),
                    
                    UnitDetailSection("✍️ 词句积累 (Expression Bank)", """
                        #### 【万能句型】
                        *   **Welcome to...** 欢迎来到……
                        *   **I'm in Class ..., Grade ...** 我在……年级……班。
                        *   **My favorite subject is ...** 我最喜欢的学科是……
                        
                        #### 【写作素材库：自我介绍】
                        *   *Let me introduce myself.* (让我介绍一下我自己。)
                        *   *I'm friendly and I like to make friends.* (我很友好，喜欢交朋友。)
                        *   *I hope we can be good friends.* (我希望我们能成为好朋友。)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u2", "Unit 2", "We're Family",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        ### 主题范畴：人与自我 - 家庭与亲人
                        本单元旨在帮助学生掌握家庭成员的称呼，理解家庭关系图，并能使用指示代词和所有格介绍家人。
                    """.trimIndent()),
                    UnitDetailSection("🔤 词汇详解", """
                        *   **family** (n.) 家；家庭成员。注意：指“家庭”整体时看作单数；指“家人”时看作复数。
                        *   **photo** (n.) 照片。复数：**photos**。
                        *   **son** (儿子) vs **sun** (太阳) —— 典型同音词。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲", """
                        #### 1. 指示代词 (this, that, these, those)
                        *   **单数**：this (近), that (远)
                        *   **复数**：these (近), those (远)
                        
                        #### 2. 名词所有格 ('s)
                        *   表示所属关系。
                        *   **Tom's mother** (汤姆的妈妈)
                        *   **the girls' room** (女孩们的房间 —— 以s结尾的复数只加撇)
                    """.trimIndent())
                )
            ),
            TextbookUnit(
                "g7up_u3", "Unit 3", "My School",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        ### 主题范畴：人与自我 - 学校生活
                        学习描述校园场所、位置关系及存在句型。
                    """.trimIndent()),
                    UnitDetailSection("🔤 词汇详解", """
                        *   **classroom** (教室), **library** (图书馆), **playground** (操场), **building** (建筑物)。
                        *   **between... and...**：在……和……之间。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲", """
                        #### There be 句型 (表示“某处有某物”)
                        1.  **结构**：There is / are + 名词 + 地点状语.
                        2.  **就近原则**：be 动词的单复数取决于离它最近的那个名词。
                            *   *There is a book and two pens.*
                            *   *There are two pens and a book.*
                    """.trimIndent())
                )
            )
        )
    )
}
