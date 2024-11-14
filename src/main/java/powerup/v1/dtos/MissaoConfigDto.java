package powerup.v1.dtos;

public record MissaoConfigDto(
        String nome,
        String descricao,
        int pontos,
        int frequenciaDias
) { }