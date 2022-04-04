package com.alkemy.icons.app.service.impl;

import com.alkemy.icons.app.dto.ContinenteDTO;

import java.util.List;

public interface ContinenteService {

    ContinenteDTO save(ContinenteDTO dto);

    List<ContinenteDTO> getAllContinentes();

    ContinenteDTO update(Long id, ContinenteDTO dto);

    void delete(Long id);
}
