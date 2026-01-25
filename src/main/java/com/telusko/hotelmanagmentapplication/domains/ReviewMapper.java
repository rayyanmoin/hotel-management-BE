package com.telusko.hotelmanagmentapplication.domains;

import com.telusko.hotelmanagmentapplication.dto.ReviewDTO;

public class ReviewMapper {

    public static ReviewDTO toDTO(Review r) {
        if (r == null) return null;

        ReviewDTO dto = new ReviewDTO();
        dto.setId(r.getId());
        dto.setBookingId(r.getBooking() != null ? r.getBooking().getId() : null);
        dto.setUserId(r.getUser() != null ? r.getUser().getId() : null);
        dto.setHotelId(r.getHotel() != null ? r.getHotel().getId() : null);
        dto.setRating(r.getRating());
        dto.setComment(r.getComment());
        return dto;
    }

    public static Review toEntity(ReviewDTO dto) {
        if (dto == null) return null;

        Review r = new Review();
        r.setId(dto.getId());

        if (dto.getBookingId() != null)
            r.setBookingId(dto.getBookingId());

        if (dto.getUserId() != null)
            r.setUserId(dto.getUserId());

        if (dto.getHotelId() != null)
            r.setHotelId(dto.getHotelId());

        r.setRating(dto.getRating());
        r.setComment(dto.getComment());
        return r;
    }
}

