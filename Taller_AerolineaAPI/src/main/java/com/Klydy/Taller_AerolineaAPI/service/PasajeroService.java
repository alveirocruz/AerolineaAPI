package com.Klydy.Taller_AerolineaAPI.service;

import com.Klydy.Taller_AerolineaAPI.model.Pasajero;
import com.Klydy.Taller_AerolineaAPI.repository.PasajeroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasajero> findAll() {
        return pasajeroRepository.findAll();
    }

    public Pasajero save(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    public Pasajero findById(Long id) {
        return null;
    }

    public Pasajero update(Long id, @Valid Pasajero datos) {
        return datos;
    }

    public void delete(Long id) {
    }
}