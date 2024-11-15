package powerup.v1.dtos.request;

public record MissaoConfigDto(
        Integer id,
        String nome,
        String descricao,
        Integer pontos,
        Integer frequenciaDias
) { }