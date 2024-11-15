package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoConfigDto(
        Integer id,
        String nome,
        String descricao,
        Integer pontos,
        Integer frequenciaDias
) { }