package com.example.t07_entidadescoperantes.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Table(name = "entity")
@Getter
@Setter
@NoArgsConstructor
public class Entidad {
    @Id
    private Integer id;
    private String name;
    private Integer contact;
    private BigInteger ruc;
    private String direction_legal;
    private String active;

    public Entidad(String name, Integer contact, BigInteger ruc, String direction_legal, String active) {
        this.name = name;
        this.contact = contact;
        this.ruc = ruc;
        this.direction_legal = direction_legal;
        this.active = active;
    }

    public Entidad(Integer id, String name, Integer contact, BigInteger ruc, String direction_legal, String active) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.ruc = ruc;
        this.direction_legal = direction_legal;
        this.active = active;
    }
}
