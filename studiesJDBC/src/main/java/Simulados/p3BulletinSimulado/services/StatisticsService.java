package Simulados.p3BulletinSimulado.services;


import Simulados.p3BulletinSimulado.model.Bulletin;

import java.util.List;

public class StatisticsService {

    public StatisticsData createStatistics(List<Bulletin> bulletins) {
        if (bulletins == null || bulletins.isEmpty()) { return new StatisticsData(0, 0, 0.0); }

        int totalCases = bulletins.stream().mapToInt(Bulletin::getInfected).sum();

        int totalDeaths = bulletins.stream().mapToInt(Bulletin::getDeaths).sum();

        double avgIcu = bulletins.stream().mapToDouble(Bulletin::getIcuRatio).average().orElse(0.0);

        return new StatisticsData(totalCases, totalDeaths, avgIcu);
    }

}
