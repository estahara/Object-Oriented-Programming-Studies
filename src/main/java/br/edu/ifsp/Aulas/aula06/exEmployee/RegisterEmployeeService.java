package main.java.br.edu.ifsp.Aulas.aula06.exEmployee;

public class RegisterEmployeeService {
    private Repository<String, Employee> repository;

    public RegisterEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee e) {
        if (repository.findById(e.getId()) == null) repository.save(e);
    }
}
