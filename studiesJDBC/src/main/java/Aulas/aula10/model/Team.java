package Aulas.aula10.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private static final int MAX_PLAYERS = 18;

    private String name;
    private String baseLocation;
    private String coachName;
    private final List<Player> players = new ArrayList<>();
    private Player captain;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player player) {
        if (players.size() >= MAX_PLAYERS) {
            throw new IllegalStateException("O time já possui " + MAX_PLAYERS + " jogadores.");
        }
        if (players.stream().anyMatch(p -> p.getNumber() == player.getNumber())) {
            throw new IllegalArgumentException("Já existe jogador com o número: " + player.getNumber());
        }

        players.add(player);
    }

    public void removePlayer(Player player) {
        if (!players.remove(player)) {
            throw new IllegalArgumentException("Jogador não encontrado no time.");
        }
        if (captain != null && captain.equals(player)) {
            captain = null;
        }

        players.remove(player);
    }

    public void substitute(Player substitute, Player starter) {
        if (!players.contains(starter)) {
            throw new IllegalArgumentException("Titular não pertence ao time.");
        }
        if (!players.contains(substitute)) {
            throw new IllegalArgumentException("Substituto não pertence ao time.");
        }
        if (!starter.isFielded()) {
            throw new IllegalStateException("O titular já está no banco.");
        }
        if (substitute.isFielded()) {
            throw new IllegalStateException("O substituto já está no campo.");
        }

        starter.setFielded(false);
        substitute.setFielded(true);
    }

    public void setCaptain(Player captain) {
        if (!players.contains(captain)) {
            throw new IllegalArgumentException("O capitão deve pertencer ao time.");
        }
        this.captain = captain;
    }

    public Player[] getFieldedPlayers() {
        return players.stream().filter(Player::isFielded).toArray(Player[]::new);
    }

    public Player[] getOutfieldedPlayers() {
        return players.stream().filter(p -> !p.isFielded()).toArray(Player[]::new);
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getBaseLocation() {return baseLocation;}
    public void setBaseLocation(String baseLocation) {this.baseLocation = baseLocation;}
    public String getCoachName() {return coachName;}
    public void setCoachName(String coachName) {this.coachName = coachName;}
    public Player getCaptain() {return captain;}
    public List<Player> getPlayers() {return players;}

    @Override
    public String toString() {
        return String.format("Nome: %s | sede: %s | coach: %s | captain: %s | jogadores: %d",
                name, baseLocation, coachName, captain != null ? captain.getName() : "Nenhum", players.size());
    }

}
