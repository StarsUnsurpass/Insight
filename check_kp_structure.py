
import sys

path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

kp_starts = []
kp_ends = []

for i, line in enumerate(lines):
    if 'KnowledgePoint(' in line:
        kp_starts.append(i + 1)
    if '        ),' in line and 'id =' not in lines[i-1]: # heuristic for end of KP
        # Check if it actually ends a KP by looking back
        # This is tricky with fuzzy code, but let's try
        kp_ends.append(i + 1)

print(f"Starts: {len(kp_starts)}")
# Let's count properly by balance
content = "".join(lines)
import re
kp_matches = list(re.finditer(r'KnowledgePoint\(', content))
print(f"Actual KnowledgePoint( calls: {len(kp_matches)}")

# Check balance for each KP
for m in kp_matches:
    start = m.start()
    # find the closing ) for this (
    stack = 1
    i = m.end()
    while stack > 0 and i < len(content):
        if content[i] == '(': stack += 1
        elif content[i] == ')': stack -= 1
        i += 1
    
    if stack == 0:
        # success
        pass
    else:
        line = content.count('\n', 0, start) + 1
        print(f"KP at line {line} is never closed!")

# Check if they are all inside allPoints
all_points_start = content.find('val allPoints = listOf(')
all_points_end = content.rfind('    )') # Should be the one before the last }

print(f"allPoints start: {all_points_start}")
print(f"allPoints end: {all_points_end}")

# Any KP outside this range?
for m in kp_matches:
    if m.start() < all_points_start or m.start() > all_points_end:
        line = content.count('\n', 0, m.start()) + 1
        print(f"KP at line {line} is OUTSIDE allPoints!")
