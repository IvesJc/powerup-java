package powerup.v1.dtos.request;

public record RecompensaDto(
        Integer id,
        Integer pontosUtilizados,
        UsuarioDto usuario,
        RecompensaConfigDto recompensaConfig
) {
}
