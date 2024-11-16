package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record MissaoArtigoDto(
        Integer missaoId,
        Integer artigoId
) {
}
