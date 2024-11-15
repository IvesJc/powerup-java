package powerup.v1.dtos.request;

public record ModuloEducativoDto(
        Integer id,
        String titulo,
        String subtitulo,
        String descricao,
        Integer nivel,
        LinkDto thumbLink
) {
}
