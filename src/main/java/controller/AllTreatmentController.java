package controller;

import datastorage.DAOCaregiver;
import datastorage.DAOFactory;
import datastorage.PatientDAO;
import datastorage.TreatmentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Caregiver;
import model.Patient;
import model.Treatment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllTreatmentController {
    @FXML
    private TableView<Treatment> tableView;
    @FXML
    private TableColumn<Treatment, Integer> colID;
    @FXML
    private TableColumn<Treatment, Integer> colPid;
    @FXML
    private TableColumn<Treatment, String> colDate;
    @FXML
    private TableColumn<Treatment, String> colBegin;
    @FXML
    private TableColumn<Treatment, String> colEnd;
    @FXML
    private TableColumn<Treatment, String> colDescription;
    @FXML
    private ComboBox<String> patientComboBox;
    @FXML
    private ComboBox<String> caregiverComboBox;
    @FXML
    private Button btnNewTreatment;
    @FXML
    private Button btnDelete;

    private final ObservableList<Treatment> tableviewContent = FXCollections.observableArrayList();
    private TreatmentDAO dao;
    private ObservableList<String> patientComboBoxData = FXCollections.observableArrayList();
    private ObservableList<String> caregiverComboBoxData = FXCollections.observableArrayList();
    private ArrayList<Patient> patientList;
    private ArrayList<Caregiver> caregiverList;

    public void initialize() {
        readAllAndShowInTableView();
        patientComboBox.setItems(patientComboBoxData);
        patientComboBox.getSelectionModel().select(0);

        this.colID.setCellValueFactory(new PropertyValueFactory<>("tid"));
        this.colPid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        this.colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.colBegin.setCellValueFactory(new PropertyValueFactory<>("begin"));
        this.colEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
        this.colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.tableView.setItems(this.tableviewContent);
        createPatientComboBoxData();
        createCaregiverComboBoxData();
    }

    public void readAllAndShowInTableView() {
        this.tableviewContent.clear();
        patientComboBox.getSelectionModel().select(0);
        this.dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        List<Treatment> allTreatments;
        try {
            allTreatments = dao.readAll();
            this.tableviewContent.addAll(allTreatments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createPatientComboBoxData() {
        PatientDAO dao = DAOFactory.getDAOFactory().createPatientDAO();
        try {
            patientList = (ArrayList<Patient>) dao.readAll();
            this.patientComboBoxData.add("alle");
            for (Patient patient : patientList) {
                this.patientComboBoxData.add(patient.getSurname());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createCaregiverComboBoxData() {
        DAOCaregiver dao = DAOFactory.getDAOFactory().createDAOCaregiver();
        try {
            caregiverList = (ArrayList<Caregiver>) dao.readAll();
            this.caregiverComboBoxData.add("alle");
            for (Caregiver caregiver : caregiverList) {
                this.caregiverComboBoxData.add(caregiver.getSurname());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handlePatientComboBox() {
        String selectedItem = this.patientComboBox.getSelectionModel().getSelectedItem();
        this.tableviewContent.clear();
        this.dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        List<Treatment> allTreatments;
        if (selectedItem.equals("alle")) {
            try {
                allTreatments = this.dao.readAll();
                this.tableviewContent.addAll(allTreatments);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Patient patient = searchPatientInList(selectedItem);
        if (patient != null) {
            try {
                allTreatments = dao.readTreatmentsByPid(patient.getPid());
                this.tableviewContent.addAll(allTreatments);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void handleCaregiverComboBox() {
        String selectedItem = this.caregiverComboBox.getSelectionModel().getSelectedItem();
        this.tableviewContent.clear();
        this.dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        List<Treatment> allTreatments;
        if (selectedItem.equals("alle")) {
            try {
                allTreatments = this.dao.readAll();
                this.tableviewContent.addAll(allTreatments);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Caregiver caregiver = searchCaregiverInList(selectedItem);
        if (caregiver != null) {
            try {
                allTreatments = dao.readTreatmentsByPid(caregiver.getCid());
                this.tableviewContent.addAll(allTreatments);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Patient searchPatientInList(String surname) {
        for (Patient patient : this.patientList) {
            if (patient.getSurname().equals(surname)) {
                return patient;
            }
        }
        return null;
    }

    private Caregiver searchCaregiverInList(String surname) {
        for (Caregiver caregiver : this.caregiverList) {
            if (caregiver.getSurname().equals(surname)) {
                return caregiver;
            }
        }
        return null;
    }

    @FXML
    public void handleDelete() {
        int index = this.tableView.getSelectionModel().getSelectedIndex();
        Treatment t = this.tableviewContent.remove(index);
        TreatmentDAO dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        try {
            dao.deleteById(t.getTid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNewTreatment() {
        try {
            String p = this.patientComboBox.getSelectionModel().getSelectedItem();
            Patient patient = searchPatientInList(p);
            newTreatmentWindow(patient);
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Patient für die Behandlung fehlt!");
            alert.setContentText("Wählen Sie über die ComboBox einen Patienten aus!");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleMouseClick() {
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && (tableView.getSelectionModel().getSelectedItem() != null)) {
                int index = this.tableView.getSelectionModel().getSelectedIndex();
                Treatment treatment = this.tableviewContent.get(index);

                treatmentWindow(treatment);
            }
        });
    }

    public void newTreatmentWindow(Patient patient) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/NewTreatmentView.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            //da die primaryStage noch im Hintergrund bleiben soll
            Stage stage = new Stage();

            NewTreatmentController controller = loader.getController();
            controller.initialize(this, stage, patient);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void treatmentWindow(Treatment treatment) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/TreatmentView.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            //da die primaryStage noch im Hintergrund bleiben soll
            Stage stage = new Stage();
            TreatmentController controller = loader.getController();

            controller.initializeController(this, stage, treatment);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}