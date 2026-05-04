package main.java.br.edu.ifsp.Aulas.aula06.exEmployee;

public class FindEmployeeService {
    private Repository<String, Employee> repository;

    public FindEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id) {
        return repository.findById(id);
    }
}
