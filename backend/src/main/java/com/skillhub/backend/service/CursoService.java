package com.skillhub.backend.service;

import com.skillhub.backend.dto.CursoDTO;
import com.skillhub.backend.domain.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CursoService {
    Page<CursoDTO> findAll(Pageable pageable);

    Page<CursoDTO> filtrar(Specification<Curso> spec, Pageable pageable);

    CursoDTO crear(CursoDTO dto);
}
