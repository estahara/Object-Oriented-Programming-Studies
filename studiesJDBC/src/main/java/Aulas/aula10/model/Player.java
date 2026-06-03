package Aulas.aula10.model;

import java.util.Objects;

public class Player {
    private String name;
    private final int number;
    private String position;
    private boolean isFielded;

    public Player(String name, int number, String position, boolean isFielded) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return number == player.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Number: %d | Position: %s | isFielded: %b",
                name, number, position, isFielded);
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getNumber() {return number;}
    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}
    public boolean isFielded() {return isFielded;}
    public void setFielded(boolean fielded) {isFielded = fielded;}
}
