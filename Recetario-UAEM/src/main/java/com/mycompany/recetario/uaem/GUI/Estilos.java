package com.mycompany.recetario.uaem.GUI;
import java.net.URL;
import javafx.scene.Scene;
public final class Estilos { private Estilos() {} public static void aplicar(Scene scene) { URL css=Estilos.class.getResource("/styles/recetario.css"); if(css!=null) scene.getStylesheets().add(css.toExternalForm()); } }
