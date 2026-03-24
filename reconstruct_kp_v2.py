
import re

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Identify preamble and postamble
list_start_marker = 'val allPoints = listOf('
list_start_idx = content.find(list_start_marker)
preamble = content[:list_start_idx + len(list_start_marker)]

# Postamble: everything after the very last ) in the file? No, that's too much.
# Let's find the closing ) of the listOf call by searching from the END of the file
# for the last ) followed by whitespace and then maybe } or end of file.
# The file ends with:
#     )
# }
postamble_match = re.search(r'\s+\)\s+\}\s*$', content)
if postamble_match:
    postamble = postamble_match.group(0)
else:
    postamble = "\n    )\n}"

# 2. Find all KnowledgePoint calls in the entire content
all_kps = []
matches = list(re.finditer(r'KnowledgePoint\(', content))

# Skip the first match if it's the data class definition
# How to know? Data class definition starts with 'data class KnowledgePoint('
for i, match in enumerate(matches):
    start_idx = match.start()
    # Check if it's the definition
    if "data class" in content[start_idx-20 : start_idx]:
        continue
        
    # Extract the block using paren counting
    depth = 0
    closing_idx = -1
    for j in range(start_idx, len(content)):
        if content[j] == '(':
            depth += 1
        elif content[j] == ')':
            depth -= 1
            if depth == 0:
                closing_idx = j
                break
    
    if closing_idx != -1:
        kp_content = content[start_idx : closing_idx + 1]
        # Extract ID to avoid duplicates (keep the first one we find for each ID)
        id_match = re.search(r'id = "([^"]+)"', kp_content)
        if id_match:
            kp_id = id_match.group(1)
            all_kps.append((kp_id, kp_content))

# 3. Filter to unique IDs, keeping the FIRST occurrence (usually the most complete one)
unique_kps = {}
for kp_id, kp_content in all_kps:
    if kp_id not in unique_kps:
        unique_kps[kp_id] = kp_content
    else:
        # If we already have it, check if this one is longer?
        if len(kp_content) > len(unique_kps[kp_id]):
             unique_kps[kp_id] = kp_content

print(f"Found {len(all_kps)} total KnowledgePoint calls.")
print(f"Found {len(unique_kps)} unique KnowledgePoint IDs.")

# 4. Rebuild the list
# We want to preserve the order if possible.
# Let's get the list of unique IDs in order of first appearance
ordered_ids = []
seen = set()
for kp_id, _ in all_kps:
    if kp_id not in seen:
        ordered_ids.append(kp_id)
        seen.add(kp_id)

new_list_content = ""
for kp_id in ordered_ids:
    kp = unique_kps[kp_id]
    lines = kp.strip().split('\n')
    new_list_content += "\n        KnowledgePoint(\n"
    for line in lines[1:-1]:
        new_list_content += "            " + line.strip() + "\n"
    new_list_content += "        ),"

# Cleanup last comma
if new_list_content.endswith(','):
    new_list_content = new_list_content[:-1]
new_list_content += "\n    "

# 5. Final assembly
new_full_content = preamble + new_list_content + postamble

with open(file_path, 'w', encoding='utf-8') as f:
    f.write(new_full_content)

print(f"Successfully reconstructed KnowledgePoint.kt with {len(unique_kps)} points.")
