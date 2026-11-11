package com.mycompany.recetario.uaem.GUI;

import com.mycompany.recetario.uaem.Archivos.Imagen;
import javafx.scene.image.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author You
 */
public class Tarjetas_Recetas {

    public int id;
    public String NombreImagen, Titulo, Descripcion, Clasificacion;
    private HBox hbox;
    private Button btn_editar, btn_eliminar, btn_ver, btn_download;

    public VBox Tarjetas_Recetas() {
        var vbox_tarjeta = new VBox();
        var vbox = new VBox();
        hbox = new HBox();

        var lbl_titulo = new Label(Titulo);
        var lbl_descripcion = new Label(Descripcion);
        var lbl_clasificacion = new Label(Clasificacion);
        
        Image img = Imagen.Cargar(NombreImagen, 120, 90);
        
        if (img != null) {
            var vista = new ImageView(img);
            vista.setFitWidth(120);
            vista.setFitHeight(90);
            vista.setPreserveRatio(true);
            vbox.getChildren().add(vista);
        } else {
            vbox.getChildren().add(new Label("Sin imagen"));
        }
        vbox.getChildren().add(lbl_titulo);
        vbox.getChildren().add(lbl_descripcion);
        vbox.getChildren().add(lbl_clasificacion);

        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER);

        btn_editar = new Button("Editar");
        btn_eliminar = new Button("Eliminar");

        btn_ver = new Button("Ver Receta");
        btn_download = new Button("Descargar Receta");

        hbox.getChildren().add(btn_editar);
        hbox.getChildren().add(btn_eliminar);

        hbox.setSpacing(10);

        vbox_tarjeta.getChildren().add(vbox);
        vbox_tarjeta.getChildren().add(hbox);

        vbox_tarjeta.setSpacing(9); vbox_tarjeta.setPrefWidth(245); vbox_tarjeta.setMinHeight(205); vbox_tarjeta.getStyleClass().add("recipe-card"); lbl_titulo.getStyleClass().add("title-label"); lbl_descripcion.setWrapText(true); lbl_descripcion.setMaxWidth(215); lbl_clasificacion.getStyleClass().add("subtitle-label");

        return vbox_tarjeta;
    }

    public Button btn_editar() {
        return btn_editar;
    }

    public Button btn_eliminar() {
        return btn_eliminar;
    }

    public Button btn_ver() {
        return btn_ver;
    }

    public Button btn_download() {
        return btn_download;
    }

    public HBox mod_users() {
        hbox.getChildren().clear();
        hbox.getChildren().add(btn_ver);
        hbox.getChildren().add(btn_download);
        return hbox;
    }
}
