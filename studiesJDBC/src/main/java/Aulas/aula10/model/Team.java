package Aulas.aula10.model;

public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player[] team = new Player[18];
    private int playerCount = 0;
    private Player teamCaptain;

    public Team(String name, String baseLocation, String coachName, Player[] team, int playerCount) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player player) {
        if (playerCount < 18) { team[playerCount++] = player; }
    }

    public void removePlayer(Player player) {
        if (playerCount != 0) {

            for (int i = 0; i < playerCount; i++) {
                if (player.equals(team[i])) {
                    if (playerCount == 1 || i == 17) {
                        team[i] = null;
                        playerCount--;
                        break;
                    } else {
                        for (int j = i + 1; j < playerCount; j++) {
                            team[i++] = team[j];
                        }
                        team[playerCount - 1] = null;
                        playerCount--;
                        break;
                    }
                }
            }
        }
    }

    public void substitute(Player substitute, Player starter) {
        if (playerCount != 0) {
            for (int i = 0; i < playerCount; i++) {
                if (team[i].equals(starter)) {
                    team[i] = substitute;
                    starter.setFielded(false);
                    substitute.setFielded(true);
                    break;
                }
            }
        }

    }

    public void setCaptain(Player captain) {
        teamCaptain = captain;
    }

    public Player[] getFieldedPlayers() {
        Player[] fieldedPlayers = new Player[18];
        int countFieldedPlayers = 0;

        for (int i = 0; i < playerCount; i++) {
            if (team[i].isFielded()) {
                fieldedPlayers[countFieldedPlayers++] = team[i];
            }
        }

        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers() {
        Player[] outfieldedPlayers = new Player[18];
        int countOutfieldedPlayers = 0;

        for (int i = 0; i < playerCount; i++) {
            if (!team[i].isFielded()) {
                outfieldedPlayers[countOutfieldedPlayers++] = team[i];
            }
        }

        return outfieldedPlayers;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getBaseLocation() {return baseLocation;}
    public void setBaseLocation(String baseLocation) {this.baseLocation = baseLocation;}
    public String getCoachName() {return coachName;}
    public void setCoachName(String coachName) {this.coachName = coachName;}
    public Player getTeamCaptain() {return teamCaptain;}
    public void setTeamCaptain(Player teamCaptain) {this.teamCaptain = teamCaptain;}
}
