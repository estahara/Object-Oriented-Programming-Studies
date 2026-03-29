package main.java.br.edu.ifsp.Aulas.aula03;

public class Team {

    private String name;
    private String baseLocation;
    private String coachName;
    private Player[] players;
    private Player captain;
    private int count;


    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.players = new Player[18];
        this.count = 0;
    }

    public void addPlayer(Player player) {
        if (count >= 18)
            System.out.println("Erro!");
         else
            this.players[count++] = player;

    }
    
    public void removePlayer(Player player) {
        if (count == 0)
            System.out.println("Erro");
         else {
            for (int i = 0; i < count; i++) {
                if (this.players[i] == player)
                    this.players[i] = null;

            }
        }
    }

    public void substitute(Player substitute, Player starter) {
        substitute.field();
        starter.unfield();
    }

    public void setCaptain(Player captain) {

        for (int i = 0; i < count; i++) {
            if (players[i] == captain)
                this.captain = captain;
        }

    }

    public Player[] getFieldedPlayers() {

        Player[] fieldedPlayers = new Player[count];
        int j = 0;

        for (int i = 0; i < count; i++) {
            if (players[i].isFielded())
                fieldedPlayers[j++] = players[i];
        }

        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers() {
        Player[] outFieldedPlayers = new Player[count];
        int j =0;

        for (int i = 0; i < count; i++) {
            if (!players[i].isFielded())
                outFieldedPlayers[j++] = players[i];
        }

        return outFieldedPlayers;
    }

}
