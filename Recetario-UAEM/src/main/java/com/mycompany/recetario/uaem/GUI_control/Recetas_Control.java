package com.mycompany.recetario.uaem.GUI_control;

import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Tarjetas_Recetas;

import com.mycompany.recetario.uaem.GUI_control.Editar_Control;
import java.util.ArrayList;

/**
 *
 * @author You
 */
public class Recetas_Control {
    private final Ventana_Editar editar;
    private final Ventana_Recetas mostrar_recetas;
    private final AdminRecetas recetas;
    private final Admin admin;
    private final Editar_Control editar_control;

    public Recetas_Control(Ventana_Editar editar, Ventana_Recetas mostrar_recetas,
            AdminRecetas recetas, Admin admin,Editar_Control editar_control) {
        this.editar = editar;
        this.mostrar_recetas = mostrar_recetas;
        this.recetas = recetas;
        this.admin = admin;
        this.editar_control=editar_control;
        Actualizar_Tarjetas();
    }

    public void Actualizar_Tarjetas() {
        var flow = mostrar_recetas.Obtener_Tarjetas();
        flow.getChildren().clear();

        for (Receta r : recetas.Obtener_Recetas()) {
            Tarjetas_Recetas tarjeta = new Tarjetas_Recetas();
            tarjeta.id=r.getid();
            tarjeta.Titulo = r.getTitulo();
            tarjeta.Descripcion = r.getDescripcion();
            tarjeta.Clasificacion = r.getCalsificacion();

            flow.getChildren().add(tarjeta.Tarjetas_Recetas()); // primero se crean los botones
            new Tarjetas_Control(recetas,tarjeta, admin, editar,editar_control,mostrar_recetas); // luego se conectan
        }
    }
}
