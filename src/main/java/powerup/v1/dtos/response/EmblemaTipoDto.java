package powerup.v1.dtos.response;

import lombok.Builder;

@Builder
public record EmblemaTipoDto(
        Integer id,
        String nome,
        Integer imageLink
) {
}
