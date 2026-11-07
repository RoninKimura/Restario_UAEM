package com.mycompany.recetario.uaem.Modelo;

import com.mycompany.recetario.uaem.Modelo.Clasificacion;
/**
 *
 * @author You
 */
public class Receta {
    private int id;
    private String Titulo;
    private String Descripcion;
    private String Clasificacion;
    private String Ingredientes;
    private String Procedimiento;
    
    public Receta(int id,String Titulo,String Descripcion,String Clasificacion,
            String Ingredientes,String Procedimiento){
        this.id=id;
        this.Titulo= Titulo;
        this.Descripcion= Descripcion;
        this.Clasificacion= Clasificacion;
        this.Ingredientes= Ingredientes;
        this.Procedimiento= Procedimiento;
    }
    public int getid(){
        return id;
    }
    public String getTitulo(){
        return Titulo;
    }
    public String getDescripcion(){
        return Descripcion;
    }
    public String getCalsificacion(){
        return Clasificacion;
    }
    public String getIngredientes(){
        return Ingredientes;
    }
    public String getProcedimiento(){
        return Procedimiento;
    }
    
    public void setTitulo(String Titulo){
        this.Titulo=Titulo;
    }
    public void setDescripcion(String Descripcion){
        this.Descripcion=Descripcion;
    }
    public void setClasificacion(String Clasificacion){
        this.Clasificacion=Clasificacion;
    }
    public void setIngredientes(String Ingredientes){
        this.Ingredientes=Ingredientes;
    }
    public void setProcedimiento(String Procedimiento){
        this.Procedimiento=Procedimiento;
    }
}
