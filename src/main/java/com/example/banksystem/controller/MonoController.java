package com.example.banksystem.controller;

import com.example.banksystem.Application;
import com.example.banksystem.context.UserContext;
import com.example.banksystem.dao.BankInfoDao;
import com.example.banksystem.dao.BankTypeDao;
import com.example.banksystem.dao.Dao;
import com.example.banksystem.model.BankInfo;
import com.example.banksystem.model.BankType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MonoController implements Initializable {

    @FXML
    private Label Maxsum;

    @FXML
    private Text Name;

    @FXML
    private Label Names;

    @FXML
    private Button backbutton;

    @FXML
    private Button choose;

    @FXML
    private Button conytinuebutton;

    @FXML
    private Text iduser;

    @FXML
    private Button logout;

    @FXML
    private Label maxterm;

    @FXML
    private Label minsum;

    @FXML
    private Label minterm;

    @FXML
    private Button overview;

    @FXML
    private Label percent;

    private List<BankInfo> bankInfoList;
    private Dao<BankInfo> bankInfoDao;
    private Dao<BankType> bankTypeDao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setText(UserContext.getInstance().getUser().getFirstname().concat(" ").concat(UserContext.getInstance().getUser().getLastname()));
        iduser.setText(String.valueOf(UserContext.getInstance().getUser().getId()));

        bankInfoDao = new BankInfoDao();
        bankTypeDao = new BankTypeDao();            // <=====
        bankInfoList = bankInfoDao.getAll();

        Optional<BankType> bankType = bankTypeDao.get(1);
        Names.setText("Name bank : " + bankType.get().getName());
        minsum.setText("Minimal sum : " + bankInfoList.get(0).getMinSum());
        Maxsum.setText("Maximal sum : " + +bankInfoList.get(0).getMaxSum());
        minterm.setText("Minimal term : " + +bankInfoList.get(0).getMinTerm());
        maxterm.setText("Maximal term : " + +bankInfoList.get(0).getMaxTerm());
        percent.setText("Percent : " + bankInfoList.get(0).getPercent());
    }


    public void logoutOnAction(ActionEvent event) {
        Stage stage = (Stage) logout.getScene().getWindow();
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

    public void OverviewOnAction(ActionEvent event) {
        Stage stage = (Stage) overview.getScene().getWindow();
        stage.close();

        try {
            Parent root = FXMLLoader.load(Application.class.getResource("view/overView.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root, 725, 514);
            scene.getStylesheets().add(Application.class.getResource("css/style.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void chooseButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) choose.getScene().getWindow();
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
