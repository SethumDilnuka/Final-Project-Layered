package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.UserDAO;
import edu.ijse.layerd.db.DbConnection;
import edu.ijse.layerd.dto.UserDto;
import edu.ijse.layerd.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOimpl implements UserDAO {
    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean updatepass(String username, String text) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE user SET password=? WHERE username=?",text,username);
    }

    @Override
    public UserDto getemail(String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE username=?";
        ResultSet resultSet = null;

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,username);
        try {
            resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                return new UserDto(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)

                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;    }

    @Override
    public boolean verifyCredentials(String text, String text1) {
        try {
            DbConnection instance = DbConnection.getInstance();
            Connection connection = instance.getConnection();

            String sql = "SELECT password FROM user WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,text);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                if (text1.equals(resultSet.getString(1))){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
        }
}
