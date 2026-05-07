package main.java.br.edu.ifsp.Aulas.aula07.exCompany;

import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private final LocalDate payday;
    private final double salary;

    public Paycheck(LocalDate payday, double salary) {
        this.payday = payday;
        this.salary = salary;
    }

    public LocalDate getPayday() { return payday; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Paycheck{" +
                "payday=" + payday +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paycheck paycheck = (Paycheck) o;
        return Double.compare(salary, paycheck.salary) == 0 && Objects.equals(payday, paycheck.payday);
    }

    @Override
    public int hashCode() { return Objects.hash(payday, salary); }
}
