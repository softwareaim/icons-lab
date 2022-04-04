package com.alkemy.icons.app.mapper;

import com.alkemy.icons.app.dto.IconDTO;
import com.alkemy.icons.app.dto.PaisDTO;
import com.alkemy.icons.app.entity.Icon;
import com.alkemy.icons.app.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PaisMapper {

    @Autowired
    private IconMapper iconMapper;

    private Pais paisDTO2Entity(PaisDTO dto) {
        Pais entity = new Pais();
        entity.setId(dto.getId());
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        entity.setContinenteId(dto.getContinenteId());
        entity.setSuperficie(dto.getSuperficie());
        // icons
        Set<Icon> icons = this.iconMapper.iconDTOList2Entity((List)dto.getIcons());
        entity.setIcons(icons);
        return entity;
    }


    private PaisDTO paisEntity2DTO(Pais entity, boolean loadIcons) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setContinenteId(entity.getContinenteId());
        dto.setSuperficie(entity.getSuperficie());
        if(loadIcons){
            List<IconDTO> iconDTOS = this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            dto.getIcons().add((Icon) iconDTOS);
        }
        return dto;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<Pais> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (Pais entity : entities) {
            dtos.add(this.paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }

    public List<Pais> paisDTOList2Entity(List<PaisDTO> dtos) {
        List<Pais> entities = new ArrayList<>();
        for (PaisDTO dto : dtos) {
            entities.add(this.paisDTO2Entity(dto));
        }
        return entities;
    }


}
