package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.persistence;

import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.exception.EntityAlreadyExistsException;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Consultant;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Employee;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class InMemoryEmployeeRepository implements Repository<String, Employee>{

    private static final Map<String, Employee> db = new HashMap<>();

    @Override
    public void save(Employee entity) {
        if (db.containsKey(entity.getId()))
            throw new EntityAlreadyExistsException("Id já existe: " + entity.getId());

        db.put(entity.getId(), entity);
    }

    @Override
    public void update(Employee entity) {
        if (db.containsKey(entity.getId()))
            db.put(entity.getId(), entity);
        else throw new IllegalArgumentException("Funcionário não encontrado: " + entity.getId());
    }

    @Override
    public Optional<Employee> findById(String id) {
        Employee root = db.get(id);
        if (root == null) return Optional.empty();
        return Optional.of(hydrate(root));
    }

    private Employee hydrate(Employee e) {
        if (e instanceof Consultant c) {
            Set<Employee> updatedSubs = new HashSet<>();
            for (Employee sub : c.getEmployees()) {
                Employee fresh = db.get(sub.getId());
                if  (fresh != null) updatedSubs.add(hydrate(fresh));
            }
            updatedSubs.forEach(c::addEmployee);
        }
        return e;
    }


}
