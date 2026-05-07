package main.java.br.edu.ifsp.Aulas.aula07.exCompany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employeeList = new ArrayList<>();

    public void hire(Employee e) {employeeList.add(e);}
    public void fire(String id) {
        employeeList.removeIf(e -> e.getId().equals(id));
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public List<Employee> getEmployees(String jobTitle) {
        return employeeList.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .toList();
    }

    public void pay(String id) {
        employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .ifPresent(e -> e.addPaycheck(LocalDate.now()));
    }

    public void increaseSalary(String id, double newSalary) {
        employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .ifPresent(e -> e.setSalary(newSalary));
    }

    public double averageSalary(String jobTitle) {
        return employeeList.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        return employeeList.stream()
                .filter(e ->
                                !e.getDateOfEmployment().isBefore(start)
                                &&
                                !e.getDateOfEmployment().isAfter(end)
                )
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

}
