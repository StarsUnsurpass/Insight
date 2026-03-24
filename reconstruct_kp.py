
import re

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Identify the preamble (everything before val allPoints = listOf()
# and the postamble (everything after the closing ) of the list)

list_start_marker = 'val allPoints = listOf('
list_start_idx = content.find(list_start_marker)
if list_start_idx == -1:
    print("Could not find list start")
    exit()

preamble = content[:list_start_idx + len(list_start_marker)]

# Find the end of the list. It's the last ) before the object end.
# Actually, let's find the closing ) of the listOf call.
# We'll use paren counting starting from list_start_idx + len(list_start_marker) - 1

depth = 0
list_end_idx = -1
for i in range(list_start_idx + len(list_start_marker) - 1, len(content)):
    if content[i] == '(':
        depth += 1
    elif content[i] == ')':
        depth -= 1
        if depth == 0:
            list_end_idx = i
            break

if list_end_idx == -1:
    print("Could not find list end")
    exit()

postamble = content[list_end_idx:]
list_text = content[list_start_idx + len(list_start_marker) : list_end_idx]

# 2. Extract all KnowledgePoint( ... ) calls from list_text
kps = []
matches = list(re.finditer(r'KnowledgePoint\(', list_text))

for i, match in enumerate(matches):
    start = match.start()
    # Find matching )
    depth = 0
    closing_idx = -1
    for j in range(start, len(list_text)):
        if list_text[j] == '(':
            depth += 1
        elif list_text[j] == ')':
            depth -= 1
            if depth == 0:
                closing_idx = j
                break
    
    if closing_idx != -1:
        kp_content = list_text[start : closing_idx + 1]
        kps.append(kp_content)

# 3. Rebuild the list content
# We'll normalize indentation to 8 spaces for the KnowledgePoint call
new_list_content = ""
for kp in kps:
    # Basic cleanup of the extracted block
    lines = kp.strip().split('\n')
    if not lines: continue
    
    # First line should be KnowledgePoint(
    new_list_content += "\n        KnowledgePoint(\n"
    
    # Remaining lines: try to keep their relative indentation or just lstrip and add spaces
    for line in lines[1:-1]:
        new_list_content += "            " + line.strip() + "\n"
    
    if len(lines) > 1:
        new_list_content += "        )"
    else:
        # Single line KP? Unlikely here but handle it
        pass
    
    new_list_content += ","

# Remove last comma and add a newline
if new_list_content.endswith(','):
    new_list_content = new_list_content[:-1]
new_list_content += "\n    "

# 4. Write back
new_full_content = preamble + new_list_content + postamble

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_full_content)

print(f"Reconstructed {len(kps)} KnowledgePoints.")
