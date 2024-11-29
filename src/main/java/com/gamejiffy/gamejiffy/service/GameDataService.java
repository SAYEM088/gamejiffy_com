package com.gamejiffy.gamejiffy.service;

import com.gamejiffy.gamejiffy.model.GameData;
import com.gamejiffy.gamejiffy.repository.GameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameDataService {

    @Autowired
    private GameDataRepository repository;

    public void saveGameData(GameData gameData) {
        repository.save(gameData);
    }
}
