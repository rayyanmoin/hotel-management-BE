package com.telusko.hotelmanagmentapplication.service;

import com.telusko.hotelmanagmentapplication.domains.Hotels;
import com.telusko.hotelmanagmentapplication.domains.Room;
import com.telusko.hotelmanagmentapplication.domains.RoomType;
import com.telusko.hotelmanagmentapplication.dto.BookingNameDTO;
import com.telusko.hotelmanagmentapplication.dto.CheckRoomAvalibilityDTO;
import com.telusko.hotelmanagmentapplication.dto.RoomDTO;
import com.telusko.hotelmanagmentapplication.dto.RoomListDTO;
import com.telusko.hotelmanagmentapplication.mapper.RoomMapper;
import com.telusko.hotelmanagmentapplication.repository.HotelsRepository;
import com.telusko.hotelmanagmentapplication.repository.RoomRepository;
import com.telusko.hotelmanagmentapplication.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final HotelsRepository hotelRepository;
    private final RoomTypeRepository roomTypeRepository;

    public List<RoomDTO> getAll() {
        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RoomListDTO> getAllWithNames() {
        return roomRepository.findAll()
                .stream()
                .map(room -> {
                    RoomListDTO dto = new RoomListDTO();
                    dto.setId(room.getId());
                    dto.setRoomNumber(room.getRoomNumber());
                    dto.setHotelName(room.getHotel().getName());
                    dto.setRoomTypeName(room.getRoomType().getName());
                    dto.setStatus(room.getStatus());
                    return dto;
                })
                .collect(Collectors.toList());
    }



    public RoomDTO get(Long id) {
        return roomRepository.findById(id)
                .map(RoomMapper::toDTO)
                .orElse(null);
    }

    public RoomDTO create(RoomDTO dto) {

        Hotels hotel = hotelRepository.findById(dto.getHotelId()).orElseThrow();
        RoomType rt = roomTypeRepository.findById(dto.getRoomTypeId()).orElseThrow();

        Room room = RoomMapper.toEntity(dto);
        room.setHotel(hotel);
        room.setRoomType(rt);

        return RoomMapper.toDTO(roomRepository.save(room));
    }

    public RoomDTO update(Long id, RoomDTO dto) {
        return roomRepository.findById(id)
                .map(existing -> {

                    Hotels hotel = hotelRepository.findById(dto.getHotelId()).orElseThrow();
                    RoomType roomType = roomTypeRepository.findById(dto.getRoomTypeId()).orElseThrow();

                    existing.setRoomNumber(dto.getRoomNumber());
                    existing.setStatus(dto.getStatus());
                    existing.setHotel(hotel);
                    existing.setRoomType(roomType);

                    return RoomMapper.toDTO(roomRepository.save(existing));
                })
                .orElse(null);
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}

