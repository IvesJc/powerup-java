package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record LinkDto(
        Integer id,
        String url,
        String descricao
) {
}
