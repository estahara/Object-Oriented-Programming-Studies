package main.java.br.edu.ifsp.Aulas.aula06.exZoo;

public class Zoo {
    static void main() {
        Animal[] jaulas = new Animal[10];

        jaulas[0] = new Owl();
        jaulas[1] = new Owl();
        jaulas[2] = new Owl();
        jaulas[3] = new Wolf();
        jaulas[4] = new Wolf();
        jaulas[5] = new Wolf();
        jaulas[6] = new Lion();
        jaulas[7] = new Lion();
        jaulas[8] = new Lion();
        jaulas[9] = new Owl();

        for (Animal a : jaulas) {
            a.makeSound();

            if (a instanceof Lion) {
                ((Lion) a).run();
            } else if (a instanceof Wolf) {
                ((Wolf) a).run();
            }

        }
    }
}
