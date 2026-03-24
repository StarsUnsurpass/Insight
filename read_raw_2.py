
file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()
    for i in range(2839, 2855):
        print(f"{i+1}: '{lines[i]}'")
