package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RankingRequestDto(
        Integer id,
        String nome
) { }
