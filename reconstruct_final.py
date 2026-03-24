
import os
import re

def full_reconstruct():
    file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
    
    # 1. Start with the boilerplate and data class definitions
    header = '''package com.example.insight.data.model

data class ExampleProblem(
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String
)

data class PastExamQuestion(
    val year: String,
    val location: String,
    val question: String,
    val options: List<String>,
    val answer: String,
    val explanation: String,
    val errorProne: String? = null,
    val translation: String? = null
)

data class HighlightedSentence(
    val text: String,
    val analysis: String
)

data class TextbookParagraph(
    val content: String,
    val highlightedSentences: List<HighlightedSentence>,
    val source: String
)

data class ExampleSentence(
    val english: String,
    val chinese: String,
    val analysis: String? = null,
    val difficulty: String = "中考难度"
)

data class RelatedPoint(
    val title: String,
    val description: String,
    val connectionReason: String
)

data class TeachingNote(
    val title: String,
    val content: String
)

data class KnowledgePoint(
    val id: String,
    val section: String,
    val title: String,
    val description: String,
    val syllabusDetails: List<String>,
    val relatedPoints: List<RelatedPoint>,
    val exampleProblems: List<ExampleProblem>,
    val pastExamQuestions: List<PastExamQuestion>,
    val textbookParagraphs: List<TextbookParagraph>,
    val exampleSentences: List<ExampleSentence> = emptyList(),
    val teachingNotes: List<TeachingNote> = emptyList(),
    val famousQuote: String = "",
    val quoteTranslation: String = "",
    val quoteAnalysis: String = "",
    val quoteAuthor: String = ""
)

object KnowledgeProvider {
    const val SEC_1 = "板块一：词法体系 (Morphology)"
    const val SEC_2 = "板块二：时态与语态体系 (Tenses & Voices)"
    const val SEC_3 = "板块三：句法体系 (Syntax)"

    val allPoints = listOf(
'''

    # 2. Extract KnowledgePoints from individual scripts or the current damaged file
    # We will look for KnowledgePoint( ... ) blocks that are balanced.
    
    with open(file_path, 'r', encoding='utf-8') as f:
        damaged_content = f.read()
        
    kp_blocks = []
    # Find all KnowledgePoint( starts
    starts = [m.start() for m in re.finditer(r'KnowledgePoint\(', damaged_content)]
    
    seen_ids = set()
    for start in starts:
        stack = 0
        block = ""
        for i in range(start, len(damaged_content)):
            if damaged_content[i] == '(': stack += 1
            elif damaged_content[j if 'j' in locals() else i] == ')': # typo fix: use 'i'
                pass
        # Better logic for bracket balancing:
        stack = 0
        end = -1
        for i in range(start, len(damaged_content)):
            if damaged_content[i] == '(': stack += 1
            elif damaged_content[i] == ')':
                stack -= 1
                if stack == 0:
                    end = i + 1
                    break
        if end != -1:
            kp_text = damaged_content[start:end]
            # Extract ID to avoid duplicates
            id_match = re.search(r'id = \"(.*?)\"', kp_text)
            if id_match:
                kp_id = id_match.group(1)
                if kp_id not in seen_ids:
                    kp_blocks.append(kp_text)
                    seen_ids.add(kp_id)

    # 3. Assemble
    full_content = header
    for i, block in enumerate(kp_blocks):
        full_content += "        " + block
        if i < len(kp_blocks) - 1:
            full_content += ",\n"
        else:
            full_content += "\n"
            
    full_content += "    )\n}\n"
    
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(full_content)
    print(f"Reconstructed with {len(kp_blocks)} KnowledgePoints.")

if __name__ == "__main__":
    full_reconstruct()
