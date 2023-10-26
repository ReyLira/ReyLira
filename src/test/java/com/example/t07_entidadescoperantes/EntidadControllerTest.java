package com.example.t07_entidadescoperantes;

import com.example.t07_entidadescoperantes.T07EntidadesCoperantesApplication;
import com.example.t07_entidadescoperantes.domain.dto.EntidadRequestDTO;
import com.example.t07_entidadescoperantes.domain.dto.EntidadResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = T07EntidadesCoperantesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EntidadControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindAll() {
        ResponseEntity<EntidadResponseDTO[]> response = restTemplate.exchange(
                "http://localhost:8080/admin",
                HttpMethod.GET,
                null,
                EntidadResponseDTO[].class
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testFindById() {
        int entityId = 1;

        ResponseEntity<EntidadResponseDTO> response = restTemplate.exchange(
                "http://localhost:8080/admin/" + entityId,
                HttpMethod.GET,
                null,
                EntidadResponseDTO.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testUpdate() {
        int entityId = 4;
        EntidadRequestDTO requestDto = new EntidadRequestDTO();
        requestDto.setNombre("PNP");
        requestDto.setContacto(975947746);
        requestDto.setRuc(new BigInteger("1234567890"));
        requestDto.setDireccion("Urb. Los Rosales");
        requestDto.setEstado("A");

        ResponseEntity<EntidadResponseDTO> response = restTemplate.exchange(
                "http://localhost:8080/admin/" + entityId,
                HttpMethod.PUT,
                new HttpEntity<>(requestDto, new HttpHeaders()),
                EntidadResponseDTO.class
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testCreate() {
        EntidadRequestDTO requestDto = new EntidadRequestDTO();
        requestDto.setNombre("PNP");
        requestDto.setContacto(975947746);
        requestDto.setRuc(new BigInteger("1234567890"));
        requestDto.setDireccion("Urb. Miraflores");
        requestDto.setEstado("A");

        ResponseEntity<EntidadResponseDTO> response = restTemplate.exchange(
                "http://localhost:8080/admin",
                HttpMethod.POST,
                new HttpEntity<>(requestDto, new HttpHeaders()),
                EntidadResponseDTO.class
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testDelete() {
        int entityId = 1;

        ResponseEntity<Void> response = restTemplate.exchange(
                "http://localhost:8080/admin/" + entityId,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}
