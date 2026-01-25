package com.telusko.hotelmanagmentapplication.dto;
import com.telusko.hotelmanagmentapplication.domains.Booking;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {
    private Long id;

    private Long userId;
    private Long roomId;

    private LocalDate checkIn;
    private LocalDate checkOut;

    private Double totalPrice;
    private Booking.Status status;
}

