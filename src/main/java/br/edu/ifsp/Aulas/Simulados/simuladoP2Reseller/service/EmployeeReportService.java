package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.service;

import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Consultant;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Employee;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.persistence.Repository;

public class EmployeeReportService {
    private final Repository<String, Employee> repo;

    public EmployeeReportService(Repository<String, Employee> repo) {
        this.repo = repo;
    }

    public String reportOf(String id) {
        Employee root = repo.findById(id).orElseThrow();
        StringBuilder sb = new StringBuilder();
        buildReport(root, sb, 0);
        return sb.toString();
    }

    private void buildReport(Employee e, StringBuilder sb, int level) {
        String indent = "  ".repeat(level);
        sb.append(indent)
                .append("[" + e.getId())
                .append("] " + e.getName())
                .append(" | Birthday: ")
                .append(e.getBirthDate())
                .append(" | Amount in sales: US$")
                .append(String.format("%.2f", e.getSoldValue()))
                .append(" | Commission: US$ ")
                .append(String.format("%.2f", e.getCommission()))
                .append("\n");

        if (e instanceof Consultant c) {
            for (Employee sub : c.getEmployees()) {
                buildReport(sub, sb, level + 1);
            }
        }
    }

}
