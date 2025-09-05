import model.*;

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

        BolsaSupermercado<Limpieza> bolsaLimpieza = new BolsaSupermercado<>();
        bolsaLimpieza.addProducto(new Limpieza("Detergente", 3.5, "Líquido", 4.0));
        bolsaLimpieza.addProducto(new Limpieza("Jabón", 2.0, "Jabon", 3.0));
        bolsaLimpieza.addProducto(new Limpieza("Desinfectante", 4.5, "Amoniaco", 5.0));
        bolsaLimpieza.addProducto(new Limpieza("Limpiador multiusos", 3.0, "Líquido", 4.5));
        bolsaLimpieza.addProducto(new Limpieza("Suavizante", 2.5, "Jabon", 3.5));
        List<? extends Producto> limpieza = bolsaLimpieza.getProductos();
        System.out.println("\nProductos de limpieza:");
        imprimirProductos(limpieza);


        BolsaSupermercado<NoPerecible> bolsaNoPerecible = new BolsaSupermercado<>();
        bolsaNoPerecible.addProducto(new NoPerecible("Arroz", 1.5, 1, 365));
        bolsaNoPerecible.addProducto(new NoPerecible("Pasta", 1.0, 1, 180));
        bolsaNoPerecible.addProducto(new NoPerecible("Miel", 5.0, 15, 730));
        bolsaNoPerecible.addProducto(new NoPerecible("Conservas", 2.5, 5, 540));
        List<? extends Producto> noPerecible = bolsaNoPerecible.getProductos();
        System.out.println("\nProductos no perecibles:");
        imprimirProductos(noPerecible);
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
