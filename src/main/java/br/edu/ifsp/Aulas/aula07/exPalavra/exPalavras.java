package main.java.br.edu.ifsp.Aulas.aula07.exPalavra;

import java.util.*;

public class exPalavras {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String palavra;

        List<String> palavras = new ArrayList<>();
        Map<String, Integer> frequencia = new HashMap<>();

        while (!(palavra = scanner.nextLine()).isEmpty()) {
            palavras.add(palavra);
            frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
        }

        Set<String> palavrasUnicas = new HashSet<>(palavras);
        List<String> palavrasUnicasOrdenadas = new ArrayList<>(palavrasUnicas);
        Collections.sort(palavrasUnicasOrdenadas);

        for (String p : palavras) System.out.println(p);
        System.out.println("------------------");
        for (String p : palavrasUnicasOrdenadas) System.out.println(p);
        System.out.println("------------------");
        for (Map.Entry<String, Integer> entry : frequencia.entrySet()) System.out.println(entry.getKey() + " -> " + entry.getValue());

        scanner.close();

    }
}
