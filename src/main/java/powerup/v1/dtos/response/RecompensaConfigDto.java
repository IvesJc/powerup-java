package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record RecompensaConfigDto(
        Integer id,
        String nome,
        Integer custoPontos,
        Integer recompensaTipo
) {
}
