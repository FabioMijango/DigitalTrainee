package modelo;

import java.util.Date;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date llegada;
    private Integer numPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date llegada, Integer numPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.llegada = llegada;
        this.numPasajeros = numPasajeros;
    }

    @Override
    public String toString() {
//        return nombre + " - " + origen + " - " + destino + " - " + llegada + " - " + numPasajeros;
        return String.format("%-10s %-18s %-15s %s %3d", nombre, origen, destino, llegada, numPasajeros);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getLlegada() {
        return llegada;
    }

    public void setLlegada(Date llegada) {
        this.llegada = llegada;
    }

    public Integer getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(Integer numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
}
