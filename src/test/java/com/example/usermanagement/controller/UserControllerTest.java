package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserCreateDTO;
import com.example.usermanagement.dto.UserResponseDTO;
import com.example.usermanagement.enums.Country;
import com.example.usermanagement.enums.Gender;
import com.example.usermanagement.enums.Role;
import com.example.usermanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    void createUser_shouldReturn201_whenDataIsValid() throws Exception {
        UserCreateDTO dto = new UserCreateDTO(
                "1234567890", "John", "Doe", "john@test.com", "3001234567",
                "Passw0rd!", LocalDateTime.of(1995, 1, 1, 0, 0),
                Country.ITALY, Gender.MALE, Role.USER
        );

        UserResponseDTO response = new UserResponseDTO(1L, dto.identification(), dto.name(),
                dto.lastName(), dto.email(), dto.phone(), dto.birthdate(), dto.country(),
                dto.gender(), dto.role(), LocalDateTime.now(), LocalDateTime.now());

        when(userService.save(any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("john@test.com"));
    }

    @Test
    void getUser_shouldFetchById() throws Exception {
        UserResponseDTO response = new UserResponseDTO(1L, "1234567890", "John", "Doe",
                "john@test.com", "3001234567", null, Country.ITALY, Gender.MALE, Role.USER, null, null);

        when(userService.getById(1L)).thenReturn(response);

        mockMvc.perform(get("/api/v1/users/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
}