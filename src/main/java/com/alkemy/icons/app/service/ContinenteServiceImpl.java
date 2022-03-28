package com.alkemy.icons.app.service;

import com.alkemy.icons.app.dto.ContinenteDTO;
import com.alkemy.icons.app.entity.Continente;
import com.alkemy.icons.app.mapper.ContinenteMapper;
import com.alkemy.icons.app.repository.ContinenteRepository;
import com.alkemy.icons.app.service.impl.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;

    @Autowired
    private ContinenteRepository continenteRepository;

    public ContinenteDTO save(ContinenteDTO dto){
        Continente entity = continenteMapper.continenteDTO2Entity(dto);
        Continente entitySaved = continenteRepository.save(entity);
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        return result;

    }

    @Override
    public List<ContinenteDTO> getAllContinentes() {
        List<Continente> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntity2DTOList(entities);
        return result;
    }

}
