package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RecompensaConfigRequestDto(
        Integer id,
        String nome,
        Integer custoPontos,
        Integer recompensaTipo
) {
}
