package com.telusko.hotelmanagmentapplication.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name="room_type_id")
    private long roomTypeId;

    @ManyToOne
    @JoinColumn(name = "hotel_id", insertable = false, updatable = false)
    private Hotels hotel;

    @ManyToOne
    @JoinColumn(name = "room_type_id", insertable = false, updatable = false)
    private RoomType roomType;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AVAILABLE,
        OCCUPIED,
        MAINTENANCE,
        BOOKED

    }
}
