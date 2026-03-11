package com.vagas.vagas.service;

import com.vagas.vagas.domain.UsuarioEntity;
import com.vagas.vagas.dto.request.UsuarioRequestDto;
import com.vagas.vagas.dto.response.UsuarioResponseDto;
import com.vagas.vagas.exception.EmailJaExisteException;
import com.vagas.vagas.mapper.UsuarioMapper;
import com.vagas.vagas.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            UsuarioMapper usuarioMapper,
            PasswordEncoder passwordEncoder
    ){
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDto criarUsuario(UsuarioRequestDto usuarioRequestDto) {
        this.usuarioRepository.findByEmail(usuarioRequestDto.email())
                .ifPresent(user -> {
                    throw new EmailJaExisteException("Email já cadastrado");
                });
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioRequestDto);
        String senha = passwordEncoder.encode(usuarioRequestDto.password());
        usuarioEntity.setPassword(senha);
        usuarioEntity = usuarioRepository.save(usuarioEntity);

        return usuarioMapper.toResponse(usuarioEntity);
    }
}