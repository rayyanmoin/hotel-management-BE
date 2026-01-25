package com.telusko.hotelmanagmentapplication.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private long userId;

    @Column(name="room_id")
    private long roomId;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "room_id",insertable = false,updatable = false)
    private Room room;

    private LocalDate checkIn;
    private LocalDate checkOut;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING,
        CONFIRMED,
        CANCELLED
    }
}
