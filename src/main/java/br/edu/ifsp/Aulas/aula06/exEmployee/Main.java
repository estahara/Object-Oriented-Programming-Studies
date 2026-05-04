package main.java.br.edu.ifsp.Aulas.aula06.exEmployee;

import java.time.LocalDate;

public class Main {
    static void main() {
        FakeEmployeeRepository repository = new FakeEmployeeRepository();

        RegisterEmployeeService registerService = new RegisterEmployeeService(repository);
        FindEmployeeService findService = new FindEmployeeService(repository);

        Employee e1 = new Employee("1", "Eduardo", "Developer", 8000.0, LocalDate.of(2020,1,10));
        Employee e2 = new Employee("2", "Alek", "Manager", 6700.0, LocalDate.of(2018,5,20));

        registerService.register(e1);
        registerService.register(e2);

        registerService.register(e1);

        Employee found = findService.findById("2");

        if (found != null) {
            System.out.println("Employee encontrado:");
            System.out.println("Nome: " + found.getName());
            System.out.println("Cargo: " + found.getJobTitle());
            System.out.println("Salário: " + found.getSalary());
            System.out.println("Anos de serviço: " + found.getYearsOfService());
            System.out.println("Bônus: " + found.calculateBonus());
        } else {
            System.out.println("Employee não encontrado!");
        }
    }
}
