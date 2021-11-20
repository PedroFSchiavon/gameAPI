package schi.manager.game.gameapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import schi.manager.game.gameapi.dto.request.GamesDTO;
import schi.manager.game.gameapi.entity.Games;

@Mapper
public interface GamesMapper {
    GamesMapper INSTANCE = Mappers.getMapper(GamesMapper.class);

    @Mapping(target = "launchDate", source = "launchDate", dateFormat = "dd-MM-yyyy")
    Games toModel(GamesDTO gamesDTO);

    GamesDTO toDTO(Games games);
}
