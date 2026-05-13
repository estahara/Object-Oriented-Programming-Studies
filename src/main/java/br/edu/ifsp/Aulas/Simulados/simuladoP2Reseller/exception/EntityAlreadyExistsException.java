package main.java.br.edu.ifsp.Aulas.Simulados.simuladoP2Reseller.exception;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
