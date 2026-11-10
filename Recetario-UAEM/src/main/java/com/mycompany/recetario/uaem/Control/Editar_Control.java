package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.Excepciones.ExcepcionesArchivo;
import com.mycompany.recetario.uaem.Excepciones.Duplicado;
import com.mycompany.recetario.uaem.Excepciones.Validacion;
import com.mycompany.recetario.uaem.GUI.Alertas;
import com.mycompany.recetario.uaem.Servicios.Validador;
import com.mycompany.recetario.uaem.Archivos.Imagen;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;

import javafx.scene.control.*;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class Editar_Control {

    private int id;
    private String imagenActual = "";
    private File imagenElegida;
    private ImageView vista_imagen;
    private TextField txt_Titulo;
    private ComboBox txt_Clasificacion;
    private TextArea txt_Descripcion, txt_Ingredientes, txt_Procedimiento;
    private Recetas_Control recetas_control;

    public Editar_Control(Ventana_Editar editar, AdminRecetas recetas,
            Admin admin, Ventana_Recetas mostrar_recetas) {
        txt_Titulo = editar.Titulo();
        txt_Descripcion = editar.Descripcion();
        txt_Clasificacion = editar.Clasificacion();
        txt_Ingredientes = editar.Ingredientes();
        txt_Procedimiento = editar.Procedimiento();

        vista_imagen = editar.Vista_Imagen();

        var btn_Imagen = editar.btnImagen();
        var btn_Editar = editar.btnEditar();
        var btn_Cancelar = editar.btnCancelar();

        btn_Imagen.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                    "Imagenes", "*.png", "*.jpg", "*.jpeg", "*.gif"));
            File f = fc.showOpenDialog(editar.btnImagen().getScene().getWindow());
            if (f != null) {
                imagenElegida = f;
                vista_imagen.setImage(new Image(f.toURI().toString(), 150, 90, true, true));
            }
        });

        btn_Editar.setOnAction(e -> {
            try {
                Clasificacion clasificacion = (Clasificacion) txt_Clasificacion.getValue();
                Validador.ValidarReceta(txt_Titulo.getText(), txt_Descripcion.getText(),
                        clasificacion, txt_Ingredientes.getText(), txt_Procedimiento.getText(),
                        imagenElegida);
                recetas.ValidarTitulo(txt_Titulo.getText(), id);

                String nombreImagen = imagenActual;
                if (imagenElegida != null) {
                    nombreImagen = Imagen.Guardar(imagenElegida);
                }
                recetas.Editar(id, nombreImagen, txt_Titulo.getText().trim(),
                        txt_Descripcion.getText().trim(), clasificacion.getNombre(),
                        txt_Ingredientes.getText().trim(), txt_Procedimiento.getText().trim());
                recetas_control.Actualizar_Tarjetas();
                Limpiar();
                admin.Ventanas(mostrar_recetas);
            } catch (Validacion | Duplicado ex) {
                Alertas.advertencia(ex.getMessage());
            } catch (ExcepcionesArchivo ex) {
                Alertas.error(ex.getMessage());
            }
        });

        btn_Cancelar.setOnAction(e -> {
            Limpiar();
            admin.Ventanas(mostrar_recetas);
        });
    }

    public void tomaRecetasControl(Recetas_Control rc) {
        this.recetas_control = rc;
    }

    private void Limpiar() {
        txt_Titulo.setText("");
        txt_Descripcion.setText("");
        txt_Clasificacion.setValue(null);
        txt_Ingredientes.setText("");
        txt_Procedimiento.setText("");
        imagenElegida = null;
        imagenActual = "";
        vista_imagen.setImage(null);
    }

    public void ObtenerDatos(Receta r) {
        id = r.getid();
        txt_Titulo.setText(r.getTitulo());
        txt_Descripcion.setText(r.getDescripcion());
        txt_Ingredientes.setText(r.getIngredientes());
        txt_Procedimiento.setText(r.getProcedimiento());

        txt_Clasificacion.setValue(null);
        for (Object item : txt_Clasificacion.getItems()) {
            Clasificacion clasificacion = (Clasificacion) item;
            if (clasificacion.getNombre().equals(r.getCalsificacion())) {
                txt_Clasificacion.setValue(clasificacion);
            }
        }
        imagenActual = r.getImagen() == null ? "" : r.getImagen();
        imagenElegida = null;
        vista_imagen.setImage(Imagen.Cargar(imagenActual, 150, 90));
    }
}
