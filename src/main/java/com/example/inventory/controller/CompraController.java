package com.example.inventory.controller;

import com.example.inventory.model.Compra;
import com.example.inventory.repository.CompraRepository;
import com.example.inventory.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final CompraRepository compraRepository;
    private final CompraService compraService;
    public CompraController(CompraRepository compraRepository, CompraService compraService) { this.compraRepository = compraRepository; this.compraService = compraService; }

    @GetMapping
    public List<Compra> all() { return compraRepository.findAll(); }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Compra compra) {
        try {
            Compra saved = compraService.createCompra(compra);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
