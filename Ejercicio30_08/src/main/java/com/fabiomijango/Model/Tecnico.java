package com.fabiomijango.Model;

public class Tecnico extends Operario {

    public Tecnico(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre() + " y soy un Tecnico";
    }

    @Override
    public String trabajar(){
        return "Estoy asegurandome que las maquinas funcionen correctamente";
    }
}
