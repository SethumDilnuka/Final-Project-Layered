package edu.ijse.layerd.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.UserBO;
import edu.ijse.layerd.dao.custom.UserDAO;
import edu.ijse.layerd.dto.UserDto;
import edu.ijse.layerd.util.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.Random;

public class ForgotPasswordController {

    static int otp;

    @FXML
    private JFXButton btnreset;

    @FXML
    private TextField txtUserName;
    @FXML
    private JFXButton btnBack;
    static String username;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.USER);

    @FXML
    void btnResetOnAction(ActionEvent event) throws SQLException, MessagingException {


        username = txtUserName.getText();
        Random random = new Random();
        otp = random.nextInt(9000);
        otp += 1000;
        UserDto userDto = userBO.getEmail(username);
        System.out.println(userDto.getE_mail());
        EmailController.sendEmail(userDto.getE_mail(), "Fruity fizz verification", otp + "");

        btnreset.getScene().getWindow().hide();
        Navigation.changeStage("/view/otpForm.fxml","OTP Form");

    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        btnBack.getScene().getWindow().hide();
        Navigation.changeStage("/view/loginPageForm.fxml","Login Form");
    }



}
