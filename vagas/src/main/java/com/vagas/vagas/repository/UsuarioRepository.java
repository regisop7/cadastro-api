package com.vagas.vagas.repository;

import com.vagas.vagas.domain.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

        Optional<UsuarioEntity> findByEmail(String email);

}
