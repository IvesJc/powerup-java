package powerup.v1.dtos;

import java.util.List;

public record PerguntaDto(
        String titulo,
        String conteudo,
        List<Long> quizIds
) {
}
