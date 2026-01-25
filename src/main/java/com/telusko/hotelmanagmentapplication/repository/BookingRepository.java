package com.telusko.hotelmanagmentapplication.repository;

import com.telusko.hotelmanagmentapplication.domains.Booking;
import com.telusko.hotelmanagmentapplication.domains.Room;
import com.telusko.hotelmanagmentapplication.domains.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(Users user);

    List<Booking> findByRoom(Room room);

    List<Booking> findByStatus(Booking.Status status);
}
