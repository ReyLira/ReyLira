package com.example.t07_entidadescoperantes.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
public class EntidadResponseDTO implements Serializable {
    private static final long serialVersionUID = 8735757125749188522L;
    private Integer id;
    private String nombre;
    private Integer contacto;
    private BigInteger ruc;
    private  String direccion;
    private String estado;
}
