package com.gamejiffy.gamejiffy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GameData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String gameTitle;
    private String currentScore;
    private String playerDetails;

    public GameData() {
    }

    public GameData(String category, String gameTitle, String currentScore, String playerDetails) {
        this.category = category;
        this.gameTitle = gameTitle;
        this.currentScore = currentScore;
        this.playerDetails = playerDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(String currentScore) {
        this.currentScore = currentScore;
    }

    public String getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(String playerDetails) {
        this.playerDetails = playerDetails;
    }
}