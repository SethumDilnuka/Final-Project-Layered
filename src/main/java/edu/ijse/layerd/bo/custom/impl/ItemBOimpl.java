package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.custom.ItemBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.ItemDAO;
import edu.ijse.layerd.dto.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemBOimpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new edu.ijse.layerd.entity.Item(dto.getId(),dto.getName(),dto.getCategory(),dto.getBrand(),dto.getUnitPrice(),dto.getQty()));
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
return itemDAO.update(new edu.ijse.layerd.entity.Item(dto.getId(),dto.getName(),dto.getCategory(),dto.getBrand(),dto.getUnitPrice(),dto.getQty()));   }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
return itemDAO.delete(id);    }

    @Override
    public List<ItemDto> getAllItems() throws SQLException, ClassNotFoundException {
        List<edu.ijse.layerd.entity.Item> list = itemDAO.getAll();
        List<ItemDto> dtos = new ArrayList<>();
        for (edu.ijse.layerd.entity.Item item : list) {
            dtos.add(new ItemDto(item.getId(),item.getName(),item.getCategory(),item.getBrand(),item.getUnitPrice(),item.getQty()));
        }
        return dtos;
    }
}
