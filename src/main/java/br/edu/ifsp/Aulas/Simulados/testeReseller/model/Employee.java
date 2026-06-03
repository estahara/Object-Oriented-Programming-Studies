package main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits Reseller, Consultant {
    private final String id;
    private String name;
    private LocalDate birthDate;
    private double soldValue;
    private String consultantInChargeId;

    public Employee(String id, String name, LocalDate birthDate, double soldValue, String consultantInChargeId) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
        this.consultantInChargeId = consultantInChargeId;
    }

    public abstract double getCommission();

    @Override
    public String toString() {
        return String.format("Id: %s | Name: %s | BirthDate: %s | SoldValue: %.2f | ConsultantInChargeId: %s",
                id, name, birthDate, soldValue, consultantInChargeId);
    }

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

    public String getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public double getSoldValue() {return soldValue;}
    public void setSoldValue(double soldValue) {this.soldValue = soldValue;}
    public String getConsultantInChargeId() {return consultantInChargeId;}
    public void setConsultantInChargeId(String consultantInChargeId) {this.consultantInChargeId = consultantInChargeId;}

}
