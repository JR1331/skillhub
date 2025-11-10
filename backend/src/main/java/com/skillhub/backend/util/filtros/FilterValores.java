package com.skillhub.backend.util.filtros;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilterValores {

    // Comunes
    private String nombre;
    private Boolean habilitado;
    private LocalDateTime modificadoDesde;
    private LocalDateTime modificadoHasta;

    // Usuario
    private String nombreUsuario;
    private String email;

    // Curso
    private String tituloCurso;
    private Boolean publicado;
    private List<Long> categoriasIds;
    private List<Long> tagsIds;

    // Búsquedas “tipo catálogo”
    private String codigo;           // genérico (si te hace falta)
    private List<String> codigos;    // genérico


}
