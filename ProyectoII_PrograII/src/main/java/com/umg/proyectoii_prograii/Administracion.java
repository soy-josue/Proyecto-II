package com.umg.proyectoii_prograii;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administracion implements Initializable {
    //Mostrar las funciones que nos proporciona esta clase
    static Fecha fecha = new Fecha();
    /**
     * Declaracion de las identificacion de cada objeto Tipo Vehiculo
     */
    @FXML
    private TextField txtPM;
    @FXML
    private TextField txtEM;
    @FXML
    private TextField txtPA;
    @FXML
    private TextField txtEA;
    @FXML
    private TextField txtPC;
    @FXML
    private TextField txtEC;
    @FXML
    private Button bttasg;
    @FXML
    private Label labhora;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Llamamos a la funcion de la clase fecha para incluir la  hora actual
        String hora = fecha.horaActual();
        labhora.setText(hora); // Se mostrar la hora al momento de ejecutar el programa

    }
    //Declaracion de la accion en evento boton asignar

    public void siguiente(ActionEvent event) {
        //Esta linea nos ayuda en trasladarlos entre formulario javafx
        try {
            Parent root = FXMLLoader.load(getClass().getResource("formulario.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();
        } catch (Exception e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void saving(ActionEvent event) {
        //Evaluacion Motociclleta
        //almacenamiento del nombre en los textos
        double preciomoto = 0;
        String preciomotos = String.valueOf(preciomoto);
        preciomotos = txtPM.getText();
        int espaciomoto = 0;
        String espaciomto = String.valueOf(espaciomoto);
        espaciomto = txtEM.getText();

        //Evaluacion Automovil
        //almacenamiento del nombre en los textos
        double precioauto = 0;
        int espacioauto = 0;
        String precioautos = String.valueOf(precioauto);
        precioautos = txtPA.getText();
        String espacioautos = String.valueOf(espacioauto);
        espacioautos = txtEA.getText();

        //Evaluacion Camion
        //almacenamiento del nombre en los textos
        double preciocamion = 0;
        int espaciocamion = 0;
        String preciocamions = String.valueOf(preciocamion);
        preciocamions = txtPC.getText();
        String espaciocamions = String.valueOf(espaciocamion);
        espaciocamions = txtEC.getText();
    }

}
