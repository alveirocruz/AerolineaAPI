package com.Klydy.Taller_AerolineaAPI.service;

import com.Klydy.Taller_AerolineaAPI.model.Vuelo;
import com.Klydy.Taller_AerolineaAPI.repository.VueloRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    public Vuelo save(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    public Vuelo findById(Long id) {
        return null;
    }

    public Vuelo update(Long id, @Valid Vuelo datos) {
        return datos;
    }

    public void delete(Long id) {
    }
}