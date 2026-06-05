package Aulas.aula10.view;

import Aulas.aula10.dto.PlayerDTO;
import Aulas.aula10.dto.TeamDTO;

import java.util.List;
import java.util.Scanner;

public class TeamView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("""
                
                ╔══════════════════════════════════╗
                ║      GERENCIADOR DE TIMES        ║
                ╠══════════════════════════════════╣
                ║  1.  Criar time                  ║
                ║  2.  Listar times                ║
                ║  3.  Selecionar time             ║
                ║  4.  Adicionar jogador           ║
                ║  5.  Remover jogador             ║
                ║  6.  Fazer substituição          ║
                ║  7.  Definir capitão             ║
                ║  8.  Ver jogadores em campo      ║
                ║  9.  Ver jogadores no banco      ║
                ║  10. Excluir time                ║
                ║  0.  Sair                        ║
                ╚══════════════════════════════════╝""");
        System.out.print("Opção: ");
    }


    public int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[AVISO] Digite um número inteiro válido.");
            }
        }
    }

    public boolean readBoolean(String prompt) {
        System.out.print(prompt + " (s/n): ");
        return scanner.nextLine().trim().equalsIgnoreCase("s");
    }


    public void showCurrentTeam(TeamDTO team) {
        System.out.printf("%n[Time ativo: %s  (ID:%d)]%n", team.name(), team.id());
    }

    public void showTeam(TeamDTO team) {
        System.out.println("\n── Detalhes do Time ──────────────────────────────");
        System.out.printf("  ID:       %d%n",  team.id());
        System.out.printf("  Nome:     %s%n",  team.name());
        System.out.printf("  Sede:     %s%n",  team.baseLocation());
        System.out.printf("  Técnico:  %s%n",  team.coachName());
        System.out.printf("  Capitão:  %s%n",
                team.captainNumber() > 0 ? "#" + team.captainNumber() : "Nenhum definido");
        System.out.println("──────────────────────────────────────────────────");
    }

    public void showTeams(List<TeamDTO> teams) {
        System.out.println("\n── Times Cadastrados ─────────────────────────────");
        if (teams.isEmpty()) {
            System.out.println("  Nenhum time encontrado.");
        } else {
            teams.forEach(t -> System.out.printf(
                    "  [%2d] %-25s | Sede: %s%n", t.id(), t.name(), t.baseLocation()));
        }
        System.out.println("──────────────────────────────────────────────────");
    }

    public void showPlayers(List<PlayerDTO> players, String label) {
        System.out.println("\n── " + label + " ──────────────────────────────────────");
        if (players.isEmpty()) {
            System.out.println("  Nenhum jogador.");
        } else {
            System.out.printf("  %-6s %-5s %-22s %-15s %s%n",
                    "ID", "Nº", "Nome", "Posição", "Status");
            System.out.println("  " + "─".repeat(65));
            players.forEach(p -> System.out.printf(
                    "  [%3d] #%-3d %-22s %-15s %s%n",
                    p.id(), p.number(), p.name(), p.position(),
                    p.isFielded() ? "✔ Em Campo" : "✗ Banco"));
        }
        System.out.println("──────────────────────────────────────────────────");
    }

    public void showMessage(String message) {
        System.out.println(">> " + message);
    }

    public void showError(String error) {
        System.out.println("[ERRO] " + error);
    }
}
