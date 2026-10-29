package com.mycompany.recetario.uaem.Modelo;

/**
 *
 * @author You
 */
public class Receta {
    private String Titulo;
    private String Descripcion;
    private String Clasificacion;
    private String Ingredientes;
    private String Procedimiento;
    
    public Receta(String Titulo,String Descripcion,String Clasificacion,
            String Ingredientes,String Procedimiento){
        this.Titulo= Titulo;
        this.Descripcion= Descripcion;
        this.Clasificacion= Clasificacion;
        this.Ingredientes= Ingredientes;
        this.Procedimiento= Procedimiento;
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
}
