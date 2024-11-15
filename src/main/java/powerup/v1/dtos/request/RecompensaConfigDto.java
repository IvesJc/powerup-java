package powerup.v1.dtos.request;

public record RecompensaConfigDto(
        Integer id,
        String nome,
        Integer custoPontos,
        RecompensaTipoDto recompensaTipo
) {
}
