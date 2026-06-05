package Aulas.aula10.dto;

public record PlayerDTO(
        int id,
        String name,
        int number,
        String position,
        boolean isFielded,
        int teamId
) {}


