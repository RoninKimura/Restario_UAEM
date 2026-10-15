package com.mycompany.recetario.uaem.GUI;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

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
        Ventana_Recetas recetas= new Ventana_Recetas();
        var vbox = new VBox();
        
        vbox.getChildren().add(recetas.Tarjets_Recetas());
        
        return vbox;
    }
    
    
}
