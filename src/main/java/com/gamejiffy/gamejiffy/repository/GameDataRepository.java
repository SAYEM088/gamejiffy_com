package com.gamejiffy.gamejiffy.repository;

import com.gamejiffy.gamejiffy.model.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDataRepository extends JpaRepository<GameData, Long> {
}
