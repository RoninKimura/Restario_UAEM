package com.mycompany.recetario.uaem.Archivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.scene.image.Image;

/**
 *
 * @author angel
 */
public class Imagen {

    private static final Path DIR = Paths.get("datos", "imagenes");

    public static String Guardar(File origen) throws IOException {
        Files.createDirectories(DIR);
        String nombre = System.currentTimeMillis() + "_" + origen.getName().replace(" ", "_");
        Files.copy(origen.toPath(), DIR.resolve(nombre), StandardCopyOption.REPLACE_EXISTING);
        return nombre;
    }

    public static File Archivo(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return null;
        }
        File f = DIR.resolve(nombre).toFile();
        return f.exists() ? f : null;
    }

    public static Image Cargar(String nombre, double ancho, double alto) {
        File f = Archivo(nombre);
        if (f == null) {
            return null;
        }
        return new Image(f.toURI().toString(), ancho, alto, true, true);
    }
}
