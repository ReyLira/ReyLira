package com.example.t07_entidadescoperantes.domain.mapper;

import com.example.t07_entidadescoperantes.domain.dto.EntidadRequestDTO;
import com.example.t07_entidadescoperantes.domain.dto.EntidadResponseDTO;
import com.example.t07_entidadescoperantes.domain.model.Entidad;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntidadMapper {
    public static Entidad toModel(EntidadRequestDTO dto) {
        return new Entidad(
                dto.getNombre(),
                dto.getContacto(),
                dto.getRuc(),
                dto.getDireccion(),
                dto.getEstado()
        );
    }

    public static Entidad toModel(Integer id, EntidadRequestDTO dto) {
        return new Entidad(
                id,
                dto.getNombre(),
                dto.getContacto(),
                dto.getRuc(),
                dto.getDireccion(),
                dto.getEstado()
        );
    }

    public static EntidadResponseDTO toDto(Entidad model) {
        return new EntidadResponseDTO(
                model.getId(),
                model.getName(),
                model.getContact(),
                model.getRuc(),
                model.getDirection_legal(),
                model.getActive()
        );
    }
}
