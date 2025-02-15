package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.EmployeeDAO;
import edu.ijse.layerd.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAoimpl implements EmployeeDAO {
    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee VALUES (?,?,?,?,?)",entity.getId(),entity.getName(),entity.getRole(),entity.getMobile(),entity.getEmail());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE id = ?",id);
    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET name = ?,role = ?,mobile = ?,email = ? WHERE id = ?",entity.getName(),entity.getRole(),entity.getMobile(),entity.getEmail(),entity.getId());
    }

    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM employee");
        ArrayList<Employee> employeeList = new ArrayList<>();
        while (rst.next()){
            Employee employee = new Employee();
            employee.setId(rst.getString(1));
            employee.setName(rst.getString(2));
            employee.setRole(rst.getString(3));
            employee.setMobile(rst.getString(4));
            employee.setEmail(rst.getString(5));
            employeeList.add(employee);
        }
        return employeeList;
    }
}
