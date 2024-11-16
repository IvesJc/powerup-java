package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record MissaoConfigRequestDto(
        Integer id,
        String nome,
        String descricao,
        Integer pontos,
        Integer frequenciaDias
) { }