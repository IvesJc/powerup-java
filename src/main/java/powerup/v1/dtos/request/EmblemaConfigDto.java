package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record EmblemaConfigDto(
        Integer id,
        String nome,
        String descricao,
        Integer emblemaTipo,
        Integer quiz
) {
}
