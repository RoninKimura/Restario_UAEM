package com.mycompany.recetario.uaem.Archivos;

import com.mycompany.recetario.uaem.Modelo.Receta;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.io.*;

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
        File archivoImagen = Imagen.Archivo(r.getImagen());
        if (archivoImagen != null) {
            doc.add(new Image(ImageDataFactory.create(archivoImagen.getAbsolutePath()))
                    .scaleToFit(300, 200));
        }
        doc.add(new Paragraph("Clasificacion: " + r.getCalsificacion()));
        doc.add(new Paragraph(r.getDescripcion()));
        doc.add(new Paragraph("Ingredientes").setFont(negrita).setFontSize(14));
        doc.add(new Paragraph(r.getIngredientes()));
        doc.add(new Paragraph("Procedimiento").setFont(negrita).setFontSize(14));
        doc.add(new Paragraph(r.getProcedimiento()));

        doc.close();
    }
}
