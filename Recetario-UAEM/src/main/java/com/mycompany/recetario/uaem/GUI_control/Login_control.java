package com.mycompany.recetario.uaem.GUI_control;

import com.mycompany.recetario.uaem.GUI.Login;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI_control.Admin_control;

import javafx.scene.control.*;
import javafx.stage.*;

/**
 *
 * @author You
 */
public class Login_control {

//    String usuario = "Dul";
//    String password = "sri257";
    String usuario = "";
    String password = "";

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
            Admin admin = new Admin();
            Stage admin_stage = new Stage();
            Admin_control admin_control = new Admin_control(admin,admin_stage);
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
    }

}
