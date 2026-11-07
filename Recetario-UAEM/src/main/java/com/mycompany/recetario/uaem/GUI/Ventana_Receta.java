package com.mycompany.recetario.uaem.GUI;

import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author angel
 */
public class Ventana_Receta {
    
    private String Titulo;
    private String Descripcion;
    private String Clasificacion;
    private String Ingredientes;
    private String Procedimiento;
    
    private VBox vbox;
    private Label lbl_imagen,lbl_titulo,lbl_descripcion,lbl_clasificacion;
    private Label lbl_ingredientes,lbl_procedimiento;
    private Button btn_volver,btn_download;
    
    public Ventana_Receta(){
    lbl_imagen= new Label("Imagen");
    lbl_titulo= new Label(Titulo);
    lbl_descripcion= new Label(Descripcion);
    lbl_clasificacion= new Label(Clasificacion);
    lbl_ingredientes= new Label(Ingredientes);
    lbl_procedimiento= new Label(Procedimiento);
    
    vbox.getChildren().add(lbl_imagen);
    vbox.getChildren().add(lbl_titulo);
    vbox.getChildren().add(lbl_descripcion);
    vbox.getChildren().add(lbl_clasificacion);
    vbox.getChildren().add(lbl_ingredientes);
    vbox.getChildren().add(lbl_procedimiento);
}
    public VBox Receta_Ventana(){
        return vbox;
    }
}
