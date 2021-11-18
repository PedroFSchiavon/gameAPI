package schi.manager.game.gameapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schi.manager.game.gameapi.dto.MessageResponseDTO;
import schi.manager.game.gameapi.entity.Games;
import schi.manager.game.gameapi.repository.GamesRepository;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private GamesRepository gamesRepository;


    @Autowired
    public GameController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }


    @PostMapping
    public MessageResponseDTO createGame(@RequestBody Games games){
        Games savedGame = gamesRepository.save(games);
        return MessageResponseDTO.builder().message("Game criado com sucesso! ID: " + savedGame.getId()).build();
    }
}
