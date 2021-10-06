package com.umg.proyectoii_prograii;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Documento implements Initializable {
    /**
     * Declaracion de las identificacion de cada Texto para asignarles datos
     */
    static Fecha fecha = new Fecha(); //Mostrar las funciones que nos proporciona esta clase
    @FXML
    private CheckBox opfactura;
    @FXML
    private CheckBox opNit;
    @FXML
    private Button btAceptar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
        //Mostrar las funciones que nos proporciona esta clase

    }

    public void generar(ActionEvent event) {
        /*
         * Creacion del Documento Factura
         * */
        Document fac = new Document(PageSize.DEMY_QUARTO);
        try {
            PdfWriter.getInstance(fac, new FileOutputStream("Factura.pdf"));
            fac.open();
            Font diseño = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            /*
             * Parrafo - Titulo
             * */
            Paragraph titulo_f = new Paragraph("Los Equipos, Sociedad Anonima");
            Paragraph addres = new Paragraph("Boulevard Austriaco 37-01");
            Paragraph addes01 = new Paragraph("Zona 16, Guatemala, Guatemala");
            Paragraph addes02 = new Paragraph("NIT: 9737625-6");
            Paragraph addes03 = new Paragraph("Vigente 15-02-2022");
            Paragraph addes04 = new Paragraph("Resolucion 2021-1-61-2098688");
            Paragraph addes05 = new Paragraph("De Fecha : " + fecha.fechaActual() + " " + fecha.horaActual());
            Paragraph serie = new Paragraph("SCEQ04 del 1045001 al 1065000");
            Paragraph datafac = new Paragraph("Factura: SCEQ04  No: ");
            Paragraph spacio1 = new Paragraph("                        ");
            Paragraph spacio2 = new Paragraph("                        ");
            Paragraph spacio3 = new Paragraph("                        ");

            /*
             * Añadimos los titulos al documento
             * */
            fac.add(titulo_f);
            fac.add(addres);
            fac.add(addes01);
            fac.add(addes02);
            fac.add(addes03);
            fac.add(addes04);
            fac.add(addes05);
            fac.add(serie);
            fac.add(datafac);
            fac.add(spacio1);
            fac.add(spacio2);
            fac.add(spacio3);
            /*
             * Creamos una Tabla Datos de Factura
             * */
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Nombre:                      ");
            tabla.addCell("NIT:                         ");
            tabla.addCell("Telefono:                    ");
            tabla.addCell("Cantidad:                    ");
            tabla.addCell("Descripcion:                 ");
            tabla.addCell("Total:                       ");
            //tabla.addCell(name);
            //tabla.addCell(nit);
            //tabla.addCell(Tel);
            //tabla.addCell(can);
            //tabla.addCell(Des + "  ");
            //tabla.addCell("Q" + tt);
            /*
             * Añadimos la tabla
             * */
            fac.add(tabla);
            /*
             * Añadimos el titulo final de la factura
             * */
            Paragraph spacio4 = new Paragraph("                        ");
            Paragraph spacio5 = new Paragraph("                        ");
            Paragraph spacio6 = new Paragraph("                        ");
            Paragraph defi = new Paragraph("Sujeto a Retencion Definitiva");
            fac.add(spacio4);
            fac.add(spacio5);
            fac.add(spacio6);
            fac.add(defi);
            /*
             * Se cierra el Documento
             * */
            fac.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
