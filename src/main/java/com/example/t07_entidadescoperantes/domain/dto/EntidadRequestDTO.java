package com.example.t07_entidadescoperantes.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class EntidadRequestDTO implements Serializable {
    private static final long serialVersionUID = 8222253670338491507L;

    private String nombre;
    private Integer contacto;
    private BigInteger ruc;
    private String direccion;
    private String estado;
}
