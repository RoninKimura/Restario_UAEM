package com.mycompany.recetario.uaem.GUI_control;

import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Clasificacion;

import javafx.stage.*;

/**
 *
 * @author You
 */
public class Admin_control {

    public Admin_control(Admin admin, Stage stage, Ventana_Recetas mostrar_recetas) {
        AdminRecetas recetas = new AdminRecetas();
        Ventana_Editar editar = new Ventana_Editar();
        Recetas_Control recetas_control = new Recetas_Control(editar,
                mostrar_recetas, recetas, admin);
        Ventana_Agregar agregar = new Ventana_Agregar();
        Agregar_Control agregar_control = new Agregar_Control(agregar, recetas,
                admin, mostrar_recetas, recetas_control);
        Ventana_Clasificacion clasificacion = new Ventana_Clasificacion();
        Clasificacion_Control clasificacion_control = new Clasificacion_Control(clasificacion, admin, agregar);

        var btn_home = admin.Btn_home();
        var btn_agregar = admin.Btn_agregar();
        var btn_clas = admin.Btn_clas();

        btn_home.setOnAction(e -> {
            var vbox = admin.Ventanas(mostrar_recetas);
            vbox.getChildren().clear();
            vbox.getChildren().add(mostrar_recetas.Tarjetas_Recetas());
        });

        btn_agregar.setOnAction(e -> {
            var vbox = admin.Ventanas(mostrar_recetas);
            vbox.getChildren().clear();
            vbox.getChildren().add(agregar.VBox_Agregar());
        });

        btn_clas.setOnAction(e -> {
            var vbox = admin.Ventanas(mostrar_recetas);
            vbox.getChildren().clear();
            vbox.getChildren().add(clasificacion.VBox_Clasificacion());
        });
    }
}
