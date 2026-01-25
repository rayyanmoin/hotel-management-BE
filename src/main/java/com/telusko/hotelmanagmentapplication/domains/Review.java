package com.telusko.hotelmanagmentapplication.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id")
    private long bookingId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "hotel_id")
    private long hotelId;

    @ManyToOne
    @JoinColumn(name = "booking_id",insertable = false,updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "hotel_id",insertable = false,updatable = false)
    private Hotels hotel;

    private Integer rating;

    private String comment;
}

