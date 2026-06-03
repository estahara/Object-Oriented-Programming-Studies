package main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Consultant extends Employee {

    private final Set<Employee> subordinates = new HashSet<>();

    public Consultant(String id, String name, LocalDate birthDate, double soldValue, String consultantInChargeId) {
        super(id, name, birthDate, soldValue, consultantInChargeId);
    }

    @Override
    public double getCommission() {
        double vendaPropria = getSoldValue() * 0.15;
        double valorComissaoTotal = subordinates.stream()
                .mapToDouble(Employee::getCommission)
                .sum();

        return vendaPropria + (valorComissaoTotal * 0.30);
    }

    public void addEmployee(Employee e) {
        subordinates.removeIf(emp -> emp.getId().equals(e.getId()));
        subordinates.add(e);
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(subordinates);
    }

    @Override
    public String toString() {
        return "CONSULTANT\n" + super.toString();
    }


}
