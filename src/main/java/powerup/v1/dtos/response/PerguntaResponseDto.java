package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record PerguntaResponseDto(
        String titulo,
        String conteudo,
        Integer quiz
) {
}
