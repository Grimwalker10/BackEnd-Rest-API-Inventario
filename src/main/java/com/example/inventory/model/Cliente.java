package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CL_Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clClienteId;

    @Column(length = 50)
    private String clNombre;

    @Column(length = 50)
    private String clApellido;

    @Column(length = 10)
    private String clTelefono;

    @Column(length = 50)
    private String clEmail;

    @Column(length = 50)
    private String clDireccion;

    private LocalDate clFechaRegistro;

    public Long getClClienteId() { return clClienteId; }
    public void setClClienteId(Long clClienteId) { this.clClienteId = clClienteId; }
    public String getClNombre() { return clNombre; }
    public void setClNombre(String clNombre) { this.clNombre = clNombre; }
    public String getClApellido() { return clApellido; }
    public void setClApellido(String clApellido) { this.clApellido = clApellido; }
    public String getClTelefono() { return clTelefono; }
    public void setClTelefono(String clTelefono) { this.clTelefono = clTelefono; }
    public String getClEmail() { return clEmail; }
    public void setClEmail(String clEmail) { this.clEmail = clEmail; }
    public String getClDireccion() { return clDireccion; }
    public void setClDireccion(String clDireccion) { this.clDireccion = clDireccion; }
    public LocalDate getClFechaRegistro() { return clFechaRegistro; }
    public void setClFechaRegistro(LocalDate clFechaRegistro) { this.clFechaRegistro = clFechaRegistro; }
}
