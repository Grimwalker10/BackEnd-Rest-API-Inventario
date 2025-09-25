package com.example.inventory.dto;

public class RegisterRequest {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String rol;
    private String password;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
