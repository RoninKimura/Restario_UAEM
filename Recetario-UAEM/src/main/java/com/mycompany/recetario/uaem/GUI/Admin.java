package com.mycompany.recetario.uaem.GUI;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author You
 */
public class Admin {
    private Scene scene;
    private VBox ventanas;
    private Button btn_home, btn_agregar, btn_clas, btn_ver_us, btn_excel;
    private ComboBox clasificacion;

    public Admin(Ventana_Recetas mostrar_recetas) {
        var grid = new GridPane();
        var menu = new VBox();

        var lbl_app = new Label("Recetario UAEM");
        var lbl_menu = new Label("Menu");
        var lbl_clas = new Label("Clasificacion");

        btn_home = new Button("Home");
        btn_home.setMinWidth(150);
        btn_agregar = new Button("Agregar Receta");
        btn_agregar.setMinWidth(150);
        btn_clas = new Button("Manegar Clasificaciones");
        btn_clas.setMinWidth(150);
        btn_ver_us = new Button("Vista de Usuario");
        btn_ver_us.setMinWidth(150);
        btn_excel= new Button("Exportar Excel");
        btn_excel.setMinWidth(150);

        clasificacion = new ComboBox();
        clasificacion.setPromptText("Selecciona Opcion");
        clasificacion.setMinWidth(150);

        menu.setMaxSize(150, 500);
        menu.getChildren().add(lbl_app);
        menu.getChildren().add(lbl_menu);
        menu.getChildren().add(btn_home);
        menu.getChildren().add(btn_clas);
        menu.getChildren().add(btn_agregar);
        menu.getChildren().add(btn_ver_us);
        menu.getChildren().add(btn_excel);
        menu.getChildren().add(lbl_clas);
        menu.getChildren().add(clasificacion);

        menu.setSpacing(10);

        ventanas = new VBox();
        grid.add(Ventanas(mostrar_recetas), 1, 0);
        grid.add(menu, 0, 0);

        menu.getStyleClass().add("side-menu"); ventanas.getStyleClass().add("content-panel"); grid.setHgap(22); grid.setPadding(new javafx.geometry.Insets(22)); grid.getColumnConstraints().add(new javafx.scene.layout.ColumnConstraints(190)); grid.getColumnConstraints().add(new javafx.scene.layout.ColumnConstraints()); scene = new Scene(grid, 1180, 780); Estilos.aplicar(scene);
    }

    public VBox Ventanas(Ventana_Recetas mostrar_recetas) {
        ventanas.getChildren().clear();
        ventanas.getChildren().add(mostrar_recetas.Tarjetas_Recetas());
        return ventanas;
    }

    public Scene scene_Admin() {
        return scene;
    }

    public Button Btn_home() {
        return btn_home;
    }

    public Button Btn_agregar() {
        return btn_agregar;
    }

    public Button Btn_clas() {
        return btn_clas;
    }

    public Button Btn_ver_us() {
        return btn_ver_us;
    }
    
    public Button Btn_Excel(){
        return btn_excel;
    }

    public ComboBox ComboBox_Admin() {
        return clasificacion;
    }
}
