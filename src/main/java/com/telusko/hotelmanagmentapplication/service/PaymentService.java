package com.telusko.hotelmanagmentapplication.service;

import com.telusko.hotelmanagmentapplication.domains.Booking;
import com.telusko.hotelmanagmentapplication.domains.Payment;
import com.telusko.hotelmanagmentapplication.dto.PaymentDTO;
import com.telusko.hotelmanagmentapplication.mapper.PaymentMapper;
import com.telusko.hotelmanagmentapplication.repository.BookingRepository;
import com.telusko.hotelmanagmentapplication.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public List<PaymentDTO> getAll() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO get(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentMapper::toDTO)
                .orElse(null);
    }

    public PaymentDTO create(PaymentDTO dto) {

        Booking booking = bookingRepository.findById(dto.getBookingId()).orElseThrow();

        Payment payment = PaymentMapper.toEntity(dto);
        payment.setBooking(booking);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus(Payment.Status.COMPLETED);

        return PaymentMapper.toDTO(paymentRepository.save(payment));
    }
}

