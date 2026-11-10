package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.GUI.Alertas;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Tarjetas_Recetas;
import com.mycompany.recetario.uaem.Control.Editar_Control;

import javafx.scene.control.Button;

public class Tarjetas_Control {

    private Button btn_editar, btn_eliminar;

    public Tarjetas_Control(AdminRecetas recetas, Tarjetas_Recetas tarjetas,
            Admin admin, Ventana_Editar editar, Editar_Control editar_control,
            Ventana_Recetas mostrar_recetas, Recetas_Control recetas_control) {
        btn_editar = tarjetas.btn_editar();
        btn_eliminar = tarjetas.btn_eliminar();

        btn_editar.setOnAction(e -> {
            Receta r = recetas.Buscar(tarjetas.id);
            editar_control.ObtenerDatos(r);
            var vbox = admin.Ventanas(mostrar_recetas);
            vbox.getChildren().clear();
            vbox.getChildren().add(editar.VBox_Editar());
        });

        btn_eliminar.setOnAction(e -> {
            Receta r = recetas.Buscar(tarjetas.id);
            if (r == null) {
                return;
            }
            if (!Alertas.confirmar("Eliminar receta",
                    "Seguro que quieres eliminar \"" + r.getTitulo() + "\"?")) {
                return;
            }
            recetas.Eliminar(r.getid());
            recetas_control.Actualizar_Tarjetas();
        });
    }
}
