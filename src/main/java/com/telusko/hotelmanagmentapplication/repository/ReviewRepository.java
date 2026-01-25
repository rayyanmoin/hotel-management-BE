package com.telusko.hotelmanagmentapplication.repository;

import com.telusko.hotelmanagmentapplication.domains.Hotels;
import com.telusko.hotelmanagmentapplication.domains.Review;
import com.telusko.hotelmanagmentapplication.domains.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByHotel(Hotels hotel);

    List<Review> findByUser(Users user);
}
