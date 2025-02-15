package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.ItemDAO;
import edu.ijse.layerd.db.DbConnection;
import edu.ijse.layerd.dto.ItemDto;
import edu.ijse.layerd.dto.tm.CartTm;
import edu.ijse.layerd.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOimpl implements ItemDAO {
    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO item VALUES (?,?,?,?,?,?)",entity.getId(),entity.getName(),entity.getCategory(),entity.getBrand(),entity.getUnitPrice(),entity.getQty());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM item WHERE id = ?",id);
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE item SET name = ?,category = ?,brand = ?,unit_price = ?,qty = ? WHERE id = ?",entity.getName(),entity.getCategory(),entity.getBrand(),entity.getUnitPrice(),entity.getQty(),entity.getId());
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM item");
        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()){
            Item item = new Item();
            item.setId(rst.getString(1));
            item.setName(rst.getString(2));
            item.setCategory(rst.getString(3));
            item.setBrand(rst.getString(4));
            item.setUnitPrice(rst.getDouble(5));
            item.setQty(rst.getInt(6));
            itemList.add(item);
        }
        return itemList;
    }


    @Override
    public boolean updateQty(List<CartTm> tmList) throws SQLException {

        for (CartTm cartTm : tmList) {
            if(!updateItem(cartTm)) {
                return false;
            }
        }
        return true;
    }

    public boolean updateItem(CartTm cartTm) throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE item SET qty = qty-? WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, cartTm.getQty());
        pstm.setString(2, cartTm.getCode());

        return pstm.executeUpdate() > 0;
    }

}
