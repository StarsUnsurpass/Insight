
import os

files = ["fix_adj_adv.py", "fix_conjunctions.py", "fix_numerals.py", "fix_past_continuous.py", "fix_prepositions.py", "fix_present_continuous.py"]

for f_name in files:
    if not os.path.exists(f_name):
        continue
    # Try reading as GBK
    try:
        with open(f_name, 'rb') as f:
            data = f.read()
        
        # Remove the # -*- coding: utf-8 -*- line if I added it wrongly
        text = data.decode('gbk')
        if text.startswith('# -*- coding: utf-8 -*-'):
            text = text[text.find('\n')+1:]
            
        # Write back as UTF-8
        with open(f_name, 'w', encoding='utf-8') as f:
            f.write(text)
        print(f"Converted {f_name} to UTF-8")
    except Exception as e:
        print(f"Failed to convert {f_name}: {e}")
