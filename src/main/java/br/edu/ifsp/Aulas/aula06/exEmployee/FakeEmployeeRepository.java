package main.java.br.edu.ifsp.Aulas.aula06.exEmployee;

public class FakeEmployeeRepository implements Repository<String, Employee> {

    private Employee[] employees = new Employee[10];
    private int count = 0;

    @Override
    public void save(Employee e) {
        employees[count++] = e;
    }

    @Override
    public Employee findById(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId().equals(id)) return employees[i];
        }
        return null;
    }
}
