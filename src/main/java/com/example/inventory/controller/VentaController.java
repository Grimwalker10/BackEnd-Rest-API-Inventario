package com.example.inventory.controller;

import com.example.inventory.model.Venta;
import com.example.inventory.repository.VentaRepository;
import com.example.inventory.service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaRepository ventaRepository;
    private final VentaService ventaService;
    public VentaController(VentaRepository ventaRepository, VentaService ventaService) { this.ventaRepository = ventaRepository; this.ventaService = ventaService; }

    @GetMapping
    public List<Venta> all() { return ventaRepository.findAll(); }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Venta venta) {
        try {
            Venta saved = ventaService.createVenta(venta);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
