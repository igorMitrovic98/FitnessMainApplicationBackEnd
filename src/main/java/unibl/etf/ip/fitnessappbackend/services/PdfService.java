package unibl.etf.ip.fitnessappbackend.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.models.Day;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    public ByteArrayOutputStream generatePdf(List<Day> dayList) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();
        for (Day day : dayList) {
            document.add(new Paragraph("Date: " + day.getDate()));
            document.add(new Paragraph("Exercise Type: " + day.getExcersiseType()));
            document.add(new Paragraph("Duration: " + day.getDuration() + " minutes"));
            document.add(new Paragraph("Intensity: " + day.getIntensity()));
            document.add(new Paragraph("Calories burnt: " + day.getResult() +" kCal"));
            document.add(new Paragraph("Weight: " + day.getWeight() + " kg"));
            document.add(new Paragraph("----------------------------------"));
        }
        document.close();
        return baos;
    }
}
