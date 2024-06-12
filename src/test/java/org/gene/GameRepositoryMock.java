package org.gene;

import org.gene.dao.GameRepository;
import org.gene.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepositoryMock implements GameRepository {

    private List<Game> games = new ArrayList<>();

    @Override
    public void addGame(Game game) {
        games.add(game);
    }

    @Override
    public void deleteGame(int id) {
        games.removeIf(game -> game.getId() == id);
    }

    @Override
    public Game findGameByName(String name) {
        for (Game game : games) {
            if (game.getName().equals(name)) {
                return game;
            }
        }
        return null;
    }

    @Override
    public List<Game> filterGamesByPrice(double maxPrice) {
        List<Game> filteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getCost() <= maxPrice) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    @Override
    public List<Game> filterGamesByType(String type) {
        List<Game> filteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getDescription().contains(type)) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    @Override
    public List<Game> getAllGamesSortedByDate() {
        return games; // For simplicity, returning unsorted list.
    }

    @Override
    public List<Game> getAllGames() {
        return games;
    }
}
