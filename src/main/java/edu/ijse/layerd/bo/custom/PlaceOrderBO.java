package edu.ijse.layerd.bo.custom;

import edu.ijse.layerd.bo.SuperBO;
import edu.ijse.layerd.dto.OrdersDto;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(OrdersDto placeOrderDto) throws SQLException;

    String generateNextOrderId();

    ObservableList<String> loadOrderId() throws SQLException;
}
