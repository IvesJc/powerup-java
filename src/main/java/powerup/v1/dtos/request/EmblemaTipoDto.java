package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record EmblemaTipoDto(
        Integer id,
        String nome,
        Integer imageLink
) {
}
