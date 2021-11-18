package schi.manager.game.gameapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Platform {
    SONY("Sony"),
    XBOX("Xbox"),
    NINTENDO("Nintendo"),
    MULTIPLATAFORM("Multiplataform");
    private final String plataform;
}
