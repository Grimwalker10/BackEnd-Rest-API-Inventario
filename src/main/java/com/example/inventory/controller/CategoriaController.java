package com.example.inventory.controller;

import com.example.inventory.model.Categoria;
import com.example.inventory.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;
    public CategoriaController(CategoriaRepository categoriaRepository) { this.categoriaRepository = categoriaRepository; }

    @GetMapping
    public List<Categoria> all() { return categoriaRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) { return categoriaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }

    @PostMapping
    public Categoria create(@RequestBody Categoria c) { return categoriaRepository.save(c); }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria dto) {
        return categoriaRepository.findById(id).map(c -> { c.setCaNombre(dto.getCaNombre()); c.setCaDescripcion(dto.getCaDescripcion()); categoriaRepository.save(c); return ResponseEntity.ok(c); }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { if(!categoriaRepository.existsById(id)) return ResponseEntity.notFound().build(); categoriaRepository.deleteById(id); return ResponseEntity.noContent().build(); }
}
