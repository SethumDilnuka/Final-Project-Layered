package edu.ijse.layerd.bo.custom;

import edu.ijse.layerd.bo.SuperBO;
import edu.ijse.layerd.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {
    List<SupplierDto> getAllSuppliers() throws SQLException, ClassNotFoundException;

    boolean updateSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException;

    boolean saveSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;
}
