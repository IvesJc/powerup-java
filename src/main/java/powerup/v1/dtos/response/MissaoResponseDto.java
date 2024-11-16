package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record MissaoResponseDto(
        Integer recompensaPontos,
        String status,
        Integer missaoConfig,
        Integer usuario
) {
}
