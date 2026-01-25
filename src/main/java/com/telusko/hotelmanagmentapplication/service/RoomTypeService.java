package com.telusko.hotelmanagmentapplication.service;

import com.telusko.hotelmanagmentapplication.domains.RoomType;
import com.telusko.hotelmanagmentapplication.dto.RoomTypeDTO;
import com.telusko.hotelmanagmentapplication.mapper.RoomTypeMapper;
import com.telusko.hotelmanagmentapplication.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public List<RoomTypeDTO> getAll() {
        return roomTypeRepository.findAll()
                .stream()
                .map(RoomTypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoomTypeDTO get(Long id) {
        return roomTypeRepository.findById(id)
                .map(RoomTypeMapper::toDTO)
                .orElse(null);
    }

    public RoomTypeDTO create(RoomTypeDTO dto) {
        RoomType saved = roomTypeRepository.save(RoomTypeMapper.toEntity(dto));
        return RoomTypeMapper.toDTO(saved);
    }

    public RoomTypeDTO update(Long id, RoomTypeDTO dto) {
        return roomTypeRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setDescription(dto.getDescription());
                    existing.setBasePrice(dto.getBasePrice());
                    existing.setAmenities(dto.getAmenities());
                    return RoomTypeMapper.toDTO(roomTypeRepository.save(existing));
                })
                .orElse(null);
    }

    public void delete(Long id) {
        roomTypeRepository.deleteById(id);
    }
}
