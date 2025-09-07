package repositorio;

import model.Producto;

public interface ContableRepositorio<T extends Producto> {
    Double total();
}
