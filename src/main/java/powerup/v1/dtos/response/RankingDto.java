package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record RankingDto(
        Integer id,
        String nome
) { }
