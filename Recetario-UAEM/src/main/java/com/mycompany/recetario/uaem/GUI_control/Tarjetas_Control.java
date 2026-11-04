package com.mycompany.recetario.uaem.GUI_control;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Tarjetas_Recetas;

import javafx.scene.control.Button;


public class Tarjetas_Control {
    private Button btn_editar, btn_eliminar;
    public Tarjetas_Control(Tarjetas_Recetas tarjetas,Admin admin,Ventana_Editar editar, Ventana_Recetas mostrar_recetas){
        btn_editar=tarjetas.btn_editar();
        btn_eliminar=tarjetas.btn_eliminar();
        
        btn_editar.setOnAction(e->{
            var vbox=admin.Ventanas(mostrar_recetas);
            vbox.getChildren().clear();
            vbox.getChildren().add(editar.VBox_Editar());
        });
    }
}
