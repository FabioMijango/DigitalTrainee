package repositorio;

import model.Producto;

public interface BaseRepositorio<T extends Producto> extends
        CrudRepositrio<T>,
        OrdenableRepositorio<T>,
        ContableRepositorio<T>{

}
