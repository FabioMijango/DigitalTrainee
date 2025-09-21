package org.hibernate_jpa;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa.entity.Producto;
import org.hibernate_jpa.util.JpaUtil;

import javax.swing.*;

public class ProductoCrear {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
            Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));

            em.getTransaction().begin();

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            em.persist(producto);

            em.getTransaction().commit();

            System.out.println("Producto registrado con ID: " + producto.getId());
            producto = em.find(Producto.class, producto.getId());
            System.out.println(producto);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
