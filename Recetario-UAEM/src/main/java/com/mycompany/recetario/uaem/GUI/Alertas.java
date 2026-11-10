package com.mycompany.recetario.uaem.GUI;

import javafx.scene.control.*;
/**
 *
 * @author angel
 */
public class Alertas {
    public static void info(String mensaje) {
        mostrar(Alert.AlertType.INFORMATION, "Listo", mensaje);
    }

    public static void advertencia(String mensaje) {
        mostrar(Alert.AlertType.WARNING, "Revisa los datos", mensaje);
    }

    public static void error(String mensaje) {
        mostrar(Alert.AlertType.ERROR, "Error", mensaje);
    }

    public static boolean confirmar(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, mensaje, ButtonType.YES, ButtonType.NO);
        a.setTitle(titulo);
        a.setHeaderText(null);
        return a.showAndWait().filter(b -> b == ButtonType.YES).isPresent();
    }

    private static void mostrar(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert a = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }
}
