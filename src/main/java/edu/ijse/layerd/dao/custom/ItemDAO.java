package edu.ijse.layerd.dao.custom;

import edu.ijse.layerd.bo.custom.ItemBO;
import edu.ijse.layerd.dao.CrudDAO;
import edu.ijse.layerd.dto.tm.CartTm;
import edu.ijse.layerd.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item>{
    boolean updateQty(List<CartTm> tmList) throws SQLException;
}
