package com.mycompany.recetario.uaem.Servicios;

import com.mycompany.recetario.uaem.Excepciones.Duplicado;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Archivos.Archivo_Excel;

import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author You
 */
public class AdminRecetas {

    private int Id = 0;
    private ArrayList<Receta> recetas;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public AdminRecetas() {
        recetas = Archivo_Excel.CargarRecetas();
        for (Receta r : recetas) {
            if (r.getid() >= Id) {
                Id = r.getid() + 1;
            }
        }
    }

    public int ID() {
        return Id++;
    }

    public void Agregar(Receta receta) throws Duplicado {
        ValidarTitulo(receta.getTitulo(), -1);
        recetas.add(receta);
        Archivo_Excel.GuardarRecetas(recetas);
    }

    public void Editar(int id, String Imagen, String Titulo, String Descripcion, String Clasificacion,
            String Ingredientes, String Procedimiento) throws Duplicado {
        Receta r = Buscar(id);
        if (r == null) {
            return;
        }
        ValidarTitulo(Titulo, id);
        r.setImagen(Imagen);
        r.setTitulo(Titulo);
        r.setDescripcion(Descripcion);
        r.setClasificacion(Clasificacion);
        r.setIngredientes(Ingredientes);
        r.setProcedimiento(Procedimiento);
        Archivo_Excel.GuardarRecetas(recetas);
        alert.setContentText("Se modifico " + r.getTitulo() + " Correctamente");
        alert.showAndWait();
    }

    public void Eliminar(int id) {
        Receta r = Buscar(id);
        if (r == null) {
            return;
        }
        recetas.remove(r);
        Archivo_Excel.GuardarRecetas(recetas);
        alert.setContentText("Se elimino Correctamente");
        alert.showAndWait();
    }

    public Receta Buscar(int id) {
        for (Receta r : recetas) {
            if (r.getid() == id) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<Receta> Obtener_Recetas() {
        return recetas;
    }

    public ArrayList<Receta> Filtrar(String clasificacion, String texto) {
        ArrayList<Receta> resultado = new ArrayList<>();
        String t = texto == null ? "" : texto.trim().toLowerCase();
        for (Receta r : recetas) {
            if (clasificacion != null && !clasificacion.equals(r.getCalsificacion())) {
                continue;
            }
            if (!t.isEmpty() && !seguro(r.getTitulo()).contains(t)
                    && !seguro(r.getIngredientes()).contains(t)
                    && !seguro(r.getDescripcion()).contains(t)) {
                continue;
            }
            resultado.add(r);
        }
        return resultado;
    }

    private String seguro(String valor) { return valor == null ? "" : valor.toLowerCase(java.util.Locale.ROOT); }

    public void ValidarTitulo(String titulo, int idIgnorar) throws Duplicado {
        if (titulo == null || !titulo.trim().matches(".*[\\p{L}].*")) {
            throw new Duplicado("El titulo debe contener al menos una letra; no se aceptan titulos formados solo por numeros.");
        }
        if (ExisteTitulo(titulo, idIgnorar)) {
            throw new Duplicado("Ya existe una receta llamada \"" + titulo.trim() + "\".");
        }
    }

    public boolean ExisteTitulo(String titulo, int idIgnorar) {
        for (Receta r : recetas) {
            if (r.getid() != idIgnorar && r.getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
                return true;
            }
        }
        return false;
    }
}
