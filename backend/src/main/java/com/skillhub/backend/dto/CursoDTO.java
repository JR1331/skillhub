package com.skillhub.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Integer duracionHoras;
    private Boolean publicado;
}
