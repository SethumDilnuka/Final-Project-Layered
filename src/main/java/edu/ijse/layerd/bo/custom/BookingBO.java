package edu.ijse.layerd.bo.custom;

import edu.ijse.layerd.bo.SuperBO;
import edu.ijse.layerd.dto.BookingDto;

import java.sql.SQLException;
import java.util.List;

public interface BookingBO extends SuperBO {
    boolean saveBooking(BookingDto dto) throws SQLException, ClassNotFoundException;

    boolean updateBooking(BookingDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteBooking(String id) throws SQLException, ClassNotFoundException;

    List<BookingDto> getAllBookings() throws SQLException, ClassNotFoundException;
}
