package com.mycompany.recetario.uaem.GUI;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author You
 */
public class Ventana_Recetas {
//    private Scene scene;
    public VBox Tarjets_Recetas(){
        var vbox= new VBox();
        
        vbox.getChildren().add(Buscador());
        vbox.getChildren().add(Recetas());
        
        vbox.setSpacing(20);
        
        return vbox;
    }
    
    private HBox Buscador(){
        var hbox=new HBox();
        
        var btn_buscar=new Button("Buscar");
        var txt_buscar=new TextField();
        
        hbox.getChildren().add(btn_buscar);
        hbox.getChildren().add(txt_buscar);
        
        hbox.setSpacing(10);
        
        hbox.setAlignment(Pos.CENTER);
        
        return hbox;
    }
    
    private VBox Recetas(){
        var vbox_tarjet= new VBox();
        var vbox= new VBox();
        var hbox= new HBox();
        
        var lbl_img= new Label("Imagen");
        var lbl_titulo= new Label("Titulo Receta");
        var lbl_descripcion= new Label("Descripcion");
        var lbl_clasi= new Label("Clasificacion");
        
        vbox.getChildren().add(lbl_img);
        vbox.getChildren().add(lbl_titulo);
        vbox.getChildren().add(lbl_descripcion);
        vbox.getChildren().add(lbl_clasi);
        
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.CENTER);
        
        var btn_editar=new Button("Editar");
        var btn_eliminar=new Button("Eliminar");
        
        hbox.getChildren().add(btn_editar);
        hbox.getChildren().add(btn_eliminar);
        
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        
        vbox_tarjet.getChildren().add(vbox);
        vbox_tarjet.getChildren().add(hbox);
        
        vbox_tarjet.setSpacing(5);
        
        return vbox_tarjet;
    }
}
