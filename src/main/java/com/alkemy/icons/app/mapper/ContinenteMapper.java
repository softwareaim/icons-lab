package com.alkemy.icons.app.mapper;

import com.alkemy.icons.app.dto.ContinenteDTO;
import com.alkemy.icons.app.entity.Continente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {

    public Continente continenteDTO2Entity(ContinenteDTO dto){
        Continente continente = new Continente();
        continente.setImagen(dto.getImagen());
        continente.setDenominacion(dto.getDenominacion());
        return continente;
    }

    public ContinenteDTO continenteEntity2DTO(Continente entity){
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }

    public List<ContinenteDTO> continenteEntity2DTOList(List<Continente> entities) {
        List<ContinenteDTO> dtos = new ArrayList<>();
        for (Continente entity: entities) {
            dtos.add(this.continenteEntity2DTO(entity));
        }
        return dtos;
    }
}
