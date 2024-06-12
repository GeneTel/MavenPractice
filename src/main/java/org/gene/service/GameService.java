package org.gene.service;


import org.gene.dao.GameRepository;
import org.gene.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameService implements GameRepository {
    private List<Game> games;

    public GameService() {
        games = new ArrayList<>();
    }

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
        return games.stream().filter(game -> game.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
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
        // Assuming 'type' is a property of Game (not shown in Game class above, needs to be added)
        List<Game> filteredGames = new ArrayList<>();
        for (Game game : games) {
            if (game.getType().equalsIgnoreCase(type)) {
                filteredGames.add(game);
            }
        }
        return filteredGames;
    }

    @Override
    public List<Game> getAllGamesSortedByDate() {
        games.sort((g1, g2) -> g1.getCreationDate().compareTo(g2.getCreationDate()));
        return new ArrayList<>(games);
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }
}
