package com.gamejiffy.gamejiffy.service;
import com.gamejiffy.gamejiffy.model.GameData;
import com.gamejiffy.gamejiffy.repository.GameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;  
import java.util.Optional;
@Service
public class GameDataService {
    @Autowired
    private GameDataRepository repository;

    public void saveGameData(GameData gameData) {
        repository.save(gameData);
    }

    public List<GameData> getAllGameData() {
        return repository.findAll(); 
    }
    public boolean updateScore(Long gameId, String newScore) {
        Optional<GameData> optionalGameData = repository.findById(gameId);

        if (optionalGameData.isPresent()) {
            GameData gameData = optionalGameData.get();
            gameData.setCurrentScore(newScore);
            repository.save(gameData);
            return true;
        }
        return false;
    }
}
