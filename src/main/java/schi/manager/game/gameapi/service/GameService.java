package schi.manager.game.gameapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import schi.manager.game.gameapi.dto.MessageResponseDTO;
import schi.manager.game.gameapi.entity.Games;
import schi.manager.game.gameapi.repository.GamesRepository;

@Service
public class GameService {
    private GamesRepository gamesRepository;

    @Autowired
    public GameService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public MessageResponseDTO createGame(Games games){
        Games savedGame = gamesRepository.save(games);
        return MessageResponseDTO.builder().message("Game criado com sucesso! ID: " + savedGame.getId()).build();
    }
}
