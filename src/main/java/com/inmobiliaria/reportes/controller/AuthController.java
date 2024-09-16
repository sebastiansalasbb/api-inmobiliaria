package com.inmobiliaria.reportes.controller;

import com.inmobiliaria.reportes.model.Role;
import com.inmobiliaria.reportes.model.Usuario;
import com.inmobiliaria.reportes.repository.RoleRepository;
import com.inmobiliaria.reportes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/checkRole")
    public String checkUserRole(Authentication authentication) {
        return authentication.getAuthorities().toString();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        Optional<Usuario> existingUser = usuarioRepository.findByUsername(usuario.getUsername());

        if (existingUser.isPresent()) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER");
        if (userRole == null) {
            return new ResponseEntity<>("User role not found!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        usuario.setRoles(Collections.singleton(userRole));

        usuarioRepository.save(usuario);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
