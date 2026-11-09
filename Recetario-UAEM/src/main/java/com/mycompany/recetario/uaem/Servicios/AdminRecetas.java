package com.mycompany.recetario.uaem.Servicios;

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

    public void Agregar(Receta receta) {
        recetas.add(receta);
        Archivo_Excel.GuardarRecetas(recetas);
        System.out.print(recetas.size());
    }

    public void Editar(int id, String Titulo, String Descripcion, String Clasificacion,
            String Ingredientes, String Procedimiento) {
        Receta r = Buscar(id);
        if (r == null) {
            return;
        }
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
        System.out.print(recetas.size());
        Receta r = Buscar(id);
        if (r == null) {
            return;
        }
        recetas.remove(r);
        Archivo_Excel.GuardarRecetas(recetas);
        System.out.print(recetas.size());
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
}
