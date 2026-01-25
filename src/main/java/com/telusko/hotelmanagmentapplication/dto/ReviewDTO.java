package com.telusko.hotelmanagmentapplication.dto;
import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;

    private Long bookingId;
    private Long userId;
    private Long hotelId;

    private Integer rating;
    private String comment;
}

