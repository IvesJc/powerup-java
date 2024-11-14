package powerup.v1.dtos;

public record QuizDto(
        String nome,
        String descricao,
        String categoria,
        Long emblemaConfigId,
        int notaMinima,
        Long moduloEducativoId
) {
}
