package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.custom.DeliveryBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.custom.DeliveryDAO;
import edu.ijse.layerd.dto.DeliveryDto;
import edu.ijse.layerd.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBOimpl implements DeliveryBO {
    DeliveryDAO deliveryDAO = (DeliveryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);
    @Override
    public boolean deleteDelivery(String id) throws SQLException, ClassNotFoundException {
        return deliveryDAO.delete(id);
    }

    @Override
    public List<DeliveryDto> getAllDeliveries() throws SQLException, ClassNotFoundException {
        List<Delivery> deliveries = deliveryDAO.getAll();
        List<DeliveryDto> deliveryDtos = new ArrayList<>();
        for (Delivery delivery : deliveries) {
            deliveryDtos.add(new DeliveryDto(delivery.getId(),delivery.getOrder_id(),delivery.getEmp_id(),delivery.getStatus(),delivery.getLocation(),delivery.getDate()));
        }
        return deliveryDtos;

    }

    @Override
    public boolean updateDelivery(DeliveryDto dto) throws SQLException, ClassNotFoundException {
        return deliveryDAO.update(new Delivery(dto.getId(),dto.getOrder_id(),dto.getEmp_id(),dto.getStatus(),dto.getLocation(),dto.getDate()));
    }

    @Override
    public boolean saveDelivery(DeliveryDto dto) throws SQLException, ClassNotFoundException {
        return deliveryDAO.save(new Delivery(dto.getId(),dto.getOrder_id(),dto.getEmp_id(),dto.getStatus(),dto.getLocation(),dto.getDate()));
    }
}
