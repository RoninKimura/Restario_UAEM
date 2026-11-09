package com.mycompany.recetario.uaem.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;

/**
 *
 * @author You
 */
public class Ventana_Editar {

    private VBox vbox;
    private TextField txt_titulo;
    private TextArea txt_descripcion, txt_ingredientes, txt_procedimiento;
    private ComboBox txt_clasificacion;
    private Button btn_editar, btn_cancelar, btn_imagen;
    private ImageView view_imagen;

    public Ventana_Editar() {
        vbox = new VBox();
        var hbox = new HBox();

        view_imagen = new ImageView();
        view_imagen.setFitWidth(150);
        view_imagen.setFitHeight(90);
        view_imagen.setPreserveRatio(true);
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

        btn_editar = new Button("Editar");
        btn_cancelar = new Button("Cancelar");

        hbox.getChildren().add(btn_editar);
        hbox.getChildren().add(btn_cancelar);

        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        vbox.getChildren().add(view_imagen);
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

        vbox.setSpacing(10);
    }

    public VBox VBox_Editar() {
        return vbox;
    }

    public Button btnImagen() {
        return btn_imagen;
    }

    public ImageView Vista_Imagen() {
        return view_imagen;
    }

    public TextField Titulo() {
        return txt_titulo;
    }

    public TextArea Descripcion() {
        return txt_descripcion;
    }

    public TextArea Ingredientes() {
        return txt_ingredientes;
    }

    public TextArea Procedimiento() {
        return txt_procedimiento;
    }

    public ComboBox Clasificacion() {
        return txt_clasificacion;
    }

    public Button btnEditar() {
        return btn_editar;
    }

    public Button btnCancelar() {
        return btn_cancelar;
    }
}
