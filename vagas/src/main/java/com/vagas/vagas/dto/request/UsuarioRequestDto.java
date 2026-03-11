package com.vagas.vagas.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record UsuarioRequestDto(

        @NotBlank(message = "O campo [name] não pode ser nulo")
        String name,

        @NotBlank(message = "O campo [username] não pode ser nulo")
        String username,

        @NotBlank(message = "O campo [email] não pode ser nulo")
        @Email(message = "Informe um email valido")
        String email,

        @NotBlank(message = "O campo [password] não pode ser nulo")
        String password,

        @NotBlank(message = "O campo [telephone] não pode ser nulo")
        String telephone
)

{}
