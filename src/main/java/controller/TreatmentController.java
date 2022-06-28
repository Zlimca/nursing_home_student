package controller;

import datastorage.CaregiverDAO;
import datastorage.DAOFactory;
import datastorage.PatientDAO;
import datastorage.TreatmentDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Caregiver;
import model.Patient;
import model.Treatment;

import java.sql.SQLException;
import java.time.LocalDate;

public class TreatmentController {
    @FXML
    private Label lblPatientName;
    @FXML
    private Label lblCaregiverName;
    @FXML
    private Label lblCaregiverPhone;
    @FXML
    private Label lblCarelevel;
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
    @FXML
    private Button btnChange;
    @FXML
    private Button btnCancel;

    private AllTreatmentController controller;
    private Stage stage;
    private Patient patient;
    private Caregiver caregiver;
    private Treatment treatment;

    /**
     * Initialization of the {@link TreatmentController}
     *
     * @param controller {@link AllTreatmentController}
     * @param stage      Stage
     * @param treatment  {@link Treatment}
     */
    public void initializeController(AllTreatmentController controller, Stage stage, Treatment treatment) {
        this.stage = stage;
        this.controller = controller;
        PatientDAO pDao = DAOFactory.getDAOFactory().createPatientDAO();
        CaregiverDAO caregiverDAO = DAOFactory.getDAOFactory().createDAOCaregiver();
        try {
            this.patient = pDao.read(treatment.getPid());
            this.caregiver = caregiverDAO.read(treatment.getCaregiverId());
            this.treatment = treatment;
            showData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Puts all data into labels
     */
    private void showData() {
        this.lblPatientName.setText(patient.getSurname() + ", " + patient.getFirstname());
        this.lblCarelevel.setText(patient.getCareLevel());
        this.lblCaregiverName.setText(caregiver.getSurname() + ", " + caregiver.getFirstname());
        this.lblCaregiverPhone.setText(caregiver.getPhoneNumber());
        LocalDate date = treatment.getDate();
        this.datepicker.setValue(date);
        this.txtBegin.setText(this.treatment.getBegin().toString());
        this.txtEnd.setText(this.treatment.getEnd().toString());
        this.txtDescription.setText(this.treatment.getDescription());
        this.taRemarks.setText(this.treatment.getRemarks());
    }

    @FXML
    public void handleChange(){
        this.treatment.setDate(this.datepicker.getValue().toString());
        this.treatment.setBegin(txtBegin.getText());
        this.treatment.setEnd(txtEnd.getText());
        this.treatment.setDescription(txtDescription.getText());
        this.treatment.setRemarks(taRemarks.getText());
        doUpdate();
        controller.readAllAndShowInTableView();
        stage.close();
    }

    private void doUpdate(){
        TreatmentDAO dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        try {
            dao.update(treatment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCancel(){
        stage.close();
    }
}