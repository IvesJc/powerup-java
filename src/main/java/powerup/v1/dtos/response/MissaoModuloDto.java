package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record MissaoModuloDto(
        Integer missaoId,
        Integer moduloEducativoId
) {
}
