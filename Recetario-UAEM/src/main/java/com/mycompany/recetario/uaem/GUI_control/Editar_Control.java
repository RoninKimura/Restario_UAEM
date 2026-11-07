package com.mycompany.recetario.uaem.GUI_control;
 
import com.mycompany.recetario.uaem.GUI.Admin;
import com.mycompany.recetario.uaem.GUI.Ventana_Agregar;
import com.mycompany.recetario.uaem.Servicios.AdminRecetas;
import com.mycompany.recetario.uaem.GUI.Ventana_Editar;
import com.mycompany.recetario.uaem.GUI.Ventana_Recetas;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import com.mycompany.recetario.uaem.Modelo.Receta;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 *
 * @author You
 */
public class Editar_Control {
    private int id;
    private TextField txt_Titulo;
    private ComboBox txt_Clasificacion;
    private TextArea txt_Descripcion, txt_Ingredientes, txt_Procedimiento;

    public Editar_Control(Ventana_Editar editar, AdminRecetas recetas) {
        txt_Titulo = editar.Titulo();
        txt_Descripcion = editar.Descripcion();
        txt_Clasificacion = editar.Clasificacion();
        txt_Ingredientes = editar.Ingredientes();
        txt_Procedimiento = editar.Procedimiento();

        var btn_Editar = editar.btnEditar();
        var btn_Cancelar = editar.btnCancelar();

        btn_Editar.setOnAction(e -> {
            String Titulo = txt_Titulo.getText();
            String Descripcion = txt_Descripcion.getText();
            Clasificacion clasificacion = (Clasificacion) txt_Clasificacion.getValue();
            String Ingredientes = txt_Ingredientes.getText();
            String Procedimiento = txt_Procedimiento.getText();            
            recetas.Editar(id, Titulo, Descripcion, clasificacion.getNombre(), Ingredientes, Procedimiento);
            Limpiar();
        });
    }

    private void Limpiar() {
        txt_Titulo.setText("");
        txt_Descripcion.setText("");
        txt_Clasificacion.setValue(null);
        txt_Ingredientes.setText("");
        txt_Procedimiento.setText("");
    }
    
    public void ObtenerDatos(Receta r){
        id=r.getid();
        txt_Titulo.setText(r.getTitulo());
        txt_Descripcion.setText(r.getDescripcion());
        txt_Clasificacion.setValue(r.getCalsificacion());
        txt_Ingredientes.setText(r.getIngredientes());
        txt_Procedimiento.setText(r.getProcedimiento());
    }
}
