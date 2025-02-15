package edu.ijse.layerd.bo.custom;

import edu.ijse.layerd.bo.SuperBO;
import edu.ijse.layerd.dto.DeliveryDto;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryBO extends SuperBO {
    boolean deleteDelivery(String id) throws SQLException, ClassNotFoundException;

    List<DeliveryDto> getAllDeliveries() throws SQLException, ClassNotFoundException;

    boolean updateDelivery(DeliveryDto dto) throws SQLException, ClassNotFoundException;

    boolean saveDelivery(DeliveryDto dto) throws SQLException, ClassNotFoundException;
}
