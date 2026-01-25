package com.telusko.hotelmanagmentapplication.service;

import com.telusko.hotelmanagmentapplication.domains.*;
import com.telusko.hotelmanagmentapplication.dto.ReviewDTO;
import com.telusko.hotelmanagmentapplication.dto.ReviewListDTO;
import com.telusko.hotelmanagmentapplication.repository.BookingRepository;
import com.telusko.hotelmanagmentapplication.repository.HotelsRepository;
import com.telusko.hotelmanagmentapplication.repository.ReviewRepository;
import com.telusko.hotelmanagmentapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final HotelsRepository hotelRepository;

    // ✅ Used by GET /api/reviews
    public List<ReviewDTO> getAll() {
        return reviewRepository.findAll()
                .stream()
                .map(ReviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    // ✅ Used by GET /api/reviews/listDTO
    public List<ReviewListDTO> getAllReviewsList() {
        return reviewRepository.findAll()
                .stream()
                .map(review -> {
                    ReviewListDTO dto = new ReviewListDTO();
                    dto.setId(review.getId());
                    dto.setBookingId(review.getBooking().getId());
                    dto.setName(review.getUser().getName());
                    dto.setHotelName(review.getHotel().getName());
                    dto.setRating(review.getRating());
                    dto.setComment(review.getComment());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public ReviewDTO get(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewMapper::toDTO)
                .orElse(null);
    }

    public ReviewDTO create(ReviewDTO dto) {

        Booking booking = bookingRepository.findById(dto.getBookingId()).orElseThrow();
        Users user = userRepository.findById(dto.getUserId()).orElseThrow();
        Hotels hotel = hotelRepository.findById(dto.getHotelId()).orElseThrow();

        Review review = ReviewMapper.toEntity(dto);
        review.setBooking(booking);
        review.setUser(user);
        review.setHotel(hotel);

        return ReviewMapper.toDTO(reviewRepository.save(review));
    }
}
