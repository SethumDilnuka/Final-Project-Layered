package edu.ijse.layerd.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.UserBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import edu.ijse.layerd.util.Navigation;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageFormController {

    public AnchorPane AncLogin;
    @FXML
    private JFXButton btnBooking;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnOrder;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSupplier;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colTblName;

    @FXML
    private TableView<?> tblBooking;

    @FXML
    private TextField txtBookiId;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtTblName;

UserBO userBO = (UserBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.USER);
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;
    private ActionEvent actionEvent;
    @FXML
    private PasswordField passwordfield1;

    @FXML
    private Hyperlink txtForgetPassword;



    @FXML
    private TextField usernametxt;


    public void hlinkForgotPassword(ActionEvent actionEvent) {
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
    }

//    public void hyperFogotPasswordOnAction(ActionEvent actionEvent) {
//    }

    @FXML
    void hyperFogotPasswordOnAction(ActionEvent event) {
        txtForgetPassword.getScene().getWindow().hide();
        Navigation.changeStage("/view/forgotPassword.fxml","FORGOT PASSWORD FORM");
    }



    public void btncheckpasswordbtnonaction(ActionEvent actionEvent) {
    }

    public void btninvisiblebtnonaction(ActionEvent actionEvent) {
    }

    public void btnOnActionLogin(ActionEvent actionEvent) throws IOException {
        System.out.println("loginnnn");
        //this.actionEvent = actionEvent;
        // AncLogin.getChildren().clear();
        // AnchorPane load = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        // AncLogin.getChildren().add(load);
        if (userBO.verifyCredentials(usernametxt.getText(), passwordfield1.getText())) {
            System.out.println("login");
            try {
                Navigation.switchNavigation("dashboardForm.fxml", actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("failed");
        }
        //Navigation.switchNavigation("dashboardForm.fxml",actionEvent);
//        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
//
//        Scene scene = new Scene(rootNode);
//
//        Stage stage = (Stage) txtBookiId.getScene().getWindow();
//        stage.setScene(scene);
//        stage.centerOnScreen();
//        stage.setTitle("Login Form");
    }

    public void hyperCreateAccOnAction(ActionEvent actionEvent) {
    }
}
