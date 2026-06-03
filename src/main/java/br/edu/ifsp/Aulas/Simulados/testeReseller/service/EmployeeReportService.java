package main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.service;

import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model.Consultant;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model.Employee;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.persistence.Repository;

public class EmployeeReportService {
    private final Repository<String, Employee> repo;

    public EmployeeReportService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public String reportOf(String id) {
        Employee employee = repo.findById(id).orElseThrow();
        StringBuilder sb = new StringBuilder();

        buildReport(employee, sb);
        return sb.toString();
    }

    private void buildReport(Employee employee, StringBuilder sb) {
        sb.append(format(employee)).append("\n");

        if (employee instanceof Consultant consultant) {
            for (Employee subordinate : consultant.getEmployees()) {
                buildReport(subordinate, sb);
            }
        }
    }

    private String format(Employee e) {
        return String.format(
                "[%s] %s | Birthday: %s | Amount in Sales: US$%.2f | Commission: US$%.2f",
                e.getId(), e.getName(), e.getBirthDate(), e.getSoldValue(), e.getCommission()
        );
    }

}
