package powerup.v1.dtos.request;

public record EmblemaConfigDto(
        Integer id,
        String nome,
        String descricao,
        EmblemaTipoDto emblemaTipo,
        QuizDto quiz
) {
}
