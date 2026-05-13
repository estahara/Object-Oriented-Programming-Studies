package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller;

import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Employee;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.model.Reseller;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.persistence.InMemoryEmployeeRepository;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.persistence.Repository;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.service.EmployeeRegistrationService;
import main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.service.EmployeeReportService;

import java.time.LocalDate;

public class Main {
    static void main() {
        Repository<String, Employee> repo = new InMemoryEmployeeRepository();

        EmployeeRegistrationService registration = new EmployeeRegistrationService(repo);
        EmployeeReportService report = new EmployeeReportService(repo);

        repo.save(new Reseller("12312312312", "David A. Huffman", LocalDate.parse("1925-08-09"), 7000.00));

        registration.register("32132132131", "Augusta Ada Byron", LocalDate.parse("1852-11-27"), 3000.00, "12312312312");
        registration.register("21321321312", "Edsger Wybe Dijkstra", LocalDate.parse("1930-05-11"), 1520.00, "12312312312");

        System.out.println(report.reportOf("12312312312"));

    }
}
