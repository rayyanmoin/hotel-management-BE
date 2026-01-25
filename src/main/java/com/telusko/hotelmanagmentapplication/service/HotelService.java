package com.telusko.hotelmanagmentapplication.service;

import com.telusko.hotelmanagmentapplication.domains.Hotels;
import com.telusko.hotelmanagmentapplication.dto.HotelDTO;
import com.telusko.hotelmanagmentapplication.mapper.HotelMapper;
import com.telusko.hotelmanagmentapplication.repository.HotelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelsRepository hotelRepository;

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(HotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HotelDTO getHotel(Long id) {
        return hotelRepository.findById(id)
                .map(HotelMapper::toDTO)
                .orElse(null);
    }

    public HotelDTO createHotel(HotelDTO dto) {
        Hotels saved = hotelRepository.save(HotelMapper.toEntity(dto));
        return HotelMapper.toDTO(saved);
    }

    public HotelDTO updateHotel(Long id, HotelDTO dto) {
        return hotelRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setDescription(dto.getDescription());
                    existing.setCity(dto.getCity());
                    existing.setAddress(dto.getAddress());
                    existing.setRating(dto.getRating());
                    return HotelMapper.toDTO(hotelRepository.save(existing));
                })
                .orElse(null);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
