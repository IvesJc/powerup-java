package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record EmblemaConfigRequestDto(
        Integer id,
        String nome,
        String descricao,
        Integer emblemaTipo,
        Integer quiz
) {
}
