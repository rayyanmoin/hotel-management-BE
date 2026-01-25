package com.telusko.hotelmanagmentapplication.repository;

import com.telusko.hotelmanagmentapplication.domains.Hotels;
import com.telusko.hotelmanagmentapplication.domains.Room;
import com.telusko.hotelmanagmentapplication.domains.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByHotel(Hotels hotel);

    List<Room> findByRoomType(RoomType roomType);

    List<Room> findByStatus(Room.Status status);
}
