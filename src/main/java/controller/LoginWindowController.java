package controller;

import datastorage.DAOCredentials;
import datastorage.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import model.Credentials;

import java.io.IOException;
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
    private DAOCredentials dao;

    public void initialize(javafx.scene.control.TextField username, javafx.scene.control.TextField password) {
        usname = this.username.getText();
        psword = this.password.getText();

        System.out.println(this.username.getText() + " " + this.password.getText());
    }

    @FXML
    private void handleLogin(ActionEvent e) {
        initialize(username, password);
        this.dao = DAOFactory.getDAOFactory().createDAOCredentials();

        List<Credentials> allCredentials;
        try {
            allCredentials = dao.readAll();
            for (Credentials c : allCredentials) {
                if(usname.equals(c.getUsername()) && psword.equals(c.getPassword())){
                    showMainWindow();
                }else{
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Eingabe ungültig.");
                    errorAlert.setContentText("Username und oder Passwort sind ungültig.");
                    errorAlert.showAndWait();
                }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        }

    }

    private void showMainWindow(){
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/MainWindowView.fxml"));
        try {
            LoginBorderPane.setCenter(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //Main controller = loader.getController();
    }


}

