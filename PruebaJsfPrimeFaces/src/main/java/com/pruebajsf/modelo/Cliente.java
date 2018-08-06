package com.pruebajsf.modelo;



public class Cliente{
    private int id;
    private String nombre;
    private String apellido;
    private String nit;

    public Cliente() {
        this.id=0;
        this.nombre=null;
        this.apellido=null;
        this.nit=null;
    }

    public Cliente(int id, String nombre, String apellido, String nit) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nit = nit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
}
