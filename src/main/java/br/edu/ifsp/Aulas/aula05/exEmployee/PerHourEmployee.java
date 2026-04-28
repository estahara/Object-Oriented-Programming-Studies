package main.java.br.edu.ifsp.Aulas.aula05.exEmployee;

import java.time.LocalDate;

public final class PerHourEmployee extends Employee {
    private double hourlyRate;
    private int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, int workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return workedHour * hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getWorkedHour() {
        return workedHour;
    }

    public void setWorkedHour(int workedHour) {
        this.workedHour = workedHour;
    }

    @Override
    public String toString() {
        return super.toString() + ", hourlyrate=" + this.getHourlyRate() + ", workedHour=" + this.getWorkedHour();
    }
}
