package com.example.t07_entidadescoperantes.web;

import com.example.t07_entidadescoperantes.domain.dto.EntidadRequestDTO;
import com.example.t07_entidadescoperantes.domain.dto.EntidadResponseDTO;
import com.example.t07_entidadescoperantes.domain.dto.Usuario;
import com.example.t07_entidadescoperantes.service.EntidadService;
import com.example.t07_entidadescoperantes.service.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/v1/entidad")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class EntidadController {

    private final EntidadService entidadService;
    private final Userservice userservice;

    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<EntidadResponseDTO> findAll() {
        return this.entidadService.findAll();
    }

    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<EntidadResponseDTO> findById(@PathVariable Integer id) {
        return this.entidadService.findById(id);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<EntidadResponseDTO> update(@PathVariable Integer id, @RequestBody EntidadRequestDTO dto) {
        return this.entidadService.update(id, dto);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<EntidadResponseDTO> create(@RequestBody EntidadRequestDTO dto) {
        return this.entidadService.create(dto);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) {
        return this.entidadService.delete(id);
    }
    @GetMapping("/users")
    public List<Usuario> listuser(){
        return userservice.getAllUsers();
    }
}
