package com.telusko.hotelmanagmentapplication.dto;

import lombok.Data;

@Data
public class HotelDTO {
    private Long id;
    private String name;
    private String description;
    private String city;
    private String address;
    private Double rating;
}

