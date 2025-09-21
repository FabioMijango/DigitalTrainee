package org.hibernate_jpa.services;

import org.hibernate_jpa.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    List<T> listar();
    Optional<T> porId(Long id);
    void guardar(T obj);
    void eliminar(Long id);
}
