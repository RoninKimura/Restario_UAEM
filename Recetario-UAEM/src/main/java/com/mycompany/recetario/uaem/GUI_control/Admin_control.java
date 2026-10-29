package com.mycompany.recetario.uaem.GUI_control;

import com.mycompany.recetario.uaem.Servicios.AdminClasificaciones;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;
import com.mycompany.recetario.uaem.GUI_control.Agregar_Control;
import com.mycompany.recetario.uaem.GUI.Ventana_Clasificacion;
import com.mycompany.recetario.uaem.GUI_control.Clasificacion_Control;

import javafx.scene.control.*;
import javafx.stage.*;

/**
 *
 * @author You
 */
public class Admin_control {

    public Admin_control(Admin admin, Stage stage) {
        Ventana_Agregar agregar = new Ventana_Agregar();
        Agregar_Control agregar_control = new Agregar_Control(agregar,admin);
        Ventana_Clasificacion clasificacion = new Ventana_Clasificacion();
        Clasificacion_Control clasificacion_control = new Clasificacion_Control(clasificacion, admin, agregar);

        var btn_agregar = admin.Btn_agregar();
        var btn_clas = admin.Btn_clas();

        btn_agregar.setOnAction(e -> {
            var vbox = admin.Ventanas();
            vbox.getChildren().clear();
            vbox.getChildren().add(agregar.VBox_Agregar());
        });

        btn_clas.setOnAction(e -> {
            var vbox = admin.Ventanas();
            vbox.getChildren().clear();
            vbox.getChildren().add(clasificacion.VBox_Clasificacion());
        });
    }
}
