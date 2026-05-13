package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.persistence;

import java.util.Optional;

public interface Repository<K, T> {
    void save(T entity);
    void update(T entity);
    Optional<T> findById(K id);
}
