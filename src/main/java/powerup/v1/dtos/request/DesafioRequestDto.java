package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record DesafioRequestDto(
        Integer id,
        String nome,
        String descricao,
        Integer thumbLink,
        Integer quiz
) {
}
