package main.java.br.edu.ifsp.Aulas.aula04;

public class EmailUtils {

    public static boolean verificaEmail(String nomeEmail) {
        return nomeEmail.endsWith("@gmail.com") ||
                nomeEmail.endsWith("@hotmail.com") ||
                nomeEmail.endsWith("@outlook.com");
    }

}
