package com.example.t07_entidadescoperantes.service.impl;

import com.example.t07_entidadescoperantes.domain.dto.EntidadRequestDTO;
import com.example.t07_entidadescoperantes.domain.dto.EntidadResponseDTO;
import com.example.t07_entidadescoperantes.domain.mapper.EntidadMapper;
import com.example.t07_entidadescoperantes.exception.ResourceNotFoundException;
import com.example.t07_entidadescoperantes.repository.EntidadRepository;
import com.example.t07_entidadescoperantes.service.EntidadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.t07_entidadescoperantes.domain.mapper.EntidadMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EntidadServiceImpl implements EntidadService {

    private final EntidadRepository entidadRepository;
    @Override
    public Mono<EntidadResponseDTO> findById(Integer id) {
        return this.entidadRepository.findById(id)
                .map(EntidadMapper::toDto);
    }

    @Override
    public Flux<EntidadResponseDTO> findAll() {
        return this.entidadRepository.findAll()
                .map(EntidadMapper::toDto);
    }

    @Override
    public Mono<EntidadResponseDTO> create(EntidadRequestDTO request) {
        return this.entidadRepository.save(toModel(request))
                .map(EntidadMapper::toDto);
    }

    @Override
    public Mono<EntidadResponseDTO> update(Integer id, EntidadRequestDTO request) {
        return this.entidadRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(("El id: " + id + " no fue encontrado"))))
                .flatMap(entidad -> this.entidadRepository.save(toModel(entidad.getId(),request)))
                .map(EntidadMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.entidadRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(("El id: " + id + " no fue encontrado"))))
                .flatMap(entidad -> {
                    entidad.setActive("I");
                    return  entidadRepository.save(entidad);
                })
                .doOnSuccess(unused -> log.info("Se elimino el usuario con id: {}" ,id))
                .then();

    }
}
