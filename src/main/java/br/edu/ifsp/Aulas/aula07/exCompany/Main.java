package main.java.br.edu.ifsp.Aulas.aula07.exCompany;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        Company company = new Company();

        int option;

        do {

            System.out.println("""
                    
                    ===== MENU =====
                    1 - Contratar funcionário
                    2 - Demitir funcionário
                    3 - Listar funcionários
                    4 - Buscar funcionários por cargo
                    5 - Pagar funcionário
                    6 - Aumentar salário
                    7 - Média salarial por cargo
                    8 - Média salarial por período
                    0 - Sair
                    """);

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {

                case 1 -> {

                    System.out.print("ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Nome: ");
                    String name = scanner.nextLine();

                    System.out.print("Cargo: ");
                    String job = scanner.nextLine();

                    System.out.print("Salário: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    System.out.print("Data contratação (AAAA-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    Employee employee =
                            new Employee(id, name, job, salary, date);

                    company.hire(employee);

                    System.out.println("Funcionário contratado!");
                }

                case 2 -> {

                    System.out.print("ID do funcionário: ");
                    String id = scanner.nextLine();

                    company.fire(id);

                    System.out.println("Funcionário removido!");
                }

                case 3 -> {

                    company.getEmployees()
                            .forEach(System.out::println);
                }

                case 4 -> {

                    System.out.print("Cargo: ");
                    String job = scanner.nextLine();

                    company.getEmployees(job)
                            .forEach(System.out::println);
                }

                case 5 -> {

                    System.out.print("ID do funcionário: ");
                    String id = scanner.nextLine();

                    company.pay(id);

                    System.out.println("Pagamento realizado!");
                }

                case 6 -> {

                    System.out.print("ID do funcionário: ");
                    String id = scanner.nextLine();

                    System.out.print("Novo salário: ");
                    double salary = Double.parseDouble(scanner.nextLine());

                    company.increaseSalary(id, salary);

                    System.out.println("Salário atualizado!");
                }

                case 7 -> {

                    System.out.print("Cargo: ");
                    String job = scanner.nextLine();

                    double avg = company.averageSalary(job);

                    System.out.println("Média salarial: " + avg);
                }

                case 8 -> {

                    System.out.print("Data inicial (AAAA-MM-DD): ");
                    LocalDate start = LocalDate.parse(scanner.nextLine());

                    System.out.print("Data final (AAAA-MM-DD): ");
                    LocalDate end = LocalDate.parse(scanner.nextLine());

                    double avg = company.averageSalary(start, end);

                    System.out.println("Média salarial: " + avg);
                }

                case 0 -> System.out.println("Encerrando...");

                default -> System.out.println("Opção inválida!");
            }

        } while (option != 0);

        scanner.close();
    }
}
