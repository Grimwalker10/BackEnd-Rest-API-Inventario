package com.example.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DC_Detalle_Compras")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dcDetalleCompraId;

    @ManyToOne
    @JoinColumn(name = "co_compra_id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "pr_producto_id")
    private Producto producto;

    private Integer dcCantidad;
    private Float dcPrecioUnitario;
    private Float dcSubtotal;

    public Long getDcDetalleCompraId() { return dcDetalleCompraId; }
    public void setDcDetalleCompraId(Long dcDetalleCompraId) { this.dcDetalleCompraId = dcDetalleCompraId; }
    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public Integer getDcCantidad() { return dcCantidad; }
    public void setDcCantidad(Integer dcCantidad) { this.dcCantidad = dcCantidad; }
    public Float getDcPrecioUnitario() { return dcPrecioUnitario; }
    public void setDcPrecioUnitario(Float dcPrecioUnitario) { this.dcPrecioUnitario = dcPrecioUnitario; }
    public Float getDcSubtotal() { return dcSubtotal; }
    public void setDcSubtotal(Float dcSubtotal) { this.dcSubtotal = dcSubtotal; }
}
