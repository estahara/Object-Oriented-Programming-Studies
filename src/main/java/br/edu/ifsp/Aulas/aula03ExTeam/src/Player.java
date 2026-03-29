public class Player {

    private String name;
    private int number;
    private String position;
    private boolean isFielded;

    public Player(String name, int number, String position, boolean isFielded) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void field() {
        this.isFielded = true;
    }

    public void unfield() {
        this.isFielded = false;
    }

    public String getStateAsString() {
        return name + ", " + number + ", " + position + ", " + isFielded;
    }

}
