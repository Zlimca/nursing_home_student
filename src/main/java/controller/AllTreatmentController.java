package controller;

import datastorage.CaregiverDAO;
import datastorage.DAOFactory;
import datastorage.PatientDAO;
import datastorage.TreatmentDAO;
import javafx.beans.property.SimpleStringProperty;
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
    private TableColumn<Treatment, String> colCId;
    @FXML
    private TableColumn<Treatment, String> colFirstname;
    @FXML
    private TableColumn<Treatment, String> colSurname;
    @FXML
    private TableColumn<Treatment, String> colPhoneNumber;
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
    private final ObservableList<String> patientComboBoxData = FXCollections.observableArrayList();
    private final ObservableList<String> caregiverComboBoxData = FXCollections.observableArrayList();
    private ArrayList<Patient> patientList;
    private ArrayList<Caregiver> caregiverList;

    /**
     * Initializes the UI for the treatments
     **/
    public void initialize() {
        readAllAndShowInTableView();
        patientComboBox.setItems(patientComboBoxData);
        patientComboBox.getSelectionModel().select(0);
        caregiverComboBox.setItems(caregiverComboBoxData);
        caregiverComboBox.getSelectionModel().select(0);

        this.colID.setCellValueFactory(new PropertyValueFactory<>("tid"));
        this.colPid.setCellValueFactory(new PropertyValueFactory<>("pid"));
        this.colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.colBegin.setCellValueFactory(new PropertyValueFactory<>("begin"));
        this.colEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
        this.colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.colCId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCaregiverId() + ""));
        this.colFirstname.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCaregiver().getFirstname()));
        this.colSurname.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCaregiver().getSurname()));
        this.colPhoneNumber.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCaregiver().getPhoneNumber()));
        this.tableView.setItems(this.tableviewContent);
        createPatientComboBoxData();
        createCaregiverComboBoxData();
    }

    /**
     * Reads all treatments and adds them to the tableview
     **/
    public void readAllAndShowInTableView() {
        this.tableviewContent.clear();
        patientComboBox.getSelectionModel().select(0);
        caregiverComboBox.getSelectionModel().select(0);
        this.dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        List<Treatment> allTreatments;
        try {
            allTreatments = dao.readAll();
            this.tableviewContent.addAll(allTreatments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the patient data to add it into the combo box
     **/
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

    /**
     * Reads the caregiver data to add it into the combo box
     **/
    private void createCaregiverComboBoxData() {
        CaregiverDAO dao = DAOFactory.getDAOFactory().createDAOCaregiver();
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

    /**
     * Patient combo box handler
     **/
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

    /**
     * Caregiver combo box handler
     **/
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
                allTreatments = dao.readTreatmentsByCid(caregiver.getCId());
                this.tableviewContent.addAll(allTreatments);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Search function for searching a patient
     **/
    private Patient searchPatientInList(String surname) {
        for (Patient patient : this.patientList) {
            if (patient.getSurname().equals(surname)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Search function for searching a caregiver
     **/
    private Caregiver searchCaregiverInList(String surname) {
        for (Caregiver caregiver : this.caregiverList) {
            if (caregiver.getSurname().equals(surname)) {
                return caregiver;
            }
        }
        return null;
    }

    /**
     * Handler for deleting a data set
     **/
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

    /**
     * Handler for adding a data set
     **/
    @FXML
    public void handleNewTreatment() {
        try {
            String p = this.patientComboBox.getSelectionModel().getSelectedItem();
            Patient patient = searchPatientInList(p);
            String c = this.caregiverComboBox.getSelectionModel().getSelectedItem();
            Caregiver caregiver = searchCaregiverInList(c);
            newTreatmentWindow(patient, caregiver);
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Patient für die Behandlung fehlt!");
            alert.setContentText("Wählen Sie über die ComboBox einen Patienten aus!");
            alert.showAndWait();
        }
    }

    /**
     * Handler for mouse clicks
     **/
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

    /**
     * Opens and handles the window when creating a new treatment
     **/
    public void newTreatmentWindow(Patient patient, Caregiver caregiver) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/NewTreatmentView.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            //da die primaryStage noch im Hintergrund bleiben soll
            Stage stage = new Stage();

            NewTreatmentController controller = loader.getController();
            controller.initialize(this, stage, patient, caregiver);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens and handles the information windows for a treatment
     **/
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
            e.printStackTrace();
        }
    }
}