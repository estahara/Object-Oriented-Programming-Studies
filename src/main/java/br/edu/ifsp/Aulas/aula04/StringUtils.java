package main.java.br.edu.ifsp.Aulas.aula04;

public class StringUtils {

    public static int appears(String phrase, String palavra) {
        int count = 0;

        String[] sentence = phrase.split("\\s+");
        for (String word : sentence) {
            if (word.equalsIgnoreCase(palavra))
                count++;
        }

        return count;

    }

}
