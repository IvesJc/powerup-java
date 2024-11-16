package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record ModuloEducativoDto(
        Integer id,
        String titulo,
        String subtitulo,
        String descricao,
        Integer nivel,
        Integer thumbLink
) {
}
