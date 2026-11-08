package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Editar_Control {
    private int id;
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

        var btn_Editar = editar.btnEditar();
        var btn_Cancelar = editar.btnCancelar();

        btn_Editar.setOnAction(e -> {
            Clasificacion clasificacion = (Clasificacion) txt_Clasificacion.getValue();
            if (clasificacion == null) {
                return;
            }
            recetas.Editar(id, txt_Titulo.getText(), txt_Descripcion.getText(),
                    clasificacion.getNombre(), txt_Ingredientes.getText(),
                    txt_Procedimiento.getText());
            recetas_control.Actualizar_Tarjetas();
            Limpiar();
            admin.Ventanas(mostrar_recetas);
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
    }
}