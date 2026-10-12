package com.mycompany.recetario.uaem;

import com.mycompany.recetario.uaem.GUI.Login;
import com.mycompany.recetario.uaem.GUI_control.Login_control;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Login login= new Login();
        Login_control login_control= new Login_control(login);
        
        stage.setScene(login.Obtener_Scene());
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}