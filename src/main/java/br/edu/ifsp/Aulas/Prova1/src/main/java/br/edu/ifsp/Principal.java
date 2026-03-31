package main.java.br.edu.ifsp.Aulas.Prova1.src.main.java.br.edu.ifsp;

public class Principal {
    void main() {

        Player p1 = new Player("Lucas");
        Player p2 = new Player("Alek");

        Game game = new Game(p1, p2);

        while (!game.isDone()) {
            game.play();
        }

        Player winner = game.getWinner();

        if (winner != null) System.out.println("Vencedor do jogo: " + winner.getName());
        else System.out.println("O jogo terminou em empate!");
    }
}
