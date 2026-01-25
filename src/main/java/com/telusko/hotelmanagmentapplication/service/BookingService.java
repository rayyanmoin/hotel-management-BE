package com.telusko.hotelmanagmentapplication.service;

import com.telusko.hotelmanagmentapplication.domains.Booking;
import com.telusko.hotelmanagmentapplication.domains.Room;
import com.telusko.hotelmanagmentapplication.domains.Users;
import com.telusko.hotelmanagmentapplication.dto.BookingDTO;
import com.telusko.hotelmanagmentapplication.dto.BookingNameDTO;
import com.telusko.hotelmanagmentapplication.mapper.BookingMapper;
import com.telusko.hotelmanagmentapplication.repository.BookingRepository;
import com.telusko.hotelmanagmentapplication.repository.RoomRepository;
import com.telusko.hotelmanagmentapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public List<BookingDTO> getAll() {
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::toDTO)
                .collect(Collectors.toList());
    }


    public List<BookingNameDTO> getAllWithNames() {
        return bookingRepository.findAll()
                .stream()
                .map(booking -> {
                    BookingNameDTO dto = new BookingNameDTO();
                    dto.setId(booking.getId());
                    dto.setUserName(booking.getUser().getName());
                    dto.setRoomName(booking.getRoom().getRoomType().getName());
                    dto.setCheckIn(booking.getCheckIn());
                    dto.setCheckOut(booking.getCheckOut());
                    dto.setTotalPrice(booking.getTotalPrice());
                    dto.setStatus(booking.getStatus());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public BookingDTO get(Long id) {
        return bookingRepository.findById(id)
                .map(BookingMapper::toDTO)
                .orElse(null);
    }

    public BookingDTO create(BookingDTO dto) {

        Users user = userRepository.findById(dto.getUserId()).orElseThrow();
        Room room = roomRepository.findById(dto.getRoomId()).orElseThrow();

        long days = dto.getCheckOut().toEpochDay() - dto.getCheckIn().toEpochDay();
        double price = days * room.getRoomType().getBasePrice();

        Booking booking = BookingMapper.toEntity(dto);
        booking.setUser(user);
        booking.setRoom(room);
        booking.setTotalPrice(price);

        room.setStatus(Room.Status.BOOKED);

        return BookingMapper.toDTO(bookingRepository.save(booking));
    }

    public void cancel(Long id) {
        bookingRepository.findById(id).ifPresent(b -> {
            b.setStatus(Booking.Status.CANCELLED);
            b.getRoom().setStatus(Room.Status.AVAILABLE);
            bookingRepository.save(b);
        });
    }
}
