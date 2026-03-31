package main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp;

import main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp.deck.Card;

public class Player {

    private String name;
    private int score;
    private Card[] cards;
    private int cardsCount;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
        this.cardsCount = 3;
    }

    public Card chooseCard() {
        for (int i = 0; i < cardsCount; i++) {
            if (cards[i] != null) {
                Card chosen = cards[i];
                cards[i] = null;
                return chosen;
            }
        }

        return null;
    }

    public void incrementScore() {
        score++;
    }
}
