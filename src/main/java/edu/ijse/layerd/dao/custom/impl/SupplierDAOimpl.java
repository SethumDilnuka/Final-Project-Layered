package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.SupplierDAO;
import edu.ijse.layerd.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOimpl implements SupplierDAO {
    @Override
    public boolean save(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO supplier Values (?,?,?,?,?)",entity.getId(),entity.getCompany_name(),entity.getLocation(),entity.getMobile(),entity.getEmail());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM supplier WHERE id = ?",id);
    }

    @Override
    public boolean update(Supplier entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE supplier SET company_name = ?,location = ?,mobile = ?,email = ? WHERE id = ?",entity.getCompany_name(),entity.getLocation(),entity.getMobile(),entity.getEmail(),entity.getId());
    }

    @Override
    public ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM supplier");
        ArrayList<Supplier> supplierList = new ArrayList<>();
        while (rst.next()){
            Supplier supplier = new Supplier();
            supplier.setId(rst.getString(1));
            supplier.setCompany_name(rst.getString(2));
            supplier.setLocation(rst.getString(3));
            supplier.setMobile(rst.getString(4));
            supplier.setEmail(rst.getString(5));
            supplierList.add(supplier);
        }
        return supplierList;
    }
}
