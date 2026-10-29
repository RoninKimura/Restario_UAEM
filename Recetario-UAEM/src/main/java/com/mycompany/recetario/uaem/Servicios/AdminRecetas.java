package com.mycompany.recetario.uaem.Servicios;
import com.mycompany.recetario.uaem.Modelo.Receta;
import java.util.ArrayList;
/**
 *
 * @author You
 */
public class AdminRecetas {
    private ArrayList<Receta> recetas= new ArrayList();
    
    public void Agregar(Receta receta){
        recetas.add(receta);
        System.out.print(recetas.size());
    }
    
    public void Editar(){
        
    }
    
    public void Eliminar(){
        
    }
}
