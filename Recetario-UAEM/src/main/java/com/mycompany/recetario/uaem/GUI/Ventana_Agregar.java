package com.mycompany.recetario.uaem.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 *
 * @author You
 */
public class Ventana_Agregar {

    private VBox vbox;

    private TextField txt_titulo;
    private TextArea txt_descripcion, txt_ingredientes, txt_procedimiento;
    private ComboBox txt_clasificacion;
    private Button btn_agregar, btn_cancelar, btn_imagen;
    private ImageView vista_imagen;

    public Ventana_Agregar() {
        vbox = new VBox();
        var hbox = new HBox();

        vista_imagen = new ImageView();
        vista_imagen.setFitWidth(150);
        vista_imagen.setFitHeight(90);
        vista_imagen.setPreserveRatio(true);
        btn_imagen = new Button("Elegir imagen");

        var lbl_titulo = new Label("Titulo");
        var lbl_descripcion = new Label("Descripcion");
        var lbl_clasificacion = new Label("Clasificacion");
        var lbl_ingredientes = new Label("Ingredientes");
        var lbl_procedimiento = new Label("Procedimiento");

        txt_titulo = new TextField();
        txt_clasificacion = new ComboBox();
        txt_descripcion = new TextArea();
        txt_ingredientes = new TextArea();
        txt_procedimiento = new TextArea();

        txt_descripcion.setPrefRowCount(2);
        txt_ingredientes.setPrefRowCount(3);
        txt_procedimiento.setPrefRowCount(3);

        btn_agregar = new Button("Agregar");
        btn_cancelar = new Button("Cancelar");

        hbox.getChildren().add(btn_agregar);
        hbox.getChildren().add(btn_cancelar);

        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        vbox.getChildren().add(vista_imagen);
        vbox.getChildren().add(btn_imagen);
        vbox.getChildren().add(lbl_titulo);
        vbox.getChildren().add(txt_titulo);
        vbox.getChildren().add(lbl_descripcion);
        vbox.getChildren().add(txt_descripcion);
        vbox.getChildren().add(lbl_clasificacion);
        vbox.getChildren().add(txt_clasificacion);
        vbox.getChildren().add(lbl_ingredientes);
        vbox.getChildren().add(txt_ingredientes);
        vbox.getChildren().add(lbl_procedimiento);
        vbox.getChildren().add(txt_procedimiento);

        vbox.getChildren().add(hbox);

        vbox.setSpacing(10); vbox.getStyleClass().add("form-panel"); vbox.setMaxWidth(820);
    }

    public VBox VBox_Agregar() {
        return vbox;
    }

    public Button Btn_Imagen() {
        return btn_imagen;
    }

    public ImageView Vista_Imagen() {
        return vista_imagen;
    }

    public TextField Titulo() {
        return txt_titulo;
    }

    public TextArea Descripcion() {
        return txt_descripcion;
    }

    public ComboBox Clasificacion() {
        return txt_clasificacion;
    }

    public TextArea Ingredientes() {
        return txt_ingredientes;
    }

    public TextArea Prodecimiento() {
        return txt_procedimiento;
    }

    public Button Btn_Agregar() {
        return btn_agregar;
    }

    public Button Btn_Cancelar() {
        return btn_cancelar;
    }
}
