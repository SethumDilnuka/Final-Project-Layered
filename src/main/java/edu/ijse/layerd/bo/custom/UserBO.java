package edu.ijse.layerd.bo.custom;

import edu.ijse.layerd.bo.SuperBO;
import edu.ijse.layerd.dto.UserDto;

import java.sql.SQLException;

public interface UserBO extends SuperBO {

    boolean updatePassword(String username, String text) throws SQLException, ClassNotFoundException;

    UserDto getEmail(String username) throws SQLException;

    boolean verifyCredentials(String text, String text1);
}
