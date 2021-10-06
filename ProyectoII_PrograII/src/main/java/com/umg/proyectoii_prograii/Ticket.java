package com.umg.proyectoii_prograii;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class Ticket implements Initializable {
    ObservableList<String> tipoVehiculo = FXCollections.observableArrayList("Motocicleta", "Camion", "Automovil");
    static Fecha fecha = new Fecha();
    @FXML
    private Button bttaceptarT;
    @FXML
    private ComboBox comobV;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comobV.setItems(tipoVehiculo);
        //comobV.getSelectionModel().select("Motocicleta");
        //comobV.getSelectionModel().select("Camion");
        //comobV.getSelectionModel().select("Automovil");
        //comobV.getSelectionModel().getSelectedItem();

    }

    public static void ingreso() {
        /*
         * Creamos Documento Ticket
         * */
        Document doc = new Document(PageSize.A6.rotate());
        //Numero random para la generacion del numero del Tickect
        Random r1 = new Random();
        Random r2 = new Random();
        int n1 = r1.nextInt(75 - 25 + 1) + 25;
        int n2 = r2.nextInt(75 - 25 - 1) + 25;
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("Ticket.pdf"));
            Rectangle pagasize = new Rectangle(216f, 720f);
            doc.open();
            Font bold = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            /**
             * Declaramos los titulos del documento
             * */
            Paragraph paragraph = new Paragraph("Ticket de Parqueo Chonitas Grill");
            Paragraph titulo = new Paragraph("Boulevard Austriaco 37-01");
            Paragraph dire = new Paragraph("Zona 16 Guatemala, Guatemala");
            Paragraph entrada = new Paragraph("Fecha: " + fecha.fechaActual());//Mostrar las funciones que nos proporciona esta clase
            Paragraph hentrada = new Paragraph("Horario de Entrada: " + fecha.horaActual());//Mostrar las funciones que nos proporciona esta clase
            Paragraph noticket = new Paragraph(" Ticket NO: " + "AE" + n1 + "ED" + n2);
            /**
             * Añadimos los titlos del Documento
             * */
            doc.add(pagasize);
            doc.add(paragraph);
            doc.add(titulo);
            doc.add(dire);
            doc.add(entrada);
            doc.add(hentrada);
            doc.add(noticket);
            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void aceptart(ActionEvent event) {
        Ticket.ingreso();
        //Esta linea nos ayuda en trasladarlos entre formulario javafx
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Documento.fxml"));
            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.toFront();
            appStage.show();
        } catch (Exception e) {

        }
    }

    public void desplegar(ActionEvent event) {
    }

    //public void desplegar(ActionEvent event) {}
}
