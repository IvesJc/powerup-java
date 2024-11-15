package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoDto(
        Integer id,
        Integer recompensaPontos,
        String status,
        Integer missaoConfig,
        Integer usuario
) {
}
