package com.skillhub.backend.mapper;

import com.skillhub.backend.domain.Curso;
import com.skillhub.backend.dto.CursoDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mappings({
        @Mapping(source = "duracionHoras", target = "duracionHoras")
    })
    CursoDTO toDto(Curso entity);

    @InheritInverseConfiguration
    Curso toEntity(CursoDTO dto);
}
