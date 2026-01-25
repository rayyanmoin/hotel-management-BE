package com.telusko.hotelmanagmentapplication.mapper;

import com.telusko.hotelmanagmentapplication.domains.RoomType;
import com.telusko.hotelmanagmentapplication.dto.RoomTypeDTO;

public class RoomTypeMapper {

    public static RoomTypeDTO toDTO(RoomType rt) {
        if (rt == null) return null;

        RoomTypeDTO dto = new RoomTypeDTO();
        dto.setId(rt.getId());
        dto.setName(rt.getName());
        dto.setDescription(rt.getDescription());
        dto.setBasePrice(rt.getBasePrice());
        dto.setAmenities(rt.getAmenities());
        return dto;
    }

    public static RoomType toEntity(RoomTypeDTO dto) {
        if (dto == null) return null;

        RoomType rt = new RoomType();
        rt.setId(dto.getId());
        rt.setName(dto.getName());
        rt.setDescription(dto.getDescription());
        rt.setBasePrice(dto.getBasePrice());
        rt.setAmenities(dto.getAmenities());
        return rt;
    }
}

