package com.telusko.hotelmanagmentapplication.mapper;


import com.telusko.hotelmanagmentapplication.domains.Users;
import com.telusko.hotelmanagmentapplication.dto.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(Users user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setPassword(user.getPassword());
        return dto;
    }

    public static Users toEntity(UserDTO dto) {
        if (dto == null) return null;

        Users user = new Users();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword());
        return user;
    }
}

