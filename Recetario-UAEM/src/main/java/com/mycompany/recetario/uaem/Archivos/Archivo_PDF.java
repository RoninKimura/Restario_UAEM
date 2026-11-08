package com.mycompany.recetario.uaem.Archivos;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.mycompany.recetario.uaem.Modelo.Receta;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author angel
 */
public class Archivo_PDF {
     public static void GenerarReceta(Receta r, File destino) throws IOException {
        PdfWriter writer = new PdfWriter(destino);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);

        PdfFont negrita = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        doc.add(new Paragraph(r.getTitulo()).setFont(negrita).setFontSize(22));
        doc.add(new Paragraph("Clasificacion: " + r.getCalsificacion()));
        doc.add(new Paragraph(r.getDescripcion()));
        doc.add(new Paragraph("Ingredientes").setFont(negrita).setFontSize(14));
        doc.add(new Paragraph(r.getIngredientes()));
        doc.add(new Paragraph("Procedimiento").setFont(negrita).setFontSize(14));
        doc.add(new Paragraph(r.getProcedimiento()));

        doc.close();
    }
}
