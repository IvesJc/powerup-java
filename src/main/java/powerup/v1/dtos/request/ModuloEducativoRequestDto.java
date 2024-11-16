package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record ModuloEducativoRequestDto(
        Integer id,
        String titulo,
        String subtitulo,
        String descricao,
        Integer nivel,
        Integer thumbLink
) {
}
