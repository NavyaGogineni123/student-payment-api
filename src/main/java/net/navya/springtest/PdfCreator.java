package net.navya.springtest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreator {

    public static void main(String[] args) {
        createPdf();

    }
   // 100.23.44.220:8080
    //100.23.44.220: 3036
    public static void createPdf(){

        try {
            //Create Document instance.


            Document document = new Document();

            //Create OutputStream instance.
            OutputStream outputStream =
                    new FileOutputStream(new File("./TestFile.pdf"));

            //Create PDFWriter instance.
            PdfWriter.getInstance(document, outputStream);

            //Open the document.
            document.open();

            //Add content to the document.
            document.add(new Paragraph("Hello world, " +
                    "this is a test pdf file."));
            document.add(new Paragraph("This team is awesome team, everyone will get job quickly"));

            //Close document and outputStream.
            document.close();
            outputStream.close();

            System.out.println("Pdf created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
