package main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp;

public class Game {

    private Player player1;
    private Player player2;

    private Hand hand;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.hand = new Hand(player1, player2);
    }

    public void play() {

        if (hand.isDone()) {
            String winner = hand.getWinner();

            if (winner != null) {
                if (winner.equals(player1.getName())) player1.incrementScore();
                else player2.incrementScore();

                System.out.println("Vencedor da mao: " + winner);
            }  else System.out.println("Mao empatada!");

            System.out.println(player1.getName() + " (" + player1.getScore() + ") x " +
                    player2.getName() + " (" + player2.getScore() + ")");

            hand = new Hand(player1, player2);

        }

        hand.playRound();

    }

    public boolean isDone() {
        if (player1.getScore() >= 12) return true;
        if (player2.getScore() >= 12) return true;

        return false;
    }

    public Player getWinner() {
        if (!isDone()) return null;

        if (player1.getScore() >= 12) return player1;
        if (player2.getScore() >= 12) return player2;

        return null;
    }

}
