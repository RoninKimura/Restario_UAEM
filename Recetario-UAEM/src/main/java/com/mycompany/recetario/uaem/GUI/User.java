package com.mycompany.recetario.uaem.GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author You
 */
public class User {
    private Scene scene;
    private VBox ventanas;
    private ComboBox clasificacion;

    public User(Ventana_Recetas mostrar_recetas) {
        var grid = new GridPane();
        var menu = new VBox();

        var lbl_app = new Label("Recetario UAEM");
        var lbl_menu = new Label("Menu");
        var lbl_clas = new Label("Clasificacion");

        clasificacion = new ComboBox();
        clasificacion.setPromptText("Selecciona Opcion");
        clasificacion.setMinWidth(150);

        menu.setMaxSize(150, 500);
        menu.getChildren().add(lbl_app);
        menu.getChildren().add(lbl_menu);
        menu.getChildren().add(lbl_clas);
        menu.getChildren().add(clasificacion);

        menu.setSpacing(10);

        ventanas = new VBox();
        grid.add(Ventanas(mostrar_recetas), 1, 0);
        grid.add(menu, 0, 0);

        menu.getStyleClass().add("side-menu"); ventanas.getStyleClass().add("content-panel"); grid.setHgap(22); grid.setPadding(new javafx.geometry.Insets(22)); grid.getColumnConstraints().add(new javafx.scene.layout.ColumnConstraints(190)); grid.getColumnConstraints().add(new javafx.scene.layout.ColumnConstraints()); scene = new Scene(grid, 1120, 760); Estilos.aplicar(scene);
    }

    public VBox Ventanas(Ventana_Recetas mostrar_recetas) {
        ventanas.getChildren().clear();
        ventanas.getChildren().add(mostrar_recetas.Tarjetas_Recetas());
        return ventanas;
    }

    public Scene scene_user() {
        return scene;
    }

    public ComboBox ComboBox_user() {
        return clasificacion;
    }
}
