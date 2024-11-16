package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record RecompensaConfigResponseDto(
        String nome,
        Integer custoPontos,
        Integer recompensaTipo
) {
}
