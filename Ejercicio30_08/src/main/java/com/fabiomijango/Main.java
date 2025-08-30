package com.fabiomijango;

import com.fabiomijango.Model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Impriendo personal:\n");

        Directivo directivo = new Directivo("Pablo");
        System.out.println(directivo);
        System.out.println(directivo.trabajar() + "\n");

        Operario operario = new Operario("Pepe");
        System.out.println(operario);
        System.out.println(operario.trabajar() + "\n");

        Oficial oficial = new Oficial("Juan");
        System.out.println(oficial);
        System.out.println(oficial.trabajar() + "\n");

        Tecnico tecnico = new Tecnico("Luis");
        System.out.println(tecnico);
        System.out.println(tecnico.trabajar() + "\n");
    }
}