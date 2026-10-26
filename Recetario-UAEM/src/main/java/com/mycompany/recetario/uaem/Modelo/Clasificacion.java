package com.mycompany.recetario.uaem.Modelo;

import javafx.scene.paint.Color;

/**
 *
 * @author You
 */
public class Clasificacion {
    private String Nombre;
    private String Descripcion;
    private Color Color;
    
    public Clasificacion(String Nombre,String Descripcion, Color Color){
        this.Nombre=Nombre;
        this.Descripcion=Descripcion;
        this.Color=Color;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getDescripcion(){
        return Descripcion;
    }
    public Color getColor(){
        return Color;
    }
    
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public void setDescripcion(String Descripcion){
        this.Descripcion=Descripcion;
    }
    public void setColor(Color Color){
        this.Color=Color;
    }
    
    @Override
    public String toString() {
        return Nombre;
    }
}
