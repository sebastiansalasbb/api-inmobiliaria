package com.inmobiliaria.reportes.service;

import com.inmobiliaria.reportes.model.ProyectoInmobiliario;
import java.util.List;
import java.util.Optional;

public interface ProyectoInmobiliarioService {
    List<ProyectoInmobiliario> findAll();
    Optional<ProyectoInmobiliario> findById(Long id);
    ProyectoInmobiliario save(ProyectoInmobiliario proyecto);
    void deleteById(Long id);
}
