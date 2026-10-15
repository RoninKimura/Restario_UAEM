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
public class Admin {

    private Scene scene;

    public Scene Admin() {
        var grid = new GridPane();
        var ventanas = Ventanas();
        var menu = Menu();

        grid.add(ventanas, 1, 0);
        grid.add(menu, 0, 0);
        
        scene = new Scene(grid, 500, 500);

        return scene;
    }

    private VBox Menu() {
        var vbox = new VBox();
        var btn_agregar = new Button("Agregar Receta");
        btn_agregar.setMinWidth(150);
        var btn_clas = new Button("Agregar Clasificacion");
        btn_clas.setMinWidth(150);
        var btn_ver_us = new Button("Vista de Usuario");
        btn_ver_us.setMinWidth(150);

        vbox.setMaxSize(150, 500);
        vbox.getChildren().add(btn_agregar);
        vbox.getChildren().add(btn_clas);
        vbox.getChildren().add(btn_ver_us);

        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        return vbox;
    }

    private VBox Ventanas() {
        var vbox = new VBox();
        var btn_buscar = new Button("Buscar");
        var txt_buscar = new TextField();

        vbox.setMaxSize(350, 50);

        vbox.getChildren().add(btn_buscar);
        vbox.getChildren().add(txt_buscar);
        vbox.setSpacing(10);

        return vbox;
    }
    
    
}
