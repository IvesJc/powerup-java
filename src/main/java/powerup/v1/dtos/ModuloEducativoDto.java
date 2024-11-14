package powerup.v1.dtos;

import java.util.List;

public record ModuloEducativoDto(
        String titulo,
        String subtitulo,
        String descricao,
        Long thumbLinkId,
        int nivel,
        List<Long> artigoIds
) {
}
