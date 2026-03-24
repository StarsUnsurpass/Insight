
import re

file_path = 'app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt'
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# Split by KnowledgePoint(
blocks = content.split('KnowledgePoint(')
print(f"Total blocks: {len(blocks)}")

for i, block in enumerate(blocks[1:]): # skip the preamble
    # Find ID in the block
    id_match = re.search(r'id = "([^"]+)"', block)
    if not id_match:
        # If it doesn't have an ID, it's malformed or a false positive
        print(f"MALFORMED BLOCK at call {i+1}:")
        print(block[:200]) # print start
    else:
        # Check if it has closing )
        # This is a bit hard, let's just see how many IDs it has
        ids_in_block = re.findall(r'id = "([^"]+)"', block)
        if len(ids_in_block) > 1:
            print(f"WARNING: Block {i+1} has MULTIPLE IDs: {ids_in_block}")
