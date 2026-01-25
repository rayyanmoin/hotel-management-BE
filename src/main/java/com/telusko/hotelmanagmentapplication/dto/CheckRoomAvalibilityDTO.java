package com.telusko.hotelmanagmentapplication.dto;


import lombok.Data;

@Data
public class CheckRoomAvalibilityDTO {

    private Long id;
    private Long bookingId;
    private String name;
    private String hotelName;
    private Integer rating;
    private String comment;

}
