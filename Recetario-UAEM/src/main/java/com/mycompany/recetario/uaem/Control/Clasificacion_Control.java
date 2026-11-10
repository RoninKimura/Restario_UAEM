package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.Excepciones.Validacion;
import com.mycompany.recetario.uaem.Servicios.Validador;
import com.mycompany.recetario.uaem.GUI.Alertas;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
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

    private AdminClasificaciones clasificaciones;

    private ComboBox choose_clasificacion, choose_clasificaciones,
            txt_Clasificacion, txt_clasificacion, clasificacion_user;
    private TextField txt_nombre;
    private TextArea txt_descripcion;
    private Color color;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public Clasificacion_Control(Ventana_Clasificacion ventana_clasificacion,
            Admin admin, Ventana_Agregar agregar, Ventana_Editar editar,
            AdminClasificaciones clasificaciones) {
        this.clasificaciones = clasificaciones;
        choose_clasificacion = ventana_clasificacion.Combo_Box();
        choose_clasificaciones = admin.ComboBox_Admin();
        txt_Clasificacion = agregar.Clasificacion();
        txt_clasificacion = editar.Clasificacion();
        txt_nombre = ventana_clasificacion.Txt_Nombre();
        txt_descripcion = ventana_clasificacion.Txt_Descripcion();
        color = ventana_clasificacion.Color();

        for (Clasificacion c : clasificaciones.Obtener_Clasificaciones()) {
            choose_clasificacion.getItems().add(c);
            choose_clasificaciones.getItems().add(c);
            txt_Clasificacion.getItems().add(c);
            txt_clasificacion.getItems().add(c);
        }

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
                    txt_clasificacion.getItems().add(clasificacion);
                }
            }
            Limpiar();
        });

        choose_clasificacion.setOnAction(e -> {
            Clasificacion seleccion = (Clasificacion) choose_clasificacion.getValue();
            if (seleccion == null) {
                return;
            }
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
            if (choose_clasificacion.getValue() == null) {
                Alertas.advertencia("Selecciona la clasificacion que quieres eliminar.");
                return;
            }
            int id = choose_clasificacion.getSelectionModel().getSelectedIndex();
            Object borrada = choose_clasificacion.getItems().get(id);
            String nombre = ((Clasificacion) borrada).getNombre();
            if (!Alertas.confirmar("Eliminar clasificacion",
                    "Seguro que quieres eliminar \"" + nombre + "\"?")) {
                return;
            }
            clasificaciones.Eliminar(id);
            choose_clasificacion.getItems().remove(borrada);
            choose_clasificaciones.getItems().remove(borrada);
            txt_Clasificacion.getItems().remove(borrada);
            txt_clasificacion.getItems().remove(borrada);
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
        try {
            Validador.ValidarClasificacion(nombre, descripcion);
            return true;
        } catch (Validacion ex) {
            Alertas.advertencia(ex.getMessage());
            return false;
        }
    }
}
