package main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp;

import main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp.deck.Card;

public class Round {

    private String winner;

    public Round(String player1, Card card1,
                 String player2, Card card2,
                 Card vira)
    {
        int result = card1.compareValueTo(card2, vira);

        if (result > 0)
            winner = player1;
        else if (result < 0)
            winner = player2;
        else
            winner = null;
    }


    public String getWinner() {
        return winner;
    }

}
