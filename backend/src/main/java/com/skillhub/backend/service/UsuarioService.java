package com.skillhub.backend.service;

import com.skillhub.backend.domain.Usuario;
import com.skillhub.backend.dto.UsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface UsuarioService {
    Page<UsuarioDTO> findAll(Pageable pageable);
    Page<UsuarioDTO> filtrar(Specification<Usuario> spec, Pageable pageable);
    UsuarioDTO crear(UsuarioDTO dto);
}
