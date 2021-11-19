package schi.manager.game.gameapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import schi.manager.game.gameapi.entity.Distributor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudioDTO {
    private long id;

    @NotEmpty
    private String name;

    private Distributor distributor;

    private LocalDate foundation;

    private String greatHit;
}
