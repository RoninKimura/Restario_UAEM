package com.mycompany.recetario.uaem.GUI;

import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Archivos.Imagen;

import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Ventana_Receta {

    private VBox vbox;
    private ImageView img_receta;
    private Label lbl_titulo, lbl_descripcion, lbl_clasificacion;
    private Label lbl_ingredientes, lbl_procedimiento;
    private Button btn_volver, btn_download;

    public Ventana_Receta() {
        vbox = new VBox();

        img_receta = new ImageView();
        img_receta.setFitWidth(250);
        img_receta.setFitHeight(120);
        img_receta.setPreserveRatio(true);
        lbl_titulo = new Label();
        lbl_descripcion = new Label();
        lbl_clasificacion = new Label();
        lbl_ingredientes = new Label();
        lbl_procedimiento = new Label();

        lbl_descripcion.setWrapText(true);
        lbl_ingredientes.setWrapText(true);
        lbl_procedimiento.setWrapText(true);
        lbl_descripcion.setMaxWidth(300);
        lbl_ingredientes.setMaxWidth(300);
        lbl_procedimiento.setMaxWidth(300);

        btn_volver = new Button("Volver");
        btn_download = new Button("Descargar Receta");

        vbox.getChildren().add(btn_volver);
        vbox.getChildren().add(img_receta);
        vbox.getChildren().add(lbl_titulo);
        vbox.getChildren().add(lbl_descripcion);
        vbox.getChildren().add(lbl_clasificacion);
        vbox.getChildren().add(lbl_ingredientes);
        vbox.getChildren().add(lbl_procedimiento);
        vbox.getChildren().add(btn_download);
        vbox.setSpacing(10);
    }

    public void Cargar(Receta r) {
        lbl_titulo.setText(r.getTitulo());
        img_receta.setImage(Imagen.Cargar(r.getImagen(), 250, 120));
        lbl_descripcion.setText(r.getDescripcion());
        lbl_clasificacion.setText(r.getCalsificacion());
        lbl_ingredientes.setText("Ingredientes:\n" + r.getIngredientes());
        lbl_procedimiento.setText("Procedimiento:\n" + r.getProcedimiento());
    }

    public VBox Receta_Ventana() {
        return vbox;
    }

    public Button btn_volver() {
        return btn_volver;
    }

    public Button btn_download() {
        return btn_download;
    }
}
