package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record QuizDto(
        Integer id,
        String nome,
        String descricao,
        String categoria,
        Integer notaMinima,
        Integer moduloEducativo
) {
}
