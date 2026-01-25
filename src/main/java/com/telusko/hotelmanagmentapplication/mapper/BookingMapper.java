package com.telusko.hotelmanagmentapplication.mapper;

import com.telusko.hotelmanagmentapplication.domains.Booking;
import com.telusko.hotelmanagmentapplication.domains.Room;
import com.telusko.hotelmanagmentapplication.domains.Users;
import com.telusko.hotelmanagmentapplication.dto.BookingDTO;
import org.apache.catalina.User;

public class BookingMapper {

    public static BookingDTO toDTO(Booking b) {
        if (b == null) return null;

        BookingDTO dto = new BookingDTO();
        dto.setId(b.getId());
        dto.setUserId(b.getUser() != null ? b.getUser().getId() : null);
        dto.setRoomId(b.getRoom() != null ? b.getRoom().getId() : null);
        dto.setCheckIn(b.getCheckIn());
        dto.setCheckOut(b.getCheckOut());
        dto.setTotalPrice(b.getTotalPrice());
        dto.setStatus(b.getStatus());
        return dto;
    }

    public static Booking toEntity(BookingDTO dto) {
        if (dto == null) return null;

        Booking b = new Booking();
        b.setId(dto.getId());

        if (dto.getUserId() != null)
            b.setUserId(dto.getUserId());

        if (dto.getRoomId() != null)
            b.setRoomId(dto.getRoomId());

        b.setCheckIn(dto.getCheckIn());
        b.setCheckOut(dto.getCheckOut());
        b.setTotalPrice(dto.getTotalPrice());
        b.setStatus(dto.getStatus());
        return b;
    }
}

