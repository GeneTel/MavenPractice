package org.gene.service;


import lombok.Getter;
import org.gene.dao.GameRepository;
import org.gene.dao.GameRepositoryImplementation;

@Getter
public class GameSingleton {
    private static GameSingleton instance;
    private GameRepository gameRepository;

    private GameSingleton() {
        gameRepository = new GameRepositoryImplementation();
    }

    public static synchronized GameSingleton getInstance() {
        if (instance == null) {
            instance = new GameSingleton();
        }
        return instance;
    }

}
