
import re

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Find all KnowledgePoint( ... ) calls
# This is a bit hard with regex for complex objects, but let's try to count them
matches = re.findall(r'KnowledgePoint\(', content)
print(f"Total KnowledgePoint calls: {len(matches)}")

# Let's find IDs
ids = re.findall(r'id = "([^"]+)"', content)
print(f"Total KnowledgePoint IDs: {len(ids)}")
print(f"Unique IDs: {len(set(ids))}")

# Identify duplicates or issues
from collections import Counter
c = Counter(ids)
for id, count in c.items():
    if count > 1:
        print(f"DUPLICATE ID: {id} ({count} times)")
