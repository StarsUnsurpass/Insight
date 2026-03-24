package com.example.insight.data.model.textbooks

import androidx.compose.ui.graphics.Color
import com.example.insight.data.model.Textbook
import com.example.insight.data.model.TextbookUnit
import com.example.insight.data.model.UnitDetailSection

object Grade8Up {
    val data = Textbook(
        id = "g8_up",
        grade = "八年级",
        term = "上册",
        coverColor = Color(0xFFFFF3E0),
        units = listOf(
            TextbookUnit(
                "g8up_u1", "Unit 1", "Happy Holiday",
                listOf(
                    UnitDetailSection("📖 单元导读", """
                        ### 1. 单元主题层级
                        *   **主题范畴**：人与社会
                        *   **子主题**：节假日活动；旅游经历与感悟。
                        
                        ### 2. 单元核心新知预览
                        *   **核心语法**：一般过去时 (Simple Past Tense)；复合不定代词 (Indefinite Pronouns)。
                        *   **功能句式**：Where did you go? / How was the trip? / Did you do anything special?
                    """.trimIndent()),
                    UnitDetailSection("🔤 词汇详解", """
                        #### ① **wonderful** (adj.) 极好的；精彩的
                        *   **近义词**：excellent, fantastic, great.
                        *   **用法**：What a wonderful trip! (多么精彩的一次旅行！)
                        
                        #### ② **decide** (v.) 决定
                        *   **搭配**：**decide to do sth.** (决定做某事)。
                        *   **名词**：**decision** (n.)。常用 *make a decision* (做决定)。
                        
                        #### ③ **hardly** (adv.) 几乎不；简直不
                        *   **注意**：本身含有否定含义。修饰动词时放在实义动词前，助动词/情态动词后。
                    """.trimIndent()),
                    UnitDetailSection("⚙️ 语法精讲", """
                        #### 1. 复合不定代词 (Indefinite Pronouns)
                        
                        | | 指物 (-thing) | 指人 (-one / -body) |
                        | :--- | :--- | :--- |
                        | **some-** | **something** | **someone / somebody** |
                        | **any-** | **anything** | **anyone / anybody** |
                        | **no-** | **nothing** | **no one / nobody** |
                        | **every-** | **everything** | **everyone / everybody** |
                        
                        #### 【高频考点】
                        1.  **形容词后置**：形容词修饰复合不定代词时，必须放在其后。(e.g., *something special*, *nothing new*)。
                        2.  **谓语一致性**：它们作主语时，谓语动词一律用**单数**。
                        
                        #### 2. 一般过去时 (回顾与深化)
                        *   **特殊疑问句**：疑问词 + did + 主语 + 动词原形 + ...?
                    """.trimIndent()),
                    UnitDetailSection("🔍 长难句分析", """
                        > *Original:* "I arrived in Penang in Malaysia this morning with my family."
                        
                        *   **成分解析**：
                            *   `I` (主语) + `arrived` (谓语) 
                            *   `in Penang in Malaysia` (地点状语，由大到小排序)
                            *   `this morning` (时间状语)
                            *   `with my family` (伴随状语)
                    """.trimIndent()),
                    UnitDetailSection("🌐 翻译与语篇分析", """
                        #### 【Jane's Diary 重点段落】
                        "Everything was tasted good. I ate two bowls of noodles."
                        译文：所有的东西尝起来都很美味。我吃了两碗面条。
                        
                        #### 【语篇结构】
                        本文是一篇典型的日记（Diary）。
                        *   **格式**：日期 + 天气 + 正文。
                        *   **基调**：第一人称叙述，时态统一为一般过去时。
                    """.trimIndent())
                )
            )
        ) + (2..10).map { i ->
            TextbookUnit("g8up_u$i", "Unit $i", "全维度教辅解析", listOf(
                UnitDetailSection("📖 单元导读", "本单元教辅内容正在根据2025教研标准同步更新中..."),
                UnitDetailSection("🔤 词汇详解", "涵盖该单元所有四会单词及考纲变形..."),
                UnitDetailSection("⚙️ 语法精讲", "包含中考高频考点解析与避坑指南...")
            ))
        }
    )
}
