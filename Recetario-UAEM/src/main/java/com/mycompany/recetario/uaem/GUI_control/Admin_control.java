package com.mycompany.recetario.uaem.GUI_control;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;

import javafx.scene.control.*;
import javafx.stage.*;
/**
 *
 * @author You
 */
public class Admin_control {
    public Admin_control(Admin admin,Stage stage){
        Ventana_Agregar agregar= new Ventana_Agregar();
        
        var btn_agregar = admin.Btn_agregar();

        btn_agregar.setOnAction(e->{
           var vbox= admin.Ventanas();
           vbox.getChildren().clear();
           vbox.getChildren().add(agregar.Ventana_Agregar());
        });
    }
}
