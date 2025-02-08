package edu.ijse.layerd.bo.custom;

import edu.ijse.layerd.bo.SuperBO;
import edu.ijse.layerd.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    List<CustomerDto> getAllCustomers() throws SQLException, ClassNotFoundException;
}
