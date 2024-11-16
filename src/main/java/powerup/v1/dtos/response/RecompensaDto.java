package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record RecompensaDto(
        Integer id,
        Integer pontosUtilizados,
        Integer usuario,
        Integer recompensaConfig
) {
}
