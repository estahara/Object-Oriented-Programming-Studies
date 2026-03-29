void main() {

    Team time = new Team("FootballClub", "7street", "Daniel");
    Player player = new Player("Luis", 1, "goalKeeper", true);

    time.addPlayer(player);
    String state = player.getStateAsString();
    System.out.println(state);
}