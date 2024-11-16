package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record EmblemaConfigResponseDto(
        String nome,
        String descricao,
        Integer emblemaTipo,
        Integer quiz
) {
}
