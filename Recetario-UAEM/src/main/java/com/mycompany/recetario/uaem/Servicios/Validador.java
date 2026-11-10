package com.mycompany.recetario.uaem.Servicios;

import com.mycompany.recetario.uaem.Excepciones.Validacion;
import java.io.File;
import java.util.regex.Pattern;
/**
 *
 * @author angel
 */
public class Validador {
    
    private static final Pattern TITULO = Pattern.compile("^[\\p{L}0-9 .,'()\\-]+$");
    private static final Pattern NOMBRE = Pattern.compile("^[\\p{L} ]+$");
    private static final long MAX_IMAGEN = 5L * 1024 * 1024; // 5 MB

    public static void ValidarReceta(String titulo, String descripcion, Object clasificacion,
            String ingredientes, String procedimiento, File imagen) throws Validacion {
        Texto("El titulo", titulo, 3, 50, TITULO,
                "solo puede tener letras, numeros, espacios y . , ' ( ) -");
        Texto("La descripcion", descripcion, 5, 200, null, null);
        if (clasificacion == null) {
            throw new Validacion("Selecciona una clasificacion.");
        }
        Texto("Los ingredientes", ingredientes, 5, 1000, null, null);
        Texto("El procedimiento", procedimiento, 10, 3000, null, null);
        ValidarImagen(imagen);
    }

    public static void ValidarClasificacion(String nombre, String descripcion)
            throws Validacion {
        Texto("El nombre", nombre, 3, 30, NOMBRE, "solo puede tener letras y espacios");
        Texto("La descripcion", descripcion, 5, 150, null, null);
    }

    public static void ValidarImagen(File imagen) throws Validacion {
        if (imagen == null) {
            return;
        }
        String n = imagen.getName().toLowerCase();
        if (!(n.endsWith(".png") || n.endsWith(".jpg") || n.endsWith(".jpeg")
                || n.endsWith(".gif"))) {
            throw new Validacion("La imagen debe ser PNG, JPG o GIF.");
        }
        if (imagen.length() > MAX_IMAGEN) {
            throw new Validacion("La imagen no puede pesar mas de 5 MB.");
        }
    }

    private static void Texto(String campo, String valor, int min, int max,
            Pattern patron, String formato) throws Validacion {
        String v = valor == null ? "" : valor.trim();
        if (v.isEmpty()) {
            throw new Validacion(campo + " es obligatorio.");
        }
        if (v.length() < min || v.length() > max) {
            throw new Validacion(campo + " debe tener entre " + min + " y "
                    + max + " caracteres (tiene " + v.length() + ").");
        }
        if (patron != null && !patron.matcher(v).matches()) {
            throw new Validacion(campo + " " + formato + ".");
        }
    }
}
