package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.service;

import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model.Partner;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model.Worker;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.persistence.Repository;

public class WorkerReportService {
    private final Repository<String, Worker> repo;

    public WorkerReportService(Repository<String, Worker> repo) {
        this.repo = repo;
    }

    public String reportOf(String id) {
        Worker w = repo.findById(id).orElseThrow();

        StringBuilder sb = new StringBuilder();

        buildReport(w, sb);

        return sb.toString();
    }

    private void buildReport(Worker worker, StringBuilder sb) {
        sb.append(String.format("[%s] %s     | Registration: %s | Amount in deliveries: R$%.2f | Earnings: R$%.2f",
                worker.getId(), worker.getName(), worker.getRegistrationDate(), worker.getDeliveredValue(), worker.getEarnings()))
                .append("\n");

        if (worker instanceof Partner partner) {
            for (Worker subordinate : partner.getWorkers()) {
                buildReport(subordinate, sb);
            }
        }
    }
}
