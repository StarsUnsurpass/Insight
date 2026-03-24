
import os
import re

def fix_orphans(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()

    # Find all KnowledgePoint( starts
    kp_starts = [m.start() for m in re.finditer(r'KnowledgePoint\(', content)]
    
    new_segments = []
    last_end = 0
    
    # Header before first KP
    new_segments.append(content[:kp_starts[0]])
    
    for i, start in enumerate(kp_starts):
        # Find closing bracket for this KP
        stack = 0
        end = -1
        for j in range(start, len(content)):
            if content[j] == '(': stack += 1
            elif content[j] == ')':
                stack -= 1
                if stack == 0:
                    end = j + 1
                    break
        
        if end == -1:
            print(f"Unclosed KnowledgePoint starting at index {start}")
            # Keep the rest of the file if it's the last one and unclosed
            new_segments.append(content[start:])
            break
            
        # Add the valid KP block
        new_segments.append(content[start:end])
        
        # Check if there is another KP
        if i + 1 < len(kp_starts):
            next_start = kp_starts[i+1]
            # Between end and next_start, there should only be whitespace and a comma
            inter_content = content[end:next_start]
            if re.search(r'\w', inter_content):
                print(f"Found orphan content between KP {i} and {i+1} (length {len(inter_content)})")
                # Discard orphan content, just add a comma and newline
                new_segments.append(",\n                ")
            else:
                new_segments.append(inter_content)
        else:
            # Final KP, add the tail
            new_segments.append(content[end:])
            
    fixed_content = "".join(new_segments)
    
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(fixed_content)
    print("Cleaned up orphaned blocks.")

if __name__ == "__main__":
    fix_orphans('app/src/main/java/com/example/insight/data/model/KnowledgePoint.kt')
