package com.mycompany.recetario.uaem.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 *
 * @author You
 */
public class Ventana_Clasificacion {
    
    private VBox vbox;
    private ComboBox choose_clasificacion;
    private TextField txt_nombre;
    private TextArea txt_descripcion;
    private Color color;
    private Button btn_agregar, btn_editar, btn_eliminar, btn_limpiar;

    public Ventana_Clasificacion() {

        vbox = new VBox();
        var hbox = new HBox();
        var lbl_clasificaciones = new Label("Clasificaciones");
        var lbl_nombre = new Label("Nombre:");
        var lbl_descripcion = new Label("Descripcion:");
        var lbl_color = new Label("Seleccionar Color");

        choose_clasificacion = new ComboBox();
        choose_clasificacion.setPromptText("Selecciona Opcion");

        txt_nombre = new TextField();
        txt_descripcion = new TextArea();
        var choose_color = new ColorPicker();
        color= choose_color.getValue();

        btn_agregar = new Button("Agregar");
        btn_editar = new Button("Editar");
        btn_eliminar = new Button("Eliminar");
        btn_limpiar = new Button("Limpiar");

        hbox.getChildren().add(btn_agregar);
        hbox.getChildren().add(btn_editar);
        hbox.getChildren().add(btn_eliminar);
        hbox.getChildren().add(btn_limpiar);

        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        vbox.getChildren().add(lbl_clasificaciones);
        vbox.getChildren().add(choose_clasificacion);
        vbox.getChildren().add(lbl_nombre);
        vbox.getChildren().add(txt_nombre);
        vbox.getChildren().add(lbl_descripcion);
        vbox.getChildren().add(txt_descripcion);
        vbox.getChildren().add(lbl_color);
        vbox.getChildren().add(choose_color);
        vbox.getChildren().add(hbox);

        vbox.setSpacing(10);
    }
    public VBox VBox_Clasificacion(){
        return vbox;
    }
    public ComboBox Combo_Box(){
        return choose_clasificacion;
    }
    public TextField Txt_Nombre(){
        return txt_nombre;
    }
    public TextArea Txt_Descripcion(){
        return txt_descripcion;
    }
    public Color Color(){
        return color;
    }
    public Button Btn_Agregar(){
        return btn_agregar;
    }
    public Button Btn_Editar(){
        return btn_editar;
    }
    public Button Btn_Eliminar(){
        return btn_eliminar;
    }
    public Button Btn_Limpiar(){
        return btn_limpiar;
    }
}
