package com.example.usermanagement.dto;

import com.example.usermanagement.enums.Country;
import com.example.usermanagement.enums.Gender;
import com.example.usermanagement.enums.Role;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String identification,
        String name,
        String lastName,
        String email,
        String phone,
        LocalDateTime birthdate,
        Country country,
        Gender gender,
        Role role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
