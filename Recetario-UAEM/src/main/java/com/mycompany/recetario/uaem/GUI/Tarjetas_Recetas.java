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
    public int id;
    public String Titulo,Descripcion,Clasificacion;
    private HBox hbox;
    private Button btn_editar, btn_eliminar,btn_ver,btn_download;

    public VBox Tarjetas_Recetas() {
        var vbox_tarjeta = new VBox();
        var vbox = new VBox();
        hbox = new HBox();

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
        
        btn_ver= new Button("Ver Receta");
        btn_download= new Button("Descargar Receta");

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
    public Button btn_ver(){
        return btn_ver;
    }
    public Button btn_download(){
        return btn_download;
    }
    public HBox mod_users(){
        hbox.getChildren().clear();
        hbox.getChildren().add(btn_ver);
        hbox.getChildren().add(btn_download);
        return hbox;
    }
}
