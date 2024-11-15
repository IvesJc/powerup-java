package powerup.v1.dtos.request;

public record ArtigoDto(
        Integer id,
        String titulo,
        String subtitulo,
        String conteudo,
        LinkDto thumbLink,
        ModuloEducativoDto moduloEducativo
) {
}
