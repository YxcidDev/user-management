package com.example.usermanagement.dto;

import com.example.usermanagement.enums.Country;
import com.example.usermanagement.enums.Gender;
import com.example.usermanagement.enums.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record UserCreateDTO(
        @NotBlank(message = "La identificación es obligatoria")
        @Size(min = 7, max = 20, message = "La identificación debe contener entre 7 y 20 caracteres")
        String identification,

        @NotBlank(message = "El nombre es obligatorio")
        @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
        String name,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(min = 3, max = 200, message = "El apellido debe tener entre 3 y 200 caracteres")
        String lastName,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo debe tener un formato válido")
        String email,

        @NotBlank(message = "El télefono es obligatorio")
        @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "El formato del teléfono no es válido. Debe contener entre 7 y 15 dígitos, y puede incluir un signo '+' al inicio")
        String phone,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, message = "La contraseña debe tener como mínimo 8 caracteres")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$", message = "La contraseña debe contener al menos un número, una minúscula, una mayúscula y un carácter especial")
        String password,

        @NotNull
        LocalDateTime birthdate,

        Country country,

        Gender gender,

        @NotNull(message = "El rol no debe ir vacío")
        Role role
) {
}
