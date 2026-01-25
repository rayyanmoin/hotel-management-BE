package com.telusko.hotelmanagmentapplication.mapper;

import com.telusko.hotelmanagmentapplication.domains.Hotels;
import com.telusko.hotelmanagmentapplication.domains.Room;
import com.telusko.hotelmanagmentapplication.domains.RoomType;
import com.telusko.hotelmanagmentapplication.dto.RoomDTO;

public class RoomMapper {

    public static RoomDTO toDTO(Room r) {
        if (r == null) return null;

        RoomDTO dto = new RoomDTO();
        dto.setId(r.getId());
        dto.setRoomNumber(r.getRoomNumber());

        dto.setHotelId(r.getHotel() != null ? r.getHotel().getId() : null);
        dto.setRoomTypeId(r.getRoomType() != null ? r.getRoomType().getId() : null);

        dto.setStatus(r.getStatus());
        return dto;
    }

    public static Room toEntity(RoomDTO dto) {
        if (dto == null) return null;

        Room r = new Room();
        r.setId(dto.getId());
        r.setRoomNumber(dto.getRoomNumber());

        if (dto.getHotelId() != null)
            r.setHotelId(dto.getHotelId());

        if (dto.getRoomTypeId() != null)
            r.setRoomTypeId(dto.getRoomTypeId());

        r.setStatus(dto.getStatus());
        return r;
    }
}

