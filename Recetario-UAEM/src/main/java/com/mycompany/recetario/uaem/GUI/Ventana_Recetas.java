package com.mycompany.recetario.uaem.GUI;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author You
 */
public class Ventana_Recetas {

    VBox vbox;
    FlowPane flow;
    Button btn_buscar;
    TextField txt_buscar;

    public Ventana_Recetas() {
        flow = new FlowPane();
        vbox = new VBox();

        vbox.getChildren().add(Buscador());
        vbox.getChildren().add(Obtener_Tarjetas());

        vbox.setSpacing(20);
    }

    private HBox Buscador() {
        var hbox = new HBox();

        btn_buscar = new Button("Buscar");
        txt_buscar = new TextField();

        hbox.getChildren().add(btn_buscar);
        hbox.getChildren().add(txt_buscar);

        hbox.setSpacing(10);

        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    public FlowPane Obtener_Tarjetas() {
        return flow;
    }

    public VBox Tarjetas_Recetas() {
        return vbox;
    }

    public Button btn_buscar() {
        return btn_buscar;
    }

    public TextField txt_buscar() {
        return txt_buscar;
    }
}
