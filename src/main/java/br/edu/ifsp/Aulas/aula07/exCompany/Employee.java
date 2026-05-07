package main.java.br.edu.ifsp.Aulas.aula07.exCompany;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Employee {

    private List<Paycheck> paychecks;
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService() {
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public void addPaycheck(LocalDate payday) {
        paychecks.add(new Paycheck(payday, salary));
    }

    public void removePaycheck(Paycheck paycheck) {
        paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaychecks() {
        return paychecks.iterator();
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getJobTitle() {return jobTitle;}
    public void setJobTitle(String jobTitle) {this.jobTitle = jobTitle;}
    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}
    public LocalDate getDateOfEmployment() {return dateOfEmployment;}
    public void setDateOfEmployment(LocalDate dateOfEmployment) {this.dateOfEmployment = dateOfEmployment;}

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
        return """
                ------------------------
                ID: %s
                Nome: %s
                Cargo: %s
                Salário: %.2f
                Data contratação: %s
                ------------------------
                """.formatted(id, name, jobTitle, salary, dateOfEmployment);
    }
}
