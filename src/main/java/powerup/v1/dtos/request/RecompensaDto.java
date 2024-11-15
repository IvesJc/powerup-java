package powerup.v1.dtos.request;

import lombok.Builder;

@Builder
public record RecompensaDto(
        Integer id,
        Integer pontosUtilizados,
        UsuarioDto usuario,
        RecompensaConfigDto recompensaConfig
) {
}
