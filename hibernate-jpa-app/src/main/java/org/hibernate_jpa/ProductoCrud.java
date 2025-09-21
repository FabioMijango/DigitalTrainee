package org.hibernate_jpa;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa.entity.Producto;
import org.hibernate_jpa.services.CrudService;
import org.hibernate_jpa.services.ProductoServiceImp;
import org.hibernate_jpa.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class ProductoCrud {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        CrudService<Producto> service = new ProductoServiceImp(em);

        System.out.println("========== listar productos ==========");
        List<Producto> productos = service.listar();
        productos.forEach(System.out::println);

        System.out.println("========= obtener producto por id =========");
        Long id = 3L;
        Optional<Producto> optionalProducto = service.porId(id);
        optionalProducto.ifPresent(System.out::println);

        System.out.println("========= insertar nuevo producto =========");
        Producto producto = new Producto();
        producto.setNombre("Papas fritas");
        producto.setPrecio(2.0);

        service.guardar(producto);
        System.out.println("producto guardado con exito!");
        service.listar().forEach(System.out::println);


        System.out.println("========= editar producto =========");
        id = producto.getId();
        optionalProducto = service.porId(id);
        optionalProducto.ifPresent(p -> {
            p.setPrecio(3.0);
            p.setNombre("Papas fritas grandes");
            service.guardar(p);
            System.out.println("producto editado con exito!");
        });
        service.listar().forEach(System.out::println);

        System.out.println("========= eliminar producto =========");
        id = producto.getId();
        optionalProducto = service.porId(id);
        optionalProducto.ifPresent(p -> {
            service.eliminar(p.getId());
            System.out.println("producto eliminado con exito!");
        });
        service.listar().forEach(System.out::println);

        em.close();
    }
}
