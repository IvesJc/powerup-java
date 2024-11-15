package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record PerguntaDto(
        Integer id,
        String titulo,
        String conteudo,
        QuizDto quiz
) {
}
