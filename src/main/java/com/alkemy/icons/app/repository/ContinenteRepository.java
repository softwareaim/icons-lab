package com.alkemy.icons.app.repository;

import com.alkemy.icons.app.entity.Continente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinenteRepository extends JpaRepository<Continente, Long> {
}
