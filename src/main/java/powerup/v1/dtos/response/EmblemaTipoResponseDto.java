package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record EmblemaTipoResponseDto(
        String nome,
        Integer imageLink
) {
}
