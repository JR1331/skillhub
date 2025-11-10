package com.skillhub.backend.util.filtros;

import com.skillhub.backend.domain.Curso;
import org.springframework.data.jpa.domain.Specification;

import static com.skillhub.backend.util.filtros.JpaSpecificationUtils.*;

public final class CursoSpecifications {

    private CursoSpecifications() {}

    public static Specification<Curso> porFiltros(FilterValores f) {
        Specification<Curso> spec = (root, query, cb) -> cb.conjunction();

        spec = spec.and(JpaSpecificationUtils.<Curso>like("titulo", f.getTituloCurso()))
            .and(JpaSpecificationUtils.<Curso, Boolean>eq("publicado", f.getPublicado()))
            .and(JpaSpecificationUtils.<Curso>betweenDate("updatedAt", f.getModificadoDesde(), f.getModificadoHasta()));

        if (f.getCategoriasIds() != null && !f.getCategoriasIds().isEmpty()) {
            spec = spec.and((root, query, cb) -> {
                query.distinct(true);
                return root.join("categorias").get("id").in(f.getCategoriasIds());
            });
        }

        if (f.getTagsIds() != null && !f.getTagsIds().isEmpty()) {
            spec = spec.and((root, query, cb) -> {
                query.distinct(true);
                return root.join("tags").get("id").in(f.getTagsIds());
            });
        }

        return spec;
    }

}
