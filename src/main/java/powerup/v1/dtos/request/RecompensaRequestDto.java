package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RecompensaRequestDto(
        Integer id,
        Integer pontosUtilizados,
        Integer usuario,
        Integer recompensaConfig
) {
}
