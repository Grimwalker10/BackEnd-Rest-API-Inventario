package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "VT_Ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vtVentaId;

    @ManyToOne
    @JoinColumn(name = "cl_cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "us_usuario_id")
    private Usuario usuario;

    private LocalDate vtFechaVenta;
    private Float vtTotal;
    private String vtMetodoPago;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalles;

    public Long getVtVentaId() { return vtVentaId; }
    public void setVtVentaId(Long vtVentaId) { this.vtVentaId = vtVentaId; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public LocalDate getVtFechaVenta() { return vtFechaVenta; }
    public void setVtFechaVenta(LocalDate vtFechaVenta) { this.vtFechaVenta = vtFechaVenta; }
    public Float getVtTotal() { return vtTotal; }
    public void setVtTotal(Float vtTotal) { this.vtTotal = vtTotal; }
    public String getVtMetodoPago() { return vtMetodoPago; }
    public void setVtMetodoPago(String vtMetodoPago) { this.vtMetodoPago = vtMetodoPago; }
    public java.util.List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(java.util.List<DetalleVenta> detalles) { this.detalles = detalles; }
}
