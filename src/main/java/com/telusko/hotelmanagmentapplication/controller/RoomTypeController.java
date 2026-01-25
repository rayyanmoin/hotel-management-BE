package com.telusko.hotelmanagmentapplication.controller;

import com.telusko.hotelmanagmentapplication.dto.RoomTypeDTO;
import com.telusko.hotelmanagmentapplication.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/room-types")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping
    public List<RoomTypeDTO> getAll() {
        return roomTypeService.getAll();
    }

    @GetMapping("/{id}")
    public RoomTypeDTO get(@PathVariable Long id) {
        return roomTypeService.get(id);
    }

    @PostMapping
    public RoomTypeDTO create(@RequestBody RoomTypeDTO dto) {
        return roomTypeService.create(dto);
    }

    @PutMapping("/{id}")
    public RoomTypeDTO update(@PathVariable Long id, @RequestBody RoomTypeDTO dto) {
        return roomTypeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomTypeService.delete(id);
    }
}