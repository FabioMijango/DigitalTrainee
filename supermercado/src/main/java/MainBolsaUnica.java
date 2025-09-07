import model.*;

import java.lang.reflect.Field;
import java.util.List;

public class MainBolsaUnica {
    public static void main(String[] args) {

        BolsaSupermercado<Producto> bolsa = new BolsaSupermercado<>();

        bolsa.addProducto(new Fruta("Manzana", 0.5, 0.2, "Roja"));
        bolsa.addProducto(new Limpieza("Detergente", 3.5, "Mucho jabon", 4.0));
        bolsa.addProducto(new Lacteo("Leche", 2.5, 100, 100));
        bolsa.addProducto(new NoPerecible("Arroz", 1.5, 1, 365));
        bolsa.addProducto(new Fruta("Plátano", 0.3, 0.25, "Amarillo"));

        List<Producto> productos = bolsa.getProductos();
        System.out.println("Productos en la bolsa:");
        imprimirProductos(productos);

        Producto productoPorId = bolsa.porId(2);
        System.out.println("\nProducto en la posición 2:");
        imprimirProductos(List.of(productoPorId));

        bolsa.updateProducto(2, new Fruta("Fresa", 0.8, 0.1, "Roja"));
        bolsa.deleteProducto(1);

        System.out.println("\nProductos en la bolsa después de actualizar y eliminar:");
        imprimirProductos(bolsa.getProductos());
    }

    public static void imprimirProductos(List<? extends Producto> bolsa) {
        bolsa.forEach(producto -> {
            System.out.print(producto.getNombre() + " - Precio: $" + producto.getPrecio());

            for(Field field : producto.getClass().getDeclaredFields()){
                field.setAccessible(true);
                try {
                    System.out.print(" - " + field.getName() + ": " + field.get(producto));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        });
    }
}
