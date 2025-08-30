package com.fabiomijango.Model;


public class Operario extends Empleado {

    public Operario(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre() + " y soy un Operario";
    }

    @Override
    public String trabajar() {
        return "Estoy trabajando en la operacion de una maquina";
    }
}
