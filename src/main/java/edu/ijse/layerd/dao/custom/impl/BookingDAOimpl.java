package edu.ijse.layerd.dao.custom.impl;

import edu.ijse.layerd.dao.SQLUtil;
import edu.ijse.layerd.dao.custom.BookingDAO;
import edu.ijse.layerd.entity.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDAOimpl implements BookingDAO {
    @Override
    public boolean save(Booking entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO booking VALUES(?,?,?,?,?)",entity.getId(),entity.getC_id(),entity.getNic(),entity.getDate(),entity.getTable_name());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM booking WHERE id = ?",id);
    }

    @Override
    public boolean update(Booking entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE booking SET c_id = ?,nic = ?,date = ?,table_name = ? WHERE id = ?",entity.getC_id(),entity.getNic(),entity.getDate(),entity.getTable_name(),entity.getId());
    }

    @Override
    public ArrayList<Booking> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM booking");
        ArrayList<Booking> bookingList = new ArrayList<>();
        while (rst.next()){
            Booking booking = new Booking();
            booking.setId(rst.getString(1));
            booking.setC_id(rst.getString(2));
            booking.setNic(rst.getString(3));
            booking.setDate(rst.getString(4));
            booking.setTable_name(rst.getString(5));
            bookingList.add(booking);
        }
        return bookingList;
    }
}
