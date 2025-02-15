package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.custom.SupplierBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.custom.SupplierDAO;
import edu.ijse.layerd.dto.SupplierDto;
import edu.ijse.layerd.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOimpl implements SupplierBO {
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);
    @Override
    public List<SupplierDto> getAllSuppliers() throws SQLException, ClassNotFoundException {
        List<Supplier> list = supplierDAO.getAll();
        List<SupplierDto> dtos = new ArrayList<>();
        for (Supplier supplier : list) {
            dtos.add(new SupplierDto(supplier.getId(),supplier.getCompany_name(),supplier.getLocation(),supplier.getMobile(),supplier.getEmail()));
        }
        return dtos;

    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new Supplier(dto.getId(),dto.getCompany_name(),dto.getLocation(),dto.getMobile(),dto.getEmail()));
    }

    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(new Supplier(dto.getId(),dto.getCompany_name(),dto.getLocation(),dto.getMobile(),dto.getEmail()));
    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }
}
