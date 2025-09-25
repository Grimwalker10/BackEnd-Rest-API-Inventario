package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PR_Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prProductoId;

    @Column(length = 50)
    private String prNombre;

    @Column(length = 100)
    private String prDescripcion;

    private Float prPrecioCompra;
    private Float prPrecioVenta;
    private Integer prStockActual;
    private Integer prStockMinimo;

    @ManyToOne
    @JoinColumn(name = "ca_categoria_id")
    private Categoria categoria;

    private LocalDate prFechaRegistro;

    public Long getPrProductoId() { return prProductoId; }
    public void setPrProductoId(Long prProductoId) { this.prProductoId = prProductoId; }
    public String getPrNombre() { return prNombre; }
    public void setPrNombre(String prNombre) { this.prNombre = prNombre; }
    public String getPrDescripcion() { return prDescripcion; }
    public void setPrDescripcion(String prDescripcion) { this.prDescripcion = prDescripcion; }
    public Float getPrPrecioCompra() { return prPrecioCompra; }
    public void setPrPrecioCompra(Float prPrecioCompra) { this.prPrecioCompra = prPrecioCompra; }
    public Float getPrPrecioVenta() { return prPrecioVenta; }
    public void setPrPrecioVenta(Float prPrecioVenta) { this.prPrecioVenta = prPrecioVenta; }
    public Integer getPrStockActual() { return prStockActual; }
    public void setPrStockActual(Integer prStockActual) { this.prStockActual = prStockActual; }
    public Integer getPrStockMinimo() { return prStockMinimo; }
    public void setPrStockMinimo(Integer prStockMinimo) { this.prStockMinimo = prStockMinimo; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public LocalDate getPrFechaRegistro() { return prFechaRegistro; }
    public void setPrFechaRegistro(LocalDate prFechaRegistro) { this.prFechaRegistro = prFechaRegistro; }
}
