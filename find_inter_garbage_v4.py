
import re

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

list_match = re.search(r'val allPoints = listOf\((.*)\)', content, re.DOTALL)
if not list_match:
    print("Could not find allPoints list")
    exit()

list_text = list_match.group(1)
base_offset = content.find(list_text)

kp_matches = list(re.finditer(r'KnowledgePoint\(', list_text))

for i in range(len(kp_matches)):
    start_this = kp_matches[i].start()
    end_this = len(list_text) if i == len(kp_matches) - 1 else kp_matches[i+1].start()
    
    this_kp_chunk = list_text[start_this:end_this]
    
    # Find the closing parenthesis of the KnowledgePoint(...) call.
    # It should be a ) followed by a comma (or just whitespace if it's the last one).
    # Since there are nested ), we need to find the one at depth 0.
    
    depth = 0
    closing_idx = -1
    for j, char in enumerate(this_kp_chunk):
        if char == '(':
            depth += 1
        elif char == ')':
            depth -= 1
            if depth == 0:
                closing_idx = j
                break
    
    if closing_idx != -1:
        after_closing = this_kp_chunk[closing_idx+1:].strip()
        if after_closing and after_closing != ',':
            # We found garbage!
            abs_start = base_offset + start_this + closing_idx + 1
            line_no = content.count('\n', 0, abs_start) + 1
            print(f"GARBAGE after KP {i+1} (ends at line {line_no}):")
            print(f"--- START ---\n{after_closing[:500]}\n--- END ---")
