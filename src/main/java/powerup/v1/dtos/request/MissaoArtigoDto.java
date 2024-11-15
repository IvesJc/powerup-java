package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoArtigoDto(
        Integer missaoId,
        Integer artigoId
) {
}
