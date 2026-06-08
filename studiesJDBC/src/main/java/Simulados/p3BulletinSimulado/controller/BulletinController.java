package Simulados.p3BulletinSimulado.controller;

import Simulados.p3BulletinSimulado.exception.EntityAlreadyExistsException;
import Simulados.p3BulletinSimulado.model.Bulletin;
import Simulados.p3BulletinSimulado.model.State;
import Simulados.p3BulletinSimulado.persistence.SqliteBulletinDao;
import Simulados.p3BulletinSimulado.services.RegisterBulletinService;
import Simulados.p3BulletinSimulado.services.UpdateBulletinService;
import Simulados.p3BulletinSimulado.view.BulletinApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextField;
import java.util.NoSuchElementException;

public class BulletinController {
    @FXML private TextField txtCity;
    @FXML private ComboBox<State> cbState;
    @FXML
    private DatePicker dpDate;
    @FXML private TextField         txtInfected;
    @FXML private TextField         txtDeaths;
    @FXML private TextField         txtIcuRatio;

    private final SqliteBulletinDao bulletinDao     = new SqliteBulletinDao();
    private final RegisterBulletinService registerService = new RegisterBulletinService(bulletinDao);
    private final UpdateBulletinService updateService   = new UpdateBulletinService(bulletinDao);

    private Bulletin currentBulletin;

    @FXML
    private void initialize() {
        cbState.setItems(FXCollections.observableArrayList(State.values()));
    }

    public void setBulletinIntoView(Bulletin bulletin) {
        currentBulletin = bulletin;

        if (bulletin == null) return;

        txtCity.setText    (bulletin.getCity());
        cbState.setValue   (bulletin.getState());
        dpDate.setValue    (bulletin.getDate());
        txtInfected.setText(String.valueOf(bulletin.getInfected()));
        txtDeaths.setText  (String.valueOf(bulletin.getDeaths()));
        txtIcuRatio.setText(String.valueOf(bulletin.getIcuRatio()));
    }

    public Bulletin getBulletinFromView() {
        int id = (currentBulletin != null) ? currentBulletin.getId() : 0;

        return new Bulletin(
                id,
                txtCity.getText(),
                cbState.getValue(),
                Integer.parseInt(txtInfected.getText()),
                Integer.parseInt(txtDeaths.getText()),
                Double.parseDouble(txtIcuRatio.getText()),
                dpDate.getValue()
        );
    }

    @FXML
    private void save() {
        try {
            Bulletin bulletin = getBulletinFromView();

            if (currentBulletin == null) {
                registerService.register(bulletin);
            } else {
                updateService.update(bulletin);
            }

            goToManagementScreen();

        } catch (EntityAlreadyExistsException | NoSuchElementException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING,
                    "Preencha todos os campos numéricos corretamente.").show();
        }
    }

    @FXML
    private void cancel() {
        goToManagementScreen();
    }

    private void goToManagementScreen() {
        try {
            BulletinApp.setRoot("bulletin_management");
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,
                    "Erro ao voltar para a tela principal.").show();
        }
    }
}
