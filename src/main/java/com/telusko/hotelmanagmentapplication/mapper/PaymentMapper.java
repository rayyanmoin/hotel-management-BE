package com.telusko.hotelmanagmentapplication.mapper;

import com.telusko.hotelmanagmentapplication.domains.Payment;
import com.telusko.hotelmanagmentapplication.dto.PaymentDTO;

public class PaymentMapper {

    public static PaymentDTO toDTO(Payment p) {
        if (p == null) return null;

        PaymentDTO dto = new PaymentDTO();
        dto.setId(p.getId());
        dto.setBookingId(p.getBooking() != null ? p.getBooking().getId() : null);
        dto.setAmount(p.getAmount());
        dto.setMethod(p.getMethod());
        dto.setStatus(p.getStatus());
        dto.setPaymentDate(p.getPaymentDate());
        return dto;
    }

    public static Payment toEntity(PaymentDTO dto) {
        if (dto == null) return null;

        Payment p = new Payment();
        p.setId(dto.getId());

        if (dto.getBookingId() != null)
            p.setBookingId(dto.getBookingId());

        p.setAmount(dto.getAmount());
        p.setMethod(dto.getMethod());
        p.setStatus(dto.getStatus());
        p.setPaymentDate(dto.getPaymentDate());
        return p;
    }
}

