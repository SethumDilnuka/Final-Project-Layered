package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.CustomerDAO;
import edu.ijse.layerd.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOIMPL implements CustomerDAO {
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO customer VALUES(?,?,?,?,?,?)",entity.getId(),entity.getName(),entity.getAddress(),entity.getMobile(),entity.getEmail(),entity.getDob());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE id=?",id);
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET name=?,address=?,mobile=?,email=?,dob=? WHERE id=?",entity.getName(),entity.getAddress(),entity.getMobile(),entity.getEmail(),entity.getDob(),entity.getId());
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");
        ArrayList<Customer> customerList = new ArrayList<>();
        while (rst.next()){
            Customer customer = new Customer();
            customer.setId(rst.getString(1));
            customer.setName(rst.getString(2));
            customer.setAddress(rst.getString(3));
            customer.setMobile(rst.getString(4));
            customer.setEmail(rst.getString(5));
            customer.setDob(rst.getString(6));
            customerList.add(customer);
        }
        return customerList;
    }
}
