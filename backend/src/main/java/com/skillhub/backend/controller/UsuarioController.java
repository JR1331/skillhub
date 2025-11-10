package com.skillhub.backend.controller;

import com.skillhub.backend.domain.Usuario;
import com.skillhub.backend.dto.UsuarioDTO;
import com.skillhub.backend.service.UsuarioService;
import com.skillhub.backend.util.filtros.FilterValores;
import com.skillhub.backend.util.filtros.UsuarioSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public Page<UsuarioDTO> listar(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/buscar")
    public Page<UsuarioDTO> buscar(
        @RequestParam(required = false) String nombreUsuario,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Boolean habilitado,
        @RequestParam(required = false) String modDesde, // ISO-8601
        @RequestParam(required = false) String modHasta, // ISO-8601
        Pageable pageable
    ) {
        var f = new FilterValores();
        f.setNombreUsuario(nombreUsuario);
        f.setEmail(email);
        f.setNombre(nombre);
        f.setHabilitado(habilitado);
        // Si tu FilterValores usa LocalDateTime:
        // f.setModificadoDesde(modDesde != null ? LocalDateTime.parse(modDesde) : null);
        // f.setModificadoHasta(modHasta != null ? LocalDateTime.parse(modHasta) : null);

        Specification<Usuario> spec = UsuarioSpecifications.porFiltros(f);
        return service.filtrar(spec, pageable);
    }

    @PostMapping
    public UsuarioDTO crear(@RequestBody UsuarioDTO dto) {
        return service.crear(dto);
    }
}
