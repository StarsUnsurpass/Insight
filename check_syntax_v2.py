
import sys

path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(path, 'r', encoding='utf-8') as f:
    content = f.read()

start_idx = content.find('id = "object_clause"')
end_idx = content.find('id = "attributive_clause"', start_idx)

if start_idx == -1 or end_idx == -1:
    print(f"Could not find markers: {start_idx}, {end_idx}")
    sys.exit(1)

# Backtrack to find KnowledgePoint(
kp_start = content.rfind('KnowledgePoint(', 0, start_idx)
sub_content = content[kp_start:end_idx]

stack = []
for i, c in enumerate(sub_content):
    if c == '(': stack.append(('(', i))
    elif c == '[': stack.append(('[', i))
    elif c == '{': stack.append(('{', i))
    elif c in ')}]':
        if not stack:
            line = content.count('\n', 0, kp_start + i) + 1
            print(f"Unmatched {c} at line {line}")
            continue
        open_c, open_i = stack.pop()
        if (open_c == '(' and c != ')') or (open_c == '[' and c != ']') or (open_c == '{' and c != '}'):
            line = content.count('\n', 0, kp_start + i) + 1
            print(f"Mismatched {open_c} with {c} at line {line}")

if stack:
    for c, i in stack:
        line = content.count('\n', 0, kp_start + i) + 1
        print(f"Unclosed {c} starting at line {line}")
else:
    print("Balanced!")
