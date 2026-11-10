package com.mycompany.recetario.uaem.Excepciones;

/**
 *
 * @author angel
 */
public class ExcepcionesArchivo extends Exception{
    public ExcepcionesArchivo(String mensaje) {
        super(mensaje);
    }

    public ExcepcionesArchivo(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
