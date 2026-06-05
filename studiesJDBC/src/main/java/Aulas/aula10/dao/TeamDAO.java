package Aulas.aula10.dao;

import Aulas.aula10.dto.TeamDTO;

import java.util.List;
import java.util.Optional;

public interface TeamDAO {

    int save(TeamDTO dto);

    Optional<TeamDTO> findOne(int id);

    Optional<TeamDTO> findByName(String name);

    List<TeamDTO> findAll();

    void update(TeamDTO dto);

    void delete(int id);

}
