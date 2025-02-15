package edu.ijse.layerd.bo.custom.impl;

import edu.ijse.layerd.bo.custom.BookingBO;
import edu.ijse.layerd.dao.DAOFactory;
import edu.ijse.layerd.dao.custom.BookingDAO;
import edu.ijse.layerd.dto.BookingDto;
import edu.ijse.layerd.entity.Booking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingBOimpl implements BookingBO {
     BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);
    @Override
    public boolean saveBooking(BookingDto dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.save(new Booking(dto.getId(),dto.getC_id(),dto.getNic(),dto.getDate(),dto.getTable_name()));
    }

    @Override
    public boolean updateBooking(BookingDto dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.update(new Booking(dto.getId(),dto.getC_id(),dto.getNic(),dto.getDate(),dto.getTable_name()));
    }

    @Override
    public boolean deleteBooking(String id) throws SQLException, ClassNotFoundException {
        return bookingDAO.delete(id);
    }

    @Override
    public List<BookingDto> getAllBookings() throws SQLException, ClassNotFoundException {
        List<Booking> list = bookingDAO.getAll();
        List<BookingDto> dtos = new ArrayList<>();
        for (Booking booking : list) {
            dtos.add(new BookingDto(booking.getId(),booking.getC_id(),booking.getNic(),booking.getDate(),booking.getTable_name()));
        }
        return dtos;
    }
}
