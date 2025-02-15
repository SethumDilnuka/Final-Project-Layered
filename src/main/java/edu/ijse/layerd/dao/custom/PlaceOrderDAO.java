package edu.ijse.layerd.dao.custom;

import edu.ijse.layerd.dao.CrudDAO;
import edu.ijse.layerd.dto.tm.CartTm;
import edu.ijse.layerd.entity.Order;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderDAO extends CrudDAO<Order> {
    boolean saveOrder(String id, String cId, LocalDate date, Double payment) throws SQLException;

    boolean saveOrderDetail(String id, List<CartTm> tmList) throws SQLException;
}
