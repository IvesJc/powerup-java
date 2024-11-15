package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RecompensaConfigDto(
        Integer id,
        String nome,
        Integer custoPontos,
        Integer recompensaTipo
) {
}
