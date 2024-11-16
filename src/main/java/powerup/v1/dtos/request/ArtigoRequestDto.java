package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record ArtigoRequestDto(
        Integer id,
        String titulo,
        String subtitulo,
        String conteudo,
        Integer thumbLink,
        Integer moduloEducativo
) {
}
