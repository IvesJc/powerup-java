package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record QuizRequestDto(
        Integer id,
        String nome,
        String descricao,
        String categoria,
        Integer notaMinima,
        Integer moduloEducativo
) {
}
