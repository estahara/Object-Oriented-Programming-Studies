package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Partner extends Worker{

    private final Set<Worker> subordinates = new LinkedHashSet<>();

    public Partner(String id, String name, LocalDate registrationDate, double deliveredValue, String partnerInChargeId) {
        super(id, name, registrationDate, deliveredValue, partnerInChargeId);
    }

    @Override
    public double getEarnings() {
        double selfEarnings = getDeliveredValue() * 0.12;
        double subEarnings = (subordinates.stream()
                .mapToDouble(Worker::getEarnings)
                .sum()) * 0.25;

        return selfEarnings + subEarnings;
    }

    public void addWorker(Worker w) {
        subordinates.remove(w);
        subordinates.add(w);
    }

    public Set<Worker> getWorkers() {
        return Collections.unmodifiableSet(subordinates);
    }

    @Override
    public String toString() {
        return "PARTNER\n" + super.toString() + "\nEarnings: " + getEarnings();
    }

}
