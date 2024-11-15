package powerup.v1.dtos.request;

public record DesafioDto(
        Integer id,
        String nome,
        String descricao,
        LinkDto thumbLink,
        QuizDto quiz
) {
}
