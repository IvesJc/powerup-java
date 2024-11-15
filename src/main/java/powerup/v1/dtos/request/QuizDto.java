package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record QuizDto(
        Integer id,
        String nome,
        String descricao,
        String categoria,
        Integer notaMinima,
        ModuloEducativoDto moduloEducativo
) {
}
