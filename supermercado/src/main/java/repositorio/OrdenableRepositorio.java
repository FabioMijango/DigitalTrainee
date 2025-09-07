package repositorio;

import model.Producto;

import java.util.List;

public interface OrdenableRepositorio<T extends Producto> {
    List<T> getProductos();
    T porId(int index);
}
