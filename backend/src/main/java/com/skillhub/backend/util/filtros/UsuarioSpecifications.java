package com.skillhub.backend.util.filtros;

import com.skillhub.backend.domain.Usuario;
import org.springframework.data.jpa.domain.Specification;

import static com.skillhub.backend.util.filtros.JpaSpecificationUtils.*;

public final class UsuarioSpecifications {

    private UsuarioSpecifications() {}

    public static Specification<Usuario> porFiltros(FilterValores f) {
        return Specification.<Usuario>allOf(
                like("nombreUsuario", f.getNombreUsuario())
            ).and(like("email", f.getEmail()))
            .and(like("nombreCompleto", f.getNombre()))
            .and(eq("habilitado", f.getHabilitado()))
            .and(betweenDate("actualizadoEn", f.getModificadoDesde(), f.getModificadoHasta()));
    }
}
