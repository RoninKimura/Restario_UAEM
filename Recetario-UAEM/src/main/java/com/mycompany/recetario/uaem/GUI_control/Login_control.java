package com.mycompany.recetario.uaem.GUI_control;
import com.mycompany.recetario.uaem.GUI.Login;
import javafx.scene.control.*;
/**
 *
 * @author You
 */
public class Login_control {
    String usuario="Dul";
    String password="sri257";
    public Login_control(Login login){
        var lbl_usuarios=login.lbl_usuarios;
        var lbl_admins=login.lbl_admins;
        var lbl_usuario=login.lbl_usuario;
        var lbl_password=login.lbl_password;
        
        var txt_usuario=login.Txt_usuario();
        var psw_password=login.Psw_password();
        
        var btn_usuario= login.Boton_usuario();
        var btn_admin= login.Boton_admin();
        var btn_singin= login.Boton_singin();
        var btn_enter= login.Boton_enter();
        
        
        
        btn_usuario.setOnAction(e->{
            lbl_admins.setVisible(false);
            lbl_usuario.setVisible(false);
            lbl_password.setVisible(false);
            
            txt_usuario.setVisible(false);
            psw_password.setVisible(false);
            
            btn_singin.setVisible(false);
            
            lbl_usuarios.setVisible(true);
            btn_enter.setVisible(true);
        });
        
        btn_admin.setOnAction(e->{
            lbl_admins.setVisible(true);
            lbl_usuario.setVisible(true);
            lbl_password.setVisible(true);
            
            txt_usuario.setVisible(true);
            psw_password.setVisible(true);
            
            btn_singin.setVisible(true);
            
            
            lbl_usuarios.setVisible(false);
            btn_enter.setVisible(false);
        });
        
        btn_singin.setOnAction(e->{
            var alert= new Alert(Alert.AlertType.CONFIRMATION);
            if(usuario.equals(txt_usuario.getText())&& password.equals(psw_password.getText())){
                alert.setContentText("Bienvenido");
                alert.showAndWait();
            }else{
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Usuario o Password Incorrectos");
                alert.showAndWait();
            }
            txt_usuario.setText("");
            psw_password.setText("");
        });
    }
}
