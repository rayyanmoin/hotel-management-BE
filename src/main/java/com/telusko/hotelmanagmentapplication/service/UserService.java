package com.telusko.hotelmanagmentapplication.service;

import com.telusko.hotelmanagmentapplication.domains.Users;
import com.telusko.hotelmanagmentapplication.dto.UserDTO;
import com.telusko.hotelmanagmentapplication.mapper.UserMapper;
import com.telusko.hotelmanagmentapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElse(null);
    }

    public UserDTO createUser(UserDTO dto) {
        Users saved = userRepository.save(UserMapper.toEntity(dto));
        return UserMapper.toDTO(saved);
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setEmail(dto.getEmail());
                    existing.setRole(dto.getRole());
                    return UserMapper.toDTO(userRepository.save(existing));
                })
                .orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

