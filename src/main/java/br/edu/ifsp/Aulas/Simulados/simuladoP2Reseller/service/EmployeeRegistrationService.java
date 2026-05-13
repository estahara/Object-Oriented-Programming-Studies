package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.service;

import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Consultant;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Employee;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Reseller;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final Repository<String, Employee> repo;

    public EmployeeRegistrationService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public void register(String id, String name, LocalDate birth, double sold, String responsibleId) {
        Employee responsible = repo.findById(responsibleId).orElseThrow();
        Employee newEmployee = new Reseller(id, name, birth, sold);

        if (responsible instanceof Reseller r) {
            Consultant promoted = new Consultant(r.getId(), r.getName(), r.getBirthDate(), r.getSoldValue());
            promoted.addEmployee(newEmployee);
            repo.update(promoted);
        } else if (responsible instanceof Consultant c) {
            c.addEmployee(newEmployee);
            repo.update(c);
        }
        repo.save(newEmployee);
    }
}
