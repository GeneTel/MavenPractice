package org.gene.dao;

import org.gene.model.Game;

import java.util.List;

public interface GameRepository {
    void addGame(Game game);
    void deleteGame(int id);
    Game findGameByName(String name);
    List<Game> filterGamesByPrice(double maxPrice);
    List<Game> filterGamesByType(String type);
    List<Game> getAllGamesSortedByDate();
    List<Game> getAllGames();
}
