package edu.ijse.layerd.dao.custom;

import edu.ijse.layerd.dao.CrudDAO;
import edu.ijse.layerd.dto.UserDto;
import edu.ijse.layerd.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    boolean updatepass(String username, String text) throws SQLException, ClassNotFoundException;

    UserDto getemail(String username) throws SQLException;
}
