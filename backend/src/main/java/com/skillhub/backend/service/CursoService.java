package com.skillhub.backend.service;

import com.skillhub.backend.dto.CursoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CursoService {
    Page<CursoDTO> findAll(Pageable pageable);
}
