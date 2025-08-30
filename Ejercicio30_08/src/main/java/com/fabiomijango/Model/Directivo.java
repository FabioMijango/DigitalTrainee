package com.fabiomijango.Model;

public class Directivo extends Empleado{

    public Directivo(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre() + " y soy un Directivo";
    }

    @Override
    public String trabajar() {
        return "Estoy dirigiendo la empresa";
    }
}
