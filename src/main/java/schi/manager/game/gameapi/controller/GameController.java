package schi.manager.game.gameapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import schi.manager.game.gameapi.dto.MessageResponseDTO;
import schi.manager.game.gameapi.entity.Games;
import schi.manager.game.gameapi.service.GameService;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createGame(@RequestBody Games games){
        return gameService.createGame(games);
    }
}
