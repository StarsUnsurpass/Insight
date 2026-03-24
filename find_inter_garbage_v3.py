
import re

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Find the allPoints list
list_match = re.search(r'val allPoints = listOf\((.*)\)', content, re.DOTALL)
if not list_match:
    print("Could not find allPoints list")
    exit()

list_text = list_match.group(1)
base_offset = content.find(list_text)

# Find all KnowledgePoint calls in the list
kp_matches = list(re.finditer(r'KnowledgePoint\(', list_text))
print(f"Total KnowledgePoint instances: {len(kp_matches)}")

for i in range(len(kp_matches) - 1):
    end_prev = kp_matches[i].end()
    start_next = kp_matches[i+1].start()
    
    gap_text = list_text[end_prev:start_next]
    
    # Find the closing ) of the constructor.
    # Since KnowledgePoint has nested lists with ), we need to be careful.
    # Let's count parentheses or just find the last ), in the gap.
    
    last_bracket_comma = gap_text.rfind('),')
    if last_bracket_comma != -1:
        garbage = gap_text[last_bracket_comma+2:].strip()
        if garbage and garbage != ',':
            # Find line number
            abs_start = base_offset + end_prev + last_bracket_comma + 2
            line_no = content.count('\n', 0, abs_start) + 1
            print(f"GARBAGE starting at line {line_no} (between instance {i+1} and {i+2}):")
            print(f"--- START ---\n{garbage}\n--- END ---")
