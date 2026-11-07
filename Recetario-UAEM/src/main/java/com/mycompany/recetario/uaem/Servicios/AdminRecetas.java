package com.mycompany.recetario.uaem.Servicios;
import com.mycompany.recetario.uaem.Modelo.Receta;
import com.mycompany.recetario.uaem.Modelo.Clasificacion;
import java.util.ArrayList;
import javafx.scene.control.Alert;
/**
 *
 * @author You
 */
public class AdminRecetas {
    private int Id=0;
    private ArrayList<Receta> recetas= new ArrayList();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public int ID(){
        return Id++;
    }
    
    public void Agregar(Receta receta){
        recetas.add(receta);
        System.out.print(recetas.size());
    }
    
    public void Editar(int id,String Titulo,String Descripcion,String Clasificacion,
            String Ingredientes,String Procedimiento){
        Buscar(id);
        recetas.get(id).setDescripcion(Descripcion);
        recetas.get(id).setClasificacion(Clasificacion);
        recetas.get(id).setIngredientes(Ingredientes);
        recetas.get(id).setProcedimiento(Procedimiento);
        alert.setContentText("Se modifico " + recetas.get(id).getTitulo() + " Correctamente");
        alert.showAndWait();
    }
    
    public void Eliminar(Receta receta){
        recetas.remove(receta);
    }
    
    public Receta Buscar(int id){
        for(Receta r: recetas){
            if(r.getid()==id){
                return r;
            }
        }
        return null;
    }
    
    public ArrayList<Receta> Obtener_Recetas(){
        return recetas;
    }
}
