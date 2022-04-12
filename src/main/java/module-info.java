module com.example.projecttema2ps {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mvvmFX;
    requires guice;
    requires javax.inject;
    requires com.fasterxml.jackson.databind;
    requires poi.ooxml;
    requires poi.ooxml.schemas;
    requires poi;
    requires json.simple;

    opens com.example.projecttema2ps to javafx.fxml;
    exports com.example.projecttema2ps.model.jdbc.dao;
    exports com.example.projecttema2ps.model;
    exports com.example.projecttema2ps;
    exports com.example.projecttema2ps.viewmodel;
    opens com.example.projecttema2ps.viewmodel to javafx.fxml;
}