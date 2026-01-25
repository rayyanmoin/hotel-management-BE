package com.telusko.hotelmanagmentapplication.dto;

import lombok.Data;

@Data
public class RoomTypeDTO {
    private Long id;
    private String name;
    private String description;
    private Double basePrice;
    private String amenities;
}

