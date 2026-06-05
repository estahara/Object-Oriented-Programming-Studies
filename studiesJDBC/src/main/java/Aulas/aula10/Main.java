package Aulas.aula10;

import Aulas.aula10.controller.TeamController;
import Aulas.aula10.factory.ConnectionFactory;
import Aulas.aula10.view.TeamView;

public class Main {
    static void main() {
        try {
            ConnectionFactory.initializeDatabase();
            TeamView view = new TeamView();
            TeamController controller = new TeamController(view);
            controller.start();
        } catch (Exception e) {
            System.err.println("Erro ao iniciar a aplicação: " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection();
        }
    }
}

