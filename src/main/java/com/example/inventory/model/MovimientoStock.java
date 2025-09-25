package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MS_Movimientos_Stock")
public class MovimientoStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msMovimientoId;

    @ManyToOne
    @JoinColumn(name = "pr_producto_id")
    private Producto producto;

    private String msTipo;
    private Integer msCantidad;
    private LocalDate msFechaMovimiento;
    private String msDescripcion;

    public Long getMsMovimientoId() { return msMovimientoId; }
    public void setMsMovimientoId(Long msMovimientoId) { this.msMovimientoId = msMovimientoId; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public String getMsTipo() { return msTipo; }
    public void setMsTipo(String msTipo) { this.msTipo = msTipo; }
    public Integer getMsCantidad() { return msCantidad; }
    public void setMsCantidad(Integer msCantidad) { this.msCantidad = msCantidad; }
    public LocalDate getMsFechaMovimiento() { return msFechaMovimiento; }
    public void setMsFechaMovimiento(LocalDate msFechaMovimiento) { this.msFechaMovimiento = msFechaMovimiento; }
    public String getMsDescripcion() { return msDescripcion; }
    public void setMsDescripcion(String msDescripcion) { this.msDescripcion = msDescripcion; }
}
