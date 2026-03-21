import os
import re

directories = ['app/src/main/java/com/example/insight/ui/screens', 'app/src/main/java/com/example/insight/camera']
icons_to_mirror = ['ArrowBack', 'Assignment', 'KeyboardArrowRight', 'HelpOutline', 'ArrowForward']

for directory in directories:
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith('.kt'):
                filepath = os.path.join(root, file)
                with open(filepath, 'r', encoding='utf-8') as f:
                    content = f.read()
                
                original_content = content
                
                # Replace Icons.Default.X with Icons.AutoMirrored.Filled.X
                for icon in icons_to_mirror:
                    content = re.sub(rf'Icons\.Default\.{icon}\b', f'Icons.AutoMirrored.Filled.{icon}', content)
                
                # Replace Icons.Filled.X with Icons.AutoMirrored.Filled.X
                for icon in icons_to_mirror:
                    content = re.sub(rf'Icons\.Filled\.{icon}\b', f'Icons.AutoMirrored.Filled.{icon}', content)
                
                # Add the automirrored import if we made a change and it's not there
                if content != original_content and 'androidx.compose.material.icons.automirrored.filled' not in content:
                    # Insert after the existing material.icons import
                    content = re.sub(
                        r'(import androidx\.compose\.material\.icons\..*\n)',
                        r'\1import androidx.compose.material.icons.automirrored.filled.*\n',
                        content,
                        count=1
                    )
                
                if content != original_content:
                    with open(filepath, 'w', encoding='utf-8') as f:
                        f.write(content)
                    print(f"Updated {filepath}")
