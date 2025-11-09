package com.skillhub.backend.web;

import com.skillhub.backend.dto.CursoDTO;
import com.skillhub.backend.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService service;

    @GetMapping
    public Page<CursoDTO> list(Pageable pageable) {
        return service.findAll(pageable);
    }
}
