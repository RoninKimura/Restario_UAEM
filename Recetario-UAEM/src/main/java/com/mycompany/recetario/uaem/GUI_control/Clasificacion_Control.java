package com.mycompany.recetario.uaem.GUI_control;

import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;
import com.mycompany.recetario.uaem.GUI.Ventana_Clasificacion;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Servicios.AdminClasificaciones;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

/**
 *
 * @author You
 */
public class Clasificacion_Control {

    AdminClasificaciones clasificaciones = new AdminClasificaciones();

    private ComboBox choose_clasificacion, choose_clasificaciones, txt_Clasificacion;
    private TextField txt_nombre;
    private TextArea txt_descripcion;
    private Color color;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public Clasificacion_Control(Ventana_Clasificacion ventana_clasificacion,
            Admin admin, Ventana_Agregar agregar) {
        choose_clasificacion = ventana_clasificacion.Combo_Box();
        choose_clasificaciones = admin.ComboBox_Admin();
        txt_Clasificacion = agregar.Clasificacion();
        txt_nombre = ventana_clasificacion.Txt_Nombre();
        txt_descripcion = ventana_clasificacion.Txt_Descripcion();
        color = ventana_clasificacion.Color();
        
        var btn_agregar = ventana_clasificacion.Btn_Agregar();
        var btn_editar = ventana_clasificacion.Btn_Editar();
        var btn_eliminar = ventana_clasificacion.Btn_Eliminar();
        var btn_limpiar = ventana_clasificacion.Btn_Limpiar();

        btn_agregar.setOnAction(e -> {
            String nombre = txt_nombre.getText();
            String descripcion = txt_descripcion.getText();
            if (NoVacios(nombre, descripcion)) {
                Clasificacion clasificacion = new Clasificacion(nombre, descripcion, color);
                if (clasificaciones.ExisteNombre(nombre)) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText(nombre + " Ya Existe");
                    alert.showAndWait();
                } else {
                    clasificaciones.Agregar(clasificacion);
                    choose_clasificacion.getItems().add(clasificacion);
                    choose_clasificaciones.getItems().add(clasificacion);
                    txt_Clasificacion.getItems().add(clasificacion);
                }
            }
            Limpiar();
        });

        choose_clasificacion.setOnAction(e -> {
            Clasificacion seleccion = (Clasificacion) choose_clasificacion.getValue();
            txt_nombre.setText(seleccion.getNombre());
            txt_descripcion.setText(seleccion.getDescripcion());
        });

        btn_editar.setOnAction(e -> {
            String nombre = txt_nombre.getText();
            String descripcion = txt_descripcion.getText();
            if (NoVacios(nombre, descripcion)) {
                int id = choose_clasificacion.getSelectionModel().getSelectedIndex();
                if (clasificaciones.ExisteNombreE(nombre, id)) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText(nombre + " Ya Existe");
                    alert.showAndWait();
                } else {
                    clasificaciones.Editar(id, nombre, descripcion, color);
                }
            }
            Limpiar();
        });

        btn_eliminar.setOnAction(e -> {
            String nombre = txt_nombre.getText();
            String descripcion = txt_descripcion.getText();
            if (NoVacios(nombre, descripcion)) {
                if (!clasificaciones.ExisteNombre(nombre)) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText(nombre + " No Existe");
                    alert.showAndWait();
                } else {
                    int id = choose_clasificacion.getSelectionModel().getSelectedIndex();
                    clasificaciones.Eliminar(id);
                    choose_clasificacion.getItems().remove(id);
                }
            }
            Limpiar();
        });

        btn_limpiar.setOnAction(e -> {
            Limpiar();
        });
    }

    private void Limpiar() {
        txt_nombre.setText("");
        txt_descripcion.setText("");
        choose_clasificacion.setValue(null);
    }

    private boolean NoVacios(String nombre, String descripcion) {
        if (nombre.equals("") || descripcion.equals("")) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Por Favor llene todos lo campos");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }
}
