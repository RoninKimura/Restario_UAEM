package com.mycompany.recetario.uaem.GUI;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author You
 */
public class Ventana_Agregar {
    private TextField txt_titulo;
    private TextArea txt_descripcion,txt_ingredientes, txt_procedimiento;
    private ComboBox txt_clasificacion;
    private Button btn_agregar, btn_cancelar;
    public VBox Ventana_Agregar(){
        var vbox= new VBox();
        var hbox= new HBox();
        var lbl_imagen= new Label("Imagen");
        var lbl_titulo= new Label("Titulo");
        var lbl_descripcion= new Label("Descripcion");
        var lbl_clasificacion= new Label("Clasificacion");
        var lbl_ingredientes= new Label("Ingredientes");
        var lbl_procedimiento= new Label("Procedimiento");
        
        txt_titulo= new TextField();
        txt_clasificacion= new ComboBox();
        txt_descripcion= new TextArea();
        txt_ingredientes= new TextArea();
        txt_procedimiento= new TextArea();
        
        btn_agregar=new Button("Agregar");
        btn_cancelar=new Button("Cancelar");
        
        hbox.getChildren().add(btn_agregar);
        hbox.getChildren().add(btn_cancelar);
        
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        
        vbox.getChildren().add(lbl_imagen);
        
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
        
        return vbox;
    }
}
