package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.GUI.Tarjetas_Recetas;
import com.mycompany.recetario.uaem.GUI.User;
import com.mycompany.recetario.uaem.GUI.Ventana_Receta;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Servicios.AdminClasificaciones;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.Archivos.Archivo_PDF;

import java.io.File;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class User_Control {

    private Receta receta;
    private final User user;
    private final Ventana_Recetas mostrar_recetas;
    private final AdminRecetas recetas;
    private final Ventana_Receta ventana_receta;
    private final ComboBox combo;

    private Button btn_volver, btn_download;

    public User_Control(User user, Ventana_Recetas mostrar_recetas,
            AdminRecetas recetas, AdminClasificaciones clasificaciones) {

        this.user = user;
        this.mostrar_recetas = mostrar_recetas;
        this.recetas = recetas;
        this.ventana_receta = new Ventana_Receta();
        this.combo = user.ComboBox_user();

        btn_volver = ventana_receta.btn_volver();
        btn_download = ventana_receta.btn_download();

        Clasificacion todas = new Clasificacion("Todas", "", Color.WHITE);
        combo.getItems().add(todas);
        combo.getItems().addAll(clasificaciones.Obtener_Clasificaciones());
        combo.setValue(todas);

        combo.setOnAction(e -> {
            user.Ventanas(mostrar_recetas);
            Actualizar_Tarjetas();
        });

        btn_volver.setOnAction(e -> {
            user.Ventanas(mostrar_recetas);
        });

        btn_download.setOnAction(e -> {
            Descargar(receta, btn_download.getScene().getWindow());
        });
        Actualizar_Tarjetas();
    }

    public void Actualizar_Tarjetas() {
        Clasificacion filtro = (Clasificacion) combo.getValue();
        var flow = mostrar_recetas.Obtener_Tarjetas();
        flow.getChildren().clear();

        for (Receta r : recetas.Obtener_Recetas()) {
            if (filtro != null && !filtro.getNombre().equals("Todas")
                    && !filtro.getNombre().equals(r.getCalsificacion())) {
                continue;
            }

            Tarjetas_Recetas tarjeta = new Tarjetas_Recetas();
            tarjeta.id = r.getid();
            tarjeta.NombreImagen = r.getImagen();
            tarjeta.Titulo = r.getTitulo();
            tarjeta.Descripcion = r.getDescripcion();
            tarjeta.Clasificacion = r.getCalsificacion();

            flow.getChildren().add(tarjeta.Tarjetas_Recetas());
            tarjeta.mod_users();

            tarjeta.btn_ver().setOnAction(e -> {
                receta = r;
                ventana_receta.Cargar(r);
                var vbox = user.Ventanas(mostrar_recetas);
                vbox.getChildren().clear();
                vbox.getChildren().add(ventana_receta.Receta_Ventana());
            });

            tarjeta.btn_download().setOnAction(e -> {
                Descargar(r, tarjeta.btn_download().getScene().getWindow());
            });
        }
    }

    public static void Abrir(AdminRecetas recetas, AdminClasificaciones clasificaciones) {
        Ventana_Recetas mostrar_recetas = new Ventana_Recetas();
        User user = new User(mostrar_recetas);
        new User_Control(user, mostrar_recetas, recetas, clasificaciones);

        Stage user_stage = new Stage();
        user_stage.setScene(user.scene_user());
        user_stage.setResizable(false);
        user_stage.setTitle("Recetario UAEM");
        user_stage.show();
    }

    private void Descargar(Receta receta, Window ventana) {
        if (receta == null) {
            return;
        }
        FileChooser fc = new FileChooser();
        fc.setInitialFileName(receta.getTitulo().replaceAll("[\\\\/:*?\"<>|]", "_") + ".pdf");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        File destino = fc.showSaveDialog(ventana);
        if (destino == null) {
            return;
        }
        if (!destino.getName().toLowerCase().endsWith(".pdf")) {
            destino = new File(destino.getAbsolutePath() + ".pdf");
        }
        try {
            Archivo_PDF.GenerarReceta(receta, destino);
            new Alert(Alert.AlertType.INFORMATION, "Receta descargada correctamente").showAndWait();
        } catch (Throwable ex) {
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "No se pudo generar el PDF").showAndWait();
        }
    }
}
