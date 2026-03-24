
import re
import sys

def check_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    in_triple_quote = False
    for i, line in enumerate(lines):
        # Toggle triple quote state
        if '"""' in line:
            if line.count('"""') % 2 != 0:
                in_triple_quote = not in_triple_quote
            continue
            
        if in_triple_quote:
            continue
            
        # Check for unclosed double quote
        # Exclude escaped quotes
        quotes = re.findall(r'(?<!\\)"', line)
        if len(quotes) % 2 != 0:
            print(f"Potential syntax error in {file_path} at line {i+1}: {line.strip()}")

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
check_file(file_path)
