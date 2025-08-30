package com.fabiomijango.Model;

public class Oficial extends Operario {

    public Oficial(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre() + " y soy un Oficial";
    }

    @Override
    public String trabajar() {
        return "Estoy trabajando en la operacion de una maquina y supervisando a los operarios";
    }
}
