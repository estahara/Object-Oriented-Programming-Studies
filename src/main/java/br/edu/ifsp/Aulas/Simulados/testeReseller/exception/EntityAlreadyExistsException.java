package main.java.br.edu.ifsp.Aulas.Simulados.testeReseller.exception;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
