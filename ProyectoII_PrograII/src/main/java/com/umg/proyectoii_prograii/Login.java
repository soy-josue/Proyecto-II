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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    static Fecha fecha = new Fecha();
    @FXML
    private Label lblhrs;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtpassword;
    @FXML
    private Button btnValidar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Mostrar las funciones que nos proporciona esta clase
        String date = fecha.horaActual();
        lblhrs.setText(date);

    }

    public void btmInicio(ActionEvent event) {
        //se loguea un usuario por default al que llamaremos "admin"
        //con una contrasena "123"
        if (txtUser.getText().equals("admin") && txtpassword.getText().equals("123")) {
            //Esta linea nos ayuda en trasladarlos entre formulario javafx
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Administracion.fxml"));
                Scene scene = new Scene(root);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.toFront();
                appStage.show();
            } catch (Exception e) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecto!", "Advertencia", JOptionPane.ERROR_MESSAGE);
            //Mensaje de adbertencia si el usuario se confuente de ingresar los datos correctos
        }
    }
}
