package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record ArtigoDto(
        Integer id,
        String titulo,
        String subtitulo,
        String conteudo,
        LinkDto thumbLink,
        ModuloEducativoDto moduloEducativo
) {
}
