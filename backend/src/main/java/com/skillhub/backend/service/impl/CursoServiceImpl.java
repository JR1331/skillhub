package com.skillhub.backend.service.impl;

import com.skillhub.backend.dto.CursoDTO;
import com.skillhub.backend.mapper.CursoMapper;
import com.skillhub.backend.repository.CursoRepository;
import com.skillhub.backend.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    @Override
    public Page<CursoDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }
}
