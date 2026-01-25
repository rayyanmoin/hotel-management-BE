package com.telusko.hotelmanagmentapplication.dto;

import com.telusko.hotelmanagmentapplication.domains.Room;
import lombok.Data;

@Data
public class RoomListDTO {
        private Long id;
        private String roomNumber;
        private String hotelName;
        private String roomTypeName;
        private Room.Status status;

}
