package schi.manager.game.gameapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schi.manager.game.gameapi.dto.request.GamesDTO;
import schi.manager.game.gameapi.dto.response.MessageResponseDTO;
import schi.manager.game.gameapi.entity.Games;
import schi.manager.game.gameapi.exception.GameNotFoundException;
import schi.manager.game.gameapi.mapper.GamesMapper;
import schi.manager.game.gameapi.repository.GamesRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GamesMapper gamesMapper = GamesMapper.INSTANCE;

    private GamesRepository gamesRepository;

    @Autowired
    public GameService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public MessageResponseDTO createGame(GamesDTO gamesDTO){

        Games gamesToSave = gamesMapper.toModel(gamesDTO);

        Games savedGame = gamesRepository.save(gamesToSave);
        return getMessageResponseDTO(savedGame, "Game criado com sucesso! ID: ");
    }

    public List<GamesDTO> listAll() {
        List<Games> allGames = gamesRepository.findAll();

        return allGames.stream().map(gamesMapper::toDTO).collect(Collectors.toList());
    }

    public GamesDTO findById(Long id) throws GameNotFoundException {
        verifyIfExist(id);
        return gamesMapper.toDTO(verifyIfExist(id).get());
    }

    public void deleteById(Long id) throws GameNotFoundException {
        verifyIfExist(id);

        gamesRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(long id, GamesDTO gamesDTO) throws GameNotFoundException {
        verifyIfExist(id);

        Games gameToUpdate = gamesMapper.toModel(gamesDTO);

        Games savedGame = gamesRepository.save(gameToUpdate);

        return getMessageResponseDTO(savedGame, "Game atualizado com sucesso! ID: ");
    }

    private Optional<Games> verifyIfExist(Long id) throws GameNotFoundException {
        Optional<Games> optionalGames = gamesRepository.findById(id);
        if(optionalGames.isEmpty()){
            throw new GameNotFoundException(id);
        }else{
            return optionalGames;
        }
    }

    private MessageResponseDTO getMessageResponseDTO(Games savedGame, String s) {
        return MessageResponseDTO.builder().message(s + savedGame.getId()).build();
    }
}
