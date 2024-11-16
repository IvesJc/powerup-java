package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record EmblemaTipoRequestDto(
        Integer id,
        String nome,
        Integer imageLink
) {
}
