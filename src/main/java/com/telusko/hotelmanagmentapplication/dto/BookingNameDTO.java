package com.telusko.hotelmanagmentapplication.dto;

import com.telusko.hotelmanagmentapplication.domains.Booking;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingNameDTO {

    private Long id;
    private String userName;
    private String roomName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Double totalPrice;
    private Booking.Status status;
}
