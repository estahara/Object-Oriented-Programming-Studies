package Simulados.p3BulletinSimulado.services;


import Simulados.p3BulletinSimulado.model.Bulletin;
import Simulados.p3BulletinSimulado.model.State;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FilterBulletinService {

    public List<Bulletin> filter(List<Bulletin> bulletins, String city, State state, LocalDate startDate, LocalDate endDate) {

        if (bulletins == null) {throw new IllegalArgumentException("Os bulletins não podem ser nulos!"); }

        return bulletins.stream()
                .filter(b -> city == null || city.isBlank() ||
                        b.getCity().toLowerCase().contains(city.toLowerCase()))

                .filter(b -> state == null || b.getState() == state)

                .filter(b -> startDate == null || !b.getDate().isBefore(startDate))

                .filter(b -> endDate == null || !b.getDate().isAfter(endDate))
                .collect(Collectors.toList());

    }

}
