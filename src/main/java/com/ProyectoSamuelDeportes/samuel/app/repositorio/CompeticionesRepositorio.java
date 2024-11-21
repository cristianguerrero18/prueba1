package com.ProyectoSamuelDeportes.samuel.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ProyectoSamuelDeportes.samuel.app.variables.Competiciones;

public interface CompeticionesRepositorio extends JpaRepository<Competiciones, Integer> {

}