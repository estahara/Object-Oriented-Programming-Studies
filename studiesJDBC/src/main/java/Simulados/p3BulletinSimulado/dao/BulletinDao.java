package Simulados.p3BulletinSimulado.dao;

import java.util.List;

public interface BulletinDao<T> {

    void insert(T entity);

    void delete(int id);

    void update(T entity);

    boolean existsById(int id);

    List<T> findAll();
}
