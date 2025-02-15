package edu.ijse.layerd.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.UserBO;
import edu.ijse.layerd.util.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.sql.SQLException;

public class ResetPasswordFormController {

    @FXML
    private JFXButton btnReset;

    @FXML
    private TextField txtConPw;

    @FXML
    private TextField txtNewPw;
    @FXML
    private JFXButton btnLogin;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.USER);

    @FXML
    void btnResetOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if(txtNewPw.getText().equals(txtConPw.getText())) {
            boolean isUpdated = userBO.updatePassword(ForgotPasswordController.username, txtNewPw.getText());
            if (isUpdated) {
                System.out.println("OK");
            } else {
                System.out.println("WRONG");
            }
        }else {
            System.out.println("CONFIRMATION NOT MATCHED!");
        }
    }
    @FXML
    void btnLoginOnAction(ActionEvent event) {
        btnLogin.getScene().getWindow().hide();
        Navigation.changeStage("/view/loginPageForm.fxml","Login Form");
    }
    public void initialize(){
        System.out.println(ForgotPasswordController.username);
    }
}
