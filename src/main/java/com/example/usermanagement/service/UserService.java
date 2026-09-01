package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserCreateDTO;
import com.example.usermanagement.dto.UserResponseDTO;
import com.example.usermanagement.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {

    public List<UserResponseDTO> getAll();

    public UserResponseDTO getById(Long id);

    public UserResponseDTO save(UserCreateDTO dto);

    public UserResponseDTO update(Long id, UserUpdateDTO dto);

    public void delete(Long id);
}
