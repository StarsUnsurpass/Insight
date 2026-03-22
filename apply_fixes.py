import os

fp = r'E:\Code\IDE\AndroidStudio\Insight\app\src\main\java\com\example\insight\ui\schedule\ScheduleScreen.kt'
with open(fp, 'r', encoding='utf-8') as f:
    text = f.read()

# 1. Unused e parameter
text = text.replace('.addOnFailureListener { e ->', '.addOnFailureListener { _ ->')

# 2. AddCourseBottomSheetContent removal of onDismiss
dismiss_block = """                onDismiss = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion { 
                        if (!sheetState.isVisible) showAddCourseDialog = false
                    }
                },
"""
text = text.replace(dismiss_block, '')

text = text.replace('    onDismiss: () -> Unit,\n', '')

# 3. eveningCount to 3
text = text.replace('var eveningCount by remember { mutableStateOf(2) }', 'var eveningCount by remember { mutableStateOf(3) }')

# 4. 晚上节数 to 晚自习节数
text = text.replace('Text("晚上节数")', 'Text("晚自习节数")')

# 5. Icons deprecation
text = text.replace('Icons.Default.KeyboardArrowLeft', 'Icons.AutoMirrored.Filled.KeyboardArrowLeft')
text = text.replace('Icons.Default.KeyboardArrowRight', 'Icons.AutoMirrored.Filled.KeyboardArrowRight')

with open(fp, 'w', encoding='utf-8') as f:
    f.write(text)

print('Success!')
