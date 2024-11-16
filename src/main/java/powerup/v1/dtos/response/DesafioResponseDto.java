package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record DesafioResponseDto(
        Integer id,
        String nome,
        String descricao,
        Integer thumbLink,
        Integer quiz
) {
}
