package com.mycompany.recetario.uaem.GUI_control;

import com.mycompany.recetario.uaem.GUI.Tarjetas_Recetas;
import com.mycompany.recetario.uaem.GUI.User;
import com.mycompany.recetario.uaem.GUI.Ventana_Receta;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Servicios.AdminClasificaciones;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class User_Control {

    private final User user;
    private final Ventana_Recetas mostrar_recetas;
    private final AdminRecetas recetas;
    private final Ventana_Receta ver_receta;
    private final ComboBox combo;

    public User_Control(User user, Ventana_Recetas mostrar_recetas,
            AdminRecetas recetas, AdminClasificaciones clasificaciones) {
        this.user = user;
        this.mostrar_recetas = mostrar_recetas;
        this.recetas = recetas;
        this.ver_receta = new Ventana_Receta();
        this.combo = user.ComboBox_user();
        
        Clasificacion todas = new Clasificacion("Todas", "", Color.WHITE);
        combo.getItems().add(todas);
        combo.getItems().addAll(clasificaciones.Obtener_Clasificaciones());
        combo.setValue(todas);
        
        combo.setOnAction(e -> {
            user.Ventanas(mostrar_recetas);
            Actualizar_Tarjetas();
        });

        ver_receta.btn_volver().setOnAction(e -> user.Ventanas(mostrar_recetas));

        Actualizar_Tarjetas();
    }

    public void Actualizar_Tarjetas() {
        Clasificacion filtro = (Clasificacion) combo.getValue();
        var flow = mostrar_recetas.Obtener_Tarjetas();
        flow.getChildren().clear();

        for (Receta r : recetas.Obtener_Recetas()) {
            if (filtro != null && !filtro.getNombre().equals("Todas")
                    && !filtro.getNombre().equals(r.getCalsificacion())) {
                continue;
            }

            Tarjetas_Recetas tarjeta = new Tarjetas_Recetas();
            tarjeta.id = r.getid();
            tarjeta.Titulo = r.getTitulo();
            tarjeta.Descripcion = r.getDescripcion();
            tarjeta.Clasificacion = r.getCalsificacion();

            flow.getChildren().add(tarjeta.Tarjetas_Recetas());
            tarjeta.mod_users();

            tarjeta.btn_ver().setOnAction(e -> {
                ver_receta.Cargar(r);
                var vbox = user.Ventanas(mostrar_recetas);
                vbox.getChildren().clear();
                vbox.getChildren().add(ver_receta.Receta_Ventana());
            });
        }
    }

    public static void Abrir(AdminRecetas recetas, AdminClasificaciones clasificaciones) {
        Ventana_Recetas mostrar_recetas = new Ventana_Recetas();
        User user = new User(mostrar_recetas);
        new User_Control(user, mostrar_recetas, recetas, clasificaciones);

        Stage user_stage = new Stage();
        user_stage.setScene(user.scene_user());
        user_stage.setResizable(false);
        user_stage.setTitle("Recetario UAEM");
        user_stage.show();
    }
}