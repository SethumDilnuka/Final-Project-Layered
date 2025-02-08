package edu.ijse.layerd.dao;


import java.sql.SQLException;
import java.util.ArrayList;


public interface CrudDAO<T> extends SuperDAO {
    boolean save(T entity) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    boolean update(T entity) throws SQLException, ClassNotFoundException;
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}
