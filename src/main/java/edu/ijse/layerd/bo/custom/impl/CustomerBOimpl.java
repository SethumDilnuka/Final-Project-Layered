package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.CustomerBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.custom.CustomerDAO;
import edu.ijse.layerd.dto.CustomerDto;
import edu.ijse.layerd.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerBOimpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getMobile(),dto.getDob()));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getMobile(),dto.getDob()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException, ClassNotFoundException {
        List <Customer> all = customerDAO.getAll();

        List<CustomerDto> dtos = new ArrayList<>() ;

        for (Customer customer : all) {
            dtos.add(new CustomerDto(customer.getId(),customer.getName(),customer.getAddress(),customer.getEmail(),customer.getMobile(),customer.getDob()));
        }
        return dtos;

    }
}
