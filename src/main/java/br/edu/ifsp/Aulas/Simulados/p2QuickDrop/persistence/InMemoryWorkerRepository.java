package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.persistence;

import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.exception.EntityAlreadyExistsException;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.exception.EntityDoesNotExistsException;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model.Worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryWorkerRepository implements Repository<String, Worker> {

    private static final Map<String, Worker> map = new HashMap<>();

    @Override
    public void save(Worker w) {
        if (map.containsKey(w.getId())) throw new EntityAlreadyExistsException("O worker com este id já existe: " + w.getId());

        map.put(w.getId(), w);
    }

    @Override
    public void update(Worker w) {
        if (!map.containsKey(w.getId())) throw new EntityDoesNotExistsException("O worker com este id não existe: " + w.getId());

        map.put(w.getId(), w);
    }

    @Override
    public Optional<Worker> findById(String id) {
        return Optional.ofNullable(map.get(id));
    }
}
