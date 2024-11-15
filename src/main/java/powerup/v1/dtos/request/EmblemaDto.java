package powerup.v1.dtos.request;

public record EmblemaDto(
        Integer id,
        UsuarioDto usuario,
        EmblemaConfigDto emblemaConfig
) {
}
