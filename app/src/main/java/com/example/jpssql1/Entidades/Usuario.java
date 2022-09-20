package com.example.jpssql1.Entidades;

public class Usuario {
    private String id;
    private String nombre;
    private String telefono;

    public Usuario(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Usuario() {
        this.id = "nnn";
        this.nombre = "nnn";
        this.telefono = "00000";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "id='" + id  +
                ", nombre='" + nombre  +
                ", telefono='" + telefono ;
    }
}
