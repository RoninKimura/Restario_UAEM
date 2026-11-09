package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.Archivos.Imagen;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.Control.Recetas_Control;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;

import javafx.scene.control.*;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 *
 * @author You
 */
public class Agregar_Control {

    private File imagen;
    private ImageView vista_imagen;
    private TextField txt_Titulo;
    private ComboBox txt_Clasificacion;
    private TextArea txt_Descripcion, txt_Ingredientes, txt_Procedimiento;

    public Agregar_Control(Ventana_Agregar agregar, AdminRecetas recetas,
            Admin admin, Ventana_Recetas mostrar_recetas,
            Recetas_Control recetas_control) {
        txt_Titulo = agregar.Titulo();
        txt_Descripcion = agregar.Descripcion();
        txt_Clasificacion = agregar.Clasificacion();
        txt_Ingredientes = agregar.Ingredientes();
        txt_Procedimiento = agregar.Prodecimiento();

        vista_imagen = agregar.Vista_Imagen();

        var btn_Imagen = agregar.Btn_Imagen();
        var btn_Agregar = agregar.Btn_Agregar();
        var btn_Cancelar = agregar.Btn_Cancelar();

        btn_Imagen.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "Imagenes", "*.png", "*.jpg", "*.jpeg", "*.gif"));
            File f = fc.showOpenDialog(agregar.Btn_Imagen().getScene().getWindow());
            if (f != null) {
                imagen = f;
                vista_imagen.setImage(new Image(f.toURI().toString(), 150, 90, true, true));
            }
        });

        btn_Agregar.setOnAction(e -> {
            String Titulo = txt_Titulo.getText();
            String Descripcion = txt_Descripcion.getText();
            Clasificacion clasificacion = (Clasificacion) txt_Clasificacion.getValue();
            if (clasificacion == null) {
                return;
            }
            String Ingredientes = txt_Ingredientes.getText();
            String Procedimiento = txt_Procedimiento.getText();
            String nombreImagen = "";
            if (imagen != null) {
                try {
                    nombreImagen = Imagen.Guardar(imagen);
                } catch (Exception ex) {
                    new Alert(Alert.AlertType.ERROR, "No se pudo guardar la imagen").showAndWait();
                    return;
                }
            }
            Receta receta = new Receta(recetas.ID(), nombreImagen, Titulo, Descripcion,
                    clasificacion.getNombre(), Ingredientes, Procedimiento);
            recetas.Agregar(receta);
            recetas_control.Actualizar_Tarjetas();

            Limpiar();
        });

        btn_Cancelar.setOnAction(e -> {
            admin.Ventanas(mostrar_recetas);
        });
    }

    private void Limpiar() {
        imagen = null;
        vista_imagen.setImage(null);
        txt_Titulo.setText("");
        txt_Descripcion.setText("");
        txt_Clasificacion.setValue(null);
        txt_Ingredientes.setText("");
        txt_Procedimiento.setText("");
    }
}
