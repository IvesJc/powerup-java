package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RankingDto(
        Integer id,
        String nome
) { }
