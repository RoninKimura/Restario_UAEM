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
    
    private Label lbl_usuarios,lbl_admins,lbl_usuario,lbl_password;
    private VBox vbox2,vbox3;
    private Button btn_usuario,btn_admin, btn_singin, btn_enter;
    private TextField txt_usuario;
    private PasswordField psw_password;
    private Scene scene;
    
    public Login(){
        var hbox= new HBox();
        var vbox1= new VBox();
        vbox2= new VBox();
        vbox3= new VBox();
        
        btn_usuario= new Button("Usuarios");
        btn_admin= new Button("Administradores");
        
        lbl_usuarios = new Label("Aprende y Cocina");
        lbl_admins= new Label("Bienvenido de Nuevo");
        
        lbl_usuario = new Label("Usuario");
        txt_usuario= new TextField();
        
        lbl_password = new Label("Password");
        psw_password= new PasswordField();
        
        btn_singin= new Button("Sing In");
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
        
        mod_usuarios(vbox2,vbox3);
        
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
    public VBox Vbox2(){
        return vbox2;
    }
    public VBox Vbox3(){
        return vbox3;
    }
    
    public void mod_usuarios(VBox v,VBox v2){
        if(v.getChildren().contains(lbl_admins)){
            v.getChildren().remove(lbl_admins);
            v2.getChildren().remove(lbl_usuario);
            v2.getChildren().remove(txt_usuario);
            v2.getChildren().remove(lbl_password);
            v2.getChildren().remove(psw_password);
            v2.getChildren().remove(btn_singin);
        }
        
        if(!v.getChildren().contains(lbl_usuarios)){
            v.getChildren().add(lbl_usuarios);
            v2.getChildren().add(btn_enter);
        }
    }
    public void mod_admins(VBox v,VBox v2){
        if(v.getChildren().contains(lbl_usuarios)){
            v.getChildren().remove(lbl_usuarios);
            v2.getChildren().remove(btn_enter);
        }
        
        if(!v.getChildren().contains(lbl_admins)){
            v.getChildren().add(lbl_admins);
            v2.getChildren().add(lbl_usuario);
            v2.getChildren().add(txt_usuario);
            v2.getChildren().add(lbl_password);
            v2.getChildren().add(psw_password);
            v2.getChildren().add(btn_singin);
        }
    }
}
