package Aulas.aula10.dao;

import Aulas.aula10.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerDAO {

    int save(PlayerDTO dto);

    Optional<PlayerDTO> findOne(int id);

    List<PlayerDTO> findByTeam(int teamId);

    void update(PlayerDTO dto);

    void delete(int id);

}
