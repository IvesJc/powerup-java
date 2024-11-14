package powerup.v1.dtos;

import java.util.List;

public record ArtigoDto(
        String titulo,
        String subtitulo,
        String conteudo,
        Long thumbLinkId,
        List<Long> missaoIds
) {
}
