package com.example.inventory.service;

import com.example.inventory.model.*;
import com.example.inventory.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraService {
    private final CompraRepository compraRepo;
    private final ProductoRepository productoRepo;
    private final MovimientoStockRepository movimientoRepo;

    public CompraService(CompraRepository compraRepo, ProductoRepository productoRepo, MovimientoStockRepository movimientoRepo) {
        this.compraRepo = compraRepo;
        this.productoRepo = productoRepo;
        this.movimientoRepo = movimientoRepo;
    }

    @Transactional
    public Compra createCompra(Compra compra) {
        compra.setCoFechaCompra(LocalDate.now());
        float total = 0f;
        List<DetalleCompra> detalles = compra.getDetalles();
        if (detalles != null) {
            for (DetalleCompra d : detalles) {
                Producto p = productoRepo.findById(d.getProducto().getPrProductoId()).orElseThrow(() -> new RuntimeException("Producto no existe: " + d.getProducto().getPrProductoId()));
                d.setProducto(p);
                d.setDcSubtotal(d.getDcPrecioUnitario() * d.getDcCantidad());
                total += d.getDcSubtotal();
                Integer actual = p.getPrStockActual() == null ? 0 : p.getPrStockActual();
                p.setPrStockActual(actual + d.getDcCantidad());
                productoRepo.save(p);
                MovimientoStock ms = new MovimientoStock();
                ms.setProducto(p);
                ms.setMsTipo("entrada");
                ms.setMsCantidad(d.getDcCantidad());
                ms.setMsFechaMovimiento(LocalDate.now());
                ms.setMsDescripcion("Compra generada");
                movimientoRepo.save(ms);
                d.setCompra(compra);
            }
        }
        compra.setCoTotal(total);
        return compraRepo.save(compra);
    }
}
