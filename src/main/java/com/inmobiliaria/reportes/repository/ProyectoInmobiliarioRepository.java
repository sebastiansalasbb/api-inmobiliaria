package com.inmobiliaria.reportes.repository;

import com.inmobiliaria.reportes.model.ProyectoInmobiliario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoInmobiliarioRepository extends JpaRepository<ProyectoInmobiliario, Long> {
    
}
