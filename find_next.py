
file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
start_idx = 2930 # line 2931

with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()
    count = 0
    for i in range(start_idx, len(lines)):
        if 'KnowledgePoint(' in lines[i]:
            print(f"{i+1}: {lines[i].strip()}")
            count += 1
            if count >= 5:
                break
