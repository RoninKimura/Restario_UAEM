package com.mycompany.recetario.uaem.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author You
 */
public class Tarjetas_Recetas {
    public String Titulo,Descripcion,Clasificacion;
    private Button btn_editar, btn_eliminar;

    public VBox Tarjetas_Recetas() {
        var vbox_tarjeta = new VBox();
        var vbox = new VBox();
        var hbox = new HBox();

        var lbl_image = new Label();
        var lbl_titulo = new Label(Titulo);
        var lbl_descripcion = new Label(Descripcion);
        var lbl_clasificacion = new Label(Clasificacion);

        vbox.getChildren().add(lbl_image);
        vbox.getChildren().add(lbl_titulo);
        vbox.getChildren().add(lbl_descripcion);
        vbox.getChildren().add(lbl_clasificacion);

        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER);

        btn_editar = new Button("Editar");
        btn_eliminar = new Button("Eliminar");

        hbox.getChildren().add(btn_editar);
        hbox.getChildren().add(btn_eliminar);

        hbox.setSpacing(10);

        vbox_tarjeta.getChildren().add(vbox);
        vbox_tarjeta.getChildren().add(hbox);

        vbox_tarjeta.setSpacing(5);

        return vbox_tarjeta;
    }
    
    public Button btn_editar(){
        return btn_editar;
    }
    public Button btn_eliminar(){
        return btn_eliminar;
    }
}
