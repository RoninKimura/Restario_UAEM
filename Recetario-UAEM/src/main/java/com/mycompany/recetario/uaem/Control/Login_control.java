package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Login;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.User;
import com.mycompany.recetario.uaem.Control.Admin_control;
import com.mycompany.recetario.uaem.Control.User_Control;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.Servicios.AdminClasificaciones;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.*;

/**
 *
 * @author You
 */
public class Login_control {

    AdminRecetas recetas = new AdminRecetas();
    AdminClasificaciones clasificaciones = new AdminClasificaciones();
    String usuario = "Eliud";
    String password = "sri257";

    public Login_control(Login login, Stage stage) {

        var txt_usuario = login.Txt_usuario();
        var psw_password = login.Psw_password();

        var btn_usuario = login.Boton_usuario();
        var btn_admin = login.Boton_admin();
        var btn_singin = login.Boton_singin();
        var btn_enter = login.Boton_enter();

        var vbox2 = login.Vbox2();
        var vbox3 = login.Vbox3();

        btn_usuario.setOnAction(e -> {
            login.mod_usuarios(vbox2, vbox3);
        });

        btn_admin.setOnAction(e -> {
            login.mod_admins(vbox2, vbox3);
        });

        btn_singin.setOnAction(e -> {
            Ventana_Recetas mostrar_recetas = new Ventana_Recetas();
            Admin admin = new Admin(mostrar_recetas);
            Stage admin_stage = new Stage();
            Admin_control admin_control = new Admin_control(admin, admin_stage, mostrar_recetas, recetas, clasificaciones);
            var alert = new Alert(Alert.AlertType.CONFIRMATION);

            if (usuario.equals(txt_usuario.getText()) && password.equals(psw_password.getText())) {
                alert.setContentText("Bienvenido");
                alert.showAndWait();
                admin_stage.setScene(admin.scene_Admin());
                admin_stage.setResizable(false);
                admin_stage.show();
                stage.close();
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Usuario o Password Incorrectos");
                alert.showAndWait();
            }
            txt_usuario.setText("");
            psw_password.setText("");
        });

        btn_enter.setOnAction(e -> {
            User_Control.Abrir(recetas, clasificaciones);
            stage.close();
        });
    }

}
