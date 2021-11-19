package schi.manager.game.gameapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import schi.manager.game.gameapi.entity.Distributor;
import schi.manager.game.gameapi.entity.Studio;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamesDTO {

    private long id;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String name;

    @NotEmpty
    private String genre;

    private String launchDate;

    @Valid
    @NotEmpty
    private Distributor distributor;

    @Valid
    @NotEmpty
    private List<Studio> studios;

    private int inventory;
}
