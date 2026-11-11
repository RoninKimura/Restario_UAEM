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
        javafx.scene.control.ScrollPane scroll = new javafx.scene.control.ScrollPane(Obtener_Tarjetas());
        scroll.setFitToWidth(true);
        scroll.setHbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setPrefViewportHeight(570);
        scroll.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        vbox.getChildren().add(scroll);

        vbox.setSpacing(20); vbox.getStyleClass().add("app-shell"); flow.setHgap(18); flow.setVgap(18); flow.setPrefWrapLength(850); flow.setPadding(new javafx.geometry.Insets(6));
    }

    private HBox Buscador() {
        var hbox = new HBox();

        btn_buscar = new Button("Buscar");
        txt_buscar = new TextField();

        hbox.getChildren().add(btn_buscar);
        hbox.getChildren().add(txt_buscar);

        hbox.setSpacing(10);

        hbox.setAlignment(Pos.CENTER_LEFT); hbox.getStyleClass().add("search-bar"); txt_buscar.setPromptText("Busca por título o ingrediente..."); txt_buscar.setPrefWidth(520); btn_buscar.setDefaultButton(true);

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
