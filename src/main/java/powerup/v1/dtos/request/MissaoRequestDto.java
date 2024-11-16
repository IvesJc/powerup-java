package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoRequestDto(
        Integer id,
        Integer recompensaPontos,
        String status,
        Integer missaoConfig,
        Integer usuario
) {
}
