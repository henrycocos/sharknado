package fh.prog.lab.it.pdf;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
public class Test_Lieferschein {
 
    private static String FILE = "Test.pdf";
    private static Font fett = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 12);
    private static Font unterstrich = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.UNDERLINE);
 
    private static Date datum = new Date();
    private static String strasseNr = "Goethestraße 1";
    private static String plz = "60313";
    private static String ort = "Frankfurt";
    private static String tel = "Tel. +49/(0)69-55555-0";
    private static String fax = "Fax +49/(0)69-55555-100";
    private static String email = "http://sharnado.com";
    private static String name = "Sharknade Enterprises";
 
//    public static void main(String[] args) {
//        try {
//            Document document = new Document(PageSize.A4, 50, 30, 50, 30);
//            PdfWriter.getInstance(document, new FileOutputStream(FILE));
//            document.open();
//            fill(document);
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
// 
    private static void fill(Document document) throws DocumentException {
 
        //PDF ERSTELLEN
        Paragraph start = new Paragraph();
 
        start.add(new Paragraph(name, fett));
        addEmptyLine(start, 1);
 
        start.add(new Paragraph(strasseNr, fett));
        start.add(new Paragraph("D-" + plz + ort, fett));
        addEmptyLine(start, 1);
        start.add(new Paragraph(tel, fett));
        start.add(new Paragraph(fax,fett));
        start.add(new Paragraph(email + "                                                                       "+datum, fett));
        addEmptyLine(start, 1);
        start.add(new Paragraph(name + ", " + strasseNr + ", " + plz + " " + ort, unterstrich));
        addEmptyLine(start, 1);
        //Hier muss noch eine Datenbank abfragen FÜR Adresse rein von fiku
 
        start.add(new Paragraph("Test"));
        addEmptyLine(start, 1);
        addEmptyLine(start, 1);

        
        
        addEmptyLine(start, 1);
        start.add(new Paragraph("Dear Customer,", normal));
        addEmptyLine(start, 1);
        start.add(new Paragraph("Take a look at your awesome goodies:", normal));
        addEmptyLine(start, 1);
        document.add(start);
        start.clear();
        //TABELE
 
        PdfPTable table = new PdfPTable(3);
        PdfPCell c1 = new PdfPCell(new Phrase("Pos"));
        table.addCell(c1);
 
        c1 = new PdfPCell(new Phrase("Description"));
        table.addCell(c1);
 
        c1 = new PdfPCell(new Phrase("Count"));
        table.addCell(c1);
 
        int i = 0;
        String str = "";
        while (i != 3) {
            i++;
            str = String.valueOf(i);
            table.addCell("=" + str + "=");//ABFRAGE DATENBANK
            table.addCell("1 Stk");
        }
        document.add(table);
 
        start.add(new Paragraph("Calculation lapping occurs separately. The product remains our property up to the entire payment.", normal));
        addEmptyLine(start, 1);
        start.add(new Paragraph("Yours sincerely", normal));
        start.add(new Paragraph(name, normal));
        document.add(start);
 
    }
 
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}