package org.gene.dao;



import org.gene.connection.ConnectionSingleton;
import org.gene.model.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GameRepositoryImplementation implements GameRepository {

    @Override
    public void addGame(Game game) {
        try (Connection connection = ConnectionSingleton.getInstance().getConnection()) {
            String sql = "INSERT INTO games (name, release_date, rating, cost, description, creation_date) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, game.getName());
                statement.setDate(2, new java.sql.Date(game.getReleaseDate().getTime()));
                statement.setDouble(3, game.getRating());
                statement.setDouble(4, game.getCost());
                statement.setString(5, game.getDescription());
                statement.setDate(6, new java.sql.Date(game.getCreationDate().getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGame(int id) {
        try (Connection connection = ConnectionSingleton.getInstance().getConnection()) {
            String sql = "DELETE FROM games WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Game findGameByName(String name) {
        Game game = null;
        try (Connection connection = ConnectionSingleton.getInstance().getConnection()) {
            String sql = "SELECT * FROM games WHERE name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        game = new Game(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("release_date"),
                                resultSet.getDouble("rating"),
                                resultSet.getDouble("cost"),
                                resultSet.getString("description"),
                                resultSet.getDate("creation_date")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
    }

    @Override
    public List<Game> filterGamesByPrice(double maxPrice) {
        List<Game> games = new ArrayList<>();
        try (Connection connection = ConnectionSingleton.getInstance().getConnection()) {
            String sql = "SELECT * FROM games WHERE cost <= ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDouble(1, maxPrice);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        games.add(new Game(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("release_date"),
                                resultSet.getDouble("rating"),
                                resultSet.getDouble("cost"),
                                resultSet.getString("description"),
                                resultSet.getDate("creation_date")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> filterGamesByType(String type) {
        List<Game> games = new ArrayList<>();
        try (Connection connection = ConnectionSingleton.getInstance().getConnection()) {
            String sql = "SELECT * FROM games WHERE description LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "%" + type + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        games.add(new Game(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("release_date"),
                                resultSet.getDouble("rating"),
                                resultSet.getDouble("cost"),
                                resultSet.getString("description"),
                                resultSet.getDate("creation_date")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> getAllGamesSortedByDate() {
        List<Game> games = new ArrayList<>();
        try (Connection connection = ConnectionSingleton.getInstance().getConnection()) {
            String sql = "SELECT * FROM games ORDER BY creation_date";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        games.add(new Game(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("release_date"),
                                resultSet.getDouble("rating"),
                                resultSet.getDouble("cost"),
                                resultSet.getString("description"),
                                resultSet.getDate("creation_date")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        try (Connection connection = ConnectionSingleton.getInstance().getConnection()) {
            String sql = "SELECT * FROM games";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        games.add(new Game(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getDate("release_date"),
                                resultSet.getDouble("rating"),
                                resultSet.getDouble("cost"),
                                resultSet.getString("description"),
                                resultSet.getDate("creation_date")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }
}
