package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model;

import java.time.LocalDate;

public final class Deliverer extends Worker {
    public Deliverer(String id, String name, LocalDate registrationDate, double deliveredValue, String partnerInChargeId) {
        super(id, name, registrationDate, deliveredValue, partnerInChargeId);
    }

    @Override
    public double getEarnings() {
        return getDeliveredValue() * 0.12;
    }

    @Override
    public String toString() {
        return "DELIVERER\n" + super.toString() + "\nEarnings: " + getEarnings();
    }

}
