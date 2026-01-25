package com.telusko.hotelmanagmentapplication.dto;
import com.telusko.hotelmanagmentapplication.domains.Room;
import lombok.Data;

@Data
public class RoomDTO {
    private Long id;
    private String roomNumber;

    private Long hotelId;
    private Long roomTypeId;

    private Room.Status status;
}

