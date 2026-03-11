package com.vagas.vagas.mapper;


import com.vagas.vagas.domain.UsuarioEntity;
import com.vagas.vagas.dto.request.UsuarioRequestDto;
import com.vagas.vagas.dto.response.UsuarioResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    public UsuarioEntity toEntity(UsuarioRequestDto usuarioRequestDto);

    public UsuarioResponseDto toResponse(UsuarioEntity usuarioEntity);

}
