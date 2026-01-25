package com.telusko.hotelmanagmentapplication.mapper;

import com.telusko.hotelmanagmentapplication.domains.Hotels;
import com.telusko.hotelmanagmentapplication.dto.HotelDTO;

public class HotelMapper {

    public static HotelDTO toDTO(Hotels h) {
        if (h == null) return null;

        HotelDTO dto = new HotelDTO();
        dto.setId(h.getId());
        dto.setName(h.getName());
        dto.setDescription(h.getDescription());
        dto.setCity(h.getCity());
        dto.setAddress(h.getAddress());
        dto.setRating(h.getRating());
        return dto;
    }

    public static Hotels toEntity(HotelDTO dto) {
        if (dto == null) return null;

        Hotels h = new Hotels();
        h.setId(dto.getId());
        h.setName(dto.getName());
        h.setDescription(dto.getDescription());
        h.setCity(dto.getCity());
        h.setAddress(dto.getAddress());
        h.setRating(dto.getRating());
        return h;
    }
}

