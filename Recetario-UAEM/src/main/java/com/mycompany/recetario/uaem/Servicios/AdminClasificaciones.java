package com.mycompany.recetario.uaem.Servicios;

import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import java.util.ArrayList;
import javafx.scene.control.*;

/**
 *
 * @author You
 */
public class AdminClasificaciones {

    private ArrayList<Clasificacion> clasificaciones = new ArrayList();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void Agregar(Clasificacion clasificacion) {
        clasificaciones.add(clasificacion);
        for (int i = 0; i < clasificaciones.size(); i++) {
            alert.setContentText(clasificaciones.get(i).getNombre() + "/" + clasificaciones.get(i).getDescripcion());
        }
        alert.show();
    }
    
    public void Editar(String nombre){
        for(int i=0;i<clasificaciones.size();i++){
            if(clasificaciones.get(i).getNombre().equals(nombre)){
                clasificaciones.get(i).getNombre();
                clasificaciones.get(i).getDescripcion();
                clasificaciones.get(i).getColor();
            }
        }
    }

    public void Eliminar(String nombre) {
        for (int i = 0; i < clasificaciones.size(); i++) {
            if (clasificaciones.get(i).getNombre().equals(nombre)) {
                alert.setContentText(clasificaciones.get(i).getNombre() + "/" + clasificaciones.get(i).getDescripcion());
                alert.show();

                clasificaciones.remove(i);
            }
        }
    }
    
    public ArrayList Obtener_Clasificaciones(){
        return clasificaciones;
    }
}
