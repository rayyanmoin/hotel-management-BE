package com.telusko.hotelmanagmentapplication.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="booking_id")
    private long bookingId;

    @OneToOne
    @JoinColumn(name = "booking_id",insertable = false,updatable = false)
    private Booking booking;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Method method;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime paymentDate = LocalDateTime.now();

    public enum Method {
        CASH,
        CARD,
        ONLINE
    }

    public enum Status {
        PENDING,
        PAID,
        FAILED,
        COMPLETED
    }
}
