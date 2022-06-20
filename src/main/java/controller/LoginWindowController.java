package controller;

import datastorage.CredentialsDAO;
import datastorage.DAOFactory;
import datastorage.PatientDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Credentials;
import model.Patient;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LoginWindowController {

    @FXML
    private BorderPane LoginBorderPane;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblPassword;
    private CredentialsDAO dao;

    public void initialize(AllTreatmentController controller, Stage stage, Patient patient) {
        checkCaregiverData();
    }

    @FXML
    private void handleLogin(ActionEvent e) {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/MainWindowView.fxml"));
        try {
            LoginBorderPane.setCenter(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void checkCaregiverData(){

        this.dao = DAOFactory.getDAOFactory().createCredentialsDAO();
        List<Credentials> allCredentials;
        try {
            allCredentials = dao.readAll();
            for (Credentials c : allCredentials) {
                //lese Daten aus Login-Tabelle + checke auf Übereinstimmung

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

