package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Worker permits Deliverer, Partner {
    private final String id;
    private String name;
    private LocalDate registrationDate;
    private double deliveredValue;
    private String partnerInChargeId;

    public Worker(String id, String name, LocalDate registrationDate, double deliveredValue, String partnerInChargeId) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
        this.deliveredValue = deliveredValue;
        this.partnerInChargeId = partnerInChargeId;
    }

    public abstract double getEarnings();
    public String getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public LocalDate getRegistrationDate() {return registrationDate;}
    public void setRegistrationDate(LocalDate registrationDate) {this.registrationDate = registrationDate;}
    public double getDeliveredValue() {return deliveredValue;}
    public void setDeliveredValue(double deliveredValue) {this.deliveredValue = deliveredValue;}
    public String getPartnerInChargeId() {return partnerInChargeId;}
    public void setPartnerInChargeId(String partnerInChargeId) {this.partnerInChargeId = partnerInChargeId;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s    | Registration: %s | Amount in deliveries: %.2f | Partner in charge Id: %s",
                id, name, registrationDate, deliveredValue, partnerInChargeId);
    }
}
