package com.example.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CA_Categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caCategoriaId;

    @Column(length = 50)
    private String caNombre;

    @Column(length = 100)
    private String caDescripcion;

    public Long getCaCategoriaId() { return caCategoriaId; }
    public void setCaCategoriaId(Long caCategoriaId) { this.caCategoriaId = caCategoriaId; }
    public String getCaNombre() { return caNombre; }
    public void setCaNombre(String caNombre) { this.caNombre = caNombre; }
    public String getCaDescripcion() { return caDescripcion; }
    public void setCaDescripcion(String caDescripcion) { this.caDescripcion = caDescripcion; }
}
