package com.example.inventory.service;

import com.example.inventory.model.*;
import com.example.inventory.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService {
    private final VentaRepository ventaRepo;
    private final ProductoRepository productoRepo;
    private final MovimientoStockRepository movimientoRepo;

    public VentaService(VentaRepository ventaRepo, ProductoRepository productoRepo, MovimientoStockRepository movimientoRepo) {
        this.ventaRepo = ventaRepo;
        this.productoRepo = productoRepo;
        this.movimientoRepo = movimientoRepo;
    }

    @Transactional
    public Venta createVenta(Venta venta) {
        venta.setVtFechaVenta(LocalDate.now());
        float total = 0f;
        List<DetalleVenta> detalles = venta.getDetalles();
        if (detalles != null) {
            for (DetalleVenta d : detalles) {
                Producto p = productoRepo.findById(d.getProducto().getPrProductoId()).orElseThrow(() -> new RuntimeException("Producto no existe: " + d.getProducto().getPrProductoId()));
                d.setProducto(p);
                d.setDvSubtotal(d.getDvPrecioUnitario() * d.getDvCantidad());
                total += d.getDvSubtotal();
                Integer actual = p.getPrStockActual() == null ? 0 : p.getPrStockActual();
                if (actual < d.getDvCantidad()) throw new RuntimeException("Stock insuficiente para producto: " + p.getPrProductoId());
                p.setPrStockActual(actual - d.getDvCantidad());
                productoRepo.save(p);
                MovimientoStock ms = new MovimientoStock();
                ms.setProducto(p);
                ms.setMsTipo("salida");
                ms.setMsCantidad(d.getDvCantidad());
                ms.setMsFechaMovimiento(LocalDate.now());
                ms.setMsDescripcion("Venta generada");
                movimientoRepo.save(ms);
                d.setVenta(venta);
            }
        }
        venta.setVtTotal(total);
        return ventaRepo.save(venta);
    }
}
