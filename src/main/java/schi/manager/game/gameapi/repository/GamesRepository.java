package schi.manager.game.gameapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schi.manager.game.gameapi.entity.Games;

public interface GamesRepository extends JpaRepository<Games, Long> {

}
