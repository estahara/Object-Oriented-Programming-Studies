package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits Consultant, Reseller {
    private final String id;
    private String name;
    private LocalDate birthDate;
    private double soldValue;

    public Employee(String id, String name, LocalDate birthDate, double soldValue) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
    }

    public abstract double getCommission();

    public String getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public double getSoldValue() {return soldValue;}
    public void setSoldValue(double soldValue) {this.soldValue = soldValue;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", soldValue=" + soldValue +
                '}';
    }
}
