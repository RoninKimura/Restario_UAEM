package com.mycompany.recetario.uaem.Control;

import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.Control.Recetas_Control;
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;
import javafx.scene.control.*;

/**
 *
 * @author You
 */
public class Agregar_Control {

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

        var btn_Agregar = agregar.Btn_Agregar();
        var btn_Cancelar = agregar.Btn_Cancelar();

        btn_Agregar.setOnAction(e -> {
            String Titulo = txt_Titulo.getText();
            String Descripcion = txt_Descripcion.getText();
            Clasificacion clasificacion = (Clasificacion) txt_Clasificacion.getValue();
            if (clasificacion == null) {
                return;
            }
            String Ingredientes = txt_Ingredientes.getText();
            String Procedimiento = txt_Procedimiento.getText();
            Receta receta = new Receta(recetas.ID(), Titulo, Descripcion, clasificacion.getNombre(),
                    Ingredientes, Procedimiento);
            recetas.Agregar(receta);
            recetas_control.Actualizar_Tarjetas();

            Limpiar();
        });

        btn_Cancelar.setOnAction(e -> {
            admin.Ventanas(mostrar_recetas);
        });
    }

    private void Limpiar() {
        txt_Titulo.setText("");
        txt_Descripcion.setText("");
        txt_Clasificacion.setValue(null);
        txt_Ingredientes.setText("");
        txt_Procedimiento.setText("");
    }
}
