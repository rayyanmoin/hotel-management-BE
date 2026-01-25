package com.telusko.hotelmanagmentapplication.repository;

import com.telusko.hotelmanagmentapplication.domains.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HotelsRepository extends JpaRepository<Hotels, Long> {

    List<Hotels> findByCity(String city);

    List<Hotels> findByRatingGreaterThan(double rating);
}

