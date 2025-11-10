package com.skillhub.backend.service.impl;

import com.skillhub.backend.domain.Usuario;
import com.skillhub.backend.dto.UsuarioDTO;
import com.skillhub.backend.repository.UsuarioRepository;
import com.skillhub.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Page<UsuarioDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(UsuarioDTO::from);
    }

    @Override
    public Page<UsuarioDTO> filtrar(Specification<Usuario> spec, Pageable pageable) {
        return repository.findAll(spec, pageable).map(UsuarioDTO::from);
    }

    @Override
    @Transactional
    public UsuarioDTO crear(UsuarioDTO dto) {
        // ejemplos de invariantes simples
        if (dto.getEmail() != null && repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese email");
        }
        if (dto.getNombreUsuario() != null && repository.existsByNombreUsuario(dto.getNombreUsuario())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese nombre de usuario");
        }
        Usuario saved = repository.save(dto.toEntity());
        return UsuarioDTO.from(saved);
    }
}
