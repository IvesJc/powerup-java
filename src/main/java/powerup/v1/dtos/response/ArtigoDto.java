package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record ArtigoDto(
        Integer id,
        String titulo,
        String subtitulo,
        String conteudo,
        Integer thumbLink,
        Integer moduloEducativo
) {
}
