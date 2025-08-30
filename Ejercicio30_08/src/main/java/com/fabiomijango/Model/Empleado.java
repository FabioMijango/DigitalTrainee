package com.fabiomijango.Model;

public abstract class Empleado {
    protected String nombre;

    public Empleado() {
    }
    public Empleado(String nombre) {
        this();
        this.nombre = nombre;
    }

    public abstract String toString();

    public abstract String trabajar();

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
