package schi.manager.game.gameapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameNotFoundException extends Exception {
    public GameNotFoundException(Long id) {
        super("Game com o id " + id + " nao foi encontrado.");
    }
}
