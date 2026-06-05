package Aulas.aula10.controller;

import Aulas.aula10.dao.PlayerDAO;
import Aulas.aula10.dao.SQLitePlayerDAO;
import Aulas.aula10.dao.SQLiteTeamDAO;
import Aulas.aula10.dao.TeamDAO;
import Aulas.aula10.dto.PlayerDTO;
import Aulas.aula10.dto.TeamDTO;
import Aulas.aula10.model.Player;
import Aulas.aula10.model.Team;
import Aulas.aula10.view.TeamView;

import java.util.List;
import java.util.NoSuchElementException;

public class TeamController {
    private final TeamView view;
    private final TeamDAO teamDAO;
    private final PlayerDAO playerDAO;

    private TeamDTO currentTeam;

    public TeamController(TeamView view) {
        this.view      = view;
        this.teamDAO   = new SQLiteTeamDAO();
        this.playerDAO = new SQLitePlayerDAO();
    }

    // ── Loop principal ─────────────────────────────────────────────────────────

    public void start() {
        boolean running = true;
        while (running) {
            if (currentTeam != null) view.showCurrentTeam(currentTeam);
            view.showMenu();
            int option = view.readOption();
            try {
                switch (option) {
                    case 1  -> createTeam();
                    case 2  -> listTeams();
                    case 3  -> selectTeam();
                    case 4  -> addPlayer();
                    case 5  -> removePlayer();
                    case 6  -> makeSubstitution();
                    case 7  -> setCaptain();
                    case 8  -> showFieldedPlayers();
                    case 9  -> showBenchPlayers();
                    case 10 -> deleteTeam();
                    case 0  -> running = false;
                    default -> view.showError("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                view.showError(e.getMessage());
            }
        }
        view.showMessage("Sistema encerrado. Até logo!");
    }


    private void createTeam() {
        String name     = view.readLine("Nome do time: ");
        String location = view.readLine("Cidade sede: ");
        String coach    = view.readLine("Nome do técnico: ");

        Team team = new Team(name, location, coach);

        int id = teamDAO.save(toTeamDTO(0, team, 0));
        if (id > 0) {
            currentTeam = teamDAO.findOne(id).orElse(null);
            view.showMessage("Time '" + name + "' criado com sucesso! (ID: " + id + ")");
        } else {
            view.showError("Falha ao salvar o time.");
        }
    }

    private void listTeams() {
        view.showTeams(teamDAO.findAll());
    }

    private void selectTeam() {
        listTeams();
        int id = view.readInt("Digite o ID do time: ");
        currentTeam = teamDAO.findOne(id)
                .orElseThrow(() -> new NoSuchElementException("Time não encontrado com ID " + id));
        view.showTeam(currentTeam);
    }

    private void addPlayer() {
        requireTeamSelected();

        String name     = view.readLine("Nome do jogador: ");
        int number      = view.readInt("Número da camisa: ");
        String position = view.readLine("Posição (ex: goleiro, meia, atacante): ");
        boolean fielded = view.readBoolean("Escalar em campo agora?");

        List<PlayerDTO> currentPlayers = playerDAO.findByTeam(currentTeam.id());
        Team team = rebuildTeamFromDB(currentTeam, currentPlayers);

        Player newPlayer = new Player(name, number, position, fielded);
        team.addPlayer(newPlayer);

        int id = playerDAO.save(toPlayerDTO(newPlayer, currentTeam.id()));
        view.showMessage("Jogador '" + name + "' adicionado! (ID: " + id + ")");
    }

    private void removePlayer() {
        requireTeamSelected();
        showAllPlayers();

        int playerId = view.readInt("ID do jogador a remover: ");
        PlayerDTO playerDTO = playerDAO.findOne(playerId)
                .filter(p -> p.teamId() == currentTeam.id())
                .orElseThrow(() -> new NoSuchElementException("Jogador não encontrado neste time."));

        playerDAO.delete(playerId);

        // Se era o capitão, limpa o campo no banco
        if (currentTeam.captainNumber() == playerDTO.number()) {
            updateCaptain(0);
        }
        view.showMessage("Jogador '" + playerDTO.name() + "' removido.");
    }

    private void makeSubstitution() {
        requireTeamSelected();

        List<PlayerDTO> fielded = playerDAO.findByTeam(currentTeam.id())
                .stream().filter(PlayerDTO::isFielded).toList();
        List<PlayerDTO> bench = playerDAO.findByTeam(currentTeam.id())
                .stream().filter(p -> !p.isFielded()).toList();

        view.showPlayers(fielded, "Titulares (em campo)");
        int starterId = view.readInt("ID do titular que vai sair: ");
        PlayerDTO starterDTO = fielded.stream().filter(p -> p.id() == starterId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Titular inválido."));

        view.showPlayers(bench, "Substitutos (no banco)");
        int subId = view.readInt("ID do substituto que vai entrar: ");
        PlayerDTO subDTO = bench.stream().filter(p -> p.id() == subId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Substituto inválido."));

        // Aplica substituição: titular sai, substituto entra
        playerDAO.update(new PlayerDTO(starterDTO.id(), starterDTO.name(), starterDTO.number(),
                starterDTO.position(), false, starterDTO.teamId()));
        playerDAO.update(new PlayerDTO(subDTO.id(), subDTO.name(), subDTO.number(),
                subDTO.position(), true, subDTO.teamId()));

        view.showMessage(String.format("Substituição: %s ENTROU — %s saiu.",
                subDTO.name(), starterDTO.name()));
    }

    private void setCaptain() {
        requireTeamSelected();
        showAllPlayers();

        int playerId = view.readInt("ID do novo capitão: ");
        PlayerDTO playerDTO = playerDAO.findOne(playerId)
                .filter(p -> p.teamId() == currentTeam.id())
                .orElseThrow(() -> new NoSuchElementException("Jogador não encontrado neste time."));

        updateCaptain(playerDTO.number());
        view.showMessage("Capitão definido: " + playerDTO.name() + " (#" + playerDTO.number() + ")");
    }

    private void showFieldedPlayers() {
        requireTeamSelected();
        List<PlayerDTO> fielded = playerDAO.findByTeam(currentTeam.id())
                .stream().filter(PlayerDTO::isFielded).toList();
        view.showPlayers(fielded, "Em Campo — " + currentTeam.name());
    }

    private void showBenchPlayers() {
        requireTeamSelected();
        List<PlayerDTO> bench = playerDAO.findByTeam(currentTeam.id())
                .stream().filter(p -> !p.isFielded()).toList();
        view.showPlayers(bench, "Banco — " + currentTeam.name());
    }

    private void deleteTeam() {
        requireTeamSelected();
        String confirm = view.readLine(
                "Confirmar exclusão de '" + currentTeam.name() + "'? Digite 'sim' para confirmar: ");
        if ("sim".equalsIgnoreCase(confirm)) {
            teamDAO.delete(currentTeam.id());
            view.showMessage("Time excluído com sucesso.");
            currentTeam = null;
        } else {
            view.showMessage("Exclusão cancelada.");
        }
    }


    private void requireTeamSelected() {
        if (currentTeam == null) {
            throw new IllegalStateException(
                    "Nenhum time selecionado. Use a opção 3 para selecionar um time.");
        }
    }

    private void showAllPlayers() {
        view.showPlayers(playerDAO.findByTeam(currentTeam.id()),
                "Elenco — " + currentTeam.name());
    }

    private void updateCaptain(int captainNumber) {
        TeamDTO updated = new TeamDTO(currentTeam.id(), currentTeam.name(),
                currentTeam.baseLocation(), currentTeam.coachName(), captainNumber);
        teamDAO.update(updated);
        currentTeam = updated;
    }


    private TeamDTO toTeamDTO(int id, Team team, int captainNumber) {
        return new TeamDTO(id, team.getName(), team.getBaseLocation(),
                team.getCoachName(), captainNumber);
    }

    private PlayerDTO toPlayerDTO(Player player, int teamId) {
        return new PlayerDTO(0, player.getName(), player.getNumber(),
                player.getPosition(), player.isFielded(), teamId);
    }

    private Player fromPlayerDTO(PlayerDTO dto) {
        return new Player(dto.name(), dto.number(), dto.position(), dto.isFielded());
    }


    private Team rebuildTeamFromDB(TeamDTO teamDTO, List<PlayerDTO> playerDTOs) {
        Team team = new Team(teamDTO.name(), teamDTO.baseLocation(), teamDTO.coachName());
        playerDTOs.stream().map(this::fromPlayerDTO).forEach(team::addPlayer);
        if (teamDTO.captainNumber() > 0) {
            team.getPlayers().stream()
                    .filter(p -> p.getNumber() == teamDTO.captainNumber())
                    .findFirst()
                    .ifPresent(team::setCaptain);
        }
        return team;
    }
}
