package com.Klydy.Taller_AerolineaAPI.repository;

import com.Klydy.Taller_AerolineaAPI.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}