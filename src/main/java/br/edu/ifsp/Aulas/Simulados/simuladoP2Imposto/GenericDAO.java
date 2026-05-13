package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Imposto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class GenericDAO<K, T extends Entidade<K>> {

    protected static final Map<Object, Object> banco = new HashMap<>();

    public void salvar(T entidade) {
        banco.put(entidade.getId(), entidade);
    }

    public Optional<T> buscarPorId(K id) {
        return Optional.ofNullable((T) banco.get(id));
    }

    public List<T> listarTodos() {
        return banco.values()
                .stream()
                .map(e -> (T) e)
                .toList();
    }

    public void remover(K id) {
        banco.remove(id);
    }

    public void atualizar(T entidade) {
        banco.put(entidade.getId(), entidade);
    }
}
