package com.Klydy.Taller_AerolineaAPI.service;

import com.Klydy.Taller_AerolineaAPI.dto.ReservaRequestDTO;
import com.Klydy.Taller_AerolineaAPI.dto.ReservaResponseDTO;
import com.Klydy.Taller_AerolineaAPI.model.Pasajero;
import com.Klydy.Taller_AerolineaAPI.model.Reserva;
import com.Klydy.Taller_AerolineaAPI.model.Vuelo;
import com.Klydy.Taller_AerolineaAPI.repository.PasajeroRepository;
import com.Klydy.Taller_AerolineaAPI.repository.ReservaRepository;
import com.Klydy.Taller_AerolineaAPI.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(
            ReservaRepository reservaRepository,
            PasajeroRepository pasajeroRepository,
            VueloRepository vueloRepository) {

        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }

    public List<ReservaResponseDTO> findAll() {

        return reservaRepository.findAll()
                .stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());
    }

    public ReservaResponseDTO findById(Long id) {

        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva == null) {
            return null;
        }

        return ReservaResponseDTO.desde(reserva);
    }

    public ReservaResponseDTO save(ReservaRequestDTO dto) {

        Pasajero pasajero = pasajeroRepository
                .findById(dto.getPasajeroId())
                .orElse(null);

        Vuelo vuelo = vueloRepository
                .findById(dto.getVueloId())
                .orElse(null);

        Reserva reserva = new Reserva();

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setClase(dto.getClase());
        reserva.setPasajero(pasajero);
        reserva.setVuelo(vuelo);

        Reserva reservaGuardada = reservaRepository.save(reserva);

        return ReservaResponseDTO.desde(reservaGuardada);
    }

    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto) {

        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva == null) {
            return null;
        }

        Pasajero pasajero = pasajeroRepository
                .findById(dto.getPasajeroId())
                .orElse(null);

        Vuelo vuelo = vueloRepository
                .findById(dto.getVueloId())
                .orElse(null);

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setClase(dto.getClase());
        reserva.setPasajero(pasajero);
        reserva.setVuelo(vuelo);

        Reserva reservaActualizada = reservaRepository.save(reserva);

        return ReservaResponseDTO.desde(reservaActualizada);
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}