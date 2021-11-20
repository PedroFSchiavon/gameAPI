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

    @Size(min = 2, max = 20)
    @NotEmpty
    private String genre;

    private String launchDate;

    private Distributor distributor;

    @Valid
    @NotEmpty
    private List<Studio> studios;

    private int inventory;
}
