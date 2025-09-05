import model.*;

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
    }
//    public static void imprimirProductos(List<? extends Producto> bolsa){
//        bolsa.forEach(producto -> {
//            System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio());
//        });
//    }

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
}
