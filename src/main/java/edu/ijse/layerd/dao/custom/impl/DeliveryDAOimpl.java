package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.DeliveryDAO;
import edu.ijse.layerd.entity.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDAOimpl implements DeliveryDAO {
    @Override
    public boolean save(Delivery entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO delivery VALUES (?,?,?,?,?,?)",entity.getId(),entity.getOrder_id(),entity.getEmp_id(),entity.getStatus(),entity.getLocation(),entity.getDate());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM delivery WHERE id = ?",id);
    }

    @Override
    public boolean update(Delivery entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE delivery SET order_id = ?,emp_id = ?,status = ?,location = ?,date = ? WHERE id = ?",entity.getOrder_id(),entity.getEmp_id(),entity.getStatus(),entity.getLocation(),entity.getDate(),entity.getId());
    }

    @Override
    public ArrayList<Delivery> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM delivery");
        ArrayList<Delivery> deliveryList = new ArrayList<>();
        while (rst.next()){
            Delivery delivery = new Delivery();
            delivery.setId(rst.getString(1));
            delivery.setOrder_id(rst.getString(2));
            delivery.setEmp_id(rst.getString(3));
            delivery.setStatus(rst.getString(4));
            delivery.setLocation(rst.getString(5));
            delivery.setDate(rst.getString(6));
            deliveryList.add(delivery);
        }
        return deliveryList;
    }
}
