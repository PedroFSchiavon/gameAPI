package schi.manager.game.gameapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schi.manager.game.gameapi.dto.request.GamesDTO;
import schi.manager.game.gameapi.dto.response.MessageResponseDTO;
import schi.manager.game.gameapi.entity.Games;
import schi.manager.game.gameapi.repository.GamesRepository;

@Service
public class GameService {
    private GamesRepository gamesRepository;

    @Autowired
    public GameService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public MessageResponseDTO createGame(GamesDTO gamesDTO){

        Games gamesToSave = Games.builder()
                .name(gamesDTO.getName())
                .genre(gamesDTO.getGenre())
                .launchDate(gamesDTO.getLaunchDate())
                .distributor((gamesDTO.getDistributor()))
                .studios(gamesDTO.getStudios())
                .inventory(gamesDTO.getInventory())
                .build();

        Games savedGame = gamesRepository.save(gamesDTO);
        return MessageResponseDTO.builder().message("Game criado com sucesso! ID: " + savedGame.getId()).build();
    }
}
