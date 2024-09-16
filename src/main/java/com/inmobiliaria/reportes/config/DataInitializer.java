package com.inmobiliaria.reportes.config;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.inmobiliaria.reportes.model.Role;
import com.inmobiliaria.reportes.model.Usuario;
import com.inmobiliaria.reportes.repository.RoleRepository;
import com.inmobiliaria.reportes.repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
            System.out.println("ROLE_ADMIN created");
        }

        if (roleRepository.findByName("ROLE_USER") == null) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
            System.out.println("ROLE_USER created");
        }
        
   
        Optional<Usuario> existingAdmin = usuarioRepository.findByUsername("admin");

  
        if (existingAdmin.isPresent()) {
            System.out.println("Admin found: " + existingAdmin.get().getUsername());
        } else {
            System.out.println("Admin not found.");
            System.out.println("Creating admin user...");

            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));

            Set<Role> roles = new HashSet<>();
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            roles.add(adminRole);
            admin.setRoles(roles);

            usuarioRepository.save(admin);
            System.out.println("Admin user created successfully.");
        }

       
    }
}
