package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record RecompensaResponseDto(
        Integer pontosUtilizados,
        Integer usuario,
        Integer recompensaConfig
) {
}
