package Aulas.aula10.dao;

import Aulas.aula10.dto.PlayerDTO;
import Aulas.aula10.factory.ConnectionFactory;
import Aulas.aula10.model.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLitePlayerDAO implements PlayerDAO{
    @Override
    public int save(PlayerDTO dto) {
        String sql = "INSERT INTO players (name, number, position, is_fielded, team_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatementWithKeys(sql)) {
            stmt.setString(1, dto.name());
            stmt.setInt(2, dto.number());
            stmt.setString(3, dto.position());
            stmt.setInt(4, dto.isFielded() ? 1 : 0);
            stmt.setInt(5, dto.teamId());
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Optional<PlayerDTO> findOne(int id) {
        String sql = "SELECT * FROM players WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<PlayerDTO> findByTeam(int teamId) {
        String sql = "SELECT * FROM players WHERE team_id = ? ORDER BY number";
        List<PlayerDTO> players = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            stmt.setInt(1, teamId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) players.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public void update(PlayerDTO dto) {
        String sql = "UPDATE players SET name = ?, number = ?, position = ?, is_fielded = ? " +
                "WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            stmt.setString(1, dto.name());
            stmt.setInt(2, dto.number());
            stmt.setString(3, dto.position());
            stmt.setInt(4, dto.isFielded() ? 1 : 0);
            stmt.setInt(5, dto.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM players WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Converte uma linha do ResultSet em um PlayerDTO. */
    private PlayerDTO mapRow(ResultSet rs) throws SQLException {
        return new PlayerDTO(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("number"),
                rs.getString("position"),
                rs.getInt("is_fielded") == 1,
                rs.getInt("team_id")
        );
    }

}
