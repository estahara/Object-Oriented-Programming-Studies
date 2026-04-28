package main.java.br.edu.ifsp.Aulas.aula05.exEmployee;

import java.time.LocalDate;

public class Main {
    static void main() {
        LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);
        FullTimeEmployee t = new FullTimeEmployee("01", "Eduardo", "Software Engineer", fiveYearsAgo, 5000.00);
        PerHourEmployee h = new PerHourEmployee("02", "Alek", "Archaeologist", fiveYearsAgo, 100.00, 5);

        System.out.println(t);
        System.out.println(h);
    }
}
