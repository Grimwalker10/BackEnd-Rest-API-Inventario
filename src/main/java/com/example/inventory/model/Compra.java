package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "CO_Compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coCompraId;

    @ManyToOne
    @JoinColumn(name = "pv_proveedor_id")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "us_usuario_id")
    private Usuario usuario;

    private LocalDate coFechaCompra;
    private Float coTotal;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCompra> detalles;

    public Long getCoCompraId() { return coCompraId; }
    public void setCoCompraId(Long coCompraId) { this.coCompraId = coCompraId; }
    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public LocalDate getCoFechaCompra() { return coFechaCompra; }
    public void setCoFechaCompra(LocalDate coFechaCompra) { this.coFechaCompra = coFechaCompra; }
    public Float getCoTotal() { return coTotal; }
    public void setCoTotal(Float coTotal) { this.coTotal = coTotal; }
    public java.util.List<DetalleCompra> getDetalles() { return detalles; }
    public void setDetalles(java.util.List<DetalleCompra> detalles) { this.detalles = detalles; }
}
