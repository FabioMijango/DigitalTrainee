import model.*;

import java.lang.reflect.Field;
import java.util.List;

public class MainDiferentesBolsas {
    public static void main(String[] args) {

        BolsaSupermercado<Lacteo> bolsaLacteos = new BolsaSupermercado<>();
        bolsaLacteos.addProducto(new Lacteo("Leche", 2.5, 100, 100));
        bolsaLacteos.addProducto(new Lacteo("Queso", 5.0, 200, 50));
        bolsaLacteos.addProducto(new Lacteo("Yogur", 1.5, 150, 30));
        bolsaLacteos.addProducto(new Lacteo("Mantequilla", 3.0, 250, 20));
        bolsaLacteos.addProducto(new Lacteo("Crema", 4.0, 300, 10));
        List<? extends Producto> lacteos = bolsaLacteos.getProductos();
        System.out.println("Lácteos:");
        imprimirProductos(lacteos);


        BolsaSupermercado<Fruta> bolsaFrutas = new BolsaSupermercado<>();
        bolsaFrutas.addProducto(new Fruta("Manzana", 0.5, 0.2, "Roja"));
        bolsaFrutas.addProducto(new Fruta("Plátano", 0.3, 0.25, "Amarillo"));
        bolsaFrutas.addProducto(new Fruta("Naranja", 0.4, 0.3, "Naranja"));
        bolsaFrutas.addProducto(new Fruta("Kiwi", 0.6, 0.15, "Marrón"));
        bolsaFrutas.addProducto(new Fruta("Fresa", 0.8, 0.1, "Roja"));
        List<? extends Producto> frutas = bolsaFrutas.getProductos();
        System.out.println("\nFrutas:");
        imprimirProductos(frutas);

        System.out.println("\nProducto en la posición 2 de la bolsa de frutas:");
        Producto producoPorId = bolsaFrutas.porId(2);
        imprimirProductos(List.of(producoPorId));

        bolsaFrutas.updateProducto(0, new Fruta("Pera", 0.7, 0.22, "Verde"));
        bolsaFrutas.deleteProducto(3);

        System.out.println("\nFrutas después de actualizar y eliminar:");
        imprimirProductos(bolsaFrutas.getProductos());
    }

/*
    public static void imprimirProductos(List<? extends Producto> bolsa){
        bolsa.forEach(System.out::println);
    }

    public static void imprimirProductos(List<? extends Producto> bolsa) {
        bolsa.forEach(producto -> {
            System.out.print(producto.getNombre() + " - Precio: $" + producto.getPrecio());

            if(producto instanceof Lacteo){
                System.out.println(" - Cantidad:" + ((Lacteo) producto).getCantidad() + "ml - Proteinas: " + ((Lacteo) producto).getProteinas() + "g");
            } else if (producto instanceof Fruta) {
                System.out.println(" - Peso:" + ((Fruta) producto).getPeso() + "kg - Color: " + ((Fruta) producto).getColor());
            } else if (producto instanceof Limpieza) {
                System.out.println(" - Componente:" + ((Limpieza) producto).getComponentes() + " - Litros: " + ((Limpieza) producto).getLitros() + "L");
            } else if (producto instanceof NoPerecible) {
                System.out.println(" - Contenido:" + ((NoPerecible) producto).getContenido() + "kg - Calorías: " + ((NoPerecible) producto).getCalorias() + "cal");
            }
        });
    }
 */

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
