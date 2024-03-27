package com.ps.controller;

import com.ps.model.Cliente;
import com.ps.model.Prestamo;
import com.ps.service.IPrestamoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/prestamos")
public class PerstamoController {
    private final IPrestamoService iPrestamoService;

    public PerstamoController(IPrestamoService iPrestamoService) {
        this.iPrestamoService = iPrestamoService;
    }


    @GetMapping()
    public ResponseEntity<List<Prestamo>> getPrestamoByLoanId(@RequestParam Long loanId) {
        List<Prestamo> prestamo = iPrestamoService.getPrestamoByLoanId(loanId);
        return ResponseEntity.ok(prestamo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Long id) {
        Prestamo prestamo = iPrestamoService.getPrestamoById(id);
        return ResponseEntity.ok(prestamo);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Prestamo> createPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo createdPrestamo =iPrestamoService.createPrestamo(prestamo);
        return new ResponseEntity<>(createdPrestamo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Prestamo> updatePrestamo( @RequestBody Prestamo prestamo) {
        Prestamo updatedPrestamo = iPrestamoService.updatePrestamo(prestamo);
        return ResponseEntity.ok(updatedPrestamo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id) {
        iPrestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }




}
