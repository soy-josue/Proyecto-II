module com.umg.proyectoii_prograii {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires itextpdf;
    requires java.desktop;
    requires java.logging;

    opens com.umg.proyectoii_prograii to javafx.fxml;
    exports com.umg.proyectoii_prograii;
}