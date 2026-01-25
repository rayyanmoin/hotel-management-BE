package com.telusko.hotelmanagmentapplication.controller;

import com.telusko.hotelmanagmentapplication.dto.HotelDTO;
import com.telusko.hotelmanagmentapplication.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public List<HotelDTO> getAll() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public HotelDTO get(@PathVariable Long id) {
        return hotelService.getHotel(id);
    }

    @PostMapping
    public HotelDTO create(@RequestBody HotelDTO dto) {
        return hotelService.createHotel(dto);
    }

    @PutMapping("/{id}")
    public HotelDTO update(@PathVariable Long id, @RequestBody HotelDTO dto) {
        return hotelService.updateHotel(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}
