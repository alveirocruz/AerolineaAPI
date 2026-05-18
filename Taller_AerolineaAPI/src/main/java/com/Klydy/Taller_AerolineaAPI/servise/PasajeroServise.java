package com.aerolineaapi.service;

import com.Klydy.Taller_AerolineaAPI.repository.VueloRepository.model.Pasajero;
import com.aerolineaapi.repository.PasajeroRepository;
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
}