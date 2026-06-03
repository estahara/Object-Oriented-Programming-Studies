package main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.service;

import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model.Consultant;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model.Employee;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model.Reseller;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final Repository<String, Employee> repo;

    public EmployeeRegistrationService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public void register(String id, String name, LocalDate birthDate, double soldValue, String consultantInChargeId) {
        Reseller newEmployee = new Reseller(id, name, birthDate, soldValue, consultantInChargeId);
        repo.save(newEmployee);

        if (consultantInChargeId != null) {
            Employee responsible = repo.findById(consultantInChargeId).orElseThrow();
            Consultant consultant;

            if (responsible instanceof Reseller) {
                consultant = new Consultant(
                        responsible.getId(),
                        responsible.getName(),
                        responsible.getBirthDate(),
                        responsible.getSoldValue(),
                        responsible.getConsultantInChargeId()
                );
                repo.update(consultant);

                if (responsible.getConsultantInChargeId() != null) {
                    Consultant grandparent = (Consultant) repo.findById(responsible.getConsultantInChargeId()).orElseThrow();
                    grandparent.addEmployee(consultant);
                }
            } else {
                consultant = (Consultant) responsible;
            }

            consultant.addEmployee(newEmployee);
        }
    }
}
