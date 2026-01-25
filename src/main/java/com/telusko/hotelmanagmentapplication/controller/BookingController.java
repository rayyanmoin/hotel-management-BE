package com.telusko.hotelmanagmentapplication.controller;

import com.telusko.hotelmanagmentapplication.dto.BookingDTO;
import com.telusko.hotelmanagmentapplication.dto.BookingNameDTO;
import com.telusko.hotelmanagmentapplication.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public List<BookingDTO> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/list")
    public List<BookingNameDTO> getAllWithNames() {
        return bookingService.getAllWithNames();
    }

    @GetMapping("/{id}")
    public BookingDTO get(@PathVariable Long id) {
        return bookingService.get(id);
    }

    @PostMapping
    public BookingDTO create(@RequestBody BookingDTO dto) {
        return bookingService.create(dto);
    }

    @PutMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        bookingService.cancel(id);
    }
}
