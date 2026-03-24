
import sys

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
start = int(sys.argv[1])
end = int(sys.argv[2])

with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()
    for i in range(start-1, min(end, len(lines))):
        print(f"{i+1}: {lines[i].strip()}")
