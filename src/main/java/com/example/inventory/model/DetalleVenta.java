package com.example.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DV_Detalle_Ventas")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dvDetalleVentaId;

    @ManyToOne
    @JoinColumn(name = "vt_venta_id")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "pr_producto_id")
    private Producto producto;

    private Integer dvCantidad;
    private Float dvPrecioUnitario;
    private Float dvSubtotal;

    public Long getDvDetalleVentaId() { return dvDetalleVentaId; }
    public void setDvDetalleVentaId(Long dvDetalleVentaId) { this.dvDetalleVentaId = dvDetalleVentaId; }
    public Venta getVenta() { return venta; }
    public void setVenta(Venta venta) { this.venta = venta; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public Integer getDvCantidad() { return dvCantidad; }
    public void setDvCantidad(Integer dvCantidad) { this.dvCantidad = dvCantidad; }
    public Float getDvPrecioUnitario() { return dvPrecioUnitario; }
    public void setDvPrecioUnitario(Float dvPrecioUnitario) { this.dvPrecioUnitario = dvPrecioUnitario; }
    public Float getDvSubtotal() { return dvSubtotal; }
    public void setDvSubtotal(Float dvSubtotal) { this.dvSubtotal = dvSubtotal; }
}
