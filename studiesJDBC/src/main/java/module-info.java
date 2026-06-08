module p3BulletinSimulado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens Simulados.p3BulletinSimulado.view       to javafx.fxml;
    opens Simulados.p3BulletinSimulado.controller to javafx.fxml;
    opens Simulados.p3BulletinSimulado.model      to javafx.fxml;
    opens Simulados.p3BulletinSimulado.persistence to javafx.fxml;

    exports Simulados.p3BulletinSimulado.view;
    exports Simulados.p3BulletinSimulado.controller;
    exports Simulados.p3BulletinSimulado.model;
    exports Simulados.p3BulletinSimulado.persistence;
    exports Simulados.p3BulletinSimulado.services;
    exports Simulados.p3BulletinSimulado.dao;
    exports Simulados.p3BulletinSimulado.exception;
}