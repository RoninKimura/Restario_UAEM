package com.mycompany.recetario.uaem.Excepciones;

/**
 *
 * @author angel
 */
public class ExcepcionesRecetario extends Exception{
        public ExcepcionesRecetario(String mensaje) {
            super(mensaje);
        }

        public ExcepcionesRecetario(String mensaje, Throwable causa) {
            super(mensaje, causa);
        }
}
