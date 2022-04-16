module oop.librarysystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
//    requires mysql.connector.java;

    opens oop.librarysystem to javafx.fxml;
    exports oop.librarysystem;
}