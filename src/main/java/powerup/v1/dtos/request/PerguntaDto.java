package powerup.v1.dtos.request;

public record PerguntaDto(
        Integer id,
        String titulo,
        String conteudo,
        QuizDto quiz
) {
}
