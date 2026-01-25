package com.telusko.hotelmanagmentapplication.controller;

import com.telusko.hotelmanagmentapplication.dto.BookingNameDTO;
import com.telusko.hotelmanagmentapplication.dto.CheckRoomAvalibilityDTO;
import com.telusko.hotelmanagmentapplication.dto.RoomDTO;
import com.telusko.hotelmanagmentapplication.dto.RoomListDTO;
import com.telusko.hotelmanagmentapplication.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<RoomDTO> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/list")
    public List<RoomListDTO> getAllWithNames() {
        return roomService.getAllWithNames();
    }

    @GetMapping("/{id}")
    public RoomDTO get(@PathVariable Long id) {
        return roomService.get(id);
    }



    @PostMapping
    public RoomDTO create(@RequestBody RoomDTO dto) {
        return roomService.create(dto);
    }

    @PutMapping("/{id}")
    public RoomDTO update(@PathVariable Long id, @RequestBody RoomDTO dto) {
        return roomService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}