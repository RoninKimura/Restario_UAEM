package com.mycompany.recetario.uaem.GUI_control;

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
    private TextField txt_nombre;
    private TextArea txt_descripcion;

    public Clasificacion_Control(Ventana_Clasificacion ventana_clasificacion) {
        var choose_clasificacion=ventana_clasificacion.Combo_Box();
        txt_nombre = ventana_clasificacion.Txt_Nombre();
        txt_descripcion = ventana_clasificacion.Txt_Descripcion();
        var color = ventana_clasificacion.Color();
        var btn_agregar = ventana_clasificacion.Btn_Agregar();
        var btn_editar = ventana_clasificacion.Btn_Editar();
        var btn_eliminar = ventana_clasificacion.Btn_Eliminar();
        var btn_limpiar = ventana_clasificacion.Btn_Limpiar();
        
        
        
        btn_agregar.setOnAction(e -> {
            String nombre = txt_nombre.getText();
            String descripcion = txt_descripcion.getText();

            Clasificacion clasificacion = new Clasificacion(nombre, descripcion, color);
            
            clasificaciones.Agregar(clasificacion);
            
            choose_clasificacion.getItems().add(clasificacion);
            
            Limpiar();
        });

        btn_editar.setOnAction(e->{
            
            String nombre = txt_nombre.getText();
            clasificaciones.Editar(nombre);
        });

        btn_eliminar.setOnAction(e -> {
            String nombre = txt_nombre.getText();
            clasificaciones.Eliminar(nombre);
            Limpiar();
        });
        
        btn_limpiar.setOnAction(e->{
            Limpiar();
        });
    }
    
    public void Limpiar(){
        txt_nombre.setText("");
        txt_descripcion.setText("");
    }
}
