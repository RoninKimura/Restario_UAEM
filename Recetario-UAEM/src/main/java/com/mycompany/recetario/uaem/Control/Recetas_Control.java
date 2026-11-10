package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Tarjetas_Recetas;

import com.mycompany.recetario.uaem.Control.Editar_Control;
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
            AdminRecetas recetas, Admin admin, Editar_Control editar_control) {
        this.editar = editar;
        this.mostrar_recetas = mostrar_recetas;
        this.recetas = recetas;
        this.admin = admin;
        this.editar_control = editar_control;

        Runnable filtrar = () -> {
            admin.Ventanas(mostrar_recetas);
            Actualizar_Tarjetas();
        };
        admin.ComboBox_Admin().setOnAction(e -> filtrar.run());
        mostrar_recetas.btn_buscar().setOnAction(e -> filtrar.run());
        mostrar_recetas.txt_buscar().setOnAction(e -> filtrar.run());
        Actualizar_Tarjetas();
    }

    public void Actualizar_Tarjetas() {
        var flow = mostrar_recetas.Obtener_Tarjetas();
        flow.getChildren().clear();

        Clasificacion c = (Clasificacion) admin.ComboBox_Admin().getValue();
        String nombre = (c == null) ? null : c.getNombre();
        for (Receta r : recetas.Filtrar(nombre, mostrar_recetas.txt_buscar().getText())) {
            Tarjetas_Recetas tarjeta = new Tarjetas_Recetas();
            tarjeta.id = r.getid();
            tarjeta.NombreImagen = r.getImagen();
            tarjeta.Titulo = r.getTitulo();
            tarjeta.Descripcion = r.getDescripcion();
            tarjeta.Clasificacion = r.getCalsificacion();

            flow.getChildren().add(tarjeta.Tarjetas_Recetas()); // primero se crean los botones
            new Tarjetas_Control(recetas, tarjeta, admin, editar, editar_control, mostrar_recetas, this); // luego se conectan
        }
    }
}
