package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record EmblemaDto(
        Integer id,
        UsuarioDto usuario,
        EmblemaConfigDto emblemaConfig
) {
}
