package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Imposto;

public class Main {
    static void main() {
        DeclaracaoDAO dao = new DeclaracaoDAO();

        GastoSaude saude = new GastoSaude(
                1,
                "Consulta",
                1800,
                "111111111",
                "CRM123"
        );

        GastoEducacao educacao = new GastoEducacao(
                2,
                "Faculdade",
                3000,
                "222222222",
                "USP"
        );

        DeclaracaoCompleta completa = new DeclaracaoCompleta(1, 70000, 5000);
        completa.addGasto(saude);
        completa.addGasto(educacao);

        DeclaracaoSimplificada simplificada = new DeclaracaoSimplificada(2,70000, 5000);
        dao.salvar(completa);
        dao.salvar(simplificada);

        System.out.println("=== LISTANDO ===");
        dao.listarTodos().forEach(System.out::println);

    }
}
