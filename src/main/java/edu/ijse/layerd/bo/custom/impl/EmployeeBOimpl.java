package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.custom.EmployeeBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.custom.EmployeeDAO;
import edu.ijse.layerd.dto.EmployeeDto;
import edu.ijse.layerd.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOimpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }

    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getId(),dto.getName(),dto.getRole(),dto.getMobile(),dto.getEmail()));
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getId(),dto.getName(),dto.getRole(),dto.getMobile(),dto.getEmail()));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> all = employeeDAO.getAll();
        List<EmployeeDto> dtos = new ArrayList<>();
        for (Employee employee : all) {
            dtos.add(new EmployeeDto(employee.getId(),employee.getName(),employee.getRole(),employee.getMobile(),employee.getEmail()));
        }
        return dtos;
    }
}
