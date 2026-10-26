package com.mycompany.recetario.uaem.Servicios;

import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import java.util.ArrayList;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

/**
 *
 * @author You
 */
public class AdminClasificaciones {

    private ArrayList<Clasificacion> clasificaciones = new ArrayList();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void Agregar(Clasificacion clasificacion) {
            clasificaciones.add(clasificacion);
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setContentText(clasificacion.getNombre() + " Agregada Correctamente");
            alert.showAndWait();
    }

    public void Editar(int id, String nombre, String descripcion, Color color) {
            clasificaciones.get(id).setNombre(nombre);
            clasificaciones.get(id).setDescripcion(descripcion);
            clasificaciones.get(id).setColor(color);
            alert.setContentText("Se modifico " + clasificaciones.get(id).getNombre() + " Correctamente");
            alert.showAndWait();
    }

    public void Eliminar(int id) {
        alert.setContentText(clasificaciones.get(id).getNombre()
                + " Fue Eliminada");
        alert.showAndWait();
        clasificaciones.remove(id);
        System.out.print(clasificaciones.size());
    }

    public boolean ExisteNombre(String nombre) {
        for (int d = 0; d < clasificaciones.size(); d++) {
            if (nombre.equals(clasificaciones.get(d).getNombre())) {
                return true;
            }
        }
        return false;
    }
    public boolean ExisteNombreE(String nombre, int id) {
        for (int d = 0; d < clasificaciones.size(); d++) {
            if (nombre.equals(clasificaciones.get(d).getNombre()) && d!=id) {
                return true;
            }
        }
        return false;
    }
}
