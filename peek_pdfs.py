import pdfplumber

def peek_pdf(path, pages_to_read):
    with pdfplumber.open(path) as pdf:
        for i in range(min(pages_to_read, len(pdf.pages))):
            print(f"--- Page {i+1} ---")
            print(pdf.pages[i].extract_text()[:1000])

print("PEEKING GRADE 7 UP")
peek_pdf("e:/Code/IDE/AndroidStudio/Insight/2025秋《教材帮》英语人教版七年级上册.pdf", 5)
print("\nPEEKING GRADE 8 UP")
peek_pdf("e:/Code/IDE/AndroidStudio/Insight/2025秋《教材帮》英语人教版八年级上册.pdf", 5)
