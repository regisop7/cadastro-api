package com.vagas.vagas.dto.response;

import java.util.UUID;

public record UsuarioResponseDto(
        UUID id,
        String name,
        String username,
        String email,
        String telephone)

{}
