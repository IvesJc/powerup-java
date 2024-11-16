package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoArtigoRequestDto(
        Integer missaoId,
        Integer artigoId
) {
}
