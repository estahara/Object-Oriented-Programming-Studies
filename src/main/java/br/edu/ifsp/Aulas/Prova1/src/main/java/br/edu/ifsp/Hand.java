package main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp;

import main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp.deck.Card;
import main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp.deck.Deck;

public class Hand {

    private Card vira;

    private Player player1;
    private Player player2;

    private Round[] rounds;
    private int roundCount;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        this.rounds = new Round[3];
        this.roundCount = 0;

        Deck deck = new Deck();
        deck.shuffle();

        this.vira = deck.takeOne();

        player1.setCards(deck.take(3));
        player2.setCards(deck.take(3));
    }

    public void playRound() {

        Round round = new Round(player1.getName(), player1.chooseCard(),
                                player2.getName(), player2.chooseCard(),
                                vira);

        if (round.getWinner() == null)
            System.out.println("Empate na rodada!");
        else
            System.out.println("O vencedor é: " + round.getWinner());

        rounds[roundCount++] = round;

    }

    public boolean isDone() {

        int p1Wins = 0;
        int p2Wins = 0;

        for (int i = 0; i < roundCount; i++) {
            String winner = rounds[i].getWinner();

            if (winner == null) continue;

            if (winner.equals(player1.getName()))
                p1Wins++;
            else if (winner.equals(player2.getName()))
                p2Wins++;

        }

        if (p1Wins == 2 || p2Wins == 2)
            return true;

        return roundCount == 3;

    }

    public String getWinner() {
        if (!isDone())
            return null;

        String r1 = rounds[0].getWinner();
        String r2;
        if (rounds[1] != null)
            r2 = rounds[1].getWinner();
        else
            r2 = null;

        String r3;
        if (rounds[2] != null)
            r3 = rounds[2].getWinner();
        else
            r3 = null;

        int p1Wins = 0;
        int p2Wins = 0;

        for (int i = 0; i < roundCount; i++) {
            String w = rounds[i].getWinner();

            if (w == null) continue;

            if (w.equals(player1.getName()))
                p1Wins++;
            else if (w.equals(player2.getName()))
                p2Wins++;
        }

        if (p1Wins > p2Wins)
            return player1.getName();
        if (p2Wins > p1Wins)
            return player2.getName();

        if (r1 == null && r2 == null && r3 == null) return null;
        if (r1 == null) return r2;
        if (r2 == null) return r1;
        if (r3 == null) return r1;

        return null;

    }

}
