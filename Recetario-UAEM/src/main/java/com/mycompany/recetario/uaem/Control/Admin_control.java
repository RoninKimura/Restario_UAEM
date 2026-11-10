package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.Archivos.Archivo_Excel;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.Servicios.AdminClasificaciones;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Clasificacion;

import java.io.File;
import javafx.scene.control.*;
import javafx.stage.*;

/**
 *
 * @author You
 */
public class Admin_control {

    public Admin_control(Admin admin, Stage stage, Ventana_Recetas mostrar_recetas,
            AdminRecetas recetas, AdminClasificaciones clasificaciones) {
        Ventana_Editar editar = new Ventana_Editar();
        Editar_Control editar_control = new Editar_Control(editar, recetas, admin,
                mostrar_recetas);
        Recetas_Control recetas_control = new Recetas_Control(editar,
                mostrar_recetas, recetas, admin, editar_control);
        editar_control.tomaRecetasControl(recetas_control);
        Ventana_Agregar agregar = new Ventana_Agregar();
        Agregar_Control agregar_control = new Agregar_Control(agregar, recetas,
                admin, mostrar_recetas, recetas_control);
        Ventana_Clasificacion clasificacion = new Ventana_Clasificacion();
        Clasificacion_Control clasificacion_control = new Clasificacion_Control(
                clasificacion, admin, agregar, editar, clasificaciones);

        admin.Btn_ver_us().setOnAction(e -> User_Control.Abrir(recetas, clasificaciones));

        var btn_home = admin.Btn_home();
        var btn_agregar = admin.Btn_agregar();
        var btn_clas = admin.Btn_clas();
        var btn_view_user = admin.Btn_ver_us();
        var btn_excel = admin.Btn_Excel();

        btn_home.setOnAction(e -> {
            admin.ComboBox_Admin().setValue(null);
            mostrar_recetas.txt_buscar().setText("");
            admin.Ventanas(mostrar_recetas);
            recetas_control.Actualizar_Tarjetas();
        });

        btn_agregar.setOnAction(e -> {
            var vbox = admin.Ventanas(mostrar_recetas);
            vbox.getChildren().clear();
            vbox.getChildren().add(agregar.VBox_Agregar());
        });

        btn_clas.setOnAction(e -> {
            var vbox = admin.Ventanas(mostrar_recetas);
            vbox.getChildren().clear();
            vbox.getChildren().add(clasificacion.VBox_Clasificacion());
        });

        btn_excel.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setInitialFileName("recetas.xlsx");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel", "*.xlsx"));
            File destino = fc.showSaveDialog(admin.Btn_Excel().getScene().getWindow());
            if (destino == null) {
                return;
            }
            try {
                Archivo_Excel.ExportarRecetas(recetas.Obtener_Recetas(), destino);
                new Alert(Alert.AlertType.INFORMATION, "Recetas exportadas correctamente").showAndWait();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "No se pudo exportar el archivo").showAndWait();
            }
        });
    }
}
