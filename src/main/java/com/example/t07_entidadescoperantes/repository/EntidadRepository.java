package com.example.t07_entidadescoperantes.repository;

import com.example.t07_entidadescoperantes.domain.model.Entidad;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadRepository extends ReactiveCrudRepository<Entidad, Integer> {
}
