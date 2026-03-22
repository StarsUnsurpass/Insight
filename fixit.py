import os
import re

schedule_screen_path = r'E:\Code\IDE\AndroidStudio\Insight\app\src\main\java\com\example\insight\ui\schedule\ScheduleScreen.kt'
main_screen_path = r'E:\Code\IDE\AndroidStudio\Insight\app\src\main\java\com\example\insight\ui\screens\MainScreen.kt'
grid_screen_path = r'E:\Code\IDE\AndroidStudio\Insight\app\src\main\java\com\example\insight\ui\schedule\ScheduleGrid.kt'

with open(schedule_screen_path, 'r', encoding='utf-8') as f:
    text = f.read()

text = text.replace('.addOnFailureListener { e ->', '.addOnFailureListener { _ ->')
text = text.replace('    onDismiss: () -> Unit,\n', '')

dismiss_block = '''                onDismiss = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion { 
                        if (!sheetState.isVisible) showAddCourseDialog = false
                    }
                },
'''
text = text.replace(dismiss_block, '')

text = text.replace('Icons.Default.KeyboardArrowLeft', 'Icons.AutoMirrored.Filled.KeyboardArrowLeft')
text = text.replace('Icons.Default.KeyboardArrowRight', 'Icons.AutoMirrored.Filled.KeyboardArrowRight')
text = text.replace('var eveningCount by remember { mutableStateOf(2) }', 'var eveningCount by remember { mutableStateOf(3) }')
text = text.replace('Text("晚上节数")', 'Text("晚自习节数")')

with open(schedule_screen_path, 'w', encoding='utf-8') as f:
    f.write(text)

with open(grid_screen_path, 'r', encoding='utf-8') as f:
    text3 = f.read()
text3 = text3.replace('SectionDivider("晚修"', 'SectionDivider("晚饭"')
with open(grid_screen_path, 'w', encoding='utf-8') as f:
    f.write(text3)

with open(main_screen_path, 'r', encoding='utf-8') as f:
    text2 = f.read()
text2 = text2.replace('Icons.Default.MenuBook', 'Icons.AutoMirrored.Filled.MenuBook')

# Also fix the MainScreen definition to remove the unused parameter completely:
# onNavigateToCoursewareEditor: (String) -> Unit,
text2 = re.sub(r'[ \t]*onNavigateToCoursewareEditor\s*:\s*\([^)]*\)\s*->\s*Unit,?\n?', '', text2)

with open(main_screen_path, 'w', encoding='utf-8') as f:
    f.write(text2)

print('Patched successfully!')
