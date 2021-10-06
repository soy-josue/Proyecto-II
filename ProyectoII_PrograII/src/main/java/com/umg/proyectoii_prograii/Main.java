package com.umg.proyectoii_prograii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /**
         * Ejecucion de la ventana principal
         * */
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 310, 311);
        stage.setTitle("Estacionamiento_ProyectoII"); //Nombre de la ventana
        stage.setScene(scene);
        stage.show();
    }

    //Inicializa el programa
    public static void main(String[] args) {
        launch();
    }
}