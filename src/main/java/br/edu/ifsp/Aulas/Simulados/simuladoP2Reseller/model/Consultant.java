package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Consultant extends Employee {

    private final Set<Employee> subordinates;

    public Consultant(String id, String name, LocalDate birthDate, double soldValue) {
        super(id, name, birthDate, soldValue);
        this.subordinates = new HashSet<>();
    }

    @Override
    public double getCommission() {
        double subordinatesTotal = subordinates.stream()
                .mapToDouble(Employee::getCommission)
                .sum();

        return (getSoldValue() * 0.15) + (subordinatesTotal * 0.30);
    }

    public void addEmployee(Employee e) {
        if (e == null) throw new NullPointerException("Subordinado não pode ser null.");

        if (e.getId().equals(this.getId())) throw new IllegalArgumentException("Um consultor não pode ser seu próprio subordinado.");

        subordinates.remove(e);
        subordinates.add(e);
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(subordinates);
    }

    public void removeEmployee(Employee e) {
        if (e == null) throw new NullPointerException("Subordinado não pode ser null.");

        subordinates.remove(e);
    }

    @Override
    public String toString() {
        return "CONSULTANTS\n" + super.toString();
    }
}
