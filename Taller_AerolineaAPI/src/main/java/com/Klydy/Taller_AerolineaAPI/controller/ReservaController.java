package com.Klydy.Taller_AerolineaAPI.controller;

import com.Klydy.Taller_AerolineaAPI.dto.ReservaRequestDTO;
import com.Klydy.Taller_AerolineaAPI.dto.ReservaResponseDTO;
import com.Klydy.Taller_AerolineaAPI.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id) {

        ReservaResponseDTO reserva = reservaService.findById(id);

        if (reserva == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reserva);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(
            @Valid @RequestBody ReservaRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ReservaRequestDTO dto) {

        ReservaResponseDTO reservaActualizada =
                reservaService.update(id, dto);

        if (reservaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reservaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        reservaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}