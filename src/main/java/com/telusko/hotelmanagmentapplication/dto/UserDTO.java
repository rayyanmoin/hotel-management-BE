package com.telusko.hotelmanagmentapplication.dto;

import com.telusko.hotelmanagmentapplication.domains.Users;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Users.Role role;
}
