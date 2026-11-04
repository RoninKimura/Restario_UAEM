package com.mycompany.recetario.uaem.GUI_control;

import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Tarjetas_Recetas;
import java.util.ArrayList;

/**
 *
 * @author You
 */
public class Recetas_Control {

    public Recetas_Control(Ventana_Editar editar,
            Ventana_Recetas mostrar_recetas, AdminRecetas recetas, Admin admin) {
        var flow = mostrar_recetas.Obtener_Tarjetas();
        ArrayList<Receta> recets = recetas.Obtener_Recetas();

        for (int d = 0; d < recetas.Obtener_Recetas().size(); d++) {
            Tarjetas_Recetas tarjetas = new Tarjetas_Recetas();
            Tarjetas_Control trajetas_control = new Tarjetas_Control(tarjetas, admin, editar,mostrar_recetas);

            tarjetas.Titulo = recets.get(d).getTitulo();
            tarjetas.Descripcion = recets.get(d).getDescripcion();
            tarjetas.Clasificacion = recets.get(d).getCalsificacion();

            flow.getChildren().add(tarjetas.Tarjetas_Recetas());
        }
    }
}
