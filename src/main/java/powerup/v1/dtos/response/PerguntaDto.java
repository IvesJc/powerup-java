package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record PerguntaDto(
        Integer id,
        String titulo,
        String conteudo,
        Integer quiz
) {
}
