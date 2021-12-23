package com.example.banksystem.controller;

import com.example.banksystem.Application;
import com.example.banksystem.context.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OverViewController implements Initializable  {

    @FXML
    private Button chooseButton;

    @FXML
    private Text creditname;

    @FXML
    private Button logoutButton;

    @FXML
    private Text nameText;

    @FXML
    private Button overviewButton;

    @FXML
    private Text userIdText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameText.setText(UserContext.getInstance().getUser().getFirstname().concat(" ").concat(UserContext.getInstance().getUser().getLastname()));
        userIdText.setText(String.valueOf(UserContext.getInstance().getUser().getId()));
    }

    public void logoutButtonOnButton(ActionEvent event) {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(Application.class.getResource("view/login.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root, 779, 520);
            scene.getStylesheets().add(Application.class.getResource("css/style.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void chooseButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) chooseButton.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(Application.class.getResource("view/bankInfo.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root, 1065, 658);
            scene.getStylesheets().add(Application.class.getResource("css/style.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }




}
