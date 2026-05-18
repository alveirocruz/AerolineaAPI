package com.Klydy.Taller_AerolineaAPI.repository;

import com.Klydy.Taller_AerolineaAPI.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}