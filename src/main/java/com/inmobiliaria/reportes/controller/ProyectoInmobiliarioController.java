package com.inmobiliaria.reportes.controller;

import com.inmobiliaria.reportes.model.ProyectoInmobiliario;
import com.inmobiliaria.reportes.service.ProyectoInmobiliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoInmobiliarioController {

    @Autowired
    private ProyectoInmobiliarioService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<ProyectoInmobiliario> getAllProyectos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<ProyectoInmobiliario> getProyectoById(@PathVariable Long id) {
        Optional<ProyectoInmobiliario> proyecto = service.findById(id);
        return proyecto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProyectoInmobiliario> createProyecto(@RequestBody ProyectoInmobiliario proyecto) {
        ProyectoInmobiliario newProyecto = service.save(proyecto);
        return new ResponseEntity<>(newProyecto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProyectoInmobiliario> updateProyecto(@PathVariable Long id, @RequestBody ProyectoInmobiliario proyectoDetails) {
        Optional<ProyectoInmobiliario> proyecto = service.findById(id);
        if (!proyecto.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ProyectoInmobiliario proyectoToUpdate = proyecto.get();
        proyectoToUpdate.setNombre(proyectoDetails.getNombre());
        proyectoToUpdate.setDescripcion(proyectoDetails.getDescripcion());
        proyectoToUpdate.setDireccion(proyectoDetails.getDireccion());
        proyectoToUpdate.setPrecio(proyectoDetails.getPrecio());
        proyectoToUpdate.setVendedor(proyectoDetails.getVendedor());

        ProyectoInmobiliario updatedProyecto = service.save(proyectoToUpdate);
        return ResponseEntity.ok(updatedProyecto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
