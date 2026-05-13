package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model;

import java.time.LocalDate;

public final class Reseller extends Employee {
    public Reseller(String id, String name, LocalDate birthDate, double soldValue) {
        super(id, name, birthDate, soldValue);
    }

    @Override
    public double getCommission() {
        return getSoldValue() * 0.15;
    }

    @Override
    public String toString() {
        return "RESELLER\n" + super.toString();
    }
}
