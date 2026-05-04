package main.java.br.edu.ifsp.Aulas.aula06.exEmployee;

public interface Repository<K, T> {
    void save(T entity);
    T findById(K id);

}
