package repositorio;

import model.Producto;

import java.util.List;

public interface CrudRepositrio<T extends Producto> {
    void addProducto(T producto);
    void updateProducto(int index, T producto);
    void deleteProducto(int index);
}
