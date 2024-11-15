package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record DesafioDto(
        Integer id,
        String nome,
        String descricao,
        Integer thumbLink,
        Integer quiz
) {
}
