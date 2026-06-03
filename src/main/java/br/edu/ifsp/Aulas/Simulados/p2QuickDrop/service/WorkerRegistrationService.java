package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.service;

import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model.Deliverer;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model.Partner;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.model.Worker;
import main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.persistence.Repository;

import java.time.LocalDate;

public class WorkerRegistrationService {
    private final Repository<String, Worker> repo;

    public WorkerRegistrationService(Repository<String, Worker> repo) {
        this.repo = repo;
    }

    public void register(String id, String name, LocalDate registrationDate, double deliveredValue, String partnerInChargeId) {
        Deliverer newWorker = new Deliverer(id, name, registrationDate, deliveredValue, partnerInChargeId);
        repo.save(newWorker);

        if (partnerInChargeId != null) {
            Worker responsible = repo.findById(partnerInChargeId).orElseThrow();
            Partner partner;

            if (responsible instanceof Deliverer) {
                partner = new Partner(responsible.getId(), responsible.getName(),
                        responsible.getRegistrationDate(), responsible.getDeliveredValue(), responsible.getPartnerInChargeId());

                repo.update(partner);

                if (partner.getPartnerInChargeId() != null) {
                    Worker grandparentWorker = repo.findById(partner.getPartnerInChargeId()).orElseThrow();
                    if (grandparentWorker instanceof Partner grandparent)
                        grandparent.addWorker(partner);
                }
            } else {
                partner = (Partner) responsible;
            }

            partner.addWorker(newWorker);
        }

    }
}
