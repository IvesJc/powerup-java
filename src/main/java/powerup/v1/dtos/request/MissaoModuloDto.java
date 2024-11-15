package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoModuloDto(
        Integer missaoId,
        Integer moduloEducativoId
) {
}
