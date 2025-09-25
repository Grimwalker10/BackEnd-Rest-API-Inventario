package com.example.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PV_Proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pvProveedorId;

    @Column(length = 50)
    private String pvNombreEmpresa;

    @Column(length = 10)
    private String pvTelefono;

    @Column(length = 50)
    private String pvEmail;

    @Column(length = 50)
    private String pvDireccion;

    public Long getPvProveedorId() { return pvProveedorId; }
    public void setPvProveedorId(Long pvProveedorId) { this.pvProveedorId = pvProveedorId; }
    public String getPvNombreEmpresa() { return pvNombreEmpresa; }
    public void setPvNombreEmpresa(String pvNombreEmpresa) { this.pvNombreEmpresa = pvNombreEmpresa; }
    public String getPvTelefono() { return pvTelefono; }
    public void setPvTelefono(String pvTelefono) { this.pvTelefono = pvTelefono; }
    public String getPvEmail() { return pvEmail; }
    public void setPvEmail(String pvEmail) { this.pvEmail = pvEmail; }
    public String getPvDireccion() { return pvDireccion; }
    public void setPvDireccion(String pvDireccion) { this.pvDireccion = pvDireccion; }
}
