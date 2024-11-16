package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record PerguntaRequestDto(
        Integer id,
        String titulo,
        String conteudo,
        Integer quiz
) {
}
