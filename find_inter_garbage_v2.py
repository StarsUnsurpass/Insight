
import re

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()
    content = "".join(lines)

# Find all KnowledgePoint calls and their line numbers
kp_matches = list(re.finditer(r'KnowledgePoint\(', content))
print(f"Total KnowledgePoint calls: {len(kp_matches)}")

for i in range(len(kp_matches) - 1):
    end_prev = kp_matches[i].end()
    start_next = kp_matches[i+1].start()
    
    # We need to find the closing ) of the first one
    # This is non-trivial, but let's assume it's before the next KnowledgePoint(
    # and it should be followed by a comma
    
    # Let's search backwards from start_next for the last ),
    gap_text = content[end_prev:start_next]
    
    # Find the last ), in the gap (if any)
    last_bracket_comma = gap_text.rfind('),')
    if last_bracket_comma != -1:
        garbage = gap_text[last_bracket_comma+2:].strip()
        if garbage and garbage != ',':
            # Find line number of start_next
            line_no = content.count('\n', 0, start_next) + 1
            print(f"GARBAGE BEFORE line {line_no} (KP {i+2}):")
            print(f"--- START ---\n{garbage}\n--- END ---")
