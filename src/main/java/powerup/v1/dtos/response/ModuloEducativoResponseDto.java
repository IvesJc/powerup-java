package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record ModuloEducativoResponseDto(
        String titulo,
        String subtitulo,
        String descricao,
        Integer nivel,
        Integer thumbLink
) {
}
