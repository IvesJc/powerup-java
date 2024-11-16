package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record ArtigoResponseDto(
        String titulo,
        String subtitulo,
        String conteudo,
        Integer thumbLink,
        Integer moduloEducativo
) {
}
