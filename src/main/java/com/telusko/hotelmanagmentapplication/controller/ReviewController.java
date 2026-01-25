package com.telusko.hotelmanagmentapplication.controller;

import com.telusko.hotelmanagmentapplication.dto.ReviewDTO;
import com.telusko.hotelmanagmentapplication.dto.ReviewListDTO;
import com.telusko.hotelmanagmentapplication.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // Returns full ReviewDTO list
    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAll();
    }

    // Returns custom ReviewListDTO
    @GetMapping("/listDTO")
    public List<ReviewListDTO> getAllReviewsList() {
        return reviewService.getAllReviewsList();
    }

    @GetMapping("/{id}")
    public ReviewDTO get(@PathVariable Long id) {
        return reviewService.get(id);
    }

    @PostMapping
    public ReviewDTO create(@RequestBody ReviewDTO dto) {
        return reviewService.create(dto);
    }
}
