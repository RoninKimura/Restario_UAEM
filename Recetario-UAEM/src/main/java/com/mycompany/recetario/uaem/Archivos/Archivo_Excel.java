package com.mycompany.recetario.uaem.Archivos;

import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Modelo.Receta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author angel
 */
public class Archivo_Excel {

    private static final File F_RECETAS = Paths.get("datos", "recetas.xlsx").toFile();
    private static final File F_CLAS = Paths.get("datos", "clasificaciones.xlsx").toFile();

    public static void GuardarRecetas(ArrayList<Receta> recetas) {
        try {
            Files.createDirectories(F_RECETAS.toPath().getParent());
            ExportarRecetas(recetas, F_RECETAS);
        } catch (IOException e) {
            ErrorGuardar("las recetas");
        }
    }

    public static ArrayList<Receta> CargarRecetas() {
        ArrayList<Receta> lista = new ArrayList<>();
        if (!F_RECETAS.exists()) {
            return lista;
        }
        DataFormatter fmt = new DataFormatter();
        try (FileInputStream in = new FileInputStream(F_RECETAS); Workbook libro = new XSSFWorkbook(in)) {
            Sheet hoja = libro.getSheetAt(0);
            for (int i = 1; i <= hoja.getLastRowNum(); i++) { // fila 0 = encabezados
                Row f = hoja.getRow(i);
                if (f == null) {
                    continue;
                }
                String id = fmt.formatCellValue(f.getCell(0)).trim();
                if (id.isEmpty()) {
                    continue;
                }
                lista.add(new Receta(Integer.parseInt(id),
                        fmt.formatCellValue(f.getCell(1)),
                        fmt.formatCellValue(f.getCell(2)),
                        fmt.formatCellValue(f.getCell(3)),
                        fmt.formatCellValue(f.getCell(4)),
                        fmt.formatCellValue(f.getCell(5)),
                        fmt.formatCellValue(f.getCell(6))));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer recetas.xlsx: " + e.getMessage());
        }
        return lista;
    }

    public static void GuardarClasificaciones(ArrayList<Clasificacion> lista) {
        try (Workbook libro = new XSSFWorkbook()) {
            Files.createDirectories(F_CLAS.toPath().getParent());
            Sheet hoja = libro.createSheet("Clasificaciones");

            Font negrita = libro.createFont();
            negrita.setBold(true);
            CellStyle estilo = libro.createCellStyle();
            estilo.setFont(negrita);

            String[] encabezados = {"Nombre", "Descripcion", "Color"};
            Row fila0 = hoja.createRow(0);
            for (int i = 0; i < encabezados.length; i++) {
                Cell celda = fila0.createCell(i);
                celda.setCellValue(encabezados[i]);
                celda.setCellStyle(estilo);
            }

            int fila = 1;
            for (Clasificacion c : lista) {
                Row f = hoja.createRow(fila++);
                f.createCell(0).setCellValue(c.getNombre());
                f.createCell(1).setCellValue(c.getDescripcion());
                f.createCell(2).setCellValue(
                        c.getColor() == null ? "0xffffffff" : c.getColor().toString());
            }
            for (int i = 0; i < 3; i++) {
                hoja.autoSizeColumn(i);
            }

            try (FileOutputStream salida = new FileOutputStream(F_CLAS)) {
                libro.write(salida);
            }
        } catch (IOException e) {
            ErrorGuardar("las clasificaciones");
        }
    }

    public static ArrayList<Clasificacion> CargarClasificaciones() {
        ArrayList<Clasificacion> lista = new ArrayList<>();
        if (!F_CLAS.exists()) {
            return lista;
        }
        DataFormatter fmt = new DataFormatter();
        try (FileInputStream in = new FileInputStream(F_CLAS); Workbook libro = new XSSFWorkbook(in)) {
            Sheet hoja = libro.getSheetAt(0);
            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                Row f = hoja.getRow(i);
                if (f == null) {
                    continue;
                }
                String nombre = fmt.formatCellValue(f.getCell(0)).trim();
                if (nombre.isEmpty()) {
                    continue;
                }
                lista.add(new Clasificacion(nombre, fmt.formatCellValue(f.getCell(1)),
                        ColorDeTexto(fmt.formatCellValue(f.getCell(2)))));
            }
        } catch (IOException e) {
            System.out.println("Error al leer clasificaciones.xlsx: " + e.getMessage());
        }
        return lista;
    }

    public static void ExportarRecetas(ArrayList<Receta> recetas, File destino)
            throws IOException {
        try (Workbook libro = new XSSFWorkbook(); FileOutputStream salida = new FileOutputStream(destino)) {

            Sheet hoja = libro.createSheet("Recetas");

            Font negrita = libro.createFont();
            negrita.setBold(true);
            CellStyle estilo = libro.createCellStyle();
            estilo.setFont(negrita);

            String[] encabezados = {"ID", "Imagen", "Titulo", "Descripcion", "Clasificacion",
                "Ingredientes", "Procedimiento"};
            Row encabezado = hoja.createRow(0);
            for (int i = 0; i < encabezados.length; i++) {
                Cell celda = encabezado.createCell(i);
                celda.setCellValue(encabezados[i]);
                celda.setCellStyle(estilo);
            }

            int fila = 1;
            for (Receta r : recetas) {
                Row f = hoja.createRow(fila++);
                f.createCell(0).setCellValue(r.getid());
                f.createCell(1).setCellValue(r.getImagen() == null ? "" : r.getImagen());
                f.createCell(2).setCellValue(r.getTitulo());
                f.createCell(3).setCellValue(r.getDescripcion());
                f.createCell(4).setCellValue(r.getCalsificacion());
                f.createCell(5).setCellValue(r.getIngredientes());
                f.createCell(6).setCellValue(r.getProcedimiento());
            }

            for (int i = 0; i < 4; i++) {
                hoja.autoSizeColumn(i);
            }
            hoja.setColumnWidth(4, 50 * 256);
            hoja.setColumnWidth(5, 60 * 256);

            libro.write(salida);
        }
    }

    private static Color ColorDeTexto(String texto) {
        try {
            return Color.web(texto);
        } catch (Exception e) {
            return Color.WHITE;
        }
    }

    private static void ErrorGuardar(String que) {
        new Alert(Alert.AlertType.ERROR, "No se pudieron guardar " + que
                + ". Si tienes el archivo de Excel abierto, cierralo e intenta de nuevo.")
                .showAndWait();
    }
}
