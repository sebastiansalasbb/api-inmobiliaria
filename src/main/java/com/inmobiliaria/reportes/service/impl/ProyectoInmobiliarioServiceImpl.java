package com.inmobiliaria.reportes.service.impl;

import com.inmobiliaria.reportes.model.ProyectoInmobiliario;
import com.inmobiliaria.reportes.repository.ProyectoInmobiliarioRepository;
import com.inmobiliaria.reportes.service.ProyectoInmobiliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoInmobiliarioServiceImpl implements ProyectoInmobiliarioService {

    @Autowired
    private ProyectoInmobiliarioRepository repository;

    @Override
    public List<ProyectoInmobiliario> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProyectoInmobiliario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ProyectoInmobiliario save(ProyectoInmobiliario proyecto) {
        return repository.save(proyecto);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
