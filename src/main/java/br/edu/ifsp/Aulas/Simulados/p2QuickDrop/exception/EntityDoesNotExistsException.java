package main.java.br.edu.ifsp.Aulas.Simulados.p2QuickDrop.exception;

public class EntityDoesNotExistsException extends RuntimeException {
    public EntityDoesNotExistsException(String message) {
        super(message);
    }
}
