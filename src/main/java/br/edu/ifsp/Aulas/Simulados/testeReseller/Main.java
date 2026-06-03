package main.java.br.edu.ifsp.Aulas.Simulados.testeReseller;

import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.model.Employee;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.persistence.InMemoryEmployeeRepository;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.persistence.Repository;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.service.EmployeeRegistrationService;
import main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.service.EmployeeReportService;

import java.time.LocalDate;

public class Main {
    static void main() {
        Repository<String, Employee> repo = new InMemoryEmployeeRepository();

        EmployeeRegistrationService registration = new EmployeeRegistrationService(repo);
        EmployeeReportService report = new EmployeeReportService(repo);

        registration.register("12312312312", "David A. Huffman", LocalDate.parse("1925-08-09"), 7000.00, null);
        registration.register("32132132131", "Augusta Ada Byron", LocalDate.parse("1852-11-27"), 3000.0, "12312312312");

        registration.register("21321321313", "Edsger Wybe Dijkstra",
                LocalDate.parse("1930-05-11"), 1520.0, "12312312312");

        registration.register("45645645646", "Alan Mathison Turing",
                LocalDate.parse("1912-06-23"), 780.0, "32132132131");

        registration.register("90219021902", "Donald Ervin Knuth",
                LocalDate.parse("1938-01-10"), 432.0, "45645645646");

        registration.register("54654654654", "Grace Murray Hopper",
                LocalDate.parse("1906-12-09"), 432.0, "21321321313");

        registration.register("65465465464", "John von Neumann",
                LocalDate.parse("1903-12-28"), 300.0, "45645645646");

        String relatorio = report.reportOf("12312312312");
        System.out.println(relatorio);
    }
}
