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

import java.awt.*;
import java.io.IOException;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;
import java.util.List;

public class LoginWindowController {

    @FXML
    private BorderPane LoginBorderPane;
    @FXML
    javafx.scene.control.TextField username;
    @FXML
    javafx.scene.control.TextField password;

    private String usname;
    private String psword;
    private CredentialsDAO dao;

    public void initialize(javafx.scene.control.TextField username, javafx.scene.control.TextField password) {
        usname = this.username.getText();
        psword = this.password.getText();

        System.out.println(this.username.getText() + " " + this.password.getText());
    }

    @FXML
    private void handleLogin(ActionEvent e) {
        initialize(username, password);
        if(usname == "Kunibert" && psword == "1234"){
            System.out.println("aaa");
            showMainWindow();
        }else{
            System.out.println("Meh");
        }

    }

    private void showMainWindow(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/MainWindowView.fxml"));
        try {
            LoginBorderPane.setCenter(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Main controller = loader.getController();
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

