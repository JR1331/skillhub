package com.skillhub.backend.dto;

import com.skillhub.backend.domain.Curso;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CursoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Boolean publicado;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
    private Integer duracionHoras;

    // Entity -> DTO
    public static CursoDTO from(Curso e) {
        if (e == null) return null;
        CursoDTO d = new CursoDTO();
        d.setId(e.getId());
        d.setTitulo(e.getTitulo());
        d.setDescripcion(e.getDescripcion());
        d.setPublicado(e.getPublicado());
        d.setCreadoEn(e.getCreatedAt());
        d.setActualizadoEn(e.getUpdatedAt());
        d.setDuracionHoras(e.getDuracionHoras());
        return d;
    }

    // DTO -> Entity
    public Curso toEntity() {
        Curso e = new Curso();
        e.setId(this.id);
        e.setTitulo(this.titulo);
        e.setDescripcion(this.descripcion);
        e.setPublicado(this.publicado);
        e.setCreatedAt(this.creadoEn);
        e.setUpdatedAt(this.actualizadoEn);
        e.setDuracionHoras(this.duracionHoras);
        return e;
    }
}
