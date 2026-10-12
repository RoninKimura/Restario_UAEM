package com.mycompany.recetario.uaem.GUI;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
/**
 *
 * @author You
 */
public class Login {
    
    public Label lbl_usuarios,lbl_admins,lbl_usuario,lbl_password;
    private Button btn_usuario,btn_admin, btn_singin, btn_enter;
    private TextField txt_usuario;
    private PasswordField psw_password;
    private Scene scene;
    
    public Login(){
        var hbox= new HBox();
        var vbox1= new VBox();
        var vbox2= new VBox();
        var vbox3= new VBox();
        
        btn_usuario= new Button("Usuarios");
        btn_admin= new Button("Administradores");
        
        lbl_usuarios = new Label("Aprende y Cocina");
        lbl_admins= new Label("Bienvenido de Nuevo");
        lbl_admins.setVisible(false);
        
        lbl_usuario = new Label("Usuario");
        lbl_usuario.setVisible(false);
        txt_usuario= new TextField();
        txt_usuario.setVisible(false);
        
        lbl_password = new Label("Password");
        lbl_password.setVisible(false);
        psw_password= new PasswordField();
        psw_password.setVisible(false);
        
        btn_singin= new Button("Sing In");
        btn_singin.setVisible(false);
        btn_enter= new Button("Entrar");
        
        vbox1.getChildren().add(btn_usuario);
        vbox1.getChildren().add(btn_admin);
        
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(20);
        
        vbox2.getChildren().add(lbl_usuarios);
        vbox2.getChildren().add(lbl_admins);
        
        vbox2.setAlignment(Pos.CENTER);
        
        vbox3.getChildren().add(btn_enter);
        vbox3.getChildren().add(lbl_usuario);
        vbox3.getChildren().add(txt_usuario);
        vbox3.getChildren().add(lbl_password);
        vbox3.getChildren().add(psw_password);
        vbox3.getChildren().add(btn_singin);
        
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setSpacing(30);
        
        hbox.getChildren().add(vbox1);
        hbox.getChildren().add(vbox2);
        hbox.getChildren().add(vbox3);
        
        hbox.setSpacing(60);
        
        scene= new Scene(hbox,500, 400);
    }
    public Scene Obtener_Scene(){
        return scene;
    }
    public Button Boton_usuario(){
        return btn_usuario;
    }
    public Button Boton_admin(){
        return btn_admin;
    }
    public Button Boton_singin(){
        return btn_singin;
    }
    public Button Boton_enter(){
        return btn_enter;
    }
    public TextField Txt_usuario(){
        return txt_usuario;
    }
    public PasswordField Psw_password(){
        return psw_password;
    }
}
