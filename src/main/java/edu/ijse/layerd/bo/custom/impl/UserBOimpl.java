package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.custom.UserBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.custom.UserDAO;
import edu.ijse.layerd.dto.UserDto;

import java.sql.SQLException;

public class UserBOimpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean updatePassword(String username, String text) throws SQLException, ClassNotFoundException {
        return userDAO.updatepass(username,text);
    }

    @Override
    public UserDto getEmail(String username) throws SQLException {
        return userDAO.getemail(username);
    }

    @Override
    public boolean verifyCredentials(String text, String text1) {
        return userDAO.verifyCredentials(text,text1);
    }
}
