package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record LinkResponseDto(
        String url,
        String descricao
) {
}
