package com.ProyectoSamuelDeportes.samuel.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoSamuelDeportes.samuel.app.variables.Jugadores;

public interface JugadoresRepositorio extends JpaRepository<Jugadores, Integer> {

}
