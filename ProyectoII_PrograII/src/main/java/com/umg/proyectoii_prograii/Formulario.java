package com.umg.proyectoii_prograii;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Formulario implements Initializable {
    /**
     * Declaracion de las identificacion de cada Texto para asignarles datos
     */
    static Fecha fecha = new Fecha();
    Persona p = new Persona();
    @FXML
    private Button bttAceptar;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtNit;
    @FXML
    private Label labfecha;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
        String date = fecha.fechaActual();//Mostrar las funciones que nos proporciona esta clase
        labfecha.setText(date);

    }

    //public void almacenar() {
    //almacenamiento del nombre en los textos
    //String name = txtname.getText();
    //name = p.getNombre();
    //String nits = txtNit.getText();
    //nits = p.getNit();
    //  //Esta linea nos ayuda en trasladarlos entre formulario javafx
    //}

    //public void imprimir(String nombres, String nita) {
    //   fomr.almacenar();
    // }

    public void aceptar(ActionEvent event) {
        //almacenamiento del nombre en los textos
        String name = txtname.getText();
        name = p.getNombre();
        String nits = txtNit.getText();
        nits = p.getNit();
        //Esta linea nos ayuda en trasladarlos entre formulario javafx
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Ticket.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();
        } catch (Exception e) {

        }
    }
}
