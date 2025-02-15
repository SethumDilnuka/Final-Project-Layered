package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.custom.PlaceOrderDAO;
import edu.ijse.layerd.db.DbConnection;
import edu.ijse.layerd.dto.tm.CartTm;
import edu.ijse.layerd.entity.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderDAOimpl implements PlaceOrderDAO {
    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveOrder(String id, String cId, LocalDate date, Double payment) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO orders VALUES(?, ?, ?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);
        pstm.setString(2, cId);
        pstm.setDate(3, Date.valueOf(date));
        pstm.setDouble(4, payment);


        return pstm.executeUpdate() > 0;    }

    @Override
    public boolean saveOrderDetail(String id, List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!saveOrderDetails(id, cartTm)) {
                return false;
            }
        }
        return true;
    }

    private boolean saveOrderDetails(String orderId, CartTm cartTm) throws SQLException {
        System.out.println(cartTm);
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO order_detail VALUES (?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, orderId);
        pstm.setString(2, cartTm.getCode());
        pstm.setString(3, cartTm.getDescription());
        pstm.setInt(4, cartTm.getQty());
        pstm.setDouble(5, cartTm.getUnitPrice());
        pstm.setDouble(6,cartTm.getTot());

        boolean isSaved = pstm.executeUpdate() > 0;
        System.out.println(isSaved);
        return isSaved;
    }
}
