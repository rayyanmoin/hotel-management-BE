package com.telusko.hotelmanagmentapplication.dto;
import com.telusko.hotelmanagmentapplication.domains.Payment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDTO {
    private Long id;

    private Long bookingId;

    private Double amount;
    private Payment.Method method;
    private Payment.Status status;

    private LocalDateTime paymentDate;
}

