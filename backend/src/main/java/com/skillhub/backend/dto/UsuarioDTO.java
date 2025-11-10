package com.skillhub.backend.dto;

import com.skillhub.backend.domain.Usuario;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private String email;
    private String nombreCompleto;
    private Boolean habilitado;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;

    // Entity -> DTO
    public static UsuarioDTO from(Usuario e) {
        if (e == null) return null;
        UsuarioDTO d = new UsuarioDTO();
        d.setId(e.getId());
        d.setNombreUsuario(e.getNombreUsuario());
        d.setEmail(e.getEmail());
        d.setNombreCompleto(e.getNombreCompleto());
        d.setHabilitado(e.getHabilitado());
        d.setCreadoEn(e.getCreadoEn());
        d.setActualizadoEn(e.getActualizadoEn());
        return d;
    }

    // DTO -> Entity
    public Usuario toEntity() {
        Usuario e = new Usuario();
        e.setId(this.id);
        e.setNombreUsuario(this.nombreUsuario);
        e.setEmail(this.email);
        e.setNombreCompleto(this.nombreCompleto);
        e.setHabilitado(this.habilitado);
        e.setCreadoEn(this.creadoEn);
        e.setActualizadoEn(this.actualizadoEn);
        return e;
    }
}
