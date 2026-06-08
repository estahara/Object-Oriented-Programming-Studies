package Simulados.p3BulletinSimulado.persistence;



import Simulados.p3BulletinSimulado.dao.BulletinDao;
import Simulados.p3BulletinSimulado.model.Bulletin;
import Simulados.p3BulletinSimulado.model.State;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SqliteBulletinDao implements BulletinDao<Bulletin> {

    private record BulletinDTO (
            int id,
            String city,
            String state,
            int infected,
            int deaths,
            double icuRatio,
            String date
    ) {}

    @Override
    public void insert(Bulletin b) {
        String sql = "INSERT INTO bulletin (city, state, infected, deaths, icu_ratio, date) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ConnectionFactory.prepareStatement(sql)) {
            ps.setString(1, b.getCity());
            ps.setString(2, b.getState().toString());
            ps.setInt(3, b.getInfected());
            ps.setInt(4, b.getDeaths());
            ps.setDouble(5, b.getIcuRatio());
            ps.setString(6, b.getDate().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir boletim: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM bulletin WHERE id = ?";

        try (PreparedStatement ps = ConnectionFactory.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar boletim: " + e.getMessage(), e);
        }

    }

    @Override
    public void update(Bulletin b) {
        String sql = "UPDATE bulletin SET city = ?, state = ?, infected = ?, deaths = ?, icu_ratio = ?, date = ? " +
                "WHERE id = ?";

        try (PreparedStatement ps = ConnectionFactory.prepareStatement(sql)) {
            ps.setString(1, b.getCity());
            ps.setString(2, b.getState().toString());
            ps.setInt(3, b.getInfected());
            ps.setInt(4, b.getDeaths());
            ps.setDouble(5, b.getIcuRatio());
            ps.setString(6, b.getDate().toString());
            ps.setInt(7, b.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao dar update no boletim: " + e.getMessage(), e);
        }

    }

    @Override
    public boolean existsById(int id) {
        String sql = "SELECT id FROM bulletin WHERE id = ?";

        try (PreparedStatement ps = ConnectionFactory.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao encontrar id: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Bulletin> findAll() {
        List<Bulletin> bulletins = new ArrayList<>();

        String sql = "SELECT * FROM bulletin";

        try (PreparedStatement ps = ConnectionFactory.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BulletinDTO dto = new BulletinDTO(
                        rs.getInt("id"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getInt("infected"),
                        rs.getInt("deaths"),
                        rs.getDouble("icu_ratio"),
                        rs.getString("date")
                );

                bulletins.add(toModel(dto));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao encontrar todos: " + e.getMessage(), e);
        }


        return bulletins;
    }

    private Bulletin toModel(BulletinDTO dto) {
        return new Bulletin(
                dto.id(),
                dto.city(),
                State.fromName(dto.state()),
                dto.infected(),
                dto.deaths(),
                dto.icuRatio(),
                LocalDate.parse(dto.date())
        );
    }
}
