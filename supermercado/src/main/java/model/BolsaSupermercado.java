package model;

import repositorio.BaseRepositorio;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado<T extends Producto> implements BaseRepositorio<T> {

    List<T> productos;
    int capacidadMaxima = 5;

    public BolsaSupermercado(){
        this.productos = new ArrayList<>();
    }

    @Override
    public void addProducto(T producto){
        if(productos.size() > capacidadMaxima) {
            System.out.println("No se pueden agregar mas productos, la bolsa esta llena");
            return;
        }
        productos.add(producto);
    }

    @Override
    public List<T> getProductos(){
        return productos;
    }

    @Override
    public T porId(int index) {
        return this.productos.get(index);
    }

    @Override
    public void updateProducto(int index, T producto) {
        this.productos.set(index, producto);
    }

    @Override
    public void deleteProducto(int index) {
        this.productos.remove(index);
    }

    @Override
    public Double total() {
        Double total = 0.0;
        for(T producto : productos){
            total += producto.getPrecio();
        }
        return total;
    }
}
