package powerup.v1.dtos.request;

public record QuizDto(
        Integer id,
        String nome,
        String descricao,
        String categoria,
        Integer notaMinima,
        ModuloEducativoDto moduloEducativo
) {
}
