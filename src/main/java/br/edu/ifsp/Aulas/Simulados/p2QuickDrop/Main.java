package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop;

import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model.Worker;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.persistence.InMemoryWorkerRepository;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.persistence.Repository;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.service.WorkerRegistrationService;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.service.WorkerReportService;

import java.time.LocalDate;


public class Main {
    static void main() {
        Repository<String, Worker> repo = new InMemoryWorkerRepository();

        WorkerRegistrationService register = new WorkerRegistrationService(repo);
        WorkerReportService report = new WorkerReportService(repo);

        register.register("11111111111", "Leonhard Euler", LocalDate.parse("2020-04-15"), 8500.00, null);
        register.register("22222222222", "Carl Friedrich Gauss", LocalDate.parse("2020-06-20"), 4200.0, "11111111111");
        register.register("33333333333", "Isaac Newton", LocalDate.parse("2020-07-10"), 2100.0, "11111111111");
        register.register("44444444444", "Blaise Pascal", LocalDate.parse("2020-09-05"),  950.0, "22222222222");
        register.register("55555555555", "Pierre de Fermat", LocalDate.parse("2021-01-12"),  640.0, "44444444444");
        register.register("66666666666", "René Descartes", LocalDate.parse("2021-02-28"),  520.0, "33333333333");
        register.register("77777777777", "Gottfried Leibniz", LocalDate.parse("2021-03-17"),  380.0, "44444444444");

        System.out.println(report.reportOf("11111111111"));
    }
}
