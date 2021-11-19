package schi.manager.game.gameapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import schi.manager.game.gameapi.entity.Studio;
import schi.manager.game.gameapi.enums.Platform;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistributorDTO {
    private long id;

    @NotEmpty
    private String name;

    private LocalDate foundation;

    private List<Studio> studios;

    private String greatHit;

    @Enumerated(EnumType.STRING)
    private Platform platform;
}
