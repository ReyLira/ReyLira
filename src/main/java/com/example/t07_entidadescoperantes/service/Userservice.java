package com.example.t07_entidadescoperantes.service;

import com.example.t07_entidadescoperantes.domain.dto.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Userservice {
    private List<Usuario> users = new ArrayList<>();

    public Userservice() {
        users.add(new Usuario("user", "password","USER"));
        users.add(new Usuario("admin", "admin", "ADMIN"));
    }

    public List<Usuario> getAllUsers() {
        return users;
    }

}
