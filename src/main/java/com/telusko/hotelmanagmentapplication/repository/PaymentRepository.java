package com.telusko.hotelmanagmentapplication.repository;

import com.telusko.hotelmanagmentapplication.domains.Booking;
import com.telusko.hotelmanagmentapplication.domains.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByBooking(Booking booking);
}
