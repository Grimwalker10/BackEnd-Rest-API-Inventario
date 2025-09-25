package com.example.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "US_Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usUsuarioId;

    @Column(length = 50)
    private String usNombre;

    @Column(length = 50)
    private String usApellido;

    @Column(length = 50, unique = true)
    private String usEmail;

    @Column(length = 10)
    private String usTelefono;

    @Column(length = 30)
    private String usRol;

    @Column(length = 255)
    private String usContrasenaHash;

    private LocalDate usFechaCreacion;

    public Long getUsUsuarioId() { return usUsuarioId; }
    public void setUsUsuarioId(Long usUsuarioId) { this.usUsuarioId = usUsuarioId; }
    public String getUsNombre() { return usNombre; }
    public void setUsNombre(String usNombre) { this.usNombre = usNombre; }
    public String getUsApellido() { return usApellido; }
    public void setUsApellido(String usApellido) { this.usApellido = usApellido; }
    public String getUsEmail() { return usEmail; }
    public void setUsEmail(String usEmail) { this.usEmail = usEmail; }
    public String getUsTelefono() { return usTelefono; }
    public void setUsTelefono(String usTelefono) { this.usTelefono = usTelefono; }
    public String getUsRol() { return usRol; }
    public void setUsRol(String usRol) { this.usRol = usRol; }
    public String getUsContrasenaHash() { return usContrasenaHash; }
    public void setUsContrasenaHash(String usContrasenaHash) { this.usContrasenaHash = usContrasenaHash; }
    public LocalDate getUsFechaCreacion() { return usFechaCreacion; }
    public void setUsFechaCreacion(LocalDate usFechaCreacion) { this.usFechaCreacion = usFechaCreacion; }
}
