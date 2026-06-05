package Aulas.aula10.dao;

import Aulas.aula10.dto.TeamDTO;
import Aulas.aula10.factory.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLiteTeamDAO implements TeamDAO{
    @Override
    public int save(TeamDTO dto) {
        String sql = "INSERT INTO teams (name, base_location, coach_name, captain_number) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatementWithKeys(sql)) {
            stmt.setString(1, dto.name());
            stmt.setString(2, dto.baseLocation());
            stmt.setString(3, dto.coachName());
            stmt.setInt(4, dto.captainNumber());
            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Optional<TeamDTO> findOne(int id) {
        String sql = "SELECT * FROM teams WHERE id = ?";
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
    public Optional<TeamDTO> findByName(String name) {
        String sql = "SELECT * FROM teams WHERE name = ?";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TeamDTO> findAll() {
        String sql = "SELECT * FROM teams ORDER BY name";
        List<TeamDTO> teams = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) teams.add(mapRow(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    public void update(TeamDTO dto) {
        String sql = "UPDATE teams SET name = ?, base_location = ?, coach_name = ?, " +
                "captain_number = ? WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            stmt.setString(1, dto.name());
            stmt.setString(2, dto.baseLocation());
            stmt.setString(3, dto.coachName());
            stmt.setInt(4, dto.captainNumber());
            stmt.setInt(5, dto.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM teams WHERE id = ?";
        try (PreparedStatement stmt = ConnectionFactory.getPreparedStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private TeamDTO mapRow(ResultSet rs) throws SQLException {
        return new TeamDTO(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("base_location"),
                rs.getString("coach_name"),
                rs.getInt("captain_number")
        );
    }
}
