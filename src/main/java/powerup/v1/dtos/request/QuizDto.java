package powerup.v1.dtos.request;

import lombok.Builder;
import lombok.Data;

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
