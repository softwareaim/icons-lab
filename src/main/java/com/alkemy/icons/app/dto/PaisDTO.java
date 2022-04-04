package com.alkemy.icons.app.dto;

import com.alkemy.icons.app.entity.Icon;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class PaisDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long superficie;
    private Long continenteId;
    private Set<Icon> icons = new HashSet<>();

}
