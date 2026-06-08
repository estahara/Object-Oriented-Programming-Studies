package Simulados.p3BulletinSimulado.controller;

import Simulados.p3BulletinSimulado.model.Bulletin;import Simulados.p3BulletinSimulado.model.State;import Simulados.p3BulletinSimulado.persistence.SqliteBulletinDao;import Simulados.p3BulletinSimulado.services.FilterBulletinService;import Simulados.p3BulletinSimulado.services.RemoveBulletinService;import Simulados.p3BulletinSimulado.services.StatisticsData;import Simulados.p3BulletinSimulado.services.StatisticsService;import Simulados.p3BulletinSimulado.view.BulletinApp;import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BulletinManagementController {

    @FXML private TableView<Bulletin> tableView;
    @FXML private TableColumn<Bulletin, String> cCity;
    @FXML private TableColumn<Bulletin, LocalDate> cDate;
    @FXML private TableColumn<Bulletin, String> cState;
    @FXML private TableColumn<Bulletin, Integer> cId;
    @FXML private TableColumn<Bulletin, Integer> cInfected;
    @FXML private TableColumn<Bulletin, Double> cIcuRatio;
    @FXML private TableColumn<Bulletin, Integer> cDeaths;

    @FXML private ComboBox<String> cbState;
    @FXML private DatePicker dpEnd;
    @FXML private DatePicker dpBegin;
    @FXML private TextField txtCity;

    @FXML private Label lbAverageIcu;
    @FXML private Label lbTotalDeaths;
    @FXML private Label lbTotalInfected;

    private List<Bulletin> databaseData;
    private ObservableList<Bulletin> tableData;

    private final SqliteBulletinDao bulletinDao = new SqliteBulletinDao();
    private final FilterBulletinService filterService = new FilterBulletinService();
    private final StatisticsService statisticsService = new StatisticsService();
    private final RemoveBulletinService removeService = new RemoveBulletinService(bulletinDao);

    @FXML
    private void initialize() {
        loadStates();
        bindTableViewToItemsList();
        bindColumnsToValueSources();
        loadDataAndUpdateTable();
    }

    private void loadStates() {
        final var stateNames = Arrays.stream(State.values())
                .map(State::toString)
                .collect(Collectors.toList());
        cbState.setItems(FXCollections.observableArrayList(stateNames));
    }

    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void bindColumnsToValueSources() {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        cState.setCellValueFactory(new PropertyValueFactory<>("state"));
        cInfected.setCellValueFactory(new PropertyValueFactory<>("infected"));
        cDeaths.setCellValueFactory(new PropertyValueFactory<>("deaths"));
        cIcuRatio.setCellValueFactory(new PropertyValueFactory<>("IcuRatio"));
        cDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void loadDataAndUpdateTable() {
        databaseData = bulletinDao.findAll();
        updateTable(databaseData);
        updateStatistics(databaseData);
    }

    private void updateTable(List<Bulletin> data){
        tableData.clear();
        tableData.addAll(data);
    }

    @FXML
    public void registerBulletin() throws IOException {

        BulletinApp.setRoot("bulletin");

        BulletinController controller = (BulletinController) BulletinApp.getController();
        controller.setBulletinIntoView(null);

    }

    @FXML
    public void editBulletin() throws IOException {

        Bulletin selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            new Alert(Alert.AlertType.WARNING,
                    "Selecione um boletim para editar.").show();
            return;
        }

        BulletinApp.setRoot("bulletin");

        BulletinController controller = (BulletinController) BulletinApp.getController();
        controller.setBulletinIntoView(selected);

    }

    @FXML
    public void removeBulletin() {
        Bulletin selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            new Alert(Alert.AlertType.WARNING,
                    "Selecione um boletim para remover.").show();
            return;
        }

        try {
            removeService.remove(selected.getId());
            databaseData.remove(selected);
            tableData.remove(selected);
            updateStatistics(new java.util.ArrayList<>(tableData));
        } catch (NoSuchElementException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    public void filter() {
        String city = txtCity.getText();

        String selectedStateName = cbState.getValue();
        State state = (selectedStateName == null || selectedStateName.isBlank())
                ? null
                : State.fromName(selectedStateName);

        LocalDate startDate = dpBegin.getValue();
        LocalDate endDate = dpEnd.getValue();

        List<Bulletin> filtered = filterService.filter(databaseData, city, state, startDate, endDate);

        updateTable(filtered);
        updateStatistics(filtered);
    }

    private void updateStatistics(List<Bulletin> data) {
        StatisticsData stats = statisticsService.createStatistics(data);

        lbTotalInfected.setText(String.valueOf(stats.totalCases()));
        lbTotalDeaths.setText(String.valueOf(stats.totalDeaths()));
        lbAverageIcu.setText(String.format("%.1f%%", stats.avgIcu()));
    }
}
