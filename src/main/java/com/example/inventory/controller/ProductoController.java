package com.example.inventory.controller;

import com.example.inventory.model.Producto;
import com.example.inventory.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoRepository productoRepository;
    public ProductoController(ProductoRepository productoRepository) { this.productoRepository = productoRepository; }

    @GetMapping
    public List<Producto> all() { return productoRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable Long id) { return productoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }

    @PostMapping
    public Producto create(@RequestBody Producto p) { return productoRepository.save(p); }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto dto) {
        return productoRepository.findById(id).map(p -> { p.setPrNombre(dto.getPrNombre()); p.setPrDescripcion(dto.getPrDescripcion()); p.setPrPrecioCompra(dto.getPrPrecioCompra()); p.setPrPrecioVenta(dto.getPrPrecioVenta()); p.setPrStockActual(dto.getPrStockActual()); p.setPrStockMinimo(dto.getPrStockMinimo()); p.setCategoria(dto.getCategoria()); productoRepository.save(p); return ResponseEntity.ok(p); }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { if(!productoRepository.existsById(id)) return ResponseEntity.notFound().build(); productoRepository.deleteById(id); return ResponseEntity.noContent().build(); }
}
