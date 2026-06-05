package Aulas.aula10.factory;

import java.sql.*;

public class ConnectionFactory {

    private static final String URL = "jdbc:sqlite:football.db";
    private static Connection connection;

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);

            connection.createStatement().execute("PRAGMA foreign_keys = ON");
        }
        return connection;
    }


    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    public static PreparedStatement getPreparedStatementWithKeys(String sql) throws SQLException {
        return getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    public static void initializeDatabase() throws SQLException {
        String createTeams = """
                CREATE TABLE IF NOT EXISTS teams (
                    id             INTEGER PRIMARY KEY AUTOINCREMENT,
                    name           TEXT NOT NULL UNIQUE,
                    base_location  TEXT,
                    coach_name     TEXT,
                    captain_number INTEGER DEFAULT 0
                )
                """;

        String createPlayers = """
                CREATE TABLE IF NOT EXISTS players (
                    id         INTEGER PRIMARY KEY AUTOINCREMENT,
                    name       TEXT    NOT NULL,
                    number     INTEGER NOT NULL,
                    position   TEXT,
                    is_fielded INTEGER DEFAULT 0,
                    team_id    INTEGER NOT NULL,
                    FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE CASCADE,
                    UNIQUE(number, team_id)
                )
                """;

        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(createTeams);
            stmt.execute(createPlayers);
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

