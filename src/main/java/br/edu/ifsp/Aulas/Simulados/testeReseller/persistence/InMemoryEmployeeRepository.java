package main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.persistence;

import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.exception.EntityAlreadyExistsException;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryEmployeeRepository implements Repository<String, Employee>{

    private final static Map<String, Employee> map = new HashMap<>();

    @Override
    public void save(Employee e) {
        if (map.containsKey(e.getId())) throw new EntityAlreadyExistsException("Esse funcionário já existe como id: " + e.getId());

        map.put(e.getId(), e);
    }

    @Override
    public void update(Employee e) {
        if (!map.containsKey(e.getId())) throw new IllegalArgumentException("O funcionário informado não existe: " + e.getId());

        map.put(e.getId(), e);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(map.get(id));
    }
}
