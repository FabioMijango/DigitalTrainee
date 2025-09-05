package model;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado<T extends Producto> {

    List<T> productos;
    int capacidadMaxima = 5;

    public BolsaSupermercado(){
        this.productos = new ArrayList<>();
    }

    public void addProducto(T producto){
        if(productos.size() > capacidadMaxima) {
            System.out.println("No se pueden agregar mas productos, la bolsa esta llena");
            return;
        }
        productos.add(producto);
    }

    public List<T> getProductos(){
        return productos;
    }
}
