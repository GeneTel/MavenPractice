package org.gene;

import org.gene.dao.GameRepository;
import org.gene.model.Game;
import org.gene.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GameServiceTest {

    private GameRepository gameRepository;
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        // Initialize a mock repository
        gameRepository = new GameRepository() {
            @Override
            public void addGame(Game game) {

            }

            @Override
            public void deleteGame(int id) {

            }

            @Override
            public Game findGameByName(String name) {
                return null;
            }

            @Override
            public List<Game> filterGamesByPrice(double maxPrice) {
                return null;
            }

            @Override
            public List<Game> filterGamesByType(String type) {
                return null;
            }

            @Override
            public List<Game> getAllGamesSortedByDate() {
                return null;
            }

            @Override
            public List<Game> getAllGames() {
                return null;
            }
        };
        // Initialize GameService with mock repository
        gameService = new GameService();
    }

    @Test
    public void testAddGame() {
        Game game = new Game(1, "Test Game", new Date(), 4.5, 29.99, "Test Description", new Date());
        gameService.addGame(game);
        Game foundGame = gameService.findGameByName("Test Game");
        assertNotNull(foundGame);
        assertEquals("Test Game", foundGame.getName());
    }

    @Test
    public void testDeleteGame() {
        Game game = new Game(2, "Test Game 2", new Date(), 4.2, 19.99, "Another Test Description", new Date());
        gameService.addGame(game);
        gameService.deleteGame(2);
        Game deletedGame = gameService.findGameByName("Test Game 2");
        assertEquals(null, deletedGame);
    }

    @Test
    public void testFilterGamesByPrice() {
        Game game1 = new Game(3, "Game 1", new Date(), 4.0, 14.99, "Description 1", new Date());
        Game game2 = new Game(4, "Game 2", new Date(), 4.5, 19.99, "Description 2", new Date());
        gameService.addGame(game1);
        gameService.addGame(game2);
        List<Game> filteredGames = gameService.filterGamesByPrice(15.0);
        assertEquals(1, filteredGames.size());
        assertEquals("Game 1", filteredGames.get(0).getName());
    }

    @Test
    public void testFilterGamesByType() {
        Game game1 = new Game(5, "Game 3", new Date(), 4.2, 24.99, "Adventure", new Date());
        Game game2 = new Game(6, "Game 4", new Date(), 4.8, 29.99, "Puzzle", new Date());
        gameService.addGame(game1);
        gameService.addGame(game2);
        List<Game> filteredGames = gameService.filterGamesByType("Adventure");
        assertEquals(1, filteredGames.size());
        assertEquals("Game 3", filteredGames.get(0).getName());
    }
}
