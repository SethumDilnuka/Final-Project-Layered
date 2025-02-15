package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.custom.ItemBO;
import edu.ijse.layerd.bo.custom.PlaceOrderBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.custom.ItemDAO;
import edu.ijse.layerd.dao.custom.PlaceOrderDAO;
import edu.ijse.layerd.db.DbConnection;
import edu.ijse.layerd.dto.OrdersDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderBOimpl implements PlaceOrderBO {

    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean placeOrder(OrdersDto placeOrderDto) throws SQLException {
        System.out.println(placeOrderDto);
        boolean result = false;
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = placeOrderDAO.saveOrder(placeOrderDto.getId(), placeOrderDto.getC_id(), placeOrderDto.getDate(),placeOrderDto.getPayment());
            if (isOrderSaved) {
                boolean isUpdated = itemDAO.updateQty(placeOrderDto.getTmList());
                if(isUpdated) {
                    boolean isOrderDetailSaved = placeOrderDAO.saveOrderDetail(placeOrderDto.getId(), placeOrderDto.getTmList());
                    System.out.println(isOrderDetailSaved);
                    if(isOrderDetailSaved) {
                        connection.commit();
                        result = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return result;    }

    @Override
    public String generateNextOrderId() {
        return "";
    }

    @Override
    public ObservableList<String> loadOrderId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM orders";
        ObservableList<String> empData = FXCollections.observableArrayList();
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet resultSet = pstm.executeQuery(sql);
            while (resultSet.next()) {
                empData.add(
                        resultSet.getString(1)
                );
            }
            return empData;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
}
