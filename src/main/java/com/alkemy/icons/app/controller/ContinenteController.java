package com.alkemy.icons.app.controller;

import com.alkemy.icons.app.dto.ContinenteDTO;
import com.alkemy.icons.app.service.impl.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> getAll(){
        List<ContinenteDTO> continentes = this.continenteService.getAllContinentes();
        return ResponseEntity.ok().body(continentes);
    }

    @PostMapping
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente){
        ContinenteDTO continenteGuardado = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContinenteDTO> update(@PathVariable Long id,@RequestBody ContinenteDTO dto){
        ContinenteDTO result = continenteService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContinenteDTO> delete(@PathVariable Long id){
        continenteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
