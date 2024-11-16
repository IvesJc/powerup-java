package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoModuloRequestDto(
        Integer missaoId,
        Integer moduloEducativoId
) {
}
