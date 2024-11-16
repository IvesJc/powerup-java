package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record LinkRequestDto(
        Integer id,
        String url,
        String descricao
) {
}
