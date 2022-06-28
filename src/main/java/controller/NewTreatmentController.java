package controller;

import datastorage.DAOFactory;
import datastorage.TreatmentDAO;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Caregiver;
import model.Patient;
import model.Treatment;
import utils.DateConverter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class NewTreatmentController {
    @FXML
    private Label lblSurname;
    @FXML
    private Label lblFirstname;
    @FXML
    private Label lblCaregiverSurname;
    @FXML
    private Label lblCaregiverFirstname;
    @FXML
    private TextField txtBegin;
    @FXML
    private TextField txtEnd;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextArea taRemarks;
    @FXML
    private DatePicker datepicker;

    private AllTreatmentController controller;
    private Patient patient;
    private Caregiver caregiver;
    private Stage stage;

    /**
     * Initializes the new treatment window data
     *
     * @param controller @{@link AllTreatmentController}
     * @param stage      Stage
     * @param patient    @{@link Patient}
     * @param caregiver  @{@link Caregiver}
     */
    public void initialize(AllTreatmentController controller, Stage stage, Patient patient, Caregiver caregiver) {
        this.controller = controller;
        this.patient = patient;
        this.caregiver = caregiver;
        this.stage = stage;
        showPatientData();
        showCaregiverData();
    }

    /**
     * Puts patient data into labels
     */
    private void showPatientData() {
        this.lblFirstname.setText(patient.getFirstname());
        this.lblSurname.setText(patient.getSurname());
    }

    /**
     * Puts caregiver data into labels
     */
    private void showCaregiverData() {
        this.lblCaregiverFirstname.setText(caregiver.getFirstname());
        this.lblCaregiverSurname.setText(caregiver.getSurname());
    }

    @FXML
    public void handleAdd() {
        LocalDate date = this.datepicker.getValue();
        LocalTime begin = DateConverter.autoCompleteTime(txtBegin.getText());
        LocalTime end = DateConverter.autoCompleteTime(txtEnd.getText());
        String description = txtDescription.getText();
        String remarks = taRemarks.getText();
        Treatment treatment = new Treatment(patient.getPid(), caregiver, date, begin, end, description, remarks);
        createTreatment(treatment);
        controller.readAllAndShowInTableView();
        stage.close();
    }

    /**
     * Creates entry in table from {@link Treatment}
     *
     * @param treatment Treatment object
     */
    private void createTreatment(Treatment treatment) {
        TreatmentDAO dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        try {
            dao.create(treatment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCancel(){
        stage.close();
    }
}