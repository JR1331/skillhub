package com.skillhub.backend.service.impl;

import com.skillhub.backend.domain.Curso;
import com.skillhub.backend.dto.CursoDTO;
import com.skillhub.backend.repository.CursoRepository;
import com.skillhub.backend.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    @Override
    public Page<CursoDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(CursoDTO::from);
    }

    @Override
    public Page<CursoDTO> filtrar(Specification<Curso> spec, Pageable pageable) {
        Page<Curso> page = repository.findAll(spec, pageable);
        return page.map(CursoDTO::from);
    }

    @Override
    public CursoDTO crear(CursoDTO dto) {
        Curso saved = repository.save(dto.toEntity());
        return CursoDTO.from(saved);
    }
}
